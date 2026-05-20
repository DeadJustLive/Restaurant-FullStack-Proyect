# K_A, K_SPACE

-> { OperacionRotarPieza(False) -- Sentido antihorario }
_ -> { OperacionBajarPiezas() }
}
Podemos observar que los d´ıgitos sirven para ir completando el c ´odigo de selecci ´on en
la zona correspondiente, las flechas a izquierda y derecha sirven para mover las piezas
hacia los costados, la flecha hacia abajo hace descender la pieza un lugar y la flecha para
arriba permite colocar una nueva pieza en el tablero. Las teclas de ENTER y espacio se
usan para rotar las piezas en sentido horario y antihorario respectivamente, y las teclas de
ESCAPE, DELETE y BACKSPACE vac´ıan la zona de selecci ´on. Todas las teclas especia-
les (flechas y comandos) tienen su contraparte en forma de letras. Cualquier tecla que se
toque que no figure entre las especificadas provocar ´a el decenso de las piezas.
5.8. Ejercitaci ´on
Habiendo completado la codificaci ´on b ´asica del juego de ZILFOST, resulta interesante
mostrar la capacidad de realizar modificaciones que tiene un programador a mano, y c ´omo
los conocimientos impartidos en este libro sirven para tal prop ´osito. Para ello proponemos
una serie de cambios de diferente complejidad que permitir ´an practicar las habilidades
obtenidas. Al realizar estos cambios seguramente ser ´a necesario ir haciendo ajustes en el
c ´odigo que se va escribiendo, puesto que al realizar modificaciones que requieren alterar
diversas partes del c ´odigo es com ´un olvidar alguna y tener que irlas corrigiendo a medida
que se descubren.
El primero de los cambios propuestos es sencillo: modificar el momento en el que
las piezas bajan. En el c ´odigo que presentamos en el anexo B, las piezas bajan des-
pu ´es de que se completa el ingreso de un c ´odigo de selecci ´on. Sin embargo, esta opci ´on
puede ser f ´acilmente cambiada modificando los lugares donde aparece la invocaci ´on a
BajarPiezasDeZonaDeJuego.
Actividad de Programaci ´on 9
Realice el ejercicio 5.8.1 y codif´ıquelo en una copia del c ´odigo, as´ı puede probar
ambas versiones por separado y comprarlas.
Ejercicio 5.8.1. Modificar el c ´odigo del ZILFOST de manera que en lugar de que las pie-
zas bajen despu ´es de completar el ingreso del c ´odigo de selecci ´on, lo hagan despu ´es
de cada movimiento de pieza (rotar, mover a izquierda o derecha o ingresar una nueva
pieza).
Como dijimos, es un ejercicio sencillo, puesto que no involucra modificar ninguna de las
operaciones de base, sino solamente las operaciones de interacci ´on (de la secci ´on B.6
del anexo B).
El siguiente cambio tiene una complejidad apenas mayor. Consiste en modificar las
primitivas que establecen el formato del tablero, de tal manera de lograr que la zona de
semilla ocupe solo el ancho de la zona de juego, y las zonas de n ´umeros del sector
de datos est ´en m ´as abajo, de manera tal que la zona de pr ´oxima pieza se encuentre a
continuaci ´on de la zona de semilla, hacia la izquierda.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 230 of 312 --

231
Actividad de Programaci ´on 10
Realice el ejercicio 5.8.2 y pru ´ebelo en el c ´odigo del ZILFOST. Recuerde que
para este ejercicio debe modificar los tableros iniciales que tuviera guardados
ya que si no lo hace, no se cumplir´ıan las precondiciones correspondientes y el
programa fallar´ıa. ¡Y recuerde cambiar todos los comentarios correspondientes!
Ejercicio 5.8.2. Realizar los cambios de codificaci ´on necesarios para lograr que la zona
de semilla sea solo tan ancha como la zona de juego, la zona de c ´odigo de pr ´oxima pieza
est ´e a la izquierda de la de semilla y la zona de c ´odigo de selecci ´on de pieza siga estando
justo arriba de la zona de c ´odigo de pr ´oxima pieza.
Ayuda: el procedimiento IrAlOrigenDeZonaDeProximaPieza es el ´unico que requiere
modificaciones.
La complejidad de este cambio reside en que se est ´an modificando las propiedades que
el tablero debe cumplir para representar a un juego v ´alido, y por ello, las operaciones de
base, lo cual requiere modificar la totalidad de los tableros preexistentes para adaptarlos
a este nuevo uso. En particular, hay que preservar las propiedades de las zonas de n ´ume-
ros, acerca de la forma de codificar sus l´ımites. Estos cambios no deber´ıan repercutir de
ninguna manera en las operaciones de m ´as alto nivel del juego (las que tienen que ver
con piezas, movimientos o interacci ´on).
Una cambio de complejidad media consiste en agregar el c ´odigo necesario para que
la pr ´oxima pieza que vaya a ser colocada en la zona de juego se muestre previamente en
la zona de datos. Se plantea en varios ejercicios, para ir guiando la soluci ´on.
Actividad de Programaci ´on 11
Realice los ejercicios desde el ejercicio 5.8.3 hasta el ejercicio 5.8.6 y pru ´ebelos.
Recuerde utilizar una copia del c ´odigo del ZILFOST, para poder comparar ambas
versiones.
Ejercicio 5.8.3. Escribir un procedimiento IrAZonaDeEsperaProximaPieza que se ubique
en la zona de datos en el lugar elegido para visualizar la pr ´oxima pieza.
Para este ejercicio debe decidirse d ´onde ser ´a el lugar para visualizar la pieza, de manera
que todas las piezas posibles quepan en el mismo.
Ejercicio 5.8.4. Escribir un procedimiento ColocarPiezaEnZonaDeEspera que reciba los
mismos par ´ametros que el procedimiento ColocarNuevaPieza, pero que en lugar de dibu-
jarla en la zona de juego la dibuje en la zona de espera. Tener en cuenta que, adem ´as de
codificar el tipo de pieza (su pivote), se hace necesario codificar el par ´ametro de ubicaci ´on
(para su uso futuro).
Sugerencia: una forma posible de codificar el par ´ametro de ubicaci ´on es utilizar pie-
zas azules en el pivote.
Para este ejercicio se hace necesario reutilizar los procedimientos ColocarPieza y el re-
ci ´en definido IrAZonaDeEsperaProximaPieza, y pensar un procedimiento auxiliar para co-
dificar el par ´ametro de ubicaci ´on.
Ejercicio 5.8.5. Escribir una funci ´on leerPiezaZonaDeEspera que retorne el c ´odigo, el
tipo y la ubicaci ´on de la pieza en la zona de espera.
Tener en cuenta que esta funci ´on debe devolver varios valores, al igual que la funci ´on
determinarNuevaPieza.
Ejercicio 5.8.6. Modificar el procedimiento OperacionColocarNuevaPieza para que ubi-
que la pieza en la zona de espera en la zona de juego, y una nueva pieza en la zona
de espera. Tener en cuenta que si no hay pieza en la zona de espera (por tratarse de la
primera pieza), deber ´a comenzarse poniendo una all´ı.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 231 of 312 --

