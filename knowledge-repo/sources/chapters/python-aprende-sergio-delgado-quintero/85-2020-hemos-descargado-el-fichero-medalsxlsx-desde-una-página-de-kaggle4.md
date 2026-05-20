# 2020. Hemos descargado el fichero medals.xlsx desde una página de Kaggle4.

En primer lugar cargaremos este fichero en un DataFrame y haremos una pequeña
«limpieza»:
>>> df = pd.read_excel( pypi/datascience/files/medals.xlsx )
>>> df.head()
Rank Team/NOC Gold Silver Bronze Total Rank by Total
0 1 United States of America 39 41 33 113 1
(continué en la próxima página)
4 Kaggle es un servicio web que ofrece una gran variedad de «datasets», así como código, cursos y otros
recursos en relación con la ciencia de datos.
454 Capítulo 8. Ciencia de datos

-- 458 of 516 --

Aprende Python
(proviene de la página anterior)
1 2 People s Republic of China 38 32 18 88 2
2 3 Japan 27 14 17 58 5
3 4 Great Britain 22 21 22 65 4
4 5 ROC 20 28 23 71 3
>>> df.rename(columns={ Team/NOC : Country }, inplace=True)
>>> df.set_index( Country , inplace=True)
>>> df.head()
Rank Gold Silver Bronze Total Rank by Total
Country
United States of America 1 39 41 33 113 1
People s Republic of China 2 38 32 18 88 2
Japan 3 27 14 17 58 5
Great Britain 4 22 21 22 65 4
ROC 5 20 28 23 71 3
Importante: Para la carga de ficheros Excel, es necesario instalar un paquete adicional
denominado openpyxl.
A continuación crearemos un gráfico de barras con las medallas de oro, plata y
bronce de los 10 primeros países ordenados por su ranking. Lo primero será crear el
subconjunto de datos sobre el que vamos a trabajar. Hay muchas maneras de hacerlo. Una
de ellas:
>>> df_best = df.nsmallest(10, Rank )
>>> df_best
Rank Gold Silver Bronze Total Rank by Total
Country
United States of America 1 39 41 33 113 1
People s Republic of China 2 38 32 18 88 2
Japan 3 27 14 17 58 5
Great Britain 4 22 21 22 65 4
ROC 5 20 28 23 71 3
Australia 6 17 7 22 46 6
Netherlands 7 10 12 14 36 9
France 8 10 12 11 33 10
Germany 9 10 11 16 37 8
Italy 10 10 10 20 40 7
Ahora ya podemos centrarnos en el diseño del gráfico de barras:
8.4. matplotlib 455

-- 459 of 516 --

