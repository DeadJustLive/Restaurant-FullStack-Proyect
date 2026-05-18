# Capítulo 3: - Diseño de Interfaces e Interacción

www.guiaweb.gob.cl > 73
Cabe señalar que al avanzar en el uso de CSS se puede ver que este estándar se
encuentra preparado para ofrecer soporte a diferentes tipos de dispositivos25 entre
los que se cuentan aparatos como agendas móviles, sistemas de proyección,
aparatos para lenguaje Braille y otros. Es importante consignar además, que al
momento de edición de este documento se encuentra en proceso una versión de
CSS para teléfonos móviles26 por parte de W3C.
Uso de Elementos para diagramar
Junto con el uso de CSS es importante indicar que la separación de contenidos y
presentación debe ir acompañada por la utilización de varios elementos de la
sintaxis XHTML que permiten hacer la diagramación y presentación final de los
contenidos.
Uno de los principales es el elemento <div> 	que permite señalar los bloques de
información y su ubicación dentro de la pantalla. <div> proviene de la palabra
"división" y es utilizada para crear secciones o agrupar contenidos.
Normalmente este elemento puede llevar la información sobre su presentación en
forma local, es decir en el propio archivo (como en el caso de este ejemplo, usando
el atributo style), o bien puede tener asignado un ID (identificador) mediante el
cual se le da un nombre que puede ser referenciado desde CSS para aplicarle un
estilo al bloque. El problema en este caso, es que la presentación queda ligada al
contenido, lo que no es aconsejable.
Adicionalmente el elemento <div> puede recibir como argumento una ubicación
espacial dentro de la pantalla, lo que permite generar una diagramación del sitio
web controlada sólo por CSS. Para ver un ejemplo detallado sobre esta forma de
trabajo, se recomienda revisar el ejemplo que se entrega en el Capítulo 2 de esta
versión de la Guía.
25.- Ver más información en http://www.w3.org/TR/REC-CSS2/media.html
26.- Ver más información en http://www.w3.org/TR/css-mobile/
<div style="border: 1px solid black;">
<h2>Espacio generado por DIV </h2>
<p>
Este es un párrafo creado dentro de un bloque demarcado por DIV.
</p>
</div>

-- 73 of 122 --

Dentro del elemento <div> se pueden utilizar otros dos para asignar tipos de
presentación especial a los contenidos. El primero es el elemento <p> que permite
generar párrafos de información textual, a la cual se le asignan valores mediante
atributos de CSS.
El segundo es el elemento <span> que es un contenedor que se utiliza para aplicar
estilo en forma directa al texto.
En el ejemplo anterior se ve cómo el elemento <span> aparece dentro de un párrafo
y permite generar un tipo de presentación específico para una parte del texto.
74 < www.guiaweb.gob.cl
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile
<div style="border: 1px solid black;">
<h2>Espacio generado por DIV </h2>
<p>
Este es un párrafo creado <span style="color: red;">dentro</span>
de un bloque demarcado por DIV.
</p>
</div>

-- 74 of 122 --