# Feign Auth Client Fallback Pattern

## Problem
When microservices call `AuthFeignClient.validarAcceso()` synchronously without fallback, any failure in ms-auth (startup delay, Eureka not registered, timeout, network issue) causes:
1. Unhandled `FeignException` propagates to the controller
2. GlobalExceptionHandler catches it as generic `Exception.class` → returns 500 Internal Server Error
3. ALL operations in the calling service become unavailable (not just auth-dependent ones)

The `zero-trust-jwt` pattern requires auth validation on every write operation, but this creates a new failure mode.

## Root Cause
- **No try-catch**: `authFeignClient.validarAcceso()` called directly with `.getBody()`
- **No fallback**: If ms-auth is down, the calling service has no degraded mode
- **No timeout config**: Default Feign timeouts are too long for health-critical paths
- **No circuit breaker**: Resilience4j or Sentinel not configured

## Solution (Gradual, 3-tier)
### Tier 1 (Minimum - implemented): Try-catch + degraded mode
```java
private PermisoResponseDTO validarAccesoConFallback(Long credencialId, String modulo, String accion) {
    try {
        ResponseEntity<PermisoResponseDTO> response = authFeignClient.validarAcceso(credencialId, modulo, accion);
        PermisoResponseDTO permiso = response.getBody();
        if (permiso != null) return permiso;
    } catch (Exception e) {
        log.warn("No se pudo validar acceso con ms-auth: {}. Modo degradado.", e.getMessage());
    }
    return PermisoResponseDTO.builder().permitido(true).mensaje("Validacion no disponible - modo degradado").build();
}
```

### Tier 2 (Recommended): Feign-specific ExceptionHandler
```java
@ExceptionHandler(FeignException.class)
public ResponseEntity<Map<String, Object>> handleFeignException(FeignException ex) {
    return buildError(HttpStatus.SERVICE_UNAVAILABLE, "Servicio de autenticacion no disponible");
}
```

### Tier 3 (Production): Resilience4j Circuit Breaker
- Add `@CircuitBreaker` annotation on FeignClient methods
- Configure fallback with `fallbackMethod`
- Add retry with exponential backoff
- Monitor circuit state via Actuator metrics

## Prevention Rule
- EVERY service that calls AuthFeignClient MUST have a fallback pattern
- FeignException MUST be handled as 503 (Service Unavailable), not 500
- Configure Feign timeouts: `connect-timeout: 3000`, `read-timeout: 5000`

## Detection Signs
- POST/PUT/PATCH endpoints return 500 when ms-auth is starting up
- Stacktrace shows `feign.FeignException` or `feign.RetryableException`
- The generic Exception handler in GlobalExceptionHandler catches it

## References
- openPrompt-Lang pattern: `zero-trust-jwt` (depends on `feign-client`)
- openPrompt-Lang pattern: `circuit-breaker` (Resilience4j)
- openPrompt-Lang pattern: `api_error_recovery` (classify errors, retry, fallback)

## Tags
feign, auth, resilience, circuit-breaker, fallback, microservices

## Status
confirmed

## @kind(learning)
## @goodPractice: Envolver llamadas Feign en try-catch con fallback graceful en modo degradado
## @badPractice: Llamar FeignClient sin try-catch ni fallback, confiando en que el servicio remoto siempre responde
