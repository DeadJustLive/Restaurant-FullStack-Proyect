# Capítulo 33:: Despliegue de aplicaciones

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 70)

## Contenido
# Capítulo 33:: Despliegue de aplicaciones

Node.js en producción
Examples
Configurando NODE_ENV = "producción"
Las implementaciones de producción variarán de muchas maneras, pero una convención
estándar cuando se implementa en producción es definir una variable de entorno llamada NODE_ENV
y establecer su valor en "producción" .
Banderas de tiempo de ejecución
Cualquier código que se ejecute en su aplicación (incluidos los módulos externos) puede verificar
el valor de NODE_ENV :
if(process.env.NODE_ENV === 'production') {
// We are running in production mode
} else {
// We are running in development mode
}
Dependencias
Cuando la variable de entorno NODE_ENV se establece en 'producción', todas las devDependencies en
su archivo package.json se ignorarán completamente cuando se ejecute npm install . También
puede imponer esto con un indicador de --production :
npm install --production
Para configurar NODE_ENV puedes usar cualquiera de estos métodos
Método 1: configurar NODE_ENV para todas las aplicaciones de nodo
Windows:
set NODE_ENV=production
Linux u otro sistema basado en Unix:
export NODE_ENV=production
Esto establece NODE_ENV para la sesión de bash actual, por lo tanto, cualquier aplicación iniciada
https://riptutorial.com/es/home 123

-- 151 of 423 --

después de esta declaración tendrá NODE_ENV establecido en production .
Método 2: establece NODE_ENV para la aplicación actual
NODE_ENV=production node app.js
Esto establecerá NODE_ENV para la aplicación actual. Esto ayuda cuando queremos probar nuestras
aplicaciones en diferentes entornos.
Método 3: crear .env archivo .env y usarlo
Esto utiliza la idea explicada aquí . Consulte esta publicación para una explicación más detallada.
Básicamente, creas .env archivo .env y ejecutas algunos scripts de bash para establecerlos en el
entorno.
Para evitar escribir un script bash, el paquete env-cmd se puede usar para cargar las variables de
entorno definidas en el archivo .env .
env-cmd .env node app.js
Método 4: usar el paquete de cross-env
Este paquete permite que las variables de entorno se configuren de una manera para cada
plataforma.
Después de instalarlo con npm, puede agregarlo a su script de implementación en package.json
siguiente manera:
"build:deploy": "cross-env NODE_ENV=production webpack"
Administrar la aplicación con el administrador de procesos
Es una buena práctica ejecutar aplicaciones de NodeJS controladas por los administradores de
procesos. El administrador de procesos ayuda a mantener viva la aplicación para siempre, reinicia
en caso de falla, recarga sin tiempo de inactividad y simplifica la administración. Los más
poderosos de ellos (como PM2 ) tienen un equilibrador de carga incorporado. PM2 también le
permite administrar el registro de aplicaciones, la supervisión y la agrupación en clústeres.
Gestor de procesos PM2
Instalación de PM2:
npm install pm2 -g
El proceso se puede iniciar en modo de clúster que incluye un equilibrador de carga integrado
para distribuir la carga entre procesos:
pm2 start app.js -i 0 --name "api" ( -i es para especificar el número de procesos que se
https://riptutorial.com/es/home 124

-- 152 of 423 --

generarán. Si es 0, el número de proceso se basará en el recuento de núcleos de CPU)
Si bien tiene múltiples usuarios en producción, es necesario tener un solo punto para PM2. Por lo
tanto, el comando pm2 debe tener el prefijo de una ubicación (para la configuración de PM2), de
lo contrario, generará un nuevo proceso de pm2 para cada usuario con la configuración en el
directorio de inicio correspondiente. Y será inconsistente.
Uso: PM2_HOME=/etc/.pm2 pm2 start app.js
Despliegue utilizando PM2
PM2 es un administrador de procesos de producción para aplicaciones Node.js , que le permite
mantener las aplicaciones activas para siempre y recargarlas sin tiempo de inactividad. PM2
también le permite administrar el registro de aplicaciones, la supervisión y la agrupación en
clústeres.
Instale pm2 globalmente.
npm install -g pm2
Luego, ejecute la aplicación node.js usando PM2.
pm2 start server.js --name "my-app"
Los siguientes comandos son útiles mientras se trabaja con PM2 .
Listar todos los procesos en ejecución:
pm2 list
Detener una aplicación:
pm2 stop my-app
Reinicie una aplicación:
pm2 restart my-app
https://riptutorial.com/es/home 125

-- 153 of 423 --

Para ver información detallada sobre una aplicación:
pm2 show my-app
Para eliminar una aplicación del registro de PM2:
pm2 delete my-app
Despliegue usando el administrador de procesos
El administrador de procesos se usa generalmente en producción para implementar una
aplicación nodejs. Las funciones principales de un administrador de procesos son reiniciar el
servidor si falla, verificar el consumo de recursos, mejorar el rendimiento en tiempo de ejecución,
monitorear, etc.
Algunos de los gestores de procesos populares creados por la comunidad de nodos son forever,
pm2, etc.
Forvever
forever es una herramienta de interfaz de línea de comandos para garantizar que un s
