package cl.triskeledu.reportes.dto.response;

import cl.triskeledu.reportes.entity.enums.TipoReporte;
import lombok.*;

import java.time.LocalDateTime;

/**
 * =============================================================================
 * DTO RESPONSE: ReporteSnapshotResponseDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReporteSnapshotResponseDTO {

    private Long id;
    private Long sucursalId;
    private TipoReporte tipo;
    private Object dataJson; // Puede serializarse genéricamente
    private LocalDateTime creadoEn;
}
