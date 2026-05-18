# 2020. Hemos descargado el fichero medals.xlsx desde una página de Kaggle4.

## Fuente
Aprende Python (Cap. 85)

## Contenido
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
el caso concreto
