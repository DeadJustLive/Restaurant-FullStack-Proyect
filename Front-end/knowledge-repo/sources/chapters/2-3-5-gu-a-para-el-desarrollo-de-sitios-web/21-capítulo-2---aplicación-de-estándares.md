# Capítulo 2: - Aplicación de Estándares

www.guiaweb.gob.cl > 37
Pequeño párrafo describiendo el error en lenguaje no técnico (no más de dos
líneas). Por ejemplo, "El documento solicitado no existe o ha cambiado de
ubicación; puede buscarlo a través del Mapa del sitio".
Buscador interno del sitio web para ayudar a encontrar lo que buscaba
cuando apareció el error.
Mapa del sitio web para ubicar al usuario respecto del contenido existente.
Contingencias (DS100/2006 Art. 7°)
Este artículo señala que el organismo dueño
del 	sitio 	web 	debe 	tener 	un 	Plan 	de
Contingencia que incluya "las medidas a ser
ejecutadas en el caso de que el sitio web deje
de estar disponible para el público, o que el
nivel de acceso disminuya o sea intermitente,
o 	que 	se 	vea 	comprometido 	por 	ataques
externos".
Es importante entender que el alcance de este
artículo debe estar relacionado con el Decreto 83/2004 del Ministerio Secretaría
General de la Presidencia que ya fue tratado en el Capítulo 1 de esta Guía, debido
a que allí se plantea la obligación de contar con políticas de seguridad permanente.
Allí se solicita la generación de planes de contingencia frente a fenómenos de toda
índole que pudieran poner en riesgo la continuidad operacional de los sistemas de
información, detallando con claridad cuáles deben ser las acciones a seguir.
Codificación de Caracteres (DS 100/2006 Art. 8°)
Este artículo señala que para la codificación de caracteres se utilizará preferente-
mente UTF-8, sigla que significa “8-bit Unicode Transformation Format”.
Al respecto se debe indicar que la codificación de caracteres es un elemento que
se declara en la sección <head> de cada página y permite que el programa
navegador interprete adecuadamente los símbolos (letras, números y otros) que
se incluyan en la misma. En el caso de la recomendación de este artículo, debe
agregarse la siguiente línea:
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
HTTP: Hyper Text
Transfer Protocol,
protocolo de
transferencia de
hipertexto, que
determina la forma en
que son transmitidos
los contenidos de un
sitio web.

-- 37 of 122 --

38 < www.guiaweb.gob.cl
La utilización de este conjunto de caracteres está relacionada con la aplicación del
Decreto 81/2004 del Ministerio Secretaría General de la Presidencia, que se refiere
a la interoperabilidad. Allí se plantea la obligación de que los documentos electró-
nicos que se generen en los órganos de la Administración Pública utilicen XML
para los documentos y UTF-8 como conjunto para la codificación de caracteres.
Política de Privacidad (DS100/2006 Art. 9°)
Este artículo determina que los Sitios Web deben contar con una Política de
Privacidad de los Datos Personales de los usuarios que acceden a éste, en la cual
se den a conocer las obligaciones y derechos que tienen por el hecho de entregar
sus datos en las pantallas del sitio web.
Respecto del contenido de dicha política, el Proyecto de Reforma y Modernización
del Estado del Ministerio Secretaria General de la Presidencia emitió el documento
titulado "Guía Modelo de Políticas de Privacidad"13 en el que se explica la forma
de cumplir con esta norma y se entrega un documento de base para crear la corres-
pondiente a cada organismo.
> Nivel II - DS100/2006
Su objetivo es que los Sitios Web cumplan “las
directrices principales de las normas internacio-
nales de accesibilidad" con el fin de permitir un
grado de acceso a las personas con discapacidades.
Para ello se deben cumplir las normas indicadas en
el Título III del decreto que corresponde a los
artículos 10° a 14° y el plazo para ello fue fijado
a dos años de la promulgación del decreto, vale
decir, al 12 de agosto de 2008. A continuación se
revisa el contenido de los artículos y la forma de darles cumplimiento.
Diagramación con CSS (DS100/2006 Art. 10°)
Este artículo indica que las páginas de los Sitios Web deben ser diagramadas
utilizando hojas de estilo en cascada (CSS por su sigla en inglés), indicando que se
debe separar "el contenido, la estructura y la presentación de los primeros".
Este es un cambio de importancia respecto de la situación actual, ya que incluso
hasta la aparición de la Guía Web Versión 1.014 habitualmente se empleaban tablas
para disponer los elementos en las páginas, facilitando de esa manera su ubicación
en la pantalla.
Guía para Desarrollo de Sitios Web - Versión 2 - Gobierno de Chile
13.- Ver documento en http://www.modernizacion.cl/1350/article-140397.html
14.- Ver información al respecto en http://www.guiaweb.gob.cl/guia/capitulos/tres/accesorapido.htm#t04diagramas
La Guía Modelo
de Políticas de
Privacidad se puede
bajar desde
http://www.moderni
zacion.cl/1350/arti
cle-140397.html.

-- 38 of 122 --