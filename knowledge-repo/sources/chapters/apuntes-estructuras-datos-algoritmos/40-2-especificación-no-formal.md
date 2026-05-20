# 2. Especificación no formal

Las especificaciones no formales de TAD expresan el dominio de valores del TAD y la semántica de las operaciones
con lenguaje natural, estableciendo todas las propiedades que las definen, de forma independiente de cualquier posible
representación de los valores o implementación del TAD.
A pesar de la carencia de formalismo, una especificación no formal de un TAD se considera igualmente un “contrato
público” entre programadores, aquéllos que implementan el tipo y los que lo utilizan para resolver problemas.
Por tanto, las especificaciones no formales, al igual que las algebraicas, deben ser precisas, generales, legibles, no
ambiguas y definir totalmente el comportamiento del TAD y sus operaciones.
Utilizaremos una sintaxis parecida a la vista para las especificaciones algebraicas, mediante una notación funcional:
• 	Cada operación toma como parámetros 0 o N valores (definen el dominio o aridad de la operación). Se
denominan constantes las operaciones con 0 parámetros.
• 	Cada operación produce un solo valor resultado (define el rango o coaridad de la operación).
Las diferencias con respecto a la especificación algebraica son:
• 	daremos un nombre a cada uno de los parámetros del dominio de cada operación, y
• 	en lugar de utilizar ecuaciones para expresar la semántica de las mismas, utilizaremos descripciones textuales,
es decir, en lenguaje natural.
Una especificación no formal constará de:
• 	Una parte sintáctica denominada signatura, que define
o 	los géneros o nombres de los nuevos tipos,
o 	los nombres de las operaciones, y
o 	los perfiles de las operaciones, es decir, su dominio (incluidos los nombres de los parámetros) y rango.
• 	Una parte semántica:
o 	las descripciones textuales del dominio de valores del TAD y del comportamiento de las operaciones,
escritas en lenguaje natural, pero de forma precisa, general, legible, y no ambigua.
En el Anexo 6 incluimos este resumen de la sintaxis de la escritura no formal de especificaciones:
espec nombreEspecificación
[usa especificación1, especificación2, …]
[parámetro formal
género nombreGénero1, …
[operación
[parcial] [_]nombreOperación[_]: [dominio] -> rango
{Descripción del dominio y el rango de la operación, y en su caso de las situaciones que hacen la
operación parcial}
….
]
fpf ]
género nombreGénero1, … {descripción del dominio de valores del TAD}
operaciones
[parcial] nombreOperación: [dominio] -> rango
{Descripción del dominio y el rango de la operación.
[Parcial: descripción de las situaciones que hacen la operación parcial]}
...
[parcial] nombreOperación_: géneroArg nombreArg -> rango
{Descripción del dominio y el rango de la operación.
[Parcial: descripción de las situaciones que hacen la operación parcial]}

-- 28 of 267 --

21
...
[parcial] 	_nombreOperación_ :
géneroArg1 nombreArg1, géneroArg2 nombreArg2 -> rango
{Descripción del dominio y el rango de la operación.
[Parcial: descripción de las situaciones que hacen la operación parcial]}
...
fespec
Donde:
• 	[ ] Significa que lo que está entre los corchetes es opcional, puede que aparezca o no.
• 	Dominio es una lista de elementos separados por ‘,’ y donde cada elemento describe un argumento de la
operación, indicando el género (o nombre de tipo) y nombre del argumento.
• 	Rango es un género, el nombre del tipo resultado de la operación.
• 	El símbolo ‘_’ indica la posición de los argumentos respecto al nombre de la operación. Se utiliza para indicar
operaciones con notación prefija sin paréntesis o con notación infija (ejemplos: ¬_ , _≤_).
• 	El parámetro formal opcional que aparece encima de la definición del género lo utilizaremos para definir
TAD genéricos. Los presentaremos en detalle en la lección siguiente.
Insistimos que en las descripciones (parte semántica, escrita en color verde) no puede aparecer ningún detalle sobre
la implementación, es decir, sobre la forma en que se almacenan los valores del TAD (del estilo de “usaremos un vector
para…”) ni sobre cómo se deben implementar las operaciones (del estilo de “recorreremos el vector para…”).
Nótese que la sintaxis de escritura de especificaciones presentada incluye:
• 	descripción del dominio de valores del TAD (situamos esta descripción al lado del nombre del nuevo género
definido);
• 	para cada operación, junto a su perfil, debe describirse completamente:
o 	información 	de 	entrada 	y 	los 	prerrequisitos 	que 	deban 	cumplirse 	para 	usar 	la 	operación
(precondición),
o 	comportamiento o efecto de la operación al aplicarse sobre las entradas e indicando qué resultado se
genera (poscondición);
• 	situaciones indeseadas o de error:
o 	cuando existen casos para los cuales no existe un valor válido que pueda representar el resultado de la
operación;
o 	se considerarán operaciones parciales y se indicarán en la especificación.
Por ejemplo, una especificación no formal del TAD pila (genérico, es decir, pilas de datos de un tipo elemento
cualquiera) es la siguiente:
espec pilasGenéricas
usa booleanos
parámetro formal
género elemento
fpf
género pila
{Los valores del TAD pila representan secuencias de elementos con acceso LIFO (last in, first out), esto es,
el último elemento añadido (o apilado) será el primero en ser borrado (o desapilado)}
operaciones
pilaVacía: -> pila
{Devuelve una pila vacía, sin elementos}
apilar: pila p, elemento e -> pila
{Devuelve la pila resultante de añadir e a p}
desapilar: pila p -> pila
{Si p es no vacía, devuelve la pila resultante de eliminar de p el último elemento que fue apilado.
Si p es vacía, devuelve una pila igual a p}

