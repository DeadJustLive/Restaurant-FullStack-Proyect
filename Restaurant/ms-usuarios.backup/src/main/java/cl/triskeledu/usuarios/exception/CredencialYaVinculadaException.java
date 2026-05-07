package cl.triskeledu.usuarios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Lanzada cuando se intenta crear un perfil para un credencialId que ya tiene uno vinculado.
 * HTTP 409 Conflict.
 *
 * TODO: Hacer crear() idempotente: si ya existe, retornar el perfil existente
 *       en lugar de lanzar error. Esto previene fallos en reintentos de ms-auth.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class CredencialYaVinculadaException extends RuntimeException {
    public CredencialYaVinculadaException(String mensaje) {
        super(mensaje);
    }
}
