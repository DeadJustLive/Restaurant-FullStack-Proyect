package cl.triskeledu.notificaciones.dto.response;

import cl.triskeledu.notificaciones.entity.enums.EstadoNotificacion;
import cl.triskeledu.notificaciones.entity.enums.TipoNotificacion;
import lombok.*;

import java.time.LocalDateTime;

/**
 * =============================================================================
 * DTO RESPONSE: NotificacionResponseDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionResponseDTO {

    private Long id;
    private String destinatario;
    private TipoNotificacion tipo;
    private String asunto;
    private String cuerpo;
    private EstadoNotificacion estado;
    private LocalDateTime creadoEn;
}
