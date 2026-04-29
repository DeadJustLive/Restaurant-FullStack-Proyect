package cl.triskeledu.pedidos.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * =============================================================================
 * DTO LOCAL: MenuItemClientResponseDTO (en ms-pedidos)
 * =============================================================================
 *
 * PROPÓSITO:
 *   DTO local de ms-pedidos que representa la respuesta mínima necesaria
 *   al consultar un ítem en ms-menu vía MenuItemClient (Feign).
 *
 * DISEÑO INTENCIONAL — DTO PROPIO VS. COMPARTIDO:
 *   ❌ Anti-patrón: compartir el DTO de response de ms-menu directamente en ms-pedidos
 *      (acoplamiento fuerte — cualquier cambio en ms-menu rompe ms-pedidos).
 *   ✅ Patrón correcto: definir un DTO local con SOLO los campos que ms-pedidos necesita.
 *      Si ms-menu agrega campos nuevos a su response, ms-pedidos no se ve afectado.
 *      Si ms-menu elimina un campo que ms-pedidos usa, Jackson lo mapeará como null
 *      y ms-pedidos detectará el problema con sus propias validaciones.
 *
 * CAMPOS NECESARIOS PARA EL SNAPSHOT:
 *   - nombre:     capturado en PedidoItem.nombreSnapshot.
 *   - precio:     capturado en PedidoItem.precioUnitario.
 *   - disponible: validado antes de crear el PedidoItem.
 *
 * CONFIGURACIÓN JACKSON:
 *   Jackson usa @JsonIgnoreProperties(ignoreUnknown = true) por defecto en Feign.
 *   Los campos extra del response de ms-menu (descripcion, imagenUrl, etc.)
 *   son ignorados automáticamente en la deserialización.
 *
 * =============================================================================
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemClientResponseDTO {

    /** ID del producto. Usado para correlacionar con la request y poblar menuItemId en PedidoItem. */
    private Long id;

    /**
     * Nombre del producto al momento de la consulta.
     * Se copia a PedidoItem.nombreSnapshot — congelado como snapshot histórico.
     * Si este campo es null (campo eliminado en ms-menu), el Service debe lanzar excepción.
     */
    private String nombre;

    /**
     * Precio de venta actual del producto.
     * Se copia a PedidoItem.precioUnitario — snapshot que NO cambiará aunque ms-menu actualice el precio.
     * Crítico: este valor se usa para calcular PedidoItem.subtotal y Pedido.total.
     */
    private BigDecimal precio;

    /**
     * Flag de disponibilidad.
     * PedidoServiceImpl verifica que disponible == true antes de crear el PedidoItem.
     * Si es false: lanzar ItemNoDisponibleException con el nombre del ítem.
     */
    private Boolean disponible;
}
