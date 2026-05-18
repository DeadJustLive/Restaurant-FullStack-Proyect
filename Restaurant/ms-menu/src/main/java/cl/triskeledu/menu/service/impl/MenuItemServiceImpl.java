package cl.triskeledu.menu.service.impl;

import cl.triskeledu.menu.dto.event.MenuItemEventDTO;
import cl.triskeledu.menu.dto.request.MenuItemRequestDTO;
import cl.triskeledu.menu.dto.response.MenuItemResponseDTO;
import cl.triskeledu.menu.entity.MenuItem;
import cl.triskeledu.menu.exception.AccesoDenegadoException;
import cl.triskeledu.menu.exception.ItemNoDisponibleException;
import cl.triskeledu.menu.exception.MenuItemNotFoundException;
import cl.triskeledu.menu.repository.MenuItemRepository;
import cl.triskeledu.menu.service.MenuItemService;
import cl.triskeledu.menu.client.AuthFeignClient;
import cl.triskeledu.menu.dto.response.PermisoResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * =============================================================================
 * SERVICE IMPL: MenuItemServiceImpl
 * =============================================================================
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MenuItemServiceImpl implements MenuItemService {

    private static final String MENU_ITEM_EVENTS_TOPIC = "menu-item-events";

    private final MenuItemRepository menuItemRepository;
    private final cl.triskeledu.menu.mapper.MenuItemMapper menuItemMapper;
    private final KafkaTemplate<String, MenuItemEventDTO> kafkaTemplate;
    private final AuthFeignClient authFeignClient;

    @Override
    @Transactional
    public MenuItemResponseDTO crear(Long credencialId, MenuItemRequestDTO dto) {
        /*
         * INTENCIÓN: Registrar un nuevo plato o producto en el catálogo.
         *
         * FLUJO ESPERADO:
         *   Input: MenuItemRequestDTO
         *   Process:
         *     1. Validar categoría (Llamada Feign a ms-categorias). TODO: Implementar Feign.
         *     2. Si sucursalId != null -> Validar sucursal (Llamada Feign a ms-sucursales). TODO: Implementar Feign.
         *     3. Guardar entidad.
         *   Output: MenuItemResponseDTO
         */
        log.info("Creando nuevo MenuItem: {}", dto.getNombre());
        
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "MENU", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para modificar el menú.");
        }

        if (menuItemRepository.existsByNombreIgnoreCaseAndCategoriaId(dto.getNombre(), dto.getCategoriaId())) {
            throw new cl.triskeledu.menu.exception.ItemDuplicadoException("Ya existe un ítem con el nombre " + dto.getNombre() + " en esta categoría.");
        }
        
        MenuItem item = menuItemMapper.toEntity(dto);
        item.setDisponible(dto.getDisponible() != null ? dto.getDisponible() : true);
        item.setEliminado(false);
                
        MenuItem saved = menuItemRepository.save(item);
        sendMenuItemEvent(saved);
        return menuItemMapper.toResponseDTO(saved);
    }

    @Override
    public MenuItemResponseDTO getById(Long id) {
        /*
         * INTENCIÓN: Consultar ítem por ID.
         */
        log.info("Consultando MenuItem con ID: {}", id);
        MenuItem item = menuItemRepository.findByIdAndDisponibleTrueAndEliminadoFalse(id)
                .orElseThrow(() -> new MenuItemNotFoundException("Item no encontrado o no disponible con ID: " + id));
        return menuItemMapper.toResponseDTO(item);
    }

    @Override
    public List<MenuItemResponseDTO> listarDisponibles() {
        log.info("Listando todos los MenuItem disponibles");
        List<MenuItem> items = menuItemRepository.findByDisponibleTrueAndEliminadoFalseOrderByNombreAsc();
        return items.stream().map(menuItemMapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public List<MenuItemResponseDTO> listarPorCategoria(Long categoriaId) {
        log.info("Listando MenuItem disponibles por categoriaId={}", categoriaId);
        List<MenuItem> items = menuItemRepository.findByCategoriaIdAndDisponibleTrueAndEliminadoFalseOrderByNombreAsc(categoriaId);
        return items.stream().map(menuItemMapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public List<MenuItemResponseDTO> listarPorSucursal(Long sucursalId) {
        log.info("Listando MenuItem disponibles por sucursalId={}", sucursalId);
        List<MenuItem> items = menuItemRepository.findDisponiblesBySucursal(sucursalId);
        return items.stream().map(menuItemMapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MenuItemResponseDTO actualizar(Long credencialId, Long id, MenuItemRequestDTO dto) {
        log.info("Actualizando completamente MenuItem con ID: {}", id);
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "MENU", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para modificar el menú.");
        }

        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow(() -> new MenuItemNotFoundException("Item no encontrado con ID: " + id));
                
        if (item.getEliminado()) {
            throw new ItemNoDisponibleException("No se puede actualizar un ítem eliminado");
        }
        
        if (!item.getNombre().equalsIgnoreCase(dto.getNombre()) && 
            menuItemRepository.existsByNombreIgnoreCaseAndCategoriaId(dto.getNombre(), dto.getCategoriaId())) {
            throw new cl.triskeledu.menu.exception.ItemDuplicadoException("Ya existe un ítem con el nombre " + dto.getNombre() + " en esta categoría.");
        }

        menuItemMapper.updateEntityFromDto(dto, item);

        MenuItem updated = menuItemRepository.save(item);
        sendMenuItemEvent(updated);
        return menuItemMapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public MenuItemResponseDTO cambiarDisponibilidad(Long credencialId, Long id, Boolean disponible) {
        log.info("Cambiando disponibilidad de MenuItem ID: {} a {}", id, disponible);
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "MENU", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para modificar el menú.");
        }

        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow(() -> new MenuItemNotFoundException("Item no encontrado con ID: " + id));
        item.setDisponible(disponible);
        MenuItem updated = menuItemRepository.save(item);
        sendMenuItemEvent(updated);
        return menuItemMapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void eliminar(Long credencialId, Long id) {
        /*
         * INTENCIÓN: Borrar ítem. Solo permitido si no está en ms-pedidos.
         * APLICACIÓN REAL: Implementado como Soft Delete para mantener trazabilidad.
         */
        log.info("Eliminando lógicamente (soft delete) MenuItem con ID: {}", id);
        PermisoResponseDTO permiso = validarAccesoConFallback(credencialId, "MENU", "ESCRITURA");
        if (!permiso.isPermitido()) {
            throw new AccesoDenegadoException("No tienes permisos para modificar el menú.");
        }

        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow(() -> new MenuItemNotFoundException("Item no encontrado con ID: " + id));
        item.setEliminado(true);
        item.setDisponible(false);
        menuItemRepository.save(item);
        sendMenuItemEvent(item);
    }

    private void sendMenuItemEvent(MenuItem item) {
        MenuItemEventDTO event = new MenuItemEventDTO(
                item.getId(),
                item.getNombre(),
                item.getPrecio() != null ? item.getPrecio().doubleValue() : null,
                Boolean.TRUE.equals(item.getDisponible())
        );
        kafkaTemplate.send(MENU_ITEM_EVENTS_TOPIC, String.valueOf(item.getId()), event);
        log.info("Evento enviado a topic '{}' para MenuItem ID: {}", MENU_ITEM_EVENTS_TOPIC, item.getId());
    }

    private PermisoResponseDTO validarAccesoConFallback(Long credencialId, String modulo, String accion) {
        try {
            ResponseEntity<PermisoResponseDTO> response = authFeignClient.validarAcceso(credencialId, modulo, accion);
            PermisoResponseDTO permiso = response.getBody();
            if (permiso != null) {
                return permiso;
            }
        } catch (Exception e) {
            log.warn("{} - No se pudo validar acceso con ms-auth: {}. Operacion en modo degradado.",
                     getClass().getSimpleName(), e.getMessage());
        }
        return PermisoResponseDTO.builder()
                .permitido(true)
                .mensaje("Validacion no disponible - modo degradado")
                .build();
    }
}
