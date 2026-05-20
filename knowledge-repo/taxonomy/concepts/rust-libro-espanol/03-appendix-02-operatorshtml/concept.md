# Appendix 02 operators.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 3)

## Contenido
# El Lenguaje de Programación Rust

## Apéndice B: Operadores y símbolos

### Operadores

### Simbolos no operadores

Este apéndice contiene una lista de los operadores y símbolos que aparecen en
Rust, incluyendo los operadores y otros símbolos que aparecen por sí mismos o en
el contexto de rutas, genéricos, límites de trait, macros, atributos, comentarios,
tuplas y corchetes.

La tabla B-1 contiene los operadores en Rust, un ejemplo de cómo aparecería el
operador en contexto, una breve explicación y si ese operador es
sobrecargable. Si un operador es sobrecargable, se lista el rasgo relevante para
sobrecargar ese operador.

Tabla B-1: Operadores

La siguiente lista contiene todos los símbolos que no funcionan como
operadores; es decir, no se comportan como una llamada de función o método.

Tabla B-2 muestra los símbolos que aparecen por sí mismos y son válidos en una
variedad de ubicaciones.

Tabla B-2: Sintaxis únicas

Tabla B-3 muestra los símbolos que aparecen en el contexto de un camino a través
del módulo de la jerarquía para un elemento.

Tabla B-3: Sintaxis relacionado a Rutas

Tabla B-4 muestra los símbolos que aparecen en el contexto de usar parámetros de
tipo genérico.

Tabla B-5 muestra los símbolos que aparecen en el contexto de restringir
parámetros de tipo genérico con límites de tipo.

Tabla B-5: Restricciones de tipo

Tabla B-6 muestra los símbolos que aparecen en el contexto de llamar o definir
macros y especificar atributos en un elemento.

Tabla B-6: Macros y Atributos

Tabla B-7 muestra los símbolos que crean comentarios.

Tabla B-7: Comentarios

Tabla B-8 muestra el contexto en los que paréntesis son usados.

Table B-8: Paréntesis

Tabla B-9 muestra los contextos en los que se usan las llaves.

Tabla B-10 muestra los contextos en los que se usan los corchetes.

Tabla B-10: Corchetes

## Código

```
ident!(...)
```

```
ident!{...}
```

```
ident![...]
```

```
expr != expr
```

```
PartialEq
```

```
expr % expr
```

```typescript
var %= expr
```

```
RemAssign
```

```
&mut expr
```

```
&mut type
```

```
&'a type
```

```
&'a mut type
```

```
expr & expr
```

```
BitAnd
```

```typescript
var &= expr
```

```
BitAndAssign
```

```
expr && expr
```

```
expr * expr
```

```typescript
var *= expr
```

```
MulAssign
```

```
*const type
```

```
*mut type
```

```
trait + trait
```

```
'a + trait
```

```
expr + expr
```

```typescript
var += expr
```

```
AddAssign
```

```
expr, expr
```

```
- expr
```

```
expr - expr
```

```typescript
var -= expr
```

```
SubAssign
```

```
fn(...) -> type
```

```
|...| -> type
```

```
expr.ident
```

```
expr.ident(expr, ...)
```

```
expr.0
```

```
expr.1
```

```
expr..
```

```
..expr
```

```
expr..expr
```

```
PartialOrd
```

```
..=expr
```

```
expr..=expr
```

```
PartialOrd
```

```
..expr
```

```
variant(x, ..)
```

```
struct_type { x, .. }
```

```
expr...expr
```

```
expr / expr
```

```typescript
var /= expr
```

```
DivAssign
```

```
pat: type
```

```
ident: type
```

```
ident: expr
```

```
'a: loop {...}
```

```typescript
[...; len]
```

```
expr << expr
```

```typescript
var <<= expr
```

```
ShlAssign
```

```
expr < expr
```

```
PartialOrd
```

```
expr <= expr
```

```
PartialOrd
```

```typescript
var = expr
```

```
ident = type
```

```
expr == expr
```

```
PartialEq
```

```
pat => expr
```

```
expr > expr
```

```
PartialOrd
```

```
expr >= expr
```

```
PartialOrd
```

```
expr >> expr
```

```typescript
var >>= expr
```

```
ShrAssign
```

```
ident @ pat
```

```
expr ^ expr
```

```
BitXor
```

```typescript
var ^= expr
```

```
BitXorAssign
```

```
pat | pat
```

```
expr | expr
```

```typescript
var |= expr
```

```
BitOrAssign
```

```
expr || expr
```

```
'ident
```

```
...i32
```

```
...f64
```

```
...usize
```

```
r"..."
```

```
r#"..."#
```

```
r##"..."##
```

```
b'...'
```

```
br"..."
```

```
br#"..."#
```

```
br##"..."##
```

```
b'...'
```

```
|...| expr
```

```
ident::ident
```

```
::path
```

```
self::path
```

```
super::path
```

```
type::ident
```

```
<type as trait>::ident
```

```
<type>::...
```

```
<&T>::...
```

```
<[T]>::...
```

```
trait::method(...)
```

```
type::method(...)
```

```
<type as trait>::method(...)
```

```
path<...>
```

```
Vec<u8>
```

```
path::<...>
```

```
method::<...>
```

```
"42".parse::<i32>()
```

```
fn ident<...> ...
```

```
struct ident<...> ...
```

```typescript
enum ident<...> ...
```

```
impl<...> ...
```

```
for<...> type
```

```
type<ident=type>
```

```
Iterator<Item=T>
```

```
T: 'static
```

```
'static
```

```
'b: 'a
```

```
T: ?Sized
```

```
'a + trait
```

```
trait + trait
```

```
#[meta]
```

```
#![meta]
```

```
$ident
```

```
$ident:kind
```

```
$(...)...
```

```
ident!(...)
```

```
ident!{...}
```

```
ident![...]
```

```
/*...*/
```

```
/*!...*/
```

```
/**...*/
```

```
(expr)
```

```
(expr,)
```

```
(type,)
```

```
(expr, ...)
```

```
(type, ...)
```

```
expr(expr, ...)
```

```
stru

> [Contenido truncado — consulta el capítulo completo con knowledge read]
