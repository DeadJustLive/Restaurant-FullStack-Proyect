# Parte IV

Estructuras de Datos
149

-- 149 of 315 --



-- 150 of 315 --

151
En lo que se reere a la resolución de problemas, muchas veces para
plantear el problema imaginamos objetos y acciones que se relacionan entre
si.
Cualquier lenguaje de programación tiene ya implementados tipos de
datos básicos como lo son enteros cortos, enteros largos, punto otante, car-
actéres, arreglos y matrices.
Sin embargo, a medida que nos adentramos más y más en la programación,
esos tipos de datos dejan de ser sucientes, podemos plantear problemas que
traten de cosas mas allá de los números y arreglos.
No debemos de desanimarnos y pensar que la computadora solo nos
servirá para problemas de números y arreglos, ya que con un poco de cre-
atividad podremos manejar una innidad de objetos distintos.
Si bien una computadora solamente cuenta con herramientas para mane-
jar números, caractéres y arreglos, es posible hacer una analogía represen-
tando ciertos objetos abstractos con arreglos y números e implementando
funciones que simulen las acciones de estos objetos.
Las representaciones de estos objetos abstractos constan de una serie de
datos y funciones para manipular esos datos, a estas dos cosas juntas se les
llama estructuras de datos. A continuación conoceremos las estructuras de
uso mas frecuente.

-- 151 of 315 --

152

-- 152 of 315 --

Cap´ıtulo 13
Pilas, Colas, Listas
Iniciaremos nuestro estudio de las estructuras de datos con estas tres
estructuras que son por mucho, las mas sencillas de todas: pilas, colas y
listas.
13.1. Pilas
Imaginemos este sencillo escenario: un mesero tiene platos de colores api-
lados; de vez en cuando el que lava los platos coloca un plato recién lavado
sobre la pila de platos; y en otras ocaciones el mesero toma el plato que esta
hasta arriba y sirve ahí la comida que ha sido preparada por el cocinero para
posteriormente llevarla a su destino.
Si sabemos de qué color es el primer plato de la pila, en qué momentos
el que lava los platos colocó platos sobre la pila(tambien sabemos el color de
los que se van añadiendo), y en qué momentos el mesero retiró cada plato
que se encontraba hasta arriba; podemos saber de qué color será el plato que
le toca a cada cliente.
Una manera de saberlo podría ser, hacer una representación dramatica
de los hechos; pero esto no es necesario, ya que tambien podríamos tomar
un lapiz y un papel, y escribir una lista de los colores de los platos, poste-
riormente, ir escribiendo los colores de los platos que se pusieron en la pila
al nal de la lista, y borrar el ultimo color de la lista cada que un plato se
retire.
No se necesita ser un gran matemático para pensar en hacer eso, sin
embargo, en el momento de querer implementar un programa en C que lo
reprodusca, nos encontramos con que no tenemos ninguna lista donde se
coloquen y se quiten cosas del nal, tenemos solamente arreglos, variables,
153

-- 153 of 315 --

154 CAPÍTULO 13. PILAS, COLAS, LISTAS
estructuras, apuntadores, etc.
Claro que podemos simular esta lista con las herramientas que nos pro-
porciona C++ o incluso C, asi pues, este es un ejemplo de objetos(como la
pila de platos) ligados a operaciones(como poner un nuevo plato o quitar un
plato) que modican al objeto, es decir, una estructura de datos.
Una pila, es la estructura de datos mencionada en este ejemplo, es decir,
un altero de objetos. O mas objetivamente:
Denición 13.1.1 (Pila). Estructura de datos que simula una lista en la
cual solo se pueden realizar 2 operaciones: colocar un elemento al nal, o
quitar un elemento del nal.
Lo unico que se puede hacer en una pila es colocar un objeto hasta arriba,
o quitar el objeto que esta arriba, en el ejemplo anterior si se quita un objeto
de abajo o del centro(lo mismo que si se intenta añadir uno), la pila colapsaría.
Si queremos programar algo similar, lo mas obvio es guardar la informa-
ción de la pila en un arreglo, además en este ejemplo usaremos números para
denotar los colores.
Imaginemos que el restaurant tiene en total 10 platos(un restaurant bas-
tante pobre), ello nos indicaría que un arreglo de tamaño 10 podría guardar
todos los platos sin temor a que el tamaño del arreglo no alcance.
Suponiendo que inicialmente hay 2 platos, uno de color 1, y otro de color
2, el arreglo debería lucir algo asi:
2 1 0 0 0 0 0 0 0 0
Si repentinamente el que lava los platos pone un plato hasta arriba de
color 2, luego de ello el arreglo debería de lucir asi:
2 1 2 0 0 0 0 0 0 0
Si luego pone hasta arriba un plato de color 3, entonces el arreglo debería
de quedar asi:
2 1 2 3 0 0 0 0 0 0
Pero si el mesero toma un plato de arriba, el arreglo estará de nuevo de
esta manera:
2 1 2 0 0 0 0 0 0 0
Si el mesero vuelve a tomar un plato de arriba, el arreglo quedará de esta
manera:

-- 154 of 315 --

13.1. PILAS 155
2 1 0 0 0 0 0 0 0 0
Para lograr esto, basta con declarar un arreglo y una variable de tal
manera que el arreglo diga especicamente qué platos hay en la pila, y la
variable cuántos platos hay.
Entonces, podemos representar los datos de una pila de la siguiente man-
era:
1 int p i l a [ tamaño maximo ] ;
2 int p=0;
En esta implementación supusimos que la pila consta únicamente de
números enteros, sin embargo en la práctica cualquier tipo de datos es váli-
do, incluso el funcionamiento es el mismo si se declaran varios arreglos para
guardar elementos en la pila que consten de varias variables, por ejemplo,
pares ordenados de números.
Cada que queramos añadir un elemento en la parte superior de la pila, es
suciente con esta línea de código:
1 p i l a [ p++]=o b j e t o ;
Y cuando queramos retirar el elemento que este en la parte superior.
1 p i l a [−−p ] = 0 ;
Hay que hacer notar casi siempre es suciente decrementar al variable p
para retirar un elemento de la parte superior, pero todo depende del proble-
ma.
Por último, como cultura general, en ingles a la pila se le llama stack, a
la operación de poner un elemento en la parte superior se le llama push, y la
de quitar un elemento se le llama pop.
Asi mismo, si la pila sobrepasa su tamaño máximo, el error devuelto es
stack overow o desbordamiento de pila(ahora ya sabemos qué quieren
decir algunos errores comunes en aplicaciones inestables).
Vale la pena recordar que cada que el sistema operativo maneja también
una pila para cada programa que se está ejecutando, en dicha pila se añaden
las variables locales cada que se llama a una función y se retiran cuando se
regresa de la función.
La implementación de dicha pila es muy parecida a la que se muestra aquí,
esto es un indicio de que a pesar de ser una implementación muy sencilla tiene
sus ventajas.

-- 155 of 315 --

156 CAPÍTULO 13. PILAS, COLAS, LISTAS
13.2. Colas
Imagina una conversación de chat entre 2 personas, aunque los conver-
santes no se den cuenta, existe algo llamado lag, es decir, el tiempo que tardan
las 2 computadoras en mandarse y recibir los mensajes.
Dependiendo de la conexión, el lag puede variar entre menos de un se-
gundo o incluso mas de un minuto.
Si por un momento, por falla del servidor, una de las 2 computadoras
pierde la conexión, y en ese momento un usuario está intentando mandar
varios mensajes, el programa de chat guardará los mensajes que el usuario
está tratando de mandar, y cuando se recupere la conexión, el programa de
chat mandará los mensajes en el mismo orden que el usuario los escribió.
Obviamente, el programa de chat no usa una pila para eso, ya que si usara
una pila, el receptor leería los mensajes en el orden inverso que el emisor los
escribió.
Es decir, en una pila el ultimo que entra es el primero que sale. De ahí
que a las pilas se les conozca como estructuras LIFO(Last In, First Out).
Existen otras estructuras llamadas colas, en una cola el primero que entra
es el primero que sale. Su nombre deriva de las las que se hacen en los
supermercados, cines, bancos, etc. Donde el primero que llega, es el primero
en ser atendido, y el último que llega es el último en ser atendido(suponiendo
que no haya preferencias burocráticas en dicho establecimiento).
Las colas, son conocidas como estructuras FIFO(First In, First Out).
Denición 13.2.1 (Cola). Una cola es una estructura de datos que simula
una lista, en la cual sólo se pueden aplicar estas dos operaciones: colocar un
elemento al nal, o quitar un elemento del principio.
Para representar una cola obviamente necesitamos tambien un arreglo.
Nuevamente para ilustrar cómo utilizar el espacio del arreglo imaginaremos
una situación divertida.
Supongamos que hay varios participantes en la cola para el registro de
la OMI(Olimpiada Mexicana de Informática). Cada participante tiene un
nombre que consiste de un número entero mayor o igual que 1(Son bastante
populares esos nombres en nuestros días).
Ccomo faltan muchos estados a la OMI, solo habrá 10 participantes.
Entonces el arreglo podría lucir algo asi...
0 0 0 0 0 0 0 0 0 0
En ese momento llega 3 y se forma
3 0 0 0 0 0 0 0 0 0

