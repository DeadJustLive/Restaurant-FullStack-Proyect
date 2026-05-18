# 2. Seleccionar un método para resolver las colisiones.

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 99)

## Contenido
# 2. Seleccionar un método para resolver las colisiones.

El método puede consistir en situar los pares que colisionan sobre una misma entrada primaria en una zona de
desbordamiento, consistente en una estructura de datos dinámica (una lista enlazada, por ejemplo) guardando la
dirección del primer par en la componente del vector soporte correspondiente a esa entrada primaria. Esta técnica
recibe el nombre de resolución de colisiones por encadenamiento (en algunos libros denominada dispersión
abierta).
Por el contrario, la recolocación en el mismo vector soporte consiste en almacenar los pares que colisionan en
otras posiciones del vector diferentes a la entrada primaria. En este caso, se precisa determinar un algoritmo de
recolocación que calcule sucesivas entradas secundarias para una clave, hasta encontrar un lugar libre en el
vector. En algunos libros se denomina dispersión cerrada a esta solución, en otros, direccionamiento abierto.
3.1. Diseño de la función de dispersión
Veamos más en detalle el primero de los pasos. Las características fundamentales que debe tener una función de
dispersión son:
• 	la capacidad de distribuir las claves de la forma más uniforme posible sobre el rango 1..max, y
• 	la posibilidad de ser evaluada eficientemente (es decir, debe consistir en la aplicación de unas pocas operaciones
aritméticas sencillas).
Para claves de tipo natural, z, una función de dispersión muy utilizada y sencilla, y que distribuye bastante bien las
claves se denomina método de la división o método del módulo.
h(z) = z mod max
En este caso, los índices del vector en el que se almacena la tabla o diccionario son: 0..max–1.
Es habitual elegir un número primo para el valor max.
En ocasiones, este método puede distribuir mal las claves. Por ejemplo, si max = 10 y casi todas las claves acaban en
el mismo dígito.
Otra alternativa para definir una función de dispersión sencilla para números naturales, y de uso frecuente, se basa en
el método del centro del cuadrado. Consiste en elevar el número al cuadrado y extraer unos cuantos dígitos de la parte
central del número resultante.
h(z) = “los 	log 2 (max) 	bits centrales de z2 ”
Por ejemplo, si max = 100 y la clave natural, z, tiene 5 dígitos, su cuadrado tiene 10 (ó 9) dígitos y (z2 / 105 ) mod 100
es el entero formado por los dos dígitos centrales del cuadrado de z, y por tanto está comprendido entre 0 y 99.

-- 188 of 267 --

181
Si las claves son de tipo cadena de caracteres, la función de dispersión h debe en primer lugar transformarlas en
un número natural, y después aplicar alguna de las soluciones conocidas para claves naturales (método de la división,
método del centro del cuadrado…).
Un primer método, el más sencillo y eficiente, para transformar una cadena en un natural es el de la suma de los
ordinales. Es decir, dada la cadena c = c[1..n] de n caracteres, calcular ord(c[1]) + ord(c[2]) + … + ord(c[n]), donde la
función “ord” devuelve el ordinal de un carácter en el código de caracteres utilizado (ASCII, por ejemplo).
En ocasiones, ese método sencillo combinado con el método de la división puede dar resultados de distribución de las
claves muy pobres. Por ejemplo, si max es demasiado grande, max = 10007 y todas las cadenas tienen 8 caracteres, o menos,
sólo se utilizarían un máximo de 2048 posiciones del vector (256 posibles*8 = 2048). O, por ejemplo, si max = 100 y las
claves son las cadenas “A0”, “A1”, …, “A99”, es fácil verificar que la función h, basada en la suma de los ordinales y en
el método de la división, intentaría colocar las 100 claves en tan sólo 29 componentes del vector (por ejemplo, las 9 claves
“A18”, “A27”, “A36”, …, “A90” tendrían la misma entrada primaria).
Una alternativa muy utilizada al método de la suma de los ordinales es la de la suma ponderada. Consiste en tratar la
cadena de caracteres como si fuera un entero en base 256 (si éste es el número de caracteres del código) al realizar la suma
en la función h (ejemplo: a la cadena “abcd” le correspondería ord('a') + ord('b')*256 + ord('c')*256 2 + ord('d')*256 3
).
Es decir, el método de la suma ponderada, combinado con el de la división, se implementaría con la siguiente
función:
constantes cardinalCódigo = 256 {código ASCII extendido, con 256 valores posibles}
max = ... 	{El tamaño del vector con el que implementar la tabla dispersa}
función h(c:cadena) devuelve 0..max-1
variables i,suma,factor:entero
principio
suma:=0; {Para calcular la suma ponderada explicada anteriormente}
factor:=1; {Valor inicial de factor = cardinalCódigo elevado a 0 = 1}
para i:=1 hasta long(c) hacer
suma:=suma + ord(c[i])*factor;
factor:=factor*cardinalCódigo {factor = cardinalCódigo elevado a i}
fpara;
devuelve (suma mod max) {Método de la división}
fin
El problema de este método es que el valor de la variable suma puede hacerse muy grande. Si las claves sólo se
componen de letras, puede tratarse la cadena de caracteres como un entero en base 26 (número de letras del alfabeto inglés).
Otra posibilid
