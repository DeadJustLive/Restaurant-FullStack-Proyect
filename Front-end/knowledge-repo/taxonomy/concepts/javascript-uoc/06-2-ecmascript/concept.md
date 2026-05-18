# 2. Ecmascript

## Fuente
javascript-uoc (Cap. 6)

## Contenido
# 2. Ecmascript

Actualmente hay muchas plataformas que interpretan JavaScript, como los
navegadores web o NodeJS y son utilizadas para el desarrollo de aplicaciones de
diferentes sistemas operativos. Es el estándar ECMAScript el que marca cómo
tiene que ser interpretado el lenguaje en cada una de estas tecnologías.
ECMA es el nombre de la asociación europea de fabricantes de ordenadores
(European Computer Manufacturer Association), una organización sin ánimo
de lucro que se encarga, entre otras cosas, de regular el funcionamiento de
muchos estándares de la industria mundial. Uno de estos es el estándar EC-
MA-262, que también se conoce como ECMAScript.
JavaScript es una de las implementaciones del estándar ECMA-262, en concre-
to la que se usa en los navegadores. Es decir, ECMAScript es el estándar que
define cómo tiene que funcionar el lenguaje, y JavaScript es una implementa-
ción concreta de lo que indica la especificación estándar.
Hay otras implementaciones con sus propias extensiones, como por ejemplo
ActionScript, el lenguaje que se usaba para programar Flash, o JScript, la im-
plementación de Microsoft de ECMAScript disponible a través de Internet Ex-
plorer.
2.1. Historia de la ECMAScript
La primera versión de ECMAScript apareció en 1997 con la intención de es-
tandarizar el lenguaje, de forma que los fabricantes de navegadores no se de-
dicaran a modificar a su gusto creando versiones incompatibles.
Un año después, en junio de 1998, apareció ECMAScript 2, que realmente no
incluía nada nuevo sino que era un cambio de formato en la especificación
para alinearla con el estándar internacional ISO/IEC 16262.
En diciembre de 1999 se lanzó ECMAScript 3, que añadió soporte para expre-
siones regulares, gestión estructurada de excepciones, definición más estricta
de errores y otras mejoras.
La versión 4 de ECMAScript no llegó nunca a ver la luz a consecuencia de las
luchas internas sobre la complejidad del lenguaje. Se querían añadir demasia-
das cosas que hacían que el lenguaje perdiera parte de su propósito inicial.
Muchas de las propuestas fueron desestimadas y desaparecieron por siempre,
mientras que otras vieron la luz en la siguiente versión o incluso se pospusie-
ron hasta las versiones más recientes.

-- 6 of 48 --

CC-BY-NC-ND • PID_00254185 7 JavaScript
Así que no fue hasta diciembre del 2009, una década después de la versión
anterior, cuando se presentó la siguiente versión del lenguaje: ECMAScript 5.
Esta es en realidad la cuarta versión real del lenguaje, por lo cual, oficialmente
se tendría que llamar ECMAScript 4, pero no es así y en algunos casos genera
confusión.
Esta edición añadió la manera estricta del lenguaje («strict mode»), mejoró la
especificación aclarando varias ambigüedades de la tercera edición y que cau-
saban confusión e implementaciones incoherentes, añadió el soporte nativo
para JSON, o los getters y setters para propiedades, entre otras pequeñas cosas.
A esta versión se la conoce también como Harmony, que es el nombre en clave
que se le daba mientras estaba en desarrollo.
En junio del 2011 salió la revisión 5.1, que simplemente alineaba el estándar
de ECMA con el formato correspondiente de ISO: ISO / IEC 16262: 2011 pero
que no tenía mejoras relevantes.
La sexta edición se lanzó en junio del 2015 con el nombre oficial de ECMAS-
cript 2015. Esta añadía muchas novedades al lenguaje, algunas de las cuales
ya se habían planteado para la fallida versión 4. Lleva el lenguaje a un nivel
superior, con cambios significativos en la sintaxis para escribir aplicaciones
complejas, y también conceptos nuevos, como los símbolos o las lambdas,
funciones de flecha, tipo de datos que no existían, estructuras mejoradas por
iteración, promesas, etc.
La versión ES5 permaneció durante tanto de tiempo que se convirtió en la más
extendida de JavaScript en todo tipo de plataformas. Su alto índice de com-
patibilidad la convierte en candidata ideal para ser empleada en la escritura
de código apto para todo tipo de sistemas o navegadores. De todos modos,
actualmente ya son muchos los sistemas capaces de interpretar la versión del
2015 (ES6).
La 7.ª edición, oficialmente conocida como ECMAScript 2016, finalizó en ju-
nio del 2016. Resultó ser una versión bastante descafeinada comparada con la
anterior, puesto que no incluye grandes mejoras: se introduce el operador de
exponenciación (**) y un método nuevo para las matrices que permite com-
probar si hay ciertos elementos dentro de estas.
A día de hoy la última versión publicada es la octava, ECMAScript 2017, que
finalizó en junio del 2017 con la esperada implementación await/async.

-- 7 of 48 --

CC-BY-NC-ND • PID_00254185 8 JavaScript
2.2. ECMAScript 6
A pesar de que ya se han publicado las versiones 7 y 8 del estándar ECMAS-
cript, la versión 6 supuso un gran cambio en el lenguaje al introducir muchas
mejoras (las posteriores han sido poco significativas en comparación, y toda-
vía no son populares en la comunidad). Por este motivo nos centraremo
