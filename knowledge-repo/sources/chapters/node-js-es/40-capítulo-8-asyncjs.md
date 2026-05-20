# Capítulo 8:: async.js

Sintaxis
Cada devolución de llamada debe escribirse con esta sintaxis:	•
función de devolución de llamada (err, result [, arg1 [, ...]])	•
De esta manera, se ve obligado a devolver el error primero y no puede ignorar el
manejo de ellos más adelante. null es la convención en ausencia de errores.
•
devolución de llamada (null, myResult);	•
Sus devoluciones de llamada pueden contener más argumentos que error y resultado
, pero es útil solo para un conjunto específico de funciones (cascada, seq, ...)
•
devolución de llamada (null, myResult, myCustomArgument);	•
Y, por supuesto, enviar errores. Debe hacerlo y manejar los errores (o al menos
registrarlos).
•
devolución de llamada (err);	•
Examples
Paralelo: multitarea
async.parallel (tareas, afterTasksCallback) ejecutará un conjunto de tareas en paralelo y
esperará el final de todas las tareas (informadas por la función de llamada de devolución de
llamada ).
Cuando finalizan las tareas, async llama a la devolución de llamada principal con todos los
errores y todos los resultados de las tareas.
function shortTimeFunction(callback) {
setTimeout(function() {
callback(null, 'resultOfShortTime');
}, 200);
}
function mediumTimeFunction(callback) {
setTimeout(function() {
callback(null, 'resultOfMediumTime');
}, 500);
}
function longTimeFunction(callback) {
setTimeout(function() {
callback(null, 'resultOfLongTime');
}, 1000);
https://riptutorial.com/es/home 55

-- 83 of 423 --

}
async.parallel([
shortTimeFunction,
mediumTimeFunction,
longTimeFunction
],
function(err, results) {
if (err) {
return console.error(err);
}
console.log(results);
});
Resultado: ["resultOfShortTime", "resultOfMediumTime", "resultOfLongTime"] .
Llame a async.parallel() con un objeto
Puede reemplazar el parámetro de matriz de tareas por un objeto. En este caso, los resultados
también serán un objeto con las mismas claves que las tareas .
Es muy útil para calcular algunas tareas y encontrar fácilmente cada resultado.
async.parallel({
short: shortTimeFunction,
medium: mediumTimeFunction,
long: longTimeFunction
},
function(err, results) {
if (err) {
return console.error(err);
}
console.log(results);
});
Resultado: {short: "resultOfShortTime", medium: "resultOfMediumTime", long: "resultOfLongTime"}
.
Resolviendo múltiples valores
Cada función paralela se pasa una devolución de llamada. Esta devolución de llamada puede
devolver un error como primer argumento o valores de éxito después de eso. Si se pasa una
devolución de llamada de varios valores de éxito, estos resultados se devuelven como una matriz.
async.parallel({
short: function shortTimeFunction(callback) {
setTimeout(function() {
callback(null, 'resultOfShortTime1', 'resultOfShortTime2');
}, 200);
https://riptutorial.com/es/home 56

-- 84 of 423 --

},
medium: function mediumTimeFunction(callback) {
setTimeout(function() {
callback(null, 'resultOfMediumTime1', 'resultOfMeiumTime2');
}, 500);
}
},
function(err, results) {
if (err) {
return console.error(err);
}
console.log(results);
});
Resultado:
{
short: ["resultOfShortTime1", "resultOfShortTime2"],
medium: ["resultOfMediumTime1", "resultOfMediumTime2"]
}
.
Serie: mono-tarea independiente
async.series (tareas, afterTasksCallback) ejecutará un conjunto de tareas. Cada tarea se ejecuta
tras otra . Si una tarea falla, async detiene inmediatamente la ejecución y salta a la
devolución de llamada principal .
Cuando las tareas se completan correctamente, async llama a la devolución de llamada "maestra"
con todos los errores y todos los resultados de las tareas.
function shortTimeFunction(callback) {
setTimeout(function() {
callback(null, 'resultOfShortTime');
}, 200);
}
function mediumTimeFunction(callback) {
setTimeout(function() {
callback(null, 'resultOfMediumTime');
}, 500);
}
function longTimeFunction(callback) {
setTimeout(function() {
callback(null, 'resultOfLongTime');
}, 1000);
}
async.series([
mediumTimeFunction,
shortTimeFunction,
longTimeFunction
],
https://riptutorial.com/es/home 57

-- 85 of 423 --

function(err, results) {
if (err) {
return console.error(err);
}
console.log(results);
});
Resultado: ["resultOfMediumTime", "resultOfShortTime", "resultOfLongTime"] .
Llame a async.series() con un objeto
Puede reemplazar el parámetro de matriz de tareas por un objeto. En este caso, los resultados
también serán un objeto con las mismas claves que las tareas .
Es muy útil para calcular algunas tareas y encontrar fácilmente cada resultado.
async.series({
short: shortTimeFunction,
medium: mediumTimeFunction,
long: longTimeFunction
},
function(err, results) {
if (err) {
return console.error(err);
}
console.log(results);
});
Resultado: {short: "resultOfShortTime", medium: "resultOfMediumTime", long: "resultOfLongTime"}
.
Cascada: mono-tarea dependiente
async.waterfall (tareas, afterTasksCallback) ejecutará un conjunto de tareas. Cada tarea se
ejecuta después de otra, y el resultado de una tarea se pasa a la siguiente tarea . Como
async.series () , si una tarea falla, async detiene la ejecución y llama inmediatamente a la
devolución de llamada principal.
Cuando las tareas se completan correctamente, async llama a la devolución de llamada "maestra"
con todos los errores y todos los resultados de las tareas.
function getUserRequest(callback) {
// We simulate the request with a timeout
setTimeout(function() {
var userResult = {
name : 'Aamu'
};
callback(null, userResult);
}, 500);
https://riptutorial.com/es/home 58

-- 86 of 423 --

}
function getUserFriendsRequest(user, callback) {
// Another request simulate with a timeout
setTimeout(function() {
var friendsResult = [];
if (user.name === "Aamu"){
friendsResult = [{
name : 'Alice'
}, {
name: 'Bob'
}];
}
callback(null, friendsResult);
}, 500);
}
async.waterfall([
getUserRequest,
getUserFriendsRequest
],
function(err, results) {
if (err) {
return console.error(err);
}
console.log(JSON.stringify(results));
});
Resultado: los results contienen el segundo parámetro de devolución de llamada de la última
función de la cascada, que es friendsResult en ese caso.
async.times (para manejar el bucle de una manera mejor)
Para ejecutar una función dentro de un bucle en Node.js, está bien usar una for bucle de bucles
cortos. Pero el bucle es largo, usar for bucle aumentará el tiempo de procesamiento, lo que
podría hacer que el proceso del nodo se bloquee. En tales escenarios, puede usar: asycn.times
function recursiveAction(n, callback)
{
//do whatever want to do repeatedly
callback(err, result);
}
async.times(5, function(n, next) {
recursiveAction(n, function(err, result) {
next(err, result);
});
}, function(err, results) {
// we should now have 5 result
});
Esto se llama en paralelo. Cuando queremos llamarlo uno a la vez, use: async.timesSeries
async.each (Para manejar la matriz de datos de manera eficiente)
https://riptutorial.com/es/home 59

