package cl.triskeledu.auth.controller;

import cl.triskeledu.auth.dto.request.UsuarioRequestDTO;
import cl.triskeledu.auth.dto.response.UsuarioResponseDTO;
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
import lombok.RequiredArgsConstructor;
import cl.triskeledu.auth.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
@Slf4j
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crear(@Valid @RequestBody UsuarioRequestDTO dto) {
        log.info("REST request to create Usuario");
        return ResponseEntity.status(201).body(usuarioService.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> getById(@PathVariable Long id) {
        log.info("REST request to get Usuario : {}", id);
        return ResponseEntity.ok(usuarioService.getById(id));
    }

    @GetMapping("/credencial/{credencialId}")
    public ResponseEntity<UsuarioResponseDTO> getByCredencialId(@PathVariable Long credencialId) {
        log.info("REST request to get Usuario by credencialId : {}", credencialId);
        return ResponseEntity.ok(usuarioService.getByCredencialId(credencialId));
    }

    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<UsuarioResponseDTO>> listarPorSucursal(@PathVariable Long sucursalId) {
        log.info("REST request to list Usuarios by sucursalId : {}", sucursalId);
        return ResponseEntity.ok(usuarioService.listarPorSucursal(sucursalId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO dto) {
        log.info("REST request to update Usuario : {}", id);
        return ResponseEntity.ok(usuarioService.actualizar(id, dto));
    }

    @PatchMapping("/{id}/sucursal")
    public ResponseEntity<UsuarioResponseDTO> reasignarSucursal(@PathVariable Long id, @RequestParam Long sucursalId) {
        log.info("REST request to reassign sucursal for Usuario : {}", id);
        return ResponseEntity.ok(usuarioService.reasignarSucursal(id, sucursalId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        log.info("REST request to delete Usuario : {}", id);
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
