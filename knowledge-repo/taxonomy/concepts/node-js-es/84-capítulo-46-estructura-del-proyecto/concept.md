# Capítulo 46:: Estructura del proyecto

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 84)

## Contenido
# Capítulo 46:: Estructura del proyecto

Introducción
La estructura del proyecto nodejs está influenciada por las preferencias personales, la
arquitectura del proyecto y la estrategia de inyección del módulo que se está utilizando. También
en el arco basado en eventos, que utiliza el mecanismo dinámico de creación de instancias del
módulo. Para tener una estructura MVC es imperativo separar el código fuente del lado del
servidor y del lado del cliente, ya que el código del lado del cliente probablemente se minimizará y
se enviará al navegador y es de carácter público. Y el lado del servidor o el back-end
proporcionarán API para realizar operaciones CRUD
Observaciones
El proyecto anterior utiliza los módulos browserify y vue.js como vista de base de aplicaciones y
librerías de minificación. Por lo tanto, la estructura del proyecto puede cambiar minuciosamente
según el marco de mvc que use, por ejemplo, el directorio de compilación en público deberá
contener todo el código de mvc. Puedes tener una tarea que haga esto por ti.
Examples
Una sencilla aplicación nodejs con MVC y API.
La primera distinción importante es entre los directorios generados dinámicamente que se
utilizarán para los directorios de alojamiento y de origen.
•
Los directorios de origen tendrán un archivo o carpeta de configuración según la cantidad de
configuración que pueda tener. Esto incluye la configuración del entorno y la configuración
de la lógica empresarial que puede elegir colocar dentro del directorio de configuración.
•
|-- Config
|-- config.json
|-- appConfig
|-- pets.config
|-- payment.config
Ahora los directorios más importantes donde distinguimos entre el lado del servidor /
backend y los módulos frontend. El servidor de 2 directorios y la aplicación web representan
el backend y el frontend, respectivamente, que podemos elegir colocar dentro de un
directorio de origen a saber. src .
Puede elegir diferentes nombres según la elección personal para el servidor o la
aplicación web, según lo que tenga sentido para usted. Asegúrese de no querer
hacerlo demasiado largo o complejo, ya que se encuentra en la estructura
interna del proyecto final.
•
https://riptutorial.com/es/home 160

-- 188 of 423 --

Dentro del directorio del servidor puede tener el controlador, App.js / index.js, que será su
archivo principal de nodejs y el punto de inicio. El directorio del servidor. también puede
tener el dto dir que contiene todos los objetos de transferencia de datos que serán utilizados
por los controladores API.
|-- server
|-- dto
|-- pet.js
|-- payment.js
|-- controller
|-- PetsController.js
|-- PaymentController.js
|-- App.js
•
El directorio de la aplicación web se puede dividir en dos partes principales públicas y mvc ,
esto se ve influenciado nuevamente por la estrategia de compilación que desee utilizar.
Estamos utilizando browserfiy la compilación de la parte MVC de la aplicación web y
minimizamos los contenidos del directorio mvc .
| - webapp | - public | - mvc
•
Ahora el directorio público puede contener todos los recursos estáticos, imágenes, css
(también puede tener archivos saas) y, lo más importante, los archivos HTML.
•
|-- public
|-- build // will contianed minified scripts(mvc)
|-- images
|-- mouse.jpg
|-- cat.jpg
|-- styles
|-- style.css
|-- views
|-- petStore.html
|-- paymentGateway.html
|-- header.html
|-- footer.html
|-- index.html
El directorio mvc contendrá la lógica de front-end, incluidos los modelos , los controladores
de vista y cualquier otro módulo de utils que pueda necesitar como parte de la interfaz de
usuario. También el index.js o shell.js, cualquiera que sea el conjunto de aplicaciones,
también forma parte de este directorio.
|-- mvc
|-- controllers
|-- Dashborad.js
|-- Help.js
|-- Login.js
|-- utils
|-- index.js
•
Entonces, en conclusión, toda la estructura del proyecto se verá a continuación. Y una simple
tarea de compilación como gulp browserify minimizará los scripts mvc y los publicará en un
https://riptutorial.com/es/home 161

-- 189 of 423 --

directorio público . Luego podemos proporcionar este directorio público como recurso estático a
través de la api express.use (satic ('public')) .
|-- node_modules
|-- src
|-- server
|-- controller
|-- App.js // node app
|-- webapp
|-- public
|-- styles
|-- images
|-- index.html
|-- mvc
|-- controller
|-- shell.js // mvc shell
|-- config
|-- Readme.md
|-- .gitignore
|-- package.json
Lea Estructura del proyecto en línea: https://riptutorial.com/es/node-js/topic/9935/estructura-del-
proyecto
https://riptutorial.com/es/home 162

-- 190 of 423 --
