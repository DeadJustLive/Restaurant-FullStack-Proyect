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
<!-- All other URLs are mapped to the Node.js application entry point -->
<rule name="DynamicContent">
<conditions>
<add input="{REQUEST_FILENAME}" matchType="IsFile" negate="True"/>
</conditions>
https://riptutorial.com/es/home 384

-- 412 of 423 --

<action type="Rewrite" url="server.js"/>
</rule>
</rules>
</rewrite>
Este es un archivo Web.config trabajo para este ejemplo , configuración para una instalación de
Node.js de 64 bits.
Eso es todo, ahora visite su sitio IIS y vea cómo funciona su aplicación Node.js.
Uso de un directorio virtual de IIS o una aplicación anidada a través de
El uso de un directorio virtual o una aplicación anidada en IIS es un escenario común y muy
probablemente el que querrá aprovechar al usar IISNode.
IISNode no proporciona soporte directo para directorios virtuales o aplicaciones anidadas a través
de la configuración, por lo que para lograrlo, deberemos aprovechar una característica de IISNode
que no forma parte de la configuración y es mucho menos conocida. Todos los elementos
<appSettings> elemento <appSettings> con Web.config se agregan al objeto process.env como
propiedades mediante la clave appSetting.
Permite crear un directorio virtual en nuestros <appSettings>
<appSettings>
<add key="virtualDirPath" value="/foo" />
</appSettings>
Dentro de nuestra aplicación Node.js podemos acceder a la configuración virtualDirPath
console.log(process.env.virtualDirPath); // prints /foo
Ahora que podemos usar el elemento <appSettings> para la configuración, aprovechemos eso y lo
usemos en nuestro código de servidor.
// Access the virtualDirPath appSettings and give it a default value of '/'
// in the event that it doesn't exist or isn't set
var virtualDirPath = process.env.virtualDirPath || '/';
// We also want to make sure that our virtualDirPath
// always starts with a forward slash
if (!virtualDirPath.startsWith('/', 0))
virtualDirPath = '/' + virtualDirPath;
// Setup a route at the index of our app
server.get(virtualDirPath, (req, res) => {
return res.status(200).send('Hello World');
});
Podemos usar virtualDirPath con nuestros recursos estáticos también
https://riptutorial.com/es/home 385

-- 413 of 423 --

// Public Directory
server.use(express.static(path.join(virtualDirPath, 'public')));
// Bower
server.use('/bower_components', express.static(path.join(virtualDirPath,
'bower_components')));
Vamos a poner todo eso juntos
const express = require('express');
const server = express();
const port = process.env.PORT || 3000;
// Access the virtualDirPath appSettings and give it a default value of '/'
// in the event that it doesn't exist or isn't set
var virtualDirPath = process.env.virtualDirPath || '/';
// We also want to make sure that our virtualDirPath
// always starts with a forward slash
if (!virtualDirPath.startsWith('/', 0))
virtualDirPath = '/' + virtualDirPath;
// Public Directory
server.use(express.static(path.join(virtualDirPath, 'public')));
// Bower
server.use('/bower_components', express.static(path.join(virtualDirPath,
'bower_components')));
// Setup a route at the index of our app
server.get(virtualDirPath, (req, res) => {
return res.status(200).send('Hello World');
});
server.listen(port, () => {
console.log(`Listening on ${port}`);
});
Usando Socket.io con IISNode
Para que Socket.io trabaje con IISNode, los únicos cambios necesarios cuando no se utiliza un
Directorio virtual / Aplicación anidada están dentro de Web.config .
Dado que Socket.io envía solicitudes que comienzan con /socket.io , IISNode necesita
comunicarse con IIS para que éstas también se manejen con IISNode y no sean solo solicitudes
de archivos estáticos u otro tipo de tráfico. Esto requiere un <handler> diferente a las aplicaciones
estándar de IISNode.
<handlers>
<add name="iisnode-socketio" path="server.js" verb="*" modules="iisnode" />
</handlers>
Además de los cambios en los <handlers> , también debemos agregar una regla de reescritura de
URL adicional. La regla de reescritura envía todo el tráfico /socket.io a nuestro archivo de
servidor donde se ejecuta el servidor Socket.io.
https://riptutorial.com/es/home 386

