package cl.triskeledu.auth.exception;

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
 * EXCEPTION HANDLER: GlobalExceptionHandler (ms-auth)
 * =============================================================================
 *
 * PROPÓSITO:
 *   Handler global para todos los controllers de ms-auth.
 *   Transforma excepciones de dominio de seguridad en respuestas HTTP consistentes.
 *
 * PRINCIPIO DE SEGURIDAD EN MENSAJES DE ERROR:
 *   Los mensajes de error de autenticación deben ser GENÉRICOS.
 *   - ❌ "Username no encontrado" — revela que el username no existe.
 *   - ❌ "Contraseña incorrecta" — revela que el username SÍ existe.
 *   - ✅ "Credenciales inválidas" — ambos casos, mismo mensaje.
 *   El GlobalExceptionHandler respeta los mensajes que le pasan las excepciones.
 *   Es responsabilidad del Service lanzar mensajes genéricos.
 *
 * CÓDIGOS HTTP DE SEGURIDAD:
 *   401 Unauthorized: credenciales inválidas, token expirado/inválido.
 *   403 Forbidden:    cuenta desactivada o sin permisos para la operación.
 *   409 Conflict:     username ya registrado.
 *   501 Not Implemented: endpoint scaffoldeado pendiente de implementar.
 *
 * =============================================================================
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 401 — Credenciales inválidas (username o password incorrectos).
     * Mensaje genérico para prevenir user enumeration.
     */
    @ExceptionHandler(CredencialesInvalidasException.class)
    public ResponseEntity<Map<String, Object>> handleCredencialesInvalidas(CredencialesInvalidasException ex) {
        return buildError(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }

    /**
     * 403 — Cuenta desactivada por el administrador.
     * El usuario existe pero no puede operar con su cuenta.
     */
    @ExceptionHandler(CuentaDesactivadaException.class)
    public ResponseEntity<Map<String, Object>> handleCuentaDesactivada(CuentaDesactivadaException ex) {
        return buildError(HttpStatus.FORBIDDEN, ex.getMessage());
    }

    /**
     * 409 — Username ya registrado.
     * Solo aplica al endpoint de registro, no al de login.
     */
    @ExceptionHandler(UsuarioYaExisteException.class)
    public ResponseEntity<Map<String, Object>> handleYaExiste(UsuarioYaExisteException ex) {
        return buildError(HttpStatus.CONFLICT, ex.getMessage());
    }

    /**
     * 400 — Validación Bean Validation fallida.
     * Retorna mapa de {campo: "mensaje"} para todos los campos inválidos.
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

    /** 501 — Endpoint scaffoldeado, pendiente de implementar. */
    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<Map<String, Object>> handleNotImplemented(UnsupportedOperationException ex) {
        return buildError(HttpStatus.NOT_IMPLEMENTED, "Funcionalidad en desarrollo: " + ex.getMessage());
    }

    /**
     * 500 — Fallback. No exponer stack trace ni detalle interno al cliente.
     * TODO: Integrar con sistema de alertas (Sentry, PagerDuty) para errores inesperados en auth.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
        return buildError(HttpStatus.INTERNAL_SERVER_ERROR,
                "Error interno en ms-auth. Contacte al administrador.");
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
