# OBSERVACI´ON:

* utiliza una repetici´on indexada sobre direcciones
-}
{
-- OBSERVAR que son direcciones!
foreach dir in [Norte..Oeste]
{ DibujarLineaNegra2Hacia(dir) }
}
Observar que la repetici ´on utiliza las direcciones como ´ındice, y que por el orden
de las mismas, utiliza las 4 direcciones. El significado de esta repetici ´on indexada
es exactamente el mismo que si hubi ´eramos escrito
DibujarLineaNegra2Hacia(Norte)
DibujarLineaNegra2Hacia(Este)
DibujarLineaNegra2Hacia(Sur)
DibujarLineaNegra2Hacia(Oeste)
puesto que el rango [Norte..Oeste] es la secuencia Norte Sur Este Oeste.
Con la repetici ´on indexada puede realizarse un procedimiento para dibujar
cuadrados de cualquier longitud. Esta ser ´a la forma final que daremos a este
procedimiento, generalizando todo lo que es posible generalizar (el tama ˜no, el
color y la direcci ´on en las l´ıneas), y utilizando los recursos adecuados para no
repetir c ´odigo innecesariamente.
Actividad de Programaci ´on 9
Realizar el ejercicio 3.1.7 y utilizar el procedimiento definido para dibujar
varios cuadrados de distintos tama ˜nos y colores.
Ejercicio 3.1.7. Escribir un procedimiento DibujarCuadrado que dibuje cuadra-
dos de color color y de n celdas de lado. Confirmar que el lado del cuadrado
tenga exactamente n celdas, y no m ´as o menos (tener en cuenta que las l´ıneas
tienen ancho 1, y el ancho de la l´ınea que se superpone tambi ´en cuenta para el
total). Utilizar la menor cantidad de procedimientos posible.
3.1.3. Ejercitaci ´on
En esta subsecci ´on revisamos algunos de los ejercicios de pr ´actica del cap´ıtulo
anterior, con el fin de incorporar las nociones de par ´ametros y repetici ´on.
Actividad de Programaci ´on 10
Realice los ejercicios enunciados en esta subsecci ´on. Recuerde utilizar
todas las buenas pr ´acticas que venimos estudiando (adecuada sepa-
raci ´on en subtareas, elecci ´on de buenos nombres de procedimientos y
par ´ametros, indentaci ´on de c ´odigo, reutilizaci ´on de c ´odigo ya realizado,
etc ´etera).
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 105 of 312 --

