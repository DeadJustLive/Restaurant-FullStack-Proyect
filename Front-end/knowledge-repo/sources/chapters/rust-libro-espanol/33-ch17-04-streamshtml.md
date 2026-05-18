# Ch17 04 streams.html

# El Lenguaje de Programación Rust

## Streams: Futures en Secuencia

### Componiendo Streams

### Combinando Streams

Hasta ahora en este capítulo, hemos estado trabajando principalmente con futuros
individuales. La única gran excepción fue el receiver de canal asíncrono que
utilizamos. Recuerda cómo usamos el receiver para nuestro canal asíncrono en el“Paso de Mensajes”al principio del capítulo. El métodorecvasíncrono produce una secuencia de elementos a lo largo del tiempo. Esta
es una instancia de un patrón mucho más general, a menudo llamadostream.

Una secuencia de elementos es algo que ya hemos visto antes, cuando miramos el
traitIteratoren el capítulo 13. Sin embargo, hay dos diferencias entre los
iteradores y el receptor de canal asíncrono. La primera es el elemento del
tiempo: los iteradores son sincrónicos, mientras que el receptor de canal es
asíncrono. La segunda es la API. Cuando trabajamos directamente con unIterator, llamamos a su método sincróniconext. Con el streamtrpl::Receiver, en particular, llamamos a un método asíncronorecven su lugar. Estas APIs, de otro modo, se sienten muy similares.

Un stream es similar a una forma asíncrona de iteración. Mientras que eltrpl::Receiverespera específicamente recibir mensajes, la API de stream
general es mucho más general: proporciona el siguiente elemento de la misma
manera queIterator, pero de forma asíncrona. La similitud entre los
iteradores y los streams en Rust significa que en realidad podemos crear un
stream a partir de cualquier iterador. Al igual que con un iterador, podemos
trabajar con un stream llamando a su métodonexty luego esperando la
salida, como en el listado 17-30.

Comenzamos con un array de números, que convertimos en un iterador y luego
llamamos amappara duplicar todos los valores. Luego convertimos el
iterador en un stream usando la funcióntrpl::stream_from_iter. Luego
recorremos los elementos en el stream a medida que llegan con el buclewhile let.

Desafortunadamente, cuando intentamos ejecutar el código, no compila. En su
lugar, como podemos ver en la salida, informa que no hay un métodonextdisponible.

Como sugiere la salida, la razón del error del compilador es que necesitamos el
método correcto en el ámbito para poder usar el métodonext. Dada nuestra
discusión hasta ahora, podrías esperar razonablemente que seaStream, pero el
trait que necesitamos aquí es en realidadStreamExt. ElExtallí es por
“extensión”: este es un patrón común en la comunidad de Rust para extender un
trait con otro.

¿Por qué necesitamosStreamExten lugar deStream, y qué hace el traitStreamen sí? Brevemente, la respuesta es que en todo el ecosistema de Rust,
el traitStreamdefine una interfaz de bajo nivel que combina
efectivamente los traitsIteratoryFuture. El traitStreamExtsuministra un conjunto de APIs de nivel superior sobreStream, incluyendo
el métodonextasí como otros métodos de utilidad similares a los
proporcionados por el traitIterator. Volveremos a los traitsStreamyStreamExtcon un poco más de detalle al final del capítulo.
Por ahora, esto es suficiente para dejarnos seguir avanzando.

La solución al error del compilador es agregar una declaraciónuseparatrpl::StreamExt, como en el listado 17-31.

Con todas esas piezas juntas, este código funciona como queremos. ¡Lo que es
más, ahora que tenemosStreamExten el ámbito, podemos usar todos sus
métodos de utilidad, al igual que con los iteradores! Por ejemplo, en el
listado 17-32, usamos el métodofilterpara filtrar todo menos los
múltiplos de tres y cinco.

Por supuesto, esto no es muy interesante. Podríamos hacer eso con
iteradores normales y sin nada asíncrono. Así que veamos algunas de las
otras cosas que podemos hacer que son únicas para los streams.

Muchos conceptos se representan naturalmente como streams: elementos que
se vuelven disponibles en una cola, o trabajar con más datos de los que
pueden caber en la memoria de una computadora al extraer (pull) solo 
fragmentos (chunks) de ellos del sistema de archivos a la vez, o datos que 
llegan a través de la red a lo largo del tiempo. Debido a que los streams son 
futuros, también podemos usarlos con cualquier otro tipo de futuro, y podemos
combinarlos de maneras interesantes. Por ejemplo, podemos agrupar
eventos para evitar activar demasiadas llamadas de red, establecer
tiempos de espera en secuencias de operaciones de larga duración, o
restringir eventos de la interfaz de usuario para evitar hacer
trabajo innecesario.

Empecemos creando un pequeño stream de mensajes, como un sustituto
para un stream de datos que podríamos ver desde un WebSocket u otro
protocolo de comunicación en tiempo real. En el listado 17-33, creamos
una funciónget_messagesque devuelveimpl Stream<Item = String>. Para
su implementación, creamos un canal asíncrono, recorremos las primeras
diez letras del alfabeto inglés y las enviamos a través del canal.

Nosotros también usamos un nuevo tipo:ReceiverStream, que convierte
el receptorrxdeltrpl::channelen unStreamcon un métodonext.
De vuelta enmain, usamos un buclewhile letpara imprimir todos los
mensajes del stream.

Cuando ejecutamos este código, obtenemos exactamente los resultados que
esperábamos:

Podríamos hacer esto con la APIReceiverregular, o incluso la APIIteratorregular, sin embargo. Agreguemos algo que requiera streams:
agregando un tiempo de espera que se aplique a cada elemento en el stream, y
una demora en los elementos que emitimos.

En el listado 17-34, comenzamos agregando un tiempo de espera al stream
con el métodotimeout, que proviene del traitStreamExt. Luego
actualizamos el cuerpo del buclewhile let, porque el stream ahora
devuelve unResult. La varianteOkindica que un mensaje llegó a
tiempo; la varianteErrindica que el tiempo de espera se agotó
antes de que llegara algún mensaje. Hacemos unmatchen ese
resultado y ya sea imprimimos el mensaje cuando lo recibimos
exitosamente, o imprimimos un aviso sobre el tiempo de espera. Finalmente,
ten en cuenta que fijamos los mensajes después de aplicar el tiempo
de espera a ellos, porque el helper de tiempo de espera produce un
stream que necesita ser fijado para ser sondeado.

Comenzamos agregando un tiempo de espera al stream con el métodotimeout, que 
proviene del traitStreamExt. Luego actualizamos el cuerpo del ciclowhile let, porque ahora el stream devuelve unResult. La varianteOkindica que llegó un mensaje a tiempo; la varianteErrindica que el tiempo de 
espera se agotó antes de que llegara algún mensaje. Hacemos unmatchsobre ese 
resultado y o bien imprimimos el mensaje cuando lo recibimos con éxito o 
mostramos un aviso sobre el tiempo de espera. Finalmente, observa que fijamos 
(pin) los mensajes después de aplicarles el timeout, porque el helper de timeout 
produce un stream que debe ser fijado para poder ser polleado.

Sin embargo, como no hay demoras entre los mensajes, este tiempo de espera
no cambia el comportamiento del programa. Agreguemos una demora variable
a los mensajes que enviamos. Enget_messages, usamos el métodoenumeratedel iterador con el arraymessagespara que podamos
obtener el índice de cada elemento que estamos enviando junto con el
elemento en sí. Luego aplicamos una demora de 100 milisegundos
a los elementos de índice par y una demora de 300 milisegundos a los
elementos de índice impar, para simular las diferentes demoras que
podríamos ver de un stream de mensajes en el mundo real. Debido a que
nuestro tiempo de espera es de 200 milisegundos, esto debería afectar
la mitad de los mensajes.

Enget_messages, usamos el método iteradorenumeratecon el arreglomessagespara poder obtener el índice de cada elemento que enviamos junto con 
el elemento en sí. Luego aplicamos un retraso de 100 milisegundos a los 
elementos con índice par y un retraso de 300 milisegundos a los elementos con 
índice impar para simular los diferentes retrasos que podríamos ver en una 
secuencia de mensajes en el mundo real. Como nuestro tiempo de espera es de 200 
milisegundos, esto debería afectar a la mitad de los mensajes.

Para usar sleep entre mensajes en la funciónget_messagessin bloquear, 
necesitamos usar async. Sin embargo, no podemos hacer deget_messagesuna 
función asíncrona, porque entonces devolveríamos unFuture<Output = Stream<Item = String>>en lugar de unStream<Item = String>>. El llamador tendría que esperar aget_messagespara obtener acceso al stream. Pero recuerda:
todo en un futuro dado sucede de manera lineal; la concurrencia ocurreentrefuturos. Esperar aget_messagesrequeriría que enviara todos
los mensajes, incluyendo las esperas (sleep) entre el envío de
cada mensaje, antes de devolver el stream receptor. Como resultado,
el tiempo de espera terminaría siendo inútil. No habría demoras
en el stream en sí: todas las demoras ocurrirían antes de que el
stream estuviera disponible.

En su lugar, dejamosget_messagescomo una función regular que devuelve un
stream, y generamos una tarea para manejar las llamadas asíncronassleep.

Nota: llamar aspawn_taskde esta manera funciona porque ya configuramos
nuestro runtime. Llamar a esta implementación particular despawn_tasksinconfigurar primero un runtime causará un pánico. Otras
implementaciones eligen diferentes compensaciones: pueden generar un nuevo
runtime y así evitar el pánico, pero terminar con un poco de sobrecarga
adicional, o simplemente no proporcionar una forma independiente de generar
tareas sin referencia a un runtime. Debes asegurarte de saber qué
compensación ha elegido tu runtime y escribir tu código en consecuencia.

Ahora nuestro código tiene un resultado mucho más interesante. Entre
cada par de mensajes, vemos un error reportado:Problem: Elapsed(()).

El tiempo de espera no previene que los mensajes lleguen al final: aún
obtenemos todos los mensajes originales. Esto se debe a que nuestro
canal es ilimitado: puede contener tantos mensajes como podamos
ajustar en memoria. Si el mensaje no llega antes de que se agote el
tiempo, nuestro manejador de stream lo tendrá en cuenta, pero cuando
vuelva a sondear el stream, el mensaje puede haber llegado
ahora.

Puedes obtener un comportamiento diferente si es necesario usando
otros tipos de canales, o otros tipos de streams más
generalmente. Veamos uno de esos en la práctica en nuestro
ejemplo final para esta sección, combinando un stream de intervalos
de tiempo con este stream de mensajes.

Primero, creemos otro stream, que emitirá un elemento cada milisegundo si
lo dejamos ejecutarse directamente. Para simplificar, podemos usar la
funciónsleeppara enviar un mensaje con un retraso, y combinarlo
con el mismo enfoque de crear un stream a partir de un canal que
usamos enget_messages. La diferencia es que esta vez, vamos a
enviar de vuelta el conteo de intervalos que ha transcurrido, así
que el tipo de retorno seráimpl Stream<Item = u32>, y podemos
llamar a la funciónget_intervals.

En el listado 17-36, comenzamos definiendo uncounten la tarea. (También
podríamos definirlo fuera de la tarea, pero es más claro limitar el
alcance de cualquier variable dada). Luego creamos un bucle
infinito. Cada iteración del bucle duerme (sleep) de forma
asíncrona durante un milisegundo, incrementa el conteo y luego lo
envía a través del canal. Debido a que todo esto está envuelto
en la tarea creada porspawn_task, todo se limpiará junto con
el runtime, incluyendo el bucle infinito.

Este tipo de bucle infinito, que solo termina cuando todo el runtime se
desmonta, es bastante común en Rust asíncrono: muchos programas
necesitan seguir ejecutándose indefinidamente. Con async, esto no bloquea nada
más, siempre que haya al menos un punto de espera (await) en cad
a iteración a través del bucle.

En el bloque async de la función principal, comenzamos llamando aget_intervals. Luego combinamos los streamsmessageseintervalscon el métodomerge, que combina múltiples streams
en un solo stream que produce elementos de cualquiera de los
streams de origen tan pronto como los elementos están disponibles,
sin imponer ningún orden particular. Finalmente, recorremos
ese stream combinado en lugar de sobremessages(listado 17-37).

Comenzamos llamando aget_intervals. Luego combinamos los streamsmessageseintervalscon el métodomerge, que une múltiples streams en un solo stream 
que produce elementos de cualquiera de los streams de origen tan pronto como los 
elementos estén disponibles, sin imponer un orden particular. Finalmente, 
iteramos sobre ese stream combinado en lugar de hacerlo sobremessages.

En este punto, nimessagesniintervalsnecesitan ser fijados o
mutables, porque ambos se combinarán en el único streammerged.
Sin embargo, esta llamada amergeno compila. (Tampoco lo hace la
llamadanexten el buclewhile let, pero volveremos a eso después de
arreglar esto). Los dos streams tienen diferentes tipos. El streammessagestiene el tipoTimeout<impl Stream<Item = String>>,
dondeTimeoutes el tipo que implementaStreampara una
llamada atimeout. Mientras tanto, el streamintervalstiene el tipoimpl Stream<Item = u32>. Para combinar estos
dos streams, necesitamos transformar uno de ellos para que
coincida con el otro.

En el listado 17-38, volvemos a trabajar el streamintervals, porquemessagesya está en el formato básico que queremos y tiene que manejar errores 
de tiempo de espera. Primero, podemos usar el método auxiliarmappara 
transformar losintervalsen una cadena. En segundo lugar, necesitamos hacer 
coincidir elTimeoutdemessages. Sin embargo, como en realidad noqueremosun tiempo de espera paraintervals, podemos simplemente crear un 
tiempo de espera que sea más largo que los otros tiempos de 
espera que estamos usando. Aquí, creamos un tiempo de espera de 10 segundos conDuration::from_secs(10). Finalmente, necesitamos hacerstreammutable, para 
que las llamadasnextdel buclewhile letpuedan iterar a través del stream, 
y fijarlo para que sea seguro hacerlo.

Esto nos llevacasia donde necesitamos estar. Todo se verifica
el tipo. Sin embargo, si ejecutas esto, habrá dos problemas. Primero,
nunca se detendrá. ¡Tendrás que detenerlo conctrl-c!
En segundo lugar, los mensajes del alfabeto inglés estarán enterrados en
medio de todos los mensajes del contador de intervalos:

