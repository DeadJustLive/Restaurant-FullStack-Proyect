# 2. Seleccionar un método para resolver las colisiones.

El método puede consistir en situar los pares que colisionan sobre una misma entrada primaria en una zona de
desbordamiento, consistente en una estructura de datos dinámica (una lista enlazada, por ejemplo) guardando la
dirección del primer par en la componente del vector soporte correspondiente a esa entrada primaria. Esta técnica
recibe el nombre de resolución de colisiones por encadenamiento (en algunos libros denominada dispersión
abierta).
Por el contrario, la recolocación en el mismo vector soporte consiste en almacenar los pares que colisionan en
otras posiciones del vector diferentes a la entrada primaria. En este caso, se precisa determinar un algoritmo de
recolocación que calcule sucesivas entradas secundarias para una clave, hasta encontrar un lugar libre en el
vector. En algunos libros se denomina dispersión cerrada a esta solución, en otros, direccionamiento abierto.
3.1. Diseño de la función de dispersión
Veamos más en detalle el primero de los pasos. Las características fundamentales que debe tener una función de
dispersión son:
• 	la capacidad de distribuir las claves de la forma más uniforme posible sobre el rango 1..max, y
• 	la posibilidad de ser evaluada eficientemente (es decir, debe consistir en la aplicación de unas pocas operaciones
aritméticas sencillas).
Para claves de tipo natural, z, una función de dispersión muy utilizada y sencilla, y que distribuye bastante bien las
claves se denomina método de la división o método del módulo.
h(z) = z mod max
En este caso, los índices del vector en el que se almacena la tabla o diccionario son: 0..max–1.
Es habitual elegir un número primo para el valor max.
En ocasiones, este método puede distribuir mal las claves. Por ejemplo, si max = 10 y casi todas las claves acaban en
el mismo dígito.
Otra alternativa para definir una función de dispersión sencilla para números naturales, y de uso frecuente, se basa en
el método del centro del cuadrado. Consiste en elevar el número al cuadrado y extraer unos cuantos dígitos de la parte
central del número resultante.
h(z) = “los 	log 2 (max) 	bits centrales de z2 ”
Por ejemplo, si max = 100 y la clave natural, z, tiene 5 dígitos, su cuadrado tiene 10 (ó 9) dígitos y (z2 / 105 ) mod 100
es el entero formado por los dos dígitos centrales del cuadrado de z, y por tanto está comprendido entre 0 y 99.

-- 188 of 267 --

