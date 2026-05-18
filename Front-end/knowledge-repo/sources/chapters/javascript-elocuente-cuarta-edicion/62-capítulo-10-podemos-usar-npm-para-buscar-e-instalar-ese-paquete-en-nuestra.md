# Capítulo 10.: Podemos usar NPM para buscar e instalar ese paquete en nuestra

computadora.
$ npm install ini
agregado 1 paquete en 723ms
$ node
> const {parse} = require("ini");
> parse("x = 1\ny = 2");
{ x: '1', y: '2' }
Después de ejecutar npm install, NPM habrá creado un directorio llamado
node_modules. Dentro de ese directorio estará un directorio ini que contiene
la biblioteca. Puedes abrirlo y ver el código. Cuando importamos "ini", esta
355

-- 367 of 445 --

biblioteca se carga, y podemos llamar a su propiedad parse para analizar un
archivo de configuración.Por defecto, NPM instala paquetes en el directorio
actual, en lugar de en un lugar centralizado. Si estás acostumbrado a otros
gestores de paquetes, esto puede parecer inusual, pero tiene ventajas: pone a
cada aplicación en control total de los paquetes que instala y facilita la gestión
de versiones y limpieza al eliminar una aplicación.
Archivos de paquete
Después de ejecutar npm install para instalar algún paquete, encontrarás no
solo un directorio node_modules, sino también un archivo llamado package.json
en tu directorio actual. Se recomienda tener tal archivo para cada proyecto.
Puedes crearlo manualmente o ejecutar npm init. Este archivo contiene infor-
mación sobre el proyecto, como su nombre y versión, y enumera sus dependen-
cias.
La simulación del robot de Capítulo 7, modularizada en el ejercicio en el