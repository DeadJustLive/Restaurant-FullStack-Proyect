# jquery-fundamentos

- **ID**: jquery-fundamentos
- **Método**: native
- **Páginas**: 107
- **Capítulos**: 44
- **Generado**: 2026-05-17T09:15:22.545Z

## Resumen

Las funciones contienen bloques de código que se ejecutaran repetidamente.

Secciones:
  # 0. Éstos son una forma práctica de almacenar un conjunto de datos relacionados (como cadenas de

Conclusión: La palabra clave this
En JavaScript, así como en la mayoría de los lenguajes de programación orientados a objetos, this es
una palabra clave especial que hace referencia al objeto en donde el método está siendo invocado.

## Capítulos

### Cap. 1 — 0. Éstos son una forma práctica de almacenar un conjunto de datos relacionados (como cadenas de

Las funciones contienen bloques de código que se ejecutaran repetidamente.

Secciones:
  # 0. Éstos son una forma práctica de almacenar un conjunto de datos relacionados (como cadenas de

Conclusión: La palabra clave this
En JavaScript, así como en la mayoría de los lenguajes de programación orientados a objetos, this es
una palabra clave especial que hace referencia al objeto en donde el método está siendo invocado.

### Cap. 2 — 1. Si la función es invocada utilizando Function.call o Function.apply, this tendrá el valor del

# 1. Si la función es invocada utilizando Function.call o Function.apply, this tendrá el valor del

primer argumento pasado al método. Si el argumento es nulo (null) o indefinido (undefined),
this hará referencia el objeto global (el objeto window);

### Cap. 3 — 2. Si la función a invocar es creada utilizando Function.bind, this será el primer argumento que

# 2. Si la función a invocar es creada utilizando Function.bind, this será el primer argumento que

es pasado a la función en el momento en que se la crea;

### Cap. 4 — 3. Si la función es invocada como un método de un objeto, this referenciará a dicho objeto;

# 3. Si la función es invocada como un método de un objeto, this referenciará a dicho objeto;

### Cap. 5 — 4. De lo contrario, si la función es invocada como una función independiente, no unida a algún

Por otro lado, demasiada especificidad puede ser perjudicial.

Secciones:
  # 4. De lo contrario, si la función es invocada como una función independiente, no unida a algún

Conclusión: Realice el ejercicio utilizando el archivo
/ejercicios/js/sandbox.

### Cap. 6 — 1. Seleccionar todos los elementos div que poseen la clase “module”.

# 1. Seleccionar todos los elementos div que poseen la clase “module”.

### Cap. 7 — 2. Especificar tres selecciones que puedan seleccionar el tercer ítem de la lista desordenada #myList.

# 2. Especificar tres selecciones que puedan seleccionar el tercer ítem de la lista desordenada #myList.

¿Cuál es el mejor para utilizar? ¿Porqué?

### Cap. 8 — 3. Seleccionar el elemento label del elemento input utilizando un selector de atributo.

# 3. Seleccionar el elemento label del elemento input utilizando un selector de atributo.

### Cap. 9 — 4. Averiguar cuantos elementos en la página están ocultos (ayuda: .length).

# 4. Averiguar cuantos elementos en la página están ocultos (ayuda: .length).

### Cap. 10 — 5. Averiguar cuantas imágenes en la página poseen el atributo alt.

# 5. Averiguar cuantas imágenes en la página poseen el atributo alt.

### Cap. 11 — 6. Seleccionar todas las filas impares del cuerpo de la tabla.

# 6. Seleccionar todas las filas impares del cuerpo de la tabla.

Recorrer el DOM
Abra el archivo /ejercicios/index.html en el navegador. Realice el ejercicio utilizando el archivo
/ejercicios/js/sandbox.js o trabaje directamente con Firebug para cumplir los siguientes puntos:

### Cap. 12 — 1. Seleccionar todas las imágenes en la página; registrar en la consola el atributo alt de cada

# 1. Seleccionar todas las imágenes en la página; registrar en la consola el atributo alt de cada

imagen.