-- 156 of 315 --

13.2. COLAS 157
Luego llega 5 y se forma
3 5 0 0 0 0 0 0 0 0
Despues llega 4 y se forma
3 4 5 0 0 0 0 0 0 0
Luego llega 9, y despues de eso llega 2
3 4 5 9 2 0 0 0 0 0
Entonces al encargado del registro se le ocurre comenzar a atender, y
atiende a 3.
En la vida real, los participantes darían un paso hacia delante, pero en
una computadora, para simular eso, sería necesario recorrer todo el arreglo,
lo cual es muy lento; por ello, es mas practico dejar el primer espacio de la
cola en blanco.
0 4 5 9 2 0 0 0 0 0
Luego se atiende a 4
0 0 5 9 2 0 0 0 0 0
En ese momento llega 1 corriendo y se forma
0 0 5 9 2 1 0 0 0 0
Y así continúa...
Ya para este momento, te debes de estar imaginando que para implemen-
tar una cola, unicamente se requiere un arreglo y dos variables, donde las
variables indican donde inicia y donde termina la cola.
La mayoría de las veces podremos saber por adelantado cuantos elemen-
tos se formarán en la cola. Sin embargo, suponiendo que se forma alguien
e inmediatamente es atendido, se vuelve a formar y vuelve a ser atendido in-
mediatamente, y asi 1 000 veces, entonces se requeriría un arreglo de tamaño
1 000, cuando nunca hay mas de un elemento dentro de la cola.
Para evitar eso, podemos añadir elementos al principio de la cola si ya no
hay espacio al nal.
Por ejemplo, si luego de que se atiendió a muchos participantes, la cola
está de esta forma:

-- 157 of 315 --

158 CAPÍTULO 13. PILAS, COLAS, LISTAS
0 0 0 0 0 0 0 0 7 3
Y para recticar algo 5 vuelve a formarse, podemos colocar a 5 al principio
5 0 0 0 0 0 0 0 7 3
Luego si 4 vuelve a formarse
5 4 0 0 0 0 0 0 7 3
Puede parecer extraño esto, pero el programa sabrá que la cola empieza
donde está 7 y termina donde está 4. Asi que si el organizador atiende al
siguiente, atenderá a 7, y la cola quedará de esta manera
5 4 0 0 0 0 0 0 0 3
Luego atenderá a 3
5 4 0 0 0 0 0 0 0 0
Despues atenderá a 5
0 4 0 0 0 0 0 0 0 0
Y asi sucesivamente...
Implementar la operación de meter un elemento a la cola es muy sencillo:
1 c o l a [ f i n ++]=elemento ;
2 i f ( f i n >=tamaño de l a c o l a )
3 f i n =0;
Y casí lo mismo es sacar un elemento de la cola
1 i n i c i o ++;
2 i f ( i n i c i o >=tamaño de l a c o l a )
3 i n i c i o =0;

-- 158 of 315 --

13.3. LISTAS 159
Dato 1 Dato 2 Vacío
Figura 13.1: Representación gráca de una lista enlazada
13.3. Listas
Frecuentemente necesitamos tener almacenadas unas k listas de datos en
memoria, sabiendo que el número total de datos en memoria no sobrepasa n.
Si disponemos de suciente memoria, podemos guardar en memoria n
arreglos de tamaño k o una matriz de tamaño nk, pero no siempre dispon-
dremos de tanta memoria.
Tambien hay veces que se requieren tener listas de números y agregar
números a dichas listas pero no al nal ni al principio, sino en medio.
Para solucionar estos y otros problemas, existen las listas enlazadas.
Las listas enlazadas son estructuras de datos compuestas por una sucesión
de elementos llamados nodos; en la que cada nodo contiene un dato y la
dirección del proximo nodo, en caso de que haya próximo.
La gura 13.3 muestra una representación gráca de una lista enlazada.
Denición 13.3.1 (Nodo). Se considera un nodo a cualquiera de estas dos
cosas:
Una estructura vacía ó
Un elemento de información y un enlace a otro nodo.
La tarea de implementar una lista enlazada puede hacerse ecazmente
con 2 arreglos: uno para guardar los datos y otro para guardar los enlaces,
además se requiere una variable que diga el tamaño de la lista de la siguiente
manera:
1 Tipo dato [ tamaño maximo de l a l i s t a ] ;
2 int proximo [ tamaño maximo de l a l i s t a ] ;
3 int t a m _ l i s t a =1; //Tamaño de l a l i s t a
Lo único que falta denir es el elemento vacío, para ello, podemos denir
que el dato 0 es el elemento vacío, y en el momento que nos encontremos con
él, sabemos que la lista ya habrá terminado.
La ventaja de usar el 0 para representar el elemento vacío radica en que
muchos arreglos se inicializan automáticamente en 0 y no es necesario ini-
cializarlos después.
Si se mira con atención las tres líneas sugeridas para declarar la lista
enlazada, es posible darse cuenta que el tamaño inicial de la lista es 1, a

-- 159 of 315 --

160 CAPÍTULO 13. PILAS, COLAS, LISTAS
pesar de que inicialmente la lista no tiene elementos. Esto se debe a que esa
implementación está pensada para reservar el nodo 0 como el nodo vacío, por
lo que inicialmente la lista consiste únicamente del nodo vacío.
Como toda estructura de datos, las listas tienen operaciones para ma-
nipular los datos, aquí contemplaremos un par de operaciones: insertar y
recorrer.
Como el lector puede imaginar, usaremos una estrategia similar a la de
la pila para determinar qué partes de los arreglos ir utilizando conforme se
vayan insertando nuevos elementos.
Mas precisamente, una vez insertados n elementos, las primeras n + 1
posiciones de los arreglos habrán sido usadas.
Una vez considerado todo esto, insertar un nodo con un dato x, justo
despues de otro nodo k, se puede hacer facilmente en tiempo constante:
1 void i n s e r t a r ( Tipo x , int k ) {
2 dato [ t a m _ l i s t a ]=x ;
3 proximo [ t a m _ l i s t a ]= proximo [ k ] ;
4 proximo [ k]= t a m _ l i s t a++;
5 }
Lo que hace este código es colocar x en el siguiente espacio en blanco den-
tro del arreglo datos, luego colocar un enlace al sucesor de k en el siguiente
espacio en blanco dentro del arreglo proximo, y hacer que k apunte al nodo
que se acaba de crear.
De esa forma k apuntará al nuevo nodo, y el nuevo nodo apuntará al nodo
que apuntaba k.
Si observamos bien, esta implementación solo funciona cuando ya se tiene
un nodo inicial en la lista, por lo cual es necesario crear el primer nodo medi-
ante otro. La siguiente función crea un primer nodo de una lista asignándole
el valor x y devuelve el índice del nodo:
1 int primer_nodo ( Tipo x ) {
2 dato [ t a m _ l i s t a ]=x ;
3 proximo [ t a m _ l i s t a ] = 0 ;
4 return t a m _ l i s t a++;
5 }
Una vez que tenemos creada una lista necesitamos consultar los datos
de alguna manera, en una lista lo único que podemos hacer es consultar sus
datos en órden, desafortunadamente tenemos que pagar el precio de no poder
acceder directamente a los datos, pero por los motivos antes expresados, a
veces vale la pena.

-- 160 of 315 --

13.3. LISTAS 161
Al recorrer la lista se pueden hacer muchas cosas, aquí mostraremos sim-
plemente cómo imprimir los elementos de la lista. El siguiente código imprime
todos los datos contenidos en una lista, asumiendo que 1 es el primer elemento
de dicha lista.
1 for ( i =1; i ! = 0 ; i=proximo [ i ] )
2 p r i n t f ( " %d" , dato [ i ] ) ;
Estas implementaciones estan algo límitadas, ya que se le da un trato
especial al primer elemento de la listas y no se pueden borrar nodos entre
otras cosas.
Muchos lenguajes de programación(por ejemplo C++) ya tienen previa-
mente implementadas listas enlazadas, con implementaciones bastante mas
completas que las mostradas aquí. El objetivo de mostrar las listas y las im-
plementaciones es simplemente mostrar la idea de las listas enlazadas y una
implementación sencilla, ya que juega un papel muy importante en el estudio
de los algoritmos y sirven de base para entender otras estructuras de datos.
También hay que hacer notar que tanto las pilas como las colas pueden ser
implementadas con listas enlazadas, pero su implementación es mas tediosa,
su rendimiento es mas lento y además los enlaces hacia el siguiente elemento
requieren cierta memoria adicional; la elección sobre qué implementaciones
usar depende del problema en especíco.

-- 161 of 315 --

