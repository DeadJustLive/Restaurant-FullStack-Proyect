# Islas con más de 1000 km2 de extensión

## Fuente
Aprende Python (Cap. 79)

## Contenido
# Islas con más de 1000 km2 de extensión

Population Area Province
Island
Gran Canaria 855521 1560.10 LPGC
Tenerife 928604 2034.38 SCTF
Fuerteventura 119732 1659.00 LPGC
Seleción usando «query»
Pandas provee una alternativa para la selección condicional de registros a través de la función
query(). Admite una sintaxis de consulta mediante operadores de comparación.
Veamos las mismas consultas de ejemplo que para el apartado anterior:
>>> df.query( Country == "United States" )
Revenue Employees City Country
Company
Apple 274515 147000 California United States
Alphabet 182527 135301 California United States
Microsoft 143015 163000 Washington United States
Dell Technologies 92224 158000 Texas United States
Facebook 85965 58604 California United States
Intel 77867 110600 California United States
IBM 73620 364800 New York United States
(continué en la próxima página)
8.3. pandas 399

-- 403 of 516 --

Aprende Python
(proviene de la página anterior)
HP Inc. 56639 53000 California United States
>>> df.query( Revenue > 100_000 & Employees > 100_000 )
Revenue Employees City Country
Company
Apple 274515 147000 California United States
Samsung Electronics 200734 267937 Suwon South Korea
Alphabet 182527 135301 California United States
Foxconn 181945 878429 New Taipei City Taiwan
Microsoft 143015 163000 Washington United States
Huawei 129184 197000 Shenzhen China
>>> df.query( City in ["California", "Tokyo"] )
Revenue Employees City Country
Company
Apple 274515 147000 California United States
Alphabet 182527 135301 California United States
Facebook 85965 58604 California United States
Sony 84893 109700 Tokyo Japan
Hitachi 82345 350864 Tokyo Japan
Intel 77867 110600 California United States
HP Inc. 56639 53000 California United States
Truco: Si los nombres de columna contienen espacios, se puede hacer referencias a ellas con
comillas invertidas. Por ejemplo: BTotal StockB.
Comparativa en consultas
Hemos visto dos métodos para realizar consultas (o filtrado) en un DataFrame: usando
selección booleana con corchetes y usando la función query. ¿Ambos métodos son igual de
eficientes en términos de rendimiento?
Haremos una comparativa muy simple para tener, al menos, una idea de sus órdenes de
magnitud. En primer lugar creamos un DataFrame con 3 columnas y 1 millón de valores
aleatorios enteros en cada una de ellas:
>>> size = 1_000_000
>>> data = {
... A : np.random.randint(1, 100, size=size),
... B : np.random.randint(1, 100, size=size),
... C : np.random.randint(1, 100, size=size)
(continué en la próxima página)
400 Capítulo 8. Ciencia de datos

-- 404 of 516 --

Aprende Python
(proviene de la página anterior)
... }
>>> df = pd.DataFrame(data)
>>> df.shape
(1000000, 3)
Ahora realizaremos la misma consulta sobre el DataFrame aplicando los métodos ya vistos:
>>> %timeit df[(df[ A ] > 50) & (df[ B ] < 50)]
5.86 ms ± 28.7 μs per loop (mean ± std. dev. of 7 runs, 100 loops each)
>>> %timeit df.query( A > 50 & B < 50 )
7.54 ms ± 115 μs per loop (mean ± std. dev. of 7 runs, 100 loops each)
Sin que esto sea en modo alguna concluyente, da la sensación de que query() añade un cierto
«overhead»7 al filtrado y aumentan los tiempos de cómputo.
Modificación de un DataFrame
Modificando valores existentes
Partiendo del acceso a los datos que ya hemos visto, podemos asignar valores sin mayor
dificultad.
Pero antes de modificar el DataFrame original, vamos a hacer una copia del mismo:
>>> df_mod = df.copy()
>>> df_mod.equals(df) # comprueba que todos los valores del DataFrame son iguales
True
Supongamos que hemos cometido un error en el número de empleados/as de Apple
y queremos corregirlo:
>>> df_mod.head(1)
Revenue Employees City Country
Company
Apple 274515 147000 California United States
>>> df_mod.loc[ Apple , Employees ] = 137000
(continué en la próxima página)
7 Exceso de tiempo de cómputacion, memoria o ancho de banda que son necesarios para realizar una
tarea específica.
8.3. pandas 401

-- 405 of 516 --

Aprende Python
(proviene de la página anterior)
>>> df_mod.head(1)
Revenue Employees City Country
Company
Apple 274616 137000 California United States
Supongamos que no se había contemplado una subida del 20% en los ingresos y queremos
reflejarla:
>>> df_mod[ Revenue ] *= 1.20
>>> df_mod[ Revenue ].head()
Company
Apple 329418.0
Samsung Electronics 240880.8
Alphabet 219032.4
Foxconn 218334.0
Microsoft 171618.0
Name: Revenue, dtype: float64
Supongamos que todas las empresas tecnológicas mueven su sede a Vigo (España) y
queremos reflejarlo:
>>> df_mod[ City ] = Vigo
>>> df_mod[ Country ] = Spain
>>> df_mod.head()
Revenue Employees City Country
Company
Apple 329418.0 137000 Vigo Spain
Samsung Electronics 240880.8 267937 Vigo Spain
Alphabet 219032.4 135301 Vigo Spain
Foxconn 218334.0 878429 Vigo Spain
Microsoft 171618.0 163000 Vigo Spain
Nota: En este último ejemplo se produce un «broadcast» o difusión del valor escalar a
todos los registros del «dataset».
402 Capítulo 8. Ciencia de datos

-- 406 of 516 --

Aprende Python
Reemplazo de va
