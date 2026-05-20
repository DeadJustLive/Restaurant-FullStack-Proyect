# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 17)

## Contenido
# PRECONDICI´ON:

* hay 3 celdas lindantes al Norte
-}
{
return(hayEnemigosAlEnRango(Norte,1) ||
hayEnemigosAlEnRango(Norte,2) ||
hayEnemigosAlEnRango(Norte,3)
}
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 125 of 312 --

126
Sin embargo, esta forma no ser´ıa parametrizable en cuanto a la distancia a me-
dir, quitando poder de generalidad a la soluci ´on propuesta y haci ´endolo menos
modificable a futuro. Por ejemplo, si modific ´asemos la definici ´on de “cerca” pa-
ra contemplar 10 celdas en lugar de 3, el resultado habr´ıa sido m ´as engorroso.
O si hubi ´eramos considerado agregar un par ´ametro num ´erico que estableciese
el rango en el que nuestros exploradores pueden detectar enemigos, no habr´ıa
sido posible expresar la funci ´on como una disyunci ´on compleja, puesto que no
sabr´ıamos de antemano cu ´antos llamados debemos realizar.
Actividad de Programaci ´on 24
Realice los ejercicios 3.3.5 y 3.3.6 y pru ´ebelos en alg ´un programa.
Ejercicio 3.3.5. Escribir una funci ´on hayEnemigosAlEnRango que, dado un par ´a-
metro d de tipo direcci ´on y uno n de tipo n ´umero indique si hay enemigos en la
celda distante exactamente n celdas en direcci ´on d a partir de la celda actual.
Utilizar la idea de la funci ´on hayEnemigosAl del ejercicio 3.3.3 pero utilizando el
procedimiento MoverN en lugar del comando Mover.
Ejercicio 3.3.6. Escribir una funci ´on hayEnemigosCercaNAlNorte que, dado un
par ´ametro n de tipo n ´umero indique si hay enemigos en alguna de las n celdas
contiguas al Norte. Utilizar la idea de procesar con una repetici ´on indexada y
bolitas para indicar el resultado.
El procesamiento que es posible realizar en las funciones con procesamiento se
ver ´a potenciado al incorporar formas de recordar valores. Esto se realizar ´a en el
siguiente cap´ıtulo.
3.4. Ejercitaci ´on
En esta secci ´on se enuncian una serie de ejercicios adicionales a los ya dados.
Al igual que en ejercitaciones previas, para su correcta resoluci ´on son necesarios
todos los elementos aprendidos en las secciones y cap´ıtulos anteriores.
Actividad de Programaci ´on 25
Realice los ejercicios enunciados en esta secci ´on. Nuevamente, le re-
cordamos que debe utilizar todas las buenas pr ´acticas que venimos es-
tudiando.
Ejercicio 3.4.1. Escribir una funci ´on nroBolitasNAl, que dados un color c, un
n ´umero n y una direcci ´on d, determine el n ´umero de bolitas de color c en la celda
distante exactamente n lugares en direcci ´on d a partir de la celda actual. Utilizar
como inspiraci ´on la funci ´on hayEnemigosAlEnRango del ejercicio 3.3.5.
El siguiente ejercicio se basa en una idea de Pablo Tobia. ¡Gracias Pablo!
Ejercicio 3.4.2. En este ejercicio utilizaremos el display de un ecualizador repre-
sentado en el tablero. El ecualizador tiene 2 canales (izquierdo y derecho) con 3
frecuencias cada uno (agudos, medios y graves). Cada frecuencia de cada canal
posee 4 leds verdes y 2 leds rojos. Para representar el display en el tablero se
utiliza una columna por cada frecuencia de cada canal (6 en total), a partir de la
columna m ´as al Oeste. Cada frecuencia se representa desde la celda base (la
m ´as al Sur), dejando dicha celda libre, y ubicando un led por celda hacia arriba.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 126 of 312 --

127
(a). Tablero inicial representando el display de un
ecualizador.
(b). Tablero final representando el ecualizador
con intensidades.
G.3.11. Tablero representando el display de un ecualizador (antes y despu ´es de
calcular las intensidades)
Los leds encendidos se representan mediante una bolita del color correspon-
diente en la celda, y los apagados con una celda vac´ıa. Se muestra un tablero
representando al display de un ecualizador en el gr ´afico G.3.11a.
Escribir un procedimiento CalcularIntensidades, que dado un tablero con-
teniendo la representaci ´on de un display de ecualizador cuente la intensidad de
cada frecuencia, registrando el resultado en la celda de la base de cada colum-
na con bolitas azules si la intensidad es menor o igual que 4, y negras si es
mayor. El resultado para el ecualizador dado como ejemplo se muestra en el
gr ´afico G.3.11b.
Para realizar el ejercicio anterior, se recomienda dividir en subtareas y utilizar
funciones y procedimientos seg ´un lo visto hasta el momento. Puede resultar ´util
contar con algunos de los nombres de los procedimientos y funciones en cues-
ti ´on: TotalizarFrecuenciaActual, ProcesarLedsVerdes, ProcesarLedsRojos,
NormalizarColorIntensidad y nroBolitasNAl. Tenga en cuenta que para to-
talizar todas las frecuencias puede usar una repetici ´on indexada, y para totalizar
la frecuencia actual puede utilizar la idea de hayEnemigosCercaAlNorte.
Los siguientes ejercicios se basan en una idea de Pablo Barenbaum. Utilizan su
idea y su enunciado para un juego inspirado en el ajedrez, que ´el denomin ´o Pro-
cedrez. Primero se describir ´a el juego, y luego se enunciar ´an los ejercicios que
ayudar ´an a 