-- 414 of 423 --

<rule name="SocketIO" patternSyntax="ECMAScript">
<match url="socket.io.+"/>
<action type="Rewrite" url="server.js"/>
</rule>
Si está utilizando IIS 8, deberá deshabilitar la configuración de webSockets en su Web.config
además de agregar el controlador anterior y volver a escribir las reglas. Esto no es necesario en
IIS 7 ya que no hay soporte webSocket.
<webSocket enabled="false" />
Lea Uso de IISNode para alojar aplicaciones web Node.js en IIS en línea:
https://riptutorial.com/es/node-js/topic/6003/uso-de-iisnode-para-alojar-aplicaciones-web-node-js-
en-iis
https://riptutorial.com/es/home 387

-- 415 of 423 --

Creditos
S.
No Capítulos Contributors
1 Empezando con
Node.js
4444, Abdelaziz Mokhnache, Abhishek Jain, Adam,
Aeolingamenfel, Alessandro Trinca Tornidor, Aljoscha Meyer,
Amila Sampath, Ankit Gomkale, Ankur Anand, arcs, Aule, B
Thuy, baranskistad, Bundit J., Chandra Sekhar, Chezzwizz,
Christopher Ronning, Community, Craig Ayre, David Gatti,
Djizeus, Florian Hämmerle, Franck Dernoncourt,
ganesshkumar, George Aidonidis, Harangue, hexacyanide, Iain
Reid, Inanc Gumus, Jason, Jasper, Jeremy Banks, John
Slegers, JohnnyCoder, Joshua Kleveter, KolesnichenkoDS,
krishgopinath, Léo Martin, Majid, Marek Skiba, Matt Bush,
Meinkraft, Michael Irigoyen, Mikhail, Milan Laslop, ndugger,
Nick, olegzhermal, Peter Mortensen, RamenChef, Reborn,
Rishikesh Chandra, Shabin Hashim, Shiven, Sibeesh Venu,
sigfried, SteveLacy, Susanne Oberhauser, thefourtheye,
theunexpected1, Tomás Cañibano, user2314737, Volodymyr
Sichka, xam, zurfyx
2 Ambiente Chris, Freddie Coleman, KlwntSingh, Louis Barranqueiro,
Mikhail, sBanda
3
Análisis de
argumentos de línea
de comando
yrtimiD
4 API de CRUD simple
basada en REST Iceman
5 Aplicaciones Web
Con Express
Aikon Mogwai, Alex Logan, alexi2, Andres C. Viesca, Aph, Asaf
Manassen, Batsu, bekce, brianmearns, Community, Craig Ayre,
Daniel Verem, devnull69, Everettss, Florian Hämmerle, H.
Pauwelyn, Inanc Gumus, jemiloii, Kid Binary, kunerd, Marek
Skiba, Mikhail, Mohit Gangrade, Mukesh Sharma, Naeem
Shaikh, Niklas, Nivesh, noob, Ojen, Pasha Rumkin, Paul, Rafal
Wiliński, Shabin Hashim, SteveLacy, tandrewnichols, Taylor
Ackley, themole, tverdohleb, Vsevolod Goloviznin, xims, Yerko
Palma
6 Asegurando
aplicaciones Node.js
akinjide, devnull69, Florian Hämmerle, John Slegers, Mukesh
Sharma, Pauly Garcia, Peter G, pranspach, RamenChef,
Simplans
https://riptutorial.com/es/home 388

-- 416 of 423 --

