# Column Non-Null Count Dtype

--- ------ -------------- -----
0 Revenue 17 non-null int64
1 Employees 17 non-null int64
2 City 17 non-null object
3 Country 17 non-null object
dtypes: int64(2), object(2)
memory usage: 680.0+ bytes
Descripción de las variables numéricas:
>>> df.describe()
Revenue Employees
(continué en la próxima página)
388 Capítulo 8. Ciencia de datos

-- 392 of 516 --

Aprende Python
(proviene de la página anterior)
count 17.000000 17.000000
mean 112523.235294 204125.470588
std 63236.957691 198345.912495
min 53625.000000 53000.000000
25% 69864.000000 85858.000000
50% 84893.000000 147000.000000
75% 143015.000000 243540.000000
max 274515.000000 878429.000000
Uso de memoria:
>>> df.memory_usage()
Index 692
Revenue 136
Employees 136
City 136
Country 136
dtype: int64
Truco: El resultado de describe() es un DataFrame, mientras que el resultado de
memory_usage() es Series. En cualquier caso, ambas estructuras son accesibles normalmente
como tipos de datos Pandas.
Atributos de un DataFrame
Tamaños y dimensiones:
>>> df.shape # filas por columnas
(17, 4)
>>> df.size # número total de datos
68
>>> df.ndim # número de dimensiones
2
Índice, columnas y valores:
>>> df.index
Index([ Apple , Samsung Electronics , Alphabet , Foxconn , Microsoft ,
Huawei , Dell Technologies , Facebook , Sony , Hitachi , Intel ,
IBM , Tencent , Panasonic , Lenovo , HP Inc. , LG Electronics ],
(continué en la próxima página)
8.3. pandas 389

-- 393 of 516 --

Aprende Python
(proviene de la página anterior)
dtype= object , name= Company )
>>> df.columns
Index([ Revenue , Employees , City , Country ], dtype= object )
>>> df.values
array([[274515, 147000, California , United States ],
[200734, 267937, Suwon , South Korea ],
[182527, 135301, California , United States ],
[181945, 878429, New Taipei City , Taiwan ],
[143015, 163000, Washington , United States ],
[129184, 197000, Shenzhen , China ],
[92224, 158000, Texas , United States ],
[85965, 58604, California , United States ],
[84893, 109700, Tokyo , Japan ],
[82345, 350864, Tokyo , Japan ],
[77867, 110600, California , United States ],
[73620, 364800, New York , United States ],
[69864, 85858, Shenzhen , China ],
[63191, 243540, Osaka , Japan ],
[60742, 71500, Hong Kong , China ],
[56639, 53000, California , United States ],
[53625, 75000, Seoul , South Korea ]], dtype=object)
Acceso a un DataFrame
Es fundamental conocer la estructura de un DataFrame para su adecuado manejo:
Para todos los ejemplos subsiguientes continuamos utilizando el conjunto de datos de
empresas tecnológicas cargado previamente:
>>> df
Revenue Employees City Country
Company
Apple 274515 147000 California United States
Samsung Electronics 200734 267937 Suwon South Korea
Alphabet 182527 135301 California United States
Foxconn 181945 878429 New Taipei City Taiwan
Microsoft 143015 163000 Washington United States
Huawei 129184 197000 Shenzhen China
Dell Technologies 92224 158000 Texas United States
Facebook 85965 58604 California United States
Sony 84893 109700 Tokyo Japan
Hitachi 82345 350864 Tokyo Japan
(continué en la próxima página)
390 Capítulo 8. Ciencia de datos

-- 394 of 516 --

Aprende Python
Figura 18: Componentes de un DataFrame
8.3. pandas 391

-- 395 of 516 --

