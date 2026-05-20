# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 507)

## Contenido
# OBSERVACIONES:

* utiliza un procedimiento parametrizado para
dibujar l´ıneas
* utiliza el par´ametro de DibujarCuadrado3 como
argumento de DibujarLinea2Hacia
*/
{
DibujarLinea2Hacia(colorDeCuadrado, Norte)
DibujarLinea2Hacia(colorDeCuadrado, Este)
DibujarLinea2Hacia(colorDeCuadrado, Sur)
DibujarLinea2Hacia(colorDeCuadrado, Oeste)
}
Esto ser´ıa como llenar el “agujero” de DibujarLinea2Hacia con el contenido del
“agujero” colorDeCuadrado. Esto es v ´alido, pues el par ´ametro representa a un
valor espec´ıfico dentro del procedimiento, y por lo tanto puede utilizarse ese valor
como argumento. Agrupamos todas estas nociones en la siguiente actividad de
programaci ´on.
Actividad de Programaci ´on 3
Realizar el ejercicio 3.1.2, y probarlo dibujando cuadrados de al menos 3
colores en 3 posiciones diferentes del tablero. Recordar que para probar
un ejercicio debe escribir un programa que invoque adecuadamente los
procedimientos necesarios.
Ejercicio 3.1.2. Definir un procedimiento DibujarCuadrado3 que, dado un color
como par ´ametro, dibuje un cuadrado de lado dos de dicho color, utilizando un
´unico procedimiento para dibujar l´ıneas.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 98 of 312 --

99
Otro ejercicio interesante donde podr´ıamos intentar utilizar par ´ametros es el de
dibujar la letra E visto en el cap´ıtulo anterior.
Actividad de Programaci ´on 4
Realizar nuevamente los ejercicios 2.4.5 y 2.4.11 de la unidad anterior,
intentando no duplicar la definici ´on de procedimientos auxiliares, pero
capturando las subtareas adecuadas con procedimentos. Utilizar la idea
de par ´ametro vista en este apartado.
Esta idea de utilizar el par ´ametro de un procedimiento como argumento en la
invocaci ´on de otro procedimiento abre una nueva pregunta: ¿d ´onde tiene sentido
utilizar un par ´ametro? Dado que un par ´ametro permite definir un esquema de
procedimiento, nombrando un valor que ser ´a diferente en cada llamado de dicho
procedimiento, el ´unico lugar donde tendr´ıa sentido el par ´ametro es dentro de
ese mismo procedimiento.
Leer con Atenci ´on
Es por tanto razonable esperar que la validez del par ´ametro sea solo
dentro del cuerpo del procedimiento que lo define. Esta noci ´on de va-
lidez se conoce con el nombre de alcance (en ingl ´es scope), y es ex-
tremadamente importante, pues es un error usual al comenzar a utilizar
par ´ametros el intentar utilizar un par ´ametro fuera de su alcance, provo-
cando errores extra ˜nos.
Definici ´on 3.1.4. El alcance de un par ´ametro es la regi ´on del programa donde
el mismo tiene validez y puede ser utilizado.
Diferentes herramientas (par ´ametros, variables, etc.) poseen alcance, y la forma
de definirlo var´ıa de herramienta en herramienta y de lenguaje en lenguaje. En
GOBSTONES el alcance es el m ´as simple de todos, siendo exclusivamente local,
lo cual quiere decir que un par ´ametro solamente es conocido en el cuerpo del
procedimiento que lo define. Podr´ıamos entender esto pensando en un procedi-
miento como una familia, y en el nombre del par ´ametro como un apodo familiar:
personas ajenas a la familia no conocer ´an este apodo, y diferentes familias pue-
den usar el mismo apodo para diferentes personas.
Antes de profundizar en estas nociones, vamos a incorporar algunos elemen-
tos para poder armar ejemplos m ´as complejos.
3.1.2. Formas b ´asicas de repetici ´on de comandos
Al pensar en parametrizar el dibujo del cuadrado, surge inmediatamente la idea
de parametrizar su tama ˜no. Esto se har´ıa pasando un par ´ametro num ´erico que
indicase el tama ˜no esperado del lado del cuadrado. Sin embargo, con las he-
rramientas del lenguaje que hemos presentado hasta el momento no es posible
construir ning ´un procedimiento que aproveche un par ´ametro num ´erico. Por ello,
es necesario presentar una nueva forma de armar comandos compuestos: la re-
petici ´on.
Repetici ´on simple
Cuando es necesario repetir un comando un cierto n ´umero de veces, en lugar
de copiar el mismo comando esa cantidad de veces, podemos describir que que-
remos el mismo comando repetido varias veces. La forma que se utiliza para
definir una repetici ´on simple en GOBSTONES es repeat. Por ejemplo, para poner
10 bolitas rojas en la celda actual se puede escribir el siguiente comando:
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 99 of 312 --

100
repeat(10)
{ Poner(Rojo) }
El comando repeat describe de manera concisa la repetici ´on simple de otro co-
mando una cierta cantidad de veces. La definici ´on es la siguiente.
Definici ´on 3.1.5. Un comando de repetici ´on simple permite que una acci ´on se
llevada a cabo un cierto n ´umero de veces, siendo la cantidad a repetir indicada
por un n ´umero. El comando repeat que permite la repetici ´on simple tiene la
siguiente forma:
repeat (< numero >)
< bloque >
siendo < numero > una expresi ´on que describe una cantidad, y < bloque > un
bloque cualquiera que se repetir ´a.
El efecto de un comando de repetici ´on
