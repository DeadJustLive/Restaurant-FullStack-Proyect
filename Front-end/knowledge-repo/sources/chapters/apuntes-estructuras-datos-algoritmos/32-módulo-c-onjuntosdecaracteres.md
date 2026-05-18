# módulo c: onjuntosDeCaracteres

importa booleanos, caracteres {ASCII extendido, i.e. 256 caracteres}, naturales
exporta { esta parte contiene la interfaz }
tipo conjcar1 {Tipo especificado previamente}
{Los valores del TAD conjcar representan conjuntos de caracteres,
sin elementos repetidos, y en los que no es relevante el orden en el que
los caracteres se añaden al conjunto.}
1 Es un tipo opaco.

-- 14 of 267 --

7
procedimiento vacío(sal A:conjcar)
{Devuelve un conjunto de caracteres vacío, es decir un conjunto
que no contiene ningún carácter}
función esVacío(A:conjcar) devuelve booleano
{Devuelve verdad si y sólo si A no contiene ningún carácter}
procedimiento poner(ent c:carácter; e/s A:conjcar)
{Si c está en A, devuelve un conjunto igual a A;
si c no está en A, devuelve el conjunto resultante de añadir c a A}
procedimiento quitar(ent c:carácter; e/s A:conjcar)
{Si c está en A, devuelve el conjunto resultante de eliminar c de A;
si c no está en A, devuelve un conjunto igual a A}
función pertenece(c:carácter; A:conjcar) devuelve booleano
{Devuelve verdad si y sólo si c está en A}
procedimiento unión(ent A,B:conjcar; sal C:conjcar)
{Devuelve en C un conjunto que contiene todos los caracteres que están en
A y todos los que están en B}
procedimiento intersección(ent A,B:conjcar; sal C:conjcar)
{Devuelve en C un conjunto que contiene únicamente los caracteres que
están tanto en A como en B}
función cardinal(A:conjcar) devuelve natural
{Devuelve el número total de caracteres que contiene c (0 si es vacío)}
{Las tres siguientes operaciones implementan un Iterador.
Hablaremos de ello más adelante}
procedimiento iniciarIterador(e/s A:conjcar)
{Prepara el iterador para que el siguiente elemento a visitar sea el primer
carácter de A por visitar, si existe (situación de no haber visitado ningún
carácter)}
función existeSiguiente(A:conjcar) devuelve booleano
{Devuelve falso si ya se han visitado todos los caracteres de A.
Devuelve verdad en caso contrario.}
procedimiento siguiente(e/s A:conjcar; sal c:carácter; sal error:booleano)
{Implementa las operaciones “siguiente” y “avanza” de la especificación, es decir:
Si existeSiguiente(A), error toma el valor falso, c toma el valor del siguiente
carácter del conjunto, y se avanza el iterador al carácter siguiente del
conjunto. Si no existeSiguiente(A), error toma el valor verdad, c queda
indefinido y A queda como estaba.}
implementación
tipo conjcar = registro
elmto: vector[carácter] de booleano;
card: natural
freg
procedimiento vacío(sal A:conjcar)
variable c:carácter
principio
A.card:=0;
para c:=chr(0) hasta chr(255) hacer
A.elmto[c]:=falso
fpara
fin
función esVacío(A:conjcar) devuelve booleano
principio
devuelve(A.card=0)
fin

-- 15 of 267 --

