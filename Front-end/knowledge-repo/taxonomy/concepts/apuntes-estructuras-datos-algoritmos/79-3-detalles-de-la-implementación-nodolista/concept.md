# 3. Detalles de la implementación nodo–lista

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 79)

## Contenido
# 3. Detalles de la implementación nodo–lista

Como dijimos, la representación nodo–lista se corresponde con la representación primogénito–siguiente hermano de
un árbol n–ario. Esta representación permite un bajo coste en espacio, puesto que sólo se almacenan los caracteres o
símbolos estrictamente necesarios (además de un par de punteros por símbolo), pero requiere un mayor tiempo para acceder
a los hijos de un nodo interno, pues obliga a recorrer la lista de nodos hijos.
Las declaraciones de tipos de datos necesarias para implementar un árbol lexicográfico que contenga un conjunto de
cadenas de caracteres mediante la representación nodo–lista son las siguientes:
tipos trie = ↑nodo;
nodo = registro
dato:carácter; {usaremos ‘$’ como carácter terminador de cada cadena}
primogenito,sigHermano:trie
freg
al 	asa 	de 	doy 	el 	la 	le 	lo mas me mi no
a
l 	s
d
e 	o
y
e 	l
a 	e 	o
m
a 	e 	i
n
o
$ 	a 	$
$
$ 	$ 	$ 	s 	$ 	$ 	$
l
$
$ 	$
l
e
$	a 	o
$ 	$
m
e
$	a
s
$
i
$
n
o
$
d
e
$
e
l
$
o
y
$
a
s
a
$
l
$
al 	asa 	de 	doy 	el 	la 	le 	lo 	mas me mi 	no

-- 171 of 267 --

164
Evidentemente, si se pretendiese almacenar un diccionario genérico, sería preciso definir el tipo de los símbolos que
componen las claves (por ejemplo, caracteres), a partir de ellos el tipo de las claves como secuencias de símbolos (por
ejemplo, cadenas de caracteres), y el tipo de los valores asociados a las claves. Además, habría que incluir en el tipo nodo
un campo que indicase si se trata de nodo interno u hoja, en los nodos internos se guardaría un símbolo (por ejemplo, un
carácter) y en las hojas se almacenarían los valores asociados a las correspondientes claves (secuencias de símbolos).
A continuación, presentamos una implementación de las operaciones básicas para crear un trie vacío, insertar una
palabra en un trie (requiere un procedimiento auxiliar que denominamos plantarPalabra), saber si una palabra pertenece a
un trie y eliminar una palabra del trie, para la estructura de datos definida anteriormente (válida para almacenar un conjunto
de cadenas de caracteres).
procedimiento crearVacío(sal t:trie)
{Devuelve en t un conjunto vacío de palabras o cadenas de caracteres}
principio
t:=nil
fin
procedimiento plantarPalabra(ent palabra:cadena; e/s t:trie)
{Algoritmo auxiliar para plantar un árbol vertical (lista) con los caracteres de
la palabra recibida como parámetro. Esa palabra NO puede incluir el carácter ‘$’.}
variables taux:trie;
resto:cadena
principio
si long(palabra)=0 entonces {long devuelve la longitud de una cadena}
nuevoDato(t);
t↑.dato:='$'; {marca de fin de palabra}
t↑.primogenito:=nil;
t↑.sigHermano:=nil
sino
resto:=palabra[2..long(palabra)]; {subcadena desde la posición 2 a la última}
plantarPalabra(resto,taux);
nuevoDato(t);
t↑.dato:=palabra[1]; {primer carácter de la palabra}
t↑.primogenito:=taux;
t↑.sigHermano:=nil
fsi
fin
procedimiento insertar(ent palabra:cadena; e/s t:trie)
{Añade la palabra (que NO puede incluir el carácter ‘$’) al conjunto t, si no estaba.
Si ya estaba, t queda igual.}
variables taux:trie;
resto:cadena
principio
si t=nil entonces
plantarPalabra(palabra,t);
sino
si long(palabra)=0 entonces
si t↑.dato≠'$' entonces {en caso contrario, la palabra ya estaba en t}
nuevoDato(taux);
taux↑.dato:='$';
taux↑.primogenito:=nil;
taux↑.sigHermano:=t;
t:=taux
fsi
sino {t
≠nil and long(palabra)>0}
si palabra[1]<t↑.dato entonces
plantarPalabra(palabra,taux);
taux↑.sigHermano:=t;
t:=taux
sino_si palabra[1]=t↑.dato entonces
resto:=palabra[2..long(palabra)];
insertar(resto,t↑.primogenito)

-- 172 of 267 --

165
sino {palabra[1]>t↑.dato}
insertar(palabra,t↑.sigHermano)
fsi
fsi
fsi
fin
función pertenece(palabra:cadena; t:trie) devuelve booleano
{Devuelve verdad si y sólo si la palabra está en t}
variable resto:cadena
principio
si t=nil entonces
devuelve falso
sino
si long(palabra)=0 entonces
devuelve t↑.dato='$'
sino
si palabra[1]<t↑.dato entonces
devuelve falso
sino_si palabra[1]=t↑.dato entonces
resto:=palabra[2..long(palabra)];
devuelve pertenece(resto,t↑.primogenito)
sino {palabra[1]>t↑.dato}
devuelve pertenece(palabra,t↑.sigHermano)
fsi
fsi
fsi
fin
procedimiento eliminar(ent palabra:cadena; e/s t:trie)
{Borra la palabra del conjunto t, si estaba. Si no, t queda igual.}
variables taux:trie;
resto:cadena
principio
si t≠nil entonces
si long(palabra)=0 entonces
si t↑.dato='$' entonces
taux:=t;
t:=t↑.sigHermano;
disponer(taux)
fsi
sino
si palabra[1]=t↑.dato entonces
resto:=palabra[2..long(palabra)];
eliminar(resto,t↑.primogenito);
si t↑.primogenito=nil entonces
taux:=t;
t:=t↑.sigHermano;
disponer(taux)
fsi
sino_si palabra[1]>t↑.dato entonces
eliminar(palabra,t↑.sigHermano)
fsi
fsi
fsi
fin
El coste en tiempo en el caso peor es de orden lineal en la longitud de la cadena (insertada, buscada, o borrada), si bien
incluye una constante multiplicativa alta, del orden del cardinal de valores posibles del tipo carácter elevado a la longitud
de la cadena, puesto que, en cada nivel del árbol, debido a la representación nodo–lista, pue
