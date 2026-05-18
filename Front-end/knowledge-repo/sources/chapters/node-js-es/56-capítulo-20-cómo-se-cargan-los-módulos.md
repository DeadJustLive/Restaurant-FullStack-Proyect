# Capítulo 20:: Cómo se cargan los módulos

Examples
Modo global
Si instaló Node usando el directorio predeterminado, mientras estaba en el modo global, NPM
instala paquetes en /usr/local/lib/node_modules . Si escribe lo siguiente en el shell, NPM buscará,
descargará e instalará la última versión del paquete llamado sax dentro del directorio
/usr/local/lib/node_modules/express :
$ npm install -g express
Asegúrese de tener suficientes derechos de acceso a la carpeta. Estos módulos estarán
disponibles para todos los procesos de nodo que se ejecutarán en esa máquina
En modo de instalación local. Npm descargará e instalará módulos en las carpetas de trabajo
actuales al crear una nueva carpeta llamada node_modules por ejemplo, si está en
/home/user/apps/my_app una nueva carpeta llamada node_modules
/home/user/apps/my_app/node_modules si aún no existen
Cargando modulos
Cuando hacemos referencia al módulo en el código, el nodo primero busca la carpeta node_module
dentro de la carpeta referenciada en la declaración requerida. Si el nombre del módulo no es
relativo y no es un módulo central, Node intentará encontrarlo dentro de la carpeta node_modules
en la node_modules actual. directorio. Por ejemplo, si hace lo siguiente, Node intentará buscar el
archivo ./node_modules/myModule.js :
var myModule = require('myModule.js');
Si Node no encuentra el archivo, buscará dentro de la carpeta principal llamada
../node_modules/myModule.js . Si vuelve a fallar, intentará con la carpeta principal y seguirá
descendiendo hasta que llegue a la raíz o encuentre el módulo requerido.
También puede omitir la extensión .js si lo desea, en cuyo caso el nodo agregará la extensión .js
y buscará el archivo.
Cargando un módulo de carpeta
Puede usar la ruta de una carpeta para cargar un módulo como este:
var myModule = require('./myModuleDir');
https://riptutorial.com/es/home 97

-- 125 of 423 --

Si lo haces, Node buscará dentro de esa carpeta. Node supondrá que esta carpeta es un paquete
e intentará buscar una definición de paquete. Esa definición de paquete debe ser un archivo
llamado package.json . Si esa carpeta no contiene un archivo de definición de paquete llamado
package.json , el punto de entrada del paquete asumirá el valor predeterminado de index.js , y
Node buscará, en este caso, un archivo bajo la ruta ./myModuleDir/index.js
El último recurso si el módulo no se encuentra en ninguna de las carpetas es la carpeta de
instalación del módulo global.
Lea Cómo se cargan los módulos en línea: https://riptutorial.com/es/node-js/topic/7738/como-se-
cargan-los-modulos
https://riptutorial.com/es/home 98

-- 126 of 423 --