Aprende Python
(proviene de la página anterior)
Intel 77867 110600 California United States
IBM 73620 364800 New York United States
Tencent 69864 85858 Shenzhen China
Panasonic 63191 243540 Osaka Japan
Lenovo 60742 71500 Hong Kong China
HP Inc. 56639 53000 California United States
LG Electronics 53625 75000 Seoul South Korea
Acceso a filas
Si queremos acceder a las filas de un conjunto de datos mediante la posición (índice
numérico) del registro usamos el atributo iloc:
>>> df.iloc[0]
Revenue 274515
Employees 147000
City California
Country United States
Name: Apple, dtype: object
>>> df.iloc[-1]
Revenue 53625
Employees 75000
City Seoul
Country South Korea
Name: LG Electronics, dtype: object
>>> df.iloc[3:5]
Revenue Employees City Country
Company
Foxconn 181945 878429 New Taipei City Taiwan
Microsoft 143015 163000 Washington United States
>>> df.iloc[::5] # Salto de 5 en 5 filas
Revenue Employees City Country
Company
Apple 274515 147000 California United States
Huawei 129184 197000 Shenzhen China
Intel 77867 110600 California United States
HP Inc. 56639 53000 California United States
Nota: El acceso a un registro individual nos devuelve una serie.
392 Capítulo 8. Ciencia de datos

-- 396 of 516 --

Aprende Python
Si queremos acceder a las filas de un conjunto de datos mediante la etiqueta del registro
usamos el atributo loc:
>>> df.loc[ Apple ]
Revenue 274515
Employees 147000
City California
Country United States
Name: Apple, dtype: object
>>> df.loc[ IBM ]
Revenue 73620
Employees 364800
City New York
Country United States
Name: IBM, dtype: object
>>> df.loc[ Sony : Intel ]
Revenue Employees City Country
Company
Sony 84893 109700 Tokyo Japan
Hitachi 82345 350864 Tokyo Japan
Intel 77867 110600 California United States
Nota: El acceso a un registro individual nos devuelve una serie.
Acceso a columnas
El acceso a columnas se realiza directamente utilizando corchetes, como si fuera un
diccionario:
>>> df[ Revenue ] # equivalente a df.Revenue
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
(continué en la próxima página)
8.3. pandas 393

-- 397 of 516 --

Aprende Python
(proviene de la página anterior)
Intel 77867
IBM 73620
Tencent 69864
Panasonic 63191
Lenovo 60742
HP Inc. 56639
LG Electronics 53625
Name: Revenue, dtype: int64
Nota: El acceso a una columna individual nos devuelve una serie.
Se pueden seleccionar varias columnas a la vez pasando una lista:
>>> df[[ Employees , City ]].head()
Employees City
Company
Apple 147000 California
Samsung Electronics 267937 Suwon
Alphabet 135301 California
Foxconn 878429 New Taipei City
Microsoft 163000 Washington
Esta misma sintaxis permite la reordenación de las columnas de un DataFrame, si
asignamos el resultado a la misma (u otra) variable:
>>> df_reordered = df[[ City , Country , Revenue , Employees ]]
>>> df_reordered.head()
City Country Revenue Employees
Company
Apple California United States 274515 147000
Samsung Electronics Suwon South Korea 200734 267937
Alphabet California United States 182527 135301
Foxconn New Taipei City Taiwan 181945 878429
Microsoft Washington United States 143015 163000
394 Capítulo 8. Ciencia de datos

-- 398 of 516 --

Aprende Python
Acceso a filas y columnas
Si mezclamos los dos accesos anteriores podemos seleccionar datos de forma muy precisa.
Como siempre, partimos del «dataset» de empresas tecnológicas:
>>> df.head()
Revenue Employees City Country
Company
Apple 274515 147000 California United States
Samsung Electronics 200734 267937 Suwon South Korea
Alphabet 182527 135301 California United States
Foxconn 181945 878429 New Taipei City Taiwan
Microsoft 143015 163000 Washington United States
Acceso al primer valor del número de empleados/as. Formas equivalentes de hacerlo:
>>> df.iloc[0, 0]
274515
>>> df.loc[ Apple , Revenue ]
274515
Acceso a ciudad y país de las empresas Sony, Panasonic y Lenovo:
>>> df.loc[[ Sony , Panasonic , Lenovo ], [ City , Country ]]
City Country
Company
Sony Tokyo Japan
Panasonic Osaka Japan
Lenovo Hong Kong China
Acceso a la última columna del DataFrame:
>>> df.iloc[:, -1]
Company
Apple United States
Samsung Electronics South Korea
Alphabet United States
Foxconn Taiwan
Microsoft United States
Huawei China
Dell Technologies United States
Facebook United States
Sony Japan
Hitachi Japan
Intel United States
(continué en la próxima página)
8.3. pandas 395

