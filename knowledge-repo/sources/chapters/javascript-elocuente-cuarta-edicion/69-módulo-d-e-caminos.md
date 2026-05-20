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
creation, 90, 334, 392
elemento aleatorio, 121
en Egg, 212
filtrado, 86
indexación, 57
402

-- 414 of 445 --

indexing, 67, 70, 392
iteración, 84
iteration, 67
longitud de, 58
methods, 90, 93
métodos, 69, 78, 84, 86, 87
notation, 77
of rest arguments, 72
representation, 76
searching, 66, 70
Array constructor, 334
array de carreteras, 116
arrays en Egg (ejercicio), 212
arriba (CSS), 237
arrow function, 197
arte de píxeles, 294
asignación, 23, 161, 213
desestructuración, 75
assignment, 34
asterisco, 12, 146
asunción, 138
async function, 189, 190
asynchronous programming, 189
reading files, 324
atajos de teclado (ejercicio), 349
atributo, 218, 230, 318, 335
atributo autofocus, 318
atributo checked, 321
atributo clase, 272
atributo class, 227, 230, 235
atributo data, 230
atributo de clase, 269
atributo de estilo, 233–235, 269
atributo disabled, 318
atributo href, 217, 227, 230
atributo id, 227, 235
atributo marcado, 316
atributo method, 310
atributo onclick, 220, 243
atributo src, 218, 219
atributo tabindex, 248, 318, 349
atributo tipo, 315
atributo valor, 316
atributo xmlns, 285
atributos, 225
automation, 125
automatización, 130
autómata, 116
avaricia, 155, 156
avatar, 262
await keyword, 189–191
axis, 296
azul, 334
Babbage, Charles, 56
background (CSS), 259
banco de trabajo (ejercicio), 329
Banks, Ian, 261
barra vertical, 151
bean counting (exercise), 55, 391
benchmark, 232
Berners-Lee, Tim, 214
biblioteca, 332, 355
binary number, 323
binding
as state, 63
asignación, 23
definition, 23
en Egg, 208
global, 128, 353, 354
model of, 63
modelo de, 24
naming, 129
nombrar, 35
bit, 3, 11, 16
bit de signo, 12
bitfield, 250
block, 136
bloque, 28, 32, 39, 41, 44, 60, 135,
201
403

-- 415 of 445 --

bloqueo, 180, 238, 257, 359
blur event, 253
body (etiqueta HTML), 217, 223
Boolean, 28, 30
conversión a, 19, 27
Booleano, 16, 143, 206
conversión a, 31
booleano, 62
Booleanos, 208
borde (CSS), 231, 233
border-radius (CSS), 249
borrado, 294
botón, 242, 319, 330
botón (etiqueta HTML), 220, 243,
335
botón de radio, 316
botón de ratón, 248
botón del mouse, 244
botón del ratón, 245
boundary, 164, 397
br (etiqueta HTML), 338
braces
function body, 43
object, 64
branching, 151
break keyword, 35
browser, 216
bucle, 4, 5, 30, 32, 37, 38, 89, 159,
391
terminación de, 33
bucle de eventos, 195
bucle de lectura-evaluación-impresión,
353
bucle do, 31, 122
bucle for, 32, 33, 94, 138
bucle for/of, 91, 107, 109, 111, 395
bucle infinito, 33, 45, 138, 392
bucle interno, 153
bucle while, 5, 32, 52
Buffer, 357, 358
bug, 127, 164, 169
bugs, 81
bundler, 174
burbujeo, see propagación de evento
button (etiqueta HTML), 248, 329
button (HTML tag), 259, 319
button property, 250
buttons property, 250
búsqueda de caminos, 342
cabecera, 313, 372
cabecera Access-Control-Allow-Origin,
313
cabecera Content-Length, 310
cabecera Content-Type, 310, 368
cabecera If-None-Match, 386
cabecera Last-Modified, 310
cabecera Prefer, 386
cadena, 13, 59, 62
indexación, 91
longitud, 37, 91
notación, 13
representación, 14
cadena de consulta, 373, 380
caja, 141, 222, 262
caja de arena, 222
call stack, 59
camel case, 35, 234
campo, 330
campo de archivo, 316, 324
campo de color, 332, 334, 339
campo de contraseña, 316
campo de texto, 253, 316, 317, 321
campo de verificación, 330
campos de texto, 320
canvas, 287, 288, 292, 293, 298, 299,
303–306
contexto, 285, 286
path, 287
size, 287
404

-- 416 of 445 --

canvas (etiqueta HTML), 285, 331
canvas (HTML tag), 345
capacidad, 242
capitalización, 35, 147, 234, 240, 361