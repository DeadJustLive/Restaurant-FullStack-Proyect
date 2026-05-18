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
• En primer lugar hay que pulsar el botón de «¡JUGAR!».
506 Capítulo 9. Scraping

-- 510 of 516 --

Aprende Python
• El elemento sobre el que enviar texto podría ser directamente el «body».
• Puede ser visualmente interesante poner un time.sleep(0.5) tras la inserción de cada
letra.
• Una vez enviada la cadena de texto hay que pulsar ENTER.
Borrar contenido
Si queremos borrar el contenido de un elemento web editable, típicamente una caja de texto,
lo podemos hacer usando el método .clear().
Manejo de selects
Los elementos de selección <select> pueden ser complicados de manejar a nivel de
automatización. Para suplir esta dificultad, Selenium proporciona el objecto Select.
Supongamos un ejemplo en el que modificamos el idioma de búsqueda de Wikipedia. En
primer lugar hay que acceder a la web y seleccionar el desplegable del idioma de búsqueda:
>>> from selenium import webdriver
>>> from selenium.webdriver.support.select import Select
>>> driver = webdriver.Firefox()
>>> driver.get( https://wikipedia.org )
>>> lang = driver.find_element_by_id( searchLanguage )
>>> lang_handler = Select(lang)
Ahora vamos a seleccionar el idioma inglés como idioma de búsqueda:
>>> # Selección por el índice que ocupa cada "option" (base 0)
>>> lang_handler.select_by_index(17)
>>> # Selección por el campo "value" de cada "option"
>>> lang_handler.select_by_value( en )
>>> # Selección por el texto visible de cada "option"
>>> lang_handler.select_by_visible_text( English )
Truco: Estas tres funciones tienen su correspondiente deselect_by_<accesor>.
Si queremos identificar las opciones que están actualmente seleccionadas, podemos usar los
siguientes atributos:
9.3. selenium 507

-- 511 of 516 --

Aprende Python
>>> lang_handler.all_selected_options
[<selenium.webdriver.firefox.webelement.FirefoxWebElement (session="8612e5b7-6e66-
˓→4121-8869-ffce4139d197", element="8433ffdb-a8ad-4e0e-9367-d63fe1418b94")>]
>>> lang_handler.first_selected_option
<selenium.webdriver.firefox.webelement.FirefoxWebElement (session="8612e5b7-6e66-
˓→4121-8869-ffce4139d197", element="8433ffdb-a8ad-4e0e-9367-d63fe1418b94")>
También es posible listar todas las opciones disponibles en el elemento select:
>>> lang_handler.options
[..., ..., ...]
Ver también:
API del objeto Select
9.3.6 Acceso a atributos
Como ya hemos comentado, los objetos del DOM con los que trabaja Selenium son de tipo
FirefoxWebElement. Veremos los mecanismos disponibles para poder acceder a sus atributos.
Para ejemplificar el acceso a la información de los elementos del DOM, vamos a localizar
el botón de descarga en la web de Ubuntu:
>>> from selenium import webdriver
>>> driver = webdriver.Firefox()
>>> driver.get( https://ubuntu.com/ )
>>> # Aceptar las cookies
>>> cookies = driver.find_element_by_id( cookie-policy-button-accept )
>>> cookies.click()
>>> download_btn = driver.find_element_by_id( takeover-primary-url )
Nombre de etiqueta
>>> download_btn.tag_name
a
508 Capítulo 9. Scraping

-- 512 of 516 --

Aprende Python
Tamaño y posición
Para cada elemento podemos obtener un diccionario que contiene la posición en pantalla
(𝑥, 𝑦) acompañado del ancho y del alto (todo en píxeles):
>>> download_btn.rect
{ x : 120.0,
y : 442.3999938964844,
width : 143.64999389648438,
height : 36.80000305175781}
Estado
Veamos las funciones disponibles para saber si un elemento se está mostrando, está habilitado
o está seleccionado:
>>> download_btn.is_displayed()
True
>>> download_btn.is_enabled()
True
>>> download_btn.is_selected()
False
Propiedad CSS
En caso de querer conocer el valor de cualquier propiedad CSS de un determinado elemento,
lo podemos conseguir así:
>>> download_btn.value_of_css_property( background-color )
rgb(14, 132, 32)
>>> download_btn.value_of_css_property( font-size )
16px
9.3. selenium 509

-- 513 of 516 --

Aprende Python
Texto del elemento
Cuando un elemento incluye texto en su contenido, ya sea de manera directa o mediante
elementos anidados, es posible acceder a esta información usando:
>>> download_btn.text
Download Now
Elemento superior
Selenium también permite obtener el elemento superior que contiene a otro elemento dado:
>>> download_btn.parent
<selenium.webdriver.firefox.webdriver.WebDriver (session="8612e5b7-6e66-4121-8869-
˓→ffce4139d197")>
Propiedad de elemento
De manera más genérica, podemos obtener el valor de cualquier atributo de un elemento del
DOM a través de la siguiente función:
>>> download_btn.get_attribute( href )
https://ubuntu.com/engage/developer-desktop-productivity-whitepaper
9.3.7 Esperas
Cuando navegamos a un sitio web utilizando driver.get() es posible que el elemento que
estamos buscando no esté aún cargado en el DOM porque existan peticiones asíncronas
pendientes o contenido dinámico javascript. Es por ello que Selenium pone a nuestra
disposición una serie de esperas explícitas hasta que se cumpla una determinada condición.
Las esperas explícitas suelen hacer uso de condiciones de espera. Cada una de estas funciones
se puede utilizar para un propósito específico. Quizás una de las funciones más habituales
sea presence_of_element_located().
Veamos un ejemplo en el que cargamos la web de Stack Overflow y esperamos a que el pie
de página esté disponible:
>>> from selenium.webdriver.support.ui import WebDriverWait
>>> from selenium.webdriver.support import expected_conditions as EC
>>> from selenium.webdriver.common.by import By
>>> driver.get( https://stackoverflow.com )
(continué en la próxima página)
510 Capítulo 9. Scraping

-- 514 of 516 --

Aprende Python
(proviene de la página anterior)
>>> footer = WebDriverWait(driver, 10).until(
... EC.presence_of_element_located((By.ID, footer )))
>>> print(footer.text)