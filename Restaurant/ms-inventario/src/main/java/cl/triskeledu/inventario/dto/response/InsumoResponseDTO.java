package cl.triskeledu.inventario.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * =============================================================================
 * DTO RESPONSE: InsumoResponseDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsumoResponseDTO {

    private Long id;
    private Long sucursalId;
    private String nombre;
    private String unidadMedida;
    private BigDecimal stockActual;
    private BigDecimal stockMinimo;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
}
