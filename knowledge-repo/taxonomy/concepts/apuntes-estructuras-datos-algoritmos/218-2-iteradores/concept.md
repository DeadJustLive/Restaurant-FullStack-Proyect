# 2. Iteradores

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 218)

## Contenido
# 2. Iteradores

Con las operaciones típicas que hemos mencionado para los contenedores (conjunto, multiconjunto, diccionario, etc.),
• 	¿cómo podemos (por ejemplo) mostrar todos los elementos del contenedor por pantalla?
• 	¿cómo podemos (por ejemplo) conocer todos los elementos del contenedor que cumplan cierta condición?
Sencillamente, teniendo en cuenta que la especificación del TAD se realiza sin conocer los detalles de la
implementación (en particular, sin saber cómo están almacenados los valores del TAD contenedor), no podemos.
Es necesario añadir a cualquier contenedor, cuyos datos se precise “recorrer” en algún momento, un conjunto pequeño
de operaciones que puedan servir para acceder a todos y cada uno de los elementos del contenedor una vez y sólo
una y de forma eficiente, y sin saber cómo están almacenados los elementos del contenedor. Ese conjunto de operaciones
se denomina iterador. Disponer de un iterador para un TAD permite implementar posteriormente algoritmos de recorrido
o búsqueda.

-- 57 of 267 --

50
Para definir un iterador, puede suponerse que, además de los elementos almacenados en el contenedor y sus posibles
relaciones, existe un cursor o índice que señala a un elemento del contenedor, o a ninguno si el cursor ya ha recorrido y
señalado antes a todos los elementos. Se necesitan las siguientes operaciones para, utilizando ese cursor, poder recorrer
todos los elementos del contenedor:
• 	iniciarIterador: prepara el cursor para que el siguiente elemento señalado (o a visitar) sea el primero del
contenedor (situación de no haber visitado ningún elemento), es decir, coloca el cursor señalando a un primer
elemento del contenedor (en el caso de un TAD lineal, suele ser el primero de la secuencia);
• 	¿existeSiguiente?: devuelve falso si ya se ha visitado el último elemento del contenedor (el cursor no señala a
ningún elemento), devuelve cierto en caso contrario;
• 	siguiente: devuelve el elemento señalado por el cursor; es una operación parcial: no está definida si no
¿existeSiguiente?;
• 	avanza: avanza el cursor para señalar a otro elemento del contenedor que todavía no se haya visitado, es decir,
que no haya sido señalado antes por el cursor; es una operación parcial: no está definida si no ¿existeSiguiente?
Es habitual implementar las operaciones siguiente y avanza juntas por razones de eficiencia y porque en el uso del
iterador para recorrer los elementos del contenedor siempre sería necesario invocar una tras otra:
procedimiento iniciarIterador(e/s c:tipo_del_contenedor)
{Prepara el cursor del contenedor c para que el elemento señalado sea el primero
del contenedor (situación de no haber visitado antes ningún elemento)}
función existeSiguiente(c:tipo_del_contenedor) devuelve booleano
{Devuelve falso si ya se ha visitado el último elemento del contenedor
(el cursor no señala a ningún elemento), devuelve cierto en caso contrario}
procedimiento siguiente(e/s c:tipo_del_contenedor;
sal e:elemento_base_del_contenedor; sal error:booleano)
{Si no ¿existeSiguente?(c) entonces devuelve el valor verdad en el parámetro error;
En caso contrario:
1. devuelve falso en el parámetro error;
2. devuelve el valor del elemento señalado por el cursor en el parámetro e;
3. avanza el cursor para señalar a otro elemento del contenedor que todavía no se haya
visitado}
Un uso típico para el que el iterador está diseñado es el siguiente (recorrido de los datos del contenedor):
iniciarIterador(c);
mientrasQue existeSiguiente(c) hacer
siguiente(c,e,error);
<utilizar el valor de e para algo>
fmq
Nunca se debe modificar el contenedor de datos (con las operaciones de añadir, borrar o modificar de que disponga)
mientras se recorren sus elementos con las operaciones de un iterador.
