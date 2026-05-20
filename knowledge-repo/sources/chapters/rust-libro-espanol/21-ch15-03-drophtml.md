# Ch15 03 drop.html

# El Lenguaje de Programación Rust

## Ejecutando Código al Limpiar con el TraitDrop

### Droppeando un valor temprano constd::mem::drop

El segundo trait importante para el patrón de smart pointer esDrop, el cual
permite personalizar qué pasa cuando un valor está a punto de salir del scope.
Puedes proveer una implementación para el traitDropen cualquier tipo, y ese
código puede ser usado para liberar recursos como archivos o conexiones de
red.

Estamos introduciendoDropen el contexto de smart pointers porque la
funcionalidad del traitDropes casi siempre usada cuando se implementa un
smart pointer. Por ejemplo, cuando unBox<T>es dropeado, desasignará el
espacio en el heap al que el box apunta.

En algunos lenguajes, para algunos tipos, el programador debe llamar código
para liberar memoria o recursos cada vez que terminan de usar una instancia de
esos tipos. Ejemplos incluyen manejadores de archivos, sockets, o locks. Si se
olvidan, el sistema podría sobrecargarse y colapsar. En Rust, puedes especificar
que un pedazo particular de código sea ejecutado cada vez que un valor sale del
scope, y el compilador insertará este código automáticamente. Como resultado,
no necesitas ser cuidadoso sobre colocar código de limpieza en todos lados en
un programa que una instancia de un tipo particular está terminada con él—¡aún
no se fugarán recursos!

Puedes especificar el código a ejecutar cuando un valor sale del scope
implementando el traitDrop. El traitDroprequiere que implementes un
método llamadodropque toma una referencia mutable aself. Para ver cuándo
Rust llama adrop, implementemosdropcon declaracionesprintln!por
ahora.

Listing 15-14 muestra una estructuraCustomSmartPointercuya única
funcionalidad personalizada es que imprimiráDropping CustomSmartPointer!cuando la instancia sale del scope, para mostrar cuándo Rust ejecuta la
funcióndrop.

El traitDropestá incluido en el prelude, así que no necesitamos traerlo al
scope. Implementamos el traitDropenCustomSmartPointery proveemos una
implementación para el métododropque llama aprintln!. El cuerpo de la
funcióndropes donde colocarías cualquier lógica que quisieras correr cuando
una instancia de tu tipo sale del scope. Estamos imprimiendo un texto aquí para
demostrar visualmente cuándo Rust llamará adrop.

Enmain, creamos dos instancias deCustomSmartPointery luego imprimimosCustomSmartPointers created. Al final demain, nuestras instancias deCustomSmartPointersaldrán del scope, y Rust llamará al código que colocamos
en el métododrop, imprimiendo nuestro mensaje final. Nota que no necesitamos
llamar al métododropexplícitamente.

Cuando ejecutemos este programa, veremos el siguiente output:

Rust automáticamente llamó adroppara nosotros cuando nuestras instancias
salieron del scope, llamando al código que especificamos. Las variables son
dropeadas en el orden inverso a su creación, así quedfue dropeada antes quec. El propósito de este ejemplo es darte una guía visual de cómo funciona el
métododrop; usualmente especificarías el código de limpieza que tu tipo
necesita correr en lugar de un mensaje de impresión.

Desafortunadamente, no es sencillo deshabilitar la funcionalidad automática dedrop. Deshabilitardropusualmente no es necesario; el punto entero del
traitDropes que se encarga automáticamente. Ocasionalmente, sin embargo,
podrías querer limpiar un valor temprano. Un ejemplo es cuando usas smart
pointers que manejan locks: podrías querer forzar el métododropque libera
el lock para que otro código en el mismo scope pueda adquirir el lock. Rust no
te deja llamar al métododropdel traitDropmanualmente; en lugar de eso
tienes que llamar a la funciónstd::mem::dropprovista por la librería
estándar si quieres forzar a un valor a ser dropeado antes del final de su
scope.

Si intentamos llamar manualmente al métododropdel traitDropmodificando 
la funciónmaindel Listado 15-14, como se muestra en el Listado 15-15, 
obtendremos un error del compilador.

