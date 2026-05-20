# the node & npm versions in apt are outdated. This is how you can update them:

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 99)

## Contenido
# the node & npm versions in apt are outdated. This is how you can update them:

sudo npm install -g npm
sudo npm install -g n
sudo n stable # (or lts, or a specific version)
Usando la última versión específica (ej. LTS
6.x) directamente desde nodesource
curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash -
apt-get install -y nodejs
Además, para la forma correcta de instalar módulos npm globales, establezca el directorio
personal para ellos (elimina la necesidad de sudo y evita los errores de EACCES):
mkdir ~/.npm-global
echo "export PATH=~/.npm-global/bin:$PATH" >> ~/.profile
source ~/.profile
npm config set prefix '~/.npm-global'
Instalación de Node.js en Windows
Instalación estándar
Todos los binarios, instaladores y archivos fuente de Node.js se pueden descargar aquí .
Puede descargar solo el tiempo de ejecución de node.exe o usar el instalador de Windows ( .msi ),
que también instalará npm , el administrador de paquetes recomendado para Node.js y configure
las rutas.
Instalación por gestor de paquetes
https://riptutorial.com/es/home 199

-- 227 of 423 --

También puede realizar la instalación mediante el administrador de paquetes Chocolatey
(automatización de administración de software).
