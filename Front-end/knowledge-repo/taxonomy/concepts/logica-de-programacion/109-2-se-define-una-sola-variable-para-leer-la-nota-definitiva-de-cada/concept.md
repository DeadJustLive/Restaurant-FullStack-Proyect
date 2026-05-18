# 2. Se define una sola variable para leer la nota definitiva de cada

## Fuente
logica-de-programacion (Cap. 109)

## Contenido
# 2. Se define una sola variable para leer la nota definitiva de cada

materia y mediante un ciclo que itere 6 veces se hace la lectura
y esta se va acumulando; una vez finalizado el ciclo se calcula
el promedio.
Para la soluci´on a implementar, se optar´a por la segunda opci´on. El
ciclo al que se hace menci´on en esta soluci´on, deber´a estar dentro de
otro ciclo intermedio, que manejar´a la informaci´on correspondiente
a los estudiantes y este a su vez estar´a anidado dentro de un ciclo
externo que trabajar´a con la informaci´on de los grupos.
En la Figura 4.42 se puede apreciar de forma global la estructura de
la soluci´on, la cual se interpreta de la siguiente manera:
La zona denominada Inicializaci´on general, ser´a utilizada para
inicializar las variables que vayan a intervenir en la condici´on del ciclo
externo, en el caso de ser necesarias para su ejecuci´on. As´ı mismo, se
inicializar´an los contadores de los datos generales que solicitan, por
ejemplo, el total de estudiantes, estudiantes en situaci´on condicional,
los que aprobaron o reprobaron el promedio y los excluidos.

-- 305 of 450 --

304 Estructuras de repetici ´on
Inicializacion general
1A
2A
3
1B
2B
1C
Resultados generales
Figura 4.42: Forma general para el Ejemplo 4.25

-- 306 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 305
Dentro del ciclo externo se identifican las siguientes zonas: 1A y 1B
y 1C.
En la zona 1A, se deben inicializar los contadores que se
incrementar´an dentro del ciclo intermedio, ubicado en la Zona 1B.
En estos contadores se almacenar´a la cantidad de estudiantes que
aprobaron o reprobaron en cada uno de los grupos. Adicionalmente
se especificar´a el grupo al cu´al se le van a procesar los datos de sus
respectivos estudiantes.
La zona 1B, conformada por las zonas 2A, 2B y 3, estar´a ocupada
por el ciclo intermedio que procesar´a los datos de los estudiantes;
dentro de ´el, estar´a el ciclo m´as interno (zona 3) que se encargar´a de
la lectura de las 6 notas definitivas.
Para terminar con el ciclo externo, se identifica la zona 1C, en ella,
se da la informaci´on que corresponde a los grupos, se incrementan
algunos contadores generales y se incrementa la identificaci´on del
grupo (Grupo A, Grupo B. . . ).
Pasando al ciclo intermedio se encuentran las zonas 2A, 2B y 3. En
este ciclo se van a procesar los datos pertenecientes a cada estudiante.
En la zona 2A, se solicitar´an los datos que se tienen del estudiante:
el c´odigo, el nombre y las notas. Recuerde que las notas ser´an le´ıdas
dentro de un ciclo, que estar´a anidado dentro del ciclo intermedio.
En la zona 2A tambi´en se deben inicializar el contador de materias
reprobadas y el acumulador de la sumatoria de las notas definitivas,
que servir´a para calcular el promedio del periodo.
Entre la zona 2A y 2B estar´a el ciclo encargado de procesar las notas
definitivas de cada materia (zona 3).
La zona 2B se destina a los siguientes objetivos:
• Calcular del promedio del periodo.
• Determinar el mayor y menor promedio.
• Informar la situaci´on acad´emica de cada estudiante.
• Contar el n´umero de estudiantes excluidos por bajo rendimiento,
los que quedan en situaci´on condicional y los que aprobaron el
periodo.
El tercer ciclo que compone esta soluci´on algor´ıtmica, se encuentra
en la zona 3. Este ciclo debe iterar 6 veces, en cada ejecuci´on debe
cumplir con 3 funciones: leer la nota definitiva de cada 1 de las 6
materias que curs´o el estudiante, incrementar la sumatoria de notas

-- 307 of 450 --

306 Estructuras de repetici ´on
definitivas y determinar si el estudiante perdi´o alguna materia, es
caso de ser as´ı, debe incrementar un contador que servir´a luego, en
la zona 2B, para decidir si el estudiante es excluido por perder m´as
del 50 % de las materias.
Por ´ultimo, se encuentra la zona denominada Resultados generales,
destinada a los siguientes c´alculos e informes globales:
• C´alculo de los porcentajes generales.
• Se informar´an los datos del mayor y menor promedio,
cantidad de estudiantes que aprobaron y reprobaron el
promedio; porcentaje de estudiantes que aprobaron y el de
los que quedaron excluidos por bajo rendimiento y finalmente
informar´a la cantidad de estudiantes que quedaron en situaci´on
condicional.
De acuerdo a las caracter´ısticas de este problema, se puede
determinar que el ciclo externo y el intermedio pueden ser estructuras
Mientras-FinMientras o Haga-MientrasQue, tenga presente
que ambas operan de manera similar, la diferencia radica en que la
primera se condiciona al inicio y la segunda al final. Para la soluci´on
que se va a plantear, se elegir´a el Mientras-FinMientras para el
ciclo externo y el Haga-MientrasQue para el intermedio; ambos
ciclos se controlar´an con una pregunta de continuar o no con la
ejecuci´on. El ciclo interno, el que est´a en la zona 3, se dise˜nar´a con
una estructura Para-FinPara ya que es la m´as indicada puesto
que se conoce que debe iterar un n´umero definido de veces (6).
Variables requeridas:

