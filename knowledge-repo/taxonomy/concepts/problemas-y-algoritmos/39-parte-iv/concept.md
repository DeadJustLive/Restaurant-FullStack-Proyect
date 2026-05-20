# Parte IV

## Fuente
problemas-y-algoritmos (Cap. 39)

## Contenido
# Parte IV

Estructuras de Datos
149

-- 149 of 315 --



-- 150 of 315 --

151
En lo que se reere a la resolución de problemas, muchas veces para
plantear el problema imaginamos objetos y acciones que se relacionan entre
si.
Cualquier lenguaje de programación tiene ya implementados tipos de
datos básicos como lo son enteros cortos, enteros largos, punto otante, car-
actéres, arreglos y matrices.
Sin embargo, a medida que nos adentramos más y más en la programación,
esos tipos de datos dejan de ser sucientes, podemos plantear problemas que
traten de cosas mas allá de los números y arreglos.
No debemos de desanimarnos y pensar que la computadora solo nos
servirá para problemas de números y arreglos, ya que con un poco de cre-
atividad podremos manejar una innidad de objetos distintos.
Si bien una computadora solamente cuenta con herramientas para mane-
jar números, caractéres y arreglos, es posible hacer una analogía represen-
tando ciertos objetos abstractos con arreglos y números e implementando
funciones que simulen las acciones de estos objetos.
Las representaciones de estos objetos abstractos constan de una serie de
datos y funciones para manipular esos datos, a estas dos cosas juntas se les
llama estructuras de datos. A continuación conoceremos las estructuras de
uso mas frecuente.

-- 151 of 315 --

152

-- 152 of 315 --

Cap´ıtulo 13
Pilas, Colas, Listas
Iniciaremos nuestro estudio de las estructuras de datos con estas tres
estructuras que son por mucho, las mas sencillas de todas: pilas, colas y
listas.
13.1. Pilas
Imaginemos este sencillo escenario: un mesero tiene platos de colores api-
lados; de vez en cuando el que lava los platos coloca un plato recién lavado
sobre la pila de platos; y en otras ocaciones el mesero toma el plato que esta
hasta arriba y sirve ahí la comida que ha sido preparada por el cocinero para
posteriormente llevarla a su destino.
Si sabemos de qué color es el primer plato de la pila, en qué momentos
el que lava los platos colocó platos sobre la pila(tambien sabemos el color de
los que se van añadiendo), y en qué momentos el mesero retiró cada plato
que se encontraba hasta arriba; podemos saber de qué color será el plato que
le toca a cada cliente.
Una manera de saberlo podría ser, hacer una representación dramatica
de los hechos; pero esto no es necesario, ya que tambien podríamos tomar
un lapiz y un papel, y escribir una lista de los colores de los platos, poste-
riormente, ir escribiendo los colores de los platos que se pusieron en la pila
al nal de la lista, y borrar el ultimo color de la lista cada que un plato se
retire.
No se necesita ser un gran matemático para pensar en hacer eso, sin
embargo, en el momento de querer implementar un programa en C que lo
reprodusca, nos encontramos con que no tenemos ninguna lista donde se
coloquen y se quiten cosas del nal, tenemos solamente arreglos, variables,
153

-- 153 of 315 --

154 CAPÍTULO 13. PILAS, COLAS, LISTAS
estructuras, apuntadores, etc.
Claro que podemos simular esta lista con las herramientas que nos pro-
porciona C++ o incluso C, asi pues, este es un ejemplo de objetos(como la
pila de platos) ligados a operaciones(como poner un nuevo plato o quitar un
plato) que modican al objeto, es decir, una estructura de datos.
Una pila, es la estructura de datos mencionada en este ejemplo, es decir,
un altero de objetos. O mas objetivamente:
Denición 13.1.1 (Pila). Estructura de datos que simula una lista en la
cual solo se pueden realizar 2 operaciones: colocar un elemento al nal, o
quitar un elemento del nal.
Lo unico que se puede hacer en una pila es colocar un objeto hasta arriba,
o quitar el objeto que esta arriba, en el ejemplo anterior si se quita un objeto
de abajo o del centro(lo mismo que si se intenta añadir uno), la pila colapsaría.
Si queremos programar algo similar, lo mas obvio es guardar la informa-
ción de la pila en un arreglo, además en este ejemplo usaremos números para
denotar los colores.
Imaginemos que el restaurant tiene en total 10 platos(un restaurant bas-
tante pobre), ello nos indicaría que un arreglo de tamaño 10 podría guardar
todos los platos sin temor a que el tamaño del arreglo no alcance.
Suponiendo que inicialmente hay 2 platos, uno de color 1, y otro de color
2, el arreglo debería lucir algo asi:
2 1 0 0 0 0 0 0 0 0
Si repentinamente el que lava los platos pone un plato hasta arriba de
color 2, luego de ello el arreglo debería de lucir asi:
2 1 2 0 0 0 0 0 0 0
Si luego pone hasta arriba un plato de color 3, entonces el arreglo debería
de quedar asi:
2 1 2 3 0 0 0 0 0 0
Pero si el mesero toma un plato de arriba, el arreglo estará de nuevo de
esta manera:
2 1 2 0 0 0 0 0 0 0
Si el mesero vuelve a tomar un plato de arriba, el arreglo quedará de esta
manera:

-- 154 of 315 --

13.1. PILAS 155
2 1 0 0 0 0 0 0 0 0
Para lograr esto, basta con declarar un arreglo y una variable de tal
manera que el arreglo diga especicamente qué platos hay en la pila, y la
variable cuántos platos hay.
Ento
