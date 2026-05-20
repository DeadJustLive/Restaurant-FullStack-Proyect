# Capítulo 6:: Asegurando aplicaciones Node.js

Examples
Prevención de falsificación de solicitudes entre sitios (CSRF)
CSRF es un ataque que obliga al usuario final a ejecutar acciones no deseadas en una aplicación
web en la que se autentica actualmente.
Puede suceder porque las cookies se envían con cada solicitud a un sitio web, incluso cuando
esas solicitudes provienen de un sitio diferente.
Podemos usar el módulo csurf para crear el token csrf y validarlo.
Ejemplo
var express = require('express')
var cookieParser = require('cookie-parser') //for cookie parsing
var csrf = require('csurf') //csrf module
var bodyParser = require('body-parser') //for body parsing
// setup route middlewares
var csrfProtection = csrf({ cookie: true })
var parseForm = bodyParser.urlencoded({ extended: false })
// create express app
var app = express()
// parse cookies
app.use(cookieParser())
app.get('/form', csrfProtection, function(req, res) {
// generate and pass the csrfToken to the view
res.render('send', { csrfToken: req.csrfToken() })
})
app.post('/process', parseForm, csrfProtection, function(req, res) {
res.send('data is being processed')
})
Entonces, cuando accedemos a GET /form , pasará el token csrfToken a la vista.
Ahora, dentro de la vista, establezca el valor csrfToken como el valor de un campo de entrada
oculto llamado _csrf .
por ejemplo, para plantillas de handlebar
<form action="/process" method="POST">
<input type="hidden" name="_csrf" value="{{csrfToken}}">
Name: <input type="text" name="name">
<button type="submit">Submit</button>
</form>
https://riptutorial.com/es/home 46

-- 74 of 423 --

por ejemplo, para plantillas de jade
form(action="/process" method="post")
input(type="hidden", name="_csrf", value=csrfToken)
span Name:
input(type="text", name="name", required=true)
br
input(type="submit")
por ejemplo, para plantillas ejs
<form action="/process" method="POST">
<input type="hidden" name="_csrf" value="<%= csrfToken %>">
Name: <input type="text" name="name">
<button type="submit">Submit</button>
</form>
SSL / TLS en Node.js
Si elige manejar SSL / TLS en su aplicación Node.js, considere que también es responsable de
mantener la prevención de ataques SSL / TLS en este momento. En muchas arquitecturas
servidor-cliente, SSL / TLS termina en un proxy inverso, tanto para reducir la complejidad de la
aplicación como para reducir el alcance de la configuración de seguridad.
Si su aplicación Node.js debe manejar SSL / TLS, se puede proteger cargando los archivos de
clave y certificado.
Si su proveedor de certificados requiere una cadena de autoridad de certificados (CA), se puede
agregar en la opción ca como una matriz. Una cadena con varias entradas en un solo archivo se
debe dividir en varios archivos y se debe ingresar en el mismo orden en la matriz, ya que Node.js
actualmente no admite varias entradas de CA en un archivo. Se proporciona un ejemplo en el
siguiente código para los archivos 1_ca.crt y 2_ca.crt . Si la matriz de ca es requerida y no está
configurada correctamente, los navegadores de los clientes pueden mostrar mensajes que no
pudieron verificar la autenticidad del certificado.
Ejemplo
const https = require('https');
const fs = require('fs');
const options = {
key: fs.readFileSync('privatekey.pem'),
cert: fs.readFileSync('certificate.pem'),
ca: [fs.readFileSync('1_ca.crt'), fs.readFileSync('2_ca.crt')]
};
https.createServer(options, (req, res) => {
res.writeHead(200);
res.end('hello world\n');
}).listen(8000);
https://riptutorial.com/es/home 47

-- 75 of 423 --

