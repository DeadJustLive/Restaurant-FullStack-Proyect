# 6.4 Módulos

Escribir pequeños trozos de código puede resultar interesante para realizar determinadas
pruebas. Pero a la larga, nuestros programas tenderán a crecer y será necesario agrupar el
código en unidades manejables.
Los módulos son simplemente ficheros de texto que contienen código Python y representan
286 Capítulo 6. Modularidad

-- 290 of 516 --

Aprende Python
unidades con las que evitar la repetición y favorecer la reutilización.1
6.4.1 Importar un módulo
Para hacer uso del código de otros módulos usaremos la sentencia import. Esto permite
importar el código y las variables de dicho módulo para que estén disponibles en nuestro
programa.
La forma más sencilla de importar un módulo es import <module> donde module es el nombre
de otro fichero Python, sin la extensión .py.
Supongamos que partimos del siguiente fichero (módulo):
arith.py
1 def addere(a, b):
2 Sum of input values
3 return a + b
4
5
6 def minuas(a, b):
7 Substract of input values
8 return a - b
9
10
11 def pullulate(a, b):
12 Product of input values
13 return a * b
14
15
16 def partitus(a, b):
17 Division of input values
18 return a / b
Desde otro fichero - en principio en la misma carpeta - podríamos hacer uso de las funciones
definidas en arith.py.
1 Foto original por Xavi Cabrera en Unsplash.
6.4. Módulos 287

-- 291 of 516 --

Aprende Python
Importar módulo completo
Desde otro fichero haríamos lo siguiente para importar todo el contenido del módulo arith.
py:
1 >>> import arith
2
3 >>> arith.addere(3, 7)
4 10
Nota: Nótese que en la línea 3 debemos anteponer a la función addere() el espacio de
nombres que define el módulo arith.
Ruta de búsqueda de módulos
Python tiene 2 formas de encontrar un módulo: