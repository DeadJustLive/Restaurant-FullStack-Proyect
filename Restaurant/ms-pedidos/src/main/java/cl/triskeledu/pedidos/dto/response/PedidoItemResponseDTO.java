package cl.triskeledu.pedidos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * =============================================================================
 * DTO RESPONSE: PedidoItemResponseDTO
 * =============================================================================
 *
 * PROPÓSITO:
 *   Representa la vista pública de un ítem dentro del PedidoResponseDTO.
 *   Expone los datos del snapshot histórico: nombre y precio al momento de compra.
 *
 * FLUJO DE DATOS:
 *   PedidoItem (entity) → [PedidoMapper.toItemResponseDTO()] → PedidoItemResponseDTO
 *   → Incluido en PedidoResponseDTO.items → JSON response
 *
 * IMPORTANCIA DEL SNAPSHOT:
 *   Los campos `nombreSnapshot` y `precioUnitario` reflejan los valores
 *   HISTÓRICOS al momento de la compra. Si ms-menu cambia precios, este
 *   DTO siempre mostrará lo que el cliente efectivamente pagó.
 *
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoItemResponseDTO {

    /** ID del ítem en esta BD. Útil para referencias internas. */
    private Long id;

    /**
     * ID del producto en ms-menu. Expuesto para que el frontend pueda
     * enriquecer la vista con imagen o descripción actual del producto
     * (aunque el precio mostrado siempre sea el del snapshot).
     */
    private Long menuItemId;

    /**
     * Nombre del producto al momento de la compra (snapshot histórico).
     * Mostrar este valor en el detalle del pedido y en el ticket de compra.
     * NO sincronizar con el nombre actual en ms-menu.
     */
    private String nombreSnapshot;

    /**
     * Precio unitario al momento de la compra (snapshot histórico).
     * Crítico para la integridad financiera del historial de pedidos.
     */
    private BigDecimal precioUnitario;

    /** Cantidad de unidades ordenadas de este ítem. */
    private Integer cantidad;

    /**
     * Subtotal = precioUnitario * cantidad.
     * Pre-calculado y almacenado para eficiencia en consultas de historial.
     */
    private BigDecimal subtotal;
}