232
Para este ejercicio ser ´a necesario utilizar QuitarPiezaActual y ColocarPieza, verifican-
do que se puedan utilizar en la zona de espera. Adem ´as, puede que la zona de c ´odigo
de pr ´oxima pieza indique un n ´umero m ´as de las piezas en la zona de juego, por contabi-
lizar la pieza en la zona de espera; ser´ıa interesante que esto no fuera as´ı, para lo cual
deber ´a ajustarse adecuadamente el c ´odigo.
El ´ultimo de los cambios que proponemos es el de mayor complejidad, pues involucra
la interactividad. Consiste en que la pieza seleccionada sea destacada (por ejemplo, me-
diante el sencillo mecanismo de hacer de su pivote la celda actual al mostrar un tablero
de juego), y en modificar el procedimiento de selecci ´on de piezas para que en lugar de
ingresar un n ´umero por d´ıgitos en la zona de selecci ´on, se utilice una tecla (por ejemplo,
K TAB) para ir seleccionando alternativamente diferentes piezas (tambi ´en puede ser un
agregado y no una modificaci ´on). Es deseable para este cambio que siempre haya una
pieza seleccionada, y que el c ´odigo de la misma se visualice en la zona de selecci ´on (lue-
go de cada cambio de pieza debe actualizarse la zona de selecci ´on de manera acorde).
Para este cambio delineamos las modificaciones principales en los siguientes ejercicios,
pero es posible que hagan falta mayores ajustes que deben detectarse a medida que se
prueban los cambios.
Actividad de Programaci ´on 12
Realice los ejercicios entre el ejercicio 5.8.7 y el ejercicio 5.8.16 y pru ´ebelos en
una copia del c ´odigo. Recuerde que puede ser necesario que tenga que realizar
varios ajustes antes de que la versi ´on final se comporte como es deseado, ya
que todos estos procedimientos deben trabajar de manera sincronizada.
Ejercicio 5.8.7. Modificar todas las operaciones de interacci ´on para que luego de termi-
nar ubiquen el cabezal en la pieza seleccionada y no borren la zona de selecci ´on (puesto
que ahora la zona de selecci ´on debe siempre contenter un c ´odigo de pieza seleccionada
en caso que haya piezas en la zona de juego).
Para ir a la pieza seleccionada puede reutilizarse IrAPiezaSiExiste, teniendo en cuenta
leer el c ´odigo correspondiente de la zona de selecci ´on.
Sin embargo, no es suficiente con estas modificaciones, pues existen operaciones
que modifican la cantidad de piezas y consecuentemente pueden producir que la pieza
seleccionada deje de existir. Por ello, deben realizarse modificaciones adicionales.
Ejercicio 5.8.8. Escribir un procedimiento GrabarZonaDeSeleccion que reciba un c ´odigo
de pieza v ´alido y lo grabe en la zona de selecci ´on de piezas.
Este procedimiento ser ´a necesario cuando la pieza seleccionada cambie por efecto de
alguna de las operaciones.
Ejercicio 5.8.9. Modificar el procedimiento OperacionColocarNuevaPieza para que al co-
locar una pieza en la zona de juego, esta se transforme en la nueva pieza seleccionada.
Recordar que para esto, deben grabarse su c ´odigo en la zona de selecci ´on y luego ir a la
pieza seleccionada.
Esta modificaci ´on simplifica la necesidad de controlar si hay o no piezas en la zona de
juego al agregar una pieza, ya que la misma siempre resulta seleccionada. Pero de todas
maneras, puede que en algunas situaciones la zona de juego se quede sin piezas por lo
que deben hacerse m ´as operaciones.
Ejercicio 5.8.10. Escribir EncontrarPiezaParaSeleccionarSiExiste, un procedimiento
que recorra la zona de juego y se ubique en alguna de las piezas de la misma, si existe
alguna.
Estructurarlo como un recorrido que arranque en el origen de la zona de juego.
Ejercicio 5.8.11. Escribir un procedimiento RenovarPiezaSeleccionada que, si la pieza
indicada actualmente en la zona de selecci ´on no existe m ´as en la zona de juego, encuen-
tre una nueva pieza para seleccionar, si existe, y actualice la zona de juego de manera
correspondiente (puede ser que deba grabar un nuevo c ´odigo en ella, o borrar dicha zona,
seg ´un el caso).
Ayuda: reutilizar el procedimiento del ejercicio anterior.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 232 of 312 --

233
Este procedimiento de renovaci ´on ser ´a ´util luego de que las piezas se transforman en
piso, para que no quede desactualizada la zona de juego.
Ejercicio 5.8.12. Modificar el procedimiento ExtenderElPiso para que luego de terminar
con la extensi ´on del piso, verifique si la pieza seleccionada no desapareci ´o (por haber sido
transformada en piso) y en dicho caso, la renueve.
De esta manera, se contribuye a garantizar que, de haber piezas, una de ellas est ´a selec-
cionada.
Solo falta realizar las operaciones necesarias a asociar con la tecla K TAB para realizar
la rotaci ´on en la selecci ´on de piezas.
Ejercicio 5.8.13. Escribir el procedimiento EncontrarProximaPieza que, suponiendo que
hay una pieza seleccionada, encuentra la pieza siguiente a la pieza seleccionada actual
(si la misma existe). Tener en cuenta que este procedimiento, en lugar de arrancar del
origen, arranca desde la pieza seleccionada; tambi ´en debe considerarse el hecho de que
el final del recorrido no es el final de la zona de juego, sino haber retornado a la pieza
seleccionada (o sea, debe rotarse por todas las piezas de la zona de juego y no solo por
las que est ´an despu ´es de la seleccionada).
Ejercicio 5.8.14. Escribir un procedimiento CambiarPiezaSeleccionada que, reutilizando
el procedimiento del ejercicio anterior, cambie la pieza seleccionada y actualice de manera
acorde la zona de selecci ´on.
Este procedimiento se utilizar ´a en una operaci ´on de interfaz para cambiar la pieza selec-
cionada.
Ejercicio 5.8.15. Escribir OperacionCambiarPiezaSeleccionada, un procedimiento que
provea la interfaz adecuada con el procedimiento anterior.
Esta operaci ´on de interfaz consiste en simplemente invocar al procedimiento previamente
definido. Se recomienda realizara para proveer una adecuada separaci ´on de niveles, as´ı el
programa principal solo utiliza operaciones de interfaz.
El cambio se completa con la modificaci ´on del programa interactivo para que la tecla
K TAB se asocie a la operaci ´on correspondiente.
Ejercicio 5.8.16. Modificar el programa interactivo para asociar la tecla K TAB con la ope-
raci ´on de cambio de pieza seleccionada.
Otros cambios posibles quedan librados a la imaginaci ´on del programador. Algunos
que son conocidos de otros juegos tipo TETRISTM son: la posibilidad de contar con una
“pieza de reserva” que se puede intercambiar con la pr ´oxima pieza a aparecer; la posibi-
lidad de tener piezas especiales (como por ejemplo, piezas con la capacidad de borrar el
piso cuando lo tocan, etc ´etera); y, de mayor complejidad, la posibilidad de que las piezas
no se transformen en piso apenas entran en contacto con el piso, sino un turno despu ´es, lo
que permitir´ıa acomodarlas a ´ultimo momento. En cada caso, debe dise ˜narse la soluci ´on
(decidiendo c ´omo se representar ´a cada concepto en t ´erminos de bolitas de manera que
no entre en conflicto con otras representaciones existentes) y agregar o modificar c ´odigo
seg ´un sea necesario.
5.9. Comentarios Finales
Codificar una aplicaci ´on completa, y m ´as cuando la misma se trata de un juego, es una
tarea para la que GOBSTONES no fue pensado inicialmente. Sin embargo puede verse el
poder de los conceptos que maneja este lenguaje en el hecho de que es posible codificar
tal aplicaci ´on.
En el dise ˜no y codificaci ´on de una aplicaci ´on completa entran muchos conceptos, al-
gunos presentados en este libro y otros que exceden completamente esta presentaci ´on. Si
bien la aplicaci ´on que mostramos utiliza todos los conceptos presentados (con el objetivo
de ejemplificar su uso), hay varios conceptos adicionales, especialmente los relacionados
con el dise ˜no general, que no fueron tratados por el libro, pero que son necesarios para la
construcci ´on correcta de programas de cierta envergadura.
Uno de tales conceptos es la separaci ´on completa entre diferentes partes del pro-
grama. Por ejemplo, todo lo que tenga que ver con interfaz de usuario est ´a claramente
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 233 of 312 --