106
Ejercicio 3.1.8. Rehacer el ejercicio 2.4.1 usando repetici ´on. Rehacer el ejer-
cicio 2.4.2 usando repetici ´on. Generalizarlos a un procedimiento PonerNDeCada
Recuerde que generalizar un
procedimiento es cambiar alg ´un
dato fijo del mismo por un
par ´ametro, de forma tal que con
un c ´odigo casi id ´entico al ante-
rior, ahora se expresan muchos
m ´as procedimientos.
que tome la cantidad como par ´ametro.
¿Reutiliz ´o el procedimiento PonerUnaDeCadaColor al escribir los dem ´as? Si no lo
hizo, ¡vuelva a revisar el ejercicio y h ´agalo!
Para Reflexionar
¿Puede observar c ´omo el uso de repetici ´on y par ´ametros simplifica el
c ´odigo producido, al tiempo que lo hace m ´as generalizable? Reflexione
sobre la importancia de contar con adecuadas herramientas abstractas
de programaci ´on, tales como los procedimientos, los par ´ametros y las
estructuras de control como la repetici ´on.
Ejercicio 3.1.9. Rehacer el ejercicio 2.4.4, pero generalizando el color y la direc-
ci ´on. Usar el resultado para rehacer el ejercicio 2.4.5 generalizando el color, y
usando una repetici ´on sobre direcciones.
Ejercicio 3.1.10. Rehacer los procedimientos del ejercicio 2.4.9 generalizando el
color con el cual se dibuja la letra E. Rehacer el ejercicio 2.4.10 para que reutilice
el procedimiento anterior y una repetici ´on sobre colores.
Como habr ´a podido comprobar mediante estos ejercicios, la combinaci ´on de re-
petici ´on y par ´ametros es extremadamente poderosa. Adem ´as, ambos juegan un
rol fundamental al permitir la generalizaci ´on de muchas de las nociones que se
utilizan al escribir procedimientos. Sin embargo, ´estas no son las ´unicas herra-
mientas que brindan expresividad y poder a la programaci ´on. En la secci ´on que
sigue veremos otro conjunto de herramientas poderosas.
3.2. Expresiones y funciones
En esta secci ´on veremos c ´omo definir en GOBSTONES expresiones complejas,
resultantes de combinar otras expresiones. Es algo similiar a lo hecho con co-
mandos a trav ´es de procedimientos definidos por el usuario, es decir, agrupare-
mos y nombraremos expresiones, solo que con una nueva herramienta conocida
como funciones.
3.2.1. Expresiones compuestas y tipos
Las expresiones compuestas son algo familiar cuando hablamos de n ´umeros.
As´ı, sabemos que 2+3 est ´a formado por tres partes: dos descripciones de n ´ume-
ros y un s´ımbolo que denota la operaci ´on de sumar ambos n ´umeros. En cual-
quier lenguaje de programaci ´on habr ´a diversas formas de armar expresiones
compuestas que vendr ´an dadas por reglas de formaci ´on.
Para poder introducir las reglas de formaci ´on de expresiones compuestas en
GOBSTONES vamos a comenzar por profundizar en la idea de tipo presentada en
la subsecci ´on 2.1.4. En su forma m ´as simple, un tipo puede entenderse como
la descripci ´on de un conjunto de valores espec´ıficos, con propiedades comunes.
En GOBSTONES existen cuatro tipos elementales: los colores, las direcciones, los
booleanos y los n ´umeros.
Se definir ´an en esta unidad. La noci ´on de tipo es utilizada, entre otras cosas, para identificar usos err ´oneos
de un valor, o sea, cu ´ales combinaciones de expresiones est ´an permitidas al ar-
mar una expresi ´on compuesta, o qu ´e comandos pueden armarse con seguridad
para describir acciones. Por ejemplo, la operaci ´on Poner espera que su argu-
mento sea un color. Si Poner recibe un valor de otro tipo, provocar ´a la autodes-
trucci ´on del cabezal. La operaci ´on Poner no se considera v ´alida a menos que su
argumento sea un valor de tipo color.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 106 of 312 --

107
Definici ´on 3.2.1. Un tipo es la descripci ´on de un conjunto de valores con ciertas
propiedades comunes. Se utilizan, entre otras cosas, para distinguir entre usos
permitidos y err ´oneos de una expresi ´on.
Actividad de Programaci ´on 11
Realice el ejercicio 3.2.1. Si puede, pru ´ebelo en diferentes herramientas
que implementen GOBSTONES.
Ejercicio 3.2.1. Escribir un programa que incluya el comando Poner(17) y com-
probar el error obtenido.
Al presentar la operaci ´on Poner se establec ´o que es una operaci ´on total, y ahora
resulta que existen formas inv ´alidas de la misma. ¿C ´omo debe entenderse este
hecho? Lo que sucede es que los errores producidos por utilizar valores de tipo
distinto al esperado (llamados errores de tipo) pueden ser controlados antes de
la ejecuci ´on del programa. De este control se suele decir que “impone el uso de
tipos”, pues en el caso de que un programa contenga combinaciones err ´oneas
de tipos en las expresiones es rechazado sin ejecutarlo. Entonces Poner(17) no
deber´ıa ser ejecutado; puesto que esto puede ser detectado autom ´aticamente
por un chequeo basado en sistemas de tipos, se elige no incluir errores de tipo
en la noci ´on de error de ejecuci ´on, y consecuentemente, se elige no incluir este
caso en la precondici ´on.
Leer con Atenci ´on
En GOBSTONES se permite invocar definiciones que esperan expresio-
nes de un determinado tipo con expresiones de cualquier otro tipo, inclu-
so cuando su uso es incorrecto. No obstante, si esto sucede el programa
fallar ´a al ser ejecutado. Sin embargo, al igual que otros lenguajes m ´as
avanzados, GOBSTONES permite la verificaci ´on de ciertas restricciones
para los tipos de datos, chequeando de alguna forma en qu ´e casos su
uso es correcto. Sin embargo, esta caracter´ıstica es opcional, y puede
no estar disponible en todas las versiones de la herramienta.
Por ejemplo, se dir ´a globalmente que Poner espera un argumento de tipo color
para indicar que su uso no es v ´alido si recibe un valor de otro tipo.
Para Ampliar
En la herramienta PYGOBSTONES existe una opci ´on en la que se verifica,
sin correr el programa, que nuestro c ´odigo no contiene errores de tipos,
y de esa manera asegurar el programa no tendr ´a errores de este estilo.
Puede resultar interesante probarla y explorar las ventajas de utilizarla.
La idea de tipos tambi ´en se aplica a las expresiones. Por ejemplo, la suma solo
es posible realizarla entre n ´umeros. ¿Qu ´e sucede si se intenta armar una suma
utilizando un color? Consideremos, por ejemplo, la expresi ´on Verde+1. La misma
no describe a ning ´un valor. Si se intenta determinar qu ´e valor representa esta
expresi ´on, tambi ´en se obtendr ´a un error de tipo.
Ejercicio 3.2.2. Escribir un programa que incluya la expresi ´on Verde+1 y com-
probar el error obtenido.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 107 of 312 --

