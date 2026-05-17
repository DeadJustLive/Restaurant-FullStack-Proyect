package cl.triskeledu.delivery.listener;

import cl.triskeledu.delivery.dto.event.PedidoEventDTO;
import cl.triskeledu.delivery.proyecciones.PedidoProyeccion;
import cl.triskeledu.delivery.repository.PedidoProyeccionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PedidoEventListener {

    private final PedidoProyeccionRepository proyeccionRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "pedido-events", groupId = "delivery-group")
    public void consumirEventoPedido(String mensajeJson) {
        try {
            // 1. Convertir el JSON que llega de Kafka al DTO
            PedidoEventDTO evento = objectMapper.readValue(mensajeJson, PedidoEventDTO.class);
            
            // 2. Mapear el DTO a la Entidad de Proyección
            PedidoProyeccion proyeccion = new PedidoProyeccion(
                    evento.getIdPedido(),
                    evento.getIdCliente(),
                    evento.getIdSucursal(),
                    evento.getEstado(),
                    evento.getDireccionEntrega()
            );
            
            // 3. Guardar/Actualizar en la base de datos local de ms-delivery
            proyeccionRepository.save(proyeccion);
            log.info("proyección de Pedido guardada exitosamente. ID: {}", evento.getIdPedido());
            
        } catch (Exception e) {
            log.error("Error procesando evento de Kafka en ms-delivery: {}", e.getMessage());
        }
    }
}