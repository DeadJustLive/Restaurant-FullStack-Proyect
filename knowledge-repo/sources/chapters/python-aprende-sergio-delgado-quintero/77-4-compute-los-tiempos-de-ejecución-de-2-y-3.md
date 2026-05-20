# 4. Compute los tiempos de ejecución de 2) y 3)

8.2.5 Álgebra lineal
NumPy tiene una sección dedicada al álgebra lineal cuyas funciones pueden resultar muy
interesantes según el contexto en el que estemos trabajando.
Producto de matrices
Si bien hemos hablado del producto de arrays elemento a elemento, NumPy nos permite
hacer la multiplicación clásica de matrices:
>>> m1
array([[1, 8, 4],
[8, 7, 1],
[1, 3, 8]])
>>> m2
(continué en la próxima página)
364 Capítulo 8. Ciencia de datos

-- 368 of 516 --

Aprende Python
(proviene de la página anterior)
array([[1, 5, 7],
[9, 4, 2],
[1, 4, 2]])
>>> np.dot(m1, m2)
array([[77, 53, 31],
[72, 72, 72],
[36, 49, 29]])
En Python 3.5 se introdujo el operador @ que permitía implementar el método especial
__matmul__() de multiplicación de matrices. NumPy lo ha desarrollado y simplifica la
multiplicación de matrices de la siguiente manera:
>>> m1 @ m2
array([[77, 53, 31],
[72, 72, 72],
[36, 49, 29]])
Ejercicio
Compruebe que la matriz
[︂

1 2
3 5
]︂

satisface la ecuación matricial: 𝑋2 − 6𝑋 − 𝐼 = 0 donde 𝐼
es la matriz identidad de orden 2.
Determinante de una matriz
El cálculo del determinante es una operación muy utilizada en álgebra lineal. Lo podemos
realizar en NumPy de la siguiente manera:
>>> m
array([[4, 1, 6],
[4, 8, 8],
[2, 1, 7]])
>>> np.linalg.det(m)
108.00000000000003
8.2. numpy 365

-- 369 of 516 --

Aprende Python
Inversa de una matriz
La inversa de una matriz se calcula de la siguiente manera:
>>> m
array([[4, 1, 6],
[4, 8, 8],
[2, 1, 7]])
>>> m_inv = np.linalg.inv(m)
>>> m_inv
array([[ 0.44444444, -0.00925926, -0.37037037],
[-0.11111111, 0.14814815, -0.07407407],
[-0.11111111, -0.01851852, 0.25925926]])
Una propiedad de la matriz inversa es que si la multiplicamos por la matriz de partida
obtenemos la matriz identidad. Vemos que se cumple 𝒜 · 𝒜−1 = ℐ:
>>> np.dot(m, m_inv)
array([[1., 0., 0.],
[0., 1., 0.],
[0., 0., 1.]])
Traspuesta de una matriz
La traspuesta de una matriz 𝒜 se denota por: (𝒜𝑡)𝑖𝑗 = 𝒜𝑗𝑖, 1 ≤ 𝑖 ≤ 𝑛, 1 ≤ 𝑗 ≤ 𝑚, pero
básicamente consiste en intercambiar filas por columnas.
Aún más fácil es computar la traspuesta de una matriz con NumPy:
>>> m
array([[1, 2, 3],
[4, 5, 6]])
>>> m.T
array([[1, 4],
[2, 5],
[3, 6]])
Ejercicio
Dadas las matrices:
𝐴 =
[︂

1 −2 1
3 0 1
]︂

; 𝐵 =
[︂

4 0 −1
−2 1 0
]︂
366 Capítulo 8. Ciencia de datos

-- 370 of 516 --

Aprende Python
, compruebe que se cumplen las siguientes igualdades:
• (𝐴 + 𝐵)𝑡 = 𝐴𝑡 + 𝐵𝑡
• (3𝐴)𝑡 = 3𝐴𝑡
Elevar matriz a potencia
En el mundo del álgebra lineal es muy frecuente recurrir a la exponenciación de matrices a
a través de su producto clásico. En este sentido, NumPy nos proporciona una función para
computarlo:
>>> m
array([[4, 1, 6],
[4, 8, 8],
[2, 1, 7]])
>>> np.linalg.matrix_power(m, 3) # más eficiente que np.dot(m, np.dot(m, m))
array([[ 348, 250, 854],
[ 848, 816, 2000],
[ 310, 231, 775]])
Ejercicio
Dada la matriz 𝐴 =
⎡
⎣
4 5 −1
−3 −4 1
−3 −4 0
⎤
⎦ calcule: 𝐴2, 𝐴3, . . . , 𝐴128
¿Nota algo especial en los resultados?
Sistemas de ecuaciones lineales
NumPy también nos permite resolver sistemas de ecuaciones lineales. Para ello debemos
modelar nuestro sistema a través de arrays.
Veamos un ejemplo en el que queremos resolver el siguiente sistema de ecuaciones lineales:
⎧
⎪	⎨
⎪	⎩
𝑥1 + 2𝑥3 = 1
𝑥1 − 𝑥2 = −2
𝑥2 + 𝑥3 = −1
=⇒
⎛
⎝
1 0 2
1 −1 0
0 1 1
⎞
⎠
⎛
⎝
𝑥1
𝑥2
𝑥3
⎞
⎠ =
⎛
⎝
1
−2
−1
⎞
⎠ =⇒ 𝒜𝒳 = ℬ
Podemos almacenar las matrices de coeficientes 𝒜 y ℬ de la siguiente manera:
8.2. numpy 367

-- 371 of 516 --

Aprende Python
>>> A = np.array([[1, 0, 2], [1, -1, 0], [0, 1, 1]])
>>> B = np.array([1, -2, -1]).reshape(-1, 1)
>>> A
array([[ 1, 0, 2],
[ 1, -1, 0],
[ 0, 1, 1]])
>>> B
array([[ 1],
[-2],
[-1]])
La solución al sistema viene dada por la siguiente función:
>>> np.linalg.solve(A, B)
array([[-7.],
[-5.],
[ 4.]])
La solución del sistema debe ser la misma que si obtenemos 𝒳 = 𝒜−1 · 𝐵:
>>> np.dot(np.linalg.inv(A), B)
array([[-7.],
[-5.],
[ 4.]])
Ejercicio
Resuelva el siguiente sistema de ecuaciones lineales:
⎧
⎪	⎨
⎪	⎩
3𝑥 + 4𝑦 − 𝑧 = 8
5𝑥 − 2𝑦 + 𝑧 = 4
2𝑥 − 2𝑦 + 𝑧 = 1
368 Capítulo 8. Ciencia de datos

-- 372 of 516 --

Aprende Python
8.3 pandas
pandas es un paquete open-source que nos proporciona una forma sencilla y potente de
trabajar con estructuras de datos a través de múltiples herramientas para su análisis.1
$ pip install pandas
La forma más común de importar esta librería es usar el alias pd:
>>> import pandas as pd
Si bien en Numpy la estructura de datos fundamental es el ndarray, en pandas existen dos
estructuras de datos sobre las que giran todas las operaciones:
• Series.
• Dataframes.
1 Foto original de portada por Sid Balachandran en Unsplash.
8.3. pandas 369

-- 373 of 516 --

Aprende Python
8.3.1 Series
Podríamos pensar en una serie como un ndarray en el que cada valor tiene asignado una
etiqueta (índice) y además admite un título (nombre).
Creación de una serie
Veamos varios ejemplos de creación de la serie [1, 2, 3].
Creación de series usando listas:
>>> pd.Series([1, 2, 3])
0 1
1 2
2 3
dtype: int64
Nota: El índice por defecto se crea con números enteros positivos empezando desde
0.
Especificando un índice personalizado (etiqueta a cada valor):
>>> pd.Series(range(1, 4), index=[ a , b , c ])
a 1
b 2
c 3
dtype: int64
Especificando un diccionario con etiquetas y valores:
>>> items = { a : 1, b : 2, c : 3}
>>> pd.Series(items)
a 1
b 2
c 3
dtype: int64
Todas las series que hemos visto hasta ahora no tienen asignado ningún nombre. Lo podemos
hacer usando el parámetro name en la creación de la serie:
>>> pd.Series([1, 2, 3], name= integers )
0 1
1 2
(continué en la próxima página)
370 Capítulo 8. Ciencia de datos

