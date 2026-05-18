# Capítulo 31:: Desafíos de rendimiento

Examples
Procesando consultas de larga ejecución con Nodo
Dado que Node es de un solo hilo, hay una solución alternativa si se trata de cálculos de larga
ejecución.
Nota: este es el ejemplo "listo para ejecutar". Simplemente, no olvide obtener jQuery e instalar los
módulos necesarios.
Lógica principal de este ejemplo:
Cliente envía solicitud al servidor.	1.
El servidor inicia la rutina en una instancia de nodo separada y envía una respuesta
inmediata con el ID de tarea relacionado.
2.
El cliente continuamente envía cheques a un servidor para actualizaciones de estado de la
ID de tarea dada.
3.
Estructura del proyecto:
project
│ package.json
│ index.html
│
├───js
│ main.js
│ jquery-1.12.0.min.js
│
└───srv
│ app.js
├─── models
│ task.js
└─── tasks
data-processor.js
app.js:
var express = require('express');
var app = express();
var http = require('http').Server(app);
var mongoose = require('mongoose');
var bodyParser = require('body-parser');
var childProcess= require('child_process');
var Task = require('./models/task');
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
https://riptutorial.com/es/home 118

-- 146 of 423 --

app.use(express.static(__dirname + '/../'));
app.get('/', function(request, response){
response.render('index.html');
});
//route for the request itself
app.post('/long-running-request', function(request, response){
//create new task item for status tracking
var t = new Task({ status: 'Starting ...' });
t.save(function(err, task){
//create new instance of node for running separate task in another thread
taskProcessor = childProcess.fork('./srv/tasks/data-processor.js');
//process the messages comming from the task processor
taskProcessor.on('message', function(msg){
task.status = msg.status;
task.save();
}.bind(this));
//remove previously openned node instance when we finished
taskProcessor.on('close', function(msg){
this.kill();
});
//send some params to our separate task
var params = {
message: 'Hello from main thread'
};
taskProcessor.send(params);
response.status(200).json(task);
});
});
//route to check is the request is finished the calculations
app.post('/is-ready', function(request, response){
Task
.findById(request.body.id)
.exec(function(err, task){
response.status(200).json(task);
});
});
mongoose.connect('mongodb://localhost/test');
http.listen('1234');
task.js:
var mongoose = require('mongoose');
var taskSchema = mongoose.Schema({
status: {
type: String
}
});
mongoose.model('Task', taskSchema);
https://riptutorial.com/es/home 119

-- 147 of 423 --

module.exports = mongoose.model('Task');
data-processor.js:
process.on('message', function(msg){
init = function(){
processData(msg.message);
}.bind(this)();
function processData(message){
//send status update to the main app
process.send({ status: 'We have started processing your data.' });
//long calculations ..
setTimeout(function(){
process.send({ status: 'Done!' });
//notify node, that we are done with this task
process.disconnect();
}, 5000);
}
});
process.on('uncaughtException',function(err){
console.log("Error happened: " + err.message + "\n" + err.stack + ".\n");
console.log("Gracefully finish the routine.");
});
index.html:
<!DOCTYPE html>
<html>
<head>
<script src="./js/jquery-1.12.0.min.js"></script>
<script src="./js/main.js"></script>
</head>
<body>
<p>Example of processing long-running node requests.</p>
<button id="go" type="button">Run</button>
<br />
<p>Log:</p>
<textarea id="log" rows="20" cols="50"></textarea>
</body>
</html>
main.js:
$(document).on('ready', function(){
$('#go').on('click', function(e){
//clear log
$("#log").val('');
$.post("/long-running-request", {some_params: 'params' })
.done(function(task){
https://riptutorial.com/es/home 120

-- 148 of 423 --

$("#log").val( $("#log").val() + '\n' + task.status);
//function for tracking the status of the task
function updateStatus(){
$.post("/is-ready", {id: task._id })
.done(function(response){
$("#log").val( $("#log").val() + '\n' + response.status);
if(response.status != 'Done!'){
checkTaskTimeout = setTimeout(updateStatus, 500);
}
});
}
//start checking the task
var checkTaskTimeout = setTimeout(updateStatus, 100);
});
});
});
paquete.json:
{
"name": "nodeProcessor",
"dependencies": {
"body-parser": "^1.15.2",
"express": "^4.14.0",
"html": "0.0.10",
"mongoose": "^4.5.5"
}
}
Descargo de responsabilidad: este ejemplo pretende darle una idea básica. Para usarlo en el
entorno de producción, necesita mejoras.
Lea Desafíos de rendimiento en línea: https://riptutorial.com/es/node-js/topic/6325/desafios-de-
rendimiento
https://riptutorial.com/es/home 121

-- 149 of 423 --