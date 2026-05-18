# Módulo d: e caminos

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 69)

## Contenido
# Módulo d: e caminos

Dado que este es un módulo ES, debes usar import para acceder al módulo
de gráfico. Esto se describió como exportando una función de buildGraph
, la cual puedes seleccionar de su objeto de interfaz con una declaración de
desestructuración const.
Para exportar roadGraph, colocas la palabra clave export antes de su defini-
ción. Debido a que buildGraph toma una estructura de datos que no coincide
exactamente con roads, la división de las cadenas de carretera debe ocurrir en
tu módulo.
Dependencias circulares
El truco es que require añade el objeto de interfaz de un módulo a su caché
antes de comenzar a cargar el módulo. De esta manera, si se hace alguna
llamada a require mientras se está ejecutando tratando de cargarlo, ya se
conoce, y se devolverá la interfaz actual, en lugar de comenzar a cargar el
módulo nuevamente (lo que eventualmente desbordaría la pila).
399

-- 411 of 445 --

Programación Asíncrona
Momentos de tranquilidad
Necesitarás convertir el contenido de estos archivos en un array. La forma
más fácil de hacerlo es utilizando el método split en la cadena producida por
textFile. Ten en cuenta que para los archivos de registro, eso seguirá dándote
un array de cadenas, que debes convertir a números antes de pasarlos a new
Date.
Resumir todos los puntos temporales en una tabla de horas se puede hacer
creando una tabla (array) que contenga un número para cada hora del día.
Luego puedes recorrer todos los marca de tiempos (sobre los archivos de registro
y los números en cada archivo de registro) y, para cada uno, si sucedió en el día
correcto, toma la hora en que ocurrió y suma uno al número correspondiente
en la tabla.
Asegúrate de usar await en el resultado de las funciones asíncronas antes de
hacer cualquier cosa con él, o terminarás con una Promise donde esperabas un
string.
hinting}}
Promesas Reales
Reescribe la función del ejercicio anterior sin async/await, utilizando métodos
simples de Promise.
En este estilo, usar Promise.all será más conveniente que intentar modelar
un bucle sobre los archivos de registro. En la función async, simplemente usar
await en un bucle es más simple. Si leer un archivo toma un tiempo, ¿cuál de
estos dos enfoques tomará menos tiempo para ejecutarse?
Si uno de los archivos listados en la lista de archivos tiene un error tipográfico,
y falla al leerlo, ¿cómo termina ese fallo en el objeto Promise que retorna tu
función?
400

-- 412 of 445 --

Index
!, 31
! operador, 17
!== operador, 19
* operador, 146
* operator, 18
** operador, 31
*= operator, 34
+ operator, 18
++ operator, 34
+= operator, 34
-, 13
− operador, 15
− operator, 18
−− operator, 34
−= operator, 34
/ operator, 13
/= operator, 34
< operador, 16
= operator, 23
== operador, 19
== operator, 63
=== operador, 19
=== operator, 393
> operador, 16
?: operador, 17
[] (array), 73
[] (arreglo), 57
[] (subíndice), 57, 58
% operator, 13, 390
&& operador, 17
| | operador, 17
| | operator, 390
{} (bloque), 28
{} (object), 64, 73
200 (código de estado HTTP), 359,
363
200 (código de estado de HTTP),
309
204 (código de estado HTTP), 366
2d (contexto de canvas), 285
304 (código de estado HTTP), 373,
381, 387
403 (código de estado HTTP), 364
404 (código de estado HTTP), 364,
378, 380
404 (código de estado de HTTP),
309
405 (código de estado HTTP), 362
500 (código de estado HTTP), 363
a (etiqueta HTML), 217, 233, 318
Abelson, Hal, 200
absolute positioning, 236, 241, 253
abstracciones, 225, 349
abstracción, 5, 39, 200, 314, 348
de la red, 215
en Egg, 200
abstraction, 82, 84
acceso
401

-- 413 of 445 --

de
propiedad, 58
propiedad, 26
acceso de propiedad, 58
acceso remoto, 362
access control, 141
acciones, 332, 334
acción, 335
aceleración, 279
acento, 15
acento grave, see comilla invertida
actor, 265, 271, 277
addEntry function, 63
adición, 114
adopción, 142
afirmación, 140
agrupación, 12, 28, 147, 148, 154
aislamiento, 96, 171
alcance, 42, 47
algoritmo de Dijkstra, 175
alt attribute, 228
altura máxima (CSS), 272
ambigüedad, 213
analysis, 132
ancho máximo (CSS), 272
and lógico, 17
Android, 248
anidación
de arrays, 65
anidamiento
de expresiones, 22, 202
de funciones, 41
de objetos, 223, 226
de ámbito, 41
en expresiones regulares, 153
animacione, 262
animación, 237, 259, 267, 304
gato giratorio, 237
juego de plataforma, 294, 295
juego de plataformas, 274, 278,
280, 281, 302
animación suave, 238
anulación, 105
anulación, prototipo, 111
análisis, 127, 161, 202, 222, 363, 380
análisis sintáctico, 201, 206, 218
apio, 370
aplanamiento (ejercicio), 94
aplicación, 1, 331, 371
aplicación web, 6, 326
Apple, 221
aprender, 7
aprendizaje, 2
arc, 290
archivo, 354, 365
acceso, 173, 357, 358
flujo, 360
imagen, 331
recurso, 310, 362, 364
archivo INI, 159
archivos estáticos, 372
arco, 291
argumento, 26, 45, 72, 201
argumento opcional, 46
arguments object, 392
aritmética, 12, 18, 208
arrastrar, 341, 350
array, 58–60, 62, 79
aplanamiento, 94
coincidencia de RegExp, 147
como matriz, 264
como tabla, 65
conteo, 92
creación, 57, 396

