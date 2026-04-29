package cl.triskeledu.menu.service.impl;

import cl.triskeledu.menu.dto.request.MenuItemRequestDTO;
import cl.triskeledu.menu.dto.response.MenuItemResponseDTO;
import cl.triskeledu.menu.service.MenuItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * =============================================================================
 * SERVICE IMPL: MenuItemServiceImpl
 * =============================================================================
 */
@Service
@Slf4j
public class MenuItemServiceImpl implements MenuItemService {

    @Override
    public MenuItemResponseDTO crear(MenuItemRequestDTO dto) {
        /*
         * INTENCIÓN: Registrar un nuevo plato o producto en el catálogo.
         *
         * FLUJO ESPERADO:
         *   Input: MenuItemRequestDTO
         *   Process:
         *     1. Validar categoría (Llamada Feign a ms-categorias).
         *     2. Si sucursalId != null -> Validar sucursal (Llamada Feign a ms-sucursales).
         *     3. Guardar entidad.
         *   Output: MenuItemResponseDTO
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public MenuItemResponseDTO getById(Long id) {
        /*
         * INTENCIÓN: Consultar ítem por ID.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public List<MenuItemResponseDTO> listarDisponibles(Long sucursalId, Long categoriaId) {
        /*
         * INTENCIÓN: Mostrar catálogo disponible a los clientes.
         *
         * FLUJO ESPERADO:
         *   Input: sucursalId (opcional), categoriaId (opcional)
         *   Process: Construir query dinámica para filtrar activos y por sucursal/categoría.
         *   Output: Lista de MenuItemResponseDTO
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public MenuItemResponseDTO actualizarParcial(Long id, MenuItemRequestDTO dto) {
        /*
         * INTENCIÓN: Modificar precio, estado o disponibilidad.
         *
         * FLUJO ESPERADO:
         *   Input: ID, DTO parcial
         *   Process: Buscar entidad, aplicar cambios in-place y guardar.
         *   Output: MenuItemResponseDTO
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public void eliminarFisicamente(Long id) {
        /*
         * INTENCIÓN: Borrar ítem. Solo permitido si no está en ms-pedidos.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }
}
