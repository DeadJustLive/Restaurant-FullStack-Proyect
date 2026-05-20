# 5.5 Ficheros

## Fuente
Aprende Python (Cap. 54)

## Contenido
# 5.5 Ficheros

Aunque los ficheros encajarían más en un apartado de «entrada/salida» ya que representan
un medio de almacenamiento persistente, también podrían ser vistos como estructuras
de datos, puesto que nos permiten guardar la información y asignarles un cierto formato.1
Un fichero es un conjunto de bytes almacenados en algún dispositivo. El sistema de ficheros
es la estructura lógica que alberga los ficheros y está jerarquizado a través de directorios
(o carpetas). Cada fichero se identifica unívocamente a través de una ruta que nos permite
acceder a él.
5.5.1 Lectura de un fichero
Python ofrece la función open() para «abrir» un fichero. Esta apertura se puede realizar en
3 modos distintos:
• Lectura del contenido de un fichero existente.
• Escritura del contenido en un fichero nuevo.
• Añadido al contenido de un fichero existente.
Veamos un ejemplo para leer el contenido de un fichero en el que se encuentran las
temperaturas mínimas y máximas de cada día de la última semana. El fichero está en la
subcarpeta (ruta relativa) files/temps.dat y tiene el siguiente contenido:
1 Foto original de portada por Maksym Kaharlytskyi en Unsplash.
5.5. Ficheros 201

-- 205 of 516 --

Aprende Python
23 29
23 31
26 34
23 33
22 29
22 28
22 28
Lo primero será abrir el fichero:
>>> f = open( files/temps.dat )
La función open() recibe como primer argumento la ruta al fichero que queremos manejar
(como un «string») y devuelve el manejador del fichero, que en este caso lo estamos asignando
a una variable llamada f pero le podríamos haber puesto cualquier otro nombre.
Nota: Es importante dominar los conceptos de ruta relativa y ruta absoluta para el
trabajo con ficheros. Véase este artículo de DeNovatoANovato.
Hay que tener en cuenta que la ruta al fichero que abrimos (en modo lectura) debe existir,
ya que de lo contrario obtendremos un error:
>>> f = open( foo.txt )
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
FileNotFoundError: [Errno 2] No such file or directory: foo.txt
Una vez abierto el fichero ya podemos proceder a leer su contenido. Para ello Python nos
ofrece la posibilidad de leer todo el fichero de una vez o bien leerlo línea a línea.
Lectura completa de un fichero
Siguiendo con nuestro ejemplo de temperaturas, veamos cómo leer todo el contenido del
fichero de una sola vez. Para esta operación, Python nos provee, al menos, de dos funciones:
read() Devuelve todo el contenido del fichero como una cadena de texto (str):
>>> f = open( files/temps.dat )
>>> f.read()
23 29\n23 31\n26 34\n23 33\n22 29\n22 28\n22 28\n
readlines() Devuelve todo el contenido del fichero como una lista (list) donde cada
elemento es una línea:
202 Capítulo 5. Estructuras de datos

-- 206 of 516 --

Aprende Python
>>> f = open( files/temps.dat )
>>> f.readlines()
[ 23 29\n , 23 31\n , 26 34\n , 23 33\n , 22 29\n , 22 28\n , 22 28\n ]
Importante: Nótese que, en ambos casos, los saltos de línea \n siguen apareciendo en
los datos leídos, por lo que habría que «limpiar» estos caracteres. Para ello se recomienda
utilizar las funciones ya vistas de cadenas de texto.
Lectura línea a línea
Hay situaciones en las que interesa leer el contenido del fichero línea a línea. Imaginemos un
fichero de tamaño considerable (varios GB). Si intentamos leer completamente este fichero
de sola una vez podríamos ocupar demasiada RAM y reducir el rendimiento de nuestra
máquina.
Es por ello que Python nos ofrece varias aproximaciones a la lectura de ficheros línea a línea.
La más usada es iterar sobre el propio manejador del fichero:
>>> f = open( files/temps.dat )
>>> for line in f: # that easy!
... print(line)
...
23 29
23 31
26 34
23 33
22 29
22 28
22 28
Truco: Igual que pasaba anteriormente, la lectura línea por línea también incluye el salto
de línea \n lo que provoca un «doble espacio» entre cada una de las salidas. Bastaría con
aplicar line.strip() para eliminarlo.
5.5. Ficheros 203

-- 207 of 516 --

Aprende Python
5.5.2 Escritura en un fichero
Para escribir texto en un fichero hay que abrir dicho fichero en modo escritura. Para ello
utilizamos un argumento adicional en la función open() que indica esta operación:
>>> f = open( files/canary-iata.dat , w )
Nota: Si bien el fichero en sí mismo se crea al abrirlo en modo escritura, la ruta hasta
ese fichero no. Eso quiere decir que debemos asegurarnos que las carpetas hasta llegar a
dicho fichero existen. En otro caso obtenemos un error de tipo FileNotFoundError.
Ahora ya podemos hacer uso de la función write() para enviar contenido al fichero abierto.
Supongamos que queremos volcar el contenido de una lista en dicho fichero. En este caso
partimos de los códigos IATA de aeropuertos de las Islas Canarias2.
1 >>> canary_iata = ( TFN , TFS , LPA , GMZ , VDE , SPC , ACE , FUE )
2
3 >>> for code in canary_iata:
4 ... f.write(code + \n )
5 ...
6
7 >>> f.close()
Nótese:
Línea 4 Escritura de cada código en el fichero. La función write() no incluye el salto de
línea por defecto, así que lo añad
