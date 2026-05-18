# 2. Implementación modular

En estos apuntes se va a implementar los TAD con módulos y no con clases (propias de la Programación Orientada a
Objetos), así que presentamos en primer lugar nuestra sintaxis en pseudocódigo para esos módulos y posteriormente una
posible codificación en C++ (otras variantes son posibles en el mismo lenguaje).
2.1. 	Pseudocódigo
Un buen lenguaje de programación con TAD debe facilitar la encapsulación. Para ello, debe separar la interfaz, o parte
pública, que incluya la declaración del TAD, de la implementación, o parte privada, que encapsule los detalles de
representación de los valores del tipo e implementación de las operaciones.
En el caso de tener que utilizar un lenguaje que no garantice la encapsulación, es responsabilidad exclusiva del
programador el cumplir con la encapsulación, cumpliendo las restricciones de acceso a los detalles de implementación que
un buen lenguaje de programación con TAD garantizaría.

-- 33 of 267 --

26
En estos apuntes utilizaremos un pseudocódigo en castellano (ver el Anexo 6) en el que los módulos para implementar
los TAD tendrán la siguiente sintaxis:
módulo <nombre del módulo>
importa <lista de módulos que necesita usar>
exporta
{parte pública: definición de constantes, nombres de tipos, encabezamientos
de procedimientos y funciones}
...
implementación
{parte privada: se incluyen las definiciones de los tipos cuyos nombres aparecen
en la parte pública, otros tipos privados, el código de procedimientos
y funciones...}
...
fin
De esta forma, para implementar un TAD, en primer lugar, hay que definir todo lo que aparecerá en la parte pública
o interfaz del módulo, es decir, lo que el módulo exporta:
• 	los identificadores válidos de constantes (si son necesarias), tipos, y operaciones (procedimientos y/o
funciones);
• 	los perfiles o cabeceras de cada operación (sea procedimiento o función): parámetros de entrada, parámetros
de salida y/o parámetros de entrada y salida; y
• 	la comunicación de las situaciones de error (en estos apuntes utilizaremos para ello más parámetros de salida).
Una vez decidida la parte pública, se pueden realizar independientemente (por parte de distintos programadores incluso)
la implementación del TAD y su utilización en otros módulos o en programas principales.
En segundo lugar, y ya en lo referido a la implementación del módulo, hay que decidir la representación interna del
TAD, es decir, cómo representar los valores del tipo de datos especificado, basándose en: tipos básicos predefinidos,
constructores básicos predefinidos (como vectores y registros), y/u otros TAD definidos previamente.
La representación interna deberá permitir implementar las operaciones definidas para el tipo de forma eficiente, tanto
en relación con su coste en memoria como en tiempo.
Además, la representación interna deberá permanecer oculta, encapsulada. Es decir, el uso del nuevo tipo solo será
posible mediante las operaciones definidas en la interfaz del tipo.
En tercer lugar, también dentro de la parte de implementación del módulo, hay que implementar cada operación de
la interfaz del TAD, de acuerdo a la representación interna definida para los valores del TAD, y las operaciones auxiliares
que resulten de interés o de utilidad (siendo éstas inaccesibles para los programadores usuarios del módulo).
Para la implementación de cada operación, las operaciones 0-arias o constantes se pueden implementar, según
convenga, como constantes predefinidas en algún tipo de dato del lenguaje, como procedimientos o como funciones sin
parámetros. Las demás operaciones se implementan como procedimientos o funciones, según convenga.
Como se ha dicho anteriormente, varias operaciones con el mismo dominio y distinto rango o resultado pueden
combinarse en un solo procedimiento con varios parámetros de salida, correspondiente a los resultados. Esta posibilidad es
especialmente recomendable si esas operaciones van a utilizarse a menudo de forma conjunta y la implementación conjunta
reduce el coste en tiempo de obtener los resultados.
En lo concerniente a las operaciones parciales (es decir, con situaciones de error), cabe la posibilidad de utilizar los
mecanismos de manejo de excepciones del lenguaje de implementación, si los tiene. En estos apuntes, no vamos a entrar
en el uso de esos posibles mecanismos, sino que utilizaremos el método, más rudimentario pero utilizable en cualquier
lenguaje de programación, de añadir parámetros de salida sobre el error ocurrido a los procedimientos.
Como regla general, si una operación sólo tiene que devolver un dato resultado, podrá implementarse tanto con un
procedimiento (incluyendo el correspondiente parámetro de salida, o eventualmente de entrada y salida) como con una
función (que devuelve el resultado asociado a su nombre). Por el contrario, si una operación tiene que devolver 0, 2 o más

