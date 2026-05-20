# Ch17 01 futures and syntax.html

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
llegue. Por lo tanto, tenemos que esperar a quetodala respuesta llegue, por
lo que el métodotexttambién es asíncrono.

Tenemos que esperar explícitamente ambos de estos futuros, porque los futuros
en Rust sonperezosos: no hacen nada hasta que les pides conawait. (De
hecho, Rust mostrará una advertencia del compilador si no usas un futuro.) Esto
debería recordarte nuestra discusión de los iteradoresen el Capítulo 13.
Los iteradores no hacen nada a menos que llames a su métodonext—ya sea
directamente, o usando buclesforo métodos comomapque usannextbajo
el capó. Con los futuros, se aplica la misma idea básica: no hacen nada a menos
que les pidas explícitamente. Esta estrategia de ejecución perezosa permite a 
Rust evitar ejecutar código asíncrono hasta que realmente sea necesario.

Nota: Esto es diferente del comportamiento que vimos al usarthread::spawnen el capítulo anterior, donde la closure que pasamos a otro hilo comenzó a
ejecutarse inmediatamente. ¡También es diferente de cómo muchos otros 
lenguajes abordan lo asíncrono! Pero es importante para Rust. Veremos por qué
es así más adelante.

Una vez que tenemosresponse_text, podemos analizarlo en una instancia del
tipoHtmlusandoHtml::parse. En lugar de una cadena en bruto, ahora tenemos
un tipo de datos con el que podemos trabajar con el HTML como una estructura de
datos más rica. En particular, podemos usar el métodoselect_firstpara
encontrar la primera instancia de un selector CSS dado. Pasando la cadena"title", obtendremos el primer elemento<title>en el documento, si lo hay.
Dado que puede que no haya ningún elemento coincidente,select_firstdevuelve
unOption<ElementRef>. Finalmente, usamos el métodoOption::map, que nos
permite trabajar con el elemento en elOptionsi está presente, y no hacer
nada si no lo está. (También podríamos usar una expresiónmatchaquí, peromapes más idiomático.) En el cuerpo de la función que proporcionamos amap,
llamamos ainner_htmlen eltitle_elementpara obtener su contenido, que es
unString. Cuando todo está dicho y hecho, tenemos unOption<String>.

Observa que la palabra claveawaitde Rust va después de la expresión que
estás esperando, no antes. Es decir, es unapalabra clave posfija. Esto puede
ser diferente de lo que estás acostumbrado si has usado asíncrono en otros
lenguajes. Rust eligió esto porque hace que las cadenas de métodos sean mucho
más agradables de trabajar. Como resultado, podemos cambiar el cuerpo depage_titlepara encadenar las llamadas a las funcionestrpl::getytextjuntas conawaitentre ellas, como se muestra en el Listado 17-2:

¡Con eso, hemos escrito con éxito nuestra primera función asíncrona! Antes de
añadir algo de código enmainpara llamarla, hablemos un poco más sobre lo
que hemos escrito y lo que significa.

Cuando Rust ve un bloque marcado con la palabra claveasync, lo compila en un
tipo de datos único y anónimo que implementa el traitFuture. Cuando Rust ve
una función marcada conasync, la compila en una función no asíncrona cuyo
cuerpo es un bloque asíncrono. El tipo de retorno de una función asíncrona es
el tipo del tipo de datos anónimo que el compilador crea para ese bloque 
asíncrono.

Por lo tanto, escribirasync fnes equivalente a escribir una función que
devuelve unfuturodel tipo de retorno. Cuando el compilador ve una definición
de función como laasync fn page_titleen el Listado 17-1, es equivalente a
una función no asíncrona definida de la siguiente manera:

Veamos cada parte de la versión transformada:

Ahora podemos llamar apage_titleenmain. Para empezar, solo obtendremos
el título de una sola página. En el Listado 17-3, seguimos el mismo patrón que
usamos para obtener los argumentos de la línea de comandos en el Capítulo 12.
Luego pasamos la primera URL apage_title, y esperamos el resultado. Dado que
el valor producido por el futuro es unOption<String>, usamos una expresiónmatchpara imprimir diferentes mensajes para tener en cuenta si la página
tenía un<title>.

