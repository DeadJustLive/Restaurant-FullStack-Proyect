package cl.triskeledu.delivery.dto.response;

import cl.triskeledu.delivery.entity.enums.EstadoDelivery;
import lombok.*;

import java.time.LocalDateTime;

/**
 * =============================================================================
 * DTO RESPONSE: DeliveryResponseDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryResponseDTO {

    private Long id;
    private Long pedidoId;
    private Long repartidorId;
    private String direccionEntrega;
    private EstadoDelivery estado;
    private String observaciones;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
}
