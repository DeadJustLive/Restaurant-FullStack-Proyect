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
curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash -
Usando el gestor de paquetes apt
sudo apt-get install -y nodejs
Instalación con Node Version Manager bajo Fish Shell con Oh My Fish!
Node Version Manager ( nvm ) simplifica enormemente la administración de las versiones de
Node.js, su instalación, y elimina la necesidad de sudo cuando se trata de paquetes (por ejemplo,
npm install ... ). Fish Shell ( fish ) " es un shell de línea de comandos inteligente y fácil de usar
para OS X, Linux y el resto de la familia ", que es una alternativa popular entre los programadores
para shells comunes como bash . Por último, Oh My Fish ( omf ) permite personalizar e instalar
paquetes dentro del shell de Fish.
Esta guía asume que ya estás usando Fish como tu caparazón .
Instalar nvm
curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.31.4/install.sh | bash
Instale Oh My Fish
https://riptutorial.com/es/home 203

-- 231 of 423 --

curl -L https://github.com/oh-my-fish/oh-my-fish/raw/master/bin/install | fish
(Nota: Se le solicitará que reinicie su terminal en este punto. Continúe y hágalo ahora).
Instalar plugin-nvm para Oh My Fish
Instalaremos plugin-nvm a través de Oh My Fish para exponer las capacidades de nvm dentro del
shell de Fish:
omf install nvm
Instale Node.js con Node Version Manager
Ahora está listo para usar nvm . Puede instalar y usar la versión de Node.js de su agrado. Algunos
ejemplos:
Instale la versión más reciente del nodo: nvm install node	•
Instale 6.3.1 específicamente: nvm install 6.3.1	•
Lista de versiones instaladas: nvm ls	•
Cambie a un 4.3.1 previamente instalado: nvm use 4.3.1	•
Notas finales
¡Recuerda de nuevo, que ya no necesitamos sudo cuando tratamos con Node.js usando este
método! Las versiones de nodo, los paquetes, etc. se instalan en su directorio de inicio.
Instale Node.js desde la fuente en Centos, RHEL y Fedora
Prerrequisitos
git	•
clang and clang++ 3.4 ^ o gcc and g++ 4.8 ^	•
Python 2.6 o 2.7	•
GNU Make 3.81 ^	•
Obtener fuente
Node.js v6.x LTS
git clone -b v6.x https://github.com/nodejs/node.git
Node.js v7.x
git clone -b v7.x https://github.com/nodejs/node.git
Construir
cd node
./configure
make -jX
su -c make install
https://riptutorial.com/es/home 204

-- 232 of 423 --

X - el número de núcleos de procesador, acelera enormemente la construcción
Limpieza [Opcional]
cd
rm -rf node
Instalando Node.js con n
Primero, hay un envoltorio muy bueno para configurar n en su sistema. Solo corre:
curl -L https://git.io/n-install | bash
instalar n . Luego instale los binarios de varias maneras:
último
n latest
estable
n stable
lts
n lts
Cualquier otra version
n <version>
por ejemplo, n 4.4.7
Si esta versión ya está instalada, este comando activará esa versión.
Versiones de conmutación
n por sí mismo producirá una lista de selección de binarios instalados. Use hacia arriba y hacia
abajo para encontrar el que desea y Enter para activarlo.
Lea Instalación de Node.js en línea: https://riptutorial.com/es/node-js/topic/1294/instalacion-de-
node-js
https://riptutorial.com/es/home 205

-- 233 of 423 --