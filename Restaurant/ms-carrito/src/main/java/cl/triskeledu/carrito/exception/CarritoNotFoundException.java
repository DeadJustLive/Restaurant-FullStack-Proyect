package cl.triskeledu.carrito.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: CarritoNotFoundException
 * =============================================================================
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarritoNotFoundException extends RuntimeException {
    public CarritoNotFoundException(String mensaje) {
        super(mensaje);
    }
}
