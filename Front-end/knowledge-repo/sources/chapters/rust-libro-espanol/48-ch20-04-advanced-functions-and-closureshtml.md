# Ch20 04 advanced functions and closures.html

# El Lenguaje de Programación Rust

## Funciones y Closures Avanzados

### Function Pointers

### Retornando Closures

Esta sección cubre algunas características avanzadas relacionadas con
funciones y closures, incluyendo punteros a funciones y retornar closures.

Hemos hablado de cómo pasar closures a funciones; ¡también puedes pasar
funciones regulares a funciones! Esta técnica es útil cuando quieres pasar una
función que ya has definido en lugar de definir un nuevo closure. Las funciones
se coercen al tipofn(con unafminúscula), no confundir con el trait de
cierreFn. El tipofnse llamapuntero a función. Pasar funciones con
punteros a función te permitirá usar funciones como argumentos para otras
funciones.

La sintaxis para especificar que un parámetro es un puntero a función es
similar a la de los closures, como se muestra en el Listado 20-28, donde hemos
definido una funciónadd_oneque suma uno a su parámetro. La funcióndo_twicetoma dos parámetros: un puntero a función a cualquier función que
tome un parámetroi32y devuelva uni32, y un valori32. La funcióndo_twicellama a la funciónfdos veces, pasándole el valorarg, luego
suma los dos resultados de la llamada a la función. La funciónmainllama ado_twicecon los argumentosadd_oney5.

Este código imprimeThe answer is: 12. Especificamos que el parámetrofendo_twicees unfnque toma un parámetro de tipoi32y devuelve uni32.
Luego podemos llamar afen el cuerpo dedo_twice. Enmain, podemos pasar
el nombre de la funciónadd_onecomo el primer argumento ado_twice.

A diferencia de los closures,fnes un tipo en lugar de un trait, por lo que
especificamosfncomo el tipo de parámetro directamente en lugar de declarar
un parámetro de tipo genérico con uno de los traitsFncomo un trait bound.

Los punteros a funciones implementan los tres closure traits (Fn,FnMutyFnOnce), lo que significa que siempre puedes pasar un puntero a función como
un argumento para una función que espera un closure. Es mejor escribir
funciones usando un tipo generic y uno de los closure traits para que tus
funciones puedan aceptar funciones o closures.

Dicho esto, un ejemplo de dónde querrías aceptar solofny no closures es
cuando te comunicas con código externo que no tiene closures: las funciones de
C pueden aceptar funciones como argumentos, pero C no tiene closures.

Como ejemplo de dónde podrías usar un closure definido en línea o una función
nombrada, veamos un uso del métodomapproporcionado por el traitIteratoren la biblioteca estándar. Para usar la funciónmappara convertir un vector
de números en un vector de strings, podríamos usar un closure, como en el 
Listado 20-29:

O podríamos nombrar una función como argumento paramapen lugar del
closure. El Listado 20-30 muestra cómo se vería.

Ten en cuenta que debemos utilizar la sintaxis completamente calificada que
mencionamos anteriormente en la sección“Traits avanzados”

Aquí, estamos usando la funciónto_stringdefinida en el traitToString,
que la biblioteca estándar ha implementado para cualquier tipo que implementeDisplay.

Recuerda la sección“Valores de Enum”del
Capítulo 6, que el nombre de cada variante de enum que definimos también se
convierte en una función inicializadora. Podemos usar estas funciones
inicializadoras como punteros a función que implementan los closure traits,
lo que significa que podemos especificar las funciones inicializadoras como
argumentos para los métodos que toman closures, como puedes ver en el 
Listado 20-31:

Aquí creamos instancias deStatus::Valueusando cada valoru32en el rango
en el que se llama amapusando la función inicializadora deStatus::Value.
A algunas personas les gusta este estilo, y a otras les gusta usar closures.
Compilan al mismo código, así que usa el estilo que sea más claro para ti.

Las closures están representadas por traits, lo que significa que no puedes 
retornar closures directamente. En la mayoría de los casos en los que podrías 
querer devolver un trait, en su lugar puedes usar el tipo concreto que 
implementa el trait como valor de retorno de la función. Sin embargo, no puedes 
hacer eso con closures porque no tienen un tipo concreto que sea retornable; por 
ejemplo, no está permitido usar el puntero a funciónfncomo tipo de retorno.

En su lugar, normalmente usarás la sintaxisimpl Traitque aprendimos en el 
Capítulo 10. Puedes devolver cualquier tipo de función, usandoFn,FnOnceyFnMut. Por ejemplo, el código en el Listado 20-32 funcionará perfectamente.

