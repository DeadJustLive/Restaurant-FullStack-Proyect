# 2. Estructuras de datos recursivas: representación mediante punteros y datos

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 231)

## Contenido
# 2. Estructuras de datos recursivas: representación mediante punteros y datos

dinámicos
En un primer curso de programación se suelen estudiar sólo datos estáticos: datos simples (estándar, como los
booleanos, carácter, enteros o reales; enumerados o subrangos) y estructurados (vectores o registros). El correspondiente
procesador (compilador o intérprete) determina para ellos una representación fija (estructura y tamaño).
Veremos a continuación cómo pueden utilizarse los datos puntero para definir estructuras dinámicas, que puedan
variar durante la ejecución del algoritmo.
Al igual que se pueden definir algoritmos recursivos cabría pensar en la definición de estructuras de datos recursivas
para representar datos definido de forma recursiva como, por ejemplo, los siguientes:
Ejemplo 1: Una cadena de caracteres no vacía se compone de un carácter seguido del resto, otra cadena de caracteres.
tipo cadena = registro
vacía:booleano;
primero:carácter;
resto:cadena*
freg
*¡No lo permitimos!
Ejemplo 2: Una expresión aritmética es un operador (+, -, * ó /) infijo y dos operandos; un operando es o bien un
número real o una nueva expresión aritmética.
tipos operador = (suma,resta,producto,división);
expresión = registro
elOperador:operador;
operando1,operando2:operando
freg
operando = registro
esNúmero:booleano;
valor:real;
subexpresión:expresión*
freg
*¡No lo permitimos!
Las definiciones recursivas anteriores no son directamente codificables con los lenguajes de programación habituales.
La razón es que a partir de tales definiciones un procesador no es capaz de averiguar el espacio de memoria necesario (ni
su estructuración) que corresponde a una variable estática del tipo correspondiente.
La solución es utilizar datos puntero para encadenar las diferentes partes de la estructura de datos, de forma que la
forma y el tamaño de dicha estructura (dinámica) pueda variar durante la ejecución del algoritmo.
Así, los datos cadena pueden representarse de la siguiente forma:
tipos cadena = ↑cad;
cad = registro
primero:carácter;
resto:cadena
freg
'l' 	'a' 	' ' 	'c' 	'a' 	'd' 	'e' 	'n' 	'a'nil
c
Representación de la cadena: 'la cadena'.
Las expresiones aritméticas definidas anteriormente admiten la siguiente representación:
tipos operador = (suma,resta,producto,división);
expresión = registro
elOperador:operador;

-- 71 of 267 --

64
operando1,operando2:operando
freg
operando = registro
esNúmero:booleano;
valor:real;
subexpresión:↑expresión
freg
