# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 490)

## Contenido
# PRECONDICI´ON:

Debe haber al menos dos celdas al Norte de la actual.
(O sea, el cabezal no puede encontrarse ni en la ´ultima
ni en la ante´ultima fila)
-}
{
-- No se dibuja en la celda incial
Mover(Norte); Poner(Negro) -- Dibuja en la celda
-- al Norte de la inicial
Mover(Norte); Poner(Negro) -- Dibuja en la celda dos
-- lugares al Norte de la
-- inicial
Mover(Norte); Poner(Negro) -- Dibuja en la celda dos
-- lugares al Norte de la
-- inicial
-- Al terminar el cabezal se encuentra dos lugares
-- al Norte de donde comenz´o
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 76 of 312 --

77
G.2.11. C ´odigo con comentarios desactualizados
}
Observar que el c ´odigo fue obtenido copiando y pegando (suele decirse, con
cut&paste), y luego alterando algunas partes
Para Reflexionar
¿Puede encontrar las partes que se agregaron? .
Estas alteraciones llevan a que haya por lo menos tres comentarios desactuali-
zados en este c ´odigo. El primero es el del prop ´osito y la precondici ´on, puesto
que al agregar comandos de movimiento, tanto el prop ´osito como la precondi-
ci ´on cambiaron, y sin embargo el comentario no fue alterado. El segundo es el
comentario de l´ınea que se asocia al tercer grupo de comandos: como fue ob-
tenido por cut&paste y no fue modificado, indica lo mismo que el anterior, pero
La forma en que la mayor´ıa lo
leemos es “c ´atan p ´eist”.
su efecto es diferente. El tercero es el comentario de cierre, sobre la posici ´on
final del cabezal. Si adem ´as este c ´odigo hubiera sido modificado por otra perso-
na diferente de Fidel, o en otra fecha, el comentario sobre el autor y la fecha
tambi ´en estar´ıan desactualizados. Puede verse en el gr ´afico G.2.11 las indica-
ciones de qu ´e comentarios est ´an desactualizados. Puesto que los comentarios
est ´an en lenguaje natural, y el prop ´osito de un programador no es analizable
autom ´aticamente, este tipo de situaciones no se pueden detectar con ninguna
herramienta. Es absoluta responsabilidad del programador que sus comentarios
est ´en actualizados, sean pertinentes y ´utiles.
La pr ´actica de comentar el c ´odigo de manera adecuada es extremadamen-
te importante cuando varias personas trabajan sobre un programa, ya sea si-
mult ´aneamente, o a lo largo de alg ´un per´ıodo de tiempo. Es recomendable co-
mentar todo c ´odigo que se escriba de manera adecuada. Por otra parte, los co-
mentarios desactualizados son m ´as da ˜ninos que la ausencia de comentarios,
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 77 of 312 --

78
puesto que pueden inducir a ideas incorrectas. Es por ello recomendable no des-
estimar la importancia de los comentarios y actualizarlos al modificar el c ´odigo.
Como observaciones finales, salvo que cada procedimiento sea definido por
un programador diferente, la informaci ´on de autor y fecha suele ponerse una
´unica vez por archivo o conjunto de definiciones, y no como parte de cada proce-
dimiento. Adem ´as, rara vez suele comentarse un c ´odigo tan profusamente como
el ejemplo de DibujarLineaHaciaElNorte como hemos hecho aqu´ı.
Durante este ´ultimo ejemplo hablamos de prop ´osito y precondici ´on de un pro-
cedimiento, pero sin haber explicado exactamente qu ´e eran esas cosas. En la
secci ´on siguiente completaremos esa falta.
2.3.4. Contrato de un procedimiento
Si bien la herramienta provista por los procedimientos puede utilizarse para dar-
le nombre a cualquier grupo de comandos, lo m ´as adecuado desde el punto de
vista de la comprensi ´on del c ´odigo es que los comandos se agrupen en funci ´on
de la resoluci ´on de alguna tarea espec´ıfica. Por otra parte, y dado que algunos
de los comandos que utilizamos son parciales, es posible que al armar un pro-
cedimiento el mismo falle porque no se cumplen las condiciones necesarias para
que esos comandos parciales se ejecuten. Para cubrir ambos aspectos, presen-
taremos la idea de contrato de un procedimiento. El contrato de un procedimiento
est ´a formado principalmente por dos partes:
el prop ´osito del procedimiento, y
las precondiciones del procedimiento.
El prop ´osito de un procedimiento establece cu ´al es la tarea que el procedimiento
pretende resolver, o sea, la funcionalidad que esperamos que el procedimiento
tenga. Las precondiciones de un procedimiento, al igual que la precondici ´on de
un comando primitivo, establecen los requisitos que deben cumplirse para que
el procedimiento pueda llevar a cabo su tarea con ´exito. Entre ambos forman las
reglas que permitir ´an saber c ´omo debe utilizarse el procedimiento en cuesti ´on. O
sea, si un programador quiere lograr cierta funcionalidad en su programa, se fija
entre los procedimientos que ya tiene definidos si alguno sirve para ese objetivo
(mirando los prop ´ositos de los mismos), y elige el que corresponda. Luego se
fija cu ´al es las precondiciones de dicho procedimiento, para poder llamarlo con
la seguridad de que no fallar ´a.
Definici ´on 2.3.3. El contrato de un procedimien