-- 374 of 516 --

Aprende Python
(proviene de la página anterior)
2 3
Name: integers, dtype: int64
Ejercicio
Cree una serie de pandas con valores enteros en el intervalo [1, 26] y etiquetas
ABCDEFGHIJKLMNOPQRSTUVWXYZ . Busque una manera programática (no manual) de hacerlo
(recuerde el módulo string).
Atributos de una serie
Las series en pandas contienen gran cantidad de atributos. A continuación destacaremos
algunos de ellos.
Trabajaremos con datos que contienen el número de empleados/as de diferentes empresas
tecnológicas2:
>>> data
{ Apple : 147000,
Samsung : 267937,
Google : 135301,
Microsoft : 163000,
Huawei : 197000,
Dell : 158000,
Facebook : 58604,
Foxconn : 878429,
Sony : 109700}
>>> employees = pd.Series(data, name= Tech Employees )
Índice de la serie:
>>> employees.index
Index([ Apple , Samsung , Google , Microsoft , Huawei , Dell , Facebook ,
Foxconn , Sony ],
dtype= object )
Valores de la serie:
>>> employees.values
array([147000, 267937, 135301, 163000, 197000, 158000, 58604, 878429,
109700])
2 Fuente: Wikipedia.
8.3. pandas 371

-- 375 of 516 --

Aprende Python
Tipo de la serie:
>>> employees.dtype
dtype( int64 )
Nombre de la serie:
>>> employees.name
Tech Employees
Memoria ocupada por la serie:
>>> employees.nbytes
72
Número de registros de la serie:
>>> employees.size
9
Selección de registros
La selección de los datos se puede realizar desde múltiples aproximaciones. A continuación
veremos las posiblidades que nos ofrece pandas para seleccionar/filtrar los registros de una
serie.
>>> employees
Apple 147000
Samsung 267937
Google 135301
Microsoft 163000
Huawei 197000
Dell 158000
Facebook 58604
Foxconn 878429
Sony 109700
Name: Tech Employees, dtype: int64
372 Capítulo 8. Ciencia de datos

-- 376 of 516 --

Aprende Python
Selección usando indexado numérico
Para acceder a los registros por su posición (índice numérico) basta usar corchetes como ya
se ha visto en cualquier secuencia:
>>> employees[0]
147000
>>> employees[-1]
109700
>>> employees[2:5]
Google 135301
Microsoft 163000
Huawei 197000
Name: Tech Employees, dtype: int64
>>> employees[1:6:2]
Samsung 267937
Microsoft 163000
Dell 158000
Name: Tech Employees, dtype: int64
El atributo iloc es un alias (algo más expresivo) que permite realizar las mismas operaciones
de indexado (con corchetes) que hemos visto anteriormente:
>>> employees.iloc[1:6:2]
Samsung 267937
Microsoft 163000
Dell 158000
Name: Tech Employees, dtype: int64
Truco: Python, y en este caso pandas, se dicen «0-index» porque sus índices (posiciones)
comienzan en cero.
Selección usando etiquetas
En el caso de aquellas series que dispongan de un índice con etiquetas, podemos acceder a
sus registros utilizando las mismas:
>>> employees[ Apple ] # equivalente a employees.Apple
147000
(continué en la próxima página)
8.3. pandas 373

-- 377 of 516 --

Aprende Python
(proviene de la página anterior)
>>> employees[ Apple : Huawei ]
Apple 147000
Samsung 267937
Google 135301
Microsoft 163000
Huawei 197000
Name: Tech Employees, dtype: int64
>>> employees[ Apple : Huawei :2]
Apple 147000
Google 135301
Huawei 197000
Name: Tech Employees, dtype: int64
El atributo loc es un alias (algo más expresivo) que permite realizar las mismas operaciones
de indexado (con corchetes) que hemos visto anteriormente:
>>> employees.loc[ Apple : Huawei :2]
Apple 147000
Google 135301
Huawei 197000
Name: Tech Employees, dtype: int64
Fragmentos de comienzo y fin
A nivel exploratorio, es bastante cómodo acceder a una porción inicial (o final) de los datos
que manejamos. Esto se puede hacer de forma muy sencilla con series:
>>> employees.head(3)
Apple 147000
Samsung 267937
Google 135301
Name: Tech Employees, dtype: int64
>>> employees.tail(3)
Facebook 58604
Foxconn 878429
Sony 109700
Name: Tech Employees, dtype: int64
374 Capítulo 8. Ciencia de datos

