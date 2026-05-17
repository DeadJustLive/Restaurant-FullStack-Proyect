package cl.triskeledu.pedidos.listener;

import cl.triskeledu.pedidos.dto.event.SucursalEventDTO;
import cl.triskeledu.pedidos.proyecciones.SucursalProyeccion;
import cl.triskeledu.pedidos.repository.SucursalProyeccionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SucursalEventListener {

    private final SucursalProyeccionRepository proyeccionRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "sucursal-events", groupId = "pedidos-group")
    public void consumirEventoSucursal(String mensajeJson) {
        try {
            SucursalEventDTO evento = objectMapper.readValue(mensajeJson, SucursalEventDTO.class);
            
            SucursalProyeccion proyeccion = new SucursalProyeccion(
                    evento.getId(),
                    evento.getNombre(),
                    evento.isActiva()
            );
            
            proyeccionRepository.save(proyeccion);
            log.info("Proyección de Sucursal guardada en ms-pedidos. ID: {}", evento.getId());
            
        } catch (Exception e) {
            log.error("Error procesando evento de Sucursal en ms-pedidos: {}", e.getMessage());
        }
    }
}