# Capítulo 30:: Usando ReactJS en forma de

flujo
Introducción
Resulta muy útil utilizar el enfoque de Flux, cuando se planea que crezca su aplicación con
ReactJS en el frontend, debido a estructuras limitadas y un poco de código nuevo para hacer que
los cambios de estado en el tiempo de ejecución sean más fáciles.
Observaciones
Flux es la arquitectura de la aplicación que usa Facebook para crear aplicaciones web del lado
del cliente. Complementa los componentes de vista compostable de React utilizando un flujo de
datos unidireccional. Es más un patrón que un marco formal, y puede comenzar a usar Flux
inmediatamente sin un montón de código nuevo.
Las aplicaciones de flujo tienen tres partes principales: el despachador , las tiendas y las vistas
(componentes React). Estos no deben confundirse con Model-View-Controller. Los controladores
existen en una aplicación Flux, pero son vistas de controlador, vistas que a menudo se
encuentran en la parte superior de la jerarquía que recuperan datos de las tiendas y pasan estos
datos a sus hijos. Además, los creadores de acciones (métodos de ayuda de dispatcher) se
utilizan para admitir una API semántica que describe todos los cambios posibles en la aplicación.
Puede ser útil pensar en ellos como una cuarta parte del ciclo de actualización de Flux.
Flux evita MVC en favor de un flujo de datos unidireccional. Cuando un usuario interactúa con
una vista React, la vista propaga una acción a través de un despachador central, a las diferentes
tiendas que contienen los datos y la lógica empresarial de la aplicación, que actualiza todas las
vistas afectadas. Esto funciona especialmente bien con el estilo de programación declarativo de
React, que permite a la tienda enviar actualizaciones sin especificar cómo hacer la transición de
las vistas entre los estados.
Examples
Flujo de datos
Este es un resumen de la descripción general .
El patrón de flujo asume el uso de flujo de datos unidireccional.
Acción : objeto simple que describe el type acción y otros datos de entrada.	1.
Dispatcher - controlador de una sola acción y devoluciones de llamada. Imagina que es el
eje central de tu aplicación.
2.
https://riptutorial.com/es/home 121

-- 131 of 139 --

Tienda : contiene el estado y la lógica de la aplicación. Registra la devolución de llamada en
el despachador y emite un evento para ver cuando se ha producido un cambio en la capa de
datos.
3.
Ver - Reactivar componente que recibe eventos de cambio y datos de la tienda. Provoca
una nueva representación cuando se cambia algo.
A partir del flujo de datos de Flux, las vistas también pueden crear acciones y
pasarlas al distribuidor para las interacciones del usuario.
4.
Revertido
Para hacerlo más claro, podemos empezar desde el final.
Los diferentes componentes de React ( vistas ) obtienen datos de diferentes tiendas sobre
los cambios realizados.
Pocos componentes pueden denominarse vistas de controlador , ya que
proporcionan el código de pegamento para obtener los datos de las tiendas y
pasar los datos por la cadena de sus descendientes. Las vistas de controlador
representan cualquier sección significativa de la página.
•
Las tiendas se pueden destacar como devoluciones de llamada que comparan el tipo de
acción y otros datos de entrada para la lógica empresarial de su aplicación.
•
Dispatcher es el receptor de acciones comunes y el contenedor de devoluciones de
llamada.
•
Las acciones no son más que simples objetos con propiedad de type requerida.
Anteriormente, querrá usar constantes para los tipos de acción y los métodos de
ayuda (llamados creadores de acción ).
•
Lea Usando ReactJS en forma de flujo en línea:
https://riptutorial.com/es/reactjs/topic/8158/usando-reactjs-en-forma-de-flujo
https://riptutorial.com/es/home 122

-- 132 of 139 --