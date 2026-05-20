# Capítulo 19:: Comenzando con el perfilado de

nodos
Introducción
El objetivo de esta publicación es comenzar a perfilar la aplicación nodejs y cómo dar sentido a
estos resultados para capturar un error o una pérdida de memoria. Una aplicación de ejecución
nodejs no es más que un proceso del motor v8 que en muchos términos es similar a un sitio web
que se ejecuta en un navegador y básicamente podemos capturar todas las métricas
relacionadas con el proceso de un sitio web para una aplicación de nodo.
La herramienta de mi preferencia es devtools de cromo o inspector de cromo junto con el
inspector de nodos.
Observaciones
El inspector de nodos falla al adjuntar al proceso de bebug del nodo a veces, en cuyo caso no
podrá obtener el punto de interrupción de depuración en devtools. Pruebe a actualizar la pestaña
de devtools varias veces y espere unos segundos para ver si está en modo de depuración.
Si no es así, reinicie el inspector de nodos desde la línea de comando.
Examples
Perfilando una aplicación de nodo simple
Paso 1 : instale el paquete node-inspector usando npm globalmente en su máquina
$ npm install -g node-inspector
Paso 2 : Iniciar el servidor de inspector de nodos
$ node-inspector
Paso 3 : Comience a depurar su aplicación de nodo
$ node --debug-brk your/short/node/script.js
Paso 4 : abre http://127.0.0.1:8080/?port=5858 en el navegador Chrome. Y verá una interfaz de
herramientas chrom-dev con el código fuente de su aplicación nodejs en el panel izquierdo. Y
dado que hemos utilizado la opción de ruptura de depuración al depurar la aplicación, la ejecución
del código se detendrá en la primera línea de código.
https://riptutorial.com/es/home 94

-- 122 of 423 --

Paso 5 : Esta es la parte fácil en la que cambia a la pestaña de perfiles y comienza a perfilar la
aplicación. En el caso de que desee obtener el perfil para un método o flujo en particular,
asegúrese de que la ejecución del código sea un punto crítico justo antes de que se ejecute ese
fragmento de código.
Paso 6 : Una vez que haya registrado su perfil de CPU, su volcado de pila / instantánea o la
https://riptutorial.com/es/home 95

-- 123 of 423 --

asignación de pila, puede ver los resultados en la misma ventana o guardarlos en una unidad
local para su posterior análisis o comparación con otros perfiles.
Puedes usar estos artículos para saber leer los perfiles:
Lectura de perfiles de CPU	•
Chrome Profiler CPU y Heap Profiler	•
Lea Comenzando con el perfilado de nodos en línea: https://riptutorial.com/es/node-
js/topic/9347/comenzando-con-el-perfilado-de-nodos
https://riptutorial.com/es/home 96

-- 124 of 423 --