package cl.triskeledu.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Lanzada cuando el usuario existe y las credenciales son correctas,
 * pero la cuenta fue desactivada por un administrador (activo = false).
 * HTTP 403 Forbidden.
 *
 * NOTA: El mensaje puede ser ligeramente más específico que CredencialesInvalidasException
 * ya que confirmar que la cuenta está desactivada no da ventaja a un atacante.
 * El atacante no puede auto-reactivar la cuenta.
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class CuentaDesactivadaException extends RuntimeException {
    public CuentaDesactivadaException(String mensaje) {
        super(mensaje);
    }
}
