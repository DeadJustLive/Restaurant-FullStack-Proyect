# 0. De igual manera si se trabaja con divisiones, la

## Fuente
logica-de-programacion (Cap. 53)

## Contenido
# 0. De igual manera si se trabaja con divisiones, la

variable valorDecremento por ning´un motivo podr´ıa tomar el
valor de 0, la divisi´on entre 0 no est´a definida.
4.1.3 Bandera
Es una variable que se usa para controlar diferentes acciones dentro de
un algoritmo. Algunos textos se refieren a esta variable como interruptor,
conmutador o centinela [Joyanes A., 1996].
Una variable bandera puede ser definida virtualmente de cualquier tipo
de dato. Generalmente estas variables toman uno de dos valores posibles,
ese valor depende del tipo de dato con que fue declarada.
Si la variable es de tipo Logico, los ´unicos valores posibles son
Verdadero o Falso. Si la variable es de tipo Entero los valores posibles

-- 183 of 450 --

182 Estructuras de repetici ´on
podr´ıan ser 1 o 0, que se pueden interpretar como verdadero o encendido
para el 1 y falso o apagado para el 0. Si la declaraci´on se hizo de tipo
Caracter, puede tomar cualquier valor; los valores m´as comunes son ’S’o
’N’, interpretados como ’S’ = S´ı o ’N’= No. Sin embargo, para estos dos
´ultimos tipos de datos, el dise˜nador del algoritmo le puede asignar los
valores que estime convenientes.
Es fundamental darle un valor inicial a la variable bandera, el cual
cambiar´a dependiendo de ciertas condiciones que estar´an dadas por la
soluci´on del problema. De acuerdo a lo explicado en los p´arrafos anteriores,
el valor inicial debe ser uno de los posibles que puede tomar; una vez se
presente la situaci´on esperada estos valores deber´an cambiar su estado al
valor contrario, es decir, si se inicializ´o en Verdadero cambiar´a a Falso,
si fue en 1 cambiar´a a 0 y si fue en ’S’cambiar´a a ’N’. Luego de ejecutar
las instrucciones correspondientes podr´ıan retomar su valor inicial.
En los siguientes p´arrafos a lo largo de este cap´ıtulo, a medida que se
estudian las diferentes estructuras de repetici´on, se ilustrar´a el uso de este
tipo de variables.
4.2. Estructura Mientras - FinMientras
Es una estructura de repetici´on que permite que una instrucci´on o un
conjunto de ellas se ejecuten una o m´as veces, o por el contrario que no
lleguen a ejecutarse ya que todo depende del resultado de una condici´on
que debe evaluarse al inicio del ciclo.
La forma general de esta estructura de repetici´on es presentada en el
segmento del Algoritmo 4.1.
Algoritmo 4.1: Forma general - Mientras-FinMientras
1 Instrucci´on de inicializaci´on
2 Mientras( condici´on )
3 Instrucci´on-1
4 Instrucci´on-2
5 ... /* Cuerpo del ciclo */
6 Instrucci´on-n
7 Instrucci´on modificadora de condici´on
8 FinMientras
9 Instrucci´on externa
Teniendo en cuenta que el Mientras-FinMientras es una
instrucci´on repetitiva condicionada al inicio, se debe prestar especial
cuidado en inicializar la variable o las variables que ser´an evaluadas en

-- 184 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 183
la condici´on, ya que de esto depende que se ejecute o no el cuerpo del
ciclo; es por ello que dentro de la anterior forma general se contempla una
Instrucci´on de inicializaci´on (l´ınea 1). De igual manera la inicializaci´on
tambi´en se aplica a los contadores y acumuladores que ser´an modificados
dentro del ciclo. La inicializaci´on puede estar impl´ıcita en el mismo
algoritmo o puede ser suministrada por el usuario.
Al encontrar la instrucci´on Mientras se debe evaluar la condici´on
(l´ınea 2), la cual estar´a representada por una expresi´on relacional o l´ogica.
Si el resultado de la evaluaci´on es verdadero, entonces se procede a ejecutar
el cuerpo del ciclo (l´ıneas de la 3 a la 7) hasta encontrar la instrucci´on
FinMientras; luego el control del algoritmo regresa al inicio del ciclo,
es decir a la instrucci´on Mientras y una vez m´as se eval´ua la condici´on.
Este proceso terminar´a en el momento que la evaluaci´on de la condici´on
arroje un resultado falso, en cuyo caso el control del algoritmo lo asume la
Instrucci´on externa (l´ınea 9), la cual no hace parte del ciclo.
Cuando se eval´ue por primera vez la condici´on y el resultado sea falso,
las instrucciones que componen el cuerpo del ciclo no se ejecutan; el control
lo asume la Instrucci´on externa.
En conclusi´on, este ciclo itera mientras el valor de la condici´on sea
verdadero.
Es importante tener presente que todo ciclo debe terminar de ejecutarse
cuando cumpla con la tarea para la cual fue dise˜nado, para ello dentro de
su cuerpo se encuentra la Instrucci´on modificadora de condici´on (l´ınea 7)
cuyo prop´osito es cambiar el estado de la condici´on. De omitir la instrucci´on
modificadora, se obtendr´a lo que se conoce como un “Ciclo infinito”, debido
a que su ejecuci´on “nunca termina”. Aunque en la forma general est´a
representada de ´ultima en la secuencia de instrucciones que componen
el cuerpo del ciclo, no necesariamente debe ocupar ese lugar.
Para representar la estructura de repetici´on Mientras -
FinMientras mediante un diagrama de flujo, se usa la notaci´on que
se presenta en la Figura 4.1.

-- 185 of 450 --

184 Estr
