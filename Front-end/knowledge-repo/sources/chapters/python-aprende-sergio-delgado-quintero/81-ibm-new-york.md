# IBM NEW YORK

Tencent SHENZHEN
Panasonic OSAKA
Lenovo HONG KONG
HP Inc. CALIFORNIA
LG Electronics SEOUL
Name: City, dtype: object
Otro supuesto sería el de sustituir espacios por subguiones en los países de las
empresas:
>>> df[ Country ].str.replace( , _ )
Company
Apple United_States
Samsung Electronics South_Korea
Alphabet United_States
Foxconn Taiwan
Microsoft United_States
Huawei China
Dell Technologies United_States
Facebook United_States
Sony Japan
Hitachi Japan
Intel United_States
IBM United_States
Tencent China
Panasonic Japan
Lenovo China
HP Inc. United_States
LG Electronics South_Korea
Name: Country, dtype: object
408 Capítulo 8. Ciencia de datos

-- 412 of 516 --

Aprende Python
Expresiones regulares
El uso de expresiones regulares aporta una gran expresividad. Veamos su aplicación con tres
casos de uso:
• Filtrado de filas.
• Reemplazo de valores.
• Extracción de columnas.
Supongamos que queremos filtrar las empresas y quedarnos con las que comienzan
por vocal:
>>> mask = df.index.str.match(r ^[aeiou] , flags=re.IGNORECASE)
>>> df[mask]
Revenue Employees City Country
Company
Apple 274515 147000 California United States
Alphabet 182527 135301 California United States
Intel 77867 110600 California United States
IBM 73620 364800 New York United States
Nota: Dado que el nombre de la empresa está actuando como índice del «dataset», hemos
aplicado la búsqueda sobre .index.
Ahora imaginemos que vamos a sustituir aquellas ciudades que empiezan con «S» o
«T» por «Stanton»:
>>> df[ City ].str.replace(r ^[ST].* , Stanton , regex=True)
Company
Apple California
Samsung Electronics Stanton
Alphabet California
Foxconn New Stanton
Microsoft Washington
Huawei Stanton
Dell Technologies Stanton
Facebook California
Sony Stanton
Hitachi Stanton
Intel California
IBM New York
Tencent Stanton
Panasonic Osaka
(continué en la próxima página)
8.3. pandas 409

-- 413 of 516 --

Aprende Python
(proviene de la página anterior)
Lenovo Hong Kong
HP Inc. California
LG Electronics Stanton
Name: City, dtype: object
Por último supongamos que queremos dividir la columna «Country» en dos columnas
usando el espacio como separador:
>>> df[ Country ].str.split( , expand=True)
0 1
Company
Apple United States
Samsung Electronics South Korea
Alphabet United States
Foxconn Taiwan None
Microsoft United States
Huawei China None
Dell Technologies United States
Facebook United States
Sony Japan None
Hitachi Japan None
Intel United States
IBM United States
Tencent China None
Panasonic Japan None
Lenovo China None
HP Inc. United States
LG Electronics South Korea
Existen otras funciones interesantes de Pandas que trabajan sobre expresiones regulares:
• count() para contar el número de ocurrencias de un patrón.
• contains() para comprobar si existe un determinado patrón.
• extract() para extraer grupos de captura sobre un patrón.
• findall() para encontrar todas las ocurrencias de un patrón.
410 Capítulo 8. Ciencia de datos

-- 414 of 516 --

Aprende Python
Manejando fechas
Suele ser habitual tener que manejar datos en formato fecha (o fecha-hora). Pandas ofrece un
amplio abanico de posibilidades para ello. Veamos algunas de las herramientas disponibles.
Para ejemplificar este apartado hemos añadido al «dataset» de empresas tecnológicas una
nueva columna con las fechas de fundación de las empresas (en formato «string»):
>>> df[ Founded ] = [ 1/4/1976 , 13/1/1969 , 4/9/1998 , 20/2/1974 ,
... 4/4/1975 , 15/9/1987 , 1/2/1984 , 4/2/2004 ,
... 7/5/1946 , 1/10/1962 , 18/7/1968 , 16/6/1911 ,
... 11/11/1998 , 13/3/1918 , 1/11/1984 , 1/1/1939 ,
... 5/1/1947 ]
>>> df.head()
Revenue Employees City Country Founded
Company
Apple 274515 147000 California United States 1/4/1976
Samsung Electronics 200734 267937 Suwon South Korea 13/1/1969
Alphabet 182527 135301 California United States 4/9/1998
Foxconn 181945 878429 New Taipei City Taiwan 20/2/1974
Microsoft 143015 163000 Washington United States 4/4/1975
>>> df[ Founded ].dtype # tipo "object"
dtype( O )
Lo primero que deberíamos hacer es convertir la columna «Founded» al tipo «datetime»
usando la función to_datetime():
>>> df[ Founded ] = pd.to_datetime(df[ Founded ])
>>> df[ Founded ].head()
Company
Apple 1976-01-04
Samsung Electronics 1969-01-13
Alphabet 1998-04-09
Foxconn 1974-02-20
Microsoft 1975-04-04
Name: Founded, dtype: datetime64[ns]
Es posible acceder a cada elemento de la fecha:
>>> df[ fyear ] = df[ Founded ].dt.year
>>> df[ fmonth ] = df[ Founded ].dt.month
>>> df[ fday ] = df[ Founded ].dt.day
>>> df.loc[:, Founded :].head()
(continué en la próxima página)
8.3. pandas 411