234
separado de la l ´ogica del programa. Como se puede ver, la mayor´ıa del c ´odigo presenta-
do no hace ning ´un tipo de consideraci ´on con respecto a c ´omo se comunica el usuario con
el programa, o c ´omo se visualiza gr ´aficamente el juego (aunque la codificaci ´on en el ta-
blero tiene en cuenta tambi ´en algunos aspectos visuales). Otra separaci ´on interesante es
la que se da entre la representaci ´on de la geometr´ıa del juego y las operaciones que esta-
blecen la mec ´anica del mismo. Finalmente, otra separaci ´on m ´as puede encontrarse entre
la representaci ´on de las piezas y diferentes componentes y su utilizaci ´on en el programa
(aunque en este caso dicha separaci ´on no siempre es total). Todos estos conceptos tienen
que ver con procesos de abstracci ´on y se estudian en cursos m ´as avanzados de progra-
maci ´on, como ser cursos de estructuras de datos, de interfases de ususario, etc ´etera.
Otro de los conceptos fundamentales que se utiliz ´o en el dise ˜no de esta aplicaci ´on es
la utilizaci ´on del tablero para representar diferentes estructuras. En este caso, las zonas
y las piezas se representan directamente en el tablero y se proveen operaciones para
manipular zonas y piezas que tienen en cuenta esta representaci ´on. En lenguajes m ´as
avanzados no se utilizar´ıan este tipo de codificaciones de bajo nivel, sino representaciones
que usen estructuras de datos m ´as avanzadas.
Finalmente, otro de los conceptos importantes utilizados tiene relaci ´on con el concepto
de precondici ´on, pero en este caso aplicada a los datos. Al representar los elementos
en el tablero asumimos determinados requerimientos que deb´ıan cumplirse de manera
espec´ıfica (por ejemplo, la propiedad de que la primera celda en un recorrido noreste con
5 bolitas azules sea la que se encuentra a la izquierda del origen de la zona de juego, la
forma de rodear las diferentes zonas, la propiedad de que en la zona de juego solo hay
piezas completas o piso, la propiedad de que no existen dos piezas con el mismo c ´odigo
en la zona de juego, la propiedad de que todas las piezas quedan identificadas por su
pivote, etc ´etera). Estas propiedades se cumplen en cada uno de los tableros que se le
presentan al usuario para interactuar, y muchas de ellas se cumplen a lo largo de todo el
programa (incluso cuando se est ´a realizando una operaci ´on de modificaci ´on). As´ı como los
requerimientos de un procedimiento o funci ´on para funcionar se llaman precondiciones, a
los requerimientos que los datos deben cumplir para ser considerados v ´alidos se los llama
invariantes de representaci ´on. Esta noci ´on no fue presentada formalmente en este libro,
y sin embargo se utiliz ´o de manera extensiva en la representaci ´on del ZILFOST, y en las
precondiciones de pr ´acticamente todas las operaciones del juego.
Entre los conceptos que s´ı fueron tratados en este libro y que fueron fundamenta-
les para el dise ˜no de esta aplicaci ´on podemos mencionar la separaci ´on en subtareas y
la adecuada parametrizaci ´on. Tambi ´en el concepto de recorridos fue utilizado extensiva-
mente. Finalmente, las cuestiones de estilo, como comentar adecuadamente el c ´odigo,
nombrar adecuadamente los diferentes elementos (procedimientos y funciones, par ´ame-
tros, variables, etc ´etera) y la indentaci ´on correcta, resultaron de excelente ayuda para la
comprensi ´on del c ´odigo producido.
Constituye una buena forma de aprender el intentar detectar cada uso de los concep-
tos presentados en el libro dentro de la aplicaci ´on, y su replicaci ´on conciente a la hora de
construir aplicaciones y juegos propios. Y tambi ´en el intentar deducir los otros conceptos
presentados que mencionamos en esta reflexi ´on final de la aplicaci ´on.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 234 of 312 --

235
¿C ´	omo continuar aprendiendo a
programar?
El aprendizaje de la programaci ´on no se agota en los conceptos b ´asicos que trabajamos
en este libro. Hace falta conocer muchas herramientas abstractas de programaci ´on m ´as,
diversas complejidades, paradigmas, lenguajes, herramientas de soporte, cuestiones de
arquitectura, y una multitud de etc ´eteras antes de poder decir que uno es un programador.
Sin embargo, la base provista en este libro es lo suficientemente s ´olida como para que
todo eso sea posible.
La pregunta que surge naturalmente es la que utilizamos para el t´ıtulo del cap´ıtulo:
¿c ´omo continuar aprendiendo a programar, dada tal cantidad de cosas a conocer para ser
programador? Nosotros creemos que hay algunos caminos que son mejores que otros y
los discutimos en este cap´ıtulo de cierre.
6.1. Estructuras de datos, algor´ıtmica y lenguajes
El primer lugar en esta lista de continuaciones lo tienen las estructuras de datos. Como
vimos en el cap´ıtulo anterior, programar una aplicaci ´on que no sea trivial utilizando ex-
clusivamente el tablero requiere much´ısimo esfuerzo y resulta en c ´odigo complejo y no
siempre lo suficientemente eficiente. Las estructuras de datos son formas de organizar
los datos en unidades complejas, mucho mayores y con mayor flexibilidad que simple-
mente n ´umeros, colores, booleanos o direcciones. Un elemento de un tipo de datos que
representa a una estructura es un valor compuesto por muchos datos individuales, con
diferentes alternativas y accesibles de diferentes maneras seg ´un de la estructura de que
se trate.
Existen numerosos enfoques para el aprendizaje de estructuras de datos. Sin em-
bargo, al igual que sucede con el aprendizaje inicial de programaci ´on, muchos de esos
enfoques fallan en focalizarse adecuadamente en un conjunto de conceptos fundamen-
tales, y normalmente abruman al estudiante con una cantidad de detalles que no hacen
a la base conceptual. Por esa raz ´on, creemos que se hace necesario dise ˜nar un enfo-
que espec´ıfico para dar los primeros pasos en estructuras de datos. Junto con el material
presentado en este libro, se dise ˜n ´o tal enfoque para el curso de Introducci ´on a la Progra-
maci ´on de la carrera de Tecnicatura en Programaci ´on Inform ´atica de la UNQ, pero no fue
inclu´ıdo aqu´ı por problemas de alcance y extensi ´on. Dicho enfoque se centra en aprender
a modelar entidades mediante agrupaciones de datos heterog ´eneos, concepto denomina-
do con el t ´ermino registros, y a manipular colecciones de datos mediante secuencias
de entidades, concepto denominado con el t ´ermino listas. En ese enfoque tanto los re-
gistros como las listas se entienden desde el punto de vista de las operaciones que es
posible realizar sobre ellos, y no desde el punto de vista de su representaci ´on de memo-
ria. De esta manera el prop ´osito de centrarse en los aspectos denotacionales por sobre
los aspectos operacionales vuelve a ser centro en esta continuaci ´on.
Una vez aprendidos los conceptos de registros y listas desde un punto de vista deno-
tacional, nuestra sugerencia es continuar con estructuras recursivas algebraicas (diversos
tipos de ´arboles y otros tipos algebraicos, por ejemplo en el lenguaje HASKELL), tambi ´en
desde un punto de vista denotacional, para continuar luego con la teor´ıa de tipos abs-
tractos de datos. Reci ´en luego de manejar ampliamente los conceptos de abstracci ´on de
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 235 of 312 --