Desafortunadamente, esto no compila. El único lugar donde podemos usar la
palabra claveawaites en funciones o bloques asíncronos, y Rust no nos
permitirá marcar la función especialmaincomoasync.

La razón por la quemainno puede ser marcada comoasynces que el código
asíncrono necesita unruntime: un crate de Rust que gestiona los detalles de
la ejecución de código asíncrono. La funciónmainde un programa puedeinicializarun runtime, pero no es un runtimeen sí mismo. (Veremos más
sobre por qué esto es un poco más adelante.) Cada programa de Rust que ejecuta
código asíncrono tiene al menos un lugar donde configura un runtime y ejecuta
los futuros.

La mayoría de los lenguajes que admiten asíncrono incluyen un runtime con el
lenguaje. Rust no lo hace. En su lugar, hay muchos runtimes asíncronos
disponibles, cada uno de los cuales hace diferentes compensaciones adecuadas
para el caso de uso al que se dirigen. Por ejemplo, un servidor web de alto
rendimiento con muchos núcleos de CPU y una gran cantidad de RAM tiene
necesidades muy diferentes a las de un microcontrolador con un solo núcleo, una
pequeña cantidad de RAM y sin capacidad para hacer asignaciones en el montón. 
Los crates que proporcionan esos runtimes también suelen suministrar versiones
asíncronas de funcionalidades comunes como la E/S de archivos o de red.

Aquí, y a lo largo del resto de este capítulo, usaremos la funciónrundel
cratetrpl, que toma un futuro como argumento y lo ejecuta hasta su
finalización. Detrás de escena, llamar arunconfigura un runtime para usarlo
para ejecutar el futuro pasado. Una vez que el futuro se completa,rundevuelve cualquier valor que el futuro haya producido.

Podríamos pasar el futuro devuelto porpage_titledirectamente arun. Una
vez completado, podríamos hacer una coincidencia en elOption<String>resultante, de la misma manera que intentamos hacer en el Listado 17-3. Sin
embargo, para la mayoría de los ejemplos en el capítulo (¡y la mayoría del 
código asíncrono en el mundo real!), haremos más que una sola llamada a función
asíncrona, por lo que en su lugar pasaremos un bloqueasyncy esperaremos
explícitamente el resultado de llamar apage_title, como en el Listado 17-4.

Cuando ejecutamos esto, obtenemos el comportamiento que podríamos haber esperado
inicialmente:

¡Uf! ¡Finalmente tenemos algo de código asíncrono funcional! Ahora compila, y
podemos ejecutarlo. Antes de añadir código para competir dos sitios entre sí,
volvamos brevemente nuestra atención a cómo funcionan los futuros.

Cadapunto de espera— es decir, cada lugar donde el código usa la palabra
claveawait— representa un lugar donde el control se devuelve al runtime. 
Para que esto funcione, Rust necesita hacer un seguimiento del estado 
involucrado en el bloque asíncrono, para que el runtime pueda iniciar otro 
trabajo y luego volver cuando esté listo para intentar avanzar en este de nuevo. 
Esta es una máquina de estados invisible, como si escribieras un enum de esta 
manera para guardar el estado actual en cada punto deawait:

Escribir el código para la transición entre cada estado a mano sería tedioso y
propenso a errores, especialmente al añadir más funcionalidad y más estados al
código más adelante. En su lugar, el compilador de Rust crea y gestiona las
estructuras de datos de la máquina de estados para el código asíncrono
automáticamente. Si te lo estás preguntando: sí, las reglas normales de
préstamo y propiedad en torno a las estructuras de datos se aplican. 
Afortunadamente, el compilador también se encarga de comprobarlas por nosotros, 
y tiene buenos mensajes de error. ¡Trabajaremos a través de algunos de esos más 
tarde en el capítulo!

