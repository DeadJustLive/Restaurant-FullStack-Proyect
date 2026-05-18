# 3. POO en los distintos lenguajes de programación

## Fuente
introduccion-poo (Cap. 6)

## Contenido
# 3. POO en los distintos lenguajes de programación

El objetivo de este apartado es presentar los principales lenguajes de progra-
mación que han incorporado la POO en su implementación. Para ello, en cada
uno de estos lenguajes se realizará una pequeña revisión histórica y se presen-
tarán sus principales características.
3.1. Smalltalk
Smalltalk fue desarrollado en Xerox Parc (Palo Alto Research Center) bajo el
impulso de Alan Kay durante la década de los setenta. Inicialmente debía ser
un lenguaje para un ordenador personal llamado Dynabook dirigido a todo
tipo de usuarios (incluidos niños). Debía ser, por lo tanto, un sistema con un
entorno intuitivo y fácil de programar. Aunque el proyecto Dynabook nunca
se completó, el lenguaje adquirió vida propia y continuó su camino.
Es poco conocida la gran importancia que tuvo este desarrollo en la evolución
posterior de la informática. De él parten muchas de las ideas que hoy son la
base de las interfaces de usuario, como el uso de gráficos, ratón, ventanas y
menús desplegables.
Smalltalk es un lenguaje orientado a objetos puro (el mismo término, si no el
concepto, fue inventado por Alan Kay) e incluye todos los conceptos clave,
como clases, métodos, mensajes y herencia. Todo el programa es una cadena
de mensajes enviados a objetos.
Las principales características del lenguaje son:
• Orientación a objetos pura.
• Tipos dinámicos.
• Herencia simple.
• Compilación en tiempo de ejecución o interpretado.
Smalltalk es un modelo puro orientado a objetos, lo que significa que, en el
entorno, todo es tratado como un objeto. Entre los lenguajes orientados a
objetos, Smalltalk es el más consistente en cuanto al manejo de las definiciones
y propiedades del paradigma orientado a objetos.
Se puede afirmar que es más que un lenguaje, es un entorno de desarrollo
con más de doscientas clases y varios miles de métodos. Smalltalk contiene
los siguientes componentes:
• Un lenguaje.
Alan Kay (1940)
Informático estadounidense
pionero en la programación
orientada a objetos y el dise-
ño de sistemas de interfaces de
usuario. Es profesor adjunto de
en la Universidad de California
en Los Ángeles. Una de sus fra-
ses mas célebres es: "La mejor
manera de predecir el futuro
es inventarlo".

-- 31 of 44 --

CC-BY-NC-ND • PID_00220485 32 Introducción a la programación orientada a objetos
• Un modelo de objeto, que define cómo actúan los objetos e implementa
la herencia, el comportamiento de clases e instancias, la asociación diná-
mica, el manejo de mensajes y las colecciones.
• Un conjunto de clases reutilizables, que dispone de una gran cantidad de
clases que pueden ser reutilizadas en cualquier programa. Estas clases pro-
veen las funciones básicas en el lenguaje, además del soporte para la por-
tabilidad a diferentes plataformas, incluida la portabilidad de las interfaces
gráficas de usuario.
• Un conjunto de herramientas de desarrollo, que habilitan a los programa-
dores a mirar y modificar las clases existentes, así como a renombrar, agre-
gar y borrar clases. También proveen de detección de errores, incluida la
habilidad de agregar paradas en la ejecución, observar los valores de las
variables, modificar el valor de variables en ejecución y realizar cambios
al código en tiempo de ejecución de un programa.
• Un entorno en tiempo de ejecución, que permite a los usuarios terminar
con el ciclo "compilado-linkeado-ejecución" de un programa. Esto permite
a los usuarios ejecutar un programa en Smalltalk mientras se cambia el
código fuente, de manera que los cambios realizados en el código fuente
son reflejados instantáneamente en la aplicación que se está ejecutando.
Una de las mejores características de Smalltalk es el alto￿grado￿de￿reutiliza-
ción del código, ya que contiene un gran conjunto de objetos que pueden ser
utilizados directamente o modificados de un modo sencillo para satisfacer la
necesidad de una aplicación en general.
Smalltalk no￿posee￿una￿notación￿explícita para describir un programa ente-
ro. Sí que se emplea una sintaxis explícita para definir ciertos elementos de
un programa, tales como métodos, pero la manera en la que esos elementos
están estructurados dentro de un programa entero generalmente es definida
por las múltiples implementaciones.
La sintaxis de Smalltalk tiende a ser minimalista, lo que implica que existe un
grupo reducido de palabras reservadas y declaraciones en comparación con la
mayoría de los lenguajes populares. Smalltalk posee un grupo de 5 palabras
reservadas: self, super, nil, true y false.
Las implementaciones utilizan técnicas de recolección de basura para detec-
tar y reclamar espacio en memoria asociado con objetos que ya no se utilizarán
más en el sistema. La manera de ejecución del recolector de basura es en back-
ground, es decir, como un proceso de baja prioridad no interactivo, aunque
en algunas implementaciones es posible ejecutarlo a demanda. La frecuencia
y las características de la recolección dependen de la técnica utilizada por la
im
