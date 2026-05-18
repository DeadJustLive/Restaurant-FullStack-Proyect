# Capítulo 30:: Depurando la aplicación Node.js

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 67)

## Contenido
# Capítulo 30:: Depurando la aplicación Node.js

Examples
Core node.js depurador e inspector de nodos
Usando el depurador de núcleo
Node.js proporciona una compilación en una utilidad de depuración no gráfica. Para iniciar la
compilación en el depurador, inicie la aplicación con este comando:
node debug filename.js
Considere la siguiente aplicación Node.js simple contenida en el debugDemo.js
'use strict';
function addTwoNumber(a, b){
// function returns the sum of the two numbers
debugger
return a + b;
}
var result = addTwoNumber(5, 9);
console.log(result);
El debugger palabras clave detendrá al depurador en ese punto del código.
Referencia de comando
Paso a paso	1.
cont, c - Continue execution
next, n - Step next
step, s - Step in
out, o - Step out
Puntos de interrupción	2.
setBreakpoint(), sb() - Set breakpoint on current line
setBreakpoint(line), sb(line) - Set breakpoint on specific line
Para depurar el código anterior ejecute el siguiente comando
node debug debugDemo.js
https://riptutorial.com/es/home 114

-- 142 of 423 --

Una vez que se ejecutan los comandos anteriores, verá la siguiente salida. Para salir de la
interfaz del depurador, escriba process.exit()
Use el comando watch(expression) para agregar la variable o expresión cuyo valor desea ver y
restart para reiniciar la aplicación y la depuración.
Use repl para ingresar el código de manera interactiva. El modo de respuesta tiene el mismo
contexto que la línea que está depurando. Esto le permite examinar el contenido de las variables
y probar las líneas de código. Presione Ctrl+C para dejar la respuesta de depuración.
Usando el inspector de nodos incorporado
v6.3.0
Puede ejecutar el inspector v8 incorporado en el nodo! El complemento inspector de nodos ya no
es necesario.
Simplemente pase el indicador de inspector y se le proporcionará una URL para el inspector
node --inspect server.js
https://riptutorial.com/es/home 115

-- 143 of 423 --

Usando inspector de nodos
Instale el inspector de nodo:
npm install -g node-inspector
Ejecute su aplicación con el comando node-debug:
node-debug filename.js
Después de eso, pulsa en Chrome:
http://localhost:8080/debug?port=5858
A veces, el puerto 8080 puede no estar disponible en su computadora. Puede obtener el siguiente
error:
No se puede iniciar el servidor en 0.0.0.0:8080. Error: escuchar EACCES.
En este caso, inicie el inspector de nodos en un puerto diferente utilizando el siguiente comando.
$node-inspector --web-port=6500
Verás algo como esto:
https://riptutorial.com/es/home 116

-- 144 of 423 --

Lea Depurando la aplicación Node.js en línea: https://riptutorial.com/es/node-
js/topic/5900/depurando-la-aplicacion-node-js
https://riptutorial.com/es/home 117

-- 145 of 423 --
