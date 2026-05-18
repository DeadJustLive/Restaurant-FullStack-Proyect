package cl.triskeledu.notificaciones.listener;

import cl.triskeledu.notificaciones.dto.event.DeliveryEventDTO;
import cl.triskeledu.notificaciones.dto.event.PedidoEventDTO;
import cl.triskeledu.notificaciones.entity.Notificacion;
import cl.triskeledu.notificaciones.entity.enums.EstadoNotificacion;
import cl.triskeledu.notificaciones.entity.enums.TipoNotificacion;
import cl.triskeledu.notificaciones.repository.NotificacionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @use(notificaciones)
 * @kind(listener)
 * @contract(in: PedidoEventDTO, DeliveryEventDTO -> out: void)
 * @limit(lines: 80)
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationEventListener {

    private final NotificacionRepository notificacionRepository;

    @KafkaListener(topics = "pedido-events", groupId = "ms-notificaciones-group")
    @Transactional
    public void handlePedidoEvent(PedidoEventDTO event) {
        log.info("[Notificaciones] Evento pedido: id={}, estado={}", event.getPedidoId(), event.getEstado());

        String asunto = "Pedido " + event.getEstado().toLowerCase();
        String cuerpo = "Su pedido #" + event.getPedidoId() + " ha cambiado a estado: " + event.getEstado();

        Notificacion notificacion = Notificacion.builder()
                .destinatario(String.valueOf(event.getUsuarioId()))
                .asunto(asunto)
                .cuerpo(cuerpo)
                .tipo(TipoNotificacion.PUSH)
                .estado(EstadoNotificacion.PENDIENTE)
                .build();

        notificacionRepository.save(notificacion);
        log.info("[Notificaciones] Notificacion creada para pedido {} estado {}", event.getPedidoId(), event.getEstado());
    }

    @KafkaListener(topics = "delivery-events", groupId = "ms-notificaciones-group")
    @Transactional
    public void handleDeliveryEvent(DeliveryEventDTO event) {
        log.info("[Notificaciones] Evento delivery: id={}, estado={}", event.getDeliveryId(), event.getEstado());

        String asunto = "Delivery " + event.getEstado().toLowerCase();
        String cuerpo = "Delivery #" + event.getDeliveryId() + " ha cambiado a estado: " + event.getEstado();

        Notificacion notificacion = Notificacion.builder()
                .destinatario(String.valueOf(event.getRepartidorId()))
                .asunto(asunto)
                .cuerpo(cuerpo)
                .tipo(TipoNotificacion.PUSH)
                .estado(EstadoNotificacion.PENDIENTE)
                .build();

        notificacionRepository.save(notificacion);
        log.info("[Notificaciones] Notificacion creada para delivery {} estado {}", event.getDeliveryId(), event.getEstado());
    }
}