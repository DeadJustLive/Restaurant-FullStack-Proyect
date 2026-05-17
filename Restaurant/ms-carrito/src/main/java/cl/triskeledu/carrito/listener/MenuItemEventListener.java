package cl.triskeledu.carrito.listener;

import cl.triskeledu.carrito.dto.event.MenuItemEventDTO;
import cl.triskeledu.carrito.proyecciones.MenuItemProyeccion;
import cl.triskeledu.carrito.repository.MenuItemProyeccionRepository;
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

    @KafkaListener(topics = "menu-item-events", groupId = "carrito-group")
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
            log.info("✅ Proyección de MenuItem guardada en ms-carrito. Listo para cotizar. ID: {}", evento.getId());
            
        } catch (Exception e) {
            log.error("❌ Error procesando evento de MenuItem en ms-carrito: {}", e.getMessage());
        }
    }
}