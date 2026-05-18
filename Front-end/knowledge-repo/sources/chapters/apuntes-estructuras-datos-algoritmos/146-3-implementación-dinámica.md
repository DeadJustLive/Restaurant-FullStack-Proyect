# 3. Implementación dinámica

Para implementar dinámicamente árboles n–arios ordenados, utilizaremos la representación llamada primogénito–
siguiente hermano (child–brother, en inglés). El tipo árbol es un puntero a un registro que guarda, además de un campo
con la información correspondiente al elemento raíz, un puntero al registro correspondiente al primer hijo (si la raíz no es
una hoja) y otro puntero que apunta al registro correspondiente al siguiente hermano (si existe) (ver la figura).
3
14 	15
9 	2 	6 	33
14
3 	nil
9 nil 	2 nil 	6 nil nil
15 	nil
33 nil nil
a
tipos árbol = ↑nodo;
nodo = registro
dato:elemento;
primogénito,sigHermano:árbol
freg;
bosque = árbol
En esta representación, la lista enlazada que se forma considerando los punteros al siguiente hermano (sigHermano)
representa un bosque ordenado (secuencia de árboles).
A continuación, se desarrolla la implementación de todas las operaciones básicas definidas en la especificación genérica
árbolesOrdenados, además de los recorridos en pre-orden y post-orden.
modulo genérico árbolesOrdenados
importa listasGenéricas {como las utilizadas en la Lección 12}
parámetro
tipo elemento
exporta
tipos árbol, bosque {Los valores del tipo bosque representan secuencias de elementos
del tipo árbol. Los valores del tipo árbol se componen de una
raíz de tipo elmto y un bosque de árboles hijos}
procedimiento crearVacío(sal b:bosque)
{devuelve el bosque vacío, es decir, la secuencia vacía de árboles}
procedimiento añadirÚltimo(e/s b:bosque; ent a:árbol)
{devuelve el bosque resultante de añadir el árbol a como último elemento de b}

-- 149 of 267 --

142
función long(b:bosque) devuelve natural
{devuelve el número de árboles del bosque b, es decir, la longitud de la secuencia}
procedimiento observar(ent b:bosque; ent n:natural; sal error:booleano; sal a:árbol)
{si 1
≤n
≤long(b): devuelve el n-ésimo árbol de la secuencia de árboles b y error=falso;
en caso contrario devuelve error=verdad}
procedimiento resto(ent b:bosque; sal error:booleano; sal rb:bosque)
{si b no es vacío devuelve en rb el bosque resultante de borrar el primer árbol de b
y error=falso; en caso contrario devuelve error=verdad}
procedimiento plantar(sal a:árbol; ent e:elemento; ent b:bosque)
{devuelve un árbol a cuya raíz es e y sus subárboles son el bosque b}
función raíz(a:árbol) devuelve elemento
{devuelve la raíz del árbol a}
procedimiento elBosque(ent a:árbol; sal b:bosque)
{devuelve el bosque de los subárboles del árbol a}
función numHijos(a:árbol) devuelve natural
{devuelve el número de subárboles de a, es decir long(elBosque(a)}
procedimiento subÁrbol(ent a:árbol; ent n:natural; sal error:booleano; sal sa:árbol)
{si 1
≤n
≤numHijos(a): devuelve el n-ésimo subárbol de a y error=falso;
en caso contrario error=verdad}
función esHoja(a:árbol) devuelve booleano
{devuelve verdad si y sólo si a no tiene subárboles, es decir, numHijos(a)=0}
función alturaBosque(b:bosque) devuelve natural
{devuelve la altura del árbol más alto de b}
función alturaÁrbol(a:árbol) devuelve natural
{devuelve la altura de a}
procedimiento duplicarBosque(sal nuevo:bosque; ent viejo:bosque)
{Duplica la representación del bosque viejo guardándolo en nuevo}
procedimiento liberarBosque(e/s b:bosque)
{Libera la memoria dinámica accesible desde b, quedando b vacío}
procedimiento duplicarÁrbol(sal nuevo:árbol; ent viejo:árbol)
{Duplica la representación del árbol viejo guardándolo en nuevo}
procedimiento liberarÁrbol(e/s a:árbol)
{Libera la memoria dinámica accesible desde a}
procedimiento preOrden(ent a:árbol; e/s L:lista)
{añade a la lista L los elementos de a recorridos en pre-orden}
procedimiento preBosque(ent b:bosque; e/s L:lista)
{añade a la lista L los elementos de todos los árboles del bosque b recorridos en
pre-orden}
procedimiento postOrden(ent a:árbol; e/s L:lista)
{añade a la lista L los elementos de a recorridos en post-orden}
procedimiento postBosque(ent b:bosque; e/s L:lista)
{añade a la lista l los elementos de todos los árboles del bosque b recorridos
en post-orden}

-- 150 of 267 --

143
implementación
tipos
árbol = ↑nodo;
nodo = registro
dato:elemento;
primogénito,sigHermano:árbol
freg;
bosque = árbol 	{Suponemos coerción de tipos automática}
procedimiento crearVacío(sal b:bosque)
{devuelve el bosque vacío, es decir, la secuencia vacía de árboles}
principio
b:=nil
fin
procedimiento añadirÚltimo(e/s b:bosque; ent a:árbol)
{devuelve el bosque resultante de añadir el árbol a como último elemento de b}
variable aux:bosque
principio
si b=nil entonces
b:=a
sino
aux:=b;
mientrasQue aux↑.sigHermano≠nil hacer
aux:=aux↑.sigHermano
fmq;
aux↑.sigHermano:=a
fsi
fin
función long(b:bosque) devuelve natural
{devuelve el número de árboles del bosque b, es decir, la longitud de la secuencia}
principio
si b=nil entonces
devuelve 0
sino
devuelve 1+long(b↑.sigHermano)
fsi
fin
procedimiento observar(ent b:bosque; ent n:natural; sal error:booleano; sal a:árbol)
{si 1
≤n
≤long(b): devuelve el n-ésimo árbol de la secuencia de árboles b y error=falso;
en caso contrario devuelve error=verdad}
principio
si n=0 or b=nil entonces
error:=verdad
sino
si n=1 entonces
a:=b;
error:=falso
sino
observar(b↑.sigHermano,n-1,error,a)
fsi
fsi
fin
procedimiento resto(ent b:bosque; sal error:booleano; sal rb:bosque)
{si b no es vacío devuelve en rb el bosque resultante de borrar el primer árbol de b
y error=falso; en caso contrario devuelve error=verdad}
principio
si b=nil entonces
error:=verdad
sino
error:=falso;
rb:=b↑.sigHermano
fsi
fin

-- 151 of 267 --

144
procedimiento plantar(sal a:árbol; ent e:elemento; ent b:bosque)
{devuelve un árbol a cuya raíz es e y sus subárboles son el bosque b}
principio
nuevoDato(a);
a↑.dato:=e;
a↑.primogénito:=b;
a↑.sigHermano:=nil
fin
función raíz(a:árbol) devuelve elemento
{devuelve la raíz del árbol a}
principio
devuelve a↑.dato
fin
procedimiento elBosque(ent a:árbol; sal b:bosque)
{devuelve el bosque de los subárboles del árbol a}
principio
b:=a↑.primogénito
fin
procedimiento subárbol(ent a:árbol; ent n:natural; sal error:booleano; sal sa:árbol)
{si 1
≤n
≤numHijos(a): devuelve el n-ésimo subárbol de a y error=falso;
en caso contrario error=verdad}
principio
observar(a↑.primogénito,n,error,sa)
fin
función numHijos(a:árbol) devuelve natural
{devuelve el número de subárboles de a, es decir long(elBosque(a)}
principio
devuelve long(a↑.primogénito)
fin
función esHoja(a:árbol) devuelve booleano
{devuelve verdad si y sólo si a no tiene subárboles, es decir, numHijos(a)=0}
principio
devuelve a↑.primogénito=nil
fin
función alturaBosque(b:bosque) devuelve natural
{devuelve la altura del árbol más alto de b}
principio
si b=nil entonces
devuelve 0
sino
devuelve max(alturaÁrbol(b),alturaBosque(b↑.sigHermano))
fsi
fin
función alturaÁrbol(a:árbol) devuelve natural
{devuelve la altura de a}
principio
si esHoja(a) entonces
devuelve 0
sino
devuelve 1+alturaBosque(a↑.primogénito)
fsi
fin
procedimiento duplicarBosque(sal nuevo:bosque; ent viejo:bosque)
{Duplica la representación del bosque viejo guardándolo en nuevo}
variables error:booleano
principio
si viejo=nil entonces
nuevo:=nil
sino

-- 152 of 267 --

145
duplicarÁrbol(nuevo,viejo);
duplicarBosque(nuevo↑.sigHermano,viejo↑.sigHermano)
fsi
fin
procedimiento duplicarÁrbol(sal nuevo:árbol; ent viejo:árbol)
{Duplica la representación del árbol viejo guardándolo en nuevo}
variables nuevoBosque:bosque
principio
duplicarBosque(nuevoBosque,viejo↑.primogénito);
plantar(viejo↑.dato,nuevoBosque,nuevo)
fin
procedimiento liberarBosque(e/s b:bosque)
{Libera la memoria dinámica accesible desde b, quedando b vacío}
principio
si b≠nil entonces
liberarBosque(b↑.sigHermano);
liberarÁrbol(b)
fsi
fin
procedimiento liberarÁrbol(e/s a:árbol)
{Libera la memoria dinámica accesible desde a}
principio
liberarBosque(a↑.primogénito);
disponer(a)
fin
procedimiento preOrden(ent a:árbol; e/s L:lista)
{añade a la lista L los elementos del árbol a recorridos en pre-orden}
principio
añadirÚltimo(L,a↑.dato); 	{añadir la raíz del árbol}
preBosque(a↑.primogénito,L) {recorrer el bosque de hijos de la raíz}
fin
procedimiento preBosque(ent b:bosque; e/s L:lista)
{añade a la lista L los elementos de todos los árboles del bosque b recorridos en
pre-orden}
principio
si b≠nil entonces
preOrden(b,L); 	{recorrer en pre-orden el primer árbol del bosque}
preBosque(b↑.sigHermano,L) {recorrer el resto del bosque en pre-orden}
fsi
fin
procedimiento postOrden(ent a:árbol; e/s L:lista)
{añade a la lista L los elementos de a recorridos en post-orden}
principio
postBosque(a↑.primogénito,L); {recorrer el bosque de hijos de la raíz }
añadirÚltimo(L,a↑.dato) 	{añadir la raíz del árbol}
fin
procedimiento postBosque(ent b:bosque; e/s L:lista)
{añade a la lista L los elementos de todos los árboles del bosque b recorridos
en post-orden}
principio
si b≠nil entonces
postOrden(b,L); 	{recorrer en post-orden el primer árbol del bosque}
postBosque(b↑.sigHermano,L) {recorrer el resto del bosque en post-orden}
fsi
fin
fin 	{del módulo árbolesOrdenados}

-- 153 of 267 --

146
La implementación anterior diferencia explícitamente los tipos de datos “árbol” y “bosque” aunque realmente ambos
son punteros a datos del mismo tipo “nodo”. Se ha escrito así para remarcar la diferencia conceptual entre un árbol y una
secuencia de árboles. No obstante, puede verse que en la implementación de las operaciones se utiliza la coerción
automática de tipos, invocando por ejemplo desde el procedimiento “preBosque” al procedimiento “preOrden” con un
argumento de tipo “bosque” cuando el parámetro formal en el procedimiento “preOrden” es de tipo “árbol”.
Caben implementaciones alternativas a los procedimientos de recorridos de árboles y bosques como las siguientes.
procedimiento preOrden(ent b:bosque; e/s L:lista)
{añade a la lista L los elementos del bosque n-ario b recorridos en pre-orden}
principio
si b≠nil entonces
añadirÚltimo(L,b↑.dato);
preOrden(b↑.primogénito,L);
preOrden(b↑.sigHermano,L)
fsi
fin
procedimiento postOrden(ent b:bosque; e/s L:lista)
{añade a la lista L los elementos del bosque n-ario b recorridos en post-orden}
principio
si b≠nil entonces
postOrden(b↑.primogénito,L);
añadirÚltimo(L,b↑.dato);
postOrden(b↑.sigHermano,L)
fsi
fin
En ambos casos el parámetro de tipo “bosque” podría ser igualmente de tipo “árbol”, pues sirven para recorrer ambas
estructuras.