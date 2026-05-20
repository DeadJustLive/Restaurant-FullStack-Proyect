# PARTIAL_LINK_TEXT

## Fuente
Aprende Python (Cap. 87)

## Contenido
# PARTIAL_LINK_TEXT

Atributo NAME find_elements_by_name() By.NAME
Nombre de etiqueta find_elements_by_tag_name() By.TAG_NAME
XPath find_elements_by_xpath() By.XPATH
Todas estas funciones tienen su correspondiente versión para devolver un único elemento
que cumpla con el filtro especificado. En caso de que hayan varios, sólo se devolverá el primero
de ellos. El nombre de estas funciones sigue el patrón en singular:
find_element_by_<accesor>()
Si te estás preguntando para qué sirve el localizador de la tabla anterior, es porque
también existe la opción de localizar elementos mediante una función genérica:
>>> from selenium.webdriver.common.by import By
>>> # Estas dos llamadas tienen el mismo significado
>>> driver.find_elements_by_class_name( matraca )
>>> driver.find_elements(By.CLASS_NAME, matraca )
Veamos un ejemplo práctico de esto. Supongamos que queremos obtener los epígrafes
principales de la tabla de contenidos de «Aprende Python»:
>>> from selenium import webdriver
>>> driver = webdriver.Firefox()
>>> driver.get( https://aprendepython.es )
(continué en la próxima página)
4 Document Object Model.
9.3. selenium 503

-- 507 of 516 --

Aprende Python
(proviene de la página anterior)
>>> toc = driver.find_elements_by_css_selector( div.sidebar-tree li.toctree-l1 )
>>> for heading in toc:
... print(heading.text)
...
Introducción
Entornos de desarrollo
Tipos de datos
Control de flujo
Estructuras de datos
Modularidad
Procesamiento de texto
Ciencia de datos
Scraping
Truco: Un poco más adelante veremos la forma de acceder a la información que contiene
cada elemento del DOM.
Cada elemento que obtenemos con las funciones de localización es de tipo
FirefoxWebElement:
>>> from selenium import webdriver
>>> driver = webdriver.Firefox()
>>> driver.get( https://aprendepython.es )
>>> element = driver.find_element_by_id( aprende-python )
>>> type(element)
selenium.webdriver.firefox.webelement.FirefoxWebElement
9.3.5 Interacciones
Si bien el acceso a la información de un sitio web puede ser un objetivo en sí mismo, para
ello podríamos usar herramientas como requests. Sin embargo, cuando entra en juego la
interacción con los elementos del DOM, necesitamos otro tipo de aproximaciones.
Selenium nos permite hacer clic en el lugar deseado, enviar texto por teclado, borrar una
caja de entrada o manejar elementos de selección, entre otros.
504 Capítulo 9. Scraping

-- 508 of 516 --

Aprende Python
Clic
Para hacer clic utilizamos la función homónima. Veamos un ejemplo en el que accedemos
a https://amazon.es y tenemos que aceptar las «cookies» haciendo clic en el botón
correspondiente:
>>> driver = webdriver.Firefox()
>>> driver.get( https://amazon.es )
>>> accept_cookies = driver.find_element_by_id( sp-cc-accept )
>>> accept_cookies.click()
Inspeccionando el DOM
Una tarea inherente a las técnicas de «scraping» y a la automatización de comportamientos
para navegadores web es la de inspeccionar los elementos del DOM. Esto se puede
hacer desde las herramientas para desarrolladores que incluyen los navegadores5.
Figura 1: Botón de «cookies» en amazon.es
Para el ejemplo anterior de Amazon en el que debemos identificar el botón para aceptar
«cookies», abrimos el inspector de Firefox y descubrimos que su id es sp-cc-accept. Si
no lo tuviéramos disponible habría que hacer uso de otros localizadores como «xpath» o
selectores de estilo.
Ejercicio
5 Para Firefox tenemos a disposición la herramienta Inspector.
9.3. selenium 505

-- 509 of 516 --

Aprende Python
Escriba un programa en Python que, utilizando Selenium, pulse el botón de «¡JUGAR!»
en el sitio web https://wordle.danielfrg.com/. Los selectores «xpath» pueden ser de mucha
ayuda.
Enviar texto
Típicamente encontraremos situaciones donde habrá que enviar texto a algún campo de
entrada de un sitio web. Selenium nos permite hacer esto.
Veamos un ejemplo en el que tratamos de hacer login sobre PyPI:
>>> driver = webdriver.Firefox()
>>> driver.get( https://pypi.org/account/login/ )
>>> username = driver.find_element_by_id( username )
>>> password = driver.find_element_by_id( password )
>>> username.send_keys( sdelquin )
>>> password.send_keys( 1234 )
>>> login_btn_xpath = //*[@id="content"]/div/div/form/div[2]/div[3]/div/div/input
>>> login_btn = driver.find_element_by_xpath(login_btn_xpath)
>>> login_btn.click()
En el caso de que queramos enviar alguna tecla «especial», Selenium nos proporciona un
conjunto de símbolos para ello, definidos en selenium.webdriver.common.keys.
Por ejemplo, si quisiéramos enviar las teclas de cursor, haríamos lo siguiente:
>>> from selenium.webdriver.common.keys import Keys
>>> element.send_keys(Keys.RIGHT) # →
>>> element.send_keys(Keys.DOWN) # ↓
>>> element.send_keys(Keys.LEFT) # ←
>>> element.send_keys(Keys.UP) # ↑
Ejercicio
Escriba un programa en Python utilizando Selenium que, dada una palabra de 5 caracteres,
permita enviar ese «string» a https://wordle.danielfrg.com/ para jugar.
Tenga en cuenta lo siguiente:
• En primer lugar hay que pulsar el botó
