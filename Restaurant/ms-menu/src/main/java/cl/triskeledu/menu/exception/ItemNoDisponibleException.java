package cl.triskeledu.menu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: ItemNoDisponibleException
 * =============================================================================
 * Lanzada cuando se intenta acceder a un MenuItem que existe pero está deshabilitado.
 * HTTP 409 Conflict — el recurso existe pero su estado impide la operación.
 *
 * CUÁNDO LANZARLA:
 *   - MenuItemServiceImpl.getById() → disponible = false.
 *
 * IMPACTO EN FEIGN:
 *   ms-pedidos recibe HTTP 409. Debe capturar el FeignException.Conflict
 *   y lanzar su propia excepción para notificar al cliente que el ítem no está disponible.
 *   El mensaje debe indicar el nombre del ítem para que el frontend lo muestre al usuario.
 * =============================================================================
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ItemNoDisponibleException extends RuntimeException {
    public ItemNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
