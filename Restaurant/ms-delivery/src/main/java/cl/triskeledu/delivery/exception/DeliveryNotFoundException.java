package cl.triskeledu.delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: DeliveryNotFoundException
 * =============================================================================
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DeliveryNotFoundException extends RuntimeException {
    public DeliveryNotFoundException(String mensaje) {
        super(mensaje);
    }
}
