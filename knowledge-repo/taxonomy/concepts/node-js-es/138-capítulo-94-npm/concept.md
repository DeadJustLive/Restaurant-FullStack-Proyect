# Capítulo 94:: npm

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 138)

## Contenido
# Capítulo 94:: npm

Introducción
Node Package Manager (npm) proporciona las siguientes dos funciones principales: Repositorios
en línea para paquetes / módulos de node.js que se pueden buscar en search.nodejs.org. Utilidad
de línea de comandos para instalar paquetes Node.js, hacer administración de versiones y
administración de dependencias de paquetes Node.js.
Sintaxis
npm <comando> donde <comando> es uno de:
agregar usuario	○
agregar usuario	○
ayuda	○
autor	○
compartimiento	○
loco	○
do	○
cache	○
terminación	○
configuración	○
ddp	○
deduplicación	○
desaprobar	○
docs	○
editar	○
explorar	○
Preguntas más frecuentes	○
encontrar	○
encontrar-falsos	○
obtener	○
ayuda	○
búsqueda de ayuda	○
casa	○
yo	○
instalar	○
info	○
en eso	○
isntall	○
cuestiones	○
la	○
enlazar	○
lista	○
•
https://riptutorial.com/es/home 302

-- 330 of 423 --

ll	○
en	○
iniciar sesión	○
ls	○
anticuado	○
propietario	○
paquete	○
prefijo	○
ciruela pasa	○
publicar	○
r	○
rb	○
reconstruir	○
retirar	○
repo	○
reiniciar	○
rm	○
raíz	○
ejecutar guión	○
s	○
se	○
buscar	○
conjunto	○
espectáculo	○
Envoltura retráctil	○
estrella	○
estrellas	○
comienzo	○
detener	○
submódulo	○
etiqueta	○
prueba	○
tst	○
Naciones Unidas	○
desinstalar	○
desconectar	○
inédito	○
unstar	○
arriba	○
actualizar	○
v	○
versión	○
ver	○
quién soy	○
Parámetros
https://riptutorial.com/es/home 303

-- 331 of 423 --

Parámetro Ejemplo
acceso npm publish --access=public
compartimiento npm bin -g
editar npm edit connect
ayuda npm help init
en eso npm init
instalar npm install
enlazar npm link
ciruela pasa npm prune
publicar npm publish ./
reiniciar npm restart
comienzo npm start
detener npm start
actualizar npm update
versión npm version
Examples
Instalando paquetes
Introducción
Paquete es un término usado por npm para denotar herramientas que los desarrolladores pueden
usar para sus proyectos. Esto incluye todo, desde bibliotecas y marcos como jQuery y AngularJS
hasta ejecutores de tareas como Gulp.js. Los paquetes vendrán en una carpeta típicamente
llamada node_modules , que también contendrá un archivo package.json . Este archivo contiene
información sobre todos los paquetes, incluidas las dependencias, que son módulos adicionales
necesarios para utilizar un paquete en particular.
Npm usa la línea de comandos para instalar y administrar paquetes, por lo que los usuarios que
intentan usar npm deben estar familiarizados con los comandos básicos en su sistema operativo,
es decir, atravesar directorios y poder ver el contenido de los directorios.
https://riptutorial.com/es/home 304

-- 332 of 423 --

Instalando NPM
Tenga en cuenta que para instalar paquetes, debe tener instalado NPM.
La forma recomendada de instalar NPM es usar uno de los instaladores de la página de descarga
de Node.js. Puede verificar si ya tiene node.js instalado ejecutando el npm -v o npm version .
Después de instalar NPM a través del instalador Node.js, asegúrese de verificar si hay
actualizaciones. Esto se debe a que NPM se actualiza con más frecuencia que el instalador
Node.js. Para buscar actualizaciones ejecute el siguiente comando:
npm install npm@latest -g
Cómo instalar paquetes
Para instalar uno o más paquetes usa lo siguiente:
npm install <package-name>
