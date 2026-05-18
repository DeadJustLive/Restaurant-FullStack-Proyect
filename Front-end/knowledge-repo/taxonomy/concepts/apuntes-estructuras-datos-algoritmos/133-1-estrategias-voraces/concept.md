# 1. Estrategias voraces

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 133)

## Contenido
# 1. Estrategias voraces

Un algoritmo voraz (o ávido; del inglés, greedy) se basa en construir la solución del problema dado en sucesivos pasos
de forma que en cada paso la solución parcial adoptada sea localmente óptima en algún sentido.
Un ejemplo cotidiano para el que aplicamos una solución voraz es el problema de dar el cambio en monedas,
resultante tras el pago de una compra. Supongamos que disponemos en la caja de monedas de 100, 50, 25, 5 y 1 unidades
monetarias, y tenemos que dar un cambio de 63 unidades, deseando hacerlo con el menor número posible de monedas.
El procedimiento que seguimos consiste en seleccionar primero la moneda más grande cuyo valor no sea mayor que la
cantidad a devolver, y para la cantidad restante aplicamos el mismo método (resultando una de 50, dos de 5 y tres de 1
unidad, es decir, un total de seis monedas). De esta forma, en cada paso intentamos dar el menor número posible de monedas
(solución localmente óptima).
Una estrategia voraz, como la presentada en el ejemplo anterior, no necesariamente lleva a la solución del problema.
En el caso del cambio en monedas, el algoritmo voraz lleva a la solución óptima (menor número de monedas) debido a las
propiedades de los valores de las monedas (100, 50, 25, 5, 1). Si, por ejemplo, los valores de las monedas fueran de 11, 5 y
1 unidades y el cambio a devolver fuera de 15 unidades, el algoritmo voraz nos llevaría a seleccionar en primer lugar la
moneda de 11 unidades, y el resto tendríamos que devolverlo con cuatro monedas de 1 unidad (es decir, con un total de
cinco monedas). Sin embargo, la solución óptima consiste en devolver tres monedas de 5 unidades1.
