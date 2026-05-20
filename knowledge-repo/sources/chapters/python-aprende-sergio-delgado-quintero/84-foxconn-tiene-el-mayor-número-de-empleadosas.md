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
Alphabet California United States 135301 182527
Apple California United States 147000 274515
Samsung Electronics Suwon South Korea 267937 200734
Truco: Nótese que las columnas tienen un nombre variable que se puede modificar
mediante columns.name.
Si queremos obtener el DataFrame en formato ancho, tal y como estaba, tenemos que realizar
alguna operación adicional: df.rename_axis(columns = None).reset_index().
Apilando datos
Las operaciones de apilado trabajan sobre los índices del DataFrame. Para comprobar su
aplicabilidad, vamos a añadir la columna «Company» como índice del «dataset» anterior:
>>> df.set_index( Company , inplace=True)
>>> df
Revenue Employees City Country
Company
Apple 274515 147000 California United States
Samsung Electronics 200734 267937 Suwon South Korea
Alphabet 182527 135301 California United States
La función stack() nos permite obtener un DataFrame con índice multinivel que incluye
las columnas del DataFrame de origen y los valores agrupados:
8.3. pandas 425

-- 429 of 516 --

Aprende Python
>>> df_stacked = df.stack()
>>> df_stacked
Company
Apple Revenue 274515
Employees 147000
City California
Country United States
Samsung Electronics Revenue 200734
Employees 267937
City Suwon
Country South Korea
Alphabet Revenue 182527
Employees 135301
City California
Country United States
dtype: object
>>> df_stacked.index
MultiIndex([( Apple , Revenue ),
( Apple , Employees ),
( Apple , City ),
( Apple , Country ),
( Samsung Electronics , Revenue ),
( Samsung Electronics , Employees ),
( Samsung Electronics , City ),
( Samsung Electronics , Country ),
( Alphabet , Revenue ),
( Alphabet , Employees ),
( Alphabet , City ),
( Alphabet , Country )],
names=[ Company , None])
La función unstack() realiza justo la operación contraria: convertir un DataFrame con índice
multinivel en un Dataframe en formato ancho con índice sencillo. Se podría ver como una
manera de aplanar el «dataset»:
>>> df_flat = df_stacked.unstack()
>>> df_flat
Revenue Employees City Country
Company
Apple 274515 147000 California United States
Samsung Electronics 200734 267937 Suwon South Korea
Alphabet 182527 135301 California United States
(continué en la próxima página)
426 Capítulo 8. Ciencia de datos

-- 430 of 516 --

Aprende Python
(proviene de la página anterior)
>>> df_flat.index
Index([ Apple , Samsung Electronics , Alphabet ], dtype= object , name= Company )
Agrupando datos
Las operaciones de agregado son muy recurridas y nos permiten extraer información
relevante, que, a simple vista, quizás no sea tan evidente.
Veamos un ejemplo en el que calculamos la suma de los ingresos de las empresas,
agrupados por país:
>>> df.groupby( Country )[ Revenue ].sum()
Country
China 259790
Japan 230429
South Korea 254359
Taiwan 181945
United States 986372
Name: Revenue, dtype: int64
También es posible realizar la agrupación en varios niveles. En el siguiente ejemplo tendremos
los datos agrupados por país y ciudad:
>>> df.groupby([ Country , City ])[ Revenue ].sum()
Country City
China Hong Kong 60742
Shenzhen 199048
Japan Osaka 63191
Tokyo 167238
South Korea Seoul 53625
Suwon 200734
Taiwan New Taipei City 181945
United States California 677513
New York 73620
Texas 92224
Washington 143015
Name: Revenue, dtype: int64
Ver también:
Cuando realizamos una agrupación por varias columnas, el resultado contiene un índice de
múltiples niveles. Podemos aplanar el DataFrame usando unstack().
Incluso podemos aplicar distintas funciones de agregación a cada columna. Supongamos
que necesitamos calcular la media de los ingresos y la mediana del número de
8.3. pandas 427

-- 431 of 516 --

