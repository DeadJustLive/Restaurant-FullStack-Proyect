package cl.triskeledu.pedidos.dto.response;

import cl.triskeledu.pedidos.entity.enums.EstadoPedido;
import cl.triskeledu.pedidos.entity.enums.TipoPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * =============================================================================
 * DTO RESPONSE: PedidoResponseDTO
 * =============================================================================
 *
 * PROPÓSITO:
 *   Objeto de transferencia para la respuesta de la API REST hacia el cliente.
 *   Representa la vista pública de un Pedido, omitiendo detalles internos
 *   y sensibles de la entidad JPA.
 *
 * FLUJO DE DATOS:
 *   Pedido (entity) → [PedidoMapper.toResponseDTO()] → PedidoResponseDTO
 *   → [Jackson serializa] → JSON response al cliente
 *
 * CAMPOS OMITIDOS INTENCIONALMENTE:
 *   Ningún campo de la entidad que sea estrictamente interno (como relaciones
 *   Hibernate sin inicializar) se incluye directamente.
 *   Los items se mapean a PedidoItemResponseDTO para evitar exposición de la entidad.
 *
 * CAMPOS INCLUIDOS:
 *   Todos los necesarios para que el frontend pueda:
 *   1. Mostrar el detalle completo del pedido.
 *   2. Tomar decisiones de UI según el estado y tipo.
 *   3. Mostrar el historial con información legible.
 *
 * USO POR ROL:
 *   - CLIENTE: ve sus pedidos propios con este DTO.
 *   - COCINERO: ve la lista de pedidos de su sucursal.
 *   - REPARTIDOR: ve los pedidos asignados en estado LISTO/EN_CAMINO.
 *   - ADMIN/SUPER_ADMIN: ve todos los pedidos.
 *
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponseDTO {

    /** ID único del pedido. Expuesto para referencias cruzadas con ms-pagos y ms-delivery. */
    private Long id;

    /** Código de negocio legible. Usado en notificaciones y pantallas de seguimiento. */
    private String numeroPedido;

    /** ID del usuario propietario. El frontend puede consultar ms-usuarios para nombre/email. */
    private Long usuarioId;

    /** ID de la sucursal. El frontend puede consultar ms-sucursales para nombre/dirección. */
    private Long sucursalId;

    /** Estado actual. El frontend renderiza UI diferente según el estado (badge de color, acciones). */
    private EstadoPedido estado;

    /** Tipo de pedido. Determina si el frontend muestra la sección de tracking de delivery. */
    private TipoPedido tipo;

    /** Total calculado. Siempre reflejará la suma real de los ítems al momento de la creación. */
    private BigDecimal total;

    /** Instrucciones especiales. Mostrar en la vista del cocinero y del repartidor. */
    private String notas;

    /** Lista de ítems mapeada a su propio DTO de response. Nunca exponer PedidoItem directamente. */
    private List<PedidoItemResponseDTO> items;

    /** Fecha de creación. Útil para ordenar historial y mostrar "Pedido realizado el DD/MM/YYYY HH:mm". */
    private LocalDateTime creadoEn;

    /** Fecha de última actualización. Útil para mostrar "Última actualización: hace X minutos". */
    private LocalDateTime actualizadoEn;
}
