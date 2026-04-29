package cl.triskeledu.reportes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: ReporteNoGeneradoException
 * =============================================================================
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ReporteNoGeneradoException extends RuntimeException {
    public ReporteNoGeneradoException(String mensaje) {
        super(mensaje);
    }
}
