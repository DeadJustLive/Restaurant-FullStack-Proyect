# INGENIERIA DE SISTEMAS

## Fuente
estructuras-de-datos (Cap. 84)

## Contenido
# INGENIERIA DE SISTEMAS

Su respectiva representación por filas de la matriz dispersa en un vector seria:
1 2 3 4 5 6 7 8 9 10
8 5 15 9 6 11 2 10 20 1
En este caso y por el mismo método de inducción matemática sugerido en el análisis de la anterior formula de
direccionamiento se encuentra que:
pos=2*(i - 1) + j
Para todo i,j tal que valor absoluto(i-j)<2
Nota: el proceso inverso de determinar los subíndices i y j conocido pos y n y la formula de direccionamiento,
basta con dividir la posición por 2 y sumarle 1 al cociente para obtener la fila i. Conocido i despejamos j usando
la formula.
Otras fórmulas de direccionamiento con matrices dispersas se pueden encontrar en:
Estructuras de Datos para Matrices Dispersas.© UPV Enlace

-- 57 of 64 --

58
