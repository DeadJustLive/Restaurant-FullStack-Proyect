# Asignación de valor inicial

>>> x = 8
>>> x > 4 or x > 12 # True or False
True
>>> x < 4 or x > 12 # False or False
False
>>> x > 4 and x > 12 # True and False
False
>>> x > 4 and x < 12 # True and True
True
>>> not(x != 8) # not False
True
Véanse las tablas de la verdad para cada operador lógico:
Figura 3: Resultados al aplicar operadores lógicos
Python ofrece la posibilidad de ver si un valor está entre dos límites de manera directa. Así,
por ejemplo, para descubrir si value está entre 4 y 12 haríamos:
106 Capítulo 4. Control de flujo

-- 110 of 516 --

Aprende Python
>>> 4 <= value <= 12
True
Nota: