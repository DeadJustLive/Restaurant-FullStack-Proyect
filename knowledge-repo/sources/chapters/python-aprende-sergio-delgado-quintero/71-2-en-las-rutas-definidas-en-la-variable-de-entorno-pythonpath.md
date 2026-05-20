# 2. En las rutas definidas en la variable de entorno PYTHONPATH.

Para ver las rutas de búsqueda establecidas, podemos ejecutar lo siguiente en un intérprete
de Python:
>>> import sys
>>> sys.path
[ /path/to/.pyenv/versions/3.9.1/envs/aprendepython/bin ,
/path/to/.pyenv/versions/3.9.1/lib/python3.9 ,
/path/to/.pyenv/versions/3.9.1/envs/aprendepython/lib/python3.9/site-packages ,
]
La cadena vacía que existe al final de la lista hace referencia a la carpeta actual.
Modificando la ruta de búsqueda
Si queremos modificar la ruta de búsqueda, existen dos opciones:
Modificando directamente la variable PYTHONPATH Para ello exportamos dicha variable
de entorno desde una terminal:
$ export PYTHONPATH=/tmp
Y comprobamos que se ha modificado en sys.path:
288 Capítulo 6. Modularidad

-- 292 of 516 --

Aprende Python
>>> sys.path
[ /path/to/.pyenv/versions/3.9.1/envs/aprendepython/bin ,
/tmp ,
/path/to/.pyenv/versions/3.9.1/lib/python3.9 ,
/path/to/.pyenv/versions/3.9.1/envs/aprendepython/lib/python3.9/site-packages ,
]
Modificando directamente la lista sys.path Para ello accedemos a lista que está en el
módulo sys de la librería estandar:
>>> sys.path.append( /tmp ) # añadimos al final
>>> sys.path
[ /path/to/.pyenv/versions/3.9.1/envs/aprendepython/bin ,
/path/to/.pyenv/versions/3.9.1/lib/python3.9 ,
/path/to/.pyenv/versions/3.9.1/envs/aprendepython/lib/python3.9/site-packages ,
,
/tmp ]
>>> sys.path.insert(0, /tmp ) # insertamos por el principio
>>> sys.path
[ /tmp ,
/path/to/.pyenv/versions/3.9.1/envs/aprendepython/bin ,
/path/to/.pyenv/versions/3.9.1/lib/python3.9 ,
/path/to/.pyenv/versions/3.9.1/envs/aprendepython/lib/python3.9/site-packages ,
]
Truco: El hecho de poner nuestra ruta al principio o al final de sys.path influye en
la búsqueda, ya que si existen dos (o más módulos) que se llaman igual en nuestra ruta
de búsqueda, Python usará el primero que encuentre.
Importar partes de un módulo
Es posible que no necesitemos todo aquello que está definido en arith.py. Supongamos que
sólo vamos a realizar divisiones. Para ello haremos lo siguiente:
1 >>> from arith import partitus
2
3 >>> partitus(5, 2)
4 2.5
6.4. Módulos 289

-- 293 of 516 --

Aprende Python
Nota: Nótese que en la línea 3 ya podemos hacer uso directamente de la función partitus()
porque la hemos importado directamente. Este esquema tiene el inconveniente de la posible
colisión de nombres, en aquellos casos en los que tuviéramos algún objeto con el mismo
nombre que el objeto que estamos importando.
Importar usando un alias
Hay ocasiones en las que interesa, por colisión de otros nombres o por mejorar la legibilidad,
usar un nombre diferente del módulo (u objeto) que estamos importando. Python nos ofrece
esta posibilidad a través de la sentencia as.
Supongamos que queremos importar la función del ejemplo anterior pero con otro nombre:
>>> from arith import partitus as mydivision
>>> mydivision(5, 2)
2.5
6.4.2 Paquetes
Un paquete es simplemente una carpeta que contiene ficheros .py. Además permite tener
una jerarquía con más de un nivel de subcarpetas anidadas.
Para ejemplificar este modelo vamos a crear un paquete llamado mymath que contendrá 2
módulos:
• arith.py para operaciones aritméticas (ya visto anteriormente).
• logic.py para operaciones lógicas.
El código del módulo de operaciones lógicas es el siguiente:
logic.py
1 def et(a, b):
2 Logic "and" of input values
3 return a & b
4
5
6 def uel(a, b):
7 Logic "or" of input values
8 return a | b
9
10
(continué en la próxima página)
290 Capítulo 6. Modularidad

-- 294 of 516 --

Aprende Python
(proviene de la página anterior)
11 def vel(a, b):
12 Logic "xor" of input values
13 return a ^ b
Si nuestro código principal va a estar en un fichero main.py (a primer nivel), la estructura
de ficheros nos quedaría tal que así:
1 .
2 ┐┐┐ main.py
3 ┐┐┐ mymath
4 ┐┐┐ arith.py
5 ┐┐┐ logic.py
6
7 1 directory, 3 files
Línea 2 Punto de entrada de nuestro programa a partir del fichero main.py
Línea 3 Carpeta que define el paquete mymath.
Línea 4 Módulo para operaciones aritméticas.
Línea 5 Módulo para operaciones lógicas.
Importar desde un paquete
Si ya estamos en el fichero main.py (o a ese nivel) podremos hacer uso de nuestro paquete
de la siguiente forma:
1 >>> from mymath import arith, logic
2
3 >>> arith.pullulate(4, 7)
4 28
5
6 >>> logic.et(1, 0)
7 0
Línea 1 Importar los módulos arith y logic del paquete mymath
Línea 3 Uso de la función pullulate que está definida en el módulo arith
Línea 5 Uso de la función et que está definida en el módulo logic
6.4. Módulos 291

-- 295 of 516 --

Aprende Python
6.4.3 Programa principal
Cuando decidimos desarrollar una pieza de software en Python, normalmente usamos
distintos ficheros para ello. Algunos de esos ficheros se convertirán en módulos, otros se
englobarán en paquetes y existirá uno en concreto que será nuestro punto de entrada,
también llamado programa principal.
Consejo: Suele ser una buena práctica llamar main.py al fichero que contiene nuestro
programa principal.
La estructura que suele tener este programa principal es la siguiente: