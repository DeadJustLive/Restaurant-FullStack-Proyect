# Capítulo 38:: Ejecutando archivos o

comandos con procesos hijo
Sintaxis
child_process.exec (comando [, opciones] [, devolución de llamada])	•
child_process.execFile (archivo [, argumentos] [, opciones] [, devolución de llamada])	•
child_process.fork (modulePath [, args] [, opciones])	•
child_process.spawn (comando [, args] [, opciones])	•
child_process.execFileSync (archivo [, argumentos] [, opciones])	•
child_process.execSync (comando [, opciones])	•
child_process.spawnSync (comando [, args] [, opciones])	•
Observaciones
Cuando se trata de procesos secundarios, todos los métodos asíncronos devolverán una
instancia de ChildProcess , mientras que todas las versiones síncronas devolverán la salida de lo
que se haya ejecutado. Al igual que otras operaciones síncronas en Node.js, si se produce un
error, se tirará.
Examples
Generando un nuevo proceso para ejecutar un comando.
Para generar un nuevo proceso en el que necesite una salida sin almacenamiento (por ejemplo,
procesos de larga ejecución que puedan imprimir la salida durante un período de tiempo en lugar
de imprimir y salir de inmediato), use child_process.spawn() .
Este método genera un nuevo proceso utilizando un comando dado y una matriz de argumentos.
El valor de retorno es una instancia de ChildProcess , que a su vez proporciona las propiedades
stdout y stderr . Ambas secuencias son instancias de stream.Readable .
El siguiente código es equivalente a usar la ejecución del comando ls -lh /usr .
const spawn = require('child_process').spawn;
const ls = spawn('ls', ['-lh', '/usr']);
ls.stdout.on('data', (data) => {
console.log(`stdout: ${data}`);
});
ls.stderr.on('data', (data) => {
console.log(`stderr: ${data}`);
});
ls.on('close', (code) => {
https://riptutorial.com/es/home 138

-- 166 of 423 --

console.log(`child process exited with code ${code}`);
});
Otro comando de ejemplo:
zip -0vr "archive" ./image.png
Podría escribirse como:
spawn('zip', ['-0vr', '"archive"', './image.png']);
Generando un shell para ejecutar un comando.
Para ejecutar un comando en un shell, en el que requería una salida con búfer (es decir, no es
una secuencia), use child_process.exec . Por ejemplo, si desea ejecutar el comando cat *.js file
| wc -l , sin opciones, se vería así:
const exec = require('child_process').exec;
exec('cat *.js file | wc -l', (err, stdout, stderr) => {
if (err) {
console.error(`exec error: ${err}`);
return;
}
console.log(`stdout: ${stdout}`);
console.log(`stderr: ${stderr}`);
});
La función acepta hasta tres parámetros:
child_process.exec(command[, options][, callback]);
El parámetro de comando es una cadena, y es obligatorio, mientras que el objeto de opciones y la
devolución de llamada son opcionales. Si no se especifica ningún objeto de opciones, exec usará
lo siguiente como predeterminado:
{
encoding: 'utf8',
timeout: 0,
maxBuffer: 200*1024,
killSignal: 'SIGTERM',
cwd: null,
env: null
}
El objeto de opciones también admite un parámetro de shell , que es de forma predeterminada
/bin/sh en UNIX y cmd.exe en Windows, una opción uid para configurar la identidad del usuario del
proceso y una opción gid para la identidad del grupo.
La devolución de llamada, que se invoca cuando se termina de ejecutar el comando, se llama con
https://riptutorial.com/es/home 139

-- 167 of 423 --

los tres argumentos (err, stdout, stderr) . Si el comando se ejecuta con éxito, err será null , de
lo contrario será una instancia de Error , donde err.code será el código de salida del proceso y
err.signal será la señal que se envió para finalizarlo.
Los argumentos stdout y stderr son la salida del comando. Se decodifica con la codificación
especificada en el objeto de opciones (predeterminado: string ), pero de lo contrario se puede
devolver como un objeto Buffer .
También existe una versión síncrona de exec , que es execSync . La versión síncrona no recibe una
devolución de llamada y devolverá stdout lugar de una instancia de ChildProcess . Si la versión
sincrónica encuentra un error, se va a tirar y poner fin a su programa. Se parece a esto:
const execSync = require('child_process').execSync;
const stdout = execSync('cat *.js file | wc -l');
console.log(`stdout: ${stdout}`);
Generando un proceso para ejecutar un ejecutable.
Si está buscando ejecutar un archivo, como un ejecutable, use child_process.execFile . En lugar
de generar un shell como child_process.exec , creará directamente un nuevo proceso, que es un
poco más eficiente que ejecutar un comando. La función se puede utilizar como tal:
const execFile = require('child_process').execFile;
const child = execFile('node', ['--version'], (err, stdout, stderr) => {
if (err) {
throw err;
}
console.log(stdout);
});
A diferencia de child_process.exec , esta función aceptará hasta cuatro parámetros, donde el
segundo parámetro es una matriz de argumentos que le gustaría proporcionar al ejecutable:
child_process.execFile(file[, args][, options][, callback]);
De lo contrario, las opciones y el formato de devolución de llamada son idénticos a
child_process.exec . Lo mismo ocurre con la versión síncrona de la función:
const execFileSync = require('child_process').execFileSync;
const stdout = execFileSync('node', ['--version']);
console.log(stdout);
Lea Ejecutando archivos o comandos con procesos hijo en línea: https://riptutorial.com/es/node-
js/topic/2726/ejecutando-archivos-o-comandos-con-procesos-hijo
https://riptutorial.com/es/home 140

-- 168 of 423 --