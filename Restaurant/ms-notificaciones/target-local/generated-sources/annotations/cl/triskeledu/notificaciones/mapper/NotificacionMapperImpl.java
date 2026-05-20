package cl.triskeledu.notificaciones.mapper;

import cl.triskeledu.notificaciones.dto.request.NotificacionRequestDTO;
import cl.triskeledu.notificaciones.dto.response.NotificacionResponseDTO;
import cl.triskeledu.notificaciones.entity.Notificacion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T13:33:16-0400",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class NotificacionMapperImpl implements NotificacionMapper {

    @Override
    public NotificacionResponseDTO toResponseDTO(Notificacion notificacion) {
        if ( notificacion == null ) {
            return null;
        }

        NotificacionResponseDTO.NotificacionResponseDTOBuilder notificacionResponseDTO = NotificacionResponseDTO.builder();

        notificacionResponseDTO.asunto( notificacion.getAsunto() );
        notificacionResponseDTO.creadoEn( notificacion.getCreadoEn() );
        notificacionResponseDTO.cuerpo( notificacion.getCuerpo() );
        notificacionResponseDTO.destinatario( notificacion.getDestinatario() );
        notificacionResponseDTO.estado( notificacion.getEstado() );
        notificacionResponseDTO.id( notificacion.getId() );
        notificacionResponseDTO.tipo( notificacion.getTipo() );

        return notificacionResponseDTO.build();
    }

    @Override
    public Notificacion toEntity(NotificacionRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Notificacion.NotificacionBuilder notificacion = Notificacion.builder();

        notificacion.asunto( dto.getAsunto() );
        notificacion.cuerpo( dto.getCuerpo() );
        notificacion.destinatario( dto.getDestinatario() );
        notificacion.tipo( dto.getTipo() );

        return notificacion.build();
    }
}