-- 87 of 423 --

Cuando queremos manejar una matriz de datos, es mejor usar async.each . Cuando queremos
realizar algo con todos los datos y queremos obtener la devolución de llamada final una vez que
todo está hecho, entonces este método será útil. Esto se maneja de forma paralela.
function createUser(userName, callback)
{
//create user in db
callback(null)//or error based on creation
}
var arrayOfData = ['Ritu', 'Sid', 'Tom'];
async.each(arrayOfData, function(eachUserName, callback) {
// Perform operation on each user.
console.log('Creating user '+eachUserName);
//Returning callback is must. Else it wont get the final callback, even if we miss to
return one callback
createUser(eachUserName, callback);
}, function(err) {
//If any of the user creation failed may throw error.
if( err ) {
// One of the iterations produced an error.
// All processing will now stop.
console.log('unable to create user');
} else {
console.log('All user created successfully');
}
});
Para hacer uno a la vez puede usar async.eachSeries
async.series (Para manejar eventos uno por uno)
/ En async.series, todas las funciones se ejecutan en serie y las salidas consolidadas de cada
función se pasan a la devolución de llamada final. por ejemplo
var async = require ('async'); async.series ([function (callback) {console.log ('First Execute ..');
callback (null, 'userPersonalData');}, function (callback) {console.log ('Second Execute ..');
devolución de llamada (null, 'userDependentData');}], función (err, resultado) {console.log
(resultado);});
//Salida:
Primera ejecución ... Segunda ejecución ... ['userPersonalData', 'userDependentData'] // resultado
Lea async.js en línea: https://riptutorial.com/es/node-js/topic/3972/async-js
https://riptutorial.com/es/home 60

-- 88 of 423 --