162 CAPÍTULO 13. PILAS, COLAS, LISTAS
13.4. Problemas
13.4.1. Equilibrando Símbolos
Jorge está estudiando para ser un desarrollador de software y como tarea
le han encargado elaborar un compilador.
Para hacerlo requiere de un algoritmo que verique que la sintaxis del
código fuente sea la correcta.
Una de las cosas que se requieren para que un código tenga una sintaxis
correcta es que todos los paréntesis, corchetes y llaves estén correctamente
emparejados, es decir, que por cada paréntesis, corchete o llave que abra
exista una pareja correspondiente que cierre, y además que no se traslapen.
Jorge requiere implementar un algoritmo que reciba un programa como
entrada y devuelva la posición del primer error sintáctico, considerando úni-
camente las posiciones de paréntesis ( (, ) ), corchetes ( [, ] ) y llaves
( {, } ).
El código fuente consiste de una sola línea con N caracteres (incluyen-
do espacios en blanco) donde el primer carácter está en la posición uno, el
segundo en la posición dos y así sucesivamente.
Algunos de los caracteres pueden ser; (, ), [, ], { o }. Dos sím-
bolos son correspondientes si son del mismo tipo y uno de ellos abre mientras
el otro cierra (ej. ( y ) son símbolos correspondientes).
Un código contiene un error sintáctico si se cumple al menos uno de tres
casos:
Para alguno de los símbolos que abren no existe un símbolo correspon-
diente que cierre. (ej. (a + b) + (c ∗ [)).
Cuando se encuentre un símbolo que cierre sin estar antes su corre-
spondiente que abra. (ej. ([a+b]) + c] * (2 + 2)).
Cuando Entre dos símbolos correspondientes (uno que abra y otro que
cierre del mismo tipo) exista un tercer símbolo de tipo diferente que
abra y que no tenga su correspondiente en ese rango, es decir, cuando
los símbolos se traslapen. (ej. a(b + c ∗ {d/h)}).
Problema
Escribir un programa que dados N (el número de caracteres del código
fuente a revisar incluyendo espacios en blanco), y el código en sí, determine
si éste es correcto sintácticamente o no.

-- 162 of 315 --

13.4. PROBLEMAS 163
Entrada
Linea 1: Un solo entero N
N caracteres que representan el código.
Salida
La palabra SI si el código es sintácticamente correcto, la palabra NO
en caso contrario.
Ejemplo de Entrada
20
a(b + c * { d / h )}
Ejemplo de Salida
NO
Referencias
El problema fue escrito por Nephtali Garrido y utilizado en uno de los
primeros examenes preselectivos de la Olimpiada Mexicana de Informática a
nales del 2007.

-- 163 of 315 --

164 CAPÍTULO 13. PILAS, COLAS, LISTAS
13.4.2. Pirámides Relevantes
Hay N pirámides alineadas en línea recta.
Las pirámides estan numeradas de 1 a N , de izquierda a derecha.
Cada pirámide i tiene un nivel de relevancia Ri y tambien tiene una altura
Hi.
Desde la parte mas alta de cualquiera de las pirámides, es posible ver
todas las pirámides hacia la izquierda o hacia la derecha, siempre y cuando
cuando no exista una piramide mas alta que obstruya la vista.
Es decir, una pirámide j se puede ver desde la parte mas alta de una
pirámide i, sí y solo sí NO existe alguna k tal que i < k < j ó j < k < i
para Hk ≥ Hi.
Por ejemplo, si hay 6 pirámides con alturas 1, 3, 2, 1, 5, 2(de izquierda
a derecha en ese orden) desde la parte mas alta de la pirámide 3(que tiene
altura 2), se pueden ver las pirámides 2, 3, y 4 y 5 y las pirámides 1 y 6 no
pueden ser vistas desde ahí ya que las pirámides 2(de altura 3) y 5(de altura
5) obstruyen la vista. En cambio, desde la parte mas alta de la pirámide 5
se pueden ver todas las pirámides, mientras que desde la parte mas alta de
la pirámide 6, solamente se puede ver la pirámide 5.
Un guía de turistas ha pedido tu ayuda.
Problema
Escribe un programa que dadas las características de las pirámides, de-
termine, para la parte mas alta de cada pirámide, cual es la pirámide mas
importante que puede ser vista desde ahí.
Entrada
Línea 1: Un solo número entero N .
Siguientes N líneas: La línea i + 1 contiene los dos enteros Hi y Ri
separados por un espacio.
Salida
N números enteros, donde el i−ésimo entero representa la relevancia
de la pirámide mas relevante que se pueda ver desde la parte mas alta
de la pirámide i.

-- 164 of 315 --

13.4. PROBLEMAS 165
Entrada de Ejemplo
6
1 10
3 5
2 4
1 3
5 1
2 2
Salida de Ejemplo
10 10 5 4 10 2
Consideraciones
Puedes asumir que 2 ≤N≤ 1000000.
Referencias
El problema fue escrito por Luis Enrique Vargas Azcona y usado en uno de
los primeros exámenes preselectivos de la Olimpiada Mexicana de Informática
a nales del 2007.

-- 165 of 315 --

166 CAPÍTULO 13. PILAS, COLAS, LISTAS

-- 166 of 315 --

Cap´ıtulo 14
Árboles Binarios
Seguramente despues de haber visto las listas enlazadas te llegó a la mente
la idea de colocar mas de un enlace en cada nodo.
No fuiste el primero en tener esa idea, pues los árboles binarios son es-
tructuras de datos parecidas a las listas enlazadas, con la diferencia de que
cada nodo puede tener hasta 2 enlaces(de ahí el nombre de binario).
Estas estructuras de datos tienen muchas aplicaciones, las mas frecuentes
involucran ordenamiento.
Al igual que a las listas enlazadas, es posible ver a los árboles binarios
como un conjunto de nodos iterconectados y a cada nodo se le puede asignar
información.
La gura 14.1 muestra una representación gráca de un árbol binario,
como se puede ver, es igual que una lista enlazada excepto porque cada nodo
puede tener hasta dos enlaces y no solamente uno.
Antes de seguir entrando en materia, será conveniente dar unas cuantas
deniciones.
Por ahora nos reservaremos la denición general de árbol, pues requiere
de teoría de grafos para comprenderla, sin embargo, un árbol binario se puede
denir de la siguiente manera, sin recurrir a teoría de grafos:
Denición 14.0.1 (Árbol Binario). Un árbol binario es un conjunto V de
elementos llamados nodos o vértices, tal que:
Para todo v ∈ V , v = (A, B) donde:
A es el conjunto vacío o un enlace a otro vértice a ∈ V (en este caso
decimos que v apunta a a), A recibe el nombre de hijo izquierdo de v
B es el conjunto vacío o un enlace a otro vértice b ∈ V (en este caso
decimos que v apunta a b), B recibe el nombre de hijo derecho de v.
167

-- 167 of 315 --

168 CAPÍTULO 14. ÁRBOLES BINARIOS
2
7
2 6
5 11
5
9
4
Figura 14.1: Representación gráca de un árbol binario
Hay un único elemento r ∈ V tal que ningún otro vértice apunta a él;
decimos que r es la raíz de V .
Para todo v ∈ V tal que v 6 = r existe un único w ∈ V tal que w apunta
a v al cual llamaremos padre de v.
Para todo v ∈ V tal que v 6 = r existe un camino desde la raiz hasta
v(mas objetivamente, existen w1, ..., wk ∈ V tales que w1 = r, wk = v
y wi apunta a wi+1 para todo entero 1 ≤ i < k).
La denición anterior no es la que se utiliza en teoría de grafos para los
árboles binarios y en cierto sentido tiene algunas propiedades distintas, sin
embargo, los árboles binarios utilizados en programación son exactamente
los que se acaban de denir.
El lector puede considerar esto una ambigüedad, y realmente lo es, pero
puede estar tranquilo de que en este libro se hablará solo de los árboles
binarios que se usan en programación evitando así toda ambigüedad.
Esto no quiere decir que nos vayamos a limitar en decir cómo progra-
mar los árboles binarios, sino que también exploraremos sus propiedades
matemáticas.
Por lo general a cada nodo se le suele asociar un contenido llamado clave,
sin embargo, esto no forma parte de la escencia de un árbol binario, ya que
puede carecer de claves y aún así sigue siendo árbol binario.
Existen también otras deniciones que es conveniente conocer:
Los enlaces que unen los nodos reciben el nombre de aristas.

-- 168 of 315 --

