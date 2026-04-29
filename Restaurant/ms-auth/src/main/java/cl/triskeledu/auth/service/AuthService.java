package cl.triskeledu.auth.service;

import cl.triskeledu.auth.dto.request.LoginRequestDTO;
import cl.triskeledu.auth.dto.request.RegisterRequestDTO;
import cl.triskeledu.auth.dto.response.AuthResponseDTO;

/**
 * =============================================================================
 * SERVICE INTERFACE: AuthService
 * =============================================================================
 *
 * PROPÓSITO:
 *   Define el contrato de negocio del dominio de autenticación.
 *   Orquesta los flujos de registro, login, refresh y logout
 *   delegando en UserCredentialRepository y JwtService.
 *
 * EXCEPCIONES ESPERADAS:
 *   - CredencialesInvalidasException: username no encontrado o password incorrecta.
 *   - CuentaDesactivadaException: activo = false en la credencial.
 *   - UsuarioYaExisteException: username ya registrado (en registrar()).
 *   - TokenInvalidoException: refresh token expirado, revocado o no encontrado.
 *
 * =============================================================================
 */
public interface AuthService {

    /**
     * OPERACIÓN: Registrar nuevas credenciales de usuario.
     *
     * FLUJO:
     *   Input:  RegisterRequestDTO con username, password, rol.
     *   Process:
     *     1. Verificar que username no existe (existsByUsername).
     *        Si existe → UsuarioYaExisteException.
     *     2. Normalizar username a minúsculas (anti-duplicados de case).
     *     3. Hashear password con BCryptPasswordEncoder.encode().
     *     4. Asignar ROLE_CL si dto.rol es null (auto-registro de cliente).
     *     5. Persistir UserCredential(username, passwordHash, rol, activo=true).
     *     6. Generar JWT con JwtService.generarToken(credential).
     *     7. Generar refresh token con JwtService.generarRefreshToken(id).
     *     8. TODO: Notificar a ms-usuarios para crear el perfil del nuevo usuario.
     *        usuariosClient.crearPerfil(UsuarioPerfilRequestDTO.builder()
     *            .credencialId(savedCredential.getId())
     *            .username(savedCredential.getUsername())
     *            .build());
     *   Output: AuthResponseDTO con token, refreshToken, expiresIn, rol, username.
     *
     * HTTP: 201 Created.
     *
     * @param dto Datos de registro validados.
     * @return AuthResponseDTO con JWT del nuevo usuario.
     */
    AuthResponseDTO registrar(RegisterRequestDTO dto);

    /**
     * OPERACIÓN: Autenticar credenciales y emitir JWT.
     *
     * FLUJO:
     *   Input:  LoginRequestDTO con username y password.
     *   Process:
     *     1. Normalizar username a minúsculas.
     *     2. Buscar credencial: repo.findByUsername(username).
     *        Si no existe → CredencialesInvalidasException ("Credenciales inválidas").
     *        NOTA: El mensaje no debe especificar si el problema es el username o la password.
     *              Ambos casos deben retornar el MISMO mensaje (anti user-enumeration).
     *     3. Verificar contraseña: BCrypt.matches(dto.password, credential.password).
     *        Si no coincide → CredencialesInvalidasException ("Credenciales inválidas").
     *     4. Verificar que credential.activo == true.
     *        Si false → CuentaDesactivadaException.
     *     5. Generar JWT con JwtService.generarToken(credential).
     *     6. Generar refresh token con JwtService.generarRefreshToken(credential.id).
     *   Output: AuthResponseDTO con token, refreshToken, expiresIn, rol, username.
     *
     * REGLA ANTI-TIMING ATTACK:
     *   Si el username no existe, el tiempo de respuesta debe ser similar al de
     *   una contraseña incorrecta. BCrypt introduce un delay natural al verificar.
     *   TODO: Si el username no existe, llamar igualmente a BCrypt.matches() contra
     *         un hash dummy para igualar tiempos de respuesta.
     *
     * HTTP: 200 OK.
     *
     * @param dto Credenciales del usuario.
     * @return AuthResponseDTO con JWT emitido.
     */
    AuthResponseDTO login(LoginRequestDTO dto);

    /**
     * OPERACIÓN: Renovar JWT usando un refresh token válido.
     *
     * FLUJO:
     *   Input:  refreshToken (String).
     *   Process:
     *     1. Buscar el refresh token en la BD (tabla `refresh_tokens`).
     *        Si no existe → TokenInvalidoException.
     *     2. Verificar que no esté expirado ni revocado.
     *     3. Cargar la credencial asociada (por userId del refresh token).
     *     4. Verificar que la credencial siga activa.
     *     5. Generar nuevo JWT con JwtService.generarToken(credential).
     *     6. Opcionalmente, rotar el refresh token (generar uno nuevo y revocar el anterior).
     *   Output: AuthResponseDTO con el nuevo JWT (el refreshToken puede ser el mismo o uno nuevo).
     *
     * TODO: Implementar cuando RefreshTokenRepository esté disponible.
     *
     * HTTP: 200 OK.
     *
     * @param refreshToken Valor del refresh token enviado por el cliente.
     * @return AuthResponseDTO con el nuevo JWT.
     */
    AuthResponseDTO refresh(String refreshToken);

    /**
     * OPERACIÓN: Revocar el refresh token activo del usuario (logout).
     *
     * FLUJO:
     *   Input:  refreshToken (String) — enviado por el cliente al hacer logout.
     *   Process:
     *     1. Buscar el refresh token en la BD.
     *     2. Si existe: marcar como revocado (revocado = true).
     *     3. Si no existe: ignorar silenciosamente (logout idempotente).
     *   Output: void.
     *
     * NOTA SOBRE EL JWT DE ACCESO:
     *   El JWT de acceso no se puede revocar directamente (es stateless).
     *   Al hacer logout, el cliente debe descartar el JWT del lado del cliente.
     *   El JWT seguirá siendo técnicamente válido hasta su expiración.
     *   TODO: Para revocación inmediata, implementar blacklist de JWT en Redis.
     *
     * HTTP: 204 No Content.
     *
     * @param refreshToken Token a revocar.
     */
    void logout(String refreshToken);
}
