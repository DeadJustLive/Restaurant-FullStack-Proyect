package cl.triskeledu.auth.dto.request;

import cl.triskeledu.auth.entity.enums.RolUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * =============================================================================
 * DTO REQUEST: RegisterRequestDTO
 * =============================================================================
 *
 * PROPÓSITO:
 *   Payload JSON para el registro de nuevas credenciales: POST /api/v1/auth/register.
 *   Solo crea la entidad de autenticación. El perfil de usuario (nombre, dirección,
 *   teléfono) es responsabilidad de ms-usuarios.
 *
 * FLUJO DE DATOS:
 *   Admin/Sistema envía: { "username": "...", "password": "...", "rol": "ROLE_CL" }
 *   → @Valid valida → AuthService.registrar(dto):
 *       1. Verificar username no duplicado
 *       2. BCrypt.encode(dto.password) → passwordHash
 *       3. Persistir UserCredential(username, passwordHash, rol, activo=true)
 *       4. JwtService.generarToken(credential) → AuthResponseDTO
 *       5. TODO: notificarUsuariosService.crearPerfil(credential.id, dto.username)
 *   → HTTP 201 + AuthResponseDTO con JWT
 *
 * DECISIÓN DE DISEÑO — ¿Quién puede registrar con qué rol?
 *   - ROLE_CL: registro libre (auto-registro desde app del cliente).
 *   - ROLE_CO, ROLE_RP, ROLE_AD: solo ROLE_SA o ROLE_AD puede crearlos.
 *   - ROLE_SA: solo ROLE_SA existente puede crear otro ROLE_SA.
 *   TODO: Implementar validación de rol en AuthServiceImpl:
 *         Si el JWT del requester no tiene privilegio para asignar el rol → 403 Forbidden.
 *         Por ahora, el endpoint de registro de empleados estará restringido por @PreAuthorize.
 *
 * CAMPOS EXCLUIDOS INTENCIONALMENTE:
 *   - `activo`: siempre true al crear. Solo el admin puede desactivar después.
 *
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    /**
     * CAMPO: username
     * Tipo: String
     * Rol: Email que actuará como identificador único de la cuenta.
     *      Se almacena como está (sin transformar a minúsculas) — el login debe ser case-insensitive.
     *      TODO: Normalizar a minúsculas en el Service antes de persistir para evitar
     *            duplicados como "Juan@email.com" y "juan@email.com".
     * Validación: Obligatorio, formato email válido.
     */
    @NotBlank(message = "El username es obligatorio")
    @Email(message = "El username debe ser un email válido")
    private String username;

    /**
     * CAMPO: password
     * Tipo: String
     * Rol: Contraseña en texto plano. El Service la hashea con BCrypt antes de persistir.
     *      NUNCA se almacena en texto plano. NUNCA se retorna en el response.
     * Validación: Obligatorio, mínimo 8 caracteres.
     * TODO: Agregar validación de complejidad con @Pattern:
     *   - Al menos 1 mayúscula: (?=.*[A-Z])
     *   - Al menos 1 número: (?=.*\d)
     *   - Al menos 1 especial: (?=.*[@$!%*?&])
     */
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;

    /**
     * CAMPO: rol
     * Tipo: RolUsuario (enum)
     * Rol: Rol asignado a la nueva cuenta. Determina los permisos en todo el sistema.
     *      Si no se especifica, el Service asigna ROLE_CL por defecto (auto-registro de cliente).
     * Validación: Opcional — si null, el Service asigna ROLE_CL.
     * Seguridad: El Controller/Service debe verificar que el requester tiene permisos
     *            para asignar el rol solicitado.
     *            TODO: Un cliente NO puede auto-registrarse con ROLE_AD o ROLE_SA.
     */
    private RolUsuario rol;
}