-- 29 of 267 --

22
parcial cima: pila p -> elemento
{Devuelve el último elemento apilado en p.
Parcial: la operación no está definida si p es vacía}
esVacía?: pila p -> bool
{Devuelve verdad si y sólo si p no tiene elementos}
fespec
Nótese la necesidad de definir como parcial la operación cima para evitar la situación de error que se produciría al
intentar devolver el valor del elemento situado en la cima de una pila vacía, puesto que éste es inexistente.
Es decir, las operaciones parciales permiten describir funciones en las que el dominio pueda ser restringido (no todos
los valores del tipo), para evitar situaciones indeseadas o de error.
Veamos en otro ejemplo una posible especificación del TAD fecha, con unas pocas operaciones elementales:
espec fechas
usa enteros, booleanos
género fecha
{Los valores del TAD fecha representan fechas válidas según las reglas del calendario gregoriano.}
operaciones
parcial crear: entero d, entero m, entero a -> fecha
{Dados los tres valores enteros, se obtiene una fecha compuesta con los tres valores
dados usados como día, mes y año respectivamente.
Parcial: 1
≤d
≤ 31 y 1
≤m
≤12 y además deben formar una fecha válida según el calendario gregoriano.}
día: fecha f -> entero
{Dada una fecha f, se obtiene el entero que corresponde al día en la fecha f.}
mes: fecha f -> entero
{Dada una fecha f, se obtiene el entero que corresponde al mes en la fecha f.}
año: fecha f -> entero
{Dada una fecha f, se obtiene el entero que corresponde al año en la fecha f.}
iguales: fecha f1, fecha f2 -> booleano
{Dadas dos fechas f1 y f2, se obtiene un booleano con valor verdad si y sólo si la
fecha f1 es igual que la fecha f2, es decir, corresponden al mismo día, mes y año.}
anterior: fecha f1, fecha f2 -> booleano
{Dadas dos fechas f1 y f2, se obtiene un booleano con valor verdad si y sólo si la
fecha f1 es cronológicamente anterior a la fecha f2.}
posterior: fecha f1, fecha f2 -> booleano
{Dadas dos fechas f1 y f2, se obtiene un booleano con valor verdad si y sólo si la
fecha f1 es cronológicamente posterior a la fecha f2.}
fespec
Finalmente, un ejemplo de especificación del TAD tabla de frecuencias de enteros que aparece en el ejercicio de la
lección anterior:
espec tablas
usa naturales, enteros {supondremos que el 0 está en los naturales}
género tabla
{Los valores del TAD tablas de frecuencia representan colecciones de números
enteros tales que:
- no se almacenan enteros repetidos, pero si se registra cuántas veces se ha
introducido cada entero (su frecuencia)

-- 30 of 267 --

23
- las operaciones permiten obtener la información de un entero o su frecuencia
según su puesto en el orden decreciente por valores de frecuencia}
operaciones
inicializar: -> tabla
{Devuelve una tabla vacía, es decir, que no contiene datos para ningún número entero}
añadir: tabla t, entero e -> tabla
{Si e no está t, devuelve la tabla resultante de añadir e a t con número de apariciones igual a 1. Si e está en t,
devuelve la tabla resultante de incrementar en 1 el número de apariciones de e (su frecuencia) en t}
total: tabla t -> natural
{Devuelve el número total de enteros para los que t contiene información}
parcial infoEnt: tabla t, natural n -> entero
{Devuelve el entero que corresponde al n-ésimo entero en la tabla t según el orden en número de apariciones
decreciente.
Parcial: la operación no está definida si n=0 OR n>total(t)}
parcial infoFrec: tabla t, natural n -> natural
{Devuelve el natural que corresponde al número de apariciones del n-ésimo entero en la tabla t según el orden
en número de apariciones decreciente.
Parcial: la operación no está definida si n=0 OR n>total(t)}
fespec

-- 31 of 267 --

24

-- 32 of 267 --

25
Lección 3
Implementación de TAD
Indice