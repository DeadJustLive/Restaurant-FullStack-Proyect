# 5. Typescript

## Fuente
javascript-uoc (Cap. 9)

## Contenido
# 5. Typescript

TypeScript es un lenguaje de programación de código abierto desarrollado y
presentado por Microsoft en 2012. Es un superset de JavaScript que esencial-
mente añade capacidades de programación orientada a objetos, como el tipa-
do estático y objetos basados en clases.
Extiende la sintaxis de JavaScript por medio de un lenguaje propio que com-
pila ficheros en lenguaje JavaScript original, asegurando la compatibilidad con
todos los navegadores, servidores y sistemas operativos.
Es importante resaltar que, al igual que sucede con los preprocesadores de
CSS, no se trabaja con el fichero JavaScript, sino que este es el resultado de la
compilación del fichero TypeScript.
Asimismo, este es un lenguaje tipado, por lo tanto se tiene que definir el ob-
jeto que se está utilizando para poder obtener las propiedades o métodos que
soporta. Así, en el ejemplo se identifica el objeto con el ID «nombre_usuario»
como un objeto del tipo Input() para poder acceder a su value. En caso de no
hacer esta especificación el compilador daría un error y no permitiría conti-
nuar.
Otra cosa que facilita mucho la vida a los que utilizamos este lenguaje es que
aprovecha todas las capacidades de compilación y depuración de Visual Studio
tal como se hace en cualquier lenguaje .NET. Esto quiere decir que podemos
poner un punto de control en cualquier lugar y hacer un resumen de inspec-
ción u obtener la pila de llamadas de un código JavaScript.
5.1. Superset
Un superset es un lenguaje escrito por encima de otro lenguaje, o mejor di-
cho, que compila a otro lenguaje. En el caso de TypeScript es un lenguaje que
compila a JavaScript y que le añade muchas facilidades y ventajas.
Los lenguajes como JavaScript basados en un estándar a menudo evolucionan
de manera más lenta que las necesidades que tienen los desarrolladores. Es
por este motivo por lo que surgen empresas y/o comunidades que deciden
expandir un lenguaje, aportando todas las herramientas de que carecen para
poder desarrollar en las mejores condiciones.
Hay dos supersets especialmente populares para JavaScript: CoffeeScript y Ty-
peScript. La diferencia principal es que mientras que CoffeeScript nos aleja del
lenguaje, con TypeScript escribimos en un lenguaje muy similar al propio Ja-

-- 44 of 48 --

CC-BY-NC-ND • PID_00254185 45 JavaScript
vaScript. Por este motivo, los programadores interesados en utilizar un super-
set se han decantado principalmente por TypeScript, y por este motivo tam-
bién es el lenguaje que veremos en detalle.
5.2. Instalación
El compilador de TypeScript está desarrollado en NodeJS, así que si no tene-
mos este entorno instalado en nuestro equipo, lo primero que tendremos que
hacer es ir al sitio web de NodeJS, donde encontraremos las opciones para la
instalación en nuestro sistema operativo mediante un instalador con asistente.
Después necesitamos el TSC (Command-line TypeScript Compiler), la herramien-
ta que nos permite compilar un archivo TypeScript a JavaScript nativo. Este
software es el que está realizado con NodeJS y su instalación se realiza vía NPM
con el siguiente comando:
npm install -g typescript
5.3. Crear y compilar un archivo ts
Los archivos TypeScript se pueden crear y editar desde cualquier editor de texto
y tienen la extensión «.ts».
Cualquier código JavaScript compila en TypeScript. Esto quiere decir que en
nuestro código TypeScript podemos incluir fragmentos de JavaScript sin que
suponga ningún problema.
Para compilar utilizamos el mencionado compilador TSC y mediante el si-
guiente comando se convertirá en JavaScript nativo:
tsc nombredelfichero.ts
El anterior es un ejemplo muy sencillo de compilación, pero TSC incluye tam-
bién un método «watch», que permite vigilar cambios en los archivos TS, au-
tomatizando así la compilación.
También tenemos la opción de configurar el archivo «tsconfig.json» donde
podemos definir todos los parámetros de compilación que nos interesen, co-
mo por ejemplo, el estándar ECMAScript al que compilaremos el código, el
tipo de informe de errores que se desea, las rutas donde colocar los archivos
compilados, etc.

-- 45 of 48 --

CC-BY-NC-ND • PID_00254185 46 JavaScript
5.4. Playground
Dentro de la página oficial de TypeScript encontramos un rincón interesante
para probar nuestro código sin necesidad de instalar nada, o para revisar rápi-
damente cómo un código TS compilaría a JavaScript, es el playground (o «zona
de recreo»):
https://www.typescriptlang.org/play/index.html
Encontramos allí dos cajas de texto: la primera es para escribir código TypeS-
cript y en tiempo real veremos cómo este código compila a JavaScript en la
caja de la derecha. Además encontramos ayudas indicando en qué partes de
nuestro código tenemos problemas y por qué motivos.

-- 46 of 48 --

CC-BY-NC-ND • PID_00254185 47 JavaScript
Bibliografía
Angular (Web oficial)
https://angular.io/
AngularJS (Web oficial)
https://angularjs.org/
ARIA (MDN web docs)
https://developer.mozilla.org/es/docs/Web/Accessibility/ARIA
BabelJS
ht
