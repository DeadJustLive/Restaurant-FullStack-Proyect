# parte 3: , y combinarlo con alguna de las expresiones reci ´en presentadas.

Ejercicio 3.2.13. Escribir un procedimiento VaciarCelda que elimine todas las
bolitas de la celda actual. Para realizarlo, considere utilizar el procedimiento an-
terior, y una repetici ´on indexada que recorra todos los colores.
Leer con Atenci ´on
Los procedimientos SacarTodasLasDeColor y VaciarCelda son excelen-
tes candidatos para ser colocados en la Biblioteca.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 114 of 312 --

115
Actividad de Programaci ´on 17
Realice los ejercicios 3.2.14 y 3.2.15 y col ´oquelos en su Biblioteca.
Ejercicio 3.2.14. Definir una funci ´on esCeldaVacia que retorne un booleano in-
dicando si la celda actual no contiene bolitas de ning ´un color.
Ayuda: considere utilizar la combinaci ´on de 4 expresiones b ´asicas sobre el
tablero con las operaciones booleanas adecuadas.
Ejercicio 3.2.15. Definir una funci ´on esCeldaVaciaAl que dada una direcci ´on,
retorne un booleano indicando si la celda en esa direcci ´on no contiene bolitas
de ning ´un color. La precondici ´on de esta funci ´on es que existe una celda en la
direcci ´on dada.
Sugerencia: reutilice adecuadamente la funci ´on del ejercicio anterior.
3.2.3. Alternativas condicionales
Los booleanos pueden utilizarse para distinguir entre diferentes alternativas al
momento de describir comandos para el cabezal. Para ello es necesario un co-
mando que, con base en un booleano, decida entre otros dos comandos para
saber cu ´al de ellos debe ejecutarse. Imaginemos que representamos una flor
mediante una bolita roja, y fertilizante mediante una bolita negra, y que, si en
la celda actual ya hay una flor, entonces le coloquemos fertilizante, y si no hay,
entonces plantemos una nueva flor. Ninguna de las herramientas vistas hasta
el momento permite describir esta situaci ´on. Entonces presentamos un nuevo
comando, llamado if-then-else:
if (hayBolitas(Rojo)) -- Verdadero si hay flor en la celda actual
{ Poner(Negro) } -- Solo agrega fertilizante
else
{ Poner(Rojo) } -- Pone una flor, pues no hay ninguna
Para Reflexionar
¿Puede mejorar el programa anterior a trav ´es del uso de procedimientos
simples que representen mejor el dominio del problema? (Por ejemplo,
con el procedimiento PonerFlor(), etc.? ¿Qu ´e suceder ´a con la condi-
ci ´on? ¡No podemos utilizar un procedimiento all´ı para darle sentido a la
misma! Es claro que hace falta una forma nueva de nombrar expresio-
nes, la cual se ver ´a en el pr ´oximo apartado.
En ingl ´es, if-then-else significa si-entonces-sino, y es la idea de estructura
alternativa con base en una condici ´on. Por ejemplo, en este caso, el comando se
leer´ıa “si hay una bolita roja (flor) en la celda actual, entonces poner una bolita
negra (fertilizante), y si no hay flores, poner una bolita roja (nueva flor)”.
La forma general del comando if-then-else est ´a dada por la siguiente defi-
nici ´on:
Definici ´on 3.2.2. El comando de alternativa condicional (o simplemente condi-
cional) if-then-else tiene la siguiente forma:
if (< bool >)
< unBloque >
else
< otroBloque >
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 115 of 312 --

116
siendo < bool > una expresi ´on que describe un valor de verdad (booleano), y
donde los bloques < unBloque > y < otroBloque > son bloques de c ´odigo cua-
lesquiera (que normalmente son diferentes, aunque podr´ıan ser iguales). Al blo-
que < unBloque > se lo denomina rama verdadera (o rama del then) y al bloque
< otroBloque > se lo denomina rama falsa (o rama del else).
El comando if-then-else describe la decisi ´on de realizar la acci ´on descrita por
el bloque < unBloque >, en caso que la condici ´on sea True, o de realizar la acci ´on
descrita por < otroBloque > en caso que la condici ´on sea False. Observar que
los par ´entesis son necesarios siempre alrededor de la condici ´on.
Actividad de Programaci ´on 18
Realice el ejercicio 3.2.16. Considere la cantidad de trabajo necesario, y
reflexione sobre la importancia de reutilizar c ´odigo definido con anterio-
ridad (seg ´un se sugiere en dicho ejercicio).
Ejercicio 3.2.16. Supongamos que una celda representa un d´ıgito de un indica-
Un d´ıgito es un n ´umero entre 0 y
9.
dor de kilometraje, para lo cual utiliza bolitas negras. Escribir un procedimiento
IncrementarDigCuentaKm(), que incremente en uno el kilometraje indicado por
ese d´ıgito (y solo ese). Tener en cuenta que el indicador, al llegar al l´ımite de
9 debe volver a 0, pues es un d´ıgito. Considerar el uso de una alternativa pa-
ra detectar las dos situaciones posibles (¿cu ´ales son?), y la reutilizaci ´on de la
condici ´on del ejercicio 3.2.11 y del procedimiento del ejercicio 3.2.12.
Una variante ´util del comando if-then-else es cuando no existe una acci ´on
alternativa para la rama del else. En ese caso, la alternativa se transforma real-
mente en un comando condicional (o sea, un comando que solo se ejecuta si se
cumple cierta condici ´on). Esto es extremadamente ´util para evitar que una opera-
ci ´on parcial provoque la autodestrucci ´on del cabezal. Para ello, basta con utilizar
como condici ´on del if-then-else una expresi ´on < condicion > que valga True
cuando la precondici ´on de la operaci ´on dada en la rama del then sea v ´alida. Por
ejemplo, si se quiere sacar una bolita, puede preguntarse primero si la misma
existe, de la siguiente manera:
if (hayBolitas(Rojo)) { Sacar(Rojo) }
Notar que la precondici ´on de Sacar(Rojo) es que haya bolitas rojas, y la condi-
ci ´on del if-then es una expresi ´on que vale True siempre que haya bolitas rojas;
o sea, la condici ´on del if-then garantiza la precondici ´on de la rama del then.
De esta manera, la operaci ´on dada por la alternativa condicional es total incluso
aunque el cuerpo de la misma es parcial, pues el comando Sacar solamente se
invocar ´a cuando haya una bolita roja en la celda actual; en caso de que no haya
ninguna bolita roja, este comando compuesto no tendr ´a ning ´un efecto.
Ejercicio 3.2.17. Escribir un procedimiento QuitarHastaTresFlores que, supo-
niendo que en la celda actual hay entre cero y tres flores representadas cada
una por una bolita roja (pero no se sabe cu ´antas exactamente), las elimine de
la celda. El procedimiento debe describir una operaci ´on total. Utilizar nombres
adecuados para la subtarea de quitar una flor (pero no puede hacerse a ´un con la
condici ´on).
Ayuda: utilizar la variante de alternativa dada por el comando if-then.
Volveremos sobre la alternativa condicional para profundizarla en la secci ´on si-
guiente y para ver varios casos de usos inadecuados en el cap´ıtulo siguiente.
3.2.4. Funciones simples
Imaginemos ahora que un grupo de bolitas de varios colores representa a alg ´un
elemento de un juego, y que queremos representar su sombra en la celda vecina
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 116 of 312 --

117
al Este. Vamos a representar la sombra por una cantidad de bolitas negras igual a
la cantidad total de bolitas del elemento. Queremos, entonces, escribir un proce-
dimiento HacerSombraBasica que dibuja una sombra en la celda lindante al Este
de la actual. Supondremos que contamos con un procedimiento DibujarSombra
que, dado un par ´ametro num ´erico valorIntensidad, coloca esa cantidad de bo-
litas negras en la celda al Este, volviendo a la celda original antes de terminar.
¿C ´omo ser´ıa el procedimiento pedido? Claramente, precisamos una expresi ´on
que calcule el n ´umero total de bolitas en la celda actual, y lo pase como argu-
mento al procedimiento DibujarSombra.
procedure HacerSombraBasica()