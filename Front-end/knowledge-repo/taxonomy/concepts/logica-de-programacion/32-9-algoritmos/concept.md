# 9. Algoritmos.

## Fuente
logica-de-programacion (Cap. 32)

## Contenido
# 9. Algoritmos.

a) Para los siguientes enunciados realice el an´alisis y el dise˜no
del algoritmo (utilizando la forma de descripci´on narrada) que
permita realizar las acciones que a continuaci´on se listan:
Adquirir un libro a trav´es de una librer´ıa virtual.
Descargar un v´ıdeo de YouTube.
Calcular cu´anto dinero se gastar´a el d´ıa de ma˜nana.
Invitar a un amigo a desayunar en la cafeter´ıa.
Desplazarse desde su casa a un centro comercial.
b) Si el lector es un estudiante universitario, tambi´en realice los
siguientes ejercicios, los cuales le permitir´an familiarizarse con
los procesos de su instituci´on educativa. Tenga en cuenta que,
si no los conoce, deber´a realizar las consultas necesarias:
Solicitar la homologaci´on de un espacio acad´emico.
Realizar un proceso de validaci´on de un espacio acad´emico.
Cancelar materias y semestre.
Realizar un pr´estamo de un libro en la biblioteca.
Realizar una consulta bibliogr´afica en las bases de datos de
la biblioteca.
Solicitar una cita en el Centro M´edico de Bienestar
Institucional.

-- 79 of 450 --



-- 80 of 450 --

Cap´ıtulo 2
Estructura secuencial
La mayor´ıa de los buenos
programadores programan no
porque esperan que les pagen o
que el p´ublico los adore, sino
porque programar es divertido.
Linus Torvalds
Objetivos del cap´ıtulo:
Analizar problemas en los que se puedan
aplicar estructuras algor´ıtmicas secuenciales
para su soluci´on.
Construtir algoritmos en pseudoc´odigo y
diagramas de flujo para resolver problemas con
la estructura algor´ıtmica secuencial.
Realizar pruebas de escritorio para verificar el
funcionamiento de los algoritmos construidos.

-- 81 of 450 --



-- 82 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 81
En este cap´ıtulo se estudiar´an algoritmos sencillos a trav´es de
los cuales se resolver´an problemas, inicialmente de baja complejidad;
Estos algoritmos se escribir´an en pseudoc´odigo y luego tendr´an su
representaci´on a trav´es de diagramas de flujo. Para escribir estos algoritmos
en pseudoc´odigo, es necesario utilizar las palabras reservadas vistas
anteriormente, principalmente las palabras Algoritmo, FinAlgoritmo,
leer e imprimir, as´ı como la utilizaci´on de variables, constantes,
operadores y expresiones ya expuesto en el cap´ıtulo anterior.
De acuerdo con [Joyanes A., 1996], un algoritmo secuencial es aquel en
el que una acci´on sigue a otra acci´on en la secuencia de instrucciones. “La
secuenciaci´on es una estructura que permite controlar la ejecuci´on de un
conjunto de acciones en orden secuencial; esto es, ejecuta la primera acci´on,
luego la que sigue y as´ı sucesivamente hasta la ´ultima” [L´opez, 2009].
Todo algoritmo secuencial consta de tres secciones: La primera de ellas
corresponde a “las entradas” (de los datos disponibles), en la cual se
identifican e ingresan al algoritmo los datos que se conocen y son necesarios
para resolver el problema. La segunda secci´on es la denominada “Procesos”
o c´alculos, donde se implementan las operaciones que encontrar´an los
resultados que se espera obtendr´a el algoritmo. La tercera y ´ultima secci´on
ser´a la de “salidas” (Resultados esperados), en la que se mostrar´an los
resultados que se encontraron en la secci´on anterior y ser´a lo que debe
entregar como respuesta el algoritmo a quien lo utilice.
2.1. Estructura b´asica de un algoritmo secuencial
Con el fin de tener una manera formal para expresar los algoritmos,
tanto en pseudoc´odigo como en diagramas de flujo, se va a utilizar la
notaci´on especificada en el apartado ”Forma general de un algor´ıtmo
en pseudoc´odigo”del cap´ıtulo anterior donde se explicaron los elementos
fundamentales para escribir los algoritmos con pseudoc´odigo.
Recuerde que los algoritmos empiezan con un nombre que los identifica.
Se recomienda que este nombre est´e directamente relacionado con su
funcionalidad del algoritmo, es decir, que el nombre exprese lo que este
hace.
Es recomendable que, el nombre del algoritmo comience por un
sustantivo en singular y con su primera letra en may´uscula. Puede estar
compuesto de varias palabras que ir´an unidas, cada una de ellas iniciando
con letra en may´uscula.

-- 83 of 450 --

82 Estructura secuencial
De la misma forma, se utilizar´a la notaci´on para los diagramas de flujo
estudiada tambi´en en el cap´ıtulo anterior en el apartado ”Diagramas de
flujo.”
A continuaci´on, se exponen algunos ejemplos para ilustrar la estructura
algor´ıtmica secuencial, primero su enunciado, luego un an´alisis del
problema, su soluci´on en pseudoc´odigo y, por ´ultimo, el diagrama de flujo.
Aclaraci´on:
Cuando se ingresan a un algoritmo los
datos necesarios para producir los resultados
esperados, es decir, se ingresan los datos
conocidos en el problema, es probable que se
entren datos err´oneos o de otros tipos de datos
diferentes a los esperados, lo que producir´a un
error en la ejecuci´on del algoritmo. En los algoritmos que se tratan en
este cap´ıtulo, se dar´a por sentado que el usuario siempre ingr
