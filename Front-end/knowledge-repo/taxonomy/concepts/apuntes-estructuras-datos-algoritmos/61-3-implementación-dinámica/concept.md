# 3. Implementación dinámica

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 61)

## Contenido
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
≤long(b): devuelve el n-ésimo árbol de la secuencia de árboles b y
