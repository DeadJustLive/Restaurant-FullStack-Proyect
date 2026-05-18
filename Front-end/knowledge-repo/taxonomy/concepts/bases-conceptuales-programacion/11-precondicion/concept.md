# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 11)

## Contenido
# PRECONDICI´ON:

* hay una celda lindante en direcci´on dir
-}
{
Mover(dir)
return(nroBolitas(colorEnemigo()))
}
La invocaci ´on de una funci ´on con procesamiento es exactamente la misma que
la de una funci ´on con par ´ametros. La ´unica diferencia es que, en GOBSTONES,
el procesamiento que la misma realiza no se lleva a cabo de manera real sobre
el tablero, sino solo de una forma simulada. Por eso, al retornar de una funci ´on
con procesamiento, el estado del tablero no vari ´o absolutamente en nada. Esto
permite utilizar las funciones con procesamiento para retornar informaci ´on, pero
sin tener que preocuparse por las consecuencias del procesamiento.
Leer con Atenci ´on
Esta caracter´ıstica de GOBSTONES es ´unica. Las funciones son expre-
siones y como tales, no deben denotar acciones (o sea, producir efectos)
sino denotar valores. Por eso, el procesamiento se realiza de manera si-
mulada. Sin embargo, en casi todos los dem ´as lenguajes, se permite que
las funciones adem ´as de denotar un valor, produzcan efectos. T ´ecnica-
mente deber´ıamos decir que no son funciones, sino procedimientos que
retornan valores; ¡pero es tan com ´un utilizar el nombre de funci ´on para
este tipo de procedimientos que es importante estar atentos a las dife-
rencias, ya que la forma de pensar las “funciones” cambia!
Por ejemplo, imaginemos una situaci ´on donde queremos agregar en la celda ac-
tual un n ´umero de aliados igual a la cantidad de enemigos en la celda al Norte,
m ´as uno (por ejemplo, como parte de un programa que expresa nuestra estrate-
gia de defensa en un juego), suponiendo la misma codificaci ´on que vimos antes
(un enemigo se representa con una bolita roja y un aliado con una bolita verde).
El procedimiento podr´ıa ser:
procedure EstrategiaDeDefensa()
{-