En última instancia, algo tiene que ejecutar esa máquina de estados. Eso algo es
un runtime. (Es por eso que a veces puedes encontrarte con referencias aejecutoresal investigar runtimes: un ejecutor es la parte de un runtime
responsable de ejecutar el código asíncrono.)

Ahora podemos entender por qué el compilador nos impidió hacer quemainen sí
fuera una función asíncrona en el Listado 17-3. Simainfuera una función
asíncrona, algo más tendría que gestionar la máquina de estados para cualquier
futuro quemaindevolviera, ¡peromaines el punto de inicio del programa!
En su lugar, llamamos a la funcióntrpl::runenmain, que configura un
runtime y ejecuta el futuro devuelto por el bloqueasynchasta que devuelvaReady.

Nota: algunos runtimes proporcionan macros para quepuedasescribir una
funciónmainasíncrona. Esos macros reescribenasync fn main() { ... }para ser unfn mainnormal que hace lo mismo que hicimos a mano en el
Listado 17-4: llamar a una función que ejecuta un futuro hasta su finalización
de la misma manera quetrpl::runhace.

Pongamos estas piezas juntas y veamos cómo podemos escribir código concurrente,
llamando apage_titlecon dos URLs diferentes pasadas desde la línea de
comandos y compitiéndolas.

En el Listado 17-5, comenzamos llamando apage_titlepara cada una de las
URLs proporcionadas por el usuario. Guardamos los futuros producidos al llamar apage_titlecomotitle_fut_1ytitle_fut_2. Recuerda, estos todavía no
hacen nada, porque los futuros son perezosos, y aún no los hemos esperado. Luego
pasamos los futuros atrpl::race, que devuelve un valor para indicar cuál de
los futuros pasados a él termina primero.

Nota: Bajo el capó,raceestá construido sobre una función más general,select, que encontrarás más a menudo en el código de Rust del mundo real.
Una funciónselectpuede hacer muchas cosas que la funcióntrpl::raceno
puede, pero también tiene cierta complejidad adicional que podemos omitir por
ahora.

Cualquiera de los futuros puede “ganar” legítimamente, por lo que no tiene
sentido devolver unResult. En su lugar,racedevuelve un tipo que no hemos
visto antes,trpl::Either. El tipoEitheres algo similar a unResult, en
que tiene dos casos. A diferencia deResult, sin embargo, no hay noción de
éxito o fracaso integrada enEither. En su lugar, usaLeftyRightpara
indicar “uno u otro”.

La funciónracedevuelveLeftcon el resultado del primer futuro que 
finalice, oRightcon el resultado del segundo futuro si ese finaliza primero. 
Esto coincide con el orden en que aparecen los argumentos al llamar a la 
función: el primer argumento está a la izquierda del segundo.

También actualizamospage_titlepara devolver la misma URL pasada. De esa
manera, si la página que se devuelve primero no tiene un<title>que podamos
resolver, aún podemos imprimir un mensaje significativo. Con esa información
disponible, terminamos actualizando nuestra salida deprintln!para indicar
tanto qué URL terminó primero como cuál fue el<title>de la página web en
esa URL, si lo hay.

¡Has construido un pequeño scraper web funcional ahora! Elige un par de URLs y
ejecuta la herramienta de línea de comandos. Puedes descubrir que algunos sitios
son confiablemente más rápidos que otros, mientras que en otros casos qué sitio
“gana” varía de una ejecución a otra. Más importante aún, has aprendido los
conceptos básicos de trabajar con futuros, por lo que ahora podemos profundizar
en aún más de las cosas que podemos hacer con asíncrono.

## Código

```
Future
```

```
Future
```

```
Future
```

```
Future
```

```
Iterator
```

```
Future
```

```
Future
```

```
futures
```

```
futures
```

```
Future
```

```
hello-async
```

```
$cargo new hello-async$cdhello-async$cargo add trpl
```

```
$cargo new hello-async$cdhello-async$cargo add trpl
```

```
<title>
```

```
externcratetrpl;// required for mdbook testfnmain() {//TODO:we'll add this next!}usetrpl::Html;asyncfnpage_title(url: &str) ->Option<String> {letresponse = trpl::get(url).await;letresponse_text = response.text().await;
    Html::parse(&response_text)
        .select_first("title")
        .map(|title_element| title_element.inner_html())
}
```

```
externcratetrpl;// required for mdbook testfnmain() {//TODO:we'll add this next!}usetrpl::Html;asyncfnpage_title(url: &str) ->Option<String> {letresponse = trpl::get(url).await;letresponse_text = response.text().await;
    Html::parse(&response_text)
        .select_first("title")
        .map(|title_element| title_element.inner_html())
}
```

```
externcratetrpl;// required for mdbook testfnmain() {//TODO:we'll add this next!}usetrpl::Html;asyncfnpage_title(url: &str) ->Option<String> {letresponse = trpl::get(url).await;letresponse_text = response.text().await;
    Html::parse(&response_text)
        .select_first("title")
        .map(|title_element| title_element.inner_html())
}
```

```
page_title
```

```
trpl::get
```

```
thread::spawn
```

```
response_text
```

```
Html::parse
```

```
select_first
```

```
"title"
```

```
<title>
```

```
select_first
```

```
Option<ElementRef>
```

```
Option::map
```

```
Option
```

```
inner_html
```

```
title_element
```

```
String
```

```
Option<String>
```

```
page_title
```

```
trpl::get
```

```
externcratetrpl;// required for mdbook testusetrpl::Html;fnmain() {//TODO:we'll add this next!}asyncfnpage_title(url: &str) ->Option<String> {letresponse_text = trpl::get(url).await.text().await;Html::parse(&response_text).select_first("title").map(|title_element| title_element.inner_html())}
```

```
externcratetrpl;// required for mdbook testusetrpl::Html;fnmain() {//TODO:we'll add this next!}asyncfnpage_title(url: &str) ->Option<String> {letresponse_text = trpl::get(url).await.text().await;Html::parse(&response_text).select_first("title").map(|title_element| title_element.inner_html())}
```

```
externcratetrpl;// required for mdbook testusetrpl::Html;fnmain() {//TODO:we'll add this next!}asyncfnpage_title(url: &str) ->Option<String> {letresponse_text = trpl::get(url).await.text().await;Html::parse(&response_text).select_first("title").map(|title_element| title_element.inner_html())}
```

```
Future
```

```
async fn
```

```
async fn page_title
```

```
#![allow(unused)]fnmain() {externcratetrpl;// requerido para mdbook testusestd::future::Future;usetrpl::Html;fnpage_title(url: &str) ->implFuture<Output =Option<String>> {asyncmove{lettext = trpl::get(url).await.text().await;
        Html::parse(&text)
            .select_first("title")
            .map(|title| title.inner_html())
    }
}}
```

```
#![allow(unused)]fnmain() {externcratetrpl;// requerido para mdbook testusestd::future::Future;usetrpl::Html;fnpage_title(url: &str) ->implFuture<Output =Option<String>> {asyncmove{lettext = trpl::get(url).await.text().await;
        Html::parse(&text)
            .select_first("title")
            .map(|title| title.inner_html())
    }
}}
```

```
#![allow(unused)]fnmain() {externcratetrpl;// requerido para mdbook testusestd::future::Future;usetrpl::Html;fnpage_title(url: &str) ->implFuture<Output =Option<String>> {asyncmove{lettext = trpl::get(url).await.text().await;
        Html::parse(&text)
            .select_first("title")
            .map(|title| title.inner_html())
    }
}}
```

```
impl Trait
```

```
Future
```

```
Output
```

```
Output
```

```
Option<String>
```

```
async fn
```

```
page_title
```

```
async move
```

```
Option<String>
```

```
Output
```

```
async move
```

```
async move
```

```
Future
```

```
Future
```

```
page_title
```

```
page_title
```

```
Option<String>
```

```
<title>
```

```
externcratetrpl;// required for mdbook testusetrpl::Html;asyncfnmain() {letargs:Vec<String> = std::env::args().collect();leturl = &args[1];matchpage_title(url).await{Some(title) =>println!("The title for {url} was {title}"),None=>println!("{url} had no title"),
    }
}asyncfnpage_title(url: &str) ->Option<String> {letresponse_text = trpl::get(url).await.text().await;Html::parse(&response_text).select_first("title").map(|title_element| title_element.inner_html())}
```