108
Leer con Atenci ´on
La suma es tambi ´en una forma de operaci ´on que requiere que sus dos
sumandos sean descripciones de n ´umeros, y solo en ese caso describe
a un n ´umero y se considera v ´alida. Esto describe as´ı que la suma espe-
ra dos argumentos de tipo num ´erico para producir un n ´umero. Al igual
que como con Poner, la suma se considera una operaci ´on total. De esta
manera, diremos que la suma es una operaci ´on total sobre n ´umeros.
Para Reflexionar
¿Recuerda la expresi ´on Rojo+Norte que mencionamos al hablar de ti-
pos en el cap´ıtulo anterior? Puesto que la suma es una operaci ´on sobre
n ´umeros, esta expresi ´on, de ser ejecutada, producir ´a un error. ¿Qu ´e le
parece la idea de contar con una herramienta que verifique que esta
forma de errores no suceda en el programa?
La idea de tipos se aplica tambi ´en a los par ´ametros de un procedimiento. Por
ejemplo, en el procedimiento DibujarLinea2Hacia, el par ´ametro dir es utilizado
como argumento del comando Mover, y por lo tanto se espera que sea una di-
recci ´on. Si se invocase al procedimiento con un valor diferente de una direcci ´on,
dicho programa ser´ıa err ´oneo. Para indicar esto, se dir ´a que dir es de tipo direc-
ci ´on, y que Mover solamente espera valores de tipo direcci ´on. De esta manera, la
invocaci ´on DibujarLinea2Hacia(Rojo) es f ´acilmente identificable como un error,
pues Rojo no es de tipo direcci ´on, sino de tipo color.
Leer con Atenci ´on
En el caso de m ´as de un par ´ametro en el mismo procedimien-
to, cada uno tendr ´a un tipo espec´ıfico, y al invocar dicho pro-
cedimiento, deber ´an suministrarse argumentos de los tipos correc-
tos, en el orden establecido. Por ejemplo, en el procedimiento
DibujarLinea2Hacia, el primer par ´ametro, colorDeLinea, es de ti-
po color, y el segundo par ´ametro, dirDeLinea, es de tipo direc-
ci ´on. Entonces, DibujarLinea2Hacia(Verde, Norte) es una invo-
caci ´on correcta del procedimiento, mientras que las inovacaciones
DibujarLineaDeHacia(Norte, Verde) y DibujarLineaHacia(Verde)
no lo son.
La correspondencia entre el tipo de un par ´ametro y el de un argumento es b ´asica,
y solo se la consignar ´a en el contrato del procedimiento en cuesti ´on establecien-
do el tipo que se espera que tenga cada par ´ametro.
A trav ´es del uso de tipos se pueden visualizar r ´apidamente los usos correc-
tos o err ´oneos de los diferentes elementos de un lenguaje de programaci ´on, y
muchos lenguajes hacen uso de esta caracter´ıstica. En este libro usaremos la
terminolog´ıa de tipos para guiar la comprensi ´on sobre las operaciones que ire-
mos introduciendo.
3.2.2. Operaciones predefinidas para construir expresiones
Las expresiones compuestas se obtienen a trav ´es de un conjunto de expresio-
nes predefinidas, combin ´andolas de maneras adecuadas. Las formas adecuadas
quedan determinadas por el tipo de los argumentos y resultados, As´ı, para co-
nocer el conjunto de operaciones predefinidas se puede seguir una clasificaci ´on
de acuerdo con estos tipos. Para conocer un lenguaje de manera completa es
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 108 of 312 --

