# 4. Otro ejemplo de aplicación: traducción de expresiones infijas a postfijas

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 240)

## Contenido
# 4. Otro ejemplo de aplicación: traducción de expresiones infijas a postfijas

Una vez resuelto el problema de evaluar una expresión escrita en notación postfija, podemos plantearnos el de realizar
la traducción de expresiones infijas a postfijas para, así, tener resuelto el problema de evaluar expresiones infijas.
Comparando una expresión infija con su correspondiente postfija, puede verse en primer lugar que los operandos
mantienen el mismo orden en ambas notaciones. Por tanto, únicamente hay que “mover” operadores y quitar paréntesis
(si existen).
Un primer algoritmo de traducción es el siguiente:
• 	Añadir a la expresión un par de paréntesis por cada operador. Esto significa añadir paréntesis redundantes con las
reglas de prioridad. Por ejemplo, de la expresión:
a/b+c*d-e*f
pasar a la expresión:
(((a/b)+(c*d))-(e*f))
• 	Mover todos los operadores de forma que sustituyan a sus correspondientes paréntesis derechos. En el ejemplo
anterior:
(((ab/(cd*+(ef*-
• 	Borrar todos los paréntesis izquierdos. Es decir:

-- 79 of 267 --

72
ab/cd*+ef*-
El problema del algoritmo anterior es que requiere dos recorridos de la expresión para traducirla: el primero para
añadir todos los paréntesis redundantes y el segundo para mover los operadores y eliminar paréntesis.
La solución a ese problema se obtiene de la siguiente forma: puesto que el orden de los operandos es el mismo, cada
vez que es leído un operando, se escribe en el resultado; cada vez que se lee un operador, hay que decidir si debe escribirse
ya en el resultado o almacenarse en un dato auxiliar (veremos que será una pila) hasta el momento de su escritura.
Por ejemplo, para traducir la expresión a+b*c a su correspondiente postfija abc*+, hay que realizar los siguientes
pasos:
siguiente
símbolo 	pila 	resultado 	comentario
vacía 	inicialización de la pila
a 	vacía 	a 	el operando se escribe ya
+ 	+ 	a 	el operador se apila porque no hay otro
b 	+ 	ab 	el operando se escribe ya
* 	+* 	ab 	* tiene más prioridad que +, luego se apila
c 	+* 	abc 	el operando se escribe ya
final 	vacía 	abc*+ 	se vuelca la pila sobre el resultado
Veamos ahora un ejemplo con paréntesis: la expresión a*(b+c)/d.
siguiente
símbolo 	pila 	resultado 	comentario
vacía 	inicialización de la pila
a 	vacía 	a 	el operando se escribe ya
* 	* 	a 	el operador se apila porque no hay otro
( 	*( 	a 	el paréntesis izquierdo se apila siempre
b 	*( 	ab 	el operando se escribe ya
+ 	*(+ 	ab 	a un paréntesis izquierdo sólo lo saca el derecho
c 	*(+ 	abc 	el operando se escribe ya
) 	* 	abc+ 	se desapila hasta el paréntesis izquierdo, escribiendo el + que se ha desapilado
/ 	/ 	abc+* 	/ tiene igual prioridad que *, luego se saca * de la pila y se mete /
d 	/ 	abc+*d 	el operando se escribe ya
final 	vacía 	abc+*d/ 	se vuelca la pila sobre el resultado
En general, el problema se resuelve de la siguiente forma:
• 	a cada operador y a los paréntesis se les asigna una “prioridad en pila” para cuando están dentro de la pila y otra
“prioridad de llegada” para cuando son leídos de la entrada;
• 	cada vez que se lee un operador o un paréntesis izquierdo, si la pila es vacía, se apila, si no, se compara su prioridad
de llegada con la prioridad en pila del símbolo que está en la cima de la pila; debe sacarse el operador de la cima de
la pila cuando su prioridad en pila es mayor o igual que la prioridad de llegada del nuevo operador leído, y repetir
el proceso con el nuevo operador que queda en la cima;
• 	cada vez que se lee un paréntesis derecho, debe desapilarse el operador de la cima, escribirse en el resultado y
desapilarse también el paréntesis izquierdo que queda en la cima de la pila;
• 	las prioridades en pila y de llegada de los operadores +, -, * y /, y del paréntesis izquierdo son:
símbolo 	prioridad en pila 	prioridad de llegada
*, / 	2 	2
+, - 	1 	1
( 	0 	3

-- 80 of 267 --

73
El algoritmo que resuelve el problema de la traducción infija a postfija es el siguiente:
procedimiento traducir(ent in:expresión; sal post:expresión)
{Traduce la expresión infija in a su correspondiente postfija (post).}
importa pilasDeSímbolos
variables p:pilaDeSímbolos; s:símbolo
función prioridadDeLaPila(p:pila) devuelve 0..2
{ Pre: p es una pila de símbolos s ∈ {(,+,-,*,/} }
{ Post: p=pilaVacía ⇒ prioridadDeLaPila(p)=0;
p≠pilaVacía ∧ cima(p)=( ⇒ prioridadDeLaPila(p)=0;
p≠pilaVacía ∧ cima(p)∈{+,-} ⇒ prioridadDeLaPila(p)=1;
p≠pilaVacía ∧ cima(p)∈{*,/} ⇒ prioridadDeLaPila(p)=2 }
función prioridadDeLlegada(s:símbolo) devuelve 1..3
{ Pre: s ∈ {(,+,-,*,/} }
{ Post: s = ( ⇒ prioridadDeLlegada(s)=3;
(s = +) ∨ (s = -) ⇒ prioridadDeLlegada(s)=1;
(s = *) ∨ (s = /) ⇒ prioridadDeLlegada(s)=2 }
principio
crearVacía(p);
iniciaExpresión(post);
s:=siguienteSímbolo(in);
mientrasQue s≠final hacer
si esOperando(s) entonces
añadeSímbolo(post,s)
sino
si esParéntesisDerecho(s) entonces
mientrasQue not esParéntesisIzquierdo(cima(p)) hacer
añadeSímbolo(post,cima(p));
desapilar(p)
fmq;
desapilar(p) {quitar el paréntesis izquierdo}
sino
mientrasQu