Aprende Python
>>> fig, ax = plt.subplots(figsize=(8, 5), dpi=100) # 800x500 px
>>> bar_width = 0.30
>>> x = np.arange(df_best.index.size)
>>> golden_medals = ax.bar(x - bar_width, df_best[ Gold ],
... bar_width, label= Oro , color= #ffd700 )
>>> silver_medals = ax.bar(x, df_best[ Silver ],
... bar_width, label= Plata , color= #aaa9ad )
>>> bronze_medals = ax.bar(x + bar_width, df_best[ Bronze ],
... bar_width, label= Bronce , color= #cd7f32 )
>>> ax.set_xticks(x)
>>> ax.set_xticklabels(df_best.index, rotation=90)
>>> ax.legend()
>>> # Etiquetas en barras
>>> ax.bar_label(golden_medals, padding=3)
>>> ax.bar_label(silver_medals, padding=3)
>>> ax.bar_label(bronze_medals, padding=3)
>>> ax.spines[ right ].set_visible(False) # ocultar borde derecho
>>> ax.spines[ top ].set_visible(False) # ocultar borde superior
>>> fig.tight_layout() # ajustar elementos al tamaño de la figura
>>> fig
456 Capítulo 8. Ciencia de datos

-- 460 of 516 --

Aprende Python
Ejercicio
Partiendo del fichero tiobe-2020-clean.csv que contiene las valoraciones de los lenguajes
de programación más usados durante el año 2020 (según el índice TIOBE)8, cree el siguiente
gráfico de barras:
8 Datos extraídos desde esta página de Kaggle.
8.4. matplotlib 457

-- 461 of 516 --

Aprende Python
Gráficos de dispersión
Para este gráfico vamos a usar un «dataset» de jugadores de la NBA5 extraído desde esta
página de Kaggle. El fichero nba-data.csv contiene información desde 1996 hasta 2019.
En primer lugar cargamos los datos y nos quedamos con un subconjunto de las columnas:
>>> df = pd.read_csv( pypi/datascience/files/nba-data.csv , usecols=[ pts , reb ,
˓→ ast ])
>>> df.head()
pts reb ast
0 4.8 4.5 0.5
1 0.3 0.8 0.0
2 4.5 1.6 0.9
3 7.8 4.4 1.4
4 3.7 1.6 0.5
>>> df.shape
(11700, 3)
5 National Basketball League (liga estadounidense de baloncesto).
458 Capítulo 8. Ciencia de datos

-- 462 of 516 --

Aprende Python
El objetivo es crear un gráfico de dispersión en el relacionaremos los puntos anotados
con los rebotes capturados, así como las asistencias dadas:
>>> fig, ax = plt.subplots(figsize=(8, 6), dpi=100) # 800x600 px
>>> # Crear variables auxiliares
>>> x = df[ pts ]
>>> y = df[ reb ]
>>> colors = df[ ast ]
>>> p = ax.scatter(x, y,
... s=30, # tamaño de los puntos
... c=colors, cmap= RdBu_r , # colores
... vmin=colors.min(), vmax=colors.max(), # normalización de colores
... alpha=0.7,
... edgecolors= none )
>>> # Barra de colores
>>> cb = fig.colorbar(p, ax=ax, label= Asistencias , extend= max )
>>> cb.outline.set_visible(False)
>>> ax.set_xlabel( Puntos )
>>> ax.set_ylabel( Rebotes )
>>> ax.spines[ right ].set_visible(False)
>>> ax.spines[ top ].set_visible(False)
>>> fig.tight_layout()
8.4. matplotlib 459

-- 463 of 516 --

Aprende Python
Del gráfico anterior cabe destacar varios aspectos:
• Normalización: Cuando aplicamos una estética de color al gráfico basada en los datos
de una variable, debemos normalizar dicha variable en el mapa de color («colormap»)
que elijamos. Para ello, matplotlib nos ofrece la normalización de mapas de color. En
el caso concreto de scatter() pasaríamos esta normalización mediante el parámetro
norm pero también podemos usar los parámetros vmin y vmax.
• Barra de color: Se trata de una leyenda particular en la que mostramos el gradiente
de color vinculado a una determinada estética/variable del gráfico. Matplotlib también
nos permite personalizar estas barras de color.
Ejercicio
Partiendo del fichero bmw-clean.csv que contiene información sobre vehículos de la marca
BMW9, cree el siguiente gráfico de dispersión:
9 Datos extraídos desde esta página de Kaggle.
460 Capítulo 8. Ciencia de datos

-- 464 of 516 --

Aprende Python
El mapa de color que se ha usado es plasma_r.
Histogramas
En esta ocasión vamos a trabajar con un «dataset» de «Avengers»6 extraído desde Kaggle.
Hemos descargado el fichero avengers.csv.
Como punto de partida vamos a cargar la información y a quedarnos únicamente con la
columna que hace referencia al año en el que se crearon los personajes:
>>> df = pd.read_csv( pypi/datascience/files/avengers.csv , usecols=[ Year ])
>>> df.head()
Year
0 1963
1 1963
2 1963
3 1963
4 1963
>>> df.shape
(173, 1)
6 Los Vengadores son un equipo de superhéroes publicados por Marvel Comics.
8.4. matplotlib 461

-- 465 of 516 --

Aprende Python
Igualmente haremos un pequeño filtrado para manejar sólo registros a partir de 1960:
>>> df = df[df[ Year ] >= 1960]
>>> df.shape
(159, 1)
Ahora ya podemos construir el histograma, que va a representar las frecuencias absolutas
de creación de personajes Marvel según su año de creación.
Aunque es posible indicar un número determinado de contenedores («bins»), en este caso
vamos a especificar directamente los intervalos (cada 5 años):
>>> df[ Year ].min(), df[ Year ].max()
(1963, 2015)
>>> bins = range(1960, 2021, 5)
Y a continuación el código necesario para montar el gráfico:
>>> fig, ax = plt.subplots(figsize=(8, 4), dpi=100) # 800x400 px
>>> ax.hist(df,
... bins=bins, # intervalos de agrupación
... rwidth=0.95, # ancho de cada barra
... zorder=2, # barras por encima de rejilla
... color= deeppink ,
... alpha=0.5)
>>> ax.spines[ right ].set_visible(False)
>>> ax.spines[ top ].set_visible(False)
>>> ax.set_xticks(bins) # etiquetas de intervalos en el eje x
>>> ax.yaxis.grid(color= lightgray , linestyle= -- ) # rejilla
>>> fig.tight_layout()
462 Capítulo 8. Ciencia de datos

-- 466 of 516 --

Aprende Python
Descargo de responsabilidad: Técnicamente este gráfico no es un histograma ya que los años
(fechas en general) no representan categorías válidas, pero sirve a efectos demostrativos de
cómo se construyen este tipo de diagramas.
Ejercicio
Partiendo del fichero pokemon.csv que contiene información sobre Pokemon10, cree el
siguiente histograma en el que se analiza el número de personajes «pokemons» en función
de su velocidad (columna Speed):
10 Datos extraídos desde esta página de Kaggle.
8.4. matplotlib 463

-- 467 of 516 --

Aprende Python
Gráficos para series temporales
Vamos a trabajar con un conjunto de datos extraído desde esta página de Kaggle que contiene
información histórica de temperaturas del planeta Tierra. El fichero global-temperatures.
csv se ha descargado para su tratamiento.
En primer lugar cargamos los datos, renombramos las columnas y eliminamos los valores
nulos:
>>> df = pd.read_csv( pypi/datascience/files/global-temperatures.csv ,
... parse_dates=[ dt ], # conversión a tipo datetime
... usecols=[ dt , LandAverageTemperature ])
>>> df.rename(columns={ dt : when , LandAverageTemperature : temp }, inplace=True)
>>> df.dropna(inplace=True)
>>> df.head()
when temp
0 1750-01-01 3.034
1 1750-02-01 3.083
2 1750-03-01 5.626
3 1750-04-01 8.490
4 1750-05-01 11.573
(continué en la próxima página)
464 Capítulo 8. Ciencia de datos

-- 468 of 516 --

Aprende Python
(proviene de la página anterior)
>>> df.shape
(3180, 2)
A continuación montamos un gráfico en el que se representan todas las mediciones
históricas de la temperatura media global del planeta y añadimos una línea de
tendencia:
>>> # Necesitamos algunas utilidades de gestión de fechas
>>> from matplotlib.dates import YearLocator, DateFormatter, date2num
>>> from matplotlib.ticker import MultipleLocator
>>> fig, ax = plt.subplots(figsize=(8, 4), dpi=100) # 800x400 px
>>> # Alias para simplificar el acceso
>>> x = df.when
>>> y = df.temp
>>> ax.plot(x, y,
... linestyle= None , marker= . , color= tomato , # estilo de línea
... zorder=2) # orden para colocar sobre rejilla
>>> # Construcción de la línea de tendencia
>>> x = date2num(x)
>>> z = np.polyfit(x, y, 2) # ajuste polinómico de grado 2
>>> p = np.poly1d(z)
>>> plt.plot(x, p(x), linewidth=4, alpha=0.8, color= royalblue )
>>> # Formateo de los ejes
>>> ax.xaxis.set_minor_locator(YearLocator(10))
>>> ax.xaxis.set_minor_formatter(DateFormatter( %Y ))
>>> ax.tick_params(axis= x , which= minor ,
... labelsize=8, labelcolor= lightgray , rotation=90)
>>> ax.xaxis.grid(which= minor , color= lightgray , linestyle= dashed )
>>> ax.yaxis.set_major_formatter( {x:.0f}º )
>>> ax.yaxis.set_minor_locator(MultipleLocator(1))
>>> ax.tick_params(axis= y , which= minor ,
... labelsize=8, labelcolor= lightgray )
>>> ax.yaxis.grid(which= minor , linestyle= dashed , color= lightgray )
>>> ax.yaxis.set_minor_formatter( {x:.0f} )
>>> ax.tick_params(axis= y , which= minor , labelsize=8, labelcolor= lightgray )
>>> ax.spines[ right ].set_visible(False)
>>> ax.spines[ top ].set_visible(False)
>>> fig.tight_layout()
8.4. matplotlib 465

-- 469 of 516 --

Aprende Python
Mapas de calor
Para este tipo de gráfico vamos a utilizar un «dataset» que recoge las 1000 películas más
valoradas en IMDB7. Está sacado desde esta página de Kaggle y se ha descargado el fichero
de datos en imdb-top-1000.csv.
En primer lugar vamos a cargar los datos quedándonos con las columnas Certificate
(clasificación de la película según edades), Genre (géneros de la película) e IMDB_Rating
(valoración de la película en IMDB):
>>> df = pd.read_csv( pypi/datascience/files/imdb-top-1000.csv ,
... usecols=[ Certificate , Genre , IMDB_Rating ])
>>> df.head()
Certificate Genre IMDB_Rating
0 A Drama 9.3
1 A Crime, Drama 9.2
2 UA Action, Crime, Drama 9.0
3 A Crime, Drama 9.0
4 U Crime, Drama 9.0
Ahora creamos una nueva columna en el DataFrame donde guardaremos únicamente el género
principal de cada película:
>>> df[ Main_Genre ] = df[ Genre ].str.split( , , expand=True)[0]
(continué en la próxima página)
7 IMDB es una reconocida página web que contiene valoraciones sobre películas y series.
466 Capítulo 8. Ciencia de datos

-- 470 of 516 --

Aprende Python
(proviene de la página anterior)
>>> df.head()
Certificate Genre IMDB_Rating Main_Genre
0 A Drama 9.3 Drama
1 A Crime, Drama 9.2 Crime
2 UA Action, Crime, Drama 9.0 Action
3 A Crime, Drama 9.0 Crime
4 U Crime, Drama 9.0 Crime
A continuación agrupamos y obtenemos los valores medios de las valoraciones:
>>> # unstack permite disponer la agrupación en forma tabular (para el heatmap)
>>> ratings = df.groupby([ Certificate , Main_Genre ])[ IMDB_Rating ].mean().
˓→unstack()
>>> # Nos quedamos con un subconjunto de certificados y géneros
>>> review_certificates = [ U , UA , PG-13 , R , A ]
>>> review_genres = [ Animation , Action , Adventure , Biography ,
... Comedy , Crime , Drama ]
>>> ratings = ratings.loc[review_certificates, review_genres]
>>> # Recodificamos los certificados (clasificación) con códigos más entendibles
>>> certs_description = { U : ALL , UA : >12 , PG-13 : >13 , R : >17 , A : >
˓→18 }
>>> ratings.index = ratings.reset_index()[ Certificate ].replace(certs_description)
>>> ratings
Main_Genre Animation Action Adventure Biography Comedy Crime Drama
Certificate
ALL 7.947368 8.165000 7.953571 7.862500 7.940541 8.200000 7.976364
>12 7.883333 7.992424 7.958333 7.971429 7.885714 7.900000 7.953659
>13 7.866667 7.783333 7.600000 7.862500 7.785714 8.000000 7.775000
>17 7.800000 7.812500 7.900000 7.900000 7.824138 7.814286 7.915094
>18 7.866667 7.873171 7.912500 8.017647 7.877778 8.130233 8.036364
Ahora ya podemos construir el mapa de calor usando el DataFrame ratings generado
previamente:
>>> fig, ax = plt.subplots(figsize=(8, 4), dpi=100)
>>> text_colors = ( black , white )
>>> im = ax.imshow(ratings, cmap= Reds ) # mapa de calor
>>> cbar = fig.colorbar(im, ax=ax, label= IMDB Rating ) # leyenda
>>> cbar.outline.set_visible(False)
>>> x = ratings.columns
(continué en la próxima página)
8.4. matplotlib 467

-- 471 of 516 --

Aprende Python
(proviene de la página anterior)
>>> y = ratings.index
>>> # Mostrar las etiquetas. El color del texto cambia en función de su normalización
>>> for i in range(len(y)):
... for j in range(len(x)):
... value = ratings.iloc[i, j]
... text_color = text_colors[int(im.norm(value) > 0.5)] # color etiqueta
... ax.text(j, i, f {value:.2f} , color=text_color, va= center , ha= center )
>>> # Formateo de los ejes
>>> ax.set_xticks(range(len(x)))
>>> ax.set_xticklabels(x, rotation=90)
>>> ax.set_yticks(range(len(y)))
>>> ax.set_yticklabels(y)
>>> ax.invert_yaxis()
>>> ax.spines[:].set_visible(False)
>>> fig.tight_layout()
Ejercicio
Partiendo del fichero euro-dollar-clean.csv que contiene información sobre el cambio
468 Capítulo 8. Ciencia de datos

-- 472 of 516 --

Aprende Python
euro-dollar durante los últimos 12 años11, cree el siguiente mapa de calor en el que se analiza
la evolución del cambio enfrentando meses y años:
Diagramas de caja
Un diagrama de caja permite visualizar la distribución de los valores de manera rápida y
muy visual:
Figura 22: Anatomía de un diagrama de caja14
11 Datos extraídos desde esta página de Kaggle.
14 Inspirado en este artículo de Towards Data Science.
8.4. matplotlib 469

-- 473 of 516 --

Aprende Python
Para mostrar el funcionamiento de los diagramas de caja en Matplotlib vamos a hacer uso
de distintas distribuciones aleatorias que crearemos mediante funciones de Numpy:
>>> DIST_SIZE = 100 # tamaño de la muestra
>>> boxplots = []
>>> boxplots.append(dict(
... dist=np.random.normal(0, 1, size=DIST_SIZE),
... label= Normal\n$\mu=0, \sigma=1$ ,
... fill_color= pink ,
... brush_color= deeppink ))
>>> boxplots.append(dict(
... dist=np.random.geometric(0.4, size=DIST_SIZE),
... label= Geometric\n$p=0.4$ ,
... fill_color= lightblue ,
... brush_color= navy ))
>>> boxplots.append(dict(
... dist=np.random.chisquare(2, size=DIST_SIZE),
... label= Chi-squared\n$df=2$ ,
... fill_color= lightgreen ,
... brush_color= darkgreen ))
Ahora ya podemos construir el gráfico de cajas que nos permite visualizar la distribución de
las muestras:
>>> fig, ax = plt.subplots(figsize=(8, 6), dpi=100) # 800x600 px
>>> for i, boxplot in enumerate(boxplots):
... fcolor, bcolor = boxplot[ fill_color ], boxplot[ brush_color ]
... ax.boxplot(boxplot[ dist ],
... labels=[boxplot[ label ]],
... positions=[i],
... widths=[.3],
... notch=True,
... patch_artist=True,
... boxprops=dict(edgecolor=bcolor,
... facecolor=fcolor,
... linewidth=2),
... capprops=dict(color=bcolor, linewidth=2),
... flierprops=dict(color=bcolor,
... markerfacecolor=fcolor,
... linestyle= none ,
... markeredgecolor= none ,
... markersize=9),
(continué en la próxima página)
470 Capítulo 8. Ciencia de datos

-- 474 of 516 --

Aprende Python
(proviene de la página anterior)
... medianprops=dict(color=bcolor),
... whiskerprops=dict(color=bcolor,
... linewidth=1))
>>> ax.yaxis.grid(color= lightgray )
>>> ax.xaxis.set_ticks_position( none )
>>> ax.yaxis.set_ticks_position( none )
>>> ax.spines[:].set_visible(False)
>>> fig.tight_layout()
Consejo: El código para preparar el gráfico se ha complicado porque se ha incidido en
mejorar la estética. En cualquier caso, una vez hecho, se puede refactorizar en una función
y reutilizarlo para futuros trabajos.
8.4. matplotlib 471

-- 475 of 516 --

Aprende Python
Gráficos de evolución
Partiendo de un conjunto de datos temporales, vamos a aprovechar para elaborar un
gráfico de evolución del precio de criptomonedas. En esta ocasión hemos utilizado el
«dataset» eth-usd.csv descargado desde esta página de Kaggle. Contiene la valoración
de la criptomoneda Ethereum en función de una marca temporal, así como el volumen de
«moneda» existente en cada momento.
El objetivo será crear un gráfico que represente el valor de la criptomoneda (a lo
largo del tiempo) en contraposición al volumen de unidades.
Lo primero que haremos, además de cargar los datos, será lo siguiente:
• Seleccionar las columnas Date (fecha de referencia), Open (precio de la moneda a la
apertura) y Volume (volumen de moneda).
• Parsear el campo fecha.
• Filtrar sólo aquellos registros a partir del 1 de enero de 2017 (por simplicidad).
• Dividir la columna de volumen por 10M de cara a equiparar cantidades con la
valoración (ajuste de gráfico).
• Aplicar una media móvil para suavizar las curvas a representar.
>>> import datetime
>>> df = pd.read_csv( pypi/datascience/files/eth-usd.csv ,
... parse_dates=[ Date ],
... usecols=[ Date , Open , Volume ],
... index_col= Date )
>>> min_date = datetime.datetime(year=2017, month=1, day=1)
>>> df = df.loc[df.index > min_date]
>>> df[ Volume ] /= 1e7
>>> df_smooth = df.rolling(20).mean().dropna()
>>> df_smooth.head()
Open Volume
Date
2017-01-21 9.968611 2.146882
2017-01-22 10.105573 2.117377
2017-01-23 10.222339 1.985587
2017-01-24 10.273270 1.821968
2017-01-25 10.239854 1.647938
Ahora ya podemos montar el gráfico dedicando algo de esfuerzo a la parte estética:
472 Capítulo 8. Ciencia de datos

-- 476 of 516 --

Aprende Python
>>> fig, ax = plt.subplots(figsize=(8, 4), dpi=100) # 800x400px
>>> # Alias para facilitar el acceso
>>> x = df_smooth.index
>>> y_open = df_smooth[ Open ]
>>> y_vol = df_smooth[ Volume ]
>>> # Líneas de evolución
>>> ax.plot(x, y_open, label= Value ($) , color= skyblue , linewidth=1.5)
>>> ax.plot(x, -y_vol, label= Volume (10M ud.) , color= pink , linewidth=1.5)
>>> # Relleno del área
>>> plt.fill_between(x, y_open, alpha=0.5, color= skyblue , zorder=3)
>>> plt.fill_between(x, -y_vol, alpha=0.5, color= pink , zorder=3)
>>> # Formateo de los ejes
>>> ax.xaxis.set_ticks_position( none )
>>> ax.yaxis.set_ticks_position( none )
>>> y_ticks = [-4000, -2000, 0, 2000, 4000]
>>> y_tick_labels = [ 4000 , 2000 , 0 , 2000 , 4000 ]
>>> ax.set_yticks(y_ticks)
>>> ax.set_yticklabels(y_tick_labels)
>>> ax.set_ylim(-6000, 6000)
>>> # Rejilla
>>> ax.xaxis.grid(color= lightgray , linewidth=.5)
>>> for y_tick in y_ticks:
... if y_tick != 0:
... ax.axhline(y_tick, color= lightgray , linewidth=.5)
>>> ax.legend()
>>> ax.spines[:].set_visible(False)
>>> fig.tight_layout()
8.4. matplotlib 473

-- 477 of 516 --

Aprende Python
Ejercicio
Partiendo del fichero mwh-spain-2021-clean.csv que contiene información sobre el precio
de la energía en España durante el año 202112, cree el siguiente diagrama de evolución que
representa la variación del precio del MWh13 en función del tiempo:
Las marcas (en el eje x) tienen una separación de 10 días.
12 Datos extraídos desde esta página de El País.
13 Mega Watio Hora (medida de consumo de energía)
474 Capítulo 8. Ciencia de datos

-- 478 of 516 --