package cl.triskeledu.sucursales.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: SucursalNotFoundException
 * =============================================================================
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SucursalNotFoundException extends RuntimeException {
    public SucursalNotFoundException(String mensaje) {
        super(mensaje);
    }
}
