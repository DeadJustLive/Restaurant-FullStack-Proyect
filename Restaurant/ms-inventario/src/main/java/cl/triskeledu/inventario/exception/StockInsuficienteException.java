package cl.triskeledu.inventario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: StockInsuficienteException
 * =============================================================================
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
