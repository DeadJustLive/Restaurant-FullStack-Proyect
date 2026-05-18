# 2.2 Ejecutando el Proyecto

## Fuente
react-aprendiz-maestro (Cap. 30)

## Contenido
# 2.2 Ejecutando el Proyecto

Ejecuta npm start para arrancar el proyecto. Deberías tener una salida como la
siguiente si todo ha ido bien:

-- 29 of 226 --

Configurando el Proyecto 12
> webpack-dev-server
http://localhost:8080/
webpack result is served from /
content is served from .../kanban-app
404s will fallback to /index.html
Child html-webpack-plugin for "index.html":
webpack: bundle is now VALID.
En caso de que recibas un error asegúrate de que no tengas ningún otro proceso
escuchando en el mismo puerto. Puedes hacer que la aplicación escuche en otro
puerto distinto usando un comando similar a PORT=3000 npm start (sólo para
Unix). La configuración utilizará el puerto que hayas indicado en la variable de
entorno. Si quieres fijar el puerto con un valor específico configúralo en el fichero
webpack.config.js.
Si todo ha ido bien deberás ver algo como esto en el navegador:
Salida del típico ‘Hello world’
Puedes probar a modificar el código fuente para ver cómo funciona la recarga en
caliente.
Hablaré del esqueleto con más detalle más adelante para que sepas cómo funciona.
También mostraré brevemente qué características del lenguaje vamos a utilizar.
Las técnicas utilizadas en el esqueleto están cubiertas con más detalle en
SurviveJS - Webpack7.
7http://survivejs.com/webpack/introduction/

-- 30 of 226 --

Configurando el Proyecto 13
2.3 scripts de npm Presentes en el Esqueleto
Nuestro esqueleto es capaz de generar una aplicación que puede ser desplegada en
producción. Hay una meta relacionada con el proceso de despliegue con la que podrás
mostrar tu proyecto a otras personas mediante GitHub Pages8. A continuación tienes
una lista con todos los scripts:
• npm run start (o npm start) - Ejecuta el proyecto en modo desarrollo.
Navega hacia localhost:8080 desde tu navegador para verlo funcionando.
• npm run build - Produce una compilación lista para producción en build/.
Puedes abrir el fichero index.html en el navegador para ver el resultado.
• npm run deploy - Despliega el contenido de build/ en la rama gh-pages
de tu proyecto y lo sube a GitHub. Podrás acceder al proyecto a través de
la URL <usuario>.github.io/<proyecto>. Para que funcione correctamente
deberás configurar la variable publicPath del fichero webpack.config.js para
que encaje con el nombre de tu proyecto en GitHub.
• npm run stats - Genera estadísticas (stats.json) sobre el proyecto. Puedes
analizar los resultados9 más adelante.
• npm run test (o npm test) - Ejecuta los tests del proyecto. El capítulo Pro-
bando React entra más adelante en este asunto. De hecho, una buena manera
de aprender mejor cómo funciona React es escribir tests que prueben tus
componentes.
• npm run test:tdd - Ejecuta los tests del proyecto en modo TDD, lo que
significa que se quedará a la espera de cambios en los ficheros y lanzará los
tests cuando se detecten cambios, lo que te permititá ir más deprisa ya que te
evitará tener que lanzar los tests manualmente.
• npm run test:lint - Ejecuta ESLint10 contra el código. ESLint es capaz de
capturar pequeños problemas. Puedes configurar tu entorno de desarrollo para
que lo utilice y te permitirá capturar errores potenciales a medida que los
cometas.
8https://pages.github.com/
9http://survivejs.com/webpack/building-with-webpack/analyzing-build-statistics/
10http://eslint.org/

-- 31 of 226 --

Configurando el Proyecto 14
Revisa la sección "scripts" del fichero package.json para entender mejor cómo
funciona cada uno de ellos. Es casi como configuración. Echa un vistazo a SurviveJS
- Webpack11 para saber más sobre este tema.
