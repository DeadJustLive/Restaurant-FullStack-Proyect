# 4. Compute los tiempos de ejecución de 2) y 3)

## Fuente
Aprende Python (Cap. 77)

## Contenido
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
Creación de series u
