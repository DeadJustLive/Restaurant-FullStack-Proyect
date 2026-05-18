# OBSERVACI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 88)

## Contenido
# OBSERVACI´ON:

* se estructura como un recorrido sobre los
n´umeros naturales mayores que 2 necesarios,
los cuales se recuerdan con la variable
cantAColocar
-}
{
-- Iniciar el recorrido
procesadas := 0 -- la cantidad de celdas ya tratadas
cantAColocar := 2 -- el inicio de la progresi´on
-- Mientras no se haya terminado el recorrido
while (procesadas < n)
{
-- Procesar el elemento actual
if (cantAColocar mod 2 == 0 -- m´ultiplo de 2
|| cantAColocar mod 3 == 0) -- o m´ultiplo de 3
{
PonerN(cantAColocar, Verde)
procesadas := procesadas + 1 -- se proces´o una celda
Mover(Este) -- por eso pasa a la sig.
}
-- Pasar al siguiente n´umero a considerar
cantAColocar := cantAColocar + 1 -- probar un nuevo nro.
}
-- Finalizar el recorrido, volviendo al punto de partida
MoverN(Oeste, n)
}
Puede observarse c ´omo la pregunta para terminar de procesar responde a la cantidad de
celdas procesadas (que en este caso debe ser el par ´ametro n), mientras que el pasar a
un nuevo elemento consiste en probar un nuevo n ´umero. El procesamiento de elementos
consiste en verificar si el n ´umero actual corresponde a una cantidad a poner, y en ese ca-
so, ponerlo en la celda correspondiente. Variando el tratamiento de estos dos par ´ametros
se pueden lograr diferentes combinaciones.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 170 of 312 --

171
Actividad de Programaci ´on 30
Realice el ejercicio 4.3.9, y verif´ıquelo en el sendero del gr ´afico G.4.3. En el gr ´afi-
co G.4.7 pueden verse un par de invocaciones del procedimiento, con par ´ame-
tros diferentes.
Ejercicio 4.3.9. Modificar el procedimiento PonerFloresEnSenderoSimple presentado en
la subsecci ´on 4.2.3, para que tome un par ´ametro distancia, y coloque flores en el sen-
dero separadas por la distancia dada.
Sugerencia: agregar una variable proximoSectorEn que cuente cu ´anto falta para el
pr ´oximo sector donde poner flores. Al procesar, si esta variables est ´a en 1, poner la flor y
volver a poner la variable en la distancia m ´axima, y si no, decrementar la variable.
Ayuda: una complicaci ´on que tiene este ejercicio es que el control de cu ´al era el
siguiente sector a mover asum´ıa que en el anterior ya se hab´ıa colocado una flor. Puesto
que en esta variante no se coloca una flor, debe marcarse un sector visitado (por ejemplo,
reemplazando las bolitas negras por bolitas verdes), para indicar que efectivamente ya fue
visitado. Al finalizar el recorrido habr´ıa que hacer una subtarea que vuelva a recorrer el
sendero cambiando bolitas verdes por negras.
Actividad de Programaci ´on 31
Realice el ejercicio 4.3.10, y pru ´ebelo con el sendero del gr ´afico G.4.3. El resul-
tado deber´ıa quedar como el gr ´afico G.4.8.
Ejercicio 4.3.10. Modificar el procedimiento PonerFloresEnSenderoSimple de la subsec-
ci ´on 4.2.3 para que “numere” los sectores, colocando tantas flores en un sector como la
distancia de ese sector al inicio del sendero. O sea, en el inicio debe colocar 1 flor, en el
primer sector, 2 flores, en el tercero, 3 flores, etc ´etera.
Actividad de Programaci ´on 32
Realice el ejercicio 4.3.11, y pru ´ebelo en varias de las frecuencias del ecualiza-
dor del gr ´afico G.3.11a.
Ejercicio 4.3.11. Escribir un procedimiento IncrementarFrecuenciaActual, que, tenien-
do en cuenta la representaci ´on del ejercicio 3.4.2, incremente en uno la frecuencia repre-
sentada en la columna actual. Puede suponerse que la celda actual se encuentra en la
base de la columna. Tener en cuenta que si la frecuencia est ´a al m ´aximo, no se incremen-
ta, y que al incrementar, debe respetarse el color de cada led.
Ayuda: estructurarlo como un recorrido sobre los 6 leds de la frecuencia, incremen-
tando una variable intensidad cada vez que se encuentra un led prendido. El finalizar
recorrido debe posicionarse sobre el led siguiente a la intensidad (si esta es menor que
6), y encenderlo (ya sea verde o rojo, seg ´un la posici ´on).
4.4. Ejercitaci ´on
Este apartado culmina la introducci ´on al lenguaje GOBSTONES, con algunos ejercicios
avanzados que utilizan todas las herramientas vistas hasta el momento.
Actividad de Programaci ´on 33
Realice los ejercicios de este apartado, y pru ´ebelos en cada caso, sobre los
tableros adecuados.
Continuando con el juego de Procedrez que se describi ´o en la secci ´on 3.4, completamos
los ejercicios que requer´ıan herramientas avanzadas.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 171 of 312 --

172
(a). Resultado de invocar PonerFloresEnSenderoSimpleCada(4)
(b). Resultado de invocar PonerFloresEnSenderoSimpleCada(5)
G.4.7. Sendero simple con flores colocadas cada algunos sectores
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 172 of 312 --

173
G.4.8. Sendero simple “numerado”
El procedimiento del ejercicio que se presenta a continuaci ´on sigue la idea del ejerci-
cio 3.4.4, y fue utilizado en el ejercicio 3.4.5.
Ejercicio 4.4.1. Implementar el procedimiento MarcarMovimientosTorre, que recibe
