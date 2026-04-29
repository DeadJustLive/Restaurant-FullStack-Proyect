package cl.triskeledu.pedidos.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * =============================================================================
 * DTO REQUEST: PedidoItemRequestDTO
 * =============================================================================
 *
 * PROPÓSITO:
 *   Representa un ítem individual dentro del payload de creación de pedido.
 *   Es un DTO anidado dentro de PedidoRequestDTO.
 *
 * FLUJO DE DATOS:
 *   Cliente envía: { menuItemId: 5, cantidad: 2 }
 *   → PedidoService consulta ms-menu con menuItemId=5
 *   → Recibe: { nombre: "Hamburguesa Clásica", precio: 8990 }
 *   → Crea PedidoItem con snapshot del nombre y precio actual
 *   → Calcula subtotal = 8990 * 2 = 17980
 *
 * CAMPOS EXCLUIDOS INTENCIONALMENTE:
 *   - `precioUnitario`: obtenido de ms-menu, nunca del cliente (seguridad).
 *   - `nombreSnapshot`: obtenido de ms-menu, nunca del cliente.
 *   - `subtotal`: calculado por el Service, nunca del cliente.
 *
 * SEGURIDAD CRÍTICA:
 *   Solo se acepta `menuItemId` y `cantidad` del cliente.
 *   Cualquier campo de precio enviado por el cliente debe ser IGNORADO.
 *   La validación de precio ocurre exclusivamente en PedidoServiceImpl
 *   mediante la consulta a MenuItemClient.
 *
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoItemRequestDTO {

    /**
     * CAMPO: menuItemId
     * Tipo: Long
     * Rol: ID del producto en ms-menu que el cliente desea ordenar.
     *      El Service usará MenuItemClient.getById(menuItemId) para obtener
     *      nombre y precio actuales al momento del pedido.
     * Validación: No nulo. El Service validará existencia en ms-menu.
     * TODO: Si ms-menu retorna 404 para este ID, lanzar ItemNoDisponibleException.
     */
    @NotNull(message = "El ID del ítem de menú es obligatorio")
    private Long menuItemId;

    /**
     * CAMPO: cantidad
     * Tipo: Integer
     * Rol: Número de unidades que el cliente desea del producto indicado.
     *      Mínimo 1. El Service puede definir un máximo configurable por ítem.
     * Validación: No nulo, mínimo 1.
     * TODO: Validar stock disponible en ms-inventario antes de confirmar el pedido.
     *       Si el stock es insuficiente, lanzar StockInsuficienteException.
     */
    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad mínima por ítem es 1")
    private Integer cantidad;
}
