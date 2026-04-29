package cl.triskeledu.reportes.service.impl;

import cl.triskeledu.reportes.dto.request.FiltroReporteDTO;
import cl.triskeledu.reportes.dto.response.ReporteSnapshotResponseDTO;
import cl.triskeledu.reportes.service.ReporteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * =============================================================================
 * SERVICE IMPL: ReporteServiceImpl
 * =============================================================================
 */
@Service
@Slf4j
public class ReporteServiceImpl implements ReporteService {

    @Override
    public ReporteSnapshotResponseDTO generarReporteDinamico(FiltroReporteDTO filtro) {
        /*
         * INTENCIÓN: API Composition. Generar consolidado leyendo de otros MS.
         *
         * FLUJO ESPERADO:
         *   1. Identificar TipoReporte.
         *   2. Realizar múltiples llamadas Feign en paralelo o secuenciales:
         *      - ms-pedidos (Ventas)
         *      - ms-inventario (Kardex, Consumo)
         *      - ms-pagos (Rechazos vs Aprobados)
         *   3. Agregar y formatear los datos (ej. Map, DTO consolidado).
         *   4. Serializar el resultado final como JSON String.
         *   5. Guardar el nuevo ReporteSnapshot en BD.
         *   Output: ReporteSnapshotResponseDTO.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public List<ReporteSnapshotResponseDTO> obtenerHistorial(cl.triskeledu.reportes.entity.enums.TipoReporte tipo) {
        /*
         * INTENCIÓN: Consultar reportes ya pre-calculados (rápido).
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }
}