109
G.3.8. Descripci ´on gr ´afica del resultado de las operaciones div y mod para n ´ume-
ros n y m.
importante conocer cu ´ales son las operaciones predefinidas de cada tipo. A con-
tinuaci ´on presentamos todas las operaciones predefinidas para cada uno de los
cuatro tipos b ´asicos de GOBSTONES, y damos ejemplos de su utilizaci ´on.
Operaciones sobre n ´umeros
El tipo de los n ´umeros trae las operaciones aritm ´eticas usuales:
la suma, +
la resta, -
la multiplicaci ´on, *
la divisi ´on entera, div
el resto de la divisi ´on entera, mod
la exponenciaci ´on, ^
Todas estas operaciones se usan infijas. En el caso de la divisi ´on entera y el
resto, el comportamiento esperado es que si n div m = q y n mod m = r, entonces
m = q*n + r, y r es positivo y menor estricto que n (en otras palabras, q es el
resultado entero de dividir n por m, y r es el resto de esa divisi ´on, como se muestra
en el gr ´afico G.3.8). Estas dos operaciones son ´utiles para dividir cuando no se
tienen n ´umeros decimales. Con ellas se pueden definir una cantidad importante
de aplicaciones interesantes.
Actividad 12
Realice los siguientes ejercicios. En ellos se busca ejercitar el uso de
expresiones num ´ericas.
¡Atenci ´on! No se pide el resulta-
do de esta operaci ´on, sino una
expresi ´on que la represente. O
sea, no es una respuesta correc-
ta al ejercicio el n ´umero 42, si
bien ese es el resultado de la
expresi ´on a escribir cuando se
eval ´ue.
Ejercicio 3.2.3. Escribir una expresi ´on sobre n ´umeros que represente la suma
de cuatro veces diez, m ´as dos. Escribir una expresi ´on sobre n ´umeros que re-
presente la suma de cuatro veces el n ´umero resultante de sumar diez m ´as dos.
¿Qu ´e diferencias se pueden observar en las expresiones? ¿Y en los resultados?
Ejercicio 3.2.4. Escribir un procedimiento RespuestaVerde que ponga tantas
bolitas verdes como la suma de cuatro veces diez, m ´as dos, pero sin hacer la
cuenta a mano.
Ayuda: reutilizar el procedimiento PonerN del ejercicio 3.1.3, parte 1 y alguna de
las expresiones del ejercicio anterior.
Ejercicio 3.2.5. Escribir un procedimiento PonerDobleRojas que ponga el doble
de bolitas rojas de lo que dice el par ´ametro.
Ayuda: reutilizar el procedimiento PonerN del ejercicio 3.1.3, parte 1, y combinar-
lo con alguna expresi ´on adecuada que involucre al par ´ametro.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 109 of 312 --

110
G.3.9. Resultado de ejecutar MostrarNumero(34)
Ejercicio 3.2.6. Escribir un procedimiento MostrarNumero que toma un par ´ame-
tro de tipo n ´umero, y asumiendo que el mismo es menor que 100, lo muestra
en el tablero en dos celdas contiguas utilizando bolitas negras. Para mostrar el
n ´umero, la celda de la derecha debe contener tantas bolitas negras como unida-
des est ´en representadas por el n ´umero, y la de la izquierda debe contener tantas
bolitas negras como decenas est ´en representadas por el n ´umero. Por ejemplo, en
el gr ´afico G.3.9 puede observarse el resultado de ejecutar MostrarNumero(34).
Ayuda: para obtener el n ´umero de unidades de un n ´umero se puede utilizar la
operaci ´on de mod con uno de sus argumentos siendo el 10; para obtener el n ´ume-
ro de decenas de un n ´umero menor a 100 se puede utilizar la operaci ´on div con
uno de sus argumentos siendo 10.
Operaciones sobre colores
Las ´unicas operaciones especiales de los colores son el c ´alculo de los valores
m´ınimo y m ´aximo.
el color m´ınimo en el orden, minColor
el color m ´aximo en el orden, maxColor
El valor de minColor() es Azul, y el de maxColor() es Verde.
Operaciones sobre direcciones
El tipo de las direcciones tiene las operaciones de m´ınima y m ´axima direcci ´on:
la direcci ´on m´ınima en el orden, minDir
la direcci ´on m ´axima en el orden, maxDir
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 110 of 312 --

111
El valor de minDir() es Norte, y el de maxDir() es Oeste.
Para Reflexionar
Estas operaciones por s´ı mismas no parecen muy ´utiles. La utilidad de
estas operaciones se observa al utilizarlas en conjunci ´on con coman-
dos avanzados, como la repetici ´on indexada. Reflexionar sobre el hecho
de que ciertos elementos que por s´ı solos resultan poco interesantes,
cobran sentido al combinarse con otros de formas no triviales. ¿Puede
imaginarse c ´omo construir una repetici ´on indexada que incluya a todos
los colores en el rango que la define?
Las operaciones de m´ınimo y m ´aximo sobre un tipo dado permiten armar repeti-
ciones indexadas que recorren todos los valores del tipo, sin tener que recordar
el orden particular. Por otra parte, dichos programas expresan con mayor ade-
cuaci ´on el hecho de que se pretende recorrer todos los valores del tipo y no solo
los que posea la versi ´on actual del lenguaje. Y siempre es una buena idea que
los programas expresen con mayor precisi ´on el prop ´osito del programador.
Actividad de Programaci ´on 13
Realice el ejercicio 3.2.7, y vuelva a considerar la utilidad de las opera-
ciones de m´ınimo y m ´aximo.
Ejercicio 3.2.7. Realizar nuevamente el ejercicio 2.4.1, reescribiendo el proce-
dimiento PonerUnaDeCadaColor, que pone una bolita de cada color en la celda
actual, pero con las siguientes restricciones:
solo se puede utilizar un ´unico Poner en el cuerpo del procedimiento;
no puede nombrarse expl´ıcitamente ning ´un color (o sea, no puede utilizar
ninguna de las siguientes expresiones: Azul, Negro, Rojo ni Verde.)
Ayuda: piense en utilizar una repetici ´on indexada con expresiones adecuadas
en su rango.
Booleanos y operaciones sobre ellos
El cuarto de los tipos, los booleanos, es un tipo especial, que merece ser consi-
derado detenidamente. Sus valores son usados impl´ıcitamente por todos desde
chicos, y son los que expresan la idea de verdad. Cualquier persona distingue
algo verdadero de algo falso. Entonces, as´ı como podemos distinguir una bolita
de color rojo e indicarlo mediante el valor Rojo, o una de color azul e indicar-
lo mediante el color Azul, podremos expresar la capacidad de distinguir entre
verdadero y falso a trav ´es de dos valores: True y False. El valor True describe
la idea de verdadero, mientras que el valor False describe la idea de falso. A
estos dos valores se los conoce como valores de verdad, valores booleanos o
simplemente booleanos.
George Boole fue un matem ´ati-
co y fil ´osofo ingl ´es del siglo
XIX que fund ´o las bases de la
aritm ´etica de computadoras, y
que es considerado uno de los
padres de la computaci ´on mo-
derna. La estructura estudiada
por este matem ´atico, y que se
compone fundamentalmente de
los valores de verdad se conoce
como ´Algebra de Boole.
El tipo de los booleanos trae las operaciones conocidas de l ´ogica, a las cuales
denominamos conectivos l ´ogicos (que se explican m ´as adelante en esta misma
unidad), y las operaciones de m´ınimo y m ´aximo booleano:
la negaci ´on, not
la conjunci ´on, &&
la disyunci ´on, ||
el booleano m´ınimo en el orden, minBool
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 111 of 312 --