181
Si las claves son de tipo cadena de caracteres, la función de dispersión h debe en primer lugar transformarlas en
un número natural, y después aplicar alguna de las soluciones conocidas para claves naturales (método de la división,
método del centro del cuadrado…).
Un primer método, el más sencillo y eficiente, para transformar una cadena en un natural es el de la suma de los
ordinales. Es decir, dada la cadena c = c[1..n] de n caracteres, calcular ord(c[1]) + ord(c[2]) + … + ord(c[n]), donde la
función “ord” devuelve el ordinal de un carácter en el código de caracteres utilizado (ASCII, por ejemplo).
En ocasiones, ese método sencillo combinado con el método de la división puede dar resultados de distribución de las
claves muy pobres. Por ejemplo, si max es demasiado grande, max = 10007 y todas las cadenas tienen 8 caracteres, o menos,
sólo se utilizarían un máximo de 2048 posiciones del vector (256 posibles*8 = 2048). O, por ejemplo, si max = 100 y las
claves son las cadenas “A0”, “A1”, …, “A99”, es fácil verificar que la función h, basada en la suma de los ordinales y en
el método de la división, intentaría colocar las 100 claves en tan sólo 29 componentes del vector (por ejemplo, las 9 claves
“A18”, “A27”, “A36”, …, “A90” tendrían la misma entrada primaria).
Una alternativa muy utilizada al método de la suma de los ordinales es la de la suma ponderada. Consiste en tratar la
cadena de caracteres como si fuera un entero en base 256 (si éste es el número de caracteres del código) al realizar la suma
en la función h (ejemplo: a la cadena “abcd” le correspondería ord('a') + ord('b')*256 + ord('c')*256 2 + ord('d')*256 3
).
Es decir, el método de la suma ponderada, combinado con el de la división, se implementaría con la siguiente
función:
constantes cardinalCódigo = 256 {código ASCII extendido, con 256 valores posibles}
max = ... 	{El tamaño del vector con el que implementar la tabla dispersa}
función h(c:cadena) devuelve 0..max-1
variables i,suma,factor:entero
principio
suma:=0; {Para calcular la suma ponderada explicada anteriormente}
factor:=1; {Valor inicial de factor = cardinalCódigo elevado a 0 = 1}
para i:=1 hasta long(c) hacer
suma:=suma + ord(c[i])*factor;
factor:=factor*cardinalCódigo {factor = cardinalCódigo elevado a i}
fpara;
devuelve (suma mod max) {Método de la división}
fin
El problema de este método es que el valor de la variable suma puede hacerse muy grande. Si las claves sólo se
componen de letras, puede tratarse la cadena de caracteres como un entero en base 26 (número de letras del alfabeto inglés).
Otra posibilidad es descomponer la clave en subcadenas más pequeñas (por ejemplo, de 4 caracteres), calcular el entero
correspondiente a cada subcadena, sumar los enteros resultantes y, finalmente, aplicar el método de la división.
Una discusión detallada sobre estos y otros métodos para el diseño de una buena función de dispersión puede
encontrarse en el volumen III de la enciclopédica obra de Donald E. Knuth, El arte de programar ordenadores (editorial
Reverté, 1987). También puede consultarse el capítulo 9 del libro Handbook of Data Structures and Applications, de D.P.
Mehta y S. Sahni (editorial Chapman & Hall/CRC, 2005).
3.2. Métodos de resolución de colisiones
La resolución de colisiones por encadenamiento (o dispersión abierta) consiste en que todos los pares a cuya clave
es asignada por la función de dispersión una misma entrada primaria se almacenan en una lista enlazada mediante punteros.
La dirección del primer elemento de la lista se guarda en la componente del vector correspondiente a la entrada primaria.
La zona de memoria (dinámica) en la que se almacenan las listas enlazadas se llama zona de desbordamientos.
A continuación, se incluye un módulo de implementación de una tabla dispersa genérica (de pares <clave,valor>) con
resolución de colisiones por encadenamiento.

-- 189 of 267 --

182
h : Dominio de las claves  0..max-1
módulo tablasDispersas
parámetros
tipos clave,valor
exporta
tipo diccionario {El TAD diccionario habitual, para parejas <clave,valor>}
procedimiento crearVacío(sal t:diccionario)
{Devuelve un diccionario (o tabla) vacío}
procedimiento añadir(e/s t:diccionario; ent c:clave; ent v:valor)
{Devuelve la tabla resultante de añadir el par (c,v) a t;
si en t ya había un par (c,v’), entonces lo sustituye por el par (c,v)}
procedimiento buscar(ent t:diccionario; ent c:clave;
sal está:booleano; sal v:valor)
{está? y obtenerValor se implementan en una única operación}
procedimiento borrar(e/s t:diccionario; ent c:clave)
{Dada una clave c, la borra de la tabla junto con su valor;
si c no estaba en t, t se queda igual}
implementación {tabla dispersa con resolución de colisiones por encadenamiento}
constante max = 997 {por ejemplo (un primo cercano a 1000)}
tipos ptNodo = ↑nodo;
nodo = registro
laClave:clave;
elValor:valor;
sig:ptNodo
freg;
diccionario = vector[0..max-1] de ptNodo
función h(valor c:clave) devuelve 0..max-1
{Función de dispersión que distribuye uniformemente el
dominio de las claves en el subrango 0..max-1.}
... {Implementación de alguna de las funciones de dispersión descritas antes}
procedimiento crearVacío(sal t:diccionario)
variable i:0..max-1
principio
para i:=0 hasta max-1 hacer
t[i]:=nil
fpara
fin
procedimiento añadir(e/s t:diccionario; ent c:clave; ent v:valor)
variables aux:ptNodo;
entrada:0..max-1
principio
entrada:=h(c);
si t[entrada]=nil entonces
nuevoDato(t[entrada]);
aux:=t[entrada];
aux↑.laClave:=c;
aux↑.elValor:=v;
0
1
max-1
.
.
.

