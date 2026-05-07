package cl.triskeledu.categorias.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: CategoriaDuplicadaException
 * =============================================================================
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class CategoriaDuplicadaException extends RuntimeException {
    public CategoriaDuplicadaException(String mensaje) {
        super(mensaje);
    }
}
