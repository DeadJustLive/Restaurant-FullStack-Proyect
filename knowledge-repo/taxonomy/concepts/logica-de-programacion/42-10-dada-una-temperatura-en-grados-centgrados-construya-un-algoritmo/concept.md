# 10. Dada una temperatura en grados cent´ıgrados, construya un algoritmo

## Fuente
logica-de-programacion (Cap. 42)

## Contenido
# 10. Dada una temperatura en grados cent´ıgrados, construya un algoritmo

que convierta esa temperatura tanto a grados Kelvin como a grados
Fahrenheit. Use las siguientes f´ormulas.
f ahrenheit = centigrados ∗ 9
5 + 32
kelvin = centigrados + 273

-- 119 of 450 --



-- 120 of 450 --

Cap´ıtulo 3
Estructuras de decisi´	on
Cuando se est´a depurando, el
programador novato introduce
c´odigo correctivo; el experto
elimina el c´odigo defectuoso
Richard Pattis
Objetivos del cap´ıtulo:
Construir algoritmos que involucran con-
diciones simples, compuestas, anidadas y
m´ultiples.
Reconocer y utilizar los ´arboles de decisi´on en
el an´alisis de problemas.
Elaborar diagramas de flujo que representen los
tipos de decisiones.

-- 121 of 450 --



-- 122 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 121
Una de las estructuras fundamentales en la creaci´on de algoritmos son
las estructuras de decisi´on. Una decisi´on permite que un algoritmo ejecute
un conjunto u otro de instrucciones dependiendo del valor de verdad de
una expresi´on l´ogica / relacional. Si dentro del conjunto de instrucciones
a ejecutar no hay otras decisiones se habla entonces de decisiones simples,
pero si las hubiera se denominan decisiones anidadas.
3.1. Decisiones compuestas
La forma general de esta estructura es presentada en el segmento del
Algoritmo 3.1 y su diagrama de flujo fue presentado en la p´agina 55.
Algoritmo 3.1: Forma general del Si
1 Si( condici´on ) Entonces
2 Instrucci´onV-1
3 Instrucci´onV-2
4 ...
5 Instrucci´onV-n
6 SiNo
7 Instrucci´onF-1
8 Instrucci´onF-2
9 ...
10 Instrucci´onF-m
11 FinSi
En esta estructura, Instrucci´	on-V representa las instrucciones en la