8
función pertenece(c:carácter; A:conjcar) devuelve booleano
principio
devuelve(A.elmto[c])
fin
procedimiento poner(ent c:carácter; e/s A:conjcar)
principio
si not pertenece(c,A) entonces
A.elmto[c]:=verdad;
A.card:=A.card+1
fsi
fin
procedimiento quitar(ent c:carácter; e/s A:conjcar)
principio
si pertenece(c,A) entonces
A.elmto[c]:=falso;
A.card:=A.card-1
fsi
fin
procedimiento unión(ent A,B:conjcar; sal C:conjcar)
variable x:carácter
principio
C.card:=0;
para x:=chr(0) hasta chr(255) hacer
C.elmto[x]:=A.elmto[x] or B.elmto[x];
si C.elmto[x] entonces
C.card:=C.card+1
fsi
fpara
fin
procedimiento intersección(ent A,B:conjcar; sal C:conjcar)
variable x:carácter
principio
C.card:=0;
para x:=chr(0) hasta chr(255) hacer
C.elmto[x]:=A.elmto[x] and B.elmto[x];
si C.elmto[x] entonces
C.card:=C.card+1
fsi
fpara
fin
función cardinal(A:conjcar) devuelve natural
principio
devuelve(A.card)
fin
procedimiento iniciarIterador(e/s A:conjcar)
principio
A.iterPos:=0;
mientrasQue A.iterPos≤255 andthen not A.elmto[chr(A.iterPos)] hacer
A.iterPos:=A.iterPos+1
fmq
fin
función existeSiguiente(A:conjcar) devuelve booleano
principio
devuelve A.iterPos<256
fin
procedimiento siguiente(e/s A:conjcar; sal c:carácter; sal error:booleano)
principio
si existeSiguiente(A) entonces
c:=chr(A.iterPos);
A.iterPos:=A.iterpos+1;
mientrasQue A.iterPos≤255 andthen not A.elmto[chr(A.iterPos)] hacer

-- 16 of 267 --

9
A.iterPos:=A.iterPos+1
fmq;
error:=falso
sino
error:=verdad
fsi
fin
fin
Desde los años setenta los lenguajes de programación se diseñan para poder soportar el diseño a gran escala de
algoritmos y, por tanto, suelen permitir el desarrollo de módulos independientes.
Vamos a presentar un mismo ejemplo (el módulo conjuntos de la sección anterior) codificado en dos lenguajes
diferentes que adoptan distintas soluciones para la definición de módulos: Ada y C++. Lo hacemos sin utilizar orientación
a objetos, es decir, sin utilizar clases.
Veamos ahora la codificación del mismo módulo anterior en Ada (evitamos, para abreviar, escribir de nuevo la
documentación del código; tampoco incluimos las operaciones del iterador):
package conjuntos is
type conjcar is private;
procedure vacio(A:out conjcar);
function esVacio(A:in conjcar) return boolean;
procedure poner(c:in character; A:in out conjcar);
procedure quitar(c:in character; A:in out conjcar);
function pertenece(c:in character; A:in conjcar) return boolean;
procedure union(A,B:in conjcar; C:out conjcar);
procedure interseccion(A,B:in conjcar; C:out conjcar);
function cardinal(A:in conjcar) return integer;
private
type elementos is array(character) of boolean;
type conjcar is
record
elmto:elementos;
card:integer;
end record;
end conjuntos;
package body conjuntos is
procedure vacio(A:out conjcar) is
begin
A.card:=0;
for c in character loop
A.elmto(c):=false;
end loop;
end vacio;
function esVacio(A:in conjcar) return boolean is
begin
return A.card=0;
end esVacio;
function pertenece(c:in character; A:in conjcar) return boolean is
begin
return A.elmto(c);
end pertenece;
procedure poner(c:in character; A:in out conjcar) is
begin
if not pertenece(c,A) then
A.elmto(c):=true;
A.card:=A.card+1;
end if;
end poner;
procedure quitar(c:in character; A:in out conjcar) is

-- 17 of 267 --

10
begin
if pertenece(c,A) then
A.elmto(c):=false;
A.card:=A.card-1;
end if;
end quitar;
procedure union(A,B:in conjcar; C:out conjcar) is
SOL:conjcar;
begin
SOL.card:=0;
for x in character loop
SOL.elmto(x):=A.elmto(x) or B.elmto(x);
if SOL.elmto(x) then
SOL.card:=SOL.card+1;
end if;
end loop;
C:=SOL;
end union;
procedure interseccion(A,B:in conjcar; C:out conjcar) is
SOL:conjcar;
begin
SOL.card:=0;
for x in character loop
SOL.elmto(x):=A.elmto(x) and B.elmto(x);
if SOL.elmto(x) then
SOL.card:=SOL.card+1;
end if;
end loop;
C:=SOL;
end interseccion;
function cardinal(A:in conjcar) return integer is
begin
return A.card;
end cardinal;
end conjuntos;
Como puede verse, se han escrito dos módulos diferente (“packages”, en Ada). El primero de ellos, denominado