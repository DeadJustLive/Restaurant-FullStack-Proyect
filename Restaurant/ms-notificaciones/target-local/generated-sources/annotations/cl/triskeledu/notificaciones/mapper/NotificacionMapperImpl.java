package cl.triskeledu.notificaciones.mapper;

import cl.triskeledu.notificaciones.dto.request.NotificacionRequestDTO;
import cl.triskeledu.notificaciones.dto.response.NotificacionResponseDTO;
import cl.triskeledu.notificaciones.entity.Notificacion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-17T21:34:28-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Red Hat, Inc.)"
)
@Component
public class NotificacionMapperImpl implements NotificacionMapper {

    @Override
    public NotificacionResponseDTO toResponseDTO(Notificacion notificacion) {
        if ( notificacion == null ) {
            return null;
        }

        NotificacionResponseDTO.NotificacionResponseDTOBuilder notificacionResponseDTO = NotificacionResponseDTO.builder();

        notificacionResponseDTO.id( notificacion.getId() );
        notificacionResponseDTO.destinatario( notificacion.getDestinatario() );
        notificacionResponseDTO.tipo( notificacion.getTipo() );
        notificacionResponseDTO.asunto( notificacion.getAsunto() );
        notificacionResponseDTO.cuerpo( notificacion.getCuerpo() );
        notificacionResponseDTO.estado( notificacion.getEstado() );
        notificacionResponseDTO.creadoEn( notificacion.getCreadoEn() );

        return notificacionResponseDTO.build();
    }

    @Override
    public Notificacion toEntity(NotificacionRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Notificacion.NotificacionBuilder notificacion = Notificacion.builder();

        notificacion.destinatario( dto.getDestinatario() );
        notificacion.tipo( dto.getTipo() );
        notificacion.asunto( dto.getAsunto() );
        notificacion.cuerpo( dto.getCuerpo() );

        return notificacion.build();
    }
}
