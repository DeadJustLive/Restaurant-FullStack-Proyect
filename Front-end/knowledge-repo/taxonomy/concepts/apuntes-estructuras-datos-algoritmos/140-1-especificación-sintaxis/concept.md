# 1. Especificación: sintaxis

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 140)

## Contenido
# 1. Especificación: sintaxis

La especificación algebraica es una técnica formal para especificar o definir TAD. El objetivo es definir sin
ambigüedades un tipo de datos (conjunto de valores y efecto de cada operación permitida).
Las ventajas de especificar algebraicamente TAD son:
• 	permite definir tipos independientemente de cualquier posible representación y razonar sobre la corrección de una
representación/implementación,
• 	unanimidad de la interpretación del tipo por los distintos programadores usuarios del mismo,
• 	deducir propiedades satisfechas por cualquier implementación correcta del tipo y, en consecuencia, posibilidad de
verificar formalmente los módulos que usan el tipo.
En esta sección se introduce una sintaxis para realizar especificaciones algebraicas de tipos. Dichas especificaciones
contarán de una signatura y de un conjunto de ecuaciones.
La signatura de una especificación algebraica define los géneros o nombres de los nuevos tipos especificados, los
nombres de las operaciones y sus perfiles (es decir, su dominio o aridad y su rango o coaridad).
Se va a utilizar una notación funcional para definir las operaciones de los TAD, es decir, una operación será una
función que toma como parámetros cero o más valores de diversos tipos y produce como resultado un solo valor de otro
tipo.
Por ejemplo, la signatura del TAD tabla de frecuencias, definido, implementado y utilizado en el Tema I, es la siguiente:
espec tablas
usa naturales,enteros
género tabla
operaciones
inicializar: -> tabla
añadir: tabla entero -> tabla
total: tabla -> natural
infoEnt: tabla natural -> entero
infoFrec: tabla natural -> natural
fespec
La cláusula usa se utiliza para importar las definiciones hechas en otras especificaciones (definición de los géneros
natural y entero). El género especificado en la signatura anterior es tabla. En general, una especificación puede
contener la definición de varios géneros.
En el ejemplo, se han definido los nombre y perfiles de cinco operaciones. Nótese lo siguiente:
• 	Hay operaciones 0-arias, es decir, con cero parámetros (como inicializar). Estas operaciones se denominan
constantes del tipo resultado (en el ejemplo, de tipo tabla). Su implementación puede consistir en una constante
de un tipo predefinido en el lenguaje utilizado, en una función sin parámetros o en un procedimiento con un solo

-- 231 of 267 --

218
parámetro de salida, al que da valor el procedimiento. En el ejemplo, la constante inicializar se implementó
(en el Tema I) de esta última forma.
• 	La traducción de la notación algebraica (funcional) a la imperativa (la que utilizamos habitualmente, dotada de
procedimientos y funciones) es normalmente inmediata. Por ejemplo, la operación total da lugar a una función
con igual perfil. En el caso de la operación añadir, se optó en la implementación del Tema I por un procedimiento
en el que el parámetro t de tipo tabla, de entrada y salida, hace un doble papel: el de uno de los parámetros de la
aridad y el de resultado.
• 	La restricción a sólo un resultado por función no es importante. En la práctica, varias operaciones con la misma
aridad y distinto resultado pueden combinarse en un solo procedimiento con varios parámetros de salida
(correspondientes a los resultados). Por ejemplo, las operaciones infoEnt e infoFrec se implementaron en el
