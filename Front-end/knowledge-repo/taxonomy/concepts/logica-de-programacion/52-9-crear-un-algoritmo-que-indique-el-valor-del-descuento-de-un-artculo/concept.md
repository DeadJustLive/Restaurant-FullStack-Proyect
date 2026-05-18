# 9. Crear un algoritmo que indique el valor del descuento de un art´ıculo

## Fuente
logica-de-programacion (Cap. 52)

## Contenido
# 9. Crear un algoritmo que indique el valor del descuento de un art´ıculo

dependiendo de su valor:
Rango de valores Porcentaje de descuento
$0.0 hasta $100.000 0 %
M´as de $100.000 hasta $225.000 1.5 %
M´as de $225.000 hasta $375.000 3.8 %
M´as de $375.000 10.3 %
Tabla 3.5: Tabla de descuento seg´un el rango de valores

-- 177 of 450 --



-- 178 of 450 --

Cap´ıtulo 4
Estructuras de repetici´	on
Si el c´odigo y los comentarios no
coinciden, posiblemente ambos
sean err´oneos
Norm Schryer
Objetivos del cap´ıtulo:
Identificar el tipo de variables que intervienen
en el manejo de estructuras de repetici´on
(contador, acumulador, centinela).
Comprender el funcionamiento de las diferentes
estructuras de repetici´on.
Implementar algoritmos que involucran el uso
de estructuras de repetici´on.
Elaborar pruebas de escritorios con procesos
iterativos

-- 179 of 450 --



-- 180 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 179
En la soluci´on de algunos problemas, se requiere que el algoritmo ejecute
la misma tarea de forma repetitiva; es ah´ı donde cobran protagonismo las
estructuras de repetici´on. Estas estructuras tambi´en reciben el nombre de
ciclos o de bucles, ellas permiten que una instrucci´on o un bloque de
ellas se pueda ejecutar m´as de una vez. A cada ejecuci´on de un ciclo se le
denomina iteraci´on.
En este libro se estudiar´an las siguientes estructuras de repetici´on:
Mientras - FinMientras
Haga - MientrasQue
Para - FinPara
4.1. Conceptos b´asicos
Es importante que el lector, antes de iniciar la construcci´on de los
algoritmos que las incluyen, se familiarice con algunos conceptos b´asicos
entorno a ellas.
4.1.1 Contador
Como su nombre lo indica, es una variable que tiene la funci´on de llevar
la cuenta de determinadas situaciones que se repiten dentro de los ciclos.
Por ejemplo, es com´un contar:
Goles en un juego de un partido de f´utbol.
Cantidad de t´erminos que tiene una serie num´erica.
Los amigos que se tienen en Facebook.
Cantidad de votos que obtienen los candidatos en unas elecciones.
El n´umero de visitas a un video en YouTube.
Esta clase de variables se declaran de tipo Entero. Deben inicializarse
antes de entrar al ciclo, es decir, se le debe asignar un valor inicial que
corresponde al n´umero desde el cual se requiere que inicie el conteo,
generalmente se inicializan en 0; aunque todo depende del problema que
se va a resolver.

-- 181 of 450 --

180 Estructuras de repetici ´on
Dentro del ciclo debe haber una instrucci´on que modifique el valor del
contador, su forma general es la siguiente:
contador = contador + valorIncremento
contador = contador - valorDecremento
El valor a incrementar o decrementar, hace referencia a cualquier
cantidad de tipo num´erico, en la cual aumenta o disminuye su valor en cada
iteraci´on del ciclo. Los valores a incrementar o decrementar son cantidades
constantes.
En los ejemplos anteriores, la cantidad de amigos en Facebook se
incrementa en el momento que se confirme una solicitud de amistad o
se decrementa cuando se elimina un contacto de la lista de amigos.
4.1.2 Acumulador
Un acumulador es una variable que funciona de forma similar a
un contador, la diferencia radica en que aumentan o disminuyen en
cantidades variables y no en forma constante como es el caso de los
contadores. Algunos autores le dan tambi´en la denominaci´on de totalizador
[Corona and Ancona, 2011].
Un acumulador se puede usar para:
Almacenar el puntaje acumulado en un juego.
Calcular el saldo en una cuenta de ahorros.
Obtener el valor de una sumatoria de notas que luego puede ser usada
para calcular un promedio.
Determinar el valor a pagar en un supermercado cuando se compran
varios art´ıculos.
Conocer el acumulado de puntos que se tienen por compras en un
almac´en o establecimiento comercial que ofrezca este beneficio.
Esta clase de variables se declaran de tipo num´erico, bien sea Entero
o Real. Deben inicializarse antes de entrar al ciclo, es decir, se le
debe asignar un valor inicial que depender´a del problema a resolver,
generalmente se inicializan en 0.
Dentro del ciclo debe haber una instrucci´on que modifique el valor del
acumulador, su forma general es la siguiente:

-- 182 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 181
acumulador = acumulador + valorIncremento
acumulador = acumulador - valorDecremento
El valor a incrementar o valor a decrementar se refiere a cualquier
cantidad de tipo num´erico, en la cual el acumulador aumenta o disminuye
su valor en cada iteraci´on del ciclo. Los valores a incrementar o decrementar
son cantidades variables.
En los ejemplos anteriores, el saldo en una cuenta de ahorros se
incrementa con las consignaciones y se decrementa con los retiros. De igual
forma sucede con los puntos por compras, incrementan por cada compra
que se realice y decrementan en el momento en que se haga un canje por
alg´un art´ıculo o promoci´on.
Existen casos especiales donde la forma general no trabaja con
operaciones de suma o resta, sino que se
