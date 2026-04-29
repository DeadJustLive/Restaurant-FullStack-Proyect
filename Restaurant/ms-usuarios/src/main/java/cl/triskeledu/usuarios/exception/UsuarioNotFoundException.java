package cl.triskeledu.usuarios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Lanzada cuando se busca un perfil de usuario que no existe.
 * HTTP 404 Not Found.
 *
 * IMPACTO EN FEIGN:
 *   ms-pedidos y ms-notificaciones reciben FeignException.NotFound (404).
 *   Deben implementar un fallback: retornar "Usuario desconocido" en lugar de fallar.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String mensaje) {
        super(mensaje);
    }
}
