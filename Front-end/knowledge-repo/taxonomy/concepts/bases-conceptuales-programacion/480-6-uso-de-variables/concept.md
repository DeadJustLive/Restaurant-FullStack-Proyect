# 6. Uso de variables

## Fuente
bases-conceptuales-programacion (Cap. 480)

## Contenido
# 6. Uso de variables

Otros conceptos dados en el libro no entran correctamente en esta clasifica-
ci ´on. Por esa raz ´on ofrecemos adem ´as un mapa conceptual de los conceptos
principales (los principales de los que fueron categorizados, y los que no lo fue-
ron), mostrando as´ı la interrelaci ´on que existe entre todas las ideas trabajadas.
El mapa conceptual de este libro se presenta en el gr ´afico G.1.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 21 of 312 --

22
G.1. Mapa conceptual del libro
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 22 of 312 --

23
La disciplina de la programaci ´	on
En este primer cap´ıtulo comenzaremos a conocer el mundo de la programaci ´on.
Analizaremos introductoriamente la idea de lenguaje de programaci ´on y de pro-
grama, y veremos c ´omo surge la necesidad de contar con este tipo de lenguajes,
a partir de analizar brevemente la historia del surgimiento de los mismos.
A partir de estas nociones iniciales acerca de qu ´e trata la programaci ´on y
del concepto de lenguaje de programaci ´on nos prepararemos para aprender las
nociones fundamentales que todo programador maneja.
1.1. ¿Qu ´e es la programaci ´on?
La programaci ´on es una disciplina que requiere simult ´anemente del uso de cier-
to grado de creatividad, un conjunto de conocimientos t ´ecnicos asociados y la
capacidad de operar constantemente con abstracciones (tanto simb ´olicas como
enteramente mentales).
La creatividad necesaria para programar no se diferencia demasiado de aque-
lla utilizada para producir textos. Sin embargo, lo que hace a la programaci ´on algo
especial es que requiere emplear un conjunto de conocimientos t ´ecnicos asocia-
dos a la manipulaci ´on de las computadoras. Esto agrega un grado notable de
rigurosidad a esta actividad, ya que no podemos programar sin tener en cuenta
este aspecto. Por otra parte, al poseer una naturaleza ligada a la resoluci ´on de di-
ferentes problemas del mundo real, se requiere de una capacidad de abstracci ´on
que permita operar sin que los conocimientos t ´ecnicos limiten al programador a
resolver adecuadamente dichos problemas.
Para Reflexionar
Ejemplos de actividades que requieren:
un uso intensivo de la creatividad son las relacionadas con el arte;
conocimientos t ´ecnicos profundos son las relacionadas con la me-
dicina, electr ´onica y qu´ımica;
operar continuamente en abstracto son las relacionadas con filo-
sof´ıa, l ´ogica y matem ´atica.
Todas las actividades mencionadas parecen dis´ımiles. ¿Por qu ´e la pro-
gramaci ´on incluye y utiliza intensamente dichas capacidades?
A lo largo de la vida los seres humanos continuamente enfrentamos todo tipo
de problemas. Para ello nos valemos de diversas herramientas, que combinadas
de maneras innovadoras ampl´ıan el espectro de soluciones y vuelven factible el
desarrollo. Los programadores se dedican principalmente a construir programas.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 23 of 312 --

24
Leer con Atenci ´on
¿Qu ´e es un programa? Un programa es una descripci ´on ejecutable de
soluciones a problemas computacionales, es decir, un texto descriptivo
que al ser procesado por una computadora da soluci ´on a un problema
propuesto por los humanos. De esta manera, la parte descriptiva de los
programas es el texto que el programador le provee a la computadora.
Definici ´on 1.1.1. Un programa es una descripci ´on ejecutable de soluciones a
problemas computacionales.
La descripciones dadas por los programas pueden estar escritas con diferentes
s´ımbolos y para diferentes prop ´ositos. Cuando el c ´odigo consiste mayormente de
palabras y nociones que son m ´as sencillas para que manejen los humanos, con
el objetivo de que puedan entender y construir los programas, hablamos de un
lenguaje de alto nivel, y al c ´odigo resultante lo llamamos c ´odigo fuente del pro-
grama. Cuando el c ´odigo consiste mayormente de n ´umeros y s´ımbolos de dif´ıcil
comprensi ´on para los humanos, pero de r ´apida interpretaci ´on para su ejecuci ´on
por una m ´aquina, hablamos de un lenguaje de bajo nivel, y al c ´odigo resultante
lo llamamos c ´odigo objeto o c ´odigo ejecutable. Hablaremos entonces de un nivel
alto de abstracci ´on cuando nos estemos refiriendo a abstracciones m ´as cercanas
a las ideas del problema a ser solucionado, a la mente de los programadores; y
de nivel bajo de abstracci ´on cuando nos refiramos a abstracciones m ´as cerca-
nas a las ideas relacionadas a las formas de funcionamiento de las m ´aquinas
que ejecutan los programas.
Es importante observar que tanto el c ´odigo fuente como el c ´odigo ejecutable
est ´an conformados por s´ımbolos, y en ese sentido es correcto llamar a ambos
programas. Esto suele crear confusi ´on, pues entonces la palabra programa se
utiliza para dos prop ´ositos diferentes: el c ´odigo que escribe el programador, y que
es el objeto de estudio de este libro, y el c ´odigo que ejecuta la computadora, que
es el resultado
