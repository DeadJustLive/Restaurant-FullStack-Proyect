// En ms-carrito: src/main/java/cl/triskeledu/carrito/listener/ClienteKafkaListener.java
package cl.triskeledu.carrito.service;

import cl.triskeledu.carrito.proyecciones.ClienteProyeccion;
import cl.triskeledu.carrito.repository.ClienteProyeccionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

// Importante: Esta clase es un DTO temporal solo para recibir los datos en Carrito.
// Puedes crear una clase igual a AuthEventDTO dentro de ms-carrito/dto para mapearlo.
import cl.triskeledu.carrito.dto.event.AuthEventDTO; 

@Component
@RequiredArgsConstructor
@Slf4j
public class ClienteKafkaListener {

    private final ClienteProyeccionRepository repository;

    // Sintonizamos la frecuencia "topico-usuarios"
    @KafkaListener(topics = "topico-usuarios", groupId = "ms-carrito-group")
    public void escucharCambiosUsuario(AuthEventDTO evento) {
        log.info("Recibido evento de usuario desde Kafka: ID {}", evento.getId());

        ClienteProyeccion cliente = new ClienteProyeccion();
        cliente.setId(evento.getId());
        // Juntamos nombre y apellido porque a Carrito solo le importa el nombre completo
        cliente.setNombreCompleto(evento.getNombre() + " " + evento.getApellido());

        // Si el ID no existe hace INSERT
        // Si sí, hace UPDATE
        repository.save(cliente);
        
        log.info("Proyección de cliente actualizada en Carrito para el ID {}", evento.getId());
    }
}