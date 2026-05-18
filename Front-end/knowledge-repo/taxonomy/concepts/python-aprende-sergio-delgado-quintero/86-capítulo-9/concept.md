# CAPÍTULO 9

## Fuente
Aprende Python (Cap. 86)

## Contenido
# CAPÍTULO 9

Scraping
Si bien existen multitud de datos estructurados en forma de ficheros, hay otros muchos que
están embebidos en páginas web y que están preparados para ser visualizados mediante un
navegador.
Sin embargo, las técnicas de «scraping» nos permiten extraer este tipo de información
web para convertirla en datos estructurados con los que poder trabajar de forma más
cómoda.
Los paquetes que veremos en este capítulo bien podrían estar incluidos en otras temáticas,
ya que no sólo se utilizan para «scraping».
475

-- 479 of 516 --

Aprende Python
9.1 requests
El paquete requests es uno de los paquetes más famosos del ecosistema Python. Como dice
su lema «HTTP for Humans» permite realizar peticiones HTTP de una forma muy sencilla
y realmente potente.1
$ pip install requests
9.1.1 Realizar una petición
Realizar una petición HTTP mediante requests es realmente sencillo:
>>> import requests
>>> response = requests.get( https://pypi.org )
Hemos ejecutado una solicitud GET al sitio web https://pypi.org. La respuesta se almacena
en un objeto de tipo requests.models.Response muy rica en métodos y atributos que
veremos a continuación:
>>> type(response)
requests.models.Response
1 Foto original de portada por Frame Harirak en Unsplash.
476 Capítulo 9. Scraping

-- 480 of 516 --

Aprende Python
Quizás lo primero que nos interese sea ver el contenido de la respuesta. En este sentido
requests nos provee del atributo text que contendrá el contenido html del sitio web en
cuestión como cadena de texto:
>>> response.text
\n\n\n\n\n\n<!DOCTYPE html>\n<html lang="en" dir="ltr">\n <head>\n <meta␣
˓→charset="utf-8">\n <meta http-equiv="X-UA-Compatible" content="IE=edge">\n
˓→<meta name="viewport" content="width=device-width, initial-scale=1">\n\n <meta␣
˓→name="defaultLanguage" content="en">\n <meta name="availableLanguages" content=
˓→"en, es, fr, ja, pt_BR, uk, el, de, zh_Hans, zh_Hant, ru, he, eo">\n\n \n\n
˓→<title>PyPI · The Python Package Index</title>\n <meta name="description"␣
˓→content="The Python Package Index (PyPI) is a repository of software for the␣
˓→Python programming language.">\n\n <link rel="stylesheet" href="/static/css/
˓→warehouse-ltr.69ee0d4e.css">\n <link rel="stylesheet" href="/static/css/
˓→fontawesome.6002a161.css">\n <link rel="stylesheet" href="/static/css/regular.
˓→98fbf39a.css">\n <link rel="stylesheet" href="/static/css/solid.c3b5f0b5.css">\
˓→n <link rel="stylesheet" href="/static/css/brands.2c303be1.css">\n <link rel=
˓→"stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,
˓→400italic,600,600italic,700,700italic%7CSource+Code+Pro:500">\n <noscript>\n ␣
˓→ <link rel="stylesheet" href="/static/css/noscript.d4ce1e76.css">\n
Nota: Se ha recortado la salida a efectos visuales.
Algo que es realmente importante en una petición HTTP es comprobar el estado de la
misma. Por regla general, si todo ha ido bien, deberíamos obtener un código 200, pero
existen muchos otros códigos de estado de respuesta HTTP:
>>> response.status_code
200
Truco: Para evitar la comparación directa con el literal 200, existe la variable requests.
codes.ok.
9.1.2 Tipos de peticiones
Con requests podemos realizar peticiones mediante cualquier método HTTP2. Para ello,
simplemente usamos el método correspondiente del paquete:
2 Métodos de petición HTTP.
9.1. requests 477

-- 481 of 516 --

Aprende Python
Método HTTP Llamada
GET requests.get()
POST requests.post()
PUT requests.put()
DELETE requests.delete()
HEAD requests.head()
OPTIONS requests.options()
9.1.3 Usando parámetros
Cuando se realiza una petición HTTP es posible incluir parámetros. Veamos distintas
opciones que nos ofrece requests para ello.
Query string
En una petición GET podemos incluir parámetros en el llamado «query string». Los
parámetros se definen mediante un diccionario con nombre y valor de parámetro.
Veamos un ejemplo sencillo. Supongamos que queremos buscar paquetes de Python que
contengan la palabra «astro»:
>>> payload = { q : astro }
>>> response = requests.get( https://pypi.org , params=payload)
>>> response.url
https://pypi.org/?q=astro
Truco: El atributo url nos devuelve la URL a la se ha accedido. Útil en el caso de paso de
parámetros.
Parámetros POST
Una petición POST, por lo general, siempre va acompañada de una serie de parámetros que
típicamente podemos encontrar en un formulario web. Es posible realizar estas peticiones en
requests adjuntando los parámetros que necesitemos en el mismo formato de diccionario que
hemos visto para «query string».
Supongamos un ejemplo en el que tratamos de logearnos en la página de GIPHY con
478 Capítulo 9. Scraping

-- 482 of 516 --

Aprende Python
nombre de usuario y contraseña. Para ello, lo primero que debemos hacer es inspeccionar3
los elementos del formulario e identificar los nombres («name») de los campos. En este caso
los campos son email y password:
>>> url = https://giphy.com/login
>>> payload = { email : sdelquin@gmail.com , password : 1234 }
>>> response = requests.p