-- 378 of 516 --

Aprende Python
Operaciones con series
Si tenemos en cuenta que una serie contiene valores en formato ndarray podemos concluir
que las operaciones sobre arrays son aplicables al caso de las series. Veamos algunos ejemplos
de operaciones que podemos aplicar sobre series.
Operaciones lógicas
Supongamos que queremos filtrar aquellas empresas que tengan más de 200000
trabajadores/as:
>>> employees > 200_000
Apple False
Samsung True
Google False
Microsoft False
Huawei False
Dell False
Facebook False
Foxconn True
Sony False
Name: Tech Employees, dtype: bool
Hemos obtenido una serie «booleana». Si queremos aplicar esta «máscara», podemos hacerlo
con indexado:
>>> employees[employees > 200_000] # empresas con más de 200K trabajadores/as
Samsung 267937
Foxconn 878429
Name: Tech Employees, dtype: int64
Ordenación
Ordenación de una serie por sus valores:
>>> employees.sort_values()
Facebook 58604
Sony 109700
Google 135301
Apple 147000
Dell 158000
Microsoft 163000
Huawei 197000
(continué en la próxima página)
8.3. pandas 375

-- 379 of 516 --

Aprende Python
(proviene de la página anterior)
Samsung 267937
Foxconn 878429
Name: Tech Employees, dtype: int64
Ordenación de una serie por su índice:
>>> employees.sort_index()
Apple 147000
Dell 158000
Facebook 58604
Foxconn 878429
Google 135301
Huawei 197000
Microsoft 163000
Samsung 267937
Sony 109700
Name: Tech Employees, dtype: int64
Truco: Ambos métodos admiten el parámetro ascending para indicar si la ordenación es
ascendente (True) o descendente (False); y también admiten el parámetro inplace para
indicar si se quiere modificar los valores de la serie (True) o devolver una nueva ya ordenada
(False).
Contando valores
Si queremos obtener una «tabla de frecuencias» podemos contar los valores que existen en
nuestra serie:
>>> marks = pd.Series([5, 5, 3, 6, 5, 2, 8, 3, 8, 7, 6])
>>> marks.value_counts()
5 3
3 2
6 2
8 2
2 1
7 1
dtype: int64
Vinculado con el caso anterior, podemos obtener el número de valores únicos en la serie:
376 Capítulo 8. Ciencia de datos

-- 380 of 516 --

Aprende Python
>>> marks.nunique()
6
El método count() devuelve el número de valores «no nulos» que contiene la serie:
>>> marks.count() # en este caso es equivalente a marks.size
11
Operaciones aritméticas
Operaciones entre series y escalares
Podemos operar entre series y escalares sin ningún tipo de problema:
>>> employees / 1000
Apple 147.000
Samsung 267.937
Google 135.301
Microsoft 163.000
Huawei 197.000
Dell 158.000
Facebook 58.604
Foxconn 878.429
Sony 109.700
Name: Tech Employees, dtype: float64
Operaciones entre series
Para el caso de operaciones entre series, vamos a ejemplificarlo con las dos siguientes3:
>>> employees
Apple 147000
Samsung 267937
Google 135301
Microsoft 163000
Huawei 197000
Dell 158000
Facebook 58604
Foxconn 878429
Sony 109700
Name: Tech Employees, dtype: int64
(continué en la próxima página)
3 Los datos de ingresos («revenues») están en billones (americanos) de dólares.
8.3. pandas 377

-- 381 of 516 --