En el listado 17-39 se muestra una forma de resolver estos últimos dos
problemas. Primero, usamos el métodothrottleen el streamintervals, para 
que no abrume al streammessages. La limitación (throttling) es una forma de 
limitar la tasa a la que una función será llamada—o, en este caso, con qué 
frecuencia se sondeará el stream. Una vez cada cien milisegundos debería 
bastante, porque eso está en el mismo rango de tiempo que la frecuencia con la 
que llegan nuestros mensajes.

Para limitar el número de elementos que aceptaremos de un stream, podemos
usar el métodotake. Lo aplicamos alstream combinado, porque
queremos limitar la salida final, no solo un stream u otro.

Ahora, cuando ejecutamos el programa, se detiene después de extraer veinte 
elementos del stream, y los intervalos no abruman a los mensajes. También
no obtenemosInterval: 100oInterval: 200o así, sino que
en su lugar obtenemosInterval: 1,Interval: 2, y así sucesivamente — 
¡incluso cuando tenemos un stream de origen quepuedeproducir un evento
cada milisegundo! Eso se debe a que la llamadathrottleproduce un nuevo
stream, envolviendo el stream original, de modo que el stream original
solo se sondea a la tasa de limitación, no a su propia tasa “nativa”.
No tenemos un montón de mensajes de intervalo no manejados que
estamos eligiendo ignorar. En su lugar, ¡nunca producimos esos mensajes de
intervalo en primer lugar! Esta es la “pereza” inherente de los futuros
de Rust en acción nuevamente, lo que nos permite elegir nuestras
características de rendimiento.

Hay una última cosa que necesitamos manejar: ¡errores! Con ambos
streams basados en canales, las llamadassendpodrían fallar
cuando el otro lado del canal se cierra—y eso es solo una cuestión de
cómo el runtime ejecuta los futuros que componen el stream. Hasta
ahora hemos ignorado esto llamando aunwrap, pero en una
aplicación bien comportada, deberíamos manejar explícitamente el
error, al mínimo terminando el bucle para que no intentemos enviar
más mensajes. El listado 17-40 muestra una estrategia de error
simple: imprime el problema y luegobreakde los bucles. Como
siempre, la forma correcta de manejar un error de envío de
mensaje variará—¡solo asegúrate de tener una estrategia!

Ahora que hemos visto un montón de async en la práctica, echemos un
paso atrás y profundicemos en algunos de los detalles de cómoFuture,Stream, y los otros traits clave que Rust usa para
hacer que async funcione.

## Código

```
Iterator
```

```
Iterator
```

```
trpl::Receiver
```

```
trpl::Receiver
```

```
Iterator
```

```
externcratetrpl;// required for mdbook testfnmain() {trpl::run(async{letvalues = [1,2,3,4,5,6,7,8,9,10];letiter = values.iter().map(|n| n *2);letmutstream = trpl::stream_from_iter(iter);whileletSome(value) = stream.next().await{println!("The value was: {value}");
        }});}
```

```
externcratetrpl;// required for mdbook testfnmain() {trpl::run(async{letvalues = [1,2,3,4,5,6,7,8,9,10];letiter = values.iter().map(|n| n *2);letmutstream = trpl::stream_from_iter(iter);whileletSome(value) = stream.next().await{println!("The value was: {value}");
        }});}
```

```
trpl::stream_from_iter
```

```
while let
```

```
error[E0599]: no method named `next` found for struct `Iter` in the current scope-->src/main.rs:10:40|
10 |         while let Some(value) = stream.next().await {
   |                                        ^^^^
   |
   = note: the full type name has been written to 'file:///projects/async-await/target/debug/deps/async_await-575db3dd3197d257.long-type-14490787947592691573.txt'
   = note: consider using `--verbose` to print the full type name to the console
   = help: items from traits can only be used if the trait is in scope
help: the following traits which provide `next` are implemented but not in scope; perhaps you want to import one of them
   |
1  + use crate::trpl::StreamExt;
   |
1  + use futures_util::stream::stream::StreamExt;
   |
1  + use std::iter::Iterator;
   |
1  + use std::str::pattern::Searcher;
   |
help: there is a method `try_next` with a similar name
   |
10 |         while let Some(value) = stream.try_next().await {
   |                                        ~~~~~~~~
```

```
error[E0599]: no method named `next` found for struct `Iter` in the current scope-->src/main.rs:10:40|
10 |         while let Some(value) = stream.next().await {
   |                                        ^^^^
   |
   = note: the full type name has been written to 'file:///projects/async-await/target/debug/deps/async_await-575db3dd3197d257.long-type-14490787947592691573.txt'
   = note: consider using `--verbose` to print the full type name to the console
   = help: items from traits can only be used if the trait is in scope
help: the following traits which provide `next` are implemented but not in scope; perhaps you want to import one of them
   |
1  + use crate::trpl::StreamExt;
   |
1  + use futures_util::stream::stream::StreamExt;
   |
1  + use std::iter::Iterator;
   |
1  + use std::str::pattern::Searcher;
   |
help: there is a method `try_next` with a similar name
   |
10 |         while let Some(value) = stream.try_next().await {
   |                                        ~~~~~~~~
```