```
externcratetrpl;// required for mdbook testusetrpl::Html;asyncfnmain() {letargs:Vec<String> = std::env::args().collect();leturl = &args[1];matchpage_title(url).await{Some(title) =>println!("The title for {url} was {title}"),None=>println!("{url} had no title"),
    }
}asyncfnpage_title(url: &str) ->Option<String> {letresponse_text = trpl::get(url).await.text().await;Html::parse(&response_text).select_first("title").map(|title_element| title_element.inner_html())}
```

```
error[E0752]: `main` function is not allowed to be `async`
 --> src/main.rs:6:1
  |
6 | async fn main() {
  | ^^^^^^^^^^^^^^^ `main` function is not allowed to be `async`
```

```
error[E0752]: `main` function is not allowed to be `async`
 --> src/main.rs:6:1
  |
6 | async fn main() {
  | ^^^^^^^^^^^^^^^ `main` function is not allowed to be `async`
```

```
page_title
```

```
Option<String>
```

```
page_title
```

```
externcratetrpl;// required for mdbook testusetrpl::Html;fnmain() {letargs:Vec<String> = std::env::args().collect();

    trpl::run(async{leturl = &args[1];matchpage_title(url).await{Some(title) =>println!("The title for {url} was {title}"),None=>println!("{url} had no title"),
        }
    })
}asyncfnpage_title(url: &str) ->Option<String> {letresponse_text = trpl::get(url).await.text().await;Html::parse(&response_text).select_first("title").map(|title_element| title_element.inner_html())}
```

```
externcratetrpl;// required for mdbook testusetrpl::Html;fnmain() {letargs:Vec<String> = std::env::args().collect();

    trpl::run(async{leturl = &args[1];matchpage_title(url).await{Some(title) =>println!("The title for {url} was {title}"),None=>println!("{url} had no title"),
        }
    })
}asyncfnpage_title(url: &str) ->Option<String> {letresponse_text = trpl::get(url).await.text().await;Html::parse(&response_text).select_first("title").map(|title_element| title_element.inner_html())}
```

```
$cargo run -- https://www.rust-lang.orgFinished `dev` profile [unoptimized + debuginfo] target(s) in 0.05s
     Running `target/debug/async_await 'https://www.rust-lang.org'`
The title for https://www.rust-lang.org was
            Rust Programming Language
```

```
$cargo run -- https://www.rust-lang.orgFinished `dev` profile [unoptimized + debuginfo] target(s) in 0.05s
     Running `target/debug/async_await 'https://www.rust-lang.org'`
The title for https://www.rust-lang.org was
            Rust Programming Language
```

```
#![allow(unused)]fnmain() {externcratetrpl;// required for mdbook testenumPageTitleFuture<'a> {
    Initial { url: &'astr},
    GetAwaitPoint { url: &'astr},
    TextAwaitPoint { response: trpl::Response },
}}
```

```
#![allow(unused)]fnmain() {externcratetrpl;// required for mdbook testenumPageTitleFuture<'a> {
    Initial { url: &'astr},
    GetAwaitPoint { url: &'astr},
    TextAwaitPoint { response: trpl::Response },
}}
```

```
#![allow(unused)]fnmain() {externcratetrpl;// required for mdbook testenumPageTitleFuture<'a> {
    Initial { url: &'astr},
    GetAwaitPoint { url: &'astr},
    TextAwaitPoint { response: trpl::Response },
}}
```

```
trpl::run
```

```
async fn main() { ... }
```

```
fn main
```

```
trpl::run
```

```
page_title
```

```
externcratetrpl;// required for mdbook testusetrpl::{Either, Html};fnmain() {letargs:Vec<String> = std::env::args().collect();

    trpl::run(async{lettitle_fut_1 = page_title(&args[1]);lettitle_fut_2 = page_title(&args[2]);let(url, maybe_title) =matchtrpl::race(title_fut_1, title_fut_2).await{
                Either::Left(left) => left,
                Either::Right(right) => right,
            };println!("{url} returned first");matchmaybe_title {Some(title) =>println!("Its page title is: '{title}'"),None=>println!("Its title could not be parsed."),
        }
    })
}asyncfnpage_title(url: &str) -> (&str,Option<String>) {lettext = trpl::get(url).await.text().await;lettitle = Html::parse(&text)
        .select_first("title")
        .map(|title| title.inner_html());
    (url, title)
}
```

```
externcratetrpl;// required for mdbook testusetrpl::{Either, Html};fnmain() {letargs:Vec<String> = std::env::args().collect();

    trpl::run(async{lettitle_fut_1 = page_title(&args[1]);lettitle_fut_2 = page_title(&args[2]);let(url, maybe_title) =matchtrpl::race(title_fut_1, title_fut_2).await{
                Either::Left(left) => left,
                Either::Right(right) => right,
            };println!("{url} returned first");matchmaybe_title {Some(title) =>println!("Its page title is: '{title}'"),None=>println!("Its title could not be parsed."),
        }
    })
}asyncfnpage_title(url: &str) -> (&str,Option<String>) {lettext = trpl::get(url).await.text().await;lettitle = Html::parse(&text)
        .select_first("title")
        .map(|title| title.inner_html());
    (url, title)
}
```

```
page_title
```

```
page_title
```

```
title_fut_1
```

```
title_fut_2
```

```
trpl::race
```

```
select
```

```
select
```

```
trpl::race
```

```
Result
```

```
trpl::Either
```

```
Either
```

```
Result
```

```
Result
```

```
Either
```

```
#![allow(unused)]fnmain() {enumEither<A, B> {
    Left(A),
    Right(B),
}}
```

```
#![allow(unused)]fnmain() {enumEither<A, B> {
    Left(A),
    Right(B),
}}
```

```
#![allow(unused)]fnmain() {enumEither<A, B> {
    Left(A),
    Right(B),
}}
```

```
page_title
```

```
<title>
```

```
println!
```

```
<title>
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

- El cratefutureses un hogar oficial para la experimentación de Rust para
el código asíncrono, y es en realidad donde el tipoFuturefue diseñado
originalmente.
- Tokio es el runtime asíncrono más utilizado en Rust hoy en día, especialmente
(¡pero no solo!) para aplicaciones web. Hay otros runtimes geniales por ahí,
y pueden ser más adecuados para tus propósitos. Usamos Tokio bajo el capó
paratrplporque está bien probado y ampliamente utilizado.

- Utiliza la sintaxisimpl Traitque discutimos en la sección“Traits como
parámetros”en el Capítulo 10.
- El trait devuelto es unFuture, con un tipo asociado deOutput. Observa
que el tipoOutputesOption<String>, que es el mismo que el tipo de
retorno original de la versiónasync fndepage_title.
- Todo el código llamado en el cuerpo de la función original está envuelto en
un bloqueasync move. Recuerda que los bloques son expresiones. Todo este
bloque es la expresión devuelta por la función.
- Este bloque asíncrono produce un valor con el tipoOption<String>, como se
describió anteriormente. Ese valor coincide con el tipoOutputen el tipo de
retorno. Esto es igual que otros bloques que has visto.
- El nuevo cuerpo de la función es un bloqueasync movedebido a cómo usa el
parámetrourl. (Hablaremos mucho más sobreasyncvs.async movemás
adelante en el capítulo.)
- La nueva versión de la función tiene un tipo de duración que no hemos visto
antes en el tipo de salida:'_. Debido a que la función devuelve unFutureque se refiere a una referencia —en este caso, la referencia del parámetrourl— necesitamos decirle a Rust que queremos que esa referencia esté
incluida. No tenemos que nombrar la duración aquí, porque Rust es lo
suficientemente inteligente como para saber que solo hay una referencia que
podría estar involucrada, perosítenemos que ser explícitos en que elFutureresultante está vinculado por esa duración.