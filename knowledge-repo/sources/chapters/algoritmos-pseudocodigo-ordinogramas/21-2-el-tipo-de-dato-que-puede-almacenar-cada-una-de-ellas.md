# 2. El tipo de dato que puede almacenar cada una de ellas.

Durante la ejecución de un programa, el valor que tome el dato almacenado en una variable
puede cambiar tantas veces como sea necesario, pero, siempre, tomando valores
pertenecientes al tipo de dato que el programador ha decidido que puede almacenar dicha
variable, ya que, el tipo de dato de una variable no puede ser cambiado durante la ejecución
de un programa.
3.2.1. Declaración de variables
Para que un programa pueda hacer uso de una o más variables, estas deben ser declaradas
previamente. Todas las variables de un programa se declaran de la misma forma, indicando de
cada una de ellas:
 El tipo de dato que puede almacenar (mediante un identificador).
 Su nombre (mediante otro identificador).
EJEMPLO La declaración de una variable para almacenar la edad de una persona se escribe:
entero edad
Por tanto, en la memoria de la computadora se reservará un espacio para almacenar la edad:
En un programa no se pueden declarar varias variables con el mismo nombre, salvo
excepciones que estudiaremos más adelante. Sin embargo, sí pueden existir varias variables
del mismo tipo de dato.
Siguiendo con el ejemplo anterior, si también se quiere declarar una variable para almacenar
su número de hijos, se debe escribir:

-- 26 of 180 --

Libro de Algoritmos de “Abrirllave.com” 27 / 180
entero edad
entero numero_de_hijos
Las variables de un programa no tienen por qué estar contiguas en la memoria del ordenador:
Puesto que las dos variables son del mismo tipo de dato, se pueden declarar en la misma línea
separándolas por medio de una coma (,).
entero edad, numero_de_hijos
Opcionalmente, cuando se declara una variable, a esta se le puede asignar un valor inicial.
EJEMPLO Si se desea declarar una variable para almacenar un número entero y que,
inicialmente, contenga el valor 35, se debe escribir:
entero numero = 35

-- 27 of 180 --

Libro de Algoritmos de “Abrirllave.com” 28 / 180
Por consiguiente, para declarar una variable, en pseudocódigo utilizaremos la sintaxis:
<nombre_del_tipo_de_dato> <nombre_de_la_variable> [ = <expresión> ]
Y para declarar más de una variable del mismo tipo:
<nombre_del_tipo_de_dato> <nombre_de_la_variable_1> [ = <expresión_1> ],
<nombre_de_la_variable_2> [ = <expresión_2> ],
...,
<nombre_de_la_variable_n> [ = <expresión_n> ]
Los caracteres abrir corchete ([) y cerrar corchete (]) se utilizan para indicar que lo que
contienen es opcional.
Una expresión representa a un valor de un tipo de dato. En el ejemplo anterior, el valor 35 es
de tipo entero. Más adelante se estudiarán en detalle las expresiones.
Durante la ejecución de un programa, para hacer uso del espacio de memoria representado
por una variable, se utiliza su identificador.
Una variable puede ser declarada de cualquier tipo de dato (simple o compuesto). El tipo de
dato de una variable determina su tamaño en memoria, o dicho de otro modo, establece el
tamaño del espacio de memoria que se reserva para ella.
3.2.2. Símbolos reservados
Los símbolos reservados son aquellos caracteres que tienen un significado especial. En todos
los lenguajes de programación existe un conjunto de símbolos reservados. Hasta ahora,
solamente se han estudiado los símbolos utilizados en la sintaxis para declarar variables.
Símbolos reservados
Símbolo Descripción
= Separador del identificador de una variable y de su expresión asignada en
su declaración.
, Separadora de los identificadores de varias variables en su declaración.

-- 28 of 180 --

Libro de Algoritmos de “Abrirllave.com” 29 / 180
3.3. Constantes
Una constante representa a un valor –dato almacenado en memoria– que no puede cambiar
durante la ejecución de un programa.
En lenguaje C, una constante puede ser de tipo entero, real, carácter, cadena o enumerado.
Las constantes de tipo enumerado se van a estudiar en el capítulo siguiente. En cuanto a las
demás, se pueden expresar de dos formas diferentes:
 Por su valor.
 Con un nombre (identificador).
EJEMPLO Las siguientes constantes de tipo entero están expresadas por su valor:
-5
10
Para expresar una constante con un nombre, la constante debe ser declarada previamente.
Todas las constantes que se declaran en un programa son definidas de la misma forma,
indicando de cada una de ellas:
 Su nombre (mediante un identificador).
 El valor que simboliza (mediante una expresión).
En pseudocódigo, para declarar una constante, vamos a utilizar la sintaxis:
<nombre_de_la_constante> = <expresión>
Y para declarar más de una constante en una misma línea, las separaremos por medio de
comas (,).
EJEMPLO De modo que, si se quieren declarar las constantes de tipo entero del ejemplo
anterior, asignándoles un identificador, se puede escribir, por ejemplo: