package cl.triskeledu.pedidos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * =============================================================================
 * EXCEPTION HANDLER: GlobalExceptionHandler
 * =============================================================================
 *
 * PROPÓSITO:
 *   Handler global de excepciones para todos los controllers del microservicio.
 *   Intercepta excepciones lanzadas en cualquier punto de la cadena de llamadas
 *   y las convierte en respuestas HTTP con cuerpo JSON estructurado y consistente.
 *
 * PATRÓN:
 *   @RestControllerAdvice = @ControllerAdvice + @ResponseBody.
 *   Aplica a todos los controllers del paquete raíz (cl.triskeledu.pedidos).
 *
 * ESTRUCTURA DE RESPUESTA DE ERROR (ErrorResponseDTO implícito):
 * {
 *   "timestamp":  "2024-04-25T18:30:00",
 *   "status":     404,
 *   "error":      "Not Found",
 *   "mensaje":    "Pedido no encontrado con ID: 42",
 *   "path":       "/api/v1/pedidos/42"    // TODO: agregar path con HttpServletRequest
 * }
 *
 * JERARQUÍA DE HANDLERS:
 *   1. Excepciones más específicas (PedidoNotFoundException) tienen prioridad.
 *   2. Las más genéricas (Exception) actúan como fallback.
 *
 * TODO: Agregar un ErrorResponseDTO formal para tipado fuerte de las respuestas de error.
 * TODO: Integrar con un sistema de logging centralizado (ej: ELK Stack).
 * TODO: Agregar el path del request con HttpServletRequest como parámetro del handler.
 *
 * =============================================================================
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * HANDLER: PedidoNotFoundException → 404 Not Found
     *
     * CAPTURA: Cuando el Service no encuentra un Pedido en la BD.
     * RESPONSE: 404 con mensaje descriptivo del recurso no encontrado.
     *
     * @param ex Excepción capturada con el mensaje del ID buscado.
     */
    @ExceptionHandler(PedidoNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePedidoNotFound(PedidoNotFoundException ex) {
        return buildError(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    /**
     * HANDLER: EstadoInvalidoException → 409 Conflict
     *
     * CAPTURA: Cuando se intenta una transición de estado no permitida.
     * RESPONSE: 409 con detalle de la transición rechazada y las válidas disponibles.
     */
    @ExceptionHandler(EstadoInvalidoException.class)
    public ResponseEntity<Map<String, Object>> handleEstadoInvalido(EstadoInvalidoException ex) {
        return buildError(HttpStatus.CONFLICT, ex.getMessage());
    }

    /**
     * HANDLER: MethodArgumentNotValidException → 400 Bad Request
     *
     * CAPTURA: Cuando la validación de @Valid en el Controller falla.
     * RESPONSE: 400 con un mapa de {campo: "mensaje de error"} para cada campo inválido.
     *
     * EJEMPLO DE RESPONSE:
     * {
     *   "timestamp": "2024-04-25T18:30:00",
     *   "status": 400,
     *   "error": "Errores de validación",
     *   "errores": {
     *     "usuarioId": "El ID del usuario es obligatorio",
     *     "items": "El pedido debe contener al menos un ítem"
     *   }
     * }
     *
     * @param ex Excepción de validación con la lista de FieldErrors.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> erroresCampos = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            erroresCampos.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Errores de validación");
        body.put("errores", erroresCampos);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    /**
     * HANDLER: UnsupportedOperationException → 501 Not Implemented
     *
     * CAPTURA: Métodos con lógica de negocio pendiente de implementar (scaffolding).
     * RESPONSE: 501 con mensaje de "en desarrollo".
     * NOTA: Este handler debe eliminarse cuando todos los TODOs estén implementados.
     */
    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<Map<String, Object>> handleNotImplemented(UnsupportedOperationException ex) {
        return buildError(HttpStatus.NOT_IMPLEMENTED, "Funcionalidad en desarrollo: " + ex.getMessage());
    }

    /**
     * HANDLER: Exception (fallback) → 500 Internal Server Error
     *
     * CAPTURA: Cualquier excepción no capturada por los handlers anteriores.
     * RESPONSE: 500 con mensaje genérico. NO exponer el stack trace al cliente.
     *
     * IMPORTANTE: Loguear el stack trace completo en el servidor para debugging.
     * TODO: Integrar con sistema de alertas (ej: Sentry, PagerDuty) para errores 500.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
        // TODO: log.error("[GlobalExceptionHandler] Error no controlado: {}", ex.getMessage(), ex);
        return buildError(HttpStatus.INTERNAL_SERVER_ERROR,
                "Error interno del servidor. Por favor contacte al administrador.");
    }

    /**
     * MÉTODO PRIVADO: Construye la estructura base de una respuesta de error.
     *
     * @param status  Código de estado HTTP.
     * @param mensaje Mensaje descriptivo del error.
     * @return ResponseEntity con cuerpo JSON estructurado.
     */
    private ResponseEntity<Map<String, Object>> buildError(HttpStatus status, String mensaje) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("mensaje", mensaje);
        return ResponseEntity.status(status).body(body);
    }
}