Utilizando HTTPS
La configuración mínima para un servidor HTTPS en Node.js sería algo como esto:
const https = require('https');
const fs = require('fs');
const httpsOptions = {
key: fs.readFileSync('path/to/server-key.pem'),
cert: fs.readFileSync('path/to/server-crt.pem')
};
const app = function (req, res) {
res.writeHead(200);
res.end("hello world\n");
}
https.createServer(httpsOptions, app).listen(4433);
Si también desea admitir solicitudes http, solo necesita hacer una pequeña modificación:
const http = require('http');
const https = require('https');
const fs = require('fs');
const httpsOptions = {
key: fs.readFileSync('path/to/server-key.pem'),
cert: fs.readFileSync('path/to/server-crt.pem')
};
const app = function (req, res) {
res.writeHead(200);
res.end("hello world\n");
}
http.createServer(app).listen(8888);
https.createServer(httpsOptions, app).listen(4433);
Configurando un servidor HTTPS
Una vez que tenga node.js instalado en su sistema, simplemente siga el procedimiento a
continuación para que un servidor web básico se ejecute con soporte para HTTP y HTTPS.
Paso 1: Construir una Autoridad de Certificación
cree la carpeta donde desea almacenar su clave y certificado:
mkdir conf
1.
ir a ese directorio:
cd conf
2.
https://riptutorial.com/es/home 48

-- 76 of 423 --

tome este archivo ca.cnf para usarlo como acceso directo de configuración:
wget https://raw.githubusercontent.com/anders94/https-authorized-clients/master/keys/ca.cnf
3.
crear una nueva autoridad de certificación utilizando esta configuración:
openssl req -new -x509 -days 9999 -config ca.cnf -keyout ca-key.pem -out ca-cert.pem
4.
Ahora que tenemos nuestra autoridad de certificación en ca-key.pem y ca-cert.pem ,
generemos una clave privada para el servidor:
openssl genrsa -out key.pem 4096
5.
tome este archivo server.cnf para usarlo como acceso directo de configuración:
wget https://raw.githubusercontent.com/anders94/https-authorized-
clients/master/keys/server.cnf
6.
generar la solicitud de firma de certificado utilizando esta configuración:
openssl req -new -config server.cnf -key key.pem -out csr.pem
7.
firmar la solicitud:
openssl x509 -req -extfile server.cnf -days 999 -passin "pass:password" -in csr.pem -CA ca-
cert.pem -CAkey ca-key.pem -CAcreateserial -out cert.pem
8.
Paso 2: instale su certificado como certificado raíz
Copie su certificado a la carpeta de sus certificados raíz:
sudo cp ca-crt.pem /usr/local/share/ca-certificates/ca-crt.pem
1.
actualizar la tienda de CA:
sudo update-ca-certificates
2.
Asegurar la aplicación express.js 3
La configuración para realizar una conexión segura utilizando express.js (desde la versión 3):
var fs = require('fs');
var http = require('http');
var https = require('https');
var privateKey = fs.readFileSync('sslcert/server.key', 'utf8');
var certificate = fs.readFileSync('sslcert/server.crt', 'utf8');
// Define your key and cert
https://riptutorial.com/es/home 49

-- 77 of 423 --

var credentials = {key: privateKey, cert: certificate};
var express = require('express');
var app = express();
// your express configuration here
var httpServer = http.createServer(app);
var httpsServer = https.createServer(credentials, app);
// Using port 8080 for http and 8443 for https
httpServer.listen(8080);
httpsServer.listen(8443);
De esa manera, proporciona middleware expreso al servidor http / https nativo
Si desea que su aplicación se ejecute en puertos por debajo de 1024, deberá usar el comando
sudo (no recomendado) o usar un proxy inverso (por ejemplo, nginx, haproxy).
Lea Asegurando aplicaciones Node.js en línea: https://riptutorial.com/es/node-
js/topic/3473/asegurando-aplicaciones-node-js
https://riptutorial.com/es/home 50

-- 78 of 423 --