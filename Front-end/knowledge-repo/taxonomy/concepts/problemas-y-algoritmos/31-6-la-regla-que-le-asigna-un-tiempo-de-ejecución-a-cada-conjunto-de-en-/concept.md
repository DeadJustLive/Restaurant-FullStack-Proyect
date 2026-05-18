# 6. La regla que le asigna un tiempo de ejecución a cada conjunto de en-

## Fuente
problemas-y-algoritmos (Cap. 31)

## Contenido
# 6. La regla que le asigna un tiempo de ejecución a cada conjunto de en-

tradas en un programa.
Con estos ejemplos debe de quedar claro que una función puede ser
cualquier regla que le asigne elementos de un conjunto Y a los elementos de
un conjunto X, y cualquier regla se reere a que las reglas pueden no ser de-
scritas por alguna ecuación o expresión algebrárica, pueden no estar denidas
en todos los números, pueden incluso no estar denidas en números(como en
el ejemplo 3), y es posible que en algunos casos(como en el ejemplo 5) no se
conozca a qué números u objetos se puede aplicar.
Si una función le asigna un elemento de un conjunto Y a cada elemento
de un conjunto X entonces se dice que el dominio de la función es de dominio
X y la codominio Y .
Aunque no es un requisito, las funciones se suelen designar por la letra
f , y cuando hay mas de una función se suelen usar también las letras g y h.
Si f es una función, x una variable tal que x ∈ X, entonces el valor que f
asocia con x se expresa como f (x) y se lee como f de x.
La función del primer ejemplo se puede expresar como:
f (x) = x
2 para todo número real n
La del segundo ejemplo se puede denir como
f (n) = (n)(n + 1)
2 para todo entero positivo n
El tercer ejemplo no se puede denir completamente con esta notación,
ya que no hay expresión algebrarica que represente una CURP o un ciu-
dadano, y tampoco conocemos un procedimiento para encontrar la CURP;

-- 92 of 315 --

7.1. LAS FUNCIONES COMO REGLAS 93
solamente sabemos que el dominio es el conjunto de ciudadanos y la imagen
es el conjunto de las CURPs.
Por este motivo es necesario denir mas notación. Si f es una función, D
su dominio y C su codominio, se puede denotar de la siguiente manera:
f : D −→ C
Así ya podemos expresar el tercer ejemplo como una función:
f : D −→ C donde D es un conjunto de ciudadanos y C es un conjunto de CURPs
El cuarto ejemplo tambien puede resultar peculiar, ya que muchas veces
se espera que el dominio de una función sea un solo número y no dos. Para
ser precisos el dominio de la función del cuarto ejemplo es el conjunto de
todos los pares órdenados de números reales (a, b), el cual se representa como
R2.
Asi que el cuarto ejemplo se puede describir así:
f (a, b) = a + b
2 para todo par de números (a, b) ∈ R2
Para el quinto ejemplo no hay mas remedio que enumerar los valores
conocidos:
f (x) = √2, si x = 53
= 1
2, si x = 42
= π, si x = 3
4
El sexto ejemplo habla de una función que corresponde al tiempo que tar-
da en ejecutarse un programa con determinada entrada; esta función cobrará
mucha importancia mas adelante y se le conoce como la función de tiempo.
Después de usar mucho tiempo las funciones, es natural comenzar a pensar
en abreviaturas, como con el primer ejemplo f (x) = x
2 para todo número
real n podría parecernos muy largo, así que muchas veces por practicidad
se omite la descripción del dominio de la función y se deberá asumir que el
dominio es el conjunto de todos los números reales para los cuales la función
tiene sentido.
Por ejemplo para la función f (x) = 1
x se sobreentiende que el dominio es
todos los números reales excepto el 0. Sin embargo existen muchos intentos
por abreviar aún más esta notación pero la mayoría resultan inadecuados.

-- 93 of 315 --

94 CAPÍTULO 7. FUNCIONES
Por ejemplo sustituir f (x) = x
2 por x
2 equivaldría a hablar de un número
real en lugar de una función; la única manera aceptable de abreviar esto
aún más es como x → x
2 , esto no representa una gran mejoría en cuanto a
la abreviación y en ocaciones puede parecer menos claro, la única ventaja
que parece tener esta notación es que no hay que asignarle un nombre a la
función y puede servir cuando se esté trabajando con muchas funciones y no
sea necesario nombrar a todas.
Luego de ver estos ejemplos es clara la ventaja de ver las funciones como
reglas y no solamente como máquinas, ya que es mas claro imaginar una
regla implícita que una máquina implícita, y no queda claro que una máquina
simpre devuelva la misma salida para una entrada dada.
7.2. El Concepto Formal de Función
A pesar de que se pueden inferir muchas cosas imaginando a las funciones
como reglas, el concepto de regla es subjetivo, es preferible denir algo en base
a cosas ya conocidas y con propiedades bien denidas.
La palabra regla puede signicar distintas cosas en distintos contextos.
Algo que sabemos muy bien cómo se comportan son los conjuntos y los pares
ordenados. Deniremos una función a partir de esto para que no quede duda
de qué es ó cómo se comporta una función.
Primero que nada necesitamos denir un concepto bastante importante
en muchas áreas de las matemáticas, y este es el del producto cartesiano, este
concepto se reere al conjunto de todos los pares ordenados formados por
elementos de dos conjuntos dados.
Por ejemplo, el producto cartesiano de Z y Z son todos los puntos del
plano cartesiano cuyas cordenadas son enteras.
El producto cartesiano de {1, 2} y {3, 4} es {(1, 3), (1, 4), (
