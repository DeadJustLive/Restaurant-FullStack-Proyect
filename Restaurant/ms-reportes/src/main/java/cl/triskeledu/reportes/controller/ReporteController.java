package cl.triskeledu.reportes.controller;

import cl.triskeledu.reportes.dto.request.FiltroReporteDTO;
import cl.triskeledu.reportes.dto.response.ReporteSnapshotResponseDTO;
import cl.triskeledu.reportes.entity.enums.TipoReporte;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =============================================================================
 * CONTROLLER: ReporteController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/reportes")
@Slf4j
public class ReporteController {

    @PostMapping("/generar")
    public ResponseEntity<ReporteSnapshotResponseDTO> generarReporte(@Valid @RequestBody FiltroReporteDTO filtro) {
        /*
         * INTENCIÓN: Disparar cálculo pesado sincrónicamente.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<ReporteSnapshotResponseDTO>> obtenerHistorial(@PathVariable TipoReporte tipo) {
        /*
         * INTENCIÓN: Leer snapshots para dashboards rápidos.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }
}
