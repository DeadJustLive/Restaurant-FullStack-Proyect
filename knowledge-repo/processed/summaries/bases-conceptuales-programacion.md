# bases-conceptuales-programacion

- **ID**: bases-conceptuales-programacion
- **Método**: native
- **Páginas**: 312
- **Capítulos**: 525
- **Generado**: 2026-05-17T09:15:22.500Z

## Resumen

# 1. La disciplina de la programaci ´on 23

1.1. ¿Qu ´e es la programaci ´on? . . . . . . . . . . . . . . . . . . . . . . 23
1.2. ¿Qu ´e son los lenguajes de programaci ´on? . . . . . . . . . . . . .

Secciones:
  # 1. La disciplina de la programaci ´on 23

Conclusión: Lenguajes para dominios espec´ıficos .

## Capítulos

### Cap. 1 — 1. La disciplina de la programaci ´on 23

# 1. La disciplina de la programaci ´on 23

1.1. ¿Qu ´e es la programaci ´on? . . . . . . . . . . . . . . . . . . . . . . 23
1.2. ¿Qu ´e son los lenguajes de programaci ´on? . . . . . . . . . . . . .

Secciones:
  # 1. La disciplina de la programaci ´on 23

Conclusión: Lenguajes para dominios espec´ıficos .

### Cap. 2 — 2. Primeros elementos de programaci ´on 39

# 2. Primeros elementos de programaci ´on 39

2.1. Introducci ´on a elementos b ´asicos . . . . . . . . . . . . . . . . . . . 39
2.1.1. Valores y expresiones . . . . . . . . . . . . . . . . . . . . .

Secciones:
  # 2. Primeros elementos de programaci ´on 39

Conclusión: Ejercitaci ´on .

### Cap. 3 — 3. Procedimientos, funciones y parametrizaci ´on 89

# 3. Procedimientos, funciones y parametrizaci ´on 89

3.1. Procedimientos . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 89
3.1.1. Procedimientos con par ´ametros . . . . . . . . . . . . .

Secciones:
  # 3. Procedimientos, funciones y parametrizaci ´on 89

Conclusión: Ejercitaci ´on .

### Cap. 4 — 4. Alternativa, repetici ´on y memoria 131

# 4. Alternativa, repetici ´on y memoria 131

4.1. M ´as sobre alternativas . . . . . . . . . . . . . . . . . . . . . . . . . 131
4.1.1. M ´as sobre alternativa condicional . . . . . . . . . . . . . .

Secciones:
  # 4. Alternativa, repetici ´on y memoria 131

Conclusión: Ejercitaci ´on .

### Cap. 5 — 5. Un ejemplo completo: ZILFOST 179

A.

Secciones:
  # 5. Un ejemplo completo: ZILFOST 179

Conclusión: En primer lugar brindamos una categorizaci ´on de los con-
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 18 of 312 --

19
ceptos, para ofrecer un marco donde entender mejor la secuencia did ´actica, y
luego presentamos la secuencia did ´actica propiamente dicha.

### Cap. 6 — 1) Elementos del lenguaje

# 1) Elementos del lenguaje

a) Universo de discurso (tablero, bolitas, cabezal)
b) Programas
c) Comandos
Comandos primitivos (Poner, Mover, Sacar, etc.)
Secuencia de comandos
Bloques
Invocaci ´on de

Secciones:
  # 1) Elementos del lenguaje

Conclusión: Elementos del lenguaje

a) Universo de discurso (tablero, bolitas, cabezal)
b) Programas
c) Comandos
Comandos primitivos (Poner, Mover, Sacar, etc.

### Cap. 7 — 2) Elementos de abstracci ´on

# 2) Elementos de abstracci ´on

a) Elementos de “contrato”
Prop ´osito de una operaci ´on
Precondiciones de una operaci ´on
Requisitos a los par ´ametros
b) Divisi ´on en subtareas
c) Tipos de datos
d) Esquemas de recorrido

### Cap. 8 — 3) Elementos de estilo

# 3) Elementos de estilo

a) Indentaci ´on
b) Comentarios
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 19 of 312 --

20
c) Elecci ´on de nombres

### Cap. 9 — 4) Otros conceptos

Cap.

Secciones:
  # 4) Otros conceptos

Conclusión: La secuencia did ´actica espec´ıfica es la siguiente
Cap.

### Cap. 10 — 1. Universo de discurso (tablero, bolitas, cabezal)

# 1. Universo de discurso (tablero, bolitas, cabezal)

### Cap. 100 — PRECONDICIONES:

Esta caracter´ıstica de GOBSTONES es ´unica. Secciones: # PRECONDICI´ON: Conclusión: Por ejemplo, imaginemos una situaci ´on donde queremos agregar en la celda ac- tual un n ´umero de aliados igual a la cantidad de enemigos en la celda al Norte, m ´as uno (por ejemplo, como parte de un programa que expresa nuestra estrate- gia de defensa en un juego), suponiendo la misma codificaci ´on que vimos antes (un enemigo se representa con una bolita roja y un aliado con...

### Cap. 101 — OBSERVACIONES:

# PROP´OSITO:

* agregar tantos aliados en la celda actual como
enemigos hay en la celda lindante al Norte,
m´as uno (si hay enemigos)

### Cap. 102 — PROP´OSITO:

Ejercicio 3.3.3.

Secciones:
  # PRECONDICI´ON:

Conclusión: Por ejemplo, la siguiente funci ´on verifica si hay enemigos en alguna de las 3
celdas lindantes al Norte (supone el uso de una funci ´on hayEnemigosAlEnRango,
similar a la funci ´on hayEnemigosAl vista, pero agregando un par ´ametro num ´erico
para indicar el rango exacto donde deben buscarse enemigos).

### Cap. 103 — PRECONDICIONES:

# PROP´OSITO:

* retorna verdadero si hay alg´un enemigo en las
pr´oximas 3 celdas al Norte de la actual

### Cap. 104 — OBSERVACIONES:

Observar que se utilizan bolitas azules para indicar el ´exito de la b ´usqueda.

Secciones:
  # PRECONDICI´ON:

Conclusión: Pues-
to que el procesamiento realizado por la funci ´on es solo simulado y no real, esta
modificaci ´on de las bolitas azules no ser ´a reflejada en el procedimiento que uti-
lice a hayEnemigosCercaAlNorte.

### Cap. 105 — PROP´OSITO:

# PROP´OSITO:

* retorna verdadero si hay alg´un enemigo en las
pr´oximas 3 celdas al Norte de la actual

### Cap. 106 — PRECONDICIONES:

Realice los ejercicios 3.3.5 y 3.3.6 y pru ´ebelos en alg ´un programa.

Secciones:
  # PRECONDICI´ON:

Conclusión: Por ejemplo, si consideramos la operaci ´on MoverN(n,dir) del ejercicio 3.

### Cap. 107 — PROP´OSITO:

Ejercicio 4.1.1.

Secciones:
  # parte 2: , vemos que la misma tiene como precondici ´on que haya tantas celdas en

Conclusión: Leer con Atenci ´on
Es importante observar que si bien el ejemplo ilustra la posibilidad de
anidar comandos condicionales, quedar´ıa de manera m ´as claro utilizan-
do procedimientos.

### Cap. 108 — PRECONDICIONES:

# {- PROP´OSITO:

* avanza 1 celda al Este y al llegar, decide si arma
una trinchera (si no hay enemigos) o ataca al enemigo.

### Cap. 109 — 10. Mensajes de error

# PRECONDICI´ON:

* hay una celda al Este
-}
{
Mover(Este)
if (not hayEnemigosAca())
{ ArmarTrinchera() }
else
{ Atacar() }
}
procedure HuirOEsconderse()

### Cap. 11 — PRECONDICI´ON:

# 2. Programas

### Cap. 110 — OBSERVACIONES:

# {- PROP´OSITO:

* decide si huir hacia el Norte o esconderse, en base
a las condiciones del camino

### Cap. 111 — PRECONDICIONES:

Ejercicio 4.1.2.

Secciones:
  # PRECONDICI´ON:

Conclusión: Para ejemplificar esta situaci ´on, consideremos la necesidad de codificar una
direcci ´on en la celda actual, utilizando bolitas verdes.

### Cap. 112 — PROP´OSITO:

PYTHON por ejemplo.

Secciones:
  # SUPOSICION:

Conclusión: Para este ejemplo vamos a suponer que el enemi-
go se encuentra en solo una de las celdas contiguas a la actual (o sea, no se
ha dispersado.

### Cap. 113 — PRECONDICIONES:

# PROP´OSITO:

* Dejar en la celda actual una codificaci´on de la
posici´on en la que est´a el enemigo

### Cap. 114 — OBSERVACIONES:

G.4.1.

Secciones:
  # PRECONDICI´ON:

Conclusión: El ejemplo m ´as sencillo
de uso de repetici ´on condicional es llevar el cabezal hasta un borde del tablero,
como se propuso pensar en la actividad del inicio de esta secci ´on.

### Cap. 115 — PROP´OSITO:

# {- PROP´OSITO:

* ilustrar el uso de while
* llevar el cabezal a la ´ultima fila de la columna actual

### Cap. 116 — PRECONDICIONES:

Realice el ejercicio 4.2.4, y pru ´ebelo con distintas direcciones.

Secciones:
  # PRECONDICI´ON:

Conclusión: En este caso, el programa provocar ´a que la m ´aquina quede infinitamen-
te intentando realizar una tarea, lo cual no puede ser comprobado de
ninguna forma externa durante la ejecuci ´on.

### Cap. 117 — OBSERVACIONES:

# {- PROP´OSITO:

* ilustrar una repetici´on cuya ejecuci´on no termina

### Cap. 118 — PRECONDICIONES:

# PRECONDICI´ON:

* Falsa: el programa jam´as termina, por lo que nunca
produce ning´un resultado
-}
{
QueresQueTeCuenteElCuentoDeLaBuenaPipa()
while (True)
{
YoNoDije_True_Dije_QueresQueTeCuenteElCue

Secciones:
  # PRECONDICI´ON:

Conclusión: A
pesar de tener esta manifestaci ´on diferente, la precondici ´on de un procedimiento
debe incluir las condiciones para asegurar que todas las repeticiones condicio-
nales terminan.

### Cap. 119 — OBSERVACIONES:

# {- PROP´OSITO:

* ilustrar el uso de precondiciones para
evitar no terminaci´on
* moverse simultaneamente en dos direcciones,
hasta alcanzar una esquina del tablero

### Cap. 12 — PROP´OSITO:

# 3. Comandos

### Cap. 120 — 11. M ´as comandos primitivos (Mover, Sacar, etc.)

# PRECONDICI´ON:

* d1 y d2 no pueden ser direcciones opuestas
-}
{
while (puedeMover(d1) && puedeMover(d2))
{ Mover(d1); Mover(d2) }
}
Observar que la condici ´on establece que el valor de los par ´a

Secciones:
  # PRECONDICI´ON:

Conclusión: El c ´odigo se ofrece a
continuaci ´on, pero es m ´as interesante si lo intenta solo primero y luego
contrasta su soluci ´on con la nuestra!

### Cap. 121 — PRECONDICIONES:

# {- PROP´OSITO:

* pinta una columna entera con bolitas de color

### Cap. 122 — OBSERVACIONES:

# PRECONDICI´ON:

* ninguna, es una operaci´on total

### Cap. 123 — PROP´OSITO:

Realice el ejercicio 4.2.5.

Secciones:
  # OBSERVACI´ON:

Conclusión: Por ejemplo, si en lugar de pintar una
columna de un color determinado, quisi ´eramos pintar todo el tablero, podr´ıamos
hacer un recorrido sobre todas las columnas, pintando cada una de ellas.

### Cap. 124 — PRECONDICIONES:

# {- PROP´OSITO:

* pinta todo el tablero con bolitas de color

### Cap. 125 — OBSERVACIONES:

# PRECONDICI´ON:

* ninguna, es una operaci´on total

### Cap. 126 — PROP´OSITO:

Realice el ejercicio 4.2.6.

Secciones:
  # OBSERVACI´ON:

Conclusión: Por eso, no debe asustarse si intenta mirarlos y no los
comprende; la programaci ´on abarca un mundo fascinante y vasto de ideas, que
no es f ´acil de dominar en poco tiempo.

### Cap. 127 — PRECONDICIONES:

# {- PROP´OSITO:

* recorre una secuencia de elementos gen´ericos, seg´un
las definiciones que se den a las partes

### Cap. 128 — OBSERVACIONES:

Definici ´on 4.2.2.

Secciones:
  # PRECONDICI´ON:

Conclusión: Supongamos que elegimos
que la primera celda ser ´a la de la esquina suroeste, y que las celdas ser ´an re-
corridas de Oeste a Este y de Sur a Norte, en ese orden.

### Cap. 129 — PRECONDICIONES:

# {- PROP´OSITO:

Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 149 of 312 --

150
* pinta todo el tablero con bolitas de color

### Cap. 13 — PRECONDICI´ON:

# 4. Comandos primitivos (Poner)

### Cap. 130 — OBSERVACIONES:

# PRECONDICI´ON:

* ninguna, es una operaci´on total

### Cap. 131 — 12. Procedimientos simples

Norte y volver al extremo Oeste para continuar con las celdas de arriba.

Secciones:
  # OBSERVACI´ON:

Conclusión: Para realizarlo debe considerarse primero si se puede mover al Este, y en
ese caso, moverse; pero si no puede moverse al Este, entonces debe moverse al
Norte y volver al extremo Oeste para continuar con las celdas de arriba.

### Cap. 132 — PROP´OSITO:

# {- PROP´OSITO:

* pasa a la siguiente celda en un recorrido por celdas
de todo el tablero

### Cap. 133 — PRECONDICIONES:

Norte.

Secciones:
  # PRECONDICI´ON:

Conclusión: Si pensamos en variaciones de los recorridos gen ´ericos, vemos que el recorrido no tiene
por qu ´e procesar todos los elementos.

### Cap. 134 — OBSERVACIONES:

# {- PROP´OSITO:

* Poner fertilizante en las celdas de la
columna que contengan flores

### Cap. 135 — PRECONDICIONES:

G.4.3.

Secciones:
  # PRECONDICI´ON:

Conclusión: Entonces, la operaci ´on interesante esMoverASiguienteSector, que es una b ´usqueda por
las 4 celdas contiguas de aquella que tenga bolitas negras pero no tenga flores y luego
moverse all´ı.

### Cap. 136 — OBSERVACIONES:

# PRECONDICI´ON:

* La celda actual no tiene bolitas verdes
* La celda actual es parte de un camino simple
* Una de los dos sectores contiguos ya fue visitado
y tiene una flor
-}
{
-- Elegir la direcc

Secciones:
  # PRECONDICI´ON:

Conclusión: Tambi ´en hay que observar que el procedimiento DecodificarDireccion debe
eliminar las bolitas verdes despu ´es de “leerlas”, as´ı no quedan en el tablero.

### Cap. 137 — PRECONDICIONES:

# {- PROP´OSITO:

* Poner flores en todas las celdas de un sendero simple

### Cap. 138 — OBSERVACIONES:

Ejercicio 4.2.10.

Secciones:
  # PRECONDICI´ON:

Conclusión: Es interesante pensar
en un recorrido sobre todas las celdas que se detenga al encontrar la celda buscada.

### Cap. 139 — PRECONDICIONES:

Este es un recorrido de b ´usqueda, y podemos observar varias cosas en ´el.

Secciones:
  # PRECONDICI´ON:

Conclusión: Es importante volver a remarcar que el valor que la variable nombra ser ´a el mismo
aun si el valor de la expresi ´on cambia a posteriori de la asignaci ´on (a menos que se reali-
ce una nueva asignaci ´on).

### Cap. 14 — PROP´OSITO:

# 5. Expresiones

### Cap. 140 — OBSERVACIONES:

# {- PROP´OSITO:

* ilustra el uso de variables y el hecho de que la
correspondencia no cambia aunque la expresi´on usada
para definirla s´ı lo haga

### Cap. 141 — PROP´OSITO:

# PRECONDICI´ON:

* debe haber una celda al Norte

### Cap. 142 — 13. Invocaci ´on de procedimientos simples

Las variables son ´utiles para recordar ciertos valores al moverse por el tablero.

Secciones:
  # SUPOSICI´ON:

Conclusión: Por ejemplo, supongamos que
las bolitas en una celda cuentan votos, y que queremos indicar en la celda de la esquina
suroeste el ganador de la votaci ´on con una bolita del color correspondiente (suponemos
adem ´as que en caso de empate, gana el color m ´as chico, o sea, el que est ´e m ´as cer-
ca del inicio del alfabeto).

### Cap. 143 — PRECONDICIONES:

# {- PROP´OSITO: * colocar en la celda de la esquina suroeste, una bolita del color de las que haya m´as en la celda actual -} { colorAPoner := colorConMasCantidad() IrALaEsquinaS() Poner(colorAPoner Secciones: # {- PROP´OSITO: Conclusión: Por ejemplo, supongamos que queremos enviar al cabezal a que encienda una luz roja en la celda de la esquina suroeste (representando la luz con una bolita de ese color) si el cultivo en la celda actual (representado tambi ´en con distintas bolitas)...

### Cap. 144 — OBSERVACIONES:

Sin embargo, el c ´odigo del ejemplo contiene un error potencial.

Secciones:
  # PRECONDICI´ON:

Conclusión: Por ejemplo, el siguiente c ´odigo es err ´oneo porque cada procedimiento
tiene su propio espacio de variables, y por lo tanto no comparten las variables.

### Cap. 145 — PROP´OSITO:

# {- PROP´OSITO:

* ilustrar el uso INCORRECTO de variables

### Cap. 146 — PRECONDICIONES:

# PRECONDICI´ON:

* falla siempre, por invocar un procedimiento que
no puede tener ´exito

### Cap. 147 — OBSERVACIONES:

# OBSERVACI´ON:

* pretende mostrar lo que NO DEBE hacerse
-}
{
cantRojas := nroBolitas(Rojo)
Mover(Norte)
CompletarDuplicarRojasAlNorteMal()
}
procedimiento CompletarDuplicarRojasAlNorteMal()

### Cap. 148 — PRECONDICIONES:

# {- PROP´OSITO:

* ilustrar el uso INCORRECTO de variables
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 161 of 312 --

162

### Cap. 149 — PRECONDICIONES:

# PRECONDICI´ON:

* falla siempre, pues cant no es una variable definida,
ni un par´ametro

### Cap. 15 — PRECONDICI´ON:

# 6. Expresiones literales

### Cap. 150 — OBSERVACIONES:

# OBSERVACI´ON:

* pretende mostrar lo que NO DEBE hacerse
-}
{
PonerN(cantRojas,Rojo)
-- cantRojas ES UNA VARIABLE SIN ASIGNAR!
-- (La asignaci´on de cantRojas en el otro
-- procedimiento no tiene va

Secciones:
  # OBSERVACI´ON:

Conclusión: Por ello, el uso de cantRojas en el procedimiento CompletarDuplicarRojasAlNorteMal
es incorrecto, puesto que no fue asignada ninguna variable con ese nombre.

### Cap. 151 — PRECONDICIONES:

# {- PROP´OSITO:

* ilustrar el uso correcto de variables y par´ametros

### Cap. 152 — PRECONDICIONES:

# PRECONDICI´ON:

* debe haber una celda al norte
-}
{
cantRojas := nroBolitas(Rojo)
Mover(Norte)
CompletarDuplicarRojasAlNorteBien(cantRojas)
}
procedimiento CompletarDuplicarRojasAlNorteBien(cantAPoner)

### Cap. 153 — 14. Divisi ´on en subtareas

# {- PROP´OSITO:

* ilustrar el uso correcto de variables y par´ametros

### Cap. 154 — PRECONDICIONES:

CompletarDuplicarRojasAlNorteBien, y este lo utiliza mediante el par ´ametro cantAPoner.

Secciones:
  # PRECONDICI´ON:

Conclusión: Si esto
sucediese, se producir ´a un error de sintaxis.

### Cap. 155 — OBSERVACIONES:

# {- PROP´OSITO:

* ilustrar la combinaci´on incorrecta de
par´ametros y variables y de ´ındices y variables

### Cap. 156 — PRECONDICIONES:

# PRECONDICI´ON:

* este c´odigo siempre produce la autodestrucci´on
-}
{
color := Negro -- color no puede ser una variable,
-- pues es un par´ametro
Las bases conceptuales de la Programaci ´on Mart´ı

Secciones:
  # PRECONDICI´ON:

Conclusión: Pero este
ejercicio podr´ıa hacerse sin codificar con bolitas, recordando si hay o no enemigos en una
variable.

### Cap. 157 — OBSERVACIONES:

# PROP´OSITO:

* retorna verdadero si hay alg´un enemigo en las
pr´oximas 3 celdas al Norte de la actual

### Cap. 158 — PRECONDICIONES:

Ejercicio 4.3.2.

Secciones:
  # PRECONDICI´ON:

Conclusión: Esta for-
ma de recorrido procesa una secuencia de elementos, acumulando el total de cierta infor-
maci ´on que cada elemento posee.

### Cap. 159 — OBSERVACIONES:

# PROP´OSITO:

* retorna el precio total de los productos de un changuito
de supermercado

### Cap. 16 — PROP´OSITO:

# 7. Secuencia de comandos

### Cap. 160 — PRECONDICIONES:

Este.

Secciones:
  # PRECONDICI´ON:

Conclusión: Por ejemplo, para verificar de cu ´al color hay m ´as bolitas en la celda actual, se puede
hacer un recorrido de c ´alculo de m ´aximo sobre colores.

### Cap. 161 — OBSERVACIONES:

# PROP´OSITO:

* retorna el color del que hay m´as bolitas.
Si hay igual cantidad de m´as de un color,
retorna el menor color posible

### Cap. 162 — PRECONDICIONES:

Podemos observar varias cosas.

Secciones:
  # PRECONDICI´ON:

Conclusión: En ese caso, deber ´an usarse variables adicionales para recordar
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 167 of 312 --

168
cu ´al fue el elemento que contribuy ´o a maximizar o minimizar la cantidad, y la modificaci ´on
acorde de las subtareas correspondientes.

### Cap. 163 — OBSERVACIONES:

# PROP´OSITO:

* calcular el m´aximo n´umero de bolitas rojas en
una celda en la columna actual

### Cap. 164 — 15. Biblioteca de operaciones

# PRECONDICI´ON:

* ninguna, es una operaci´on total
-}
{
-- Iniciar el recorrido
IrAlExtremo(Norte)
maxCantidad := nroBolitas(Rojo)
-- Falta procesar alguna celda?
while (puedeMover(Sur))
{
Mover(Sur

Secciones:
  # PRECONDICI´ON:

Conclusión: Pero si en lugar de querer saber la cantidad, quisi ´eramos saber de qu ´e celda se trata
(por ejemplo, para marcarla con bolitas de color Azul), deber´ıamos recordar la cantidad
de veces que nos movemos y usar ese n ´umero al terminar el recorrido.

### Cap. 165 — PRECONDICIONES Y OBSERVACIONES:

# PROP´OSITO:

* marcar con bolitas azules la celda con el m´aximo
n´umero de bolitas rojas en la columna actual

### Cap. 166 — PRECONDICIONES Y OBSERVACIONES:

# PRECONDICI´ON:

* ninguna, es una operaci´on total

### Cap. 167 — PRECONDICIONES Y OBSERVACIONES:

Realice los ejercicios 4.3.7 y 4.3.8, y pru ´ebelos adecuadamente.

Secciones:
  # SUPOSICI´ON:

Conclusión: Por
ejemplo, imaginemos que queremos colocar una progresi ´on de bolitas verde en n celdas,
tal que la cantidad de bolitas en cada celda sean solo los m ´ultiplos de 2 o de 3 (o sea, 2, 3,
4, 6, 8, 9, 10, 12, etc.

### Cap. 168 — PRECONDICIONES Y OBSERVACIONES:

# {- PROP´OSITO:

* armar una progresi´on de n celdas con cantidad de
bolitas que sea m´ultiplo de 2 o de 3

### Cap. 169 — PRECONDICIONES Y OBSERVACIONES:

# PRECONDICI´ON:

* que haya n celdas al Este

### Cap. 17 — PRECONDICI´ON:

# 8. Bloques

### Cap. 170 — PRECONDICIONES Y OBSERVACIONES:

Mover(Este) -- por eso pasa a la sig.

Secciones:
  # OBSERVACI´ON:

Conclusión: Este ejercicio puede realizarse de tres maneras diferentes, cada una con su propia com-
plejidad.

### Cap. 171 — PRECONDICIONES:

# 1. Recorrer primero el texto de referencia, recordando la traducci ´on de cada s´ımbolo (digamos, armando un diccionario), y despu ´es recorrer el texto a traducir, usando el diccionario ya armado. Secciones: # 1. Recorrer primero el texto de referencia, recordando la traducci ´on de cada s´ımbolo Conclusión: En GOBSTONES, con las herramien- tas vistas, esto no es factible, porque solo se dispone de un n ´umero fijo de variables que recuerdan un ´unico valor, y no se pueden...

### Cap. 172 — OBSERVACIONES:

# 2. Recorrer el texto de referencia y, a medida que se encuentra un par clave/valor,

traducir todas las ocurrencias de ese s´ımbolo.
Esta soluci ´on tiene la dificultad de que una vez visitado el texto a traducir, hay que
volver a la posici ´on del texto de referencia de donde hab´ıa partido el cabezal. Esto
puede hacerse dejando marcas sobre el tablero. Sin embargo, esta soluci ´on es
compleja.

### Cap. 173 — PRECONDICIONES:

El juego de ZILFOST est ´a basado en el popular juego TETRISTM. Secciones: # 3. Esta posibilidad es la m ´as simple de programar (y quiz ´as la m ´as “natural” en alg ´un Conclusión: Definiremos los siguientes procedimientos y funciones concernientes a la zona de juego // * Geometr´ıa de la zona de juego // procedure IrAlOrigenDeZonaDeJuego() // function desplazamientoXDeZonaDeJuego() // function desplazamientoYDeZonaDeJuego() // function anchoDeZonaDeJuego() // function altoDeZonaDeJuego() // // * Movimiento dentro de la zona de juego...

### Cap. 174 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 175 — 16. Elementos de estilo

Ejercicio 5.2.1.

Secciones:
  # OBSERVACIONES:

Conclusión: Sin embargo, para simplificar
controles posteriores es m ´as sencillo si conocemos la cantidad de celdas que hay desde
la esquina suroeste hasta el origen de la zona de juego.

### Cap. 176 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
*/
{
IrAlOrigenDeZonaDeJuego()
return (medirDistanciaAlBorde(Oeste))
}
Podemos observar que reutilizamos la funci ´on medirDistancia

Secciones:
  # PRECONDICIONES:

Conclusión: Un elemento de utilidad para movernos dentro de la zona de juego sin salirse de la misma
(y sin tener que controlar cada vez mediante la codificaci ´on de bolitas si estamos en el
borde) ser ´a conocer el ancho y alto de la zona de juego.

### Cap. 177 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
*/
{
IrAlOrigenDeZonaDeJuego()
// Contar la distancia hasta el otro borde de la zona
anchoActual := 0
while (not nroBolitas(Azul)==5

Secciones:
  # PRECONDICIONES:

Conclusión: La funci ´on de control de movimiento, puedeMoverEnZonaDeJuego, cumple una funci ´on
similar a la de la funci ´on primitiva puedeMover, pero restringida a la zona de juego.

### Cap. 178 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 179 — OBSERVACIONES:

# OBSERVACIONES:

* optimiza la pregunta (no usan cuentas que deban
recorrer mucho el tablero)
* la verificaci´on usa el formato de codificaci´on
de un tablero Zilfost
*/
{
switch (dir) to
Norte ->
//

Secciones:
  # OBSERVACIONES:

Conclusión: Esto permite realizar una
consulta eficiente de la posibilidad de moverse en la zona de juego, lo que resulta crucial
para la eficiencia de las operaciones del juego.

### Cap. 18 — parte 2: , vemos que la misma tiene como precondici ´on que haya tantas celdas en

# 9. Ejecuci ´on de programas

### Cap. 180 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
*/
{ while (puedeMoverEnZonaDeJuego(dir)) { Mover(dir) } }
Observamos que el mecanismo es simplemente un recorrido de b ´usqueda que

Secciones:
  # PRECONDICIONES:

Conclusión: Para ir a una
coordenada espec´ıfica dentro de la zona de juego seguimos una estrategia diferente: se
utilizan las cantidades previamente obtenidas.

### Cap. 181 — OBSERVACIONES:

# PRECONDICIONES:

* (x,y) indica una coordenada v´alida
dentro de la zona de juego de Zilfost

### Cap. 182 — OBSERVACIONES:

Realice el ejercicio 5.2.2 y ub´ıquelo en la Biblioteca.

Secciones:
  # OBSERVACIONES:

Conclusión: Adem ´as, para que la funci ´on
tenga sentido la celda actual debe encontrarse dentro de una zona de n ´umeros.

### Cap. 183 — OBSERVACIONES:

# PROP´OSITO:

devuelve si hay m´as lugar en direcci´on dir en
la zona de n´umeros actual

### Cap. 184 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* la celda actual est´a en la zona de n´umeros a
determinar si se puede mover
* dir es Este u Oeste (no tiene sentido que sea
Norte o Sur, porque las zonas de n´umeros tienen
altura 1)

### Cap. 185 — OBSERVACIONES:

Observar c ´omo se establece la precondici ´on de manera que el c ´odigo tenga sentido.

Secciones:
  # OBSERVACIONES:

Conclusión: Al igual que en el caso de la funci ´on anterior, supondremos como precondici ´on
que la direcci ´on es Este u Oeste y que la celda actual est ´a dentro de una zona de n ´umeros.

### Cap. 186 — 17. Indentaci ´on

# PROP´OSITO:

ir al borde dir de la zona de n´umeros actual

### Cap. 187 — PRECONDICIONES:

# PRECONDICIONES: * default <hay un tablero de Zilfost codificado> * se encuentra dentro de una zona de n´umeros * dir es Este u Oeste (no tiene sentido que sea Norte o Sur, porque las zonas de n´ume Secciones: # PRECONDICIONES: Conclusión: El c ´odigo se estructura como un recorrido de totaliza- ci ´on sobre los d´ıgitos, ley ´endolos de derecha a izquierda, para lo cual asumimos como precondici ´on que la celda actual se encuentra en el borde derecho...

### Cap. 188 — OBSERVACIONES:

# PROP´OSITO:

devuelve un n´umero codificado en la zona de n´umeros
actual, si tal n´umero existe, o cero si no

### Cap. 189 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* est´a en el borde derecho de la zona de n´umeros
a leer

### Cap. 19 — {- PROP´OSITO:

# 10. Mensajes de error

### Cap. 190 — OBSERVACIONES:

Realice el ejercicio 5.2.3.

Secciones:
  # OBSERVACIONES:

Conclusión: Adem ´as, al iniciar debe borrarse la zona de n ´umeros actual para evi-
tar que se superpongan las representaciones de m ´as de un n ´umero.

### Cap. 191 — OBSERVACIONES:

Relice el ejercicio 5.2.4.

Secciones:
  # PRECONDICIONES:

Conclusión: La operaci ´on de borrado de zona de n ´umeros simplemente debe recorrer cada celda
de la zona de n ´umeros, vaci ´andola.

### Cap. 192 — OBSERVACIONES:

# PROP´OSITO:

borra el contenido de la zona de n´umeros actual

### Cap. 193 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* se encuentra en la zona de n´umeros a borrar

### Cap. 194 — OBSERVACIONES:

# OBSERVACIONES:

* se estructura como un recorrido en la zona
de n´umeros
*/
{
IrAlBordeDeZonaDeNumeros(Este)
while(puedeMoverEnZonaDeNumeroAl(Oeste))
{
VaciarCelda()
Mover(Oeste)
}
VaciarCelda()
}
L

Secciones:
  # OBSERVACIONES:

Conclusión: En caso que la zona est ´e llena,
la borra y vuelve a empezar.

### Cap. 195 — PRECONDICIONES:

# PROP´OSITO:

agrega el d´ıgito dig codificado en la zona de
n´umeros actual

### Cap. 196 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* dig es un d´ıgito (entre 0 y 9)
* se encuentra en la zona de n´umeros donde debe
agregar el d´ıgito

### Cap. 197 — 18. Elecci ´on de nombres

Ejercicio 5.2.5.

Secciones:
  # OBSERVACIONES:

Conclusión: Para poder contar con
un carry inicial, en lugar de procesar por separado el ´ultimo elemento de la secuencia, se
comienza procesando por separado el primero.

### Cap. 198 — PROP´OSITO:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* el n´umero m´aximo codificado no excede la cantidad
de d´ıgitos disponibles
* se encuentra en la zona de n´umeros a incrementar

### Cap. 199 — PRECONDICIONES:

Observemos el uso de las operaciones de movimiento en la zona.

Secciones:
  # OBSERVACIONES:

Conclusión: Esta ´ultima operaci ´on utiliza el procedimiento IncrementarDigitoDeCelda, cuyo com-
portamiento es similar al del ejercicio 3.

### Cap. 20 — PRECONDICI´ON:

# 11. M ´as comandos primitivos (Mover, Sacar, etc.)

### Cap. 200 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* o bien no hay d´ıgito, o bien es un d´ıgito v´alido
(entre 0 y 9)

### Cap. 201 — PROP´OSITO:

# OBSERVACIONES:

* si no hay d´ıgito, lo agrega
* si se excede, lo vuelve a 0
*/
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 192 of 312 --

193
{
// Agrega un d´ıgito si no lo h

Secciones:
  # OBSERVACIONES:

Conclusión: De esta manera, resultan sencillas.

### Cap. 202 — PRECONDICIONES:

# PROP´OSITO:

ir al origen de la zona de pr´oxima pieza

### Cap. 203 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 204 — PROP´OSITO:

# OBSERVACIONES:

* esta zona est´a 2 al Oeste del origen de la
zona de juego y 1 al Norte
*/
{
IrAlOrigenDeZonaDeJuego()
MoverN(Oeste,2); MoverN(Norte, 1)
}
procedure IrAlOrigenDeZonaDeSeleccion()
/*

### Cap. 205 — PRECONDICIONES:

# PROP´OSITO:

ir al origen de la zona de selecci´on

### Cap. 206 — OBSERVACIONES:

# PRECONDICIONES:

Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 193 of 312 --

194
* default <hay un tablero de Zilfost codificado>

### Cap. 207 — PROP´OSITO:

# OBSERVACIONES:

* 2 al Norte del origen de la zona de
pr´oxima pieza
*/
{
IrAlOrigenDeZonaDeProximaPieza()
MoverN(Norte,2)
}
procedure IrAlOrigenDeZonaDeSemilla()
/*
PROP´OSITO: ir al origen de la zona de semilla

### Cap. 208 — 19. Comentarios

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 209 — PRECONDICIONES:

# OBSERVACIONES: * la semilla se codifica debajo de la zona de piezas, todo a lo ancho */ { IrAlOrigenDeZonaDeJuego() MoverN(Sur, 2) IrAlBordeDeZonaDeNumeros(Este) } La lectura de estas zonas es tan Secciones: # OBSERVACIONES: Conclusión: OBSERVACIONES: * la semilla se codifica debajo de la zona de piezas, todo a lo ancho */ { IrAlOrigenDeZonaDeJuego() MoverN(Sur, 2) IrAlBordeDeZonaDeNumeros(Este) } La lectura de estas zonas es tan sencillo como ir al origen de la zona correspondiente (mediante las subtareas expresadas en los...

### Cap. 21 — 2. Programas

# 12. Procedimientos simples

### Cap. 210 — OBSERVACIONES:

# PROP´OSITO:

devuelve un n´umero codificado en la zona de
pr´oxima pieza, si existe, o cero si no

### Cap. 211 — PROP´OSITO:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 212 — PRECONDICIONES:

Las operaciones para leer las zonas restante son pr ´acticamente id ´enticas y las omitimos.

Secciones:
  # OBSERVACIONES:

Conclusión: Lo que hace la funci ´on rotar es justamente este c ´alculo.

### Cap. 213 — OBSERVACIONES:

# PRECONDICIONES:

* rotacion es una rotaci´on v´alida
(de 1 a 4 o con marca de 7 rojas)

### Cap. 214 — PRECONDICIONES:

# OBSERVACIONES: * el c´alculo se realiza de la siguiente forma rotacion 1 2 3 4 . mod 4 1 2 3 0 . +1 2 3 4 1 // En sentido horario rotacion 1 2 3 4 . + 2 3 4 5 6 . mod 4 3 0 1 2 . + 1 4 1 2 3 // En Secciones: # OBSERVACIONES: Conclusión: Con estas ideas, estamos en condiciones de definir las siguientes dos funciones, que se encargan...

### Cap. 215 — OBSERVACIONES:

# PRECONDICIONES:

* tipoPieza es un tipo v´alido
* rotPieza es una rotaci´on v´alida

### Cap. 216 — OBSERVACIONES:

# OBSERVACIONES:

* realiza una selecci´on alternativa en base al
tipo de pieza
*/
{
switch (tipoPieza) to
1 -> { (dirA,dirB,dirC1,dirC2)
:= diresDePiezaZ(rotPieza) }
2 -> { (dirA,dirB,dirC1,dirC2)
:=

Secciones:
  # OBSERVACIONES:

### Cap. 217 — OBSERVACIONES:

# PRECONDICIONES:

* tipoPieza es un tipo v´alido
* rotPieza es una rotaci´on v´alida

### Cap. 218 — PROP´OSITO:

Hay varios detalles para observar.

Secciones:
  # OBSERVACIONES:

Conclusión: Para ello reciben como
par ´ametro la rotaci ´on, y ajustan las direcciones “naturales” (las que tiene la pieza cuando
est ´a en rotaci ´on 1) seg ´un este par ´ametro.

### Cap. 219 — 20. Elementos de “contrato”

# PROP´OSITO:

* devolver las direcciones de una Z

### Cap. 22 — {- PROP´OSITO:

# 13. Invocaci ´on de procedimientos simples

### Cap. 220 — PROP´OSITO:

# PRECONDICIONES:

* la rotaci´on es v´alida

### Cap. 221 — PROP´OSITO:

La funci ´on ajustarDires se encarga de modificar las direcciones seg ´un la rotaci ´on.

Secciones:
  # OBSERVACIONES:

Conclusión: Pero la funci ´on
espec´ıfica para la pieza de clase B, diresDePiezaT merece cierta atenci ´on.

### Cap. 222 — OBSERVACIONES:

# PROP´OSITO:

* devolver las direcciones de una T

### Cap. 223 — PROP´OSITO:

# PRECONDICIONES:

* la rotaci´on es v´alida

### Cap. 224 — PRECONDICI´ON:

A primera vista parece casi id ´entica a la anterior. Secciones: # OBSERVACIONES: Conclusión: La primera de ellas es extremadamente sencilla y solo sirve para retornar varios valores juntos (y deber ´a ser usada en una asignaci ´on m ´ultiple) function id(dA,dB,dC1,dC2) Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez -- 198 of 312 -- 199 /* PROP´OSITO: retornar varios valores simult´aneamente */ { return (dA,dB,dC1,dC2) } La segunda requiere verificar cada una de las 4 rotaciones posibles,...

### Cap. 225 — K BACKSPACE; y

Las cuatro finales son solamente auxiliares para hayLugarParaPiezaTipo.

Secciones:
  # PRECONDICIONES:

Conclusión: Para esto utiliza las funciones que obtienen las direcciones de
una pieza, y dos funciones auxiliares para procesar las celdas de clase A y B.

### Cap. 226 — PRECONDICI´ON:

# PRECONDICIONES:

* tipoPieza es un tipo de pieza v´alido
* rotPieza es una rotaci´on v´alida

### Cap. 227 — K_B, K_ESCAPE, K_DELETE, K_BACKSPACE

# OBSERVACIONES:

* puede no haber lugar porque se acaba el tablero
o porque est´a ocupada
*/
{
if (esClaseA(tipoPieza))
{
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 201 of 312

Secciones:
  # OBSERVACIONES:

Conclusión: Resulta entonces interesante mirar el c ´odigo de las
funciones auxiliares.

### Cap. 228 — K_J, K_ARROW_LEFT

# PRECONDICIONES:

* est´a parado sobre el lugar en el que va el pivote
de la pieza
* las direcciones dadas codifican la pieza
correctamente
*/
{
return(esCeldaVacia()
&& hayCeldaLibreAl(dirA)
&& hayCeldaLibreAl(dirB)
&& hayCeldaLibreAlY(dirC1,dirC2))
}
y para la clase B tendremos el siguiente
function hayLgPzClaseBEnDires(dirA,dirB,dirC)
/*
PROP´OSITO: completar el trabajo de hayLugarParaPiezaTipo
para las piezas de clase B

### Cap. 229 — K_L, K_ARROW_RIGHT

Consideraremos cada una de ellas por separado, puesto que requieren cierto cuidado.

Secciones:
  # PRECONDICIONES:

Conclusión: Para ello
abstrae a la funci ´on esCeldaVacia que es una funci ´on de Biblioteca que verifica si en la
celda no hay bolitas de ning ´un color; esta funci ´on se defini ´o en el ejercicio 3.

### Cap. 23 — PRECONDICI´ON:

# 14. Divisi ´on en subtareas

### Cap. 230 — 21. Prop ´osito de una operaci ´on

# PRECONDICIONES:

* la celda actual se encuentra en la zona de
juego

### Cap. 231 — K_K, K_ARROW_DOWN

# OBSERVACIONES:

* abstrae a la funci´on de Biblioteca que verifica
si una celda est´a vac´ıa
*/
{ return (esCeldaVacia()) }
La precondici ´on establece que la celda actual est ´a en la zona de juego

Secciones:
  # OBSERVACIONES:

Conclusión: Para esto se sigue una
idea similar a la de la funci ´on hayCeldaVaciaAl, del ejercicio 4.

### Cap. 232 — K_I, K_ARROW_UP

# PRECONDICIONES:

* la celda actual se encuentra en la zona de
juego

### Cap. 233 — K_D, K_ENTER

# OBSERVACIONES: * es libre si hay celda y no tiene pieza */ { return (puedeMoverEnZonaDeJuego(dir) && esCeldaVaciaAl(dir)) } Vale recordar que estamos usando la caracter´ıstica de circuito corto (sh Secciones: # OBSERVACIONES: Conclusión: Por esta raz ´on debemos pedir como precondici ´on que las direcciones no se cancelen mutuamente (o sea, que no sean una Norte y la otra Sur, o una Este y la otra Oeste)), y debemos controlar la existencia de la segunda celda despu ´es de...

### Cap. 234 — K_A, K_SPACE

# PRECONDICIONES:

* la celda actual se encuentra en la zona de
juego
* las direcciones dadas no se "cancelan" mutuamente
(por ejemplo, no son Norte y Sur o Este y Oeste)

### Cap. 235 — OBSERVACIONES:

# OBSERVACIONES:

* es libre si hay celda y no tiene pieza
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 203 of 312 --

204
*/
{
if (puedeMoverEnZonaDeJuego(dir1))
{ Mover(dir1)
if

Secciones:
  # OBSERVACIONES:

Conclusión: Al pro-
cedimiento que la codifica lo denominamos IrAPiezaSiExiste, y se estructura como un
recorrido de b ´usqueda sobre las celdas de la zona de juego, terminando o bien cuando
encuentra la pieza buscada, o bien cuando se acaban las celdas.

### Cap. 236 — (1-Z,2-I,3-L,4-F,5-O,6-S,7-T)

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 237 — /*=SECCI´ON 1=======================================*

B.

Secciones:
  # OBSERVACIONES:

Conclusión: Las operaciones ser ´an las siguientes
// procedure ColocarPieza(codPieza, tipoPieza, rotPieza)
// procedure ColocarPzClaseA(codPieza,tipoPieza,rotPieza
// ,dirA,dirB,dirC1,dirC2)
// procedure ColocarPzClaseB(codPieza,tipoPieza,rotPieza
// ,dirA,dirB,dirC)
// procedure ColocarSeccionDePieza(codPieza)
// procedure ColocarPivote(codPieza,tipoPieza,rotPieza)
// procedure ColocarSeccionDePiezaEn(codPieza,dir)
// procedure ColocarSeccionDePiezaEnY(codPieza,dir1,dir2)
El c ´odigo de ColocarPieza es sencillo una vez que entendemos que solo determina a
cual de las operaciones auxiliares debe invocar.

### Cap. 238 — PRECONDICI´ON:

# PRECONDICIONES:

* hay lugar para colocar la pieza
* no hay otra pieza codPieza en el tablero
* tipoPieza es un tipo v´alido
* rotPieza es una rotaci´on v´alida

### Cap. 239 — PRECONDICI´ON:

# OBSERVACIONES:

* la celda actual ser´a el centro de la pieza
codPieza
* la pieza codPieza ser´a de tipo tipoPieza
* la rotaci´on estar´a dada por rotPieza
* la celda actual queda en el mismo lugar

Secciones:
  # OBSERVACIONES:

Conclusión: Las operaciones auxiliares simplemente colocan las secciones en los lugares corres-
pondientes utilizando m ´as operaciones auxiliares.

### Cap. 24 — SUPOSICION:

# 15. Biblioteca de operaciones

### Cap. 240 — K_B, K_ESCAPE, K_DELETE, K_BACKSPACE

# PRECONDICIONES Y OBSERVACIONES:

* las mismas que para ColocarPieza
* las direcciones coinciden con el tipoPieza
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 205 of 312 --

206
*/
{
ColocarPivote(codPieza,tipoPieza,rotPieza)
ColocarSeccionDePiezaEn(codPieza,dirA)
ColocarSeccionDePiezaEn(codPieza,dirB)
ColocarSeccionDePiezaEnY(codPieza,dirC1,dirC2)
}
//----------------------------------------------------
procedure ColocarPzClaseB(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC)
/*
PROP´OSITO: completar el trabajo de ColocarPieza
para las piezas de clase B

### Cap. 241 — 22. Precondiciones de una operaci ´on

# PRECONDICIONES Y OBSERVACIONES:

* las mismas que para ColocarPieza
* las direcciones coinciden con el tipoPieza
*/
{
ColocarPivote(codPieza,tipoPieza,rotPieza)
ColocarSeccionDePiezaEn(codPieza,dirA)
ColocarSeccionDePiezaEn(codPieza,dirB)
ColocarSeccionDePiezaEn(codPieza,dirC)
}
Las operaciones de colocar secciones son similares a las de verificar si hay lugar, con la
excepci ´on que pueden asumir como precondici ´on que las celdas donde deben ubicarse
las secciones existen, lo cual simplifica un poco el c ´odigo.
procedure ColocarSeccionDePieza(codPieza)
/*
PROP´OSITO: coloca una secci´on de la pieza codPieza

### Cap. 242 — K_J, K_ARROW_LEFT

# PRECONDICIONES Y OBSERVACIONES:

* las mismas que para ColocarPieza
*/
{ PonerN(Verde,codPieza) }
//-----------------------------------------------------
procedure ColocarPivote(codPieza, tipoPieza, rotPieza)
/*
PROP´OSITO: coloca el pivote de la pieza codPieza

### Cap. 243 — K_L, K_ARROW_RIGHT

# PRECONDICIONES Y OBSERVACIONES:

* las mismas que para ColocarPieza
*/
{
ColocarSeccionDePieza(codPieza)
PonerN(Negro,tipoPieza)
PonerN(Rojo,rotPieza)
}
//-----------------------------------------------------
procedure ColocarSeccionDePiezaEn(codPieza,dir)
/*
PROP´OSITO: coloca una secci´on de la pieza codPieza
en la celda lindante al dir

### Cap. 244 — K_K, K_ARROW_DOWN

# PRECONDICIONES Y OBSERVACIONES:

* las mismas que para ColocarPieza
*/
{
Mover(dir)
ColocarSeccionDePieza(codPieza)
Mover(opuesto(dir))
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 206 of 312 --

207
//-----------------------------------------------------
procedure ColocarSeccionDePiezaEnY(codPieza,dir1,dir2)
/*
PROP´OSITO: coloca una secci´on de la pieza codPieza
en la celda lindante al dir1 y dir2

### Cap. 245 — K_I, K_ARROW_UP

QuitarSeccionDePiezaActual.

Secciones:
  # PRECONDICIONES Y OBSERVACIONES:

Conclusión: Solo daremos el c ´odigo de la operaci ´on
QuitarSeccionDePiezaActual.

### Cap. 246 — K_D, K_ENTER

# PRECONDICIONES:

* la celda es una secci´on de pieza

### Cap. 247 — K_A, K_SPACE

Veamos el c ´odigo de la funci ´on puedeMoverPiezaActual.

Secciones:
  # OBSERVACIONES:

### Cap. 248 — /*=SECCI´ON 2=======================================*

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 249 — PRECONDICIONES:

# OBSERVACIONES:

* para saber si puede mover, se la quita y se
determina si hay lugar en la celda
correspondiente (si es que existe)
* si no hay pieza, no la puede mover...
*/
{
if (esSeccionPivoteDe

Secciones:
  # OBSERVACIONES:

Conclusión: El procedimiento de MoverPiezaActual procede de manera muy similar a la de la
funci ´on reci ´en explicada.

### Cap. 25 — PROP´OSITO:

# 16. Elementos de estilo

### Cap. 250 — OBSERVACIONES:

# PRECONDICIONES:

* la celda actual est´a sobre el pivote de una
pieza

### Cap. 251 — PRECONDICIONES:

Sur.

Secciones:
  # OBSERVACIONES:

Conclusión: Finalmente, el c ´odigo de rotar pieza es similar al de mover pieza, salvo que debe
calcularse y usarse la nueva rotaci ´on.

### Cap. 252 — 1. Par ´ametros

# PRECONDICIONES:

* la celda actual est´a sobre el pivote de una
pieza

### Cap. 253 — PRECONDICIONES:

Con esto culmina la presentaci ´on de las partes b ´asicas del juego.

Secciones:
  # OBSERVACIONES:

Conclusión: Por simplicidad, se asume que las piezas se colocan
en la zona de juego en rotaci ´on “natural” (o sea, c ´odigo de rotaci ´on 1).

### Cap. 254 — PRECONDICIONES:

# PRECONDICIONES:

* la pieza codPieza no existe en la zona de juego
* ubicaci´on es mayor o igual a 0 y menor que el
ancho de la zona de juego

### Cap. 255 — PRECONDICIONES:

La operaci ´on principal se divide en dos partes: bajar las piezas y extender el piso. Secciones: # OBSERVACIONES: Conclusión: Las mismas son las siguientes // procedure BajarPiezasDeZonaDeJuego() // procedure UnicamenteBajarPiezas() // procedure IrAPiezaBajableNoMarcadaSiExiste() Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez -- 210 of 312 -- 211 // function esSeccionPivoteDePiezaNoMarcadaBajable() // function esCeldaConMarcaDePieza() // procedure MarcarPiezaActual() // procedure QuitarMarcasDePiezas() // procedure DesmarcarPiezaActualSiHay() La operaci ´on principal se divide en dos partes: bajar las piezas y extender el...

### Cap. 256 — PRECONDICIONES:

# OBSERVACIONES:

* al bajar piezas se puede generar nuevo piso
y por eso se invoca a la operaci´on de extender
el piso
*/
{
UnicamenteBajarPiezas()
ExtenderElPiso()
}
La operaci ´on de bajar ´unicame

Secciones:
  # OBSERVACIONES:

Conclusión: Se estructura como un recorrido sobre las
piezas no marcadas.

### Cap. 257 — OBSERVACIONES:

G.5.4.

Secciones:
  # OBSERVACIONES:

Conclusión: Se estructura como un
recorrido de b ´usqueda sobre las celdas de la zona de juego; pero dado que puede terminar
sin que haya ninguna, debe preguntarse al terminar si efectivamente termin ´o sobre una
pieza como la buscada.

### Cap. 258 — PRECONDICIONES:

# OBSERVACIONES: * se estructura como un recorrido de b´usqueda sobre las celdas de la zona de juego * si no hay pieza, no hay marca y no puede bajar con lo cual sigue buscando * si para, es porque e Secciones: # OBSERVACIONES: Conclusión: SeccionPivoteDePiezaNoMarcadaBajable() /* PROP´OSITO: informa si la celda actual es celda pivote de una pieza no marcada que puede bajar */ { return (esSeccionPivoteDeAlgunaPieza() && not esCeldaConMarcaDePieza() && puedeBajarPiezaActual()) } Observar como se usa el circuito...

### Cap. 259 — PRECONDICIONES:

Solo faltan las operaciones de marcado para completar las operaciones de esta secci ´on.

Secciones:
  # OBSERVACIONES:

Conclusión: Es importante
que las marcas no interfieran con la codificaci ´on de otras partes del juego.

### Cap. 26 — PRECONDICI´ON:

# 17. Indentaci ´on

### Cap. 260 — OBSERVACIONES:

# PRECONDICIONES:

* la celda actual es el pivote de una pieza
y la misma no est´a marcada

### Cap. 261 — PROP´OSITO:

# OBSERVACIONES:

* se marca con 7 bolitas rojas (verificar que
otras marcas no usen esta misma codificaci´on)
*/
{ PonerN(Rojo,7) }
Para quitar las marcas de todas las piezas ya marcadas se usa un recorrido de las celdas
de la zona de juego
procedure QuitarMarcasDePiezas()
/*
PROP´OSITO: quita todas las marcas de las piezas

### Cap. 262 — PRECONDICIONES:

# OBSERVACIONES: * se estructura como un recorrido sobre las celdas de la zona de juego, quitando todas las marcas de pieza */ { IrAlOrigenDeZonaDeJuego() while (not esFinDelRecorridoNEDeZonaDeJuego( Secciones: # OBSERVACIONES: Conclusión: OBSERVACIONES: * se estructura como un recorrido sobre las celdas de la zona de juego, quitando todas las marcas de pieza */ { IrAlOrigenDeZonaDeJuego() while (not esFinDelRecorridoNEDeZonaDeJuego()) { // Procesar es sacar la marca de pieza, si existe DesmarcarPiezaActualSiHay() AvanzarEnRecorridoNEDeZonaDeJuego() } // Procesar ´ultimo DesmarcarPiezaActualSiHay() } La operaci...

### Cap. 263 — 2. Procedimientos con par ´ametros

Cuando las piezas no pueden bajar m ´as, se vuelven parte del piso.

Secciones:
  # OBSERVACIONES:

Conclusión: Para esto se utiliza un mecanismo de marcas de la siguiente
manera: se marcan todas las piezas y luego se van procesando de a una; al transformar
en piso una pieza se la transforma en piso marcado, as´ı se garantiza que sus celdas a ´un
no han sido procesadas.

### Cap. 264 — OBSERVACIONES:

# OBSERVACIONES:

* no hace falta procesar el ´ultimo elemento pues
seguro est´a en la fila m´as al Norte y no puede
tener nada encima
* se estructura como un recorrido NE sobre celdas
* para cada cel

Secciones:
  # OBSERVACIONES:

Conclusión: Para
detectar esto utiliza la funci ´on esPiso y el procedimiento MarcarPiso.

### Cap. 265 — PROP´OSITO:

Ejercicio 5.5.1.

Secciones:
  # OBSERVACIONES:

Conclusión: Sin embargo, dado que la celda actual del recorrido est ´a ocupada por
una pieza que va a ser reemplazada por piso, la marca no puede ser colocada en dicha
celda; para solucionar esto se marca en la celda inmediatamente inferior, que por tratarse
de la base, es una celda del borde del tablero.

### Cap. 266 — PRECONDICIONES:

# OBSERVACIONES:

* se estructura como un recorrido sobre las
celdas de la fila base
* las piezas se transforman a piso sin marcar
*/
{
IrAlOrigenDeZonaDeJuego()
while (puedeMoverEnZonaDeJuego(Este))

Secciones:
  # OBSERVACIONES:

Conclusión: Este par ´ametro se ir ´a pasando hasta el momento de
transformar la pieza en piso.

### Cap. 267 — PROP´OSITO:

# OBSERVACIONES:

* si no hay pieza, entonces no hace nada
*/
{
if (esSeccionDeAlgunaPieza())
{
IrAPiezaSiExiste(leerCodigoDePiezaActual())
TransformarEnPisoPiezaActual(marca)
}
}
El procedimiento Tra

Secciones:
  # OBSERVACIONES:

Conclusión: El c ´odigo se omite pues es
pr ´acticamente id ´entico al de los otros procedimientos similares (con la excepci ´on de que
debe avisar si el piso debe transformarse marcado o no).

### Cap. 268 — PRECONDICIONES:

# PRECONDICIONES:

* la celda es secci´on de una pieza

### Cap. 269 — OBSERVACIONES:

La ´ultima acci ´on luego de extender el piso es eliminar las filas que hayan quedado llenas.

Secciones:
  # OBSERVACIONES:

Conclusión: Cuando encuentra una fila llena, baja todas las
superiores sobre ella y contin ´ua bajando hasta que la fila actual no est ´a m ´as llena.

### Cap. 27 — {- PROP´OSITO:

# 18. Elecci ´on de nombres

### Cap. 270 — PROP´OSITO:

# PROP´OSITO:

eliminar todo el piso de las filas llenas de
la zona de juego, bajando el piso de las superiores
a la eliminada

### Cap. 271 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 272 — OBSERVACIONES:

# OBSERVACIONES:

* debe ir de abajo-arriba para no repetir trabajo
* se estructura como un recorrido sobre filas
*/
{
IrAlOrigenDeZonaDeJuego()
while(puedeMoverEnZonaDeJuego(Norte))
{
EliminarMientrasSigaLlena()
Mover(Norte)
}
// Procesa la fila m´as al Norte
EliminarMientrasSigaLlena()
}
El ´unico procedimiento nuevo es EliminarMientrasSigaLlena, que procesa la fila actual.
En este caso su c ´odigo es muy simple: baja las filas superiores hasta que la actual no
est ´e llena.
procedure EliminarMientrasSigaLlena()
/*

### Cap. 273 — PROP´OSITO:

# PROP´OSITO:

eliminar las secciones de piso de la fila
actual bajando las de piso que est´an sobre ella,
hasta que la fila actual no est´e llena

### Cap. 274 — 3. Invocaci ´on de procedimientos con argumentos

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 275 — PRECONDICIONES:

True significa que la fila no contiene celdas diferentes del piso (est ´a llena).

Secciones:
  # OBSERVACIONES:

Conclusión: Cuando termina, si el booleano sigue en
True significa que la fila no contiene celdas diferentes del piso (est ´a llena).

### Cap. 276 — OBSERVACIONES:

# PROP´OSITO:

determinar si la fila actual est´a llena de piso

### Cap. 277 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 278 — PROP´OSITO:

La pregunta sobre si es llena antes de saber si puede mover optimiza levemente el c ´odigo.

Secciones:
  # OBSERVACIONES:

Conclusión: Adem ´as,
el procesamiento de la ´ultima fila debe hacerse diferente, pues ella no tiene filas arriba;
consiste simplemente en borrar todas las celdas del piso de dicha fila.

### Cap. 279 — PRECONDICIONES:

# PROP´OSITO:

bajar todas las filas de piso sobre la actual,
sobreescribiendo la fila actual,
solo en la zona de juego

### Cap. 28 — PRECONDICI´ON:

# 19. Comentarios

### Cap. 280 — PROP´OSITO:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 281 — PRECONDICIONES:

# OBSERVACIONES:

* al bajar, se quita todo el piso de la fila
m´as al Norte
* el cabezal no se debe mover de la fila
actual (por lo que debe devolv´erselo a su
lugar al terminar)
* la variables despl

Secciones:
  # OBSERVACIONES:

Conclusión: El c ´odigo que s´ı se ofrece es el de procesar una celda, bajando la que est ´a sobre
ella, pues resulta interesante.

### Cap. 282 — OBSERVACIONES:

# PROP´OSITO:

baja la celda al norte de la actual,
si corresponde

### Cap. 283 — PROP´OSITO:

# PRECONDICIONES:

* no est´a en la fila m´as al Norte

### Cap. 284 — PRECONDICIONES:

VaciarDePisoLaFilaActual.

Secciones:
  # OBSERVACIONES:

Conclusión: Este procedimiento es muy sencillo,
pues simplemente combina operaciones anteriormente definidas de manera secuencial.

### Cap. 285 — 4. Uso de par ´ametros

Toda la mec ´anica del juego se accede con una interfaz espec´ıfica.

Secciones:
  # PRECONDICIONES:

Conclusión: All´ı muestra adem ´as c ´omo
implementarlo con aritm ´etica de 32 bits y c ´omo obtener n ´umeros en un rango de 0 a un
m ´aximo dado.

### Cap. 286 — OBSERVACIONES:

LNCS 925, Springer Verlag, 1995.

Secciones:
  # OBSERVACIONES:

Conclusión: Meijer, editores,
LNCS 925, Springer Verlag, 1995.

### Cap. 287 — PRECONDICIONES:

# OBSERVACIONES:

* auxiliar para randomEntre0YConSemilla(maximo, semilla)
* Mark Jones lo atribuye a "Random Number Generators: Good
Ones are Hard to Find" de S.K.Park y K.W.Miller, publicado
en la r

Secciones:
  # OBSERVACIONES:

Conclusión: El c ´odigo resultante es el siguiente
function determinarNuevaPieza(semilla)
/*
PROP´OSITO: devolver c´odigo, tipo y ubicaci´on para
una nueva pieza de manera seudorand´omica
en base a una semilla.

### Cap. 288 — OBSERVACIONES:

Puede verse que el tipo de pieza se acota entre 0 y 6, y luego se ajusta sum ´andole 1.

Secciones:
  # OBSERVACIONES:

Conclusión: Este es el prop ´osito de la zona de se-
milla que fuera descrita en la secci ´on 5.

### Cap. 289 — PRECONDICIONES:

# PROP´OSITO:

combinar las acciones necesarias para la aparici´on
de una nueva pieza en la zona de juego (si entra)
*/
{
semilla := leerSemilla()
(codPz,tipoPz,ubicPz,semilla) := determinarNuevaPieza

Secciones:
  # PROP´OSITO:

Conclusión: Las operaciones de movimiento y rotaci ´on de piezas utilizan el n ´umero codificado en
la zona de selecci ´on para determinar sobre qu ´e pieza del tablero deben trabajar, y luego
usan la operaci ´on correspondiente para hacerlo, suministrando los par ´ametros correspon-
dientes.

### Cap. 29 — {- PROP´OSITO:

# 20. Elementos de “contrato”

### Cap. 290 — OBSERVACIONES:

# PROP´OSITO:

combinar las acciones necesarias para mover la
pieza indicada en la zona de selecci´on (si existe)
*/
{
IrAPiezaSiExiste(leerZonaDeSeleccion())
if (hayPiezaActual())
{ MoverPiezaActual(

Secciones:
  # PROP´OSITO:

Conclusión: Cuando los d´ıgitos completan un c ´odigo v ´alido, esta operaci ´on baja todas
las piezas.

### Cap. 291 — PROP´OSITO:

# PROP´OSITO:

agregar un d´ıgito a la selecci´on actual, y bajar
las piezas al terminar de ingresar un c´odigo v´alido

### Cap. 292 — PRECONDICIONES:

# OBSERVACIONES:

* como los d´ıgitos se ingresan de izquierda a derecha
pero se leen de derecha a izquierda, determinar si
se complet´o el ingreso de un c´odigo v´alido se puede
realizar leyendo el n

Secciones:
  # OBSERVACIONES:

Conclusión: Finalmente la ´ultima de las operaciones de interacci ´on es la de bajar todas las piezas
en simult ´aneo.

### Cap. 293 — OBSERVACIONES:

Un programa simple invoca sencillamente a una o m ´as operaciones de interfaz.

Secciones:
  # PROP´OSITO:

Conclusión: Por ejem-
plo, el tablero final que muestra el nombre ZILFOST escrito con piezas del gr ´afico G.

### Cap. 294 — PROP´OSITO:

# PRECONDICI´ON:

* tiene que haber un juego de Zilfost v´alido
codificado en el tablero con una zona de
juego de ancho m´ınimo 9
*/
{ GenerarLogoZILFOST() }
Vemos que se asume que ya hay un juego de

Secciones:
  # PRECONDICI´ON:

Conclusión: K Z;
los c ´odigos de los d´ıgitos, K 0, .

### Cap. 295 — PRECONDICIONES:

# K BACKSPACE; y

el c ´odigo de la tecla de fin de ciclo, K CTRL D.
El caracter de CTRL-D es hist ´oricamente usado en telecomunicaciones como el carac-
ter de fin de transmisi ´on (end-of-transmissi

Secciones:
  # K BACKSPACE; y

Conclusión: El juego interactivo
Habiendo presentado la capacidad de GOBSTONES de expresar programas interactivos,
completaremos nuestra presentaci ´on del ZILFOST mostrando un programa principal inter-
activo, donde fueron elegidas teclas espec´ıficas para llevar adelante la interacci ´on.

### Cap. 296 — 5. Requisitos a los par ´ametros

# PRECONDICI´ON:

* tiene que haber un juego de
Zilfost v´alido codificado en el tablero
*/
{

### Cap. 297 — OBSERVACIONES:

# K_B, K_ESCAPE, K_DELETE, K_BACKSPACE

-> { BorrarZonaDeSeleccion() }
K_0 -> { OperacionAgregarDigitoASeleccion(0) }
K_1 -> { OperacionAgregarDigitoASeleccion(1) }
K_2 -> { OperacionAgregarDigitoASeleccion(2) }
K_3 -> { OperacionAgregarDigitoASeleccion(3) }
K_4 -> { OperacionAgregarDigitoASeleccion(4) }
K_5 -> { OperacionAgregarDigitoASeleccion(5) }
K_6 -> { OperacionAgregarDigitoASeleccion(6) }
K_7 -> { OperacionAgregarDigitoASeleccion(7) }
K_8 -> { OperacionAgregarDigitoASeleccion(8) }
K_9 -> { OperacionAgregarDigitoASeleccion(9) }

### Cap. 298 — PRECONDICIONES:

# K_J, K_ARROW_LEFT

Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 229 of 312 --

230
-> { OperacionMoverPiezaAl(Oeste) }

### Cap. 299 — OBSERVACIONES:

# K_L, K_ARROW_RIGHT

-> { OperacionMoverPiezaAl(Este) }

### Cap. 30 — PRECONDICI´ON:

# 21. Prop ´osito de una operaci ´on

### Cap. 300 — PROP´OSITO:

# K_K, K_ARROW_DOWN

-> { OperacionMoverPiezaAl(Sur) }

### Cap. 301 — PRECONDICIONES:

# K_I, K_ARROW_UP

-> { OperacionColocarNuevaPieza() }

### Cap. 302 — OBSERVACIONES:

# K_D, K_ENTER

-> { OperacionRotarPieza(True) -- Sentido horario }

### Cap. 303 — PROP´OSITO:

ESCAPE, DELETE y BACKSPACE vac´ıan la zona de selecci ´on.

Secciones:
  # K_A, K_SPACE

Conclusión: C ´odigo principal
/* -------------------------------------------------
AUTOR: Pablo E.

### Cap. 304 — PRECONDICIONES:

# OBSERVACIONES:

* Zilfost es un juego basado en el Tetris, pero donde
las reglas son levemente diferentes
* se basa en una idea de un parcial de
Introducci´on a la Programaci´on de la
carrera TPI de

Secciones:
  # OBSERVACIONES:

Conclusión: SECCI´ON 2):
.

### Cap. 305 — OBSERVACIONES:

# (1-Z,2-I,3-L,4-F,5-O,6-S,7-T)

. cada tipo tiene una rotaci´on "natural"
que corresponde a la mnemotecnia
. una rotaci´on v´alida va entre 1 y 4
y la codificaci´on sigue el sentido de las
agujas del

Secciones:
  # (1-Z,2-I,3-L,4-F,5-O,6-S,7-T)

Conclusión: Z,2-I,3-L,4-F,5-O,6-S,7-T)

.

### Cap. 306 — OBSERVACIONES:

# /*=SECCI´ON 1=======================================*

* C´odigio principal *
*=================================================*/
{-
/*==================================================*/
/* Programa */
/*==================================================*/
program
/*

### Cap. 307 — 6. Repetici ´on simple

# PRECONDICI´ON:

* tiene que haber un juego de Zilfost v´alido
codificado en el tablero con una zona de
juego de ancho m´ınimo 9
*/
{ GenerarLogoZILFOST() }
-}
/*==================================================*/
/* Programa interactivo */
/*==================================================*/
interactive program
/*

### Cap. 308 — PROP´OSITO:

# PRECONDICI´ON:

* tiene que haber un juego de
Zilfost v´alido codificado en el tablero
*/
{

### Cap. 309 — PRECONDICIONES:

# K_B, K_ESCAPE, K_DELETE, K_BACKSPACE

-> { BorrarZonaDeSeleccion() }
K_0 -> { OperacionAgregarDigitoASeleccion(0) }
K_1 -> { OperacionAgregarDigitoASeleccion(1) }
K_2 -> { OperacionAgregarDigitoASeleccion(2) }
K_3 -> { OperacionAgregarDigitoASeleccion(3) }
K_4 -> { OperacionAgregarDigitoASeleccion(4) }
K_5 -> { OperacionAgregarDigitoASeleccion(5) }
K_6 -> { OperacionAgregarDigitoASeleccion(6) }
K_7 -> { OperacionAgregarDigitoASeleccion(7) }
K_8 -> { OperacionAgregarDigitoASeleccion(8) }
K_9 -> { OperacionAgregarDigitoASeleccion(9) }

### Cap. 31 — {- PROP´OSITO:

# 22. Precondiciones de una operaci ´on

Cap. 3

### Cap. 310 — OBSERVACIONES:

# K_J, K_ARROW_LEFT

-> { OperacionMoverPiezaAl(Oeste) }

### Cap. 311 — PROP´OSITO:

# K_L, K_ARROW_RIGHT

-> { OperacionMoverPiezaAl(Este) }

### Cap. 312 — PRECONDICIONES:

# K_K, K_ARROW_DOWN

-> { OperacionMoverPiezaAl(Sur) }

### Cap. 313 — OBSERVACIONES:

# K_I, K_ARROW_UP

-> { OperacionColocarNuevaPieza() }

### Cap. 314 — PROP´OSITO:

# K_D, K_ENTER

-> { OperacionRotarPieza(True) -- Sentido horario }

### Cap. 315 — PRECONDICIONES:

# K_A, K_SPACE

-> { OperacionRotarPieza(False) -- Sentido antihorario }
_ -> { OperacionBajarPiezas() }
}
B.2. Operaciones sobre zonas

### Cap. 316 — OBSERVACIONES:

B.2.1.

Secciones:
  # /*=SECCI´ON 2=======================================*

Conclusión: Auxiliares - Operaciones de *
* la zona de juego del tablero *
* *
* La zona de juego es una zona rectangular, *
* delimitada en sus esquinas inferiores por *
* celdas con 5 bolitas azules, en sus *
* esquinas superiores por celdas con 7 *
* bolitas azules y rodeada por celdas con *
* 6 bolitas azules a ambos lados.

### Cap. 317 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 318 — 7. Repetici ´on indexada

# OBSERVACIONES:

* El origen esta al Este de la primer celda
de 5 bolitas en un recorrido NE de las celdas
*/
{ IrAPrimerCeldaNEConBolitas(Azul,5); Mover(Este) }
//----------------------------------------------------
function desplazamientoXDeZonaDeJuego()
/*
PROP´OSITO: retorna la cantidad de celdas al Este
a moverse desde la esquina suroeste para
ubicarse en la 1era columna de la zona de juego

### Cap. 319 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
*/
{
IrAlOrigenDeZonaDeJuego()
return (medirDistanciaAlBorde(Oeste))
}
//----------------------------------------------------
function desplazamientoYDeZonaDeJuego()
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 260 of 312 --

261
/*
PROP´OSITO: retorna la cantidad de celdas al Norte
a moverse desde la esquina suroeste para
ubicarse en la 1era fila de la zona de juego

### Cap. 32 — 3. Comandos

# 1. Par ´ametros

### Cap. 320 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
*/
{
IrAlOrigenDeZonaDeJuego()
return (medirDistanciaAlBorde(Sur))
}
//----------------------------------------------------
function anchoDeZonaDeJuego()
/*
PROP´OSITO: retorna la cantidad de celdas de ancho
de la zona de juego

### Cap. 321 — /*=SECCI´ON 3=======================================*

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
*/
{
IrAlOrigenDeZonaDeJuego()
// Contar la distancia hasta el otro borde de la zona
anchoActual := 0
while (not nroBolitas(Azul)==5)
{
anchoActual := anchoActual + 1
Mover(Este)
}
return (anchoActual)
}
//-----------------------------------------------------
function altoDeZonaDeJuego()
/*
PROP´OSITO: retorna la cantidad de celdas de alto
de la zona de juego

### Cap. 322 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
*/
{
IrAlOrigenDeZonaDeJuego(); Mover(Oeste)
// Contar la altura hasta las 7 bolitas azules
altura := 0
while (nroBolitas(Azul)/=7)
{
altura := altura + 1
Mover(Norte)
}
return (altura+1) // Ajusta contando la ultima
}
//-----------------------------------------------------
//------------------------------------------------------
function puedeMoverEnZonaDeJuego(dir)
/*
PROP´OSITO: determina si puede moverse en la direcci´on
dada sin caerse de la parte de juego

### Cap. 323 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* la celda actual est´a dentro de la zona de juego
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 261 of 312 --

262

### Cap. 324 — PRECONDICIONES:

# OBSERVACIONES: * optimiza la pregunta (no usa cuentas que deban recorrer mucho el tablero) */ { switch (dir) to Norte -> // Si dir es Norte, se puede mover dentro de la // zona si hay lugar al nort Secciones: # OBSERVACIONES: Conclusión: OBSERVACIONES: * optimiza la pregunta (no usa cuentas que deban recorrer mucho el tablero) */ { switch (dir) to Norte -> // Si dir es Norte, se puede mover dentro de la // zona si hay...

### Cap. 325 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
*/
{ while (puedeMoverEnZonaDeJuego(dir)) { Mover(dir) } }
//----------------------------------------------------
procedure IrACoordenadaDeZonaDeJuego(x,y)
/*
PROP´OSITO: ir a la coordenada (x,y) en la zona
de juego del SeudoTetris

### Cap. 326 — PRECONDICIONES:

# PRECONDICIONES:

* (x,y) indica una coordenada v´alida
dentro de la zona de juego de Zilfost

### Cap. 327 — OBSERVACIONES:

B.2.2.

Secciones:
  # OBSERVACIONES:

Conclusión: Operaciones sobre zonas de n ´umeros
/*=SECCI´ON 2.

### Cap. 328 — PRECONDICIONES:

# PROP´OSITO:

devuelve si hay m´as lugar en direcci´on dir en
la zona de n´umeros actual

### Cap. 329 — 9. Uso de ´ındices

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* la celda actual est´a en la zona de n´umeros a
determinar si se puede mover
* dir es Este u Oeste (no tiene sentido que sea
Norte o Sur, porque las zonas de n´umeros tienen
altura 1)

### Cap. 33 — PRECONDICI´ON:

# 2. Procedimientos con par ´ametros

### Cap. 330 — OBSERVACIONES:

# OBSERVACIONES:

* la zona termina con 6 azules al Este y Oeste
*/
{ return(nroBolitasAl(Azul,dir)/=6) }
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 263 of 312 --

264
//----------------------------------------------------
procedure IrAlBordeDeZonaDeNumeros(dir)
/*

### Cap. 331 — PRECONDICIONES:

# PROP´OSITO:

ir al borde dir de la zona de n´umeros actual

### Cap. 332 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* se encuentra dentro de una zona de n´umeros
* dir es Este u Oeste (no tiene sentido que sea
Norte o Sur, porque las zonas de n´umeros tienen
altura 1)
*/
{
while(puedeMoverEnZonaDeNumeroAl(dir))
{ Mover(dir) }
}
//----------------------------------------------------
//----------------------------------------------------
function leerZonaDeNumeros()
/*

### Cap. 333 — PRECONDICIONES:

# PROP´OSITO:

devuelve un n´umero codificado en la zona de n´umeros
actual, si tal n´umero existe, o cero si no

### Cap. 334 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* est´a en el borde derecho de la zona de n´umeros
a leer

### Cap. 335 — PRECONDICIONES:

# OBSERVACIONES:

* se estructura como un recorrido sobre los d´ıgitos
codificados en la zona de n´umeros
* total guarda el n´umero le´ıdo hasta el momento
* posDig guarda la pr´oxima unidad a leer
*/

Secciones:
  # OBSERVACIONES:

### Cap. 336 — OBSERVACIONES:

# PROP´OSITO:

indica si en la celda actual hay un d´ıgito

### Cap. 337 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 264 of 312 --

265

### Cap. 338 — OBSERVACIONES:

# OBSERVACIONES:

* los d´ıgitos se indican con una bolita azul
y no tienen m´as de 9 bolitas negras
*/
{ return(nroBolitas(Azul)==1 && nroBolitas(Negro)<=9) }
//----------------------------------------------------
function leerDigito()
/*

### Cap. 339 — PRECONDICIONES:

# PROP´OSITO:

retorna el d´ıgito codificado en la celda actual

### Cap. 34 — {- PROP´OSITO:

# 3. Invocaci ´on de procedimientos con argumentos

### Cap. 340 — 10. Tipos de datos

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* hay un d´ıgito codificado en la celda actual

### Cap. 341 — OBSERVACIONES:

# OBSERVACIONES:

* los d´ıgitos se indican con una bolita azul
y dig negras (0<=dig<=9)
*/
{ return(nroBolitas(Negro)) }
//----------------------------------------------------
procedure GrabarNumeroEnZonaDeNumeros(numero)
/*
PROP´OSITO: guardar el n´umero dado en la zona de
n´umeros actual

### Cap. 342 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* est´a en la zona de n´umeros donde debe grabarse
*/
{
BorrarZonaDeNumeros()
IrAlBordeDeZonaDeNumeros(Este)
aGuardar := numero
while (aGuardar > 0)
{
GrabarDigitoEnCelda(aGuardar mod 10)
aGuardar := aGuardar div 10
Mover(Oeste)
}
}
//----------------------------------------------------
procedure GrabarDigitoEnCelda(dig)
/*

### Cap. 343 — OBSERVACIONES:

# PROP´OSITO:

agrega el d´ıgito dig codificado en la celda actual

### Cap. 344 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* dig es un d´ıgito (entre 0 y 9)
* est´a sobre un espacio libre (celda vac´ıa) de
una zona de n´umeros
*/
{ Poner(Azul); PonerN(Negro,dig) }
//---------------------------------------------------
//---------------------------------------------------
procedure BorrarZonaDeNumeros()
/*

### Cap. 345 — PRECONDICIONES:

# PROP´OSITO:

borra el contenido de la zona de n´umeros actual

### Cap. 346 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* se encuentra en la zona de n´umeros a borrar
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 265 of 312 --

266

### Cap. 347 — PRECONDICIONES:

# OBSERVACIONES:

* se estructura como un recorrido en la zona
de n´umeros
*/
{
IrAlBordeDeZonaDeNumeros(Este)
while(puedeMoverEnZonaDeNumeroAl(Oeste))
{
VaciarCelda()
Mover(Oeste)
}
VaciarCelda()
}
//---------------------------------------------------
//----------------------------------------------------
procedure AgregarDigitoAZonaDeNumerosPorIzq(dig)
/*

### Cap. 348 — PRECONDICIONES:

# PROP´OSITO:

agrega el d´ıgito dig codificado en la zona de
n´umeros actual

### Cap. 349 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* dig es un d´ıgito (entre 0 y 9)
* se encuentra en la zona de n´umeros donde debe
agregar el d´ıgito

### Cap. 35 — PRECONDICI´ON:

# 4. Uso de par ´ametros

### Cap. 350 — PRECONDICIONES:

# OBSERVACIONES:

* los d´ıgitos entran a la zona de izquierda a
derecha
* recorre los d´ıgitos de izq a der para
encontrar d´onde poner el d´ıgito
* los espacios libres solo pueden estar
a la derecha

Secciones:
  # OBSERVACIONES:

### Cap. 351 — 11. Utilidad de los tipos

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* el n´umero m´aximo codificado no excede la cantidad
de d´ıgitos disponibles
* se encuentra en la zona de n´umeros a incrementar

### Cap. 352 — PRECONDICIONES:

# OBSERVACIONES: Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez -- 266 of 312 -- 267 * usa el algoritmo usual de incremento con carry ("llevarme uno"), o sea un recorrido sobre los d Secciones: # OBSERVACIONES: Conclusión: OBSERVACIONES: Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez -- 266 of 312 -- 267 * usa el algoritmo usual de incremento con carry ("llevarme uno"), o sea un recorrido sobre los d´ıgitos a incrementar * puede fallar...

### Cap. 353 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* o bien no hay d´ıgito, o bien es un d´ıgito v´alido
(entre 0 y 9)

### Cap. 354 — OBSERVACIONES:

B.2.3.

Secciones:
  # OBSERVACIONES:

Conclusión: Operaciones de zonas espec´ıficas
/*=SECCI´ON 2.

### Cap. 355 — PRECONDICIONES:

# PROP´OSITO:

ir al origen de la zona de pr´oxima pieza

### Cap. 356 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 357 — PRECONDICIONES:

# OBSERVACIONES:

* esta zona est´a 2 al Oeste del origen de la
zona de juego y 1 al Norte
*/
{
IrAlOrigenDeZonaDeJuego()
MoverN(Oeste,2); MoverN(Norte, 1)
}
//----------------------------------------------------
procedure IrAlOrigenDeZonaDeSeleccion()
/*

### Cap. 358 — OBSERVACIONES:

# PROP´OSITO:

ir al origen de la zona de selecci´on

### Cap. 359 — /*=SECCI´ON 4=======================================*

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 36 — OBSERVACI´ON:

# 5. Requisitos a los par ´ametros

### Cap. 360 — PRECONDICIONES:

# OBSERVACIONES:

* 2 al Norte del origen de la zona de
pr´oxima pieza
*/
{
IrAlOrigenDeZonaDeProximaPieza()
MoverN(Norte,2)
}
//----------------------------------------------------
procedure IrAlOrigenDeZonaDeSemilla()
/*
PROP´OSITO: ir al origen de la zona de semilla

### Cap. 361 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 362 — 12. Operaciones primitivas de expresiones (por tipo)

# OBSERVACIONES:

* la semilla se codifica debajo de la zona
de piezas, todo a lo ancho
*/
{
IrAlOrigenDeZonaDeJuego()
MoverN(Sur, 2)
IrAlBordeDeZonaDeNumeros(Este)
}
//----------------------------------------------------
//----------------------------------------------------
function leerZonaDeProximaPieza()
/*

### Cap. 363 — PRECONDICIONES:

# PROP´OSITO:

devuelve un n´umero codificado en la zona de
pr´oxima pieza, si existe, o cero si no

### Cap. 364 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 365 — PRECONDICIONES:

# OBSERVACIONES:

* va a la zona de pr´oxima pieza y lee el
n´umero all´ı codificado
*/
{
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 268 of 312 --

269
IrAlOrigenDeZonaDeProximaPieza()
return(leerZonaDeNumeros())
}
//----------------------------------------------------
function leerZonaDeSeleccion()
/*

### Cap. 366 — OBSERVACIONES:

# PROP´OSITO:

devuelve un n´umero codificado en la zona de
selecci´on, si existe, o cero si no

### Cap. 367 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 368 — OBSERVACIONES:

# OBSERVACIONES:

* va a la zona de selecci´on y lee el
n´umero all´ı codificado
*/
{
IrAlOrigenDeZonaDeSeleccion()
return(leerZonaDeNumeros())
}
//----------------------------------------------------
function leerSemilla()
/*
PROP´OSITO: leer el valor de la semilla del tablero

### Cap. 369 — PRECONDICIONES:

# OBSERVACIONES:

* la semilla se codifica en la zona de semillas,
seg´un la codificaci´on de n´umeros en zonas
*/
{
IrAlOrigenDeZonaDeSemilla()
return(leerZonaDeNumeros())
}
//----------------------------------------------------
//---------------------------------------------------
procedure BorrarZonaDeProximaPieza()
/*

### Cap. 37 — {- PROP´OSITO:

# 6. Repetici ´on simple

Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 20 of 312 --

21

### Cap. 370 — OBSERVACIONES:

# PROP´OSITO:

borra el contenido de la zona de selecci´on

### Cap. 371 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 372 — OBSERVACIONES:

# OBSERVACIONES:

* se estructura como un recorrido en la zona
de selecci´on
*/
{
IrAlOrigenDeZonaDeProximaPieza()
BorrarZonaDeNumeros()
}
//---------------------------------------------------
procedure BorrarZonaDeSeleccion()
/*

### Cap. 373 — 13. Alternativa condicional

# PROP´OSITO:

borra el contenido de la zona de selecci´on

### Cap. 374 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 375 — OBSERVACIONES:

# OBSERVACIONES:

* se estructura como un recorrido en la zona
de selecci´on
*/
{
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 269 of 312 --

270
IrAlOrigenDeZonaDeSeleccion()
BorrarZonaDeNumeros()
}
//---------------------------------------------------
//----------------------------------------------------
procedure AgregarDigitoASeleccion(dig)
/*

### Cap. 376 — PRECONDICIONES:

# PROP´OSITO:

agrega el d´ıgito dig codificado en la zona de
selecci´on.

### Cap. 377 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* dig es un d´ıgito (entre 0 y 9)

### Cap. 378 — PRECONDICIONES:

# OBSERVACIONES:

* La operatoria var´ıa seg´un lo que ya haya
en dicha zona (agrega un d´ıgito a los ya
existentes, o borra los anteriores y deja
el nuevo como ´unico d´ıgito)
*/
{
IrAlOrigenDeZonaDeSeleccion()
AgregarDigitoAZonaDeNumerosPorIzq(dig)
}
//----------------------------------------------------
procedure IncrementarZonaDeProximaPieza()
/*
PROP´OSITO: incrementa el n´umero codificado en la
zona de c´odigo de pr´oxima pieza

### Cap. 379 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>
* el n´umero m´aximo codificado no excede la cantidad
de d´ıgitos disponibles

### Cap. 38 — PRECONDICI´ON:

# 7. Repetici ´on indexada

8. ´Indices

### Cap. 380 — PRECONDICIONES:

# OBSERVACIONES:

* puede fallar si excede el m´aximo representable
*/
{
IrAlOrigenDeZonaDeProximaPieza()
IncrementarZonaDeNumeros()
}
//----------------------------------------------------
procedure GrabarSemilla(semilla)
/*
PROP´OSITO: guardar la semilla dada como la semilla
del tablero

### Cap. 381 — OBSERVACIONES:

# OBSERVACIONES:

* la semilla se codifica en la zona de semillas,
seg´un la codificaci´on de n´umeros en zonas
*/
{
IrAlOrigenDeZonaDeSemilla()
GrabarNumeroEnZonaDeNumeros(semilla)
}
B.3. Operaciones sobre piezas

### Cap. 382 — PRECONDICIONES:

B.3.1.

Secciones:
  # /*=SECCI´ON 3=======================================*

Conclusión: Geometr´ıa de las piezas
/*=SECCI´ON 3.

### Cap. 383 — OBSERVACIONES:

# PRECONDICIONES:

* rotacion es una rotaci´on v´alida
(de 1 a 4 o con marca de 7 rojas)
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 271 of 312 --

272

### Cap. 384 — 14. Funciones simples

# OBSERVACIONES:

* el c´alculo se realiza de la siguiente forma
rotacion 1 2 3 4
. mod 4 1 2 3 0
. +1 2 3 4 1 // En sentido horario
rotacion 1 2 3 4
. + 2 3 4 5 6
. mod 4 3 0 1 2
. + 1 4 1 2 3 // En

Secciones:
  # OBSERVACIONES:

Conclusión: En sentido horario
rotacion 1 2 3 4
.

### Cap. 385 — PRECONDICIONES:

# PRECONDICIONES:

* tipoPieza es un tipo v´alido
* rotPieza es una rotaci´on v´alida

### Cap. 386 — OBSERVACIONES:

# OBSERVACIONES:

* realiza una selecci´on alternativa en base al
tipo de pieza
*/
{
switch (tipoPieza) to
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 272 of 312 --

273
1 -> { (

Secciones:
  # OBSERVACIONES:

### Cap. 387 — PRECONDICIONES:

# PRECONDICIONES:

* tipoPieza es un tipo v´alido
* rotPieza es una rotaci´on v´alida

### Cap. 388 — OBSERVACIONES:

# OBSERVACIONES:

* realiza una selecci´on alternativa en base al
tipo de pieza
*/
{
switch (tipoPieza) to
7 -> { (dirA,dirB,dirC) := diresDePiezaT(rotPieza) }
_ -> { }
return (dirA,dirB,dirC)
}
//-----------------------------------------------------
function diresDePiezaZ(rotPieza)
/*
PROP´OSITO: devolver las direcciones de una Z

### Cap. 389 — PRECONDICIONES:

# PRECONDICIONES:

* la rotaci´on es v´alida

### Cap. 39 — OBSERVACI´ON:

# 9. Uso de ´ındices

### Cap. 390 — OBSERVACIONES:

# OBSERVACIONES:

* en rotaci´on 1, Z es
Norte,Oeste -> ZZ <- Norte
XZ <- Este
donde la X representa al pivote y
las Zs a las dem´as secciones
*/
{
(dA,dB,dC1,dC2) := id(Este,Norte,Norte,Oeste)
(dA,dB,dC1,dC2) := ajustarDires(dA,dB,dC1,dC2,rotPieza)
return (dA,dB,dC1,dC2)
}
//-----------------------------------------------------
function diresDePiezaI(rotPieza)
/*
PROP´OSITO: devolver las direcciones de una I

### Cap. 391 — PRECONDICIONES:

# PRECONDICIONES:

* la rotaci´on es v´alida

### Cap. 392 — OBSERVACIONES:

# OBSERVACIONES:

Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 273 of 312 --

274
* en rotaci´on 1, I es
Norte -> I
X
I <- Sur
I <- Sur,Sur
donde la X representa al pivote y
las Is a las dem´as secciones
*/
{
(dA,dB,dC1,dC2) := id(Sur,Norte,Sur,Sur)
(dA,dB,dC1,dC2) := ajustarDires(dA,dB,dC1,dC2,rotPieza)
return (dA,dB,dC1,dC2)
}
//-----------------------------------------------------
function diresDePiezaL(rotPieza)
/*
PROP´OSITO: devolver las direcciones de una L

### Cap. 393 — PRECONDICIONES:

# PRECONDICIONES:

* la rotaci´on es v´alida

### Cap. 394 — OBSERVACIONES:

# OBSERVACIONES:

* en rotaci´on 1, L es
Norte -> L
X
Sur -> LL <- Sur,Este
donde la X representa al pivote y
las Ls a las dem´as secciones
*/
{
(dA,dB,dC1,dC2) := id(Norte,Sur,Sur,Este)
(dA,dB,dC1,dC2) := ajustarDires(dA,dB,dC1,dC2,rotPieza)
return (dA,dB,dC1,dC2)
}
//-----------------------------------------------------
function diresDePiezaF(rotPieza)
/*
PROP´OSITO: devolver las direcciones de una F

### Cap. 395 — 15. Invocaci ´on de funciones simples

# PRECONDICIONES:

* la rotaci´on es v´alida

### Cap. 396 — PRECONDICIONES:

# OBSERVACIONES:

* en rotaci´on 1, F es
Norte -> FF <- Norte,Este
X
F <- Sur
donde la X representa al pivote y
las Fs a las dem´as secciones
*/
{
(dA,dB,dC1,dC2) := id(Norte,Sur,Norte,Este)
(dA,dB,dC1,dC2) := ajustarDires(dA,dB,dC1,dC2,rotPieza)
return (dA,dB,dC1,dC2)
}
//-----------------------------------------------------
function diresDePiezaO(rotPieza)
/*
PROP´OSITO: devolver las direcciones de una O

### Cap. 397 — OBSERVACIONES:

# PRECONDICIONES:

* la rotaci´on es v´alida

### Cap. 398 — PRECONDICIONES:

# OBSERVACIONES:

* en rotaci´on 1, O es
Norte -> OO <- Norte,Este
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 274 of 312 --

275
XO <- Este
donde la X representa al pivote y
las Os a las dem´as secciones
*/
{
(dA,dB,dC1,dC2) := id(Norte,Este,Norte,Este)
(dA,dB,dC1,dC2) := ajustarDires(dA,dB,dC1,dC2,rotPieza)
return (dA,dB,dC1,dC2)
}
//-----------------------------------------------------
function diresDePiezaS(rotPieza)
/*
PROP´OSITO: devolver las direcciones de una S

### Cap. 399 — OBSERVACIONES:

# PRECONDICIONES:

* la rotaci´on es v´alida

### Cap. 40 — {- PROP´OSITO:

# 10. Tipos de datos

### Cap. 400 — PRECONDICIONES:

# OBSERVACIONES:

* en rotaci´on 1, S es
Norte -> SS <- Norte,Este
Oeste -> SX
donde la X representa al pivote y
las Ss a las dem´as secciones
*/
{
(dA,dB,dC1,dC2) := id(Norte,Oeste,Norte,Este)
(dA,dB,dC1,dC2) := ajustarDires(dA,dB,dC1,dC2,rotPieza)
return (dA,dB,dC1,dC2)
}
//-----------------------------------------------------
function diresDePiezaT(rotPieza)
/*
PROP´OSITO: devolver las direcciones de una T

### Cap. 401 — OBSERVACIONES:

# PRECONDICIONES:

* la rotaci´on es v´alida

### Cap. 402 — PRECONDICIONES:

# OBSERVACIONES: * en rotaci´on 1, T es Oeste -> TXT <- Este T <- Sur donde la X representa al pivote y las Ts a las dem´as secciones * se usa una direcci´on dD como dummy para reutilizar ajustarDire Secciones: # OBSERVACIONES: Conclusión: OBSERVACIONES: * en rotaci´on 1, T es Oeste -> TXT <- Este T <- Sur donde la X representa al pivote y las Ts a las dem´as secciones * se usa una direcci´on dD como dummy...

### Cap. 403 — OBSERVACIONES:

B.3.2.

Secciones:
  # PRECONDICIONES:

Conclusión: Detecci ´on de piezas
/*=SECCI´ON 3.

### Cap. 404 — PRECONDICIONES:

# PRECONDICIONES:

* la celda actual es el pivote de una pieza
*/
{ return (nroBolitas(Verde)) }
//----------------------------------------------------
function leerTipoDePiezaActual()
/*
PROP´OSITO: determinar el tipo de la pieza actual

### Cap. 405 — OBSERVACIONES:

# PRECONDICIONES:

* la celda actual es el pivote de una pieza
*/
{ return (nroBolitas(Negro)) }
//----------------------------------------------------
function leerRotacionDePiezaActual()
/*
PROP´OSITO: determinar la rotaci´on de la pieza actual

### Cap. 406 — 16. Funciones con par ´ametros

# PRECONDICIONES:

Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 277 of 312 --

278
* la celda actual es el pivote de una pieza
*/
{ return (nroBolitas(Rojo)) }
//----------------------------------------------------
//----------------------------------------------------
function hayLugarParaPiezaTipo(tipoPieza, rotPieza)
/*
PROP´OSITO: informar si hay lugar en el tablero
para colocar una pieza de tipo tipoPieza
y rotaci´on rotPieza con pivote en la
celda actual

### Cap. 407 — /*=SECCI´ON 5=======================================*

# PRECONDICIONES:

* tipoPieza es un tipo de pieza v´alido
* rotPieza es una rotaci´on v´alida

### Cap. 408 — PRECONDICIONES:

# OBSERVACIONES:

* puede no haber lugar porque se acaba el tablero
o porque est´a ocupada
*/
{
if (esClaseA(tipoPieza))
{
(dirA,dirB,dirC1,dirC2)
:= diresDePiezaClaseA(tipoPieza,rotPieza)
hayL := hayLgPzClaseAEnDires(dirA,dirB,dirC1,dirC2)
}
else // Si no es clase A, es clase B
{
(dirA,dirB,dirC)
:= diresDePiezaClaseB(tipoPieza,rotPieza)
hayL := hayLgPzClaseBEnDires(dirA,dirB,dirC)
}
return (hayL)
}
//----------------------------------------------------
function hayLgPzClaseAEnDires(dirA,dirB,dirC1,dirC2)
/*
PROP´OSITO: completar el trabajo de hayLugarParaPiezaTipo
para las piezas de clase A

### Cap. 409 — OBSERVACIONES:

# PRECONDICIONES:

* est´a parado sobre el lugar en el que va el pivote
de la pieza
* las direcciones dadas codifican la pieza
correctamente
*/
{
return(esCeldaLibre()
&& hayCeldaLibreAl(dirA)
&& hayCeldaLibreAl(dirB)
&& hayCeldaLibreAlY(dirC1,dirC2))
}
//----------------------------------------------------
function hayLgPzClaseBEnDires(dirA,dirB,dirC)
/*
PROP´OSITO: completar el trabajo de hayLugarParaPiezaTipo
para las piezas de clase B

### Cap. 41 — PRECONDICI´ON:

# 11. Utilidad de los tipos

### Cap. 410 — OBSERVACIONES:

# PRECONDICIONES:

* est´a parado sobre el lugar en el que va el pivote
de la pieza
* las direcciones dadas codifican la pieza
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 278 of 312 --

279
correctamente
*/
{
return(esCeldaLibre()
&& hayCeldaLibreAl(dirA)
&& hayCeldaLibreAl(dirB)
&& hayCeldaLibreAl(dirC))
}
//-----------------------------------------------------
function esCeldaLibre()
/*
PROP´OSITO: determinar si la celda actual es una
celda libre

### Cap. 411 — OBSERVACIONES:

# PRECONDICIONES:

* la celda actual se encuentra en la zona de
juego

### Cap. 412 — OBSERVACIONES:

# OBSERVACIONES:

* abstrae a la funci´on de Biblioteca que verifica
si una celda est´a vac´ıa
*/
{ return (esCeldaVacia()) }
//-----------------------------------------------------
function hayCeldaLibreAl(dir)
/*
PROP´OSITO: determinar si hay una celda libre en la
zona de juego, en la direcci´on indicada
por dir

### Cap. 413 — OBSERVACIONES:

# PRECONDICIONES:

* la celda actual se encuentra en la zona de
juego

### Cap. 414 — PRECONDICIONES:

# OBSERVACIONES:

* es libre si hay celda y no tiene pieza
*/
{
return (puedeMoverEnZonaDeJuego(dir)
&& esCeldaVaciaAl(dir))
}
//-----------------------------------------------------
function hayCeldaLibreAlY(dir1,dir2)
/*
PROP´OSITO: determinar si hay una celda libre en la
zona de juego, en la direcci´on indicada
por las direcciones dir1 y dir2

### Cap. 415 — OBSERVACIONES:

# PRECONDICIONES:

* la celda actual se encuentra en la zona de
juego
* las direcciones dadas no se "cancelan" mutuamente
(por ejemplo, no son Norte y Sur o Este y Oeste)

### Cap. 416 — OBSERVACIONES:

# OBSERVACIONES:

* es libre si hay celda y no tiene pieza
*/
{
if (puedeMoverEnZonaDeJuego(dir1))
{ Mover(dir1)
if (puedeMoverEnZonaDeJuego(dir2))
{ Mover(dir2)
celdaLibre := esCeldaLibre() }
else { celdaLibre := False }} -- No existe la celda2
else { celdaLibre := False } -- No existe la celda1
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 279 of 312 --

280
return (celdaLibre)
}
B.4. Operaciones de procesamiento de piezas

### Cap. 417 — 17. Invocaci ´on de funciones con argumentos

# /*=SECCI´ON 4=======================================*

* Procesamiento de piezas *
*=================================================*
// 4.1 procedure IrAPiezaSiExiste(codPieza)
// 4.2 procedure ColocarPieza(codPieza, tipoPieza, rotPieza)
// procedure QuitarPiezaActual()
// 4.3 Operaciones de movimiento de piezas
*=================================================*/
B.4.1. Operaci ´on de localizaci ´on de una pieza
/*=SECCI´ON 4.1=====================================*
* Procesamiento de piezas (IrAPiezaSiExiste) *
*=================================================*
// procedure IrAPiezaSiExiste(codPieza)
*=================================================*/
//----------------------------------------------------
procedure IrAPiezaSiExiste(codPieza)
/*
PROP´OSITO: va a la celda pivote de la pieza de
c´odigo codPieza, si existeexiste

### Cap. 418 — OBSERVACIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 419 — OBSERVACIONES:

B.4.2.

Secciones:
  # OBSERVACIONES:

Conclusión: Operaciones para colocar una pieza
/*=SECCI´ON 4.

### Cap. 42 — {- PROP´OSITO:

# 12. Operaciones primitivas de expresiones (por tipo)

### Cap. 420 — OBSERVACIONES:

# PRECONDICIONES:

* no hay otra pieza codPieza en el tablero
* hay lugar para colocar la pieza
* tipoPieza es un tipo v´alido
* rotPieza es una rotaci´on v´alida

### Cap. 421 — OBSERVACIONES:

# OBSERVACIONES:

* la celda actual ser´a el centro de la pieza
codPieza
* la pieza codPieza ser´a de tipo tipoPieza
* la rotaci´on estar´a dada por rotPieza
* la celda actual queda en el mismo lugar

Secciones:
  # OBSERVACIONES:

### Cap. 422 — PRECONDICIONES:

# PRECONDICIONES:

* hay lugar para colocar la pieza
* no hay otra pieza de c´odigo codPieza en el
tablero
* rotPieza es una rotaci´on v´alida
* tipoPieza es un tipo v´alido
* las direcciones coinciden con el tipoPieza

### Cap. 423 — PRECONDICIONES:

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
ColocarPivote(codPieza,tipoPieza,rotPieza)
ColocarSeccionDePiezaEn(codPieza,dirA)
ColocarSeccionDePiezaEn(codPieza,dirB)
ColocarSeccionDePiezaEnY(codPieza,dirC1,dirC2)
}
//----------------------------------------------------
procedure ColocarPzClaseB(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC)
/*
PROP´OSITO: completar el trabajo de ColocarPieza
para las piezas de clase B

### Cap. 424 — OBSERVACIONES:

# PRECONDICIONES:

* hay lugar para colocar la pieza
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 281 of 312 --

282
* no hay otra pieza de c´odigo codPieza en el
tablero
* rotPieza es una rotaci´on v´alida
* tipoPieza es un tipo v´alido
* las direcciones coinciden con el tipoPieza

### Cap. 425 — OBSERVACIONES:

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
ColocarPivote(codPieza,tipoPieza,rotPieza)
ColocarSeccionDePiezaEn(codPieza,dirA)
ColocarSeccionDePiezaEn(codPieza,dirB)
ColocarSeccionDePiezaEn(codPieza,dirC)
}
//-----------------------------------------------------
procedure ColocarSeccionDePieza(codPieza)
/*
PROP´OSITO: coloca una secci´on de la pieza codPieza

### Cap. 426 — PRECONDICIONES:

# PRECONDICIONES:

* la celda actual est´a libre
* no hay otra pieza codPieza en el tablero

### Cap. 427 — OBSERVACIONES:

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{ PonerN(Verde,codPieza) }
//-----------------------------------------------------
procedure ColocarPivote(codPieza, tipoPieza, rotPieza)
/*
PROP´OSITO: coloca el pivote de la pieza codPieza

### Cap. 428 — 18. Funciones con procesamiento

# PRECONDICIONES:

* la celda actual est´a libre
* no hay otra pieza codPieza en el tablero
* tipoPieza es un tipo v´alido
* rotPieza es una rotaci´on v´alida

### Cap. 429 — PRECONDICIONES:

# OBSERVACIONES:

* la celda actual ser´a el centro de la pieza
codPieza
* la pieza codPieza ser´a de tipo tipoPieza
* la rotaci´on estar´a dada por rotPieza
* la celda actual queda en el mismo lugar que
empez´o
*/
{
ColocarSeccionDePieza(codPieza)
PonerN(Negro,tipoPieza)
PonerN(Rojo,rotPieza)
}
//-----------------------------------------------------
procedure ColocarSeccionDePiezaEn(codPieza,dir)
/*
PROP´OSITO: coloca una secci´on de la pieza codPieza
en la celda lindante al dir

### Cap. 43 — 4. Comandos primitivos (Poner)

# 13. Alternativa condicional

### Cap. 430 — OBSERVACIONES:

# PRECONDICIONES:

* la celda lindante al dir existe y est´a libre
* no hay otra pieza codPieza en el tablero

### Cap. 431 — PRECONDICIONES:

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 282 of 312 --

283
*/
{
Mover(dir)
ColocarSeccionDePieza(codPieza)
Mover(opuesto(dir))
}
//-----------------------------------------------------
procedure ColocarSeccionDePiezaEnY(codPieza,dir1,dir2)
/*
PROP´OSITO: coloca una secci´on de la pieza codPieza
en la celda lindante al dir1 y dir2

### Cap. 432 — OBSERVACIONES:

# PRECONDICIONES:

* la celda lindante mencionada existe y est´a libre
* no hay otra pieza codPieza en el tablero

### Cap. 433 — PRECONDICIONES:

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
Mover(dir1);Mover(dir2)
ColocarSeccionDePieza(codPieza)
Mover(opuesto(dir1));Mover(opuesto(dir2))
}
B.4.3. Operaciones para quitar una pieza
/*=SECCI´ON 4.2.2===================================*
* Procesamiento de piezas (QuitarPiezaActual) *
*=================================================*
// procedure QuitarSeccionDePiezaActual()
// procedure QuitarPiezaActual()
// procedure QuitarPzClaseA(codPieza,tipoPieza,rotPieza
// ,dirA,dirB,dirC1,dirC2)
// procedure QuitarPzClaseB(codPieza,tipoPieza,rotPieza
// ,dirA,dirB,dirC)
// procedure QuitarSeccionDePieza(codPieza)
// procedure QuitarPivote(codPieza,tipoPieza,rotPieza)
// procedure QuitarSeccionDePiezaDe(codPieza,dir)
// procedure QuitarSeccionDePiezaDeY(codPieza,dir1,dir2)
*=================================================*/
//----------------------------------------------------
//-----------------------------------------------------
procedure QuitarSeccionDePiezaActual()
/*
PROP´OSITO: quita una secci´on de la pieza actual

### Cap. 434 — PRECONDICIONES:

# PRECONDICIONES:

* la celda es una secci´on de pieza

### Cap. 435 — OBSERVACIONES:

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
SacarTodasLasDeColor(Verde)
SacarTodasLasDeColor(Negro)
SacarTodasLasDeColor(Rojo)
}
//-----------------------------------------------------
//-----------------------------------------------------
procedure QuitarPiezaActual()
/*
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 283 of 312 --

284
PROP´OSITO: quita la pieza actual del tablero

### Cap. 436 — PRECONDICIONES:

# PRECONDICIONES:

* la celda actual es el pivote de una pieza
* la pieza no est´a marcada

### Cap. 437 — OBSERVACIONES:

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
codPieza := leerCodigoDePiezaActual()
tipoPieza := leerTipoDePiezaActual()
rotPieza := leerRotacionDePiezaActual()
if (esClaseA(tipoPieza))
{
(dirA,dirB,dirC1,dirC2)
:= diresDePiezaClaseA(tipoPieza,rotPieza)
QuitarPzClaseA(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC1,dirC2)
}
else // Si no es clase A, es clase B
{
(dirA,dirB,dirC)
:= diresDePiezaClaseB(tipoPieza,rotPieza)
QuitarPzClaseB(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC)
}
}
//----------------------------------------------------
procedure QuitarPzClaseA(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC1,dirC2)
/*
PROP´OSITO: completar el trabajo de QuitarPieza
para las piezas de clase A

### Cap. 438 — PRECONDICIONES:

# PRECONDICIONES:

* hay celdas de la pieza en los lugares correctos
* rotPieza es una rotaci´on v´alida
* tipoPieza es un tipo v´alido
* las direcciones coinciden con el tipoPieza
* la pieza no est´a marcada

### Cap. 439 — 1. Alternativa indexada

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
QuitarPivote(codPieza,tipoPieza,rotPieza)
QuitarSeccionDePiezaDe(codPieza,dirA)
QuitarSeccionDePiezaDe(codPieza,dirB)
QuitarSeccionDePiezaDeY(codPieza,dirC1,dirC2)
}
//----------------------------------------------------
procedure QuitarPzClaseB(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC)
/*
PROP´OSITO: completar el trabajo de QuitarPieza
para las piezas de clase B

### Cap. 44 — PRECONDICI´ON:

# 14. Funciones simples

### Cap. 440 — OBSERVACIONES:

# PRECONDICIONES:

* hay celdas de la pieza en los lugares correctos
* rotPieza es una rotaci´on v´alida
* tipoPieza es un tipo v´alido
* las direcciones coinciden con el tipoPieza
* la pieza no est´a marcada
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 284 of 312 --

285

### Cap. 441 — PROP´OSITO:

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
QuitarPivote(codPieza,tipoPieza,rotPieza)
QuitarSeccionDePiezaDe(codPieza,dirA)
QuitarSeccionDePiezaDe(codPieza,dirB)
QuitarSeccionDePiezaDe(codPieza,dirC)
}
//-----------------------------------------------------
procedure QuitarSeccionDePieza(codPieza)
/*
PROP´OSITO: quita una secci´on de la pieza codPieza

### Cap. 442 — PRECONDICIONES:

# PRECONDICIONES:

* la celda es una secci´on de la pieza codPieza

### Cap. 443 — OBSERVACIONES:

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{ SacarN(Verde,codPieza) }
//-----------------------------------------------------
procedure QuitarPivote(codPieza, tipoPieza, rotPieza)
/*
PROP´OSITO: quita el pivote de la pieza codPieza

### Cap. 444 — PROP´OSITO:

# PRECONDICIONES:

* hay celdas de la pieza en los lugares correctos
* tipoPieza es un tipo v´alido
* rotPieza es una rotaci´on v´alida
* la pieza no est´a marcada

### Cap. 445 — PRECONDICIONES:

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
QuitarSeccionDePieza(codPieza)
SacarN(Negro,tipoPieza)
SacarN(Rojo,rotPieza)
}
//-----------------------------------------------------
procedure QuitarSeccionDePiezaDe(codPieza,dir)
/*
PROP´OSITO: quita una secci´on de la pieza codPieza
en la celda lindante al dir

### Cap. 446 — OBSERVACIONES:

# PRECONDICIONES:

* la celda lindante al dir es una secci´on de
la pieza codPieza

### Cap. 447 — PROP´OSITO:

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
Mover(dir)
QuitarSeccionDePieza(codPieza)
Mover(opuesto(dir))
}
//-----------------------------------------------------
procedure QuitarSeccionDePiezaDeY(codPieza,dir1,dir2)
/*
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 285 of 312 --

286
PROP´OSITO: quitar una secci´on de la pieza codPieza
en la celda lindante al dir1 y dir2

### Cap. 448 — PRECONDICIONES:

# PRECONDICIONES:

* la celda lindante al dir1 y dir2 es una secci´on de
la pieza codPieza

### Cap. 449 — OBSERVACIONES:

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
Mover(dir1);Mover(dir2)
QuitarSeccionDePieza(codPieza)
Mover(opuesto(dir1));Mover(opuesto(dir2))
}
B.4.4. Operaciones de movimiento de piezas
/*=SECCI´ON 4.3=====================================*
* Operaciones de movimiento de piezas *
*=================================================*
// function puedeMoverPiezaActual(dir)
// procedure MoverPiezaActual(dir)
//
// function puedeBajarPiezaActual()
// procedure BajarPiezaActual()
//
// procedure RotarPiezaActual(rotacionSentidoHorario)
*=================================================*/
//-----------------------------------------------------
//-----------------------------------------------------
function puedeMoverPiezaActual(dir)
/*
PROP´OSITO: determina si la pieza actual se puede
mover en la direcci´on dir

### Cap. 45 — OBSERVACI´ON:

# 15. Invocaci ´on de funciones simples

### Cap. 450 — 2. Repetici ´on condicional

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 451 — PROP´OSITO:

# OBSERVACIONES:

* para saber si puede mover, se la quita y se
determina si hay lugar en la celda
correspondiente (si es que existe)
* si no hay pieza, no la puede mover...
*/
{
if (esSeccionPivoteDe

Secciones:
  # OBSERVACIONES:

Conclusión: OBSERVACIONES:

* para saber si puede mover, se la quita y se
determina si hay lugar en la celda
correspondiente (si es que existe)
* si no hay pieza, no la puede mover.

### Cap. 452 — PRECONDICIONES:

# PRECONDICIONES:

* la celda actual est´a sobre el pivote de una
pieza

### Cap. 453 — OBSERVACIONES:

# OBSERVACIONES:

* para mover una pieza se la quita toda y se la
pone de nuevo en el nuevo lugar, si hay lugar
* la celda actual queda en el pivote de la pieza
ya sea que se movi´o o no
*/
{
codPieza

Secciones:
  # OBSERVACIONES:

### Cap. 454 — PROP´OSITO:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 455 — PRECONDICIONES:

# OBSERVACIONES:

* para saber su puede bajar, se la quita y se determina
si hay lugar una celda m´as abajo (si es que hay
celda m´as abajo)
* si no hay pieza, no la puede bajar...
*/
{ return (puedeMoverPiezaActual(Sur)) }
//-----------------------------------------------------
procedure BajarPiezaActual()
/*
PROP´OSITO: baja la pieza actual

### Cap. 456 — OBSERVACIONES:

# PRECONDICIONES:

* la celda actual es el pivote de una pieza
* la pieza actual se puede bajar

### Cap. 457 — PROP´OSITO:

# OBSERVACIONES:

* para bajar una pieza se la quita toda y se la
pone m´as abajo (se puede porque se pregunta si
se puede bajar antes, y entonces hay lugar)
* la celda actual queda en el pivote de la pieza
*/
{ MoverPiezaActual(Sur) }
//-----------------------------------------------------
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 287 of 312 --

288
procedure RotarPiezaActual(sentidoHorario)
/*
PROP´OSITO: rotar la pieza actual, si se puede
o nada si no se puede

### Cap. 458 — PRECONDICIONES:

# PRECONDICIONES:

* la celda actual est´a sobre el pivote de una
pieza

### Cap. 459 — OBSERVACIONES:

# OBSERVACIONES:

* para rotar una pieza se la quita toda y se la
pone rotada,si hay lugar
* la celda actual queda en el mismo lugar que
empez´o
*/
{
codPieza := leerCodigoDePiezaActual()
tipoPieza := leerTipoDePiezaActual()
rotPieza := leerRotacionDePiezaActual()
nuevaRot := rotar(rotPieza, sentidoHorario)
QuitarPiezaActual()
if (hayLugarParaPiezaTipo(tipoPieza,nuevaRot))
{ ColocarPieza(codPieza, tipoPieza, nuevaRot) }
else
{ ColocarPieza(codPieza, tipoPieza, rotPieza) }
}
B.5. Operaciones de la mec ´anica del juego

### Cap. 46 — {- PROP´OSITO:

# 16. Funciones con par ´ametros

### Cap. 460 — PROP´OSITO:

# /*=SECCI´ON 5=======================================*

* Mec´anica del juego *
*=================================================*
// 5.1 procedure ColocarNuevaPieza(codPieza,tipoPieza,ubicacion)
// 5.2 procedure BajarPiezasDeZonaDeJuego()
// 5.3 procedure ExtenderElPiso()
// 5.4 procedure EliminarFilasLlenas()
// 5.5 procedure GenerarLogoZILFOST()
*=================================================*/
B.5.1. Operaci ´on de colocar nueva pieza
/*=SECCI´ON 5.1=======================================*
* Operaciones del juego (ColocarNuevaPieza) *
*===================================================*
// procedure ColocarNuevaPieza(codPieza,tipoPieza,ubicacion)
*===================================================*/
//-----------------------------------------------------
procedure ColocarNuevaPieza(codPieza,tipoPieza,ubicacion)
/*
PROP´OSITO: coloca una nueva pieza de c´odigo
codPieza y tipo tipoPieza en la zona de
juego, en la columna indicada por
ubicacion

### Cap. 461 — 3. Esquemas de recorrido

# PRECONDICIONES:

* la pieza codPieza no existe en la zona de juego
* ubicaci´on es mayor o igual a 0 y menor que el
ancho de la zona de juego

### Cap. 462 — PRECONDICIONES:

B.5.2.

Secciones:
  # OBSERVACIONES:

Conclusión: Procesamiento del juego (BajarPiezas.

### Cap. 463 — OBSERVACIONES:

# OBSERVACIONES:

* al bajar piezas se puede generar nuevo piso
y por eso se invoca a la operaci´on de extender
el piso
*/
{
UnicamenteBajarPiezas()
ExtenderElPiso()
}
//-----------------------------------------------------
procedure UnicamenteBajarPiezas()
/*
PROP´OSITO: bajar un lugar todas las piezas que
pueden bajar

### Cap. 464 — PRECONDICIONES:

# OBSERVACIONES:

* luego de bajar una pieza, la misma se marca
para no volver a procesarla
* esto es necesario cuando hay varias piezas
bajables que se enciman y unas bloquean a
otras para bajar
Ej:

Secciones:
  # OBSERVACIONES:

### Cap. 465 — PRECONDICIONES:

# OBSERVACIONES:

* se estructura como un recorrido de b´usqueda
sobre las celdas de la zona de juego
* si no hay pieza, no hay marca y no puede bajar
con lo cual sigue buscando
* si para, es porque e

Secciones:
  # OBSERVACIONES:

### Cap. 466 — PRECONDICIONES:

# OBSERVACIONES:

la marca de 7 se superpone con la
codificaci´on de giro (de 1 a 4), por eso
pregunta por mayor
*/
{ return (nroBolitas(Rojo)>7) }
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 290 of 312 --

291
//-----------------------------------------------------
//-----------------------------------------------------
procedure MarcarPiezaActual()
/*
PROP´OSITO: marcar la pieza actual

### Cap. 467 — OBSERVACIONES:

# PRECONDICIONES:

* la celda actual es el pivote de una pieza
y la misma no est´a marcada

### Cap. 468 — /*=SECCI´ON 6=======================================*

# OBSERVACIONES:

* se marca con 7 bolitas rojas (verificar que
otras marcas no usen esta misma codificaci´on)
*/
{ PonerN(Rojo,7) }
//-----------------------------------------------------
procedure QuitarMarcasDePiezas()
/*
PROP´OSITO: quita todas las marcas de las piezas

### Cap. 469 — OBSERVACIONES:

# OBSERVACIONES:

* se estructura como un recorrido sobre las
celdas de la zona de juego, quitando todas
las marcas de pieza
*/
{
// Iniciar recorrido NE en la zona de juego
IrAlOrigenDeZonaDeJuego()
while (not esFinDelRecorridoNEDeZonaDeJuego())
{
// Procesar es sacar la marca de pieza, si existe
DesmarcarPiezaActualSiHay()
AvanzarEnRecorridoNEDeZonaDeJuego()
}
// Procesar ´ultimo
DesmarcarPiezaActualSiHay()
}
//-----------------------------------------------------
procedure DesmarcarPiezaActualSiHay()
/*
PROP´OSITO: desmarcar la pieza actual, si existe
y est´a marcada; si no, no hacer nada

### Cap. 47 — PRECONDICI´ON:

# 17. Invocaci ´on de funciones con argumentos

### Cap. 470 — PROP´OSITO:

B.5.3.

Secciones:
  # OBSERVACIONES:

Conclusión: Operaciones para extender el piso
/*=SECCI´ON 5.

### Cap. 471 — PROP´OSITO:

# OBSERVACIONES: * no hace falta procesar el ´ultimo elemento pues seguro est´a en la fila m´as al Norte y no puede tener nada encima * se estructura como un recorrido NE sobre celdas * para cada cel Secciones: # OBSERVACIONES: Conclusión: OBSERVACIONES: * no hace falta procesar el ´ultimo elemento pues seguro est´a en la fila m´as al Norte y no puede tener nada encima * se estructura como un recorrido NE sobre celdas * para cada celda de...

### Cap. 472 — 4. Variables

# OBSERVACIONES:

* se estructura como un recorrido sobre las celdas
de la zona de juego
*/
{
IrAlOrigenDeZonaDeJuego()
while (not esFinDelRecorridoNEDeZonaDeJuego())
{
if (esPiso()) { MarcarElPiso() }
AvanzarEnRecorridoNEDeZonaDeJuego()
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 292 of 312 --

293
}
if (esPiso()) { MarcarElPiso() }
}
//-----------------------------------------------------
procedure ExtenderElPisoEnLaFilaBase()
/*
PROP´OSITO: analiza si hay piezas en la fila
base que puedan estar en el piso, y las
convierte en piso

### Cap. 473 — PROP´OSITO:

# OBSERVACIONES:

* se estructura como un recorrido sobre las
celdas de la fila base
* las piezas se transforman a piso sin marcar
*/
{
IrAlOrigenDeZonaDeJuego()
while (puedeMoverEnZonaDeJuego(Este))

Secciones:
  # OBSERVACIONES:

Conclusión: OBSERVACI´ON: ¡no marca en la misma posici´on, porque
la misma va a cambiar!

### Cap. 474 — PROP´OSITO:

# PRECONDICIONES:

* hay una celda lindante al dir en la zona de
juego
*/
{
Mover(dir)
return(esPiso())
}
//-----------------------------------------------------
function esCeldaDePisoMarcada()
/*
PROP´OSITO: informa si la celda actual es piso con
marca de piso (simple)
*/
{ return(nroBolitas(Azul)>60) }
//-----------------------------------------------------
procedure MarcarElPiso()
/*
PROP´OSITO: marcar el piso
*/
{ PonerN(Azul,60) }
//-----------------------------------------------------
procedure DesmarcarElPiso()
/*
PROP´OSITO: desmarca el piso

### Cap. 475 — OBSERVACIONES:

# PRECONDICIONES:

* est´a sobre una celda de piso marcada
*/
{ SacarN(Azul,60) }
//-----------------------------------------------------
procedure IrACeldaDePisoMarcadaSiExiste()
/*
PROP´OSITO: va a una celda con marca de piso

### Cap. 476 — PROP´OSITO:

# OBSERVACIONES:

* si no hay celda con marca de piso, termina
en la ´ultima celda del recorrido NE de la
zona de juego
*/
{
IrAlOrigenDeZonaDeJuego()
while (not esFinDelRecorridoNEDeZonaDeJuego()
&& not esCeldaDePisoMarcada())
{ AvanzarEnRecorridoNEDeZonaDeJuego() }
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 294 of 312 --

295
//-----------------------------------------------------
procedure TransformarEnPisoSiEsPieza(marca)
/*
PROP´OSITO: transforma en piso a la pieza que
intersecciona con la celda actual,
si existe, y agrega la marca si
corresponde

### Cap. 477 — OBSERVACIONES:

# OBSERVACIONES:

* si no hay pieza, entonces no hace nada
*/
{
if (esSeccionDeAlgunaPieza())
{
IrAPiezaSiExiste(leerCodigoDePiezaActual())
TransformarEnPisoPiezaActual(marca)
}
}
//-----------------------------------------------------
procedure TransformarEnPisoPiezaActual(marca)
/*
PROP´OSITO: transforma en piso la pieza actual
y agrega la marca si corresponde

### Cap. 478 — OBSERVACIONES:

# PRECONDICIONES:

* la celda actual es el pivote de una pieza

### Cap. 479 — 5. Asignaci ´on

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
codPieza := leerCodigoDePiezaActual()
tipoPieza := leerTipoDePiezaActual()
rotPieza := leerRotacionDePiezaActual()
if (esClaseA(tipoPieza))
{
(dirA,dirB,dirC1,dirC2)
:= diresDePiezaClaseA(tipoPieza,rotPieza)
TransfPzClaseA(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC1,dirC2,marca)
}
else // Si no es clase A, es clase B
{
(dirA,dirB,dirC)
:= diresDePiezaClaseB(tipoPieza,rotPieza)
TransfPzClaseB(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC,marca)
}
}
//----------------------------------------------------
procedure TransfPzClaseA(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC1,dirC2,marca)
/*
PROP´OSITO: completar el trabajo de
TransformarEnPisoPiezaActual
para las piezas de clase A

### Cap. 48 — {- PROP´OSITO:

# 18. Funciones con procesamiento

Cap. 4

### Cap. 480 — 6. Uso de variables

# PRECONDICIONES:

* hay celdas de la pieza en los lugares correctos
* rotPieza es una rotaci´on v´alida
* tipoPieza es un tipo v´alido
* las direcciones coinciden con el tipoPieza

### Cap. 481 — 1957. Realiz ´o nu-

# OBSERVACIONES:

Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 295 of 312 --

296
* la celda actual queda en el mismo lugar que
empez´o
*/
{
TransformarCeldaEnPiso(marca)
TransformarCeldaEnPisoAl(dirA,marca)
TransformarCeldaEnPisoAl(dirB,marca)
TransformarCeldaEnPisoAlY(dirC1,dirC2,marca)
}
//----------------------------------------------------
procedure TransfPzClaseB(codPieza,tipoPieza,rotPieza
,dirA,dirB,dirC,marca)
/*
PROP´OSITO: completar el trabajo de
TransformarEnPisoPiezaActual
para las piezas de clase B

### Cap. 482 — 2007. Gan ´o diver-

# PRECONDICIONES:

* hay celdas de la pieza en los lugares correctos
* rotPieza es una rotaci´on v´alida
* tipoPieza es un tipo v´alido
* las direcciones coinciden con el tipoPieza

### Cap. 483 — 3. Dibujar

# OBSERVACIONES:

* la celda actual queda en el mismo lugar que
empez´o
*/
{
TransformarCeldaEnPiso(marca)
TransformarCeldaEnPisoAl(dirA, marca)
TransformarCeldaEnPisoAl(dirB, marca)
TransformarCeldaEnPisoAl(dirC, marca)
}
//-----------------------------------------------------
procedure TransformarCeldaEnPiso(marca)
/*
PROP´OSITO: transforma en piso la celda actual
y agrega la marca si corresponde

### Cap. 484 — 5. UnIdentificadorMasEntendible

# PRECONDICIONES:

* la celda es secci´on de una pieza
*/
{
QuitarSeccionDePiezaActual()
PonerPiso()
if (marca) { MarcarElPiso() }
}
//-----------------------------------------------------
procedure PonerPiso()
/*
PROP´OSITO: pone piso en la celda actual

### Cap. 485 — 6. UnIdentificadorTanLargoQueNoValeLaPenaNiPensarEnEscribirlo

# PRECONDICIONES:

* la celda est´a vac´ıa

### Cap. 486 — 7. DibujarCuadradoNegroDeLado3

# OBSERVACIONES:

* el piso se indica con 8 bolitas azules
*/
{ PonerN(Azul,8) }
//-----------------------------------------------------
procedure TransformarCeldaEnPisoAl(dir, marca)
/*
PROP´OSITO: transforma en piso la celda lindante
al dir si la misma es secci´on de pieza
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 296 of 312 --

297

### Cap. 487 — PROP´OSITO:

# PRECONDICIONES:

* hay una celda lindante al dir y es secci´on de
una pieza

### Cap. 488 — PRECONDICI´ON:

# OBSERVACIONES:

* no cambia la celda actual
*/
{
Mover(dir)
TransformarCeldaEnPiso(marca)
Mover(opuesto(dir))
}
//-----------------------------------------------------
procedure TransformarCeldaEnPisoAlY(dir1,dir2, marca)
/*
PROP´OSITO: transforma en piso la celda lindante
al dir1 y dir2 si la misma es secci´on
de pieza

### Cap. 489 — PROP´OSITO:

# PRECONDICIONES:

* hay una celda lindante en las dir1 y dir2
y es secci´on de una pieza

### Cap. 49 — PRECONDICI´ON:

# 1. Alternativa indexada

### Cap. 490 — PRECONDICI´ON:

# OBSERVACIONES:

* no cambia la celda actual
*/
{
Mover(dir1);Mover(dir2)
TransformarCeldaEnPiso(marca)
Mover(opuesto(dir1));Mover(opuesto(dir2))
}
B.5.4. Operaciones para eliminar filas llenas
/*=SECCI´ON 5.4=====================================*
* Procesamiento del juego (EliminarFilasLlenas) *
*=================================================*
// procedure EliminarFilasLlenas()
// procedure EliminarMientrasSigaLlena()
// function esFilaLlena()
// procedure BajarFilasSobreEsta()
// procedure BajarFilaSuperior()
// procedure VaciarDePisoLaFilaActual()
// procedure QuitarPiso()
*=================================================*/
//----------------------------------------------------
procedure EliminarFilasLlenas()
/*

### Cap. 491 — PROP´OSITO:

# PROP´OSITO:

eliminar todo el piso de las filas llenas de
la zona de juego, bajando el piso de las superiores
a la eliminada

### Cap. 492 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 493 — PRECONDICIONES:

# OBSERVACIONES:

* debe ir de abajo-arriba para no repetir trabajo
* se estructura como un recorrido sobre filas
*/
{
IrAlOrigenDeZonaDeJuego()
while(puedeMoverEnZonaDeJuego(Norte))
{
EliminarMientrasSigaLlena()
Mover(Norte)
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 297 of 312 --

298
}
// Procesa la fila m´as al Norte
EliminarMientrasSigaLlena()
}
//----------------------------------------------------
procedure EliminarMientrasSigaLlena()
/*

### Cap. 494 — PROP´OSITO:

# PROP´OSITO:

eliminar las secciones de piso de la fila
actual bajando las de piso que est´an sobre ella,
hasta que la fila actual no est´e llena

### Cap. 495 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 496 — PROP´OSITO:

# OBSERVACIONES:

* al bajar las filas sobre la actual, se borra
la que estaba, y la condici´on puede cambiar
* al terminar, la fila actual no est´a llena
*/
{
while (esFilaLlena())
{ BajarFilasSobreEsta() }
}
//----------------------------------------------------
function esFilaLlena()
/*

### Cap. 497 — PRECONDICIONES:

# PROP´OSITO:

determinar si la fila actual est´a llena de piso

### Cap. 498 — PROP´OSITO:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 499 — PRECONDICIONES:

# OBSERVACIONES:

* la variable esLlena indica si hasta el momento
se encontr´o evidencia que la fila no est´a
llena
* se estructura como un recorrido de b´usqueda
sobre las celdas de la fila actual
*/
{
IrAlBordeDeZonaDeJuego(Oeste)
esLlena := True
while(esLlena && puedeMoverEnZonaDeJuego(Este))
{
esLlena := esLlena && esPiso()
Mover(Este)
}
esLlena := esLlena && esPiso()
return(esLlena)
}
//----------------------------------------------------
procedure BajarFilasSobreEsta()
/*

### Cap. 50 — PRECONDICI´ON:

# 2. Repetici ´on condicional

### Cap. 500 — PROP´OSITO:

# PROP´OSITO:

bajar todas las filas de piso sobre la actual,
sobreescribiendo la fila actual,
solo en la zona de juego

### Cap. 501 — PRECONDICIONES:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 502 — PROP´OSITO:

# OBSERVACIONES:

* al bajar, se quita todo el piso de la fila
m´as al Norte
* el cabezal no se debe mover de la fila
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 298 of 312 --

2

Secciones:
  # OBSERVACIONES:

### Cap. 503 — PRECONDICIONES:

# PROP´OSITO:

duplica la fila sobre la actual en la actual
borrando el contenido de la fila actual,
solo en la zona de juego

### Cap. 504 — OBSERVACIONES:

# PRECONDICIONES:

* no est´a en la fila m´as al Norte

### Cap. 505 — PROP´OSITO:

# OBSERVACIONES:

* se estructura como un recorrido sobre
las celdas de la fila actual
* solo baja las celdas de piso; las de piezas
no se bajan
* Si al bajar el piso puede romper una pieza,
entonces no baja (y puede resultar "aplastado"
por otros pisos sobre ´el)
*/
{
IrAlBordeDeZonaDeJuego(Oeste)
while (puedeMoverEnZonaDeJuego(Este))
{
BajarCeldaAlNorte()
Mover(Este)
}
BajarCeldaAlNorte()
}
//----------------------------------------------------
procedure BajarCeldaAlNorte()
/*

### Cap. 506 — PRECONDICIONES:

# PROP´OSITO:

baja la celda al norte de la actual,
si corresponde

### Cap. 507 — OBSERVACIONES:

# PRECONDICIONES:

* no est´a en la fila m´as al Norte

### Cap. 508 — PROP´OSITO:

# OBSERVACIONES:

* solo baja las celdas de piso; las de piezas
no se bajan
* Si al bajar el piso puede romper una pieza,
entonces es absorvido (no rompe la pieza)
*/
{
if (not esSeccionDeAlgunaPieza(

Secciones:
  # OBSERVACIONES:

### Cap. 509 — 1. PonerN que deposite cant bolitas de color color en la celda actual, supo-

# PROP´OSITO:

vac´ıa la fila actual de piso de la zona
de juego

### Cap. 51 — {- PROP´OSITO:

# 3. Esquemas de recorrido

### Cap. 510 — 2. MoverN que se mueva cant celdas en la direcci ´on dir desde la celda actual,

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 511 — 3. SacarN que quite cant bolitas de color color de la celda actual, suponiendo

# OBSERVACIONES:

* se estructura como un recorrido sobre
las celdas de la fila actual
*/
{
IrAlBordeDeZonaDeJuego(Oeste)
while (puedeMoverEnZonaDeJuego(Este))
{
if (esPiso()) { QuitarPiso() }
Mover(Este)
}
if (esPiso()) { QuitarPiso() }
}
//-----------------------------------------------------
procedure QuitarPiso()
/*
PROP´OSITO: quita el piso de la celda actual

### Cap. 512 — PROP´OSITO:

# PRECONDICIONES:

* la celda actual tiene piso
*/
{ SacarN(Azul,8) }
B.5.5. Operaciones adicionales
/*=SECCI´ON 5.5=======================================*
* Operaciones adicionales *
*===================================================*
// procedure GenerarLogoZILFOST()
// procedure VaciarZonaDeJuego()
*===================================================*/
//----------------------------------------------------
procedure GenerarLogoZILFOST()
/*
PROP´OSITO: Dibuja ZILFOST con piezas

### Cap. 513 — PRECONDICI´ON:

# PRECONDICIONES:

* la zona de juego tiene un ancho m´ınimo de 9
*/
{
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 300 of 312 --

301
VaciarZonaDeJuego()
ColocarNuevaPieza(1,1,1)
ColocarNuevaPieza(6,6,6)
BajarPiezasDeZonaDeJuego()
BajarPiezasDeZonaDeJuego()
ColocarNuevaPieza(3,3,3)
ColocarNuevaPieza(5,5,5)
BajarPiezasDeZonaDeJuego()
BajarPiezasDeZonaDeJuego()
ColocarNuevaPieza(7,7,7)
BajarPiezasDeZonaDeJuego()
ColocarNuevaPieza(2,2,2)
ColocarNuevaPieza(4,4,4)
BajarPiezasDeZonaDeJuego()
BajarPiezasDeZonaDeJuego()
BajarPiezasDeZonaDeJuego()
}
//-----------------------------------------------------
procedure VaciarZonaDeJuego()
/*
PROP´OSITO: quita todas las piezas y el piso
de la zona de juego

### Cap. 514 — OBSERVACI´ON:

# PRECONDICIONES:

* default <hay un tablero de Zilfost codificado>

### Cap. 515 — parte 3: , y combinarlo con alguna de las expresiones reci ´en presentadas.

# OBSERVACIONES:

* se estructura como un recorrido sobre las
celdas de la zona de juego, quitando todas
las piezas
*/
{
// Iniciar recorrido NE en la zona de juego
IrAlOrigenDeZonaDeJuego()
while (not esFinDelRecorridoNEDeZonaDeJuego())
{
VaciarCelda()
AvanzarEnRecorridoNEDeZonaDeJuego()
}
VaciarCelda()
}
B.6. Operaciones de interfaz

### Cap. 516 — {- PROP´OSITO:

# /*=SECCI´ON 6=======================================*

* Operaciones para interfaz *
*=================================================*
// 6.1 function determinarNuevaPieza(semilla)
// 6.2 Operaciones de interacci´on
*=================================================*/
B.6.1. Determinar nueva pieza
/*=SECCI´ON 6.1======================================*
* Operaciones para interfaz (determinarNuevaPieza) *
*==================================================*
// function determinarNuevaPieza(semilla)
*==================================================*/
//----------------------------------------------------
function determinarNuevaPieza(semilla)
/*
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 301 of 312 --

302
PROP´OSITO: devolver c´odigo, tipo y ubicaci´on para
una nueva pieza de manera seudorand´omica
en base a una semilla. Tambi´en devuelve
la nueva semilla

### Cap. 517 — PRECONDICI´ON:

# OBSERVACIONES:

* la semilla de par´ametro se usa como semilla inicial
* el resultado de cada n´umero seudorand´omico generado
se usa como pr´oxima semilla, y el final se retorna
*/
{
(ubicacion,nuevaSemilla)
:= randomEntre0YConSemilla(anchoDeZonaDeJuego()-1
,semilla)
(tipoPieza,nuevaSemilla)
:= randomEntre0YConSemilla(6
,nuevaSemilla)
return(leerZonaDeProximaPieza(), tipoPieza+1
,ubicacion , nuevaSemilla)
}
B.6.2. Operaciones de interacci ´on
/*=SECCI´ON 6.2======================================*
* Operaciones de interacci´on *
*==================================================*
// procedure OperacionColocarNuevaPieza()
// procedure OperacionMoverPiezaAl(dir)
// procedure OperacionRotarPieza(sentidoHorario)
// procedure OperacionAgregarDigitoASeleccion(dig)
// procedure OperacionBajarPiezas()
*==================================================*/
//----------------------------------------------------
procedure OperacionColocarNuevaPieza()
/*

### Cap. 518 — {- PROP´OSITO:

# PROP´OSITO:

combinar las acciones necesarias para la aparici´on
de una nueva pieza en la zona de juego (si entra)
*/
{
semilla := leerSemilla()
(codPz,tipoPz,ubicPz,semilla) := determinarNuevaPieza(semilla)
GrabarSemilla(semilla)
ColocarNuevaPieza(codPz,tipoPz,ubicPz)
// Al exceder el m´aximo, vuelve a 1
IncrementarZonaDeProximaPieza()
BorrarZonaDeSeleccion()
}
//----------------------------------------------------
procedure OperacionMoverPiezaAl(dir)
/*

### Cap. 519 — PRECONDICI´ON:

# PROP´OSITO:

combinar las acciones necesarias para mover la
pieza indicada en la zona de selecci´on (si existe)
*/
{
IrAPiezaSiExiste(leerZonaDeSeleccion())
if (hayPiezaActual())
{ MoverPiezaActual(dir); ExtenderElPiso() }
BorrarZonaDeSeleccion()
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 302 of 312 --

303
//----------------------------------------------------
procedure OperacionRotarPieza(sentidoHorario)
/*

### Cap. 52 — PRECONDICI´ON:

# 4. Variables

### Cap. 520 — {- PROP´OSITO:

# PROP´OSITO:

combinar las acciones necesarias para rotar la
pieza indicada en la zona de selecci´on (si existe)
*/
{
IrAPiezaSiExiste(leerZonaDeSeleccion())
if (hayPiezaActual())
{ RotarPiezaActual(sentidoHorario); ExtenderElPiso() }
BorrarZonaDeSeleccion()
}
//----------------------------------------------------
procedure OperacionAgregarDigitoASeleccion(dig)
/*

### Cap. 521 — PRECONDICI´ON:

# PROP´OSITO:

agregar un d´ıgito a la selecci´on actual, y bajar
las piezas al terminar de ingresar un c´odigo v´alido

### Cap. 522 — OBSERVACI´ON:

# OBSERVACIONES:

* como los d´ıgitos se ingresan de izquierda a derecha
pero se leen de derecha a izquierda, determinar si
se complet´o el ingreso de un c´odigo v´alido se puede
realizar leyendo el n´umero y viendo que es distinto
de cero
*/
{
AgregarDigitoASeleccion(dig)
if (leerZonaDeSeleccion()/=0) // Al terminar de seleccionar
// una pieza, baja todas
{ BajarPiezasDeZonaDeJuego() }
}
//----------------------------------------------------
procedure OperacionBajarPiezas()
/*

### Cap. 523 — PROP´OSITO:

B.7. Secciones: # PROP´OSITO: Conclusión: Color()] { SacarTodasLasDeColor(color) } } //---------------------------------------------------- function esCeldaVacia() { return (not hayBolitas(Azul) && not hayBolitas(Negro) && not hayBolitas(Rojo) && not hayBolitas(Verde)) } //---------------------------------------------------- function esCeldaVaciaAl(dir) /* PRECONDICION: el cabezal puede moverse en direcci´on dir Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez -- 304 of 312 -- 305 */ { Mover(dir) return (esCeldaVacia()) } //---------------------------------------------------- function hayCeldaVaciaAl(dir) { return (puedeMover(dir) && esCeldaVaciaAl(dir)) } //---------------------------------------------------- //---------------------------------------------------- procedure IrALaEsquina(dir1,dir2) { IrAlBorde(dir1); IrAlBorde(dir2) } //---------------------------------------------------- procedure...

### Cap. 524 — PRECONDICI´ON:

LNCS 925, Springer Verlag, 1995.

Secciones:
  # OBSERVACIONES:

Conclusión: Meijer, editores,
LNCS 925, Springer Verlag, 1995.

### Cap. 525 — PROP´OSITO:

Notes in Computer Science, pages 97–136.

Secciones:
  # OBSERVACIONES:

Conclusión: Universit ´e Joseph Fourier Institut Grenoblois d’ ´etudes in-
formatiques, 1988.

### Cap. 53 — PRECONDICI´ON:

# 5. Asignaci ´on

### Cap. 54 — 5. Expresiones

El mapa conceptual de este libro se presenta en el gr ´afico G.1.

Secciones:
  # 6. Uso de variables

Conclusión: A partir de los trabajos de Turing, John von Neumann desarroll ´o una arquitec-
Se pronuncia “yon
fon n ´oiman”.

### Cap. 55 — {- PROP´OSITO:

ENIAC.

Secciones:
  # 1957. Realiz ´o nu-

Conclusión: Los primeros lenguajes de alto nivel
La situaci ´on con los lenguajes ensambladores era bastante preocupante para los
programadores de aquella ´epoca pues les restaba productividad, les restring´ıa
la creatividad y el espectro de soluciones imaginables y los manten´ıa todo el
tiempo pensando m ´as en la m ´aquina que en la programaci ´on en s´ı.

### Cap. 56 — PRECONDICI´ON:

Naur Form, o BNF).

Secciones:
  # 2007. Gan ´o diver-

Conclusión: En la siguiente lista de ejemplos de identificadores,
pueden observarse letras, palabras y combinaciones diversas, todas las cuales
constituyen identificadores, pues son cadenas de letras sin separaci ´on.

### Cap. 57 — SUPOSICI´ON:

# 3. Dibujar

4. unidentificadormuylargoymuyconfuso

### Cap. 58 — {- PROP´OSITO:

# 5. UnIdentificadorMasEntendible

Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 60 of 312 --

61

### Cap. 59 — PRECONDICI´ON:

# 6. UnIdentificadorTanLargoQueNoValeLaPenaNiPensarEnEscribirlo

### Cap. 60 — {- PROP´OSITO:

Los ejemplos 1, 2 y 4 comienzan con min ´uscula.

Secciones:
  # 7. DibujarCuadradoNegroDeLado3

Conclusión: DibujarLineaNegra2HaciaElNorte.

### Cap. 61 — PRECONDICI´ON:

# PROP´OSITO:

Dibujar una l´ınea negra de longitud 2
hacia el norte de la celda actual.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 75 of 312 --

76

### Cap. 62 — OBSERVACI´ON:

Debe haber al menos dos celdas al Norte de la actual.

Secciones:
  # PRECONDICI´ON:

Conclusión: Por ejemplo, supongamos
que utilizamos este ´ultimo procedimiento comentado como base para un proce-
dimiento similar utilizado en la soluci ´on del ejercicio 2.

### Cap. 63 — {- PROP´OSITO:

# PROP´OSITO:

Dibujar una l´ınea negra de longitud 2
hacia el norte de la celda actual.

### Cap. 64 — PRECONDICI´ON:

Debe haber al menos dos celdas al Norte de la actual.

Secciones:
  # PRECONDICI´ON:

Conclusión: Para ello, utilizaremos
el procedimiento DibujarCuadradoNegroDeLado3 visto en el ejercicio 2.

### Cap. 65 — 6. Expresiones literales

# PROP´OSITO:

Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 78 of 312 --

79
* dibujar un cuadrado negro de 3 celdas de lado
con el v´ertice inferior izquierdo ubicado en
la celda actual, dejando el cabezal en la misma
posici´on

### Cap. 66 — OBSERVACI´ON:

# PRECONDICIONES:

* existe suficiente espacio hacia el norte y el este
para poder dibujar el cuadrado (2 filas al Norte y
2 columnas al Oeste)
-}
{
DibujarLineaNegra2AlNorte()
DibujarLineaNegra2AlEst

Secciones:
  # PRECONDICIONES:

Conclusión: En general vamos a preferir precondiciones lo m ´as precisas posible.

### Cap. 67 — {- PROP´OSITO:

Realice los ejercicios enunciados en esta secci ´on.

Secciones:
  # PRECONDICIONES:

Conclusión: El c ´odigo para ello, suponien-
do solo las herramientas del cap´ıtulo anterior, ser´ıa algo como
program
{
VaciarTablero(); IrAlOrigen()
DibujarCuadradoNegroDeLado3()
IrAlBorde(Este); Mover(Oeste); Mover(Oeste)
DibujarCuadradoRojoDeLado3()
}
procedure DibujarCuadradoNegroDeLado3()
/*
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 89 of 312 --

90
G.

### Cap. 68 — PRECONDICI´ON:

# PROP´OSITO:

* dibujar un cuadrado negro de 3 celdas de lado

### Cap. 69 — {- PROP´OSITO:

# PRECONDICIONES:

* hay 2 celdas al Norte y 2 celdas al Este de la actual
*/
{
Poner(Negro); Mover(Norte); Poner(Negro); Mover(Norte)
Poner(Negro); Mover(Este); Poner(Negro); Mover(Este)
Poner(Negro); Mover(Sur); Poner(Negro); Mover(Sur)
Poner(Negro); Mover(Oeste); Poner(Negro); Mover(Oeste)
}
procedure DibujarCuadradoRojoDeLado3()
/*

### Cap. 70 — PRECONDICI´ON:

# PROP´OSITO:

* dibujar un cuadrado rojo de 3 celdas de lado

### Cap. 71 — {- PROP´OSITO:

En el gr ´afico G.3.2 podemos ver resaltadas esas diferencias.

Secciones:
  # PRECONDICIONES:

Conclusión: As´ı, en lugar de escribir un agujero gr ´aficamente,
usaremos ese nombre para indicar que ah´ı hay un agujero.

### Cap. 72 — PRECONDICI´ON:

# PROP´OSITO:

* dibujar un cuadrado de 3 celdas de lado,
de color colorDelCuadrado

### Cap. 73 — PROP´OSITO:

G.3.4.

Secciones:
  # PRECONDICIONES:

Conclusión: Ello es posible porque un procedimiento puede tener m ´as
de un par ´ametro.

### Cap. 74 — PRECONDICI´ON:

# PROP´OSITO:

* dibujar una l´ınea de 2 celdas de longitud en la direcci´on
dirDeLinea y de color colorDeLinea

### Cap. 75 — PROP´OSITO:

# PRECONDICIONES:

* hay 2 celdas en la direcci´on indicada por dirDeLinea
*/
{
Mover(colorDeLinea); Poner(dirDeLinea)
Mover(colorDeLinea); Poner(dirDeLinea)
}
Podemos observar que este procedimiento tiene 2 par ´ametros: el primero es un
color para el comando Poner, y el segundo es una direcci ´on para el coman-
do Mover. Al invocarlo deben pas ´arsele, consecuentemente, 2 argumentos. Por
ejemplo, para dibujar el cuadrado rojo har´ıamos
procedure DibujarCuadradoRojoDeLado3()
/*

### Cap. 76 — 7. Secuencia de comandos

# PROP´OSITO:

* dibujar un cuadrado de 3 celdas de lado,
de color rojo

### Cap. 77 — PRECONDICI´ON:

# PRECONDICIONES:

* hay 2 celdas al Norte y 2 celdas al Este de la actual

### Cap. 78 — PROP´OSITO:

# OBSERVACIONES:

* utiliza un procedimiento parametrizado para
dibujar l´ıneas
*/
{
DibujarLinea2Hacia(Rojo, Norte)
DibujarLinea2Hacia(Rojo, Este)
DibujarLinea2Hacia(Rojo, Sur)
DibujarLinea2Hacia(Roj

Secciones:
  # OBSERVACIONES:

Conclusión: La idea
ser´ıa que el par ´ametro represen-
ta un agujero, el cual fue llenado
con un valor al invocar el proce-
dimiento principal, y al utilizarlo
como argumento tomamos el va-
lor que est ´a en el agujero y lo co-
locamos en el agujero del proce-
dimiento secundario.

### Cap. 79 — PRECONDICI´ON:

# PROP´OSITO:

* dibujar un cuadrado de 3 celdas de lado,
del color dado por colorDeCuadrado

### Cap. 80 — PROP´OSITO:

# PRECONDICIONES:

* hay 2 celdas al Norte y 2 celdas al Este de la actual

### Cap. 81 — PRECONDICI´ON:

Ejercicio 3.1.2.

Secciones:
  # OBSERVACIONES:

Conclusión: Leer con Atenci ´on
El verdadero poder de la repetici ´on viene de su combinaci ´on con
par ´ametros.

### Cap. 82 — PROP´OSITO:

Realizar los procedimientos solicitados en el ejercicio 3.1.3.

Secciones:
  # PROP´OSITO:

Conclusión: Escribir los procedimientos que se describen.

### Cap. 83 — PRECONDICI´ON:

# 1. PonerN que deposite cant bolitas de color color en la celda actual, supo-

niendo que cant es un n ´umero positivo. ¿Cu ´al es su precondici ´on?

### Cap. 84 — SUPOSICI´ON:

# 2. MoverN que se mueva cant celdas en la direcci ´on dir desde la celda actual,

suponiendo que cant es un n ´umero positivo. ¿Cu ´al es su precondici ´on?

### Cap. 85 — {- PROP´OSITO:

Realice los ejercicios 3.1.4 y 3.1.5 y pru ´ebelos adecuadamente.

Secciones:
  # 3. SacarN que quite cant bolitas de color color de la celda actual, suponiendo

Conclusión: El orden en
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 104 of 312 --

105
cada caso es importante para saber qu ´e rango corresponde a cada par de valo-
res.

### Cap. 86 — PRECONDICI´ON:

# PROP´OSITO:

* dibuja un cuadrado Negro de lado 3

### Cap. 87 — 8. Bloques

# PRECONDICI´ON:

* hay 2 celdas al Norte y 2 al Este de la celda actual

### Cap. 88 — OBSERVACI´ON:

Ejercicio 3.1.7.

Secciones:
  # OBSERVACI´ON:

Conclusión: Para realizarlo, considere utilizar el procedimiento SacarN del ejercicio 3.

### Cap. 89 — 1. Recorrer primero el texto de referencia, recordando la traducci ´on de cada s´ımbolo

Ejercicio 3.2.13.

Secciones:
  # parte 3: , y combinarlo con alguna de las expresiones reci ´en presentadas.

Conclusión: Claramente, precisamos una expresi ´on
que calcule el n ´umero total de bolitas en la celda actual, y lo pase como argu-
mento al procedimiento DibujarSombra.

### Cap. 90 — 2. Recorrer el texto de referencia y, a medida que se encuentra un par clave/valor,

# {- PROP´OSITO:

* pone una sombra del elemento representado en la celda
actual, en la celda lindante al Este

### Cap. 91 — 3. Esta posibilidad es la m ´as simple de programar (y quiz ´as la m ´as “natural” en alg ´un

Definici ´on 3.2.3.

Secciones:
  # PRECONDICI´ON:

Conclusión: En el ejemplo visto antes, podr´ıamos definir una funci ´on simple para calcular el
n ´umero total de bolitas de la celda actual de la siguiente manera.

### Cap. 92 — PRECONDICIONES:

# {- PROP´OSITO:

* calcula el total de bolitas de la celda actual

### Cap. 93 — OBSERVACIONES:

# PRECONDICI´ON:

* ninguna, es una operaci´on total
-}
{
return ( nroBolitas(Azul) + nroBolitas(Negro)
+ nroBolitas(Rojo) + nroBolitas(Verde)
)
}
Al utilizar esta funci ´on, el valor representado por su invocaci ´on es el n ´umero total
de bolitas de todos los colores en la celda actual.
El procedimiento para hacer la sombra podr´ıa modificarse para aprovechar
esta funci ´on de la siguiente manera
procedure HacerSombra()

### Cap. 94 — PRECONDICIONES:

# {- PROP´OSITO:

* ilustrar el uso de funciones
* pone una sombra del elemento representado en la celda
actual, en la celda lindante al Este

### Cap. 95 — PRECONDICIONES:

# PRECONDICI´ON:

* que haya una celda al Este

### Cap. 96 — PRECONDICIONES:

Ejercicio 3.2.18.

Secciones:
  # OBSERVACI´ON:

Conclusión: Por ejemplo, podemos ver si hay m ´as bolitas de un color que de otro, pero
usando par ´ametros para indicar qu ´e colores queremos.

### Cap. 97 — OBSERVACIONES:

# PROP´OSITO:

* retorna verdadero si hay m´as bolitas del color1
que bolitas del color2 en la celda actual

### Cap. 98 — 9. Ejecuci ´on de programas

Realice el ejercicio 3.3.1.

Secciones:
  # PRECONDICI´ON:

Conclusión: La forma de definir una funci ´on con procesamiento en GOBSTONES es
function < funcName >(< params >)
{
< comando >
return(< expresion >)
}
siendo < funName >, < params > y < expresion > como antes, y < comando >
un comando (que puede ser un comando compuesto como una secuencia de
comandos).

### Cap. 99 — PRECONDICIONES:

# PROP´OSITO:

* retorna la cantidad de enemigos en la celda lindante a la
actual en la direcci´on dir

