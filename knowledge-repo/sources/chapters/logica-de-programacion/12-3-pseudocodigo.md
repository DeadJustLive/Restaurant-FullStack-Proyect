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
misma p´agina
Permite conectar dos
partes del diagrama en una
misma p´agina. Siempre se
utilizan en pares, uno de
salida y otro de entrada.
Conector otra
p´agina
Cuando el diagrama es
muy
extenso, permite conectar
dos partes del diagrama
en p´aginas diferentes. Igual
que el anterior, se utilizan
en pares.
L´ıneas de flujo
Indican el orden y la direc-
ci´on en que las instruc-
ciones se deben de ejecutar.
Tabla 1.12: Elementos en un digrama de flujo - Parte 2

-- 53 of 450 --

52 Fundamentos
Para el uso de estos s´ımbolos se deben tener presentes las siguientes
consideraciones:
Terminal
En un diagrama deben existir solamente dos de estos s´ımbolos, uno
rotulado con la palabra Inicio y otro con la palabra Final (Ver Figuras
1.3 y 1.4).
Inicio
Final
Figura 1.3: Terminal
Del que se rotula como Inicio solo puede salir una ´unica l´ınea de flujo.
El que est´a rotulado como Final, recibe una ´unica l´ınea de flujo.
Inicio
Final
Figura 1.4: Elementos Terminal
Buena pr´actica:
El gr´afico del Inicio debe quedar de primero en el
diagrama, y el del Final debe ser la ´ultima parte del
mismo.

-- 54 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 53
Entrada
A este s´ımbolo entra y sale una ´unica l´ınea de flujo (Ver Figura 1.5).
Se rotula con el identificador de la variable que recibir´a el valor que
proporcione el usuario del algoritmo. La variable debe ser uno de los datos
disponibles para la soluci´on del problema.
variable
Figura 1.5: Entrada
Proceso
A este s´ımbolo entra y sale una ´unica l´ınea de flujo (Ver Figura 1.6). Se
rotula con la instrucci´on que se vaya a ejecutar, puede ser, por ejemplo,
una instrucci´on de asignaci´on.
Instrucci´on
Figura 1.6: Proceso
Salida
A este s´ımbolo entra y sale una ´unica l´ınea de flujo (Ver Figura 1.7). Se
utiliza para mostrar resultados o mensajes. Dentro de ´el se puede escribir
el nombre de una variable o una constante (Figura 1.7(a)), una operaci´on
matem´atica (Figura 1.7(b)), un mensaje con alguna variable o constante
(Figura 1.7(c)) o combinar varios de estos elementos (salida Figura 1.7(d)).

-- 55 of 450 --

54 Fundamentos
variable o
constante
(a)
a + 2 * b
(b)
“Mensaje”, variable
o constante
(c)
...
(d)
Figura 1.7: Salida
Los mensajes deben escribirse dentro de comillas dobles (“”) y se
mostrar´an exactamente como fueron escritos. En el caso de la variable
o constante, que no lleva las comillas, se mostrar´a el valor que tenga
almacenado. En las operaciones matem´aticas, tampoco se usan las comillas
y se mostrar´a el resultado de la operaci´on.
Decisi´on o bifurcaci´on
A este rombo debe llegar una ´unica l´ınea de flujo y salir dos, una que
indica el camino verdadero y otra que indica el camino falso (Ver Figura
1.8).
Condici´on
Decisi´on simple
No
S´ı
Condici´on
Decisi´on compuesta
No	S´ı
Figura 1.8: Decisiones
El s´ımbolo se rotula con una condici´on que se representa mediante una
expresi´on relacional o l´ogica, dependiendo de su resultado se elige uno de
dos caminos. Las l´ıneas de flujo que salen de ´el, deben rotularse con la
palabra S´	ı para el camino a seguir cuando la condici´on es verdadera y con
la palabra No, para el caso contrario.
Una decisi´on tiene varias configuraciones: simple, compuesta y
anidada. Este s´ımbolo tambi´en es usado para establecer la condici´on en
los procesos repetitivos, los cuales se estudiar´an en detalle en el cap´ıtulos
posteriores.

