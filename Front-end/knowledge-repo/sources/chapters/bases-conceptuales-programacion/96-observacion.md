# OBSERVACI´ON:

* esta es una manera adecuada de abstraer este problema
-}
{
DibujarSombra(nroBolitasTotal())
-- usa una funci´on para calcular el n´umero de bolitas de
-- la celda actual y llama a DibujarSombra tal n´umero
-- como argumento
}
Ejercicio 3.2.18. Escribir el procedimiento DibujarSombra que recibe un par ´ame-
tro valorIntensidad y coloca una sombra de la intensidad dada por el par ´ametro
en la celda lindante al Este, retornando luego a la celda original.
Las funciones simples permiten abstraer la implementaci ´on efectiva de ciertas
En este caso, llevar m ´as cer-
ca de las ideas del programador
a trav ´es de nombrar adecuada-
mente los elementos.
ideas expresadas mediante expresiones compuestas. Quiz ´as las expresiones
que resulten m ´as ´util abstraer de esta manera sean las determinadas por con-
diciones complejas expresadas mediante la combinaci ´on de varias expresiones
booleanas simples mediante conectivos l ´ogicos.
Condiciones booleanas m ´as complejas
A partir de los valores de verdad b ´asicos pueden construirse condiciones com-
plejas a trav ´es del uso de conectivos l ´ogicos. Los conectivos l ´ogicos son ope-
raciones entre booleanos. Los m ´as comunes, y que pueden ser representados
directamente en GOBSTONES, son la negaci ´on, la conjunci ´on y la disyunci ´on.
Definici ´on 3.2.5. Un conectivo l ´ogico es una operaci ´on entre booleanos. Los
conectivos m ´as comunes son la negaci ´on, la conjunci ´on y la disyunci ´on.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 118 of 312 --

119
Leer con Atenci ´on
La negaci ´on es un conectivo l ´ogico que toma un booleano y devuelve
otro booleano. Transforma True en False y viceversa. La manera de
escribir la negaci ´on de una expresi ´on booleana es con la operaci ´on not.
En resumen, not True es igual a False, y not False es igual a True.
Definici ´on 3.2.6. La negaci ´on es un conectivo l ´ogico unario. Su forma general
es
not < expBooleana >
donde < expBooleana > es cualquier expresi ´on cuyo resultado sea True o False.
Con esta operaci ´on, por ejemplo, podr´ıa escribirse una condici ´on que verifique
si en la celda actual no hay bolitas rojas como: not hayBolitas(Rojo). Esta
expresi ´on valdr ´a True cuando el n ´umero de bolitas rojas en la celda actual sea
0, y False en caso contrario, extactamente lo opuesto a hayBolitas(Rojo).
Ejercicio 3.2.19. Escribir una funci ´on noHayMarcianos() que retorne verdadero
si en la celda actual no hay ning ´un marciano, y falso en caso de que haya alguno.
Un marciano se representa mediante una bolita de color Azul.
Ejercicio 3.2.20. Escribir un ejercicio celdaVacia() que retorna verdadero si en
la celda actual no hay ninguna bolita de ning ´un color, y falso en caso de que haya
alguna. Para realizarlo, reutilizar la funci ´on nroBolitasTotal, y combinarla con
un operador de igualdad y el conectivo l ´ogico de negaci ´on.
Leer con Atenci ´on
Otro conectivo l ´ogico importante es la conjunci ´on, que toma dos valo-
res de verdad y retorna un tercero. La conjunci ´on de dos proposiciones,
expresada mediante la operaci ´on infija &&, ser ´a verdadera cuando am-
bas lo sean, y falsa en otro caso. Es la manera de representar el ‘y’ del
lenguaje natural.
Definici ´on 3.2.7. La conjunci ´on es un conectivo l ´ogico binario. Su forma general
es
< expBooleana1 > && < expBooleana2 >
donde < expBooleana1 > y < expBooleana2 > son expresiones cuyo resultado es
True o False.
La expresi ´on True && True tendr ´a como resultado True, y las expresiones True
&& False, False && True y False && False tendr ´an como resultado False. De
esta manera se pueden construir condiciones complejas, como preguntar si en
la celda actual hay bolitas rojas y verdes al mismo tiempo: hayBolitas(Rojo) &&
hayBolitas(Verde).
Ejercicio 3.2.21. Escribir una funci ´on hayFlores() que retorne verdadero si en
la celda actual hay alguna flor, y falso en caso de que no haya ninguna. Una flor se
representa mediante una bolita de color Rojo y una de color Verde. La condici ´on
de que haya flores puede verificarse, por tanto, verificando que haya bolitas de
ambos colores en la celda. ¡Observar que no se pide verificar que la cantidad de
bolitas verdes y rojas coincida, sino solo que haya de ambas! Y tambi ´en que no
molesta que haya bolitas de otros colores.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 119 of 312 --

