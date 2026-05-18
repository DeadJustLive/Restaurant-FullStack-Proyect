# IBM USA

Tencent CHN
Panasonic JPN
Lenovo CHN
HP Inc. USA
LG Electronics KOR
Name: Country, dtype: object
Ejercicio
Recodifique la columna Province del «dataset» democan de tal manera que aparezcan las
provincias con el texto completo: Santa Cruz de Tenerife y Las Palmas de Gran Canaria.
8.3. pandas 403

-- 407 of 516 --

Aprende Python
Insertando y borrando filas
Podemos insertar datos en un DataFrame como filas o como columnas.
Supongamos que queremos incluir una nueva empresa Cisco4:
>>> cisco = pd.Series(data=[51_904, 75_900, California , United States ],
... index=df_mod.columns, name= Cisco )
>>> cisco
Revenue 51904
Employees 75900
City California
Country United States
Name: Cisco, dtype: object
>>> df_mod = df_mod.append(cisco)
>>> df_mod.tail(3)
Revenue Employees City Country
Company
HP Inc. 67966.8 53000 Vigo Spain
LG Electronics 64350.0 75000 Vigo Spain
Cisco 51904.0 75900 California United States
Truco: El método append() devuelve un nuevo DataFrame con los datos añadidos. Es por
eso que si queremos consolidar los cambios, debemos realizar una asignación.
Imaginemos ahora que Facebook, Tencent e Hitachi caen en bancarrota y debemos
eliminarlas de nuestro conjunto de datos:
>>> df_mod = df_mod.drop(labels=[ Facebook , Tencent , Hitachi ])
>>> df_mod.index # ya no aparecen en el índice
Index([ Apple , Samsung Electronics , Alphabet , Foxconn , Microsoft ,
Huawei , Dell Technologies , Sony , Intel , IBM , Panasonic ,
Lenovo , HP Inc. , LG Electronics , Cisco ],
dtype= object , name= Company )
4 Datos del año 2020 según Wikipedia.
404 Capítulo 8. Ciencia de datos

-- 408 of 516 --

Aprende Python
Insertando y borrando columnas
Insertar una columna en un DataFrame es equivalente a añadir una clave en un diccionario.
Supongamos que queremos añadir una columna «Expenses» (gastos). No manejamos
esta información, así que, a modo de ejemplo, utilizaremos unos valores aleatorios:
>>> expenses = np.random.randint(50_000, 300_000, size=15)
>>> expenses
array([139655, 97509, 220777, 260609, 121145, 112338, 72815, 159843,
205695, 97672, 89614, 260028, 171650, 152049, 57006])
>>> df_mod[ Expenses ] = expenses
>>> df_mod.head()
Revenue Employees City Country Expenses
Company
Apple 329418.0 137000 Vigo Spain 139655
Samsung Electronics 240880.8 267937 Vigo Spain 97509
Alphabet 219032.4 135301 Vigo Spain 220777
Foxconn 218334.0 878429 Vigo Spain 260609
Microsoft 171618.0 163000 Vigo Spain 121145
Truco: También existe la función insert() que nos permite insertar una columna en una
posición determinada.
En el caso de que no nos haga falta una columna podemos borrarla fácilmente. Una opción
sería utilizar la sentencia del, pero seguiremos con el uso de funciones propias de pandas.
Imaginemos que queremos eliminar la columna «Expenses»:
>>> df_mod.columns
Index([ Revenue , Employees , City , Country , Expenses ], dtype= object )
>>> df_mod = df_mod.drop(labels= Expenses , axis=1)
>>> df_mod.columns
Index([ Revenue , Employees , City , Country ], dtype= object )
Truco: Recordar que el parámetro axis indica en qué «dirección» estamos trabajando.
Véase el acceso a un DataFrame.
8.3. pandas 405

-- 409 of 516 --

Aprende Python
El parámetro inplace
Muchas de las funciones de pandas se dicen «no destructivas» en el sentido de que no
modifican el conjunto de datos original, sino que devuelven uno nuevo con las modificaciones
realizadas. Pero este comportamiento se puede modificar utilizando el parámetro inplace.
Veamos un ejemplo con el borrado de columnas:
>>> df_mod.head()
Revenue Employees City Country
Company
Apple 329418.0 137000 Vigo Spain
Samsung Electronics 240880.8 267937 Vigo Spain
Alphabet 219032.4 135301 Vigo Spain
Foxconn 218334.0 878429 Vigo Spain
Microsoft 171618.0 163000 Vigo Spain
>>> df_mod.drop(labels=[ City , Country ], axis=1, inplace=True)
>>> df_mod.head()
Revenue Employees
Company
Apple 329418.0 137000
Samsung Electronics 240880.8 267937
Alphabet 219032.4 135301
Foxconn 218334.0 878429
Microsoft 171618.0 163000
Ejercicio
Añada una nueva columna Density a democan de tal manera que represente la densidad de
población de cada isla del archipiélago canario.
También es posible renombrar columnas utilizando la función rename() de Pandas.
Supongamos un caso de uso en el que queremos renombrar las columnas a sus tres
primeras letras en minúsculas. Tenemos dos maneras de hacerlo. La primera sería
directamente creando un «mapping» entre los nombres de columna actuales y los nombres
nuevos:
>>> new_columns = { Revenue : rev , Employees : emp , City : cit , Country :
˓→ cou }
>>> df.rename(columns=new_columns).head(3)
rev emp cit cou
(continué en la próxima página)
406 Capítulo 8. Ciencia de datos

-- 410 of 516 --

Aprende Python
(proviene de la página anterior)
Company
Apple 274515 147000 California United States
Samsung Electronics 200734 267937 Suwon South Korea
Alphabet 182527 135301 California United States
Otro camino para conseguir el mismo resultado es aplicar una función que realice esta tarea
de manera automatizada:
>>> df.rename(columns=lambda c: c.lower()[:3]).head(3)
rev emp cit cou
Company
Apple 274515 147000 California United States
Samsung Electronics 200734 267937 Suwon South Korea
Alphabet 182527 135301 California United States
Ver también:
Si en vez del parámetro nominal columns utilizamos el parámetro index estaremos
renombrando los valores del índice. Se aplica el mismo comportamiento ya visto.
Nada impide asignar directamente una lista (tupla) de nombres a las columnas de
un DataFrame:
>>> df.columns = ( Ingresos , Empleados , Ciudad , País )
>>> df.head(3)
Ingresos Empleados Ciudad País
Company
Apple 274515 147000 California United States
Samsung Electronics 200734 267937 Suwon South Korea
Alphabet 182527 135301 California United States
Otras operaciones con un DataFrame
Manejando cadenas de texto
A menudo solemos trabajar con datos que incluyen información textual. Pandas también nos
ofrece herramientas para cubrir estos casos.
De hecho, simplemente debemos utilizar el manejador str y tendremos a disposición la gran
mayoría de funciones vistas en la sección de cadenas de texto.
Veamos un primer ejemplo en el que pasamos a mayúsculas las ciudades en las que
se localizan las empresas tecnológicas:
8.3. pandas 407

-- 411 of 516 --

Aprende Python
>>> df[ City ].str.upper()
Company
Apple CALIFORNIA
Samsung Electronics SUWON
Alphabet CALIFORNIA
Foxconn NEW TAIPEI CITY
Microsoft WASHINGTON
Huawei SHENZHEN
Dell Technologies TEXAS
Facebook CALIFORNIA
Sony TOKYO
Hitachi TOKYO
Intel CALIFORNIA