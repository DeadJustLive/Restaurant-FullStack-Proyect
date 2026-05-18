# INGENIERIA DE SISTEMAS

## Fuente
estructuras-de-datos (Cap. 74)

## Contenido
# INGENIERIA DE SISTEMAS

f/c 1 2 3 4 5 6
1 8
2 20
3 10
4 7
5 5
6 2
Se podría representar usando un vector para almacenar los datos de la diagonal secundaria así:
1 2 3 4 5 6
8 20 10 7 5 2
La fórmula de direccionamiento Pos =i si hacemos la representación por filas
Si hacemos la representación por columnas se obtiene:
1 2 3 4 5 6
2 5 7 10 20 8
Y la fórmula de direccionamiento es:
Pos=j
Se debe tener en cuenta que para pertenecer a la diagonal secundaria un elemento ubicado en i, j de la matriz
debe cumplir que Para todo i, j : i + j=n+1

-- 54 of 64 --

55
