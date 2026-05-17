package cl.triskeledu.pagos.listener;

import cl.triskeledu.pagos.dto.event.PedidoEventDTO;
import cl.triskeledu.pagos.proyecciones.PedidoProyeccion;
import cl.triskeledu.pagos.repository.PedidoProyeccionRepository;
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

    @KafkaListener(topics = "pedido-events", groupId = "pagos-group")
    public void consumirEventoPedido(String mensajeJson) {
        try {
            // 1. Deserializar el JSON a DTO
            PedidoEventDTO evento = objectMapper.readValue(mensajeJson, PedidoEventDTO.class);
            
            // 2. Convertir a la Entidad de BD local
            PedidoProyeccion proyeccion = new PedidoProyeccion(
                    evento.getIdPedido(),
                    evento.getIdCliente(),
                    evento.getTotal(),
                    evento.getEstado()
            );
            
            // 3. Guardar en la BD de ms-pagos
            proyeccionRepository.save(proyeccion);
            log.info("Proyección de Pedido guardada en ms-pagos lista para ser cobrada. ID: {}, Total: {}", evento.getIdPedido(), evento.getTotal());
            
        } catch (Exception e) {
            log.error("Error procesando evento de Pedido en ms-pagos: {}", e.getMessage());
        }
    }
}