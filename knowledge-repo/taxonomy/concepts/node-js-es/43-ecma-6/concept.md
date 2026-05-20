# ECMA 6:

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 43)

## Contenido
# ECMA 6:

const user = new User({
name: 'Stack',
password: 'Overflow',
}) ;
user.save((err) => {
if (err) throw err;
console.log('User saved!');
});
ECMA5.1:
var user = new User({
name: 'Stack',
password: 'Overflow',
}) ;
user.save(function (err) {
if (err) throw err;
console.log('User saved!');
});
Leer datos