112
el booleano m ´aximo en el orden, maxBool
La negaci ´on se usa de manera prefija (o sea, la operaci ´on se escribe antes del
operando), y las conjunci ´on y la disyunci ´on, infijas (o sea, la operaci ´on se escribe
entre medio de los operandos). Es decir, la forma de la operaci ´on not es not
< condicion >, y la forma de la operaci ´on && es < cond1 > && < cond2 >. El valor
de minBool() es False, y el de maxBool() es True.
El uso de expresiones booleanas y el significado de los conectivos l ´ogicos se
explica y ejercita en la secci ´on 3.2.3, al trabajar con alternativas.
Operaciones que combinan varios tipos
Hay operaciones que trabajan sobre todos los tipos b ´asicos. Las m ´as comunes
de estas son las operaciones relacionales, que permiten realizar comparaciones
entre dos elementos del mismo tipo (o sea, son operaciones que si reciben ar-
gumentos de distinto tipo resultan inv ´alidas), y cuyo resultado es un booleano.
Adem ´as hay operaciones que permiten moverse dentro del orden establecido de
cada tipo. Estas operaciones son:
las comparaciones por igualdad:
• es igual a, ==
• es diferente de, /=
las comparaciones de orden:
• es menor que, <
• es menor o igual que, <=
• es mayor que, >
• es mayor o igual que, >=
la operaciones de movimiento en el orden:
• c ´alculo del siguiente, siguiente.
• c ´alculo del previo, previo.
operaciones especiales solo para algunos tipos:
• c ´alculo del opuesto, opuesto ´o - (unario)
Todas, salvo siguiente, previo y opuesto, se usan de manera infija. Las ope-
raciones de orden siguen una secuencia establecida para cada tipo. El orden de
los n ´umeros es el tradicional, midiendo la cantidad que representa. El orden de
las direcciones es en el sentido de las agujas del reloj, comenzando por el Norte,
el orden de los colores es alfab ´etico, y el de los booleanos es primero falso y
luego verdadero. La operaci ´on siguiente(< expresion >) devuelve el elemen-
to siguiente en el orden de los elementos del tipo del valor de < expresion >,
volviendo al m´ınimo en caso de que el elemento sea el m ´aximo. Por ejemplo,
siguiente(2) es 3, siguiente(Norte) es Este, y siguiente(Oeste) es Norte.
La operaci ´on previo(< expresion >) es la operaci ´on inversa, devolviendo el valor
anterior en el orden, y volviendo al m ´aximo en caso de que se trate del m´ınimo.
Entonces, previo(3) es 2, previo(Oeste) es Sur, y previo(Norte) es Oeste.
La operaci ´on opuesto funciona sobre direcciones o n ´umeros. Se utiliza como
opuesto(< expresion >) o -< expresion >. En el caso de las direcciones trans-
forma Norte en Sur, Este en Oeste, y viceversa. Por ejemplo, el valor de la ex-
presi ´on opuesto(Sur) es Norte y el valor de -Este es Oeste. En el caso de los
n ´umeros, si la expresi ´on vale n, calcula el valor de −n.
Ejemplos de uso de estas expresiones son la comparaci ´on de que un cierto
valor num ´erico pasado como par ´ametro es menor que un n ´umero fijo (e.g. num
< 9), que dos colores pasados como par ´ametros son iguales (e.g. color1 ==
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 112 of 312 --

113
G.3.10. Resultado de ejecutar ArribaAbajo(Norte)
color2) y que la direcci ´on siguiente de una direcci ´on pasada como par ´ametro no
es la ´ultima posible (e.g. siguiente(dir) /= maxDir()).
Actividad 14
Realice los ejercicios que se enuncian a continuaci ´on. Los mismos ejem-
plifican el uso de operaciones que combinan varios tipos.
Ejercicio 3.2.8. Escribir una expresi ´on que determine si dos par ´ametros de ti-
po direcci ´on, llamados por ejemplo direccionOriginal y direccionNueva, son
diferentes.
Ejercicio 3.2.9. Escribir una expresi ´on que determine si un n ´umero est ´a entre 0
y 100. Para ello, combinar dos expresiones relacionales mediante una conjunci ´on
booleana.
Ejercicio 3.2.10. Escribir un procedimiento ArribaAbajo que tome un par ´ame-
tro de tipo Direcci ´on, y ponga una bolita roja en la celda contigua a la inicial en
la direcci ´on indicada, y una bolita verde en la celda contigua a la inicial, pero en
la direcci ´on opuesta a la indicada. Por ejemplo, el resultado de llamar al procedi-
miento ArribaAbajo(Norte) deber´ıa ser como el mostrado en el gr ´afico G.3.10.
Observar que la celda actual al terminar debe ser la misma que la celda inicial.
Ayuda: ¿C ´omo expresar el opuesto de una direcci ´on dada por un par ´ametro?
Pensar en las operaciones reci ´en presentadas.
Sugerencia: Definir un procedimiento auxiliar con la parametrizaci ´on adecuada
para poner una bolita de alg ´un color en alguna celda contigua. Este procedimien-
to deber´ıa invocarse dos veces con diferentes argumentos.
Operaciones sobre el tablero
Finalmente, as´ı como el cabezal posee un dispositivo para poner y sacar bolitas,
y para moverse, posee tambi ´en sensores que le permiten saber si hay o no bolitas
de cierto color en la celda actual, cu ´antas hay, y si puede o no moverse de manera
segura sin caerse del borde del tablero. Todas estas formas se expresan a trav ´es
de expresiones. Las expresiones que tienen que ver con la operatoria del cabezal,
y sirven para determinar ciertos valores asociados a la celda actual son:
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 113 of 312 --