14.1. IMPLEMENTACIÓN 169
Se dice que un nodo B es hijo de un nodo A, si existe alguna arista que
va desde A hasta B. Por ejemplo, en la gura, 7 es hijo de 2, 4 es hijo
de 9, 11 es hijo de 6, etc.
Se dice que un nodo A es padre de un nodo B si existe una arista que
va desde A hasta B. Ej. 9 es padre de 4, 6 es padre de 5 y de 11, etc.
Se dice que un nodo es hoja, si no tiene hijos. Ej. 11 y 4 son hojas, pero
6, 7, y 9 no lo son.
La rama izquierda de un nodo es el árbol que tiene como raíz el hijo
izquierdo de tal nodo, por ejemplo 7, 2, 6, 5, 11 son los nodos de la
rama izquierda de 2.
La rama derecha de un nodo es el árbol que tiene como raíz el hijo
derecho de tal nodo.
La altura de un árbol es la distancia(en áristas) de la hoja mas lejana
a la raíz.
14.1. Implementación
Los árboles binarios tienen muchas formas de implementarse, cada una
con sus ventajas y desventajas, por ahora solo trataremos una.
Pueden ser implementados utilizando 3 arreglos: clave(los datos que guar-
da cada nodo), hijo izquierdo e hijo derecho.
Y por supuesto otra variable entera: el número de nodos en el árbol.
1 Tipo c l a v e [ maximo de nodos ] ; // Dato que guarda e l nodo
2 int i z q [ maximo de nodos ] ; // H i j o i z q u i e r d o
3 int der [ maximo de nodos ] ; // H i j o d e r e c h o
4 int nodos =0;
En seguida se muestran los datos que podrían contener los arreglos para
obtener el árbol que se muestra el la gura 14.1 :
nodo 0 1 2 3 4 5 6 7 8
clave 2 7 2 6 5 11 5 9 4
izq 1 2 -1 6 -1 -1 -1 8 -1
der 4 3 -1 5 7 -1 -1 -1 -1
Como se observa en la tabla, se está utillizando el nodo 0 como raíz, y el
-1 para representar el vacío.
Se puede crear un nuevo nodo facilmente con la siguiente función:

-- 169 of 315 --

170 CAPÍTULO 14. ÁRBOLES BINARIOS
1 int crear_nodo ( Tipo dato ) {
2 c l a v e [ nodos ]= dato ;
3 i z q [ nodos ]= −1;
4 der [ nodos ]= −1;
5 return nodos++;
6 }
Como se puede ver, la función recibe como parámetro el dato que va
a tener el nuevo nodo y regresa el lugar en el arreglo donde está ubicado
el nuevo nodo, depende del programador saber dónde poner el enlace para
accesar a dicho nodo.
14.2. Propiedades Básicas
Los árboles binarios tienen muchas propiedades que pueden resultar útiles.
Exploraremos varias de ellas.
Teorema 17. Todo árbol binario con n nodos contiene exactamente n − 1
aristas.
Demostración. Sea A un árbol binario con n nodos.
Toda arista une a un nodo padre con un nodo hijo, es decir, el número
de aristas es igual al número de nodos que tienen un padre.
Para todo v ∈ A tal que v no es la raíz, existe un único nodo w tal que v
es hijo de w. Por lo tanto, hay tantas aristas como nodos distintos de la raíz,
es decir, hay n − 1 aristas.
Teorema 18. Un árbol binario de altura n tiene a lo mas 2n+1 − 1 nodos.
Demostración. Existe un solo nodo a distancia 0 de la raíz, existen a lo más
2 nodos a distancia 1 de la raíz, existen a lo más 4 nodos a distancia 3 de la
raíz.
Si para algun k existen a lo más 2k nodos a distancia k de la raíz, como
cada uno de esos nodos puede tener a lo más 2 hijos, entonces existen a lo
más 2k+1 nodos a distancia k + 1 de la raiz.
Por inducción, existen a lo más 2k nodos a distancia k de la raíz para
todo k ∈ N.
Por lo tanto, el número de nodos es 20 + ... + 2n, lo que por la ecuación
4.1 es igual a 2n+1 − 1.
Un árbol estrictamente binario es aquel en el que todo nodo tiene 2 hijos
o bien no tiene hijos.

-- 170 of 315 --

14.3. RECORRIDOS 171
Teorema 19. Un árbol estrictamente binario A tiene exactamente |A|+1
2 ho-
jas.
Demostración. Sea h el número de hojas que hay en el árbol, y sea m el
número de nodos que no son hojas, es decir m = |A| − h.
Por cada nodo v ∈ A tal que v no es una hoja, existen 2 aristas, por lo
tanto el número de aristas es igual a 2m.
Por el teorema 17, el árbol tiene exactamente |A| − 1 aristas. Es decir
|A| − 1 = 2m = 2|A| − 2h y así se concluye que:
h = |A| + 1
2 (14.1)
14.3. Recorridos
Aunque nos hemos dedicado a demostrar propiedades de los árboles bi-
narios e incluso ya vimos cómo representarlos en un programa, aún no hemos
visto ni una sola cosa útil que se pueda realizar con ellos.
Desafortunadamente el lector tendrá que esperar si quiere encontrar cosas
útiles, pues antes tenemos que estudiar los recorridos en árboles binarios.
El tema de los recorridos en los árboles binarios suele parecer muy aburri-
do en un inicio, ya que su explicación carece de motivación. Por el momento
el lector deberá de creer que dichos recorridos nos servirán muy pronto. Aún
así se explicarán supercialmente ejemplos de dónde se usa cada recorrido.
Existen 3 formas recursivas distintas de visitar los nodos de un árbol
binario:
Recorrido en Preorden. Tambien llamado Búsqueda en Profundidad
en la teoría de grafos, consiste en visitar primero el nodo actual, luego
el hijo izquierdo y despues el hijo derecho.
Este recorrido visita los nodos del árbol binario de la gura 14.1 en el
siguiente órden: 2 7 2 6 5 11 5 9 4.
Puede ser implementado de la siguiente manera:
1 void p r e o r d e n ( int nodo ) {
2 i f ( nodo==−1)
3 return ;
4 v i s i t a ( nodo ) ;
5 p r e o r d e n ( i z q [ nodo ] ) ;
6 p r e o r d e n ( der [ nodo ] ) ;
7 }

-- 171 of 315 --

172 CAPÍTULO 14. ÁRBOLES BINARIOS
Entre otras cosas, este recorrido es útil para saber cómo recorrería
una persona, un robot, o culquier cosa que pueda trasladarse pero no
teletransportarse una estructura similar a un árbol binario de búsqueda;
ya que para llegar a los nodos hijos hay que pasar primero por el nodo
padre. Dicho de otra manera, estos recorridos son caminables.
Recorrido en Orden. En algunos lugares se le menciona como inor-
den, consiste en visitar primero el hijo izquierdo, luego el nodo actual,
y nalmente el hijo derecho.
Este recorrido visita los nodos del árbol binario de la gura 14.1 en el
siguiente órden: 2 7 5 6 11 2 5 4 9.
El siguiente código lo ilustra:
1 void orden ( int nodo ) {
2 i f ( nodo==−1)
3 return ;
4 orden ( i z q [ nodo ] ) ;
5 v i s i t a ( nodo ) ;
6 orden ( der [ nodo ] ) ;
7 }
La principal aplicación de este recorrido es en el ordenamiento, dicha
aplicación se tratará después.
Recorrido en Postorden. Como ya te imaginarás, consiste en visitar
primero los nodos hijos y después el nodo actual.
Este recorrido visita los nodos del árbol binario de la gura 14.1 en el
siguiente órden: 2 5 11 6 7 4 9 5 2.
1 void p o s t o r d e n ( int nodo ) {
2 i f ( nodo==−1)
3 return ;
4 p o s t o r d e n ( i z q [ nodo ] ) ;
5 p o s t o r d e n ( der [ nodo ] ) ;
6 v i s i t a ( nodo ) ;
7 }
A veces es necesario borrar los nodos al visitarlos, en caso de que fuera
así, este recorrido tendría la característica de que solamente desapare-
cerían hojas del árbol y en ningun momento habría vértices aislados.
Es decir, este recorrido es indispensable cuando se requiere liberar la
memoria de un árbol binario(aunque estas implementaciones no reser-

-- 172 of 315 --

14.4. ÁRBOLES BINARIOS DE BÚSQUEDA 173
ven y liberen dinámicamente la memoria, es muy probable que el lector
lo necesite realizar en algun momento de su vida).
14.4. Árboles Binarios de Búsqueda
Los árboles binarios son bellos, pero no demuestran todo su potencial
hasta que se utilizan como árboles binarios de búsqueda; los árboles binarios
de búsqueda aparecieron con el propósito de mantener conjuntos de datos
ordenados.
Ya hemos visto como ordenar conjuntos de datos, pero si en algun mo-
mento dado quicieramos agregar mas datos al conjunto, con lo que sabemos
hasta ahora tendríamos que repetir todo el ordenamiento, o en el mejor de
los casos usar inserción, como ya hemos visto, si una inserción toma tiempo
lineal entonces N inserciones tomarían tiempo cuadrático.
El principal objetivo de los árboles binarios de búsqueda es poder hacer
inserciones en O(logN ); lamentablemente los árboles que estudiaremos no
alcanzan ese objetivo, pero al menos se acercan de cierta manera.
Denición 14.4.1 (Arbol Binario de Búsqueda). Un árbol binario de búsque-
da es un árbol binario A con una función de costo w : A → C donde C es un
conjunto con un órden total.
Además, para todo v ∈ A:
Si v tiene algún descendiente izquierdo(llamémosle i) entonces w(v) ≥
w(i)
Si v tiene algún descendiente derecho(llamémosle d) entonces w(v) ≤
w(d)
Al número w(v) le vamos a llamar el peso de v o la clave de v.
La principal aplicación de estos árboles en este capítulo será la de guardar
elementos en el árbol y saber si ya se habían insertado de manera eciente.
Hasta este momento hemos visto cómo recorrer árboles binarios y cómo
guardarlos en memoria, sin embargo, sin una manera de construirlos, esto
resultaría inútil.
No vale la pena entrar en detalle respecto a cómo construir un árbol
binario de búsqueda de un solo nodo. Una vez teniendo un árbol binario de
búsqueda, es necesario poder agregarle mas nodos, ya que de otra manera de
nada nos serviría que el recorrido en órden procesara las claves de un árbol
binario de búsqueda en órden no descendente.

