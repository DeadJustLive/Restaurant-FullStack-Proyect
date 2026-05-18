# Capítulo 12

## Fuente
algoritmos-pseudocodigo-ordinogramas (Cap. 56)

## Contenido
# Capítulo 12

Llamadas a subalgoritmos
Como ya hemos estudiamos en el capítulo 6 “Instrucciones primitivas”, en pseudocódigo, las
instrucciones que se utilizan para diseñar algoritmos se pueden clasificar en:
 Primitivas (asignación, salida y entrada).
 De control (alternativas, repetitivas y de salto).
 Llamadas a subalgoritmos (llamadas a subprogramas).
Las instrucciones primitivas y de control ya han sido estudiadas. Así pues, solamente faltan por
explicar las llamadas a subalgoritmos (subprogramas).
Un subalgoritmo se convertirá en un subprograma cuando se codifique en un lenguaje de
programación específico.
Un subprograma es un programa, el cual, es llamado desde otro programa o subprograma. Por
tanto, un subprograma solamente se ejecutará cuando sea llamado desde otro programa o
subprograma.
12.1. Problemas y subproblemas
Utilizando el método “divide y vencerás”, siempre que se pueda, es conveniente subdividir los
problemas en otros más pequeños (subproblemas) y, en consecuencia, más fáciles de resolver.
EJEMPLO Un problema se puede segmentar en otros más pequeños:
 Subproblema 1
 Subproblema 2
 Subproblema 3
Además, si los subproblemas obtenidos siguen siendo demasiado grandes, de nuevo, puede
ser conveniente que también estos sean fragmentados. Así pues, el subproblema 1 se puede
subdividir en otros subproblemas:

-- 156 of 180 --

Libro de Algoritmos de “Abrirllave.com” 157 / 180
 Subproblema 1.1
 Subproblema 1.2
 Subproblema 1.3
Y así sucesivamente. De forma que, por ejemplo, el subproblema 1.1 se puede fraccionar en
otros todavía más pequeños:
 Subproblema 1.1.1
 Subproblema 1.1.2
 Subproblema 1.1.3
Etcétera.
12.2. Subprogramas
Como puede verse en el apartado de diseño de un programa del tutorial de programación de
Abrirllave, el programa –módulo principal– que da solución a un problema, suele
descomponerse en otros submódulos (subprogramas) más pequeños, que también se pueden
fraccionar, y así sucesivamente.
Los subalgoritmos (subprogramas) se pueden clasificar en:
 Procedimientos.
 Funciones.
En este capítulo vamos a estudiar las diferencias y semejanzas existentes entre un
procedimiento y una función.

-- 157 of 180 --

Libro de Algoritmos de “Abrirllave.com” 158 / 180
12.2.1. Procedimientos
En pseudocódigo, la sintaxis que se utiliza para escribir un procedimiento es muy similar a la
que se usa para escribir un algoritmo.
/* Cabecera */
procedimiento <nombre_del_procedimiento>(
[ <lista_de_parámetros_formales> ] )
/* Declaraciones */
[ constantes
<declaraciones_de_constantes> ]
[ tipos_de_datos
<declaraciones_de_tipos_de_datos> ]
[ variables
<declaraciones_de_variables> ]
/* Cuerpo */
inicio
<bloque_de_instrucciones>
fin
Existen dos diferencias importantes entre la sintaxis de un algoritmo y la de un procedimiento:
 En vez de la palabra reservada algoritmo, se debe escribir la palabra reservada
procedimiento.
 En un procedimiento, después del <nombre_del_procedimiento>, se deben
escribir los paréntesis "()", entre los cuales, opcionalmente, se pueden declarar
parámetros formales.
Más adelante estudiaremos qué son y para qué sirven los parámetros formales. De momento,
para entender cómo se puede hacer uso de los procedimientos –sin parámetros– estúdiese el
siguiente problema.
EJEMPLO Menú de opciones.
Se quiere diseñar el algoritmo de un programa que:
1º) Muestre un menú con 4 opciones:
 Mostrar los números del 1 al 10 (ambos inclusive).
 Mostrar la tabla de multiplicar del 8.
 Mostrar las primeras diez potencias de 2.
 Salir.
2º) Pida por teclado la opción deseada (dato carácter). Deberá ser introducida, mientras que,
no sea mayor o igual que '1' y menor o igual que '4'.

-- 158 of 180 --

Libro de Algoritmos de “Abrirllave.com” 159 / 180
3º) Ejecute la opción del menú seleccionada.
4º) Repita los pasos 1º, 2º y 3º, mientras que, el usuario no seleccione la opción 4 (Salir) del
menú.
En pantalla:
Sin usar subalgoritmos, la solución al problema puede ser la siguiente:

-- 159 of 180 --

Libro de Algoritmos de “Abrirllave.com” 160 / 180
algoritmo Menu_de_opciones
variables
caracter opcion
entero numero, contador, resultado
inicio
hacer
escribir( ">>> MENÚ DE OPCIONES <<<" )
escribir( "1. Números del 1 al 10." )
escribir( "2. Tabla de multiplicar del 8." )
escribir( "3. Primeras diez potencias de 2." )
escribir( "4. Salir." )
escribir( "Introduzca opción: " )
/* Filtramos la opción elegida por el usuario. */
hacer
leer( opcion )
mientras ( opcion < '1' o opcion > '4' )
/* La opción solamente puede ser 1, 2, 3 ó 4. */
segun_sea ( opcion )
'1' : para numero  1 hasta 10 hacer
escribir( numero )
fin_para
'2' : para contador  1 hasta 10 hacer
contador  contador * 8
escribir( "8 * ", contador, " = ",
resultado )
fin_para
'3' : para contador  1 hasta 10 hacer
escribir( 2 ** contador )
fin_para
fin_segun_sea
mientras ( opcion <> '4' )
fin
En este caso, parece obvio que cada una de las opciones del menú puede considerarse como
un subproblema:
 Subproblema 1: Mostrar los números 
