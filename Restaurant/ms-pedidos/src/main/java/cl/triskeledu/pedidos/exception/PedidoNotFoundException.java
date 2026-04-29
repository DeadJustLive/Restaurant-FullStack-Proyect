package cl.triskeledu.pedidos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: PedidoNotFoundException
 * =============================================================================
 *
 * PROPÓSITO:
 *   Excepción de dominio lanzada cuando se busca un Pedido que no existe en la BD.
 *   Mapeada automáticamente a HTTP 404 Not Found por @ResponseStatus.
 *
 * CUÁNDO LANZARLA:
 *   - PedidoServiceImpl.obtenerPorId() → pedido no encontrado en Repository.
 *   - PedidoServiceImpl.cambiarEstado() → pedido no encontrado.
 *   - PedidoServiceImpl.cancelar() → pedido no encontrado.
 *
 * MANEJO:
 *   El GlobalExceptionHandler captura esta excepción y retorna un body JSON
 *   estructurado con mensaje de error y timestamp.
 *   El @ResponseStatus aquí es un fallback si el GlobalExceptionHandler no existe.
 *
 * BUENAS PRÁCTICAS:
 *   Incluir el ID en el mensaje para facilitar el debugging:
 *   new PedidoNotFoundException("Pedido no encontrado con ID: " + id)
 *
 * =============================================================================
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PedidoNotFoundException extends RuntimeException {

    public PedidoNotFoundException(String mensaje) {
        super(mensaje);
    }

    public PedidoNotFoundException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
