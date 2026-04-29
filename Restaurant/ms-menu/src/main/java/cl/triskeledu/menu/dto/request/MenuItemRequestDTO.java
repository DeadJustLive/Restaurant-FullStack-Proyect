package cl.triskeledu.menu.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * =============================================================================
 * DTO REQUEST: MenuItemRequestDTO
 * =============================================================================
 *
 * PROPÓSITO:
 *   Payload JSON para CREAR o ACTUALIZAR un ítem del menú.
 *   Usado tanto en POST /api/v1/menu (crear) como en PUT /api/v1/menu/{id} (actualizar completo).
 *
 * FLUJO DE DATOS:
 *   ADMIN envía JSON → Jackson deserializa → @Valid valida
 *   → MenuItemController → MenuItemService
 *   → [Feign: validar categoriaId en ms-categorias]
 *   → [Feign: validar sucursalId en ms-sucursales si no es null]
 *   → MapStruct: DTO → Entity → Repository.save()
 *   → Entity → MenuItemResponseDTO → JSON response
 *
 * CAMPOS EXCLUIDOS INTENCIONALMENTE:
 *   - `id`: generado por la BD, nunca recibido en creación.
 *   - `creadoEn`, `actualizadoEn`: marcas temporales automáticas de Hibernate.
 *
 * ACCESO:
 *   Solo ROLE_AD (Admin de sucursal) y ROLE_SA (Super Admin) pueden enviar este DTO.
 *   El Controller debe verificar el rol antes de procesar la request.
 *
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemRequestDTO {

    /**
     * CAMPO: nombre
     * Tipo: String
     * Rol: Nombre comercial del producto. Será capturado como snapshot por ms-pedidos.
     * Validación: Obligatorio, 2 a 100 caracteres. Sin caracteres especiales peligrosos.
     * Impacto: Cambiar el nombre en un PUT actualiza el catálogo actual pero no los snapshots históricos.
     */
    @NotBlank(message = "El nombre del ítem es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    /**
     * CAMPO: descripcion
     * Tipo: String
     * Rol: Descripción completa del producto con ingredientes y alérgenos.
     * Validación: Opcional, máximo 1000 caracteres para evitar abuso.
     */
    @Size(max = 1000, message = "La descripción no puede superar los 1000 caracteres")
    private String descripcion;

    /**
     * CAMPO: precio
     * Tipo: BigDecimal
     * Rol: Precio de venta en moneda local. Fuente de verdad para snapshots de ms-pedidos.
     * Validación: Obligatorio, mayor a 0. Máximo 2 decimales (definido por la columna DECIMAL(10,2)).
     * Riesgo: El Service debe registrar el cambio de precio en un log de auditoría.
     *         TODO: Implementar tabla `precio_historial` para trazabilidad de cambios.
     */
    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a cero")
    @Digits(integer = 8, fraction = 2, message = "El precio debe tener como máximo 8 dígitos enteros y 2 decimales")
    private BigDecimal precio;

    /**
     * CAMPO: imagenUrl
     * Tipo: String
     * Rol: URL de la imagen del producto en CDN. No se almacena el binario en la BD.
     * Validación: Opcional. Si se provee, debe ser una URL válida.
     * TODO: Validar formato con @URL (Hibernate Validator) cuando se integre la dependencia.
     */
    @Size(max = 500, message = "La URL de la imagen no puede superar los 500 caracteres")
    private String imagenUrl;

    /**
     * CAMPO: disponible
     * Tipo: Boolean
     * Rol: Estado de disponibilidad del ítem. Si es false, el ítem no puede ordenarse.
     * Validación: Opcional en creación — el Service asigna true por defecto.
     * Nota: Para cambiar solo disponibilidad se recomienda usar PATCH /{id}/disponibilidad.
     *       Incluir aquí también para soporte de PUT (actualización completa).
     */
    private Boolean disponible;

    /**
     * CAMPO: categoriaId
     * Tipo: Long
     * Rol: ID de la categoría a la que pertenece el ítem (de ms-categorias).
     *      El Service validará que la categoría existe y está activa llamando a CategoriaClient.
     * Validación: Obligatorio.
     * TODO: Si CategoriaClient retorna 404, lanzar CategoriaNotFoundException.
     */
    @NotNull(message = "El ID de la categoría es obligatorio")
    private Long categoriaId;

    /**
     * CAMPO: sucursalId
     * Tipo: Long — nullable
     * Rol: Si se provee, el ítem es exclusivo de esa sucursal.
     *      Si es null, el ítem es global y aparece en todas las sucursales.
     * Validación: Opcional. Si se provee, el Service validará en ms-sucursales.
     * TODO: Si SucursalClient retorna 404 o sucursal inactiva, lanzar SucursalNotFoundException.
     */
    private Long sucursalId;
}
