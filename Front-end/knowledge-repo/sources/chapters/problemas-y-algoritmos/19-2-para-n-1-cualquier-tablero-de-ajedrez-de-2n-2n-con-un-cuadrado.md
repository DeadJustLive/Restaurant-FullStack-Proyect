# 2. Para n ≥ 1 cualquier tablero de ajedrez de 2n × 2n, con un cuadrado

faltante, puede ser cubierto con triminos de solo 3 colores(de man-
era que 2 triminos del mismo color no tengan bordes en común), sin
importar en dónde esté el cuadro faltante.

-- 30 of 315 --

1.4. PROBLEMAS 31
1.4.3. Chocolate
Tiempo Límite:1 Segundo
Supongamos que tenemos una barra de chocolate de m x n piezas cuadradas
de 1x1(es una suposición, por lo tanto no puedes comertela) y debes partirla
en cuadrados de 1 x 1.
Las partes del chocolate pueden ser cortadas a través de cortes horizon-
tales y/o verticales como se muestra en la gura. Un corte(ya sea horizontal o
vertical) de un pedazo del chocolate siempre divide ese pedazo en dos pedazos
mas pequeños.
Como todo cuesta en esta vida, cada corte que realizes en el chocolate
también tendrá un costo, dicho costo se puede expresar como un número
entero positivo. Este costo no depende del tamaño del pedazo que se corte,
sino que depende de la recta horizontal o vertical por la cual se esté cortando.
Denotaremos los costos de cortar por cada recta vertical como x1, x2, x3, ..., xm−1
y los costos de cortar por cada recta horizontal como y1, y2, y3, ..., yn−1 .
El costo de cortar la barra entera es la suma de los costos de todos los
cortes requeridos.
Por ejemplo, si cortamos el chocolate a lo largo de las rectas horizontales
y después cada pedazo obtenido lo cortamos a lo largo de las rectas verticales,
el costo total por cortar la barra será y1+ y2+ y3+4(x1+ x2+ x3+ x4+ x5 ).
Problema
Escribe un programa que dado el tamaño de la barra de chocolate, deter-
mine el costo mínimo para cortarla en cuadrados de 1x1.
Entrada
Descripción
Línea 1: Dos enteros positivos m y n separados por un espacio
Siguientes m -1 líneas: Los valores de x1, x2, x3, ..., xm−1
Siguientes n -1 líneas: Los valores de y1, y2, y3, ..., yn−1

-- 31 of 315 --

32 CAPÍTULO 1. INDUCCIÓN MATEMÁTICA
Ejemplo
6 4
2
1
3
1
4
4
1
2
Salida
Descripción
Línea 1: Un solo número entero: el costo mínimo de cortar todo el choco-
late en cuadrados de 1x1
Ejemplo
42
Límites
2 ≤ m, n ≤ 1000
Ninguno de los costos superará a 1000
Referencias
Fuente: X Polish Olympiad in Informatics 2002/2003
Autor: Marcin Kubica
Traductor: Luis Enrique Vargas Azcona

-- 32 of 315 --

1.5. SUGERENCIAS 33
1.5. Sugerencias
Esta sección está dedicada a dar pistas para encontrar algunas soluciones
de los problemas del capítulo. Suele ser mejor leer una sugerencia y volver a
intentar el problema que pasar directo a la solución.
Sumas
Sugerencia para el quinto inciso: intenta demostrar que si puedes formar
5 números consecutivos n, n+1, n+2, n+3 y n+4, entonces también puedes
formar n + 5, n + 6, n + 7, n + 8 y n + 9.
Tablero de Ajedrez
Sugerencias para el conteo de cuadros blancos y negros: