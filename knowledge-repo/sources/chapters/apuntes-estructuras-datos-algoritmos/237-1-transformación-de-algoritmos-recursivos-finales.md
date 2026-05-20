# 1. Transformación de algoritmos recursivos finales

El estudio de una técnica general de transformación de algoritmos recursivos en iterativos es interesante por diversas
razones. En primer lugar, algunos compiladores generan código ineficiente al compilar programas recursivos, por ello puede
ser conveniente realizar la transformación a iterativo antes de compilar. En segundo lugar, hay lenguajes de programación
que no permiten el diseño de algoritmos recursivos; en esos casos es indispensable disponer de una técnica de
transformación de algoritmos recursivos a iterativos. Además, la técnica presentada tiene interés didáctico puesto que
integra la utilización de razonamientos formales sobre algoritmos recursivos con el uso de estructuras de datos
arborescentes.
Un algoritmo recursivo se dice lineal si cada llamada recursiva sólo genera, como mucho, otra llamada. Si, además,
esa llamada es la última operación que se efectúa, entonces el algoritmo se llama recursivo final.
Así, un esquema general de algoritmo recursivo final es el siguiente:
procedimiento r(ent x:tx)
principio
selección
C0(x): A0(x);
C1(x): A1(x);
r(sig1(x));
C2(x): A2(x);
r(sig2(x));
...
Cn(x): An(x);
r(sign(x))
fselección
fin
En el esquema anterior, tx es un tipo previamente definido; C0(x), C1(x), …, Cn(x) son expresiones booleanas que
dependen del valor del parámetro x; A0(x), A1(x), …, An(x) son secuencias de instrucciones que no incluyen llamadas
al algoritmo r; y sig1(x), …, sign(x) son expresiones de tipo tx que, obviamente, dependen del valor del parámetro x.
Para deducir la versión iterativa del esquema anterior, basta observar que las sucesivas llamadas recursivas al
algoritmo r pueden ordenarse en una secuencia (puesto que cada llamada recursiva sólo genera, como mucho, otra
llamada) de ejecución de instrucciones. Esas instrucciones se ejecutarán para diferentes valores x0 (= x), x1 (= sigi(x0),
si Ci(x0) es verdad), …, xn (= sigj(xn-1), si Cj(xn-1) es verdad). Para los valores xi anteriores al último de la
secuencia, hay que ejecutar las instrucciones Aj(xi) tales que Cj(xi) es verdad. Para el último elemento de esa
secuencia, xn (al que se llega cuando se verifica C0(xn)) hay que ejecutar A0(xn).
Por tanto, el siguiente algoritmo iterativo ejecuta las mismas instrucciones que el recursivo r:
procedimiento rIter(ent x:tx)
variable v:tx
principio
v:=x;
mientrasQue not C0(v) hacer
selección
C1(v): A1(v);
v:=sig1(v);

-- 249 of 267 --

236
C2(v): A2(v);
v:=sig2(v);
...
Cn(v): An(v);
v:=sign(v)
fselección
fmq;
A0(v)
Fin