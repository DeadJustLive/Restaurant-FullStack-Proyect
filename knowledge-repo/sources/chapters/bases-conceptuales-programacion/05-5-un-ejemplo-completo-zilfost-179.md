# 5. Un ejemplo completo: ZILFOST 179

5.1. Representaci ´on del ZILFOST . . . . . . . . . . . . . . . . . . . . . 179
5.2. C ´odigo GOBSTONES para las zonas . . . . . . . . . . . . . . . . . 183
5.2.1. Zona de juego . . . . . . . . . . . . . . . . . . . . . . . . . 183
5.2.2. Zonas de n ´umeros . . . . . . . . . . . . . . . . . . . . . . . 187
5.2.3. Zonas de n ´umeros espec´ıficas . . . . . . . . . . . . . . . . 193
5.3. C ´odigo para expresar piezas . . . . . . . . . . . . . . . . . . . . . 195
5.3.1. Geometr´ıa de las piezas . . . . . . . . . . . . . . . . . . . . 195
5.3.2. Detecci ´on de piezas . . . . . . . . . . . . . . . . . . . . . . 199
5.4. C ´odigo para operaciones b ´asicas sobre piezas . . . . . . . . . . . 204
5.4.1. Localizar una pieza . . . . . . . . . . . . . . . . . . . . . . 204
5.4.2. Colocar y quitar una pieza . . . . . . . . . . . . . . . . . . . 204
5.4.3. Movimientos de una pieza . . . . . . . . . . . . . . . . . . . 207
5.5. C ´odigo para la mec ´anica del juego . . . . . . . . . . . . . . . . . . 209
5.5.1. Colocar nueva pieza . . . . . . . . . . . . . . . . . . . . . . 210
5.5.2. Bajar las piezas . . . . . . . . . . . . . . . . . . . . . . . . 210
5.5.3. Extender el piso . . . . . . . . . . . . . . . . . . . . . . . . 214
5.5.4. Eliminar filas llenas . . . . . . . . . . . . . . . . . . . . . . . 218
5.5.5. Generaci ´on del logo de ZILFOST . . . . . . . . . . . . . . . 221
5.6. C ´odigo para las operaciones de interfaz . . . . . . . . . . . . . . . 222
5.6.1. Determinar la pr ´oxima pieza . . . . . . . . . . . . . . . . . 222
5.6.2. Operaciones de interacci ´on . . . . . . . . . . . . . . . . . . 225
5.7. El programa principal . . . . . . . . . . . . . . . . . . . . . . . . . 228
5.7.1. Un programa simple . . . . . . . . . . . . . . . . . . . . . . 228
5.7.2. Programas interactivos . . . . . . . . . . . . . . . . . . . . 228
5.7.3. El juego interactivo . . . . . . . . . . . . . . . . . . . . . . . 229
5.8. Ejercitaci ´on . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 230
5.9. Comentarios Finales . . . . . . . . . . . . . . . . . . . . . . . . . . 233
6. ¿C ´omo continuar aprendiendo a programar? 235
6.1. Estructuras de datos, algor´ıtmica y lenguajes . . . . . . . . . . . . 235
6.1.1. Programaci ´on orientada a objetos . . . . . . . . . . . . . . 236
6.1.2. Programaci ´on funcional . . . . . . . . . . . . . . . . . . . . 237
6.2. Disciplinas asociadas . . . . . . . . . . . . . . . . . . . . . . . . . 237
6.3. Palabras finales . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 238
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 14 of 312 --

