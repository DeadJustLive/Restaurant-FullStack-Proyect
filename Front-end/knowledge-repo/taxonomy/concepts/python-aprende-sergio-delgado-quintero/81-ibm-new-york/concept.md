# IBM NEW YORK

## Fuente
Aprende Python (Cap. 81)

## Contenido
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
Samsung El
