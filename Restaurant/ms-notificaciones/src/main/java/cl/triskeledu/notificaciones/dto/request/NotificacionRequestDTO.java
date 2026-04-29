package cl.triskeledu.notificaciones.dto.request;

import cl.triskeledu.notificaciones.entity.enums.TipoNotificacion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * =============================================================================
 * DTO REQUEST: NotificacionRequestDTO
 * =============================================================================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionRequestDTO {

    @NotBlank(message = "El destinatario es obligatorio")
    private String destinatario;

    @NotNull(message = "El tipo de notificación es obligatorio")
    private TipoNotificacion tipo;

    private String asunto;

    @NotBlank(message = "El cuerpo del mensaje es obligatorio")
    private String cuerpo;
}
