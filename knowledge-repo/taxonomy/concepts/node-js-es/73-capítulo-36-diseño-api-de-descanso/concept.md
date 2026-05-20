# Capítulo 36:: Diseño API de descanso:

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 73)

## Contenido
# Capítulo 36:: Diseño API de descanso:

Mejores prácticas
Examples
Manejo de errores: OBTENER todos los recursos
¿Cómo maneja los errores, en lugar de registrarlos en la consola?
Mal camino:
Router.route('/')
.get((req, res) => {
Request.find((err, r) => {
if(err){
console.log(err)
} else {
res.json(r)
}
})
})
.post((req, res) => {
const request = new Request({
type: req.body.type,
info: req.body.info
});
request.info.user = req.user._id;
console.log("ABOUT TO SAVE REQUEST", request);
request.save((err, r) => {
if (err) {
res.json({ message: 'there was an error saving your r' });
} else {
res.json(r);
}
});
});
Mejor manera:
Router.route('/')
.get((req, res) => {
Request.find((err, r) => {
if(err){
console.log(err)
} else {
return next(err)
}
})
})
.post((req, res) => {
const request = new Request({
type: req.body.type,
info: req.body.info
https://riptutorial.com/es/home 133

-- 161 of 423 --

});
request.info.user = req.user._id;
console.log("ABOUT TO SAVE REQUEST", request);
request.save((err, r) => {
if (err) {
return next(err)
} else {
res.json(r);
}
});
});
Lea Diseño API de descanso: Mejores prácticas en línea: https://riptutorial.com/es/node-
js/topic/6490/diseno-api-de-descanso--mejores-practicas
https://riptutorial.com/es/home 134

-- 162 of 423 --
