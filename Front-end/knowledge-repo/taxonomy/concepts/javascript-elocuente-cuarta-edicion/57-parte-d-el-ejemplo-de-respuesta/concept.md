# parte d: el ejemplo de respuesta:

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 57)

## Contenido
# parte d: el ejemplo de respuesta:

Content-Length: 87320
Content-Type: text/html
Last-Modified: Fri, 13 Oct 2023 10:05:41 GMT
309

-- 321 of 445 --

Esto nos indica el tamaño y tipo del documento de respuesta. En este caso, es
un documento HTML de 87,320 bytes. También nos dice cuándo se modificó
por última vez ese documento.
El cliente y servidor son libres de decidir qué cabeceras incluir en sus so-
licitudes o respuestas. Sin embargo, algunas de ellas son necesarias para que
todo funcione. Por ejemplo, sin la cabecera Content-Type en la respuesta, el
navegador no sabrá cómo mostrar el documento.
Después de las cabeceras, tanto las solicitudes como las respuestas pueden
incluir una línea en blanco seguida de un cuerpo, que contiene el documento
real que se envía. Las solicitudes GET y DELETE no envían ningún dato, pero
las solicitudes PUT y POST sí lo hacen. Algunos tipos de respuestas, como las
respuestas de error, tampoco requieren un cuerpo.
Navegadores y HTTP
Como vimos, un navegador hará una solicitud cuando introducimos una URL
en la barra de direcciones. Cuando la página HTML resultante hace referencia
a otros archivos, como imágenes y archivos de JavaScript, el navegador los
recuperará también.
Un sitio web moderadamente complicado puede incluir fácilmente entre 10 y
200 recursos. Para poder obtenerlos rápidamente, los navegadores harán varias
solicitudes GET simultáneamente en lugar de esperar las respuestas una por
una.Las páginas HTML pueden incluir formularios, que permiten al usuario
completar información y enviarla al servidor. A continuación se muestra un
ejemplo de un formulario:
<form method="GET" action="example/message.html">
<p>Nombre: <input type="text" name="name"></p>
<p>Mensaje:<br><textarea name="message"></textarea></p>
<p><button type="submit">Enviar</button></p>
</form>
Este código describe un formulario con dos campos: uno pequeño que pide un
nombre y otro más grande para escribir un mensaje. Cuando se hace clic en
el botón Enviar, el formulario se envía, lo que significa que el contenido de sus
campos se empaqueta en una solicitud HTTP y el navegador navega hacia el
resultado de esa solicitud.
Cuando el atributo method del elemento <form> es GET (o se omite), la infor-
mación del formulario se agrega al final de la URL de action como una cadena
de consulta. El navegador podría hacer una solicitud a esta URL:
310

-- 322 of 445 --

GET /example/message.html?name=Jean&message=Yes%3F HTTP/1.1
El signo de interrogación indica el final de la parte de la ruta de la URL y el
inicio de la consulta. Le siguen pares de nombres y valores, correspondientes al
atributo name en los elementos del campo del formulario y al contenido de esos
elementos, respectivamente. Un carácter ampersand (&) se utiliza para separar
los pares.
El mensaje real codificado en la URL es “Yes?”, pero el signo de interro-
gación se reemplaza por un código extraño. Algunos caracteres en las cadenas
de consulta deben ser escapados. El signo de interrogación, representado como
%3F, es uno de ellos. Parece haber una regla no escrita de que cada formato
necesita su propia forma de escapar caracteres. Este, llamado codificación
de URL, utiliza un signo de porcentaje seguido de dos dígitos hexadecimales
(base 16) que codifican el código de caracteres. En este caso, 3F, que es 63 en
notación decimal, es el código de un signo de interrogación. JavaScript propor-
ciona las funciones encodeURIComponent y decodeURIComponent para codificar y
decodificar este formato.
console.log(encodeURIComponent("Yes?"));
// → Yes%3F
console.log(decodeURIComponent("Yes%3F"));
// → Yes?
Si cambiamos el atributo method del formulario HTML en el ejemplo que vimos
anteriormente a POST, la solicitud HTTP realizada para enviar el formulario
utilizará el método POST y colocará la cadena de consulta en el cuerpo de la
solicitud, en lugar de agregarla a la URL.
POST /example/message.html HTTP/1.1
Content-length: 24
Content-type: application/x-www-form-urlencoded
name=Jean&message=Yes%3F
Las solicitudes GET deben utilizarse para solicitudes que no tengan efectos se-
cundarios, sino simplemente para solicitar información. Las solicitudes que
cambian algo en el servidor, como por ejemplo crear una nueva cuenta o pub-
licar un mensaje, deben expresarse con otros métodos, como POST. El software
del lado del cliente, como un navegador, sabe que no debe hacer solicitudes POST
a ciegas, pero a menudo implícitamente realiza solicitudes GET, por ejemplo,
para precargar un recurso que cree que pronto el usuario necesitará.Volveremos
a hablar de formularios y cómo interactuar con ellos desde JavaScript más ade-
lante en el capítulo.
311

-- 323 of 445 --

Fetch
La interfaz a través de la cual JavaScript del navegador puede hacer solicitudes
HTTP se llama fetch.
fetch("ejemplo/datos.txt").then(response => {
console.log(response.status);
// → 200
console.log(response.headers.get("Content-Type"));
// → text/plain
});
Llamar a fetch devuelve una promesa que se re
