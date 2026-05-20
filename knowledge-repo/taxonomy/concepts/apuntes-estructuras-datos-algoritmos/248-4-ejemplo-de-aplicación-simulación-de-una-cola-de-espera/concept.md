# 4. Ejemplo de aplicación: simulación de una cola de espera

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 248)

## Contenido
# 4. Ejemplo de aplicación: simulación de una cola de espera

Cada día tenemos que hacer cola en numerosas ocasiones para obtener un cierto “servicio” por parte de algún agente
o “servidor”. No debe sorprendernos, por tanto, que el uso de colas sea importante en muchas aplicaciones informáticas.
Ejemplos de colas se dan en las siguientes situaciones: personas esperando ante ventanillas de bancos o aeropuertos,
coches esperando en una calle ante un semáforo en rojo o en una autopista ante un puesto de peaje, procesos generados por
los usuario de un sistema informático multiusuario esperando a ser ejecutados por el procesador, llamadas telefónicas
recibidas en una centralita esperando hasta obtener línea libre hacia una determinada extensión, piezas de un determinado
tipo esperando en un almacén para ser tratadas por una máquina en un sistema de fabricación, etcétera.
Todas las situaciones anteriores pueden ser simuladas con un computador utilizando una variable del TAD cola que
sirva para modelar o imitar la cola que se produce en la realidad y poder responder a preguntas del tipo de: ¿cuánto tiempo
tiene que esperar, en media, un cliente para obtener un servicio?, ¿cuál es la longitud media de la cola?, ¿cuál es la varianza
de las medidas anteriores?
Vamos a estudiar el caso más sencillo. Hay un solo servidor al que llegan clientes de forma aleatoria y el servicio de
cada uno de ellos le toma un tiempo fijo al servidor (tiempo de servicio). Los parámetros de entrada para ejecutar una
simulación con un computador son: la probabilidad de que durante un intervalo de tiempo de un minuto se produzca la
llegada de un cliente, el tiempo (fijo) de servicio a un cliente y la longitud total del intervalo de tiempo que se quiere simular.
Para llevar a cabo la simulación utilizaremos una cola (entendida aquí como una variable del TAD cola) en la que
almacenar los clientes esperando para ser servidos. Cada elemento de la cola será, en realidad, el instante (entero no
negativo) en el que llegó el cliente.
tipo instanteDeLlegada = 0..maxEntero
Utilizaremos, además, una variable tiempo (entera no negativa) que modela el reloj; su valor inicial será cero y se
incrementará de uno en uno, en cada paso de la simulación, contando los minutos transcurridos.
Cuando el cliente llega al principio de la cola, es decir, ante el servidor, la diferencia entre el tiempo en ese momento
y el instante de su llegada a la cola es el número de minutos que ese cliente ha esperado en la cola (puede ser cero si cuando

-- 91 of 267 --

84
llega el cliente la cola está vacía). Podemos sumar todos esos tiempos de espera hasta el final del tiempo total de simulación
y dividir la suma por el número de clientes que han llegado, y obtener, así, el tiempo medio de espera de un cliente en la
cola.
Para modelar las llegadas aleatorias, utilizaremos una función random que nos devuelve un número (pseudo-)aleatorio
uniformemente distribuido en el intervalo (0,1). Para decidir si un cliente llega o no durante un intervalo de tiempo de un
minuto, preguntamos si el valor obtenido con la función random es menor o no que el valor de la probabilidad de llegada
de un pasajero en un minuto cualquiera (valor, este último, solicitado como parámetro de entrada antes de comenzar la
simulación).
El algoritmo esbozado previamente es como sigue:
procedimiento simulador
importa colasDeInstantesDeLlegada
variables cola:colaDeInstantesDeLlegada;
probabilidadLlegada,esperaMedia:real;
tiempoServicio,tiempoSimulación,tiempo,
tiempoQuedaServicio,númeroClientes,
sumaDeEsperas,instanteLlegada:0..maxEntero
función random devuelve real
{Devuelve un número (pseudo-)aleatorio en el intervalo (0,1). No la implementamos.}
principio
escribir('DATOS');
escribir('Probabilidad de que llegue un cliente durante un minuto:');
leer(probabilidadLlegada);
escribir('Tiempo requerido por cada servicio (en minutos):');
leer(tiempoServicio);
escribir('Longitud de la simulación (tiempo total, en minutos):');
leer(tiempoSimulación);
creaVacía(cola);
tiempo:=0;
tiempoQuedaServicio:=0; { el servidor está libre, en principio }
númeroClientes:=0;
sumaDeEsperas:=0;
mientrasQue tiempo ≤ tiempoSimulación hacer
si random < probabilidadLlegada entonces
añadir(cola,tiempo)
fsi;
si tiempoQuedaServicio = 0 entonces
si not esVacía(cola) entonces
instanteLlegada:=primero(cola);
eliminar(cola);
sumaDeEsperas:=sumaDeEsperas+(tiempo-instanteLlegada);
númeroClientes:=númeroClientes+1;
tiempoQuedaServicio:=tiempoServicio
fsi
fsi;
tiempo:=tiempo+1;
si tiempoQuedaServicio > 0 entonces
tiempoQuedaServicio:=tiempoQuedaServicio-1
fsi
fmq;
si númeroClientes = 0 entonces
esperaMedia:=0.0
sino
esperaMedia:=sumaDeEsperas/númeroClientes
fsi;
escribir('RESULTADOS');

-- 92 of 267 --

85
escribir('Número de clientes servidos: ',númeroClientes);
escribir('Tiempo medio de espera (en minutos): ', esperaMedia)
fin
A continuación, se muestra el resultado obtenido al ejecutar tres veces el algoritmo anterior para datos idénticos:
DATOS
Pr
