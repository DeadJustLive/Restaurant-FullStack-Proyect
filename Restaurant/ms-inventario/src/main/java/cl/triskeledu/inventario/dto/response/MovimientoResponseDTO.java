package cl.triskeledu.inventario.dto.response;

import cl.triskeledu.inventario.entity.enums.TipoMovimiento;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * =============================================================================
 * DTO RESPONSE: MovimientoResponseDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoResponseDTO {

    private Long id;
    private Long insumoId;
    private TipoMovimiento tipo;
    private BigDecimal cantidad;
    private String referencia;
    private LocalDateTime creadoEn;
}
