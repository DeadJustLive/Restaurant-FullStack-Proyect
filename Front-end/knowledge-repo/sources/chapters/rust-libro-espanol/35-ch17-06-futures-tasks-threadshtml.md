# Ch17 06 futures tasks threads.html

# El Lenguaje de Programación Rust

## Uniendo Todo: Futures, Tareas e Hilos

## Resumen

Como vimos en el capítulo anterior, los hilos proporcionan un enfoque para la 
concurrencia. Hemos visto otro enfoque para la concurrencia en este capítulo, 
usando async con futuros y flujos. Puede que te preguntes por qué elegirías uno 
u otro. La respuesta es: ¡depende! Y en muchos casos, la elección no es hilosoasync, sino más bien hilosyasync.

Muchos sistemas operativos han proporcionado modelos de concurrencia basados en
hilos durante décadas, y muchos lenguajes de programación los admiten como
resultado. Sin embargo, no están exentos de sus compensaciones. En muchos
sistemas operativos, utilizan una buena cantidad de memoria para cada hilo, y
tienen ciertos costos de inicio y cierre. ¡Los hilos también son una opción solo
cuando su sistema operativo y hardware los admiten! A diferencia de las
computadoras de escritorio y móviles convencionales, algunos sistemas embebidos
no tienen un sistema operativo en absoluto, ¡por lo que tampoco tienen hilos!

El modelo async proporciona un conjunto diferente —y en última instancia
complementario— de compensaciones. En el modelo async, las operaciones
concurrentes no requieren sus propios hilos. En su lugar, pueden ejecutarse en
tareas, como cuando usamostrpl::spawn_taskpara iniciar el trabajo desde una
función síncrona a lo largo de la sección de flujos. Una tarea es similar a un
hilo, pero en lugar de ser administrada por el sistema operativo, es 
administrada por código a nivel de biblioteca: el tiempo de ejecución.

En la sección anterior, vimos que podíamos construir unStreamusando un canal
async y lanzando una tarea async que podíamos llamar desde el código síncrono.
¡Podríamos hacer exactamente lo mismo con un hilo! En el Listado 17-40, usamostrpl::spawn_taskytrpl::sleep. En el Listado 17-41, reemplazamos esos con
las APIthread::spawnythread::sleepde la biblioteca estándar en la 
funciónget_intervals.

Si ejecutas esto, la salida es idéntica. ¡Y fíjate en cuánto cambia aquí desde
la perspectiva del código que llama! Además, aunque una de nuestras funciones
lanzó una tarea async en el tiempo de ejecución y la otra lanzó un hilo del
sistema operativo, los flujos resultantes no se vieron afectados por las
diferencias.

A pesar de las similitudes, estos dos enfoques se comportan de manera muy
diferente, aunque podríamos tener dificultades para medirlo en este ejemplo muy
simple. Podríamos lanzar millones de tareas async en cualquier computadora
personal moderna. ¡Si intentáramos hacer eso con hilos, literalmente nos 
quedaríamos sin memoria!

Sin embargo, hay una razón por la que estas API son tan similares. Los hilos
actúan como un límite para conjuntos de operaciones síncronas; la concurrencia 
es posibleentrehilos. Las tareas actúan como un límite para conjuntos de
operacionesasíncronas; la concurrencia es posible tantoentrecomodentrode las tareas, porque una tarea puede cambiar entre futuros en su cuerpo.
Finalmente, los futuros son la unidad de concurrencia más granular de Rust, y
cada futuro puede representar un árbol de otros futuros. El tiempo de ejecución
— específicamente, su ejecutor — administra las tareas, y las tareas administran
los futuros. En ese sentido, las tareas son similares a hilos livianos
administrados por el tiempo de ejecución con capacidades adicionales que 
provienen de ser administrados por un tiempo de ejecución en lugar del sistema
operativo.

Esto no significa que las tareas async siempre sean mejores que los hilos, al
igual que los hilos no siempre son mejores que las tareas.

La concurrencia con hilos es en ciertos aspectos un modelo de programación más
simple que la concurrencia conasync. Eso puede ser una fortaleza o una
debilidad. Los hilos son algo así como “disparar y olvidar”, no tienen un
equivalente nativo a un futuro, por lo que simplemente se ejecutan hasta su
finalización, sin interrupciones excepto por el sistema operativo en sí mismo.
Es decir, no tienen soporte integrado para laconcurrencia intra-tareade la
forma en que lo hacen los futuros. Los hilos en Rust tampoco tienen mecanismos
para la cancelación —un tema que no hemos cubierto en profundidad en este
capítulo, pero que es implícito en el hecho de que cada vez que terminamos un
futuro, su estado se limpió correctamente.

