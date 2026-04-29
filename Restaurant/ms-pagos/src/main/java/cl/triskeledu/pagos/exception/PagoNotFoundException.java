package cl.triskeledu.pagos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: PagoNotFoundException
 * =============================================================================
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PagoNotFoundException extends RuntimeException {
    public PagoNotFoundException(String mensaje) {
        super(mensaje);
    }
}