```
Stream
```

```
StreamExt
```

```
StreamExt
```

```
Stream
```

```
Stream
```

```
Stream
```

```
Iterator
```

```
Future
```

```
StreamExt
```

```
Stream
```

```
Iterator
```

```
Stream
```

```
StreamExt
```

```
trpl::StreamExt
```

```
externcratetrpl;// required for mdbook testusetrpl::StreamExt;fnmain() {
    trpl::run(async{letvalues = [1,2,3,4,5,6,7,8,9,10];letiter = values.iter().map(|n| n *2);letmutstream = trpl::stream_from_iter(iter);whileletSome(value) = stream.next().await{println!("The value was: {value}");
        }
    });
}
```

```
externcratetrpl;// required for mdbook testusetrpl::StreamExt;fnmain() {
    trpl::run(async{letvalues = [1,2,3,4,5,6,7,8,9,10];letiter = values.iter().map(|n| n *2);letmutstream = trpl::stream_from_iter(iter);whileletSome(value) = stream.next().await{println!("The value was: {value}");
        }
    });
}
```

```
externcratetrpl;// required for mdbook testusetrpl::StreamExt;fnmain() {
    trpl::run(async{letvalues = [1,2,3,4,5,6,7,8,9,10];letiter = values.iter().map(|n| n *2);letmutstream = trpl::stream_from_iter(iter);whileletSome(value) = stream.next().await{println!("The value was: {value}");
        }
    });
}
```

```
StreamExt
```

```
filter
```

```
externcratetrpl;// required for mdbook testusetrpl::StreamExt;fnmain() {
    trpl::run(async{letvalues =1..101;letiter = values.map(|n| n *2);letstream = trpl::stream_from_iter(iter);letmutfiltered =
            stream.filter(|value| value %3==0|| value %5==0);whileletSome(value) = filtered.next().await{println!("The value was: {value}");
        }
    });
}
```

```
externcratetrpl;// required for mdbook testusetrpl::StreamExt;fnmain() {
    trpl::run(async{letvalues =1..101;letiter = values.map(|n| n *2);letstream = trpl::stream_from_iter(iter);letmutfiltered =
            stream.filter(|value| value %3==0|| value %5==0);whileletSome(value) = filtered.next().await{println!("The value was: {value}");
        }
    });
}
```

```
externcratetrpl;// required for mdbook testusetrpl::StreamExt;fnmain() {
    trpl::run(async{letvalues =1..101;letiter = values.map(|n| n *2);letstream = trpl::stream_from_iter(iter);letmutfiltered =
            stream.filter(|value| value %3==0|| value %5==0);whileletSome(value) = filtered.next().await{println!("The value was: {value}");
        }
    });
}
```

```
get_messages
```

```
impl Stream<Item = String>
```

```
ReceiverStream
```

```
trpl::channel
```

```
Stream
```

```
while let
```

```
externcratetrpl;// required for mdbook testusetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {
    trpl::run(async{letmutmessages = get_messages();whileletSome(message) = messages.next().await{println!("{message}");
        }
    });
}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();letmessages = ["a","b","c","d","e","f","g","h","i","j"];formessageinmessages {
        tx.send(format!("Message: '{message}'")).unwrap();
    }

    ReceiverStream::new(rx)
}
```

```
externcratetrpl;// required for mdbook testusetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {
    trpl::run(async{letmutmessages = get_messages();whileletSome(message) = messages.next().await{println!("{message}");
        }
    });
}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();letmessages = ["a","b","c","d","e","f","g","h","i","j"];formessageinmessages {
        tx.send(format!("Message: '{message}'")).unwrap();
    }

    ReceiverStream::new(rx)
}
```

```
externcratetrpl;// required for mdbook testusetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {
    trpl::run(async{letmutmessages = get_messages();whileletSome(message) = messages.next().await{println!("{message}");
        }
    });
}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();letmessages = ["a","b","c","d","e","f","g","h","i","j"];formessageinmessages {
        tx.send(format!("Message: '{message}'")).unwrap();
    }

    ReceiverStream::new(rx)
}
```

```
Message: 'a'
Message: 'b'
Message: 'c'
Message: 'd'
Message: 'e'
Message: 'f'
Message: 'g'
Message: 'h'
Message: 'i'
Message: 'j'
```

```
Message: 'a'
Message: 'b'
Message: 'c'
Message: 'd'
Message: 'e'
Message: 'f'
Message: 'g'
Message: 'h'
Message: 'i'
Message: 'j'
```

```
Receiver
```

```
Iterator
```

```
timeout
```

```
StreamExt
```

```
while let
```

