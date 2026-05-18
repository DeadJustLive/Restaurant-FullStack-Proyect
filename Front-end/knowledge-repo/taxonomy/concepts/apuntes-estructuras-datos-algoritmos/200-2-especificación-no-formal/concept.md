# 2. Especificación no formal

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 200)

## Contenido
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
paráme
