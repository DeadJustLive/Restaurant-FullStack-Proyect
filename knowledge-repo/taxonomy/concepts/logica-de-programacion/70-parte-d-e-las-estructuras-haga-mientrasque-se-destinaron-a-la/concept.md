# Parte d: e las estructuras Haga-MientrasQue se destinaron a la

## Fuente
logica-de-programacion (Cap. 70)

## Contenido
# Parte d: e las estructuras Haga-MientrasQue se destinaron a la

validaci´on de la entrada de los datos. Los de tipo num´erico est´an validados
para que acepten valores entre -200000 y 200000, este tope se eligi´o m´as
por mostrar el ejemplo de c´omo validar un dato num´erico que, por alg´un
requerimiento en el enunciado del problema; el dise˜nador del algoritmo
puede tomar los valores que estime conveniente. El ciclo dedicado a la
validaci´on de la lectura del operador matem´atico condiciona a que solo
pueda ingresar uno de los siguientes caracteres: ’+’,’-’ ,’*’ y ’/’ o el signo
’=’.
La variable calculo que almacena el resultado de todas las operaciones
que se realicen, se inicializ´o con el valor de la variable numero, el cual
corresponde al primer n´umero que se obtendr´a para iniciar el proceso de la
calculadora. De igual forma se hace la inicializaci´on de la variable bandera
con un valor Verdadero, el cual cambiar´a en el caso que se trate de hacer
una divisi´on entre 0.
Seguidamente se encuentra el ciclo Haga, donde las primeras
instrucciones que ejecuta son solicitar y leer un operador con el fin de
determinar qu´e proceso se hace con el valor almacenado en la variable
calculo. Si ingresan un signo ’=’ se termina el proceso y se informa el
resultado. Si por el contrario ingresan uno de los operadores b´asicos, se
procede a solicitar el segundo n´umero; si el operador corresponde a uno de
los siguientes ’+’, ’-’ o ’*’ se realiza la respectiva operaci´on, en el caso que
el operador sea ’/’ se toma una decisi´on.

-- 263 of 450 --

262 Estructuras de repetici ´on
42 Caso ’/’: Si( numero == 0 ) Entonces
43 imprimir( "Error. Divisi´on entre cero" )
44 bandera = Falso // Cambio de estado
45 SiNo
46 calculo = calculo / numero
47 FinSi
48 FinCaso
Esta decisi´on es parte de una estructura Segun-FinSegun y
corresponde al caso ’/’. Cuando se ingresa el operador de divisi´on se verifica
el valor del n´umero con el prop´osito de informar la situaci´on de divisi´on
entre 0.
Observe que cuando el n´umero es 0, se imprime un mensaje informando
la situaci´on (l´ınea 43). A bandera se le cambia el estado de Verdadero
a Falso, con el fin de omitir la instrucci´on que imprime el resultado (l´ınea
53). Finalmente a la variable operador se le asigna el signo ’=’; de esta
manera cuando se eval´ue la condici´on MientrasQue (operador !=
’=’) el resultado ser´a Falso y se dar´a por terminada la ejecuci´on del
ciclo y en consecuencia la del algoritmo.
Contrario a todo lo expuesto en el p´arrafo anterior, si el n´umero es
diferente de 0, se realiza la divisi´on, se informa el contenido de la variable
calculo (l´ınea 53) y se testea la condici´on del MientrasQue; al obtener
un resultado Verdadero se repite el ciclo Haga-MientrasQue.
La variable operador, tiene la particularidad, que adem´as de
determinar qu´e tipo de operaci´on se realiza con los n´umeros
ingresados, est´a haciendo el papel del centinela que controla el ciclo
Haga-MientrasQue.
.:Ejemplo 4.15. En matem´aticas un n´umero es perfecto si es igual a la
suma de sus divisores propios positivos. Un ejemplo de n´umero perfecto es
el 28 dado que: 1 + 2 + 4 + 7 + 14 = 28.
Construya un algoritmo que acepte como dato de entrada un n´umero
entero positivo e informe se es o no un n´umero perfecto. El algoritmo debe
ejecutarse hasta que el usuario determine lo contrario.
An´alisis del problema:
Resultados esperados: un mensaje que informe si el n´umero
ingresado al algoritmo es o no perfecto.
Datos disponibles: un n´umero entero positivo.

-- 264 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 263
Proceso: teniendo en cuenta que el enunciado condiciona a que el
n´umero sea positivo, la lectura del dato debe hacerse de tal forma
que solo acepte valores mayores o iguales a 1.
Una vez se posea el n´umero, debe hacerse un proceso repetitivo que
determine si cada uno de los n´umeros menores a ´el es su divisor.
Recuerde que se puede determinar si un n´umero es divisor de otro, si
al dividir el mayor entre el menor se obtiene una divisi´on exacta, es
decir cuando el residuo es 0. En el caso de los algoritmos, un residuo
o resto de la divisi´on se logra usando el operador m´odulo: ’ %’. En
tal sentido, la siguiente decisi´on determina si un n´umero es divisor
de otro:
¿numero1 % numero2 == 0?
numero2 es divisor de numero1
s´ı
numero2 no es divisor de numero1
no
Figura 4.29: ´	Arbol de decisi´on del Ejemplo 4.15
Para el problema, objeto de este an´alisis, si la decisi´on es verdadera se
proceder´a a incrementar un acumulador donde se sumar´an todos los
n´umeros menores que sean divisores del n´umero ingresado. Una vez
terminada la ejecuci´on del proceso c´ıclico, se decidir´a si la sumatoria
es igual al n´umero, en cuyo caso se informar´a que si es un n´umero
perfecto, o que no lo es en caso contrario. De acuerdo a la definici´on
de n´umero perfecto, el 1 no lo es, ya que no tiene divisores propios
(menores a ´el).
Todo este proceso debe estar anidado dentro de otro ciclo,