Aprende Python
empleados/as, con las empresas agrupadas por país:
>>> df.groupby( Country ).agg({ Revenue : mean , Employees : median })
Revenue Employees
Country
China 86596.666667 85858.0
Japan 76809.666667 243540.0
South Korea 127179.500000 171468.5
Taiwan 181945.000000 878429.0
United States 123296.500000 141150.5
Nota: Utilizamos la función agg() pasando un diccionario cuyas claves son nombres de
columnas y cuyos valores son funciones a aplicar.
Ejercicio
Obtenga el porcentaje de población (en relación con el total) de cada provincia de las Islas
Canarias en base al «dataset» democan.
El resultado debería ser similar a:
• Las Palmas de Gran Canaria: 52%
• Santa Cruz de Tenerife: 48%
Aplicando funciones
Pandas permite la aplicación de funciones (tanto propias como «built-in») a filas y/o
columnas de un DataFrame.
Numpy nos ofrece una amplia gama de funciones matemáticas. Podemos hacer uso de
cualquier de ellas aplicándola directamente a nuestro conjunto de datos. Veamos un ejemplo
en el que obtenemos el máximo de cada columna:
>>> df.apply(np.max)
Revenue 274515
Employees 878429
City Washington
Country United States
dtype: object
Truco: En este caso equivalente a df.max().
428 Capítulo 8. Ciencia de datos

-- 432 of 516 --

Aprende Python
Podemos aplicar funciones sobre determinadas columnas. Supongamos que queremos obtener
el logaritmo de la serie de ingresos:
>>> df[ Revenue ].apply(np.log)
Company
Apple 12.522761
Samsung Electronics 12.209736
Alphabet 12.114653
Foxconn 12.111460
Microsoft 11.870705
Huawei 11.768993
Dell Technologies 11.431976
Facebook 11.361696
Sony 11.349147
Hitachi 11.318673
Intel 11.262758
IBM 11.206672
Tencent 11.154306
Panasonic 11.053917
Lenovo 11.014391
HP Inc. 10.944453
LG Electronics 10.889771
Name: Revenue, dtype: float64
Ahora imaginemos un escenario en el que la normativa de Estados Unidos ha
cambiado y obliga a sus empresas tecnológicas a aumentar un 5% el número
de empleados/as que tienen. Esto lo podríamos abordar escribiendo una función propia
que gestione cada fila del «dataset» y devuelva el valor adecuado de empleados/as según las
características de cada empresa:
>>> def raise_employment(row):
... num_employees = row[ Employees ]
... if row[ Country ] == United States :
... return num_employees * 1.05
... return num_employees
Ahora ya podemos aplicar esta función a nuestro DataFrame, teniendo en cuenta que
debemos actuar sobre el eje de filas (axis=1):
>>> df.apply(raise_employment, axis=1)
Company
Apple 154350.00
Samsung Electronics 267937.00
Alphabet 142066.05
Foxconn 878429.00
Microsoft 171150.00
Huawei 197000.00
(continué en la próxima página)
8.3. pandas 429

-- 433 of 516 --

Aprende Python
(proviene de la página anterior)
Dell Technologies 165900.00
Facebook 61534.20
Sony 109700.00
Hitachi 350864.00
Intel 116130.00
IBM 383040.00
Tencent 85858.00
Panasonic 243540.00
Lenovo 71500.00
HP Inc. 55650.00
LG Electronics 75000.00
dtype: float64
El resultado es una serie que se podría incorporar al conjunto de datos, o bien, reemplazar
la columna Employees con estos valores.
Ejercicio
Supongamos que el Gobierno de Canarias va a dar unas ayudas a cada isla en función de su
superficie y su población, con las siguientes reglas:
• Islas con menos de 1000 km2: ayuda del 30% de su población.
• Islas con más de 1000 km2: ayuda del 20% de su población.
Añada una nueva columna Grant al «dataset» democan donde se contemplen estas ayudas.
El DataFrame debería quedar así:
Population Area Province Grant
Island
Gran Canaria 855521 1560.10 LPGC 171104.2
Tenerife 928604 2034.38 SCTF 185720.8
La Palma 83458 708.32 SCTF 25037.4
Lanzarote 155812 845.94 LPGC 46743.6
La Gomera 21678 369.76 SCTF 6503.4
El Hierro 11147 278.71 SCTF 3344.1
Fuerteventura 119732 1659.00 LPGC 23946.4
430 Capítulo 8. Ciencia de datos

