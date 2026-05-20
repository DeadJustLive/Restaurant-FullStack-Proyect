# 11. Es obvio que cad(1, c) imprime c líneas.

## Fuente
problemas-y-algoritmos (Cap. 24)

## Contenido
# 11. Es obvio que cad(1, c) imprime c líneas.

Nótese que si n > 1, cadenas(n, c) llama c veces a cadenas(n − 1, c). Por
lo tanto
cad(1, c) = c
cad(n, c) = cad(n − 1, c)c para n > 1
Ahora por inducción es fácil darnos cuenta que
cad(n, c) = cn


-- 63 of 315 --

64 CAPÍTULO 5. BÚSQUEDA EXHAUSTIVA
Un algoritmo de cambio mínimo para generar cadenas binarias(de 0s y
1s) es aquel que genera todas las cadenas binarias de determinada longitud
en un orden tal que cada cadena diera de su predecesor en solamente un
caracter.
El siguiente código es una implementación de un algoritmo de cambio
mínimo que genera las 2n cadenas binarias.
Código 5.2: Generador de cadenas binarias con cambio mínimo
1 void g e n e r a ( int n ) {
2 i f ( n==0){
3 imprime_cadena ( ) ;
4 } e l s e {
5 g e n e r a ( n−1) ;
6 C[ i ] = !C[ i ] ;
7 g e n e r a ( n−1) ;
8 }
9 }
El código anterior genera las cadenas en un arreglo llamado C, y asume
que siempre será lo sucientemente grande para generar todas las cadenas, la
línea 3 llama a una función para imprimir la cadena generada, dicha función
no se muestra porque ocuparía demasiado espacio y no tiene relevancia en el
algoritmo.
Puede parecer un tanto confusa la línea 6, pero hay que recordar que !0
devuelve 1 y !1 devuelve 0.
Problema Resuelto 5.1.3. Demuestra que el código 5.2 genera todas las
cadenas binarias y que cada cadena que genera diere de la anterior en sola-
mente un dígito.
Solución Este problema requiere que se comprueben 2 cosas: una es que
el algoritmo genera todas las cadenas binarias de longitud n, y otra es que
las genera con cambio mínimo.
Si n = 1 basta con echar un vistazo al código para darse cuenta que
funciona en ambas cosas.
Podemos observar también, que luego de ejecutarse la línea 6 se llama
a genera(n − 1) y se sigue llamando recursivamente a la función genera sin
pasar por la línea 6 hasta que n toma el valor de 0 y se imprime la cadena
en la línea 3; de esta forma podemos asegurar que genera las cadenas con
cambio mínimo.
Para probar el hecho de que se imprimen todas las cadenas binarias de
longitud n, hay que hacer la siguiente observación que no es muy obvia:

-- 64 of 315 --

5.2. CONJUNTOS Y SUBCONJUNTOS 65
No importa si el arreglo C no está inicializado en 0s, siempre y cuando
contenga únicamente 0s y 1s. La prueba de esto es que dada una cadena
binaria de longitud n, se puede generar a partir de ella cualquier otra cadena
binaria de longitud n, simplemente cambiando algunos de sus 1s por 0s y/o
algunos de sus 0s por 1s. Si el algoritmo produce todas los conjuntos de
cambios que existen entonces generará todas las cadenas sin importar la
cadena inicial ya que a partir de una cadena se puede formar cualquier otra
luego de aplicar una serie de cambios.
La capacidad de poder hacer este tipo de razonamientos tanto es muy
importante, tan importante es poder reducir un problema como dividirlo.
De esa forma, suponiendo que para algún n − 1 la función produce todas
las cadenas de n − 1 caracteres, ¾las producirá para n?.
Dado que la función no hace asignaciones sino solamente cambios(línea
6), podemos estar seguros que si se producen todas las cadenas llamando a
la función con n − 1 signica que el algoritmo hace todos los cambios para
n − 1.
También se puede observar que la línea 5 llama a genera(n − 1) con
C[n] = a para alguna 0 ≤ a ≤ 1, y la línea 7 llama a genera(n − 1) con
C[n] =!a (si a = 0 entonces C[n] = 1 y si a = 1 entonces C[n] = 0).
Como C[n] está tomando todos los valores posibles y para cada uno de sus
valores esta generando todas las cadenas de tamaño n − 1 podemos concluir
que el algoritmo genera todas las cadenas binarias.

Hay que destacar una propiedad que se hayó en la solución:
Teorema 3. Sea cad(n, c) el número de cadenas que se pueden formar de
longitud n con un alfabeto de c letras.
cad(n, c) = cn
5.2. Conjuntos y Subconjuntos
Los conjuntos son estructuras que estan presentes en todas las áreas de
las matemáticas, y juegan un papel central en las matemáticas discretas y
por ende en las ciencias de la computación.
La idea básica de un conjunto es una colección de elementos, para los
cuales todo objeto debe pertenecer o no pertenecer a la colección.
Hay muchos ejemplos de la vida cotidiana de conjuntos, por ejemplo, el
conjunto de los libros de una biblioteca, el conjunto de muebles de la casa,
el conjunto de personas entre 25 y 30 años, etc.

-- 65 of 315 --

66 CAPÍTULO 5. BÚSQUEDA EXHAUSTIVA
Así como existen conjuntos tan concretos, las matemáticas tratan por lo
general con conjuntos más abstractos.
Por ejemplo el conjunto de los números entre 0 y 10, el conjunto de los
números pares, el conjunto de los polígonos regulares, entre otros. De hecho
casi todos los objetos matemáticos son conjuntos.
Los conjuntos nitos pueden describirse con una lista de sus elementos
separados por comas, por ejemplo, el conjunto de las vocales:
{a, e, i, o, u}
El conjunto de los números pares positivos de un solo dígito:
{2, 4, 6, 8}
Dado que un conjunto 
