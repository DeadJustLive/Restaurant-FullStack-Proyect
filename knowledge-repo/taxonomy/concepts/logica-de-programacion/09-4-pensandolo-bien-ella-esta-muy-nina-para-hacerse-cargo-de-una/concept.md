# 4. Pens´andolo bien, ella est´a muy ni˜na para hacerse cargo de una

## Fuente
logica-de-programacion (Cap. 9)

## Contenido
# 4. Pens´andolo bien, ella est´a muy ni˜na para hacerse cargo de una

mascota, no le doy el perro, ni el gato, estar´ıa triste.
Para expresar este ejemplo con el operador O, recuerde la forma general
de una expresi´on:
Operando1 Operador Operando2
De acuerdo a esta forma general, el operando1 estar´a representado por
el perro y el operando2 ser´a el gato, el operador ser´a la disyunci´on
(O).
Los valores de Falso o Verdadero para cada operando estar´an dados
de la siguiente forma: si le regalo el perro el valor ser´a Verdadero, en
caso contrario ser´a Falso; para el gato se procede de la misma manera
(Ver Tabla 1.9).

-- 44 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 43
perro gato perro O gato Explicaci´on
Verdadero Verdadero Verdadero La sobrina est´a feliz
Verdadero Falso Verdadero La sobrina est´a feliz
Falso Verdadero Verdadero La sobrina est´a feliz
Falso Falso Falso La sobrina no est´a feliz
Tabla 1.9: Tabla de verdad del operador O - Ejemplo
Concluyendo, con el operador O, el resultado ser´a verdadero con solo
cumplir una de las condiciones.
Ejemplo con el operador NO: con este operador el asunto es m´as
sencillo; su funci´on es cambiar el estado l´ogico de su ´unico operando.
NO (5 < 10)
esta expresi´on se debe leer: es falso que 5 sea menor que 10.
El resultado que arroja esta expresi´on es Falso. La expresi´on relacional
(5 <10) es verdadera, al ser negada con el operador NO, cambia su estado
de Verdadero a Falso.
1.6.8 Prioridad de operaci´on
Las expresiones l´ogicas tambi´en pueden combinar expresiones
relacionales. En el momento de hacer su evaluaci´on, al igual que con los
operadores aritm´eticos, se debe respetar la precedencia y para ello en la
Tabla 1.10 se dar´a el orden de ejecuci´on de todos los operadores, incluyendo
los par´entesis.
En los siguientes ejemplos se ilustrar´a la aplicaci´on de la tabla. Suponga
la siguiente asignaci´on de valores:
a = 5
b = 10
c = 15
¿Cu´al ser´ıa el resultado de la siguiente expresi´on l´ogica?
a < b Y b < c
5 < 10 Y 10 < 15
Verdadero Y Verdadero
Verdadero

-- 45 of 450 --

44 Fundamentos
Orden Operador
1 ( )
2 - (signo)
3 ˆ
4 *, /, %
5 +, -
6 <, <=, >, >=
7 ==, ! =
8 NO (Negaci´on)
9 Y (Conjunci´on)
10 O (Disyunci´on)
11 = (asignaci´on)
Tabla 1.10: Prioridad completa de los operadores
Primero se eval´uan las expresiones relacionales y luego el operador
l´ogico (Y). Ambas expresiones relacionales son verdaderas, por lo tanto
la expresi´on l´ogica es verdadera.
En el caso del ejemplo anterior no se usaron par´entesis, es una buena
pr´actica usarlos para dar mayor claridad a las expresiones, aunque de
acuerdo al orden de prioridad, no son requeridos. Esta expresi´on tambi´en
puede ser expresada as´ı:
(a < b) Y (b < c)
Expresiones m´as complejas, tambi´en se eval´uan de acuerdo a la prioridad
expresada en la Tabla 1.10. Ejemplo:
(20 > 40 Y 2 <= 10) O (32 < 50 Y 20 <= 20)
Obs´ervese que se tienen dos juegos de par´entesis separados por el
operador l´ogico O. Para que el resultado final sea verdadero, uno de los
juegos de par´entesis deber´a tener un resultado verdadero. Sin embargo,
cada juego de par´entesis tiene en su interior un operador Y que implica
que ambas expresiones dentro de cada par´entesis deben ser verdaderas para
entregar un resultado verdadero. La evaluaci´on, de acuerdo a la prioridad,
es la siguiente:
Primero se eval´ua el par´entesis de la izquierda:
(20 > 40 Y 2 <= 10) O (32 < 50 Y 20 <= 20)
Dentro de ´el, la prioridad la tienen los operadores relaciones:
(Falso Y 2 <= 10) O (32 < 50 Y 20 <= 20)

-- 46 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 45
Teniendo en cuenta que la expresi´on l´ogica est´a conectada por el
operador Y, no hace falta la evaluaci´on de la expresi´on relacional del
lado derecho (2 <= 10), porque se sabe que el resultado ser´a falso. Sin
embargo, se realizar´a con fines did´acticos:
(Falso Y Verdadero) O (32 < 50 Y 20 <= 20)
La primera expresi´on l´ogica arroja un resultado falso:
Falso O (32 < 50 Y 20 <= 20)
Ahora se procede con la parte derecha del operador O.
Falso O (32 < 50 Y 20 <= 20)
Falso O (Verdadero Y 20 <= 20)
Falso O (Verdadero Y Verdadero)
Falso O Verdadero
El resultado final de esta expresi´on es verdadero.
Las expresiones l´ogicas tambi´en son muy ´utiles para definir intervalos:
(edad >= 18) Y (edad <= 24)
Para que esta expresi´on l´ogica entregue un resultado verdadero, el dato
almacenado en la variable edad deber´a ser mayor o igual a 18 y menor o
igual a 24.
1.7. Algoritmo
Un algoritmo es un conjunto de acciones o pasos finitos, ordenados de
forma l´ogica y que se utilizan para resolver un problema o para obtener un
resultado.
Si se detiene unos instantes a analizar esta definici´on, puede concluir
que el uso de algoritmos es muy com´un en su vida diaria. Piense en
algunas de las tareas que realiza desde el momento en que se levanta
hasta que se vuelve a acostar. Ese conjunto de tareas lo hace de forma
mec´anica y repetitiva, pero por lo general siempre ejecuta los mismo
