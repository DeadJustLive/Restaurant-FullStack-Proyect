# Capítulo 111:: Uso de IISNode para alojar

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 169)

## Contenido
# Capítulo 111:: Uso de IISNode para alojar

aplicaciones web Node.js en IIS
Observaciones
Directorio virtual / Aplicación anidada con
vistas sin errores
Si va a utilizar Express para representar vistas utilizando un motor de visualización, deberá pasar
el valor virtualDirPath a sus vistas.
`res.render('index', { virtualDirPath: virtualDirPath });`
La razón para hacer esto es hacer que sus hipervínculos a otras vistas sean hosteados por su
aplicación y rutas de recursos estáticos para saber dónde se hospeda el sitio sin necesidad de
modificar todas las vistas después de la implementación. Este es uno de los escollos más
molestos y tediosos de usar Directorios Virtuales con IISNode.
Versiones
Todos los ejemplos anteriores trabajan con
Expreso v4.x	•
IIS 7.x / 8.x	•
Socket.io v1.3.x o mayor	•
Examples
Empezando
IISNode permite que las aplicaciones web Node.js se alojen en IIS 7/8 como lo haría una
aplicación .NET. Por supuesto, puede auto hospedar su proceso node.exe en Windows, pero ¿por
qué hacerlo cuando puede ejecutar su aplicación en IIS?
IISNode se encargará de escalar varios núcleos, administrará el proceso de node.exe y reciclará
automáticamente su aplicación IIS cada vez que se actualice su aplicación, solo por mencionar
algunos de sus beneficios .
Requerimientos
https://riptutorial.com/es/home 382

-- 410 of 423 --

IISNode tiene algunos requisitos antes de poder alojar su aplicación Node.js en IIS.
Node.js debe estar instalado en el host IIS, ya sea de 32 bits o de 64 bits, ya sea
compatible.
1.
IISNode instaló x86 o x64 , esto debería coincidir con el bitness de su host IIS.	2.
El módulo Microsoft URL-Rewrite Module para IIS instalado en su host IIS.
Esta es la clave, de lo contrario, las solicitudes a su aplicación Node.js no funcionarán
como se espera.
•
3.
Un Web.config en la carpeta raíz de su aplicación Node.js.	4.
Configuración de IISNode a través de un archivo iisnode.yml o un elemento <iisnode> dentro
de su Web.config .
5.
Ejemplo básico de Hello World usando Express
Para que este ejemplo funcione, deberá crear una aplicación IIS 7/8 en su host IIS y agregar el
directorio que contiene la aplicación web Node.js como el Directorio físico. Asegúrese de que la
identidad de su grupo de aplicaciones / aplicación pueda acceder a la instalación de Node.js. Este
ejemplo utiliza la instalación de 64 bits de Node.js.
Proyecto Strucure
Esta es la estructura básica del proyecto de una aplicación web IISNode / Node.js. Parece casi
idéntico a cualquier aplicación web que no sea IISNode, excepto por la adición de Web.config .
- /app_root
- package.json
- server.js
- Web.config
server.js - Aplicación Express
const express = require('express');
const server = express();
// We need to get the port that IISNode passes into us
// using the PORT environment variable, if it isn't set use a default value
const port = process.env.PORT || 3000;
// Setup a route at the index of our app
server.get('/', (req, res) => {
return res.status(200).send('Hello World');
});
server.listen(port, () => {
console.log(`Listening on ${port}`);
});
https://riptutorial.com/es/home 383

-- 411 of 423 --

Configuración y Web.config
El Web.config es como cualquier otro Web.config IIS, excepto que las dos cosas siguientes deben
estar presentes, URL <rewrite><rules> y un IISNode <handler> . Ambos de estos elementos son
hijos del elemento <system.webServer> .
Configuración
Puede configurar IISNode utilizando un archivo iisnode.yml o agregando el elemento <iisnode>
como un elemento secundario de <system.webServer> en su Web.config . Ambas configuraciones se
pueden usar en conjunto, sin embargo, en este caso, Web.config deberá especificar el archivo
iisnode.yml Y cualquier conflicto de configuración se eliminará del archivo iisnode.yml lugar . Esta
anulación de la configuración no puede suceder al revés.
IISNode Handler
Para que IIS sepa que server.js contiene nuestra aplicación web Node.js, debemos indicarlo
explícitamente. Podemos hacer esto agregando el IISNode <handler> al elemento <handlers> .
<handlers>
<add name="iisnode" path="server.js" verb="*" modules="iisnode"/>
</handlers>
Reglas de reescritura de URL
La parte final de la configuración es garantizar que el tráfico destinado a nuestra aplicación
Node.js que ingresa a nuestra instancia de IIS se dirija a IISNode. Sin las reglas de reescritura de
URL, tendríamos que visitar nuestra aplicación yendo a http://<host>/server.js y, lo que es peor,
al intentar solicitar un recurso proporcionado por server.js obtendrá un 404 . Esta es la razón por
la cual la reescritura de URL es necesaria para las aplicaciones web de IISNode.
<rewrite>
<rules>
<!-- First we consider whether the incoming URL matches a physical file in the /public
folder -->
<rule name="StaticContent" patternSyntax="Wildcard">
<action type="Rewrite" url="public/{R:0}" logRewrittenUrl="true"/>
<conditions>
<add input="{REQUEST_FILENAME}" matchType="IsFile" negate="true"/>
</conditions>
<match url="*.*"/>
</rule>
<!-- All ot