-- 434 of 516 --

Aprende Python
Uniendo DataFrames
En esta sección veremos dos técnicas: Una de ellas «fusiona» dos DataFrames mientras que
la otra los «concatena».
Fusión de DataFrames
Pandas proporciona la función merge() para mezclar dos DataFrames. El comportamiento
de la función viene definido, entre otros, por el parámetro how que establece el método de
«fusión»:
Figura 19: Operaciones de mezcla con «merge»
En principio, si no establecemos ningún argumento adicional, «merge» tratará de vincular
aquellas filas con columnas homónimas en ambos conjuntos de datos. Si queremos especificar
8.3. pandas 431

-- 435 of 516 --

Aprende Python
que la mezcla se dirija por determinadas columnas, tenemos a disposición los parámetros on,
left_on o right_on.
Ver también:
Existe la posibilidad de generar un producto cartesiano entre las filas de ambos DataFrames.
Para ello podemos usar pd.merge(df1, df2, how= cross ).
Concatenación de DataFrames
Para concatenar dos DataFrames podemos utilizar la función concat() que permite añadir
las filas de un DataFrame a otro, o bien añadir las columnas de un DataFrame a otro.
Figura 20: Operaciones de concatenación con «concat»
Si queremos «reindexar» el DataFrame concatenado, la función concat() admite un
parámetro ignore_index que podemos poner a True. De esta forma tendremos un «dataset»
resultante con índice desde 0 hasta N.
Ejercicio
Obtenga los datos de población y superficie de las comunidades autónomas españolas desde
esta url de Wikipedia en un único DataFrame con la siguiente estructura:
Comunidad Superficie Población Densidad
0 Castilla y León 94226 2407650 25.551865
1 Andalucía 87268 8379248 96.017418
2 Casstilla-La Mancha 79463 2025510 25.489976
...
...
Notas:
432 Capítulo 8. Ciencia de datos

-- 436 of 516 --

Aprende Python
• Utilice la función pd.read_html() para acceder a las tablas. La tabla de superficie
tiene el índice 3 y la tabla de población tiene el índice 4.
• Elimine la última fila de totales en cada DataFrame y quédese sólo con las columnas
que interesen.
• Renombre las columnas según interese.
• Reemplace los valores de población y superficie para que sean números y convierta las
columnas a entero.
• Realice la mezcla de población y superficie en un único DataFrame.
• Calcule la densidad de población de cada comunidad autónoma.
8.4 matplotlib
matplotlib es el paquete Python más utilizado en el ámbito de la ciencia de datos para
representaciones gráficas.1
$ pip install matplotlib
La forma más común de importar esta librería es usar el alias plt de la siguiente manera:
1 Foto original de portada por Customerbox en Unsplash.
8.4. matplotlib 433

-- 437 of 516 --

Aprende Python
>>> import matplotlib.pyplot as plt
Importante: Si bien podemos utilizar matplotlib en el intérprete habitual de Python, suele
ser muy frecuente trabajar con esta librería mediante entornos Jupyter, ya que facilitan la
visualización de los gráficos en su interfaz de usuario.
8.4.1 Figura
La figura es el elemento base sobre el que se construyen todos los gráficos en matplotlib.
Veamos cómo crearla:
>>> fig = plt.figure()
>>> type(fig)
matplotlib.figure.Figure
>>> fig
<Figure size 640x480 with 0 Axes>
Podemos observar que la resolución (por defecto) de la figura es de 640x480 píxeles y que no
dispone de ningún eje («0 Axes»).
Importante: El término «axes» hace referencia a un conjunto de ejes. Puede resultar
confuso en español y he decidido asignar el nombre marco cuando haga referencia a «axes».
La resolución final de una figura viene determinada por su altura (height) y anchura (width)
especificadas en pulgadas2 que, a su vez, se multiplican por los puntos por pulgada o dpi.
Veamos el funcionamiento:
>>> fig
<Figure size 640x480 with 0 Axes>
>>> fig.get_figwidth() # pulgadas
6.4
>>> fig.get_figheight() # pulgadas
4.8
>>> fig.get_dpi() # dots per inch
100.0
(continué en la próxima página)
2 Se suele usar el término inglés «inches».
434 Capítulo 8. Ciencia de datos

