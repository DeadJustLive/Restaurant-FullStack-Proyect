package cl.triskeledu.categorias.controller;

import cl.triskeledu.categorias.dto.request.CategoriaRequestDTO;
import cl.triskeledu.categorias.dto.response.CategoriaResponseDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =============================================================================
 * CONTROLLER: CategoriaController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/categorias")
@Slf4j
public class CategoriaController {

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> crear(@Valid @RequestBody CategoriaRequestDTO dto) {
        /*
         * INTENCIÓN: Crear categoría. Solo ROLE_SA, AD.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> getById(@PathVariable Long id) {
        /*
         * INTENCIÓN: Obtener detalle. Acceso público.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listarActivas() {
        /*
         * INTENCIÓN: Listar activas. Acceso público para menú.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/todas")
    public ResponseEntity<List<CategoriaResponseDTO>> listarTodas() {
        /*
         * INTENCIÓN: Listar todas (incluyendo inactivas). Para admin.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody CategoriaRequestDTO dto) {
        /*
         * INTENCIÓN: Actualizar nombre/descripción.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<CategoriaResponseDTO> cambiarEstado(@PathVariable Long id, @RequestParam Boolean activa) {
        /*
         * INTENCIÓN: Ocultar o mostrar categoría.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }
}
