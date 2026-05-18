# 2. Especificación algebraica

La especificación algebraica es una técnica formal para especificar TAD.
El objetivo es definir sin ambigüedades un tipo de datos (conjunto de valores y efecto de cada operación permitida).
Las ventajas de especificar algebraicamente TAD son:
• 	permite definir tipos independientemente de cualquier posible representación y razonar sobre la corrección de una
representación/implementación;
• 	unanimidad de la interpretación del tipo por los distintos programadores usuarios del mismo;
• 	deducir propiedades satisfechas por cualquier implementación correcta del tipo y, en consecuencia, posibilidad de
verificar formalmente los módulos que usan el tipo.
En esta sección se introduce la sintaxis habitual de las especificaciones algebraicas de tipos, si bien, no se entra en
profundidad en aspectos de su semántica puesto que en lo que sigue emplearemos una especificación no formal para definir
tipos.
Las especificaciones algebraicas se componen de una signatura y de un conjunto de ecuaciones.
La signatura de una especificación algebraica define los géneros o nombres de los nuevos tipos especificados, los
nombres de las operaciones y sus perfiles (es decir, su dominio o aridad y su rango o coaridad).

-- 25 of 267 --

18
Se suele utilizar una notación funcional para definir las operaciones de los TAD, es decir, una operación es una función
que toma como parámetros cero o más valores de diversos tipos y produce como resultado un solo valor de otro tipo.
Por ejemplo, la signatura del TAD tabla mencionado en la lección anterior es la siguiente:
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
natural y entero, en este caso). El género especificado en la signatura anterior es tabla. En general, una especificación
puede contener la definición de varios géneros.
En el ejemplo, se han definido los nombre y perfiles de cinco operaciones. Nótese lo siguiente:
• 	Hay operaciones 0-arias, es decir, con cero parámetros (como inicializar). Estas operaciones se denominan
constantes del tipo resultado (en el ejemplo, de tipo tabla). Su implementación puede consistir en una constante
de un tipo predefinido en el lenguaje utilizado, en una función sin parámetros o en un procedimiento con un solo
parámetro de salida, al que da valor el procedimiento. En el ejemplo, la constante inicializar se implementó
(en la lección anterior) de esta última forma.
• 	La traducción de la notación algebraica (funcional) a la imperativa (la que utilizamos habitualmente, dotada de
procedimientos y funciones) es normalmente inmediata. Por ejemplo, la operación total da lugar a una función
con igual perfil. En el caso de la operación añadir, se optó en la implementación de la lección anterior por un
procedimiento en el que el parámetro t de tipo tabla es un parámetro de entrada y salida, y por tanto hace un doble
papel: el de uno de los parámetros de la aridad y el de resultado.
• 	La restricción a sólo un resultado por función no es importante. En la práctica, varias operaciones con la misma
aridad y distinto resultado pueden combinarse en un solo procedimiento con varios parámetros de salida
(correspondiente a los resultados). Por ejemplo, las operaciones infoEnt e infoFrec se implementaron con el
procedimiento info.
Veamos, a continuación, una posible signatura de los tipos “booleano” y “naturales con el cero”.
espec boolnat
géneros booleano,natural
operaciones
verdad,falso: -> booleano
¬_: booleano -> booleano
_∧_,_∨_: booleano booleano -> booleano
0,1: -> natural
suc: natural -> natural
_+_,_*_: natural natural -> natural
_≤_,_>_: natural natural -> booleano
fespec
En este ejemplo, verdad, falso, 0 y 1 son constantes. La operación suc es prefija, es decir, el nombre de la operación
precede a los operandos y éstos van entre paréntesis y separados por comas. Para indicar operaciones prefijas sin paréntesis
o infijas, indicaremos mediante el símbolo ‘ _’ la posición de los argumentos con respecto al nombre de la operación
(ejemplos: ¬_, _+_, …).
Para cada género existe un conjunto de términos bien formados (es decir, sintácticamente correctos) o, simplemente,
términos. La signatura especifica cómo se construyen los términos. De manera informal, cada constante es un término y
la aplicación de un símbolo de operación a un número apropiado de términos de géneros adecuados es también un
término. En el caso de definir operaciones con notación infija se precisa además la utilización de paréntesis para construir
los términos. Los siguientes son tres ejemplos de términos bien formados:
1
(suc(1+suc(0))*1)≤1

-- 26 of 267 --

19
((verdad∨falso) ∧ (¬falso)) ∧ (0>suc(suc(1)))
A la especificación algebraica de un TAD se le puede atribuir una semántica o significado. Dicho significado consiste
en considerar que cada término bien formado denota un valor del tipo al que pertenece la expresión construida. Por
ejemplo, 	0, 	1, 	suc(0), 	0+1, 	son 	valores 	del 	tipo 	natural, 	mientras 	que 	verdad, 	falso, 	¬falso,
(suc(1+suc(0))*1)≤1, son valores de tipo booleano.
En la denominada semántica inicial del TAD natural definido previamente, cada término bien formado de tipo natural
denota un valor diferente de dicho tipo. Sin embargo, es posible que según la idea intuitiva del programador sobre el tipo
que está construyendo, varios términos bien formados diferentes deban corresponder a un mismo valor. Por ejemplo, los
términos 1, suc(0), 0+1, 1+0 y 1*1, corresponden a la idea abstracta “uno” que todos conocemos y por tanto deberían
tener un mismo significado. Sin embargo, la semántica inicial considera, por defecto, valores distintos aquéllos que se
construyen con términos distintos.
Considerando la semántica inicial, la siguiente especificación construye exactamente el tipo de los números naturales
(con el cero):
espec naturales_1
género natural
operaciones
0: -> natural
suc: natural -> natural
fespec
Los únicos valores que pueden construirse son 0, suc(0), suc(suc(0)), suc(suc(suc(0))), etcétera. Cada
término denota un valor diferente, que corresponde a la idea intuitiva de un natural diferente.
Si queremos añadir la operación “suma” a la especificación anterior, puede intentarse en la forma siguiente:
espec naturales_2
género natural
operaciones
0: -> natural
suc: natural -> natural
_+_: natural natural -> natural
fespec
Sin embargo, esta especificación construye un tipo que no corresponde con lo que llamamos “naturales” puesto que,
por ejemplo, los términos suc(0) y 0+suc(0) denotan, en principio, valores diferentes (algo contrario a nuestro
conocimiento sobre cómo los números naturales deberían comportarse).
La forma de expresar en una especificación que varios términos corresponden a un mismo valor y tienen, por tanto,
un mismo significado es añadir ecuaciones:
término_1 = término_2
Donde término_1 y término_2 son términos bien formados de un mismo género.
Para poder expresar el hecho de que un número grande o infinito de términos bien formados tienen el mismo valor se
pueden introducir variables en las ecuaciones. Se entiende que en cada ecuación con variables, éstas están (implícitamente)
cuantificadas universalmente (∀).
espec naturales_3
género natural
operaciones
0: -> natural
suc: natural -> natural
_+_: natural natural -> natural
ecuaciones x,y:natural
x+0 = x
x+suc(y) = suc(x+y)
fespec

-- 27 of 267 --

20