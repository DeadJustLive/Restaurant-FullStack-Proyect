package cl.triskeledu.pedidos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: EstadoInvalidoException
 * =============================================================================
 *
 * PROPÓSITO:
 *   Excepción de dominio lanzada cuando se intenta una transición de estado
 *   no permitida por la máquina de estados definida en PedidoServiceImpl.
 *   Mapeada a HTTP 409 Conflict, ya que el recurso existe pero su estado
 *   actual entra en conflicto con la operación solicitada.
 *
 * CUÁNDO LANZARLA:
 *   - PedidoServiceImpl.cambiarEstado() → transición no incluida en TRANSICIONES_VALIDAS.
 *   - PedidoServiceImpl.cancelar() → estado actual no es PENDIENTE ni CONFIRMADO.
 *
 * EJEMPLOS DE USO:
 *   throw new EstadoInvalidoException("Transición inválida: EN_PREPARACION → PENDIENTE");
 *   throw new EstadoInvalidoException("No se puede cancelar un pedido ENTREGADO");
 *
 * CONSIDERACIÓN DE DISEÑO:
 *   HTTP 409 es más semántico que 400 aquí porque el problema no es el formato
 *   de la request (que puede ser perfectamente válida), sino el estado actual
 *   del recurso que impide la operación.
 *
 * =============================================================================
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class EstadoInvalidoException extends RuntimeException {

    public EstadoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
