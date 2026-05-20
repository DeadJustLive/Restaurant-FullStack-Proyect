# Módulo d: e ejemplo y programa correspondiente usando Bluebird

math.js
'use strict';
const Promise = require('bluebird');
module.exports = {
// example of a callback-only method
callbackSum: function(a, b, callback) {
if (typeof a !== 'number')
return callback(new Error('"a" must be a number'));
if (typeof b !== 'number')
return callback(new Error('"b" must be a number'));
return callback(null, a + b);
},
// example of a promise-only method
promiseSum: function(a, b) {
return new Promise(function(resolve, reject) {
if (typeof a !== 'number')
return reject(new Error('"a" must be a number'));
if (typeof b !== 'number')
return reject(new Error('"b" must be a number'));
resolve(a + b);
});
},
// a method that can be used as a promise or with callbacks
sum: function(a, b, callback) {
return new Promise(function(resolve, reject) {
if (typeof a !== 'number')
return reject(new Error('"a" must be a number'));
https://riptutorial.com/es/home 106

-- 134 of 423 --

if (typeof b !== 'number')
return reject(new Error('"b" must be a number'));
resolve(a + b);
}).asCallback(callback);
},
};
index.js
'use strict';
const math = require('./math');
// classic callbacks
math.callbackSum(1, 3, function(err, result) {
if (err)
console.log('Test 1: ' + err);
else
console.log('Test 1: the answer is ' + result);
});
math.callbackSum(1, 'd', function(err, result) {
if (err)
console.log('Test 2: ' + err);
else
console.log('Test 2: the answer is ' + result);
});
// promises
math.promiseSum(2, 5)
.then(function(result) {
console.log('Test 3: the answer is ' + result);
})
.catch(function(err) {
console.log('Test 3: ' + err);
});
math.promiseSum(1)
.then(function(result) {
console.log('Test 4: the answer is ' + result);
})
.catch(function(err) {
console.log('Test 4: ' + err);
});
// promise/callback method used like a promise
math.sum(8, 2)
.then(function(result) {
console.log('Test 5: the answer is ' + result);
})
.catch(function(err) {
console.log('Test 5: ' + err);
});
https://riptutorial.com/es/home 107

-- 135 of 423 --

// promise/callback method used with callbacks
math.sum(7, 11, function(err, result) {
if (err)
console.log('Test 6: ' + err);
else
console.log('Test 6: the answer is ' + result);
});
// promise/callback method used like a promise with async/await syntax
(async () => {
try {
let x = await math.sum(6, 3);
console.log('Test 7a: ' + x);
let y = await math.sum(4, 's');
console.log('Test 7b: ' + y);
} catch(err) {
console.log(err.message);
}
})();
Lea Creación de una biblioteca Node.js que admita tanto las promesas como las devoluciones de
llamada de error primero en línea: https://riptutorial.com/es/node-js/topic/9874/creacion-de-una-
biblioteca-node-js-que-admita-tanto-las-promesas-como-las-devoluciones-de-llamada-de-error-
primero
https://riptutorial.com/es/home 108

-- 136 of 423 --