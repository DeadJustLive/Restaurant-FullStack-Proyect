# Capítulo 58:: http

Examples
servidor http
Un ejemplo básico de servidor HTTP.
escriba el siguiente código en el archivo http_server.js:
var http = require('http');
var httpPort = 80;
http.createServer(handler).listen(httpPort, start_callback);
function handler(req, res) {
var clientIP = req.connection.remoteAddress;
var connectUsing = req.connection.encrypted ? 'SSL' : 'HTTP';
console.log('Request received: '+ connectUsing + ' ' + req.method + ' ' + req.url);
console.log('Client IP: ' + clientIP);
res.writeHead(200, "OK", {'Content-Type': 'text/plain'});
res.write("OK");
res.end();
return;
}
function start_callback(){
console.log('Start HTTP on port ' + httpPort)
}
luego desde su ubicación http_server.js ejecute este comando:
node http_server.js
Deberías ver este resultado:
> Start HTTP on port 80
ahora necesita probar su servidor, necesita abrir su navegador de internet y navegar a este url:
http://127.0.0.1:80
Si su máquina está ejecutando un servidor Linux, puede probarla así:
curl 127.0.0.1:80
Deberías ver el siguiente resultado:
https://riptutorial.com/es/home 196

-- 224 of 423 --

ok
En su consola, que al ejecutar la aplicación, verá estos resultados:
> Request received: HTTP GET /
> Client IP: ::ffff:127.0.0.1
cliente http
Un ejemplo básico para el cliente http:
escriba el siguiente código en el archivo http_client.js:
var http = require('http');
var options = {
hostname: '127.0.0.1',
port: 80,
path: '/',
method: 'GET'
};
var req = http.request(options, function(res) {
console.log('STATUS: ' + res.statusCode);
console.log('HEADERS: ' + JSON.stringify(res.headers));
res.setEncoding('utf8');
res.on('data', function (chunk) {
console.log('Response: ' + chunk);
});
res.on('end', function (chunk) {
console.log('Response ENDED');
});
});
req.on('error', function(e) {
console.log('problem with request: ' + e.message);
});
req.end();
luego desde su ubicación http_client.js ejecute este comando:
node http_client.js
Deberías ver este resultado:
> STATUS: 200
> HEADERS: {"content-type":"text/plain","date":"Thu, 21 Jul 2016 11:27:17
GMT","connection":"close","transfer-encoding":"chunked"}
> Response: OK
> Response ENDED
nota: este ejemplo depende del ejemplo del servidor http.
https://riptutorial.com/es/home 197

-- 225 of 423 --

Lea http en línea: https://riptutorial.com/es/node-js/topic/2973/http
https://riptutorial.com/es/home 198

-- 226 of 423 --