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
 Subproblema 1: Mostrar los números del 1 al 10 (ambos inclusive).
 Subproblema 2: Mostrar la tabla de multiplicar del 8.
 Subproblema 3: Mostrar las primeras diez potencias de 2.
Los subalgoritmos (procedimientos) que dan solución a dichos subproblemas, pueden ser:

-- 160 of 180 --

Libro de Algoritmos de “Abrirllave.com” 161 / 180
procedimiento Numeros_del_1_al_10()
variables
entero numero
inicio
para numero  1 hasta 10 hacer
escribir( numero )
fin_para
fin
procedimiento Tabla_de_multiplicar_del_8()
variables
entero contador, resultado
inicio
para contador  1 hasta 10 hacer
resultado  contador * 8
escribir( "8 * ", contador, " = ", resultado )
fin_para
fin
procedimiento Primeras_diez_pontencias_de_2()
variables
entero contador
inicio
para contador  1 hasta 10 hacer
escribir( 2 ** contador )
fin_para
fin
Además, al conjunto de instrucciones de salida que se utilizan para mostrar el menú por
pantalla, también se le puede considerar como un subproblema:
 Subproblema 4: Mostrar menú por pantalla.
Para ello, el procedimiento propuesto es:
procedimiento Menu_por_pantalla()
inicio
escribir( ">>> MENÚ DE OPCIONES <<<" )
escribir( "1. Números del 1 al 10." )
escribir( "2. Tabla de multiplicar del 8." )
escribir( "3. Primeras diez potencias de 2." )
escribir( "4. Salir." )
escribir( "Introduzca opción: " )
fin

-- 161 of 180 --

Libro de Algoritmos de “Abrirllave.com” 162 / 180
De manera que, la solución al problema planteado puede venir dada por un módulo principal
(programa principal):
 Menu_de_opciones
Y cuatro submódulos (subprogramas):
 Numeros_del_1_al_10()
 Tabla_de_multiplicar_del_8()
 Primeras_diez_potencias_de_2()
 Menu_por_pantalla()
Por otra parte, para hacer una llamada a un procedimiento, la sintaxis es:
<nombre_del_procedimiento>( [ <lista_de_parámetros_actuales> ] )
En una llamada a un procedimiento se debe escribir el identificador de dicho procedimiento,
seguido de los paréntesis "()", entre los cuales, opcionalmente, se puede indicar una lista de
parámetros actuales. En el apartado “12.2.4.2. Parámetros actuales” vamos a estudiar qué son
y para qué sirven los parámetros actuales.
Por tanto, usando los cuatro subalgoritmos (procedimientos) anteriores, la solución
algorítmica al problema del ejemplo plantado en este apartado (Menú de opciones), puede ser
la siguiente:
algoritmo Menu_de_opciones
variables
caracter opcion
inicio
hacer
Menu_por_pantalla() /* Llamada a subalgoritmo */
/* Filtramos la opción elegida por el usuario. */
hacer
leer( opcion )
mientras ( opcion < '1' o opcion > '4' )
/* La opción solamente puede ser 1, 2, 3 ó 4. */
segun_sea ( opcion )
'1' : Numeros_del_1_al_10()
'2' : Tabla_de_multiplicar_del_8()
'3' : Primeras_diez_potencias_de_2()
fin_segun_sea
mientras ( opcion <> '4' )
fin

-- 162 of 180 --

Libro de Algoritmos de “Abrirllave.com” 163 / 180
Cuando se hace una llamada a un procedimiento, este se ejecuta y, al finalizar, devuelve el
control del flujo al programa (o subprograma) llamante, el cual continuará su ejecución con la
siguiente instrucción a la llamada.
12.2.2. Declaraciones locales y globales
Las declaraciones de variables, constantes y tipos de datos realizadas en un subprograma
(submódulo) se dice que son declaraciones de ámbito local, es decir, dichas variables,
constantes y tipos de datos, solamente pueden utilizarse en dicho subprograma.
Por el contrario, las declaraciones realizadas en el programa (módulo) principal, se dice que
son declaraciones de ámbito global, es decir, las variables, constantes y tipos de datos
declarados en el programa principal, pueden utilizarse en el programa principal y en todos los
subprogramas.
En los procedimientos propuestos para resolver el problema del ejemplo del apartado anterior
“12.2.1. Procedimientos”, se han declarado las siguientes variables locales:
 numero, en el procedimiento Numeros_del_1_al_10.
 contador y resultado, en el procedimiento Tabla_de_multiplicar_
del_8.
 contador, en el procedimiento Primeras_diez_potencias_de_2.
En el algoritmo Menu_por_pantalla no se ha realizado ninguna declaración de ámbito
local.
Al hacer una llamada a un subprograma, es, en ese momento, y no antes, cuando se reserva
espacio de memoria para las variables locales de ese subprograma llamado. Dicho espacio de
memoria se libera cuando el subprograma finaliza su ejecución, devolviendo el control del flujo
al programa (o subprograma) que lo llamó.
Por tanto, es importante entender que, la variable contador declarada en el procedimiento
Tabla_de_multiplicar_del_8, no representa al mismo espacio de memoria que la
variable contador declarada en el procedimiento Primeras_diez_potencias_de_2.
Igualmente, si se hubiese declarado otra variable contador en el programa principal,
también esta representaría a un espacio de memoria diferente.
En el caso de que se declaren dos variables con el mismo identificador, una local (en un
subprograma) y otra global (en el programa principal), al hacer referencia a dicho identificador,
pueden ocurrir dos cosas:
 Si se hace en el programa principal, es obvio que se está referenciando a la variable
global.
 Pero, si se hace en el subprograma, entonces se está referenciando a la variable local.
Asimismo, a las declaraciones de constantes y tipos de datos, se les aplica el mismo criterio.

-- 163 of 180 --

Libro de Algoritmos de “Abrirllave.com” 164 / 180
EJEMPLO Partiendo de los dos procedimientos siguientes:
procedimiento Ejemplo_A()
variables
entero n /* Variable local */
inicio
n  77
escribir( n )
fin
procedimiento Ejemplo_B()
inicio
escribir( n )
fin
Podemos escribir el algoritmo:
algoritmo Ejemplo_C
variables
entero n /* Variable global */
inicio
n  30
Ejemplo_A()
Ejemplo_B()
escribir( n )
fin
La salida por pantalla es:
Obsérvese que, para que el procedimiento Ejemplo_B se ejecute correctamente, es
necesario que la variable n esté declarada globalmente, y que además, esta contenga un dato
(valor entero) en el momento de la llamada al procedimiento Ejemplo_B. En cualquier caso,
para que no se dé esta dependencia, es recomendable declarar dicha variable localmente,
como se ha hecho en el procedimiento Ejemplo_A.
Del mismo modo, se pueden declarar dos variables con el mismo identificador, una local (en
un subprograma) y otra también local (en otro subprograma llamado por el anterior). En cuyo
caso, al hacer referencia a dicho identificador, se estará referenciando a la variable más local.

-- 164 of 180 --

