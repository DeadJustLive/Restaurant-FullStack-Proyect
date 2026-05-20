# 2. Transformación de algoritmos recursivos lineales (no finales)

El siguiente es un esquema general de algoritmo lineal:
procedimiento r(ent x:tx)
principio
si C(x) entonces
A(x)
sino
B1(x);
r(sig(x));
B2(x)
fsi
fin
Como puede verse, cada llamada al algoritmo genera, como mucho, una llamada recursiva (r(sig(x)), cuando la
expresión booleana C(x) es falsa; si C(x) es verdad, no se genera ninguna llamada recursiva).
Al igual que en el caso particular de algoritmo recursivo final (cuando B2(x) es una secuencia vacía de instrucciones),
puede construirse una secuencia de datos x0 (= 	x), x1, …, xn que corresponden a los valores del parámetro x en las
sucesivas llamadas recursivas al algoritmo r. Para cada uno de los valores xi de esa secuencia hay que ejecutar B1(xi)
antes de tratar el resto de la secuencia y B2(xi) después de tratar el resto de la secuencia. En consecuencia, hay que recorrer
la secuencia x0, x1, …, xn dos veces; una de principio a fin y otra al revés. Para ello, cuando se recorre de principio a fin,
además de ejecutar B1(xi) podemos almacenar el valor xi en una pila de datos de tipo tx. Así, una vez recorrida la
secuencia de principio a fin, basta con ir extrayendo datos de la pila para poder recorrer la secuencia en sentido inverso y
ejecutando B2(xi) para valores decrecientes de i.
En definitiva, la versión iterativa del algoritmo recursivo lineal anterior es la siguiente:
procedimiento rIter(ent x:tx)
variables v:tx;
p:pila_de_tx
principio
creaVacía(p);
v:=x;
mientrasQue not C(v) hacer
B1(v);
apilar(p,v);
v:=sig(v)
fmq;
A(v);
mientrasQue not esVacía(p) hacer
v:=cima(p);
desapilar(p);
B2(v)
fmq
fin

-- 250 of 267 --

237