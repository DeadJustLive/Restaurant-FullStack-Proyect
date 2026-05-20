# Cheatsheet

## Fuente
Qwik Framework - Libro en Español (Cap. 30)

## Contenido
# Cheatsheet

> Fuente: [https://qwik-book-spanish.netlify.app/cheatsheet](https://qwik-book-spanish.netlify.app/cheatsheet)

Comenzamos con el capítulo final, donde se recopilan los aspectos más importantes a tener en cuenta para
          poder seguir trabajando con Qwik.

Se añadirán las notas sobre cosas a tener en cuenta, para no tener que andar buscando en el libro página por
          página.

Como ayuda si se añadirá una mención de que capítulo corresponde a ese concepto, con el objetivo de facilitar
          el proceso de búsqueda.

Se aprovechará haciendo una comparativa de como se implementa en React, comparándolo con Qwik.

Algunos ejemplos de código de Qwik haciendo una comparativa con React para mostrar como sería para
            implementar la misma funcionalidad.

El ejemplo más básico con el que trabajamos a la hora de utilizar un componente.

Capítulo donde se trabaja con este concepto:

Componente sencillo con un botón en el que se implementa el eventoclick.

Capítulos donde se trabaja con este concepto:

Uso de un componentes sencillo conpropspara pasar información de manera dinámica a los
            componentes y poder reutilizarlos, como podría ser un componente de detalles, botones,...

Capítulos donde se trabaja con este concepto:

Para gestionar el valor del estado local de una manera sencilla y hacer que se muestre de manera reactiva
            la información correspondiente a ese valor que queramos mostrar.

Capítulo donde se trabaja con este concepto:

Ejemplo del típico ejemplo de componente en el que añadimos un elemento, para contabilizar el estado de ese
            contador mediante un hook acorde a ello.

Capítulos donde se trabaja con este concepto:

Ejemplo de un componente de reloj, donde hacemos uso de los conocimientos de crear componentes, trabajo de
            estados y uso de los ciclos de vida para crear un reloj que irá actualizándose segundo a segundo.

Capítulos donde se trabaja con este concepto:

Trabajo de consumo de APIs haciendo uso de los ciclos de vida con la funcióntrack.

Capítulos donde se trabaja con este concepto:

Para poder trabajar con los estados globales y así hacer uso de la información desde cualquier componente,
            sin hacer uso de losprops.

Capítulos donde se trabaja con este concepto:

Creamos un componente con un elemento input donde implementaremos la opción con retardo, para que se asigne
            un valor en un tiempo especificado. En este caso el retardo será de1000msque es igual a1sg.

Capítulos en los que se trabaja con estos conceptos:

En este caso vamos a crear un ejemplo donde mediante el eventoonClick$()vamos a ejecutar una
            función que genera los valores de rojo, verde y azul de manera aleatoria.

Capítulos donde se trabaja con este concepto:

Creamos un componente que renderiza una lista de elementos. En este caso, por ejemplo mostramos una lista
            de equipos de la NBA con su año de fundación.

Capítulo donde se trabaja con este concepto:

Formas incorrectas / correctas que tenemos para poder hacer uso de los hooks (y custom hooks) en Qwik.

Capítulo donde se trabaja con este concepto:

Esta porción de código os recomiendo que la tengáis siempre a mano mientras estéis
                aprendiendo. Luego, cuando ya tengáis todo bien interiorizado, inconscientemente lo aplicaréis
              perfectamente sin pensar mucho.

Información sobre este apartadoaquí.

Teniendo la siguiente distribución de directorios:

Accedemos mediante/product/<id-del-producto>para la página del producto principal y/product/<id-del-producto>/detailspara los detalles del producto.

Información sobre este apartadoaquí.

Usando como base la distribución de directorios anterior.

Añadiendo en el navegador esta ruta:http://127.0.0.1:5173/product/1234/details/.

Información sobre este apartadoaquí.

Teniendo la siguiente distribución de directorios:

Pudiendo obtener los ids de los productos implementando este código:

Accedemos mediante/product/<id-del-producto-1>/.../<id-del-producto-n>para la
              página del producto principal con los ids seleccionados.

Información sobre este apartadoaquí.

Teniendo en cuenta una estructura así:

Al haber añadido un directorio(<nombre-directorio), al introducir la ruta NO hay que
              añadir elnombre-directorioen la ruta.

Para implementar de forma muy fácil integraciones de librerías en nuestros proyectos con pocos pasos.

Para ejecutarlo y ver la lista de disponibles:

Más información al detalle:

```
exportconstHelloWorld=component$(()=>{return<div>Helloworld</div>;});Copy Code
```

```
exportconstHelloWorld=component$(()=>{return<div>Helloworld</div>;});
```

```
exportfunctionHelloWorld(){return<div>Helloworld</div>;}Copy Code
```

```
exportfunctionHelloWorld(){return<div>Helloworld</div>;}
```

```
click
```

```
exportconstButton=component$(()=>{return<button onClick$={()=>console.log('click')}>Clickme</button>;});Copy Code
```

```
exportconstButton=com