-- 173 of 315 --

174 CAPÍTULO 14. ÁRBOLES BINARIOS
La inserción de un dato en un árbol binario de búsqueda, además de que
implica crear un nodo, la parte mas difícil radica en saber dónde insertar el
nuevo nodo.
Esa dicultad se supera sin mucho problema adoptando un procedimiento
recursivo, llamaremos x a la clave que tendrá el nuevo nodo:
Si x es mayor que la clave de la raíz y no hay rama derecha, entonces
hay que crear un nodo con clave x que haga las veces de rama derecha.
Si x es mayor que la clave de la raíz y hay rama derecha, entonces hay
que insertar x en la rama derecha.
Si x es menor que la clave de la raíz y no hay rama izquierda, entonces
hay que crear un nodo con clave x que haga las veces de rama izquierda.
Si x es menor que la clave de la raíz y hay rama izquierda, entonces
hay que insertar x en la rama izquierda.
Si se diera el caso que x fuera igual a la clave de la raíz, x puede ser
insertado en cualquiera de las dos ramas sin alterar la condición de árbol
binario de búsqueda.
La gura 14.2 muestra una serie de inserciones utilizando este algoritmo.
A continuación se muestra una implementación de dicho algoritmo:
1 void i n s e r t a r ( int nodo , Tipo dato ) {
2 i f ( c l a v e [ nodo]> dato ) {
3 i f ( i z q [ nodo]==−1){
4 i z q [ nodo ]= crear_nodo (
dato ) ;
5 } e l s e {
6 i n s e r t a r ( i z q [ nodo ] , dato
) ;
7 }
8 } e l s e {
9 i f ( der [ nodo]==−1){
10 der [ nodo ]= crear_nodo (
dato ) ;
11 } e l s e {
12 i n s e r t a r ( der [ nodo ] ,
dato ) ;
13 }
14 }
15 }

-- 174 of 315 --

14.4. ÁRBOLES BINARIOS DE BÚSQUEDA 175
8 8
4
8
4
5
8
4
5
9
8
4
5
9
10
8
4
3 5
9
10
Figura 14.2: Inserción de la secuencia de enteros 8 4 5 9 10 3 en un árbol
binario de búsqueda.

-- 175 of 315 --

176 CAPÍTULO 14. ÁRBOLES BINARIOS
La función anterior, crea un nuevo nodo con clave dato y lo inserta en un
árbol(o subárbol) que tiene raiz en nodo.
Asi que si queremos generar un árbol de búsqueda con las claves 8, 4, 5,
9, 10, 3 lo unico que tenemos que hacer es:
1 r a i z=crear_nodo ( 8 ) ;
2 i n s e r t a r ( r a i z , 4) ;
3 i n s e r t a r ( r a i z , 5) ;
4 i n s e r t a r ( r a i z , 9) ;
5 i n s e r t a r ( r a i z , 10) ;
6 i n s e r t a r ( r a i z , 3) ;
Ahora podemos ver que un árbol binario de búsqueda permite mantener
un conjunto de datos ordenado e insertar nuevos datos; pero el objetivo
de los árboles binarios de búsqueda es poder hacer inserciones en tiempo
logarítmico, lo cual aún no hemos logrado.
14.5. Encontrar un Elemento en el Árbol Bina-
rio de Búsqueda
Otra aplicación de los árboles binarios de búsqueda, es el hecho de saber
si en el árbol existe un nodo con una determinada clave.
Nuevamente la recursión resuelve fácilmente este problema. Llamémosle
x al valor que se está buscando:
Si la clave de la raiz es x entonces x está en el árbol.
Si la clave de la raíz es menor que x, entonces x está en el árbol si y
solo sí x está en la rama derecha
Si la clave de la raiz es mayor que x, entonces x está en el árbol si y
solo sí x está en la rama izquierda
Estas 3 observaciones conducen instantanemente a la siguiente imple-
mentación recursiva:
1 bool esta_en_el_arbol ( int nodo , Tipo x ) {
2 i f ( nodo==−1)
3 return f a l s e ;
4 i f ( c l a v e [ nodo]==x ) {
5 return true ;
6 } e l s e i f ( c l a v e [ nodo]<x ) {

-- 176 of 315 --

14.6. COMPLEJIDAD 177
7 return esta_en_el_arbol ( der [ nodo ] , x ) ;
8 } e l s e {
9 return esta_en_el_arbol ( i z q [ nodo ] , x ) ;
10 }
11 }
Como se podrá notar, si el árbol tiene altura h, se visitarán a lo más h
nodos para encontrar el nodo deseado, o bien, darse cuenta que no existe.
14.6. Complejidad
Respecto a la complejidad de la inserción en árboles binarios de búsqueda,
hay mucho que decir. Ya que si se insertan los datos en órden ascendente o
descendente, insertar un nuevo nodo requeriría O(n); pero también es posible
insertar los datos en otro órden de manera que cada inserción tome a lo más
dlog2 ne llamadas recursivas.
Consideremos el ejemplo de insertar los números enteros desde 1 hasta 7.
Si se insertaran de la siguiente manera no obtendríamos algo no muy
diferente a una lista enlazada:
1 r a i z=crear_nodo ( 1 ) ;
2 for ( i =2; i <=7; i ++)
3 i n s e r t a r ( r a i z , i ) ;
De hecho, el árbol binario tendría una altura de 6 aristas.
Pero si se insertaran los nodos de la siguiente manera, obtendríamos algo
muy diferente:
1 r a i z=crear_nodo ( 4 ) ;
2 i n s e r t a r ( r a i z , 2) ;
3 i n s e r t a r ( r a i z , 1) ;
4 i n s e r t a r ( r a i z , 3) ;
5 i n s e r t a r ( r a i z , 6) ;
6 i n s e r t a r ( r a i z , 5) ;
7 i n s e r t a r ( r a i z , 7) ;
En este segundo caso, obtendríamos un árbol con altura de 2 aristas.
De esta manera, es posible que una inserción tome O(log n) ó tome O(n),
dependiendo de cómo se haya construido el árbol, pero esa no es toda la
dicultad, ya que aquí solamente presentamos 2 formas de construir un árbol,
cuando en realidad hay n! formas de construirlo, y además, puede que un
mismo árbol se pueda construir de dos o mas maneras diferentes.

-- 177 of 315 --

178 CAPÍTULO 14. ÁRBOLES BINARIOS
A estas alturas, obviamente nos gustaría saber, en promedio, ¾qué altura
tiene un árbol binario de búsqueda?.
Prestando atención a lo que signica en promedio, podemos denirlo
como la suma de las alturas de los n! árboles(dichos árboles se generan in-
sertando los números de 1 a n en todos los órdenes posibles) entre n!.
Vamos a llamar S a una función N → Q tal que S(n) sea el promedio de
la altura al generar un árbol binario de búsqueda de n nodos.
Por denición, si n > 1:
S(n) =
∑n!
i=1 H(P (i))
n! (14.2)
Donde H(P (i)) representa la altura del árbol generado por una per-
mutación numerada como i(suponiendo que se numeraran todas las permuta-
ciones de 1 a n!).
Es necesario tomar en cuenta que F (n + 1) ≥ F (n), ya que todos los
árboles con n + 1 nodos se obtienen generando primero cada uno de los
árboles con n nodos y añadiendoles otro nodo al nal.
Con lo anterior, es fácil demostrar que la altura de un árbol con a nodos
en la rama izquierda y b nodos en la rama derecha tiene en promedio altura
de S(max(a, b)) + 1.
También hay que hacer la observación ahora de que se generan (n − 1)!
árboles con cada una de las claves como raíz.
Por lo tanto, si n > 1 entonces:
S(n) =
∑n−1
i=0 S(max(i, n − i − 1)) + 1
n (14.3)
Si n es par:
S(n) = 2 ∑n−1
i= n
2
S(i)
n + 1 (14.4)
Si n es impar
S(n) = 2 ∑n−1
i=d n
2 e S(i)
n − 1 + S(bn
2 c)
2 + 1 (14.5)
Sabemos de antemano que S(1) = 1 y S(0) = 0.
Nuevamente buscaremos evaluaremos algunos valores de n e intentaremos
adivinar:
S(2) = 21
2 + 1 = 2
S(3) = 22
3 + 1
3 + 1 = 2 + 2
3

-- 178 of 315 --