-- 438 of 516 --

Aprende Python
(proviene de la página anterior)
>>> fig.get_figwidth() * fig.dpi, fig.get_figheight() * fig.dpi
(640.0, 480.0)
Importante: Si utilizamos entornos de desarollo basados en Jupyter, los valores por defecto
son distintos:
• Ancho de figura: 6 in
• Alto de figura: 4 in
• DPI: 75
• Resolución: 450x300 px
Por tanto, cuando creamos una figura podemos modificar los parámetros por defecto para
obtener la resolución deseada:
>>> fig = plt.figure(figsize=(19.2, 10.8)) # 100 dpi
>>> fig
<Figure size 1920x1080 with 0 Axes>
>>> fig = plt.figure(figsize=(19.2, 10.8), dpi=300)
>>> fig
<Figure size 5760x3240 with 0 Axes>
Si nos interesa que cualquier figura tome unos valores concretos de resolución, podemos
modificar los valores por defecto del entorno. Para ello, matplotlib hace uso de un
diccionario plt.rcParams que contiene los parámetros globales de configuración. Veamos
cómo modificarlo:
>>> plt.rcParams[ figure.figsize ]
[6.4, 4.8]
>>> plt.rcParams[ figure.dpi ]
100.0
>>> plt.rcParams[ figure.figsize ] = (10, 5)
>>> plt.rcParams[ figure.dpi ] = 300 # res. final: 3000x1500 px
>>> fig.get_figwidth()
10.0
>>> fig.get_figheight()
5.0
>>> fig.dpi
300.0
8.4. matplotlib 435

-- 439 of 516 --

Aprende Python
8.4.2 Marcos
Para poder empezar a graficar necesitamos tener, al menos, un marco. Utilizaremos la
función add_subplot() que requiere pasar como parámetros el número de filas, el número
de columnas y el marco activo:
Figura 21: Creación de marcos dentro de una figura
Para comenzar vamos a trabajar únicamente con un marco:
>>> fig = plt.figure()
>>> ax = fig.add_subplot(1, 1, 1) # equivalente a fig.add_subplot(111)
>>> ax
<AxesSubplot:>
>>> fig
<Figure size 640x480 with 1 Axes>
Truco: Suele ser habitual encontrar ax como nombre de variable del «axes» devuelto por
la función add_subplot().
436 Capítulo 8. Ciencia de datos

-- 440 of 516 --

Aprende Python
Nota: La escala por defecto de cada eje va de 0 a 1 con marcas cada 0.2
Ahora vamos a generar 4 marcos sobre los que fijaremos un título identificativo:
>>> fig = plt.figure()
>>> for i in range(1, 5):
... ax = fig.add_subplot(2, 2, i)
... ax.set_title(f Subplot {i} )
>>> fig.tight_layout(pad=1) # sólo para que no se solapen los títulos
>>> fig
<Figure size 640x480 with 4 Axes>
8.4. matplotlib 437

-- 441 of 516 --

Aprende Python
Atajo para subgráficos
Matplotlib nos ofrece una forma compacta de crear a la vez tanto la figura como los marcos
que necesitemos.
Para ello utilizaremos la función plt.subplots() que recibe como parámetros el número de
filas y el número de columnas para la disposición de los marcos, y devuelve una tupla con la
figura y los marcos.
En el siguiente ejemplo creamos una figura con un único marco:
>>> fig, ax = plt.subplots(1, 1)
>>> fig
<Figure size 640x480 with 1 Axes>
>>> ax
<AxesSubplot:>
Truco: Si invocamos la función plt.subplots() sin parámetros, creará (por defecto) un
438 Capítulo 8. Ciencia de datos