114
hayBolitas(< color >) que dado un color, representa a un booleano que
indica si en la celda actual hay o no bolitas de ese color;
puedeMover(< direccion >) que dada una direcci ´on, representa a un boo-
leano que indica si el cabezal se puede mover en la direcci ´on indicada sin
provocar su autodestrucci ´on;
nroBolitas(< color >) que dado un color, representa al n ´umero de bolitas
de ese color que hay en la celda actual.
Por ejemplo, hayBolitas(Rojo) puede ser True o False, dependiendo del es-
tado de la celda actual: si en la celda hay alguna bolita de color Rojo, enton-
ces esta expresi ´on valdr ´a True; si por el contrario, no hay ninguna, esta expre-
si ´on valdr ´a False. Si hayBolitas(Rojo) vale False, entonces nroBolitas(Rojo)
valdr ´a 0, y si nroBolitas(Rojo) es distinto de 0, entonces hayBolitas(Rojo)
valdr ´a True. De manera similar a hayBolitas, puedeMover(Sur) valdr ´a True si el
cabezal no se encuentra en la fila de m ´as abajo, y False si se encuentra en dicha
fila, y de manera an ´aloga para las restantes direcciones. Ejercitaremos el uso de
estas expresiones luego de ver una herramienta nueva para armar comandos
complejos.
Esto completa el repertorio de expresiones de GOBSTONES, con las cuales
se pueden realizar una serie importante de programas.
Actividad 15
Realice el ejercicio 3.2.11. (Todav´ıa no tenemos suficientes herramientas
para poder aprovechar este ejercicio. Su utilidad se ver ´a en el siguiente
apartado.)
Ejercicio 3.2.11. Utilizando algunas de las expresiones reci ´en presentadas, es-
cribir una expresi ´on que determine si la cantidad de bolitas en la celda actual es
menor o igual que un n ´umero determinado (e.g. 9). Recordar que una expresi ´on
para comparar por menor o igual se escribe, por ejemplo, 16 <= 20, y que hay
una expresi ´on para comprobar el n ´umero de bolitas de una celda.
Actividad de Programaci ´on 16
Realice los ejercicios 3.2.12 y 3.2.13 y util´ıcelos para quitar todas las
bolitas rojas y negras de la celda actual, y la totalidad de las bolitas de
la celda lindante al Norte.
Ejercicio 3.2.12. Escribir un procedimiento SacarTodasLasDeColor que, dado
un par ´ametro color, elimina todas las bolitas del color indicado de la celda ac-
tual. Para realizarlo, considere utilizar el procedimiento SacarN del ejercicio 3.1.3,