14.7. EL BARRIDO, UNA TÉCNICA ÚTIL 179
S(4) = 24+ 2
3
4 + 1 = 3 + 1
3
S(5) = 26
5 + 2
5 + 1 = 3 + 4
5
S(6) = 29+ 4
5
6 + 1 = 4 + 4
15
S(7) ≈ 211,4
7 + 2,67
7 + 1 = 4,64
S(8) ≈ 5,00
S(9) ≈ 5,30
S(10) ≈ 5,60
S(11) ≈ 5,85
S(12) ≈ 6,11
S(13) ≈ 6,33
S(14) ≈ 6,55
S(15) ≈ 6,74
S(16) ≈ 6,94
Aquí es mas difícil encontrar un patrón, el único patrón que parece apare-
cer es que S crece cada vez mas lento. Esto sugiere que la complejidad es
logaritmica. Y al examinar los valores de las razones S(16)
S(8) , S(8)
S(4) y S(4)
S(2) parece
haber una conrmación de dicha sospecha.
Por el momento no disponemos de sucientes herramientas para demostrar
esto para cualquier n, sin embargo, con un programa es posible demostrarlo
para todas las n menores o iguales 50 millones, lo cual debe ser suciente
para casi cualquier aplicación.
14.7. El Barrido, una Técnica Útil
El cálculo de los valores de S tampoco es algo trivial, ya que S está
denida a través de una sumatoria, y si se calcula esa sumatoria cada vez
que se quiera calcular el valor de S(i) para alguna i, requeriría en total un
tiempo cuadratico, ya que para calcular S(i) es necesario haber calculado
antes S(1), S(2), ..., S(i − 1).
Para poder calcular los valores de S en tiempo O(n) haremos uso de una
técnica que comunmente la denominan barrido o ventana deslizante.

-- 179 of 315 --

180 CAPÍTULO 14. ÁRBOLES BINARIOS
Un barrido normalmente consiste en obtener el valor de una función eval-
uada en un intervalo a partir del valor de la misma función evaluada en un
intervalo parecido.
No existe una regla general de cuándo es conveniente aplicar un barrido,
pero en el cáluculo de S, como lo veremos a continuación, si es conveniente.
Otra forma de denir S es como:
S(i) = F (i)
i + 1 (14.6)
Cuando i es par y
S(i) = F (i)
i + S(b i
2 c)
i + 1 (14.7)
Cuando i es impar.
En las dos ecuaciones anteriores se está utilizando F (i) para denotar∑n−1
i=d n
2 e S(i).
La observación clave para lograr calcular S en tiempo lineal es que si i ≥ 1
entonces F (2i) = F (2i − 1) + S(2i − 1) y F (2i + 1) = F (2i) − S(i) + S(2i).
Es decir, si se sabe de antemano cuales son los valores de F (1), ..., F (i) y el
valor de S(i), calcular los valores de S(i + 1) y F (i + 1) se puede hacer en
tiempo constante.
Por lo cual, el algoritmo consistiría en llenar un arreglo S con los valores
que se vayan encontrando de la función S y mantener una variable num con
el valor de F (i).
Para que este algoritmo funcione es necesario primero calcular S(1), luego
calcular S(2), después calcular S(3), etc. Esta forma de calcular valores de
funciónes recursivas de abajo hacia arriba es conocida como Programación
Dinámica.
En seguida se muestra una implementación del algoritmo:
1 double S [ 5 0 0 0 0 0 0 1 ] ;
2 double num= 0 . 0 ;
3
4 int main ( ) {
5 double i ;
6 S [ 0 ] = 0 ;
7 S [ 1 ] = 1 ;
8 for ( i =2; i <=50000000; i ++){
9 num+=S [ int ( i ) −1];
10 i f ( int ( i ) %2==0){
11 S [ int ( i ) ] = ( 2 . 0 ∗num) / i + 1 . 0 ;

-- 180 of 315 --

14.7. EL BARRIDO, UNA TÉCNICA ÚTIL 181
12 } e l s e {
13 num−=S [ int ( i /2) ] ;
14 S [ int ( i ) ] = ( 2 . 0 ∗num) / i+S [ int ( i
/2) ] / i + 1 . 0 ;
15 }
16 }
17 return 0 ;
18 }
Utilizando la ascersión assert(S[int(i)] <= 3,2 ∗ log(i)) en el programa
anterior, es posible comprobar que S(i) ≤ 3,2ln i para toda i entre 1 y 50
millones. De ahí llegamos al siguiente teorema
Teorema 20 (Altura promedio de un árbol binario de búsqueda). El valor
esperado de la altura de un árbol binario de búsqueda construido al azar es
menor o igual a 3,2log(n) donde n es el número de nodos del árbol.
Ahora hemos conrmado como los árboles binarios de búsqueda se acercan
bastante a su objetivo inicial de hacer inserciones en tiempo logarítmico, ya
que un árbol binario de búsqueda construido al azar con menos de 50 millones
de vertices probablemente tendrá una altura razonable.
Como podrá intuir el lector, S es una función cuya complejidad es O(logN ),
sin embargo la demostración de dicho resultado va mas allá de todo lo que
se pueda ver en este libro, y para sentirnos bien con nuestra conciencia, no
utilizaremos ese resultado sino el teorema 20.

-- 181 of 315 --

182 CAPÍTULO 14. ÁRBOLES BINARIOS
14.8. Problemas
14.8.1. Ancho de un Arbol
Tiempo Límite: 1 segundo
Descripcion
Supon que deseas dibujar un arbol binario en una cuadricula cuyas colum-
nas estan numeradas de acuerdo a las siguientes reglas:
Todos los nodos en un mismo nivel deberan estar en la misma la
Cada columna de la cuadricula puede tener solamente un nodo
Los nodos en el subarbol izquierdo de un nodo deberan ser dibujados en
una columna a la izquierda del mismo, al igual los nodos del subarbol
derecho deberan ser dibujados en columnas a la derecha del mismo
Al dibujar el arbol no debe quedar ninguna columna sin nodo entre la
columna mas a la izquierda y mas a la derecha del dibujo.
El ancho de un nivel se puede obtener restando el numero de la columna
derecha menos la columna izquierda del mismo mas uno. La raiz del arbol se
considera el nivel 1.
La siguiente gura muestra un arbol binario dibujado de acuerdo a la
siguiente regla. El ancho del primer nivel es uno mientras que el ancho del
segundo es 13, el tercer, cuarto, quindo y sexto nivel tienen los anchos 18,
18, 13 y 12 respectivamente.
Escribe un programa que al dibujar un arbol de esta forma calcule cual
es el nivel mas ancho del arbol, si dos niveles tienen el ancho maximo, como
en el caso del ejemplo el nivel 3 y el 4, entonces debes tomar el nivel con
menor numero.

-- 182 of 315 --

14.8. PROBLEMAS 183
Entrada
Tu programa debera leer del teclado los siguientes datos, la primera linea
contendra un numero N entre 1 y 1,000 que indica el numero de nodos del
arbol.
Cada una de las siguientes N lineas contiene 3 enteros, denotando 3 nodos,
donde el primer numero indica un nodo, el segundo y tercer numeros de la
linea indican el nodo izquierdo y derecho del nodo respectivamente.
Cada nodo esta numerado del 1 al N . Si hay un nodo que no tenga hijos,
entonces su hijo tendra el numero -1. El nodo raiz tiene el numero 1.
Salida
Tu programa debera escribir a la pantalla dos numeros en una linea sepa-
rados por un espacio, el primer numero indica el nivel con el ancho maximo,
mientras que el segundo numero indica el ancho del nivel. Si hay mas de un
nivel con el ancho maximo imprime el nivel de menor numero.
Ejemplo
Entrada
19
1 2 3
2 4 5
3 6 7
4 8 -1
5 9 10
6 11 12
7 13 -1
8 -1 -1
9 14 15
10 -1 -1
11 16 -1
12 -1 -1
13 17 -1
14 -1 -1
15 18 -1
16 -1 -1
17 -1 19
18 -1 -1
19 -1 -1

-- 183 of 315 --

184 CAPÍTULO 14. ÁRBOLES BINARIOS
Salida
19
1 2 3
2 4 5
3 6 7
4 8 -1
5 9 10
6 11 12
7 13 -1
8 -1 -1
9 14 15
10 -1 -1
11 16 -1
12 -1 -1
13 17 -1
14 -1 -1
15 18 -1
16 -1 -1
17 -1 19
18 -1 -1
19 -1 -1
Limites
N siempre estara entre 1 y 1,000
Referencias
Este problema apareció en el concurso VU atrankinis turas 2005 m. ACM
ICPC var?yboms
Posteriormente fue utilizado en los preselectivos 2004-2005, que fueron
organizados donde Cesar Arturo Cepeda García y Francisco Javier Zaragoza
Martínez se encargaron de elegir y traducir los problemas.

-- 184 of 315 --

