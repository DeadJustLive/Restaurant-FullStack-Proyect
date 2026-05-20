# State Management: Gestión de estados - Parte 2

## Fuente
Qwik Framework - Libro en Español (Cap. 9)

## Contenido
# State Management: Gestión de estados - Parte 2

> Fuente: [https://qwik-book-spanish.netlify.app/09-state-management-ii](https://qwik-book-spanish.netlify.app/09-state-management-ii)

Comenzamos con un nuevo capítulo donde seguiremos aprendiendo más acerca de la gestión de estados.

En este caso vamos a aprender a hacer uso del hookuseComputed$(), función que nos va a facilitar mucho el trabajo cuando trabajamos con valores computados, permitiendo hacer tracking (observar cambios) por defecto y encima de eso, devolver un valor como resultado.

Es muy importante haber entendido bien elcapítulo anterior, donde trabajamos con los hooks de estadouseSignal()comouseStore()para gestionar el estado de una aplicación.

Los puntos que vamos a trabajar en este capítulo son los siguientes:

Para empezar a trabajar con ello, tendremos que tener claros los conceptos de estas dos preguntas:

useComputed$()es la forma preferida de crear valores computados que nos va a permitir memoizar un valor derivado sincrónicamente de otro estado.

Es similar a memo en otros frameworks, ya quesolo volverá a calcular el valor cuando reciba señales de cambio en la entrada.

En la siguiente referencia tenemos información sobre esta función, aunque con lo que veamos en este capítulo no va a ser necesario usarla.

https://shorten-up.vercel.app/Ks3SOD7zBf

Ejemplos que podrían realizarse, entre otros ejemplos que podremos ver en este capítulo:

Antes de empezar a trabajar nuestro proyecto, dejamos de lado el proyecto anterior llamado08-state-management-iy creamos uno nuevo, siguiendo los pasos expuestos anteriormente. Como sugerencia os animo a que lo llaméis09-state-management-ii.

Empezamos con lo más básico, desde lo que es la importación de la función hasta añadirlo en el componente de la ruta donde trabajaremos.

Imaginaros que estamos en la ruta de raíz, es decir, ensrc/routes/index.tsxcon el siguiente contenido:

Cuyo contenido se visualizará de la siguiente forma (o similar, puede cambiar con la versiones el apartado de estilos y estructura):

Para poder usaruseComputed$()debemos de importarlo de la siguiente forma:

También añadiremosuseSignal()que servirá para definir el estado inicial:

Quedando de la siguiente forma el apartado del import:

Ahora nos centramos en iniciar un valor numérico entero junto con la opción deuseComputed$()para ir obteniendo el valor siempre duplicado por 2. Primero añadimos los dos valores:

Y lo que se muestra es el siguiente resultado,en los dos tenemos el valor 0.

Tenemos que tener en cuenta ahora lo siguiente:

Dentro de esta función, estamos realizando la operación de transformación con el nuevo valor computado, quesería en este caso 0(0 * 2 siempre 0), teniendo 0 como valor devalueCounter.value.

¿Qué pasarási le asignamos un 1 avalueCountere iniciamos la página?

Debería de mostrar envalueCounter.value = 1y endobleValueCounter.value = 2por ser el doble.

Con este cambio hemos podido ver su comportamiento de una manera sencilla. Vamos a hacer que tenga más dinamismo y que podamos modificarlo con un click de botón mediante el eventoonClick$aplicando un color rojo de fondo, para que se vea y podamos trabajar con el:

Quedando de la siguiente forma:

Ahorasi hacemos click 4 veces, tendremos el primer valor con 5 y el segundo como es el doble, será 10:

Tenemos ya las primeras nociones para pasar a otro ejemplo con el objetivo de reforzar lo aprendido en este punto.

Este apartado seráprácticamente igual al anteriorpero en vez de trabajar con números vamos a trabajar con datos de tipo string.

Podemos considerar este punto como un extra de refuerzo, para asentar lo aprendido en el punto anterior.

Ahora lo que vamos a tener es un valor que irá convirtiendo a mayúsculas a medida que cambiemos el estado en el valor original.

Vamos a imaginarnos que tenemos un array de varios nombres:

Y que el valor asignado aluseSignal, sea la posición seleccionada, para que cada vez que hacemos click haga un+1a la posiciónindexhasta llegar al 3 para volver a asignarse el 0 y así sucesivamente.

Aplicamos esos cambios dejando el código de la siguiente forma:

Y se visualizará de esta forma:

Donde en1tenemos el valor de seleccionar el valor índice (indexSelect.value = 0) denameListque será elprimer nombrey en el2muestra el valor actual deindexSelect.value.

Cuando llegue aindexSelect.value === 3, resetea a 0para poder estar visualizando los nombres todo el tiempo.

Teniendo estos aspectos claros, realizamos la conversión en el valor computado dentro deuseComputed$()que se asigna al valornameSelectUppercase.

CambiamosindexSelect.valuepor la transformación del texto seleccionado usandotoUpperCase()

Automáticamente al guardar, ya se inicia el valor computado en base a la posición seleccionada y esto será lo que se verá:

Si pulsamos+ 1, iremos viendo los diferentes nombres conuseSignal()yuseComputed$()dondese verá en el primero el valor original en minúsculas y en el segundo caso en mayúsculas completamente.

Ahora q
