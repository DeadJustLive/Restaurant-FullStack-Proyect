# INGENIERIA DE SISTEMAS

## Fuente
estructuras-de-datos (Cap. 133)

## Contenido
# INGENIERIA DE SISTEMAS

2.3.2 PROPIEDADES DE LOS ARBOLES BINARIOS
Se pueden presentar las siguientes propiedades de este tipo de árboles:
El número máximo de registros de un nivel k del árbol es 2k-1
Un árbol binario lleno: es un árbol de altura k que tiene 2k -1 registros, ósea cada registro
tiene sus dos hijos hasta el último nivel que solo hay hojas
Sea n0 = al número de hojas del árbol y n2 número de registros de grado 2. Siempre se
cumplirá que n0=n2+1, pero no el árbol vacío.
2.3.3 REPRESENTACIÓN DE LOS ARBOLES BINARIOS
Se pueden representar como un vector de forma estática o como una lista ligada de forma dinámica.
Veamos cada una de estas dos representaciones:
2.3.3.1 REPRESENTACIÓN DE ÁRBOLES BINARIOS CON UN VECTOR
El nivel 1 corresponde a una posición donde colocamos el dato de la raíz principal del árbol, a las dos
posiciones siguientes les corresponde los datos de los dos registros hijos del nivel 2, las cuatro
siguientes posiciones del vector serán para los dos pares de hijos del nivel 3, de tal manera que el
siguiente nivel tendrá 8 posiciones del vector para representar la cantidad posible de hijos del 4 nivel
del árbol y así sucesivamente como una potencia de 2. Gráficamente para el árbol del ejemplo inicial:
