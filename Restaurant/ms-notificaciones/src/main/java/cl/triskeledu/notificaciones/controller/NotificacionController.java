package cl.triskeledu.notificaciones.controller;

import cl.triskeledu.notificaciones.dto.request.NotificacionRequestDTO;
import cl.triskeledu.notificaciones.dto.response.NotificacionResponseDTO;
import cl.triskeledu.notificaciones.entity.enums.EstadoNotificacion;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cl.triskeledu.notificaciones.service.NotificacionService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * =============================================================================
 * CONTROLLER: NotificacionController
 * =============================================================================
 */
@RestController
@RequestMapping("/api/v1/notificaciones")
@RequiredArgsConstructor
@Slf4j
public class NotificacionController {

    private final NotificacionService notificacionService;

    @PostMapping
    public ResponseEntity<NotificacionResponseDTO> enviarNotificacion(@Valid @RequestBody NotificacionRequestDTO dto) {
        log.info("REST request to send Notificacion");
        return ResponseEntity.status(201).body(notificacionService.enviarNotificacion(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionResponseDTO> getById(@PathVariable Long id) {
        log.info("REST request to get Notificacion : {}", id);
        return ResponseEntity.ok(notificacionService.getById(id));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<NotificacionResponseDTO>> listarPorEstado(@PathVariable EstadoNotificacion estado) {
        log.info("REST request to list Notificaciones by estado: {}", estado);
        return ResponseEntity.ok(notificacionService.listarPorEstado(estado));
    }
}
