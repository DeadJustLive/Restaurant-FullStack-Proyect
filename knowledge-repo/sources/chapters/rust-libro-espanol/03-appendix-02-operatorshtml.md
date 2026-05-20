# Appendix 02 operators.html

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
struct
```

```
expr.0
```

```
expr.1
```

```
Type {...}
```

```
struct
```

```typescript
[type; expr]
```

```
expr[expr]
```

```
IndexMut
```

```
expr[..]
```

```
expr[a..]
```

```
expr[..b]
```

```
expr[a..b]
```

```
RangeFrom
```

```
RangeTo
```

```
RangeFull
```

| Operador | Ejemplo | Explicación | Sobrecargable? |
| --- | --- | --- | --- |
| ! | ident!(...),ident!{...},ident![...] | Expansor de Macros |
| ! | !expr | Operador bit a bit o complemento lógico | Not |
| != | expr != expr | Comparador de No Igualdad | PartialEq |
| % | expr % expr | Modulo | Rem |
| %= | var %= expr | Modulo y asignación | RemAssign |
| & | &expr,&mut expr | Préstamo |
| & | &type,&mut type,&'a type,&'a mut type | Préstamo del puntero del tipo |
| & | expr & expr | Operador bit a bit AND | BitAnd |
| &= | var &= expr | Operador bit a bit AND y asignación | BitAndAssign |
| && | expr && expr | Operador lógico AND |
| * | expr * expr | Multiplicación | Mul |
| *= | var *= expr | Multiplicación y asignación | MulAssign |
| * | *expr | Direferencia | Deref |
| * | *const type,*mut type | Puntero |
| + | trait + trait,'a + trait | Restricción de tipo compuesta |
| + | expr + expr | Aritmético adición | Add |
| += | var += expr | Adición y asignación | AddAssign |
| , | expr, expr | Separador de argumentos y elementos |
| - | - expr | Aritmético de Negación | Neg |
| - | expr - expr | Aritmético de sustracción | Sub |
| -= | var -= expr | Aritmético de sustracción y asignación | SubAssign |
| -> | fn(...) -> type,\|...\| -> type | Tipo de retorno en funciones y clausuras |
| . | expr.ident | Acceso a atributo |
| . | expr.ident(expr, ...) | Llamada a método |
| . | expr.0,expr.1, etc. | Indexación de tuplas |
| .. | ..,expr..,..expr,expr..expr | Rango exclusivo a la derecha | PartialOrd |
| ..= | ..=expr,expr..=expr | Rango inclusivo a la derecha | PartialOrd |
| .. | ..expr | Sintaxis de actualización de estructuras |
| .. | variant(x, ..),struct_type { x, .. } | Patrón “y el resto” |
| ... | expr...expr | (Obsoleto, use..=en su lugar) En un patrón: Patrón de rango inclusivo |

| Símbolos | Explicación |
| --- | --- |
| 'ident | Lifetime nombrado o etiqueta de bucle |
| ...u8,...i32,...f64,...usize, etc. | Literal numérico de un tipo especifico |
| "..." | Literal de tipo String |
| r"...",r#"..."#,r##"..."##, etc. | Literal de tipo String sin procesar |
| b'...' | Literal de tipo byte; construye un array de bytes en lugar de una cadena |
| br"...",br#"..."#,br##"..."##, etc. | Literal de tipo String sin procesar, combinación de literal de tipo String y lit |
| '...' | Literal de tipo caracter |
| b'...' | Literal de tipo byte ASCII |
| \|...\| expr | Clausura |
| ! | Tipo de dato vacío siempre vacío para funciones divergentes |
| _ | “Ignored” patrón de enlace; también se usa para hacer que los literales enteros  |

| Símbolos | Explicación |
| --- | --- |
| ident::ident | Ruta del Namespace |
| ::path | Ruta relativa al prelude externo, donde están enraizados todos los demás crates  |
| self::path | Ruta relativa al módulo actual (es decir, una ruta explícitamente relativa). |
| super::path | Ruta relativa al módulo padre del módulo actual |
| type::ident,<type as trait>::ident | Constantes, funciones y tipos asociados |
| <type>::... | Elemento asociado a un tipo que no puede nombrarse directamente (por ejemplo,<&T |
| trait::method(...) | Desambiguar una llamada a un método nombrando el trait que lo define |
| type::method(...) | Desambiguar una llamada a un método nombrando el tipo para el cual está definido |
| <type as trait>::method(...) | Desambiguar una llamada a un método nombrando tanto el trait como el tipo |

| Símbolos | Explicación |
| --- | --- |
| path<...> | Especifica parámetros de tipo genérico en un tipo (por ejemplo,Vec<u8>) |
| path::<...>,method::<...> | Especifica parámetros de tipo genérico, función o método en una expresión; a men |
| fn ident<...> ... | Define una función genérica |
| struct ident<...> ... | Define una estructura genérica |
| enum ident<...> ... | Define una enumeración genérica |
| impl<...> ... | Define una implementación genérica |
| for<...> type | Límites de vida de rango superior |
| type<ident=type> | Un tipo genérico donde uno o más tipos asociados tienen asignaciones específicas |

| Simbolos | Explicación |
| --- | --- |
| T: U | Parámetro de tipo genéricoTrestringido a tipos que implementanU |
| T: 'a | Tipo genéricoTdebe sobrevivir al tiempo de vida'a(es decir, el tipo no puede con |
| T: 'static | Tipo genéricoTno contiene referencias prestadas, excepto las de'static |
| 'b: 'a | Tiempo de vida genérico'bdebe sobrevivir al tiempo de vida'a |
| T: ?Sized | Permitir que el parámetro de tipo genérico sea un tipo de tamaño dinámico |
| 'a + trait,trait + trait | Restricción de tipo compuesta |

| Símbolos | Explicación |
| --- | --- |
| #[meta] | Atributo externo |
| #![meta] | Atributo interno |
| $ident | Sustitución de macro |
| $ident:kind | Captura de macro |
| $(...)... | Repetición de macro |
| ident!(...),ident!{...},ident![...] | Invocación de macro |

| Símbolos | Explicación |
| --- | --- |
| // | Comentario de línea |
| //! | Comentario de línea de documentación interna |
| /// | Comentario de línea de documentación externa |
| /*...*/ | Comentario de bloque |
| /*!...*/ | Comentario de bloque de documentación interna |
| /**...*/ | Comentario de bloque de documentación externa |

| Símbolos | Explicación |
| --- | --- |
| () | Tupla vacía (también conocida como unidad), tanto literal como tipo |
| (expr) | Expresión entre paréntesis |
| (expr,) | Expresión de tupla de un solo elemento |
| (type,) | Tipo de tupla de un solo elemento |
| (expr, ...) | Expresión de tupla |
| (type, ...) | Tipo de tupla |
| expr(expr, ...) | Expresión de llamada de función; también se usa para inicializarstructs de tupla |
| expr.0,expr.1, etc. | Índice de tupla |

| Contexto | Explicación |
| --- | --- |
| {...} | Expresión de bloque |
| Type {...} | Literal destruct |

| Contexto | Explicación |
| --- | --- |
| [...] | Expresión de arreglo |
| [type; expr] | Arreglo de tipo y tamaño |
| expr[expr] | Índice de colección. Sobrecargable (Index,IndexMut) |
| expr[..],expr[a..],expr[..b],expr[a..b] | Índice de colección fingiendo ser recortes de colección, usandoRange,RangeFrom,R |

- El Lenguaje de Programación Rust
- Prefacio
- Introducción
- 1.Empezando
- 1.1.Instalación1.2.¡Hola, Mundo!1.3.¡Hola, Cargo!
- 1.1.Instalación
- 1.2.¡Hola, Mundo!
- 1.3.¡Hola, Cargo!
- 2.Programando un juego de adivinanzas
- 3.Conceptos Comunes de Programación
- 3.1.Variables y Mutabilidad3.2.Tipos de Datos3.3.Funciones3.4.Comentarios3.5.Flujo de Control
- 3.1.Variables y Mutabilidad
- 3.2.Tipos de Datos
- 3.3.Funciones
- 3.4.Comentarios
- 3.5.Flujo de Control
- 4.Entendiendo el Ownership
- 4.1.¿Qué es el Ownership?4.2.Referencias y Prestamos4.3.El Tipo Slice
- 4.1.¿Qué es el Ownership?
- 4.2.Referencias y Prestamos
- 4.3.El Tipo Slice
- 5.Usando Structs para Estructurar Datos Relacionados
- 5.1.Definiendo e Instanciando Structs5.2.Un Programa de Ejemplo Usando Structs5.3.Sintaxis de Métodos
- 5.1.Definiendo e Instanciando Structs
- 5.2.Un Programa de Ejemplo Usando Structs
- 5.3.Sintaxis de Métodos
- 6.Enums y Pattern Matching
- 6.1.Definiendo un Enum6.2.El operador de control de flujo match6.3.Flujo de Control Conciso con if let y let else
- 6.1.Definiendo un Enum
- 6.2.El operador de control de flujo match
- 6.3.Flujo de Control Conciso con if let y let else
- 7.Administrando Proyectos en Crecimiento con Paquetes, Crates y Módulos
- 7.1.Paquetes y Crates7.2.Definiendo módulos para controlar el scope y la privacidad7.3.Paths para referirse a un item en el árbol de módulos7.4.Incluyendo rutas al Scope con la palabra clave use7.5.Separando Módulos en Diferentes Archivos
- 7.1.Paquetes y Crates
- 7.2.Definiendo módulos para controlar el scope y la privacidad
- 7.3.Paths para referirse a un item en el árbol de módulos
- 7.4.Incluyendo rutas al Scope con la palabra clave use
- 7.5.Separando Módulos en Diferentes Archivos
- 8.Colecciones comunes
- 8.1.Almacenando listas de valores con vectores8.2.Almacenando texto codificado en UTF-8 con Strings8.3.Almacenar Claves con Valores Asociados en HashMaps
- 8.1.Almacenando listas de valores con vectores
- 8.2.Almacenando texto codificado en UTF-8 con Strings
- 8.3.Almacenar Claves con Valores Asociados en HashMaps
- 9.Manejo de Errores
- 9.1.Errores irrecuperables con panic!9.2.Errores recuperables con Result9.3.panic! o no panic!
- 9.1.Errores irrecuperables con panic!
- 9.2.Errores recuperables con Result
- 9.3.panic! o no panic!
- 10.Tipos Genéricos, Traits y Lifetimes
- 10.1.Tipos de Datos Genéricos10.2.Traits: Definiendo Comportamiento Compartido10.3.Validando Referencias con Lifetimes
- 10.1.Tipos de Datos Genéricos
- 10.2.Traits: Definiendo Comportamiento Compartido
- 10.3.Validando Referencias con Lifetimes
- 11.Escribiendo Tests Automatizados
- 11.1.Cómo Escribir Tests11.2.Controlando Cómo Los Tests Son Ejecutados11.3.Organización De Los Tests
- 11.1.Cómo Escribir Tests
- 11.2.Controlando Cómo Los Tests Son Ejecutados
- 11.3.Organización De Los Tests
- 12.Un proyecto de I/O: Construyendo un programa de línea de comandos
- 12.1.Aceptando argumentos de línea de comandos12.2.Leyendo un archivo12.3.Refactorizando para mejorar la modularidad y el manejo de errores12.4.Desarrollando la funcionalidad de la biblioteca con T.D.D.12.5.Trabajando con Variables de Entorno12.6.Escribiendo mensajes de error estándar en lugar del output estándar
- 12.1.Aceptando argumentos de línea de comandos
- 12.2.Leyendo un archivo
- 12.3.Refactorizando para mejorar la modularidad y el manejo de errores
- 12.4.Desarrollando la funcionalidad de la biblioteca con T.D.D.
- 12.5.Trabajando con Variables de Entorno
- 12.6.Escribiendo mensajes de error estándar en lugar del output estándar
- 13.Características De Lenguajes Funcionales: Iteradores y Closures
- 13.1.Closures: Funciones anónimas que capturan su entorno13.2.Procesando una serie de elementos con Iteradores13.3.Mejorando nuestro proyecto I/O13.4.Comparando Performance: Bucles vs. Iteradores
- 13.1.Closures: Funciones anónimas que capturan su entorno
- 13.2.Procesando una serie de elementos con Iteradores
- 13.3.Mejorando nuestro proyecto I/O
- 13.4.Comparando Performance: Bucles vs. Iteradores
- 14.Más sobre Cargo y Crates.io
- 14.1.Personalizando Compilaciones con Perfiles de Lanzamiento14.2.Publicando un Crate a Crates.io14.3.Cargo Workspaces14.4.Instalando Binarios con cargo install14.5.Extendiendo Cargo con Comandos Personalizados
- 14.1.Personalizando Compilaciones con Perfiles de Lanzamiento
- 14.2.Publicando un Crate a Crates.io
- 14.3.Cargo Workspaces
- 14.4.Instalando Binarios con cargo install
- 14.5.Extendiendo Cargo con Comandos Personalizados
- 15.Smart Pointers
- 15.1.Usando Box<T> para Apuntar a Datos en el Heap15.2.Tratando los Smart Pointers como Referencias Regulares con el Trait Deref15.3.Ejecutando Código al Limpiar con el Trait Drop15.4.Rc<T>, el Smart Pointer de Conteo de Referencias15.5.RefCell<T> y el Patrón de Mutabilidad Interior15.6.Referencias Circulares Pueden Fugar Memoria
- 15.1.Usando Box<T> para Apuntar a Datos en el Heap
- 15.2.Tratando los Smart Pointers como Referencias Regulares con el Trait Deref
- 15.3.Ejecutando Código al Limpiar con el Trait Drop
- 15.4.Rc<T>, el Smart Pointer de Conteo de Referencias
- 15.5.RefCell<T> y el Patrón de Mutabilidad Interior
- 15.6.Referencias Circulares Pueden Fugar Memoria
- 16.Concurrencia sin miedo
- 16.1.Usando Threads para Ejecutar Código Simultáneamente16.2.Usando el Pasaje de Mensajes para Transferir Datos entre Hilos16.3.Concurrencia con Estado Compartido16.4.Concurrencia extensible con los traits Sync y Send
- 16.1.Usando Threads para Ejecutar Código Simultáneamente
- 16.2.Usando el Pasaje de Mensajes para Transferir Datos entre Hilos
- 16.3.Concurrencia con Estado Compartido
- 16.4.Concurrencia extensible con los traits Sync y Send
- 17.Fundamentos de la Programación Asíncrona: Async, Await, Futures y Streams
- 17.1.Futures y la sintaxis Async17.2.Aplicando Concurrencia Con Async17.3.Trabajar con cualquier número de futuros17.4.Streams17.5.Profundizando en los Traits para Async17.6.Futuros, tareas e hilos
- 17.1.Futures y la sintaxis Async
- 17.2.Aplicando Concurrencia Con Async
- 17.3.Trabajar con cualquier número de futuros
- 17.4.Streams
- 17.5.Profundizando en los Traits para Async
- 17.6.Futuros, tareas e hilos
- 18.Rust como un Lenguaje de Programación Orientado a Objetos
- 18.1.Características de Lenguajes Orientados a Objetos18.2.Usando Trait Objects que Permiten Valores de Diferentes Tipos18.3.Implementando un Patrón de Diseño Orientado a Objetos
- 18.1.Características de Lenguajes Orientados a Objetos
- 18.2.Usando Trait Objects que Permiten Valores de Diferentes Tipos
- 18.3.Implementando un Patrón de Diseño Orientado a Objetos
- 19.Patterns and Matching
- 19.1.Todos los lugares donde se pueden usar Patterns19.2.Refutabilidad: Si un Pattern Puede Fallar al Hacer Match19.3.Sintaxis de los Patterns
- 19.1.Todos los lugares donde se pueden usar Patterns
- 19.2.Refutabilidad: Si un Pattern Puede Fallar al Hacer Match
- 19.3.Sintaxis de los Patterns
- 20.Características Avanzadas
- 20.1.Rust Inseguro20.2.Traits Avanzados20.3.Tipos Avanzados20.4.Funciones y Closures Avanzados20.5.Macros
- 20.1.Rust Inseguro
- 20.2.Traits Avanzados
- 20.3.Tipos Avanzados
- 20.4.Funciones y Closures Avanzados
- 20.5.Macros
- 21.Proyecto Final: Construyendo un Servidor Web Multithread
- 21.1.Construyendo un Servidor Web de un Solo Hilo21.2.Convirtiendo Nuestro Servidor de un solo Hilo en un Servidor Multihilo21.3.Apagado y limpieza eficientes
- 21.1.Construyendo un Servidor Web de un Solo Hilo
- 21.2.Convirtiendo Nuestro Servidor de un solo Hilo en un Servidor Multihilo
- 21.3.Apagado y limpieza eficientes
- 22.Apéndice
- 22.1.A - Palabras claves22.2.B - Operadores y Símbolos22.3.C - Traits derivables22.4.D - Herramientas de desarrollo útiles22.5.E - Ediciones22.6.F - Traducciones del libro22.7.G - Cómo se hace Rust y “Rust Nightly”
- 22.1.A - Palabras claves
- 22.2.B - Operadores y Símbolos
- 22.3.C - Traits derivables
- 22.4.D - Herramientas de desarrollo útiles
- 22.5.E - Ediciones
- 22.6.F - Traducciones del libro
- 22.7.G - Cómo se hace Rust y “Rust Nightly”

- 1.1.Instalación
- 1.2.¡Hola, Mundo!
- 1.3.¡Hola, Cargo!

- 3.1.Variables y Mutabilidad
- 3.2.Tipos de Datos
- 3.3.Funciones
- 3.4.Comentarios
- 3.5.Flujo de Control

- 4.1.¿Qué es el Ownership?
- 4.2.Referencias y Prestamos
- 4.3.El Tipo Slice

- 5.1.Definiendo e Instanciando Structs
- 5.2.Un Programa de Ejemplo Usando Structs
- 5.3.Sintaxis de Métodos

- 6.1.Definiendo un Enum
- 6.2.El operador de control de flujo match
- 6.3.Flujo de Control Conciso con if let y let else

- 7.1.Paquetes y Crates
- 7.2.Definiendo módulos para controlar el scope y la privacidad
- 7.3.Paths para referirse a un item en el árbol de módulos
- 7.4.Incluyendo rutas al Scope con la palabra clave use
- 7.5.Separando Módulos en Diferentes Archivos

- 8.1.Almacenando listas de valores con vectores
- 8.2.Almacenando texto codificado en UTF-8 con Strings
- 8.3.Almacenar Claves con Valores Asociados en HashMaps

- 9.1.Errores irrecuperables con panic!
- 9.2.Errores recuperables con Result
- 9.3.panic! o no panic!

- 10.1.Tipos de Datos Genéricos
- 10.2.Traits: Definiendo Comportamiento Compartido
- 10.3.Validando Referencias con Lifetimes

- 11.1.Cómo Escribir Tests
- 11.2.Controlando Cómo Los Tests Son Ejecutados
- 11.3.Organización De Los Tests

- 12.1.Aceptando argumentos de línea de comandos
- 12.2.Leyendo un archivo
- 12.3.Refactorizando para mejorar la modularidad y el manejo de errores
- 12.4.Desarrollando la funcionalidad de la biblioteca con T.D.D.
- 12.5.Trabajando con Variables de Entorno
- 12.6.Escribiendo mensajes de error estándar en lugar del output estándar

- 13.1.Closures: Funciones anónimas que capturan su entorno
- 13.2.Procesando una serie de elementos con Iteradores
- 13.3.Mejorando nuestro proyecto I/O
- 13.4.Comparando Performance: Bucles vs. Iteradores

- 14.1.Personalizando Compilaciones con Perfiles de Lanzamiento
- 14.2.Publicando un Crate a Crates.io
- 14.3.Cargo Workspaces
- 14.4.Instalando Binarios con cargo install
- 14.5.Extendiendo Cargo con Comandos Personalizados

- 15.1.Usando Box<T> para Apuntar a Datos en el Heap
- 15.2.Tratando los Smart Pointers como Referencias Regulares con el Trait Deref
- 15.3.Ejecutando Código al Limpiar con el Trait Drop
- 15.4.Rc<T>, el Smart Pointer de Conteo de Referencias
- 15.5.RefCell<T> y el Patrón de Mutabilidad Interior
- 15.6.Referencias Circulares Pueden Fugar Memoria

- 16.1.Usando Threads para Ejecutar Código Simultáneamente
- 16.2.Usando el Pasaje de Mensajes para Transferir Datos entre Hilos
- 16.3.Concurrencia con Estado Compartido
- 16.4.Concurrencia extensible con los traits Sync y Send

- 17.1.Futures y la sintaxis Async
- 17.2.Aplicando Concurrencia Con Async
- 17.3.Trabajar con cualquier número de futuros
- 17.4.Streams
- 17.5.Profundizando en los Traits para Async
- 17.6.Futuros, tareas e hilos

- 18.1.Características de Lenguajes Orientados a Objetos
- 18.2.Usando Trait Objects que Permiten Valores de Diferentes Tipos
- 18.3.Implementando un Patrón de Diseño Orientado a Objetos

- 19.1.Todos los lugares donde se pueden usar Patterns
- 19.2.Refutabilidad: Si un Pattern Puede Fallar al Hacer Match
- 19.3.Sintaxis de los Patterns

- 20.1.Rust Inseguro
- 20.2.Traits Avanzados
- 20.3.Tipos Avanzados
- 20.4.Funciones y Closures Avanzados
- 20.5.Macros

- 21.1.Construyendo un Servidor Web de un Solo Hilo
- 21.2.Convirtiendo Nuestro Servidor de un solo Hilo en un Servidor Multihilo
- 21.3.Apagado y limpieza eficientes

- 22.1.A - Palabras claves
- 22.2.B - Operadores y Símbolos
- 22.3.C - Traits derivables
- 22.4.D - Herramientas de desarrollo útiles
- 22.5.E - Ediciones
- 22.6.F - Traducciones del libro
- 22.7.G - Cómo se hace Rust y “Rust Nightly”

- Light (default)
- Rust
- Coal
- Navy
- Ayu
- Latte
- Frappé
- Macchiato
- Mocha