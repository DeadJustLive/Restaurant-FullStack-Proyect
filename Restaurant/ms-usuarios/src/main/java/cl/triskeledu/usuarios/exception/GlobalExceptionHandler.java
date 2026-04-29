package cl.triskeledu.usuarios.exception;

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
 * EXCEPTION HANDLER: GlobalExceptionHandler (ms-usuarios)
 * =============================================================================
 * Transforma excepciones de dominio en respuestas HTTP JSON estructuradas.
 * Las excepciones también son recibidas por los clientes Feign como FeignException.
 * =============================================================================
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /** 404 — Perfil de usuario no encontrado. */
    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(UsuarioNotFoundException ex) {
        return buildError(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    /** 409 — Credencial ya tiene un perfil vinculado. */
    @ExceptionHandler(CredencialYaVinculadaException.class)
    public ResponseEntity<Map<String, Object>> handleCredencialYaVinculada(CredencialYaVinculadaException ex) {
        return buildError(HttpStatus.CONFLICT, ex.getMessage());
    }

    /** 400 — Validación Bean Validation fallida. Retorna mapa campo→mensaje. */
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

    /** 500 — Fallback no controlado. No exponer detalle interno. */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
        return buildError(HttpStatus.INTERNAL_SERVER_ERROR,
                "Error interno en ms-usuarios. Contacte al administrador.");
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
