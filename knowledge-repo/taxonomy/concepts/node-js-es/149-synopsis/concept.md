# SYNOPSIS

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 149)

## Contenido
# SYNOPSIS

npm link (in package dir)
npm link [<@scope>/]<pkg>[@<version>]
alias: npm ln
Pasos para vincular dependencias de proyectos.
Al crear el enlace de dependencia, tenga en cuenta que el nombre del paquete es lo que se va a
hacer referencia en el proyecto principal.
CD en un directorio de dependencias (ej: cd ../my-dep )	1.
npm link	2.
CD en el proyecto que va a utilizar la dependencia.	3.
npm link my-dep o si espacio de nombres npm link @namespace/my-dep	4.
Pasos para vincular una herramienta global.
https://riptutorial.com/es/home 315

-- 343 of 423 --

CD en el directorio del proyecto (ej: cd eslint-watch )	1.
npm link	2.
Usa la herramienta	3.
esw --quiet	4.
Problemas que pueden surgir
En ocasiones, vincular proyectos puede causar problemas si la dependencia o la herramienta
global ya está instalada. npm uninstall (-g) <pkg> y luego ejecutar el npm link normalmente
resuelve cualquier problema que pueda surgir.
Lea npm en línea: https://riptutorial.com/es/node-js/topic/482/npm
https://riptutorial.com/es/home 316

-- 344 of 423 --