-- 442 of 516 --

Aprende Python
único marco.
En el siguiente ejemplo creamos una figura con 6 marcos en disposición de 2 filas por 3
columnas:
>>> fig, ax = plt.subplots(2, 3)
>>> fig
<Figure size 640x480 with 6 Axes>
>>> ax
array([[<AxesSubplot:>, <AxesSubplot:>, <AxesSubplot:>],
[<AxesSubplot:>, <AxesSubplot:>, <AxesSubplot:>]], dtype=object)
>>> ax.shape
(2, 3)
Nota: Se podría ver la función subplots() como una combinación de figure() +
add_subplot().
Etiquetas
Dentro de un marco también es posible fijar las etiquetas de los ejes (X e Y). Veamos cómo
hacerlo:
>>> fig, ax = plt.subplots()
>>> ax.set_title( Gráfico en blanco )
Text(0.5, 1.0, Gráfico en blanco )
>>> ax.set_xlabel( Etiqueta para el eje X )
Text(0.5, 0, Etiqueta para el eje X )
>>> ax.set_ylabel( Etiqueta para el eje Y )
Text(0, 0.5, Etiqueta para el eje Y )
>>> fig
<Figure size 640x480 with 1 Axes>
8.4. matplotlib 439

-- 443 of 516 --

Aprende Python
Ejes
Un marco (2D) está compuesto por dos ejes: eje X e eje Y. Podemos acceder a cada eje
mediante sendos atributos:
>>> ax.xaxis
<matplotlib.axis.XAxis at 0x112b34100>
>>> ax.yaxis
<matplotlib.axis.YAxis at 0x112b34850>
440 Capítulo 8. Ciencia de datos

-- 444 of 516 --

Aprende Python
Rejilla
En cada eje podemos activar o desactivar la rejilla, así como indicar su estilo.
En primer lugar vamos a activar la rejilla en ambos ejes:
>>> ax.xaxis.grid(True)
>>> ax.yaxis.grid(True)
Esto sería equivalente a:
>>> ax.grid(True)
Y obtendríamos una figura con la rejilla (por defecto):
Truco: Las funciones de matplotlib que actúan como «interruptores» tienen por defecto el
valor verdadero. En este sentido ax.grid() invocada sin parámetros hace que se muestre la
rejilla. Esto se puede aplicar a muchas otras funciones.
Supongamos ahora que queremos personalizar la rejilla con estilos diferentes en cada eje:
8.4. matplotlib 441

-- 445 of 516 --

Aprende Python
>>> ax.xaxis.grid(color= r , linestyle= - ) # equivale a color= red , linestyle=
˓→ solid
>>> ax.yaxis.grid(color= b , linestyle= - ) # equivale a color= blue , linestyle=
˓→ solid
• Parámetros disponibles para creación del grid.
• Listado de nombres de colores en matplotlib.
• Estilos de línea en matplotlib.
Marcas
Por defecto, los ejes del marco tienen unas marcas3 equiespaciadas que constituyen las marcas
mayores. Igualmente existen unas marcas menores que, a priori, no están activadas.
Ambos elementos son susceptibles de modificarse. Veamos un ejemplo en el que establecemos
las marcas menores con distinto espaciado en cada eje y además le damos un estilo
diferente a cada rejilla:
3 Se suele usar el término inglés «ticks».
442 Capítulo 8. Ciencia de datos

-- 446 of 516 --

Aprende Python
>>> from matplotlib.ticker import MultipleLocator
>>> ax.xaxis.set_minor_locator(MultipleLocator(0.1)) # X: separación cada 0.1␣
˓→unidades
>>> ax.yaxis.set_minor_locator(MultipleLocator(0.05)) # Y: separación cada 0.05␣
˓→unidades
>>> ax.xaxis.grid(which= minor , linestyle= dashed , color= gray )
>>> ax.yaxis.grid(which= minor , linestyle= dashed , color= lightskyblue )
También es posible asignar etiquetas a las marcas menores. En ese sentido, veremos un
ejemplo en el que incorporamos los valores a los ejes con estilos propios:
• Marcas menores en el eje X: precisión de 1 decimal, tamaño de letra 8 y color gris.
• Marcas menores en el eje Y: precisión de 2 decimales, tamaño de letra 8 y color azul.
>>> # Eje X
>>> ax.xaxis.set_minor_formatter( {x:.1f} )
>>> ax.tick_params(axis= x , which= minor , labelsize=8, labelcolor= gray )
(continué en la próxima página)
8.4. matplotlib 443

-- 447 of 516 --

Aprende Python
(proviene de la página anterior)
>>> # Eje Y
>>> ax.yaxis.set_minor_formatter( {x:.2f} )
>>> ax.tick_params(axis= y , which= minor , labelsize=8, labelcolor= lightskyblue )
8.4.3 Primeros pasos
Vamos a empezar por representar la función 𝑓 (𝑥) = 𝑠𝑖𝑛(𝑥). Para ello crearemos una variable
𝑥 con valores flotantes equidistantes y una variable 𝑦 aplicando la función senoidal. Nos
apoyamos en numpy para ello. A continuación usaremos la función plot() del marco para
representar la función creada:
>>> x = np.linspace(0, 2 * np.pi)
>>> y = np.sin(x)
>>> fig, ax = plt.subplots()
>>> ax.plot(x, y)
[<matplotlib.lines.Line2D at 0x120914040>]
444 Capítulo 8. Ciencia de datos

-- 448 of 516 --

Aprende Python
Múltiples funciones
Partiendo de un mismo marco, es posible graficar todas las funciones que necesitemos. A
continuación crearemos un marco con las funciones seno y coseno:
>>> x = np.linspace(0, 2 * np.pi)
>>> sin = np.sin(x)
>>> cos = np.cos(x)
>>> fig, ax = plt.subplots()
>>> ax.plot(x, sin)
[<matplotlib.lines.Line2D at 0x1247b6310>]
>>> ax.plot(x, cos)
[<matplotlib.lines.Line2D at 0x112b0d4c0>]
8.4. matplotlib 445

-- 449 of 516 --

Aprende Python
Nota: Los colores «auto» asignados a las funciones siguen un ciclo establecido por matplotlib
que es igualmente personalizable.
Leyenda
En el caso de que tengamos múltiples gráficos en el mismo marco puede ser deseable mostrar
una leyenda identificativa. Para usarla necesitamos asignar etiquetas a cada función. Veamos
a continuación cómo incorporar una leyenda:
>>> ax.plot(x, sin, label= sin )
[<matplotlib.lines.Line2D at 0x124e07ac0>]
>>> ax.plot(x, cos, label= cos )
[<matplotlib.lines.Line2D at 0x123c58f10>]
>>> ax.legend()
<matplotlib.legend.Legend at 0x123c8f190>
446 Capítulo 8. Ciencia de datos

-- 450 of 516 --

Aprende Python
Es posible incorporar sintaxis Latex en los distintos elementos textuales de matplotlib. En
el siguiente ejemplo usaremos esta notación en las etiquetas de las funciones utilizando el
símbolo $ ... $ para ello:
>>> ax.plot(x, sin, label= $f_1(x) = sin(x)$ )
[<matplotlib.lines.Line2D at 0x11682f3a0>]
>>> ax.plot(x, cos, label= $f_2(x) = cos(x)$ )
[<matplotlib.lines.Line2D at 0x11682b3a0>]
8.4. matplotlib 447

-- 451 of 516 --

Aprende Python
Ubicación de la leyenda
Matplotlib intenta encontrar la mejor ubicación para la leyenda en el marco. Sin embargo,
también es posible personalizar el lugar en el que queremos colocarla.
Si nos interesa situar la leyenda en la parte superior central del marco haríamos lo
siguiente:
>>> ax.legend(loc= upper center )
<matplotlib.legend.Legend at 0x1167d43a0>
448 Capítulo 8. Ciencia de datos

-- 452 of 516 --

Aprende Python
Aplicando estilos
Para cada función que incluimos en el marco es posible establecer un estilo personalizado con
multitud de parámetros. Veamos la aplicación de algunos de estos parámetros a las funciones
seno y coseno con las que hemos estado trabajando:
>>> sin_style = dict(linewidth=3, color= darkorange )
>>> cos_style = dict(marker= o , markerfacecolor= limegreen , color= darkgreen )
>>> ax.plot(x, sin, label= $f_1(x) = sin(x)$ , **sin_style)
[<matplotlib.lines.Line2D at 0x1131e9fd0>]
>>> ax.plot(x, cos, label= $f_2(x) = cos(x)$ , **cos_style)
[<matplotlib.lines.Line2D at 0x1226d76d0>]
8.4. matplotlib 449

-- 453 of 516 --

Aprende Python
Acotando ejes
Hay veces que nos interesa definir los límites de los ejes. En ese caso, podemos hacerlo de
una manera muy sencilla:
>>> ax.set_xlim(0, np.pi / 2)
>>> ax.set_ylim(0, 1)
>>> ax.grid() # sólo a efectos estéticos
450 Capítulo 8. Ciencia de datos

-- 454 of 516 --

Aprende Python
Truco: También es posible especificar únicamente límite inferior o superior en
ambas funciones set_xlim() y set_ylim(). En ese caso, el otro valor sería ajustado
automáticamente por matplotlib.
Anotaciones
En ocasiones necesitamos añadir ciertas anotaciones al gráfico que estamos diseñando. Esto
permite destacar áreas o detalles que pueden ser relevantes.
Partiendo de las funciones seno y coseno con las que hemos estado trabajando, vamos a
suponer que queremos obtener sus puntos de corte, es decir, resolver la siguiente
ecuación:
𝑠𝑖𝑛(𝑥) = 𝑐𝑜𝑠(𝑥)
⇓
𝑥 = 𝜋
4 + 𝜋𝑛, 𝑛 ∈ Z
Para el caso que nos ocupa haríamos 𝑛 = 0 con lo que obtendríamos la siguiente solución:
8.4. matplotlib 451

-- 455 of 516 --

Aprende Python
>>> xsol = np.pi / 4 + np.pi * 0
>>> ysol = np.sin(xsol)
>>> xsol, ysol
(0.7853981633974483, 0.7071067811865475)
Vamos a insertar una serie de anotaciones en el gráfico:
• Flecha en el punto de corte con etiqueta de ecuación.
• Coordenadas de solución en el punto de corte.
• Proyección del punto de corte hacia ambos ejes.
>>> ax.annotate( $sin(x) = cos(x)$ ,
... xy=(xsol, ysol),
... xytext=(1.2, 0.8),
... arrowprops=dict(facecolor= black , shrink=0.05))
>>> ax.text(0.47, 0.72, f ({xsol:.2f}, {ysol:.2f}) )
>>> ax.plot([xsol, xsol], [0, ysol], color= gray , linestyle= -- )
>>> ax.plot([0, xsol], [ysol, ysol], color= gray , linestyle= -- )
452 Capítulo 8. Ciencia de datos

-- 456 of 516 --

Aprende Python
Ejercicio
Escriba el código Python necesario para obtener el siguiente gráfico:
8.4. matplotlib 453

-- 457 of 516 --

Aprende Python
Datos:
• 𝑥 ∈ [0, 2𝜋] (1000 puntos)
• 𝑦 = 𝑒−𝛼𝑥𝑠𝑖𝑛(𝛽𝑥), donde 𝛼 = 0.7 y 𝛽 = 10.
8.4.4 Tipos de gráficos
Mediante matplotlib podemos hacer prácticamente cualquier tipo de gráfico. En esta sección
haremos un repaso por algunos de ellos.
Gráficos de barras
Vamos a partir de un «dataset» que contiene los resultados de los Juegos Olímpicos de Tokio