-- 56 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 55
Decisi´on simple: cuando la condici´on arroja un resultado verdadero
se ejecutan una o m´as instrucciones que est´en asociadas al flujo
rotulado con la palabra Si (Instrucci´	on-V) . Si el resultado es
falso, no se lleva a cabo ninguna acci´on que dependa de la condici´on.
Ver Figura 1.9.
Condici´on
Instrucci´on-V
No
S´ı
Figura 1.9: Decisi´on simple
Decisi´on compuesta: si el resultado de la condici´on es verdadero
se ejecutan una o m´as instrucciones asociadas al flujo rotulado con la
palabra Si (Instrucci´	on-V), en caso contrario se deben ejecutar
una o m´as instrucciones asociadas al flujo rotulado con la palabra
No (Instrucci´	on-F). Ver Figura 1.10.
Condici´on
Instrucci´on-F	Instrucci´on-V
No	S´ı
Figura 1.10: Decisi´on compuesta

-- 57 of 450 --

56 Fundamentos
Decisi´on anidada: cuando se deben tomar otras decisiones,
dependiendo del resultado de una decisi´on anterior. Ver Figuras 1.11
y 1.12.
Decisi´on 1
Decisi´on 2
Instrucci´on-V
Decisi´on 3
Instrucci´on-V
Instrucci´on-V Instrucci´on-F
S´ı No
S´ı No
S´ı No
Figura 1.11: Decisi´on anidada - Ejemplo 1
Aclaraci´on:
Este tipo de decisi´on se puede presentar en
m´ultiples formas, todo depende del problema
que se est´a solucionando.

-- 58 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 57
Condici´on
1
Condici´on
3
Condici´on
2
Condici´on
4 b
Condici´on
5
d	c
a
S´ı 	No
S´ı No
No	S´ı
S´ı
S´ı
No
No
Figura 1.12: Decisi´on anidada - Ejemplo 2
Buena pr´actica:
De todo s´ımbolo de decisi´on debe salir una l´ınea de
flujo por la parte verdadera (Si) y otra por la parte
falsa (No)
Selector o decisi´on m´	ultiple
Dependiendo del valor de una variable o expresi´on que se usa para rotular
el s´ımbolo, se elige uno de varios caminos posibles y se ejecutan la o las
instrucciones correspondientes. [En otro caso] indica que si el valor de la

-- 59 of 450 --

58 Fundamentos
variable selector no es igual a ninguno de los valores relacionados (valor
1, valor 2,. . . , valor n) se ejecuta la instrucci´on por defecto. Ver
Figura 1.13.
selector
Instrucci´on 1 Instrucci´on
por defecto	Instrucci´on 2 Instrucci´on n
valor1 [en otro caso]
valor2 valor n
Figura 1.13: Decisi´on m´ultiple
Conector misma p´agina
Los s´ımbolos que reciben la l´ınea de flujo representan la salida y deben
emparejar con otro de los mismos s´ımbolos del que sale la l´ınea de flujo.
Se deben rotular con una letra o un n´umero, que se repetir´a tanto en el
conector de salida, como en el de entrada. Con el uso de los conectores se
evita el cruce de l´ıneas de flujo o dibujar l´ıneas de flujo demasiado largas.
En un diagrama pueden existir varios conectores de salida con el mismo
r´otulo, pero solamente debe haber uno de entrada.
En la Figura 1.14 se observa que se pueden usar de forma vertical o de
forma horizontal.
n
n
(a)
k
k
(b)
Figura 1.14: Conector misma p´agina

-- 60 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 59
Este s´ımbolo tambi´en se puede usar como punto de concentraci´on de
varias l´ıneas de flujo, en cuyo caso no se rotula y se usa uno solo. Pueden
llegar varios flujos de entrada, pero solamente habr´a un flujo de salida.
Conector otra p´agina
Tiene las mismas caracter´ısticas del conector anterior, la diferencia
radica en que este se usa para hacer conexiones de partes del diagrama
que est´an dibujadas en p´aginas diferentes. Ver Figura 1.15.
A
Conector 1
A
Conector 2
Figura 1.15: Conector otra p´agina
El uso detallado de estos y los dem´as s´ımbolos, se estudiar´a a lo largo
de los siguientes cap´ıtulos.
Ahora que ya conoce los s´ımbolos de un diagrama de flujo, recuerde que
un algoritmo consta de 3 etapas: Entrada, Proceso y Salida. Dentro de la
forma general de algoritmo expresado mediante un diagrama de flujo, estas
etapas se pueden representar como se aprecia en la Figura 1.16.
Inicio
Entrada
de datos
Proceso
Salida de resultado
Final
Figura 1.16: Diagrama de flujo (forma general)