-- 190 of 267 --

183
aux↑.sig:=nil
sino
aux:=t[entrada];
mientrasQue (aux↑.laClave≠c) and (aux↑.sig≠nil) hacer
aux:=aux↑.sig
fmq;
si aux↑.laClave=c entonces
aux↑.elValor:=v
sino
nuevoDato(aux↑.sig);
aux:=aux↑.sig;
aux↑.laClave:=c;
aux↑.elValor:=v;
aux↑.sig:=nil
fsi
fsi
fin
procedimiento buscar(ent t:diccionario; ent c:clave;
sal está:booleano; sal v:valor)
variable aux:ptNodo
principio
aux:=t[h(c)];
si aux=nil entonces
está:=falso
sino {buscar en la zona de desbordamiento (lista no ordenada)}
mientrasQue (aux↑.laClave≠c) and (aux↑.sig≠nil) hacer
aux:=aux↑.sig
fmq;
si aux↑.laClave=c entonces
está:=verdad;
v:=aux↑.elValor
sino
está:=falso
fsi
fsi
fin
procedimiento borrar(e/s t:diccionario; ent c:clave)
variables entrada:0..max-1;
aux,sigAux:ptNodo;
borrado:booleano
principio
entrada:=h(c);
aux:=t[entrada];
si aux≠nil entonces {lista no vacía}
si aux↑.laClave=c entonces {borrar el primero}
t[entrada]:=aux↑.sig;
disponer(aux)
sino {borrar otro o ninguno}
borrado:=falso;
mientrasQue (aux↑.sig≠nil) and not borrado hacer
si aux↑.sig↑.laClave=c entonces
sigAux:=aux↑.sig;
aux↑.sig:=sigAux↑.sig;
disponer(sigAux);
borrado:=verdad
sino
aux:=aux↑.sig
fsi
fmq
fsi
fsi
fin
fin {del módulo}

-- 191 of 267 --

184
El factor de carga de la tabla se define como α = N / max, donde N es el número de pares almacenados en la tabla o
diccionario y max es la capacidad del vector. Si el factor de carga es pequeño la resolución de colisiones por encadenamiento
es bastante rápida puesto que las listas de desbordamientos son cortas.
Volviendo a la paradoja del cumpleaños, si hay 365 personas en una habitación es muy probable que haya muchas
parejas con el mismo cumpleaños, pero el número medio de personas con un cierto cumpleaños es sólo 1 (asumiendo que
los cumpleaños se distribuyen uniformemente en los 365 días del año).
En general, si la tabla tiene dimensión max y hay N pares <clave,valor> almacenados, y la función de dispersión es
uniforme, la longitud media de cada lista es α = N / max. En el libro de Donald Knuth mencionado en la sección anterior
se presenta la siguiente fórmula del número medio de comparaciones de claves que se realizan en una operación de
búsqueda:
1
1
N N
C 	e
max 	max
 		
	 			 	 	 	 	 		 		 		 	 , 	si la búsqueda no tiene éxito
1 	1
1 	1
2 * 	2
N
C max 

 	 	 	 	, 	si la búsqueda tiene éxito