-- 415 of 516 --

Aprende Python
(proviene de la página anterior)
Founded fyear fmonth fday
Company
Apple 1976-01-04 1976 1 4
Samsung Electronics 1969-01-13 1969 1 13
Alphabet 1998-04-09 1998 4 9
Foxconn 1974-02-20 1974 2 20
Microsoft 1975-04-04 1975 4 4
Por ejemplo, podríamos querer calcular el número de años que llevan activas las
empresas:
>>> pd.to_datetime( today ).year - df[ Founded ].dt.year
Company
Apple 46
Samsung Electronics 53
Alphabet 24
Foxconn 48
Microsoft 47
Huawei 35
Dell Technologies 38
Facebook 18
Sony 76
Hitachi 60
Intel 54
IBM 111
Tencent 24
Panasonic 104
Lenovo 38
HP Inc. 83
LG Electronics 75
Name: Founded, dtype: int64
Los tipos de datos «datetime» dan mucha flexibilidad a la hora de hacer consultas:
>>> # Empresas creadas antes de 1950
>>> df.query( Founded <= 1950 )
Revenue Employees City Country Founded
Company
Sony 84893 109700 Tokyo Japan 1946-07-05
IBM 73620 364800 New York United States 1911-06-16
Panasonic 63191 243540 Osaka Japan 1918-03-13
HP Inc. 56639 53000 California United States 1939-01-01
LG Electronics 53625 75000 Seoul South Korea 1947-05-01
>>> # Empresas creadas en Enero
(continué en la próxima página)
412 Capítulo 8. Ciencia de datos

-- 416 of 516 --

Aprende Python
(proviene de la página anterior)
>>> df.query( Founded.dt.month == 1 )
Revenue Employees City Country Founded
Company
Apple 274515 147000 California United States 1976-01-04
Samsung Electronics 200734 267937 Suwon South Korea 1969-01-13
Dell Technologies 92224 158000 Texas United States 1984-01-02
Hitachi 82345 350864 Tokyo Japan 1962-01-10
Lenovo 60742 71500 Hong Kong China 1984-01-11
HP Inc. 56639 53000 California United States 1939-01-01
>>> # Empresas creadas en el último cuatrimestre del año
>>> df.query( 9 <= Founded.dt.month <= 12 )
Revenue Employees City Country Founded
Company
Huawei 129184 197000 Shenzhen China 1987-09-15
Tencent 69864 85858 Shenzhen China 1998-11-11
Hay ocasiones en las que necesitamos que la fecha se convierta en el índice del DataFrame:
>>> df = df.reset_index().set_index( Founded ).sort_index()
>>> df.head()
Company Revenue Employees City Country
Founded
1911-06-16 IBM 73620 364800 New York United States
1918-03-13 Panasonic 63191 243540 Osaka Japan
1939-01-01 HP Inc. 56639 53000 California United States
1946-07-05 Sony 84893 109700 Tokyo Japan
1947-05-01 LG Electronics 53625 75000 Seoul South Korea
Esto nos permite indexar de forma mucho más precisa:
>>> # Empresas creadas en 1988
>>> df.loc[ 1998 ]
Company Revenue Employees City Country
Founded
1998-04-09 Alphabet 182527 135301 California United States
1998-11-11 Tencent 69864 85858 Shenzhen China
>>> # Empresas creadas entre 1970 y 1980
>>> df.loc[ 1970 : 1980 ]
Company Revenue Employees City Country
Founded
1974-02-20 Foxconn 181945 878429 New Taipei City Taiwan
1975-04-04 Microsoft 143015 163000 Washington United States
(continué en la próxima página)
8.3. pandas 413

-- 417 of 516 --

