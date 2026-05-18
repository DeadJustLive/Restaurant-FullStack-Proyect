package cl.triskeledu.reportes.listener;

import cl.triskeledu.reportes.dto.event.PagoEventDTO;
import cl.triskeledu.reportes.dto.event.PedidoEventDTO;
import cl.triskeledu.reportes.entity.ReporteSnapshot;
import cl.triskeledu.reportes.entity.enums.TipoReporte;
import cl.triskeledu.reportes.repository.ReporteSnapshotRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @use(reportes)
 * @kind(listener)
 * @contract(in: PedidoEventDTO, PagoEventDTO -> out: void)
 * @limit(lines: 80)
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class ReportEventListener {

    private final ReporteSnapshotRepository reporteSnapshotRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "pedido-events", groupId = "ms-reportes-group")
    @Transactional
    public void handlePedidoEvent(PedidoEventDTO event) {
        log.info("[Reportes] Evento pedido recibido: pedidoId={}, estado={}", event.getPedidoId(), event.getEstado());
        try {
            String dataJson = objectMapper.writeValueAsString(event);
            ReporteSnapshot snapshot = ReporteSnapshot.builder()
                    .tipo(TipoReporte.VENTAS_DIARIAS)
                    .dataJson(dataJson)
                    .build();
            reporteSnapshotRepository.save(snapshot);
            log.info("[Reportes] Snapshot de pedido guardado: id={}", snapshot.getId());
        } catch (Exception e) {
            log.error("[Reportes] Error procesando evento de pedido: {}", e.getMessage());
        }
    }

    @KafkaListener(topics = "pago-events", groupId = "ms-reportes-group")
    @Transactional
    public void handlePagoEvent(PagoEventDTO event) {
        log.info("[Reportes] Evento pago recibido: pagoId={}, estado={}", event.getPagoId(), event.getEstado());
        try {
            String dataJson = objectMapper.writeValueAsString(event);
            ReporteSnapshot snapshot = ReporteSnapshot.builder()
                    .tipo(TipoReporte.VENTAS_DIARIAS)
                    .dataJson(dataJson)
                    .build();
            reporteSnapshotRepository.save(snapshot);
            log.info("[Reportes] Snapshot de pago guardado: id={}", snapshot.getId());
        } catch (Exception e) {
            log.error("[Reportes] Error procesando evento de pago: {}", e.getMessage());
        }
    }
}