# Crear y publicar librería en NPM / Modo librería

## Fuente
Qwik Framework - Libro en Español (Cap. 18)

## Contenido
# Crear y publicar librería en NPM / Modo librería

> Fuente: [https://qwik-book-spanish.netlify.app/18-library-mode](https://qwik-book-spanish.netlify.app/18-library-mode)

En este capítulo, os explicaré todas las claves para poder crear nuestra propia librería Qwik, paso a paso, y distribuirla en NPM para que otras personas puedan utilizarla, al igual que nosotros utilizamos librerías externas en nuestros proyectos.

Para trabajar con este capítulo os recomiendo que estudiéis los contenidos de los capítulos anteriores, sobre todo el correspondiente acomponentesya que será lo que vamos a trabajar principalmente junto con los conceptos de desarrollo de una librería en Qwik.

Estos serán los temas que vamos a trabajar en este capítulo, desde lo que es la introducción hasta publicar nuestro primer paquete Qwik en NPM.

Qwik utiliza el modo de librería de Vite para crear librerías de componentes.

Para acceder al modo de librería de Vite a continuación podréis encontrar esa información dentro de la referencia oficial:

https://shorten-up.vercel.app/EQ7twSYrM4

Para crear una librería de componentes para Qwik, debemos asegurarnos de seguir unas reglas específicas para que el optimizador de Qwik pueda reconocer nuestra librería como tal.

La forma más sencilla de crear una nueva librería de componentes es utilizando la referencia oficial, donde se exponen los temas a tener en cuenta y los pasos a seguir, aunque bajo mi punto de vista creo que le falta información y faltaría hacerle algunos ajustes para mejorarla y que sea más cómoda de utilizar.

A continuación podéis encontrar la referencia oficial de la documentación de Qwik para poder seguir los pasos y crear vuestra librería de componentes:

https://shorten-up.vercel.app/2qBiEimJpm

Por este motivo, siguiendo un poco mi propia estructura, mis gustos personales y mi forma de organizar las cosas, he creado mi versión alternativa añadiendo algunas configuraciones que me gustan más.

Por supuesto, siempre respetando que el optimizador de Qwik pueda reconocer el proyecto como una librería de Qwik, si no, que sentido tendría hacerlo.

También se respeta lo que se refiere a la estructura de ficheros que se propone en la implementación oficial. Los cambios que he proporcionado son más enfocados a temas de compilación y forma de trabajar con ello.

Para continuar con el desarrollo de la librería paso a paso, tenemos que descargar el proyecto que utilizaremos como plantilla para realizar el desarrollo de la librería.

Os proporciono dos opciones, seleccionar la que más os guste:

Una vez que hayamos descargado el proyecto

Seleccionar la versión Node:16o18(importante).

Instalarlas dependencias del proyecto utilizando el comandonpm install(o similares comoyarn)

Con esto ya tenemos el primer paso completado, el de tener disponible el proyecto.

Lo abrimos en el editor de código (Visual Studio Code) y debemos de tener el proyecto abierto y se tiene que ver esta estructura.

Ahora que ya disponemos del proyecto y lo tenemos abierto, listo para trabajar, vamos a analizar su estructura mencionando los aspectos que debemos tener en cuenta en lo que respecta al proyecto de la librería.

De esta manera, vamos a conseguir trabajar sabiendo qué estamos modificando y qué necesitamos para llegar hasta el punto de publicar nuestra librería sin hacer las cosas a ciegas, que no suele ser muy buena idea.

Es prácticamente la misma estructura que el proyecto que se creará a partir del generador oficial aunque esta plantilla tiene algunas diferencias que facilitan más el trabajo.

Esta será la estructura:

De estos archivos los más importantes en una librería en Qwik son los ficherospackage.jsonyvite.config.tsconfigurados correctamente.

Ahora vemos estos ficheros junto con los otros con sus características y detalles a tener en cuenta.

Empezamos hablando del ficheropackage.json, que es el fichero que necesitamos para poder añadir y gestionar la información de nuestros proyectos de desarrollo de software en JavaScript y Node.JS.

Se utiliza principalmente para gestionar las dependencias del proyecto, scripts de ejecución, metadatos y otra información relevante que se necesitará especificar.

En el caso de Qwik, tenemos que tener en cuenta la siguiente estructura, cuyas propiedades que se muestran a continuación son importantes y aunque algunos no sean obligatorios su uso, se recomiendan añadirlos para respetar su optimización a proyectos Qwik.

El contenido del fichero del manifiesto del template que estamos usando para el desarrollo de una librería de Qwik es el siguiente:

Ahora se hará hincapié en las propiedades más importantes y las restantes las menciono en conjunto con una breve explicación.

qwik:Una propiedad super importantees la propiedad qwik, que será el punto de entrada para que el Optimizador de Qwik reconozca como una librería de Qwik. Hay que añadir la referencia con la extensión.qwik.mjs, que de lo contrario el optimizador de Qwik NO LO RECONOCERÁ. Este fichero se g
