# Aprendizajes de Refactorización en ms-auth

## @learn-error REST_PARAM_BINDING
- **id**: REST_PARAM_BINDING
- **category**: REST / Spring Web
- **input**: Petición POST/PATCH con cuerpo JSON desde Postman o Frontend.
- **actual**: El controlador definía parámetros con `@RequestParam`, lo que provocaba errores 400 (Bad Request) al no encontrar los parámetros en la URL o en `application/x-www-form-urlencoded`.
- **expected**: El controlador debe capturar el cuerpo JSON usando `@RequestBody` asociado a un DTO.
- **fix**: Reemplazar `@RequestParam` por `@RequestBody` y encapsular los datos requeridos (como `refreshToken` o `sucursalId`) dentro de Data Transfer Objects (ej. `RefreshTokenRequestDTO`).

## @learn-error CORS_PRODUCTION_CONFIG
- **id**: CORS_PRODUCTION_CONFIG
- **category**: SECURITY / CORS
- **input**: Petición fetch/axios desde el Frontend alojado en dominios externos (ej. Vercel, entorno real) a la API.
- **actual**: `SecurityConfig` limitaba el acceso explícitamente a `http://localhost:*` provocando el bloqueo total del frontend en entornos que no fueran de desarrollo local estricto.
- **expected**: Configuración flexible de CORS que permita conexiones desde los orígenes de la aplicación frontend o `*` en entornos de desarrollo/staging.
- **fix**: Actualizar el `setAllowedOriginPatterns` a `*` en la definición del `CorsConfigurationSource` para permitir interacciones fluidas durante la depuración y paso a desarrollo.

## @learn-error EXCEPTION_LOGGING_PRACTICE
- **id**: EXCEPTION_LOGGING_PRACTICE
- **category**: LOGGING / OBSERVABILITY
- **input**: Error interno no controlado que cae en `GlobalExceptionHandler`.
- **actual**: Uso de `ex.printStackTrace()` que contamina la salida estándar y evade el sistema estructurado de trazas (SLF4J/Logback).
- **expected**: Trazas enviadas al canal de log configurado respetando los niveles de severidad (`ERROR`).
- **fix**: Inyectar `@Slf4j` y usar `log.error("Mensaje", ex)` para garantizar la compatibilidad con recolectores como ELK Stack y herramientas de APM.

## Cumplimiento de Criterios para Entorno de Desarrollo
Tras las refactorizaciones, el microservicio `ms-auth`:
1. **Frontend Ready**: Las peticiones de registro, login, refresh, logout y actualización (vía POST/PATCH) ahora interpretan correctamente JSON.
2. **CORS Abierto**: El puente Frontend ↔ Backend ya no está bloqueado por orígenes cerrados a localhost.
3. **Debuggable**: Gracias al uso consistente de SLF4J y centralización de excepciones, el frontend podrá interpretar claramente respuestas HTTP precisas (400, 401, 403, 409) con un JSON estructurado, mientras que la consola de desarrollo local/servidor tendrá la traza del error exacta para depuración.
