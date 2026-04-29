package cl.triskeledu.notificaciones.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: NotificacionNotFoundException
 * =============================================================================
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotificacionNotFoundException extends RuntimeException {
    public NotificacionNotFoundException(String mensaje) {
        super(mensaje);
    }
}
