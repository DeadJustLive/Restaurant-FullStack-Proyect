package cl.triskeledu.inventario.listener;

import cl.triskeledu.inventario.dto.event.PedidoEventDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @use(inventario)
 * @kind(listener)
 * @contract(in: PedidoEventDTO -> out: void)
 * @limit(lines: 80)
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class PedidoEventListener {

    @KafkaListener(topics = "pedido-events", groupId = "ms-inventario-group")
    public void handlePedidoEvent(PedidoEventDTO event) {
        log.info("[Inventario] Evento pedido recibido: pedidoId={}, estado={}", event.getPedidoId(), event.getEstado());
    }
}