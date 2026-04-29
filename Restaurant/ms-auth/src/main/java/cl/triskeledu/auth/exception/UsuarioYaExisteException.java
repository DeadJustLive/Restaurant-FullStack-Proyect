package cl.triskeledu.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Lanzada durante el registro cuando el username ya está tomado.
 * HTTP 409 Conflict.
 *
 * CUÁNDO LANZARLA:
 *   AuthServiceImpl.registrar() → existsByUsername() retorna true.
 *
 * NOTA: En el registro SÍ es aceptable confirmar que el username existe,
 * ya que el usuario debe elegir uno diferente. No aplica user enumeration aquí.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class UsuarioYaExisteException extends RuntimeException {
    public UsuarioYaExisteException(String mensaje) {
        super(mensaje);
    }
}
