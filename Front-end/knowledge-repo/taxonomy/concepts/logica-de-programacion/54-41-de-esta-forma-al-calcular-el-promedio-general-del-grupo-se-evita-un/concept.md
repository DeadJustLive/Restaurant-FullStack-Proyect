# 41. De esta forma, al calcular el promedio general del grupo se evita un

## Fuente
logica-de-programacion (Cap. 54)

## Contenido
# 41. De esta forma, al calcular el promedio general del grupo se evita un

posible error de ejecuci´on:
// Se asume 0 en el promedio cuando la cantidad de
// estudiantes es 0.
Si( cantidadEstudiantes >= 1 ) Entonces
promedioGrupo = sumaDefinitivas / cantidadEstudiantes
SiNo
promedioGrupo = 0
FinSi
Esta nueva decisi´on, verificar´ıa que la cantidad de estudiantes sea
m´ınimo de 1 y as´ı poder determinar el promedioGrupo; en caso contrario,
es decir que el valor sea 0 o un valor negativo, el algoritmo asignar´ıa el valor
de 0 a la variable promedioGrupo y este ser´a el resultado que informar´ıa.
En las Figuras 4.5 y 4.6 se muestra la soluci´on del Ejemplo 4.2 mediante
un diagrama de flujo.
Buena pr´actica:
Mediante las instrucciones necesarias se debe controlar
que los algoritmos no generen errores en su ejecuci´on;
como por ejemplo, cuando se trata de realizar la
divisi´on entre 0.
Algunos lenguaje de programaci´on poseen instrucciones adecuadas
para el manejo de errores y excepciones que facilitan este tipo de
control.
Tambi´en es posible definir condiciones que se deben garantizar para
que el algoritmo funcione correctamente. A estas condiciones se les
denomina precondiciones.

-- 199 of 450 --

198 Estructuras de repetici ´on
Inicio
cantidadEstudiantes
contadorEstudiantes= 0
aprobaron = 0
reprobaron = 0
sumaDefinitivas = 0
contadorEstudiantes
< cantidadEstudiantes
2
codigoEstudiante
1
promedioGrupo = sumaDefinitivas
/ cantidadEstudiantes
aprobaron
reprobaron
promedioGrupo
Final
No
S´ı
Figura 4.5: Algoritmo Estudiantes - Parte 1

-- 200 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 199
1
notaDefinitiva
notaDefintiva
>= 3.0
aprobaron = aprobaron + 1 reprobaron = reprobaron + 1
sumaDefinitivas =
sumaDefinitivas + notaDefintiva
contadorEstudiantes =
contadorEstudiantes + 1
2
S´ı 	No
Figura 4.6: Algoritmo Estudiantes - Parte 2
.:Ejemplo 4.3. Dise˜ne un algoritmo que reciba como dato de entrada un
n´umero entero perteneciente al sistema decimal1. Si cumple la condici´on de
ser positivo, informe el n´umero de cifras que posee, adicionalmente calcule
la sumatoria de ellas; en caso contrario, imprima un mensaje que diga que
el n´umero no es positivo.
An´alisis del problema:
Resultados esperados: la cantidad de cifras que tiene el n´umero
le´ıdo y la sumatoria de ellas. Adicionalmente un mensaje en el caso
que el n´umero no sea positivo.
Datos disponibles: un n´umero entero.
Proceso: leer un n´umero entero. Tomar una decisi´on para
determinar si es positivo, en caso de serlo se deben separar cada una
de sus cifras y simult´aneamente se van sumando; en caso contrario
informar que no es positivo.
1Sistema decimal: que tiene como base el n´umero 10.

-- 201 of 450 --

200 Estructuras de repetici ´on
Se puede determinar que un n´umero es positivo con la siguiente
decisi´on (Ver Figura 4.7).
¿numero > 0?
Separar las cifras
Calcular la sumatoria
S´ı
Informar que no es positivo
No
Figura 4.7: ´	Arbol de decisi´on del Ejemplo 4.3
La descomposici´on de un n´umero entero del sistema decimal en sus
respectivas cifras, se puede realizar con divisiones enteras sucesivas
entre 10. Suponga que desea separar las cifras que tiene el n´umero
8345, para ello se hacen las siguientes operaciones:
Iteraci´on Dividendo Divisor Cociente Resto
1 8345 10 834 5
2 834 10 83 4
3 83 10 8 3
4 8 10 0 8
Tabla 4.2: Descomposici´on del n´umero 8345 en cifras
Para mayor claridad en la siguiente explicaci´on, tenga presente el
nombre de los t´erminos que intervienen en una divisi´on: dividendo,
divisor, residuo (resto) y cociente. En una divisi´on entera, al residuo
se le denomina resto.
dividendo divisor
resto cociente
Como se anot´o anteriormente, la descomposici´on de un n´umero
entero en sus cifras, se logra haciendo divisiones sucesivas. El n´umero
de veces que se repite esta operaci´on, es igual al n´umero de cifras del
n´umero a descomponer (para este ejemplo es 4). El proceso termina
cuando el cociente tome un valor de 0.

-- 202 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 201
En la primera iteraci´on que se debe realizar se hace la siguiente
operaci´on:
8 3 4 5
3 4
4 5
5
1 0
8 3 4
Observe que el resto (residuo) es 5, que corresponde a la ´ultima cifra
del n´umero, y el cociente es 834, que equivale al n´umero original sin la
´ultima cifra. Para obtener estos valores se deben hacer dos divisiones
enteras2 entre 10.
La primera divisi´on que se efecutar´a ser´a el m´odulo o resto de la
divisi´on, para ello se usa el operador %: con el cual se consigue el
resto (residuo):
8345 % 10 = 5
Con la segunda divisi´on se obtiene el cociente, el cual va tomando
el valor del n´umero original pero reducido en una cifra; ese cociente
pasa a ser el dividendo en la siguiente iteraci´on, para obtenerlo se
hace una divisi´on entera entre 10 usando el operador /:
8345 / 10 = 834
En la segunda iteraci´on se hacen las mismas operaciones, teniendo
en cuenta que el cociente obtenido en la divisi´on anterior, pasa a ser
el nuevo dividendo:
8
