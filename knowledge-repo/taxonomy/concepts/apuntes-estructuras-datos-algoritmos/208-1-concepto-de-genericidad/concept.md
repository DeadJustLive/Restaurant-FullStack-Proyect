# 1. Concepto de genericidad

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 208)

## Contenido
# 1. Concepto de genericidad

La genericidad es un mecanismo que permite escribir fragmentos (subprogramas, módulos, clases…) de código
genérico, es decir, código que incluye referencias a uno o varios nombres de tipos de datos (o clases) e incluso a nombres
de procedimientos o funciones que manipulan valores de esos tipos, sin que exista una declaración de los mismos, es decir,
sin concretar qué tipos, qué procedimientos o qué funciones son los utilizados. Esos nombres de tipos, de procedimientos
o de funciones se denominan parámetros de tipo, de procedimiento o de función. Además, es posible especificar
restricciones para los parámetros de tipo del código genérico, como, por ejemplo, que el tipo en el que se concrete luego
ese parámetro sea un tipo discreto.
Particularizar (o concretar) el código genérico consiste en indicar los tipos concretos (previamente definidos) en los
que se convierten los parámetros de tipos. Si además de parámetros de tipo hay parámetros de procedimiento o de función,
es necesario también indicar los procedimientos o funciones concretos (previamente implementados) en los que se
convierten los parámetros de procedimiento o función.
Con la particularización del código genérico, se obtiene código concreto, que puede ser ejecutado.
La genericidad facilita la reutilización de algoritmos. Por ejemplo, si se implementa un algoritmo de ordenación de
vectores por el método de ordenación rápida de Hoare (quicksort), los tipos de datos de los índices y de los elementos del
vector no afectan al algoritmo, siempre que se disponga de una función de orden que diga si un elemento es mayor que otro.
Un tipo genérico vector puede especificarse así:
espec vectoresGenéricos
usa booleanos
parámetros formales
géneros índice, elemento {dos parámetros de tipo: el tipo de los índices y el de los datos del vector}
operación
_>_: elemento e1, elemento e2 -> booleano { “>” es una relación de orden }
fpf
género vector {vector es una colección de datos de tipo elemento indexados con los valores del tipo índice}
operaciones
modifica: vector v, índice i, elemento e -> vector
{Devuelve el vector resultante de modificar v asignando el valor e a la componente de índice i de v.}
valor: vector v, índice i -> elemento
{Devuelve el valor del elemento de índice i en el vector v.
Si al elemento de índice i en v no se le ha asignado previamente ningún valor con la operación modifica,
entonces devuelve un valor cualquiera del tipo elemento.}
fespec
Un algoritmo se denomina genérico si manipula TAD genéricos. Por ejemplo, puede desarrollarse el algoritmo de
ordenación rápida (quicksort) para vectores genéricos. Bastará con concretar los géneros índice y elemento y la operación
“>” para contar con un ejemplar del TAD genérico vector (TAD concreto) y con un algoritmo concreto de ordenación para
ese tipo.
Algunos lenguajes imperativos (por ejemplo, Ada) soportan la genericidad. A continuación, y a título de ejemplo, se
incluye un algoritmo genérico de ordenación rápida en Ada.

-- 43 of 267 --

36
generic –- módulo de declaración; este módulo genérico ofrece un procedimiento de
-- ordenación de vectores genéricos
type indice is (<>); 	-- cualquier tipo discreto (es un parámetro de tipo)
type elemento is private; -- cualquier tipo (es otro parámetro de tipo)
type vector is array(indice range <>) of elemento;
with function ">"(a,b:elemento) return boolean;
package ordenacion_g is
procedure ordena(v:in out vector);
end; -- del módulo de declaración
package body ordenacion_g is -– módulo de implementación
procedure ordena(v:in out vector) is
i,j:indice; m,t:elemento; n:integer;
begin
-- inicialización
i:=v'first;
j:=v'last;
n:=indice'pos(i);
n:=n+indice'pos(j);
n:=n/2;
m:=v(indice'val(n));
-- partición del vector en dos
while i<=j loop
while m>v(i) loop
i:=indice'succ(i);
end loop;
while v(j)>m loop
j:=indice'pred(j);
end loop;
if i<=j then
t:=v(i);
v(i):=v(j);
v(j):=t;
i:=indice'succ(i);
j:=indice'pred(j);
end if;
end loop;
-- recursión en los dos subvectores
if v'first<j then
ordena(v(v'first..j));
end if;
if i<v'last then
ordena(v(i..v'last));
end if;
end ordena;
end ordenacion_g; -- del módulo de implementación
La utilización de un ejemplar concreto del algoritmo genérico anterior se puede realizar de la siguiente forma:
with ordenacion_g;
procedure titi is
type color is (rojo,azul,gris);
type dia is (lu,ma,mi,ju,vi,sa,do);
type vect is array(dia range <>) of color;
x:vect(ma..vi):=(gris,azul,rojo,gris);
package o is new ordenacion_g(dia,color,vect,">");
begin
...
o.ordena(x);
...
end titi;

-- 44 of 267 --

37
