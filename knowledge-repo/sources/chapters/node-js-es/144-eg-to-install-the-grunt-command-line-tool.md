# e.g. to install the grunt command line tool

npm install -g grunt-cli
Si desea ver una lista de todos los paquetes instalados y sus versiones asociadas en el espacio
de trabajo actual, use:
npm list
npm list <name>
Agregar un argumento de nombre opcional puede verificar la versión de un paquete específico.
Nota: si tiene problemas de permisos al intentar instalar un módulo npm globalmente, resista la
tentación de emitir un sudo npm install -g ... para superar el problema. Es peligroso otorgar
scripts de terceros para que se ejecuten en su sistema con privilegios elevados. El problema de
permisos puede significar que tiene un problema con la forma en que se instaló npm . Si está
interesado en instalar Node en entornos de usuario de espacio aislado, puede intentar usar nvm .
Si tiene herramientas de compilación u otras dependencias de solo desarrollo (por ejemplo,
Grunt), es posible que no desee que se incluyan en la aplicación que implementa. Si ese es el
caso, querrá tenerlo como una dependencia de desarrollo, que se encuentra en package.json en
devDependencies . Para instalar un paquete como una dependencia de solo desarrollo, use --save-
dev (o -D ).
npm install --save-dev <name> // Install development dependencies which is not included in
production
https://riptutorial.com/es/home 307

-- 335 of 423 --