Cuando nosotros intentemos compilar este código, obtendremos el siguiente error:

Este mensaje de error indica que no se nos permite llamar adropexplícitamente. El mensaje de error usa el términodestructor, que es el 
término general de programación para una función que limpia una instancia. 
Undestructores análogo a unconstructor, que crea una instancia. 
La funcióndropen Rust es un destructor particular.

Rust no nos deja llamar adropexplícitamente porque Rust llamaría
automáticamente adropen el valor al final demain. Esto causaría un error
dedouble freeporque Rust intentaría limpiar el mismo valor dos veces.

No podemos desactivar la inserción automática dedropcuando un valor sale
del scope, y no podemos llamar explícitamente al métododrop. Así que, si
necesitamos forzar a un valor a ser limpiado temprano, usamos la funciónstd::mem::drop.

La funciónstd::mem::dropes diferente del métododropen el traitDrop.
La llamamos pasando como argumento el valor que queremos forzar a dropear. La
función está en el prelude, así que podemos modificarmainen el Listado
15-15 para llamar a la funcióndrop, como se muestra en el Listado 15-16.

Ejecutar este código imprimirá lo siguiente:

El textoDropping CustomSmartPointer with data `some data`!es impreso
entre el textoCustomSmartPointer created.yCustomSmartPointer dropped before the end of main., mostrando que el código del métododropes llamado
para dropearcen ese punto.

Puedes utilizar código especificado en una implementación del traitDropde
varias maneras para hacer la limpieza conveniente y segura: por ejemplo,
¡podrías usarlo para crear tu propio allocator de memoria! Con el traitDropy el sistema de ownership de Rust, no tienes que recordar limpiar porque Rust
lo hace automáticamente.

Tampoco tienes que preocuparte por problemas que surjan de limpiar 
accidentalmente valores que aún están en uso: el sistema de ownership que
asegura que las referencias siempre sean válidas también asegura quedropsea
llamado solo una vez cuando el valor ya no está siendo usado.

Ahora que hemos examinadoBox<T>y algunas de las características de los
smart pointers, veamos algunos otros smart pointers definidos en la librería
estándar.

## Código

```
Box<T>
```

```
println!
```

```
CustomSmartPointer
```

```
Dropping CustomSmartPointer!
```

```
structCustomSmartPointer{
    data:String,
}implDropforCustomSmartPointer {fndrop(&mutself) {println!("Dropping CustomSmartPointer with data `{}`!",self.data);
    }
}fnmain() {letc = CustomSmartPointer {
        data:String::from("my stuff"),
    };letd = CustomSmartPointer {
        data:String::from("other stuff"),
    };println!("CustomSmartPointers created.");
}
```

```
structCustomSmartPointer{
    data:String,
}implDropforCustomSmartPointer {fndrop(&mutself) {println!("Dropping CustomSmartPointer with data `{}`!",self.data);
    }
}fnmain() {letc = CustomSmartPointer {
        data:String::from("my stuff"),
    };letd = CustomSmartPointer {
        data:String::from("other stuff"),
    };println!("CustomSmartPointers created.");
}
```

```
structCustomSmartPointer{
    data:String,
}implDropforCustomSmartPointer {fndrop(&mutself) {println!("Dropping CustomSmartPointer with data `{}`!",self.data);
    }
}fnmain() {letc = CustomSmartPointer {
        data:String::from("my stuff"),
    };letd = CustomSmartPointer {
        data:String::from("other stuff"),
    };println!("CustomSmartPointers created.");
}
```

```
CustomSmartPointer
```

```
println!
```

```
CustomSmartPointer
```

```
CustomSmartPointers created
```

```
CustomSmartPointer
```

```
$cargo runCompiling drop-example v0.1.0 (file:///projects/drop-example)
    Finished `dev` profile [unoptimized + debuginfo] target(s) in 0.60s
     Running `target/debug/drop-example`
CustomSmartPointers created.
Dropping CustomSmartPointer with data `other stuff`!
Dropping CustomSmartPointer with data `my stuff`!
```

