# 1.3 Python

## Fuente
Aprende Python (Cap. 4)

## Contenido
# 1.3 Python

Python es un lenguaje de programación de alto nivel creado a finales de los 80/principios de
los 90 por Guido van Rossum, holandés que trabajaba por aquella época en el Centro para
las Matemáticas y la Informática de los Países Bajos. Sus instrucciones están muy cercanas
al lenguaje natural en inglés y se hace hincapié en la legibilidad del código. Toma su
nombre de los Monty Python, grupo humorista de los 60 que gustaban mucho a Guido.
Python fue creado como sucesor del lenguaje ABC.1
1.3.1 Características del lenguaje
A partir de su definición de la Wikipedia:
• Python es un lenguaje de programación interpretado y multiplataforma cuya
filosofía hace hincapié en una sintaxis que favorezca un código legible.
• Se trata de un lenguaje de programación multiparadigma, ya que soporta
orientación a objetos, programación imperativa y, en menor medida,
programación funcional.
• Añadiría, como característica destacada, que se trata de un lenguaje de propósito
general.
1 Foto original por Markéta Marcellová en Unsplash.
1.3. Python 13

-- 17 of 516 --

Aprende Python
Ventajas
• Libre y gratuito (OpenSource).
• Fácil de leer, parecido a pseudocódigo.
• Aprendizaje relativamente fácil y rápido: claro, intuitivo….
• Alto nivel.
• Alta Productividad: simple y rápido.
• Tiende a producir un buen código: orden, limpieza, elegancia, flexibilidad, …
• Multiplataforma. Portable.
• Multiparadigma: programación imperativa, orientada a objetos, funcional, …
• Interactivo, modular, dinámico.
• Librerías extensivas («pilas incluídas»).
• Gran cantidad de librerías de terceros.
• Extensible (C++, C, …) y «embebible».
• Gran comunidad, amplio soporte.
• Interpretado.
• Tipado dinámico5.
• Fuertemente tipado6.
Desventajas
• Interpretado (velocidad de ejecución, multithread vs GIL, etc.).
• Consumo de memoria.
• Errores durante la ejecución.
• Dos versiones mayores no del todo compatibles (v2 vs v3).
• Desarrollo móvil.
• Documentación a veces dispersa e incompleta.
• Varios módulos para la misma funcionalidad.
• Librerías de terceros no siempre del todo maduras.
5 Tipado dinámico significa que una variable puede cambiar de tipo durante el tiempo de vida de un
programa. C es un lenguaje de tipado estático.
6 Fuertemente tipado significa que, de manera nativa, no podemos operar con dos variables de tipos
distintos, a menos que realice una conversión explícita. Javascript es un lenguaje débilmente tipado.
14 Capítulo 1. Introducción

-- 18 of 516 --

Aprende Python
1.3.2 Uso de Python
Al ser un lenguaje de propósito general, podemos encontrar aplicaciones prácticamente en
todos los campos científico-tecnológicos:
• Análisis de datos.
• Aplicaciones de escritorio.
• Bases de datos relacionales / NoSQL
• Buenas prácticas de programación / Patrones de diseño.
• Concurrencia.
• Criptomonedas / Blockchain.
• Desarrollo de aplicaciones multimedia.
• Desarrollo de juegos.
• Desarrollo en dispositivos embebidos.
• Desarrollo web.
• DevOps / Administración de sistemas / Scripts de automatización.
• Gráficos por ordenador.
• Inteligencia artificial.
• Internet de las cosas.
• Machine Learning.
• Programación de parsers / scrapers / crawlers.
• Programación de redes.
• Propósitos educativos.
• Prototipado de software.
• Seguridad.
• Tests automatizados.
De igual modo son muchas las empresas, instituciones y organismos que utilizan Python en
su día a día para mejorar sus sistemas de información. Veamos algunas de las más relevantes:
Existen ránkings y estudios de mercado que sitúan a Python como uno de los lenguajes más
usados y la vez, más amados dentro del mundo del desarrollo de software.
En el momento de la escritura de este documento, la última actualización del Índice TIOBE
es de febrero de 2022 en el que Python ocupaba el primer lugar de los lenguajes de
programación más usados, por delante de C y Java.
1.3. Python 15

-- 19 of 516 --

Aprende Python
Figura 4: Grandes empresas y organismos que usan Python
Figura 5: Índice TIOBE 2022
16 Capítulo 1. Introducción

-- 20 of 516 --

Aprende Python
Igualmente en la encuesta a desarrolladores de Stack Overflow hecha en 2022, Python
ocupaba el cuarto puesto de los lenguajes de programación más populares, sólo
por detrás de Javascript, HTML/CSS y SQL:
Figura 6: Encuesta Stack Overflow 2022
1.3.3 Python2 vs Python3
En el momento de la escritura de este material, se muestra a continuación la evolución de
las versiones mayores de Python a lo largo de la historia:3
Versión Fecha de lanzamiento
Python 1.0 Enero 1994
Python 1.5 Diciembre 1997
Python 1.6 Septiembre 2000
Python 2.0 Octubre 2000
Python 2.1 Abril 2001
Python 2.2 Diciembre 2001
Python 2.3 Julio 2003
Python 2.4 Noviembre 2004
Python 2.5 Septiembre 2006
Python 2.6 Octubre 2008
Python 2.7 Julio 2010
Python 3.0 Diciembre 2008
Python 3.1 Junio 2009
Python 3.2 Febrero 2011
Python 3.3 Septiembre 2012
Python 3.4 Marzo 2014
Python 3.5 Septiembre 2015
continué en la próxima página
3 Fuente: python.org.
1.3. Python 17

-- 21 of 516 --

Apre
