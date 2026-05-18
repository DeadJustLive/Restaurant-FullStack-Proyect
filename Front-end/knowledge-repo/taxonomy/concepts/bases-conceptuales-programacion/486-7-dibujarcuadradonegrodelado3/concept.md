# 7. DibujarCuadradoNegroDeLado3

## Fuente
bases-conceptuales-programacion (Cap. 486)

## Contenido
# 7. DibujarCuadradoNegroDeLado3

Los ejemplos 1, 2 y 4 comienzan con min ´uscula. Los ejemplos 3, 5, 6 y 7 comien-
zan con may ´usculas. Por otra parte, los ejemplos 5, 6 y 7 est ´an escritos en una
forma mixta conocida como camelCase, que es la que vamos a utilizar en este
De Wikipedia: “CamelCase es
un estilo de escritura que se apli-
ca a frases o palabras compues-
tas. El nombre se debe a que
las may ´usculas a lo largo de una
palabra en CamelCase se ase-
mejan a las jorobas de un ca-
mello. El nombre CamelCase se
podr´ıa traducir como May ´uscu-
las/Min ´usculas en Camello.”
es.wikipedia.org/wiki/
CamelCase
libro. Existen otras formas de escribir identificadores, y cada programador tiene
su propio estilo. Vamos a hablar de cuestiones de estilo en la secci ´on 2.3.
Actividad 8
Escribir al menos otros diez identificadores, que sirvan para describir
valores complejos y acciones cotidianas. Por ejemplo, sumarDosYTres,
FreirUnHuevo, etc ´etera.
Teniendo la capacidad de denotar elementos a trav ´es de los identificadores, es-
tamos en condiciones de definir procedimientos.
Definici ´on de procedimientos simples
La forma general de una declaraci ´on de procedimiento simple est ´a dada por la
siguiente definici ´on.
Definici ´on 2.2.21. Un procedimiento simple es un nuevo comando definido por
el programador mediante el mecanismo de darle un nombre a un bloque median-
te un identificador. La definici ´on de un procedimiento simple tiene la forma
procedure < procName >()
< bloque >
siendo < procName > un identificador que comienza en may ´uscula, y < bloque >
¡Recordar que la notaci ´on quiere
decir que esto debe reemplazar-
se por un identificador que nom-
bre al procedimiento, y no por la
palabra procName!
un bloque cualquiera.
Los par ´entesis son necesarios; su utilidad se comprender ´a en el cap´ıtulo 3, don-
de se definir ´an formas m ´as complejas de procedimientos. Por el momento solo
se ver ´an las formas m ´as simples de los mismos.
Leer con Atenci ´on
Un procedimiento simple es un bloque al que se le pone nombre.
Ese nombre podr ´a ser utilizado como un comando.
Un ejemplo de procedimiento definido (o declarado) por el programador ser´ıa
procedure PonerDosVerdes()
{ Poner(Verde); Poner(Verde) }
Es importante observar que un procedimiento definido por el programador por
s´ı solo NO constituye un programa. La diferencia entre un procedimiento definido
por el programador y un programa es que el el programa determina completa-
mente la tarea que el cabezal debe llevar a cabo, mientras que el procedimiento
define solo una parte. El programa se usa indicando externamente al cabezal
que lo ejecute, pero un procedimiento definido por el programador debe ser invo-
cado de manera expl´ıcita como comando por el c ´odigo del programa para que el
mismo sea tenido en cuenta por la m ´aquina. Entonces
program
{
PonerDosVerdes()
PonerDosVerdes()
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 61 of 312 --

62
}
procedure PonerDosVerdes()
{ Poner(Verde); Poner(Verde) }
es un programa GOBSTONES que coloca cuatro bolitas verdes en la celda actual.
Observemos que la definici ´on del procedimiento PonerDosVerdes debe darse a
continuaci ´on del programa para que el comando PonerDosVerdes() tenga senti-
do durante la ejecuci ´on.
Definici ´on 2.2.22. Un procedimiento declarado por usuario puede ser utilizado
como comando. Se escribe el nombre seguido por par ´entesis:
< procName >()
El efecto de dicho comando es el mismo que el del bloque definido en la decla-
raci ´on del procedimiento del mismo nombre.
Si se utiliza un comando que no es primitivo ni fue definido por el programador,
el programa fallar ´a.
Observar c ´omo la tarea de poner dos bolitas verdes ya no queda expre-
sada ´unicamente por una secuenciaci ´on, sino que a trav ´es del uso de proce-
dimientos hemos podido darle un nombre significativo a esa tarea. Cada vez
que precisemos poner dos bolitas verdes podemos recurrir al nuevo comando
Para que sea realmente un nue-
vo comando, su definici ´on debe
encontrarse entre las definicio-
nes de procedimientos del pro-
grama.
PonerDosVerdes().
Un defecto muy com ´un en la ense ˜nanza de la programaci ´on (imperativa) es
ignorar completamente a los procedimientos hasta que el estudiante conoce mu-
chas otras formas b ´asicas de comandos. Y esto lleva a escribir programas que
son extremadamente dif´ıciles de leer, por estar pensados en demasiado bajo ni-
vel. En el pasado, cuando las computadoras eran lentas y ten´ıan poca memoria,
se hac´ıa imprescindible ahorrar los recursos (tiempo y memoria) al m ´aximo, por
lo que no resultaba conveniente utilizar muchos procedimientos. Pero hoy en d´ıa,
cuando los recursos se han ido multiplicando exponencialmente hasta no ser un
problema, y donde adem ´as la tecnolog´ıa de procesamiento de programas (cons-
trucci ´on de compiladores, an ´alisis est ´atico de c ´odigo, etc ´etera) ha evolucionado
much´ısimo, resulta mucho mejor utilizarlos desde el comienzo pa