### Cap. 13 — 2. Seleccionar el elemento input, luego dirigirse hacia el formulario y añadirle una clase al mismo.

# 2. Seleccionar el elemento input, luego dirigirse hacia el formulario y añadirle una clase al mismo.

### Cap. 14 — 3. Seleccionar el ítem que posee la clase “current” dentro de la lista #myList y remover dicha clase

# 3. Seleccionar el ítem que posee la clase “current” dentro de la lista #myList y remover dicha clase

en el elemento; luego añadir la clase “current” al siguiente ítem de la lista.

### Cap. 15 — 4. Seleccionar el elemento select dentro de #specials; luego dirigirse hacia el botón submit.

# 4. Seleccionar el elemento select dentro de #specials; luego dirigirse hacia el botón submit.

### Cap. 16 — 5. Seleccionar el primer ítem de la lista en el elemento #slideshow; añadirle la clase “current” al

# 5. Seleccionar el primer ítem de la lista en el elemento #slideshow; añadirle la clase “current” al

mismo y luego añadir la clase “disabled” a los elementos hermanos.
38

-- 39 of 107 --

Manipulación
Abra el archivo /ejercicios/index.html en el navegador. Realice el ejercicio utilizando el archivo
/ejercicios/js/sandbox.js o trabaje directamente con Firebug para cumplir los siguientes puntos:

### Cap. 17 — 1. Añadir 5 nuevos ítems al final de la lista desordenada #myList. Ayuda:

# 1. Añadir 5 nuevos ítems al final de la lista desordenada #myList. Ayuda:

for (var i = 0; i<5; i++) { ... }

### Cap. 18 — 2. Remover los ítems impares de la lista.

# 2. Remover los ítems impares de la lista.

### Cap. 19 — 3. Añadir otro elemento h2 y otro párrafo al último div.module.

# 3. Añadir otro elemento h2 y otro párrafo al último div.module.

### Cap. 20 — 4. Añadir otra opción al elemento select; darle a la opción añadida el valor “Wednesday”.

# 4. Añadir otra opción al elemento select; darle a la opción añadida el valor “Wednesday”.

### Cap. 21 — 5. Añadir un nuevo div.module a la página después del último; luego añadir una copia de una de

Hasta ahora, se ha tratado completamente con métodos que se llaman desde el objeto jQuery.

Secciones:
  # 5. Añadir un nuevo div.module a la página después del último; luego añadir una copia de una de

Conclusión: La tarea a realizar es utilizar el
texto del elemento label y aplicar una “sugerencia” en la caja de ingreso de texto.

### Cap. 22 — 1. Establecer el valor del elemento input igual al valor del elemento label.

# 1. Establecer el valor del elemento input igual al valor del elemento label.

### Cap. 23 — 2. Añadir la clase “hint” al elemento input.

# 2. Añadir la clase “hint” al elemento input.

### Cap. 24 — 3. Remover el elemento label.

# 3. Remover el elemento label.

### Cap. 25 — 4. Vincular un evento focus en el input para remover el texto de sugerencia y la clase “hint”.

# 4. Vincular un evento focus en el input para remover el texto de sugerencia y la clase “hint”.

### Cap. 26 — 5. Vincular un evento blur en el input para restaurar el texto de sugerencia y la clase “hint” en

Abra el archivo /ejercicios/index.html en el navegador.

Secciones:
  # 5. Vincular un evento blur en el input para restaurar el texto de sugerencia y la clase “hint” en

Conclusión: La tarea a realizar es crear una
navegación por pestañas para los dos elementos div.

### Cap. 27 — 1. Ocultar todos los elementos div.module.

# 1. Ocultar todos los elementos div.module.

### Cap. 28 — 2. Crear una lista desordenada antes del primer div.module para utilizar como pestañas.

# 2. Crear una lista desordenada antes del primer div.module para utilizar como pestañas.

### Cap. 29 — 3. Interactuar con cada div utilizando $.fn.each. Por cada uno, utilizar el texto del elemento h2

# 3. Interactuar con cada div utilizando $.fn.each. Por cada uno, utilizar el texto del elemento h2

como el texto para el ítem de la lista desordenada.

