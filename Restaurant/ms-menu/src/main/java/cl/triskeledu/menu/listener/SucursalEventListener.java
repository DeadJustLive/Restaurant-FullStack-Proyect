package cl.triskeledu.menu.listener;

import cl.triskeledu.menu.dto.event.SucursalEventDTO;
import cl.triskeledu.menu.proyecciones.SucursalProyeccion;
import cl.triskeledu.menu.repository.SucursalProyeccionRepository;
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

    @KafkaListener(topics = "sucursal-events", groupId = "menu-group")
    public void consumirEventoSucursal(String mensajeJson) {
        try {
            // 1. Deserializar el JSON a DTO
            SucursalEventDTO evento = objectMapper.readValue(mensajeJson, SucursalEventDTO.class);
            
            // 2. Convertir a la Entidad de BD local
            SucursalProyeccion proyeccion = new SucursalProyeccion(
                    evento.getId(),
                    evento.getNombre(),
                    evento.getDireccion(),
                    evento.isActiva()
            );
            
            // 3. Guardar en la BD de ms-menu
            proyeccionRepository.save(proyeccion);
            log.info("✅ Proyección de Sucursal guardada en ms-menu. ID: {}", evento.getId());
            
        } catch (Exception e) {
            log.error("❌ Error procesando evento de Sucursal en ms-menu: {}", e.getMessage());
        }
    }
}