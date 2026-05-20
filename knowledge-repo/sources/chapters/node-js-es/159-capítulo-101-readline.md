# Capítulo 101:: Readline

Sintaxis
const readline = require ('readline')	•
readline.close ()	•
readline.pause ()	•
readline.prompt ([preserveCursor])	•
readline.question (consulta, devolución de llamada)	•
readline.resume ()	•
readline.setPrompt (indicador)	•
readline.write (datos [, clave])	•
readline.clearLine (stream, dir)	•
readline.clearScreenDown (secuencia)	•
readline.createInterface (opciones)	•
readline.cursorTo (secuencia, x, y)	•
readline.emitKeypressEvents (flujo [, interfaz])	•
readline.moveCursor (secuencia, dx, dy)	•
Examples
Lectura de archivos línea por línea
const fs = require('fs');
const readline = require('readline');
const rl = readline.createInterface({
input: fs.createReadStream('text.txt')
});
// Each new line emits an event - every time the stream receives \r, \n, or \r\n
rl.on('line', (line) => {
console.log(line);
});
rl.on('close', () => {
console.log('Done reading file');
});
Solicitar la entrada del usuario a través de CLI
const readline = require('readline');
const rl = readline.createInterface({
input: process.stdin,
output: process.stdout
});
rl.question('What is your name?', (name) => {
https://riptutorial.com/es/home 349

-- 377 of 423 --

console.log(`Hello ${name}!`);
rl.close();
});
Lea Readline en línea: https://riptutorial.com/es/node-js/topic/1431/readline
https://riptutorial.com/es/home 350

-- 378 of 423 --