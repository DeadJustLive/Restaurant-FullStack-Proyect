package cl.triskeledu.reportes.dto.request;

import cl.triskeledu.reportes.entity.enums.TipoReporte;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

/**
 * =============================================================================
 * DTO REQUEST: FiltroReporteDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiltroReporteDTO {

    @NotNull(message = "El tipo de reporte es obligatorio")
    private TipoReporte tipo;

    private Long sucursalId; // Opcional para reportes globales

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDate fechaFin;
}
