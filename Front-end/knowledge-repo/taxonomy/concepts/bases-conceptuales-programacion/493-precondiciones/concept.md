# PRECONDICIONES:

## Fuente
bases-conceptuales-programacion (Cap. 493)

## Contenido
# PRECONDICIONES:

* el tablero debe tener 3 filas y 3 columnas y la celda actual
debe ser el origen
Claramente sirve tambi ´en para el procedimiento DibujarCuadradoNegroDeLado3,
pues en ese tablero podr ´a dibujar sin problemas; pero en general este tipo de
precondiciones son consideradas demasiado restrictivas, pues no dice que hay
much´ısimos otros tableros donde el procedimiento tambi ´en funcionar ´a. Entonces,
si us ´asemos esta ´ultima precondici ´on en lugar de la que vimos, un programador
al verla pensar´ıa que solo puede limitar el uso del procedimiento a tableros de
ese tama ˜no, y no la usar´ıa para otros casos donde podr´ıa serle ´util.
Leer con Atenci ´on
En general es extremadamente importante escribir bien el prop ´osito y la
precondici ´on de manera que indiquen claramente el objetivo y los reque-
rimientos de la manera m ´as precisa posible, ya que es la forma en que
un programador se entera de las caracter´ısticas importantes del proce-
dimiento. O sea, si el contrato est ´a bien expresado, el programador que
precisa usarlo normalmente no lee el c ´odigo del mismo, ya sea por no
estar disponible o por no ser relevante para su soluci ´on.
Establecer el prop ´osito tiene adem ´as una segunda ventaja: cuando definimos un
procedimiento debemos pensar para qu ´e lo estamos definiendo, o sea, qu ´e tarea
esperamos que el procedimiento resuelva. De esa forma evitamos definir proce-
dimientos que no tienen sentido desde el punto de vista de nuestra soluci ´on, y
podemos determinar si ciertas operaciones deben ser inclu´ıdas (o no) como par-
te del mismo. Volveremos a este punto cuando veamos ejemplos m ´as complejos.
Por todas estas razones, en el resto del curso insistiremos con establecer
siempre el prop ´osito y las precondiciones de un procedimiento. La forma en que
se redactan ambos es tambi ´en una cuesti ´on de estilo. Al igual que las restantes
cuestiones de estilo, se puede dominar perfectamente con suficiente pr ´actica.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 79 of 312 --

80
2.4. Ejercitaci ´on
En este apartado se enuncian una serie de ejercicios de pr ´actica adicionales
a los ya dados durante el cap´ıtulo. Para su correcta resoluci ´on son necesarios
todos los elementos aprendidos en las secciones anteriores. A trav ´es de su re-
Es importante que al resolver-
los se utilicen solamente los
conceptos ya vistos. Las perso-
nas que ya conocen otros len-
guajes tendr ´an la tentaci ´on de
utilizar herramientas m ´as avan-
zadas para pensar la soluci ´on;
sin embargo, los ejercicios fue-
ron pensados para ser resueltos
con las herramientas provistas.
En algunos casos puede resultar
m ´as complejo de la cuenta, ¡pe-
ro esa complejidad es buscada
con fines did ´acticos!
soluci ´on iremos repasando algunos de los conceptos principales, e incorporando
preguntas que preparar ´an el material de cap´ıtulos posteriores.
Actividad de Programaci ´on 16
Realice los ejercicios enunciados en esta secci ´on. Recuerde separar
adecuadamente su c ´odigo en procedimientos, elegir convenientemen-
te los nombres de los mismos, y comentar su c ´odigo de manera que el
mismo sea f ´acilmente entendible.
El primer ejercicio es simplemente una gu´ıa para recordar c ´omo definir un pro-
cedimiento, para experimentar c ´omo probarlo en un programa, y para preparar
ideas que luego se utilizar ´an en ejercicios posteriores.
Ejercicio 2.4.1.
Escribir un procedimiento PonerUnaDeCadaColor, que coloque una bolita de cada
color en la celda actual. ¿Cu ´al es su precondici ´on?
Leer con Atenci ´on
Recuerde que para probar su procedimiento debe escribir un programa
principal que lo utilice.
El siguiente ejercicio permite volver a repasar la idea de reutilizaci ´on de proce-
dimientos ya definidos. Toda vez que una tarea de programaci ´on aparece una
y otra vez, hay un candidato para introducir un procedimiento que resuelva esa
tarea. En muchos casos en este libro, los procedimientos a utilizar en una solu-
ci ´on se presentan antes en otros ejercicios previos, orientando de esta manera
la soluci ´on deseada.
Ejercicio 2.4.2.
Escribir el procedimiento Poner5DeCadaColor que coloque cinco bolitas de cada
color en la celda actual. Reutilizar el procedimiento definido en el ejercicio 2.4.1
( PonerUnaDeCada) para definir esta tarea.
Para Reflexionar
¿Cu ´anto m ´as dif´ıcil habr´ıa sido el ejercicio 2.4.2 si no hubiera conta-
do con el ejercicio 2.4.1? Piense en la necesidad de identificar estas
subtareas, y definir sus propios procedimientos para expresarlas, espe-
cialmente cuando no se hayan definido en ejercicios previos.
Si bien en el ejercicio 2.4.2 se pidi ´o expresamente la reutilizaci ´on del ejerci-
cio 2.4.1, esto no es lo usal. Normalmente la determinaci ´on de qu ´e otros pro-
cedimientos pueden servir para expresar la soluci ´on a un problema (o sea, en
qu ´e subtareas es interesante o relevante dividir ese problema) se deja librado a
la imaginaci ´on y la habilidad del programador.
Y en e
