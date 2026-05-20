# Ch17 01 futures and syntax.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 31)

## Contenido
# El Lenguaje de Programación Rust

## Futures y la sintaxisasync

### Nuestro primer programa asíncrono

Los elementos clave de la programación asíncrona en Rust son losfuturesy las
palabras claveasyncyawait.

Unfuturees un valor que puede no estar listo ahora, pero que estará listo en
algún momento en el futuro. (Este mismo concepto aparece en muchos lenguajes,
a veces bajo otros nombres como “tarea” o “promesa”.) Rust proporciona un traitFuturecomo un bloque de construcción para que diferentes operaciones 
asíncronas puedan implementarse con diferentes estructuras de datos, pero con
una interfaz común. En Rust, decimos que los tipos que implementan el traitFutureson futuros. Cada tipo que implementaFuturecontiene su propia
información sobre el progreso que se ha hecho y lo que significa estar "listo".

La palabra claveasyncse puede aplicar a bloques y funciones para especificar
que pueden ser interrumpidos y reanudados. Dentro de un bloque asíncrono o una
función asíncrona, puedes usar la palabra claveawaitpara esperar a que un
futuro esté listo, pudiendoesperar un futuro. Cada lugar donde esperas un
futuro dentro de un bloque o función asíncrona es un lugar donde ese bloque o
función asíncrona puede ser pausado y reanudado. El proceso de comprobar con un
futuro para ver si su valor está disponible se llamapolling.

Algunos otros lenguajes también utilizan las palabras claveasyncyawaitpara la programación asíncrona. Si estás familiarizado con esos lenguajes, puede
que notes algunas diferencias significativas en cómo Rust hace las cosas,
incluyendo cómo maneja la sintaxis. ¡Por una buena razón, como veremos!

La mayor parte del tiempo al escribir Rust asíncrono, usamos las palabras claveasyncyawait. Rust las compila en código equivalente utilizando el traitFuture, al igual que compila los buclesforen código equivalente utilizando
el traitIterator. Sin embargo, como Rust proporciona el traitFuture, puedes
implementarlo para tus propios tipos de datos cuando sea necesario. Muchas de las
funciones que veremos a lo largo de este capítulo devuelven tipos con sus propias
implementaciones deFuture. Volveremos a la definición del trait al final del
capítulo y profundizaremos más en cómo funciona, pero este es suficiente detalle
para seguir avanzando.

Todo esto puede parecer un poco abstracto. Escribamos nuestro primer programa
asíncrono: un pequeño web scraper. Pasaremos dos URLs desde la línea de 
comandos, obtendremos ambos de forma concurrente y devolveremos el resultado
de aquel que termine primero. Este ejemplo tendrá un poco de nueva sintaxis,
pero no te preocupes. Explicaremos todo lo que necesitas saber a medida que
avanzamos.

Para mantener este capítulo centrado en aprender lo asíncrono, en lugar de
manejar partes del ecosistema, hemos creado el cratetrpl(trples la
abreviatura de “The Rust Programming Language”). Re-exporta todos los tipos,
traits y funciones que necesitarás, principalmente de los cratesfuturesytokio.

El cratefutureses un hogar oficial para la experimentación de Rust para
el código asíncrono, y es en realidad donde el tipoFuturefue diseñado
originalmente.

Tokio es el runtime asíncrono más utilizado en Rust hoy en día, especialmente
(¡pero no solo!) para aplicaciones web. Hay otros runtimes geniales por ahí,
y pueden ser más adecuados para tus propósitos. Usamos Tokio bajo el capó
paratrplporque está bien probado y ampliamente utilizado.

En algunos casos,trpltambién renombra o envuelve las APIs originales para
permitirnos mantenernos enfocados en los detalles relevantes para este capítulo.
Si quieres entender qué hace el crate, te animamos a que eches un vistazo asu código fuente. Podrás ver de qué crate proviene cada
re-exportación, y hemos dejado extensos comentarios explicando qué hace el 
crate.

Crea un nuevo proyecto binario llamadohello-asyncy añade el cratetrplcomo dependencia:

Ahora podemos usar las diversas piezas proporcionadas portrplpara escribir
nuestro primer programa asíncrono. Construiremos una pequeña herramienta de
línea de comandos que obtiene dos páginas web, extrae el elemento<title>de
cada una e imprime el título de aquella que termine todo el proceso primero.

Empecemos escribiendo una función que toma una URL de página como parámetro,
hace una petición a ella y devuelve el texto del elemento título:

En el Listado 17-1, definimos una función llamadapage_title, y la marcamos
con la palabra claveasync. Luego usamos la funcióntrpl::getpara obtener
cualquier URL que se pase, y esperamos la respuesta usando la palabra claveawait. Luego obtenemos el texto de la respuesta llamando a su métodotext,
y una vez más lo esperamos con la palabra claveawait. Ambos pasos son
asíncronos. Paraget, necesitamos esperar a que el servidor envíe la primera
parte de su respuesta, que incluirá cabeceras HTTP, cookies, etc. Esa parte de
la respuesta puede entregarse por separado del cuerpo de la petición. 
Especialmente si el cuerpo es muy grande, puede llevar algo de tiempo que todo

> [Contenido truncado — consulta el capítulo completo con knowledge read]
