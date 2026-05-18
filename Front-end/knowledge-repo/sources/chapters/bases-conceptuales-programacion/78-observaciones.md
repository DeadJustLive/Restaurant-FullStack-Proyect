# OBSERVACIONES:

* utiliza un procedimiento parametrizado para
dibujar l´ıneas
*/
{
DibujarLinea2Hacia(Rojo, Norte)
DibujarLinea2Hacia(Rojo, Este)
DibujarLinea2Hacia(Rojo, Sur)
DibujarLinea2Hacia(Rojo, Oeste)
}
Un detalle importante a observar en el uso de par ´ametros es la corresponden-
cia entre el n ´umero de par ´ametros declarados en un procedimiento, y el n ´ume-
ro y orden de los argumentos usados para invocarlo. Por ejemplo, el procedi-
miento DibujarLineaNegra2HaciaEl del ejercicio 3.1.1 tiene un ´unico par ´ametro
dirDeLinea y cuando se invoca dicho procedimiento se debe suministrar un ´uni-
co valor; es v ´alido invocar al procedimiento como
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 97 of 312 --

98
DibujarLineaNegra2HaciaEl(Norte)
as´ı como tambi ´en con el resto de las direcciones (¡pero no con colores, por
ejemplo!). La misma correspondencia debe existir si se usan varios par ´ametros
en la definici ´on del procedimiento: al invocarlo deben usarse la misma canti-
dad de argumentos y en el orden correcto. Si consideramos el procedimiento
DibujarLinea2Hacia vemos que DibujarLinea2Hacia(Negro,Norte) es una in-
vocaci ´on v ´alida del procedimiento, pues corresponden el n ´umero de los argumen-
tos con los par ´ametros declarados y est ´an en orden. En cambio una invocaci ´on
inv ´alida ser´ıa DibujarLinea2Hacia(Norte), ya que no concuerda la cantidad de
argumentos entre el uso y la declaraci ´on. Otro error posible ser´ıa hacer la invo-
caci ´on con los par ´ametros invertidos: DibujarLinea2Hacia(Norte,Negro), pues
en la definici ´on el par ´ametro de nombre colorDeLinea se utiliza para invocar al
comando Poner, y si rellenamos dicho par ´ametro con el argumento Norte, eso
producir ´a un error (y lo mismo con Negro, dirDeLinea y Mover).
¿Y c ´omo podemos hacer para utilizar el procedimiento DibujarLinea2Hacia
en un procedimiento DibujarCuadrado3 que dibuje un cuadrado parametrizando
su color? La respuesta es sencilla: debemos usar el par ´ametro colorDeCuadrado
como argumento para el procedimiento de dibujar l´ıneas. El resultado ser ´a
Puesto que un par ´ametro repre-
senta un valor, podemos utilizar-
lo como argumento al invocar
otros procedimientos. La idea
ser´ıa que el par ´ametro represen-
ta un agujero, el cual fue llenado
con un valor al invocar el proce-
dimiento principal, y al utilizarlo
como argumento tomamos el va-
lor que est ´a en el agujero y lo co-
locamos en el agujero del proce-
dimiento secundario.
procedure DibujarCuadrado3(colorDeCuadrado)
/*