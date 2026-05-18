# Foxconn tiene el mayor número de empleados/as

## Fuente
Aprende Python (Cap. 84)

## Contenido
# Foxconn tiene el mayor número de empleados/as

>>> df[ Employees ].idxmax()
Foxconn
Nota: En este caso nos devuelve una cadena de texto con el nombre de la empresa ya que
tenemos definido así nuestro índice (etiquetas). En otro caso devolvería la posición (numérica)
con un índice por defecto.
Si queremos acceder al registro completo, basta con acceder a través de la etiqueta devuelta:
>>> company = df[ Revenue ].idxmin()
>>> df.loc[company]
Revenue 53625
Employees 75000
City Seoul
Country South Korea
(continué en la próxima página)
8.3. pandas 421

-- 425 of 516 --

Aprende Python
(proviene de la página anterior)
Name: LG Electronics, dtype: object
Otra de las operaciones muy usuales es encontrar los 𝑛 registros con mayores/menores valores.
Supongamos que nos interesa conocer las 3 empresas con mayores ingresos y las 3
empresas con menor número de empleados/as:
>>> df[ Revenue ].nlargest(3)
Company
Apple 274515
Samsung Electronics 200734
Alphabet 182527
Name: Revenue, dtype: int64
>>> df[ Employees ].nsmallest(3)
Company
HP Inc. 53000
Facebook 58604
Lenovo 71500
Name: Employees, dtype: int64
Nota: Si no especificamos un número de registros, estas funciones lo tienen definido por
defecto a 5.
Si queremos acceder al registro completo, podemos aplicar estas funciones de otro modo:
>>> df.nlargest(3, Revenue )
Revenue Employees City Country
Company
Apple 274515 147000 California United States
Samsung Electronics 200734 267937 Suwon South Korea
Alphabet 182527 135301 California United States
>>> df.nsmallest(3, Employees )
Revenue Employees City Country
Company
HP Inc. 56639 53000 California United States
Facebook 85965 58604 California United States
Lenovo 60742 71500 Hong Kong China
Ejercicio
Partiendo del conjunto de datos democan obtenga las 3 islas con menor densidad de población.
El resultado debería ser el siguiente:
422 Capítulo 8. Ciencia de datos

-- 426 of 516 --

Aprende Python
Population Area Province Density
Island
El Hierro 11147 278.71 SCTF 39.994977
La Gomera 21678 369.76 SCTF 58.627218
Fuerteventura 119732 1659.00 LPGC 72.171187
Gestionando valores nulos
La limpieza de un «dataset» suele estar vinculado, en muchas ocasiones, a la gestión de los
valores nulos. En este sentido, pandas ofrece varias funciones.
Para ejemplificar este apartado, vamos a hacer uso del siguiente DataFrame:
>>> df
A B C
0 1 4.0 7.0
1 2 NaN 8.0
2 3 6.0 NaN
Si queremos detectar aquellos valores nulos, haremos lo siguiente:
>>> df.isna()
A B C
0 False False False
1 False True False
2 False False True
Nota: También existe la función isnull() que funciona de manera análoga a isna(). En
StackExchange puedes ver una explicación de estas funciones.
En caso de que nos interese descartar los registros con valores nulos, procedemos así:
>>> df.dropna()
A B C
0 1 4.0 7.0
Sin embargo, también existe la posiblidad de rellenar los valores nulos con algún sustituto.
En este caso podemos ejecutar lo siguiente:
>>> df.fillna(0)
A B C
0 1 4.0 0.0
(continué en la próxima página)
8.3. pandas 423

-- 427 of 516 --

Aprende Python
(proviene de la página anterior)
1 2 0.0 0.0
2 3 6.0 9.0
Incluso podemos aplicar interpolación para completar valores nulos:
>>> df.interpolate()
A B C
0 1 4.0 7.0
1 2 5.0 8.0
2 3 6.0 8.0
Reformando datos
En esta sección se verán las operaciones de pivotar y apilar que permiten reformar
(remodelar) un DataFrame.
Seguimos utilizando el conjunto de datos de empresas tecnológicas aunque nos quedaremos
únicamente con las 3 primeras filas a efectos didácticos:
>>> df = df.reset_index()[:3]
>>> df
Company Revenue Employees City Country
0 Apple 274515 147000 California United States
1 Samsung Electronics 200734 267937 Suwon South Korea
2 Alphabet 182527 135301 California United States
Ancho y Largo
Típicamente existen dos maneras de presentar datos tabulares: formato ancho y formato
largo. En formato ancho cada fila tiene múltiples columnas representando todas las
variables de una misma observación. En formato largo cada fila tiene básicamente tres
columnas: una que identifica la observación, otra que identifica la variable y otra que contiene
el valor.
Para pasar de formato ancho a formato largo usamos la función melt():
>>> df.melt(id_vars= Company )
Company variable value
0 Apple Revenue 274515
1 Samsung Electronics Revenue 200734
2 Alphabet Revenue 182527
(continué en la próxima página)
424 Capítulo 8. Ciencia de datos

-- 428 of 516 --

Aprende Python
(proviene de la página anterior)
3 Apple Employees 147000
4 Samsung Electronics Employees 267937
5 Alphabet Employees 135301
6 Apple City California
7 Samsung Electronics City Suwon
8 Alphabet City California
9 Apple Country United States
10 Samsung Electronics Country South Korea
11 Alphabet Country United States
Para pasar de formato largo a formato ancho usamos la función pivot():
>>> df_long = df.melt(id_vars= Company )
>>> df_long.pivot(index= Company , columns= variable , values= value )
variable City Country Employees Revenue
Company
Alphabet California United 
