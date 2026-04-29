package cl.triskeledu.pedidos.entity.enums;

/**
 * =============================================================================
 * ENUM: TipoPedido
 * =============================================================================
 *
 * PROPÓSITO:
 *   Clasifica el pedido según la modalidad de entrega. Este valor es INMUTABLE
 *   una vez que el pedido es creado. No debe modificarse durante el ciclo de vida.
 *
 * IMPACTO EN EL FLUJO:
 *   - DELIVERY:  Activa la integración con ms-delivery cuando el estado llega a LISTO.
 *                El pedido incluye dirección de entrega en el DTO de request.
 *   - EN_LOCAL:  El cliente está físicamente en la sucursal. No hay dirección de entrega.
 *                Cuando estado == LISTO, se transiciona directamente a ENTREGADO.
 *
 * IMPACTO EN FRONTEND:
 *   - Determina si se muestra el campo "Dirección de entrega" en el formulario de checkout.
 *   - Determina si el CLIENTE puede ver la sección de tracking del repartidor.
 *
 * RIESGO DE MODIFICACIÓN:
 *   ALTO. Cambiar el nombre de un valor sin migración de datos dejará registros
 *   históricos con valores inconsistentes en la columna `tipo` de la BD.
 *
 * =============================================================================
 */
public enum TipoPedido {

    /**
     * El pedido debe ser enviado a una dirección física.
     * Requiere: dirección de entrega en PedidoRequestDTO.
     * Activa: integración con ms-delivery al llegar a estado LISTO.
     */
    DELIVERY,

    /**
     * El cliente consume en el local. No requiere dirección.
     * Puede incluir número de mesa en el campo `notas` del pedido.
     * Al llegar a LISTO, el estado cambia a ENTREGADO automáticamente.
     */
    EN_LOCAL
}
