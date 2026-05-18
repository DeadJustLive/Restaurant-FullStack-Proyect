# Column Non-Null Count Dtype

## Fuente
Aprende Python (Cap. 78)

## Contenido
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
Nota: El acceso a 
