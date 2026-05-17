package cl.triskeledu.pedidos.listener;

import cl.triskeledu.pedidos.dto.event.MenuItemEventDTO;
import cl.triskeledu.pedidos.proyecciones.MenuItemProyeccion;
import cl.triskeledu.pedidos.repository.MenuItemProyeccionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MenuItemEventListener {

    private final MenuItemProyeccionRepository proyeccionRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "menu-item-events", groupId = "pedidos-group")
    public void consumirEventoMenuItem(String mensajeJson) {
        try {
            MenuItemEventDTO evento = objectMapper.readValue(mensajeJson, MenuItemEventDTO.class);
            
            MenuItemProyeccion proyeccion = new MenuItemProyeccion(
                    evento.getId(),
                    evento.getNombre(),
                    evento.getPrecio(),
                    evento.isDisponible()
            );
            
            proyeccionRepository.save(proyeccion);
            log.info("Proyección de MenuItem guardada en ms-pedidos. ID: {}, Precio: {}", evento.getId(), evento.getPrecio());
            
        } catch (Exception e) {
            log.error("Error procesando evento de MenuItem en ms-pedidos: {}", e.getMessage());
        }
    }
}