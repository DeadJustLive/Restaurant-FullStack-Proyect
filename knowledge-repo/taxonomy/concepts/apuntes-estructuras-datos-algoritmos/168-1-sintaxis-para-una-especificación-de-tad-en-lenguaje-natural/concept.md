# 1. Sintaxis para una especificación de TAD en lenguaje natural

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 168)

## Contenido
# 1. Sintaxis para una especificación de TAD en lenguaje natural

espec nombreEspecificación
[ usa especificación1, especificación2, … ]
[ parámetro formal
género nombreGénero1, …
[ operación
[parcial] [ _ ] 	nombreOperación [ _ ] : [ dominio ]  rango
{Descripción del dominio y el rango de la operación, y en su caso de las situaciones que hacen la operación
parcial}
….
]
fpf ]
género nombreGénero1, … {descripción del TAD}
operaciones
[parcial] nombreOperación: [ dominio ]  rango
{Descripción del dominio y el rango de la operación.
[Parcial: descripción de las situaciones que hacen la operación parcial]}
...
[parcial] nombreOperación _ : géneroArg nombreArg  rango
{Descripción del dominio y el rango de la operación.
[ Parcial: descripción de las situaciones que hacen la operación parcial]}
...
[parcial] 	_ nombreOperación: géneroArg1 nombreArg1, géneroArg2 nombreArg2  rango
{Descripción del dominio y el rango de la operación.
{ Parcial: descripción de las situaciones que hacen la operación parcial]}
...
...
fespec
Donde:
[ ] 	Significa que lo que está entre los corchetes es opcional, puede que aparezca o no
Dominio es una lista de elementos separados por ‘,’ y donde cada elemento describe un argumento de la operación,
indicando el género y nombre del argumento.
Rango es el nombre de un género.
El símbolo ‘_’ indica la posición de los argumentos respecto al nombre de la operación. Se utiliza para indicar
operaciones con notación prefija sin paréntesis o con notación infija (ejemplo: ¬_ , _≤_. ).

-- 259 of 267 --

246
