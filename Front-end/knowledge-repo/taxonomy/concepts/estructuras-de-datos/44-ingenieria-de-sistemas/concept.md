# INGENIERIA DE SISTEMAS

## Fuente
estructuras-de-datos (Cap. 44)

## Contenido
# INGENIERIA DE SISTEMAS

3.3.3 REPRESENTACIÓN DE MATRICES EN TRIPLETAS:
Cada elemento de la matriz está definido por sus posiciones i,j las cuales representan la fila y la columna
respectivamente y para referenciar el elemento debemos escribir la fila, la columna y el valor. Podemos
almacenar la matriz como una lista de tripletas i, j, valor.
La tripleta en su posición cero define el orden de la matriz y el número de elementos diferentes de cero. Para
definir objetualmente el problema se debe definir: Una clase matriz que retorna un objeto de la clase tripleta.
Otra clase denominada matriz en tripletas.
La representación gráfica de matriz en tripletas es:
0 5 5 10
1 1 3 2
2 1 4 -2
3 2 4 5
4 3 1 3
5 3 2 4
6 3 4 1
7 3 5 2
8 4 3 2
9 4 5 1
10 5 4 2
Definición de algoritmos orientados a objetos con las matrices dispersas representadas en tripletas
Clase tripleta
Esta es la representación de la clase tripleta
Clase tripleta
Privado: //la parte privada define las características
Entero fila,columna // principales de la clase y sus tipos asociados
Objeto valor

-- 42 of 64 --

43
