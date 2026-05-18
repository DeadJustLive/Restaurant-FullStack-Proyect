# Capítulo 97:: paquete.json

Observaciones
Puedes crear package.json con
npm init
que le preguntará acerca de los datos básicos sobre sus proyectos, incluido el identificador de
licencia .
Examples
Definición básica del proyecto
{
"name": "my-project",
"version": "0.0.1",
"description": "This is a project.",
"author": "Someone <someone@example.com>",
"contributors": [{
"name": "Someone Else",
"email": "else@example.com"
}],
"keywords": ["improves", "searching"]
}
Campo Descripción
nombre un campo obligatorio para instalar un paquete. Necesita ser minúscula,
una sola palabra sin espacios. (Se permiten guiones y guiones bajos)
versión un campo obligatorio para la versión del paquete que usa versiones
semánticas .
descripción Una breve descripción del proyecto.
autor Especifica el autor del paquete.
contribuyentes una matriz de objetos, uno para cada contribuyente
palabras clave una serie de cadenas, esto ayudará a las personas a encontrar su paquete
Dependencias
"dependencias": {"nombre-módulo": "0.1.0"}
https://riptutorial.com/es/home 330

-- 358 of 423 --

exacto : 0.1.0 instalará esa versión específica del módulo.	•
la versión menor más nueva : ^0.1.0 instalará la versión menor más nueva, por ejemplo
0.2.0 , pero no instalará un módulo con una versión mayor más alta, por ejemplo, 1.0.0
•
el parche más nuevo : 0.1.x o ~0.1.0 instalará la versión más nueva del parche disponible,
por ejemplo, 0.1.4 , pero no instalará un módulo con una versión mayor o menor, por
ejemplo, 0.2.0 o 1.0.0 .
•
comodín : * instalará la última versión del módulo.	•
repositorio git : lo siguiente instalará un tarball desde la rama maestra de un repositorio git.
También se puede proporcionar un #sha , #tag o #branch :
GitHub : user/project o user/project#v1.0.0	○
url : git://gitlab.com/user/project.git o git://gitlab.com/user/project.git#develop	○
•
ruta local : file:../lib/project	•
Después de agregarlos a su package.json, use el comando npm install en el directorio de su
proyecto en la terminal.
Dependencias
"devDependencies": {
"module-name": "0.1.0"
}
Para dependencias necesarias solo para el desarrollo, como probar proxies de estilo ext. Esas
dependencias de desarrollo no se instalarán cuando se ejecute "npm install" en modo de
producción.
Guiones
Puede definir secuencias de comandos que se pueden ejecutar o se activan antes o después de
otra secuencia de comandos.
{
"scripts": {
"pretest": "scripts/pretest.js",
"test": "scripts/test.js",
"posttest": "scripts/posttest.js"
}
}
En este caso, puede ejecutar el script ejecutando cualquiera de estos comandos:
$ npm run-script test
$ npm run test
$ npm test
$ npm t
https://riptutorial.com/es/home 331

-- 359 of 423 --

Scripts predefinidos
Nombre del script Descripción
prepublicar Ejecutar antes de que se publique el paquete.
publicar, publicar Ejecutar después de que se publica el paquete.
preinstalar Ejecutar antes de instalar el paquete.
instalar, postinstalar Ejecutar después de instalar el paquete.
preinstalar, desinstalar Ejecutar antes de que se desinstale el paquete.
postuninstall Ejecutar después de que se desinstala el paquete.
versión previa Ejecutar antes de golpear la versión del paquete.
postversion Ejecutar después de golpear la versión del paquete.
pretest, prueba, postest Ejecutado por el npm test
Pretop, detener, poststop Ejecutado por el comando npm stop
prearranque, inicio, poststart Ejecutado por el npm start
prerestart, reinicio, postrestart Ejecutado por el comando npm restart
Scripts definidos por el usuario
También puede definir sus propios scripts de la misma manera que lo hace con los scripts
predefinidos:
{
"scripts": {
"preci": "scripts/preci.js",
"ci": "scripts/ci.js",
"postci": "scripts/postci.js"
}
}
En este caso, puede ejecutar el script ejecutando cualquiera de estos comandos:
$ npm run-script ci
$ npm run ci
Los scripts definidos por el usuario también admiten scripts anteriores y posteriores , como se
https://riptutorial.com/es/home 332

-- 360 of 423 --

muestra en el ejemplo anterior.
Definición extendida del proyecto
Algunos de los atributos adicionales son analizados por el sitio web de npm como repository ,
bugs o homepage y se muestran en el cuadro de información de este paquete.
{
"main": "server.js",
"repository" : {
"type": "git",
"url": "git+https://github.com/<accountname>/<repositoryname>.git"
},
"bugs": {
"url": "https://github.com/<accountname>/<repositoryname>/issues"
},
"homepage": "https://github.com/<accountname>/<repositoryname>#readme",
"files": [
"server.js", // source files
"README.md", // additional files
"lib" // folder with all included files
]
}
Campo Descripción
principal Script de entrada para este paquete. Este script se devuelve cuando un
usuario requiere el paquete.
repositorio Ubicación y tipo de repositorio público.
loco Bugtracker para este paquete (por ejemplo, github)
página
principal Página de inicio de este paquete o del proyecto general.
archivos Lista de archivos y carpetas que deben descargarse cuando un usuario
realiza una npm install <packagename>
Explorando package.json
Un archivo package.json , generalmente presente en la raíz del proyecto, contiene metadatos
sobre su aplicación o módulo, así como la lista de dependencias para instalar desde npm cuando
se ejecuta npm install .
Para inicializar un package.json escriba npm init en su símbolo del sistema.
Para crear un package.json con valores predeterminados use:
npm init --yes