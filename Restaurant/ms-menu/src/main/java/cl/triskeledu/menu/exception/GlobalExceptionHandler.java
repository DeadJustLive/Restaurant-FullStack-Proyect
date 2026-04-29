package cl.triskeledu.menu.exception;

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
 * EXCEPTION HANDLER: GlobalExceptionHandler (ms-menu)
 * =============================================================================
 *
 * PROPÓSITO:
 *   Handler global de excepciones para todos los controllers de ms-menu.
 *   Convierte excepciones de dominio en respuestas HTTP estructuradas y consistentes.
 *
 * ESTRUCTURA DE RESPUESTA DE ERROR:
 * {
 *   "timestamp": "2024-04-25T18:30:00",
 *   "status":    404,
 *   "error":     "Not Found",
 *   "mensaje":   "Ítem de menú no encontrado con ID: 7"
 * }
 *
 * CONSIDERACIÓN DE FEIGN:
 *   ms-pedidos y ms-carrito consumen este servicio vía Feign.
 *   Los errores aquí retornados se convierten en FeignException en el cliente.
 *   El body del error también es accesible en el cliente Feign si se configura
 *   un ErrorDecoder personalizado.
 *   TODO: Definir un contrato de error estándar entre todos los microservicios
 *         (ErrorResponseDTO compartido, posiblemente en una librería común).
 *
 * =============================================================================
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /** 404 — Ítem no encontrado */
    @ExceptionHandler(MenuItemNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(MenuItemNotFoundException ex) {
        return buildError(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    /** 409 — Ítem no disponible (existe pero disponible = false) */
    @ExceptionHandler(ItemNoDisponibleException.class)
    public ResponseEntity<Map<String, Object>> handleNoDisponible(ItemNoDisponibleException ex) {
        return buildError(HttpStatus.CONFLICT, ex.getMessage());
    }

    /** 409 — Ítem duplicado (nombre ya existe en la misma categoría) */
    @ExceptionHandler(ItemDuplicadoException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicado(ItemDuplicadoException ex) {
        return buildError(HttpStatus.CONFLICT, ex.getMessage());
    }

    /**
     * 400 — Validación Bean Validation (@Valid) fallida.
     * Retorna un mapa de {campo: "mensaje"} para cada campo inválido.
     * Útil para que el frontend muestre mensajes de error inline en el formulario.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> erroresCampos = new HashMap<>();
        for (FieldError fe : ex.getBindingResult().getFieldErrors()) {
            erroresCampos.put(fe.getField(), fe.getDefaultMessage());
        }
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Errores de validación");
        body.put("errores", erroresCampos);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    /** 500 — Fallback para errores no controlados. No exponer stack trace al cliente. */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
        // TODO: Integrar con sistema de alertas para errores 500 no esperados.
        return buildError(HttpStatus.INTERNAL_SERVER_ERROR,
                "Error interno en ms-menu. Contacte al administrador.");
    }

    private ResponseEntity<Map<String, Object>> buildError(HttpStatus status, String mensaje) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("mensaje", mensaje);
        return ResponseEntity.status(status).body(body);
    }
}
