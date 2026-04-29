package cl.triskeledu.menu.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * =============================================================================
 * DTO RESPONSE: MenuItemResponseDTO
 * =============================================================================
 *
 * PROPÓSITO:
 *   Representa la vista pública de un MenuItem.
 *   Serializado como JSON en las respuestas de la API de ms-menu.
 *
 * CONSUMIDORES DE ESTE DTO:
 *   1. Frontend (CLIENTE): muestra el catálogo de productos, precios e imágenes.
 *   2. ms-pedidos (Feign): lee `id`, `nombre`, `precio` y `disponible`
 *      para crear el snapshot del PedidoItem. Es el contrato más crítico.
 *   3. ms-carrito (Feign): lee `precio` y `disponible` para calcular totales.
 *
 * CONTRATO FEIGN CRÍTICO:
 *   El campo `precio` en este DTO es el que ms-pedidos usa para el snapshot.
 *   Si se cambia el nombre del campo `precio` a otro nombre (ej: `precioVenta`),
 *   SE ROMPERÁ la deserialización en todos los clientes Feign que usan este DTO.
 *   Mantener compatibilidad hacia atrás o versionar el endpoint (/api/v2/menu).
 *
 * CAMPOS OMITIDOS PARA LA RESPUESTA PÚBLICA:
 *   Ninguno en este caso — todos los campos son seguros para exponer al cliente.
 *   Si en el futuro se agrega un campo `costoProduccion`, NO incluirlo aquí.
 *
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemResponseDTO {

    /** ID único del ítem. Clave usada por ms-pedidos y ms-carrito en sus llamadas Feign. */
    private Long id;

    /**
     * Nombre del producto. Capturado como snapshot por ms-pedidos al crear un PedidoItem.
     * CONTRATO: No renombrar este campo sin actualizar los clientes Feign.
     */
    private String nombre;

    /** Descripción completa con ingredientes y alérgenos. Visible en la vista de detalle. */
    private String descripcion;

    /**
     * Precio actual de venta.
     * CONTRATO CRÍTICO: Este es el campo que ms-pedidos lee para el snapshot de precio.
     * Representa el precio vigente al momento de la consulta.
     * No renombrar sin actualizar MenuItemClient en ms-pedidos y ms-carrito.
     */
    private BigDecimal precio;

    /** URL de la imagen del producto para renderizar en el catálogo y carrito. */
    private String imagenUrl;

    /**
     * Flag de disponibilidad.
     * ms-pedidos debe verificar que este campo sea `true` antes de crear el PedidoItem.
     * Si es `false`, lanzar ItemNoDisponibleException.
     */
    private Boolean disponible;

    /**
     * ID de la categoría a la que pertenece el ítem (FK lógica a ms-categorias).
     * El frontend puede usar este ID para agrupar ítems por categoría en el menú.
     */
    private Long categoriaId;

    /**
     * ID de la sucursal propietaria del ítem. Si es null, el ítem es global.
     * Útil para que el frontend filtre el menú según la sucursal seleccionada.
     */
    private Long sucursalId;

    /** Fecha de creación. Útil para ordenar por "novedades" en el menú. */
    private LocalDateTime creadoEn;

    /** Última actualización. Permite detectar cambios recientes de precio o disponibilidad. */
    private LocalDateTime actualizadoEn;
}
