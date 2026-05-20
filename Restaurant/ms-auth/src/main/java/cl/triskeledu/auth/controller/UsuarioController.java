// @use(auth)
// @kind(controller)
// @contract(in: UsuarioRequestDTO -> out: UsuarioResponseDTO)
// @limit(lines: 400)
package cl.triskeledu.auth.controller;

import cl.triskeledu.auth.dto.request.UsuarioRequestDTO;
import cl.triskeledu.auth.dto.response.UsuarioResponseDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;
import cl.triskeledu.auth.service.UsuarioService;

/**
 * =============================================================================
 * CONTROLLER: UsuarioController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
@Slf4j
public class UsuarioController {

    private final UsuarioService usuarioService;

    /**
     * ENDPOINT: Crear un nuevo perfil de usuario.
     *
     * MÉTODO: POST
     * PATH: /api/v1/usuarios
     * PROPÓSITO: Crea un perfil vinculado a una credencial.
     * ACCESO: Invocado internamente tras el registro.
     *
     * @param dto Datos del usuario.
     * @return UsuarioResponseDTO con los datos creados y 201 Created.
     */
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crear(@Valid @RequestBody UsuarioRequestDTO dto) {
        log.info("[UsuarioController] POST /api/v1/usuarios — Creando Usuario");
        return ResponseEntity.status(201).body(usuarioService.crear(dto));
    }

    /**
     * ENDPOINT: Obtener un usuario por su ID interno de perfil.
     *
     * MÉTODO: GET
     * PATH: /api/v1/usuarios/{id}
     * PROPÓSITO: Recupera detalles completos de un usuario por su ID de perfil.
     *
     * @param id ID del perfil de usuario.
     * @return UsuarioResponseDTO y 200 OK.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> getById(@PathVariable Long id) {
        log.info("[UsuarioController] GET /api/v1/usuarios/{} — Obteniendo Usuario por ID", id);
        return ResponseEntity.ok(usuarioService.getById(id));
    }

    /**
     * ENDPOINT: Obtener un usuario por su credencialId.
     *
     * MÉTODO: GET
     * PATH: /api/v1/usuarios/credencial/{credencialId}
     * PROPÓSITO: Método crítico usado por Feign para obtener el perfil a partir del ID de credencial (JWT).
     *
     * @param credencialId ID de la credencial asociada.
     * @return UsuarioResponseDTO y 200 OK.
     */
    @GetMapping("/credencial/{credencialId}")
    public ResponseEntity<UsuarioResponseDTO> getByCredencialId(@PathVariable Long credencialId) {
        log.info("[UsuarioController] GET /api/v1/usuarios/credencial/{} — Obteniendo Usuario por credencialId", credencialId);
        return ResponseEntity.ok(usuarioService.getByCredencialId(credencialId));
    }

    /**
     * ENDPOINT: Listar usuarios activos por sucursal.
     *
     * MÉTODO: GET
     * PATH: /api/v1/usuarios/sucursal/{sucursalId}
     * PROPÓSITO: Devuelve la lista de empleados activos asignados a una sucursal específica.
     *
     * @param sucursalId ID de la sucursal.
     * @return Lista de UsuarioResponseDTO y 200 OK.
     */
    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<UsuarioResponseDTO>> listarPorSucursal(@PathVariable Long sucursalId) {
        log.info("[UsuarioController] GET /api/v1/usuarios/sucursal/{} — Listando Usuarios por sucursal", sucursalId);
        return ResponseEntity.ok(usuarioService.listarPorSucursal(sucursalId));
    }

    /**
     * ENDPOINT: Actualizar el perfil completo de un usuario.
     *
     * MÉTODO: PUT
     * PATH: /api/v1/usuarios/{id}
     * PROPÓSITO: Actualiza los datos de un perfil. Valida el acceso según el rol.
     *
     * @param id ID del perfil.
     * @param dto Nuevos datos.
     * @return UsuarioResponseDTO actualizado y 200 OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO dto) {
        log.info("[UsuarioController] PUT /api/v1/usuarios/{} — Actualizando Usuario", id);
        return ResponseEntity.ok(usuarioService.actualizar(id, dto));
    }

    /**
     * ENDPOINT: Reasignar un usuario a una sucursal diferente.
     *
     * MÉTODO: PATCH
     * PATH: /api/v1/usuarios/{id}/sucursal
     * PROPÓSITO: Modifica únicamente la sucursal a la que pertenece un empleado.
     *
     * @param id ID del perfil.
     * @param sucursalId ID de la nueva sucursal.
     * @return UsuarioResponseDTO actualizado y 200 OK.
     */
    @PatchMapping("/{id}/sucursal")
    public ResponseEntity<UsuarioResponseDTO> reasignarSucursal(@PathVariable Long id, @RequestBody java.util.Map<String, Long> payload) {
        Long sucursalId = payload.get("sucursalId");
        log.info("[UsuarioController] PATCH /api/v1/usuarios/{}/sucursal — Reasignando sucursal a {}", id, sucursalId);
        return ResponseEntity.ok(usuarioService.reasignarSucursal(id, sucursalId));
    }

    /**
     * ENDPOINT: Eliminar (Soft Delete) un usuario.
     *
     * MÉTODO: DELETE
     * PATH: /api/v1/usuarios/{id}
     * PROPÓSITO: Realiza una baja lógica (activo=false) para no romper referencias de histórico.
     *
     * @param id ID del perfil a eliminar.
     * @return 204 No Content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        log.info("[UsuarioController] DELETE /api/v1/usuarios/{} — Eliminando Usuario (Soft Delete)", id);
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
