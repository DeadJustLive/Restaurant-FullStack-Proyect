# 4. Ventajas de la programación con TAD

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 194)

## Contenido
# 4. Ventajas de la programación con TAD

La utilización de la metodología de diseño descendente, mediante refinamientos sucesivos, facilita el desarrollo de
programas de “tamaño pequeño” (programación a pequeña escala). Dicha metodología resulta sin embargo insuficiente
para el diseño de programas de “medio o gran tamaño” (programación a media o gran escala).
El diseño por refinamientos sucesivos se basa en la abstracción de acciones (procedural o funcional).
Inconvenientes de ese mecanismo de abstracción para programar en gran escala son:
• 	Los tipos de datos utilizados son los predefinidos en el lenguaje, son tipos concretos o de bajo nivel, por tanto, existe
un desequilibrio: acciones abstractas (procedimientos o funciones) o de alto nivel que manipulan datos concretos o
de bajo nivel.

-- 20 of 267 --

13
• 	Las decisiones sobre representación de datos se toman al principio; deberían aplazarse hasta que se conozcan las
operaciones necesarias para cada tipo.
• 	En algoritmos de alto nivel hay que utilizar detalles de bajo nivel sobre los datos (se oscurecen los rasgos
importantes de esos algoritmos).
La clásica “ecuación” de N. Wirth:
programas = datos + algoritmos
es bastante representativa de la metodología de diseño basada en la abstracción de acciones. Esa ecuación podría refinarse
en la siguiente forma:
programas = datos + (algoritmos de datos + algoritmos de control)
entendiendo por “algoritmos de datos” los algoritmos de más bajo nivel encargados de la manipulación de las estructuras
de datos y por “algoritmos de control” a la parte del algoritmo que representa el método de solución del problema
(independiente, hasta cierto punto, de las estructuras de datos seleccionadas).
Los problemas mencionados se resuelven con la metodología de programación modular basada en TAD. Esta
metodología se puede resumir en la ecuación siguiente, en la que se han agrupado los términos “datos” y “algoritmos de
datos” en uno solo denominado “implementación de TAD”:
programas = implementación de TAD + algoritmos de control
Veamos un ejemplo.
Ejercicio: Diseñar un programa que lea una secuencia de enteros de un fichero y escriba en pantalla cada entero
distinto leído junto con su frecuencia de aparición, en orden de frecuencias decrecientes.
La metodología de programación basada en TAD sugiere posponer la decisión de cómo se almacenarán los enteros
leídos y sus frecuencias y suponer que existe un TAD llamado tabla para dicho almacenamiento. Las operaciones
necesarias en ese TAD se conocerán tras haber diseñado el programa principal (módulo usuario del TAD).
procedimiento estadística
importa tablas
variables
f:fichero de entero; nombre:cadena;
t:tabla; dato,orden,frec:entero
principio
escribir('Nombre del fichero: ');
leer(nombre);
asociar(f,nombre);
iniciarlectura(f);
inicializar(t);
mientrasQue not finFichero(f) hacer
leer(f,dato);
añadir(t,dato)
fmq;
disociar(f);
para orden:=1 hasta total(t) hacer
info(t,orden,dato,frec);
escribir('entero: ',dato,' frecuencia: ',frec)
fpara
fin
El algoritmo recoge sólo los aspectos esenciales. Falta implementar el tipo tabla, del cual se conocen ya su nombre
y requisitos de las operaciones, es decir, se conoce la interfaz:
módulo tablas
exporta
tipo tabla 	{ tabla de frecuencias de enteros }
procedimiento inicializar(sal t:tabla)

-- 21 of 267 --

14
{ Crea una tabla vacía t de frecuencias }
procedimiento añadir(e/s t:tabla; ent n:entero)
{ Modifica t incrementando en 1 la frecuencia de n }
función total(t:tabla) devuelve entero
{ Devuelve el nº de enteros distintos en la tabla t }
procedimiento info(ent t:tabla; ent i:entero; sal n,frec:entero)
{ Al terminar, n es el entero que ocupa el i-ésimo lugar en la tabla t,
en orden de frecuencias decrecientes, y frec es su frecuencia }
implementación
...
fin
El siguiente refinamiento lleva asociada la elección de la representación del TAD tabla y la implementación de las
operaciones. En la elección de la representación influyen las operaciones que deben implementarse (añadir e info,
fundamentalmente), pues debe buscarse la máxima eficiencia. Hay muchas soluciones posibles pero la elección no
modificará en nada el código del algoritmo principal (quizá únicamente su eficiencia).
Una metodología de programación en media o gran escala puede basarse en los refinamientos sucesivos de TAD:
• 	Primera fase: decidir las interfaces de todos los módulos (cada módulo define un TAD). Para ello no es necesario
detallar 	la 	representación 	e 	implementación 	de 	las 	operaciones, 	sino 	que 	basta 	con 	decidir 	si 	para
representar/implementar cada TAD se precisan otros TAD de más bajo nivel, para los que a su vez hay que definir
las interfaces correspondientes.
• 	Segunda fase: distribución del trabajo de implementación de cada módulo entre los diversos programadores del
equipo (cada programador detalla uno o más módulos). Para la implementación detallada de cada módulo sólo se
necesitan del resto las interfaces.
Para terminar, enumeramos algunos crit