Libro de Algoritmos de “Abrirllave.com” 165 / 180
Las declaraciones deben ser lo más locales posibles. Así que, cuantas menos declaraciones
globales existan, mejor. Además, con el fin de evitar confusiones, y prevenir errores no
deseados, es recomendable no usar el mismo identificador para una variable local, que para
otra global.
12.2.3. Declaraciones de subprogramas
En pseudocódigo, los subprogramas también se pueden declarar locales o globales. Por
consiguiente, tanto a la sección de declaraciones de un algoritmo (programa principal), como a
la de un subalgoritmo (subprograma), se debe añadir la sintaxis:
[ subalgoritmos
<declaraciones_de_subalgoritmos> ]
Para declarar un procedimiento –sin parámetros– se utiliza el identificador de dicho
procedimiento, seguido de los paréntesis "()". La sintaxis es:
<nombre_del_procedimiento>()
Por tanto, si al algoritmo del ejemplo del apartado “12.2.1. Procedimientos” le añadimos las
declaraciones de los procedimientos que en él se utilizan, obtendremos el algoritmo:
algoritmo Menu_de_opciones
subalgoritmos
/* Procedimientos globales */
Numeros_del_1_al_10()
Tabla_de_multiplicar_del_8()
Primeras_diez_potencias_de_2()
Menu_por_pantalla()
variables
caracter opcion /* Variable global */
inicio
hacer
Menu_por_pantalla() /* Llamada a subalgoritmo */
hacer
leer( opcion )
mientras ( opcion < '1' o opcion > '4' )
segun_sea ( opcion )
'1' : Numeros_del_1_al_10()
'2' : Tabla_de_multiplicar_del_8()
'3' : Primeras_diez_potencias_de_2()
fin_segun_sea
mientras ( opcion <> '4' )
fin

-- 165 of 180 --

Libro de Algoritmos de “Abrirllave.com” 166 / 180
Haciendo lo mismo con el algoritmo del ejemplo del apartado “12.2.2. Declaraciones locales y
globales”, obtendremos el algoritmo:
algoritmo Ejemplo_C
subalgoritmos
/* Procedimientos globales */
Ejemplo_A()
Ejemplo_B()
variables
entero n /* Variable global */
inicio
n  30
Ejemplo_A()
Ejemplo_B()
escribir( n )
fin
EJEMPLO Estúdiese ahora el procedimiento siguiente:
procedimiento Ejemplo_A()
subalgoritmos
Ejemplo_B() /* Procedimiento local */
variables
entero n /* Variable local */
inicio
Ejemplo_B() /* Llamada a subalgoritmo */
n  26
escribir( n )
fin
En el ejemplo, se ha declarado el procedimiento Ejemplo_B localmente. Por tanto, este
únicamente puede ser llamado desde el procedimiento Ejemplo_A. Esto es posible
especificarlo en muchos lenguajes estructurados, pero no en otros. Por ejemplo, en C esta
característica no se cumple, ya que, no se puede definir un subprograma dentro de otro. Por
tanto, cuando se escribe un programa en C, todos los subprogramas se declaran globalmente.
Y dado el procedimiento:
procedimiento Ejemplo_B()
variables
entero n /* Variable local */
inicio
n  90
escribir( n )
fin

-- 166 of 180 --

Libro de Algoritmos de “Abrirllave.com” 167 / 180
Y el algoritmo:
algoritmo Ejemplo_D
subalgoritmos
Ejemplo_A() /* Procedimiento global */
variables
entero n /* Variable global */
inicio
n  18
Ejemplo_A() /* Llamada a subalgoritmo */
escribir( n )
fin
Su salida por pantalla es:
Al igual que con las variables, constantes y tipos de datos, también es conveniente declarar los
subalgoritmos lo más localmente posible. Así como, no usar el mismo identificador para un
subalgoritmo local, que para otro global.
Por otro lado, como se ha podido ver, el espacio de memoria reservado para las variables
globales –en este caso una variable, n– no se libera hasta que el programa principal finaliza su
ejecución, a diferencia de las variables locales.
12.2.4. Parámetros
Los parámetros –también llamados argumentos– se emplean, opcionalmente, para transferir
datos de un programa (o subprograma) llamante, a otro llamado, y viceversa (del llamado al
llamante), o dicho de otro modo, en una llamada a un subprograma, el llamante y el llamado
se pueden enviar datos entre sí, mediante parámetros. De manera que, en una llamada a un
subprograma, los parámetros se usan para:
 Proporcionar uno o más datos de entrada al llamado.
 Devolver uno o más datos de salida al llamante.
Por tanto, los parámetros se pueden clasificar en:
 De entrada.
 De salida.
 Y también, de entrada y salida.

-- 167 of 180 --

Libro de Algoritmos de “Abrirllave.com” 168 / 180
Como su propio nombre indica, un parámetro de entrada y salida se utiliza para proporcionar
un dato de entrada al llamado y, también, para devolver un dato de salida al llamante.
Para entender cómo se puede hacer uso de los parámetros, estúdiese el siguiente problema.
EJEMPLO Multiplicación de dos números enteros.
Se quiere diseñar el algoritmo de un programa que:
1º) Pida por teclado dos números (datos enteros).
2º) Calcule la multiplicación de los dos números introducidos por el usuario.
3º) Muestre por pantalla el resultado (dato entero).
En pantalla:
Sin usar subalgoritmos, la solución al problema puede ser la siguiente:
algoritmo Multiplicacion_de_dos_numeros_enteros
variables
entero a, b, r
inicio
escribir( "Introduzca el primer número: " )
leer( a )
escribir( "Introduzca el segundo número: " )
leer( b )
r  a * b
escribir( "La multiplicación es: ", r )
fin
En este caso, vamos a considerar como un subproblema la realización de la multiplicación.
 Subproblema: Realizar la multiplicación de dos números enteros.
Recuérdese que, en pseudocódigo, la sintaxis que se utiliza para escribir la cabecera de un
procedimiento es:
procedimiento <nombre_del_procedimiento>(
[ <lista_de_parámetros_formales> ] )

-- 168 of 180 --

Libro de Algoritmos de “Abrirllave.com” 169 / 180
12.2.4.1. Parámetros formales
Los parámetros formales –también llamados ficticios– son variables locales que se declaran en
la cabecera de un procedimiento, en las cuales se almacenarán:
 Los datos de entrada que se le proporcionen al procedimiento en la llamada.
 Así como, los datos de salida que se devolverán al subprograma llamante.
 Y también, los datos de entrada y salida.
En un subprograma, las variables locales declaradas en la sección de declaraciones, se
diferencian de las variables locales declaradas en la cabecera (parámetros), en que, estas
últimas, se utilizan para transferir datos entre el llamante y el llamado, y las otras no.
Para escribir la <lista_de_parámetros_formales> de un subalgoritmo, la sintaxis es:
[ E <nombre_del_tipo_de_dato_1> : <lista_de_variables_1> ;
E <nombre_del_tipo_de_dato_2> : <lista_de_variables_2> ;
...
E <nombre_del_tipo_de_dato_n> : <lista_de_variables_n> ; ]
[ S <nombre_del_tipo_de_dato_1> : <lista_de_variables_n+1> ;
S <nombre_del_tipo_de_dato_2> : <lista_de_variables_n+2> ;
...
S <nombre_del_tipo_de_dato_n> : <lista_de_variables_m> ; ]
[ E/S <nombre_del_tipo_de_dato_1> : <lista_de_variables_m+1> ;
E/S <nombre_del_tipo_de_dato_2> : <lista_de_variables_m+2> ;
...
E/S <nombre_del_tipo_de_dato_n> : <lista_de_variables_p> ]
En donde, E, S y E/S, indican que los parámetros siguientes son de entrada, de salida y de
entrada/salida, respectivamente.
El carácter punto y coma (;) únicamente se debe poner, si después de una lista de variables,
hay otra.
Las variables de una lista de variables deben ir separadas por el carácter coma (,).
De modo que, suponiendo que al subalgoritmo (procedimiento) que da solución al
subproblema planteado en el apartado anterior –realizar la multiplicación de dos números
enteros– se le pasen dos datos de entrada (los dos números introducidos por el usuario) en la
llamada, y devuelva un dato de salida (el resultado de la multiplicación), el procedimiento que
da solución a dicho subproblema, puede ser:
procedimiento Multiplicar(
E entero n1, n2;
S entero resultado )
inicio
resultado  n1 * n2
fin

-- 169 of 180 --

Libro de Algoritmos de “Abrirllave.com” 170 / 180
Los parámetros n1 y n2, son variables de entrada (E). Por tanto, cuando se realice una
llamada al procedimiento Multiplicar, se tienen que proporcionar los datos que se
almacenarán –recogerán– en dichos parámetros.
Por otra parte, cuando el procedimiento Multiplicar finalice, el parámetro resultado
debe contener un dato que se devolverá al llamante. Dicho dato, se almacenará en una
variable local declarada en el llamante, o en una global.
12.2.4.2. Parámetros actuales
Recuérdese que, en pseudocódigo, la sintaxis que se utiliza para hacer una llamada a un
procedimiento es:
<nombre_del_procedimiento>( [ <lista_de_parámetros_actuales> ] )
Los parámetros de una <lista_de_parámetros_actuales> deben ir separados por el
carácter coma (,).
En una llamada a un subprograma, el número de parámetros actuales –también llamados
reales– debe coincidir con el número de parámetros formales declarados en el subprograma,
existiendo una correspondencia de tipos de datos entre ellos, es decir, el primer parámetro
formal debe ser del mismo tipo de dato que el primer parámetro actual, y así con todos.
Los parámetros actuales que se correspondan con parámetros formales de entrada, pueden
ser expresiones. De esta forma, el resultado de evaluar un parámetro actual (expresión), se
proporciona como dato de entrada al llamado. Sin embargo, los parámetros actuales que se
correspondan con parámetros formales de salida o de entrada y salida, únicamente pueden
ser variables, ya que, un dato de salida devuelto por el llamante, se almacena en un parámetro
actual, el cual, obviamente, solamente puede ser una variable.
Por otro lado, para declarar un procedimiento –con parámetros– se utiliza el identificador de
dicho procedimiento, seguido de los paréntesis "()", entre los cuales, se deben escribir los
tipos de datos de los parámetros formales que se hayan declarado en el procedimiento. La
sintaxis es:
<nombre_del_procedimiento>( <lista_de_tipos_de_datos> )
Para escribir la <lista_de_tipos_de_datos> en la declaración de un subalgoritmo, la
sintaxis es:
[ E <lista_de_tipos_de_datos_de_entrada> ; ]
[ S <lista_de_tipos_de_datos_de_salida> ; ]
[ E/S <lista_de_tipos_de_datos_de_entrada_y_salida> ]
El carácter punto y coma (;) únicamente se debe poner, si después de una lista de tipos de
datos, hay otra.

-- 170 of 180 --

Libro de Algoritmos de “Abrirllave.com” 171 / 180
Los tipos de datos de una lista de tipos de datos deben ir separados por el carácter coma (,).
Así pues, usando el procedimiento Multiplicar, la solución algorítmica al problema del
ejemplo (Multiplicación de dos números enteros) del apartado “12.2.4. Parámetros”, puede
ser la siguiente:
algoritmo Multiplicacion_de_dos_numeros_enteros
subalgoritmos
Multiplicar( E entero, entero;
S entero)
variables
entero a, b, r
inicio
escribir( "Introduzca el primer número: " )
leer( a )
escribir( "Introduzca el segundo número: " )
leer( b )
Multiplicar( a, b, r )
escribir( "La multiplicación es: ", r )
fin
Suponiendo, por ejemplo, que el usuario desee calcular la multiplicación de los números 5 y 8,
en pantalla se mostrará:
Por tanto, cuando en el algoritmo se hace la llamada al procedimiento Multiplicar:
Multiplicar( a, b, r )
En los parámetros n1 y n2 del procedimiento, se almacenan –copian– los datos de entrada (5
y 8) proporcionados en la llamada.
5 y 8 son los resultados de evaluar las expresiones (variables en este caso) a y b,
respectivamente.

-- 171 of 180 --

Libro de Algoritmos de “Abrirllave.com” 172 / 180
12.2.4.3. Paso por valor
Usando como ejemplo el algoritmo Multiplicacion_de_dos_numeros_enteros del
apartado anterior “12.2.4.2. Parámetros Actuales”:
algoritmo Multiplicacion_de_dos_numeros_enteros
subalgoritmos
Multiplicar( E entero, entero;
S entero)
variables
entero a, b, r
inicio
escribir( "Introduzca el primer número: " )
leer( a )
escribir( "Introduzca el segundo número: " )
leer( b )
Multiplicar( a, b, r )
escribir( "La multiplicación es: ", r )
fin
Y siendo el código del procedimiento Multiplicar el siguiente:
procedimiento Multiplicar(
E entero n1, n2;
S entero resultado )
inicio
resultado  n1 * n2
fin
Cuando el valor (dato) de un parámetro actual (a por ejemplo), se transfiere –copia– a un
parámetro formal de entrada (n1, en este caso), se dice que se está realizando un paso por
valor.
El paso por valor implica la asignación:
<parámetro_formal_de_entrada>  <parámetro_actual>
De modo que, en el algoritmo Multiplicacion_de_dos_numeros_enteros, se
producen los pasos por valor siguientes:
n1  a
n2  b

-- 172 of 180 --

Libro de Algoritmos de “Abrirllave.com” 173 / 180
12.2.4.4. Paso por referencia
Usando como ejemplo el algoritmo Multiplicacion_de_dos_numeros_enteros del
apartado “12.2.4.2. Parámetros Actuales”:
algoritmo Multiplicacion_de_dos_numeros_enteros
subalgoritmos
Multiplicar( E entero, entero;
S entero)
variables
entero a, b, r
inicio
escribir( "Introduzca el primer número: " )
leer( a )
escribir( "Introduzca el segundo número: " )
leer( b )
Multiplicar( a, b, r )
escribir( "La multiplicación es: ", r )
fin
Siendo el código del procedimiento Multiplicar el siguiente:
procedimiento Multiplicar(
E entero n1, n2;
S entero resultado )
inicio
resultado  n1 * n2
fin
Y suponiendo que el usuario calcule la multiplicación de los números 5 y 8, mostrándose en
pantalla:
En el parámetro r (variable de salida) se almacenará el valor (dato) 40, como consecuencia de
la instrucción de asignación:
resultado  n1 * n2

-- 173 of 180 --

Libro de Algoritmos de “Abrirllave.com” 174 / 180
Puede pensarse que, cuando finalice el procedimiento Multiplicar, se efectuará la
asignación:
r  resultado
Pero, en realidad, resultado no es una variable que almacene un dato de tipo entero, ya
que, un parámetro formal de salida, como es el caso de resultado, representa al espacio de
memoria en el cual se almacena la dirección de memoria del parámetro actual
correspondiente, r en este caso.
Por tanto, cuando al parámetro formal de salida (resultado) se le asigna un valor dentro del
procedimiento Multiplicar. Lo que se está haciendo realmente, es asignar dicho valor al
parámetro actual correspondiente (r), es decir, resultado hace referencia a r y, por tanto,
se dice entonces que se está realizando un paso por referencia.
Es importante comprender que, cuando se realiza un paso por valor, si se modifica el valor del
parámetro formal en el subprograma llamado, haciendo por ejemplo:
n1  3
Dicha modificación no afectaría al parámetro actual (a en este caso), que seguiría conteniendo
el valor 5. Pero, si el paso fuese por referencia, entonces sí que afectaría.
12.2.5. Funciones
En pseudocódigo, la sintaxis que se utiliza para escribir una función es muy similar a la que se
usa para escribir un procedimiento:
/* Cabecera */
<tipo_de_dato> funcion <nombre_de_la_función>(
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
volver <expresión>
fin

-- 174 of 180 --

Libro de Algoritmos de “Abrirllave.com” 175 / 180
Existen dos diferencias importantes entre la sintaxis de un procedimiento y de una función: