# 2. Usar los paréntesis (...):

## Fuente
Aprende Python (Cap. 29)

## Contenido
# 2. Usar los paréntesis (...):

>>> factorial = 4 * 3 * 2 * 1
>>> factorial = (4 *
... 3 *
... 2 *
... 1)
4.1.4 La sentencia if
La sentencia condicional en Python (al igual que en muchos otros lenguajes de programación)
es if. En su escritura debemos añadir una expresión de comparación terminando con
dos puntos al final de la línea. Veamos un ejemplo:
>>> temperature = 40
(continué en la próxima página)
102 Capítulo 4. Control de flujo

-- 106 of 516 --

Aprende Python
(proviene de la página anterior)
>>> if temperature > 35:
... print( Aviso por alta temperatura )
...
Aviso por alta temperatura
Nota: Nótese que en Python no es necesario incluir paréntesis ( y ) al escribir condiciones.
Hay veces que es recomendable por claridad o por establecer prioridades.
En el caso anterior se puede ver claramente que la condición se cumple y por tanto se ejecuta
la instrucción que tenemos dentro del cuerpo de la condición. Pero podría no ser así. Para
controlar ese caso existe la sentencia else. Veamos el mismo ejemplo anterior pero añadiendo
esta variante:
>>> temperature = 20
>>> if temperature > 35:
... print( Aviso por alta temperatura )
... else:
... print( Parámetros normales )
...
Parámetros normales
Podríamos tener incluso condiciones dentro de condiciones, lo que se viene a llamar
técnicamente condiciones anidadas3. Veamos un ejemplo ampliando el caso anterior:
>>> temperature = 28
>>> if temperature < 20:
... if temperature < 10:
... print( Nivel azul )
... else:
... print( Nivel verde )
... else:
... if temperature < 30:
... print( Nivel naranja )
... else:
... print( Nivel rojo )
...
Nivel naranja
Python nos ofrece una mejora en la escritura de condiciones anidadas cuando aparecen
consecutivamente un else y un if. Podemos sustituirlos por la sentencia elif:
3 El anidamiento (o «nesting») hace referencia a incorporar sentencias unas dentro de otras mediante la
inclusión de diversos niveles de profunidad (indentación).
4.1. Condicionales 103

-- 107 of 516 --

Aprende Python
Figura 2: Construcción de la sentencia elif
Apliquemos esta mejora al código del ejemplo anterior:
>>> temperature = 28
>>> if temperature < 20:
... if temperature < 10:
... print( Nivel azul )
... else:
... print( Nivel verde )
... elif temperature < 30:
... print( Nivel naranja )
... else:
... print( Nivel rojo )
...
Nivel naranja
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/wd58B4t
4.1.5 Asignaciones condicionales
Nivel intermedio
Supongamos que queremos asignar un nivel de riesgo de incendio en función de la
temperatura. En su versión clásica escribiríamos:
>>> temperature = 35
>>> if temperature < 30:
... fire_risk = LOW
... else:
... fire_risk = HIGH
...
(continué en la próxima página)
104 Capítulo 4. Control de flujo

-- 108 of 516 --

Aprende Python
(proviene de la página anterior)
>>> fire_risk
