// @use(carrito)
// @kind(serviceImpl)
// @contract(in: CarritoRequestDTO, CarritoItemRequestDTO -> out: CarritoResponseDTO)
// @limit(lines: 400)
package cl.triskeledu.carrito.service.impl;

import cl.triskeledu.carrito.dto.request.CarritoItemRequestDTO;
import cl.triskeledu.carrito.dto.request.CarritoRequestDTO;
import cl.triskeledu.carrito.dto.response.CarritoResponseDTO;
import cl.triskeledu.carrito.entity.Carrito;
import cl.triskeledu.carrito.entity.CarritoItem;
import cl.triskeledu.carrito.exception.CarritoNotFoundException;
import cl.triskeledu.carrito.exception.ItemNotFoundException;
import cl.triskeledu.carrito.mapper.CarritoMapper;
import cl.triskeledu.carrito.proyecciones.MenuItemProyeccion;
import cl.triskeledu.carrito.repository.CarritoRepository;
import cl.triskeledu.carrito.repository.MenuItemProyeccionRepository;
import cl.triskeledu.carrito.service.CarritoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * <h1>Servicio de carrito de compras</h1>
 * <p>
 * Implementa {@link CarritoService} y gestiona el ciclo de vida completo del
 * carrito: creación, adición de ítems, actualización de cantidades, eliminación
 * de ítems y vaciado. Es el núcleo de ms-carrito.
 * </p>
 *
 * <h2>Patrón CQRS — Proyección local en lugar de Feign</h2>
 * <p>
 * Para obtener el precio de un {@code menuItemId} este servicio <b>no</b> realiza
 * una llamada síncrona a ms-menu vía Feign. En su lugar consulta
 * {@link MenuItemProyeccionRepository}, una proyección JPA local que se mantiene
 * actualizada mediante la ingesta de eventos Kafka provenientes de ms-menu.
 * </p>
 * <p>
 * Esta es la implementación concreta del patrón <b>CQRS</b> en el proyecto: el
 * {@code MenuItemProyeccion} es una vista materializada local optimizada para
 * consultas de lectura, mientras que la fuente de verdad (ms-menu) escribe los
 * cambios y los propaga asíncronamente.
 * </p>
 *
 * <h2>Detalle de operaciones</h2>
 * <ul>
 *   <li><b>crearCarrito</b> — crea un carrito vacío ({@code total = 0})
 *       asociado a un usuario y sucursal. Solo se permite un carrito activo
 *       por usuario.</li>
 *   <li><b>agregarItem</b> — añade un ítem al carrito; si ya existe el mismo
 *       menú, incrementa la cantidad y recalcula el subtotal.</li>
 *   <li><b>actualizarCantidadItem</b> — modifica la cantidad de un ítem
 *       existente y recalcula su subtotal.</li>
 *   <li><b>removerItem</b> — elimina un ítem del carrito.</li>
 *   <li><b>vaciarCarrito</b> — limpia todos los ítems y pone el total a cero.</li>
 * </ul>
 *
 * <h2>Métodos auxiliares privados</h2>
 * <ul>
 *   <li>{@link #obtenerPrecioItem(Long)} — consulta la proyección local
 *       para resolver el precio sin depender de Feign.</li>
 *   <li>{@link #recalcularTotal(Carrito)} — suma los subtotales de todos
 *       los ítems y actualiza el campo {@code total} del carrito.</li>
 * </ul>
 *
 * @see CarritoService
 * @see MenuItemProyeccionRepository
 * @see MenuItemProyeccion
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CarritoServiceImpl implements CarritoService {

    private final CarritoRepository carritoRepository;
    private final MenuItemProyeccionRepository menuItemProyeccionRepository;
    private final CarritoMapper carritoMapper;

    /**
     * Obtiene el carrito activo de un usuario.
     *
     * @param usuarioId ID del usuario dueño del carrito
     * @return DTO con los datos del carrito y sus ítems
     * @throws CarritoNotFoundException si el usuario no tiene carrito activo
     */
    @Override
    public CarritoResponseDTO obtenerCarrito(Long usuarioId) {
        log.info("Obteniendo carrito para usuario {}", usuarioId);
        Carrito carrito = carritoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new CarritoNotFoundException("Carrito no encontrado para usuario: " + usuarioId));
        return carritoMapper.toResponseDTO(carrito);
    }

    /**
     * Crea un carrito nuevo para un usuario en una sucursal determinada.
     * El total inicial es {@code BigDecimal.ZERO}.
     * Solo se permite un carrito activo por usuario: si ya existe, lanza
     * {@link CarritoNotFoundException}.
     *
     * @param dto contiene usuarioId y sucursalId
     * @return DTO con el carrito recién creado
     */
    @Override
    @Transactional
    public CarritoResponseDTO crearCarrito(CarritoRequestDTO dto) {
        log.info("Creando carrito para usuario {} en sucursal {}", dto.getUsuarioId(), dto.getSucursalId());
        carritoRepository.findByUsuarioId(dto.getUsuarioId()).ifPresent(existing -> {
            throw new CarritoNotFoundException("El usuario ya tiene un carrito activo. Use agregar item en su lugar.");
        });
        Carrito carrito = Carrito.builder()
                .usuarioId(dto.getUsuarioId())
                .sucursalId(dto.getSucursalId())
                .total(BigDecimal.ZERO)
                .build();
        Carrito saved = carritoRepository.save(carrito);
        log.info("Carrito creado con ID: {}", saved.getId());
        return carritoMapper.toResponseDTO(saved);
    }

    /**
     * Agrega un ítem al carrito del usuario. Si el mismo {@code menuItemId} ya
     * existe en el carrito, incrementa la cantidad en lugar de duplicar el ítem.
     * <p>
     * El precio unitario se obtiene de {@link MenuItemProyeccionRepository}
     * (proyección CQRS local), no mediante una llamada Feign a ms-menu.
     * Al finalizar se invoca {@link #recalcularTotal(Carrito)} para actualizar
     * el total del carrito.
     * </p>
     *
     * @param usuarioId ID del usuario dueño del carrito
     * @param dto       contiene menuItemId y cantidad a agregar
     * @return DTO del carrito actualizado
     * @throws CarritoNotFoundException si el usuario no tiene carrito
     * @throws ItemNotFoundException    si el menuItemId no existe en la proyección local
     */
    @Override
    @Transactional
    public CarritoResponseDTO agregarItem(Long usuarioId, CarritoItemRequestDTO dto) {
        log.info("Agregando item {} al carrito del usuario {} con cantidad {}", dto.getMenuItemId(), usuarioId, dto.getCantidad());
        Carrito carrito = carritoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new CarritoNotFoundException("Carrito no encontrado para usuario: " + usuarioId));

        BigDecimal precioUnitario = obtenerPrecioItem(dto.getMenuItemId());

        var existingItem = carrito.getItems().stream()
                .filter(item -> item.getMenuItemId().equals(dto.getMenuItemId()))
                .findFirst();

        if (existingItem.isPresent()) {
            CarritoItem item = existingItem.get();
            int nuevaCantidad = item.getCantidad() + dto.getCantidad();
            item.setCantidad(nuevaCantidad);
            item.setSubtotal(precioUnitario.multiply(BigDecimal.valueOf(nuevaCantidad)));
        } else {
            CarritoItem newItem = CarritoItem.builder()
                    .carrito(carrito)
                    .menuItemId(dto.getMenuItemId())
                    .precioUnitario(precioUnitario)
                    .cantidad(dto.getCantidad())
                    .subtotal(precioUnitario.multiply(BigDecimal.valueOf(dto.getCantidad())))
                    .build();
            carrito.addItem(newItem);
        }

        recalcularTotal(carrito);
        Carrito saved = carritoRepository.save(carrito);
        log.info("Item agregado al carrito {}. Total: {}", saved.getId(), saved.getTotal());
        return carritoMapper.toResponseDTO(saved);
    }

    /**
     * Actualiza la cantidad de un ítem específico dentro del carrito y
     * recalcula su subtotal ({@code precioUnitario * nuevaCantidad}).
     * Invoca {@link #recalcularTotal(Carrito)} para refrescar el total general.
     *
     * @param usuarioId     ID del usuario dueño del carrito
     * @param itemId        ID del ítem a modificar
     * @param nuevaCantidad nueva cantidad (reemplaza la anterior)
     * @return DTO del carrito actualizado
     * @throws CarritoNotFoundException si el usuario no tiene carrito
     * @throws ItemNotFoundException    si el itemId no pertenece al carrito
     */
    @Override
    @Transactional
    public CarritoResponseDTO actualizarCantidadItem(Long usuarioId, Long itemId, Integer nuevaCantidad) {
        log.info("Actualizando cantidad del item {} a {} para usuario {}", itemId, nuevaCantidad, usuarioId);
        Carrito carrito = carritoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new CarritoNotFoundException("Carrito no encontrado para usuario: " + usuarioId));

        CarritoItem item = carrito.getItems().stream()
                .filter(i -> i.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item no encontrado en el carrito: " + itemId));

        item.setCantidad(nuevaCantidad);
        item.setSubtotal(item.getPrecioUnitario().multiply(BigDecimal.valueOf(nuevaCantidad)));

        recalcularTotal(carrito);
        Carrito saved = carritoRepository.save(carrito);
        log.info("Cantidad del item {} actualizada a {} en carrito {}", itemId, nuevaCantidad, saved.getId());
        return carritoMapper.toResponseDTO(saved);
    }

    /**
     * Remueve un ítem del carrito por su ID y recalcula el total.
     *
     * @param usuarioId ID del usuario dueño del carrito
     * @param itemId    ID del ítem a remover
     * @return DTO del carrito actualizado
     * @throws CarritoNotFoundException si el usuario no tiene carrito
     * @throws ItemNotFoundException    si el itemId no pertenece al carrito
     */
    @Override
    @Transactional
    public CarritoResponseDTO removerItem(Long usuarioId, Long itemId) {
        log.info("Removiendo item {} del carrito del usuario {}", itemId, usuarioId);
        Carrito carrito = carritoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new CarritoNotFoundException("Carrito no encontrado para usuario: " + usuarioId));

        CarritoItem item = carrito.getItems().stream()
                .filter(i -> i.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item no encontrado en el carrito: " + itemId));

        carrito.removeItem(item);
        recalcularTotal(carrito);
        Carrito saved = carritoRepository.save(carrito);
        log.info("Item {} removido del carrito {}. Total: {}", itemId, saved.getId(), saved.getTotal());
        return carritoMapper.toResponseDTO(saved);
    }

    /**
     * Vacia todos los ítems del carrito y restablece el total a {@code BigDecimal.ZERO}.
     * No elimina el carrito, solo lo limpia para su reutilización.
     *
     * @param usuarioId ID del usuario dueño del carrito
     * @throws CarritoNotFoundException si el usuario no tiene carrito
     */
    @Override
    @Transactional
    public void vaciarCarrito(Long usuarioId) {
        log.info("Vaciando carrito del usuario {}", usuarioId);
        Carrito carrito = carritoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new CarritoNotFoundException("Carrito no encontrado para usuario: " + usuarioId));
        carrito.getItems().clear();
        carrito.setTotal(BigDecimal.ZERO);
        carritoRepository.save(carrito);
        log.info("Carrito del usuario {} vaciado correctamente", usuarioId);
    }

    /**
     * Resuelve el precio de un ítem del menú consultando la proyección CQRS local
     * {@link MenuItemProyeccionRepository} en lugar de realizar una llamada Feign
     * a ms-menu. Esta es la materialización del patrón CQRS: los precios se mantienen
     * sincronizados vía eventos Kafka consumidos desde {@code menu-events}.
     *
     * @param menuItemId ID del ítem de menú
     * @return precio unitario como {@link BigDecimal}
     * @throws ItemNotFoundException si el ID no existe en la proyección local
     */
    private BigDecimal obtenerPrecioItem(Long menuItemId) {
        return menuItemProyeccionRepository.findById(menuItemId)
                .map(MenuItemProyeccion::getPrecio)
                .map(precio -> BigDecimal.valueOf(precio))
                .orElseThrow(() -> new ItemNotFoundException("Menu item no encontrado: " + menuItemId));
    }

    /**
     * Recalcula el total del carrito sumando los subtotales de todos los ítems
     * mediante {@link BigDecimal#add}. El resultado se asigna directamente al
     * campo {@code total} de la entidad {@link Carrito}.
     *
     * @param carrito entidad cuyo total se va a recalcular
     */
    private void recalcularTotal(Carrito carrito) {
        BigDecimal total = carrito.getItems().stream()
                .map(CarritoItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        carrito.setTotal(total);
    }
}