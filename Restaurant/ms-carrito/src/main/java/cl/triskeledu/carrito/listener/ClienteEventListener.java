package cl.triskeledu.carrito.listener;

import cl.triskeledu.carrito.dto.event.ClienteEventDTO;
import cl.triskeledu.carrito.proyecciones.ClienteProyeccion;
import cl.triskeledu.carrito.repository.ClienteProyeccionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ClienteEventListener {

    private final ClienteProyeccionRepository proyeccionRepository;
    private final ObjectMapper objectMapper;

    // Asumiendo que ms-auth o ms-usuarios publica en "usuario-events"
    @KafkaListener(topics = "usuario-events", groupId = "carrito-group")
    public void consumirEventoCliente(String mensajeJson) {
        try {
            ClienteEventDTO evento = objectMapper.readValue(mensajeJson, ClienteEventDTO.class);
            
            ClienteProyeccion proyeccion = new ClienteProyeccion(
                    evento.getId(),
                    evento.getNombre(),
                    evento.getEmail()
            );
            
            proyeccionRepository.save(proyeccion);
            log.info("✅ Proyección de Cliente guardada en ms-carrito. ID: {}", evento.getId());
            
        } catch (Exception e) {
            log.error("❌ Error procesando evento de Cliente en ms-carrito: {}", e.getMessage());
        }
    }
}