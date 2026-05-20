# start node at multi user system level (= sysVinit runlevel 3)

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 77)

## Contenido
# start node at multi user system level (= sysVinit runlevel 3)

WantedBy=multi-user.target
Ahora es posible iniciar, detener y reiniciar la aplicación respectivamente con:
service node start
service node stop
service node restart
Para indicarle a systemd que inicie automáticamente el nodo en el arranque, simplemente
escriba: systemctl enable node .
Eso es todo, el nodo ahora se ejecuta como un demonio.
Lea Ejecutando node.js como un servicio en línea: https://riptutorial.com/es/node-
js/topic/9258/ejecutando-node-js-como-un-servicio
https://riptutorial.com/es/home 142

-- 170 of 423 --
