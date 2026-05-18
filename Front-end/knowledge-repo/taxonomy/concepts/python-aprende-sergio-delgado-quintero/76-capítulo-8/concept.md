# CAPÍTULO 8

## Fuente
Aprende Python (Cap. 76)

## Contenido
# CAPÍTULO 8

Ciencia de datos
La Ciencia de Datos representa uno de los ámbitos de aplicación más importantes dentro
del mundo Python. De hecho, en la encuesta a desarrolladores/as de JetBrains del año 2021
se puede observar que análisis de datos y aprendizaje automático están en primera y
cuarta opción en la pregunta ¿para qué utiliza Python?.
Muchos de los paquetes que veremos en esta sección también vienen incluidos por defecto
en Anaconda una plataforma para desarrollo de ciencia de datos que dispone de instaladores
para todos los sistemas operativos.
301

-- 305 of 516 --

Aprende Python
8.1 jupyter
El módulo jupyter proporciona un entorno de desarrollo integrado para ciencia de datos, que
no es exclusivo de Python, sino que además admite otros lenguajes en su «backend».1
$ pip install jupyter
Para lanzar el servidor de «notebooks»2:
$ jupyter notebook
Nota: Este comando nos debería abrir una ventana en el navegador web por defecto del
sistema, apuntando a la dirección http://localhost:8888
1 Foto original de portada por NASA en Unsplash.
2 Un «notebook» es el concepto de cuaderno (documento) científico que se maneja en Jupyter
302 Capítulo 8. Ciencia de datos

-- 306 of 516 --

Aprende Python
8.1.1 Notebooks
Un «notebook» es un documento que está compuesto por celdas en las que podemos incluir:
• Texto en formato markdown (incluyendo fórmulas).
• Elementos multimedia.
• Código Python ejecutable.
Figura 1: Ejecución de celdas en Jupyter Notebook
En código «markdown», la salida de la celda es la renderización del texto. En código Python,
la salida de la celda es el resultado de la última sentencia incluida en la celda.
Nota: Los «notebooks» o cuadernos son básicamente archivos de texto en formato json con
extensión .ipynb (que proviene de «IPython Notebook»).
8.1.2 Interfaz
Jupyter se presenta como una aplicación web en cuya interfaz podemos encontrar distintos
elementos que nos permitirán desarrollar nuestras tareas de programación de una forma más
cómoda.
Explorador de archivos
Lo primero que veremos al arrancar el servidor de «notebooks» será el explorador de
archivos con un diseño muy similar al de cualquier sistema operativo.
Nota: Los «notebooks» que se están ejecutando suelen tener un color verde en el icono,
mientras que los que están parados aparecen en gris.
8.1. jupyter 303

-- 307 of 516 --

Aprende Python
Figura 2: Explorador de archivos de Jupyter Notebook
Barra de menú
Menú Fichero
Del estilo de los menús tradicionales de aplicaciones, aquí podemos encontrar las principales
funciones sobre ficheros.
Checkpoints: Permiten guardar el estado del «notebook» en un momento determinado
para luego poder revertirlo a ese momento del tiempo.
Exportar notebooks: Es posible exportar «notebooks» a una gran variedad de formatos:
• Python (.py)
• HTML (.html)
• Reveal.js «slides» (.html)
• Markdown (.md)
• reST (.rst)
• PDF vía LaTeX (.pdf)
• asciidoc (.asciidoc)
• custom (.txt)
• LaTeX (.tex)
Ejercicio
Cree un «notebook» de prueba y descárgelo en formato HTML y Markdown.
304 Capítulo 8. Ciencia de datos

-- 308 of 516 --

Aprende Python
Figura 3: Menú Fichero de Jupyter Notebook
8.1. jupyter 305

-- 309 of 516 --

Aprende Python
Menú Edición
Este menú contiene las acciones que podemos realizar sobre una o varias celdas.
Las funciones las podríamos agrupar en gestión de celdas (cortar, pegar, borrar, dividir,
unir, mover, etc.) e inserción de imágenes seleccionando desde un cuadro de diálogo.
Menú Vista
Permite modificar el aspecto visual de determinados elementos de la aplicación.
Números de línea: Puede resultar interesante mostrar los números de línea en celdas que
contengan código.
Modo presentación (Cell Toolbar Slideshow) : Jupyter Notebook ofrece la
posibilidad de crear una presentación sobre el documento en el que estamos
trabajando. Cada celda se puede configurar con alguno de los siguientes tipos:
• Slide.
• Subslide.
• Fragment.
• Skip.
• Notes.
Etiquetas (Cell Toolbar Tags): Es interesante – entre otras – el uso de la etiqueta
raises-exception ya que nos permite ejecutar todas las celdas de un «notebook» sin
que el sistema se detenga por errores en la celda etiquetada, ya que estamos informando
que lanzará una excepción.
Menú Insertar
Insertar celda antes o después de la actual.
Menú Celda
Principalmente enfocado a la ejecución de las celdas que componen el «notebook».
Ejecución de celdas: La ejecución de celdas se puede hacer de forma individual o grupal
así como indicando el punto de partida (celda actual).
Tipo de celdas:
306 Capítulo 8. Ciencia de datos

-- 310 of 516 --

Aprende Python
Figura 4: Menú Edición de Jupyter Notebook
8.1. jupyter 307

-- 311 of 516 --

Aprende Python
Figura 5: Menú Vista de Jupyter Notebook
308 Capítulo 8. Ciencia de datos

-- 312 of 516 --

Aprende Python
Figura 6: Menú Insertar de Jupyter Notebook
Figura 7: Menú Celda de Jupyter Notebook
8.1. jupyter 309

-- 313 of 516 --

Aprende Python
• Code: para incluir código (se podrá ejecutar el lenguaje de program
