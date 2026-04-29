package cl.triskeledu.auth.entity;

import cl.triskeledu.auth.entity.enums.RolUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * =============================================================================
 * ENTIDAD: UserCredential
 * =============================================================================
 *
 * PROPÓSITO:
 *   Almacena las credenciales de autenticación de cada usuario del sistema.
 *   Contiene únicamente los datos necesarios para autenticar (username + password hash + rol).
 *   Los datos de perfil (nombre, teléfono, dirección) pertenecen a ms-usuarios.
 *
 * TABLA EN BD: `user_credentials` (PostgreSQL — base de datos exclusiva `auth`)
 *
 * SEPARACIÓN DE RESPONSABILIDADES (Principio Database-per-Service):
 *   Esta entidad es la contraparte de identidad de un usuario.
 *   La relación entre ms-auth y ms-usuarios es por ID:
 *   UserCredential.id == Usuario.credencialId (en ms-usuarios).
 *   Al registrar un usuario: ms-auth crea UserCredential, luego notifica a ms-usuarios
 *   para crear el perfil con el mismo ID.
 *
 * INTEGRACIÓN CON SPRING SECURITY:
 *   Esta entidad puede implementar UserDetails de Spring Security
 *   para ser usada directamente por el AuthenticationManager.
 *   TODO: Implementar UserDetails cuando se configure Spring Security.
 *   Por ahora solo es una entidad JPA simple.
 *
 * INVARIANTES:
 *   1. El campo `password` SIEMPRE debe almacenarse como hash BCrypt. NUNCA en texto plano.
 *   2. El campo `username` es único en la BD (UNIQUE constraint).
 *   3. Solo el flujo de cambio de contraseña puede modificar `password`.
 *   4. Los campos de auditoría (`creadoEn`, `actualizadoEn`) son inmutables desde la API.
 *
 * =============================================================================
 */
@Entity
@Table(
    name = "user_credentials",
    uniqueConstraints = @UniqueConstraint(name = "uk_username", columnNames = "username")
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCredential {

    /**
     * ATRIBUTO: id
     * Tipo: Long (BIGSERIAL en PostgreSQL)
     * Rol: PK autoincremental. Es el identificador de identidad del usuario.
     *      Se incluye como claim `sub` (subject) en el payload del JWT.
     *      Es el campo que ms-usuarios almacena como `credencialId` para vincular perfiles.
     * Riesgo: CRÍTICO. Nunca reasignar. Si cambia, todos los JWT emitidos con el ID anterior
     *         se vuelven inválidos o apuntan a una identidad incorrecta.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ATRIBUTO: username
     * Tipo: String (VARCHAR 100)
     * Rol: Email o nombre de usuario único. Es la clave de búsqueda en el login.
     *      Usado por UserCredentialRepository.findByUsername() en el AuthServiceImpl.
     *      Se incluye como claim `username` en el JWT para que el frontend lo muestre.
     * Riesgo: ALTO. Cambiar el username de un usuario sin notificarle rompe su flujo de login.
     *         La constraint UNIQUE a nivel de BD garantiza unicidad sin lógica adicional.
     *         TODO: Implementar flujo de cambio de username con verificación de email.
     */
    @Column(name = "username", nullable = false, length = 100)
    private String username;

    /**
     * ATRIBUTO: password
     * Tipo: String (VARCHAR 255)
     * Rol: Hash BCrypt de la contraseña del usuario.
     *      255 chars es suficiente para BCrypt ($2a$10$... = 60 chars, con margen).
     *      El AuthServiceImpl usa BCryptPasswordEncoder.matches(rawPassword, this.password).
     * Riesgo: CRÍTICO.
     *         - NUNCA almacenar en texto plano. NUNCA loguear este campo.
     *         - NUNCA incluir en ningún DTO de response (ni en logs de error).
     *         - Solo modificable a través del endpoint de cambio de contraseña
     *           con verificación de la contraseña actual.
     *         - TODO: Agregar @JsonIgnore si se usa Jackson serialization directa de la entidad.
     */
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    /**
     * ATRIBUTO: rol
     * Tipo: RolUsuario (VARCHAR 20 — @Enumerated STRING)
     * Rol: Define los permisos del usuario en todo el sistema.
     *      Se incluye como claim `roles: ["ROLE_CL"]` en el JWT.
     *      Todos los microservicios leen este claim para decidir acceso con @PreAuthorize.
     * Riesgo: CRÍTICO.
     *         - Cambiar el rol de un usuario NO invalida sus tokens activos.
     *           El usuario seguirá operando con el rol anterior hasta que su JWT expire.
     *         - Para revocación inmediata de rol: implementar blacklist de tokens
     *           o reducir el tiempo de expiración del JWT (ej: 15 minutos).
     *         - TODO: Implementar notificación de cambio de rol con invalidación de sesión.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false, length = 20)
    private RolUsuario rol;

    /**
     * ATRIBUTO: activo
     * Tipo: Boolean
     * Rol: Flag de cuenta habilitada. Si es false, el login debe rechazarse con 401.
     *      Permite suspender cuentas sin eliminarlas (soft disable).
     *      Útil para bloquear cuentas por intentos fallidos, fraude o baja del servicio.
     * Riesgo: ALTO.
     *         - Desactivar una cuenta NO invalida los JWT ya emitidos.
     *           Un JWT activo sigue siendo válido hasta su expiración aunque activo = false.
     *         - Para revocación inmediata: implementar blacklist de tokens en Redis.
     *         - TODO: Verificar `activo` en JwtAuthFilter de cada microservicio
     *                 llamando a ms-auth (costo alto) o incluyendo `activo` en el JWT claim.
     */
    @Column(name = "activo", nullable = false)
    @Builder.Default
    private Boolean activo = true;

    /**
     * ATRIBUTO: creadoEn
     * Tipo: LocalDateTime (TIMESTAMP)
     * Rol: Fecha de creación de la credencial. Inmutable. Auditoría de alta de usuario.
     *      Útil para detectar cuentas recientes en alertas de seguridad.
     * Riesgo: CRÍTICO. updatable = false garantiza que Hibernate nunca lo sobreescriba.
     *         No incluir en ningún DTO de response externo.
     */
    @CreationTimestamp
    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    /**
     * ATRIBUTO: actualizadoEn
     * Tipo: LocalDateTime (TIMESTAMP)
     * Rol: Última modificación de la credencial (cambio de contraseña, de rol, etc.).
     *      Útil para auditoría de seguridad: detectar cambios recientes de contraseña.
     * Riesgo: BAJO. Gestionado automáticamente por Hibernate.
     */
    @UpdateTimestamp
    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn;
}
