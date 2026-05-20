# OBSERVACI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 514)

## Contenido
# OBSERVACI´ON:

* utiliza una repetici´on indexada sobre direcciones
-}
{
-- OBSERVAR que son direcciones!
foreach dir in [Norte..Oeste]
{ DibujarLineaNegra2Hacia(dir) }
}
Observar que la repetici ´on utiliza las direcciones como ´ındice, y que por el orden
de las mismas, utiliza las 4 direcciones. El significado de esta repetici ´on indexada
es exactamente el mismo que si hubi ´eramos escrito
DibujarLineaNegra2Hacia(Norte)
DibujarLineaNegra2Hacia(Este)
DibujarLineaNegra2Hacia(Sur)
DibujarLineaNegra2Hacia(Oeste)
puesto que el rango [Norte..Oeste] es la secuencia Norte Sur Este Oeste.
Con la repetici ´on indexada puede realizarse un procedimiento para dibujar
cuadrados de cualquier longitud. Esta ser ´a la forma final que daremos a este
procedimiento, generalizando todo lo que es posible generalizar (el tama ˜no, el
color y la direcci ´on en las l´ıneas), y utilizando los recursos adecuados para no
repetir c ´odigo innecesariamente.
Actividad de Programaci ´on 9
Realizar el ejercicio 3.1.7 y utilizar el procedimiento definido para dibujar
varios cuadrados de distintos tama ˜nos y colores.
Ejercicio 3.1.7. Escribir un procedimiento DibujarCuadrado que dibuje cuadra-
dos de color color y de n celdas de lado. Confirmar que el lado del cuadrado
tenga exactamente n celdas, y no m ´as o menos (tener en cuenta que las l´ıneas
tienen ancho 1, y el ancho de la l´ınea que se superpone tambi ´en cuenta para el
total). Utilizar la menor cantidad de procedimientos posible.
3.1.3. Ejercitaci ´on
En esta subsecci ´on revisamos algunos de los ejercicios de pr ´actica del cap´ıtulo
anterior, con el fin de incorporar las nociones de par ´ametros y repetici ´on.
Actividad de Programaci ´on 10
Realice los ejercicios enunciados en esta subsecci ´on. Recuerde utilizar
todas las buenas pr ´acticas que venimos estudiando (adecuada sepa-
raci ´on en subtareas, elecci ´on de buenos nombres de procedimientos y
par ´ametros, indentaci ´on de c ´odigo, reutilizaci ´on de c ´odigo ya realizado,
etc ´etera).
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 105 of 312 --

106
Ejercicio 3.1.8. Rehacer el ejercicio 2.4.1 usando repetici ´on. Rehacer el ejer-
cicio 2.4.2 usando repetici ´on. Generalizarlos a un procedimiento PonerNDeCada
Recuerde que generalizar un
procedimiento es cambiar alg ´un
dato fijo del mismo por un
par ´ametro, de forma tal que con
un c ´odigo casi id ´entico al ante-
rior, ahora se expresan muchos
m ´as procedimientos.
que tome la cantidad como par ´ametro.
¿Reutiliz ´o el procedimiento PonerUnaDeCadaColor al escribir los dem ´as? Si no lo
hizo, ¡vuelva a revisar el ejercicio y h ´agalo!
Para Reflexionar
¿Puede observar c ´omo el uso de repetici ´on y par ´ametros simplifica el
c ´odigo producido, al tiempo que lo hace m ´as generalizable? Reflexione
sobre la importancia de contar con adecuadas herramientas abstractas
de programaci ´on, tales como los procedimientos, los par ´ametros y las
estructuras de control como la repetici ´on.
Ejercicio 3.1.9. Rehacer el ejercicio 2.4.4, pero generalizando el color y la direc-
ci ´on. Usar el resultado para rehacer el ejercicio 2.4.5 generalizando el color, y
usando una repetici ´on sobre direcciones.
Ejercicio 3.1.10. Rehacer los procedimientos del ejercicio 2.4.9 generalizando el
color con el cual se dibuja la letra E. Rehacer el ejercicio 2.4.10 para que reutilice
el procedimiento anterior y una repetici ´on sobre colores.
Como habr ´a podido comprobar mediante estos ejercicios, la combinaci ´on de re-
petici ´on y par ´ametros es extremadamente poderosa. Adem ´as, ambos juegan un
rol fundamental al permitir la generalizaci ´on de muchas de las nociones que se
utilizan al escribir procedimientos. Sin embargo, ´estas no son las ´unicas herra-
mientas que brindan expresividad y poder a la programaci ´on. En la secci ´on que
sigue veremos otro conjunto de herramientas poderosas.
3.2. Expresiones y funciones
En esta secci ´on veremos c ´omo definir en GOBSTONES expresiones complejas,
resultantes de combinar otras expresiones. Es algo similiar a lo hecho con co-
mandos a trav ´es de procedimientos definidos por el usuario, es decir, agrupare-
mos y nombraremos expresiones, solo que con una nueva herramienta conocida
como funciones.
3.2.1. Expresiones compuestas y tipos
Las expresiones compuestas son algo familiar cuando hablamos de n ´umeros.
As´ı, sabemos que 2+3 est ´a formado por tres partes: dos descripciones de n ´ume-
ros y un s´ımbolo que denota la operaci ´on de sumar ambos n ´umeros. En cual-
quier lenguaje de programaci ´on habr ´a diversas formas de armar expresiones
compuestas que vendr ´an dadas por reglas de formaci ´on.
Para poder introducir las reglas de formaci ´on de expresiones compuestas en
GOBSTONES vamos a comenzar por profundizar en la idea de tipo presentada en
la subsecci ´on 2.1.4. En su forma m ´as simple, un tipo puede entenderse como
la descripci ´on de un conjunto de valores espec´ıficos, con propiedades comunes.
En GOBSTONES exis