15
A. La herramienta PYGOBSTONES 241
A.1. Instalaci ´on . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 241
A.1.1. La herramienta . . . . . . . . . . . . . . . . . . . . . . . . . 241
A.1.2. Usuarios de WINDOWS . . . . . . . . . . . . . . . . . . . . 241
A.1.3. Usuarios de GNU/LINUX . . . . . . . . . . . . . . . . . . . . 242
A.2. Primeros pasos en PYGOBSTONES . . . . . . . . . . . . . . . . . . 244
A.2.1. Barra de men ´ues . . . . . . . . . . . . . . . . . . . . . . . . 244
A.2.2. Editor de textos de programa y biblioteca . . . . . . . . . . 245
A.2.3. Ejecutar un programa y ver su resultado . . . . . . . . . . . 245
A.2.4. Visualizar informaci ´on adicional . . . . . . . . . . . . . . . . 247
A.2.5. Chequear un programa . . . . . . . . . . . . . . . . . . . . 247
A.2.6. Opciones de Tablero . . . . . . . . . . . . . . . . . . . . . . 247
A.3. Otras funcionalidades de PYGOBSTONES . . . . . . . . . . . . . . 249
A.3.1. Guardar y cargar tableros . . . . . . . . . . . . . . . . . . . 249
A.3.2. Editor de Tableros . . . . . . . . . . . . . . . . . . . . . . . 250
A.3.3. Vestimentas . . . . . . . . . . . . . . . . . . . . . . . . . . . 250
A.3.4. Interactivo . . . . . . . . . . . . . . . . . . . . . . . . . . . . 252
B. C ´odigo completo del Zilfost 257
B.1. C ´odigo principal . . . . . . . . . . . . . . . . . . . . . . . . . . . . 257
B.2. Operaciones sobre zonas . . . . . . . . . . . . . . . . . . . . . . . 259
B.2.1. Operaciones sobre la zona de juego . . . . . . . . . . . . . 260
B.2.2. Operaciones sobre zonas de n ´umeros . . . . . . . . . . . . 263
B.2.3. Operaciones de zonas espec´ıficas . . . . . . . . . . . . . . 267
B.3. Operaciones sobre piezas . . . . . . . . . . . . . . . . . . . . . . . 270
B.3.1. Geometr´ıa de las piezas . . . . . . . . . . . . . . . . . . . . 271
B.3.2. Detecci ´on de piezas . . . . . . . . . . . . . . . . . . . . . . 276
B.4. Operaciones de procesamiento de piezas . . . . . . . . . . . . . . 280
B.4.1. Operaci ´on de localizaci ´on de una pieza . . . . . . . . . . . 280
B.4.2. Operaciones para colocar una pieza . . . . . . . . . . . . . 280
B.4.3. Operaciones para quitar una pieza . . . . . . . . . . . . . . 283
B.4.4. Operaciones de movimiento de piezas . . . . . . . . . . . . 286
B.5. Operaciones de la mec ´anica del juego . . . . . . . . . . . . . . . . 288
B.5.1. Operaci ´on de colocar nueva pieza . . . . . . . . . . . . . . 288
B.5.2. Operaciones para bajar piezas . . . . . . . . . . . . . . . . 289
B.5.3. Operaciones para extender el piso . . . . . . . . . . . . . . 291
B.5.4. Operaciones para eliminar filas llenas . . . . . . . . . . . . 297
B.5.5. Operaciones adicionales . . . . . . . . . . . . . . . . . . . 300
B.6. Operaciones de interfaz . . . . . . . . . . . . . . . . . . . . . . . . 301
B.6.1. Determinar nueva pieza . . . . . . . . . . . . . . . . . . . . 301
B.6.2. Operaciones de interacci ´on . . . . . . . . . . . . . . . . . . 302
B.7. Operaciones de biblioteca . . . . . . . . . . . . . . . . . . . . . . . 303
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 15 of 312 --

16
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 16 of 312 --