14.8. PROBLEMAS 185
14.8.2. Cuenta Árboles
Tiempo Límite: 1 segundo
Problema
Escribe un programa que dado N , determine cuantos árboles binarios se
pueden formar con exactamente N nodos.
Entrada
Una línea con un único número: N .
Salida
La primera y única línea deberá contener un solo entero: el número de
árboles que se pueden formar mod 1000000.
Entrada de Ejemplo
3
Salida de Ejemplo
5
Consideraciones
1 ≤ N ≤ 1000
Referencias
Este es un problema clásico de combinatoria de conteo, esta redacción
fue utilizada por primera vez para un examen preselectivo de la Olimpiada
Mexicana de Informática a nales del 2005.

-- 185 of 315 --

186 CAPÍTULO 14. ÁRBOLES BINARIOS

-- 186 of 315 --

Cap´ıtulo 15
Montículos
Ya vimos en el capítulo anterior lo útiles que son los árboles binarios de
búsqueda, y que para la mayoría de conjuntos de datos los podemos usar
como si soportaran inserción y búsqueda de elementos en tiempo O(log N ).
Sin embargo, estamos conscientes de que eso no es suciente, ya que puede
suceder que para un conjunto de entradas en especíco tanto la inserción
como la búsqueda de un elemento tomen tiempo O(n) .
Dichos casos no son difíciles de encontrar. ½Basta con dar como entra-
da algo que ya esté ordenado!, cosa que no sería muy raro en la práctica
que sucediera. Incluso los árboles binarios de búsqueda pueden resultar muy
lentos si la entrada está casi ordenada.
En este capítulo nos vamos a concentrar en una estructura de datos que
resuelve parcialmente el problema: los montículos. El montículo es una es-
tructura de datos que soporta sólamente 3 operaciones: conocer el mayor
elemento que tiene guardado, agregar un nuevo elemento y eliminar el mayor
elemento.
Puede sonar limitante el hecho de que no se puede saber si un elemento
está o no está dentro de los datos guardados y muchas veces sí lo es, pero
hay algunos problemas donde lo único que se requiere es saber cuál es el
elemento mayor, o en otras ocaciones se requiere conocer el menor; por tanto
los montículos a veces funcionan mejor que los árboles binarios de búsqueda
pero no constituyen un reemplazo.
15.1. ¾Qué son los Montículos?
Los montículos también son árboles binarios, pero no son árboles binarios
de búsqueda.
187

-- 187 of 315 --

188 CAPÍTULO 15. MONTÍCULOS
Para poder explicar de manera precisa lo que son los montículos debemos
denir otra cosa, la cual llamaremos posición horizontal de un nodo, super-
cialmente hablando la posición horizontal de un nodo es cuántos nodos de
su mismo nivel(misma distancia a la raíz) se pueden dibujar a la izquierda
de él.
Como en el primer nivel hay un solo nodo, que es la raíz, diremos que su
posición horizontal es 0. Si la posición horizontal de un hijo izquierdo es k la
posición horizontal del hijo derecho claramente debe de ser k + 1.
Además si la posición horizontal de un nodo es p signica que hay p nodos
a su izquierda, por lo cual se van a dibujar 2p nodos a la izquierda de sus
hijos y por ende la posición horizontal de sus hijos es 2p y 2p + 1.
Con esto ya tenemos sucientes elementos para denir la posición hori-
zontal de un nodo:
Denición 15.1.1 (Posicion Horizontal). La posición horizontal en un árbol
A es una función p : A → Z tal que para cada vértice v ∈ A:
Si v es la raíz entonces p(v) = 0.
Si v es un hijo izquierdo y w es su padre entonces p(v) = 2p(w)
Si v es un hijo derecho y w es su padre entonces p(v) = 2p(w) + 1.
Volviendo al tema de los montículos, la idea de un montículo es que cada
nodo tiene una clave mayor a la de cualquiera de sus hijos y además son
árboles muy equilibrados, de manera que todos los niveles del árbol están
llenos excepto tal vez el último. Y el último nivel tiene la característica de
que todos sus nodos estan lo mas a la izquierda posible.
Dicho de una manera mas precisa:
Denición 15.1.2 (Montículo). Un montículo A es un árbol binario que
cumple con las siguientes propiedades:
La clave de todo nodo v ∈ A es mayor o igual que la clave de cualquiera
de sus hijos.
Para todo entero no negativo n se cumple una de estas dos propiedades:
el número de nodos que estan a distancia n de la raiz es exactamente
2n ó no hay nodos cuya distancia a la raíz sea mayor que n.
Para cualquier nodo v, si su posición horizontal es p entonces existen
al menos p + 1 nodos que se encuentran en el mismo nivel que v.

-- 188 of 315 --

15.2. REPRESENTACIÓN EN MEMORIA 189
8
5
3 2
1
Figura 15.1: Dibujo de un montículo
La primera condición para que un árbol binario sea considerado montículo
tiene el propósito de que la raíz tenga siempre la mayor clave.
El propósito de la segunda propiedad es que sea un árbol completamente
equilibrado.
Y la tercera propiedad simplemente es una manera formal de decir que
los nodos del último nivel se encuentran lo mas a la izquierda posible.
La gura 15.1 muestra un dibujo de un montículo, como se puede observar,
aunque la clave de cada nodo es mayor o igual que las claves de sus hijos,
puede darse el caso de que un nodo de un nivel inferior tenga mayor clave
que un nodo de un nivel superior.
Como el lector puede imaginar, la propiedad de ser un árbol muy equi-
librado es lo que garantiza eciencia en un montículo, sin embargo aún no
hemos visto cómo implementar el montículo ni tampoco cómo implementar
las operaciones de quitar el mayor elemento e insertar un nuevo elemento.
La buena noticia es que estas implementaciones son mas simples de lo
que se esperan.
15.2. Representación en Memoria
Podríamos vernos tentados a implementar un montículo de la misma man-
era que cualquier otro árbol binario, pero las 2 últimas condiciones que debe
cumplir un árbol binario para ser montículo nos serán de especial utilidad.
La idea es guardar las claves de los nodos en un arreglo de manera que
primero aparezcan las claves que estan mas arriba y luego aparezcan las claves
que estan mas abajo, y además las claves del mismo nivel esten ordenadas
de izquierda a derecha.
Por ejemplo, el montículo de la gura 15.1 se puede representar como
(8, 5, 1, 3, 2). Una ventaja de dicha representación es que no se requiere memo-
ria para guardar los enlances de hijo izquierdo e hijo derecho.

-- 189 of 315 --

190 CAPÍTULO 15. MONTÍCULOS
0
1
3 4
2
5 6
Figura 15.2: Índices de Montículo que corresponden a cada nodo
La gura 15.2 muestra los índices de montículo de cada nodo cuando se
tiene un montículo de 7 elementos.
Nuestro propósito será ahora entender cómo se relaciona esta representación
esbozada con la estructura del árbol.
Si un montículo tiene n + 1 niveles, por el teorema 20 entonces hay un
total de 2n+1 − 1 nodos en los primeros n niveles, por lo que dichos 2n+1 − 1
nodos aparecerán primero en el arreglo, el resto de los nodos todos estan en
un mismo nivel, y están ordenados de izquierda a derecha, es decir, por su
posición horizontal.
Así que vamos a denir la posición en el arreglo de la siguiente manera:
Denición 15.2.1 (Índice de Montículo). Sea A un árbol binario, sea v ∈ A
un nodo cualquiera, sea d su distancia a la raíz, y h su posición horizontal.
Entonces el índice de montículo de v es 2d − 1 + h.
Puede parecer extraño que esta propiedad de índice de montículo se haya
denido para cualquier árbol binario y no sólo para los montículos, existen
varios motivos, uno es que resulta útil para implementar cualquier árbol
binario que se sabe de antemano que está equilibrado, el otro lo revisaremos
al ver cómo realizar operaciones en un montículo.
Como ya vimos, el índice de montículo corresponde a la posición del ar-
reglo en el cual está ubicado un nodo, sabiendo eso es obvio que un montículo
con n nodos va a requerir exactamente n posiciones del arreglo sin que haya
huecos. O dicho de otra manera:
Teorema 21. Sea A un montículo, y n el número de nodos de A, tenemos
que para todo v ∈ A, el índice del montículo de v es menor que n y no hay
dos nodos con el mismo índice de montículo; es decir, hay una biyección entre
los nodos y los índices de montículo menores que n.

-- 190 of 315 --

