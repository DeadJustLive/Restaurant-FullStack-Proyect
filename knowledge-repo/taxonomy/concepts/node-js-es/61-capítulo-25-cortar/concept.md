# Capítulo 25:: Cortar

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 61)

## Contenido
# Capítulo 25:: Cortar

Examples
Añadir nuevas extensiones para requerir ()
Puede agregar nuevas extensiones a require() extendiendo require.extensions .
Para un ejemplo de XML :
// Add .xml for require()
require.extensions['.xml'] = (module, filename) => {
const fs = require('fs')
const xml2js = require('xml2js')
module.exports = (callback) => {
// Read required file.
fs.readFile(filename, 'utf8', (err, data) => {
if (err) {
callback(err)
return
}
// Parse it.
xml2js.parseString(data, (err, result) => {
callback(null, result)
})
})
}
}
Si el contenido de hello.xml es el siguiente:
<?xml version="1.0" encoding="UTF-8"?>
<foo>
<bar>baz</bar>
<qux />
</foo>
Puedes leerlo y analizarlo a través de require() :
require('./hello')((err, xml) {
if (err)
throw err;
console.log(err);
})
Imprime { foo: { bar: [ 'baz' ], qux: [ '' ] } } .
Lea Cortar en línea: https://riptutorial.com/es/node-js/topic/6645/cortar
https://riptutorial.com/es/home 105

-- 133 of 423 --
