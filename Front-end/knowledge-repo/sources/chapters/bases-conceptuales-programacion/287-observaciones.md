# OBSERVACIONES:

* auxiliar para randomEntre0YConSemilla(maximo, semilla)
* Mark Jones lo atribuye a "Random Number Generators: Good
Ones are Hard to Find" de S.K.Park y K.W.Miller, publicado
en la revista "Communications of the ACM", 31(10):1192-1201,
en octubre de 1988.
* este art´ıculo en realidad lo toma de una propuesta de 1969
por Lewis, Goodman and Miller y lo propone como est´andar
m´ınimo de generaci´on de n´umeros seudoaleatorios
* el comentario sobre su funcionamiento fue agregado por m´ı,
en base a alguna lectura que encontr´e alguna vez que lo
explicaba, y de la que no recuerdo la cita:
x_{i+1} = a*x_i mod m
donde
a = 7^5 = 16807
m = 2^31 - 1 = 2147483647
q = m div a = 127773
r = m mod a = 2836
y entonces
x_{i+1} = a*(x_i mod q) - r*(x_i div q) + delta*m
siendo
delta = 1 si (a*(x_i mod q) - r*(x_i div q) > 0)
delta = 0 si no
*/
{
hi := semilla div 12773 -- semilla div (2^31 mod 7^5)
lo := semilla mod 12773 -- semilla mod (2^31 mod 7^5)
preresultado := 16807 * lo - 2836 * hi
-- 7^5 * lo - (2^31 mod 7^5) * hi
if (preresultado > 0) { delta := 0 }
else { delta := 1 }
return (preresultado + delta * 2147483647)
-- delta * 2^31
}
Puede observarse que para utilizarlo correctamente, la primera vez debe suministrarse
una semilla inicial, y luego, en cada nuevo uso, debe suministrarse la semilla devuelta por
la iteraci ´on anterior. Esto es as´ı para satisfacer el requerimiento de que cada nueva semilla
se calcula en base a la anterior, y es necesario para garantizar el correcto funcionamiento
del algoritmo.
Actividad de Programaci ´on 8
Agregue los dos procedimientos de generaci ´on de n ´umeros seudoaleatorios a
su Biblioteca, puesto que constituyen un recurso importante y general.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 224 of 312 --

225
Generaci ´on de piezas
Habiendo presentado las ideas de generaci ´on de n ´umeros seudoaleatorios, estamos
en condiciones de codificar la generaci ´on de nuevas piezas. Este c ´odigo tomar ´a como
par ´ametro una semilla que servir ´a para alimentar al generador de n ´umeros de la biblioteca,
y producir ´a 4 datos:
el c ´odigo de la pr ´oxima pieza,
el tipo de la pr ´oxima pieza,
la columna en la que debe introducirse la pr ´oxima pieza y
la nueva semilla para continuar la generaci ´on de n ´umeros en el futuro.
El primer dato se puede leer simplemente de la secci ´on de pr ´oxima pieza del tablero (ver
secci ´on 5.1), para lo que pueden usarse las operaciones definidas en la subsecci ´on 5.3.1.
Para los siguientes 2 datos se utilizar ´a el generador de n ´umeros seudoaleatorios, y el
´ultimo de ellos ser ´a producido por este mismo proceso. El c ´odigo resultante es el siguiente
function determinarNuevaPieza(semilla)
/*
PROP´OSITO: devolver c´odigo, tipo y ubicaci´on para
una nueva pieza de manera seudorand´omica
en base a una semilla. Tambi´en devuelve
la nueva semilla