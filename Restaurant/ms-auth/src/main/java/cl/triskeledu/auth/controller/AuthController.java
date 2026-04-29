package cl.triskeledu.auth.controller;

import cl.triskeledu.auth.dto.request.LoginRequestDTO;
import cl.triskeledu.auth.dto.request.RegisterRequestDTO;
import cl.triskeledu.auth.dto.response.AuthResponseDTO;
import cl.triskeledu.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * =============================================================================
 * CONTROLLER: AuthController
 * =============================================================================
 *
 * PROPÓSITO:
 * Capa REST pública del servicio de autenticación.
 * Gestiona el registro, login, refresh de tokens y logout.
 *
 * BASE URL: /api/v1/auth
 * Puerto: 9001 — registrado en Eureka como: ms-auth
 *
 * ACCESO:
 * Los endpoints de este controller son mayormente PÚBLICOS (no requieren JWT).
 * Esto se configura en SecurityConfig.java para que Spring Security no
 * rechace las requests a /api/v1/auth/** antes de autenticarse.
 *
 * LOGGING:
 * - Loguear el username en intentos de login (trazabilidad).
 * - NUNCA loguear contraseñas ni tokens JWT completos.
 * - En producción: considera loguear la IP del cliente para detección de
 * ataques.
 *
 * TODO: Implementar rate limiting en /login para prevenir ataques de fuerza
 * bruta.
 * Opciones: Spring Boot Actuator + Bucket4j, o Kong API Gateway.
 *
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    // =========================================================================
    // ENDPOINT: POST /api/v1/auth/register
    // =========================================================================

    /**
     * ENDPOINT: Registrar nuevas credenciales de usuario.
     *
     * MÉTODO: POST
     * PATH: /api/v1/auth/register
     * ACCESO: Público para ROLE_CL (auto-registro de clientes).
     * Para ROLE_CO, ROLE_RP, ROLE_AD: requiere JWT con ROLE_AD o ROLE_SA.
     * TODO: Separar en /register (cliente) y /admin/register (empleados).
     *
     * REQUEST BODY (RegisterRequestDTO):
     * {
     * "username": "cliente@email.com", // String, requerido, formato email
     * "password": "MiClave123!", // String, requerido, mínimo 8 chars
     * "rol": "ROLE_CL" // RolUsuario, opcional (default ROLE_CL)
     * }
     *
     * RESPUESTA EXITOSA: 201 Created
     * {
     * "token": "eyJhbGci...", // JWT de acceso
     * "refreshToken": "550e8400-...", // Refresh token
     * "expiresIn": 3600, // Segundos hasta expiración del JWT
     * "rol": "ROLE_CL", // Rol del usuario registrado
     * "username": "cliente@email.com"
     * }
     *
     * RESPUESTAS DE ERROR:
     * 400 Bad Request — Validación fallida (email inválido, password corta).
     * 409 Conflict — Username ya registrado.
     *
     * SEGURIDAD: El campo `password` viaja en texto plano — REQUIERE HTTPS.
     */
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> registrar(@Valid @RequestBody RegisterRequestDTO dto) {
        log.info("[AuthController] POST /register — username={}", dto.getUsername());
        AuthResponseDTO response = authService.registrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // =========================================================================
    // ENDPOINT: POST /api/v1/auth/login
    // =========================================================================

    /**
     * ENDPOINT: Autenticar usuario y emitir JWT.
     *
     * MÉTODO: POST
     * PATH: /api/v1/auth/login
     * ACCESO: Público (sin JWT requerido).
     *
     * REQUEST BODY (LoginRequestDTO):
     * {
     * "username": "cliente@email.com", // String, requerido, formato email
     * "password": "MiClave123!" // String, requerido, mínimo 8 chars
     * }
     *
     * RESPUESTA EXITOSA: 200 OK
     * AuthResponseDTO con el JWT del usuario autenticado.
     * El cliente incluirá el token en cada request posterior:
     * Authorization: Bearer <token>
     *
     * RESPUESTAS DE ERROR:
     * 400 Bad Request — Validación fallida (@Valid).
     * 401 Unauthorized — Credenciales inválidas (username o password incorrectos).
     * Mensaje genérico — no especifica cuál de los dos es incorrecto.
     * 403 Forbidden — Cuenta desactivada.
     *
     * SEGURIDAD:
     * - REQUIERE HTTPS. La contraseña viaja en texto plano en el body.
     * - No loguear el body completo. Solo loguear el username.
     * - TODO: Implementar rate limiting: máximo 5 intentos fallidos por IP/username
     * en 15 minutos.
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginRequestDTO dto) {
        log.info("[AuthController] POST /login — username={}", dto.getUsername());
        return ResponseEntity.ok(authService.login(dto));
    }

    // =========================================================================
    // ENDPOINT: POST /api/v1/auth/refresh
    // =========================================================================

    /**
     * ENDPOINT: Renovar JWT usando un refresh token válido.
     *
     * MÉTODO: POST
     * PATH: /api/v1/auth/refresh
     * ACCESO: Público (el refresh token es la credencial en sí).
     *
     * REQUEST PARAM:
     * refreshToken (String): valor del refresh token emitido en el login/registro.
     * Ejemplo: POST /api/v1/auth/refresh?refreshToken=550e8400-...
     *
     * RESPUESTA EXITOSA: 200 OK
     * AuthResponseDTO con el nuevo JWT de acceso.
     * El refreshToken en la respuesta puede ser el mismo o uno nuevo (rotación).
     *
     * RESPUESTAS DE ERROR:
     * 401 Unauthorized — Refresh token inválido, expirado o revocado.
     *
     * NOTA:
     * El cliente debe implementar este flujo automáticamente cuando recibe
     * un 401 en cualquier request (indica que el JWT expiró).
     * El refresh token tiene mayor duración (7 días vs 1 hora del JWT).
     *
     * TODO: Implementar cuando RefreshTokenRepository esté disponible.
     */
    @PostMapping("/refresh")
    public ResponseEntity<AuthResponseDTO> refresh(@RequestParam String refreshToken) {
        log.info("[AuthController] POST /refresh");
        return ResponseEntity.ok(authService.refresh(refreshToken));
    }

    // =========================================================================
    // ENDPOINT: POST /api/v1/auth/logout
    // =========================================================================

    /**
     * ENDPOINT: Revocar el refresh token activo (logout).
     *
     * MÉTODO: POST
     * PATH: /api/v1/auth/logout
     * ACCESO: Público (o autenticado — se puede requerir JWT para evitar spam).
     *
     * REQUEST PARAM:
     * refreshToken (String): token a revocar.
     *
     * RESPUESTA EXITOSA: 204 No Content (sin body).
     *
     * RESPUESTAS DE ERROR:
     * Ninguna — el logout es idempotente. Si el token no existe, se ignora.
     *
     * NOTA IMPORTANTE:
     * Este endpoint solo revoca el refresh token.
     * El JWT de acceso sigue siendo válido hasta su expiración natural.
     * El cliente DEBE descartar el JWT del lado del cliente al hacer logout.
     * Para revocación inmediata del JWT: implementar blacklist en Redis.
     *
     * TODO: Implementar cuando RefreshTokenRepository esté disponible.
     */
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestParam String refreshToken) {
        log.info("[AuthController] POST /logout");
        authService.logout(refreshToken);
        return ResponseEntity.noContent().build();
    }
}