Como puede verse, el coste promedio en tiempo de una búsqueda es del orden del factor de carga de la tabla (tenga o
no tenga éxito la búsqueda), y por tanto, si el tamaño del vector, max, es del mismo orden de magnitud que el número de
claves, N, entonces el factor de carga es de orden constante y también el coste promedio de la búsqueda.
Es decir, si la función de dispersión distribuye uniformemente (caso “ideal”) y el número de claves es similar al
tamaño del vector, el coste promedio de una búsqueda de clave es de orden constante. Lógicamente, en la práctica, la
función de dispersión no es “perfecta” y no distribuye del todo uniformemente, y eso puede empeorar el coste promedio.
La resolución de colisiones por recolocación en el mismo vector soporte (también conocida en algunos libros como
dispersión cerrada, y en otros como direccionamiento abierto) consiste en almacenar los pares <clave,valor> cuya
entrada primaria ya está ocupada en otra posición secundaria (libre) del vector. Para eso, se precisa implementar una función
de recolocación que llamaremos hh.
Evidentemente, con esta representación, el factor de carga debe mantenerse siempre por debajo de 1, α = N / max ≤ 1,
puesto que sólo se dispone de las max componentes del vector para almacenar los datos.
Un inconveniente común a todos los métodos de recolocación de este tipo es que los pares recolocados ocupan
posiciones de otras futuras claves, y las colisiones tienden a “arracimarse” o amontonarse. A pesar de este problema, como
veremos, el funcionamiento suele ser bueno, en la práctica, si el factor de carga se mantiene por debajo de 0’9.
La representación de la tabla en este caso se limita a:
constante max = 997 {por ejemplo (un primo cercano a 1000)}
tipos componente = registro
libre:booleano;
laClave:clave; {el tipo tiene implementadas las funciones de
dispersión, h, y recolocación, hh}
elValor:valor
freg;
diccionario = vector[0..max-1] de componente
Como ejemplo, el algoritmo de búsqueda del valor de una clave es el siguiente, en una primera aproximación:
procedimiento buscar(ent t:diccionario; ent c:clave; sal está:booleano; sal v:valor)
variables primaria,secundaria:0..max-1;
i:1..max
principio
primaria:=h(c); {uso de la función de dispersión}
si t[primaria].libre entonces
está:=falso
sino
si t[primaria].laClave=c entonces

-- 192 of 267 --

185
está:=verdad;
v:=t[primaria].elValor
sino {t[primaria].laClave
≠c}
i:=1; {contador de intentos de recolocación}
secundaria:=(primaria + hh(i)) mod max; {uso de la función de recolocación}
mientrasQue (not t[secundaria].libre) and (t[secundaria].laClave≠c) hacer (*)
i:=i+1;
secundaria:=(primaria + hh(i)) mod max
fmq;
si t[secundaria].libre entonces
está:=falso
sino
está:=verdad;
v:=t[secundaria].elValor
fsi
fsi
fsi
fin
(*) Ojo, esta implementación no evita posibles ciclos infinitos. Una implementación detallada debería tenerlo en cuenta.
En el algoritmo anterior, hh es la función de recolocación. La solución más sencilla para esta función es tomar
hh(i)=i, y recibe el nombre de recolocación lineal. Con esa función, se genera una secuencia de entradas secundarias
para una determinada clave, hasta encontrar una posición libre del vector o encontrar la clave.
Si α = N / max es el factor de carga de la tabla (es decir, N = número de pares <clave,valor> almacenados), puede
demostrarse que el número medio de intentos (o comparaciones) hasta encontrar, con una recolocación lineal, la clave
buscada es:
1 	2
1
C 


 
En la tabla siguiente se presentan algunos valores de C en función de α. Puede observarse que los resultados son muy
buenos, independientemente del valor de N, siempre que α sea inferior a 0.75.
α 	0,1 	0,25 	0,5 	0,75 	0,9 	0,95
C 	1,06 	1,17 	1,50 	2,50 	5,50 	10,50
El problema fundamental de la recolocación lineal es que los elementos almacenados tienden a “amontonarse”
alrededor de las entradas primarias, y este hecho empeora la eficiencia promedio de las operaciones posteriores de búsqueda
o modificación.
La solución ideal sería escoger una función de recolocación, hh, que, de nuevo, distribuyese uniformemente las claves
en las posiciones libres restantes. En la práctica, construir esa función sería costoso y son preferibles otros métodos más
sencillos. Un método comúnmente utilizado es tomar hh como una función cuadrática:
hh(i) = i*i
Nótese que hay un método eficiente del cálculo de los sucesivos valores de la función anterior basado en su definición
recursiva:
hh(i+1) = hh(i) + 2*i + 1
hh(0) = 0
y en que la función
d(i) = 2*i +1
también admite una definición recursiva:

-- 193 of 267 --