15.2. REPRESENTACIÓN EN MEMORIA 191
El teorema anterior sólo nos dice qué un índice de montículo identica de
manera única cada uno de los nodos, sin embargo, probablemente necesitare-
mos saber dado el índice de montículo de un nodo, cuáles son los índices de
montículo de su padre y sus hijos.
El siguiente teorema nos da una respuesta increíblemente sencilla a la
pregunta anterior:
Teorema 22. Sea A un montículo, y v el índice de un nodo que tiene dos
hijos y un padre, entonces se cumple lo siguiente:
El índice de montículo de los hijos es 2v + 1 y 2v + 2 para hijo izquierdo
y derecho respectivamente.
El índice de montículo de el padre es bv−1
2 c.
Demostración. Sea h la posición horizontal del nodo que tiene índice de mon-
tículo v y sea k su distancia a la raíz. tal que 2k − 1 + h = v, tenemos que su
hijo izquierdo tendrá una posición horizontal de 2h y estará a distancia k + 1
de la raíz, por lo tanto la posición horizontal del hijo izquierdo es 2k+1 −1+2h
y notamos que esto es igual a 2(2k − 1 + h) + 1.
Dado que la posición horizontal del hijo derecho es igual a la posición
horizontal del hijo izquierdo más uno, tenemos que el índice de montículo del
hijo derecho es 2v + 1 + 1 = 2v + 2.
Sea m el índice de montículo de un nodo que no es la raíz y sea p el índice
de montículo de su padre, tenemos que m = 2p + 1 o bien m = 2p + 2, en
ambos casos p = bm−1
2 c.
Con esta información ya podemos movernos libremente en el árbol usando
solamente los índices del montículo. Y para guardar un montículo en memoria
solamente necesitaremos un arreglo y una variable.
1 int Monticulo [TAMAÑO_MAXIMO] ;
2 int N=0;
Aquí el arreglo Monticulo guarda las claves de los nodos correspondientes
a cada índice de montículo y N guarda el número de nodos del montículo.
No está por demás mencionar que un montículo puede guardar cualquier
conjunto con un órden total, no es necesario que sea de tipo int.
Sin embargo, esta implementación nos resultará inútil hasta averigüar
como insertar y borrar elementos.

-- 191 of 315 --

192 CAPÍTULO 15. MONTÍCULOS
15.3. Inserción
Para insertar un elemento en el montículo es necesario que temporalmente
este árbol binario deje de ser montículo.
La idea es colocar la clave del nuevo elemento en el primer lugar disponible(de
izquierda a derecha) del último nivel, y si el último nivel está lleno, colocar
la clave del nuevo elemento en el primer nodo de un nuevo nivel.
Esto se puede hacer simplemente colocando la clave en Monticulo[N] y
posteriormente incrementando N, una vez hecho esto, nuestro árbol binario
podría dejar temporalmente de ser montículo.
A continuación hay que intercambiar la clave que se acaba de insertar con
la clave del padre y repetir esta operación hasta que el árbol binario vuelva a
ser montículo, es decir, hay que subir la clave insertada mientras se encuentre
en un nodo cuyo su padre tenga una clave menor.
Este algoritmo se puede implementar con el siguiente código:
1 void i n s e r t a r ( int Monticulo [ ] , int c l a v e ) {
2 int i , k ;
3 i=N++;
4 Monticulo [ i ]= c l a v e ;
5 while ( i >0 && Monticulo [ ( i −1)/2] < Monticulo [ i ] ) {
6 k=Monticulo [ ( i −1) / 2 ] ;
7 Monticulo [ ( i −1)/2]= Monticulo [ i ] ;
8 Monticulo [ i ]=k ;
9 i =( i −1) / 2 ;
10 }
11 }
15.4. Eliminación
Como se había dicho anteriormente, no se puede eliminar cualquier ele-
mento del montículo, sino que en lugar de eso solamente se puede eliminar
el mayor elemento.
Para eliminar la mayor clave se puede seguir un procedimiento parecido a
insertar una nueva; la idea es quitar la clave que esté en la raíz, luego mover
la clave que esté hasta el nal del montículo(último nivel lo más a la derecha
posible) colocándola en la raíz. Y nalmente intercambiar esta clave con la
clave del mayor de los hijos del nodo donde se encuentre hasta que la clave
sea mayor que las claves de todos los hijos.
Al igual que la inserción, la eliminación también es un procedimiento muy
sencillo de implementar:

-- 192 of 315 --

15.4. ELIMINACIÓN 193
1 int q u i t a r ( int Monticulo [ ] ) {
2 int i , k , r ;
3 r=Monticulo [ 0 ] ;
4 N−−;
5 Monticulo [ 0 ] = Monticulo [N ] ;
6 i =0;
7 while (2∗ i +1<N) {
8 i f (2∗ i +2<N && Monticulo [ 2 ∗ i +2]> Monticulo [ 2 ∗ i
+1]) {
9 k=2∗ i +2;
10 } e l s e {
11 k=2∗ i +1;
12 }
13 i f ( Monticulo [ k]> Monticulo [ i ] ) {
14 i=k ;
15 k=Monticulo [ ( i −1) / 2 ] ;
16 Monticulo [ ( i −1)/2]= Monticulo [ i ] ;
17 Monticulo [ i ]=k ;
18 } e l s e {
19 break ;
20 }
21 }
22 return r ;
23 }

-- 193 of 315 --

194 CAPÍTULO 15. MONTÍCULOS

-- 194 of 315 --

Cap´ıtulo 16
Grafos
Muchos problemas, nos presentan algun conjunto, en el cual algunos pares
de elementos de dicho conjunto se relacionan entre sí. Ese tipo de problemas
son muy estudiados en la teoría de grácas o teoría de grafos.
Estrictamente hablando, estas estructuras se llaman grácas, sin embargo
la palabra puede generar confusión con la gráca de una función. Por tal
motivo en este libro nos referiremos a estas estructuras como grafos.
El primer ejemplo de grafos se utilizará en algo no muy relacionado con
la programación, esto se hace para evitar que el lector se vea tentado a
confundir el concepto de grafo con el de la implementación de un grafo; pues
hay problemas donde es necesario utilizar grafos en el razonamiento y no en
la implementación.
Problema Resuelto 16.0.1. En una reunión hay n invitados, se asume que
si un invitado a conoce a un invitado b, b tambien conoce a a, demuestra que
en la reunión hay al menos 2 invitados que conocen al mismo número de
invitados. Asúmase tambien que todos conocen por lo menos a alguien de la
reunión.
Solución En el ejemplo anterior, tenemos un conjunto de n personas, y
como vemos, algunos pares de personas se conocen entre sí.
Para resolver este tipo de problemas es muy útil usar grafos, tambien
llamados gracas por algunos, sin embargo, aquí se utilizará el término
grafo, para evitar que se confunda con el concepto de la gráca de una
función.
Una forma un tanto pobre de denir un grafo(poco después trataremos
la denición formal) es:
Denición 16.0.1 (Denición Provisional de Grafo). Conjunto de puntos
195

-- 195 of 315 --

196 CAPÍTULO 16. GRAFOS
1
2	3
4 5
6
Figura 16.1: Dibujo de un grafo
llamados vértices, en el cual algunos vertices pueden estar unidos por líneas
llamadas aristas
Volviendo al ejemplo, es posible dibujar un punto por cada persona de la
reunión, y entre cada par de personas que se conozca entre sí, colocar una
línea.
Por ejemplo si 6 conoce a 4, 4 conoce a 5, 5 conoce a 1, 5 conoce a 2, 2
conoce a 1, 3 conoce a 2 y 4 conoce a 3, se podría dibujar un grafo similar al
de la gura 16
Ahora, una vez que tenemos visualizada de cierta manera la solución,
podemos ver que cada nodo puede estar conectado con al menos otro no-
do(cada invitado conoce por lo menos a otro invitado) y a lo mas n − 1
nodos.
Es decir, el número de conocidos de cada persona va desde 1 hasta n − 1.
Como cada persona puede tener n − 1 números distintos de conocidos y hay
n personas, por principio de las casillas al menos dos personas deberán tener
el mismo número de conocidos.

16.1. ¾Qué son los grafos?
Por si alguien no leyó la solución del ejemplo. Hay que mencionar que un
grafo puede imaginarse como un conjunto de puntos llamados vértices, en el
cual algunos vertices pueden estar unidos por líneas llamadas aristas.
Los grafos son muy útiles en problemas que involucran estructuras tales
como carreteras, circuitos electricos, tuberías de agua y redes entre otras

-- 196 of 315 --

16.1. ¾QUÉ SON LOS GRAFOS? 197
A B
C	D
A
D
C	B
Figura 16.2: Dos dibujos de un mismo grafo conocido como K4
cosas, y como lo acabamos de ver, con los grafos incluso se pueden representar
las relaciones en una sociedad.
Si eres observador, tal vez ya te diste cuenta que tanto las listas enlazadas
como los árboles son grafos.
Hay que hacer notar que no importa cómo se dibujen los grafos, si las
aristas estan curvas o rectas, o si los vertices estan en diferente posición no
es relevante, lo unico que importa qué pares de vertices estan unidos.
Por ejemplo, la gura 16.1 muestra dos maneras distintas de dibujar un
mismo grafo.
Es decir, un grafo, mas que un conjunto de puntos unidos por líneas, es
un conjunto de objetos en el cual algunos pares de estos se relacionan entre
sí, mas formalmente:
Denición 16.1.1 (Grafo). Par ordenado G = (V, A), donde los elementos
de V son llamados vertices, y A es un conjunto de pares no ordenados de
vértices llamadas aristas.
Aunque hay quienes se dedican a investigar grafos innitos, en este libro
nos dedicaremos exclusivamente a grafos nitos.
De esa forma, el grafo que se dibuja arriba se puede expresar como: