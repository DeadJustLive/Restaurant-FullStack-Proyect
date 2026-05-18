# 5. Añadir un nuevo div.module a la página después del último; luego añadir una copia de una de

## Fuente
jquery-fundamentos (Cap. 21)

## Contenido
# 5. Añadir un nuevo div.module a la página después del último; luego añadir una copia de una de

las imágenes existentes dentro del nuevo div.
0.4. El núcleo de jQuery
0.4.1. $ vs $()
Hasta ahora, se ha tratado completamente con métodos que se llaman desde el objeto jQuery. Por
ejemplo:
$('h1').remove();
Dichos métodos son parte del espacio de nombres (en inglés namespace) $.fn, o del prototipo (en
inglés prototype) de jQuery, y son considerados como métodos del objeto jQuery.
Sin embargo, existen métodos que son parte del espacio de nombres de $ y se consideran como métodos
del núcleo de jQuery.
Estas distinciones pueden ser bastantes confusas para usuarios nuevos. Para evitar la confusión, debe
recordar estos dos puntos:
los métodos utilizados en selecciones se encuentran dentro del espacio de nombres $.fn, y au-
tomáticamente reciben y devuelven una selección en sí;
métodos en el espacio de nombres $ son generalmente métodos para diferentes utilidades, no
trabajan con selecciones, no se les pasa ningún argumento y el valor que devuelven puede variar.
Existen algunos casos en donde métodos del objeto y del núcleo poseen los mismos nombres, como
sucede con $.each y $.fn.each. En estos casos, debe ser cuidadoso de leer bien la documentación
para saber que objeto utilizar correctamente.
39

-- 40 of 107 --

0.4.2. Métodos Utilitarios
jQuery ofrece varios métodos utilitarios dentro del espacio de nombres $. Estos métodos son de gran
ayuda para llevar a cabo tareas rutinarias de programación. A continuación se muestran algunos
ejemplos, para una completa documentación sobre ellos, visite http://api.jquery.com/category/
utilities/.
$.trim Remueve los espacios en blanco del principio y final.
$.trim(' varios espacios en blanco ');
// devuelve 'varios espacios en blanco'
$.each Interactúa en vectores y objetos.
$.each([ 'foo', 'bar', 'baz' ], function(idx, val) {
console.log('elemento ' + idx + 'es ' + val);
});
$.each({ foo : 'bar', baz : 'bim' }, function(k, v) {
console.log(k + ' : ' + v);
});
Nota
Como se dijo antes, existe un método llamado $.fn.each, el cual interactúa en una
selección de elementos.
$.inArray Devuelve el índice de un valor en un vector, o -1 si el valor no se encuentra en el vector.
var myArray = [ 1, 2, 3, 5 ];
if ($.inArray(4, myArray) !== -1) {
console.log('valor encontrado');
}
$.extend Cambia la propiedades del primer objeto utilizando las propiedades de los subsecuentes
objetos.
var firstObject = { foo : 'bar', a : 'b' };
var secondObject = { foo : 'baz' };
var newObject = $.extend(firstObject, secondObject);
console.log(firstObject.foo); // 'baz'
console.log(newObject.foo); // 'baz'
Si no se desea cambiar las propiedades de ninguno de los objetos que se utilizan en $.extend, se debe
incluir un objeto vacío como primer argumento.
40

-- 41 of 107 --

var firstObject = { foo : 'bar', a : 'b' };
var secondObject = { foo : 'baz' };
var newObject = $.extend({}, firstObject, secondObject);
console.log(firstObject.foo); // 'bar'
console.log(newObject.foo); // 'baz'
$.proxy Devuelve una función que siempre se ejecutará en el alcance (scope) provisto — en otras
palabras, establece el significado de this (incluido dentro de la función) como el segundo argu-
mento.
var myFunction = function() { console.log(this); };
var myObject = { foo : 'bar' };
myFunction(); // devuelve el objeto window
var myProxyFunction = $.proxy(myFunction, myObject);
myProxyFunction(); // devuelve el objeto myObject
Si se posee un objeto con métodos, es posible pasar dicho objeto y el nombre de un método para
devolver una función que siempre se ejecuta en el alcance de dicho objeto.
var myObject = {
myFn : function() {
console.log(this);
}
};
$('#foo').click(myObject.myFn); // registra el elemento DOM #foo
$('#foo').click($.proxy(myObject, 'myFn')); // registra myObject
0.4.3. Comprobación de Tipos
Como se mencionó en el capítulo “Conceptos Básicos de JavaScript”, jQuery ofrece varios métodos
útiles para determinar el tipo de un valor específico.
Comprobar el tipo de un determinado valor
var myValue = [1, 2, 3];
// Utilizar el operador typeof de JavaScript para comprobar tipos primitivos
typeof myValue == 'string'; // falso (false)
typeof myValue == 'number'; // falso (false)
typeof myValue == 'undefined'; // falso (false)
typeof myValue == 'boolean'; // falso (false)
// Utilizar el operador de igualdad estricta para comprobar valores nulos (null)
myValue === null; // falso (false)
// Utilizar los métodos jQuery para comprobar tipos no primitivos
41

-- 42 of 107 --

jQuery.isFunction(myValue); // falso (false)
jQuery.isPlainObject(myValue); // falso (false)
jQuery.isArray(myValue); // verdadero (true)
jQuery.isNumeric(16); // verdadero (true). No disponible en versiones inferiores a jQuery 1.7
0.4.4. El Método Data
A menudo encontrará que existe información acerca de un elemento que necesita guardar. En Ja-
vaScript es posible hacerlo añadiendo propiedades al DOM del elemento, pero esta práctica conlleva
enfrentarse a
