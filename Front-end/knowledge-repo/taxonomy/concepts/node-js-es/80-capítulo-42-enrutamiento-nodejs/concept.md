# Capítulo 42:: Enrutamiento NodeJs

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 80)

## Contenido
# Capítulo 42:: Enrutamiento NodeJs

Introducción
Cómo configurar un servidor web Express básico bajo el nodo js y Explorando el enrutador
Express.
Observaciones
Por último, utilizando Express Router puede usar la facilidad de enrutamiento en su aplicación y
es fácil de implementar.
Examples
Enrutamiento de Express Web Server
Creación de Express Web Server
El servidor Express fue práctico y profundiza en muchos usuarios y comunidades. Se está
volviendo popular.
Permite crear un Servidor Express. Para la administración de paquetes y la flexibilidad para la
dependencia utilizaremos NPM (Administrador de paquetes de nodos).
Vaya al directorio Proyecto y cree el archivo package.json. package.json {"name":
"expressRouter", "version": "0.0.1", "scripts": {"start": "node Server.js"}, "dependencies":
{"express": "^ 4.12.3 "}}
1.
Guarde el archivo e instale la dependencia expresa utilizando el siguiente comando npm
install . Esto creará node_modules en su directorio de proyecto junto con la dependencia
requerida.
2.
Vamos a crear Express Web Server. Vaya al directorio Proyecto y cree el archivo server.js.
server.js
var express = require ("express"); var app = express ();
3.
// Creando el objeto Router ()
var router = express.Router ();
// Proporcionar todas las rutas aquí, esto es para la página de inicio.
router.get("/",function(req,res){
res.json({"message" : "Hello World"});
https://riptutorial.com/es/home 149

-- 177 of 423 --

});
app.use ("/ api", enrutador);
// Escucha este puerto
app.listen (3000, function () {console.log ("Live at Port 3000");});
For more detail on setting node server you can see [here][1].
Ejecuta el servidor escribiendo el siguiente comando.
nodo server.js
Si el servidor se ejecuta correctamente, verás algo como esto.
.
4.
Ahora ve al navegador o al cartero y haz una solicitud.
http: // localhost: 3000 / api /
La salida será
5.
https://riptutorial.com/es/home 150

-- 178 of 423 --

.
Eso es todo, lo básico del enrutamiento Express.
Ahora vamos a manejar el GET, POST etc.
Cambiar yous server.js archivo como
var express = require("express");
var app = express();
//Creating Router() object
var router = express.Router();
// Router middleware, mentioned it before defining routes.
router.use(function(req,res,next) {
console.log("/" + req.method);
next();
});
// Provide all routes here, this is for Home page.
router.get("/",function(req,res){
res.json({"message" : "Hello World"});
});
app.use("/api",router);
app.listen(3000,function(){
console.log("Live at Port 3000");
https://riptutorial.com/es/home 151

-- 179 of 423 --

});
Ahora si reinicia el servidor y realiza la solicitud a
http://localhost:3000/api/
Verás algo como
Parámetros de acceso en el enrutamiento
También puede acceder al parámetro desde url, como http://example.com/api/:name/ . Así se
puede acceder al parámetro nombre. Agregue el siguiente código en su server.js
router.get("/user/:id",function(req,res){
res.json({"message" : "Hello "+req.params.id});
});
Ahora reinicie el servidor y vaya a [ http: // localhost: 3000 / api / user / Adem] [4] , la salida será
como
https://riptutorial.com/es/home 152

-- 180 of 423 --

.
Lea Enrutamiento NodeJs en línea: https://riptutorial.com/es/node-js/topic/9846/enrutamiento-
nodejs
https://riptutorial.com/es/home 153

-- 181 of 423 --
