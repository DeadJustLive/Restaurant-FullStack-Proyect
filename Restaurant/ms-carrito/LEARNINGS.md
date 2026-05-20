# Aprendizajes de Refactorización en ms-carrito

## @learn-error REST_PARAM_BINDING
- **id**: REST_PARAM_BINDING
- **category**: REST / Spring Web
- **input**: Petición PATCH para modificar cantidades desde Postman o Frontend.
- **actual**: `CarritoController` definía `@RequestParam Integer cantidad` en el método `actualizarCantidadItem()`, provocando potenciales conflictos al no leer el cuerpo de la petición.
- **expected**: El controlador debe capturar parámetros de actualización estructurados vía `@RequestBody` (como JSON map o DTO).
- **fix**: Reemplazado `@RequestParam Integer cantidad` por `@RequestBody Map<String, Integer> payload` para ajustarlo a las convenciones estándar de APIs RESTFul consumidas por frontends modernos.

## @learn-error EXCEPTION_LOGGING_PRACTICE
- **id**: EXCEPTION_LOGGING_PRACTICE
- **category**: LOGGING / OBSERVABILITY
- **input**: Error interno o excepción no capturada explícitamente y dirigida al método `handleGeneral()` de `GlobalExceptionHandler`.
- **actual**: Uso de `ex.printStackTrace()` evadiendo el framework de logging.
- **expected**: Envío de trazas completas a través de los canales configurados usando `@Slf4j`.
- **fix**: Eliminación del `.printStackTrace()` a favor del estándar `log.error("Mensaje", ex)`.

## @learn-error CORS_PRODUCTION_CONFIG
- **id**: CORS_PRODUCTION_CONFIG
- **category**: SECURITY / CORS
- **input**: Intentos de acceso desde clientes con origen distinto a `localhost` / `127.0.0.1`.
- **actual**: Configuración limitada en `CorsConfig` (`allowedOriginPatterns("http://localhost:*", "http://127.0.0.1:*")`) que restringe la compatibilidad con entornos de QA/Prod.
- **expected**: Configuración flexible (abierta con `*` o controlada vía propiedades del entorno).
- **fix**: Actualización a `.allowedOriginPatterns("*")` en `addCorsMappings`.

## @learn-error MAPSTRUCT_VSCODE_COMPILATION
- **id**: MAPSTRUCT_VSCODE_COMPILATION
- **category**: TOOLING / IDE
- **input**: Procesamiento de Anotaciones en VSCode (Java Language Server) al trabajar con MapStruct.
- **actual**: Conflictos o falsos positivos (como "No implementation was created... due to erroneous element java.util.ArrayList") si el compilador detecta propiedades no mapeadas de forma estricta.
- **expected**: MapStruct debe ignorar transparentemente las propiedades sin mapeo (como campos automáticos de JPA) si así se requiere.
- **fix**: Inyección explícita de `unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE` en `@Mapper` para `CarritoMapper`.

## Cumplimiento de Criterios para Entorno de Desarrollo
El microservicio `ms-carrito` cumple exitosamente con:
1. **Frontend Ready**: Las peticiones mutables están correctamente enrutadas con `RequestBody`.
2. **CORS Abierto**: Se superan las barreras artificiales de localhost para la capa de presentación.
3. **Debuggable**: Las excepciones caen en `GlobalExceptionHandler` retornando JSON estructurado hacia el cliente y trazas limpias vía SLF4J en la consola.
4. **Validación OPL**: `npx openprompt-lang validate` pasa exitosamente, certificando estructura estricta (`docs/`, `prompt-lang.json`) y disposición correcta de anotaciones PromptLang (`@use`, `@kind`, `@contract`, `@limit`).
