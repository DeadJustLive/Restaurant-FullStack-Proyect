package cl.triskeledu.pedidos.entity.enums;

/**
 * =============================================================================
 * ENUM: EstadoPedido
 * =============================================================================
 *
 * PROPÓSITO:
 *   Representa los estados posibles en el ciclo de vida de un pedido.
 *   Actúa como la fuente de verdad de la máquina de estados del dominio.
 *
 * REGLA DE NEGOCIO CRÍTICA:
 *   Las transiciones de estado son UNIDIRECCIONALES y RESTRINGIDAS.
 *   Solo el PedidoServiceImpl puede invocar cambios de estado, nunca
 *   el Controller directamente ni el cliente externo.
 *
 * TRANSICIONES PERMITIDAS:
 *   PENDIENTE       → CONFIRMADO  (tras pago exitoso desde ms-pagos)
 *   CONFIRMADO      → EN_PREPARACION (cocinero toma el pedido)
 *   EN_PREPARACION  → LISTO       (cocinero termina)
 *   LISTO           → EN_CAMINO   (solo si tipo == DELIVERY)
 *   LISTO           → ENTREGADO   (si tipo == EN_LOCAL)
 *   EN_CAMINO       → ENTREGADO   (repartidor confirma entrega)
 *   PENDIENTE       → CANCELADO   (cliente o admin)
 *   CONFIRMADO      → CANCELADO   (solo admin, con lógica de reembolso)
 *
 * RIESGO DE MODIFICACIÓN:
 *   CRÍTICO. Agregar o renombrar un valor rompe los registros históricos
 *   en la BD (columna VARCHAR) y las comparaciones en el service.
 *   Si se necesita agregar un estado, añadir AL FINAL de la lista.
 *
 * MAPEADO EN BD:
 *   Persistido como STRING mediante @Enumerated(EnumType.STRING).
 *   NO usar EnumType.ORDINAL: frágil ante reordenamientos.
 *
 * =============================================================================
 */
public enum EstadoPedido {

    /**
     * Estado inicial. El pedido fue creado pero el pago aún no fue procesado.
     * Visible en frontend para el CLIENTE como "Esperando confirmación de pago".
     */
    PENDIENTE,

    /**
     * El pago fue aprobado por ms-pagos. El pedido entra a la cola de cocina.
     * En este punto ms-inventario ya descontó el stock.
     */
    CONFIRMADO,

    /**
     * Un COCINERO tomó el pedido desde la vista KDS (Kitchen Display System).
     * Se notifica al CLIENTE via ms-notificaciones.
     */
    EN_PREPARACION,

    /**
     * La cocina finalizó la preparación.
     * Si tipo == EN_LOCAL → transición directa a ENTREGADO.
     * Si tipo == DELIVERY → transición a EN_CAMINO (ms-delivery asigna repartidor).
     */
    LISTO,

    /**
     * El repartidor recogió el pedido y está en camino. Solo aplica tipo DELIVERY.
     * ms-delivery maneja el tracking de geolocalización en su propio dominio.
     */
    EN_CAMINO,

    /**
     * Estado terminal exitoso. El pedido llegó al cliente.
     * Se dispara evento a ms-reportes y ms-notificaciones.
     * NO modificable una vez alcanzado.
     */
    ENTREGADO,

    /**
     * Estado terminal negativo. Solo accesible desde PENDIENTE o CONFIRMADO.
     * Si se cancela desde CONFIRMADO, debe generarse solicitud de reembolso en ms-pagos.
     * TODO: Implementar compensación de stock en ms-inventario al cancelar.
     */
    CANCELADO
}
