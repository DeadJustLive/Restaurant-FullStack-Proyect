# lombok-boxed-boolean-gotcha

## Resumen
Gotcha de compilación con Lombok al mezclar campos tipo `Boolean` (objeto encapsulado) y primitivos `boolean`. En Java, Lombok genera getters con el prefijo `get` para objetos `Boolean` (ej. `getActiva()`) pero usa el prefijo `is` para primitivos `boolean` (ej. `isActiva()`). Si la capa de negocio invoca `isActiva()`, compilará únicamente si el campo es de tipo primitivo `boolean`.

## Tipo
backend

## Estado
confirmado

## Variantes disponibles
| Variante | Archivo | Descripción breve |
|----------|---------|-------------------|
| primitive-boolean | `primitive.md` | Uso de tipo primitivo para banderas obligatorias |

## Relaciones
- Similar a: `mapstruct-type-mismatches`
- Contraste con: `jpa-nullable-columns`

## Reglas generales
- Usar siempre primitivos `boolean` para columnas marcadas como `@Column(nullable = false)` para garantizar generación uniforme de getters `isX()`.
- Evitar el uso de `Boolean` encapsulado a menos que la columna admita expresamente valores nulos en base de datos.
