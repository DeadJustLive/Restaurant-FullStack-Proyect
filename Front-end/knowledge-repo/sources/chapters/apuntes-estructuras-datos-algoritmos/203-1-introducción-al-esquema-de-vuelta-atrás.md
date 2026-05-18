# 1. Introducción al esquema de vuelta atrás

Hay problemas que no admiten métodos directos y sencillos de solución como muchos de los tratados hasta el
momento. En ocasiones es necesario aplicar la técnica o esquema general de prueba y error, que consiste en probar posibles
soluciones al problema hasta encontrar la solución adecuada.
Un esquema muy útil de prueba y error es el de vuelta atrás o retroceso (en inglés, backtracking). Consiste en
descomponer la tarea de encontrar una solución en varias subtareas, de forma que cada una de ellas admita varias
candidatas a soluciones. De esta forma se puede generar un árbol en el que las diferentes candidatas a soluciones de la
primera subtarea son los elementos del primer nivel. Se elige el primer subárbol y se ensaya una solución a la segunda
subtarea. De nuevo hay varias posibilidades que se encuentran en el siguiente nivel del árbol. De esta forma, la construcción
de una candidata a solución completa del problema se obtiene siguiendo un camino en el árbol que empieza en la raíz y va
descendiendo hasta llegar a una hoja. Es posible que en algún momento se descubra que la candidata tanteada no es la
solución al problema. En ese momento se debe retroceder en el árbol hasta el nivel anterior y ensayar otra solución para
la subtarea previamente planteada.
La exploración o búsqueda exhaustiva llevada a cabo en el árbol se denomina implícita porque el árbol nunca está
íntegramente almacenado en memoria, simplemente se dispone de uno o varios nodos del árbol y de las reglas para acceder
a nodos adyacentes (hijos o padre).
En resumen, en el esquema de vuelta atrás se intentan pasos hacia la solución completa del problema que son anotados,
y en caso de que más tarde se descubra que un paso no conduce a una solución completa se borra la anotación
correspondiente y se prueba otro.
De forma genérica, el esquema de vuelta atrás es el siguiente:
procedimiento ensaya
principio
inicializar selección de candidatas;
repetir
seleccionar siguiente;
si aceptable entonces
registrarla;
si solución incompleta entonces
ensaya;
si no exitoso entonces
cancelar registro
fsi
fsi
fsi
hastaQue exitosa or no más candidatas
fin
En muchos casos, es necesario que el algoritmo de “ensayo” reciba como parámetro el índice del paso o subtarea que
se va a resolver. Es frecuente también que el número de subtareas a realizar sea conocido (n) y que el número de candidatas
a solución para cada subtarea sea fijo (m). Entonces, el esquema de algoritmo de vuelta atrás toma la siguiente forma:

-- 213 of 267 --

200
procedimiento ensaya(ent i:entero)
variable k:entero
principio
k:=0;
repetir
k:=k+1;
seleccionar k-ésimo candidata;
si aceptable entonces
registrarla;
si i<n entonces
ensaya(i+1);
si no exitoso entonces
cancelar registro
fsi
fsi
fsi
hastaQue exitoso or (k=m)
fin
En el libro Algoritmos + Estructuras de Datos = Programas, de Niklaus Wirth, pueden encontrarse algunos ejemplos
clásicos que admiten una solución con el esquema de vuelta atrás, como: la vuelta del caballo (encontrar un recorrido de
un caballo por un tablero de ajedrez de forma que recorra todos los cuadros del tablero exactamente una vez), las ocho
reinas (colocar ocho reinas en un tablero de ajedrez sin que ninguna de ellas pueda matar a otra), los matrimonios estables
(dados dos conjuntos con igual número de elementos, encontrar una biyección entre ellos de forma que todas las parejas
relacionadas por esa aplicación satisfagan ciertas propiedades), etc.