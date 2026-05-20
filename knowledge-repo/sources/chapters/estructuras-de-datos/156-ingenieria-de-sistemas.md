# INGENIERIA DE SISTEMAS

f/c 1 2 3 4 5 6
1 10
2 2
3 5
4 38
5 20
6 16
n=6
Si representamos la matriz en forma tradicional gastamos n2 posiciones de memoria, de los cuales se usan
solamente n, para ahorrar memoria debemos de utilizar un vector de n posiciones para almacenar los datos de
la diagonal principal así:
1 2 3 4 5 6
10 2 5 38 20 16
La representación anterior queda como la de un vector con tamaño igual a la cantidad de elementos diferentes
de cero de la matriz dispersa diagonal principal.
La fórmula de direccionamiento es:
pos =i o pos =j y es válida para los elementos de la matriz m[i][j] que cumplan que i=j (se debe decir para cual
rango de filas y columnas es válida dicha fórmula)
4.1.3.2 Matriz de diagonal secundaria
Sea la matriz que representa los elementos de la diagonal secundaria:

-- 53 of 64 --

54