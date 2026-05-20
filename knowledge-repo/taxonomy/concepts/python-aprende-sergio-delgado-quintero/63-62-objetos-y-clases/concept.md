# 6.2 Objetos y Clases

## Fuente
Aprende Python (Cap. 63)

## Contenido
# 6.2 Objetos y Clases

Hasta ahora hemos estado usando objetos de forma totalmente transparente, casi sin ser
conscientes de ello. Pero, en realidad, todo en Python es un objeto, desde números
a funciones. El lenguaje provee ciertos mecanismos para no tener que usar explícitamente
técnicas de orientación a objetos.
Llegados a este punto, investigaremos en profundidad sobre la creación y manipulación de
clases y objetos, y todas las operaciones que engloban este paradigma.1
6.2.1 Programación orientada a objetos
La programación orientada a objetos (POO) o en sus siglas inglesas OOP es una manera de
programar que permite llevar al código mecanismos usados con entidades de la vida real.
Sus beneficios son los siguientes:
Encapsulamiento Permite empaquetar el código dentro de una unidad (objeto) donde
se puede determinar el ámbito de actuación.
Abstracción Permite generalizar los tipos de objetos a través de las clases y simplificar
el programa.
Herencia Permite reutilizar código al poder heredar atributos y comportamientos de una
clase a otra.
1 Foto original por Rabie Madaci en Unsplash.
6.2. Objetos y Clases 251

-- 255 of 516 --

Aprende Python
Polimorfismo Permite crear múltiples objetos a partir de una misma pieza flexible de
código.
Figura 7: Beneficios de la Programación Orientada a Objetos
¿Qué es un objeto?
Un objeto es una estructura de datos personalizada que contiene datos y código:
Elementos ¿Qué son? ¿Cómo se llaman? ¿Cómo se identifican?
Datos Variables Atributos Nombres
Código Funciones Métodos Verbos
Un objeto representa una instancia única de alguna entidad a través de los valores de sus
atributos e interactuan con otros objetos (o consigo mismos) a través de sus métodos.
252 Capítulo 6. Modularidad

-- 256 of 516 --

Aprende Python
Figura 8: Analogía de atributos y métodos en un objeto «bicicleta»
¿Qué es una clase?
Para crear un objeto primero debemos definir la clase que lo contiene. Podemos pensar en
la clase como el molde con el que crear nuevos objetos de ese tipo.
En el proceso de diseño de una clase hay que tener en cuenta – entre otros – el principio
de responsabilidad única7, intentando que los atributos y los métodos que contenga estén
enfocados a un objetivo único y bien definido.
6.2.2 Creando objetos
Empecemos por crear nuestra primera clase. En este caso vamos a modelar algunos de los
droides de la saga StarWars:
Para ello usaremos la palabra reservada class seguido del nombre de la clase:
>>> class StarWarsDroid:
... pass
...
7 Principios SOLID
2 Fuente de la imagen: Astro Mech Droids.
6.2. Objetos y Clases 253

-- 257 of 516 --

Aprende Python
Figura 9: Ejemplificación de creación de objetos a partir de una clase
Figura 10: Droides de la saga StarWars2
254 Capítulo 6. Modularidad

-- 258 of 516 --

Aprende Python
Consejo: Los nombres de clases se suelen escribir en formato CamelCase y en singular3.
Existen multitud de droides en el universo StarWars. Una vez que hemos definido la clase
genérica podemos crear instancias/objetos (droides) concretos:
>>> c3po = StarWarsDroid()
>>> r2d2 = StarWarsDroid()
>>> bb8 = StarWarsDroid()
>>> type(c3po)
__main__.StarWarsDroid
>>> type(r2d2)
__main__.StarWarsDroid
>>> type(bb8)
__main__.StarWarsDroid
Añadiendo atributos
Un atributo no es más que una variable, un nombre al que asignamos un valor, con la
particularidad de vivir dentro de una clase o de un objeto.
Los atributos – por lo general – se suelen asignar durante la creación de un objeto, pero
también es posible añadirlos a posteriori:
>>> blue_droid = StarWarsDroid()
>>> golden_droid = StarWarsDroid()
>>> golden_droid.name = C-3PO
>>> blue_droid.name = R2-D2
>>> blue_droid.height = 1.09
>>> blue_droid.num_feet = 3
>>> blue_droid.partner_droid = golden_droid # otro droide como atributo
Una vez creados, es muy sencillo acceder a los atributos:
>>> golden_droid.name
C-3PO
>>> blue_droid.num_feet
3
3 Guía de estilos PEP8 para convenciones de nombres.
6.2. Objetos y Clases 255

-- 259 of 516 --

Aprende Python
Hemos definido un droide «socio». Veremos a continuación que podemos trabajar con él de
una manera totalmente natural:
>>> type(blue_droid.partner_droid)
__main__.StarWarsDroid
>>> blue_droid.partner_droid.name # acceso al nombre del droide socio
C-3PO
>>> blue_droid.partner_droid.num_feet # aún sin definir!
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
AttributeError: StarWarsDroid object has no attribute num_feet
>>> blue_droid.partner_droid.num_feet = 2
Añadiendo métodos
Un método es una función que forma parte de una clase o de un objeto. En su ámbito tiene
acceso a otros métodos y atributos de la clase o del objeto al que pertenece.
La definición de un método (de instancia) es análoga a la de una función ordinaria, pero
incorporando un primer parámetro self que hace referencia a la instancia actual del objeto.
Una de las acciones más sencillas que se pueden hacer sobre un droide es encenderlo o
apagarlo. Vamos a implementar estos dos métodos en nuestr
