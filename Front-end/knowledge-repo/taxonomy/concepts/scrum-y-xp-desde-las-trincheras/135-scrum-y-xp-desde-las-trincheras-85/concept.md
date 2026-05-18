# SCRUM Y XP DESDE LAS TRINCHERAS | 85

## Fuente
scrum-y-xp-desde-las-trincheras (Cap. 135)

## Contenido
# SCRUM Y XP DESDE LAS TRINCHERAS | 85

Propiedad colectiva del código
Apoyamos el concepto de propiedad colectiva del código, pero no todos los
equipos lo han adoptado aun. Hemos encontrado que la programación por
parejas con una rotación frecuente de las parejas conduce a un nivel elevado de
propiedad colectiva del código.
Los equipos que tienen un alto nivel de propiedad colectiva del código han
probado ser muy robustos. Por ejemplo, sus Sprints no fallan simplemente
porque una persona clave esté enferma.
Espacio informativo
Todos los equipos tienen acceso a pizarras y espacios vacíos en las paredes, y
hacen buen uso de ellos. En la mayoría de las salas encontrarás las paredes
empapeladas de toda clase de información sobre el producto y el proyecto. El
principal problema es que se va acumulando porquería vieja en las paredes, por
lo que puede que introduzcamos un rol de “responsable de limpieza” en cada
equipo.
Apoyamos en uso de paneles de tareas, pero no todos los equipos lo han
adoptado aun. Ver “Cómo distribuimos la sala del equipo”
Estandarización de código
Últimamente hemos comenzado a definir un estándar de código. Muy útil, ojala lo
hubiéramos hecho antes. Prácticamente no cuesta nada de tiempo: comienza
con algo simple y deja que vaya creciendo con el tiempo. Escribe únicamente
material que no sea obvio para todo el mundo y enlaza a material ya existente
siempre que sea posible.
La mayoría de los programadores tienen su propio y distintivo estilo de
programación. 	Pequeños 	detalles 	como 	la 	forma 	en 	la 	que 	tratan 	las
excepciones, cómo comentan el código, cuándo devuelven un valor null, etc. En
algunos casos esta diferencia no importa, pero en otros puede conducir a una
severa inconsistencia del diseño del sistema y a un código difícil de leer. Un
estándar de código ayuda a que esto no ocurra, siempre que te concentres en
las cosas que importan.
He aquí algunos ejemplos de nuestro estándar de código:
• 	Puedes romper estas reglas, pero asegúrate de que hay una buena razón
para ello y documéntala.
• 	Usa las convenciones de código de Sun por defecto:
http://java.sun.com/docs/codeconv/html/CodeConvTOC.doc.html
• 	Nunca, nunca, nunca captures excepciones sin registrar la traza de la pila
(stack trace) o relanzar. log.debug() esta bien, pero no pierdas esa traza
de la pila.

-- 85 of 122 --