Aprende Python
(proviene de la página anterior)
1976-01-04 Apple 274515 147000 California United States
>>> # Empresas creadas entre enero de 1975 y marzo de 1984
>>> df.loc[ 1975-1 : 1984-3 ]
Company Revenue Employees City Country
Founded
1975-04-04 Microsoft 143015 163000 Washington United States
1976-01-04 Apple 274515 147000 California United States
1984-01-02 Dell Technologies 92224 158000 Texas United States
1984-01-11 Lenovo 60742 71500 Hong Kong China
Ejercicio
Partiendo del fichero oasis.csv que contiene información sobre la discografía del grupo de
pop británico Oasis, se pide:
• Cargue el fichero en un DataFrame.
• Convierta la columna «album_release_date» a tipo «datetime».
• Obtenga los nombres de los álbumes publicados entre 2000 y 2005.
Manejando categorías
Hasta ahora hemos visto tipos de datos numéricos, cadenas de texto y fechas. ¿Pero qué
ocurre con las categorías?
Las categorías pueden ser tanto datos numéricos como textuales, con la característica de
tener un número discreto (relativamente pequeño) de elementos y, en ciertas ocasiones, un
orden preestablecido. Ejemplos de variables categóricas son: género, idioma, meses del año,
color de ojos, nivel de estudios, grupo sanguíneo, valoración, etc.
Pandas facilita el tratamiento de datos categóricos mediante un tipo específico Categorical.
Siguiendo con el «dataset» de empresas tecnológicas, vamos a añadir el continente al que
pertenece cada empresa. En primera instancia mediante valores de texto habituales:
>>> df[ Continent ] = [ America , Asia , America , Asia ,
... America , Asia , America , America ,
... Asia , Asia , America , America ,
... Asia , Asia , Asia , America ,
... Asia ]
>>> df[ Continent ].head()
(continué en la próxima página)
414 Capítulo 8. Ciencia de datos

-- 418 of 516 --

Aprende Python
(proviene de la página anterior)
Company
Apple America
Samsung Electronics Asia
Alphabet America
Foxconn Asia
Microsoft America
Name: Continent, dtype: object
Ahora podemos convertir esta columna a tipo categoría:
>>> df[ Continent ].astype( category )
Company
Apple America
Samsung Electronics Asia
Alphabet America
Foxconn Asia
Microsoft America
Huawei Asia
Dell Technologies America
Facebook America
Sony Asia
Hitachi Asia
Intel America
IBM America
Tencent Asia
Panasonic Asia
Lenovo Asia
HP Inc. America
LG Electronics Asia
Name: Continent, dtype: category
Categories (2, object): [ America , Asia ]
En este caso, al ser una conversión «automática», las categorías no han incluido ningún
tipo de orden. Pero imaginemos que queremos establecer un orden para las categorías de
continentes basadas, por ejemplo, en su población: Asia, África, Europa, América, Australia:
>>> from pandas.api.types import CategoricalDtype
>>> continents = ( Asia , Africa , Europe , America , Australia )
>>> cat_continents = CategoricalDtype(categories=continents, ordered=True)
>>> df[ Continent ].astype(cat_continents)
Company
Apple America
(continué en la próxima página)
8.3. pandas 415

-- 419 of 516 --

Aprende Python
(proviene de la página anterior)
Samsung Electronics Asia
Alphabet America
Foxconn Asia
Microsoft America
Huawei Asia
Dell Technologies America
Facebook America
Sony Asia
Hitachi Asia
Intel America
IBM America
Tencent Asia
Panasonic Asia
Lenovo Asia
HP Inc. America
LG Electronics Asia
Name: Continent, dtype: category
Categories (5, object): [ Asia < Africa < Europe < America < Australia ]
El hecho de trabajar con categorías ordenadas permite (entre otras) estas operaciones:
>>> df[ Continent ].min()
Asia
>>> df[ Continent ].max()
America
>>> df[ Continent ].sort_values()
Company
Sony Asia
Lenovo Asia
Panasonic Asia
Tencent Asia
Hitachi Asia
LG Electronics Asia
Foxconn Asia
Samsung Electronics Asia
Huawei Asia
Dell Technologies America
Facebook America
HP Inc. America
Microsoft America
Intel America
IBM America
Alphabet America
Apple America
(continué en la próxima página)
416 Capítulo 8. Ciencia de datos

-- 420 of 516 --

Aprende Python
(proviene de la página anterior)
Name: Continent, dtype: category
Categories (5, object): [ Asia < Africa < Europe < America < Australia ]
Atención: En condiciones normales (categorías sin ordenar) el mínimo hubiera sido
America y el máximo hubiera sido Asia ya que se habrían ordenado alfabéticamente.
Usando funciones estadísticas
Vamos a aplicar las funciones estadísticas que proporciona pandas sobre la columna Revenue
de nuestro «dataset», aunque podríamos hacerlo sobre todas aquellas variables numéricas
susceptibles:
>>> df[ Revenue ]
Company
Apple 274515
Samsung Electronics 200734
Alphabet 182527
Foxconn 181945
Microsoft 143015
Huawei 129184
Dell Technologies 92224
Facebook 85965
Sony 84893
Hitachi 82345
Intel 77867
IBM 73620
Tencent 69864
Panasonic 63191
Lenovo 60742
HP Inc. 56639
LG Electronics 53625
Name: Revenue, dtype: int64
Tabla 3: Funciones estadísticas en pandas
Función Resultado	Descripción
df[ Revenue ].count() 17 Número de observaciones no nulas
df[ Revenue ].sum() 1912895 Suma de los valores
df[ Revenue ].mean() 112523.23Media de los valores
df[ Revenue ].mad() 51385.95 Desviación absoluta media
continué en la próxima página
8.3. pandas 417

-- 421 of 516 --

Aprende Python
Tabla 3 – proviene de la página anterior
Función Resultado	Descripción
df[ Revenue ].
median()