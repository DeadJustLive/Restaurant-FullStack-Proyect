package cl.triskeledu.notificaciones.service;

import cl.triskeledu.notificaciones.dto.request.NotificacionRequestDTO;
import cl.triskeledu.notificaciones.dto.response.NotificacionResponseDTO;
import cl.triskeledu.notificaciones.entity.enums.EstadoNotificacion;

import java.util.List;

/**
 * =============================================================================
 * SERVICE INTERFACE: NotificacionService
 * =============================================================================
 */
public interface NotificacionService {

    NotificacionResponseDTO enviarNotificacion(NotificacionRequestDTO dto);

    NotificacionResponseDTO getById(Long id);

    List<NotificacionResponseDTO> listarPorEstado(EstadoNotificacion estado);
}
