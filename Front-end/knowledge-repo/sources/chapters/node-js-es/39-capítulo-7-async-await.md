# Capítulo 7:: Async / Await

Introducción
Async / await es un conjunto de palabras clave que permite escribir código asíncrono de manera
procesal sin tener que depender de devoluciones de llamada ( infierno de devolución de llamada )
o encadenamiento de promesa ( .then().then().then() ).
Esto funciona utilizando la palabra clave await para suspender el estado de una función
asíncrona, hasta la resolución de una promesa, y usando la palabra clave async para declarar
tales funciones asíncronas, que devuelven una promesa.
Async / await está disponible desde node.js 8 por defecto o 7 usando la bandera --harmony-async-
await .
Examples
Funciones asíncronas con el manejo de errores Try-Catch
Una de las mejores características de la sintaxis de async / await es que es posible el estilo de
codificación try-catch estándar, como si estuviera escribiendo código síncrono.
const myFunc = async (req, res) => {
try {
const result = await somePromise();
} catch (err) {
// handle errors here
}
});
Aquí hay un ejemplo con Express y promise-mysql:
router.get('/flags/:id', async (req, res) => {
try {
const connection = await pool.createConnection();
try {
const sql = `SELECT f.id, f.width, f.height, f.code, f.filename
FROM flags f
WHERE f.id = ?
LIMIT 1`;
const flags = await connection.query(sql, req.params.id);
if (flags.length === 0)
return res.status(404).send({ message: 'flag not found' });
return res.send({ flags[0] });
} finally {
https://riptutorial.com/es/home 51

-- 79 of 423 --

pool.releaseConnection(connection);
}
} catch (err) {
// handle errors here
}
});
Comparación entre Promesas y Async / Await
Función mediante promesas:
function myAsyncFunction() {
return aFunctionThatReturnsAPromise()
// doSomething is a sync function
.then(result => doSomething(result))
.catch(handleError);
}
Así que aquí es cuando Async / Await entra en acción para limpiar nuestra función:
async function myAsyncFunction() {
let result;
try {
result = await aFunctionThatReturnsAPromise();
} catch (error) {
handleError(error);
}
// doSomething is a sync function
return doSomething(result);
}
Entonces, la palabra clave async sería similar a escribir return new Promise((resolve, reject) =>
{...} .
Y await similar para obtener el resultado en then de devolución de llamada.
Aquí les dejo un gif bastante breve que no dejará ninguna duda en mente después de verlo:
GIF
Progresión de devoluciones de llamada
Al principio había devoluciones de llamada, y las devoluciones de llamada estaban bien:
const getTemperature = (callback) => {
http.get('www.temperature.com/current', (res) => {
callback(res.data.temperature)
})
}
const getAirPollution = (callback) => {
https://riptutorial.com/es/home 52

-- 80 of 423 --

http.get('www.pollution.com/current', (res) => {
callback(res.data.pollution)
});
}
getTemperature(function(temp) {
getAirPollution(function(pollution) {
console.log(`the temp is ${temp} and the pollution is ${pollution}.`)
// The temp is 27 and the pollution is 0.5.
})
})
Pero hubo algunos problemas realmente frustrantes con las devoluciones de llamada, por lo que
todos empezamos a usar promesas.
const getTemperature = () => {
return new Promise((resolve, reject) => {
http.get('www.temperature.com/current', (res) => {
resolve(res.data.temperature)
})
})
}
const getAirPollution = () => {
return new Promise((resolve, reject) => {
http.get('www.pollution.com/current', (res) => {
resolve(res.data.pollution)
})
})
}
getTemperature()
.then(temp => console.log(`the temp is ${temp}`))
.then(() => getAirPollution())
.then(pollution => console.log(`and the pollution is ${pollution}`))
// the temp is 32
// and the pollution is 0.5
Esto fue un poco mejor Finalmente, encontramos async / await. Que todavía utiliza promesas bajo
el capó.
const temp = await getTemperature()
const pollution = await getAirPollution()
Detiene la ejecución en espera
Si la promesa no devuelve nada, la tarea asíncrona se puede completar con await .
try{
await User.findByIdAndUpdate(user._id, {
$push: {
tokens: token
}
}).exec()
}catch(e){
handleError(e)
https://riptutorial.com/es/home 53

-- 81 of 423 --

}
Lea Async / Await en línea: https://riptutorial.com/es/node-js/topic/6729/async---await
https://riptutorial.com/es/home 54

-- 82 of 423 --