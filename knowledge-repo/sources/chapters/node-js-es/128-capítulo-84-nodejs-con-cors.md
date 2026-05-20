# Capítulo 84:: Node.js con CORS

Examples
Habilitar CORS en express.js
Como node.js se usa a menudo para crear API, la configuración CORS adecuada puede ser un
salvavidas si desea poder solicitar la API desde diferentes dominios.
En el ejemplo, lo configuraremos para una configuración más amplia (autorizaremos todos los
tipos de solicitud desde cualquier dominio.
En su server.js después de inicializar express:
// Create express server
const app = express();
app.use((req, res, next) => {
res.header('Access-Control-Allow-Origin', '*');
// authorized headers for preflight requests
// https://developer.mozilla.org/en-US/docs/Glossary/preflight_request
res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type,
Accept');
next();
app.options('*', (req, res) => {
// allowed XHR methods
res.header('Access-Control-Allow-Methods', 'GET, PATCH, PUT, POST, DELETE, OPTIONS');
res.send();
});
});
Generalmente, el nodo se ejecuta detrás de un proxy en servidores de producción. Por lo tanto, el
servidor proxy inverso (como Apache o Nginx) será responsable de la configuración de CORS.
Para adaptar convenientemente este escenario, es posible habilitar solo el nodo.js CORS cuando
está en desarrollo.
Esto se hace fácilmente marcando NODE_ENV :
const app = express();
if (process.env.NODE_ENV === 'development') {
// CORS settings
}
Lea Node.js con CORS en línea: https://riptutorial.com/es/node-js/topic/9272/node-js-con-cors
https://riptutorial.com/es/home 270

-- 298 of 423 --