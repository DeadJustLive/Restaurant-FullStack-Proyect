package cl.triskeledu.pagos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EstadoPagoInvalidoException extends RuntimeException {

    public EstadoPagoInvalidoException(String mensaje) {
        super(mensaje);
    }
}