package cl.triskeledu.carrito.proyecciones;

import cl.triskeledu.carrito.dto.event.MenuItemEventDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuItemKafkaListener {

    private final MenuItemProyeccionRepository repository;
    @KafkaListener(topics = "topico-menu", groupId = "ms-carrito-group")
    public void escucharCambiosMenu(MenuItemEventDTO evento) {
        log.info("Recibido evento de menú desde Kafka: Producto ID {}", evento.getId());

        MenuItemProyeccion producto = MenuItemProyeccion.builder()
                .id(evento.getId())
                .nombre(evento.getNombre())
                .precio(evento.getPrecio())
                .disponible(evento.isDisponible())
                .build();

        //si el ID no existe en menu_proyeccion, hace un INSERT.
        //si el ya existe hace un UPDATE.
        repository.save(producto);
        
        log.info("Proyección de menú actualizada con éxito en Carrito.");
    }
}