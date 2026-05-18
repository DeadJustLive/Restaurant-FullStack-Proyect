# 3. Pseudoc´odigo.

## Fuente
logica-de-programacion (Cap. 12)

## Contenido
# 3. Pseudoc´odigo.

Descripci´on narrada
Los pasos o instrucciones se describen mediante un lenguaje natural,
usando palabras o frases normales y corrientes. Su uso principal se da en
el dise˜no de algoritmos informales. Son ejemplos de ellos:

-- 49 of 450 --

48 Fundamentos
Indicar como se llega a una direcci´on.
Preparar una deliciosa receta de cocina.
Registrarse en Netflix para disfrutar de su contenido.
Solicitar la autorizaci´on para presentar un examen supletorio en una
Universidad, ejemplo que se desarrollar´a a continuaci´on.
.:Ejemplo 1.1. Examen Supletorio
En la Universidad UQ es com´un la presentaci´on de ex´amenes supletorios,
que son aquellos que se presentan dentro de los 5 d´ıas h´abiles despu´es
de la realizaci´on oficial del examen. Para presentar un supletorio se debe
solicitar autorizaci´on ante el Director del programa, el cual lo autorizar´a
o no, dependiendo de que exista una debida justificaci´on.
Una vez consultado el Director de uno de los Programas de la
Universidad UQ, se pudo establecer el siguiente conjunto de pasos, que
se deben de ejecutar para poder obtener la autorizaci´on de la presentaci´on
del examen supletorio.
Los pasos fueron definidos teniendo en cuenta que no necesariamente
se puede obtener la autorizaci´on; esta puede ser negada si la justificaci´on
presentada no es suficiente motivo para la no presentaci´on. Tambi´en se
tiene en cuenta que si ya pasaron los 5 d´ıas reglamentarios, no se puede
hacer la solicitud. En el caso de que sea autorizada la presentaci´on,
se definieron los pasos hasta el momento que el estudiante presenta el
supletorio.
1 Algoritmo ExamenSupletorio
2 Si est´a dentro del plazo reglamentario
3 a. Dirigirse a la direcci´on del Programa.
4 b. Solicitar autorizaci´on para presentarlo.
5 c. Presentar la justificaci´on ante el Director
6 d. Si autorizan la presentaci´on
7 i. Descargar el recibo de pago (portal).
8 ii. Cancelar el recibo.
9 iii. Presentar el recibo cancelado en la Direcci´on.
10 iv. Recibir formato de autorizaci´on.
11 v. Entregar formato de autorizaci´on al Profesor.
12 vi. Presentar examen supletorio.
13 Si no est´a dentro del plazo reglamentario
14 a. No hacer la solicitud
15 FinAlgoritmo

-- 50 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 49
Antes de entrar en detalle con los diagramas de flujo y pseudoc´odigos,
que son las formas de m´as uso para la representaci´on de algoritmos
computacionales, se debe establecer que este tipo de algoritmos siguen
un patr´on de ejecuci´on en 3 etapas (Ver Figura 1.2).
Entrada Proceso Salida
Figura 1.2: Patr´on de ejecuci´on de un algoritmo
Entrada: en esta etapa se le proporciona al algoritmo los datos que
se poseen del problema y que son necesarios para su soluci´on.
Proceso: hace referencia a los pasos, actividades, instrucciones o
c´alculos que realiza el algoritmo para solucionar el problema o
encontrar un resultado. Generalmente, en esta etapa se transforman
los datos de entrada en resultados de salida.
Salida: es la entrega de resultados o la respuesta dada por el
algoritmo.
Ahora conocer´a como es que los diagramas de flujo y el pseudoc´odigo se
ocupan de hacer la representaci´on de este esquema de entrada, proceso y
salida.
Diagrama de flujo
Es la representaci´on gr´afica de un algoritmo. Lo conforma un conjunto
de componentes que permiten representar acciones, decisiones o c´alculos
con los cuales se soluciona un problema determinado. Cuando el diagrama
de flujo est´a correctamente dise˜nado, la concepci´on de un programa en un
lenguaje de programaci´on, en f´acilmente codificable.
Los gr´aficos que se usar´an en este texto, para representar los pasos o
instrucciones son los presentados en las Tablas 1.11 y 1.12.

-- 51 of 450 --

50 Fundamentos
S´ımbolo Nombre Explicaci´on
Terminal
Representa el inicio y el
final del algoritmo. Se
rotula con la palabra Inicio
o la palabra Final. En cada
algoritmo solo puede estar
presente un inicio y un
final.
Entrada Permite la interacci´on con
el entorno, a trav´es de este
s´ımbolo el algoritmo recibe
datos. Indica lectura de
datos.
Proceso Se usa para indicar la
ejecuci´on de una acci´on.
Salida
Permite la interacci´on con
el entorno, a trav´es de este
s´ımbolo
muestra resultados. Indica
escritura.
Decisi´on
Indica una toma de de-
cisiones. Se rotula con
una expresi´on relacional
o l´ogica, dependiendo de
su resultado se toma un
camino de ejecuci´on. Se
usa en decisiones, condi-
ciones de las instrucciones
Mientras-FinMientras
y Haga-MientrasQue.
Tabla 1.11: Elementos en un digrama de flujo - Parte 1

-- 52 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 51
S´ımbolo Nombre Explicaci´on
Decisi´on
m´ultiple
Permite decidir que paso
se ejecutar´an dentro de
un conjunto de acciones
predeterminadas.
Estructura
Para
Se usa para establecer
procesos repetitivos.
Procedimiento
Permite dividir
el algoritmo en m´odulos
independientes, que
realizan
una tarea indispensable en
el resultado del mismo
[Pimiento, 2009].
Conector
misma p´a