Sin embargo, como mencionamos en“Inferencia y anotación de tipos en closures”en el Capítulo 13, cada closure también es un tipo distinto por sí mismo. Si 
necesitas trabajar con múltiples funciones que tienen la misma firma pero 
diferentes implementaciones, tendrás que usar un trait object para ellas. 
Considera qué sucede si escribes un código como el que se muestra en el 
Listado 20-33.

Aquí tenemos dos funciones,returns_closureyreturns_initialized_closure, 
que ambas retornanimpl Fn(i32) -> i32. Observa que los closures que devuelven 
son diferentes, aunque implementan el mismo tipo. Si intentamos compilar esto, 
Rust nos indica que no funcionará:

El mensaje de error nos indica que cada vez que retornamos unimpl Trait, 
Rust crea untipo opacoúnico, un tipo cuyos detalles no podemos ver ni 
conocer cómo Rust lo construye. Así, aunque estas funciones retornan closures 
que implementan el mismo trait,Fn(i32) -> i32, los tipos opacos que Rust 
genera para cada una son distintos. (Esto es similar a cómo Rust produce tipos 
concretos diferentes para bloquesasyncdistintos, incluso cuando tienen el 
mismo tipo de salida, como vimos en“Trabajando con cualquier número de futuros”en el 
Capítulo 17). Hemos visto una solución para este problema varias veces: podemos 
usar un trait objeto, como en el Listado 20-34.

Este código se compilará sin problemas. Para más información sobre 
trait objects, consulta la sección“Usando trait objects que permiten valores 
de diferentes tipos”en el Capítulo 18.

¡Ahora, veamos las macros!

## Código

```
add_one
```

```
do_twice
```

```
do_twice
```

```
do_twice
```

```
add_one
```

```
fnadd_one(x:i32) ->i32{
    x +1}fndo_twice(f:fn(i32) ->i32, arg:i32) ->i32{
    f(arg) + f(arg)
}fnmain() {letanswer = do_twice(add_one,5);println!("The answer is: {answer}");
}
```

```
fnadd_one(x:i32) ->i32{
    x +1}fndo_twice(f:fn(i32) ->i32, arg:i32) ->i32{
    f(arg) + f(arg)
}fnmain() {letanswer = do_twice(add_one,5);println!("The answer is: {answer}");
}
```

```
fnadd_one(x:i32) ->i32{
    x +1}fndo_twice(f:fn(i32) ->i32, arg:i32) ->i32{
    f(arg) + f(arg)
}fnmain() {letanswer = do_twice(add_one,5);println!("The answer is: {answer}");
}
```

```
The answer is: 12
```

```
do_twice
```

```
do_twice
```

```
add_one
```

```
do_twice
```

```
FnOnce
```

```
Iterator
```

```
fnmain() {letlist_of_numbers =vec![1,2,3];letlist_of_strings:Vec<String> =
        list_of_numbers.iter().map(|i| i.to_string()).collect();}
```

```
fnmain() {letlist_of_numbers =vec![1,2,3];letlist_of_strings:Vec<String> =
        list_of_numbers.iter().map(|i| i.to_string()).collect();}
```

```
fnmain() {letlist_of_numbers =vec![1,2,3];letlist_of_strings:Vec<String> =
        list_of_numbers.iter().map(|i| i.to_string()).collect();}
```

```
fnmain() {letlist_of_numbers =vec![1,2,3];letlist_of_strings:Vec<String> =
        list_of_numbers.iter().map(ToString::to_string).collect();}
```

```
fnmain() {letlist_of_numbers =vec![1,2,3];letlist_of_strings:Vec<String> =
        list_of_numbers.iter().map(ToString::to_string).collect();}
```

```
fnmain() {letlist_of_numbers =vec![1,2,3];letlist_of_strings:Vec<String> =
        list_of_numbers.iter().map(ToString::to_string).collect();}
```

```
to_string
```

```
ToString
```

```
Display
```

```
fnmain() {enumStatus{
        Value(u32),
        Stop,
    }letlist_of_statuses:Vec<Status> = (0u32..20).map(Status::Value).collect();}
```

```
fnmain() {enumStatus{
        Value(u32),
        Stop,
    }letlist_of_statuses:Vec<Status> = (0u32..20).map(Status::Value).collect();}
```

```
fnmain() {enumStatus{
        Value(u32),
        Stop,
    }letlist_of_statuses:Vec<Status> = (0u32..20).map(Status::Value).collect();}
```

```
Status::Value
```

```
Status::Value
```

