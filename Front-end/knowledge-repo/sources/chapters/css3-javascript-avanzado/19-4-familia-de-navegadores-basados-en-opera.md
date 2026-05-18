# 4) Familia de navegadores basados en Opera.

Cabe resaltar que sólo hablamos de la tecnología￿de￿dibujo, o sea, la parte del
software que lee el documento sgml, le aplica los estilos que encuentra en la
hoja de estilo y lo dibuja en la pantalla (o cualquiera otra salida). Además de
esto, un navegador (cliente web) también contiene un intérprete de Javascript
que nos permite ejecutar secuencias de pedidos e interactuar con el DOM (do-
cument￿object￿model), el conjunto de sgml con los estilos aplicados.
Esta aclaración la hacemos porque a partir de aquí, cuando hablamos de las
diferentes novedades y técnicas disponibles con la revisión tercera, esclarece-
remos en qué motores de dibujo funciona, para poder extraer las propiedades
más comunes que podemos utilizar a día de hoy en el proceso de confección
de espacios web.

-- 9 of 86 --

CC-BY-SA • PID_00176160 10 CSS3 y Javascript avanzado
1.4. Beneficios del uso del CSS3
1)￿Reducción￿del￿tiempo￿de￿desarrollo￿y￿mantenimiento
Utilizar propiedades y métodos de CSS3 puede ser un beneficio directo a la ho-
ra de desarrollar, puesto que nos ahorramos bastante trabajo, como por ejem-
plo a la hora de hacer fondo con esquinas redondeadas. Antes había que ha-
cerlo con imágenes. También ahorramos mucho trabajo a la hora de hacer
sombras, ya que nos ahorramos de nuevo la imagen que teníamos que usar
antes (normalmente un gráfico en formato png).
También podemos mejorar el rendimiento al tener menos código, divs dentro
de divs, etc.
2)￿Incrementar￿el￿rendimiento￿de￿las￿páginas
Menos etiquetas html indican menos código a la hora de descargarse del ser-
vidor y menos código a la hora de interpretar y dibujar el navegador. Dos aho-
rros, uno de ancho de banda y el otro de rendimiento del ordenador. Además,
muchas de las técnicas de CSS3 nos ahorran imágenes, que a la vez cumplen
la doble premisa de rendimiento.
1.5. La mejora progresiva
Uno de los elementos clave a la hora de emplear CSS es utilizar una técnica de
desarrollo llamada mejora progresiva, y que consiste en empezar por generar
un código genérico que funcione en todos los navegadores, para, poco a poco,
ir introduciendo mejoras para navegadores más modernos. Esto lo permite,
ya que los intérpretes de CSS de los navegadores ignoran una propiedad si no
la conocen.
Empleando esta técnica logramos un control total óptimo del aspecto, puesto
que a mejores prestaciones del navegador, mejor visualización.

-- 10 of 86 --

CC-BY-SA • PID_00176160 11 CSS3 y Javascript avanzado