186
d(i+1) = d(i) + 2
d(0) = 1
El uso de la función de recolocación cuadrática evita el amontonamiento alrededor de las entradas principales. El
principal problema es que no permite acceder a todos los índices del vector, pudiéndose dar el caso de que existan huecos
libres y sin embargo no se encuentre ninguno para almacenar un nuevo par. No obstante, puede demostrarse que, si se
elige max como un número primo, la función cuadrática de recolocación permite acceder al menos a la mitad de las
posiciones del vector, desde cualquier entrada primaria. Esto resuelve el problema puesto que, si el factor de carga no es
muy grande, es muy raro (poco frecuente) que se presenten max/2 colisiones consecutivas.
Puede demostrarse que, si se usara una función de recolocación perfectamente uniforme en las componentes vacías
(caso “ideal”) el número medio de comparaciones para realizar una búsqueda sería:
1 ln(1 	)	C 	


 	
La tabla siguiente recoge algunos valores de C según el valor de α:
α 	0,1 	0,25 	0,5 	0,75 	0,9 	0,95 	0,99
C 	1,05 	1,15 	1,39 	2,85 	2,56 	3,15 	4,66
Aunque la función cuadrática da unos resultados ligeramente peores a los de esta tabla, existen otros métodos que se
aproximan bastante bien a la recolocación uniforme (consúltese la bibliografía ya citada sobre tablas dispersas).
Un problema adicional de las técnicas de recolocación en el mismo vector soporte es la implementación de la
operación de borrado de un par. Para ello hay que sustituir el campo booleano libre por otro que pueda tomar tres valores
distintos: libre, ocupado y borrado. Así, borrar un elemento supone dar el valor borrado al campo correspondiente.
Si se está realizando una búsqueda, las componentes “borradas” han de ser tratadas como si estuviesen “ocupadas” y con
una clave distinta a la buscada. En la operación de inserción de un nuevo elemento, se pueden aprovechar las componentes
“borradas” para realizar el almacenamiento, tratándolas como si estuviesen vacías, pero teniendo en cuenta de no dejar
claves duplicadas (apariciones previas de la clave localizadas en posiciones posteriores en la cadena de recolocaciones).
Y otro problema común a cualquier representación de tablas dispersas, es que se trata de una estructura de datos pensada
para accesos individuales por clave, pero no resulta fácil (implementable de forma eficiente) realizar un recorrido de
datos que visite las claves por orden creciente de su valor (iterador que recorra las claves por orden). El diseño de un
iterador requerirá un recorrido secuencial de todas las componentes del vector, para visitar las posiciones ocupadas,
obteniendo así un recorrido en el que las claves no se obtienen ordenadas, o bien duplicar la memoria en una estructura
de datos auxiliar y ordenada por valores crecientes de las claves, solamente para realizar el recorrido (ineficiente en tiempo
y en espacio).
Como recomendaciones finales sobre la elección de una implementación u otra para el TAD diccionario o tabla, puede
concluirse lo siguiente:
• 	Si no es posible estimar a priori un valor máximo de N (número de elementos almacenados en la tabla) o este
valor puede ser muy grande, la representación basada en árboles de búsqueda equilibrados, o árboles
lexicográficos (si el dominio de las claves es una secuencia de símbolos), es la mejor pues, al menos, garantiza un
coste de las operaciones en O(log N) en el caso peor.
• 	Si se tiene una estimación a priori del valor de N y no es muy grande, una tabla dispersa supone la mejor
solución pues el coste de las operaciones es prácticamente, en promedio, constante; en cualquier caso, conviene
sobredimensionar el vector soporte con entre un 10% y un 25% más de componentes que N.
• 	Si se utilizan tablas dispersas y van a ser frecuentes las operaciones de borrado, la resolución de colisiones por
encadenamiento será preferible a la recolocación en el mismo vector soporte.

-- 194 of 267 --

187
• 	Si se ha optado por una tabla dispersa, el coste de las operaciones se mantiene bajo si el factor de carga, α = N /
max, es pequeño. Si esto no ocurre, es decir, si se llena demasiado la tabla (si N ≥ 2*max en el caso de resolución
de colisiones por encadenamiento, o si N ≥ 0.9*max en el caso de recolocación en el mismo vector soporte) se
puede optar por la técnica de redispersión (rehashing, en inglés), que consiste en mover todos los datos a una
nueva tabla (vector) de, por ejemplo, doble capacidad, lógicamente re-implementando una nueva función de
dispersión, h, para calcular las nuevas entradas primarias en el nuevo vector.
• 	Si lo más frecuente es necesitar un recorrido ordenado por clave de todos los datos, una tabla dispersa no es
una buena solución.

-- 195 of 267 --

188

-- 196 of 267 --

189