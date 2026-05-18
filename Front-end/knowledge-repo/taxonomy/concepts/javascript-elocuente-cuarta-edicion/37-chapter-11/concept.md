# Chapter 11

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 37)

## Contenido
# Chapter 11

Programación Asíncrona
La parte central de una computadora, la parte que lleva a cabo los pasos
individuales que componen nuestros programas, se llama el procesador. Los
programas que hemos visto hasta ahora mantendrán ocupado al procesador
hasta que hayan terminado su trabajo. La velocidad a la cual algo como un
bucle que manipula números puede ser ejecutado depende casi enteramente de
la velocidad del procesador y la memoria de la computadora.
Pero muchos programas interactúan con cosas fuera del procesador. Por
ejemplo, pueden comunicarse a través de una red de computadoras o solicitar
datos desde el disco duro, lo cual es mucho más lento que obtenerlo de la
memoria.
Cuando esto está sucediendo, sería una lástima dejar el procesador inactivo,
ya que podría haber otro trabajo que podría hacer en ese tiempo. En parte,
esto es manejado por tu sistema operativo, el cual cambiará el procesador entre
múltiples programas en ejecución. Pero eso no ayuda cuando queremos que un
único programa pueda avanzar mientras espera una solicitud de red.
Asincronía
En un modelo de programación sincrónico, las cosas suceden una a la vez.
Cuando llamas a una función que realiza una acción de larga duración, solo
devuelve cuando la acción ha terminado y puede devolver el resultado. Esto
detiene tu programa durante el tiempo que tome la acción.
Un modelo asincrónico permite que múltiples cosas sucedan al mismo tiempo.
Cuando inicias una acción, tu programa continúa ejecutándose. Cuando la
acción termina, el programa es informado y obtiene acceso al resultado (por
ejemplo, los datos leídos desde el disco).
Podemos comparar la programación sincrónica y asincrónica usando un pe-
queño ejemplo: un programa que realiza dos solicitudes a través de la red y
luego combina los resultados.
En un entorno sincrónico, donde la función de solicitud devuelve solo después
179

-- 191 of 445 --

de haber hecho su trabajo, la forma más fácil de realizar esta tarea es hacer las
solicitudes una después de la otra. Esto tiene la desventaja de que la segunda
solicitud se iniciará solo cuando la primera haya terminado. El tiempo total
tomado será al menos la suma de los dos tiempos de respuesta.
La solución a este problema, en un sistema sincrónico, es iniciar hebras de
control adicionales. Una hebra es otro programa en ejecución cuya ejecución
puede ser intercalada con otros programas por el sistema operativo, ya que
la mayoría de las computadoras modernas contienen múltiples procesadores,
múltiples hebras incluso podrían ejecutarse al mismo tiempo, en diferentes
procesadores. Una segunda hebra podría iniciar la segunda solicitud, y luego
ambas hebras esperan que sus resultados regresen, después de lo cual se resin-
cronizan para combinar sus resultados.
En el siguiente diagrama, las líneas gruesas representan el tiempo que el
programa pasa funcionando normalmente, y las líneas delgadas representan el
tiempo gastado esperando a la red. En el modelo síncrono, el tiempo tomado
por la red es parte de la línea de tiempo para un hilo de control dado. En el
modelo asíncrono, iniciar una acción en la red permite que el programa continúe
ejecutándose mientras la comunicación en la red sucede junto a él, notificando
al programa cuando haya terminado.
synchronous, single thread of control
synchronous, two threads of control
asynchronous
Otra forma de describir la diferencia es que esperar a que las acciones termi-
nen es implícito en el modelo síncrono, mientras que es explícito, bajo nuestro
control, en el modelo asíncrono.
La asincronía tiene sus pros y sus contras. Facilita la expresión de programas
que no encajan en el modelo de control de línea recta, pero también puede
hacer que expresar programas que siguen una línea recta sea más complicado.
Veremos algunas formas de reducir esta dificultad más adelante en el capítulo.
Tanto las plataformas de programación de JavaScript prominentes —navegadores
como Node.js— hacen operaciones que podrían tardar un tiempo de forma
asíncrona, en lugar de depender de hilos. Dado que programar con hilos es
notoriamente difícil (entender lo que hace un programa es mucho más difícil
cuando está haciendo múltiples cosas a la vez), esto generalmente se considera
180

-- 192 of 445 --

algo bueno.
Retrollamadas
Un enfoque para la programación asíncrona es hacer que las funciones que
necesitan esperar por algo tomen un argumento adicional, una función de de-
volución de llamada. La función asíncrona inicia algún proceso, configura las
cosas para que se llame a la función de devolución de llamada cuando el proceso
termine, y luego retorna.
Como ejemplo, la función setTimeout, disponible tanto en Node.js como en
los navegadores, espera un número dado de milisegundos (un segundo equivale
a mil milisegundos) y luego llama a una función.
setTimeout(() => console.log("Tick"), 500);
Esperar no suele ser un tipo de trabajo muy importante, pero puede ser muy
útil cuando necesitas organizar que algo suceda en un momento dete