-- 34 of 267 --

27
resultados, tendrá que optarse por un procedimiento que incluya tantos parámetros de salida, o eventualmente de entrada y
salida, como resultados.
En cuanto a las implicaciones que el utilizar un parámetro de entrada y otro de salida o un único parámetro de entrada
y salida tiene en el almacenamiento de los datos en memoria, se puede decidir que:
a) 	el resultado sea la actualización de uno de los parámetros del dominio:
• 	almacenamos el parámetro del dominio de entrada y el resultado en un único parámetro de entrada y salida,
• 	sólo posible con procedimientos (puesto que vamos a suponer que las funciones sólo tienen parámetros de
entrada),
• 	se evita ocupar nueva memoria para los datos resultado y el tiempo de copiar toda la parte de los datos que
no resulta modificada (es más eficiente, en tiempo y memoria),
• 	combinando su uso con el de una operación de copiar (o duplicar), siempre se podrán generar nuevas copias
separadas de los datos (valores previo y posterior a la modificación por la operación).
b) 	el resultado sea una copia distinta en memoria del parámetro del dominio:
• 	el parámetro del dominio será de entrada y el resultado será de salida (o el valor devuelto por una función),
• 	se ocupa memoria adicional, independiente, para dato y resultado,
• 	combinando su uso con el de una operación copiar (o duplicar), siempre se podrá hacer que el nuevo valor
sustituya al original (en memoria).
Veamos como ejemplo la implementación del TAD fecha especificado en una lección anterior.
módulo fechas
exporta
tipo fecha
{Los valores del TAD fecha representan fechas válidas según las reglas
del calendario gregoriano.}
procedimiento crear(ent d,m,a:entero; sal f:fecha; sal error:booleano)
{Dados los tres valores enteros d,m,a, si forman una fecha válida según el calendario
gregoriano, se devuelve en f la fecha compuesta con los tres valores dados usados
como día, mes y año respectivamente, y error devuelve falso.
Si d,m,a no forman una fecha válida, error devuelve verdad.}
función día(f:fecha) devuelve entero
{Dada una fecha f, se obtiene el entero que corresponde al día en la fecha f.}
función mes(f:fecha) devuelve entero
{Dada una fecha f, se obtiene el entero que corresponde al mes en la fecha f.}
función año(f:fecha) devuelve entero
{Dada una fecha f, se obtiene el entero que corresponde al año en la fecha f.}
función iguales(f1,f2:fecha) devuelve booleano
{Dadas dos fechas f1 y f2, se obtiene un booleano con valor verdad si y sólo si la
fecha f1 es igual que la fecha f2, es decir, corresponden al mismo día, mes y
año.}
función anterior(f1,f2:fecha) devuelve booleano
{Dadas dos fechas f1 y f2, se obtiene un booleano con valor verdad si y sólo si la
fecha f1 es cronológicamente anterior a la fecha f2.}
función posterior(f1,f2:fecha) devuelve booleano
{Dadas dos fechas f1 y f2, se obtiene un booleano con valor verdad si y sólo si la
fecha f1 es cronológicamente posterior a la fecha f2.}

-- 35 of 267 --

28
implementación
tipo fecha = registro
elDía,elMes,elAño:entero
freg
procedimiento crear(ent d,m,a:entero; sal f:fecha; sal error:booleano)
principio
si d<1 or d>31 or m<1 or m>12 or a<1583 or
(d=31 and (m=2 or m=4 or m=6 or m=9 or m=11)) or (m=2 and d=30) entonces
error:=verdad
sino
si m=2 and d=29 and
((a mod 4/=0) or (a mod 4=0 and a mod 100=0 and a mod 400/=0)) entonces
error:=verdad
sino
f.elDía:=d;
f.elMes:=m;
f.elAño:=a;
error:=falso
fsi
fsi
fin
función día(f:fecha) devuelve entero
principio
devuelve f.elDía
fin
función mes(f:fecha) devuelve entero
principio
devuelve f.elMes
fin
función año(f:fecha) devuelve entero
principio
devuelve f.elAño
fin
función iguales(f1,f2:fecha) devuelve booleano
principio
devuelve ((f1.elAño=f2.elAño) and (f1.elMes=f2.elMes) and (f1.elDía=f2.elDía))
fin
función anterior(f1,f2:fecha) devuelve booleano
principio
devuelve (f1.elAño<f2.elAño) or
((f1.elAño=f2.elAño) and (f1.elMes<f2.elMes)) or
((f1.elAño=f2.elAño) and (f1.elMes=f2.elMes) and (f1.elDía<f2.elDía))
fin
función posterior(f1,f2:fecha) devuelve booleano

