package cl.triskeledu.usuarios.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

/**
 * =============================================================================
 * DTO REQUEST: UsuarioRequestDTO
 * =============================================================================
 *
 * PROPÓSITO:
 *   Payload JSON para CREAR o ACTUALIZAR un perfil de usuario.
 *   Usado en POST /api/v1/usuarios (crear, invocado por ms-auth vía Feign)
 *   y en PUT /api/v1/usuarios/{id} (actualizar, invocado por el propio usuario o admin).
 *
 * FLUJO DE CREACIÓN (invocado por ms-auth al registrar un usuario):
 *   ms-auth.registrar() → POST /api/v1/usuarios { credencialId, nombre, apellido, rol }
 *   → UsuarioServiceImpl.crear() → persiste perfil → retorna UsuarioResponseDTO
 *
 * FLUJO DE ACTUALIZACIÓN (invocado por el usuario desde el frontend):
 *   Cliente PUT /api/v1/usuarios/{id} { nombre, apellido, telefono, direccion, imagenUrl }
 *   El usuario solo puede actualizar su PROPIO perfil (validar credencialId del JWT).
 *   TODO: Agregar validación: credencialId del JWT == usuario.credencialId en el Service.
 *
 * CAMPOS EXCLUIDOS INTENCIONALMENTE:
 *   - `id`:           generado por la BD.
 *   - `credencialId`: inmutable una vez creado. Nunca en updates.
 *   - `activo`:       solo el admin puede cambiar este campo (endpoint dedicado).
 *   - `creadoEn`, `actualizadoEn`: gestionados por Hibernate.
 *
 * ACCESO:
 *   - Crear: Interno (ms-auth vía Feign) — no expuesto al cliente directamente.
 *   - Actualizar: El propio usuario (ROLE_CL su perfil) o ROLE_AD/ROLE_SA.
 *
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    /**
     * CAMPO: credencialId
     * Tipo: Long
     * Rol: ID de la credencial en ms-auth. Usado solo en CREACIÓN.
     *      En actualizaciones (PUT), este campo debe ser IGNORADO.
     *      El Service nunca debe actualizar el credencialId de un perfil existente.
     * Validación: Obligatorio en creación.
     * Nota: El Service valida que no exista ya un perfil con este credencialId.
     */
    @NotNull(message = "El ID de la credencial es obligatorio")
    private Long credencialId;

    /**
     * CAMPO: nombre
     * Tipo: String
     * Rol: Nombre de pila. Mostrado en la UI y en notificaciones.
     * Validación: Obligatorio, 2-100 caracteres.
     */
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    /**
     * CAMPO: apellido
     * Tipo: String
     * Rol: Apellido del usuario. Requerido para identificación completa.
     * Validación: Obligatorio, 2-100 caracteres.
     */
    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 100, message = "El apellido debe tener entre 2 y 100 caracteres")
    private String apellido;

    /**
     * CAMPO: telefono
     * Tipo: String
     * Rol: Número de contacto. Opcional en creación (puede completarse después en el perfil).
     *      Requerido para pedidos de delivery.
     * Validación: Opcional. Si se provee, validar formato básico.
     * TODO: Validar formato internacional con @Pattern: ^\+?[0-9]{7,15}$
     */
    @Size(max = 20, message = "El teléfono no puede superar los 20 caracteres")
    private String telefono;

    /**
     * CAMPO: direccion
     * Tipo: String
     * Rol: Dirección principal de entrega. Pre-rellena el carrito en deliveries.
     *      Opcional en creación.
     * Validación: Opcional. Máximo 300 caracteres.
     */
    @Size(max = 300, message = "La dirección no puede superar los 300 caracteres")
    private String direccion;

    /**
     * CAMPO: imagenUrl
     * Tipo: String
     * Rol: URL de la foto de perfil en CDN. Opcional.
     * Validación: Opcional. Máximo 500 caracteres.
     * TODO: Validar formato URL con @URL de Hibernate Validator.
     */
    @Size(max = 500, message = "La URL de imagen no puede superar los 500 caracteres")
    private String imagenUrl;

    /**
     * CAMPO: sucursalId
     * Tipo: Long — nullable
     * Rol: Sucursal asignada (solo para empleados). Null para clientes.
     *      El Service valida en ms-sucursales que la sucursal esté activa.
     * Validación: Opcional. Si se provee, el Service llama a SucursalClient.
     */
    private Long sucursalId;
}
