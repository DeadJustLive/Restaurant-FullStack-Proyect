# módulo m: onederos

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 211)

## Contenido
# módulo m: onederos

importa monedas
exporta
tipo monedero
procedimiento vacio(sal s:monedero)
procedimiento meter(e/s s:monedero; ent m:moneda)
procedimiento sacar(e/s s:monedero; ent m:moneda)
función cuántas(s:monedero; m:moneda) devuelve natural
función valor(s:monedero) devuelve natural
implementación
tipo monedero=vector[moneda] de natural
procedimiento vacio(sal s:monedero)
variable m:moneda
principio
para m:=c1 hasta e1 hacer
s[m]:=0
fpara
fin
procedimiento meter(e/s s:monedero; ent m:moneda)
principio
s[m]:=s[m]+1
fin
procedimiento sacar(e/s s:monedero; ent m:moneda)
principio
si s[m]>0 entonces
s[m]:=s[m]-1
fsi
fin
función cuántas(s:monedero; m:moneda) devuelve natural
principio
devuelve s[m]
fin
función valor(s:monedero) devuelve natural
variables v:natural; m:moneda
principio
v:=0;
para m:=c1 hasta e1 hacer
v:=v+cuántas(s,m)*precio(m)
fpara;
devuelve v
fin
fin
A continuación, hagamos lo mismo con los TAD fruta y frutero (colección de frutas).

-- 47 of 267 --

40
Sus especificaciones:
espec frutas
usa naturales
género fruta
{Los valores del TAD fruta representan valores posibles de una fruta}
operaciones
pera: -> fruta
{devuelve una pera}
manzana: -> fruta
{devuelve una manzana}
limón: -> fruta
{devuelve un limón}
pomelo: -> fruta
{devuelve un pomelo}
papaya: -> fruta
{devuelve una papaya}
precio: fruta f -> natural
{devuelve el valor de la fruta f}
fespec
espec frutero
usa frutas, naturales
género frutero
{Los valores del TAD frutero representan valores posibles de un multiconjunto (saco) de frutas}
operaciones
vacio: -> frutero
{devuelve un frutero vacío, sin frutas}
meter: frutero s, fruta f -> frutero
{devuelve el frutero resultante de añadir la fruta f a s}
sacar: frutero s, fruta f -> frutero
{devuelve el frutero resultante de extraer la fruta f de s;
si no hay ninguna fruta f en s, devuelve un frutero igual a s}
cuántas: frutero s, fruta f -> natural
{cuenta cuántas frutas de valor f hay en s}
valor: frutero s -> natural
{devuelve la suma del precio de todas las frutas de s}
fespec
La implementación en pseudocódigo de frutas y fruteros sería idéntica a la de monedas y monederos, sustituyendo
“moneda” por “fruta” y “monedero” por “frutero”. No la repetimos.
Con objeto de ahorrar tiempo y de realizar una especificación y una implementación más reutilizables, procedemos
a especificar e implementar un TAD genérico, saco, que puede hacer el papel (concretándolo o particularizándolo cuando
se necesite) tanto de frutero como de monedero:
espec sacosGenéricos
usa naturales
parámetro formal
género elemento
operación
precio: elemento e -> natural
_=_ : elemento e1, elemento e2 -> booleano
{el parámetro es un tipo no definido (elemento) al que se le exigirá tener definidas
una operación con el perfil que tiene la operación precio y otra operación de igualdad}
fpf
género saco
{Los valores del TAD genérico saco representan valores posibles de un multiconjunto de elementos}
operaciones
vacio: -> saco

-- 48 of 267 --

41
{devuelve un saco vacío, sin elementos}
meter: saco s , elemento e -> saco
{devuelve el saco resultante de añadir el elemento e a s}
sacar: saco s , elemento e -> saco
{devuelve el saco resultante de extraer el elemento e de s;
si no hay ningún elemento e en s, devuelve un saco igual a s}
cuántas: saco s , elemento e -> natural
{cuenta cuántas unidades del elemento e hay en s}
valor: saco s -> natural
{devuelve la suma del precio de todos los elementos de s; para su cálculo será preciso usar la operación
precio, que deberá estar definida para los datos de tipo elemento}
fespec
La implementación genérica del TAD (genérico) saco tendría la forma siguiente:
módulo genérico sacosGen
parámetros
tipo elemento
con función precio(e:elemento) devuelve natural
con función “=”(e1,e2:elemento) devuelve booleano
exporta
constante maxNum = 1000000
tipo saco
procedimiento vacio(sal s:saco)
procedimiento meter(e/s s:saco; ent e:elemento)
procedimiento sacar(e/s s:saco; ent e:elemento)
función cuántas(s:saco; e:elemento) devuelve natural
función valor(s:saco) devuelve natural
implementación
tipo unElemto = registro
elElemto:elemento;
numVecesRepetido:natural
freg
elementos = vector[1..maxNum] de unElemto
saco = registro
losElementos:elementos;
numDistintos:natural
freg
procedimiento vacio(sal s:saco)
variable e:elemento
principio
s.numDistintos:=0
fin
...
{Dejamos como ejercicio escribir el resto de la implementación, teniendo en
cuenta que el tipo “elemento” es un parámetro formal, es decir, es sólo un
nombre de tipo y no sabemos más características de él, salvo que tendrá
siempre definida una función “precio” con el perfil indicado.}
fin

-- 49 of 267 --

42
Finalmente, para poder usar un TAD genérico, como el TAD saco, es necesario antes concretarlo o particularizarlo,
indicando con qué tipo se corresponde su parámetro formal elemento.
procedimiento tití
importa monedas,frutas,sacosGen
{En los módulos ‘monedas’ y ‘frutas’ están definidos los tipos moneda, fruta, y
una función ‘precio’ para monedas 
