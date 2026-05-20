# estructuras-de-datos

- **ID**: estructuras-de-datos
- **Método**: native
- **Páginas**: 64
- **Capítulos**: 183
- **Generado**: 2026-05-17T09:15:22.516Z

## Resumen

# ESTRUCTURAS DE DATOS

## Capítulos

### Cap. 1 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 2 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

### Cap. 3 — FACULTAD DE CIENCIAS BÁSICAS E INGENIERÍA

# FACULTAD DE CIENCIAS BÁSICAS E INGENIERÍA

-- 1 of 64 --

2

### Cap. 4 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 5 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

El módulo de estudio de la asignatura ESTRUCTURAS DE DATOS es propiedad de la Corporación Universitaria
Remington. Las imágenes fueron tomadas de diferentes fuentes que se relacionan en los derechos de autor y las
citas en la bibliografía. El contenido del módulo está protegido por las leyes de derechos de autor que rigen al
país.
Este material tiene fines educativos y no puede usarse con propósitos económicos o comerciales.
AUTOR

### Cap. 6 — LUIS FERNANDO ZAPATA ALVAREZ

# LUIS FERNANDO ZAPATA ALVAREZ

### Cap. 7 — ESPECIALISTA EN GERENCIA INFORMATICA Y EN ADMINISTRACION DE LA INFORMATICA EDUCATIVA y MAGISTER EN

GESTION DE LA TECNOLOGIA EDUCATIVA.

Secciones:
  # ESPECIALISTA EN GERENCIA INFORMATICA Y EN ADMINISTRACION DE LA INFORMATICA EDUCATIVA y MAGISTER EN

Conclusión: Nota: el autor certificó (de manera verbal o escrita) No haber incurrido en fraude científico, plagio o vicios de
autoría; en caso contrario eximió de toda responsabilidad a la Corporación Universitaria Remington, y se declaró
como el único responsable.

### Cap. 8 — RESPONSABLES

# RESPONSABLES

Jorge Mauricio Sepúlveda Castaño
Decano de la Facultad de Ciencias Básicas e Ingeniería
jsepulveda@uniremington.edu.co
Eduardo Alfredo Castillo Builes
Vicerrector modalidad distancia y virtual
ecastillo@uniremington.edu.co
Francisco Javier Álvarez Gómez
Coordinador CUR-Virtual
falvarez@uniremington.edu.co

### Cap. 9 — GRUPO DE APOYO

# GRUPO DE APOYO

Personal de la Unidad CUR-Virtual

### Cap. 10 — EDICIÓN Y MONTAJE

# EDICIÓN Y MONTAJE

Primera versión. Febrero de 2011.
Segunda versión. Marzo de 2012
Tercera versión. noviembre de 2015
Derechos Reservados
Esta obra es publicada bajo la licencia Creative Commons.
Reconocimiento-No Comercial-Compartir Igual 2.5 Colombia.

-- 2 of 64 --

3

### Cap. 100 — ESTRUCTURAS DE DATOS

Grado de un vértice: Es el número de lados incidentes sobre él.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: Así
<1,2>, <2,3>,<3,4> pertenecen al conjunto de lados del Grafo 1, lo anterior quiere decir que en un grafo
pueden haber trayectorias que no son válidas.

### Cap. 101 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 102 — 5 BIBLIOGRAFÍA

Longitud de una trayectoria: Se define con la cantidad de lados que contiene.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: La relación que se da entre los vértices del grafo se representa en la matriz teniendo en cuenta lo
siguiente:
Si existe lado (Vi, Vj) el cruce entre i y j se llena con 1 (hay adyacencia)
En otro caso es 0 (se deja el cruce en blanco).

### Cap. 103 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 104 — INGENIERIA DE SISTEMAS

C por lo que esos cruces en la matriz tienen asignado 1 respectivamente.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: Los apuntadores de entrada a cada vértice se
encuentran en un vector de apuntadores de entrada.

### Cap. 105 — 3.4 Análisis de otras fórmulas de direccionamiento ................................................................................... 55

# ESTRUCTURAS DE DATOS

### Cap. 106 — ESTRUCTURAS DE DATOS

Multilista de adyacencia: Se define un registro para representar cada lado del grafo.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: Para hacer la representación se deben numerar los lados del grafo (aleatoriamente).

### Cap. 107 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 108 — 1 MAPA DE LA ASIGNATURA

# INGENIERIA DE SISTEMAS

