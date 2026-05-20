# or

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 148)

## Contenido
# or

npm init -y
Si está creando un package.json para un proyecto que no va a publicar como un paquete npm (es
decir, con el único fin de redondear sus dependencias), puede transmitir esta intención en su
archivo package.json :
Opcionalmente, establezca la propiedad private en verdadero para evitar la publicación
accidental.
1.
Opcionalmente, establezca la propiedad de la license en "SIN LICENCIA" para negar a	2.
https://riptutorial.com/es/home 310

-- 338 of 423 --

otros el derecho de usar su paquete.
Para instalar un paquete y guardarlo automáticamente en su package.json , use:
npm install --save <package>
El paquete y los metadatos asociados (como la versión del paquete) aparecerán en sus
dependencias. Si guarda si es una dependencia de desarrollo (usando --save-dev ), el paquete
aparecerá en sus devDependencies .
Con este bare-bones package.json , encontrará mensajes de advertencia al instalar o actualizar
paquetes, indicándole que le falta una descripción y el campo del repositorio. Si bien es seguro
ignorar estos mensajes, puede deshacerse de ellos abriendo package.json en cualquier editor de
texto y agregando las siguientes líneas al objeto JSON:
[...]
"description": "No description",
"repository": {
"private": true
},
[...]
Publicando un paquete
Primero, asegúrese de haber configurado su paquete (como se dijo en Configuración de la
configuración de un paquete ). Entonces, tienes que estar conectado a npmjs.
Si ya tienes un usuario npm
npm login
Si no tienes usuario
npm adduser
Para comprobar que su usuario está registrado en el cliente actual.
npm config ls
Después de eso, cuando su paquete esté listo para ser publicado use
npm publish
Y ya está hecho.
Si necesita publicar una nueva versión, asegúrese de actualizar la versión de su paquete, como
se indica en las versiones semánticas básicas . De lo contrario, npm no le permitirá publicar el
paquete.
https://riptutorial.com/es/home 311

-- 339 of 423 --

{
name: "package-name",
version: "1.0.4"
}
Ejecutando scripts
Puede definir scripts en su package.json , por ejemplo:
{
"name": "your-package",
"version": "1.0.0",
"description": "",
"main": "index.js",
"author": "",
"license": "ISC",
"dependencies": {},
"devDependencies": {},
"scripts": {
"echo": "echo hello!"
}
}
Para ejecutar el script echo , ejecute npm run echo desde la línea de comandos. Los scripts
arbitrarios, como el echo anterior, deben ejecutarse con npm run <script name> . npm también tiene
una serie de scripts oficiales que se ejecutan en ciertas etapas de la vida del paquete (como
preinstall ). Consulte aquí la descripción general completa de cómo npm maneja los campos de
script.
Los scripts npm se utilizan con mayor frecuencia para tareas como iniciar un servidor, crear el
proyecto y ejecutar pruebas. Aquí hay un ejemplo más realista:
"scripts": {
"test": "mocha tests",
"start": "pm2 start index.js"
}
En las entradas de scripts , los programas de línea de comandos como mocha funcionarán cuando
se instalen global o localmente. Si la entrada de la línea de comandos no existe en la ruta del
sistema, npm también verificará los paquetes instalados localmente.
Si sus scripts se vuelven muy largos, se pueden dividir en partes, como esta:
"scripts": {
"very-complex-command": "npm run chain-1 && npm run chain-2",
"chain-1": "webpack",
"chain-2": "node app.js"
}
La eliminación de paquetes extraños
https://riptutorial.com/es/home 312

-- 340 of 423 --

Para eliminar paquetes extraños (paquetes que están instalados pero no en la lista de
dependencias), ejecute el siguiente comando:
npm prune
Para eliminar todos los paquetes dev , agregue --production flag:
npm prune --production
Más sobre esto
Listado de paquetes actualmente instalados
Para generar una lista (vista de árbol) de los paquetes instalados actualmente, use
npm list
ls , la y ll son alias del comando list . Los comandos la y ll muestran información extendida como
descripción y repositorio.
Opciones
El formato de respuesta se puede cambiar pasando las opciones.
npm list --json
json - Muestra información en formato json	•
largo - Muestra información extendida	•
analizable : muestra una lista analizable en lugar de un árbol	•
global - Muestra paquetes instalados globalmente	•
profundidad - Máxima profundidad de visualización del árbol de dependencias	•
dev / desarrollo - Muestra devDependencies	•
prod / production - Muestra dependencias	•
Si lo desea, también puede ir a la página de inicio del paquete.
npm home <package name>
Actualizando npm y paquetes
Dado que npm en sí mismo es un módulo Node.js, puede actualizarse usando sí mismo.
Si el sistema operativo es Windows debe estar ejecutando el símbolo del sistema como
administrador
npm install -g npm@latest
https://riptutorial.com/es/home 313

-- 341 of 423 --

Si quieres comprobar si hay versiones actualizadas puedes hacerlo:
npm outdated
Para actualizar un paquete específico:
npm update <package name>
Esto actualizará el paquete a la última versión de acuerdo con las restricciones en
p