Estas limitaciones también hacen que los hilos sean más difíciles de componer 
que los futuros. Es mucho más difícil, por ejemplo, usar hilos para construir
ayudantes como eltimeoutque construimos en“Construyendo nuestras propias
abstracciones async”o el métodothrottleque usamos con
flujos en“Componiendo flujos”. El hecho de que los futuros sean
estructuras de datos más ricas significa que se pueden componer de manera más
natural, como hemos visto.

Las tareas dancontrol adicionalsobre los futuros, permitiéndote elegir dónde
y cómo agrupar los futuros. Y resulta que los hilos y las tareas a menudo
funcionan muy bien juntos, porque las tareas pueden (al menos en algunos
tiempos de ejecución) moverse entre hilos. No lo hemos mencionado hasta ahora,
pero bajo el capó, elRuntimeque hemos estado usando, incluidas las funcionesspawn_blockingyspawn_task, es multihilo de forma predeterminada. ¡Muchos
tiempos de ejecución utilizan un enfoque llamadorobo de trabajopara mover
tareas de manera transparente entre hilos basándose en la utilización actual de
los hilos, con el objetivo de mejorar el rendimiento general del sistema. Para
construir eso, en realidad se requieren hilosytareas, y por lo tanto
futuros.

Como una forma predeterminada de pensar es cuando:

Y si necesitas una mezcla de paralelismo y concurrencia, no tienes que elegir
entre hilos y async. Puedes usarlos juntos libremente, dejando que cada uno
sirva la parte en la que es mejor. Por ejemplo, el Listado 17-42 muestra un
ejemplo bastante común de este tipo de mezcla en código Rust del mundo real.

Comenzamos creando un canal async. Luego lanzamos un hilo que toma posesión del
lado emisor del canal. Dentro del hilo, enviamos los números del 1 al 10, y
dormimos durante un segundo entre cada uno. Finalmente, ejecutamos un futuro
creado con un bloque async pasado atrpl::runtal como lo hemos hecho a lo
largo del capítulo. En ese futuro, esperamos esos mensajes, al igual que en los
otros ejemplos de paso de mensajes que hemos visto.

Para volver a los ejemplos con los que abrimos el capítulo: podrías imaginar
ejecutar un conjunto de tareas de codificación de video usando un hilo
dedicado, porque la codificación de video está limitada por la computación, pero
notificar a la interfaz de usuario que esas operaciones se han completado con un
canal async. ¡Los ejemplos de este tipo de mezcla abundan!

Esto no es lo último que verás de la concurrencia en este libro: el proyecto en
el Capítulo 21 utilizará los conceptos de este capítulo en una situación más
realista que los ejemplos más pequeños discutidos aquí —y comparará de manera
más directa cómo se ve resolver este tipo de problemas con hilos vs. con tareas 
y futuros.

Ya sea con hilos, con futuros y tareas, o con la combinación de todos ellos, 
Rust te brinda las herramientas que necesitas para escribir código concurrente
seguro y rápido —ya sea para un servidor web de alto rendimiento o un sistema
operativo embebido.

A continuación, hablaremos sobre formas idiomáticas de modelar problemas y
estructurar soluciones a medida que tus programas Rust se vuelven más grandes.
Además, discutiremos cómo se relacionan los ídolos de Rust con los que podrías
estar familiarizado de la programación orientada a objetos.

## Código

```
trpl::spawn_task
```

```
Stream
```

```
trpl::spawn_task
```

```
trpl::sleep
```

```
thread::spawn
```

```
thread::sleep
```