-- 61 of 450 --

60 Fundamentos
Buenas pr´acticas:
Para la construcci´on de los diagramas de flujo, se
deben seguir algunas reglas o recomendaciones.
- El diagrama de flujo debe tener un nombre que
identifique su funci´on.
- Los diagramas de flujo no tienen declaraci´on de
variables, ellas simplemente se usan.
- Construya el diagrama de arriba hacia abajo y de izquierda a
derecha.
- Debe existir solamente un s´ımbolo de inicio y uno de final, ambos
debidamente rotulados.
- Dibuje ´unicamente l´ıneas de flujo en rectas horizontales o verticales.
No se deben usar l´ıneas inclinadas.
- Toda l´ınea de flujo debe estar conectada a uno de los s´ımbolos o
a otra l´ınea de flujo, no pueden haber l´ıneas sueltas, es decir, sin
conexi´on.
- Evite pasar una l´ınea sobre otra, en caso de que no sea posible,
debe usar un conector a la misma p´agina.
- Ning´un s´ımbolo puede recibir m´as de una l´ınea, exceptuando el
utilizado en la estructura repetitiva Para y el conector a la
misma p´	agina cuando se usa como punto de concentraci´on para
las l´ıneas de flujo. El funcionamiento de la estructura Para se
estudiar´a de forma detallada en el Cap´ıtulo 4.
Por ejemplo, un proceso que recibe dos l´ıneas de flujo es un error
(Figura (a)); la forma correcta de diagramar este caso, es uniendo
todos los flujos a una sola l´ınea y que esta sea la que conecte al
s´ımbolo, tal como se aprecia al lado derecho de la gr´afica (Figura
(b)).
Instrucci´on
(a)
Instrucci´on
(b)
- Use conectores solamente cuando sea necesario.
- En el caso que el diagrama sea muy extenso, use conectores, bien
sea dentro de la misma p´agina o a p´agina diferente. Se recomienda
que los conectores a la misma p´agina se identifiquen con n´umeros y
los conectores a p´agina diferente usen letras, o viceversa.
- A los s´ımbolos de decisi´on se le deben dibujar las dos l´ıneas de
salida, especificando cual es la verdadera y cual es la falsa.

-- 62 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 61
Pseudoc´odigo
La palabra Pseudoc´odigo, proviene de pseudo7 y c´odigo, que tomado
literalmente significa un falso c´odigo o dicho en otras palabras una especie
de c´odigo. Se le ha dado esta denominaci´on porque no es un lenguaje de
programaci´on, sino otra de las formas de expresar un algoritmo, usando
palabras similares a las propias de los lenguajes de programaci´on.
El pseudoc´odigo est´a compuesto por un conjunto de palabras en espa˜nol,
ingl´es o cualquier otro idioma8 (c´odigos) que representan una instrucci´on
que es entendida de una manera espec´ıfica por el algoritmo en la soluci´on
de un problema. Estos c´odigos son f´acilmente traducidos a un lenguaje
de programaci´on para que puedan ser interpretados y ejecutados por un
computador.
Las palabras o c´odigos que se utilizan en el pseudoc´odigo no tienen
un est´andar, por lo tanto, pueden variar de una fuente de informaci´on a
otra. Sin embargo, conservan mucha similitud a las caracter´ısticas de las
palabras reservadas y estructuras de los lenguajes de programaci´on.
Palabras reservadas
Los c´odigos o palabras reservadas cumplen tareas espec´ıficas dentro de
los algoritmos y no pueden usarse para prop´ositos diferentes. En este texto
se trabajar´an las siguientes:
Algoritmo – FinAlgoritmo. Indica el comienzo y final del
algoritmo, respectivamente. Cada algoritmo tendr´a solo un inicio y
un solo final.
Entero, Real, Cadena, Caracter, Logico. Se usan para
declarar el tipo de dato de las variables que se requieren en la soluci´on
del problema.
Constante. Este c´odigo se emplea en el momento de declarar
constantes.
Si, Entonces, SiNo, FinSi. Se usan para la toma de decisiones
simples y compuestas.
Segun, Caso, FinCaso, EnOtroCaso, FinSegun. Utilizadas
para la toma de decisiones m´ultiples.
7 Del gr. ψξνδo - pseudo: significa “falso”. http://dle.rae.es/?id=XkBx392
8Depende del idioma que se maneje en el pa´ıs donde se ense˜ne. Para el caso de este
texto, se usar´an palabras en espa˜nol.

-- 63 of 450 --

62 Fundamentos
Para, Hasta, Incremento, Decremento, FinPara. Especifican
una estructura repetitiva condicionada al comienzo.
Mientras, FinMientras. C´odigos para el manejo de una
estructura repetitiva condicionada al comienzo.
Haga, MientrasQue. Palabras usadas para dise˜nar una estructura
repetitiva condicionada al final.
Procedimiento, FinProcedimiento. Palabras reservadas
empleadas para dividir el algoritmo en m´odulos independientes,
que realizan una tarea indispensable en el resultado del mismo
[Pimiento, 2009]
Funcion, FinFuncion, Retornar. Permite hacer la divisi´on en
bloques funcionales independientes que retornan valores.
dimensionar. Se usa para declarar la dimensi´on en un vector o en
una matriz.
Aclaraci´on:
Los c´odigos o palabras reservadas cumplen tareas
espec´ıficas dentro de los algoritmos y no pueden
usarse para prop´ositos diferentes.
Tambi´en existen las denominadas funciones del lenguaje algor´ıtmico.
Estas son funciones que ya est´an predefinidas para realizar diversas tareas,
entre las m´as importantes se destacan las funciones matem´aticas que
permiten realizar diversos c´alculos y, las funciones para el manejo de
cadenas que se usan para el tratamiento de datos de tipo alfanum´erico.
Aclaraci´on:
Las funciones son tambi´en palabras reservadas y
no pueden ser utilizadas para declarar variables,
constantes, procedimientos, funciones de usuario e
incluso los algoritmos.

-- 64 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 63
Entre las funciones que ser´an trabajadas en los ejemplos y ejercicios de
los siguientes cap´ıtulos se encuentran:
Entero longitud( Cadena )
Real abs( Real o Entero )
Real cos( Real )
Real convertirANumero( Cadena )
Real raizCuadrada( Real o Entero )
Real ln( Real )
Real log( Real )
Real exp( Real )
Real sen( Real )
Real tan( Real )
Una de las palabras reservadas m´as utilizadas en los algoritmos en
pseudoc´odigo, es la instrucci´on imprimir, por ello, tenga en cuenta estas
consideraciones en su uso:
imprimir. Es una instrucci´on de salida, se usa para mostrar datos o
informaci´on. Su forma general es la siguiente:
imprimir (par´	ametro)
Donde par´	ametro puede tomar cualquiera de los siguientes formatos:
imprimir( variable ) o imprimir( CONSTANTE )
Muestra el valor almacenado en una variable o en una constante,
previamente definidas y a las cuales se les asign´o un valor.
imprimir( Operaci´	on )
Donde Operaci´	on es una expresi´on matem´atica, que puede estar
conformada por valores constantes o por variables, por ejemplo:
imprimir (5 * 2), muestra como resultado de salida un 10.
imprimir( "Mensaje" )
La salida que muestra, es el Mensaje que se escriba entre las comillas
dobles.
Los anteriores formatos pueden combinarse de diferentes formas:
• imprimir( "Mensaje", variable )
• imprimir( "Mensaje", variable, CONSTANTE )
• imprimir( "Mensaje", operaci´	on )
• imprimir( variable, "Mensaje", operaci´	on )
• Entre otros.

-- 65 of 450 --

64 Fundamentos
Comentarios
Es otro de los componentes de un algoritmo; se utilizan de manera
opcional para documentarlo. No hacen parte de su l´ogica, por lo cual no
afectar´a su ejecuci´on.
La documentaci´on es una buena pr´actica que permite que otra persona
o el mismo autor tenga claridad sobre algunos aspectos que se dise˜naron
dentro del algoritmo. Esto permite que a futuro los ajustes o modificaciones
a que haya lugar, sean mucho m´as sencillos o por lo menos m´as entendibles.
Los comentarios pueden ser de dos formas.