```
Result
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {
    trpl::run(async{letmutmessages =
            pin!(get_messages().timeout(Duration::from_millis(200)));whileletSome(result) = messages.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),
            }
        }
    })
}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();letmessages = ["a","b","c","d","e","f","g","h","i","j"];formessageinmessages {tx.send(format!("Message: '{message}'")).unwrap();}ReceiverStream::new(rx)}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {
    trpl::run(async{letmutmessages =
            pin!(get_messages().timeout(Duration::from_millis(200)));whileletSome(result) = messages.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),
            }
        }
    })
}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();letmessages = ["a","b","c","d","e","f","g","h","i","j"];formessageinmessages {tx.send(format!("Message: '{message}'")).unwrap();}ReceiverStream::new(rx)}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {
    trpl::run(async{letmutmessages =
            pin!(get_messages().timeout(Duration::from_millis(200)));whileletSome(result) = messages.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),
            }
        }
    })
}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();letmessages = ["a","b","c","d","e","f","g","h","i","j"];formessageinmessages {tx.send(format!("Message: '{message}'")).unwrap();}ReceiverStream::new(rx)}
```

```
timeout
```

```
StreamExt
```

```
while let
```

```
Result
```

```
get_messages
```

```
enumerate
```

```
messages
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmutmessages =pin!(get_messages().timeout(Duration::from_millis(200)));whileletSome(result) = messages.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}})}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();

    trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};
            trpl::sleep(Duration::from_millis(time_to_sleep)).await;

            tx.send(format!("Message: '{message}'")).unwrap();
        }
    });

    ReceiverStream::new(rx)
}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmutmessages =pin!(get_messages().timeout(Duration::from_millis(200)));whileletSome(result) = messages.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}})}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();

    trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};
            trpl::sleep(Duration::from_millis(time_to_sleep)).await;

            tx.send(format!("Message: '{message}'")).unwrap();
        }
    });

    ReceiverStream::new(rx)
}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmutmessages =pin!(get_messages().timeout(Duration::from_millis(200)));whileletSome(result) = messages.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}})}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();

    trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};
            trpl::sleep(Duration::from_millis(time_to_sleep)).await;

            tx.send(format!("Message: '{message}'")).unwrap();
        }
    });

    ReceiverStream::new(rx)
}
```

```
get_messages
```

```
enumerate
```

```
messages
```

```
get_messages
```

```
get_messages
```

```
Future<Output = Stream<Item = String>>
```

```
Stream<Item = String>>
```

```
get_messages
```

```
get_messages
```

```
get_messages
```

```
spawn_task
```

```
spawn_task
```

```
Problem: Elapsed(())
```

```
Message: 'a'
Problem: Elapsed(())
Message: 'b'
Message: 'c'
Problem: Elapsed(())
Message: 'd'
Message: 'e'
Problem: Elapsed(())
Message: 'f'
Message: 'g'
Problem: Elapsed(())
Message: 'h'
Message: 'i'
Problem: Elapsed(())
Message: 'j'
```

```
Message: 'a'
Problem: Elapsed(())
Message: 'b'
Message: 'c'
Problem: Elapsed(())
Message: 'd'
Message: 'e'
Problem: Elapsed(())
Message: 'f'
Message: 'g'
Problem: Elapsed(())
Message: 'h'
Message: 'i'
Problem: Elapsed(())
Message: 'j'
```

```
get_messages
```

```
impl Stream<Item = u32>
```

```
get_intervals
```

```
spawn_task
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmutmessages =pin!(get_messages().timeout(Duration::from_millis(200)));whileletSome(result) = messages.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}})}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};trpl::sleep(Duration::from_millis(time_to_sleep)).await;tx.send(format!("Message: '{message}'")).unwrap();}});ReceiverStream::new(rx)}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();

    trpl::spawn_task(asyncmove{letmutcount =0;loop{
            trpl::sleep(Duration::from_millis(1)).await;
            count +=1;
            tx.send(count).unwrap();
        }
    });

    ReceiverStream::new(rx)
}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmutmessages =pin!(get_messages().timeout(Duration::from_millis(200)));whileletSome(result) = messages.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}})}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};trpl::sleep(Duration::from_millis(time_to_sleep)).await;tx.send(format!("Message: '{message}'")).unwrap();}});ReceiverStream::new(rx)}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();

    trpl::spawn_task(asyncmove{letmutcount =0;loop{
            trpl::sleep(Duration::from_millis(1)).await;
            count +=1;
            tx.send(count).unwrap();
        }
    });

    ReceiverStream::new(rx)
}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmutmessages =pin!(get_messages().timeout(Duration::from_millis(200)));whileletSome(result) = messages.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}})}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};trpl::sleep(Duration::from_millis(time_to_sleep)).await;tx.send(format!("Message: '{message}'")).unwrap();}});ReceiverStream::new(rx)}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();

    trpl::spawn_task(asyncmove{letmutcount =0;loop{
            trpl::sleep(Duration::from_millis(1)).await;
            count +=1;
            tx.send(count).unwrap();
        }
    });

    ReceiverStream::new(rx)
}
```

```
get_intervals
```

```
messages
```

```
intervals
```

