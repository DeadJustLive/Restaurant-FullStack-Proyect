# Capítulo 52:: Gestión de errores Node.js

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 92)

## Contenido
# Capítulo 52:: Gestión de errores Node.js

Introducción
Aprenderemos cómo crear objetos de error y cómo lanzar y manejar errores en Node.js
Futuras ediciones relacionadas con las mejores prácticas en el manejo de errores.
Examples
Creando objeto de error
nuevo error (mensaje)
Crea un nuevo objeto de error, donde el message valor se establece en propiedad de message del
objeto creado. Normalmente, los argumentos del message se pasan al constructor de errores como
una cadena. Sin embargo, si el argumento del message es un objeto y no una cadena, el
constructor de error llama .toString() método .toString() del objeto pasado y establece ese valor
en la propiedad del message del objeto de error creado.
var err = new Error("The error message");
console.log(err.message); //prints: The error message
console.log(err);
//output
//Error: The error message
// at ...
Cada objeto de error tiene un seguimiento de pila. El seguimiento de la pila contiene la
información del mensaje de error y muestra dónde ocurrió el error (la salida anterior muestra la
pila de error). Una vez que se crea el objeto de error, el sistema captura el seguimiento de la pila
del error en la línea actual. Para obtener el seguimiento de pila, utilice la propiedad de pila de
cualquier objeto de error creado. Debajo de dos líneas son idénticas:
console.log(err);
console.log(err.stack);
Error de lanzamiento
El error de lanzamiento significa una excepción si no se maneja alguna excepción, el servidor de
nodos se bloqueará.
La siguiente línea arroja error:
throw new Error("Some error occurred");
o
https://riptutorial.com/es/home 181

-- 209 of 423 --

var err = new Error("Some error occurred");
throw err;
o
throw "Some error occurred";
El último ejemplo (lanzar cadenas) no es una buena práctica y no se recomienda (siempre arroje
errores que son instancias del objeto Error).
Tenga en cuenta que si throw un error en el suyo, entonces el sistema se bloqueará en esa línea
(si no hay controladores de excepción), no se ejecutará ningún código después de esa línea.
var a = 5;
var err = new Error("Some error message");
throw err; //this will print the error stack and node server will stop
a++; //this line will never be executed
console.log(a); //and this one also
Pero en este ejemplo:
var a = 5;
var err = new Error("Some error message");
console.log(err); //this will print the error stack
a++;
console.log(a); //this line will be executed and will print 6
prueba ... atrapa bloque
try ... catch block es para manejar excepciones, recuerde la excepción significa que el error
arrojado no el error.
try {
var a = 1;
b++; //this will cause an error because be is undefined
console.log(b); //this line will not be executed
} catch (error) {
console.log(error); //here we handle the error caused in the try block
}
En el bloque de try b++ produce un error y ese error se pasa al bloque de catch que puede
manejarse allí o incluso se puede lanzar el mismo error en el bloque de captura o hacer una
pequeña modificación y luego lanzar. Veamos el siguiente ejemplo.
try {
var a = 1;
b++;
console.log(b);
} catch (error) {
error.message = "b variable is undefined, so the undefined can't be incremented"
throw error;
}
https://riptutorial.com/es/home 182

-- 210 of 423 --

En el ejemplo anterior modificamos la propiedad de message del objeto de error y luego lanzamos
el error modificado.
Puede a través de cualquier error en su bloque try y manejarlo en el bloque catch:
try {
var a = 1;
throw new Error("Some error message");
console.log(a); //this line will not be executed;
} catch (error) {
console.log(error); //will be the above thrown error
}
Lea Gestión de errores Node.js en línea: https://riptutorial.com/es/node-js/topic/8590/gestion-de-
errores-node-js
https://riptutorial.com/es/home 183

-- 211 of 423 --
