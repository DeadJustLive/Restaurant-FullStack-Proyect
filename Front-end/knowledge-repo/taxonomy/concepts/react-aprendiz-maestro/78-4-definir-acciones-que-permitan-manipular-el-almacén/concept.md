# 4. Definir acciones que permitan manipular el almacén.

## Fuente
react-aprendiz-maestro (Cap. 78)

## Contenido
# 4. Definir acciones que permitan manipular el almacén.

Lo iremos haciendo paso a paso. Las partes específicas de Alt van después de los
adaptadores. El enfoque de adaptadores nos permite cambiar fácilmente de idea más
adelante así que vale la pena implementarlos.
Configurando una Instancia de Alt
Todo en Alt comienza desde una instancia de Alt. Hace un seguimiento de las
acciones y los almacenes y permite que la comunicación fluya. Para hacer que todo
sea sencillo trataremos a todos los componentes de Alt como si fueran singleton7.
Gracias a este patrón podremos reutilizar la misma instancia dentro de nuestra
aplicación.
Para conseguirlo podemos dejarlo en un módulo y referenciarlo desde cualquier sitio.
Configúralo tal y como sigue:
app/libs/alt.js
import Alt from 'alt';
const alt = new Alt();
export default alt;
Esta es la forma estándar de implementar singletons usando la sintaxis de ES6.
Cachea el módulo de tal forma que te devolverá la misma instancia la próxima vez
que importes Alt desde donde sea.
Observa que alt.js debe ir bajo app/libs, ¡no en el directorio libs del
raíz!
7https://es.wikipedia.org/wiki/Singleton

-- 89 of 226 --

React y Flux 72
El patrón singleton garantiza que habrá una y sólo una instancia. Este es
precisamente el comportamiento que queremos ahora.
Uniendo Alt con las Vistas
Por normal general los gestores de estados facilitan dos cosas que pueden ser usadas
para conectar con una aplicación React. Esto son el Proveedor y una función de alto
nivel conectar (una función que devuelve una función que genera un componente).
El Proveedor configura un contexto de react8.
Los contextos son una característica avanzada que puede ser utilizada para enviar
datos de forma implícita a través de la jerarquía de componentes sin utilizar props.
La función conectar utiliza el contexto para cavar un hueco en el que enviar los
datos al componente.
Es posible utilizar conectar a través de la invocación de funciones o de un decorador
como veremos pronto. El apéndice Entendiendo los Decoradores entra más en
profundidad en este patrón.
Para permitir que la arquitectura de nuestra aplicación sea sencilla de modificar
necesitaremos configurar dos adaptadores, uno para el Proveedor y otro para
conectar. Nos enfrentaremos con los detalles específicos de Alt en ambos sitios.
Configurando un Proveedor
Voy a utilizar una configuración especial que nos permitirá que nuestro Proveedor
sea flexible. Lo envolveremos en un módulo que eligirá un Proveedor u otro
dependiendo de nuestro entorno. Esto nos permitirá usar herramientas de desarrollo
sin incluirlas en el pack de producción. Es necesario hacer algo de configuración extra
pero merece la pena puesto que así tendremos un resultado más limpio.
El punto de partida de esto está en el index del módulo. CommonJS escoje por
defecto el fichero index.js del directorio cuando hacemos un import de ese directorio.
No podemos dejarlo en mano de los módulos de ES6 dado que queremos un
comportamiento dinámico.
8https://facebook.github.io/react/docs/context.html

-- 90 of 226 --

React y Flux 73
La idea es que nuestro componente reescriba el código dependiendo de la variable
process.env.NODE_ENV, la cual servirá para seleccionar el módulo que queramos
incluir. Aquí tenemos el punto de entrada de nuestro Proveedor:
app/components/Provider/index.js
if(process.env.NODE_ENV === 'production') {
module.exports = require('./Provider.prod');
}
else {
module.exports = require('./Provider.dev');
}
También necesitaremos los ficheros a los cuales está apuntando el fichero index.
La primera parte es sencilla. Aquí necesitamos apuntar a nuestra instancia de Alt,
conectarlo con un componente conocido como AltContainer y renderizar nuestra
aplicación con él. Es aquí donde props.children entran en juego. Es la misma idea
de antes.
AltContainer nos permitirá conectar los datos de nuestra aplicación a nivel de com-
ponente cuando implementemos conectar. Para ello, aquí tienes la implementación
a nivel de producción:
app/components/Provider/Provider.prod.jsx
import React from 'react';
import AltContainer from 'alt-container';
import alt from '../../libs/alt';
import setup from './setup';
setup(alt);
export default ({children}) =>
<AltContainer flux={alt}>
{children}
</AltContainer>

-- 91 of 226 --

React y Flux 74
La implementación de Proveedor puede cambiar dependiendo del gestor de estados
que estemos utilizando. Es posible que finalmente no haga nada, lo cual es aceptable.
La idea es que tengamos un punto de extensión donde poder modificar nuestra
aplicación si lo necesitamos.
Todavía nos estamos dejando una parte, la relacionada con la configuración de
desarrollo. Será como la de producción con la excepción de que esta vez podremos
habilitar herramientas específicas de desarrollo. Es una buena oportunidad de mover
la configuración de react-addons-perf aquí desde el app/index.jsx de la aplicación.
También estoy habilitando las herramientas de debug de Chrome para Alt9. Tendrás
que insta
