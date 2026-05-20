# 5. El resto anterior (rn−1), es decir, el ´ultimo divisor es el MCD de a

## Fuente
logica-de-programacion (Cap. 59)

## Contenido
# 5. El resto anterior (rn−1), es decir, el ´ultimo divisor es el MCD de a

y b.
De igual manera se establece que:
mcm = a ∗ b
M CD
An´alisis del problema:
Resultados esperados: de acuerdo al enunciado, el algoritmo debe
informar el MCD y el mcm de dos n´umeros enteros.
Datos disponibles: el usuario del algoritmo proporcionar´a dos
valores enteros (a y b).
Proceso: una vez se ingresen los dos n´umeros (a y b), se debe
garantizar que se cumpla la condici´on que a > b, en caso contrario,
se debe hacer el cambio de valores entre las dos variables (Ver Figura
4.12).
5El MCD es el mayor n´umero que divide exactamente a dos o m´as n´umeros.
6El mcm es el n´umero m´as peque˜no, que no sea 0, que es m´ultiplo de dos o m´as
n´umeros.

-- 215 of 450 --

214 Estructuras de repetici ´on
¿a > b?
No se hace ning´un cambio
s´ı
a toma el valor de b
b toma el valor de a
no
Figura 4.12: ´	Arbol de decisi´on del Ejemplo 4.5
Mediante el siguiente ejemplo se analizar´a el procedimiento explicado
en los pasos anteriores. Suponga que se desea encontrar el MCD y el
mcm de 532 y 112.
