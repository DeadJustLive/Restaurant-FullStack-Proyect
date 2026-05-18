# 84893.0 Cuantiles (por defecto 50%)

df[ Revenue ].
cumsum()
Múltiples
valores
Suma acumulativa
df[ Revenue ].
cumprod()
Múltiples
valores
Producto acumulativo
df[ Revenue ].
cummax()
Múltiples
valores
Máximo acumulativo
df[ Revenue ].
cummin()
Múltiples
valores
Mínimo acumulativo
Ejercicio
Partiendo del conjunto de datos democan, obtenga aquellas islas cuya población está por
encima de la media del archipiélago canario.
Resultado esperado: [ Gran Canaria , Tenerife ]
Ordenando valores
Una operación muy típica cuando trabajamos con datos es la de ordenarlos en base a ciertos
criterios. Veamos cómo podemos hacerlo utilizando pandas. Volvemos a nuestro «dataset»
tecnológico:
>>> df
Revenue Employees City Country
(continué en la próxima página)
418 Capítulo 8. Ciencia de datos

-- 422 of 516 --

Aprende Python
(proviene de la página anterior)
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
Supongamos que queremos tener el conjunto de datos ordenado por el nombre de
empresa. Como, en este caso, la columna Company constituye el índice, debemos ordenar
por el índice:
>>> df.sort_index()
Revenue Employees City Country
Company
Alphabet 182527 135301 California United States
Apple 274515 147000 California United States
Dell Technologies 92224 158000 Texas United States
Facebook 85965 58604 California United States
Foxconn 181945 878429 New Taipei City Taiwan
HP Inc. 56639 53000 California United States
Hitachi 82345 350864 Tokyo Japan
Huawei 129184 197000 Shenzhen China
IBM 73620 364800 New York United States
Intel 77867 110600 California United States
LG Electronics 53625 75000 Seoul South Korea
Lenovo 60742 71500 Hong Kong China
Microsoft 143015 163000 Washington United States
Panasonic 63191 243540 Osaka Japan
Samsung Electronics 200734 267937 Suwon South Korea
Sony 84893 109700 Tokyo Japan
Tencent 69864 85858 Shenzhen China
Ahora imaginemos que necesitamos tener las empresas ordenadas de mayor a menor
número de ingresos:
8.3. pandas 419

-- 423 of 516 --

Aprende Python
>>> df.sort_values(by= Revenue , ascending=False)
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
También es posible utilizar varias columnas en la ordenación. Pongamos que deseamos
ordenar los datos por país y por ciudad. Veamos cómo afrontarlo:
>>> df.sort_values(by=[ Country , City ])
Revenue Employees City Country
Company
Lenovo 60742 71500 Hong Kong China
Huawei 129184 197000 Shenzhen China
Tencent 69864 85858 Shenzhen China
Panasonic 63191 243540 Osaka Japan
Sony 84893 109700 Tokyo Japan
Hitachi 82345 350864 Tokyo Japan
LG Electronics 53625 75000 Seoul South Korea
Samsung Electronics 200734 267937 Suwon South Korea
Foxconn 181945 878429 New Taipei City Taiwan
Apple 274515 147000 California United States
Alphabet 182527 135301 California United States
Facebook 85965 58604 California United States
Intel 77867 110600 California United States
HP Inc. 56639 53000 California United States
IBM 73620 364800 New York United States
Dell Technologies 92224 158000 Texas United States
Microsoft 143015 163000 Washington United States
420 Capítulo 8. Ciencia de datos

-- 424 of 516 --

Aprende Python
Buscando máximos y mínimos
Al igual que veíamos en el caso de las series, podemos aplicar muchas de estas funciones de
máximos y mínimos sobre un DataFrame de Pandas.
Podemos obtener los valores mínimos y máximos de todas las columnas:
>>> df.min()
Revenue 53625
Employees 53000
City California
Country China
dtype: object
>>> df.max()
Revenue 274515
Employees 878429
City Washington
Country United States
dtype: object
También podría ser de utilidad saber qué empresa tiene el valor mínimo o máximo
para una determinada columna: