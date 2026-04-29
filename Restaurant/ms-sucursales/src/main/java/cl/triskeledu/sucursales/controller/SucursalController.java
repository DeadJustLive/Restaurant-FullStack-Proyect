package cl.triskeledu.sucursales.controller;

import cl.triskeledu.sucursales.dto.request.SucursalRequestDTO;
import cl.triskeledu.sucursales.dto.response.SucursalResponseDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =============================================================================
 * CONTROLLER: SucursalController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/sucursales")
@Slf4j
public class SucursalController {

    @PostMapping
    public ResponseEntity<SucursalResponseDTO> crear(@Valid @RequestBody SucursalRequestDTO dto) {
        /*
         * INTENCIÓN: Endpoint para dar de alta sucursales.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<SucursalResponseDTO> getById(@PathVariable Long id) {
        /*
         * INTENCIÓN: Obtener detalle público.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping
    public ResponseEntity<List<SucursalResponseDTO>> listarActivas() {
        /*
         * INTENCIÓN: Mostrar en el frontend.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/todas")
    public ResponseEntity<List<SucursalResponseDTO>> listarTodas() {
        /*
         * INTENCIÓN: Mostrar para panel de admin.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<SucursalResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody SucursalRequestDTO dto) {
        /*
         * INTENCIÓN: Modificar info de contacto.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<SucursalResponseDTO> cambiarEstado(@PathVariable Long id, @RequestParam Boolean activa) {
        /*
         * INTENCIÓN: Cerrar/abrir local.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }
}
