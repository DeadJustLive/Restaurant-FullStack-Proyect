package cl.triskeledu.notificaciones.mapper;

import cl.triskeledu.notificaciones.dto.request.NotificacionRequestDTO;
import cl.triskeledu.notificaciones.dto.response.NotificacionResponseDTO;
import cl.triskeledu.notificaciones.entity.Notificacion;
import org.mapstruct.Mapper;

/**
 * =============================================================================
 * MAPPER: NotificacionMapper
 * =============================================================================
 */
@Mapper(componentModel = "spring")
public interface NotificacionMapper {

    NotificacionResponseDTO toResponseDTO(Notificacion notificacion);

    Notificacion toEntity(NotificacionRequestDTO dto);
}
