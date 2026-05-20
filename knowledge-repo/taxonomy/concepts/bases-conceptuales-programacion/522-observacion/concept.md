# OBSERVACI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 522)

## Contenido
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
ja y una verde en la celda. ¿C ´omo se puede expresar esta condici ´on utiliz