236
datos recomendamos incluir aspectos de implementaciones de bajo nivel utilizando me-
moria de manera expl´ıcita (por ejemplo en el lenguaje C, utilizando memoria din ´amica y
punteros), y profundizar en aspectos de eficiencia. Para completar el estudio b ´asico de
estructuras de datos recomendamos agregar estructuras de datos est ´aticas (arreglos y
matrices) y sus aplicaciones (heaps binarias, quicksort y binsort, hashing, etc ´etera).
El aprendizaje de estructuras de datos involucra al mismo tiempo el aprendizaje de
principios de algor´ıtmica. En este libro hemos iniciado los rudimentos del aprendizaje de
algoritmos al estudiar recorridos. Otros temas cl ´asicos de algor´ıtmica involucran el apren-
dizaje de soluciones recursivas (conocido como “divide y vencer ´as” – divide&conquer ),
con ´enfasis en su aplicaci ´on al problema de ordenamiento de una secuencia de datos,
y otras t ´ecnicas como algoritmos glotones o golosos (algoritmos greedy), programaci ´on
din ´amica, heur´ısticas, etc ´etera. Sin embargo, la mayor´ıa de los enfoques cl ´asicos hacen
demasiado hincapi ´e en los detalles de bajo nivel, privilegiando un enfoque mayormente
operacional.
Otro tema importante asociado al estudio de estructuras de datos y de algoritmos es el
de la complejidad. La eficiencia de un programa queda determinada por diversos factores.
Reducir el estudio de la eficiencia a simplemente medir cu ´anto tiempo lleva un programa
en algunos ejemplos particulares es un error com ´un, que debe evitarse pues puede con-
ducir a falsas impresiones y conclusiones sobre lo bueno que puede ser cierto programa.
Es por ello que el correcto estudio de la tem ´atica de complejidad es tan importante. El
m ´as importante de todos los factores que inciden en la eficiencia es la complejidad te ´ori-
ca propia de la estructura de datos o algoritmo utilizado. Para estudiar esta complejidad
inherente, la t ´ecnica m ´as difundida y estudiada es la de la matem ´atica de funciones de
orden para an ´alisis de cotas superiores asint ´oticas (O grande) utilizada principalmente en
el an ´alisis del peor caso de algoritmos. Tambi ´en existen otras formas de an ´alisis como
funciones de recurrencia, an ´alisis de cotas inferiores asint ´oticas (Omega grande), an ´alisis
de cotas ajustadas asint ´oticas (Theta grande), pero todas estas son menos comunes que
la primera mencionada, que alcanzar´ıa para iniciarse en estudios de complejidad. Otros
factores que inciden en menor medida (pero no despreciable) al estudiar eficiencia son
la cantidad de veces que ciertas operaciones se realizan (que en el estudio asint ´otico
se abordan mediante las denominadas constantes de proporcionalidad), la cantidad de
memoria consumida (especialmente en lenguajes con manejo autom ´atico de memoria),
la velocidad del procesador, y en el caso de sistemas con concurrencia o paralelismo, el
grado de carga del procesador en n ´umero de procesos simult ´aneos. Todos estos aspectos
deben ser tenidos en cuenta a estudiar temas de eficiencia de programas.
Otro aspecto que debe tenerse en cuenta a la hora de aprender a programar es ver
c ´omo los conceptos aprendidos se manifiestan en diferentes lenguajes. Por ello, es impor-
tante aprender diversos lenguajes y practicar los conceptos en cada uno de ellos. Pero no
debe confundirse el aprender un lenguaje y ver c ´omo se manifiestan en ´el los conceptos
de programaci ´on con aprender a programar en un lenguaje. Cada lenguaje tiene su propio
conjunto de particularidades y trucos para realizar ciertas tareas, y no debe confundirse
aprender esos trucos con aprender a programar. Y adem ´as, no deben mezclarse los pa-
radigmas de programaci ´on. Algunos lenguajes modernos combinan varios paradigmas,
pero siempre es conveniente aprender los conceptos en lenguajes puros, que manejan
Lenguajes puros son HASKELL
(paradigma funcional), SMALL-
TALK (paradigma de orientaci ´on
a objetos) y C (paradigma im-
perativo). Una vez aprendidos
los conceptos en dichos lengua-
jes/paradigmas, es conveniente
ver c ´omo los mismos se mani-
fiestan en otros lenguajes h´ıbri-
dos.
exclusivamente los conceptos de un ´unico paradigma. Creemos que para aprender verda-
deramente a programar deben comprenderse ciertas nociones b ´asicas que aparecen en
casi todos los lenguajes, puesto que los lenguajes particulares aparecen y desaparecen
con el tiempo.
6.1.1. Programaci ´on orientada a objetos
Dise ˜nar software a nivel industrial es m ´as que simplemente programar y no es una tarea
trivial. Adem ´as, se hace m ´as y m ´as complejo cuanto mayor es el tama ˜no y alcance del
software desarrollado. Para abordar esta complejidad surgi ´o, entre otras soluciones, el
paradigma de Programaci ´on Orientada a Objetos (POO), que aporta elementos b ´asicos
que benefician el dise ˜no de sistemas de gran escala.
El paradigma de Programaci ´on Orientada a Objetos (POO) es uno de los m ´as predo-
minantes en la actualidad, y aparece en la mayor´ıa de los lenguajes industriales. En este
tipo de programaci ´on se ven involucrados ciertos conceptos que podr´ıan ser considerados
´unicos para este paradigma, pero de todas formas se utilizan todos aquellos conceptos
que presentamos con GOBSTONES, al igual que los conceptos provenientes del estudio
de las estructuras de datos.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 236 of 312 --

237
Uno de los conceptos m ´as importantes en POO es el de encapsulamiento, que permite
abstraer estado (estructura) y comportamiento (procedimientos y funciones), dentro de lo
que se conoce como un objeto. Un objeto en este paradigma es, entonces, un concepto
te ´orico que permite relacionar un estado y un comportamiento espec´ıficos, abstray ´endolos
para su reutilizaci ´on. Esta idea est ´a relacionada con la idea de tipos abstractos de datos,
que son accedidos por interfaz, permitiendo ocultar detalles internos de implementaci ´on
al usuario. Sin embargo, introduce nociones espec´ıficas y ciertas formas de pensar los
programas que hacen m ´as sencillo la producci ´on de sistemas de software en gran escala.
Los objetos se comunican entre s´ı mediante el env´ıo de mensajes, que son similares a
la invocaci ´on de procedimientos, aunque no iguales. Al enviarse un mensaje se desenca-
dena un mecanismo para determinar qu ´e m ´etodo espec´ıfico de qu ´e objeto responder ´a ese
mensaje (algo as´ı como decir que se determinar ´a durante la ejecuci ´on qu ´e procedimiento
exacto ser ´a ejecutado al encontrar una invocaci ´on). Para ordenar este proceso de de-
terminar c ´omo responder a los mensajes, muchos lenguajes utilizan la idea de clase de
objetos, aunque esta noci ´on no es esencial para el paradigma.
La mejor manera de comenzar a estudiar POO es a trav ´es de un lenguaje puro, que
solo tenga la noci ´on de objetos y mensajes. Uno de tales lenguajes es SMALLTALK. Re-
ci ´en luego de manejar los conceptos de objetos adecuadamente es conveniente aprender
lenguajes que combinan objetos con otras nociones, tales como JAVA, PYTHON, etc ´etera.
6.1.2. Programaci ´on funcional
Otro de los paradigmas importantes actualmente es el paradigma de programaci ´on fun-
cional. En este paradigma no existe, en principio, la noci ´on de acci ´on ni de comando:
Decimos en principio porque
existen varios mecanismos pa-
ra incorporar la noci ´on de ac-
ci ´on y de comando en el lengua-
je manteniendo la pureza con-
ceptual del paradigma.
todas las expresiones del lenguaje referencian valores abstractos. Esta ausencia de en-
tidades con efectos se conoce con el nombre de transparencia referencial, e implica que
el lenguaje es m ´as apto para manipulaciones algebraicas y para determinadas formas
de combinaci ´on de programas donde los efectos producen numerosas complejidads (por
ejemplo, formas de computaci ´on paralelas o concurrentes). En ese marco conceptual, las
funciones son todo lo necesario para representar programas.
Un concepto importante dentro del paradigma funcional es conocido como alto orden,
que implica que las funciones pueden utilizarse al igual que otros valores, pas ´andolas co-
mo argumentos, retorn ´andolas como resultados e incluso almacen ´andolas en estructuras
de datos (y en el extremo, ¡utiliz ´andolas como estructuras de datos!) Este concepto es
de central importancia, y permite expresar esquemas de programas en forma de c ´odigo,
lo cual tiene much´ısimas ventajas a la hora de pensar programas. Adem ´as, el uso de
esquemas de programas fomenta la visi ´on abstracta del c ´odigo, favoreciendo el enfoque
utilizado en este libro.
Muchos de los desarrollos de herramientas y conceptos que hoy consideramos fun-
damentales fueron desarrollados originalmente en el paradigma funcional; por ejemplo,
la idea de manejo de memoria autom ´atica (garbage collection), la idea de funciones co-
mo valores (actualmente presente en lenguajes como PYTHON, SCALA, etc ´etera), la idea
de polimorifismo param ´etrico (lo que en JAVA se conoce con el nombre de generics), y
muchas otras. Sin embargo, el verdadero auge moderno de la programaci ´on funcional
proviene de la facilidad con la que el paradigma se adapta a la producci ´on de programas
paralelos, puesto que la ausencia de efectos dada por la pureza referencial del lenguaje
lo hace ideal para esta tarea.
Creemos que un programador moderno no puede dejar de conocer los conceptos
fundamentales de este paradigma.
6.2. Disciplinas asociadas
Finalmente, el dise ˜no de software no se agota en la programaci ´on. Existen otras nocio-
nes relacionadas con la programaci ´on, como ser las t ´ecnicas para representar grandes
vol ´umenes de informaci ´on, las t ´ecnicas utilizadas para desarrollar en equipos grandes
de programadores teniendo en cuenta las necesidades de los usuarios del software, las
problem ´aticas asociadas al soporte f´ısico de las m ´aquinas y dispositivos involucrados,
etc ´etera. Cada una de estas tem ´aticas se vincula de alguna forma con la programaci ´on,
pero tiene su propia l ´ogica, sus propios conceptos y sus propios desarrollos tanto te ´oricos
como pr ´acticos. No se puede pretender estudiar programaci ´on hoy d´ıa sin tener conoci-
mientos de estas tem ´aticas.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 237 of 312 --

