# 1957. Realiz ´o nu-

## Fuente
bases-conceptuales-programacion (Cap. 481)

## Contenido
# 1957. Realiz ´o nu-

merosas con-
tribuciones en
matem ´aticas, pero su nombre
se conoce por su aporte a la ar-
quitectura de las computadoras.
tura de m ´aquinas que usaban la misma memoria para almacenar los datos y los
“programas”. La arquitectura von Neumann, o alguna de sus variantes, es a ´un
hoy utilizada por, pr ´acticamente, todas las formas de computadoras existentes.
Estos dos descubrimientos permitieron, durante la Segunda Guerra Mundial
el desarrollo pr ´actico de las primeras computadoras: los trabajos del alem ´an Zu-
se, los trabajos ingleses en la l´ınea Colossus y los trabajos americanos en la l´ınea
ENIAC. Pero reci ´en en la d ´ecada de 1950 se comenzaron a producir computado-
ras a nivel comercial. Estaban basadas en tubos de vac´ıo llamados “v ´alvulas” y
eran enormes y costosas, y su poder de c ´omputo era menor que el de un tel ´efono
digital moderno. Sin embargo significaron una revoluci ´on en t ´erminos de c ´alcu-
lo para la ´epoca. Fueron la llamada “primer generaci ´on” de computadoras. La
“segunda generaci ´on” aparece a fines de esa d ´ecada, cuando las v ´alvulas son
reemplazadas por transistores, y permiten iniciar la carrera para disminuir el ta-
ma ˜no de las computadoras. Las computadoras de la segunda generaci ´on son
m ´as peque ˜nas y consumen menos electricidad que las anteriores.
Durante la d ´ecada de 1960 se invent ´o el circuito integrado, que fue la clave
para el desarrollo del microprocesador, que dio lugar a la “tercera generaci ´on”.
Los circuitos integrados son pastillas de silicio en las que se colocan miles de
componentes electr ´onicos en una integraci ´on en miniatura.
Para Ampliar
Para saber m ´as sobre el desarrollo del hardware, especialmente las pri-
meras computadoras, consultar:
http://en.wikipedia.org/wiki/Computer_history y
http://es.wikipedia.org/wiki/Generaciones_de_computadoras
Todas estas computadoras iniciales se programaban en lenguaje binario, o sea,
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 28 of 312 --

29
a trav ´es de lo que com ´unmente se denomina “ceros y unos”, y que en realidad
en esa ´epoca eran agujeros (o su ausencia) en tarjetas perforadas. Con este
lenguaje binario se codificaban instrucciones para indicar las acciones que las
Se suele decir que los 0s y 1s,
constituyen la base f´ısica de la
jerarqu´ıa conceptual de los pro-
gramas. Sin embargo, este len-
guaje es en realidad una abs-
tracci ´on que expresa la presen-
cia o ausencia de algo a trav ´es
de 2 n ´umeros y de combinacio-
nes de los mismos, aunque el
hecho de que esta tambi ´en sea
una abstracci ´on pr ´acticamente
no se tiene en cuenta al conside-
rar las abstracciones dadas por
los lenguajes.
m ´aquinas intentaban llevar adelante. Los primeros lenguajes de programaci ´on
reemplazaban entonces estas cadenas de 0s y 1s por “palabras” que fueran m ´as
f ´aciles de recordar por los humanos que constru´ıan los programas (instrucciones
mnem ´onicas), como MOVE, LDA, ADD, etc., las cuales constituyeron la primer
abstracci ´on sobre la capa f´ısica. La relaci ´on entre las instrucciones mnem ´onicas
y el c ´odigo binario era directa: por cada mnem ´onico exist´ıa una instrucci ´on en
binario y viceversa. As´ı se construyen los primeros traductores que traducen ins-
trucciones mnem ´onicas a binario; recibieron el nombre de ensambladores, y se
convirtieron en los primeros lenguajes de programaci ´on de computadoras de la
historia.
Cada computadora ven´ıa con su propio lenguaje ensamblador (assembly lan-
guages en ingl ´es), y cada programador deb´ıa aprenderlo junto con las carac-
ter´ısticas espec´ıficas de la m ´aquina en cuesti ´on. Pero programar en assembler
Si intentamos ser precisos, no
se trata de un lenguaje, sino de
un tipo o familia de lenguajes.
Pero es com ´un referise a esta fa-
milia como si se tratase de un
lenguaje ´unico.
requer´ıa tremendos esfuerzos intelectuales y era muy f ´acil cometer errores, pues-
to que hab´ıa que atender todos y cada uno de los aspectos de las m ´aquinas
que se programaban, los cuales no eran pocos ni simples, puesto que atend´ıan
a cada uno de los componentes espec´ıficos que cada m ´aquina pose´ıa con sus
caracter´ısticas de funcionamiento particulares. Adem ´as, al querer realizar un pro-
grama para otra computadora deb´ıa aprenderse todo el lenguaje de nuevo desde
el comienzo, puesto que cada computadora ten´ıa un conjunto diferente de com-
ponentes, y el lenguaje ensamblador de cada m ´aquina reflejaba en su estructura
estos componentes. El problema para los programadores con el lenguaje assem-
bler es que el mismo se acerca m ´as a la forma de operar de las computadoras
y no a la forma de pensar de los humanos; o sea, en los t ´erminos que maneja-
mos en este cap´ıtulo, es un lenguaje de muy bajo nivel. En ese momento era
necesario este tipo de manejo de bajo nivel, puesto que los recursos de los que
dispon´ıa una computadora eran extremadamente escasos y deb´ıan, por lo tanto,
ser administrados 
