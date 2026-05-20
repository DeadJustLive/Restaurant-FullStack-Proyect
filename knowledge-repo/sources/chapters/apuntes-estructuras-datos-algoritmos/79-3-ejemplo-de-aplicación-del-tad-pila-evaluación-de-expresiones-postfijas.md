# 3. Ejemplo de aplicación del TAD pila: evaluación de expresiones postfijas

Una expresión aritmética en notación postfija (o notación polaca inversa) es una secuencia formada por símbolos de
dos tipos diferentes: operadores (para simplificar, consideraremos únicamente los operadores aritméticos binarios +, -, *
y /) y operandos (para simplificar pensaremos en identificadores de una sola letra). Cada operador se escribe detrás de
sus operandos.
Por ejemplo, a la expresión siguiente, escrita en la notación habitual (infija):
a*b/c
le corresponde la siguiente expresión en notación postfija:
ab*c/
Si en la expresión infija aparecen paréntesis, éstos cambian la correspondiente expresión postfija sólo si los paréntesis
alteran el orden de prioridad de los operadores:
a/b+c*d-e*f, traducido a notación postfija es: ab/cd*+ef*-
a/(b+c)*(d-e)*f, se traduce en cambio por: abc+/de-*f*
Tres ventajas importantes de la notación postfija frente a la convencional infija son las siguientes:
• 	En notación postfija nunca son necesarios los paréntesis.
• 	En notación postfija no es necesario definir prioridades entre operadores.
• 	Una expresión postfija puede evaluarse de forma muy sencilla, como veremos enseguida.
En el siguiente apartado de la lección veremos un algoritmo para traducir expresiones de notación infija a notación
postfija. Veamos ahora cómo evaluar una expresión escrita en notación postfija.
Una expresión en notación postfija puede ser evaluada haciendo un recorrido de izquierda a derecha. Cuando se
encuentra un operando, se apila en una pila de operandos. Cuando se encuentra un operador, se desapilan dos operandos

-- 78 of 267 --

71
de la pila, se realiza la correspondiente operación y el resultado se apila en la pila de operandos. Este método de evaluación
es mucho más sencillo que el proceso necesario para evaluar una expresión escrita en notación infija.
A continuación, se presenta una función de evaluación de expresiones en notación postfija:
función evaluar(e:expresión) devuelve real
{Devuelve el valor real de la expresión postfija e.}
importa pilasDeSímbolos {es el módulo genérico de pilas particularizado para
elementos de tipo símbolo, que también se define en este módulo}
variables s,o1,o2,r:símbolo; p:pilaDeSímbolos
principio
crearVacía(p);
s:=siguienteSímbolo(e);
mientrasQue s≠final hacer
si esOperando(s) entonces
apilar(p,s)
sino
o2:=cima(p);
desapilar(p);
o1:=cima(p);
desapilar(p);
r:=operar(o1,o2,s);
apilar(p,r)
fsi;
s:=siguienteSímbolo(e)
fmq;
devuelve cima(p);
desapilar(p)
fin
Se ha supuesto lo siguiente:
• 	Se usa el módulo pilasDeSímbolos, en el cual se ha definido el tipo símbolo, cuyos valores pueden ser
operandos, operadores o el valor especial final; además, existe la función esOperando que devuelve verdad si y
sólo si el símbolo enviado como argumento es un operando; existe también la función operar, que a partir de dos
operandos y un operador devuelve un nuevo operando que es el resultado de realizar la operación.
• 	El TAD genérico pila se supone particularizado para datos de tipo símbolo en el módulo pilasDeSímbolos,
es decir, el parámetro formal elemento de la especificación del TAD pila debe sustituirse por el tipo símbolo.
• 	Se supone predefinido el tipo expresión como una secuencia de símbolos. Además, existe la función
siguienteSímbolo que devuelve el siguiente símbolo de una expresión.