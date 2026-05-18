# Capítulo 15:: Casos de uso de Node.js

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 49)

## Contenido
# Capítulo 15:: Casos de uso de Node.js

Examples
Servidor HTTP
const http = require('http');
console.log('Starting server...');
var config = {
port: 80,
contentType: 'application/json; charset=utf-8'
};
// JSON-API server on port 80
var server = http.createServer();
server.listen(config.port);
server.on('error', (err) => {
if (err.code == 'EADDRINUSE') console.error('Port '+ config.port +' is already in use');
else console.error(err.message);
});
server.on('request', (request, res) => {
var remoteAddress = request.headers['x-forwarded-for'] ||
request.connection.remoteAddress; // Client address
console.log(remoteAddress +' '+ request.method +' '+ request.url);
var out = {};
// Here you can change output according to `request.url`
out.test = request.url;
res.writeHead(200, {
'Content-Type': config.contentType
});
res.end(JSON.stringify(out));
});
server.on('listening', () => {
c.info('Server is available: http://localhost:'+ config.port);
});
Consola con el símbolo del sistema
const process = require('process');
const rl = require('readline').createInterface(process.stdin, process.stdout);
rl.pause();
console.log('Something long is happening here...');
var cliConfig = {
promptPrefix: ' > '
}
/*
Commands recognition
