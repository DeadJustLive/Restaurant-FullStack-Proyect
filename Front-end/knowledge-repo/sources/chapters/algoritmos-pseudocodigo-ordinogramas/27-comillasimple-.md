# COMILLA_SIMPLE = '\''

-- 35 of 180 --

Libro de Algoritmos de “Abrirllave.com” 36 / 180
Han aparecido dos nuevos símbolos reservados.
Símbolos reservados
Símbolo Descripción
' Se escribe delante y detrás de un valor de tipo carácter.
\ Se escribe delante del carácter comilla simple (') para representarlo
como un carácter.
3.3.5. Constantes de tipo cadena
Una constante de tipo cadena es aquella que representa a un valor –dato– de tipo cadena, es
decir, representa a una secuencia de caracteres.
EJEMPLO Las siguientes constantes de tipo cadena están expresadas por su valor:
"Alejandro"
"Lucerna"
"Barcelona 2000"
EJEMPLO Algunos ejemplos de declaración de constantes de tipo cadena son:
NOMBRE = "Alejandro"
CIUDAD = "Lucerna"
OLIMPIADAS = "Barcelona 2000"
EJEMPLO En lenguaje C, y en nuestro pseudocódigo CEE, para representar el carácter
comilla doble (") dentro de una cadena, se debe anteponer el carácter barra invertida (\).
FIESTA = "7 de julio \"San Fermín\""

-- 36 of 180 --

Libro de Algoritmos de “Abrirllave.com” 37 / 180
Ha aparecido un nuevo símbolo reservado.
" Se escribe delante y detrás de un valor de tipo cadena.
Y el símbolo reservado barra invertida (\) ha vuelto a aparecer.
\ Se escribe delante del carácter comilla doble (") para representarlo
dentro de una cadena.
Ejercicios resueltos
 Valores almacenados en memoria (de tipos definidos por el programador)
 Declaraciones correctas (de tipos definidos por el programador)

-- 37 of 180 --

Libro de Algoritmos de “Abrirllave.com” 38 / 180
Capítulo 4
Tipos de datos definidos por el
programador
Además de los tipos de datos simples predefinidos –vistos en el capítulo 2 “Tipos de datos”–
que proporcionan los lenguajes de programación, el programador tiene la posibilidad de
definir –declarar– sus propios tipos de datos. Los tipos de datos simples que puede definir el
programador son:
 Enumerados.
 Subrangos.
4.1. Datos de tipos enumerados
Un dato de un tipo enumerado es aquel que puede tomar por valor uno de los pertenecientes
a una lista ordenada de valores definida por el programador.
EJEMPLO El color de un semáforo puede ser uno de los siguientes:
{ rojo, verde, amarillo }
EJEMPLO Otro ejemplo de dato enumerado puede ser la dirección en la que se mueve un
coche. Los valores son:
{ norte, sur, este, oeste }
4.1.1. Declaración de tipos enumerados
En nuestro pseudocódigo CEE, para declarar un tipo de dato enumerado, vamos a utilizar la
sintaxis:

-- 38 of 180 --

Libro de Algoritmos de “Abrirllave.com” 39 / 180
enumerado <nombre_del_tipo> { <constante_1> [ = <valor_1> ],
<constante_2> [ = <valor_2> ],
...,
<constante_n> [ = <valor_n> ] }
Como se puede apreciar, los valores de la lista se representan por medio de identificadores de
constantes.
EJEMPLO Para declarar el tipo enumerado direcciones, se debe escribir:
enumerado direcciones { NORTE, SUR, ESTE, OESTE }
La lista de constantes está ordenada, y cada una de ellas representa a un valor entero
empezando por el 0, e incrementándose de uno en uno. De manera que, las constantes
declaradas representan a los valores enteros {0, 1, 2, 3}.
NORTE representa al valor 0
SUR representa al valor 1
ESTE representa al valor 2
OESTE representa al valor 3
Pero, dichos valores pueden ser diferentes si así se indica en la declaración.
EJEMPLO Se puede escribir:
enumerado direcciones { NORTE = -2, SUR, ESTE, OESTE }
En este caso, las constantes declaradas representan a los valores {-2, -1, 0, 1}, ya que, a
partir de la asignación NORTE = -2, las demás constantes de la lista toman valores
incrementándose de uno en uno.
NORTE representa al valor -2
SUR representa al valor -1
ESTE representa al valor 0
OESTE representa al valor 1
EJEMPLO También se puede escribir, por ejemplo:
enumerado direcciones { NORTE, SUR, ESTE = 4, OESTE }
Ahora, las constantes declaradas representan a los valores {0, 1, 4, 5}.
NORTE representa al valor 0

-- 39 of 180 --

Libro de Algoritmos de “Abrirllave.com” 40 / 180
SUR representa al valor 1
ESTE representa al valor 4
OESTE representa al valor 5
NORTE es la primera constante de la lista, en consecuencia, representa al valor 0. Después,
SUR representa al valor 1. Pero, a ESTE, que debería representar al valor 2, se le ha asignado
el valor 4 en la declaración, de manera que, OESTE representa al valor 5. Si después hubiese
otra constante en la lista, representaría al valor 6, y así sucesivamente.
Han aparecido dos nuevos símbolos reservados.
Símbolos reservados
Símbolo Descripción
{ Se escribe delante de la lista de identificadores de constantes de un tipo
de dato enumerado.
} Se escribe detrás de la lista de identificadores de constantes de un tipo de
dato enumerado.
Y el símbolo reservado coma (,) ha vuelto a aparecer.
, Separadora de los identificadores de las constantes de la lista asignada a
un tipo de dato enumerado.
4.1.2. Variables de tipos enumerados
Una variable de un tipo enumerado representa a un espacio de memoria en donde se puede
almacenar un dato de un tipo enumerado.
EJEMPLO Dadas las declaraciones:
enumerado direcciones { NORTE, SUR, ESTE, OESTE }
direcciones direccion_de_un_coche
direccion_de_un_coche es una variable del tipo enumerado direcciones. Por tanto,
en el espacio de memoria representado por la variable se podrá almacenar uno de los valores
{0, 1, 2, 3}.
EJEMPLO Las declaraciones del ejemplo anterior se pueden combinar de la forma siguiente:
enumerado direcciones { NORTE, SUR, ESTE, OESTE }
direccion_de_un_coche

-- 40 of 180 --

Libro de Algoritmos de “Abrirllave.com” 41 / 180
EJEMPLO También se pueden combinar prescindiendo del nombre –identificador– del tipo
de dato enumerado.
enumerado { NORTE, SUR, ESTE, OESTE } direccion_de_un_coche
Varias variables del mismo tipo de dato enumerado se pueden declarar de diferentes formas.
A continuación, se muestran algunos ejemplos.