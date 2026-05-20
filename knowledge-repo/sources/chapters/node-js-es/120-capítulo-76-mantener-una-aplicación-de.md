# Capítulo 76:: Mantener una aplicación de

nodo constantemente en ejecución
Examples
Usa PM2 como administrador de procesos
PM2 te permite ejecutar tus scripts de nodejs para siempre. En caso de que su aplicación falle,
PM2 también la reiniciará por usted.
Instale PM2 globalmente para administrar sus instancias de nodejs
npm install pm2 -g
Navegue hasta el directorio en el que reside su script de nodejs y ejecute el siguiente comando
cada vez que desee iniciar una instancia de nodejs para que sea supervisada por pm2:
pm2 start server.js --name "app1"
Comandos útiles para monitorear el proceso.
Listar todas las instancias de nodejs gestionadas por pm2
pm2 list
1.
Detener una instancia de nodejs particular
pm2 stop <instance named>
2.
Eliminar una instancia de nodejs particular	3.
https://riptutorial.com/es/home 249

-- 277 of 423 --

pm2 delete <instance name>
Reinicie una instancia de nodejs particular
pm2 restart <instance name>
4.
Monitorizando todas las instancias de nodejs
pm2 monit
5.
Parada pm2
pm2 kill
6.
A diferencia de reiniciar, que mata y reinicia el proceso, la recarga logra una recarga de
tiempo de inactividad de 0 segundos
pm2 reload <instance name>
7.
Ver los registros
pm2 logs <instance_name>
8.
Ejecutando y deteniendo un demonio de Forever
Para iniciar el proceso:
$ forever start index.js
warn: --minUptime not set. Defaulting to: 1000ms
warn: --spinSleepTime not set. Your script will exit if it does not stay up for at least
1000ms
info: Forever processing file: index.js
Lista de instancias en ejecución para siempre:
https://riptutorial.com/es/home 250

-- 278 of 423 --

$ forever list
info: Forever processes running
|data: | index | uid | command | script |forever pid|id | logfile
|uptime |
|------|-------|-----|------------------|-------------|-----------|-----|---------------------
---|--------------|
|data: | [0] |f4Kt |/usr/bin/nodejs | src/index.js|2131 |
2146|/root/.forever/f4Kt.log | 0:0:0:11.485 |
Detener el primer proceso:
$ forever stop 0
$ forever stop 2146
$ forever stop --uid f4Kt
$ forever stop --pidFile 2131
Carrera continua con nohup
Una alternativa para siempre en Linux es nohup.
Para iniciar una instancia nohup
CD a la ubicación de la carpeta app.js o www	1.
ejecutar nohup nodejs app.js &	2.
Matar el proceso
ejecuta ps -ef|grep nodejs	1.
kill -9 <the process number>	2.
Proceso de gestión con Forever
Instalación
npm install forever -g
cd /node/project/directory
Usos
forever start app.js
Lea Mantener una aplicación de nodo constantemente en ejecución en línea:
https://riptutorial.com/es/node-js/topic/2820/mantener-una-aplicacion-de-nodo-constantemente-en-
ejecucion
https://riptutorial.com/es/home 251

-- 279 of 423 --