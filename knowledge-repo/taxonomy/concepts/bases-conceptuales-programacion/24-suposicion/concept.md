# SUPOSICION:

## Fuente
bases-conceptuales-programacion (Cap. 24)

## Contenido
# SUPOSICION:

* en la celda actual no hay bolitas verdes
-}
{
switch (dir) to
Norte -> { PonerN(1, Verde) }
Sur -> { PonerN(2, Verde) }
Este -> { PonerN(3, Verde) }
_ -> { PonerN(4, Verde) }
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 137 of 312 --

138
donde se observa que solo se pregunta por 3 direcciones, siendo innecesario
preguntar por la direcci ´on Oeste en el ´ultimo caso, porque es la ´unica opci ´on
posible. Si quisi ´esemos explicitar la pregunta sobre cada una de las direcciones,
el case deber´ıa contener igualmente la rama default, pero con c ´odigo que jam ´as
se ejecutar´ıa:
procedure CodificarDirAlternativo(dir)
{
switch (dir) to
Norte -> { PonerN(1, Verde) }
Sur -> { PonerN(2, Verde) }
Este -> { PonerN(3, Verde) }
Oeste -> { PonerN(4, Verde) }
_ -> { Skip }
}
Observar que no es imprescindible contar con el comando switch, puesto que
el mismo puede ser representado mediante condicionales anidados y el uso del
operador de igualdad ==, de la siguiente manera
if (< indexExp >==< val1 >) < bloque1 >
else { if (< indexExp >==< val2 >)< bloque2 >
else { if (. . . ) . . .
else < bloqueDefault >
}}
Sin embargo, es mucho m ´as c ´omodo escribir esta construcci ´on mediante el co-
mando switch, y m ´as representativo de las intenciones del programador de deci-
dir entre varias alterantivas en base a un valor dado. En algunos lenguajes donde
PYTHON por ejemplo. no existe el comando switch, existe una forma de alternativa condicional que per-
mite varias ramas en el if mediante la palabra clave elif (abreviatura de else
if), y que permite una construcci ´on como la presentada reci ´en con ifs anidados.
Para Reflexionar
Cuando la alternativa indexada se utiliza sobre el tipo de los booleanos,
y el ´unico valor consultado es el True, la misma es equivalente a una
alternativa condicional. Dicho de otro modo, la alternativa condicional
puede entenderse como una alternativa que indexa sobre booleanos.
Actividad de Programaci ´on 4
Realice el ejercicio 4.1.4 utilizando un switch. Luego intente realizarlo
utilizando un if-then-else y compare el c ´odigo de ambas soluciones.
Ejercicio 4.1.4. Escribir un procedimiento ProcesarTecla, que dado un n ´umero
codificando a una tecla que fue presionada en alg ´un tipo de interfase, determine
la acci ´on a seguir. Los c ´odigos de teclas y las acciones que debe producir cada
tecla son los siguientes:
Tecla C ´odigo Acci ´on
↑, w 119 Acelerar()
↓, s 97 Frenar()
←, a 115 GirarIzquierda()
→, d 100 GirarDerecha()
< espacio > 32 Disparar()
< escape > 27 Terminar()
otras MostrarError()
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 138 of 312 --

139
4.2. M ´as sobre repeticiones
Como vimos, una repetici ´on es un comando que expresa la ejecuci ´on reiterada de
otro comando un cierto n ´umero de veces que se indica con un rango de valores.
En este apartado vamos a profundizar sobre algunas combinaciones de repe-
ticiones indexadas, y veremos una nueva forma de repetici ´on, la repetici ´on condi-
cional, tambi ´en conocida como sentencia while o sentencia do-while. Adem ´as,
veremos una manera de estructurar programas que utilizan repetici ´on condicio-
nal, denominada por nosotros como recorridos, pensados como repeticiones que
procesan secuencias de elementos. El objetivo de los recorridos es simplificar el
uso de repeticiones condicionales, y evitar la multitud de problemas que pueden
presentarse al utilizar esta poderosa forma de repetici ´on.
4.2.1. M ´as sobre repetici ´on indexada
Al realizar repeticiones, puede suceder que algunos de los elementos del ran-
go sobre el que se repite no pueda ser procesado de la misma manera que el
resto. En ese caso, y acorde al enunciado del ejercicio mencionado, el proce-
samiento puede utilizar una alternativa condicional para evitar procesar elemen-
tos incorrectos. Para ejemplificar esto, consideremos un procedimiento al que
podemos llamar CodificarDireccionDelEnemigo, que deje en la celda actual
una marca que indique en cu ´al de las 4 direcciones se encuentra el enemigo al
Imaginemos que somos los ex-
ploradores de nuestro ej ´ercito,
y venimos siguiendo al enemi-
go, marcando el territorio para
que nuestro ej ´ercito pueda se-
guirnos.
momento de poner la marca. Para este ejemplo vamos a suponer que el enemi-
go se encuentra en solo una de las celdas contiguas a la actual (o sea, no se
ha dispersado. . . ), y que la celda actual no contiene bolitas del color en el que
codificaremos la respuesta. El c ´odigo para dicho procedimiento podr´ıa ser
procedure CodificarDireccionDelEnemigo()
{-
