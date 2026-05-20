# 2. Árboles n–arios de búsqueda equilibrados

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 70)

## Contenido
# 2. Árboles n–arios de búsqueda equilibrados

Al igual que ocurre con los árboles binarios de búsqueda, el coste de la operación de búsqueda es del orden de la
altura del árbol. Por tanto, es conveniente que el árbol n–ario de búsqueda sea “lo más equilibrado posible” (como los
árboles binarios AVL).
Un tipo particular de árboles n–arios de búsqueda equilibrados son los árboles B. Un árbol B de orden n tiene las
siguientes propiedades1:
• 	es un árbol n–ario de búsqueda;
• 	la raíz es una hoja o tiene al menos 2 hijos;
• 	cada nodo, excepto la raíz y las hojas, tiene al menos n/2 hijos;
• 	todas las hojas están en un mismo nivel.
En la siguiente figura puede verse un árbol B de orden 5.
18
10,12
4,6,8 	11 	13,14,16
22,28,34,38
19,20 	23,24,25 	29,30,31 	35,36 	39,40,41
Si un árbol B tiene M hojas y las hojas están en el nivel L, se tiene que el número de nodos en los niveles 1, 2, 3... es
por lo menos 2, 2 n/2 , 2 n/2 2 , ..., y por tanto: M ≥ 2 n/2 L –1 , es decir: L ≤ 1 + logn/2 (M / 2). Es decir, la altura está
acotada por el logaritmo del número de claves.
La implementación de las operaciones de búsqueda, inserción y borrado en este tipo de árboles puede encontrarse, por
ejemplo, en el capítulo 10 libro Estructura de datos. Libro de problemas de L. Joyanes, I. Zahonero, M. Fernández y L.
Sánchez (editorial McGraw Hill, 1999), o en el libro Data Structures and Algorithm Analysis in C++, 4th Edition de M.A.
Weiss (editorial Pearson/Addison Wesley, 2014).
Los árboles B de orden 3 se denominan también árboles 2–3. En un árbol 2–3, cada nodo, excepto las hojas, tiene dos
o tres hijos. Un estudio detallado sobre este tipo de árboles puede encontrarse, por ejemplo, en el libro Estructuras de Datos
y Algoritmos de A. V. Aho, J. E. Hopcroft y J. D. Ullman (páginas 171 a 182). Se presenta una implementación en la
siguiente sección.
Otra clase de árboles n–arios de búsqueda estudiada en la literatura es la de los árboles B*. La raíz de un árbol B* de
orden n tiene como mínimo 2 y como máximo 2 (2n-2)/3 + 1 hijos. Cada nodo de un árbol B* de orden n, excepto la raíz
y las hojas, tiene como mínimo (2n-1)/3 hijos. Todas las hojas de un árbol B* de orden n están en un mismo nivel.
Los árboles B* constituyen una mejora de los árboles B para aumentar el promedio de utilización de los nodos. La
inserción de claves en el árbol B* supone que si el nodo que le corresponde está lleno, se mueven las claves a uno de sus
hermanos, y así se pospone la división del nodo hasta que ambos hermanos están completamente llenos. Cuando finalmente
se dividan, esos dos hermanos pasarán a ser 3, y cada uno estará lleno en 2/3 partes de su capacidad.
Los árboles B+ son otra mejora de los árboles B. Mantienen la propiedad de acceso rápido en búsquedas para claves
cualquiera y, además, permiten un recorrido secuencial rápido. En un árbol B+ todas las claves se encuentran en las hojas,
duplicándose en la raíz y en los nodos interiores aquellas que definen los caminos de búsqueda. Las claves en el nodo raíz
e interiores se utilizan únicamente como índices. Para facilitar el recorrido secuencial rápido, las hojas están encadenadas
(enhebradas). Véase la figura.
1 Introducidos por R. Bayer y E. M. Mc Creight en “Organization and maintenance of large ordered indices”, Acta Informatica, vol. 1, no. 3, pp.
173–189, 1972.

-- 158 of 267 --

151
