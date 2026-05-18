# Capítulo 32:: Desinstalar Node.js

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 69)

## Contenido
# Capítulo 32:: Desinstalar Node.js

Examples
Desinstale completamente Node.js en Mac OSX
En la Terminal de su sistema operativo Mac, ingrese los siguientes 2 comandos:
lsbom -f -l -s -pf /var/db/receipts/org.nodejs.pkg.bom | while read f; do sudo rm
/usr/local/${f}; done
sudo rm -rf /usr/local/lib/node /usr/local/lib/node_modules /var/db/receipts/org.nodejs.*
Desinstalar Node.js en Windows
Para desinstalar Node.js en Windows, use Agregar o quitar programas como este:
Abre Add or Remove Programs del menú de inicio.	1.
Buscar Node.js	2.
Windows 10:
Haga clic en Node.js.	3.
Haga clic en Desinstalar.	4.
Haga clic en el nuevo botón Desinstalar.	5.
Windows 7-8.1:
Haga clic en el botón Desinstalar debajo de Node.js.	3.
Lea Desinstalar Node.js en línea: https://riptutorial.com/es/node-js/topic/2821/desinstalar-node-js
https://riptutorial.com/es/home 122

-- 150 of 423 --
