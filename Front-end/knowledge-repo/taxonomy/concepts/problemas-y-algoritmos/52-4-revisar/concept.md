# 4. Revisar

## Fuente
problemas-y-algoritmos (Cap. 52)

## Contenido
# 4. Revisar

Como bien se podrá dar cuenta el lector, estos 4 pasos no son un buen
resúmen de cómo resolver problemas, principalmente porque la parte de en-
contrar la solución suele ser mucho mas complicada que las otras 3 juntas.
Sin embargo, eso no debe de provocar que les prestemos menos atención
a los otros 3 pasos en el momento de resolver un problema, cada uno de estos
4 pasos es igualmente importante a pesar de que algunos de ellos son fáciles.

-- 297 of 315 --

298

-- 298 of 315 --

Cap´ıtulo 22
Entendiendo el Problema
Lo primero que hay que hacer para resolver un problema es entenderlo,
suena como algo bastante obvio, y realmente es obvio que antes de resolver un
problema primero hay que entenderlo. Sin embargo es necesario tener claro
cuándo un problema ya se entendió adecuadamente.
La clave es la siguiente: un problema ya se entendió adecuadamente cuan-
do es posible construir un modelo matemático del problema, además de decir
objetivamente y sin rodeos qué es lo que se sabe de antemano(los datos) y qué
es lo que se quiere saber(las incógnitas) en términos del modelo matemáti-
co(no en terminos de la descripción del problema original).
Para dejarlo mas claro: alguien que no haya leido el problema debería
de ser capáz de resolverlo sabiendo los datos, las incógnitas y el modelo
matemático.
A pesar de que este paso es de vital importancia y aparentemente sencillo,
muchas veces es subestimado y es omitido erróneamente. Tal es el caso co-
tidiano del estudiante al cual se le presenta un problema y después de leerlo
sin hacer ningún intento se declara incapáz de resolverlo porque no sabe qué
hacer.
Ahora bien, si al lector alguna vez le sucede algo similar, que luego de
leer un problema no sepa por donde empezar, lo primero que debe de hacer
es empezar por identicar los datos y las incógnitas, eso incluye decir
en términos objetivos(y de preferencia matemáticos) qué es lo que se está
buscando y qué es lo que se sabe de antemano además de eliminar información
supercial.
Vale la pena subrayar que la respuesta a la pregunta ¾Por dónde em-
piezo? siempre es: por identicar los datos y las incógnitas.
Vamos a resolver un ejemplo sencillo, de algo que para el lector le resul-
taría un ejercicio mas que un problema pero para niños de educación primeria
299

-- 299 of 315 --

300 CAPÍTULO 22. ENTENDIENDO EL PROBLEMA
les podría resultar un problema, el objetivo es ilustrar cómo un problema al
enterlo se transforma en un modelo matemático.
Problema Resuelto 22.0.1. Una naranja cuesta 2 pesos, una pera cuesta
5 pesos. Suponga que usted gastó 18 pesos y la cantidad de naranjas que
compró es el doble de la cantidad de peras. ¾Cuántas peras y cuántas naranjas
compró?
Solución Sin prestar mucha atención a los detalles rápidamente llegamos
a este sistema de ecuaciones:
2x + 5y = 18 (22.1)
2y = x (22.2)
Y posteriormente se llegará a la respuesta: 2 paras y 4 naranjas.
Si prestamos algo de atención, en el momento que al número de naranjas
les llamamos x, que al número de peras les llamamos y y que planteamos las 2
ecuaciones, estamos olvidándonos de que hablabamos de peras y de naranjas.
Incluso nos estamos olvidando de la moneda con la cual se realiza la
compra y una vez que planteamos la primera ecuación ya no es necesario ni
siquiera recordar los precios.

De esta manera el proceso de entender un problema es el mismo que el
de convertir el enunciado del problema en variables con un comportamiento
bien denido.
También hay que cuidarse de evitar asumir demasiadas cosas en el mo-
mento de entender un problema, y qué mejor manera de mostrar que esto
puede suceder a través de un ejemplo:
Problema Resuelto 22.0.2. Dos padres y sus respectivos dos hijos se
comieron un pastel, y nadie mas comió de él ¾Es posible que en total hayan
comido de ese pastel 3 personas?
Solución Es posible que el lector se vea tentado a asumir que los 2 padres
son personas distintas de los 2 hijos y que por tanto hay 4 personas.
Revisemos nuevamente el texto, nos dice que hay 3 personas en total, las
cuales las podemos representar por 3 vértices llamados A, B y C.
Podemos representar este problema como un grafo, donde lo que se quiere
encontrar es una manera de encontrar 2 aristas dirigidas de manera que 2

-- 300 of 315 --

301
vértices tengan grado de salida 1, 2 vértices tengan grado de entrada 1 y que
no haya ciclos.
Los vértices con grado de salida 1 son los padres, los que tienen grado de
entrada 1 son los hijos y a es hijo de b si existe una arista desde b hasta a.
Claramente no es necesario tener en cuenta todo este tecnicismo para
resolver el problema, simplemente se está haciendo notar que ya no importa
si lo que estamos imaginando son personas o animales, ya nos olvidamos del
pastel, etc.
El problema nos dice además que entre ellos hay 2 padres, sin pérdida de
generalidad diremos que son A y B. Y además hay 2 hijos, dichos 2 hijos no
pueden ser también A y B puesto que para que sucediera alguno debería de
ser padre de sí mis
