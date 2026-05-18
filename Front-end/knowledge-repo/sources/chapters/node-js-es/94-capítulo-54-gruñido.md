# Capítulo 54:: gruñido

Observaciones
Otras lecturas:
La guía de instalación de Grunt tiene información detallada sobre la instalación de versiones
específicas de Grunt y grunt-cli, de producción o en desarrollo.
La guía de configuración de tareas tiene una explicación detallada sobre cómo configurar tareas,
objetivos, opciones y archivos dentro de Gruntfile, junto con una explicación de plantillas,
patrones globales e importación de datos externos.
La guía de Creación de Tareas enumera las diferencias entre los tipos de tareas Grunt y muestra
una serie de tareas y configuraciones de muestra.
Examples
Introducción a GruntJs
Grunt es un JavaScript Task Runner, que se utiliza para la automatización de tareas repetitivas
como minificación, compilación, prueba de unidades, alineación, etc.
Para comenzar, querrá instalar la interfaz de línea de comandos (CLI) de Grunt globalmente.
npm install -g grunt-cli
Preparación de un nuevo proyecto Grunt: una configuración típica implicará agregar dos
archivos a su proyecto: package.json y Gruntfile.
package.json: npm utiliza este archivo para almacenar metadatos para proyectos publicados
como módulos npm. Enumera grunt y los complementos de Grunt que su proyecto necesita como
DevDependencies en este archivo.
Gruntfile: este archivo se llama Gruntfile.js y se usa para configurar o definir tareas y cargar
complementos de Grunt.
Example package.json:
{
"name": "my-project-name",
"version": "0.1.0",
"devDependencies": {
"grunt": "~0.4.5",
"grunt-contrib-jshint": "~0.10.0",
"grunt-contrib-nodeunit": "~0.4.1",
"grunt-contrib-uglify": "~0.5.0"
}
https://riptutorial.com/es/home 188

-- 216 of 423 --

}
Ejemplo de gruntfile:
module.exports = function(grunt) {
// Project configuration.
grunt.initConfig({
pkg: grunt.file.readJSON('package.json'),
uglify: {
options: {
banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
},
build: {
src: 'src/<%= pkg.name %>.js',
dest: 'build/<%= pkg.name %>.min.js'
}
}
});
// Load the plugin that provides the "uglify" task.
grunt.loadNpmTasks('grunt-contrib-uglify');
// Default task(s).
grunt.registerTask('default', ['uglify']);
};
Instalación de gruntplugins
Añadiendo dependencia
Para usar un gruntplugin, primero debe agregarlo como una dependencia a su proyecto. Vamos a
usar el plugin jshint como ejemplo.
npm install grunt-contrib-jshint --save-dev
La opción --save-dev se usa para agregar el complemento en el package.json , de esta manera el
complemento siempre se instala después de una npm install .
Cargando el plugin
Puede cargar su complemento en el archivo loadNpmTasks usando loadNpmTasks .
grunt.loadNpmTasks('grunt-contrib-jshint');
Configurando la tarea
Configura la tarea en el archivo grunt agregando una propiedad llamada jshint al objeto pasado a
grunt.initConfig .
grunt.initConfig({
jshint: {
https://riptutorial.com/es/home 189

-- 217 of 423 --

all: ['Gruntfile.js', 'lib/**/*.js', 'test/**/*.js']
}
});
No olvide que puede tener otras propiedades para otros complementos que está utilizando.
Ejecutando la tarea
Para ejecutar la tarea con el complemento, puede utilizar la línea de comandos.
grunt jshint
O puede agregar jshint a otra tarea.
grunt.registerTask('default', ['jshint']);
La tarea predeterminada se ejecuta con el comando grunt en el terminal sin ninguna opción.
Lea gruñido en línea: https://riptutorial.com/es/node-js/topic/6059/grunido
https://riptutorial.com/es/home 190

-- 218 of 423 --