7 Async / Await Cami Rodriguez, Cody G., cyanbeam, Dave, David Xu, Dom
Vinyard, m_callens, Manuel, nomanbinhussein, Toni Villena
8 async.js David Knipe, devnull69, DrakaSAN, F. Kauder, jerry, lsampaio,
Shriganesh Kolhe, Sky, walid
9
Autenticación de
Windows bajo
node.js
CJ Harries
10
Base de datos
(MongoDB con
Mangosta)
zurfyx
11 Biblioteca de
mangosta
Alex Logan, manuerumx, Mikhail, Naeem Shaikh, Qiong Wu,
Simplans, Will
12 Bluebird Promises David Xu
13 Buen estilo de
codificación Ajitej Kaushik, RamenChef
14 Carga automática en
los cambios
ch4nd4n, Dean Rather, Jonas S, Joshua Kleveter, Nivesh,
Sanketh Katta, zurfyx
15 Casos de uso de
Node.js vintproykt
16 Cierre agraciado RamenChef, Sathish
17 CLI Ze Rubeus
18
Código Node.js para
STDIN y STDOUT
sin usar ninguna
biblioteca
Syam Pradeep
19 Comenzando con el
perfilado de nodos damitj07
20 Cómo se cargan los
módulos RamenChef, umesh
21 Comunicación
cliente-servidor Zoltán Schmidt
22 Comunicación
socket.io Forivin, N.J.Dawson
Conectarse a	23 FabianCook, Nainesh Raval, Shriganesh Kolhe
https://riptutorial.com/es/home 389

-- 417 of 423 --

Mongodb
24 Conexión Mysql Pool KlwntSingh
25 Cortar signal
26
Creación de una
biblioteca Node.js
que admita tanto las
promesas como las
devoluciones de
llamada de error
primero
Dave
27 Creando API's con
Node.js Mukesh Sharma
28 csv parser en el
nodo js aisflat439
29 Depuración remota
en Node.JS Rick, VooVoo
30 Depurando la
aplicación Node.js
4444, Alister Norris, Ankur Anand, H. Pauwelyn, Matthew
Shanley
31 Desafíos de
rendimiento Antenka, SteveLacy
32 Desinstalar Node.js John Vincent Jardin, RamenChef, snuggles08, Trevor Clarke
33
Despliegue de
aplicaciones Node.js
en producción
Apidcloud, Brett Jackson, Community, Cristian Boariu,
duncanhall, Florian Hämmerle, guleria, haykam, KlwntSingh,
Mad Scientist, MatthieuLemoine, Mukesh Sharma, raghu,
sjmarshy, tverdohleb, tyehia
34
Despliegue de la
aplicación Node.js
sin tiempo de
inactividad.
gentlejo
35
Devolución de
llamada a la
promesa
Clement JACOB, Michael Buen, Sanketh Katta
36
Diseño API de
descanso: Mejores
prácticas
fresh5447, nilakantha singh deo
ECMAScript 2015	37 David Xu, Florian Hämmerle, Osama Bari
https://riptutorial.com/es/home 390

-- 418 of 423 --

(ES6) con Node.js
38
Ejecutando archivos
o comandos con
procesos hijo
guleria, hexacyanide, iSkore
39 Ejecutando node.js
como un servicio Buzut
40 Emisores de eventos DrakaSAN, Duly Kinsky, Florian Hämmerle, jamescostian,
MindlessRanger, Mothman
41
Enrutamiento de
solicitudes ajax con
Express.JS
RamenChef, SynapseTech
42 Enrutamiento
NodeJs parlad neupane
43
Entregar HTML o
cualquier otro tipo de
archivo.
Himani Agrawal, RamenChef, user2314737
44 Enviando un flujo de
archivos al cliente Beshoy Hanna
45 Enviar notificación
web Houssem Yahiaoui
46 Estructura del
proyecto damitj07
47 Eventloop Kelum Senanayake
48
Evitar el infierno de
devolución de
llamada
tyehia
49 Exigir() Philip Cornelius Glover
50
Exportando e
importando el
módulo en node.js
AndrewLeonardi, Bharat, commonSenseCode, James
Billingham, Oliver, sharif.io, Shog9
51
Exportando y
consumiendo
módulos
Aminadav, Craig Ayre, cyanbeam, devnull69, DrakaSAN,
Fenton, Florian Hämmerle, hexacyanide, Jason, jdrydn,
Loufylouf, Louis Barranqueiro, m02ph3u5, Marek Skiba,
MrWhiteNerdy, MSB, Pedro Otero, Shabin Hashim, tkone, uzaif
Gestión de errores	52 Karlen
https://riptutorial.com/es/home 391

