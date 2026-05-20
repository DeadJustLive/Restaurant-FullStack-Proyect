# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 524)

## Contenido
# PRECONDICI´ON:

* Ninguna (es una funci´on total)
-}
{
return (nroBolitas(color1) > nroBolitas(color2))
}
Con esta funci ´on podr´ıa verificarse que hubiera m ´as bolitas rojas que verdes
y m ´as negras que azules mediante la expresi ´on hayMasQue(Rojo,Verde) &&
hayMasQue(Azul,Negro).
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 122 of 312 --

123
Actividad de Programaci ´on 21
Realice el ejercicio 3.3.1. ¿Codific ´o un procedimiento auxiliar para abs-
trear la forma de huir? ¿O utiliz ´o simplemente un comando b ´asico?
Ejercicio 3.3.1. Escribir un procedimiento HuirSiPintaMal que huya de la celda
actual movi ´endose al Norte si en la misma hay m ´as enemigos que aliados. Los
aliados se representan mediante bolitas verdes y los enemigos mediante bolitas
rojas. Considerar la reutilizaci ´on de la funci ´on hayMasQue, pero utilizando fun-
ciones adecuadas para abstraer la representaci ´on de aliados y enemigos (por
ejemplo, con las funciones colorAliado() y colorEnemigo()).
Actividad de Programaci ´on 22
Realice el ejercicio 3.3.2. Util´ıcelo en una funci ´on esValorDigito que
dado un n ´umero determine si es un d´ıgito o no, retornando un booleano.
Ejercicio 3.3.2. Escribir una funci ´on enIntervalo que dados un n ´umero n y dos
n ´umeros inf y sup, retorne verdadero si n est ´a dentro del intervalo [inf,sup] (o
sea, es mayor o igual a inf y menor o igual a sup).
Las funciones parametrizadas proveen una herramienta m ´as poderosa que las
funciones simples. Sin embargo, el verdadero poder de las funciones radica en
poder realizar alguna forma de procesamiento antes de retornar su valor, permi-
tiendo, por ejemplo, visitar otras zonas del tablero.
3.3.2. Funciones con procesamiento
Las funciones simples y parametrizadas son una forma importante de abstraer
ideas que se expresan mediante expresiones complejas. Sin embargo, para po-
der devolver valores que dependan de otras celdas que no sea la celda actual,
o expresar valores que dependan de procesar informaci ´on dispersa en el table-
ro, es preciso contar con una forma m ´as poderosa de funciones: las funciones
con procesamiento. Este procesamiento se consigue agregando a las funciones,
previo a expresar su valor de retorno, un grupo de comandos que realicen este
procesamiento.
Definici ´on 3.3.3. Una funci ´on con procesamiento es una forma de funci ´on que
adem ´as de nombrar a una expresi ´on realiza previamente alg ´un procesamiento.
La forma de definir una funci ´on con procesamiento en GOBSTONES es
function < funcName >(< params >)
{
< comando >
return(< expresion >)
}
siendo < funName >, < params > y < expresion > como antes, y < comando >
un comando (que puede ser un comando compuesto como una secuencia de
comandos).
Por ejemplo, si queremos expresar la cantidad de enemigos (representados como
antes por una bolita roja cada uno) en una celda lindante a la actual, podemos
utilizar la siguiente funci ´on
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 123 of 312 --

124
function nroEnemigosAl(dir)
{-