-- 36 of 267 --

29
principio
devuelve not( iguales(f1,f2) or anterior(f1,f2) )
fin
fin
Como comentarios adicionales:
• 	Dada una especificación de TAD hay muchas implementaciones válidas.
• 	Un cambio de implementación de un TAD debe ser transparente a los programas que lo utilizan.
• 	Cuando se implementa un TAD, se está construyendo una interpretación de la especificación. La
implementación de un TAD debe corresponderse con la especificación, manteniendo sus propiedades, si es
posible sin introducir “basura” ni “confusión”.
o 	Basura: la representación de datos elegida para el TAD hace que sean representables más valores de
los especificados (llamados basura).
o 	Confusión: la representación de datos elegida para el TAD hace que varios de los valores
especificados tengan una misma representación (se confunden).
Si no queda más remedio que introducir basura o confusión, deberán estar documentadas para que quien use
la implementación del TAD sepa exactamente qué se le está ofreciendo.
Ejemplos de basura y confusión para el TAD fecha:
• 	Basura: que un dato fecha pueda tomar valores de fechas no válidas: 31-2-2011, 2-15-2011…
• 	Confusión: que varios valores válidos se representen exactamente igual y por tanto sean indistinguibles: 31-
1-1920 y 31-1-2020 representados ambos como 31-1-20.
Hay veces que la confusión es inevitable, pero como se ha dicho debe estar documentada. Por ejemplo, si se trata de
representar un dominio de valores de cardinal infinito, como los números enteros, utilizando una representación en
memoria acotada (por ejemplo de 4 bytes), lo cual es inevitable.
Como último ejemplo, veamos la implementación del TAD tabla de frecuencias mencionado en el ejercicio final de
la lección 1 y especificado en la lección 2.
módulo tablas
exporta
constante maxnumdatos = 1000
tipo tabla
{Tabla de frecuencias de enteros según el enunciado de la lección 1.
Implementación limitada a tablas con un tamaño máximo de maxnumdatos enteros
distintos.}
procedimiento inicializar(sal t:tabla)
{Crea una tabla vacía t de frecuencias}
procedimiento añadir(e/s t:tabla; ent e:entero; sal error:booleano)
{Modifica t incrementando en 1 la frecuencia de e.
La implementación limita a maxnumdatos el nº de datos distintos,
por tanto, si e no cabe en la tabla, devuelve error=verdad.}
función total(t:tabla) devuelve natural
{Devuelve el nº de enteros distintos en la tabla t.}
procedimiento info(ent t:tabla; ent n:natural;
sal e:entero; sal m:natural; sal error:booleano)
{Devuelve en e el entero que ocupa el n-ésimo lugar en la tabla t,
en orden de frecuencias decrecientes, y m es su frecuencia.
Si no existe ese entero (i.e. total(t)<n), devuelve 0 en ambos y error=verdad.}
implementación
tipos
dato = registro
número:entero;

-- 37 of 267 --

30
frecuencia:natural
freg;
elementos = vector[1..maxnumdatos] de dato
tabla = registro
elmto:elementos;
total:natural
freg
{Guarda los datos ordenados por frecuencias de mayor a menor.}
procedimiento inicializar(sal t:tabla)
{Crea una tabla vacía t de frecuencias}
principio
t.total:=0
fin
procedimiento añadir(e/s t:tabla; ent e:entero; sal error:booleano)
{Modifica t incrementando en 1 la frecuencia de e.
La implementación limita a maxnumdatos el nº de datos distintos,
por tanto, si e no cabe en la tabla, devuelve error=verdad.}
variables
i:natural:=0;
éxito:booleano:=falso;
aux:entero
principio
{buscar e en t}
mientrasQue not éxito and i<t.total hacer
i:=i+1;
éxito:=t.elmto[i].número=e
fmq;
si éxito entonces
{e ya estaba -> incrementar su frecuencia y recolocarlo}
t.elmto[i].frecuencia:=t.elmto[i].frecuencia+1;
mientrasQue i>1 andThen t.elmto[i].frecuencia>t.elmto[i-1].frecuencia hacer
aux:=t.elmto[i].número;
t.elmto[i].número:=t.elmto(i-1).número;
t.elmto[i-1].número:=aux;
aux:=t.elmto[i].frecuencia;
t.elmto[i].frecuencia:=t.elmto[i-1].frecuencia;
t.elmto[i-1].frecuencia:=aux
fmq;
error:=falso
sino
{e no estaba -> añadirlo al final de la tabla, si cabe}
si t.total<maxnumdatos entonces
t.total:=t.total+1;
t.elmto[t.total].número:=e;
t.elmto[t.total].frecuencia:=1;
error:=falso
sino
error:=verdad
fsi
fsi
fin
función total(t:tabla) devuelve natural
{Devuelve el nº de enteros distintos en la tabla t.}
principio
devuelve t.total
fin
procedimiento info(ent t:tabla; ent n:natural;
sal e:entero; sal m:natural; sal error:booleano)
{Devuelve en e el entero que ocupa el n-ésimo lugar en la tabla t,
en orden de frecuencias decrecientes, y m es su frecuencia.
Si no existe ese entero (i.e. total(t)<n), devuelve 0 en ambos y error=verdad.}
principio
si n<=total(t) entonces
e:=t.elmto[n].número;
m:=t.elmto[n].frecuencia;

-- 38 of 267 --

31
error:=falso
sino
e:=0;
m:=0;
error:=verdad
fsi
fin
fin
2.2. 	C++
Para implementar un TAD en C++ hay esencialmente dos posibilidades: utilizar el concepto de clase de la
programación orientada a objetos e implementar cada TAD en una clase, o bien utilizar registros o tuplas (constructor de
tipos struct). Dado que en las asignaturas anteriores todavía no se ha estudiado la orientación a objetos y que ese es uno de
los objetivos de la asignatura de programación siguiente a ésta en el plan de estudios, optaremos por la representación con
registros.
La representación de los datos en el registro será privada (private) y para poder acceder a ella las operaciones del TAD
serán funciones amigas (friend).
Las operaciones que en pseudocódigo aparecen como procedimientos se pueden codificar con funciones void. Las
operaciones que en pseudocódigo aparecen como funciones se pueden codificar con funciones que devuelven un dato.
Los parámetros de entrada se pueden codificar con
• 	parámetros de entrada (transmisión por valor), útiles si ocupan poca memoria;
• 	parámetros constantes transmitidos por referencia, útiles si ocupan mucha memoria.
Los parámetros de salida o de entrada y salida se codifican con parámetros transmitidos por referencia.
Veamos en primer lugar una codificación en C++ del ejemplo del TAD fecha.
Fichero fecha.h:
#ifndef _FECHA_H
#define _FECHA_H
// Interfaz del TAD fecha. Pre-declaraciones:
/* Los valores del TAD fecha representan fechas válidas
* según las reglas del calendario gregoriano (adoptado en 1583) */
struct Fecha;
/* Dados los tres valores enteros dia, mes y anyo, se devuelve en f
* la fecha compuesta por ellos.
* Parcial: se precisa que 1≤dia≤31, 1≤mes≤12, 1583≤anyo, y además
* que dia, mes y anyo formen una fecha válida según el calendario
* gregoriano; de lo contrario, error devuelve el valor falso */
void crear(int dia, int mes, int anyo, Fecha& f, bool& error);
/* Devuelve el dia de la fecha */
int dia(const Fecha& f);
/* Devuelve el mes de la fecha */
int mes(const Fecha& f);
/* Devuelve el año de la fecha */
int anyo(const Fecha& f);
/* Devuelve verdad si y sólo si f1 y f2 son la misma fecha */
bool iguales(const Fecha& f1, const Fecha& f2);
/* Devuelve verdad si y sólo si la fecha f1 es cronológicamente
* anterior a la fecha f2 */
bool anterior(const Fecha& f1, const Fecha& f2);

-- 39 of 267 --

32
/* Devuelve verdad si y sólo si la fecha f1 es cronológicamente
* posterior a la fecha f2 */
bool posterior(const Fecha& f1, const Fecha& f2);
// Declaración
struct Fecha {
friend void crear(int dia, int mes, int anyo, Fecha& f, bool& error) ;
friend int dia(const Fecha& f);
friend int mes(const Fecha& f);
friend int anyo(const Fecha& f);
friend bool iguales(const Fecha& f1, const Fecha& f2) ;
friend bool anterior(const Fecha& f1, const Fecha& f2);
friend bool posterior(const Fecha& f1, const Fecha& f2);
private:
// Representación de los valores del TAD.
int elDia;
int elMes;
int elAnyo;
};
#endif
Fichero fecha.cpp:
#include "fecha.h"
// Implementacion de las operaciones del TAD fecha.
// Operaciones auxiliares sobre enteros.
// Devuelve verdad si y sólo si el año a es bisiesto.
bool esBisiesto(int a) {
return (a % 4 == 0 && !(a % 100 == 0 && a % 400 != 0));
}
// Devuelve verdad si y sólo si (d,m,a) representan una fecha válida.
bool esFechaValida(int d, int m, int a) {
bool valida = 1583 <= a && 1 <= m && m <= 12;
if (valida) {
switch (m) {
case 4: case 6: case 9: case 11:
valida = 1 <= d && d <= 30;
break;
case 1: case 3: case 5: case 7: case 8: case 10: case 12:
valida = 1 <= d && d <= 31;
break;
case 2:
if (!esBisiesto(a)) {
valida = 1 <= d && d <= 28;
}
else
valida = 1 <= d && d <= 29;
break;
}
}
return valida;
}
void crear(int dia, int mes, int anyo, Fecha& f, bool& error) {
if (esFechaValida(dia, mes, anyo)) {
f.elDia = dia;
f.elMes = mes;
f.elAnyo = anyo;
error = false;
}
else
error = true;

-- 40 of 267 --

33
};
int dia(const Fecha& f) {
return f.elDia;
};
int mes(const Fecha& f) {
return f.elMes;
};
int anyo(const Fecha& f) {
return f.elAnyo;
};
bool iguales(const Fecha& f1, const Fecha& f2) {
return f1.elDia == f2.elDia && f1.elMes == f2.elMes &&
f1.elAnyo == f2.elAnyo;
};
bool anterior(const Fecha& f1, const Fecha& f2) {
return f1.elAnyo < 	f2.elAnyo ||
(f1.elAnyo == f2.elAnyo && f1.elMes < f2.elMes) ||
(f1.elAnyo == f2.elAnyo && f1.elMes == f2.elMes && f1.elDia < f2.elDia);
};
bool posterior(const Fecha& f1, const Fecha& f2) {
return !iguales(f1,f2) && !anterior(f1,f2);
};
Y finalmente, para el ejemplo de las tablas de frecuencias.
Fichero tabla_frec.h:
#ifndef _TABLA_FREC_H
#define _TABLA_FREC_H
// Interfaz del TAD tabla de frecuencias. Pre-declaraciones:
const int MAX_NUM_DATOS = 1000;
struct Tabla;
void inicializar(Tabla& t);
bool anyadir(Tabla& t, int n);
int total(const Tabla& t);
int infoEnt(const Tabla& t, int n);
int infoFrec(const Tabla& t, int n);
// Declaración
struct Tabla {
friend void inicializar(Tabla& t);
friend bool anyadir(Tabla& t, int n);
friend int total(const Tabla& t);
friend int infoEnt(const Tabla& t, int n);
friend int infoFrec(const Tabla& t, int n);
// Representación de los valores del TAD
private:
struct Frecuencia {
int numero;
int frec;
};
Frecuencia elementos [MAX_NUM_DATOS];
int numElementos;
};

-- 41 of 267 --

34
#endif
Fichero tabla_frec.cpp:
#include "tabla_frec.h"
void inicializar(Tabla& t){
t.numElementos = 0;
};
bool anyadir(Tabla& t, int n){
//encontrar n en tabla
int pos = 0;
bool encontrado = false;
while (!encontrado && pos < t.numElementos){
if (t.elementos[pos].numero == n){
encontrado = true;
}
else{
pos = pos + 1;
}
}
if (!encontrado){
pos = - 1;
}
bool error = false;
//si está n en tabla, recolocar
if (pos != -1) {
t.elementos[pos].frec = t.elementos[pos].frec + 1;
while (pos > 0 && t.elementos[pos].frec > t.elementos[pos-1].frec) {
Frecuencia aux = t.elementos[pos];
t.elementos[pos] = t.elementos[pos-1];
t.elementos[pos-1] = aux;
pos = pos - 1;
}
}
else { //si no esá, introducir al final si se puede
if (t.numElementos < MAX_NUM_DATOS) {
t.elementos[t.numElementos].numero = n;
t.elementos[t.numElementos].frec = 1;
t.numElementos = t.numElementos + 1;
}
else {
error = true;
}
}
return error;
};
int total(const Tabla& t) {
return t.numElementos;
};
int infoEnt(const Tabla& t, int n) {
if (1 <= n && n <= t.numElementos) {
return t.elementos[n-1].numero;
} else {
return 0;
}
};
int infoFrec(const Tabla& t, int n) {
if (1 <= n && n <= t.numElementos) {
return t.elementos[n-1].frec;
} else {
return 0;
}
};

-- 42 of 267 --

35
Lección 4
TAD genéricos
Indice