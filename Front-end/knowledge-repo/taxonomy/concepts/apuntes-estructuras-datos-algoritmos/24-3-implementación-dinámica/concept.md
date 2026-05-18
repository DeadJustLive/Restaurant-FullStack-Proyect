# 3. Implementación dinámica

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 24)

## Contenido
# 3. Implementación dinámica

Veamos ahora la implementación dinámica de árboles binarios obtenida enlazando mediante punteros los registros que
guardan la información de cada nodo. Será una implementación basada en punteros a los hijos, es decir, cada registro
incluirá sendos punteros al subárbol izquierdo y al subárbol derecho. Incluimos las operaciones de asignación y liberación
de memoria dinámica, y una operación de comparación de igualdad. Dejamos el iterador para la siguiente sección.
módulo genérico árbolesBinarios
parámetros
tipo elemento
exporta
tipo arbin {Su dominio de valores son los árboles binarios de elementos.}
procedimiento vacío(sal a:arbin)
{Devuelve en a el árbol vacío.}
procedimiento plantar(sal a:arbin; ent e:elemento; ent ai,ad:arbin)
{Devuelve en a un árbol binario cuyo elemento raíz es e, subárbol izquierdo es ai
y subárbol derecho es ad, sin duplicar la representación de éstos en memoria,
es decir, simplemente apuntando a éstos.}
función esVacío(a:arbin) devuelve booleano
{Devuelve verdad si y sólo si a es el árbol vacío.}
procedimiento raíz(ent a:arbin; sal error:booleano; sal e:elemento)
{Si esVacío(a) devuelve error=verdad.
Si no, devuelve error=falso y en e el elemento raíz de a.}
procedimiento subIzq(ent a:arbin; sal error:booleano; sal ai:arbin)
{Si esVacío(a) devuelve error=verdad.

-- 113 of 267 --

106
Si no, devuelve error=falso y en ai el subárbol izquierdo de a, sin duplicar la
representación en memori.a}
procedimiento subDer(ent a:arbin; sal error:booleano; sal ad:arbin)
{Si esVacío(a) devuelve error=verdad.
Si no, devuelve error=falso y en ad el subárbol derecho de a, sin duplicar la
representación en memoria.}
procedimiento altura(ent a:arbin; sal error:booleano; sal h:natural)
{Si esVacío(a) devuelve error=verdad.
Si no, devuelve error=falso y en h la altura de a}
procedimiento duplicar(sal nuevo:arbin; ent viejo:arbin)
{Duplica la representación en memoria del árbol viejo guardándolo en nuevo.}
procedimiento liberar(e/s a:arbin)
{Libera la representación en memoria de a, quedando a vacío.}
función iguales(a1,a2:arbin) devuelve booleano
{Devuelve verdad si y sólo si a1 y a2 tienen los mismos elementos y en las
mismas posiciones del árbol.}
{Las operaciones del iterador: pendientes de realizar.}
implementación
tipos arbin = ↑nodo; {almacenamiento en memoria dinámica con punteros a los hijos}
nodo = registro
dato:elemento;
izq,der:arbin
freg
procedimiento vacío(sal a:arbin)
{Devuelve en a el árbol vacío.}
principio
a:=nil
fin
procedimiento plantar(sal a:arbin; ent e:elemento; ent ai,ad:arbin)
{Devuelve en a un árbol binario cuyo elemento raíz es e, subárbol izquierdo es ai
y subárbol derecho es ad, sin duplicar la representación de éstos en memoria,
es decir, simplemente apuntando a éstos.}
principio
nuevoDato(a);
a↑.dato:=e;
a↑.izq:=ai;
a↑.der:=ad
fin
función esVacío(a:arbin) devuelve booleano
{Devuelve verdad si y sólo si a es el árbol vacío.}
principio
devuelve a=nil
fin
procedimiento raíz(ent a:arbin; sal error:booleano; sal e:elemento)
{Si esVacío(a) devuelve error=verdad.
Si no, devuelve error=falso y en e el elemento raíz de a.}
principio
si esVacío(a) entonces
error:=verdad
sino
error:=falso;
e:=a↑.dato
fsi
fin
procedimiento subIzq(ent a:arbin; sal error:booleano; sal ai:arbin)

-- 114 of 267 --

107
{Si esVacío(a) devuelve error=verdad.
Si no, devuelve error=falso y en ai el subárbol izquierdo de a, sin duplicar la
representación en memoria.}
principio
si esVacío(a) entonces
error:=verdad
sino
error:=falso;
ai:=a↑.izq
fin
fin
procedimiento subDer(ent a:arbin; sal error:booleano; sal ad:arbin)
{Si esVacío(a) devuelve error=verdad.
Si no, devuelve error=falso y en ad el subárbol derecho de a, sin duplicar la
representación en memoria.}
principio
si esVacío(a) entonces
error:=verdad
sino
error:=falso;
ad:=a↑.der
fin
fin
función max(a,b:entero) devuelve entero
{Función auxiliar para calcular el máximo de dos enteros}
principio
si a≥b entonces
devuelve a
sino
devuelve b
fsi
fin
función altRec(a:arbin) devuelve natural
{PRECONDICIÓN: a es no vacío.
Función recursiva auxiliar para calcular la altura de un árbol no vacío.}
principio
selección
(a↑.izq=nil) and (a↑.der=nil): devuelve 0;
(a↑.izq=nil) and (a↑.der≠nil): devuelve 1+altRec(a↑.der);
(a↑.izq≠nil) and (a↑.der=nil): devuelve 1+altRec(a↑.izq);
(a↑.izq≠nil) and (a↑.der≠nil): devuelve 1+max(altRec(a↑.izq),altRec(a↑.der))
fselección
fin
procedimiento altura(ent a:arbin; sal error:booleano; sal h:natural)
{Si esVacío(a) devuelve error=verdad.
Si no, devuelve error=falso y en h la altura de a}
principio
si esVacío(a) entonces
error:=verdad
sino
error:=falso;
h:=altRec(a)
fsi
fin
procedimiento duplicar(sal nuevo:arbin; ent viejo:arbin)
{Duplica la representación en memoria del árbol viejo guardándolo en nuevo.}
variables ai,ad:arbin
principio
si viejo=nil entonces
nuevo:=nil
sino
nuevoDato(nuevo);

-- 115 of 267 --

108
nuevo↑.dato:=viejo↑.dato;
duplicar(ai,viejo↑.izq);
duplicar(ad,viejo↑.der);
nuevo↑.izq:=ai;
nuevo↑