```
messages
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmessages = get_messages().timeout(Duration::from_millis(200));letintervals = get_intervals();letmerged = messages.merge(intervals);whileletSome(result) = merged.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}})}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};trpl::sleep(Duration::from_millis(time_to_sleep)).await;tx.send(format!("Message: '{message}'")).unwrap();}});ReceiverStream::new(rx)}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmutcount =0;loop{trpl::sleep(Duration::from_millis(1)).await;count +=1;tx.send(count).unwrap();}});ReceiverStream::new(rx)}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmessages = get_messages().timeout(Duration::from_millis(200));letintervals = get_intervals();letmerged = messages.merge(intervals);whileletSome(result) = merged.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}})}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};trpl::sleep(Duration::from_millis(time_to_sleep)).await;tx.send(format!("Message: '{message}'")).unwrap();}});ReceiverStream::new(rx)}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmutcount =0;loop{trpl::sleep(Duration::from_millis(1)).await;count +=1;tx.send(count).unwrap();}});ReceiverStream::new(rx)}
```

```
get_intervals
```

```
messages
```

```
intervals
```

```
messages
```

```
messages
```

```
intervals
```

```
merged
```

```
while let
```

```
messages
```

```
Timeout<impl Stream<Item = String>>
```

```
Timeout
```

```
Stream
```

```
timeout
```

```
intervals
```

```
impl Stream<Item = u32>
```

```
intervals
```

```
messages
```

```
intervals
```

```
Timeout
```

```
messages
```

```
intervals
```

```
Duration::from_secs(10)
```

```
stream
```

```
while let
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmessages = get_messages().timeout(Duration::from_millis(200));letintervals = get_intervals()
            .map(|count|format!("Interval: {count}"))
            .timeout(Duration::from_secs(10));letmerged = messages.merge(intervals);letmutstream = pin!(merged);whileletSome(result) = stream.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}})}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};trpl::sleep(Duration::from_millis(time_to_sleep)).await;tx.send(format!("Message: '{message}'")).unwrap();}});ReceiverStream::new(rx)}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmutcount =0;loop{trpl::sleep(Duration::from_millis(1)).await;count +=1;tx.send(count).unwrap();}});ReceiverStream::new(rx)}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmessages = get_messages().timeout(Duration::from_millis(200));letintervals = get_intervals()
            .map(|count|format!("Interval: {count}"))
            .timeout(Duration::from_secs(10));letmerged = messages.merge(intervals);letmutstream = pin!(merged);whileletSome(result) = stream.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}})}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};trpl::sleep(Duration::from_millis(time_to_sleep)).await;tx.send(format!("Message: '{message}'")).unwrap();}});ReceiverStream::new(rx)}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmutcount =0;loop{trpl::sleep(Duration::from_millis(1)).await;count +=1;tx.send(count).unwrap();}});ReceiverStream::new(rx)}
```

```
--snip--
Interval: 38
Interval: 39
Interval: 40
Message: 'a'
Interval: 41
Interval: 42
Interval: 43
--snip--
```

```
--snip--
Interval: 38
Interval: 39
Interval: 40
Message: 'a'
Interval: 41
Interval: 42
Interval: 43
--snip--
```

```
throttle
```

```
intervals
```

```
messages
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmessages = get_messages().timeout(Duration::from_millis(200));letintervals = get_intervals()
            .map(|count|format!("Interval: {count}"))
            .throttle(Duration::from_millis(100))
            .timeout(Duration::from_secs(10));letmerged = messages.merge(intervals).take(20);letmutstream = pin!(merged);whileletSome(result) = stream.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}})}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};trpl::sleep(Duration::from_millis(time_to_sleep)).await;tx.send(format!("Message: '{message}'")).unwrap();}});ReceiverStream::new(rx)}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmutcount =0;loop{trpl::sleep(Duration::from_millis(1)).await;count +=1;tx.send(count).unwrap();}});ReceiverStream::new(rx)}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmessages = get_messages().timeout(Duration::from_millis(200));letintervals = get_intervals()
            .map(|count|format!("Interval: {count}"))
            .throttle(Duration::from_millis(100))
            .timeout(Duration::from_secs(10));letmerged = messages.merge(intervals).take(20);letmutstream = pin!(merged);whileletSome(result) = stream.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}})}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};trpl::sleep(Duration::from_millis(time_to_sleep)).await;tx.send(format!("Message: '{message}'")).unwrap();}});ReceiverStream::new(rx)}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmutcount =0;loop{trpl::sleep(Duration::from_millis(1)).await;count +=1;tx.send(count).unwrap();}});ReceiverStream::new(rx)}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmessages = get_messages().timeout(Duration::from_millis(200));letintervals = get_intervals()
            .map(|count|format!("Interval: {count}"))
            .throttle(Duration::from_millis(100))
            .timeout(Duration::from_secs(10));letmerged = messages.merge(intervals).take(20);letmutstream = pin!(merged);whileletSome(result) = stream.next().await{matchresult {Ok(message) =>println!("{message}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}})}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};trpl::sleep(Duration::from_millis(time_to_sleep)).await;tx.send(format!("Message: '{message}'")).unwrap();}});ReceiverStream::new(rx)}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();trpl::spawn_task(asyncmove{letmutcount =0;loop{trpl::sleep(Duration::from_millis(1)).await;count +=1;tx.send(count).unwrap();}});ReceiverStream::new(rx)}
```