120
Ejercicio 3.2.22. Escribir una funci ´on floresSinMarcianos() que retorne ver-
dadero si en la celda actual hay alguna flor, pero no hay ning ´un marciano. Con-
sidere reutilizar las funciones de los ejercicios anteriores, combinadas mediante
alg ´un conectivo adecuado.
Ejercicio 3.2.23. Escribir una funci ´on hayExactamenteUnaFlor() que retorna ver-
dadero si en la celda actual hay exactamente una flor (representada igual que en
el ejercicio 3.2.21). Tener en cuenta que no puede haber m ´as de una bolita ro-
ja y una verde en la celda. ¿C ´omo se puede expresar esta condici ´on utilizando
conjunciones y operaciones relacionales?
Leer con Atenci ´on
El tercer conectivo l ´ogico que se puede escribir en GOBSTONES de ma-
nera primitiva es la disyunci ´on. La disyunci ´on toma dos valores de ver-
dad y retorna otro. La disyunci ´on es verdadera cuando al menos uno
de los argumentos es verdadero, siendo falsa solo si ambos son falsos.
Para denotarla se utiliza la operaci ´on infija ||.
Definici ´on 3.2.8. La disyunci ´on es un conectivo l ´ogico binario. Su forma general
es
< expBooleana1 > || < expBooleana2 >
donde < expBooleana1 > y < expBooleana2 > son expresiones cuyo resultado es
True o False.
Las expresiones True || True, True || False y False || True tendr ´an como
resultado True, y la expresi ´on False || False tendr ´a como resultado False.
Con la disyunci ´on se puede pregunta si en la celda actual hay bolitas azules
o hay bolitas negras (puede faltar cualquiera de las dos): hayBolitas(Azul) ||
hayBolitas(Negro).
Actividad 19
¿C ´omo construir una condici ´on que verifique si hay alguna bolita en la
celda actual? Considere el ejercicio 3.2.24.
Ejercicio 3.2.24. Escribir una funci ´on hayBolitas que retorne verdadero si hay
alguna bolita en la celda actual (no importa su color). Considerar la utilizaci ´on de
una combinaci ´on m ´as complicada de hayBolitas y ||, y que involucre a los 4
colores. ¿Puede expresar la condici ´on de alguna otra forma?
Ejercicio 3.2.25. Escribir un procedimiento PintarCeldaMarron que pinte una
celda de color marr ´on (agregando bolitas de los cuatro colores en la celda actual)
solo si no hay bolitas de ning ´un color. Considerar la utilizaci ´on de la funci ´on del
ejercicio anterior y una alternativa condicional.
Para Reflexionar
Esta forma de expresiones complicadas puede ser extremadamente en-
gorrosa si tuvi ´eramos que usarlas directamente. ¿Entiende la importan-
cia de la habilidad de nombrar sus ideas? Este proceso, al que deno-
minamos abstracci ´on es s ´umamente importante en toda actividad de
programaci ´on.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 120 of 312 --

121
Leer con Atenci ´on
Al combinar diferentes conectivos l ´ogicos, la negaci ´on se resuelve pri-
mero, luego la conjunci ´on, y finalmente la disyunci ´on. Esto se denomina
precedencia de los operadores l ´ogicos.
Definici ´on 3.2.9. La precedencia de un operador es la prioridad que tiene el
mismo en una expresi ´on combinada para ser resuelto.
La negaci ´on tiene m ´as precedencia que la conjunci ´on, y la conjunci ´on m ´as prece-
dencia que la disyunci ´on. En caso de precisar alterar este orden, deben utilizarse
par ´entesis. Entonces, la expresi ´on
not hayPasto() && not hayMarciano() || haySangre()
significa lo mismo que
((not hayPasto()) && (not hayMaciano()))
|| haySangre()
Para obtener otros resultados, deben utilizarse par ´entesis de manera obligatoria.
Como ser
not (hayPasto()
&& (not (hayMarciano() || haySangre()))
)
Considerar que las funciones hayPasto(), hayMarciano() y haySangre() veri-
fican la existencia de cada uno de estos elementos, representados respectiva-
mente mediante bolitas verdes, azules y rojas.
Ejercicio 3.2.26. Escribir hayPasto(), hayMarciano() y haySangre().
Actividad 20
¿Cu ´al ser ´a el valor de verdad de las distintas condiciones compuestas
dadas antes? Para determinarlo, escriba una tabla que consigne las dife-
rentes posibilidades de una celda para contener bolitas (por ejemplo, si
contiene bolitas verdes pero no azules ni rojas, si contiene bolitas verdes
y azules pero no rojas, etc., e indicar en cada caso el valor booleano de
las expresiones.) ¿Qu ´e diferencia se observa entre ambas condiciones
(con diferentes precedencias)?
Ejercicio 3.2.27. Escribir un procedimiento PlantarYFertilizar que, reutilizan-
do la idea del ejemplo al comienzo del subsecci ´on 3.2.3, plante una flor si no hay
ninguna, y fertilice las flores que haya (ya sea que fueron reci ´en colocadas o
ya exist´ıan). Nombre adecuadamente sus subtareas utilizando procedimientos y
funciones auxiliares de manera conveniente.
Ejercicio 3.2.28. Revisar el ejercicio 3.2.16 para abstraer de manera adecuada
la condici ´on utilizada, d ´andole un nombre representativo a la misma mediante
una funci ´on (por ejemplo, seVaAExceder()).
3.3. Funciones avanzadas
En el apartado anterior aprendimos c ´omo escribir y utilizar funciones simples
(definici ´on 2.2.21), y trabajamos con ellas, aprendiendo c ´omo valernos adecua-
damente para abstraer nuestras ideas. En este apartado vamos a extender nues-
tra concepci ´on sobre las funciones, exhibiendo su uso junto con otros conceptos
avanzados de programaci ´on.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 121 of 312 --

122
3.3.1. Funciones con par ´ametros
As´ı como los procedimientos simples pueden generalizarse a esquemas de pro-
cedimientos mediante el uso de par ´ametros, las funciones simples pueden ge-
neralizarse a esquemas de funciones mediante el mismo recurso. La idea es la
misma: un par ´ametro indica el nombre de un valor que cambia en cada uso de
la funci ´on (como vimos, similar a un “agujero” que debe completarse al invocar
su uso en el c ´odigo). La sintaxis utilizada es similar a la utilizada para los proce-
dimientos: el nombre de los par ´ametros de la funci ´on se coloca entre par ´entesis
despu ´es del nombre de la misma (indicando que esta funci ´on tiene dichos “agu-
jeros”).
Definici ´on 3.3.1. Una funci ´on con par ´ametros es similar a una funci ´on simple,
pero agregando la noci ´on de par ´ametros. La forma de definir una funci ´on con
par ´ametros en GOBSTONES es
function < funcName >(< params >)
{
return(< expresion >)
}
siendo < funName > un identificador que comienza con min ´uscula, < params >,
una lista de identificadores que comienzan con min ´usculas y < expresion >, una
expresi ´on de cualquier tipo b ´asico.
Las funciones con par ´ametros se pueden invocar de manera similar a la vista
para procedimientos con par ´ametros, mediante el uso de argumentos, con la
diferencia, ya mencionada, de que por ser expresiones solo se pueden utilizar en
lugares donde se espera una expresi ´on.
Definici ´on 3.3.2. Una funci ´on con par ´ametros puede ser usada como una ex-
presi ´on. La forma de invocarla es escribir su nombre seguida por argumentos, de
la siguiente manera
< funcName >(< args >)
donde < args > es una lista de valores espec´ıficos (los argumentos) para los
par ´ametros de la funci ´on.
Las nociones de concordancia de tipos entre cada argumento y los usos que se
les da a los par ´ametros correspondientes es similar a la vista para los procedi-
mientos.
Por ejemplo, podemos ver si hay m ´as bolitas de un color que de otro, pero
usando par ´ametros para indicar qu ´e colores queremos.
function hayMasQue(color1, color2)
{-