```
get_intervals
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, thread, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmessages = get_messages().timeout(Duration::from_millis(200));letintervals = get_intervals().map(|count|format!("Interval #{count}")).throttle(Duration::from_millis(500)).timeout(Duration::from_secs(10));letmerged = messages.merge(intervals).take(20);letmutstream = pin!(merged);whileletSome(result) = stream.next().await{matchresult {Ok(item) =>println!("{item}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}});}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};trpl::sleep(Duration::from_millis(time_to_sleep)).await;ifletErr(send_error) = tx.send(format!("Message: '{message}'")) {eprintln!("Cannot send message '{message}': {send_error}");break;}}});ReceiverStream::new(rx)}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();// This is *not* `trpl::spawn` but `std::thread::spawn`!thread::spawn(move|| {letmutcount =0;loop{// Likewise, this is *not* `trpl::sleep` but `std::thread::sleep`!thread::sleep(Duration::from_millis(1));
            count +=1;ifletErr(send_error) = tx.send(count) {
                eprintln!("Could not send interval {count}: {send_error}");break;
            };
        }
    });

    ReceiverStream::new(rx)
}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, thread, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmessages = get_messages().timeout(Duration::from_millis(200));letintervals = get_intervals().map(|count|format!("Interval #{count}")).throttle(Duration::from_millis(500)).timeout(Duration::from_secs(10));letmerged = messages.merge(intervals).take(20);letmutstream = pin!(merged);whileletSome(result) = stream.next().await{matchresult {Ok(item) =>println!("{item}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}});}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};trpl::sleep(Duration::from_millis(time_to_sleep)).await;ifletErr(send_error) = tx.send(format!("Message: '{message}'")) {eprintln!("Cannot send message '{message}': {send_error}");break;}}});ReceiverStream::new(rx)}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();// This is *not* `trpl::spawn` but `std::thread::spawn`!thread::spawn(move|| {letmutcount =0;loop{// Likewise, this is *not* `trpl::sleep` but `std::thread::sleep`!thread::sleep(Duration::from_millis(1));
            count +=1;ifletErr(send_error) = tx.send(count) {
                eprintln!("Could not send interval {count}: {send_error}");break;
            };
        }
    });

    ReceiverStream::new(rx)
}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, thread, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmessages = get_messages().timeout(Duration::from_millis(200));letintervals = get_intervals().map(|count|format!("Interval #{count}")).throttle(Duration::from_millis(500)).timeout(Duration::from_secs(10));letmerged = messages.merge(intervals).take(20);letmutstream = pin!(merged);whileletSome(result) = stream.next().await{matchresult {Ok(item) =>println!("{item}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}});}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};trpl::sleep(Duration::from_millis(time_to_sleep)).await;ifletErr(send_error) = tx.send(format!("Message: '{message}'")) {eprintln!("Cannot send message '{message}': {send_error}");break;}}});ReceiverStream::new(rx)}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();// This is *not* `trpl::spawn` but `std::thread::spawn`!thread::spawn(move|| {letmutcount =0;loop{// Likewise, this is *not* `trpl::sleep` but `std::thread::sleep`!thread::sleep(Duration::from_millis(1));
            count +=1;ifletErr(send_error) = tx.send(count) {
                eprintln!("Could not send interval {count}: {send_error}");break;
            };
        }
    });

    ReceiverStream::new(rx)
}
```

```
timeout
```

```
throttle
```

```
Runtime
```

```
spawn_blocking
```

```
spawn_task
```

```
externcratetrpl;// for mdbook testusestd::{thread, time::Duration};fnmain() {let(tx,mutrx) = trpl::channel();

    thread::spawn(move|| {foriin1..11{
            tx.send(i).unwrap();
            thread::sleep(Duration::from_secs(1));
        }
    });

    trpl::run(async{whileletSome(message) = rx.recv().await{println!("{message}");
        }
    });
}
```

```
externcratetrpl;// for mdbook testusestd::{thread, time::Duration};fnmain() {let(tx,mutrx) = trpl::channel();

    thread::spawn(move|| {foriin1..11{
            tx.send(i).unwrap();
            thread::sleep(Duration::from_secs(1));
        }
    });

    trpl::run(async{whileletSome(message) = rx.recv().await{println!("{message}");
        }
    });
}
```

```
externcratetrpl;// for mdbook testusestd::{thread, time::Duration};fnmain() {let(tx,mutrx) = trpl::channel();

    thread::spawn(move|| {foriin1..11{
            tx.send(i).unwrap();
            thread::sleep(Duration::from_secs(1));
        }
    });

    trpl::run(async{whileletSome(message) = rx.recv().await{println!("{message}");
        }
    });
}
```

```
trpl::run
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

- Si el trabajo esmuy paralelizable, como procesar un montón de datos donde
cada parte puede procesarse por separado, los hilos son una mejor elección.
- Si el trabajo esmuy concurrente, como manejar mensajes de un montón de
fuentes diferentes que pueden llegar en intervalos o tasas diferentes, async
es una mejor elección.