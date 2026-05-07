package cl.triskeledu.usuarios.controller;

import cl.triskeledu.usuarios.dto.request.UsuarioRequestDTO;
import cl.triskeledu.usuarios.dto.response.UsuarioResponseDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =============================================================================
 * CONTROLLER: UsuarioController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/usuarios")
@Slf4j
public class UsuarioController {

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crear(@Valid @RequestBody UsuarioRequestDTO dto) {
        /*
         * INTENCIÓN: Invocado por ms-auth vía Feign al registrarse.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> getById(@PathVariable Long id) {
        /*
         * INTENCIÓN: Consulta interna de perfil por ID en ms-usuarios.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/credencial/{credencialId}")
    public ResponseEntity<UsuarioResponseDTO> getByCredencialId(@PathVariable Long credencialId) {
        /*
         * INTENCIÓN: Consulta por sub del JWT (Feign crítico).
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<UsuarioResponseDTO>> listarPorSucursal(@PathVariable Long sucursalId) {
        /*
         * INTENCIÓN: Empleados activos de un local.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO dto) {
        /*
         * INTENCIÓN: Edición del propio perfil.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @PatchMapping("/{id}/sucursal")
    public ResponseEntity<UsuarioResponseDTO> reasignarSucursal(@PathVariable Long id, @RequestParam Long sucursalId) {
        /*
         * INTENCIÓN: Mover empleado.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        /*
         * INTENCIÓN: Soft delete.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }
}
