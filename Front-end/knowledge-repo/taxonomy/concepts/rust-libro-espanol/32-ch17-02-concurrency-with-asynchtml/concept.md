# Ch17 02 concurrency with async.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 32)

## Contenido
# Ch17 02 concurrency with async.html

# El Lenguaje de Programación Rust

## Aplicando Concurrencia con Async

### Crear una nueva tarea conspawn_task

### Paso de Mensajes

En esta sección, aplicaremos async a algunos de los mismos desafíos
de concurrencia que abordamos con threads en el capítulo 16. Hemos explorado muchas de
las ideas claves en esa sección, aquí se profundizara en las diferencias
entre threads and futures.

En muchos casos, las APIs para trabajar con concurrencia usando async son muy
similares a las que se usan con threads. En otros casos, terminan teniendo formas
bastante diferentes. Incluso cuando las APIs parecen similares entre threads y async,
a menudo presentan comportamientos distintos y casi siempre tienen diferentes
características de rendimiento.

La primera tarea que abordamos enCrear un nuevo hilo con Spawnfue contar en dos threads separados. Hagamos lo mismo usando async. El
cratetrplproporciona una funciónspawn_task, que se comporta de forma muy 
similar a la API dethread::spawn, y una funciónsleep,
que es una versión async dethread::sleep. Podemos usarlas juntas para implementar
el mismo ejemplo de conteo que con threads, como se muestra en el Listado 17-6.

Como punto de partida, configuramos nuestra funciónmaincontrpl::run, de
de modo que nuestra función de nivel superior pueda ser async.

Nota: A partir de este punto en el capítulo, cada ejemplo incluirá
este mismo código de envoltura contrpl::runenmain, así que a menudo lo omitiremos,
igual que hacemos conmain. ¡No olvides incluirlo en tu código!

Luego, dentro de ese bloque, escribimos dos bucles, cada uno con una llamada atrpl::sleep,
que espera medio segundo (500 milisegundos) antes de enviar el siguiente
mensaje. Uno de los bucles va dentro detrpl::spawn_task, mientras que el otro se ejecuta
en un bucleforde nivel superior. También añadimos unawaitdespués de cada llamada asleep.

El resultado es similar a la versión basada en threads, incluyendo el detalle
de que los mensajes podrían aparecer en un orden distinto cada vez
que lo ejecutes en tu terminal.

Esta versión se detiene tan pronto como el bucle for dentro del bloque async principal
termina, porque la tarea creada conspawn_taskse cierra cuando finaliza la función
main. Si quieres que el programa siga ejecutándose hasta que la tarea termine por completo,
necesitas usar un join handle para esperar a que la primera tarea finalice. Con
threads, utilizamos el métodojoinpara “bloquear”, la ejecución hasta que el hilo terminara.
En el Listado 17-7, podemos hacer lo mismo conawait, ya que el handle de la tarea
en sí es un future. Su tipo deOutputes unResult, por lo que también usamos unwrap
después de esperarlo con await.

Esta versión actualizada se ejecuta hasta queambosbucles terminan.

Hasta ahora, parece que async y threads nos dan los mismos resultados básicos, solo
que con una sintaxis diferente: usamosawaiten lugar de llamar ajoinen el join
handle, y también esperamos las llamadas asleep.

La mayor diferencia aquí es que no necesitamos crear otro hilo del sistema operativo
para lograrlo. De hecho, ni siquiera es necesario generar una tarea separada. Pues
los bloques async se compilan en futures anónimos, podemos colocar cada bucle dentro de un
bloque async y dejar que el runtime los ejecute hasta su finalización usando la
funcióntrpl::join.

En la secciónEsperando a que todos los hilos terminen usandojoinhandles, 
mostramos cómo usar el métodojoinen el tipoJoinHandleque se obtiene al llamarstd::thread::spawn. La funcióntrpl::joines
similar, pero para futures. Cuando le pasas dos futures, genera un nuevo
future cuyo resultado es una tupla con los valores de salida de los futures originales,
pero solo cuandoamboshan finalizado. Es decir, en Listado 17-8, usamostrpl::joinpara esperar a
que tantofut1comofut2finalicen. En lugar de hacer await sobrefut1yfut2por separado, esperamos
el nuevo futuro producido portrpl::join. Ignoramos su salida, debido a que
solo contiene una tupla con dos valores unitarios.

Cuando ejecutamos esto, vemos que ambos futuros se ejecutan hasta completarse:

Aquí verás exactamente el mismo orden en cada ejecución, lo cual es muy diferente
de lo que ocurría con threads. Esto se debe a que la funcióntrpl::joinesjusta,
lo que significa que revisa cada future con la misma frecuencia, alternando entre ellos y evitando
que uno avance más rápido que el otro si ambos están listos. Con threads, el sistema operativo
decide qué hilo revisar y cuánto tiempo permitirle ejecutarse. Con async Rust, es
el runtime el que decide que tarea revisar. (En la práctica, esto se vuelve más complejo
porque un runtime async puede usar threads del sistema operativo en segundo
plano para gestionar la concurrencia, lo que hace que garantizar la equidad requiera más trabajo
—¡pero sigue siendo posible!). Los runtimes no están obligados
a garantizar equidad en todas las operaciones, y muchas veces ofrecen diferentes APIs
para que elijas si quieres equidad o no.

Prueba 
