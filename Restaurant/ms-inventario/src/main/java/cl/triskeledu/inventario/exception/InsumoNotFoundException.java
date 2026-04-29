package cl.triskeledu.inventario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: InsumoNotFoundException
 * =============================================================================
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InsumoNotFoundException extends RuntimeException {
    public InsumoNotFoundException(String mensaje) {
        super(mensaje);
    }
}
