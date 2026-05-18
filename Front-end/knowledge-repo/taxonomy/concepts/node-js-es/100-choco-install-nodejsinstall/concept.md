# choco install nodejs.install

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 100)

## Contenido
# choco install nodejs.install

Más información sobre la versión actual, puede encontrarla en el repositorio de choco aquí .
Usando el administrador de versiones de nodos (nvm)
Node Version Manager , también conocido como nvm, es un script de bash que simplifica la
administración de múltiples versiones de Node.js.
Para instalar nvm, use el script de instalación provisto:
$ curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.31.3/install.sh | bash
Para Windows hay un paquete nvm-windows con un instalador. Esta página de GithHub tiene los
detalles para instalar y usar el paquete nvm-windows.
Después de instalar nvm, ejecute "nvm on" desde la línea de comandos. Esto permite que nvm
controle las versiones del nodo.
Nota: Es posible que deba reiniciar su terminal para que reconozca el comando nvm recién
instalado.
Luego instale la última versión del nodo:
$ nvm install node
También puede instalar una versión de Nodo específica, pasando las versiones principal,
secundaria y / o parche:
$ nvm install 6
$ nvm install 4.2
Para listar las versiones disponibles para instalar:
$ nvm ls-remote
Luego puede cambiar las versiones pasando la versión de la misma manera que lo hace al
instalar:
$ nvm use 5
Puede configurar una versión específica del nodo que instaló para que sea la versión
predeterminada ingresando:
https://riptutorial.com/es/home 200

-- 228 of 423 --

$ nvm alias default 4.2
Para mostrar una lista de las versiones de nodo que están instaladas en su máquina, ingrese:
$ nvm ls
Para usar versiones de nodo específicas del proyecto, puede guardar la versión en el archivo
.nvmrc. De esta manera, comenzar a trabajar con otro proyecto será menos propenso a errores
después de obtenerlo de su repositorio.
$ echo "4.2" > .nvmrc
$ nvm use
Found '/path/to/project/.nvmrc' with version <4.2>
Now using node v4.2 (npm v3.7.3)
Cuando Node se instala a través de nvm, no tenemos que usar sudo para instalar paquetes
globales, ya que están instalados en la carpeta de inicio. Por npm i -g http-server tanto, npm i -g
http-server funciona sin ningún error de permiso.
Instale Node.js From Source con el administrador de paquetes APT
Prerrequisitos
sudo apt-get install build-essential
sudo apt-get install python
[optional]
sudo apt-get install git
Obtener fuente y construir
cd ~
git clone https://github.com/nodejs/node.git
O Para la última versión 6.10.2 de LTS Node.js
cd ~
wget https://nodejs.org/dist/v6.3.0/node-v6.10.2.tar.gz
tar -xzvf node-v6.10.2.tar.gz
Cambie al directorio de origen, como en cd ~/node-v6.10.2
./configure
make
sudo make install
Instalando Node.js en Mac usando el administrador de paquetes
https://riptutorial.com/es/home 201

-- 229 of 423 --

Homebrew
Puedes instalar Node.js usando el administrador de paquetes de Homebrew .
Comience por actualizar brew:
brew update
Es posible que necesite cambiar permisos o rutas. Es mejor ejecutar esto antes de continuar:
brew doctor
A continuación, puede instalar Node.js ejecutando:
brew install node
Una vez que Node.js está instalado, puede validar la versión instalada ejecutando:
node -v
Macports
También puede instalar node.js a través de Macports .
Primero actualícelo para asegurarse de que se haga referencia a los paquetes más recientes:
sudo port selfupdate
Luego instale nodejs y npm
sudo port install nodejs npm
Ahora puede ejecutar el nodo a través de la CLI directamente invocando el node . Además, puede
comprobar su versión de nodo actual con
node -v
Instalación utilizando el instalador de MacOS X
Puede encontrar los instaladores en la página de descarga de Node.js. Normalmente, Node.js
recomienda dos versiones de Node, la versión LTS (soporte a largo plazo) y la versión actual
(última versión). Si eres nuevo en Node, solo ve al LTS y luego haz clic en el botón del Macintosh
Installer para descargar el paquete.
https://riptutorial.com/es/home 202

-- 230 of 423 --

Si desea encontrar otras versiones de NodeJS, vaya aquí , elija su versión y luego haga clic en
descargar. Desde la página de descarga, busque un archivo con la extensión .pkg .
Una vez que haya descargado el archivo (con la extensión .pkg curso), haga doble clic en él para
instalarlo. El instalador empaquetado con Node.js y npm , de forma predeterminada, el paquete
instalará ambos, pero puede personalizar cuál instalar haciendo clic en el botón customize en el
paso Installation Type . Aparte de eso, solo sigue las instrucciones de instalación, es bastante
sencillo.
Compruebe si Node está instalado
terminal abierta (si no sabe cómo abrir su terminal, mire este wikihow ). En el node --version tipo
terminal node --version luego ingrese. Su terminal se verá así si Node está instalado:
$ node --version
v7.2.1
La v7.2.1 es su versión de Node.js, si recibe el command not found: node mensaje command not
found: node lugar de eso, entonces significa que hay un problema con su instalación.
Instalando Node.js en Raspberry PI
Para instalar v6.x actualiza los paquetes.
curl -sL https://deb.nodesource.com/setup_6.x
