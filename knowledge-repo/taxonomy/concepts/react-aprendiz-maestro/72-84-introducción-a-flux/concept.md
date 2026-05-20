# 8.4 Introducción a Flux

## Fuente
react-aprendiz-maestro (Cap. 72)

## Contenido
# 8.4 Introducción a Flux

Flujo de Datos Unidirectional de Flux
De momento sólo hemos trabajado con vistas. La arquitectura Flux introduce un
par de conceptos nuevos, los cuales son acciones, dispatchers y almacenes. Flux
implementa un flujo unidireccional, al contrario que otros frameworks populares
como Angular o Ember. Aunque los flujos bidireccionales puedan ser convenientes,
éstos tienen un coste. Puede ser difícil saber qué está pasando y por qué.
Acciones y Almacenes
Flux no es totalmente trivial ya que hay algunos conceptos que tener en cuenta. En
nuestro caso modelaremos NoteActions y NoteStore. NoteActions facilita opera-
ciones concretas que podremos realizar sobre nuestros datos. Por ejemplo, podremos
tener NoteActions.create({task: 'Aprender React'}).
6http://alt.js.org/

-- 86 of 226 --

React y Flux 69
Dispatcher
El dispatcher percibirá que hemos ejecutado una acción. No sólo eso, sino que
el dispatcher será capaz de lidiar con las posibles dependencias que existan entre
almacenes. Es probable que cierta acción necesite ser ejecutada después de otra, el
dispacher nos permitirá lograr todo ello.
El almacén detectará que el dispacher ha procesado una acción y se invocará. En
nuestro caso se notificará a NoteStore. Como resultado, será capaz de actualizar su
estado interno y, tras hacer esto, notificará del nuevo estado.
El Flujo de Datos de Flux
Esto completa el flujo de flujo unidireccional, aunque lineal, básico de Flux. Por
regla general el proceso unidireccional tiene un flujo cíclico que no necesariamente
termina. El siguiente diagrama ilustra un flujo más común. Es la misma idea de
nuevo, pero incluye un ciclo de retorno. Para terminar, los componentes se actualizan
a través de este proceso de bucle dependiendo de los datos de nuestro almacén.
Flujo de Datos Cíclico de Flux
Parece que se dan muchos pasos para conseguir algo tan simple como crear una nueva
Nota. Esta aproximación, sin embargo, conlleva sus propios beneficios. Es muy fácil
de trazar y de depurar puesto que el flujo siempre actúa en una única dirección. Si
algo está mal, está en algún lugar del ciclo.
Mejor todavía: podemos ver los datos que recorren nuestra aplicación. Tan sólo
conecta tu vista a tu almacén y ya lo tienes. Ésta es uno de las mayores ventajas

-- 87 of 226 --

React y Flux 70
de utilizar una solución de gestión de estados.
Ventajas de Flux
Aunque todo esto suene complicado, esta forma de trabajar dará flexibilidad a tu
aplicación. Podemos, por ejemplo, implementar comunicación con un API, cachés, e
internacionalización fuera de nuestras vistas. De esta forma se mantienen lejos de la
lógica a la vez que las aplicaciones siguen siendo fáciles de entender.
Implementar una arquitectura Flux en tu aplicación incrementará la cantidad de
código de alguna manera. Es importante comprender que la meta de Flux no es mi-
nimizar la cantidad de código escrito. Ha sido diseñado para que haya productividad
en equipos grandes. Siempre se puede decir que explícito es mejor que implícito.
