package cl.triskeledu.menu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: MenuItemNotFoundException
 * =============================================================================
 * Lanzada cuando se busca un MenuItem que no existe en la BD de menú.
 * HTTP 404 Not Found.
 *
 * CUÁNDO LANZARLA:
 *   - MenuItemServiceImpl.getById() → ID no encontrado.
 *   - MenuItemServiceImpl.actualizar() → ID no encontrado.
 *   - MenuItemServiceImpl.cambiarDisponibilidad() → ID no encontrado.
 *   - MenuItemServiceImpl.eliminar() → ID no encontrado.
 *
 * IMPACTO EN FEIGN:
 *   ms-pedidos y ms-carrito recibirán FeignException con HTTP 404.
 *   Deben capturarla y lanzar su propia excepción local para control de flujo.
 * =============================================================================
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MenuItemNotFoundException extends RuntimeException {
    public MenuItemNotFoundException(String mensaje) {
        super(mensaje);
    }
}
