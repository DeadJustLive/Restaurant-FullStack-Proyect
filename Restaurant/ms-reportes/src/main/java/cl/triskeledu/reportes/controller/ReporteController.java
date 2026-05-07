package cl.triskeledu.reportes.controller;

import cl.triskeledu.reportes.dto.request.FiltroReporteDTO;
import cl.triskeledu.reportes.dto.response.ReporteSnapshotResponseDTO;
import cl.triskeledu.reportes.entity.enums.TipoReporte;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cl.triskeledu.reportes.service.ReporteService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * =============================================================================
 * CONTROLLER: ReporteController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/reportes")
@RequiredArgsConstructor
@Slf4j
public class ReporteController {

    private final ReporteService reporteService;

    @PostMapping("/generar")
    public ResponseEntity<ReporteSnapshotResponseDTO> generarReporte(@Valid @RequestBody FiltroReporteDTO filtro) {
        log.info("REST request to generate Reporte");
        return ResponseEntity.status(201).body(reporteService.generarReporteDinamico(filtro));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<ReporteSnapshotResponseDTO>> obtenerHistorial(@PathVariable TipoReporte tipo) {
        log.info("REST request to get Reporte history for tipo: {}", tipo);
        return ResponseEntity.ok(reporteService.obtenerHistorial(tipo));
    }
}
