# INGENIERIA DE SISTEMAS

## Fuente
estructuras-de-datos (Cap. 164)

## Contenido
# INGENIERIA DE SISTEMAS

2.4.1 DEFINICIÓN DE LISTAS GENERALIZADAS
Es un conjunto finito de n elementos (n>=0) cada uno de los cuales representa un dato almacenado o apunta a
otra lista generalizada, es una estructura que se define así misma ósea que es recursiva. Los datos que puede
representar se denominan átomos. Realizando una representación de acuerdo a la teoría formal de conjuntos
la notación usada será: letras mayúsculas representan listas y letras minúsculas representan átomos. Un ejemplo
seria:
A={x,y}
C={a,A,c}
B={d,C,f,A}
Se pueden mostrar los conjuntos C y B por extensión:
C={a,(x,y},c}
B={d,{a,A,c},f, {x,y}}= {d,{a,{x,y},c},d, {x,y}}
2.4.1.1 REPRESENTACIÓN DE LISTAS GENERALIZADAS
Su forma de representación básica es una lista ligada que define el registro de la lista como sigue:
sw dato liga
El sw se define de la si8guiente forma:
0: si en el campo de dato hay un átomo
1: si en el campo de dato hay un apuntador a una sublista
Cada elemento de la lista generalizada utiliza un nodo. A continuación, se representa la lista del ejemplo
propuesto en la representación de conjuntos:

-- 24 of 64 --

25
