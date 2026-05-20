# TEMPERATURA = -5, MES = 10

## Fuente
algoritmos-pseudocodigo-ordinogramas (Cap. 23)

## Contenido
# TEMPERATURA = -5, MES = 10

-- 29 of 180 --

Libro de Algoritmos de “Abrirllave.com” 30 / 180
Al igual que las variables de un programa, tampoco las constantes tienen por qué estar
contiguas en la memoria:
En programación es una buena práctica escribir los identificadores de las constantes en
mayúsculas, de esta forma es más fácil localizarlos en el código de un programa (o algoritmo).
Durante la ejecución de un programa, por medio del identificador de una constante, se puede
hacer referencia al valor (dato) que simboliza, tantas veces como sea necesario.
Los símbolos reservados igual (=) y coma (,) han vuelto a aparecer.
Símbolos reservados
Símbolo Descripción
= Separador del identificador de una constante y de su expresión asignada
en su declaración.
, Separadora de los identificadores de dos constantes en una misma línea.

-- 30 of 180 --

Libro de Algoritmos de “Abrirllave.com” 31 / 180
3.3.1. Constantes de tipo entero
Una constante de tipo entero es aquella que representa a un valor –dato– perteneciente al
subconjunto de Z representable por el ordenador.
EJEMPLO Suponiendo que el ordenador –utilizando dieciséis bits– pueda representar, en
Complemento a 2, el siguiente conjunto de valores enteros:
{ -32768, -32767, ..., -1, 0, 1, ..., 32766, 32767 }
Algunos ejemplos de constantes de tipo entero son:
-32000
0
000077
+1111
Obsérvese que, además de los caracteres numéricos, dígitos del (0) al (9), también se puede
hacer uso de los caracteres especiales (+) y (-) para indicar el signo de un número entero, el
cual es positivo por omisión. Sin embargo, en pseudocódigo, y también en lenguaje C, es
incorrecto usar los caracteres coma (,) y/o punto (.) para expresar constantes de tipo entero.
EJEMPLO Por tanto, es incorrecto escribir:
-32.000
0,0
+1,111.00
EJEMPLO Otros ejemplos incorrectos de constantes de tipo entero son:
++111 (No se puede duplicar el signo).
38000 (No pertenece al subconjunto de Z representable por el ordenador).
Han aparecido dos nuevos símbolos reservados.
Símbolos reservados
Símbolo Descripción
+ Indica que el número es positivo (es opcional).
- Indica que el número es negativo.

-- 31 of 180 --

Libro de Algoritmos de “Abrirllave.com” 32 / 180
3.3.2. Constantes de tipo real
Una constante de tipo real es aquella que representa a un valor –dato– perteneciente al
subconjunto de R representable por el ordenador.
EJEMPLO Algunos ejemplos son:
8.12
000.333 (Los ceros a la izquierda no son significativos)
+1111.809
-3200. (También se puede escribir -3200.0)
.56 (También se puede escribir 0.56)
Obsérvese que, además de los caracteres numéricos, dígitos del (0) al (9), también se puede
hacer uso de los caracteres especiales (+) y (-) para indicar el signo de un número real.
Además, en lenguaje C y, por tanto, también en nuestro pseudocódigo CEE, obligatoriamente
debe aparecer el carácter punto (.), o el carácter (e) o (E) seguido del exponente, del cual
también puede indicarse su signo con los caracteres (+) y (-). Los signos del exponente y del
número en sí, por omisión, son positivos.
EJEMPLO Las siguientes constantes de tipo real están expresadas correctamente:
-77e-3
+1111e+2
2000E+2
3040e2
Una constante de tipo real también se puede expresar con el carácter punto (.) y el exponente
al mismo tiempo.
EJEMPLO Algunos ejemplos son:
-50.50e-4
400.e-3
+65.65E+2
.7e3
El exponente tiene la función de desplazar la posición del punto decimal hacia la derecha si es
positivo, o hacia la izquierda si es negativo.

-- 32 of 180 --

Libro de Algoritmos de “Abrirllave.com” 33 / 180
EJEMPLO Así pues, las siguientes constantes de tipo real representan al mismo valor:
0.004E+3
4.
.4e1
+400.00e-2
4000E-3
EJEMPLO Algunos ejemplos de constantes de tipo real incorrectas son:
-200 (No aparece el punto ni el exponente)
-20,0 (No puede aparecer la coma)
--111. (No se puede duplicar el signo)
-111.. (No se puede duplicar el punto)
-111.11. (No puede aparecer más de un punto)
+22e (Después del carácter (e) o (E) se debe escribir el exponente)
+22ee6 (No se puede duplicar el carácter (e) o (E))
+22e 6 (No se puede escribir el carácter espacio en blanco)
38E-2.2 (El exponente debe ser una cantidad entera)
EJEMPLO El número  (pi) y el número e, son dos ejemplos de valores reales –datos–
frecuentemente declarados como constantes en los programas que hacen uso de ellos.
PI = 3.141592
NUMERO_E = 2.718281
El número e es el límite de la expresión (1+1/n)n cuando n tiende a infinito.

-- 33 of 180 --

Libro de Algoritmos de “Abrirllave.com” 34 / 180
Han aparecido tres nuevos símbolos reservados.
Símbolos reservados
Símbolo Descripción
. Separador de la parte entera y decimal de un número real.
e Separador de un número real y su exponente.
E Separador de un número real y su exponente.
3.3.3. Constantes de tipo lógico
Una constante de tipo lógico es aquella que representa a un valor –dato– perteneciente al
conjunto:
{ verdadero, falso }
verdadero y falso son palabras reservadas –identificadores– que, en sí mismas,
representan 