### Cap. 30 — 4. Vincular un evento click a cada ítem de la lista de forma que:

# 4. Vincular un evento click a cada ítem de la lista de forma que:

muestre el div correspondiente y oculte el otro;
añada la clase “current” al ítem seleccionado;
remueva la clase “current” del otro ítem de la lista.

### Cap. 31 — 5. Finalmente, mostrar la primera pestaña.

Con jQuery, agregar efectos a una página es muy fácil.

Secciones:
  # 5. Finalmente, mostrar la primera pestaña.

Conclusión: La tarea es añadir un slideshow a la página con JavaScript.

### Cap. 32 — 1. Mover el elemento #slideshow a la parte superior de la página.

# 1. Mover el elemento #slideshow a la parte superior de la página.

### Cap. 33 — 2. Escribir un código que permita mostrar los ítems de forma cíclica, mostrando un ítem por unos

# 2. Escribir un código que permita mostrar los ítems de forma cíclica, mostrando un ítem por unos

segundos, luego ocultándolo con un efecto fade out y mostrando el siguiente con un efecto *fade
in.

### Cap. 34 — 3. Una vez llegado al último ítem de la lista, comenzar de nuevo con el primero.

En general, Ajax no trabaja a través de dominios diferentes.

Secciones:
  # 3. Una vez llegado al último ítem de la lista, comenzar de nuevo con el primero.

Conclusión: La tarea es cargar el contenido de un artículo de blog cuando el usuario
haga click en el título del ítem.

### Cap. 35 — 1. Crear un elementos div después del titulo de cada titulo de artículo de blog y guardar una

# 1. Crear un elementos div después del titulo de cada titulo de artículo de blog y guardar una

referencia hacia ellos en el elemento de titulo utilizando $.fn.data.

### Cap. 36 — 2. Vincular un evento click al titulo, el cual utilizará el método $.fn.load para cargar en cada

Notar que cada titulo de artículo de blog en index.html incluye un enlace hacia el artículo.

Secciones:
  # 2. Vincular un evento click al titulo, el cual utilizará el método $.fn.load para cargar en cada

Conclusión: La tarea es mostrar los detalles del usuario para un día determinado
cuando se selecciona desde la lista desplegable.

### Cap. 37 — 1. Añadir un elemento div después del formulario que se encuentra dentro del elemento #specials;

# 1. Añadir un elemento div después del formulario que se encuentra dentro del elemento #specials;

allí será el lugar en donde se colocará la información a obtener.

### Cap. 38 — 2. Vincular el evento change en el elemento select; cuando se realiza un cambio en la selección,

# 2. Vincular el evento change en el elemento select; cuando se realiza un cambio en la selección,

enviar una petición Ajax a /ejercicios/data/specials.json.

### Cap. 39 — 3. Cuando la petición devuelve una respuesta, utilizar el valor seleccionado en el select (ayuda:

# 3. Cuando la petición devuelve una respuesta, utilizar el valor seleccionado en el select (ayuda:

$.fn.val) para buscar la información correspondiente en la respuesta JSON.

### Cap. 40 — 4. Añadir algún HTML con la información obtenida en el div creado anteriormente.

# 4. Añadir algún HTML con la información obtenida en el div creado anteriormente.

### Cap. 41 — 5. Finalmente remover el botón submit del formulario.

Notar que cada vez que la selección cambia, se realiza una petición Ajax.

Secciones:
  # 5. Finalmente remover el botón submit del formulario.

Conclusión: Use en lo posible etiqueta.

### Cap. 42 — parte i: zquierda.

En lo posible, hay que evitar la manipulación del DOM.

Secciones:
  # parte i: zquierda.

Conclusión: Closure Compiler es utilizado para
la minificación del código (en caso que optimize: "none" esté comentado).

### Cap. 43 — para sistemas que no son windows

# para sistemas que no son windows

../../requirejs/build/build.sh app.build.js

### Cap. 44 — para sistemas windows

Abra el archivo /ejercicios/portlets.html en el navegador.

Secciones:
  # para sistemas windows

Conclusión: United States.

