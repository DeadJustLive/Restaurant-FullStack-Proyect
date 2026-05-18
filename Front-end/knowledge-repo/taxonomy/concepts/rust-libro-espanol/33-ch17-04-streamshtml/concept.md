# Ch17 04 streams.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 33)

## Contenido
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
el receptorrxdeltrpl::channele
