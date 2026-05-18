# Capítulo 14:: Carga automática en los

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 48)

## Contenido
# Capítulo 14:: Carga automática en los

cambios
Examples
Carga automática de cambios en el código fuente usando nodemon
El paquete nodemon permite recargar automáticamente su programa cuando modifica cualquier
archivo en el código fuente.
Instalando nodemon globalmente
npm install -g nodemon (o npm i -g nodemon )
Instalando nodemon localmente
En caso de que no quieras instalarlo globalmente.
npm install --save-dev nodemon (o npm i -D nodemon )
Usando nodemon
Ejecute su programa con nodemon entry.js (o nodemon entry )
Esto reemplaza el uso habitual de node entry.js (o node entry ).
También puede agregar su inicio de nodemon como un script npm, lo que puede ser útil si desea
proporcionar parámetros y no escribirlos cada vez.
Añadir package.json:
"scripts": {
"start": "nodemon entry.js -devmode -something 1"
}
De esta manera solo puedes usar npm start desde tu consola.
Browsersync
Visión general
https://riptutorial.com/es/home 83

-- 111 of 423 --

Browsersync es una herramienta que permite ver archivos en vivo y recargar el navegador. Está
disponible como un paquete NPM .
Instalación
Para instalar Browsersync, primero debes tener Node.js y NPM instalados. Para obtener más
información, consulte la documentación de SO sobre Instalación y ejecución de Node.js.
Una vez que su proyecto esté configurado, puede instalar Browsersync con el siguiente comando:
$ npm install browser-sync -D
Esto instalará Browsersync en el directorio local node_modules y lo guardará en sus dependencias
de desarrollador.
Si prefiere instalarlo globalmente, use el indicador -g en lugar del indicador -D .
Usuarios de Windows
Si tiene problemas para instalar Browsersync en Windows, es posible que deba instalar Visual
Studio para poder acceder a las herramientas de compilación para instalar Browsersync. A
continuación, deberá especificar la versión de Visual Studio que está utilizando como:
$ npm install browser-sync --msvs_version=2013 -D
Este comando especifica la versión 2013 de Visual Studio.
Uso básico
Para volver a cargar automáticamente su sitio cada vez que cambie un archivo JavaScript en su
proyecto, use el siguiente comando:
$ browser-sync start --proxy "myproject.dev" --files "**/*.js"
Reemplace myproject.dev con la dirección web que está utilizando para acceder a su proyecto.
Browsersync generará una dirección alternativa que se puede usar para acceder a su sitio a
través del proxy.
Uso avanzado
Además de la interfaz de línea de comandos que se describió anteriormente, Browsersync
también se puede usar con Grunt.js y Gulp.js.
https://riptutorial.com/es/home 84

-- 112 of 423 --

Grunt.js
El uso con Grunt.js requiere un complemento que se pueda instalar así:
$ npm install grunt-browser-sync -D
Luego agregará esta línea a su gruntfile.js :
grunt.loadNpmTasks('grunt-browser-sync');
Gulp.js
Browsersync funciona como un módulo CommonJS , por lo que no hay necesidad de un
complemento Gulp.js. Simplemente requiere el módulo así:
var browserSync = require('browser-sync').create();
Ahora puede utilizar la API de Browsersync para configurarlo según sus necesidades.
API
La API de Browsersync se puede encontrar aquí: https://browsersync.io/docs/api
Lea Carga automática en los cambios en línea: https://riptutorial.com/es/node-js/topic/1743/carga-
automatica-en-los-cambios
https://riptutorial.com/es/home 85

-- 113 of 423 --
