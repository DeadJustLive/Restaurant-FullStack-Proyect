# 3. Representación estática circular

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 247)

## Contenido
# 3. Representación estática circular

La representación estática o contigua de una cola se realiza mediante un vector con un espacio para un máximo max
de elementos y dos contadores, anterior y último, que memoricen el índice de la componente anterior a aquélla en la
que se encuentra el primer elemento de la cola y el índice donde se encuentra el último elemento de la cola, respectivamente.
Al igual que sucede con la representación estática del TAD pila, esta representación hace que la operación añadir haya que
implementarla como una operación parcial (sólo pueden representarse colas de longitud menor o igual que max).
El vector soporte debe considerarse como si fuese una estructura circular, es decir, las operaciones con los índices del
vector deben realizarse con aritmética modular (módulo max).
En la figura se representa un ejemplo de
cola (e1,e2,e3,e4,e5) almacenada
en 	un 	vector 	(considerado 	como
circular).
En este ejemplo, el índice anterior (en el
sentido contrario a las agujas del reloj)
al del primer elemento de la cola (e1) es
max–3; el índice del último elemento de
la cola (e5) es 2.
En esta representación, tamaño = 0 si
y sólo si la secuencia es vacía. La
capacidad máxima es de max elementos.
e1	e2	e3
e4
e5
0
1
2
3
4
5
6
7
8 	9
max-1 max-2
max-3
anterior = max-3
último = 2
tamaño = 5
módulo genérico colasGenéricasEstáticas
parámetro
tipo elemento
exporta
constante max = 100
tipo 	cola 	{Los 	valores 	del 	TAD 	cola 	representan 	secuencias 	de 	0 	o 	más 	elementos,
con longitud máxima max; llamamos primer elemento de la cola al primero
que fue añadido y último al último que fue añadido}
procedimiento crearVacía(sal c:cola)
{Devuelve una cola vacía, sin elementos}
procedimiento encolar(ent e:elemento; e/s c:cola; sal error:booleano)
{Si c no está llena, añade e a c como último elemento; si está llena, devuelve error}
función esVacía(c:cola) devuelve booleano
{Devuelve verdad si y sólo si c no tiene elementos}
procedimiento desencolar(e/s c:cola)
{Si c es no vacía, devuelve en c la cola resultante de eliminar de c el primer
elemento que fue añadido. Si c es vacía, la deja igual}

-- 88 of 267 --

81
procedimiento primero(ent c:cola; sal e:elemento; sal error:booleano)
{Si c es no vacía, devuelve en e su primer elemento; si es vacía, devuelve error}
función longitud(c:cola) devuelve natural
{Devuelve el número de elementos de c}
procedimiento duplicar(sal cSal:cola; ent cEnt:cola)
{Duplica la representación de la cola cEnt en la cola cSal}
función iguales(c1,c2:cola) devuelve booleano
{Devuelve verdad si y sólo si las colas c1 y c2 tienen la misma longitud y los
mismos elementos en idénticas posiciones}
procedimiento iniciarIterador(e/s c:cola)
{Prepara el iterador para que el siguiente elemento a visitar sea el
primero de la cola (situación de no haber visitado ningún elemento)}
función existeSiguiente(c:cola) devuelve booleano
{Devuelve falso si ya se ha visitado el último elemento, cierto en caso contrario}
procedimiento siguiente(e/s c:cola; sal e:elemento: sal error:booleano)
{Si existe algún elemento de c pendiente de visitar, devuelve en e el siguiente
elemento a visitar y error=falso, y además avanza el iterador para que a
continuación se pueda visitar otro elemento de c. Si no quedan elementos
pendientes de visitar devuelve error=verdad, e queda indefinido y c queda
como estaba}
implementación
tipos vectorDatos = vector[0..max-1] de elemento;
cola = registro
datos:vectorDatos;
anterior,último,iter:0..max-1; {iter se usa para implementar el iterador}
tamaño:0..max;
iterEnInicio:booleano {se usa también para implementar el iterador}
freg
procedimiento crearVacía(sal c:cola)
{Devuelve una cola vacía, sin elementos}
principio
c.anterior:=0; 	{por ejemplo}
c.último:=0;
c.tamaño:=0
fin
procedimiento encolar(e/s c:cola; ent e:elemento; sal error:booleano)
{Si c no está llena, añade e a c como último elemento; si está llena, devuelve error}
principio
si c.tamaño<max entonces
error:=falso;
c.último:=(c.último+1) mod max;
c.datos[c.último]:=e;
c.tamaño:=c.tamaño+1
sino
error:=verdad
fsi
fin
función esVacía(c:cola) devuelve booleano
{Devuelve verdad si y sólo si c no tiene elementos}
principio
devuelve c.tamaño=0
fin
procedimiento desencolar(e/s c:cola)
{Si c es no vacía, devuelve en c la cola resultante de eliminar de c el primer
elemento que fue añadido. Si c es vacía, la deja igual}

-- 89 of 267 --

82
principio
si not esVacía(c) entonces
c.anterior:=(c.anterior+1) mod max;
c.tamaño:=c.tamaño-1
fsi
fin
procedimiento primero(ent c:cola; sal e:elemento; sal error:booleano)
{Si c es no vacía, devuelve en e su primer elemento; si es vacía, devuelve error}
principio
si esVacía(c) entonces
error:=verdad
sino
error:=falso;
e:=c.datos[(c.anterior+1) mod max]
fsi
fin
función longitud(c:cola) devuelve natural
{Devuelve el número de elementos de c}
principio
devuelve c.tamaño
fin
procedimiento duplicar(sal cSal:cola; ent cEnt:cola)
{Duplica la representación de la cola cEnt en la cola cSal}
variable i:
