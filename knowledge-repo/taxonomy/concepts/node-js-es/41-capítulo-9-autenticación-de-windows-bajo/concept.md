# Capítulo 9:: Autenticación de Windows bajo

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 41)

## Contenido
# Capítulo 9:: Autenticación de Windows bajo

node.js
Observaciones
Hay varios otros APIS de Active Directory, como activedirectory2 y adldap .
Examples
Usando activedirectory
El siguiente ejemplo está tomado de los documentos completos, disponibles aquí (GitHub) o aquí
(NPM) .
Instalación
npm install --save activedirectory
Uso
// Initialize
var ActiveDirectory = require('activedirectory');
var config = {
url: 'ldap://dc.domain.com',
baseDN: 'dc=domain,dc=com'
};
var ad = new ActiveDirectory(config);
var username = 'john.smith@domain.com';
var password = 'password';
// Authenticate
ad.authenticate(username, password, function(err, auth) {
if (err) {
console.log('ERROR: '+JSON.stringify(err));
return;
}
if (auth) {
console.log('Authenticated!');
}
else {
console.log('Authentication failed!');
}
});
Lea Autenticación de Windows bajo node.js en línea: https://riptutorial.com/es/node-
js/topic/10612/autenticacion-de-windows-bajo-node-js
https://riptutorial.com/es/home 61

-- 89 of 423 --
