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
Para terminar, enumeramos algunos criterios de calidad del software y a continuación algunas de las ventajas de la
programación con TAD con respecto a esos criterios.
Criterios de calidad del software:
• 	Corrección  debe realizar exactamente las tareas definidas por su especificación.
• 	Legibilidad  debe ser fácil de leer y lo más sencillo posible. Contribuyen la abstracción y la codificación con
comentarios, sangrados, etc.
• 	Extensibilidad  facilidad para adaptarse a cambios en su especificación.
• 	Robustez  capacidad de funcionar correctamente incluso en situaciones anormales.
• 	Eficiencia  hace un buen uso de los recursos, tales como el tiempo, espacio (memoria y disco), etc.
• 	Facilidad de uso  la utilidad de un sistema está relacionado con su facilidad de uso.
• 	Portabilidad  facilidad con la que puede ser transportado a diferentes sistemas físicos o lógicos.
• 	Verificabilidad  facilidad de verificación de un software, su capacidad para soportar los procedimientos de
validación, juegos de test, ensayo o pruebas.
• 	Reutilización  capacidad de ser reutilizados en nuevas aplicaciones o desarrollos.
• 	Integridad  capacidad de proteger sus propios componentes frente a accesos o usos indebidos.
• 	Compatibilidad  facilidad para ser combinados con otros y usados en diferentes plataformas hardware o software.
Algunas ventajas de la programación con TAD para varios de los criterios de calidad del software antes enumerados:
• 	Abstracción:
o 	La complejidad del problema se diluye. Los módulos en los que se descompone el problema serán de menor
complejidad.
o 	Se pueden implementar los TAD sólo a partir de la especificación, sin saber para qué se van a usar 
Reusabilidad.
• 	Corrección:

-- 22 of 267 --

15
o 	Los TAD pueden ser desarrollados y probados de forma independiente.
o 	Se pueden utilizar los TAD sólo conociendo la especificación. Facilita la integración de módulos.
• 	Eficiencia:
o 	La implementación puede retrasarse hasta conocer las restricciones de eficiencia sobre sus operaciones.
o 	Para un TAD podemos contar con diferentes implementaciones válidas y optar por la más eficiente y
adecuada a las restricciones a cumplir.
• 	Legibilidad:
o 	La especificación de un TAD es suficiente para entender su significado y comportamiento.
o 	Un TAD tiene un tamaño y complejidad acotados que facilita su legibilidad.
• 	Modificabilidad y mantenimiento:
o 	Tanto durante el periodo de desarrollo y pruebas, como durante en el periodo de mantenimiento y de vida
del software.
o 	Cambios localizados y acotados.
o 	Cambios que no afecten a la especificación no afectarán a los programas que usen el TAD.
• 	Organización:
o 	Facilita el reparto de tareas y la comunicación en un grupo de programadores.
o 	El equipo desarrolla en paralelo las múltiples partes o módulos del sistema.
• 	Reusabilidad:
o 	TAD reutilizables en otros contextos con pocos o ningún cambio (¡escoger bien el conjunto de
operaciones!).
• 	Seguridad:
o 	Imposibilidad de manipular directamente la representación interna de los datos u objetos del tipo.
o 	Impide el mal uso y la generación de valores incorrectos.

-- 23 of 267 --

16

-- 24 of 267 --

17
Lección 2
Especificación de TAD
Indice