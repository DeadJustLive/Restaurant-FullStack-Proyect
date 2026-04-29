package cl.triskeledu.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Lanzada cuando las credenciales de login son incorrectas
 * (username no existe O password no coincide — mismo mensaje para ambos casos).
 * HTTP 401 Unauthorized.
 *
 * SEGURIDAD: El mensaje debe ser SIEMPRE genérico ("Credenciales inválidas.")
 * sin especificar si el error es en el username o en la password.
 * Esto previene user enumeration attacks.
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class CredencialesInvalidasException extends RuntimeException {
    public CredencialesInvalidasException(String mensaje) {
        super(mensaje);
    }
}
