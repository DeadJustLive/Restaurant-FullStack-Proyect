package cl.triskeledu.pedidos.service.impl;

import cl.triskeledu.pedidos.client.MenuItemClient;
import cl.triskeledu.pedidos.client.dto.MenuItemClientResponseDTO;
import cl.triskeledu.pedidos.dto.event.PedidoEventDTO;
import cl.triskeledu.pedidos.dto.request.PedidoRequestDTO;
import cl.triskeledu.pedidos.dto.response.PedidoResponseDTO;
import cl.triskeledu.pedidos.entity.Pedido;
import cl.triskeledu.pedidos.entity.PedidoItem;
import cl.triskeledu.pedidos.entity.enums.EstadoPedido;
import cl.triskeledu.pedidos.entity.enums.TipoPedido;
import cl.triskeledu.pedidos.exception.EstadoInvalidoException;
import cl.triskeledu.pedidos.exception.PedidoNotFoundException;
import cl.triskeledu.pedidos.mapper.PedidoMapper;
import cl.triskeledu.pedidos.proyecciones.MenuItemProyeccion;
import cl.triskeledu.pedidos.repository.MenuItemProyeccionRepository;
import cl.triskeledu.pedidos.repository.PedidoRepository;
import cl.triskeledu.pedidos.service.PedidoService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * =============================================================================
 * SERVICE IMPL: PedidoServiceImpl
 * =============================================================================
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PedidoServiceImpl implements PedidoService {

    private static final Map<EstadoPedido, Set<EstadoPedido>> TRANSICIONES_VALIDAS;

    static {
        TRANSICIONES_VALIDAS = new EnumMap<>(EstadoPedido.class);
        TRANSICIONES_VALIDAS.put(EstadoPedido.PENDIENTE, EnumSet.of(EstadoPedido.CONFIRMADO, EstadoPedido.CANCELADO));
        TRANSICIONES_VALIDAS.put(EstadoPedido.CONFIRMADO, EnumSet.of(EstadoPedido.EN_PREPARACION, EstadoPedido.CANCELADO));
        TRANSICIONES_VALIDAS.put(EstadoPedido.EN_PREPARACION, EnumSet.of(EstadoPedido.LISTO));
        TRANSICIONES_VALIDAS.put(EstadoPedido.EN_CAMINO, EnumSet.of(EstadoPedido.ENTREGADO));
    }

    private final MenuItemClient menuItemClient;
    private final MenuItemProyeccionRepository menuItemProyeccionRepository;
    private final PedidoMapper pedidoMapper;

    private static final String TOPIC = "pedido-events";

    private final KafkaTemplate<String, PedidoEventDTO> kafkaTemplate;
    private final PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public PedidoResponseDTO crear(PedidoRequestDTO dto) {
        /*
         * INTENCIÓN: Orquestar la creación de un pedido.
         *
         * FLUJO IMPLEMENTADO:
         *   1. Validar usuario (ms-usuarios) - TODO: Feign
         *   2. Validar sucursal (ms-sucursales) - TODO: Feign
         *   3. Por cada ítem: Validar precio y existencia (ms-menu) - TODO: Simulado
         *   4. Guardar pedido e ítems.
         *   5. Vaciar carrito (ms-carrito) - TODO: Feign
         *   6. Notificar creación (ms-notificaciones) - TODO: Feign o Kafka
         */
        log.info("Creando pedido para usuario {} en sucursal {}", dto.getUsuarioId(), dto.getSucursalId());
        
        Pedido pedido = Pedido.builder()
                .numeroPedido("PED-" + System.currentTimeMillis())
                .usuarioId(dto.getUsuarioId())
                .sucursalId(dto.getSucursalId())
                .estado(EstadoPedido.PENDIENTE) // Asignar estado inicial
                .tipo(dto.getTipo())
                .notas(dto.getNotas())
                .build();
                
        List<PedidoItem> items = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        
        for (var itemDto : dto.getItems()) {
            String nombreSnapshot;
            BigDecimal precioUnitario;

            try {
                MenuItemClientResponseDTO menuResponse = menuItemClient.getById(itemDto.getMenuItemId());
                nombreSnapshot = menuResponse.getNombre();
                precioUnitario = menuResponse.getPrecio();
                log.debug("Feign: menuItemId={} -> nombre={}, precio={}", itemDto.getMenuItemId(), nombreSnapshot, precioUnitario);
            } catch (FeignException fe) {
                log.warn("Feign falló para menuItemId={}, usando proyección local: {}", itemDto.getMenuItemId(), fe.getMessage());
                MenuItemProyeccion proyeccion = menuItemProyeccionRepository.findById(itemDto.getMenuItemId())
                        .orElseThrow(() -> new PedidoNotFoundException("MenuItem no encontrado (Feign y proyección fallaron) para ID: " + itemDto.getMenuItemId()));
                nombreSnapshot = proyeccion.getNombre();
                precioUnitario = BigDecimal.valueOf(proyeccion.getPrecio());
            } catch (Exception ex) {
                log.warn("Error inesperado consultando menuItemId={}, usando proyección local: {}", itemDto.getMenuItemId(), ex.getMessage());
                MenuItemProyeccion proyeccion = menuItemProyeccionRepository.findById(itemDto.getMenuItemId())
                        .orElseThrow(() -> new PedidoNotFoundException("MenuItem no encontrado (Feign y proyección fallaron) para ID: " + itemDto.getMenuItemId()));
                nombreSnapshot = proyeccion.getNombre();
                precioUnitario = BigDecimal.valueOf(proyeccion.getPrecio());
            }

            BigDecimal subtotal = precioUnitario.multiply(new BigDecimal(itemDto.getCantidad()));
            total = total.add(subtotal);
            
            PedidoItem item = PedidoItem.builder()
                    .pedido(pedido)
                    .menuItemId(itemDto.getMenuItemId())
                    .nombreSnapshot(nombreSnapshot)
                    .precioUnitario(precioUnitario)
                    .cantidad(itemDto.getCantidad())
                    .subtotal(subtotal)
                    .build();
                    
            items.add(item);
        }
        
        pedido.setItems(items);
        pedido.setTotal(total);
        
        Pedido saved = pedidoRepository.save(pedido);

        PedidoEventDTO event = new PedidoEventDTO(
                saved.getId(),
                saved.getUsuarioId(),
                saved.getTotal().doubleValue(),
                saved.getEstado().name(),
                null
        );
        kafkaTemplate.send(TOPIC, String.valueOf(saved.getId()), event);
        log.info("Kafka event sent to {}: pedido creado id={}", TOPIC, saved.getId());

        return pedidoMapper.toResponseDTO(saved);
    }

    @Override
    public PedidoResponseDTO obtenerPorId(Long id) {
        log.info("Consultando pedido ID {}", id);
        Pedido pedido = pedidoRepository.findByIdWithItems(id)
                .orElseThrow(() -> new PedidoNotFoundException("Pedido no encontrado con ID: " + id));
        return pedidoMapper.toResponseDTO(pedido);
    }

    @Override
    public List<PedidoResponseDTO> obtenerColaSucursal(Long sucursalId) {
        log.info("Listando pedidos activos para sucursal {}", sucursalId);
        List<EstadoPedido> estadosFinales = List.of(EstadoPedido.ENTREGADO, EstadoPedido.CANCELADO);
        return pedidoRepository.findBySucursalIdAndEstadoNotIn(sucursalId, estadosFinales).stream()
                .map(pedidoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoResponseDTO> obtenerPorUsuario(Long usuarioId) {
        log.info("Listando pedidos para usuario {}", usuarioId);
        return pedidoRepository.findByUsuarioIdOrderByCreadoEnDesc(usuarioId).stream()
                .map(pedidoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PedidoResponseDTO cambiarEstado(Long id, EstadoPedido nuevoEstado) {
        log.info("Cambiando estado de pedido {} a {}", id, nuevoEstado);
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException("Pedido no encontrado con ID: " + id));

        EstadoPedido estadoActual = pedido.getEstado();
        Set<EstadoPedido> estadosPermitidos;

        if (estadoActual == EstadoPedido.LISTO) {
            estadosPermitidos = pedido.getTipo() == TipoPedido.DELIVERY
                    ? EnumSet.of(EstadoPedido.EN_CAMINO)
                    : EnumSet.of(EstadoPedido.ENTREGADO);
        } else {
            estadosPermitidos = TRANSICIONES_VALIDAS.getOrDefault(estadoActual, EnumSet.noneOf(EstadoPedido.class));
        }

        if (!estadosPermitidos.contains(nuevoEstado)) {
            throw new EstadoInvalidoException("No se puede cambiar de " + estadoActual + " a " + nuevoEstado);
        }

        pedido.setEstado(nuevoEstado);
        
        // TODO: Agregar lógica si el estado es LISTO o CANCELADO notificar.
        
        Pedido updated = pedidoRepository.save(pedido);

        PedidoEventDTO event = new PedidoEventDTO(
                updated.getId(),
                updated.getUsuarioId(),
                updated.getTotal().doubleValue(),
                updated.getEstado().name(),
                null
        );
        kafkaTemplate.send(TOPIC, String.valueOf(updated.getId()), event);
        log.info("Kafka event sent to {}: pedido estado cambiado id={} estado={}", TOPIC, updated.getId(), updated.getEstado());

        return pedidoMapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public PedidoResponseDTO cancelar(Long id) {
        log.info("Cancelando pedido {}", id);
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException("Pedido no encontrado con ID: " + id));
                
        if (pedido.getEstado() != EstadoPedido.PENDIENTE && pedido.getEstado() != EstadoPedido.CONFIRMADO) {
            throw new EstadoInvalidoException("El pedido no puede ser cancelado en este estado");
        }
        
        pedido.setEstado(EstadoPedido.CANCELADO);
        Pedido updated = pedidoRepository.save(pedido);

        PedidoEventDTO event = new PedidoEventDTO(
                updated.getId(),
                updated.getUsuarioId(),
                updated.getTotal().doubleValue(),
                updated.getEstado().name(),
                null
        );
        kafkaTemplate.send(TOPIC, String.valueOf(updated.getId()), event);
        log.info("Kafka event sent to {}: pedido cancelado id={}", TOPIC, updated.getId());

        return pedidoMapper.toResponseDTO(updated);
    }

    @Override
    public List<PedidoResponseDTO> listarTodos() {
        log.info("Listando todos los pedidos");
        return pedidoRepository.findAll().stream()
                .map(pedidoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
