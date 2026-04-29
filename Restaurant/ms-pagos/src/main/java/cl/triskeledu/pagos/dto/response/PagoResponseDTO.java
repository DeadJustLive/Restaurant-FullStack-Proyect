package cl.triskeledu.pagos.dto.response;

import cl.triskeledu.pagos.entity.enums.EstadoPago;
import cl.triskeledu.pagos.entity.enums.MetodoPago;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * =============================================================================
 * DTO RESPONSE: PagoResponseDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagoResponseDTO {

    private Long id;
    private Long pedidoId;
    private BigDecimal monto;
    private MetodoPago metodo;
    private EstadoPago estado;
    private String transaccionId;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
}