```
impl Trait
```

```
FnOnce
```

```
#![allow(unused)]fnmain() {fnreturns_closure() ->implFn(i32) ->i32{
    |x| x +1}}
```

```
#![allow(unused)]fnmain() {fnreturns_closure() ->implFn(i32) ->i32{
    |x| x +1}}
```

```
#![allow(unused)]fnmain() {fnreturns_closure() ->implFn(i32) ->i32{
    |x| x +1}}
```

```
fnmain() {lethandlers =vec![returns_closure(), returns_initialized_closure(123)];forhandlerinhandlers {letoutput = handler(5);println!("{output}");
    }
}fnreturns_closure() ->implFn(i32) ->i32{
    |x| x +1}fnreturns_initialized_closure(init:i32) ->implFn(i32) ->i32{move|x| x + init
}
```

```
fnmain() {lethandlers =vec![returns_closure(), returns_initialized_closure(123)];forhandlerinhandlers {letoutput = handler(5);println!("{output}");
    }
}fnreturns_closure() ->implFn(i32) ->i32{
    |x| x +1}fnreturns_initialized_closure(init:i32) ->implFn(i32) ->i32{move|x| x + init
}
```

```
returns_closure
```

```
returns_initialized_closure
```

```
impl Fn(i32) -> i32
```

```
$ cargo build
   Compiling functions-example v0.1.0 (file:///projects/functions-example)
error[E0308]: mismatched types
  --> src/main.rs:2:44
   |
2  |     let handlers = vec![returns_closure(), returns_initialized_closure(123)];
   |                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ expected opaque type, found a different opaque type
...
9  | fn returns_closure() -> impl Fn(i32) -> i32 {
   |                         ------------------- the expected opaque type
...
13 | fn returns_initialized_closure(init: i32) -> impl Fn(i32) -> i32 {
   |                                              ------------------- the found opaque type
   |
   = note: expected opaque type `impl Fn(i32) -> i32` (opaque type at <src/main.rs:9:25>)
              found opaque type `impl Fn(i32) -> i32` (opaque type at <src/main.rs:13:46>)
   = note: distinct uses of `impl Trait` result in different opaque types

For more information about this error, try `rustc --explain E0308`.
error: could not compile `functions-example` (bin "functions-example") due to 1 previous error
```

```
$ cargo build
   Compiling functions-example v0.1.0 (file:///projects/functions-example)
error[E0308]: mismatched types
  --> src/main.rs:2:44
   |
2  |     let handlers = vec![returns_closure(), returns_initialized_closure(123)];
   |                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ expected opaque type, found a different opaque type
...
9  | fn returns_closure() -> impl Fn(i32) -> i32 {
   |                         ------------------- the expected opaque type
...
13 | fn returns_initialized_closure(init: i32) -> impl Fn(i32) -> i32 {
   |                                              ------------------- the found opaque type
   |
   = note: expected opaque type `impl Fn(i32) -> i32` (opaque type at <src/main.rs:9:25>)
              found opaque type `impl Fn(i32) -> i32` (opaque type at <src/main.rs:13:46>)
   = note: distinct uses of `impl Trait` result in different opaque types

For more information about this error, try `rustc --explain E0308`.
error: could not compile `functions-example` (bin "functions-example") due to 1 previous error
```

```
impl Trait
```

```
Fn(i32) -> i32
```

```
fnmain() {lethandlers =vec![returns_closure(), returns_initialized_closure(123)];forhandlerinhandlers {letoutput = handler(5);println!("{output}");}}fnreturns_closure() ->Box<dynFn(i32) ->i32> {Box::new(|x| x +1)
}fnreturns_initialized_closure(init:i32) ->Box<dynFn(i32) ->i32> {Box::new(move|x| x + init)
}
```

```
fnmain() {lethandlers =vec![returns_closure(), returns_initialized_closure(123)];forhandlerinhandlers {letoutput = handler(5);println!("{output}");}}fnreturns_closure() ->Box<dynFn(i32) ->i32> {Box::new(|x| x +1)
}fnreturns_initialized_closure(init:i32) ->Box<dynFn(i32) ->i32> {Box::new(move|x| x + init)
}
```

```
fnmain() {lethandlers =vec![returns_closure(), returns_initialized_closure(123)];forhandlerinhandlers {letoutput = handler(5);println!("{output}");}}fnreturns_closure() ->Box<dynFn(i32) ->i32> {Box::new(|x| x +1)
}fnreturns_initialized_closure(init:i32) ->Box<dynFn(i32) ->i32> {Box::new(move|x| x + init)
}
```

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