238
El estudio de las t ´ecnicas para representar grandes vol ´umenes de informaci ´on se en-
globan bajo el estudio de bases de datos, que comprenden desarrollos te ´oricos y pr ´acticos
para esta tarea. Aprender de c ´omo modelar entidades y las relaciones entre ellas, c ´omo
representar esos modelos en formato relacional, c ´omo comprender y mejorar las carac-
ter´ısticas de estas representaciones para evitar problemas comunes y c ´omo consultar
la informaci ´on almacenada de manera consisa y expresiva son todas nociones b ´asicas
vinculadas con esta tem ´atica. Adem ´as, existen otras nociones m ´as avanzadas como la
persistencia de estructuras de datos u objetos en gran escala, el acceso en gran escala a
los datos en forma concurrente o paralela, la implementaci ´on de herramientas que plas-
men todas estas cuestiones, etc ´etera. Para poder desarrollar programas reales se hace
necesario tener al menos una idea de los temas de bases de datos, por lo que iniciarse
en estos temas es importante para la tarea de programaci ´on.
Otros de los temas imprescindibles son los que se relacionan con el ambiente en el
que los programas se ejecutan. Y a este respecto hay tres temas importantes: arquitec-
tura de computadoras, sistemas operativos y redes de computadoras. La arquitectura de
computadoras trata de c ´omo se compone una computadora en el nivel f´ısico, qu ´e partes
tiene (memoria, dispositivos de almacenamiento, procesador, etc ´etera), c ´omo interact ´uan
y c ´omo se representa la informaci ´on en bajo nivel mediante codificaci ´on binaria o hexade-
cimal. Tambi ´en trata sobre c ´omo se realiza el ciclo de ejecuci ´on de los programas en bajo
nivel (assembler). Adem ´as, todas las computadoras modernas poseen un programa base,
llamado sistema operativo, que es el encargado de comunicar a todos los dem ´as progra-
mas y aplicaciones con la arquitectura de la m ´aquina. Todos los programas interact ´uan de
una forma u otra con el sistema operativo, y es por eso que conocer la forma de trabajo de
este sistema es fundamental. Al aprender sobre sistemas operativos se aprende sobre sis-
temas de almacenamiento de archivos, sobre maneras de administrar la memoria, sobre
la manera de administrar m ´ultiples procesos concurrentes, administrar diversos usuarios
con diferentes niveles de acceso, y varios otros temas que son importantes para entender
c ´omo ejecutan nuestros programas en un entorno real. Finalmente, las computadoras mo-
dernas no trabajan aisladas, sino que se comunican con otras a trav ´es de redes de datos.
Entender c ´omo son las conexiones f´ısicas, las reglas de codificaci ´on de la informaci ´on, los
protocolos de comunicaci ´on en los diversos niveles y la arquitectura general de las redes
de computadoras son conocimientos escenciales para poder escribir programas que se
puedan comunicar con otros, u ofrecer servicios en la red.
El ´ultimo de los temas vinculados con la programaci ´on tiene que ver con el hecho de
que al desarrollar programas o sistemas de gran envergadura hacen falta t ´ecnicas para
desarrollo en gran escala. Los temas cubiertos en este libro, y los que tienen que ver
con estructuras de datos y algor´ıtmica pueden ser vistos como la base conceptual de la
programaci ´on. Pero para poder abarcar las situaciones y problemas que se presentan al
desarrollar programas en gran escala y en equipos de mucha gente (usualmente mul-
tidisciplinarios), hace falta tener conocimientos de ingenier´ıa de software. La ingenier´ıa
de software abarca los problemas de comunicaci ´on entre equipos y con los usuarios del
programa que se desarrolla, la planificaci ´on de los tiempos, la evaluaci ´on de costos, la
planificaci ´on para posibles contingencias, etc ´eterca, y todo en un marco de trabajo donde
los requerimientos que se realizan sobre los programas son muy din ´amicos y cambiantes.
Tener conocimientos b ´asicos de ingenier´ıa de software es necesario en la medida en que
se quiera programar algo m ´as que peque ˜nos programas para uno mismo.
6.3. Palabras finales
En este libro hemos cubierto los conceptos fundamentales para comenzar a entender
de programaci ´on, pero desde una concepci ´on innovadora con respecto a otros enfoques
m ´as tradicionales. Esto implic ´o por un lado un recorte de muchos temas que usualmente
nadie se cuestiona como parte de una introducci ´on a la programaci ´on, como ser mecanis-
mos de entrada/salida de informaci ´on, estructuras de datos elementales, etc ´etera, y por el
otro una profundizaci ´on en los temas considerados esenciales, como ser los procesos de
abstracci ´on y las herramientas para expresarlos, la identificaci ´on de la naturaleza de los
elementos que componen un programa y su expresi ´on en forma pura, la uniformidad de
las formas de combinaci ´on de elementos, etc ´etera.
Creemos que este enfoque, o uno con similares caracter´ısticas, es imprescindible para
que la programaci ´on no quede restringida a un c´ırculo peque ˜no de iniciados y pueda
ense ˜narse como materia b ´asica junto con la matem ´atica o la literatura. Claramente, este
es solo el comienzo de la enorme aventura que representa aprender a programar, pero
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 238 of 312 --

239
sentando bases s ´olidas, que permitan construir todos los dem ´as conceptos y herramientas
que hay que conocer para poder decir que uno sabe programar. Y aunque uno no tenga
intenciones de volverse un programador, los conocimientos b ´asicos aqu´ı brindados son
necesarios para comprender mejor el mundo actual, donde los programas son ubicuos,
proveyendo una forma de “alfabetizaci ´on” moderna.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 239 of 312 --

240
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 240 of 312 --

241
La herramienta PYGOBSTONES
La herramienta PYGOBSTONES es un entorno de programaci ´on b ´asico para el lenguaje
GOBSTONES. El programa est ´a implementado en PYTHON y se compone de varios m ´odu-
los que pueden utilizarse para analizar y ejecutar programas escritos en GOBSTONES.
En este apartado se detallan los pasos necesarios para poder ejecutar la herramienta
PYGOBSTONES.
A.1. Instalaci ´on
Para la instalaci ´on de PYGOBSTONES hay que seguir varios pasos: obtener el c ´odigo
de la herramienta, el lenguaje para ejecutarlo y varias bibliotecas de funciones gr ´aficas.
Describimos cada paso por separado.
A.1.1. La herramienta
El primer paso es obtener los scripts que conforman el entorno de programaci ´on PYGOBS-
TONES (este libro describe la herramienta en su versi ´on 1.0). Se encuentran en un archivo
comprimido que est ´a disponible para descargar desde el sitio de GOBSTONES.
Recurso Web
http://www.gobstones.org/descargas/
All´ı se debe puede descargar el archivo cuyo nombre comienza con PyGobstones, luego
contiene la versi ´on correspondiente, una fecha y luego una extensi ´on, que puede ser .zip
o .tar.gz, indicando que se trata de un archivo comprimido. Por ejemplo, la versi ´on que
utilizamos en este libro es la 1.0, y los archivos se llaman PyGobstones v 1.0 10-12-13.zip
y PyGobstones v 1.0 10-12-13.tar.gz.
El archivo comprimido debe descomprimirse en una carpeta. All´ı se encontrar ´an va-
rios archivos de extensi ´on .py que conforman la implementaci ´on de PYGOBSTONES. Los
restantes pasos dependen del sistema operativo que se est ´e utilizando, e incluyen instalar
el lenguaje PYTHON y algunas bibliotecas.
A.1.2. Usuarios de WINDOWS
Para los usuarios de WINDOWS, el int ´erprete tradicional de PYTHON se puede descargar
desde el sitio de la organizaci ´on PYTHON.
Recurso Web
http://www.python.org/download .
All´ı debe buscarse el archivo para instalar en WINDOWS, que para la versi ´on 2.7.6 es Pyt-
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 241 of 312 --

