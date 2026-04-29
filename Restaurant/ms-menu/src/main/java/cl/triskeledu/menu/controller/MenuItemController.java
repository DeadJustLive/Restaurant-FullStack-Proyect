package cl.triskeledu.menu.controller;

import cl.triskeledu.menu.dto.request.MenuItemRequestDTO;
import cl.triskeledu.menu.dto.response.MenuItemResponseDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =============================================================================
 * CONTROLLER: MenuItemController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/menu")
@Slf4j
public class MenuItemController {

    @PostMapping
    public ResponseEntity<MenuItemResponseDTO> crear(@Valid @RequestBody MenuItemRequestDTO dto) {
        /*
         * INTENCIÓN: Endpoint para crear un nuevo ítem en el menú.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemResponseDTO> getById(@PathVariable Long id) {
        /*
         * INTENCIÓN: Endpoint para obtener detalle de un ítem.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping
    public ResponseEntity<List<MenuItemResponseDTO>> listarDisponibles(
            @RequestParam(required = false) Long sucursalId,
            @RequestParam(required = false) Long categoriaId) {
        /*
         * INTENCIÓN: Endpoint público para el cliente. Filtra ítems activos.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItemResponseDTO> actualizarParcial(
            @PathVariable Long id, 
            @RequestBody MenuItemRequestDTO dto) {
        /*
         * INTENCIÓN: Actualizar campos de un ítem.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFisicamente(@PathVariable Long id) {
        /*
         * INTENCIÓN: Eliminación física si no hay ventas.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }
}
