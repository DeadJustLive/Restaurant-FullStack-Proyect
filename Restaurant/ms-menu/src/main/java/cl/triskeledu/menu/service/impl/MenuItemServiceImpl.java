package cl.triskeledu.menu.service.impl;

import cl.triskeledu.menu.dto.request.MenuItemRequestDTO;
import cl.triskeledu.menu.dto.response.MenuItemResponseDTO;
import cl.triskeledu.menu.entity.MenuItem;
import cl.triskeledu.menu.exception.MenuItemNotFoundException;
import cl.triskeledu.menu.repository.MenuItemRepository;
import cl.triskeledu.menu.service.MenuItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    @Transactional
    public MenuItemResponseDTO crear(MenuItemRequestDTO dto) {
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
        
        MenuItem item = MenuItem.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .precio(dto.getPrecio())
                .imagenUrl(dto.getImagenUrl())
                .disponible(dto.getDisponible() != null ? dto.getDisponible() : true)
                .categoriaId(dto.getCategoriaId())
                .sucursalId(dto.getSucursalId())
                .eliminado(false)
                .build();
                
        MenuItem saved = menuItemRepository.save(item);
        return mapToDTO(saved);
    }

    @Override
    public MenuItemResponseDTO getById(Long id) {
        /*
         * INTENCIÓN: Consultar ítem por ID.
         */
        log.info("Consultando MenuItem con ID: {}", id);
        MenuItem item = menuItemRepository.findByIdAndDisponibleTrueAndEliminadoFalse(id)
                .orElseThrow(() -> new MenuItemNotFoundException("Item no encontrado o no disponible con ID: " + id));
        return mapToDTO(item);
    }

    @Override
    public List<MenuItemResponseDTO> listarDisponibles() {
        log.info("Listando todos los MenuItem disponibles");
        List<MenuItem> items = menuItemRepository.findByDisponibleTrueAndEliminadoFalseOrderByNombreAsc();
        return items.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<MenuItemResponseDTO> listarPorCategoria(Long categoriaId) {
        log.info("Listando MenuItem disponibles por categoriaId={}", categoriaId);
        List<MenuItem> items = menuItemRepository.findByCategoriaIdAndDisponibleTrueAndEliminadoFalseOrderByNombreAsc(categoriaId);
        return items.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<MenuItemResponseDTO> listarPorSucursal(Long sucursalId) {
        log.info("Listando MenuItem disponibles por sucursalId={}", sucursalId);
        List<MenuItem> items = menuItemRepository.findDisponiblesBySucursal(sucursalId);
        return items.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MenuItemResponseDTO actualizar(Long id, MenuItemRequestDTO dto) {
        log.info("Actualizando completamente MenuItem con ID: {}", id);
        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow(() -> new MenuItemNotFoundException("Item no encontrado con ID: " + id));
                
        if (item.getEliminado()) {
            throw new RuntimeException("No se puede actualizar un ítem eliminado");
        }

        item.setNombre(dto.getNombre());
        item.setDescripcion(dto.getDescripcion());
        item.setPrecio(dto.getPrecio());
        item.setImagenUrl(dto.getImagenUrl());
        item.setDisponible(dto.getDisponible() != null ? dto.getDisponible() : item.getDisponible());
        item.setCategoriaId(dto.getCategoriaId());
        item.setSucursalId(dto.getSucursalId());

        MenuItem updated = menuItemRepository.save(item);
        return mapToDTO(updated);
    }

    @Override
    @Transactional
    public MenuItemResponseDTO cambiarDisponibilidad(Long id, Boolean disponible) {
        log.info("Cambiando disponibilidad de MenuItem ID: {} a {}", id, disponible);
        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow(() -> new MenuItemNotFoundException("Item no encontrado con ID: " + id));
        item.setDisponible(disponible);
        MenuItem updated = menuItemRepository.save(item);
        return mapToDTO(updated);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        /*
         * INTENCIÓN: Borrar ítem. Solo permitido si no está en ms-pedidos.
         * APLICACIÓN REAL: Implementado como Soft Delete para mantener trazabilidad.
         */
        log.info("Eliminando lógicamente (soft delete) MenuItem con ID: {}", id);
        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow(() -> new MenuItemNotFoundException("Item no encontrado con ID: " + id));
        item.setEliminado(true);
        item.setDisponible(false);
        menuItemRepository.save(item);
    }
    
    private MenuItemResponseDTO mapToDTO(MenuItem entity) {
        return MenuItemResponseDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .precio(entity.getPrecio())
                .imagenUrl(entity.getImagenUrl())
                .disponible(entity.getDisponible())
                .categoriaId(entity.getCategoriaId())
                .sucursalId(entity.getSucursalId())
                .creadoEn(entity.getCreadoEn())
                .actualizadoEn(entity.getActualizadoEn())
                .build();
    }
}
