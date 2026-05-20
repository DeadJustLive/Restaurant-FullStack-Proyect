# Capítulo 95:: nvm - Administrador de

versiones de nodo
Observaciones
Las direcciones URL utilizadas en los ejemplos anteriores hacen referencia a una versión
específica de Node Version Manager. Es muy probable que la última versión sea diferente a lo
que se está haciendo referencia. Para instalar nvm con la última versión, haga clic aquí para
acceder a nvm en GitHub, que le proporcionará las últimas URL.
Examples
Instalar NVM
Puedes usar curl :
curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.31.3/install.sh | bash
O puedes usar wget :
wget -qO- https://raw.githubusercontent.com/creationix/nvm/v0.31.3/install.sh | bash
Compruebe la versión de NVM
Para verificar que nvm ha sido instalado, haga:
command -v nvm
lo que debería generar 'nvm' si la instalación fue exitosa.
Instalación de una versión específica del nodo
Listado de versiones remotas disponibles para la instalación
nvm ls-remote
Instalando una versión remota
nvm install <version>
Por ejemplo
nvm install 0.10.13
https://riptutorial.com/es/home 317

-- 345 of 423 --

Usando una versión de nodo ya instalada
Para listar las versiones locales disponibles del nodo a través de NVM:
nvm ls
Por ejemplo, si nvm ls devuelve:
$ nvm ls
v4.3.0
v5.5.0
Puedes cambiar a v5.5.0 con:
nvm use v5.5.0
Instala nvm en Mac OSX