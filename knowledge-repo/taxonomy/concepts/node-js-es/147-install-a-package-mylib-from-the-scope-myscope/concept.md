# Install a package "mylib" from the scope "myscope"

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 147)

## Contenido
# Install a package "mylib" from the scope "myscope"

npm install @myscope/mylib
Si el nombre de su propio paquete comienza con @myscope y el ámbito "myscope" está asociado
con un repositorio diferente, npm publish cargará su paquete en ese repositorio.
También puede conservar estas configuraciones en un archivo .npmrc :
https://riptutorial.com/es/home 308

-- 336 of 423 --

@myscope:registry=http://registry.corporation.com
//registry.corporation.com/:_authToken=xxxxxxxx-xxxx-xxxx-xxxxxxxxxxxxxxx
Esto es útil cuando se automatiza la compilación en una fe de servidor CI
Desinstalar paquetes
Para desinstalar uno o más paquetes instalados localmente, use:
npm uninstall <package name>
El comando de desinstalación para npm tiene cinco alias que también se pueden usar:
npm remove <package name>
npm rm <package name>
npm r <package name>
npm unlink <package name>
npm un <package name>
Si desea eliminar el paquete del archivo package.json como parte de la desinstalación, use el
indicador --save (abreviado: -S ):
npm uninstall --save <package name>
npm uninstall -S <package name>
Para una dependencia de desarrollo, use el --save-dev (abreviado: -D ):
npm uninstall --save-dev <package name>
npm uninstall -D <package name>
Para una dependencia opcional, use la --save-optional (abreviatura: -O ):
npm uninstall --save-optional <package name>
npm uninstall -O <package name>
Para los paquetes que se instalan globalmente, use el --global flag (taquigrafía: -g ):
npm uninstall -g <package name>
Versiones semánticas básicas
Antes de publicar un paquete tienes que versionarlo. npm soporta versiones semánticas , esto
significa que hay parches, versiones menores y mayores .
Por ejemplo, si su paquete está en la versión 1.2.3 para cambiar la versión, debe:
versión de parche: npm version patch => 1.2.4	1.
versión menor: npm version minor => 1.3.0	2.
https://riptutorial.com/es/home 309

-- 337 of 423 --

lanzamiento principal: npm version major => 2.0.0	3.
También puede especificar una versión directamente con:
npm version 3.1.4 => 3.1.4
Cuando configura una versión de paquete utilizando uno de los comandos npm anteriores, npm
modificará el campo de versión del archivo package.json, lo confirmará y también creará una
nueva etiqueta Git con la versión prefijada con una "v", como si He emitido el comando:
git tag v3.1.4
A diferencia de otros gestores de paquetes como Bower, el registro npm no se basa en la
creación de etiquetas Git para cada versión. Pero, si le gusta usar etiquetas, recuerde empujar la
etiqueta recién creada después de golpear la versión del paquete:
git push origin master (para enviar el cambio a package.json)
git push origin v3.1.4 (para empujar la nueva etiqueta)
O puedes hacer esto de una sola vez con:
git push origin master --tags
Configuración de una configuración de paquete
Las configuraciones del paquete Node.js están contenidas en un archivo llamado package.json
que puede encontrar en la raíz de cada proyecto. Puede configurar un nuevo archivo de
configuración llamando a:
npm init
Eso intentará leer el directorio de trabajo actual para obtener información del repositorio de Git (si
existe) y las variables de entorno para probar y autocompletar algunos de los valores de marcador
de posición para usted. De lo contrario, proporcionará un diálogo de entrada para las opciones
básicas.
Si desea crear un package.json con valores predeterminados use:
npm init --yes