```
Interval: 100
```

```
Interval: 200
```

```
Interval: 1
```

```
Interval: 2
```

```
throttle
```

```
Interval: 1
Message: 'a'
Interval: 2
Interval: 3
Problem: Elapsed(())
Interval: 4
Message: 'b'
Interval: 5
Message: 'c'
Interval: 6
Interval: 7
Problem: Elapsed(())
Interval: 8
Message: 'd'
Interval: 9
Message: 'e'
Interval: 10
Interval: 11
Problem: Elapsed(())
Interval: 12
```

```
Interval: 1
Message: 'a'
Interval: 2
Interval: 3
Problem: Elapsed(())
Interval: 4
Message: 'b'
Interval: 5
Message: 'c'
Interval: 6
Interval: 7
Problem: Elapsed(())
Interval: 8
Message: 'd'
Interval: 9
Message: 'e'
Interval: 10
Interval: 11
Problem: Elapsed(())
Interval: 12
```

```
unwrap
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmessages = get_messages().timeout(Duration::from_millis(200));letintervals = get_intervals().map(|count|format!("Interval #{count}")).throttle(Duration::from_millis(500)).timeout(Duration::from_secs(10));letmerged = messages.merge(intervals).take(20);letmutstream = pin!(merged);whileletSome(result) = stream.next().await{matchresult {Ok(item) =>println!("{item}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}});}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();

    trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};
            trpl::sleep(Duration::from_millis(time_to_sleep)).await;ifletErr(send_error) = tx.send(format!("Message: '{message}'")) {
                eprintln!("Cannot send message '{message}': {send_error}");break;
            }
        }
    });

    ReceiverStream::new(rx)
}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();

    trpl::spawn_task(asyncmove{letmutcount =0;loop{
            trpl::sleep(Duration::from_millis(1)).await;
            count +=1;ifletErr(send_error) = tx.send(count) {
                eprintln!("Could not send interval {count}: {send_error}");break;
            };
        }
    });

    ReceiverStream::new(rx)
}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmessages = get_messages().timeout(Duration::from_millis(200));letintervals = get_intervals().map(|count|format!("Interval #{count}")).throttle(Duration::from_millis(500)).timeout(Duration::from_secs(10));letmerged = messages.merge(intervals).take(20);letmutstream = pin!(merged);whileletSome(result) = stream.next().await{matchresult {Ok(item) =>println!("{item}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}});}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();

    trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};
            trpl::sleep(Duration::from_millis(time_to_sleep)).await;ifletErr(send_error) = tx.send(format!("Message: '{message}'")) {
                eprintln!("Cannot send message '{message}': {send_error}");break;
            }
        }
    });

    ReceiverStream::new(rx)
}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();

    trpl::spawn_task(asyncmove{letmutcount =0;loop{
            trpl::sleep(Duration::from_millis(1)).await;
            count +=1;ifletErr(send_error) = tx.send(count) {
                eprintln!("Could not send interval {count}: {send_error}");break;
            };
        }
    });

    ReceiverStream::new(rx)
}
```

```
externcratetrpl;// required for mdbook testusestd::{pin::pin, time::Duration};usetrpl::{ReceiverStream, Stream, StreamExt};fnmain() {trpl::run(async{letmessages = get_messages().timeout(Duration::from_millis(200));letintervals = get_intervals().map(|count|format!("Interval #{count}")).throttle(Duration::from_millis(500)).timeout(Duration::from_secs(10));letmerged = messages.merge(intervals).take(20);letmutstream = pin!(merged);whileletSome(result) = stream.next().await{matchresult {Ok(item) =>println!("{item}"),Err(reason) => eprintln!("Problem: {reason:?}"),}}});}fnget_messages() ->implStream<Item =String> {let(tx, rx) = trpl::channel();

    trpl::spawn_task(asyncmove{letmessages = ["a","b","c","d","e","f","g","h","i","j"];for(index, message)inmessages.into_iter().enumerate() {lettime_to_sleep =ifindex %2==0{100}else{300};
            trpl::sleep(Duration::from_millis(time_to_sleep)).await;ifletErr(send_error) = tx.send(format!("Message: '{message}'")) {
                eprintln!("Cannot send message '{message}': {send_error}");break;
            }
        }
    });

    ReceiverStream::new(rx)
}fnget_intervals() ->implStream<Item =u32> {let(tx, rx) = trpl::channel();

    trpl::spawn_task(asyncmove{letmutcount =0;loop{
            trpl::sleep(Duration::from_millis(1)).await;
            count +=1;ifletErr(send_error) = tx.send(count) {
                eprintln!("Could not send interval {count}: {send_error}");break;
            };
        }
    });

    ReceiverStream::new(rx)
}
```

```
Future
```

```
Stream
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