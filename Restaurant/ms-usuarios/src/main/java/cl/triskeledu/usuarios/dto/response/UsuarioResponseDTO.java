package cl.triskeledu.usuarios.dto.response;

import lombok.*;

import java.time.LocalDateTime;

/**
 * =============================================================================
 * DTO RESPONSE: UsuarioResponseDTO
 * =============================================================================
 *
 * PROPÓSITO:
 *   Vista pública del perfil de un usuario. Serializado como JSON en las respuestas.
 *
 * CONSUMIDORES DE ESTE DTO:
 *   1. Frontend: muestra nombre, imagen y datos de contacto del usuario.
 *   2. ms-pedidos (Feign): consulta `nombre` y `apellido` para mostrar en pedido.
 *   3. ms-notificaciones (Feign): consulta `nombre` para personalizar mensajes.
 *   4. ms-delivery (Feign): consulta `telefono` y `direccion` para coordinar entrega.
 *
 * CAMPOS OMITIDOS POR SEGURIDAD:
 *   - `password`: nunca. Ni siquiera existe en este MS (está en ms-auth).
 *   - `credencialId`: NO incluir en responses públicos — es un ID interno de ms-auth.
 *     Solo expuesto para comunicación interna (Feign entre ms-auth y ms-usuarios).
 *     TODO: Evaluar si exponer credencialId o usar solo el id local.
 *
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {

    /** ID del perfil en ms-usuarios (distinto al credencialId de ms-auth). */
    private Long id;

    /**
     * ID de la credencial en ms-auth. Incluido para uso interno (Feign).
     * El frontend NO debe usar este campo directamente — usar el `sub` del JWT.
     */
    private Long credencialId;

    /** Nombre de pila. Usado por ms-notificaciones para personalizar mensajes. */
    private String nombre;

    /** Apellido. Complementa el nombre para identificación completa. */
    private String apellido;

    /**
     * Nombre completo (nombre + apellido). Campo conveniente para el frontend.
     * Calculado en el Mapper o Service — no existe como columna en la BD.
     * TODO: Calcular en UsuarioMapper: nombre + " " + apellido.
     */
    private String nombreCompleto;

    /**
     * Teléfono. Consumido por ms-delivery para contacto en entregas.
     * Solo expuesto a roles con permiso (no al cliente público).
     * TODO: Configurar @JsonView para ocultar campos según el rol del requester.
     */
    private String telefono;

    /** Dirección principal. Pre-rellena el formulario de delivery en el frontend. */
    private String direccion;

    /** URL de la foto de perfil. El frontend muestra avatar genérico si null. */
    private String imagenUrl;

    /**
     * ID de la sucursal asignada. Solo para empleados.
     * El frontend usa este campo para mostrar la sucursal del empleado en el panel de admin.
     */
    private Long sucursalId;

    /** Estado activo del perfil. */
    private Boolean activo;

    /** Fecha de creación del perfil. */
    private LocalDateTime creadoEn;

    /** Última actualización del perfil. */
    private LocalDateTime actualizadoEn;
}
