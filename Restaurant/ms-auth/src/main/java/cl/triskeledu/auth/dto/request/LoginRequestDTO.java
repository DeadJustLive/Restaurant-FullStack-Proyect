package cl.triskeledu.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * =============================================================================
 * DTO REQUEST: LoginRequestDTO
 * =============================================================================
 *
 * PROPÓSITO:
 *   Payload JSON para el endpoint de autenticación: POST /api/v1/auth/login.
 *
 * FLUJO DE DATOS:
 *   Cliente envía: { "username": "juan@email.com", "password": "miClave123" }
 *   → Jackson deserializa → @Valid valida campos
 *   → AuthController.login(dto)
 *   → AuthService.login(dto):
 *       1. userRepo.findByUsername(dto.username)
 *       2. BCrypt.matches(dto.password, credential.password)
 *       3. Si OK: JwtService.generarToken(credential) → AuthResponseDTO
 *
 * SEGURIDAD CRÍTICA:
 *   - El campo `password` viaja en texto plano en el body (nunca en URL/query params).
 *   - El canal DEBE ser HTTPS. Sin TLS, la contraseña viaja expuesta.
 *   - No loguear el DTO completo: log.info("Login: {}", dto) expondría la contraseña.
 *     Solo loguear el username: log.info("Login attempt: username={}", dto.getUsername()).
 *   - El tiempo de respuesta ante username inexistente y contraseña incorrecta debe ser
 *     similar para evitar timing attacks (BCrypt naturalmente introduce delay).
 *
 * CAMPOS EXCLUIDOS INTENCIONALMENTE:
 *   - `rol`: el rol se obtiene de la BD, nunca del cliente (podría fabricar su propio rol).
 *
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {

    /**
     * CAMPO: username
     * Tipo: String
     * Rol: Identificador único del usuario. Usado como clave de búsqueda en la BD.
     *      Se valida como email para mantener consistencia con el registro.
     * Validación: No vacío, formato de email válido.
     * Seguridad: Es seguro loguear para trazabilidad de intentos de login.
     */
    @NotBlank(message = "El username es obligatorio")
    @Email(message = "El username debe ser un email válido")
    private String username;

    /**
     * CAMPO: password
     * Tipo: String
     * Rol: Contraseña en texto plano enviada por el cliente.
     *      El Service la compara con el hash BCrypt almacenado en la BD.
     *      Nunca se persiste. Se descarta inmediatamente tras la verificación.
     * Validación: No vacío, mínimo 8 caracteres (política de contraseñas básica).
     * Seguridad: NUNCA loguear. NUNCA incluir en respuestas de error.
     *            TODO: Implementar política de contraseñas más estricta:
     *                  mínimo 1 mayúscula, 1 número, 1 carácter especial.
     */
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;
}
