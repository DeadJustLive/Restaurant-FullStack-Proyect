# Capítulo 29:: Depuración remota en Node.JS

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 66)

## Contenido
# Capítulo 29:: Depuración remota en Node.JS

Examples
Configuración de ejecución NodeJS
Para configurar la depuración remota del nodo, simplemente ejecute el proceso del nodo con el
indicador --debug . Puede agregar un puerto en el que el depurador debe ejecutarse utilizando --
debug=<port> .
Cuando su proceso de nodo se inicie debería ver el mensaje
Debugger listening on port <port>
Lo que te dirá que todo está bien para ir.
Luego, configura el destino de depuración remota en su IDE específico.
Configuración de IntelliJ / Webstorm
Asegúrese de que el complemento NodeJS esté habilitado	1.
Seleccione sus configuraciones de ejecución (pantalla)	2.
Seleccione + > Depuración remota Node.js	3.
https://riptutorial.com/es/home 112

-- 140 of 423 --

Asegúrese de ingresar el puerto seleccionado arriba así como el host correcto	4.
Una vez que estén configurados, simplemente ejecute el destino de depuración como lo haría
normalmente y se detendrá en sus puntos de interrupción.
Utilice el proxy para la depuración a través del puerto en Linux
Si inicia su aplicación en Linux, use el proxy para la depuración a través del puerto, por ejemplo:
socat TCP-LISTEN:9958,fork TCP:127.0.0.1:5858 &
Utilice el puerto 9958 para la depuración remota entonces.
Lea Depuración remota en Node.JS en línea: https://riptutorial.com/es/node-
js/topic/6335/depuracion-remota-en-node-js
https://riptutorial.com/es/home 113

-- 141 of 423 --