Lado (A,B) se numera con 1
Lado (A,C) se numera con 2
Lado (B,C) se numera con 3
Lado (C,D) se numera con 4
En este caso m=4, n=4 (la matriz tiene 4 filas representan los vér

Secciones:
  # INGENIERIA DE SISTEMAS

### Cap. 109 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 11 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 110 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

¿Cuál representación de las propuestas para grafos se debe usar?
Todo depende del problema que se esté intentando resolver y además se debe acomodar a las
intenciones de diseño del programador.
Para crear un grafo en programación a partir de su representación que se recomienda y aplicación
de un proyecto de grafos en una situación real:
GRAFOS c++ distancias mas cortas Enlace

-- 35 of 64 --

36

### Cap. 111 — 2 UNIDAD 1 ARBOLES

# ESTRUCTURAS DE DATOS

### Cap. 112 — UTPL ÁRBOLES [(INFORMÁTICA)(ESTRUCTURA DE DATOS)] Enlace

# INGENIERIA DE SISTEMAS

Proyecto Final Estructura de Datos (grafos) Enlace
Además sería muy bueno ver representación de grafos en java:
Representação Gráfica de um Grafo em Java V. 3.2 Enlace

-- 36 of 64 --

37

### Cap. 113 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 114 — INGENIERIA DE SISTEMAS

Recorrido DFS: Es la sigla en inglés que quiere decir primero búsqueda en profundidad.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: En este algoritmo
se visitan todos los vértices adyacentes a un vértice dado.

### Cap. 115 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 116 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

El algoritmo para hacer un recorrido BFS sobre grafos en forma general es:
void BFS(entero v) //recibe como parámetro el vértice donde inicia
visitado[v]=1 // marca el vértic

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: A continuación se muestra un recorrido BFS con el grafo representado como matriz de adyacencia:
void BFS(entero v) //recibe como parámetro el vértice donde inicia
visitado[v]=1 // marca el vértice como visitado
cola.

### Cap. 117 — 2.2 TEMA 1 ARBOLES GENERALES Y SU REPRESENTACIÓN

# ESTRUCTURAS DE DATOS

### Cap. 118 — ESTRUCTURAS DE DATOS

# INGENIERIA DE SISTEMAS

49 - Grafos, El Camino Más Corto, Implementación (EDDJava) Enlace
Revisar grafos en Netbeans también interesante desde la programación con grafos
Grafos(Graphs) En NetBeans(java). prim y dijkstra Enlace

-- 39 of 64 --

40

### Cap. 119 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 12 — ESTRUCTURAS DE DATOS

# INGENIERIA DE SISTEMAS

### Cap. 120 — ESTRUCTURAS DE DATOS

# INGENIERIA DE SISTEMAS

3.2.2 EJERCICIOS PROPUESTOS

### Cap. 121 — INGENIERIA DE SISTEMAS

# 1) Elabore un algoritmo que imprima el recorrido DFS de un grafo representado como matriz de adyacencia.

### Cap. 122 — LIGA1 LIGA2 LIGA3 DATO

# 2) Elabore un algoritmo que imprima el recorrido BFS de un grafo representado como listas ligadas de

adyacencia

### Cap. 123 — REPRESENTACION DE ARBOLES GENERALES CON LISTAS LIGADAS

# 3) Elabore un algoritmo que imprima el recorrido BFS de un grafo representado como multilistas de

adyacencia

### Cap. 124 — ESTRUCTURAS DE DATOS

# 4) Elabore un algoritmo que imprima el recorrido DFS de un grafo representado como multilistas de

adyacencia

### Cap. 125 — INGENIERIA DE SISTEMAS

# 5) Elabore un algoritmo que imprima el recorrido BFS de un grafo representado como matriz de incidencia.

### Cap. 126 — SW DATO LIGA

# 3.3 MATRICES DISPERSAS

Una aplicación de matrices que poseen muchos de sus elementos en ceros se muestra en las estructuras de datos
como las matrices dispersas es algo que normalmente puede rebajar el procesamiento de algoritmos
relacionados con métodos aplicados a este tipo de matrices.

-- 40 of 64 --

41

### Cap. 127 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 128 — INGENIERIA DE SISTEMAS

Existen dos formas para representar matrices dispersas, por extensión y por comprensión.

Secciones:
  # INGENIERIA DE SISTEMAS

### Cap. 129 — 2.3 TEMA 2 ARBOLES BINARIOS Y SU REPRESENTACIÓN

# ESTRUCTURAS DE DATOS

### Cap. 13 — INGENIERIA DE SISTEMAS

# TABLA DE CONTENIDO

Pág.
1 MAPA DE LA ASIGNATURA ...............................................................................................................................5
2 UNIDAD 1 ARBOLES ..........................................................................................................................................6
2.1.1 Relación de conceptos ......................................................................................................................7

### Cap. 130 — ESTRUCTURAS DE DATOS

La tripleta en su posición cero define el orden de la matriz y el número de elementos diferentes de cero.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: Otra clase denominada matriz en tripletas.

### Cap. 131 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 132 — ESTRUCTURAS DE DATOS

# INGENIERIA DE SISTEMAS

Public:
Tripleta(entero f, entero,c,objeto, v) //constructor de la clase
Void asignafila(entero f) // determina la fila
Void asignacolumna(entero c) // determina la columna
V

Secciones:
  # INGENIERIA DE SISTEMAS

### Cap. 133 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 134 — A B C D E F G

Por ser una definición bastante simple de los algoritmos no requiere que sea explicada. Secciones: # INGENIERIA DE SISTEMAS Conclusión: A continuación se define la clase matizentripletas: Clase matrizentripletas Privado Tripleta v[] //característica privada de la clase Publico: Matrizentripletas(tripleta t) //constructor Void asignanumerotripletas(entero n) Void asignatripleta(tripleta tx, entero i) Entero retornafilas() Entero retornacolumnas() Entero retornanumerotripletas() Entero retornatripleta(entero i) Void muestramatrizentripletas(tripleta tx) //ver matriz en tripletas Void insertatripleta(tripleta tx) //insertar tripletas Matriz en tripletas suma(matizentripletas,b) //sumar matrices en tripletas Matriz en...

### Cap. 135 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 136 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

a.asignatripleta(t,c) //asigna el valor a la tripeta t,c
End(if)
End(for)
a.asignadatos(c ) //asigna datos a la matriz con asignadatos
return a //retorna la matriz en triplet

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: A continuación se escribirá el método matriz en tripletas
matrizentripletas(tripleta t) //constructor de la clase
entero m=t.

### Cap. 137 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 138 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

v=new tripleta[p] // asigna memoria de clase tripleta a “v”
v[0]=t //inicializa el vector de tripletas en el valor de “t”
for (i=1,i<=p,i++) do //ciclo que recorre con variab

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: El método actualiza el campo de valor de la tripleta que se halla en la posición 0 del vector v (indica el número
de elementos que se representan)
Entero retornafilas()
Tripleta t=v[0]
Return t.

### Cap. 139 — DEL PADRE

# ESTRUCTURAS DE DATOS

### Cap. 14 — ESTRUCTURAS DE DATOS

# 2.2 Tema 1 Arboles generales y su representación........................................................................................8

2.2.1 Definición de Arboles generales .......................................................................................................8
2.2.2 Terminología de árboles ...................................................................................................................8
2.2.3 Representación de Arboles n-arios ..................................................................................................9

### Cap. 140 — ESTRUCTURAS DE DATOS

Método que devuelve el número de elementos diferentes de cero.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: While(i<0datos)
Imprima(v[i].

### Cap. 141 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 142 — LI RP D LD

El anterior método simplemente recorre el vector de tripletas escribiendo los datos contenidos en cada tripleta.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: While (i<=datos and t.

### Cap. 143 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 144 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

### Cap. 145 — ESTRUCTURAS DE DATOS

# 1. Buscamos la primera tripleta que contenga la fila de la tripleta ti

### Cap. 146 — INGENIERIA DE SISTEMAS

# 2. Cuando se avanza sobre el vector de tripletas se tiene en cuenta que estemos en la misma fila de la tripleta ti y la columna de la tripleta ti sea mayor o igual que la de la tripleta i, en los d Secciones: # 2. Cuando se avanza sobre el vector de tripletas se tiene en cuenta que estemos en la misma fila de la Conclusión: Lo último es su ubicación dentro del vector y correr los datos...

### Cap. 147 — ESTRUCTURAS DE DATOS

# 3. El orden de magnitud es O(p), siendo p el número de tripletas (orden lineal) A continuación se presenta un método para calcular la transpuesta de una matriz dispersa representada en tripletas: L Secciones: # 3. El orden de magnitud es O(p), siendo p el número de tripletas (orden lineal) Conclusión: Matrizentripletas transpuesta //método que genera la transpuesta de matriz Entero i, p ,f , c, v //define cinco variables enteras Tripleta ti //define objeto ti de clase tripleta...

### Cap. 148 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 149 — ESTRUCTURAS DE DATOS

Es un método que se basa en llamar a insertatripleta para crear la transpuesta. Secciones: # INGENIERIA DE SISTEMAS Conclusión: Para evitar el llamado inserta tripleta dentro del algoritmo de la transpuesta en tripletas se propone el siguiente algoritmo para calcular la transpuesta en tripletas: Variación del algoritmo de la transpuesta en tripletas para mejorar su rendimiento Matrizentripletas transpuestaM() Entero i,j,k,m,n,p,f,c,v Tripleta tj, tx m=retornafilas() n=retornacolumnas() p=retornanumerotripletas() tx= new tripleta(n,m,p) matrizentripletas b=new matriz entripletas(tx) k=0 for(i=1;i<=n;i++) do for(j=1;j<=p;j++) do tj=retornatripleta(j)...

### Cap. 15 — INGENIERIA DE SISTEMAS

# 2.3 Tema 2 Arboles binarios y su representación ....................................................................................... 12

2.3.1 Definición de Arboles binarios....................................................................................................... 12
2.3.2 Propiedades de los Arboles binarios ............................................................................................. 14
2.3.3 Representación de los Arboles binarios ........................................................................................ 14
2.3.4 Taller del capítulo: ......................................................................................................................... 23

### Cap. 150 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 151 — ESTRUCTURAS DE DATOS

O(m*n) sigue siendo malo.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: M)
El anterior algoritmo de la transpesta elimina el llamado a insertatripleta, pero hacienda un análisis al algoritmo
el orden de magnitude puede llegar a ser O(m*n2) el cual comparado al algoritmo de la traspuesta en cuadriculas
O(m*n) sigue siendo malo.

### Cap. 152 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 153 — ESTRUCTURAS DE DATOS

# INGENIERIA DE SISTEMAS

end (for)
for(i=1;;i<=p;i++) do
ti=retornatripleta(i)
s[ti.retornacolumna()]=s[ti.retornacolumna()]+1
end (for)
t[1]=1
for(i=2;i<=n;i++)
t[i]=t[i-1]+s[i-1]
end(for)
for(i=1;;

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: Si aplicamos análisis de algoritmos a esta última propuesta el orden de magnitud es O(m+n) y en el peor de los
casos seria: =O(m*n), que en la mayoría de los casos mejora la eficiencia de un algoritmo con cuadriculas.

### Cap. 154 — INGENIERIA DE SISTEMAS

# 4.2 Representación de matrices dispersas con fórmulas de direccionamiento

4.2.1 Representación de matrices diagonales en vectores con fórmulas de direccionamiento
Sea una matriz cuadrada de orden n*n, donde todos los elementos de la diagonal principal son distintos
de cero así como el siguiente ejemplo:

-- 52 of 64 --

53

### Cap. 155 — 1. Para el siguiente Árbol general

# ESTRUCTURAS DE DATOS

### Cap. 156 — 2. Para el siguiente árbol binario:

# INGENIERIA DE SISTEMAS f/c 1 2 3 4 5 6 1 10 2 2 3 5 4 38 5 20 6 16 n=6 Si representamos la matriz en forma tradicional gastamos n2 posiciones de memoria, de los cuales se usan solamente n, para aho Secciones: # INGENIERIA DE SISTEMAS Conclusión: La fórmula de direccionamiento es: pos =i o pos =j y es válida para los elementos de la matriz m[i][j] que cumplan que i=j (se debe decir para cual...

### Cap. 157 — 3. Describir los recorridos inorden, postorden y preorden asociados al árbol del punto 2

# ESTRUCTURAS DE DATOS

### Cap. 158 — 4. Convertir el árbol del punto 1 en binario

# INGENIERIA DE SISTEMAS

f/c 1 2 3 4 5 6
1 8
2 20
3 10
4 7
5 5
6 2
Se podría representar usando un vector para almacenar los datos de la diagonal secundaria así:
1 2 3 4 5 6
8 20 10 7 5 2
La fórmula

Secciones:
  # INGENIERIA DE SISTEMAS

### Cap. 159 — 5. Escribir un algoritmo que cree un árbol binario de forma recursiva

# ESTRUCTURAS DE DATOS

### Cap. 16 — ESTRUCTURAS DE DATOS

# 2.4 Tema 3 Listas Generalizadas.................................................................................................................. 23

2.4.1 Definición de listas generalizadas .................................................................................................. 24
3 UNIDAD 2 GRAFOS......................................................................................................................................... 27
3.1.1 Relación de conceptos ................................................................................................................... 28
3.1.2 Definición de conceptos ................................................................................................................ 28

### Cap. 160 — 6. Hacer un seguimiento recursivo en Inorden para el árbol que tiene tres registros utilizando la pila

# INGENIERIA DE SISTEMAS

### Cap. 161 — 7. Escribir un algoritmo que busque un dato en que puede encontrarse dentro del árbol.

# 3.4 ANÁLISIS DE OTRAS FÓRMULAS DE DIRECCIONAMIENTO

3.4.1 FORMULA DE DIRECCIONAMIENTO DE MATRIZ TRIANGULAR INFERIOR

### Cap. 162 — 2.4 TEMA 3 LISTAS GENERALIZADAS

Este tipo de matrices aparecen regularmente en soluciones del algebra y programación lineal. Secciones: # IZQUIERDA Conclusión: La siguiente es la representación de las matrices que tienen un comportamiento disperso como triangular: Se representa en el caso de 3*3 de la siguiente manera: f/c 1 2 3 1 4 2 9 7 3 5 3 10 La representación de la matriz triangular inferior izquierda como vector por filas seria: 1 2 3 4 5 6 4 9 7 5 3...

### Cap. 163 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 164 — INGENIERIA DE SISTEMAS

En todas las matrices de este tipo se analiza: 1<=i<=n y 1<=j<=n , con i número de la fila y j número de la columna. Secciones: # INGENIERIA DE SISTEMAS Conclusión: Aplicando el método de inducción matemática en este caso se obtiene que un elemento perteneciente a la fila i columna j su pos el vector se obtiene con base a la suma de los elementos de las i-1 filas anteriores más la columna j así: pos para datos diferentes...

### Cap. 165 — ESTRUCTURAS DE DATOS

# PRINCIPAL (ESTILO, TÍTULO 4)

La característica principal de esta matriz es que los únicos elementos diferentes de cero se encuentran en la
diagonal principal y sus diagonales adyacentes. Ejemplo con una matriz dispersa de 4*4
f/c 1 2 3 4
1 8 5
2 15 9 6
3 11 2 10
4 20 1
Matriz tridiagonal

-- 56 of 64 --

57

### Cap. 166 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 167 — GENERALIZADA

# INGENIERIA DE SISTEMAS

Su respectiva representación por filas de la matriz dispersa en un vector seria:
1 2 3 4 5 6 7 8 9 10
8 5 15 9 6 11 2 10 20 1
En este caso y por el mismo método de inducción

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: Otras fórmulas de direccionamiento con matrices dispersas se pueden encontrar en:
Estructuras de Datos para Matrices Dispersas.

### Cap. 168 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 169 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

Ejercicios propuestos
Deducir la fórmula de direccionamiento de una matriz dispersa triangular inferior derecha para
representar por filas en un vector
Deducir la fórmula de

Secciones:
  # INGENIERIA DE SISTEMAS

### Cap. 17 — INGENIERIA DE SISTEMAS

# 3.2 Tema 1 Definición y terminología básica sobre grafos.......................................................................... 29

3.2.1 Definición de Grafos ...................................................................................................................... 29
3.2.2 Ejercicios propuestos ..................................................................................................................... 40

### Cap. 170 — 1. Representar con listas generalizadas el siguiente polinomio:

# ESTRUCTURAS DE DATOS

### Cap. 171 — 2. Representar como lista generalizada el siguiente conjunto al conjunto C:

# INGENIERIA DE SISTEMAS

### Cap. 172 — 3. Representar con listas generalizadas el siguiente árbol n-ario

Un hijo de una raíz en un árbol puede ser otro árbol con las mismas características.

Secciones:
  # 4 PISTAS DE APRENDIZAJE

Conclusión: Qdl0p3m6E
Recuerden por favor: que las representaciones que tienen en cuenta el registro de padre en sus nodos hijos
pueden devolverse a sus respectivos padres cuando se requiera en el método de la clase trabajada.

### Cap. 173 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 174 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

Recuerde bien: La diferencia entre un grafo dirigido y uno no dirigido
El grafo dirigido marca la orientación exacta de los lados, el no dirigido tiene las dos orientaciones.
Recuerde por favor que los grafos se pueden utilizar en la realidad en:
Mas sobre esta respuesta de grafos: https://www.youtube.com/watch?v=-zpx_wMUyQg

-- 60 of 64 --

61

### Cap. 175 — 3 UNIDAD 2 GRAFOS

# ESTRUCTURAS DE DATOS

### Cap. 176 — ESTRUCTURAS DE DATOS

No olvide que: los grafos tiene representaciones dinámicas y estáticas.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: Recuerde: la diferencia ente incidencia y adyacencia en la teoría de grafos.

### Cap. 177 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 178 — ESTRUCTURAS DE DATOS

# INGENIERIA DE SISTEMAS

No olvide por favor: Las diferencias entre los recorrido en anchura y profundidad.
Para reforzar el conocimiento ver video en la siguiente dirección:
https://www.youtube.com/watch?v=Y4tndzfQkoE
Recuerde Bien: Cual es la importancia de las listas generalizadas a nivel de las estructuras de datos?
Leer el siguiente pdf y confrontar las diferencias: http://www.inf.udec.cl/~andrea/cursos/estructura/Listas.pdf
No olviden por favor sobre la importancia de las matrices dispersas en aplicaciones lineales y en matemáticas
ver:

-- 62 of 64 --

63

### Cap. 179 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 18 — ESTRUCTURAS DE DATOS

# 3.3 Matrices dispersas ................................................................................................................................. 40

-- 3 of 64 --

4

### Cap. 180 — 3.2 TEMA 1 DEFINICIÓN Y TERMINOLOGÍA BÁSICA SOBRE GRAFOS

Como las matrices dispersas que tienen muchos datos en ceros.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: Es más conveniente aprender a realizar
almacenamiento de los datos de la matriz en una estructura lineal (baja el orden de magnitud de los algoritmos
optimizando código de programación)
Recuerde también: la representación estática con tripletas en Geogebra de una matriz dispersa:
https://www.

### Cap. 181 — L2={(A,B),(A,C),(B,C),(C,D)}

# ESTRUCTURAS DE DATOS

### Cap. 182 — GRAFOS CARACTERÍSTICAS

# INGENIERIA DE SISTEMAS

### Cap. 183 — ESTRUCTURAS DE DATOS

# 5 BIBLIOGRAFÍA

Becerra, S. C. (2000). Estructura de datos en java. bogota: Kimpres limitada.
Florez, r. (2012). Algoritmia 3. Medellin: universidad de antioquia.
Gotieb, C. C. (1978). Data type and structures. New jersey: Prentice Hall.
Joyanes Aguilar, l. (1999). Estructura de datos, libro de problemas. Madrid: McGrawHill.
Marti, O. O. (2004). Estructuras de datos y metodos algoritmicos. Madrid : Prentice Hall.

-- 64 of 64 --

### Cap. 19 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 20 — ESTRUCTURAS DE DATOS

# INGENIERIA DE SISTEMAS

3.3.1 Relación de conceptos ................................................................................................................... 41
3.3.2 Definición de matrices dispersas: .................................................................................................. 41
3.3.3 Representación de matrices en tripletas:...................................................................................... 42

### Cap. 21 — ESTRUCTURAS DE DATOS

# 3.4 Análisis de otras fórmulas de direccionamiento ................................................................................... 55

3.4.1 Formula de direccionamiento de matriz triangular inferior izquierda .......................................... 55
3.4.2 Formula de direccionamiento de matriz tridiagonal principal (estilo, Título 4) ............................ 56
4 PISTAS DE APRENDIZAJE ................................................................................................................................ 59
5 BIBLIOGRAFÍA ................................................................................................................................................ 64

-- 4 of 64 --

5

### Cap. 22 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 23 — ESTRUCTURAS DE DATOS

# INGENIERIA DE SISTEMAS

### Cap. 24 — INGENIERIA DE SISTEMAS

# 1 MAPA DE LA ASIGNATURA

-- 5 of 64 --

6

### Cap. 25 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 26 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

### Cap. 27 — ESTRUCTURAS DE DATOS

# 2 UNIDAD 1 ARBOLES

La estructura árbol que es recursiva por definición es utilizada en diversos tipos de soluciones como por ejemplo
la estructura de almacenamiento en disco de los archivos y directorios a partir el espacio particionado de disco
en un sistema operativo.

### Cap. 28 — INGENIERIA DE SISTEMAS

# UTPL ÁRBOLES [(INFORMÁTICA)(ESTRUCTURA DE DATOS)] Enlace

-- 6 of 64 --

7

### Cap. 29 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 30 — INGENIERIA DE SISTEMAS

Registro padre: Es el registro que es raíz del árbol o de un subárbol de la estructura y tiene hijos.

Secciones:
  # INGENIERIA DE SISTEMAS

### Cap. 31 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 32 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

Preorden: recorrido del árbol binario que va primero a la raiz, después al hijo izquierdo y por último al hijo
derecho.
Posorden: recorrido del árbol binario que va primero al hijo izquierdo, después al derecho y por ultimo a la raíz.

### Cap. 33 — INGENIERIA DE SISTEMAS

La definición de árboles parte del concepto de árbol general que no incluye el árbol sin ningún registro.

Secciones:
  # 2.2 TEMA 1 ARBOLES GENERALES Y SU REPRESENTACIÓN

Conclusión: Los registros que no tienen hijos dentro del árbol se denominan hojas.

### Cap. 34 — 1) Elabore un algoritmo que imprima el recorrido DFS de un grafo representado como matriz de adyacencia.

# ESTRUCTURAS DE DATOS

### Cap. 35 — 2) Elabore un algoritmo que imprima el recorrido BFS de un grafo representado como listas ligadas de

Al máximo nivel alcanzado por el árbol se le denomina la altura del árbol.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: REPRESENTACIÓN CON LISTAS LIGADAS
Para representar con listas ligadas se debe definir el registro teniendo en cuenta el grado del árbol.

### Cap. 36 — 3) Elabore un algoritmo que imprima el recorrido BFS de un grafo representado como multilistas de

# ESTRUCTURAS DE DATOS

### Cap. 37 — 4) Elabore un algoritmo que imprima el recorrido DFS de un grafo representado como multilistas de

# INGENIERIA DE SISTEMAS

datos que almacene la estructura. Esto hace que la representación desperdicie memoria cuando un
registro sea de grado inferior al del árbol y que además sea muy difícil de representar con listas pues
cada árbol con grado distinto tiene una definición del nodo completamente distinta. Si el grado del
árbol es 3 entonces el registro para la representación con listas tendría 3 campos de liga seria en ese
caso:

### Cap. 38 — 5) Elabore un algoritmo que imprima el recorrido BFS de un grafo representado como matriz de incidencia.

# LIGA1 LIGA2 LIGA3 DATO

Ejemplo:
La representación del árbol para el ejemplo de arriba con listas ligadas será:

### Cap. 39 — 3.3 MATRICES DISPERSAS

# REPRESENTACION DE ARBOLES GENERALES CON LISTAS LIGADAS

Árbol:
Representación:

-- 10 of 64 --

11

### Cap. 40 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 41 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

2.2.3.2 REPRESENTACIÓN CON LISTAS GENERALIZADAS
Para evitar los problemas de la representación con listas ligadas para los arboles generales recurrimos
a las listas generalizadas cuya definición del nodo en la representación es:

### Cap. 42 — ESTRUCTURAS DE DATOS

La representación utiliza una lista simplemente ligada para cada raíz con sus hijos.

Secciones:
  # SW DATO LIGA

Conclusión: SW DATO LIGA

Dónde: Si el sw =0 En el campo de dato hay un dato
Si sw=1 en el campo hay un apuntador hacia un sub árbol
La representación utiliza una lista simplemente ligada para cada raíz con sus hijos.

### Cap. 43 — TABLA DE CONTENIDO

# ESTRUCTURAS DE DATOS

### Cap. 44 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

### Cap. 45 — ESTRUCTURAS DE DATOS

# 2.3 TEMA 2 ARBOLES BINARIOS Y SU REPRESENTACIÓN Este tipo de estructuras de datos son los fundamentales en la teoría de árboles, pues permiten realizar recorridos y búsquedas con la suficiente rapi Secciones: # 2.3 TEMA 2 ARBOLES BINARIOS Y SU REPRESENTACIÓN Conclusión: Es importante anotar que los arboles binarios son también una estructura de datos recursiva por definición, esto quiere decir que en su creación se debe asumir por donde se quiere crear el árbol y se debe...

### Cap. 46 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 47 — ESTRUCTURAS DE DATOS

# INGENIERIA DE SISTEMAS

09-Árboles de búsqueda binarios-02-Definición Enlace
La terminología usada para los arboles generales se usa de la misma forma con los arboles binarios,
pero teniendo en cuen

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: Por ejemplo:
El registro D es hijo del registro B y nieto del registro A, mientras que D, E, F y G son hermanos, el
grado del árbol binario es 2 y la altura del árbol es 3 pues tiene tres niveles.

### Cap. 48 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 49 — ESTRUCTURAS DE DATOS

Sea n0 = al número de hojas del árbol y n2 número de registros de grado 2. Secciones: # INGENIERIA DE SISTEMAS Conclusión: REPRESENTACIÓN DE ÁRBOLES BINARIOS CON UN VECTOR El nivel 1 corresponde a una posición donde colocamos el dato de la raíz principal del árbol, a las dos posiciones siguientes les corresponde los datos de los dos registros hijos del nivel 2, las cuatro siguientes posiciones del vector serán para los dos pares de hijos del nivel 3,...

### Cap. 50 — INGENIERIA DE SISTEMAS

# A B C D E F G 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 Por tener el árbol solo tres niveles el tamaño de la estructura estática será de 7 un dato en el primer nivel, dos datos en el segundo nivel y cuat Secciones: # A B C D E F G Conclusión: En el caso de que el árbol no tenga alguno de los hijos de los dos lados...

### Cap. 51 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 52 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

Con:
LI: Apuntador al subárbol izquierdo del árbol
LD: Apuntador al subárbol derecho del árbol
D: Representa el dato almacenado en la estructura (este puede ser también un registro si es necesario almacenar
más datos).
34 - Árboles Binarios de Búsqueda, Creación e Inserción (EDDJava) Enlace

-- 15 of 64 --

16

### Cap. 53 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 54 — 2.2 Tema 1 Arboles generales y su representación........................................................................................8

# INGENIERIA DE SISTEMAS

Árbol Binario de Búsqueda Implementado en Java Enlace
Para el árbol del ejemplo la representación quedaría:
Las hojas siempre deben tener las dos ligas iguales a 0 (Esto se debe tener en cuenta para el algoritmo
cuenta hojas en arboles binarios).
2.3.3.3 REPRESENTACIÓN DE ÁRBOLES COMO UNA LISTA LIGADA CON LA DIRECCIÓN

### Cap. 55 — INGENIERIA DE SISTEMAS

# DEL PADRE

Esta representación difiere de la anterior por que la definición del nodo tiene un campo más para el
registro que es un apuntador con la dirección del padre. Así:

-- 16 of 64 --

17

### Cap. 56 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 57 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

### Cap. 58 — ESTRUCTURAS DE DATOS

# LI RP D LD LI, LD, D: Son la misma definición anterior y RP: Es la dirección del registro del padre para cada nodo representado. Si el registro es la raíz del árbol no tendrá RP. Esta representació Secciones: # LI RP D LD Conclusión: Se dan tres recorridos principales en los arboles binarios: (Se debe tener en cuenta que cuando se representan operaciones en un árbol binario la raíz siempre tiene al operador y los hijos son los...

### Cap. 59 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 60 — 1. Buscamos la primera tripleta que contenga la fila de la tripleta ti

# INGENIERIA DE SISTEMAS

Explicación: partimos de la raíz principal que es 10, pero como el recorrido primero va a la izquierda pasamos al
subárbol de raíz 5 pero a su vez este también tiene subárbol

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: Como ya se visitó el hijo
izquierdo se regresa a la raíz principal y se imprime 10 pasando a recorrer el hijo derecho del árbol que debe
imprimir respectivamente 11, 12 y 15 con el mismo análisis anterior.

### Cap. 61 — 2. Cuando se avanza sobre el vector de tripletas se tiene en cuenta que estemos en la misma fila de la

# ESTRUCTURAS DE DATOS

### Cap. 62 — 3. El orden de magnitud es O(p), siendo p el número de tripletas (orden lineal)

# INGENIERIA DE SISTEMAS Recorrido preorden: Consiste en imprimir el dato de la raíz y después visitar al hijo izquierdo y posteriormente al derecho como dos llamados recursivos a los subárboles resp Secciones: # INGENIERIA DE SISTEMAS Conclusión: Un ejemplo para este recorrido es: 36 - Árboles Binarios de Búsqueda, Recorrido PreOrden (EDDJava) Enlace Recorrido posorden: Consiste en recorrer inicialmente los hijos izquierdo y derecho para dejar de ultimo la impresión del dato de la raíz, su forma de representación...

### Cap. 63 — ESTRUCTURAS DE DATOS

# ESTRUCTURAS DE DATOS

### Cap. 64 — INGENIERIA DE SISTEMAS

# INGENIERIA DE SISTEMAS

37 - Árboles Binarios de Búsqueda, Recorrido PostOrden (EDDJava) Enlace

-- 20 of 64 --

21

### Cap. 65 — 2.3 Tema 2 Arboles binarios y su representación ....................................................................................... 12

# ESTRUCTURAS DE DATOS

### Cap. 66 — ESTRUCTURAS DE DATOS

# INGENIERIA DE SISTEMAS

Ejemplo de un árbol con los tres recorridos definidos:
Inorden: 1 3 4 6 7 8 10 13 14
Preorden: 8 3 1 6 4 7 10 14 13
Posorden: 1 4 7 6 3 13 14 10 8
Algoritmos para los recorri

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: LI(R)
Preorden(R.

### Cap. 67 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 68 — ESTRUCTURAS DE DATOS

Cualquier árbol general sin importar su grado, puede ser representado como un árbol binario.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: Lo que quiere decir que los
registros que están en una rama derecha del árbol son los hermanos de la raíz que los contiene.

### Cap. 69 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 70 — 4.2 Representación de matrices dispersas con fórmulas de direccionamiento

# INGENIERIA DE SISTEMAS

2.3.4 TALLER DEL CAPÍTULO:

### Cap. 71 — ESTRUCTURAS DE DATOS

# 1. Para el siguiente Árbol general

Representar como: Listas ligadas y listas generalizadas

### Cap. 72 — INGENIERIA DE SISTEMAS

# 2. Para el siguiente árbol binario:

Representar como listas ligadas y como listas ligadas con el registro del padre

### Cap. 73 — ESTRUCTURAS DE DATOS

# 3. Describir los recorridos inorden, postorden y preorden asociados al árbol del punto 2

### Cap. 74 — INGENIERIA DE SISTEMAS

# 4. Convertir el árbol del punto 1 en binario

### Cap. 75 — ESTRUCTURAS DE DATOS

# 5. Escribir un algoritmo que cree un árbol binario de forma recursiva

### Cap. 76 — 2.4 Tema 3 Listas Generalizadas.................................................................................................................. 23

# 6. Hacer un seguimiento recursivo en Inorden para el árbol que tiene tres registros utilizando la pila

### Cap. 77 — INGENIERIA DE SISTEMAS

# 7. Escribir un algoritmo que busque un dato en que puede encontrarse dentro del árbol.

### Cap. 78 — 3.4 ANÁLISIS DE OTRAS FÓRMULAS DE DIRECCIONAMIENTO

# 2.4 TEMA 3 LISTAS GENERALIZADAS

Es una estructura que permite escribir listas ligadas dentro de otras cuando la necesidad de manejo de información
lo requiera. Un ejemplo importante son los polinomios de varias variables en la teoría matemática o una forma
de representar árboles generales como listas generalizadas. Es posible que algún tipo de estructuras recursivas
se puedan representar como una lista generalizada.

-- 23 of 64 --

24

### Cap. 79 — IZQUIERDA

# ESTRUCTURAS DE DATOS

### Cap. 80 — ESTRUCTURAS DE DATOS

Cada elemento de la lista generalizada utiliza un nodo.

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: REPRESENTACIÓN DE LISTAS GENERALIZADAS
Su forma de representación básica es una lista ligada que define el registro de la lista como sigue:
sw dato liga
El sw se define de la si8guiente forma:
0: si en el campo de dato hay un átomo
1: si en el campo de dato hay un apuntador a una sublista
Cada elemento de la lista generalizada utiliza un nodo.

### Cap. 81 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 82 — PRINCIPAL (ESTILO, TÍTULO 4)

# INGENIERIA DE SISTEMAS

2.4.1.2 CONSTRUCCIÓN DE UNA LISTA LIGADA QUE REPRESENTA UNA LISTA

### Cap. 83 — ESTRUCTURAS DE DATOS

# GENERALIZADA

Se debe tener en cuenta la forma en que se define la hilera de entrada que representa la lista
generalizada así: paréntesis abierto, átomos, comas, paréntesis cerrado. El algoritmo rec

Secciones:
  # GENERALIZADA

Conclusión: Ultimo=x
“)” ultimo=pila.

### Cap. 84 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 85 — ESTRUCTURAS DE DATOS

# INGENIERIA DE SISTEMAS

//construcción que se interrumpió
Nota: una de las aplicaciones básicas de las listas generalizadas se da en la representación de polinomios con
muchas variables. La definici

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: Agregue tantos bloques de título y contenido como requiera.

### Cap. 86 — INGENIERIA DE SISTEMAS

# 1. Representar con listas generalizadas el siguiente polinomio:

3x2+(2y+3)x-2

### Cap. 87 — 3.2 Tema 1 Definición y terminología básica sobre grafos.......................................................................... 29

# 2. Representar como lista generalizada el siguiente conjunto al conjunto C:

A=(b, B, d, e)
B=(f,g)
C=(z, A,B)

### Cap. 88 — ESTRUCTURAS DE DATOS

# 3. Representar con listas generalizadas el siguiente árbol n-ario

-- 26 of 64 --

27

### Cap. 89 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 90 — 4 PISTAS DE APRENDIZAJE

# INGENIERIA DE SISTEMAS

### Cap. 91 — ESTRUCTURAS DE DATOS

Teoría de Grafos en la vida real.

Secciones:
  # 3 UNIDAD 2 GRAFOS

Conclusión: Árboles dirigidos con raíz.

### Cap. 92 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 93 — ESTRUCTURAS DE DATOS

# INGENIERIA DE SISTEMAS

3.1.1 RELACIÓN DE CONCEPTOS
3.1.2 DEFINICIÓN DE CONCEPTOS
Adyacencia: conformación de un lado
Conectado: Para un grafo no dirigido es la propiedad de ir a todos los otros vér

Secciones:
  # INGENIERIA DE SISTEMAS

Conclusión: RELACIÓN DE CONCEPTOS
3.

### Cap. 94 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

### Cap. 95 — ESTRUCTURAS DE DATOS

# INGENIERIA DE SISTEMAS

### Cap. 96 — INGENIERIA DE SISTEMAS

# 3.2 TEMA 1 DEFINICIÓN Y TERMINOLOGÍA BÁSICA SOBRE GRAFOS

3.2.1 DEFINICIÓN DE GRAFOS
Se define como un conjunto finito de puntos o vértices que se comunican con una traza llamada lado para
formar una figura con estas relaciones (un grafo contiene un conjunto finito de lados).
Ejemplos:
Grafo 1 Grafo 2 Grafo 3
Los vértices y lados para los grafos 1 y 2 son:
Grafo 1: V1={1,2,3,4}
L1={<1,2>,<1,3>,<2,3>,<2,4>,<3,4>}
Grafo 2: V2={A,B,C,D}

### Cap. 97 — ESTRUCTURAS DE DATOS

# L2={(A,B),(A,C),(B,C),(C,D)}

3.2.1.1 CLASIFICACIÓN
Los grafos se clasifican así:

### Cap. 98 — 3.3 Matrices dispersas ................................................................................................................................. 40

# GRAFOS CARACTERÍSTICAS

Grafos no dirigidos Se caracterizan por que sus lados no están
orientados, se representan entre paréntesis. Como

-- 29 of 64 --

30

### Cap. 99 — INGENIERIA DE SISTEMAS

# ESTRUCTURAS DE DATOS

