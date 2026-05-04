package cl.triskeledu.menu.controller;

import cl.triskeledu.menu.dto.request.MenuItemRequestDTO;
import cl.triskeledu.menu.dto.response.MenuItemResponseDTO;
import cl.triskeledu.menu.service.MenuItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PostMapping
    public ResponseEntity<MenuItemResponseDTO> crear(@Valid @RequestBody MenuItemRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuItemService.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(menuItemService.getById(id));
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<MenuItemResponseDTO>> listarDisponiblesExplicito(
            @RequestParam(required = false) Long sucursalId,
            @RequestParam(required = false) Long categoriaId) {
        return listarDisponibles(sucursalId, categoriaId);
    }

    @GetMapping
    public ResponseEntity<List<MenuItemResponseDTO>> listarDisponibles(
            @RequestParam(required = false) Long sucursalId,
            @RequestParam(required = false) Long categoriaId) {
        
        if (sucursalId != null) {
            return ResponseEntity.ok(menuItemService.listarPorSucursal(sucursalId));
        } else if (categoriaId != null) {
            return ResponseEntity.ok(menuItemService.listarPorCategoria(categoriaId));
        }
        return ResponseEntity.ok(menuItemService.listarDisponibles());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItemResponseDTO> actualizarParcial(
            @PathVariable Long id, 
            @RequestBody MenuItemRequestDTO dto) {
        return ResponseEntity.ok(menuItemService.actualizar(id, dto));
    }

    @PatchMapping("/{id}/disponibilidad")
    public ResponseEntity<MenuItemResponseDTO> cambiarDisponibilidad(
            @PathVariable Long id, 
            @RequestParam Boolean disponible) {
        return ResponseEntity.ok(menuItemService.cambiarDisponibilidad(id, disponible));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFisicamente(@PathVariable Long id) {
        menuItemService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
