# PRECONDICI´ON:

* es una operaci´on total
-}
{
while (puedeMover(Norte))
{ Mover(Norte) }
}
Si realiz ´o concienzudamente la actividad inicial, ya comprob ´o que no hay ma-
nera de realizar esta tarea con una repetici ´on indexada pues no se conoce de
antemano el n ´umero de celdas que deber ´a moverse el cabezal. Debe obser-
varse que el cuerpo del while modifica el estado, y en determinado momento
esa modificaci ´on hace que la condici ´on pase a ser falsa, dando por finalizada la
Esto es as´ı porque el tablero es
finito.
ejecuci ´on del comando. Esta tarea no podr´ıa hacerse con repetici ´on indexada,
pues no se conoce el tama ˜no del tablero, ni hay forma de determinar la posi-
ci ´on de la celda actual. Pero s´ı podr´ıa parametrizarse, lo cual se evidencia en el
pr ´oximo ejercicio.
Actividad de Programaci ´on 9
Realice el ejercicio 4.2.4, y pru ´ebelo con distintas direcciones.
Ejercicio 4.2.4. Escribir un procedimiento IrHastaElBorde, que dada una direc-
ci ´on, se mueve en esa direcci ´on hasta que llega al borde del tablero. Este proce-
dimiento realiza la misma tarea que el comando IrAlBorde, comprobando que
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 144 of 312 --

145
con las herramientas adecuadas, algunos comandos b ´asicos pueden ser reem-
plazados.
Leer con Atenci ´on
La repetici ´on condicional es una de las formas m ´as poderosas de re-
petici ´on, y por ello, tambi ´en m ´as dif´ıcil de manejar correctamente. Por
ejemplo, podr´ıa suceder que la condici ´on jam ´as se hiciese verdadera.
En este caso, el programa provocar ´a que la m ´aquina quede infinitamen-
te intentando realizar una tarea, lo cual no puede ser comprobado de
ninguna forma externa durante la ejecuci ´on.
Como ejemplo, considerar el siguiente c ´odigo:
procedure LaBuenaPipa()