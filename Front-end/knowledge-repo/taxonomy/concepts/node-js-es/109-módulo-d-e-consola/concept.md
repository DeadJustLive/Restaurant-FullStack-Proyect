# Módulo d: e consola

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 109)

## Contenido
# Módulo d: e consola

Similar al entorno de navegación de JavaScript, node.js proporciona un módulo de consola que
brinda posibilidades simples de registro y depuración.
Los métodos más importantes proporcionados por el módulo de console.log son console.log ,
console.error y console.time . Pero hay varios otros como console.info .
console.log
Los parámetros se imprimirán en la salida estándar ( stdout ) con una nueva línea.
console.log('Hello World');
consola.error
Los parámetros se imprimirán al error estándar ( stderr ) con una nueva línea.
console.error('Oh, sorry, there is an error.');
console.time, console.timeEnd
console.time inicia un temporizador con una etiqueta única que se puede usar para calcular la
duración de una operación. Cuando llama a console.timeEnd con la misma etiqueta, el
temporizador se detiene e imprime el tiempo transcurrido en milisegundos hasta la stdout .
https://riptutorial.com/es/home 230

-- 258 of 423 --
