# Capítulo 78:: Marcos de pruebas unitarias

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 122)

## Contenido
# Capítulo 78:: Marcos de pruebas unitarias

Examples
Moca síncrona
describe('Suite Name', function() {
describe('#method()', function() {
it('should run without an error', function() {
expect([ 1, 2, 3 ].length).to.be.equal(3)
})
})
})
Mocha asíncrono (callback)
var expect = require("chai").expect;
describe('Suite Name', function() {
describe('#method()', function() {
it('should run without an error', function(done) {
testSomething(err => {
expect(err).to.not.be.equal(null)
done()
})
})
})
})
Mocha asíncrona (Promesa)
describe('Suite Name', function() {
describe('#method()', function() {
it('should run without an error', function() {
return doSomething().then(result => {
expect(result).to.be.equal('hello world')
})
})
})
})
Mocha Asíncrono (asíncrono / await)
const { expect } = require('chai')
describe('Suite Name', function() {
describe('#method()', function() {
it('should run without an error', async function() {
const result = await answerToTheUltimateQuestion()
expect(result).to.be.equal(42)
})
})
https://riptutorial.com/es/home 254

-- 282 of 423 --

})
Lea Marcos de pruebas unitarias en línea: https://riptutorial.com/es/node-js/topic/6731/marcos-de-
pruebas-unitarias
https://riptutorial.com/es/home 255

-- 283 of 423 --