Aprende Python
(proviene de la página anterior)
>>> revenues
Apple 274515
Samsung 200734
Google 182527
Microsoft 143015
Huawei 129184
Dell 92224
Facebook 85965
Foxconn 181945
Sony 84893
Name: Tech Revenues, dtype: int64
Supongamos que queremos calcular la ratio de ingresos por trabajador/a:
>>> revenues / employees
Apple 1.867449
Samsung 0.749184
Google 1.349044
Microsoft 0.877393
Huawei 0.655756
Dell 0.583696
Facebook 1.466879
Foxconn 0.207125
Sony 0.773865
dtype: float64
Truco: Tener en cuenta que las operaciones se realizan entre registros que tienen el mismo
índice (etiqueta).
Funciones estadísticas
Existen multitud de funciones estadísticas que podemos aplicar a una serie. Dependiendo
del tipo de dato con el que estamos trabajando, serán más útiles unas que otras. Veamos dos
funciones a modo de ejemplo:
>>> employees.mean()
234996.77777777778
>>> employees.std()
248027.7840619765
378 Capítulo 8. Ciencia de datos

-- 382 of 516 --

Aprende Python
Máximos y mínimos
El abanico de posibilidades es muy amplio en cuanto a la búsqueda de valores máximos y
mínimos en una serie. Veamos lo que nos ofrece pandas a este respecto.
Obtener valor mínimo/máximo de una serie:
>>> employees.min()
58604
>>> employees.max()
878429
Posición (índice) del valor mínimo/máximo de una serie:
>>> employees.argmin() # employees[6] = 58604
6
>>> employees.argmax() # employees[7] = 878429
7
Etiqueta (índice) del valor mínimo/máximo de una serie:
>>> employees.idxmin()
Facebook
>>> employees.idxmax()
Foxconn
Obtener los 𝑛 valores menores/mayores de una serie:
>>> employees.nsmallest(3)
Facebook 58604
Sony 109700
Google 135301
Name: Tech Employees, dtype: int64
>>> employees.nlargest(3)
Foxconn 878429
Samsung 267937
Huawei 197000
Name: Tech Employees, dtype: int64
8.3. pandas 379

-- 383 of 516 --

