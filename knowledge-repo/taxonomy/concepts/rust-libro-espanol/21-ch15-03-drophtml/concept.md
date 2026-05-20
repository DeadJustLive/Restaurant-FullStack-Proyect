# Ch15 03 drop.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 21)

## Contenido
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
función está en el prelude, así que podemos m

> [Contenido truncado — consulta el capítulo completo con knowledge read]