-- 399 of 516 --

Aprende Python
(proviene de la página anterior)
IBM United States
Tencent China
Panasonic Japan
Lenovo China
HP Inc. United States
LG Electronics South Korea
Name: Country, dtype: object
Acceso a las tres últimas filas (empresas) y a las dos primeras columnas:
>>> df.iloc[-3:, :2]
Revenue Employees
Company
Lenovo 60742 71500
HP Inc. 56639 53000
LG Electronics 53625 75000
Acceso a las filas que van desde «Apple» a «Huawei» y a las columnas que van
desde «Revenue» hasta «City»:
>>> df.loc[ Apple : Huawei , Revenue : City ]
Revenue Employees City
Company
Apple 274515 147000 California
Samsung Electronics 200734 267937 Suwon
Alphabet 182527 135301 California
Foxconn 181945 878429 New Taipei City
Microsoft 143015 163000 Washington
Huawei 129184 197000 Shenzhen
Truco: Es posible usar «slicing» (troceado) en el acceso a registros y columnas.
Selección condicional
Es posible aplicar ciertas condiciones en la selección de los datos para obtener el subconjunto
que estemos buscando. Veremos distintas aproximaciones a esta técnica.
Supongamos que queremos seleccionar aquellas empresas con base en Estados Unidos.
Si aplicamos la condición sobre la columna obtendremos una serie de tipo «booleano» en la
que se indica para qué registros se cumple la condición (incluyendo el índice):
396 Capítulo 8. Ciencia de datos

-- 400 of 516 --

Aprende Python
>>> df[ Country ] == United States
Company
Apple True
Samsung Electronics False
Alphabet True
Foxconn False
Microsoft True
Huawei False
Dell Technologies True
Facebook True
Sony False
Hitachi False
Intel True
IBM True
Tencent False
Panasonic False
Lenovo False
HP Inc. True
LG Electronics False
Name: Country, dtype: bool
Si aplicamos esta «máscara» al conjunto original de datos, obtendremos las empresas que
estamos buscando:
>>> df[df[ Country ] == United States ]
Revenue Employees City Country
Company
Apple 274515 147000 California United States
Alphabet 182527 135301 California United States
Microsoft 143015 163000 Washington United States
Dell Technologies 92224 158000 Texas United States
Facebook 85965 58604 California United States
Intel 77867 110600 California United States
IBM 73620 364800 New York United States
HP Inc. 56639 53000 California United States
También es posible aplicar condiciones compuestas. Supongamos que necesitamos selecionar
aquellas empresas con más de 100000 millones de dólares de ingresos y más de
100000 empleados/as:
>>> revenue_condition = df[ Revenue ] > 100_000
>>> employees_condition = df[ Employees ] > 100_000
>>> df[revenue_condition & employees_condition]
Revenue Employees City Country
Company
(continué en la próxima página)
8.3. pandas 397

-- 401 of 516 --

Aprende Python
(proviene de la página anterior)
Apple 274515 147000 California United States
Samsung Electronics 200734 267937 Suwon South Korea
Alphabet 182527 135301 California United States
Foxconn 181945 878429 New Taipei City Taiwan
Microsoft 143015 163000 Washington United States
Huawei 129184 197000 Shenzhen China
Los operadores lógicos que se pueden utilizar para combinar condiciones de selección son los
siguientes:
Operador Significado
| «or» lógico
& «and» lógico
~ «not» lógico
^ «xor» lógico
Imaginemos ahora que estamos buscando aquellas empresas establecidas en California
o Tokyo. Una posible aproximación sería utilizar una condición compuesta, pero existe la
función isin() que nos permite comprobar si un valor está dentro de una lista de opciones:
>>> mask = df[ City ].isin([ California , Tokyo ])
>>> df[mask]
Revenue Employees City Country
Company
Apple 274515 147000 California United States
Alphabet 182527 135301 California United States
Facebook 85965 58604 California United States
Sony 84893 109700 Tokyo Japan
Hitachi 82345 350864 Tokyo Japan
Intel 77867 110600 California United States
HP Inc. 56639 53000 California United States
Ejercicio
Obtenga los siguientes subconjuntos del «dataset» democan: