# RESULTADOS

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 251)

## Contenido
# RESULTADOS

Número de clientes servidos: 19
Tiempo medio de espera (en minutos): 0.68
En los tres casos, un cliente llega, en media, cada diez minutos. El tiempo de servicio de cada cliente es de cinco
minutos. La observación más interesante sobre los resultados anteriores es la variación de los resultados. Dada la frecuencia
de llegada de clientes (uno cada diez minutos) y la longitud de la simulación (200 minutos), el número esperado de clientes
servidos debe ser 20, con una cierta varianza alrededor de la media, y en efecto así ocurre. Sin embargo, la gran varianza
del tiempo medio de espera en la cola es sorprendente.
El algoritmo anterior puede modificarse de forma que se ejecute la simulación de 200 minutos un total de 200 veces,
para el mismo valor de la velocidad de llegadas (1 cliente cada 10 minutos) y para un valor dado del tiempo de servicio.
Los resultados que pueden obtenerse de este nuevo algoritmo son, por ejemplo, el máximo tiempo de espera de un cliente
(en las 200 simulaciones), la espera media en las 200 simulaciones, la espera media mínima y la espera media máxima de
entre las 200 simulaciones.
En la tabla siguiente se muestran los resultados obtenidos ejecutando el algoritmo modificado para distintos valores
del tiempo de servicio. Por ejemplo, la primera línea refleja que para un tiempo de servicio de 3 minutos, la espera máxima
de un cliente en las 200 simulaciones fue de 6 minutos. El tiempo medio de espera fue 0.40 minutos; sin embargo, en (al
menos) una simulación de las 200 el tiempo medio de espera fue 0.0 mientras que en otra fue 1.29 minutos.

-- 93 of 267 --

86
Tiempo
de servicio
Máxima
espera4
Espera
media
Mínima
espera media
Máxima
espera media
3 	6 	0.40 	0.00 	1.29
4 	11 	0.90 	0.00 	3.35
5 	23 	1.69 	0.00 	5.96
6 	38 	2.81 	0.27 	16.82
7 	48 	5.55 	0.20 	24.00
8 	70 	7.80 	0.28 	34.48
Si el tiempo de servicio se aproxima al tiempo medio entre dos llegadas consecutivas de clientes, el sistema se aproxima
a un estado de saturación. Si la velocidad de llegadas fuese mayor que la de servicio, obviamente el número de clientes en
la cola aumentaría ad infinitum. Lo más sorprendente vuelve a ser que para un sistema lejos del estado de saturación, la
variación de los resultados puede ser grande.
Por ejemplo, para un tiempo de servicio de 5 minutos y los clientes llegando en media cada 10 minutos, al menos un
cliente tuvo que esperar en cola durante 23 minutos. En una de las 200 simulaciones, para esos mismos valores de entrada,
el tiempo medio de espera en cola fue de 5.96 minutos (superior incluso que el tiempo de servicio), mientras que en otra de
las simulaciones el tiempo medio de espera en cola fue de 0.0 minutos (es decir, ninguno de los clientes servidos en los 200
minutos de esa simulación tuvo que hacer cola).
La simulación propuesta en esta lección es la más sencilla que puede plantearse y, de hecho, existen fórmulas
analíticas que permiten obtener los resultados buscados sin realizar ninguna simulación (por ejemplo, si el tiempo entre
dos llegadas consecutivas es una variable aleatoria exponencial de parámetro λ y el tiempo de servicio es otra variable
aleatoria exponencial de parámetro μ, entonces el tiempo medio de espera de un cliente en la cola es Wq=(1/μ2 )/(1-λ/μ). El
estudio de modelos de colas como el propuesto aquí y de otros más realistas y complejos, y su análisis, es el objeto de la
denominada Teoría de Colas.
4
…	…

-- 94 of 267 --

87
