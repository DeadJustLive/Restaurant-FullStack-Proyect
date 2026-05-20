# 3. Codificar y escapar los datos

Éstas son técnicas defensivas, cuyo
objetivo es detener ataques de
inyección, ya sean SQL, XSS u otros.
Codificar consiste en transformar o
traducir ciertos caracteres especiales en
otros caracteres equivalentes pero
inofensivos para el intérprete. Por
ejemplo, el carácter “<” se traduce en
“&lt;”.
Escapar caracteres es una técnica
similar, con la diferencia que en lugar de
reemplazar un carácter por otro, se
añade un carácter especial antes del
dato a escapar, para prevenir
interpretaciones erróneas, por ejemplo,
añadiendo un “\” antes de caracteres
como [“] (comillas dobles), para que sea
interpretado como texto y no como el
cierre de un string.
Es fundamental realizar este escapado
y/o codificación de datos en un entorno
confiable (en el servidor y no en el
navegador del usuario), de forma tal, de
evitar el “doble escapado” que genera
errores de despliegue de los datos (por
ejemplo, si escapamos antes de
almacenar en la base de datos y
nuevamente cuando se despliega al
usuario).
Para evitar ataques XSS se deben
utilizar los mecanismos conocidos
como Contextual Output Encoding, que
nos permiten prevenir el despliegue de
contenido malicioso en el navegador del
usuario.
Existen otros tipos de codificación y
escape, tales como shell escaping, XML
escaping, LDAP escaping y otros, que
podrán ser utilizados en la medida que
sea necesario.
Un sistema debe considerar como
potencialmente inseguros todos los
datos que provengan desde fuera de la
aplicación, así como también los datos
que provienen desde la base de datos
(en caso que se haya modificado
División de Gobierno Digital | Lineamientos para desarrollo de software 	9

-- 9 of 33 --

maliciosamente la misma). Por ello,
deben ser correctamente codificados
y/o escapados siempre, pero sin olvidar
el contexto de los datos, por ejemplo, si
es HTML, datos alfanuméricos u otros.
Se deben considerar también las
validaciones de datos, descritas a
continuación.