242
G.A.1. Descarga de PYTHON
hon 2.7.6 Windows Installer (python-2.7.6.msi). En el gr ´afico G.A.1 puede observarse
la p ´agina mencionada con la opci ´on correcta resaltada.
Una vez obtenido el archivo se lo debe abrir para proceder con la instalaci ´on. Alcanza con
realizar la instalaci ´on con todas las opciones predeterminadas.
El paso siguiente es descargar e instalar las bibliotecas gr ´aficas PyQt4, ya que son las
que se utilizaron para desarrollar la interfaz gr ´afica de PYGOBSTONES. El sitio para des-
cargarlas est ´a en sourceforge, en el proyecto pyqt.
Recurso Web
http://sourceforge.net/projects/pyqt/files/PyQt4/PyQt-4.10.2/
El archivo espec´ıfico depende del sistema operativo y la versi ´on de la biblioteca. Por ejem-
plo, para un WINDOWS est ´andar de 32 bits y la versi ´on 4.8.4 de la biblioteca, el archivo es
PyQt4-4.10.2-gpl-Py2.7-Qt4.8.4-x32.exe. Al igual que con el paquete de PYTHON, se
procede a ejecutar el instalador con las opciones predeterminadas.
Con estos tres pasos, ya estamos en condiciones de ejecutar PYGOBSTONES. Para
cargar la herramienta debe ejecutarse PYTHON sobre el script PyGobstones Windows.py
que se encuentra en la carpeta de PYGOBSTONES. Esto se puede hacer utilizando el
bot ´on derecho sobre dicho archivo y eligiendo la opci ´on “Abrir con”, desde donde de-
be seleccionarse el link al programa ejecutable C:\Python27\pythonw.exe (o la ruta en
la que est ´e instalado – ver el gr ´afico G.A.2). Alternativamente, en la mayor´ıa de las
configuraciones de Windows se puede hacer doble click directamente sobre el archivo
PyGobstones Windows.py.
A.1.3. Usuarios de GNU/LINUX
Las distribuciones de LINUX generalmente ya traen el int ´erprete de PYTHON instalado.
Adem ´as de esto, para ejecutar PYGOBSTONES se requiere instalar el paquete python-qt4.
Para instalarlo, se puede utilizar el administrador de paquetes synaptic, o bien abrir una
terminal y ejecutar el comando
sudo apt-get install python-qt4
(para lo cual se precisan permisos de administrador).
Para iniciar PYGOBSTONES en LINUX primero se debe abrir la carpeta que descarga-
da anteriormente (por ejemplo PyGobstones v 1.0 10-12-13), dar click derecho sobre el
archivo PyGobstones Linux.sh, ir a la opci ´on propiedades, ir a la solapa de permisos y
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 242 of 312 --

243
G.A.2. Abrir la herramienta PYGOBSTONES
G.A.3. Cambiar el permiso de ejecuci ´on de PyGobstones Linux.sh
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 243 of 312 --

244
G.A.4. Seleccionar la opci ´on de ejecuci ´on
G.A.5. Ventana principal de PYGOBSTONES, indicando la barra de men ´ues y las
solapas
tildar la opci ´on que permite ejecutar ese archivo como un programa (puede verse el resul-
tado de esta acci ´on en el gr ´afico G.A.3). Una vez hecho esto, basta con hacer doble click
sobre el archivo en cuesti ´on y seleccionar la opcion Run o Ejecutar, como se muestra en
el gr ´afico G.A.4.
A.2. Primeros pasos en PYGOBSTONES
Al arrancar la herramienta, y luego de visualizar el logo de GOBSTONES, la herramienta
muestra su ventana principal. En primer lugar conviene reconocer algunos componentes
importantes que van a ser de utilidad para el desarrollo de programas GOBSTONES usando
PYGOBSTONES.
A.2.1. Barra de men ´ues
La barra de men ´ues se encuentra en la parte superior de la ventana principal. Su aspecto
puede observarse en el gr ´afico G.A.5. En esta barra est ´an agrupadas la mayor´ıa de las
opciones que provee la herramienta.
En el men ´u Archivo se encuentran las opciones para Abrir, Guardar y Cerrar un
archivo de programa. Adem ´as se puede cerrar la aplicaci ´on desde all´ı.
En el men ´u Editar se encuentran las opciones cl ´asicas de Buscar y Buscar y
Reemplazar palabras, de Rehacer, Deshacer, Copiar, Cortar y Pegar. Adem ´as se
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 244 of 312 --

245
encuentra la opci ´on Preferencias, donde se pueden establecer algunas preferen-
cias generales de la aplicaci ´on. Las preferencias se explican m ´as adelante.
En el men ´u GOBSTONES se encuentran las opciones para ejecuci ´on de un progra-
ma. Desde aqu´ı se puede Ejecutar y Chequear el c ´odigo fuente y tambi ´en detener
la ejecuci ´on del mismo antes de que culmine. Estas opciones pueden devolver cier-
ta informaci ´on, la cual puede encontrarse en el Logger, ubicado en el sector inferior
de la pantalla.
En el men ´u Tablero se encuentran las opciones para interactuar con el tablero.
Desde aqu´ı se puede cargar un archivo .gbb (un tablero) desde el disco. Adem ´as
se puede acceder a Opciones del tablero y al Editor del tablero. Finalmente
se cuenta con una opcion Elegir vista, que permite elegir el tipo de vista que va
a tener el resultado, es decir la vestimenta con la que se va a vestir a los tablero
inicial y final. Cada una de las alternativas se explica m ´as adelante.
En el men ´u Ayuda se encuentra una opci ´on para acceder al manual de GOBSTO-
NES (para lo que se requiere acceso a internet), la Licencia de la herramienta
y finalmente la opci ´on Acerca de, con informaci ´on sobre herramientas utilizadas,
miembros del equipo de GOBSTONES y algo de la historia de este lenguaje.
Varias de las opciones de la barra de men ´ues aparecen de manera individual en forma de
botones inmediatamente debajo de la barra.
A.2.2. Editor de textos de programa y biblioteca
Debajo de los botones de men ´ues se encuentra un recuadro editable en el cual se puede
escribir y editar un programa GOBSTONES (o su biblioteca), que puede verse indicado
en el gr ´afico G.A.6. El editor es un editor tradicional, con opciones para copiar, cortar y
pegar, deshacer, moverse por el texto, etc ´etera. Permite crear y modificar programas de
GOBSTONES, que se guardan en archivos de texto con extensi ´on .gbs con las opciones
de men ´u correspondientes.
La zona del editor posee dos solapas en la parte superior, inicialmente con la leyenda
Sin T´ıtulo, como puede observarse en los gr ´aficos G.A.5 y G.A.6a. Estas solapas co-
rresponden a las ventanas de edici ´on del programa (la de la izquierda) y de la biblioteca
(la de la derecha).
Mientras que no se ha creado y salvado un archivo de programa, las solapas mues-
tran la opci ´on Sin T´ıtulo. Una vez que un archivo de programa fue editado y salvado,
o cargado desde el disco, la primera solapa muestra el nombre del archivo, como pue-
de observarse en el gr ´afico G.A.6b. La segunda solapa contendr ´a el archivo de nombre
Biblioteca.gbs que guarda las operaciones que querramos preservar en m ´as de un pro-
grama.
Un detalle importante a tener en cuenta con el manejo de la biblioteca es que, en
esta herramienta, la misma se asocia a una carpeta de trabajo. De esta manera, varios
archivos de programa en la misma carpeta pueden compartir la misma biblioteca. La car-
peta de trabajo actual es aquella en la que se encuentra el programa que est ´e cargado
en la solapa de programa (indicado en la barra de t´ıtulo de la ventana principal como se
indica en el gr ´afico G.A.6b), y en ese caso, la solapa de biblioteca mostrar ´a la biblioteca
correspondiente; si la biblioteca a ´un no existe en la carpeta de trabajo, la herramienta crea
una biblioteca vac´ıa. Si la carpeta donde se guarda el programa ya contiene un archivo
Biblioteca.gbs, la aplicaci ´on cargar ´a el existente, eliminando la biblioteca que estuviese
en dicha solapa.
Una opci ´on adicional de este editor es que es posible elegir mostrar o no los n ´ume-
ros de l´ınea; esta opci ´on se puede establecer utilizando la opci ´on correspondiente del
men ´u Editar→Preferencias.
A.2.3. Ejecutar un programa y ver su resultado
El prop ´osito del programa escrito en el editor es ejecutarse en GOBSTONES. PYGOBS-
TONES provee tres formas de iniciar la ejecuci ´on de un programa: usar la opci ´on de
men ´u Gobstones → Ejecutar, presionar la tecla F5, o presionar el bot ´on Ejecutar de
la barra de herramientas. En el gr ´afico G.A.7 se muestran dos de las opciones.
Una vez que la ejecuci ´on del programa finaliz ´o, y si lo hizo de manera exitosa, la
herramienta abre autom ´aticamente una nueva ventana llamada “Modo de resultados” que
permite inspeccionar 3 elementos: el tablero inicial, el c ´odigo fuente y el tablero final. En
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 245 of 312 --