17
Prefacio
La programaci ´on es una disciplina que en pocos a ˜nos ha cobrado una relevancia
fundamental en gran diversidad de ´ambitos de la cultura y la sociedad huma-
na. Hoy d´ıa es deseable que todas las personas tengan un m´ınimo de conoci-
mientos relacionados con la programaci ´on, ya que la programaci ´on favorece el
pensamiento algor´ıtmico. Adem ´as, si consideramos a la programaci ´on desde un
enfoque adecuado, abstracto, se adquiere una conciencia del uso de elementos
de abstracci ´on que resultan fundamentales para muchas otras actividades del
conocimiento. La abstracci ´on es una herramienta esencial del pensamiento hu-
mano, y la programaci ´on provee formas de explicitar el proceso de abstracci ´on y
de controlarlo de diversas maneras, orientando a una forma de conceptualizar los
problemas que hacen mucho m ´as simple el entender problemas y encontrarles
soluci ´on, tal cual lo indic ´o Edsger Dijkstra en 1989 [Dijkstra and others, 1989].
Este libro busca ser una introducci ´on amena para personas con poca o nin-
guna experiencia en tem ´aticas vinculadas al desarrollo de software. Para ello
ofrece una visi ´on panor ´amica de los temas b ´asicos, comenzando por la historia
de la programaci ´on, y continuando con abstracciones b ´asicas que permiten mo-
delar programas. Este libro se basa principalmente de los primeros 4 cap´ıtulos
del Cuaderno de Trabajo “Introducci ´on a la Programaci ´on para la carrera de Li-
cenciatura en Artes y Tecnolog´ıas” [Mart´ınez L ´opez and Sawady O’Connor, 2013]
del autor y Federico Sawady O’Connor, y presenta un enfoque nuevo para la en-
se ˜nanza de la programaci ´on, guiado por la necesidad de focalizar el aprendizaje
en el proceso de abstracci ´on, y en los conceptos fundamentales, transversales a
todos los paradigmas y lenguajes. La secuencia did ´actica que gu´ıa este enfoque
fue desarrollada por el autor y su colega Eduardo Bonelli durante el dictado de la
materia Introducci ´on a la Programaci ´on de la carrera Tecnicatura en Programa-
ci ´on Inform ´atica de la UNQ, entre los a ˜nos 2008 a 2010. Las bases conceptuales
del enfoque se discuten en el art´ıculo “El nombre verdadero de la programaci ´on.
Una concepci ´on de la ense ˜nanza de la programaci ´on para la sociedad de la in-
formaci ´on” [Mart´ınez L ´opez et al., 2012]. Este enfoque ha sido utilizado con ´exito
desde 2010 en la mencionada carrera, y tambi ´en se ha comenzado a utilizar en
algunas escuelas secundarias. La secuencia did ´actica espec´ıfica se presenta en
la pr ´oxima secci ´on.
En el momento de la edici ´on de este libro estamos escribiendo una versi ´on
m ´as completa con t´ıtulo tentativo “Introducci ´on a la Programaci ´on. Una did ´actica
innovadora”, y que completar ´a much´ısimo el material presente aqu´ı, pero por ra-
zones de necesidad en la implementaci ´on de cursos masivos en escuelas secun-
darias se hace necesario contar con una versi ´on incial que pueda salir a prensa
antes.
Presentamos la programaci ´on de una manera amena y sencilla procurando
brindar los conocimientos de los fundamentos b ´asicos de la misma. Sin embargo,
no por ello incurrimos en el defecto de sobresimplificar o infantilizar la programa-
ci ´on a trav ´es de met ´aforas u otros recursos limitantes, sino que buscamos mante-
ner una visi ´on precisa, cient´ıfica, aunque sin incurrir en detalles t ´ecnicos innece-
sarios. Articulamos la presentaci ´on alrededor del concepto de abstracci ´on, idea
vertebral a la actividad misma de programar. La misma noci ´on de programaci ´on
es una tarea abstracta, y que requiere de conceptualizaciones y representacio-
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 17 of 312 --

18
nes abstractas de la informaci ´on y los procesos. Asimismo, los lenguajes de pro-
gramaci ´on pueden ser vistos como herramientas de abstracci ´on, y los elementos
que en ellos aparecen se pueden comprender en funci ´on del tipo de abstrac-
ci ´on que proveen. Los cap´ıtulos se centran en las formas de escribir programas,
omitiendo adrede el tratamiento de temas m ´as complejos (como las estructuras
de datos, o la algor´ıtmica), que, aunque fundamentales para la programaci ´on,
pueden abordarse con posterioridad.
El material de este libro est ´a pensado para que sirva no solo como referencia
y gu´ıa del aprendizaje de la disciplina, sino tambi ´en de material de consulta para
las definiciones elementales y las ideas que son pilar de la fascinante disciplina
de la programaci ´on.
En educaci ´on es clave el protagonismo y compromiso individual de cada es-
tudiante, aunque muchas veces esto no sea adecuadamente puesto en foco.
En el caso de la ense ˜nanza de la programaci ´on, donde la pr ´actica constante y
sostenida es el ´unico camino para aprender los conceptos fundamentales, este
compromiso y protagonismo debe remarcarse a ´un m ´as. Parafraseando un viejo
dicho acerca de la matem ´atica, podemos decir que “la programaci ´on no es un de-
porte para espectadores” (en ingl ´es computer science is not a spectator sport),
lo que viene a querer decir que para poder aprender es necesario involucrarse
y ejercitar, buscar varias alternativas de soluci ´on al mismo problema, ampliar la
informaci ´on, y probar en forma pr ´actica en las computadoras los programas rea-
lizados. En ese proceso este libro act ´ua como gu´ıa, y como consejero, pero el
factor de ´exito est ´a en el estudiante mismo. No dejes de tener esto en cuenta eso
al leer este libro para aprender, o al utilizar este libro para ense ˜nar.
El libro se organiza en 6 cap´ıtulos. En el primero comenzamos presentando
la idea de programa y lenguaje de programaci ´on, y haremos una revisi ´on de la
historia de los lenguajes de programaci ´on desde su surgimiento moderno, para
comprender el rol que los lenguajes juegan en la construcci ´on del mundo actual.
En el segundo hacemos la primera aproximaci ´on a un primer lenguaje de progra-
maci ´on, presentando sus elementos b ´asicos (expresiones y comandos) y orga-
niz ´andolos para comenzar a resolver problemas sencillos. Elegimos el lenguaje
GOBSTONES, desarrollado espec´ıficamente en la UNQ para la ense ˜nanza de un
curso inicial. En el tercero continuamos presentando elementos de lenguajes de
programaci ´on en GOBSTONES, incorporando herramientas (funciones, procedi-
mientos y parametrizaci ´on) para manejar la complejidad y simplificar los progra-
mas resultantes. El cuarto completa la presentaci ´on del lenguaje GOBSTONES
con una explicaci ´on de los elementos m ´as complejos del mismo (estructuras de
control para alternativa y repetici ´on, y manejo de memoria elemental), y propone
algunos ejercicios avanzados. El cap´ıtulo 5 completa la presentaci ´on mostran-
do la integraci ´on de los conceptos explicados en el libro mediante el desarrollo
de una aplicaci ´on, para la que se explica su dise ˜no y su codificaci ´on (el c ´odigo
fuente completo se presenta en el anexo B). Finalmente concluimos en el ´ultimo
con una discusi ´on sobre c ´omo creemos los autores que se debe continuar pro-
fundizando el aprendizaje de la programaci ´on, a trav ´es del abordaje de temas
fundamentales que no inclu´ımos por tratarse de un enfoque inicial.
Secuencia did ´actica y mapa conceptual
Como mencionamos antes, en este libro proponemos una secuencia did ´actica
novedosa, diferente a la tradicional forma de ense ˜nar programaci ´on. Esta se-
cuencia did ´actica se dise ˜n ´o teniendo en cuenta el trabajo con los estudiantes
de primer a ˜no de la Tecnicatura en Programaci ´on Inform ´atica de la Universidad
Nacional de Quilmes, y expresa una s´ıntesis conceptual utilizable con personas
que no tienen ninguna experiencia previa en programaci ´on, ni demasiada fami-
liaridad con procesos de abstracci ´on (t´ıpicamente presentados en cursos de ma-
tem ´aticas). La secuencia did ´actica articula una serie de conceptos de diferentes
categor´ıas y niveles. En primer lugar brindamos una categorizaci ´on de los con-
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 18 of 312 --

19
ceptos, para ofrecer un marco donde entender mejor la secuencia did ´actica, y
luego presentamos la secuencia did ´actica propiamente dicha.