# axios-unsafe-json-request-body-parsing

## Resumen
Error crítico de parseo en interceptores de Axios donde se asume que el cuerpo de la petición (`config.data`) siempre es un String JSON serializado. Si Axios ya transformó el cuerpo en un objeto JS (o si el llamador pasó un objeto), llamar a `JSON.parse(config.data)` lanza un error de sintaxis implícito `SyntaxError: "[object Object]" is not valid JSON`, interrumpiendo la cadena de promesas y haciendo colapsar la respuesta del cliente de forma silenciosa.

## Tipo
backend

## Estado
aprobado

## Variantes disponibles
| Variante | Archivo | Descripción breve |
|----------|---------|-------------------|
| safe-parse | `safe-parse.md` | Implementación de una IIFE segura con try-catch para parsear opcionalmente el body. |

## Relaciones
- Similar a: `json-unsafe-deserialization`
- Contraste con: `strict-json-parsing`
- Compatible con: `axios-interceptors`

## Reglas generales
- **NUNCA usar `JSON.parse` a ciegas** sobre propiedades de peticiones HTTP como `config.data` en interceptores globales.
- **Implementar siempre un try-catch de respaldo (fallback):** Si el parseo falla o si el objeto ya está parsed (dando un `[object Object]`), se debe retornar el valor original directamente sin lanzar excepciones.