Aprende Python
Exportación de series
Suele ser bastante habitual intercambiar datos en distintos formatos (y aplicaciones). Para
ello, pandas nos permite exportar una serie a multitud de formatos. Veamos algunos de ellos:
Exportación de serie a lista:
>>> employees.to_list()
[147000, 267937, 135301, 163000, 197000, 158000, 58604, 878429, 109700]
Exportación de serie a diccionario:
>>> employees.to_dict()
{ Apple : 147000,
Samsung : 267937,
Google : 135301,
Microsoft : 163000,
Huawei : 197000,
Dell : 158000,
Facebook : 58604,
Foxconn : 878429,
Sony : 109700}
Exportación de serie a csv:
>>> employees.to_csv()
,Tech Employees\nApple,147000\nSamsung,267937\nGoogle,135301\nMicrosoft,163000\
˓→nHuawei,197000\nDell,158000\nFacebook,58604\nFoxconn,878429\nSony,109700\n
Exportación de serie a json:
>>> employees.to_json()
{"Apple":147000,"Samsung":267937,"Google":135301,"Microsoft":163000,"Huawei
˓→":197000,"Dell":158000,"Facebook":58604,"Foxconn":878429,"Sony":109700}
Exportación de serie a pandas.DataFrame:
>>> employees.to_frame()
Tech Employees
Apple 147000
Samsung 267937
Google 135301
Microsoft 163000
Huawei 197000
Dell 158000
Facebook 58604
Foxconn 878429
Sony 109700
380 Capítulo 8. Ciencia de datos

-- 384 of 516 --

Aprende Python
Y muchos otros como: to_clipboard(), to_numpy(), to_pickle(), to_string(),
to_xarray(), to_excel(), to_hdf(), to_latex(), to_markdown(), to_period(), to_sql()
o to_timestamp().
8.3.2 DataFrames
Un DataFrame es una estructura tabular compuesta por series. Se trata del tipo de datos
fundamental en pandas y sobre el que giran la mayoría de operaciones que podemos realizar.
Figura 17: Estructura de un DataFrame a partir de Series
Creación de un DataFrame
Existen múltiples formas de crear un DataFrame en pandas. Veamos algunas de ellas.
DataFrame desde diccionario de listas
Cada elemento del diccionario se convierte en una columna, donde su clave es el nombre y
sus valores se despliegan en «vertical»:
>>> data = { A : [1, 2, 3], B : [4, 5, 6]}
>>> pd.DataFrame(data)
A B
0 1 4
1 2 5
2 3 6
8.3. pandas 381

-- 385 of 516 --

Aprende Python
DataFrame desde lista de diccionarios
Cada elemento de la lista se convierte en una fila. Las claves de cada diccionario serán los
nombres de las columnas y sus valores se despliegan en «horizontal»:
>>> data = [{ A : 1, B : 2, C : 3}, { A : 4, B : 5, C : 6}]
>>> pd.DataFrame(data)
A B C
0 1 2 3
1 4 5 6
DataFrame desde lista de listas
Cada elemento de la lista se convierte en una fila y sus valores se despliegan en «horizontal».
Los nombres de las columnas deben pasarse como parámetro opcional:
>>> data = [[1, 2], [3, 4], [5, 6]]
>>> pd.DataFrame(data, columns=[ A , B ])
A B
0 1 2
1 3 4
2 5 6
DataFrame desde series
>>> employees
Apple 147000
Samsung 267937
Google 135301
Microsoft 163000
Huawei 197000
Dell 158000
Facebook 58604
Foxconn 878429
Sony 109700
Name: Tech Employees, dtype: int64
>>> revenues
Apple 274515
Samsung 200734
(continué en la próxima página)
382 Capítulo 8. Ciencia de datos

-- 386 of 516 --

Aprende Python
(proviene de la página anterior)
Google 182527
Microsoft 143015
Huawei 129184
Dell 92224
Facebook 85965
Foxconn 181945
Sony 84893
Name: Tech Revenues, dtype: int64
>>> pd.DataFrame({ employees : employees, revenues : revenues})
employees revenues
Apple 147000 274515
Samsung 267937 200734
Google 135301 182527
Microsoft 163000 143015
Huawei 197000 129184
Dell 158000 92224
Facebook 58604 85965
Foxconn 878429 181945
Sony 109700 84893
Ejercicio
Cree el siguiente DataFrame en Pandas5:
5 Datos extraídos de Wikipedia.
8.3. pandas 383

-- 387 of 516 --

Aprende Python
La superficie (Area) está expresada en km2 y las provincias corresponden con LPGC: Las
Palmas de Gran Canaria y SCTF: Santa Cruz de Tenerife.
Importante: Nos referiremos a este DataFrame como democan de ahora en adelante.
Gestión del índice
Cuando creamos un DataFrame, pandas autocompleta el índice con un valor entero
autoincremental comenzando desde cero:
>>> pd.DataFrame({ A : [1, 2], B : [3, 4]})
A B
0 1 3
1 2 4
Si queremos convertir alguna columna en el índice de la tabla, podemos hacerlo así:
>>> stats = pd.DataFrame({ A : [1, 2], B : [3, 4]})
>>> stats.set_index( A ) # columna A como índice
B
(continué en la próxima página)
384 Capítulo 8. Ciencia de datos

-- 388 of 516 --

Aprende Python
(proviene de la página anterior)
A
1 3
2 4
Nota: En el caso anterior se puede observar que el índice toma un nombre A. Esto se puede
conseguir directamente asignando un valor a df.index.name.
Podemos añadir un parámetro (en la creación) para especificar los valores que queremos
incluir en el índice:
>>> pd.DataFrame({ A : [1, 2], B : [3, 4]}, index=[ R1 , R2 ])
A B
R1 1 3
R2 2 4
En aquellos DataFrames que disponen de un índice etiquetado, es posible resetearlo:
>>> pd.DataFrame({ A : [1, 2], B : [3, 4]}, index=[ R1 , R2 ]).reset_index()
index A B
0 R1 1 3
1 R2 2 4
Ejercicio
Convierta la columna Island en el índice de democan. El DataFrame debería de quedar así:
>>> df
Population Area Province
Island
Gran Canaria 855521 1560.10 LPGC
Tenerife 928604 2034.38 SCTF
La Palma 83458 708.32 SCTF
Lanzarote 155812 845.94 LPGC
La Gomera 21678 369.76 SCTF
El Hierro 11147 278.71 SCTF
Fuerteventura 119732 1659.00 LPGC
8.3. pandas 385

-- 389 of 516 --

Aprende Python
Lectura de fuentes externas
Lo más habitual cuando se trabaja en ciencia de datos es tener la información en distintas
fuentes auxiliares: bases de datos, ficheros, llamadas remotas a APIs, etc. Pandas nos ofrece
una variedad enorme de funciones para cargar datos desde, prácticamente, cualquier origen.
Tabla 2: Funciones para lectura de datos en pandas
Función Explicación
read_pickle Lectura de datos en formato pickle (Python)
read_table Lectura de ficheros con delimitadores
read_csv Lectura de ficheros .csv
read_fwf Lectura de tablas con líneas de ancho fijo
read_clipboard Lectura de texto del portapapeles
read_excel Lectura de ficheros excel
read_json Lectura de ficheros json
read_html Lectura de tablas HTML
read_xml Lectura de documentos XML
read_hdf Lectura de objetos pandas almacenados en fichero
read_feather Lectura de objetos en formato «feather»
read_parquet Lectura de objetos en formato «parquet»
read_orc Lectura de objetos en formato ORC
read_sas Lectura de ficheros SAS
read_spss Lectura de ficheros SPSS
read_sql_table Lectura de tabla SQL
read_sql_query Lectura de una consulta SQL
read_sql Wrapper para read_sql_table y read_sql_query
read_gbq Lectura de datos desde Google BigQuery
read_stata Lectura de ficheros Stata
Nota: Todas estas funciones tienen su equivalente para escribir datos en los distintos
formatos. En vez de read_ habría que usar el prefijo to_. Por ejemplo: .to_csv(), .to_json()
o .to_sql()
A modo de ilustración, vamos a leer el contenido del fichero tech.csv que contiene la lista
de las mayores empresas tecnológicas por ingresos totales (en millones de dólares)2.
Usaremos la función read_csv() que espera la coma como separador de campos. Este fichero
está delimitado por tabuladores, por lo que especificaremos esta circunstancia mediante el
parámetro delimiter. Igualmente, vamos a indicar que se use la primera columna Company
como índice del DataFrame con el parámetro index_col:
386 Capítulo 8. Ciencia de datos

-- 390 of 516 --

Aprende Python
>>> df = pd.read_csv( tech.csv , delimiter= \t , index_col= Company )
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
Intel 77867 110600 California United States
IBM 73620 364800 New York United States
Tencent 69864 85858 Shenzhen China
Panasonic 63191 243540 Osaka Japan
Lenovo 60742 71500 Hong Kong China
HP Inc. 56639 53000 California United States
LG Electronics 53625 75000 Seoul South Korea
Truco: Se suele usar df como nombre para las variables tipo DataFrame.
Ejercicio
Cargue el conjunto de datos democan desde democan.csv en un DataFrame df indicando que
la columna Island es el índice.
También es posible cargar el «dataset» a través de la URL que conseguimos con botón derecho:
copiar enlace.
Características de un DataFrame
Visualización de los datos
Para «echar un vistazo» a los datos, existen dos funciones muy recurridas:
>>> df.head()
Revenue Employees City Country
(continué en la próxima página)
8.3. pandas 387

-- 391 of 516 --

Aprende Python
(proviene de la página anterior)
Company
Apple 274515 147000 California United States
Samsung Electronics 200734 267937 Suwon South Korea
Alphabet 182527 135301 California United States
Foxconn 181945 878429 New Taipei City Taiwan
Microsoft 143015 163000 Washington United States
>>> df.tail()
Revenue Employees City Country
Company
Tencent 69864 85858 Shenzhen China
Panasonic 63191 243540 Osaka Japan
Lenovo 60742 71500 Hong Kong China
HP Inc. 56639 53000 California United States
LG Electronics 53625 75000 Seoul South Korea
Truco: Estas funciones admiten como parámetro el número de registros a visualizar.
Información sobre los datos
Pandas ofrece algunas funciones que proporcionan un cierto «resumen» de los datos a nivel
descriptivo. Veamos algunas de ellas.
Información sobre columnas:
>>> df.info()
<class pandas.core.frame.DataFrame >
Index: 17 entries, Apple to LG Electronics
Data columns (total 4 columns):