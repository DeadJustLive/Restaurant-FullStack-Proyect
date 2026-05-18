# Ch17 06 futures tasks threads.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 35)

## Contenido
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
funcionan muy 
