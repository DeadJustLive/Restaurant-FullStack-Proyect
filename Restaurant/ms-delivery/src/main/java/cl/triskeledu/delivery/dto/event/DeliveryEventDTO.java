package cl.triskeledu.delivery.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @use(delivery)
 * @kind(type)
 * @limit(lines: 30)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryEventDTO {
    private Long deliveryId;
    private Long pedidoId;
    private String estado;
    private Long repartidorId;
}