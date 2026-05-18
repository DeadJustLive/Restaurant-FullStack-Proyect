# 1. Introducción

## Fuente
introduccion-poo (Cap. 4)

## Contenido
# 1. Introducción

1.1. La programación
La programación es un proceso por el que se escribe, se prueba, se depura y se
modifica el código. Los programas como elementos que forman el software son
un conjunto de instrucciones que se ejecutan en el hardware con el objetivo
de realizar una tarea determinada.
Para el desarrollo de programas de cierta envergadura o complejos, con ciertas
garantías de calidad, es conveniente seguir alguno de los modelos de desarrollo
de software existentes, en los que la programación es sólo una de las etapas
del proceso de desarrollo del software.
Un programa es un conjunto de instrucciones que se ejecutan con el
objetivo de resolver un cierto problema. Los programas se componen
en varios algoritmos, y cada uno de éstos resuelve una parte del proble-
ma inicial. De esta manera, la complejidad de cada una de las partes es
menor que la del programa completo (esta técnica es conocida como
"divide y vencerás").
Según Niklaus Wirth, un programa está formado por algoritmos y una estruc-
tura de datos.
Niklaus Wirth (Winterthur, 1934)
Doctorado en 1963 en Berkeley, de 1963 a 1967 fue profesor de Informática en Stanford
y en la Universidad de Zúrich. A partir de 1968, pasó a ser profesor de Informática en la
ETH de Suiza y se tomó dos años sabáticos en la Xerox PARC de California.
Fue el jefe de diseño de los lenguajes de programación Euler, Algol W, Pascal, Modula,
Modula-2 y Oyeron, y ocupó gran parte de su tiempo en el equipo de diseño e imple-
mentación de sistemas operativos Lilith y Oberon para el Lola en el diseño del hardware
digital y el sistema de simulación.
Su artículo de desarrollo de un programa por refinamiento sucesivo ("Program Develop-
ment by Stepwise Refinement") es considerado un texto clásico en la ingeniería del soft-
ware, así como su libro Algoritmos + Estructuras de datos = Programas, que recibió un am-
plio reconocimiento, y que aún hoy es útil en la enseñanza de la programación. Recibió
el Premio Turing por el desarrollo de estos lenguajes de programación en 1984.
La programación tiene como uno de sus principales objetivos la creación de
software de calidad, y los principales factores que indican el nivel￿de￿calidad
de￿un￿programa son los siguientes:

-- 5 of 44 --

CC-BY-NC-ND • PID_00220485 6 Introducción a la programación orientada a objetos
1)￿Corrección: un programa es correcto si hace lo que debe hacer tal y como
se estableció. Para determinar si un programa actúa correctamente es muy im-
portante disponer de una especificación de lo que debe resolver el programa
antes de desarrollarlo, de esta manera, una vez implementado se ha de com-
probar que realmente lo implementa.
2)￿Claridad: es fundamental que el código sea lo más claro y legible posible,
para facilitar así su desarrollo y posterior mantenimiento. Se debe intentar que
su estructura sea sencilla y coherente, así como cuidar el estilo en la edición;
de esta manera, se facilita el trabajo del programador, tanto en la fase de crea-
ción como en las fases posteriores de corrección de errores, ampliaciones, mo-
dificaciones, etc. Fases que pueden ser realizadas incluso por otro programa-
dor, con lo que la claridad es aún más necesaria para que otros programadores
puedan continuar el trabajo fácilmente.
3)￿Eficiencia: además de realizar aquello para lo que fue creado, debe realizarlo
minimizando los recursos que utiliza. La eficiencia se basa en el tiempo que
tarda en realizar la tarea para la que ha sido creado y a la cantidad de memoria
que necesita. Hay otros recursos que también deben ser considerados: espacio
en disco que utiliza, tráfico de red que genera, etc.
4)￿Portabilidad: se basa en la capacidad de poder ejecutarse en una platafor-
ma, ya sea hardware o software, diferente a aquélla en la que se elaboró. La
portabilidad es una característica muy deseable para un programa, ya que per-
mite, por ejemplo, a un programa que se ha desarrollado para sistemas GNU/
Linux ejecutarse también en la familia de sistemas operativos Windows, in-
cluso en distintas máquinas virtuales de Java o en los distintos navegadores
que existen en el mercado.
1.2. Modelos de desarrollo
Se entiende como modelos de desarrollo o paradigmas de programación a los
distintos enfoques o filosofías que se han ido creando para la construcción del
software. No existe un modelo mejor que otro, sino que, dependiendo del tipo
de problema, un modelo puede ser más apropiado que otro.
Los modelos de desarrollo más comunes son los siguientes:
• Programación imperativa.
• Programación funcional.
• Programación lógica.
• Programación orientada a objetos.

-- 6 of 44 --

CC-BY-NC-ND • PID_00220485 7 Introducción a la programación orientada a objetos
1.2.1. Programación imperativa
La programación imperativa se basa en un conjunto de instrucciones
que le indican al hardware cómo debe realizar una tarea. Está conside-
rada la más común y la representan, por ejemplo, lenguajes como C o
BASIC.
El hardware está diseñado para ejecutar código 
