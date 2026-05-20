# 5. Imprima por pantalla la info() de este objeto (el método info() debería retornar str

y debería hacer uso de los métodos info() de las clases base).
Salida esperada:
/home/python/vanrossum.mp4 [size=19B] # self.info() de File
Codec: h264 # ┐
Geolocalization: (23.5454, 31.4343) # ┐ self.info() de MediaFile
Duration: 487s # ┐
Dimensions: (1920, 1080) # self.info() de VideoFile
� El método size() debe devolver el número total de caracteres sumando las longitudes de
los elementos del atributo contents.
Agregación y composición
Aunque la herencia de clases nos permite modelar una gran cantidad de casos de uso en
términos de «is-a» (es un), existen muchas otras situaciones en las que la agregación o
la composición son una mejor opción. En este caso una clase se compone de otras cases:
hablamos de una relación «has-a» (tiene un).
Hay una sutil diferencia entre agregación y composición:
• La composición implica que el objeto utilizado no puede «funcionar» sin la presencia
de su propietario.
• La agregación implica que el objeto utilizado puede funcionar por sí mismo.
Veamos un ejemplo de agregación en el que añadimos una herramienta a un droide:
>>> class Tool:
... def __init__(self, name):
... self.name = name
...
... def __str__(self):
... return self.name.upper()
...
... class Droid:
... def __init__(self, name, serial_number, tool):
... self.name = name
(continué en la próxima página)
6.2. Objetos y Clases 277

-- 281 of 516 --

Aprende Python
Figura 15: Agregación vs. Composición6
(proviene de la página anterior)
... self.serial_number = serial_number
... self.tool = tool # agregación
...
... def __str__(self):
... return f Droid {self.name} armed with a {self.tool}
...
>>> lighter = Tool( lighter )
>>> bb8 = Droid( BB-8 , 48050989085439, lighter)
>>> print(bb8)
Droid BB-8 armed with a LIGHTER
EJERCICIOS DE REPASO