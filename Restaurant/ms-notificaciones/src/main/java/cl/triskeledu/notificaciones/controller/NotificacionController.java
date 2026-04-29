package cl.triskeledu.notificaciones.controller;

import cl.triskeledu.notificaciones.dto.request.NotificacionRequestDTO;
import cl.triskeledu.notificaciones.dto.response.NotificacionResponseDTO;
import cl.triskeledu.notificaciones.entity.enums.EstadoNotificacion;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =============================================================================
 * CONTROLLER: NotificacionController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/notificaciones")
@Slf4j
public class NotificacionController {

    @PostMapping
    public ResponseEntity<NotificacionResponseDTO> enviarNotificacion(@Valid @RequestBody NotificacionRequestDTO dto) {
        /*
         * INTENCIÓN: Invocado por ms-pagos, ms-delivery, ms-inventario.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionResponseDTO> getById(@PathVariable Long id) {
        /*
         * INTENCIÓN: Ver detalle de envío.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<NotificacionResponseDTO>> listarPorEstado(@PathVariable EstadoNotificacion estado) {
        /*
         * INTENCIÓN: Para monitor de fallos.
         */
        throw new UnsupportedOperationException("Scaffolding: Controlador pendiente de implementación.");
    }
}
