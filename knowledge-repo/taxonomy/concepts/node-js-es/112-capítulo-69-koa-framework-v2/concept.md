# Capítulo 69:: Koa Framework v2

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 112)

## Contenido
# Capítulo 69:: Koa Framework v2

Examples
Hola mundo ejemplo
const Koa = require('koa')
const app = new Koa()
app.use(async ctx => {
ctx.body = 'Hello World'
})
app.listen(8080)
Manejo de errores utilizando middleware.
app.use(async (ctx, next) => {
try {
await next() // attempt to invoke the next middleware downstream
} catch (err) {
handleError(err, ctx) // define your own error handling function
}
})
Lea Koa Framework v2 en línea: https://riptutorial.com/es/node-js/topic/6730/koa-framework-v2
https://riptutorial.com/es/home 234

-- 262 of 423 --