```
$cargo runCompiling drop-example v0.1.0 (file:///projects/drop-example)
    Finished `dev` profile [unoptimized + debuginfo] target(s) in 0.60s
     Running `target/debug/drop-example`
CustomSmartPointers created.
Dropping CustomSmartPointer with data `other stuff`!
Dropping CustomSmartPointer with data `my stuff`!
```

```
std::mem::drop
```

```
std::mem::drop
```

```
structCustomSmartPointer{data:String,}implDropforCustomSmartPointer {fndrop(&mutself) {println!("Dropping CustomSmartPointer with data `{}`!",self.data);}}fnmain() {letc = CustomSmartPointer {
        data:String::from("some data"),
    };println!("CustomSmartPointer created.");
    c.drop();println!("CustomSmartPointer dropped before the end of main.");
}
```

```
structCustomSmartPointer{data:String,}implDropforCustomSmartPointer {fndrop(&mutself) {println!("Dropping CustomSmartPointer with data `{}`!",self.data);}}fnmain() {letc = CustomSmartPointer {
        data:String::from("some data"),
    };println!("CustomSmartPointer created.");
    c.drop();println!("CustomSmartPointer dropped before the end of main.");
}
```

```
$cargo runCompiling drop-example v0.1.0 (file:///projects/drop-example)
error[E0040]: explicit use of destructor method-->src/main.rs:16:7|
16 |     c.drop();
   |       ^^^^ explicit destructor calls not allowed
   |
help: consider using `drop` function
   |
16 |     drop(c);
   |     +++++ ~

For more information about this error, try `rustc --explain E0040`.
error: could not compile `drop-example` (bin "drop-example") due to 1 previous error
```

```
$cargo runCompiling drop-example v0.1.0 (file:///projects/drop-example)
error[E0040]: explicit use of destructor method-->src/main.rs:16:7|
16 |     c.drop();
   |       ^^^^ explicit destructor calls not allowed
   |
help: consider using `drop` function
   |
16 |     drop(c);
   |     +++++ ~

For more information about this error, try `rustc --explain E0040`.
error: could not compile `drop-example` (bin "drop-example") due to 1 previous error
```

```
std::mem::drop
```

```
std::mem::drop
```

```
structCustomSmartPointer{data:String,}implDropforCustomSmartPointer {fndrop(&mutself) {println!("Dropping CustomSmartPointer with data `{}`!",self.data);}}fnmain() {letc = CustomSmartPointer {
        data:String::from("some data"),
    };println!("CustomSmartPointer created.");drop(c);println!("CustomSmartPointer dropped before the end of main.");
}
```

```
structCustomSmartPointer{data:String,}implDropforCustomSmartPointer {fndrop(&mutself) {println!("Dropping CustomSmartPointer with data `{}`!",self.data);}}fnmain() {letc = CustomSmartPointer {
        data:String::from("some data"),
    };println!("CustomSmartPointer created.");drop(c);println!("CustomSmartPointer dropped before the end of main.");
}
```

```
structCustomSmartPointer{data:String,}implDropforCustomSmartPointer {fndrop(&mutself) {println!("Dropping CustomSmartPointer with data `{}`!",self.data);}}fnmain() {letc = CustomSmartPointer {
        data:String::from("some data"),
    };println!("CustomSmartPointer created.");drop(c);println!("CustomSmartPointer dropped before the end of main.");
}
```

```
$cargo runCompiling drop-example v0.1.0 (file:///projects/drop-example)
    Finished `dev` profile [unoptimized + debuginfo] target(s) in 0.73s
     Running `target/debug/drop-example`
CustomSmartPointer created.
Dropping CustomSmartPointer with data `some data`!
CustomSmartPointer dropped before the end of main.
```

```
$cargo runCompiling drop-example v0.1.0 (file:///projects/drop-example)
    Finished `dev` profile [unoptimized + debuginfo] target(s) in 0.73s
     Running `target/debug/drop-example`
CustomSmartPointer created.
Dropping CustomSmartPointer with data `some data`!
CustomSmartPointer dropped before the end of main.
```

```
Dropping CustomSmartPointer with data `some data`!
```

```
CustomSmartPointer created.
```

```
CustomSmartPointer dropped before the end of main.
```

```
Box<T>
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