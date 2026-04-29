package cl.triskeledu.reportes.service;

import cl.triskeledu.reportes.dto.request.FiltroReporteDTO;
import cl.triskeledu.reportes.dto.response.ReporteSnapshotResponseDTO;

import java.util.List;

/**
 * =============================================================================
 * SERVICE INTERFACE: ReporteService
 * =============================================================================
 */
public interface ReporteService {

    ReporteSnapshotResponseDTO generarReporteDinamico(FiltroReporteDTO filtro);

    List<ReporteSnapshotResponseDTO> obtenerHistorial(cl.triskeledu.reportes.entity.enums.TipoReporte tipo);
}