246
(a). Sin archivo.
(b). Con un programa salvado.
G.A.6. Editor de textos de programas y bibliotecas
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 246 of 312 --

247
G.A.7. Ejecutar un programa
el gr ´afico G.A.8 puede verse esta ventana, con el tablero final como elemento visualizado.
Estos elementos son accesibles invidivualmente a trav ´es de solapas y permiten comprobar
que el programa efectivamente cumpli ´o con su cometido. Su significado es el siguiente:
Tablero Inicial: el estado del tablero antes de ejecutar el programa.
C ´odigo Fuente: el c ´odigo que efectivamente se ejecut ´o.
Tablero Final: el estado del tablero despu ´es de haber ejecutado el programa.
Por defecto el tablero inicial tiene un tama ˜no de 8 filas y 8 columnas, y se encuentra vac´ıo,
con el cabezal sobre en la esquina suroeste; esto puede luego ser modificado a trav ´es del
uso de opciones de tablero.
Existen algunas funcionalidades asociadas a la ventana de Modo de resultados que
se describen m ´as adelante.
A.2.4. Visualizar informaci ´on adicional
Distintas funcionalidades de la herramienta PYGOBSTONES retornan una cierta cantidad
de informaci ´on ´util para el programador. Por ejemplo, la funcionalidad de ejecuci ´on infor-
ma, en caso de ´exito, la hora de inicio y fin de la ejecuci ´on, o en caso de error, el tipo de
error con informaci ´on extra para ayudar a su correcci ´on. Otras funcionalidades proporcio-
nan otras informaciones.
Esta informaci ´on se presenta en una zona espec´ıfica, denominada “logger” . El logger
Log, en ingl ´es, significa bit ´aco-
ra. Entonces, el t ´ermino “logger”
indica un lugar donde se mues-
tra la bit ´acora, o sea, el registro
de informaci ´on resultante de ca-
da una de las funcionalidades.
se encuentra en la zona inferior de la pantalla, aunque inicialmente la mayor parte del mis-
mo est ´a oculto. Para visualizar m ´as informaci ´on puede deslizarse la l´ınea inferior del editor
hacia arriba, o encender la opci ´on Mostrar logger de las preferencias (que se acceden
desde Editar→Preferencias). En el gr ´afico G.A.9 se puede visualizar el resultado de la
ejecuci ´on de un programa exitoso.
El logger puede ocultarse en cualquier momento, y volverlo a visualizar con las opcio-
nes mencionadas.
A.2.5. Chequear un programa
Una funcionalidad nueva de esta versi ´on de PYGOBSTONES es la opci ´on de chequear (o
validar) si el programa que se est ´a escribiendo es correcto, desde el punto de vista de
la coincidencia de tipos, antes de ejecutarlo. Existen 3 formas de acceder a esta carac-
ter´ıstica: presionando la tecla F10, desde el men ´u Gobstones→Chequear, o presionando
el bot ´on con un tilde que se encuentra en la barra de herramientas.
A.2.6. Opciones de Tablero
Por defecto, el tablero inicial en el cual se ejecutan los programas posee un tama ˜no fijo (de
8x8), no contiene bolitas, y el cabezal se encuentra ubicado en la esquina suroeste. Sin
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 247 of 312 --

248
G.A.8. Ventana de Modo de resultados
G.A.9. Visualizaci ´on del logger
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 248 of 312 --

249
G.A.10. Opciones de tablero
embargo, no es conveniente acostumbrarse a programar con las opciones de ambiente
fijas, y para ello PYGOBSTONES provee varias alternativas para la modificaci ´on del tablero
inicial. Estas alternativas son accesibles desde el men ´u Tablero→Opciones de tablero.
Al acceder a esta opci ´on, se abre una ventana subsidiaria con elementos para modificar
las diferentes alternativas; la misma se muestra en el gr ´afico G.A.10.
Las opciones de tablero incluyen alternativas para modificar la aparici ´on de bolitas, el
tama ˜no del tablero y la posici ´on del cabezal:
Con respecto a las bolitas, se puede dejar la configuraci ´on de bolitas actual, pedir
que se establezca un orden y cantidades aleatorias, o pedir que no haya bolitas en
el tablero. La configuraci ´on de bolitas actual es ´util en conjunci ´on con el editor de
tableros, que se discute en la pr ´oxima secci ´on.
Con respecto al tama ˜no del tablero, se puede conservar el tama ˜no actual, ingresar
un tama ˜no manualmente, o pedir que se genere un tama ˜no aleatorio. Esta ´ultima
opci ´on forzar ´a al cabezal a ser aleatorio, ya que no se conocen las dimensiones
finales que va a tener el tablero.
Con respecto a la posici ´on del cabezal, se puede conservar la posici ´on actual del
mismo, ingresar una posici ´on manualmente (limitada por el tama ˜no del tablero), o
bien pedir que se genere una posici ´on aleatoria del cabezal.
A.3. Otras funcionalidades de PYGOBSTONES
La herramienta PYGOBSTONES ofrece algunas funcionalidades avanzadas, destinadas a
facilitar el trabajo de prueba de programas, y a mejorar algunos aspectos pedag ´ogicos o de
usabilidad. Entre estas opciones se encuentran la manipulaci ´on de tableros, la capacidad
de incorporar “vestimentas” a los tableros (proveyendo de esa forma una visualizaci ´on de
ciertos procesos de abstracci ´on) y la capacidad de operar interactivamente con un progra-
ma GOBSTONES. Tratamos cada una de estas caracter´ısticas en diferentes subsecciones.
A.3.1. Guardar y cargar tableros
Cuando los programas a realizar dejan de ser triviales, muchas veces es necesario contar
con tableros iniciales espec´ıficos. Para ello, PYGOBSTONES cuenta con opciones de salvar
tableros y de cargar tableros salvados y usarlos como tableros iniciales.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 249 of 312 --

250
G.A.11. Editor de tableros
Para guardar tableros se puede utilizar el bot ´on Guardar tablero final en la ventana
de resultados, o tambi ´en utilizar el editor de tableros para crear un tablero y salvarlo. Para
cargar un tablero desde el disco se utiliza la opci ´on del men ´u Tablero→Cargar Tablero.
Tanto la opci ´on de guardar como la de salvar abren un explorador de archivos para indicar
a qu ´e archivo o desde qu ´e archivo debe realizarse la operaci ´on. Los tablero se almacenan
en archivos de extensi ´on .gbb y usualmente residen en la misma carpeta que el programa
con el que se asocian.
A.3.2. Editor de Tableros
El editor de tableros es una funcionalidad de PYGOBSTONES que permite editar tableros
guardados y crear tableros propios, modificando el tama ˜no de los mismos, la cantidad
de bolitas en las celdas y la posici ´on del cabezal. Para accederlo se utiliza la opci ´on
Tablero→Editor de Tableros, que cuando se selecciona abre una nueva ventana con
el editor, como puede observarse en el gr ´afico G.A.11.
Para utilizar el editor de tableros se utiliza el mouse y el teclado. Con el mouse se
pueden poner y sacar bolitas del tablero; para ello hay que posicionarse sobre una celda,
y elegir una de las 4 regiones de la celda (que se colorean al posicionar el cursor sobre
ellas), y luego con el bot ´on izquierdo se ponen bolitas y con el derecho se sacan. Con las
flechas del teclado se puede mover el cabezal, cambiando la celda actual.
Adem ´as de las opciones de edici ´on, sobre el tablero aparecen 3 botones que permiten
cargar un tablero, persistir un tablero o modificar las opciones. Al cargar o guardar, se
puede indicar que el origen o destino sea el disco o se puede utilizar el tablero inicial. Las
opciones abren las opciones de tablero ya mencionadas.
A.3.3. Vestimentas
Una innovaci ´on de la versi ´on 1.0de PYGOBSTONES es la posibilidad de “vestir” los table-
ros. La funcionalidad consiste en asignar una imagen con extensi ´on .png o .jpg a una
configuraci ´on de bolitas espec´ıfica, de manera tal que cada celda que posea esa configu-
raci ´on mostrar ´a la imagen indicada en lugar de las bolitas. Si la configuraci ´on de bolitas
de una celda no coincide con ninguna de las especificadas, la herramienta la dibujar ´a de
la manera tradicional.
Esta asociaci ´on entre configuraciones de bolitas e im ´agenes se especifica mediante
un archivo externo, en formato .xml, conteniendo los siguientes elementos:
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 250 of 312 --

