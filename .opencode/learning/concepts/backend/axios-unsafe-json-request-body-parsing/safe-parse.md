# Variante: safe-parse (Parseo Seguro en Interceptores de Axios)

Cuando escribimos interceptores en Axios para registrar logs de peticiones (`requestBody`), la propiedad `config.data` puede presentarse de dos formas:
1.  Un **String serializado** (si el interceptor se ejecuta después del transformRequest predeterminado de Axios).
2.  Un **Objeto JS** nativo (si se ejecuta antes o si el usuario configuró transforms custom).

Llamar a `JSON.parse(config.data)` cuando es un objeto JS provoca que JS haga coerción de tipo implícita a String, transformándolo en `"[object Object]"`. Dado que esa cadena no es un JSON válido, se genera una excepción fatal de sintaxis.

## 🛠️ Patrón de Código Seguro (Solución)

Utilizar una función anónima autoejecutable (IIFE) con bloque `try-catch` para intentar parsear el string y, ante cualquier error o tipo incorrecto, retornar el cuerpo original de forma segura:

```typescript
const safeRequestBody = config.data 
  ? (() => {
      try {
        // Si ya es un objeto, no requiere parseo y se retorna
        if (typeof config.data === 'object') {
          return config.data;
        }
        return JSON.parse(config.data);
      } catch (e) {
        // Ante cualquier fallo de parseo (ej: [object Object]), retornar el valor original
        return config.data;
      }
    })()
  : undefined;
```