-- 419 of 423 --

Node.js
53 Gestor de paquetes
de hilo Andrew Brooke, skiilaa
54 gruñido Naeem Shaikh, Waterscroll
55
Guía para
principiantes de
NodeJS
Niroshan Ranapathi
56 herrero RamenChef, vsjn3290ckjnaoij2jikndckjb
57 Historia de Nodejs Kelum Senanayake
58 http Ahmed Metwally
59 Instalación de
Node.js
Alister Norris, Aminadav, Anh Cao, asherbar, Batsu, Buzut,
Chance Snow, Chezzwizz, Dmitriy Borisov, Florian Hämmerle,
GilZ, guleria, hexacyanide, HungryCoder, Inanc Gumus, Jacek
Labuda, John Vincent Jardin, Josh, KahWee Teng, Maciej
Rostański, mmhyamin, Naing Lin Aung, NuSkooler, Shabin
Hashim, Siddharth Srivastva, Sveratum, tandrewnichols,
user2314737, user6939352, V1P3R, victorkohl
60 Integracion de
cassandra Vsevolod Goloviznin
61 Integración de
mongodb cyanbeam, FabianCook, midnightsyntax
62
Integración de
MongoDB para
Node.js / Express.js
William Carron
63 Integración de
MySQL
Aminadav, Andrés Encarnación, Florian Hämmerle, Ivan
Schwarz, jdrydn, JohnnyCoder, Kapil Vats, KlwntSingh, Marek
Skiba, Rafael Gadotti Bachovas, RamenChef, Simplans,
Sorangwala Abbasali, surjikal
64 Integración de
pasaportes
Ankit Rana, Community, Léo Martin, M. A. Cordeiro, Rupali
Pemare, shikhar bansal
65 Integración MSSQL damitj07
66 Integración
PostgreSQL Niroshan Ranapathi
67 Interactuando con la
consola ScientiaEtVeritas
https://riptutorial.com/es/home 392

-- 420 of 423 --

68 Inyección de
dependencia Niroshan Ranapathi
69 Koa Framework v2 David Xu
70 La comunicación
arduino con nodeJs. sBanda
71 Localización Nodo
JS Osama Bari
72 Lodash M1kstur
73 Loopback - Conector
basado en REST Roopesh
74 Manejo de
excepciones KlwntSingh, Nivesh, riyadhalnur, sBanda, sjmarshy, topheman
75 Manejo de solicitud
POST en Node.js Manas Jayanth
76
Mantener una
aplicación de nodo
constantemente en
ejecución
Alex Logan, Bearington, cyanbeam, Himani Agrawal, Mikhail,
mscdex, optimus, pietrovismara, RamenChef, Sameer
Srivastava, somebody, Taylor Swanson
77 Marcos de plantillas Aikon Mogwai
78 Marcos de pruebas
unitarias David Xu, Florian Hämmerle, skiilaa
79 Módulo de cluster Benjamin, Florian Hämmerle, Kid Binary, MayorMonty, Mukesh
Sharma, riyadhalnur, Vsevolod Goloviznin
80 Multihilo arcs
81 N-API Parham Alvani
82
Node.js (express.js)
con código de
ejemplo angular.js
sigfried
83 Node.js Arquitectura
y Trabajos Internos Ivan Hristov
84 Node.js con CORS Buzut
85 Node.JS con ES6 Inanc Gumus, xam, ymz, zurfyx
86 Node.js con Oracle oliolioli
https://riptutorial.com/es/home 393