251
BoardCoding : el elemento principal, que contiene a todos los dem ´as. Debe haber solo
uno de estos elementos por archivo.
Cell : este elemento indica la asociaci ´on entre una configuraci ´on de bolitas espec´ıficas y
una imagen (a trav ´es de los elementos siguientes). Puede haber cualquier n ´umero
de ellos dentro del elemento BoardCoding; el orden importa, ya que se utilizar ´a el
primero que coincida con la configuraci ´on de una celda.
Blue : indica la cantidad de bolitas azules que debe haber para coincidir con esta confi-
guraci ´on. Hay exactamente uno de estos elementos en cada elemento Cell. Puede
ser un n ´umero positivo o un comod´ın. Los comodines son un asterisco (*) o un signo
de suma (+), e indican cero o m ´as bolitas y una o m ´as bolitas, respectivamente.
Black : similar al elemento Blue, pero para bolitas negras.
Red : similar al elemento Blue, pero para bolitas rojas.
Green : similar al elemento Blue, pero para bolitas verdes.
Image : indica el nombre de un archivo (con extensi ´on .png o .jpg), que debe contener
una imagen de 60x60 p´ıxeles que se utilizar ´a para mostrar en la celda en caso de
que la configuraci ´on de bolitas coincida. Hay exactamente uno por cada elemento
Cell.
El archivo especificando la vestimenta debe residir en una carpeta de nombre Vestimentas
en la carpeta de trabajo. Los archivos de im ´agenes deben ir dentro de una carpeta de nom-
bre Imagenes, a su vez dentro de la carpeta Vestimentas. Estas dos carpetas se crean
autom ´aticamente y pueden contener cualquier n ´umero de vestimentas y de im ´agenes,
respectivamente.
Por ejemplo se puede indicar que toda celda donde haya exclusivamente 1 bolita se
dibuje como un bloque s ´olido del color de la bolita y si no hay bolitas, que se dibuje como
un bloque s ´olido gris. Para ello se debe generar un archivo .xml con el siguiente contenido:
<BoardCoding>
<Cell>
<Blue>0</Blue>
<Black>0</Black>
<Red>0</Red>
<Green>0</Green>
<Image>fondo.png</Image>
</Cell>
<Cell>
<Blue>0</Blue>
<Black>0</Black>
<Red>0</Red>
<Green>1</Green>
<Image>bloque-verde.png</Image>
</Cell>
<Cell>
<Blue>1</Blue>
<Black>0</Black>
<Red>0</Red>
<Green>0</Green>
<Image>bloque-azul.png</Image>
</Cell>
<Cell>
<Blue>0</Blue>
<Black>1</Black>
<Red>0</Red>
<Green>0</Green>
<Image>bloque-negro.png</Image>
</Cell>
<Cell>
<Blue>0</Blue>
<Black>0</Black>
<Red>1</Red>
<Green>0</Green>
<Image>bloque-rojo.png</Image>
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 251 of 312 --

252
</Cell>
</BoardCoding>
Si los archivos de im ´agenes son los correctos, entonces un tablero con la configuraci ´on
del gr ´afico G.A.12a se ver´ıa como el tablero del gr ´afico G.A.12b a partir de aplicar esta
vestimenta.
Las vestimentas son una herramienta poderosa que se puede utilizar para ejemplificar
el principio de abstracci ´on y para mejorar la apreciaci ´on abstracta de los programas que
se ejecutan. Por ejemplo, en el caso del juego de Zilfost, en lugar de esforzarnos en ver
las piezas en ciertos grupos de celdas con bolitas, como deber´ıamos hacer en el caso del
gr ´afico G.A.13a, podr´ıamos tener una vista como la que se muestra en el gr ´afico G.A.13b.
En esta vestimenta del Zilfost, que denominamos zilfost-romano, podemos encontrar
una aplicaci ´on de los comodines de especificaci ´on:
...
<Cell>
<Blue>0</Blue>
<Black>*</Black>
<Red>*</Red>
<Green>1</Green>
<Image>bloque-azul.png</Image>
</Cell>
<Cell>
<Blue>0</Blue>
<Black>*</Black>
<Red>*</Red>
<Green>2</Green>
<Image>bloque-naranja.png</Image>
</Cell>
...
Puesto que las piezas se codifican mediante la cantidad de bolitas verdes, pero las rojas
y negras se utilizan con fines de marcaci ´on, entonces la pieza de c ´odigo 1, que tendr ´a 1
bolita verde y cualquier cantidad de negras o rojas, ser ´a la pieza azul, etc ´etera.
A.3.4. Interactivo
PYGOBSTONES en su versi ´on 1.0 implementa la versi ´on 3.0 del lenguaje GOBSTONES.
Esta versi ´on incluye una base para realizar programas interactivos, por lo que otra inno-
vaci ´on en esta versi ´on de la herramienta es la capacidad de interactuar con programas
GOBSTONES.
Si el programa del editor de programas es un programa interactivo correcto (comienza
con las palabras reservadas interactive program, y respeta una sintaxis espec´ıfica de
asociaci ´on entre teclas y procedimientos), al ejecutarlo PYGOBSTONES abre una ventana
de Modo Interactivo. Esta ventana puede observarse en el gr ´afico G.A.14. En esta venta-
na, la luz verde en la esquina inferior derecha indica que la aplicaci ´on est ´a esperando que
el usuario presione una tecla (la ventana tiene que estar seleccionada para que la tecla
presionada sea aceptada por el programa). Al presionar, se ejecuta el procedimiento asig-
nado a dicha tecla, y mientras esto sucede, la luz roja indica que no se pueden ingresar
nuevas teclas. Al finalizar la ejecuci ´on de dicho procedimiento, la ventana cambia el table-
ro inicial por el tablero resultante luego de la ejecuci ´on, y vuelve al estado de esperar una
tecla. Para finalizar la ejecuci ´on de un programa interactivo alcanza con cerrar la ventana
de resultados o digitar la tecla CTRL-D.
La funcionalidad de programas interactivos sirve para mostrar el poder de un conjunto
simple pero fundamental de ideas, como las plasmadas por el lenguaje GOBSTONES.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 252 of 312 --

253
(a). Sin vestir.
(b). Con la vestimenta del ejemplo.
G.A.12. Ejemplos de tableros con y sin vestimentas
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 253 of 312 --

254
(a). Sin vestir.
(b). Con vestimenta.
G.A.13. Ejemplos de Zilfost con y sin vestimentas
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 254 of 312 --

255
G.A.14. Ventana del Modo Interactivo
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 255 of 312 --

256
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 256 of 312 --

257
C ´	odigo completo del Zilfost
En este ap ´endice se presenta el c ´odigo completo del juego ZILFOST, que fuera presen-
tado en el cap´ıtulo 5. Se separan las partes en diferentes secciones; para contar con el
juego completo deben juntarse todas las secciones (excepto la secci ´on de biblioteca) en
un archivo Zilfost.gbs y la secci ´on de biblioteca en un archivo Biblioteca.gbs. Am-
bos archivos deben ser colocados en la misma carpeta, y ejecutados con alguna de las
herramientas que implementan GOBSTONES en su versi ´on 3.0.
B.1. C ´odigo principal
/* -------------------------------------------------
AUTOR: Pablo E. Mart´ınez L´opez
FECHA: abril-octubre 2013