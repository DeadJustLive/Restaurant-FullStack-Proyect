# Chapter 19

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 58)

## Contenido
# Chapter 19

Proyecto: Editor de Arte Pixelado
El material de los capítulos anteriores te brinda todos los elementos que nece-
sitas para construir una aplicación web básica. En este capítulo, haremos
precisamente eso.
Nuestra aplicación será un programa de dibujo de pixeles, donde puedes
modificar una imagen píxel por píxel manipulando una vista ampliada de la
misma, mostrada como una rejilla de cuadros de colores. Puedes utilizar el
programa para abrir archivos de imagen, garabatear en ellos con tu ratón u
otro dispositivo señalador, y guardarlos. Así es cómo se verá:
Pintar en una computadora es genial. No necesitas preocuparte por materi-
ales, habilidad o talento. Simplemente comienzas a manchar y ves hacia dónde
llegas.
Componentes
La interfaz de la aplicación muestra un gran elemento <canvas> en la parte
superior, con varios formularios debajo de él. El usuario dibuja en la imagen
seleccionando una herramienta de un campo <select> y luego haciendo clic,
tocando o arrastrando sobre el lienzo. Hay herramientas para dibujar píxeles
individuales o rectángulos, para rellenar un área y para seleccionar un color de
la imagen.
Estructuraremos la interfaz del editor como un conjunto de componentes,
objetos responsables de una parte del DOM y que pueden contener otros com-
331

-- 343 of 445 --

ponentes dentro de ellos.
El estado de la aplicación consiste en la imagen actual, la herramienta se-
leccionada y el color seleccionado. Organizaremos las cosas de manera que el
estado resida en un único valor, y los componentes de la interfaz siempre se
basen en el estado actual para verse.
Para entender por qué esto es importante, consideremos la alternativa: dis-
tribuir piezas de estado a lo largo de la interfaz. Hasta cierto punto, esto es
más fácil de programar. Podemos simplemente agregar un campo de color y
leer su valor cuando necesitemos saber el color actual.
Pero luego agregamos el selector de colores —una herramienta que te per-
mite hacer clic en la imagen para seleccionar el color de un píxel determinado.
Para mantener el campo de color mostrando el color correcto, esa herramienta
tendría que saber que el campo de color existe y actualizarlo cada vez que elige
un nuevo color. Si alguna vez añades otro lugar que muestre el color (quizás el
cursor del ratón podría mostrarlo), tendrías que actualizar tu código de cambio
de color para mantener eso sincronizado también.
De hecho, esto crea un problema en el que cada parte de la interfaz necesita
saber acerca de todas las demás partes, lo cual no es muy modular. Para
aplicaciones pequeñas como la de este capítulo, eso puede no ser un problema.
Para proyectos más grandes, puede convertirse en una verdadera pesadilla.
Para evitar esta pesadilla en principio, vamos a ser estrictos acerca del flujo
de datos. Hay un estado, y la interfaz se dibuja basada en ese estado. Un
componente de la interfaz puede responder a las acciones del usuario actual-
izando el estado, momento en el cual los componentes tienen la oportunidad
de sincronizarse con este nuevo estado.
En la práctica, cada componente se configura para que, cuando reciba un
nuevo estado, también notifique a sus componentes hijos, en la medida en que
estos necesiten ser actualizados. Configurar esto es un poco tedioso. Hacer que
esto sea más conveniente es el principal punto de venta de muchas bibliotecas
de programación para el navegador. Pero para una aplicación pequeña como
esta, podemos hacerlo sin dicha infraestructura.
Las actualizaciones al estado se representan como objetos, a los que lla-
maremos acciones. Los componentes pueden crear tales acciones y despachar
(enviarlos) a una función central de gestión de estado. Esa función calcula el
próximo estado, tras lo cual los componentes de la interfaz se actualizan a este
nuevo estado.
Estamos tomando la tarea desordenada de ejecutar una interfaz de usuario y
aplicándole estructura. Aunque las piezas relacionadas con el DOM aún están
llenas de efectos secundarios, están respaldadas por un esqueleto conceptual-
mente simple: el ciclo de actualización de estado. El estado determina cómo
332

-- 344 of 445 --

se ve el DOM, y la única forma en que los eventos del DOM pueden cambiar
el estado es despachando acciones al estado.
Hay muchas variantes de este enfoque, cada una con sus propios beneficios
y problemas, pero su idea central es la misma: los cambios de estado deben
pasar por un canal único y bien definido, no suceder por todas partes.
Nuestros componentes serán clases que cumplan con una interfaz. Su con-
structor recibe un estado, que puede ser el estado de toda la aplicación o algún
valor más pequeño si no necesita acceso a todo, y lo utiliza para construir una
propiedad dom. Este es el elemento DOM que representa el componente. La
mayoría de los constructores también tomarán otros valores que no cambiarán
con el tiempo, como la función que pueden utilizar para despachar una acción.
Cada componente tiene un método syncState que se utiliza para si