-- 421 of 423 --

87 Node.js Design
Fundamental Ankur Anand, pietrovismara
88 Node.js Performance Florian Hämmerle, Inanc Gumus
89
Node.js v6 Nuevas
características y
mejoras
creyD, DominicValenciana, KlwntSingh
90 Node.JS y
MongoDB. midnightsyntax, RamenChef, Satyam S
91 NodeJS con Redis evalsocket
92 NodeJS Frameworks dthree
93 Notificaciones push Mario Rozic
94 npm
Abhishek Jain, AJS, Amreesh Tyagi, Ankur Anand, Asaf
Manassen, Ates Goral, ccnokes, CD.., Cristian Cavalli, David
G., DrakaSAN, Eric Fortin, Everettss, Explosion Pills, Florian
Hämmerle, George Bailey, hexacyanide, HungryCoder, Ionică
Bizău, James Taylor, João Andrade, John Slegers, Jojodmo,
Josh, Kid Binary, Loufylouf, m02ph3u5, Matt, Matthew Harwood
, Mehdi El Fadil, Mikhail, Mindsers, Nick, notgiorgi, num8er,
oscarm, Pete TNT, Philipp Flenker, Pieter Herroelen, Pyloid,
QoP, Quill, Rafal Wiliński, RamenChef, Ratan Kumar,
RationalDev, rdegges, refaelos, Rizowski, Shiven, Skanda,
Sorangwala Abbasali, still_learning, subbu, the12, tlo, Un3qual,
uzaif, VladNeacsu, Vsevolod Goloviznin, Wasabi Fan, Yerko
Palma
95
nvm - Administrador
de versiones de
nodo
cyanbeam, guleria, John Vincent Jardin, Luis González,
pranspach, Shog9, Tushar Gupta
96 OAuth 2.0 tyehia
97 paquete.json
Ankur Anand, Asaf Manassen, Chance Snow, efeder, Eric
Smekens, Florian Hämmerle, Jaylem Chaudhari, Kornel, lauriys
, mezzode, OzW, RamenChef, Robbie, Shabin Hashim,
Simplans, SteveLacy, Sven 31415, Tomás Cañibano,
user6939352, V1P3R, victorkohl
98 pasaporte.js Red
99 Programación
asíncrona
Ala Eddine JEBALI, cyanbeam, Florian Hämmerle, H.
Pauwelyn, John, Marek Skiba, Native Coder, omgimanerd,
slowdeath007
https://riptutorial.com/es/home 394

-- 422 of 423 --

100
Programación
síncrona vs
asíncrona en nodejs
Craig Ayre, Veger
101 Readline 4444, Craig Ayre, Florian Hämmerle, peteb
102
Ruta-controlador-
estructura de
servicio para
ExpressJS
nomanbinhussein
103 Sequelize.js Fikra, Niroshan Ranapathi, xam
104 Servidor de nodo sin
marco Hasan A Yousef, Taylor Ackley
105 Sistema de archivos
de E / S
4444, Accepted Answer, Aeolingamenfel, Christophe Marois,
Craig Ayre, DrakaSAN, Duly Kinsky, Florian Hämmerle,
gnerkus, Harshal Bhamare, hexacyanide, jakerella, Julien
CROUZET, Louis Barranqueiro, midnightsyntax, Mikhail, peteb,
Shiven, still_learning, Tim Jones, Tropic, Vsevolod Goloviznin,
Zanon
106 Sockets TCP B Thuy
107 Subir archivo Aikon Mogwai, Iceman, Mikhail, walid
108 Usando Streams cyanbeam, Duly Kinsky, efeder, johni, KlwntSingh, Max, Ze
Rubeus
109 Usando WebSocket
con Node.JS Rowan Harley
110
Uso de Browserfiy
para resolver el error
'requerido' con los
navegadores
Big Dude
111
Uso de IISNode para
alojar aplicaciones
web Node.js en IIS
peteb
https://riptutorial.com/es/home 395

-- 423 of 423 --