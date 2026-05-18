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
• Code: para incluir código (se podrá ejecutar el lenguaje de programación según
el «kernel» instalado).
• Markdown: para escribir texto utilizando sintaxis markdown.
• Raw: estas celdas no serán formateadas.
Salida de celdas: La ejecución de las celdas de código tiene (suele tener) una salida. Esta
salida se puede ocultar (si interesa). Incluso tenemos control sobre activar o desactivar
el «scroll» en caso de que la salida sea muy larga.
Menú Kernel
Permite gestionar el servicio que se encarga de lanzar los «notebooks».
Figura 8: Menú Kernel de Jupyter Notebook
El kernel es la capa de software que se encarga de ejecutar las celdas de nuestro «notebook»
que contienen código. Podemos tener instalados distintos «kernels» para un mismo Jupyter
Notebook. El kernel se puede interrumpir o reiniciar.
Hay veces, que debido a un error de programación o a procesos muy largos, podemos
encontrarnos con el «kernel» bloqueado durante un largo período de tiempo. En estas
310 Capítulo 8. Ciencia de datos

-- 314 of 516 --

Aprende Python
ocasiones es útil reiniciarlo para salvar esa situación.
Figura 9: Kernel ocupado
Menú Ayuda
Como cualquier aplicación, existe un menú de ayuda en el que se pueden encontrar enlaces
a referencias y manuales.
Uno de los elementos más interesantes de la ayuda es el uso de los «shortcuts»3. Aunque hay
muchos, dejamos aquí algunos de los más útiles:
Shortcut Acción
SHIFT + ENTER Ejecutar la celda actual
ALT + ENTER Ejecutar la celda actual y «abrir» una celda debajo
a Abrir una celda encima de la actual («above»)
b Abrir una celda debajo de la actual («below»)
m Convertir la celda actual a Markdown
y Convertir la celda actual a código
dd Borrar la celda actual
8.1.3 MathJax
MathJax es una biblioteca javascript que permite visualizar fórmulas matemáticas en
navegadores web, utilizando (entre otros) el lenguajes de marcado LaTeX. Para escribir
fórmulas matemáticas la celda debe ser de tipo Markdown y tendremos que usar
delimitadores especiales.
Fórmulas «en línea»: Se debe usar el delimitador dólar antes y después de la expresión $
... $
Por ejemplo: $ \sum_{x=1}^n sin(x) + cos(x) $ produce :∑︀ 𝑛
𝑥=1 𝑠𝑖𝑛(𝑥) + 𝑐𝑜𝑠(𝑥)
3 Un «shortcut» es un «atajo de teclado» (combinación de teclas) para lanzar una determinada acción.
8.1. jupyter 311

-- 315 of 516 --

Aprende Python
Figura 10: Menú Ayuda de Jupyter Notebook
312 Capítulo 8. Ciencia de datos

-- 316 of 516 --

Aprende Python
Fórmulas «de bloque»: Se debe usar el delimitador doble dólar antes y después de la
expresión $$ ... $$
Por ejemplo: $$ \sum_{x=1}^n sin(x) + cos(x) $$ produce:
𝑛	∑︁
𝑥=1
𝑠𝑖𝑛(𝑥) + 𝑐𝑜𝑠(𝑥)
Ejemplos de fórmulas
A continuación veremos distintas fórmulas inspiradas en Motivating Examples de la
documentación oficial de Jupyter Notebook. Nótese que aunque no se estén indicando los
delimitadores $$ sí habría que ponerlos para conseguir el efecto deseado.
Ecuaciones en varias líneas:
\dot{x} = \sigma(y-x) \\
\dot{y} = \rho x - y - xz \\
\dot{z} = -\beta z + xy
˙𝑥 = 𝜎(𝑦 − 𝑥)
˙𝑦 = 𝜌𝑥 − 𝑦 − 𝑥𝑧
˙𝑧 = −𝛽𝑧 + 𝑥𝑦
Ecuaciones en varias líneas (con alineación):
\begin{align}
\dot{x} &= \sigma(y-x) \\
\dot{y} &= \rho x - y - xz \\
\dot{z} &= -\beta z + xy
\end{align}
˙𝑥 = 𝜎(𝑦 − 𝑥)
˙𝑦 = 𝜌𝑥 − 𝑦 − 𝑥𝑧
˙𝑧 = −𝛽𝑧 + 𝑥𝑦
Usando paréntesis:
\left( \sum_{k=1}^n a_k b_k \right)^2 \leq
\left( \sum_{k=1}^n a_k^2 \right) \left( \sum_{k=1}^n b_k^2 \right)
(︃
𝑛	∑︁
𝑘=1
𝑎𝑘𝑏𝑘
)︃
2
≤
(︃
𝑛	∑︁
𝑘=1
𝑎2
𝑘
)︃(︃
𝑛	∑︁
𝑘=1
𝑏2
𝑘
)︃
Trabajando con matrices:
8.1. jupyter 313

-- 317 of 516 --

Aprende Python
\mathbf{V}_1 \times \mathbf{V}_2 =
\begin{vmatrix}
\mathbf{i} & \mathbf{j} & \mathbf{k} \\
\frac{\partial X}{\partial u} & \frac{\partial Y}{\partial u} & 0 \\
\frac{\partial X}{\partial v} & \frac{\partial Y}{\partial v} & 0
\end{vmatrix}
V1 × V2 =
⃒⃒⃒⃒⃒⃒
i j k
𝜕𝑋
𝜕𝑢
𝜕𝑌
𝜕𝑢 0
𝜕𝑋
𝜕𝑣
𝜕𝑌
𝜕𝑣 0
⃒⃒⃒⃒⃒⃒
Algo de probabilidad:
P(E) = {n \choose k} p^k (1-p)^{ n-k}
𝑃 (𝐸) =
(︂

𝑛
𝑘
)︂

𝑝𝑘(1 − 𝑝)𝑛−𝑘
Algunos ejemplos con fracciones:
\frac{1}{\Bigl(\sqrt{\phi \sqrt{5}}-\phi\Bigr) e^{\frac25 \pi}} =
1+\frac{e^{-2\pi}} {1+\frac{e^{-4\pi}} {1+\frac{e^{-6\pi}}
{1+\frac{e^{-8\pi}} {1+\ldots} } } }
1(︁√︀
𝜑√5 − 𝜑
)︁
 𝑒2
5 𝜋
= 1 + 𝑒−2𝜋
1 + 𝑒−4𝜋
1+ 𝑒−6𝜋
1+ 𝑒−8𝜋
1+...
1 + \frac{q^2}{(1-q)}+\frac{q^6}{(1-q)(1-q^2)}+\cdots =
\prod_{j=0}^{\infty}\frac{1}{(1-q^{5j+2})(1-q^{5j+3})},
\quad\quad \text{for $|q|<1$}.
1 + 𝑞2
(1 − 𝑞) + 𝑞6
(1 − 𝑞)(1 − 𝑞2) + · · · =
∞	∏︁
𝑗=0
1
(1 − 𝑞5𝑗+2)(1 − 𝑞5𝑗+3), for |𝑞| < 1.
Múltiples puntos de alineación:
\begin{eqnarray}
x &=& &x \sin\phi &+& z \cos\phi \\
z &=& - &x \cos\phi &+& z \sin\phi
\end{eqnarray}
𝑥′ = 𝑥 sin 𝜑 + 𝑧 cos 𝜑
𝑧′ = − 𝑥 cos 𝜑 + 𝑧 sin 𝜑
Ejercicio
Escriba en MathJax las siguientes ecuaciones:
314 Capítulo 8. Ciencia de datos

-- 318 of 516 --

Aprende Python
Ecuación 1
∫︁
𝑏
𝑎
𝑓 ′(𝑥)𝑑𝑥 = 𝑓 (𝑏) − 𝑓 (𝑎)
Ecuación 2
𝑡′ = 𝑡 1√︁
1 − 𝑣2
𝑐2
Ecuación 3
[︁
𝑀 𝜕
𝜕𝑀 + 𝛽(𝑔) 𝜕
𝜕𝑔 + 𝜂𝛾
]︁
 𝐺𝑛(𝑥1, 𝑥2, . . . , 𝑥𝑛; 𝑀, 𝑔) = 0
Ecuación 4
𝑅00 ≈ −1
2
∑︁

𝑖
𝜕2ℎ00
𝜕(𝑥𝑖)2 = 4𝜋𝐺
𝑐2 (𝜌𝑐2) ⇒ ▽2𝜑𝑔 = 4𝜋𝐺𝜌
Truco: Puede encontrar símbolos matemáticos para Latex en este enlace así como dibujar
directamente un símbolo y obtener su referencia a través de la herramienta Detexify.
8.1.4 Comandos especiales
Jupyter Notebook ofrece una gama de comandos especiales que cubren gran variedad de
funcionalidades.
Comandos de shell
Podemos ejecutar comandos de «shell» usando el prefijo exclamación !
>>> !date
martes, 15 de junio de 2021, 09:13:25 WEST
>>> !whoami
sdelquin
Ejercicio
Ejecute los siguientes comandos del sistema y obtenga la salida en una celda del Notebook:
8.1. jupyter 315

-- 319 of 516 --

Aprende Python
Windows Linux & macOS
time date
dir ls
mem free
Obteniendo ayuda
Una de las formas más sencillas de obtener información de librerías, funciones o módulos es
utilizar el sufijo interrogación ?
>>> import random
>>> random.randint?
Signature: random.randint(a, b)
Docstring:
Return random integer in range [a, b], including both end points.
File: ~/.pyenv/versions/3.9.1/lib/python3.9/random.py
Type: method
Ejercicio
Obtenga la documentación de las siguientes funciones:
• os.path.dirname
• re.match
• datetime.timedelta
Comandos mágicos
Jupyter Notebook, o mejor expresado IPython, admite un conjunto de comandos mágicos
que permiten realizar distintas tareas, en muchos casos, no necesariamente relacionadas con
Python:
>>> %lsmagic
Available line magics:
%aimport %alias %alias_magic %autoawait %autocall %autoindent %automagic
˓→%autoreload %bookmark %cat %cd %clear %colors %conda %config %cp %cpaste
˓→%debug %dhist %dirs %doctest_mode %ed %edit %env %gui %hist %history
˓→%killbgscripts %ldir %less %lf %lk %ll %load %load_ext %loadpy %logoff
˓→%logon %logstart %logstate %logstop %ls %lsmagic %lx %macro %magic %man
˓→%matplotlib %mkdir %more %mv %notebook %page %paste %pastebin %pdb %pdef
˓→%pdoc %pfile %pinfo %pinfo2 %pip %popd %pprint %precision %prun %psearch
˓→%psource %pushd %pwd %pycat %pylab %quickref %recall %rehashx %reload_ext
˓→%rep %rerun %reset %reset_selective %rm %rmdir %run %save %sc %set_env
˓→%store %sx %system %tb %time %timeit %unalias %unload_ext %who %who_ls
(continué en la próxima página)
316 Capítulo 8. Ciencia de datos

-- 320 of 516 --

Aprende Python
(proviene de la página anterior)
Available cell magics:
%%! %%HTML %%SVG %%bash %%capture %%debug %%file %%html %%javascript %%js %
˓→%latex %%markdown %%perl %%prun %%pypy %%python %%python2 %%python3 %%ruby␣
˓→ %%script %%sh %%svg %%sx %%system %%time %%timeit %%writefile
Automagic is ON, % prefix IS NOT needed for line magics.
Si nos fijamos en el último mensaje, al estar habilitado el modo «automagic», no es
estrictamente necesario que usemos el prefijo % para hacer uso de estos comandos. Por
ejemplo, si quisiéramos conocer la historia de comandos en el intérprete:
>>> hist # equivalente a %hist
!date
import random
random.randint?
%lsmagic
pwd
hist
Representando gráficas
Otra de las grandes ventajas que ofrece Jupyter Notebook es poder graficar directamente
sobre el cuaderno. Para ello utilizamos código Python (en este caso) y una directiva de
comando mágico para indicar que se renderice en línea:
>>> %matplotlib inline
>>> from matplotlib import pyplot as plt
>>> x = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
>>> y = [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
>>> plt.plot(x, y)
[<matplotlib.lines.Line2D at 0x106414e50>]
<Figure size 432x288 with 1 Axes>
8.1. jupyter 317

-- 321 of 516 --

Aprende Python
Figura 11: Gráfica sencilla hecha en Jupyter Notebook
Manejando ficheros
Cargando un fichero en la celda actual: Para ello utilizamos el comando %load "ruta/
al/fichero"
Ejecutando un fichero en la celda actual: Para ello utilizamos el comando %run
"ruta/al/fichero"
Escribiendo el contenido de la celda actual a fichero: Para ello utilizamos el
comando %writefile "ruta/al/fichero" como primera línea de la celda y
después vendría el código que queremos escribir.
Ejercicio
• En una celda del «notebook», escriba código Python para crear una lista de 100
números pares.
• Guarde el contenido de esa celda un fichero Python usando %%writefile
• Carge este fichero en una celda con %load
• Ejecútelo con %run
318 Capítulo 8. Ciencia de datos

-- 322 of 516 --

Aprende Python
Tiempos de ejecución
Para medir el tiempo de ejecución de una determinada instrucción Python podemos utilizar
el comando %timeit que calcula un promedio tras correr repetidas veces el código indicado:
>>> import numpy
>>> %timeit numpy.random.normal(size=100)
3.03 μs ± 6.77 ns per loop (mean ± std. dev. of 7 runs, 100000 loops each)
De igual forma, existe un mecanismo para medir el tiempo de ejecución de una celda
completa. En este caso se utiliza el comando %%timeit (nótese la diferencia del doble
porcentaje como prefijo):
%%timeit
numpy.random.poisson(size=100)
numpy.random.uniform(size=100)
numpy.random.logistic(size=100)
8.88 μs ± 25.8 ns per loop (mean ± std. dev. of 7 runs, 100000 loops each)
Ejercicio
Mida si hay diferencias significativas en tiempos de ejecución en la creación de distribuciones
aleatorias atendiendo a:
• Tipo de distribución (Poisson, Uniform, Logistic).
• Tamaño de la muestra (100, 10000, 1000000).
Incluyendo otros lenguajes
Celdas con HTML: Si necesitamos insertar código HTML en una celda, podemos usar el
comando %%html al comienzo de la misma:
%%html
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3592984.
˓→8538165656!2d-18.096789575396794!3d28.426067294993228!2m3!1f0!2f0!3f0!3m2!
˓→1i1024!2i768!4f13.1!3m3!1m2!1s0xc41aa86ef755363%3A0x10340f3be4bc8c0!
˓→2sCanarias!5e0!3m2!1ses!2ses!4v1623755509663!5m2!1ses!2ses" width="400"␣
˓→height="300" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
8.1. jupyter 319

-- 323 of 516 --

Aprende Python
Celdas con «shell script»: Hay ocasiones en las que un código en shell script suele ser
útil. Para incluirlo recurrimos al comando %%bash al principio de la celda:
%%bash
!tree -d -L 2
.
┐┐┐ __pycache__
┐┐┐ _build
┐ ┐┐┐ html
┐┐┐ _static
┐ ┐┐┐ css
┐ ┐┐┐ img
┐ ┐┐┐ js
┐┐┐ core
┐ ┐┐┐ controlflow
┐ ┐┐┐ datastructures
┐ ┐┐┐ datatypes
┐ ┐┐┐ devenv
┐ ┐┐┐ introduction
┐ ┐┐┐ modularity
┐┐┐ miniprojects
(continué en la próxima página)
320 Capítulo 8. Ciencia de datos

-- 324 of 516 --

Aprende Python
(proviene de la página anterior)
┐ ┐┐┐ spotify
┐┐┐ pypi
┐ ┐┐┐ datascience
┐┐┐ stdlib
┐┐┐ text_processing
20 directories
Celdas con perl: No hay que subestimar el poder del lenguaje de programación perl. Si
fuera necesario, lo podemos incluir en una celda del «notebook» con %%perl al comienzo
de la misma:
%%perl
my $email = sdelquin@gmail.com ;
if ($email =~ /^([^@]+)\@(.+)$/) {
print "Username is: $1\n";
print "Hostname is: $2\n";
}
...
Username is: sdelquin
Hostname is: gmail.com
8.1.5 Extensiones
El ecosistema de Jupyter Notebook es muy amplio y ofrece una gran variedad de
extensiones que se pueden incluir en la instalación que tengamos: Unofficial Jupyter Notebook
Extensions.
Su instalación es tan sencilla como:
$ pip install jupyter_contrib_nbextensions
8.1. jupyter 321

-- 325 of 516 --

Aprende Python
8.1.6 Otros entornos
El ecosistema de entornos para trabajos en ciencia de datos ha ido ampliándose durante estos
últimos años con la explosión del «BigData» y la inteligencia artificial. En este apartado
veremos otras plataformas que también nos permiten usar Python enfocado al análisis de
datos.
JupyterLab
JupyterLab es una evolución de Jupyter Notebook. Entre sus mejoras podemos destacar:
• Explorador de ficheros integrado en la barra lateral.
• Posibilidad de abrir múltiples .ipynb al mismo tiempo usando pestañas.
• Posibilidad de abrir múltiples terminales.
• Editor integrado para cualquier fichero de texto.
• Vista previa en tiempo real de documentos markdown o csv.
Figura 12: Pantalla inicial de JupyterLab
Su instalación se lleva a cabo como cualquier otro paquete Python:
$ pip install jupyterlab
Para ejecutar la aplicación:
322 Capítulo 8. Ciencia de datos

-- 326 of 516 --

Aprende Python
$ jupyter-lab
Google Colab
Google Colab es un entorno de computación científica creado por Google y disponible en su
nube. Como era previsible, para su uso es necesario disponer de una cuenta en Google.
Figura 13: Pantalla inicial de Google Colab
Características:
• Tiene un comportamiento totalmente análogo a Jupyter en cuanto a comportamiento
y funcionalidades.
• Completamente en la nube. No necesita instalación ni configuración.
• Por defecto trae multitud de paquetes instalados, principalmente en el ámbito científico:
386 paquetes (febrero de 2022).
• Versión de Python: 3.7.12 (febrero de 2022).
• Espacio en disco sujeto a las características de Google Compute Engine: 107.72GB
(febrero de 2022)
• Memoria RAM sujeta a las características de Google Compute Engine: 12.69GB
(febrero de 2022)
• Acceso limitado al sistema operativo.
8.1. jupyter 323

-- 327 of 516 --

Aprende Python
• En cuentas gratuitas, los tiempos de cómputo son, por lo general, mayores que en una
máquina local.4
• Previsualización markdown en tiempo real sobre cada celda.
• Posibilidad de subir ficheros de datos propios en carpetas accesibles por el cuaderno.
• Posibilidad de ejecutar Jupyter «notebooks» propios.
• Posibilidad (limitada) de acelerar cálculos usando GPU6 o TPU7.
• Posibilidad de descargar el cuaderno como Jupyter «notebook» o archivo de Python.
• Índice de contenidos integrado en barra lateral.
• Inspector de variables integrado en barra lateral.
Kaggle
Kaggle es una plataforma que no sólo ofrece un entorno de trabajo para cuadernos Jupyter
sino también una enorme colección de conjuntos de datos de libre acceso. Para su uso es
necesario disponer de una cuenta en el servicio.
Figura 14: Pantalla inicial de Kaggle
Características:
4 Todo estará en función de las características de la máquina con la que se esté trabajando.
6 Graphics Processing Unit (Unidad gráfica de procesamiento).
7 Tensor Processing Unit (Unidad de procesamiento tensorial).
324 Capítulo 8. Ciencia de datos

-- 328 of 516 --

Aprende Python
• Tiene un comportamiento totalmente análogo a Jupyter en cuanto a comportamiento
y funcionalidades.
• Completamente en la nube. No necesita instalación ni configuración.
• Por defecto trae multitud de paquetes instalados, principalmente en el ámbito científico:
792 paquetes (febrero de 2022).
• Versión de Python: 3.7.12 (febrero de 2022).
• Espacio en disco sujeto a las características de Kaggle: 73.1GB (febrero de 2022)
• Memoria RAM sujeta a las características de Kaggle: 16GB (febrero de 2022)
• Acceso limitado al sistema operativo.
• En cuentas gratuitas, los tiempos de cómputo son, por lo general, mayores que en una
máquina local.4
• Posibilidad de subir ficheros de datos propios sólo como «datasets» de Kaggle.
• Posibilidad de ejecutar Jupyter «notebooks» propios.
• Posibilidad (limitada) de acelerar cálculos usando GPU6 o TPU7.
• Posibilidad de descargar el cuaderno como Jupyter «notebook».
Comparativa
Haremos una comparativa de tiempos de ejecución lanzando una FFT5 sobre una matriz de
1 millón de elementos:
>>> import numpy as np
>>> bigdata = np.random.randint(1, 100, size=(1_000, 1_000))
>>> %timeit np.fft.fft(bigdata)
4.89 ms ± 5.78 μs per loop (mean ± std. dev. of 7 runs, 100 loops each)
Jupyter Colab Kaggle
4.89ms 13.9ms 12.8ms
Obviamente se trata de una ejecución puntual y no podemos sacar conclusiones claras al
respecto. Además de ello depende del «hardware» sobre el que estemos trabajando. En
cualquier caso el propósito es únicamente tener una ligera idea de los órdenes de magnitud.
5 Fast Fourier Transform (Transformada rápida de Fourier).
8.1. jupyter 325

-- 329 of 516 --

Aprende Python
8.2 numpy
NumPy es el paquete fundamental para computación científica en Python y manejo de arrays
numéricos multi-dimensionales.1
$ pip install numpy
La forma más común de importar esta librería es usar el alias np:
>>> import numpy as np
8.2.1 ndarray
En el núcleo de NumPy está el ndarray, donde «nd» es por n-dimensional. Un ndarray es
un array multidimensional de elementos del mismo tipo.
Aquí tenemos una diferencia fundamental con las listas en Python que pueden mantener
objetos heterogéneos. Y esta característica propicia que el rendimiento de un ndarray sea
bastante mejor que el de una lista convencional.
Para crear un array podemos usar:
1 Foto original de portada por Vlado Paunovic en Unsplash.
326 Capítulo 8. Ciencia de datos

-- 330 of 516 --

Aprende Python
>>> import numpy as np
>>> x = np.array([1, 2, 3, 4, 5])
>>> x
array([1, 2, 3, 4, 5])
>>> type(x)
numpy.ndarray
Si queremos obtener información sobre el array creado, podemos acceder a distintos atributos
del mismo:
>>> x.ndim # dimensión
1
>>> x.size # tamaño total del array
5
>>> x.shape # forma
(5,)
>>> x.dtype # tipo de sus elementos
dtype( int64 )
Datos heterogéneos
Hemos dicho que los ndarray son estructuras de datos que almacenan un único tipo de datos.
A pesar de esto, es posible crear un array con los siguientes valores:
>>> x = np.array([4, Einstein , 1e-7])
Aunque, a priori, puede parecer que estamos mezclando tipos enteros, flotantes y cadenas de
texto, lo que realmente se produce (de forma implícita) es una coerción2 de tipos a Unicode:
>>> x
array([ 4 , Einstein , 1e-07 ], dtype= <U32 )
>>> x.dtype
dtype( <U32 )
2 Característica de los lenguajes de programación que permite, implícita o explícitamente, convertir un
elemento de un tipo de datos en otro, sin tener en cuenta la comprobación de tipos.
8.2. numpy 327

-- 331 of 516 --

Aprende Python
Tipos de datos
NumPy maneja gran cantidad de tipos de datos. A diferencia de los tipos de datos numéricos
en Python que no establecen un tamaño de bytes de almacenamiento, aquí sí hay una
diferencia clara.
Algunos de los tipos de datos numéricos en NumPy se presentan en la siguiente tabla:
Tabla 1: Tipos de datos numéricos en NumPy
dtype Descripción Rango
np.int32 Integer De -2147483648 a 2147483647
np.int64 Integer De -9223372036854775808 a 9223372036854775807
np.uint32Unsigned
integer
De 0 a 4294967295
np.uint64Unsigned
integer
De 0 a 18446744073709551615
np.float32Float De -3.4028235e+38 a 3.4028235e+38
np.float64Float De -1.7976931348623157e+308 a 1.7976931348623157e+308
Truco: NumPy entiende por defecto que int hace referencia a np.int64 y que float hace
referencia a np.float64. Son «alias» bastante utilizados.
Si creamos un array de números enteros, el tipo de datos por defecto será int64:
>>> a = np.array(range(10))
>>> a
array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
>>> a.dtype
dtype( int64 )
Sin embargo podemos especificar el tipo de datos que nos interese:
>>> b = np.array(range(10), dtype= int32 ) # int32 hace referencia a np.int32
>>> b
array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], dtype=int32)
>>> b.dtype
dtype( int32 )
Lo mismo ocurre con valores flotantes, donde float64 es el tipo de datos por defecto.
Es posible convertir el tipo de datos que almacena un array mediante el método astype. Por
328 Capítulo 8. Ciencia de datos

-- 332 of 516 --

Aprende Python
ejemplo:
>>> a
array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
>>> c = a.astype(float)
>>> c.dtype
dtype( float64 )
ndarray vs list
Como ya se ha comentado en la introducción de esta sección, el uso de ndarray frente a list
está justificado por cuestiones de rendimiento. Pero veamos un ejemplo clarificador en el que
sumamos 10 millones de valores enteros:
>>> array_as_list = list(range(int(10e6)))
>>> array_as_ndarray = np.array(array_as_list)
>>> %timeit sum(array_as_list)
48 ms ± 203 μs per loop (mean ± std. dev. of 7 runs, 10 loops each)
>>> %timeit array_as_ndarray.sum()
3.83 ms ± 4.84 μs per loop (mean ± std. dev. of 7 runs, 100 loops each)
Nota: El cómputo es casi 12 veces más rápido utilizando ndarray frente a listas clásicas.
En cualquier caso, existe la posibilidad de convertir a lista cualquier ndarray mediante el
método tolist():
>>> a = np.array([10, 20, 30])
>>> a
array([10, 20, 30])
>>> b = a.tolist()
>>> b
[10, 20, 30]
>>> type(b)
list
8.2. numpy 329

-- 333 of 516 --

Aprende Python
Matrices
Una matriz no es más que un array bidimensional. Como ya se ha comentado, NumPy provee
ndarray que se comporta como un array multidimensional con lo que podríamos crear una
matriz sin mayor problema.
Veamos un ejemplo en el que tratamos de construir la siguiente matriz:
𝑀 =
⎡
⎢
⎢
⎣
1 2 3
4 5 6
7 8 9
10 11 12
⎤
⎥
⎥
⎦
Nos apoyamos en una lista de listas para la creación de la matriz:
>>> M = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9], [10, 11, 12]])
>>> M
array([[ 1, 2, 3],
[ 4, 5, 6],
[ 7, 8, 9],
[10, 11, 12]])
>>> M.ndim # bidimensional
2
>>> M.size
12
>>> M.shape # 4 filas x 3 columnas
(4, 3)
>>> M.dtype
dtype( int64 )
Ejercicio
Cree los siguientes arrays en NumPy:
array1 =[︀ 88 23 39 41]︀
array2 =
[︂

76.4 21.7 38.4
41.2 52.8 68.9
]︂
array3 =
⎡
⎢
⎢
⎣
12
4
9
8
⎤
⎥
⎥
⎦
330 Capítulo 8. Ciencia de datos

-- 334 of 516 --

Aprende Python
Obtenga igualmente las siguientes características de cada uno de ellos: dimensión, tamaño,
forma y tipo de sus elementos.
Cambiando la forma
Dado un array, podemos cambiar su forma mediante la función np.reshape():
>>> a = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12])
>>> np.reshape(a, (3, 4)) # 3 x 4
array([[ 1, 2, 3, 4],
[ 5, 6, 7, 8],
[ 9, 10, 11, 12]])
Si sólo queremos especificar un número determinado de filas o columnas, podemos dejar la
otra dimensión a -1:
>>> np.reshape(a, (6, -1)) # 6 filas
array([[ 1, 2],
[ 3, 4],
[ 5, 6],
[ 7, 8],
[ 9, 10],
[11, 12]])
>>> np.reshape(a, (-1, 3)) # 3 columnas
array([[ 1, 2, 3],
[ 4, 5, 6],
[ 7, 8, 9],
[10, 11, 12]])
Advertencia: En el caso de que no exista posibilidad de cambiar la forma del array por
el número de filas y/o columnas especificado, obtendremos un error de tipo ValueError:
cannot reshape array.
8.2. numpy 331

-- 335 of 516 --

Aprende Python
Almacenando arrays
Es posible que nos interese almacenar (de forma persistente) los arrays que hemos ido
creando. Para ello NumPy nos provee, al menos, de dos mecanismos:
Almacenamiento en formato binario propio: Mediante el método save() podemos
guardar la estructura de datos en ficheros .npy. Veamos un ejemplo:
>>> M
array([[ 1, 2, 3],
[ 4, 5, 6],
[ 7, 8, 9],
[10, 11, 12]])
>>> np.save( my_matrix , M)
>>> !ls my_matrix.npy
my_matrix.npy
>>> M_reloaded = np.load( my_matrix.npy )
>>> M_reloaded
array([[ 1, 2, 3],
[ 4, 5, 6],
[ 7, 8, 9],
[10, 11, 12]])
Almacenamiento en formato de texto plano: NumPy proporciona el método
savetxt() con el que podremos volcar la estructura de datos a un fichero de
texto csv. Veamos un ejemplo:
>>> M
array([[ 1, 2, 3],
[ 4, 5, 6],
[ 7, 8, 9],
[10, 11, 12]])
>>> np.savetxt( my_matrix.csv , M, fmt= %d )
>>> !cat my_matrix.csv
1 2 3
4 5 6
7 8 9
10 11 12
>>> M_reloaded = np.loadtxt( my_matrix.csv , dtype=int)
(continué en la próxima página)
332 Capítulo 8. Ciencia de datos

-- 336 of 516 --

Aprende Python
(proviene de la página anterior)
>>> M_reloaded
array([[ 1, 2, 3],
[ 4, 5, 6],
[ 7, 8, 9],
[10, 11, 12]])
Truco: Por defecto el almacenamiento y la carga de arrays en formato texto usa
tipos de datos flotantes. Es por ello que hemos usado el parámetro fmt en el
almacenamiento y el parámetro dtype en la carga.
Es posible cargar un array desempaquetando sus valores a través del parámetro
unpack. En el siguiente ejemplo separamos las columnas en tres variables diferentes:
>>> M
array([[ 1, 2, 3],
[ 4, 5, 6],
[ 7, 8, 9],
[10, 11, 12]])
>>> col1, col2, col3 = np.loadtxt( my_matrix.csv , unpack=True, dtype=int)
>>> col1
array([ 1, 4, 7, 10])
>>> col2
array([ 2, 5, 8, 11])
>>> col3
array([ 3, 6, 9, 12])
8.2.2 Funciones predefinidas para creación de arrays
NumPy ofrece una gran variedad de funciones predefinidas para creación de arrays que nos
permiten simplificar el proceso de construcción de este tipo de estructuras de datos.
Valores fijos
A continuación veremos una serie de funciones para crear arrays con valores fijos.
8.2. numpy 333

-- 337 of 516 --

Aprende Python
Ceros
>>> np.zeros((3, 4))
array([[0., 0., 0., 0.],
[0., 0., 0., 0.],
[0., 0., 0., 0.]])
Por defecto, ésta y otras funciones del estilo, devuelven valores flotantes. Si quisiéramos
trabajar con valores enteros basta con usar el parámetro dtype:
>>> np.zeros((3, 4), dtype=int)
array([[0, 0, 0, 0],
[0, 0, 0, 0],
[0, 0, 0, 0]])
Existe la posibilidad de crear un array de ceros con las mismas dimensiones (y forma)
que otro array:
>>> M = np.array([[1, 2, 3], [4, 5, 6]])
>>> M
array([[1, 2, 3],
[4, 5, 6]])
>>> np.zeros_like(M)
array([[0, 0, 0],
[0, 0, 0]])
Lo cual sería equivalente a pasar la «forma» del array a la función predefinida de creación
de ceros:
>>> np.zeros(M.shape, dtype=int)
array([[0, 0, 0],
[0, 0, 0]])
Unos
>>> np.ones((3, 4)) # también existe np.ones_like()
array([[1., 1., 1., 1.],
[1., 1., 1., 1.],
[1., 1., 1., 1.]])
334 Capítulo 8. Ciencia de datos

-- 338 of 516 --

Aprende Python
Mismo valor
>>> np.full((3, 4), 7) # también existe np.full_like()
array([[7, 7, 7, 7],
[7, 7, 7, 7],
[7, 7, 7, 7]])
Matriz identidad
>>> np.eye(5)
array([[1., 0., 0., 0., 0.],
[0., 1., 0., 0., 0.],
[0., 0., 1., 0., 0.],
[0., 0., 0., 1., 0.],
[0., 0., 0., 0., 1.]])
Matriz diagonal
>>> np.diag([5, 4, 3, 2, 1])
array([[5, 0, 0, 0, 0],
[0, 4, 0, 0, 0],
[0, 0, 3, 0, 0],
[0, 0, 0, 2, 0],
[0, 0, 0, 0, 1]])
Ejercicio
Cree la siguiente matriz mediante código Python:
diagonal =
⎡
⎢
⎢
⎢
⎢
⎢
⎣
0 0 0 . . . 0
0 1 0 . . . 0
0 0 2 . . . 0
... ... 0 . . . 0
0 0 0 . . . 49
⎤
⎥
⎥
⎥
⎥
⎥
⎦
Obtenga igualmente las siguientes características de cada uno de ellos: dimensión, tamaño,
forma y tipo de sus elementos.
8.2. numpy 335

-- 339 of 516 --

Aprende Python
Valores equiespaciados
A continuación veremos una serie de funciones para crear arrays con valores equiespaciados
o en intervalos definidos.
Valores enteros equiespaciados
La función que usamos para este propósito es np.arange() cuyo comportamiento es
totalmente análogo a la función «built-in» range().
Especificando límite superior:
>>> np.arange(21)
array([ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
17, 18, 19, 20])
Especificando límite inferior y superior:
>>> np.arange(6, 60)
array([ 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56,
57, 58, 59])
Especificando límite inferior, superior y paso:
>>> np.arange(6, 60, 3)
array([ 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54,
57])
Es posible especificar un paso flotante en la función arange():
>>> np.arange(6, 16, .3)
array([ 6. , 6.3, 6.6, 6.9, 7.2, 7.5, 7.8, 8.1, 8.4, 8.7, 9. ,
9.3, 9.6, 9.9, 10.2, 10.5, 10.8, 11.1, 11.4, 11.7, 12. , 12.3,
12.6, 12.9, 13.2, 13.5, 13.8, 14.1, 14.4, 14.7, 15. , 15.3, 15.6,
15.9])
336 Capítulo 8. Ciencia de datos

-- 340 of 516 --

Aprende Python
Valores flotantes equiespaciados
La función que usamos para este propósito es np.linspace() cuyo comportamiento es
«similar» a np.arange() pero para valores flotantes.
Especificando límite inferior y superior:
>>> np.linspace(6, 60) # [6, 60] con 50 valores
array([ 6. , 7.10204082, 8.20408163, 9.30612245, 10.40816327,
11.51020408, 12.6122449 , 13.71428571, 14.81632653, 15.91836735,
17.02040816, 18.12244898, 19.2244898 , 20.32653061, 21.42857143,
22.53061224, 23.63265306, 24.73469388, 25.83673469, 26.93877551,
28.04081633, 29.14285714, 30.24489796, 31.34693878, 32.44897959,
33.55102041, 34.65306122, 35.75510204, 36.85714286, 37.95918367,
39.06122449, 40.16326531, 41.26530612, 42.36734694, 43.46938776,
44.57142857, 45.67346939, 46.7755102 , 47.87755102, 48.97959184,
50.08163265, 51.18367347, 52.28571429, 53.3877551 , 54.48979592,
55.59183673, 56.69387755, 57.79591837, 58.89795918, 60. ])
Nota: Por defecto np.linspace() genera 50 elementos.
Especificando límite inferior, superior y total de elementos:
>>> np.linspace(6, 60, 20) # [6, 60] con 20 valores
array([ 6. , 8.84210526, 11.68421053, 14.52631579, 17.36842105,
20.21052632, 23.05263158, 25.89473684, 28.73684211, 31.57894737,
34.42105263, 37.26315789, 40.10526316, 42.94736842, 45.78947368,
48.63157895, 51.47368421, 54.31578947, 57.15789474, 60. ])
Importante: A diferencia de np.arange(), la función np.linspace() incluye «por
defecto» el límte superior especificado.
Especificando un intervalo abierto [𝑎, 𝑏):
>>> np.linspace(6, 60, 20, endpoint=False) # [6, 60) con 20 elementos
array([ 6. , 8.7, 11.4, 14.1, 16.8, 19.5, 22.2, 24.9, 27.6, 30.3, 33. ,
35.7, 38.4, 41.1, 43.8, 46.5, 49.2, 51.9, 54.6, 57.3])
8.2. numpy 337

-- 341 of 516 --

Aprende Python
Valores aleatorios
A continuación veremos una serie de funciones para crear arrays con valores aleatorios y
distribuciones de probabilidad.
Valores aleatorios enteros
Valores aleatorios enteros en [𝑎, 𝑏):
>>> np.random.randint(3, 30) # escalar
4
>>> np.random.randint(3, 30, size=9) # vector
array([29, 7, 8, 21, 27, 23, 29, 15, 28])
>>> np.random.randint(3, 30, size=(3, 3)) # matriz
array([[24, 4, 29],
[10, 22, 27],
[27, 7, 20]])
Valores aleatorios flotantes
Por simplicidad, en el resto de ejemplos vamos a obviar la salida escalar y matriz.
Valores aleatorios flotantes en [0, 1):
>>> np.random.random(9)
array([0.53836208, 0.78315275, 0.6931254 , 0.97194325, 0.01523289,
0.47692141, 0.27653964, 0.82297655, 0.70502383])
Valores aleatorios flotantes en [𝑎, 𝑏):
>>> np.random.uniform(1, 100, size=9)
array([17.00450378, 67.08416159, 56.99930273, 9.19685998, 35.27334323,
97.34651516, 25.89283558, 53.59685476, 72.74943888])
338 Capítulo 8. Ciencia de datos

-- 342 of 516 --

Aprende Python
Distribuciones de probabilidad
Distribución normal: Ejemplo en el que generamos un millón de valores usando como
parámetros de la distribución 𝜇 = 0, 𝜎 = 5
>>> dist = np.random.normal(0, 5, size=1_000_000)
>>> dist[:20]
array([ 2.5290643 , 1.46577658, 1.65170437, -1.36970819, -2.24547757,
7.19905613, -4.4666239 , -1.05505116, 2.42351298, -4.45314272,
1.13604077, -2.85054948, 4.34589478, -2.81235743, -0.8215143 ,
0.57796411, -2.56594122, -7.14899388, 3.49197644, 1.80691996])
>>> dist.mean()
0.004992046432131982
>>> dist.std()
4.998583810032169
Muestra aleatoria: Ejemplo en el que generamos una muestra aleatoria de un millón de
lanzamientos de una moneda:
>>> coins = np.random.choice([ head , tail ], size=1_000_000)
>>> coins
array([ tail , head , tail , ..., tail , head , tail ], dtype= <U4 )
>>> sum(coins == head )
499874
>>> sum(coins == tail )
500126
Muestra aleatoria con probabilidades no uniformes: Ejemplo en el que generamos
una muestra aleatoria de un millón de lanzamientos con un dado «trucado»:
>>> # La cara del "1" tiene un 50% de probabilidades de salir
>>> dices = np.random.choice(range(1, 7), size=1_000_000, p=[.5, .1, .1, .1, .1,
˓→ .1])
>>> dices
array([6, 5, 4, ..., 1, 6, 1])
>>> sum(dices == 1)
500290
>>> sum(dices == 6)
99550
8.2. numpy 339

-- 343 of 516 --

Aprende Python
Muestra aleatoria sin reemplazo: Ejemplo en el que seleccionamos 5 principios
aleatorios del Zen de Python sin reemplazo:
>>> import this
>>> import codecs
>>> zen = codecs.decode(this.s, rot-13 ).splitlines()[3:] # https://bit.ly/
˓→3xhsucQ
>>> np.random.choice(zen, size=5, replace=False)
array([ Unless explicitly silenced. ,
"Although that way may not be obvious at first unless you re Dutch.",
Sparse is better than dense. ,
If the implementation is easy to explain, it may be a good idea. ,
Complex is better than complicated. ], dtype= <U69 )
Ver también:
Listado de distribuciones aleatorias que se pueden utilizar en NumPy.
Ejercicio
Cree:
• Una matriz de 20 filas y 5 columnas con valores flotantes equiespaciados en el intervalo
cerrado [1, 10].
• Un array unidimensional con 128 valores aleatorios de una distribución normal 𝜇 =
1, 𝜎 = 2.
• Un array unidimensional con 15 valores aleatorios de una muestra 1, X, 2 donde la
probabilidad de que gane el equipo local es del 50%, la probabilidad de que empaten
es del 30% y la probabilidad de que gane el visitante es del 20%.
Constantes
Numpy proporciona una serie de constantes predefinidas que facilitan su acceso y
reutilización. Veamos algunas de ellas:
>>> import numpy as np
>>> np.Inf
inf
>>> np.nan
nan
(continué en la próxima página)
340 Capítulo 8. Ciencia de datos

-- 344 of 516 --

Aprende Python
(proviene de la página anterior)
>>> np.e
2.718281828459045
>>> np.pi
3.141592653589793
8.2.3 Manipulando elementos
Los arrays multidimensionales de NumPy están indexados por unos ejes que establecen la
forma en la que debemos acceder a sus elementos. Véase el siguiente diagrama:
Figura 15: Esquema de ejes sobre los arrays de NumPy3
Arrays unidimensionales
Acceso a arrays unidimensionales
>>> values
array([10, 11, 12, 13, 14, 15])
>>> values[2]
12
>>> values[-3]
13
3 Imagen de Harriet Dashnow, Stéfan van der Walt y Juan Núñez-Iglesias en O’Reilly.
8.2. numpy 341

-- 345 of 516 --

Aprende Python
Modificación a arrays unidimensionales
>>> values
array([10, 11, 12, 13, 14, 15])
>>> values[0] = values[1] + values[5]
>>> values
array([26, 11, 12, 13, 14, 15])
Borrado en arrays unidimensionales
>>> values
array([10, 11, 12, 13, 14, 15])
>>> np.delete(values, 2) # índice (como escalar)
array([10, 11, 13, 14, 15])
>>> np.delete(values, (2, 3, 4)) # índices (como tupla)
array([10, 11, 15])
Nota: La función np.delete() no es destructiva. Devuelve una copia modificada del array.
Inserción en arrays unidimensionales
>>> values
array([10, 11, 12, 13, 14, 15])
>>> np.append(values, 16) # añade elementos al final
array([10, 11, 12, 13, 14, 15, 16])
>>> np.insert(values, 1, 101) # añade elementos en una posición
array([ 10, 101, 11, 12, 13, 14, 15])
Para ambas funciones también es posible añadir varios elementos de una sola vez:
>>> values
array([10, 11, 12, 13, 14, 15])
>>> np.append(values, [16, 17, 18])
array([10, 11, 12, 13, 14, 15, 16, 17, 18])
342 Capítulo 8. Ciencia de datos

-- 346 of 516 --

Aprende Python
Nota: La funciones np.append() y np.insert() no son destructivas. Devuelven una copia
modificada del array.
Arrays multidimensionales
Partimos del siguiente array bidimensional (matriz) para ejemplificar las distintas
operaciones:
>>> values = np.arange(1, 13).reshape(3, 4)
>>> values
array([[ 1, 2, 3, 4],
[ 5, 6, 7, 8],
[ 9, 10, 11, 12]])
Acceso a arrays multidimensionales
>>> values
array([[ 1, 2, 3, 4],
[ 5, 6, 7, 8],
[ 9, 10, 11, 12]])
Acceso a elementos individuales::
>>> values[0, 0]
1
>>> values[-1, -1]
12
>>> values[1, 2]
7
Acceso a múltiples elementos::
>>> values[[0, 2], [1, 2]] # Elementos [0, 1] y [2, 2]
array([ 2, 11])
Acceso a filas o columnas completas:
>>> values[2] # tercera fila
array([ 9, 10, 11, 12])
>>> values[:, 1] # segunda columna
array([ 2, 6, 10])
8.2. numpy 343

-- 347 of 516 --

Aprende Python
Acceso a zonas parciales del array:
>>> values[0:2, 0:2]
array([[1, 2],
[5, 6]])
>>> values[0:2, [1, 3]]
array([[2, 4],
[6, 8]])
Importante: Todos estos accesos crean una copia (vista) del array original. Esto significa
que, si modificamos un valor en el array copia, se ve reflejado en el original. Para evitar esta
situación podemos usar la función np.copy() y desvincular la vista de su fuente.
Modificación de arrays multidimensionales
>>> values
array([[ 1, 2, 3, 4],
[ 5, 6, 7, 8],
[ 9, 10, 11, 12]])
>>> values[0, 0] = 100
>>> values[1] = [55, 66, 77, 88]
>>> values[:,2] = [30, 70, 110]
>>> values
array([[100, 2, 30, 4],
[ 55, 66, 70, 88],
[ 9, 10, 110, 12]])
Borrado en arrays multidimensionales
>>> values
array([[ 1, 2, 3, 4],
[ 5, 6, 7, 8],
[ 9, 10, 11, 12]])
>>> np.delete(values, 0, axis=0) # Borrado de la primera fila
array([[ 5, 6, 7, 8],
(continué en la próxima página)
344 Capítulo 8. Ciencia de datos

-- 348 of 516 --

Aprende Python
(proviene de la página anterior)
[ 9, 10, 11, 12]])
>>> np.delete(values, (1, 3), axis=1) # Borrado de la segunda y cuarta columna
array([[ 1, 3],
[ 5, 7],
[ 9, 11]])
Truco: Tener en cuenta que axis=0 hace referencia a filas y axis=1 hace referencia a
columnas tal y como describe el diagrama del comienzo de la sección.
Inserción en arrays multidimensionales
Añadir elementos al final del array:
>>> values
array([[1, 2],
[3, 4]])
>>> np.append(values, [[5, 6]], axis=0)
array([[1, 2],
[3, 4],
[5, 6]])
>>> np.append(values, [[5], [6]], axis=1)
array([[1, 2, 5],
[3, 4, 6]])
Insertar elementos en posiciones arbitrarias del array:
>>> values
array([[1, 2],
[3, 4]])
>>> np.insert(values, 0, [0, 0], axis=0)
array([[0, 0],
[1, 2],
[3, 4]])
>>> np.insert(values, 1, [0, 0], axis=1)
array([[1, 0, 2],
[3, 0, 4]])
8.2. numpy 345

-- 349 of 516 --

Aprende Python
Ejercicio
Utilizando las operaciones de modificación, borrado e inserción, convierta la siguiente matriz:
⎡
⎢
⎢
⎣
17 12 31
49 11 51
21 31 62
63 75 22
⎤
⎥
⎥
⎦
en esta:
⎡
⎣
17 12 31 63
49 11 51 75
21 31 62 22
⎤
⎦
y luego en esta:
⎡
⎣
17 12 31 63
49 49 49 63
21 31 62 63
⎤
⎦
Apilando matrices
Hay veces que nos interesa combinar dos matrices (arrays en general). Una de los mecanismos
que nos proporciona NumPy es el apilado.
Apilado vertical:
>>> m1 = np.random.randint(1, 100, size=(3, 2))
>>> m2 = np.random.randint(1, 100, size=(1, 2))
>>> m1
array([[68, 68],
[10, 50],
[87, 92]])
>>> m2
array([[63, 80]])
>>> np.vstack((m1, m2))
array([[68, 68],
[10, 50],
[87, 92],
[63, 80]])
Apilado horizontal:
346 Capítulo 8. Ciencia de datos

-- 350 of 516 --

Aprende Python
>>> m1 = np.random.randint(1, 100, size=(3, 2))
>>> m2 = np.random.randint(1, 100, size=(3, 1))
>>> m1
array([[51, 50],
[52, 15],
[14, 21]])
>>> m2
array([[18],
[52],
[ 1]])
>>> np.hstack((m1, m2))
array([[51, 50, 18],
[52, 15, 52],
[14, 21, 1]])
Repitiendo elementos
Repetición por ejes: El parámetro de repetición indica el número de veces que repetimos
el array completo por cada eje:
>>> values
array([[1, 2],
[3, 4],
[5, 6]])
>>> np.tile(values, 3) # x3 en columnas
array([[1, 2, 1, 2, 1, 2],
[3, 4, 3, 4, 3, 4],
[5, 6, 5, 6, 5, 6]])
>>> np.tile(values, (2, 3)) # x2 en filas; x3 en columnas
array([[1, 2, 1, 2, 1, 2],
[3, 4, 3, 4, 3, 4],
[5, 6, 5, 6, 5, 6],
[1, 2, 1, 2, 1, 2],
[3, 4, 3, 4, 3, 4],
[5, 6, 5, 6, 5, 6]])
Repetición por elementos: El parámetro de repetición indica el número de veces que
repetimos cada elemento del array:
>>> values
array([[1, 2],
(continué en la próxima página)
8.2. numpy 347

-- 351 of 516 --

Aprende Python
(proviene de la página anterior)
[3, 4],
[5, 6]])
>>> np.repeat(values, 2)
array([1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6])
>>> np.repeat(values, 2, axis=0) # x2 en filas
array([[1, 2],
[1, 2],
[3, 4],
[3, 4],
[5, 6],
[5, 6]])
>>> np.repeat(values, 3, axis=1) # x3 en columnas
array([[1, 1, 1, 2, 2, 2],
[3, 3, 3, 4, 4, 4],
[5, 5, 5, 6, 6, 6]])
Acceso por diagonal
Es bastante común acceder a elementos de una matriz (array en general) tomando como
referencia su diagonal. Para ello, NumPy nos provee de ciertos mecanismos que veremos a
continuación.
Para ejemplificarlo, partiremos del siguiente array:
>>> values
array([[73, 86, 90, 20],
[96, 55, 15, 48],
[38, 63, 96, 95],
[13, 87, 32, 96]])
Extracción de elementos por diagonal
La función np.diag() permite acceder a los elementos de un array especificando un
parámetro k que indica la «distancia» con la diagonal principal:
Veamos cómo variando el parámetro k obtenemos distintos resultados:
>>> np.diag(values) # k = 0
array([73, 55, 96, 96])
(continué en la próxima página)
348 Capítulo 8. Ciencia de datos

-- 352 of 516 --

Aprende Python
Figura 16: Acceso a elementos de un array por su diagonal
8.2. numpy 349

-- 353 of 516 --

Aprende Python
(proviene de la página anterior)
>>> for k in range(1, values.shape[0]):
... print(f k={k} , np.diag(values, k=k))
...
k=1 [86 15 95]
k=2 [90 48]
k=3 [20]
>>> for k in range(1, values.shape[0]):
... print(f k={-k} , np.diag(values, k=-k))
...
k=-1 [96 63 32]
k=-2 [38 87]
k=-3 [13]
Modificación de elementos por diagonal
NumPy también provee un método np.diag_indices() que retorna los índices de los
elementos de la diagonal principal, con lo que podemos modificar sus valores directamente:
>>> values
array([[73, 86, 90, 20],
[96, 55, 15, 48],
[38, 63, 96, 95],
[13, 87, 32, 96]])
>>> di = np.diag_indices(values.shape[0])
>>> di
(array([0, 1, 2, 3]), array([0, 1, 2, 3]))
>>> values[di] = 0
>>> values
array([[ 0, 86, 90, 20],
[96, 0, 15, 48],
[38, 63, 0, 95],
[13, 87, 32, 0]])
Truco: Existen igualmente las funciones np.triu_indices() y np.tril_indices() para
obtener los índices de la diagonal superior e inferior de una matriz.
350 Capítulo 8. Ciencia de datos

-- 354 of 516 --

Aprende Python
8.2.4 Operaciones sobre arrays
Operaciones lógicas
Indexado booleano
El indexado booleano es una operación que permite conocer (a nivel de elemento) si un array
cumple o no con una determinada condición:
>>> values
array([[60, 47, 34, 38],
[43, 63, 37, 68],
[58, 28, 31, 43],
[32, 65, 32, 96]])
>>> values > 50 # indexado booleano
array([[ True, False, False, False],
[False, True, False, True],
[ True, False, False, False],
[False, True, False, True]])
>>> values[values > 50] # uso de máscara
array([60, 63, 68, 58, 65, 96])
>>> values[values > 50] = -1 # modificación de valores
>>> values
array([[-1, 47, 34, 38],
[43, -1, 37, -1],
[-1, 28, 31, 43],
[32, -1, 32, -1]])
Las condiciones pueden ser más complejas e incorporar operadores lógicos | (or) y & (and):
>>> values
array([[60, 47, 34, 38],
[43, 63, 37, 68],
[58, 28, 31, 43],
[32, 65, 32, 96]])
>>> (values < 25) | (values > 75)
array([[False, False, False, False],
[False, False, False, False],
[False, False, False, False],
[False, False, False, True]])
(continué en la próxima página)
8.2. numpy 351

-- 355 of 516 --

Aprende Python
(proviene de la página anterior)
>>> (values > 25) & (values < 75)
array([[ True, True, True, True],
[ True, True, True, True],
[ True, True, True, True],
[ True, True, True, False]])
Consejo: El uso de paréntesis es obligatorio si queremos mantener la precedencia y que
funcione correctamente.
Ejercicio
Extraiga todos los números impares de la siguiente matriz:
values =
⎡
⎣
10 11 12 13
14 15 16 17
18 19 20 21
⎤
⎦
Si lo que nos interesa es obtener los índices del array que satisfacen una determinada
condición, NumPy nos proporciona el método where() cuyo comportamiento se ejemplifica
a continuación:
>>> values
array([[60, 47, 34, 38],
[43, 63, 37, 68],
[58, 28, 31, 43],
[32, 65, 32, 96]])
>>> idx = np.where(values > 50)
>>> idx
(array([0, 1, 1, 2, 3, 3]), array([0, 1, 3, 0, 1, 3]))
>>> values[idx]
array([60, 63, 68, 58, 65, 96])
Ejercicio
Partiendo de una matriz de 10 filas y 10 columnas con valores aleatorios enteros en el intervalo
[0, 100], realice las operaciones necesarias para obtener una matriz de las mismas dimensiones
donde:
• Todos los elementos de la diagonal sean 50.
352 Capítulo 8. Ciencia de datos

-- 356 of 516 --

Aprende Python
• Los elementos mayores que 50 tengan valor 100.
• Los elementos menores que 50 tengan valor 0.
Comparando arrays
Dados dos arrays podemos compararlos usando el operador == del mismo modo que con
cualquier otro objeto en Python. La cuestión es que el resultado se evalúa a nivel de elemento:
>>> m1 = np.array([[1, 2], [3, 4]])
>>> m3 = np.array([[1, 2], [3, 4]])
>>> m1 == m2
array([[ True, True],
[ True, True]])
Si queremos comparar arrays en su totalidad, podemos hacer uso de la siguiente función:
>>> np.array_equal(m1, m2)
True
Operaciones de conjunto
Al igual que existen operaciones sobre conjuntos en Python, también podemos llevarlas a
cabo sobre arrays en NumPy.
Unión de arrays
𝑥 ∪ 𝑦
>>> x
array([ 9, 4, 11, 3, 14, 5, 13, 12, 7, 14])
>>> y
array([17, 9, 19, 4, 18, 4, 7, 13, 11, 10])
>>> np.union1d(x, y)
array([ 3, 4, 5, 7, 9, 10, 11, 12, 13, 14, 17, 18, 19])
8.2. numpy 353

-- 357 of 516 --

Aprende Python
Intersección de arrays
𝑥 ∩ 𝑦
>>> x
array([ 9, 4, 11, 3, 14, 5, 13, 12, 7, 14])
>>> y
array([17, 9, 19, 4, 18, 4, 7, 13, 11, 10])
>>> np.intersect1d(x, y)
array([ 4, 7, 9, 11, 13])
Diferencia de arrays
𝑥 ∖ 𝑦
>>> x
array([ 9, 4, 11, 3, 14, 5, 13, 12, 7, 14])
>>> y
array([17, 9, 19, 4, 18, 4, 7, 13, 11, 10])
>>> np.setdiff1d(x, y)
array([ 3, 5, 12, 14])
Ordenación de arrays
En términos generales, existen dos formas de ordenar cualquier estructura de datos, una
que modifica «in-situ» los valores (destructiva) y otra que devuelve «nuevos» valores (no
destructiva). En el caso de NumPy también es así.
Ordenación sobre arrays unidimensionales
>>> values
array([23, 24, 92, 88, 75, 68, 12, 91, 94, 24, 9, 21, 42, 3, 66])
>>> np.sort(values) # no destructivo
array([ 3, 9, 12, 21, 23, 24, 24, 42, 66, 68, 75, 88, 91, 92, 94])
>>> values.sort() # destructivo
>>> values
array([ 3, 9, 12, 21, 23, 24, 24, 42, 66, 68, 75, 88, 91, 92, 94])
354 Capítulo 8. Ciencia de datos

-- 358 of 516 --

Aprende Python
Ordenación sobre arrays multidimensionales
>>> values
array([[52, 23, 90, 46],
[61, 63, 74, 59],
[75, 5, 58, 70],
[21, 7, 80, 52]])
>>> np.sort(values, axis=1) # equivale a np.sort(values)
array([[23, 46, 52, 90],
[59, 61, 63, 74],
[ 5, 58, 70, 75],
[ 7, 21, 52, 80]])
>>> np.sort(values, axis=0)
array([[21, 5, 58, 46],
[52, 7, 74, 52],
[61, 23, 80, 59],
[75, 63, 90, 70]])
Nota: También existe values.sort(axis=1) y values.sort(axis=0) como métodos
«destructivos» de ordenación.
Contando valores
Otra de las herramientas útiles que proporciona NumPy es la posibilidad de contar el número
de valores que existen en un array en base a ciertos criterios.
Para ejemplificarlo, partiremos de un array unidimensional con valores de una distribución
aleatoria uniforme en el intervalo [1, 10]:
>>> randomized = np.random.randint(1, 11, size=1000)
>>> randomized
array([ 7, 9, 7, 8, 3, 7, 6, 4, 3, 9, 3, 1, 6, 7, 10, 4, 8,
1, 3, 3, 8, 5, 4, 7, 5, 8, 8, 3, 10, 1, 7, 10, 3, 10,
2, 9, 5, 1, 2, 4, 4, 10, 5, 10, 5, 2, 5, 2, 10, 3, 4,
...
Valores únicos:
>>> np.unique(randomized)
array([ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
8.2. numpy 355

-- 359 of 516 --

Aprende Python
Valores únicos (incluyendo frecuencias):
>>> np.unique(randomized, return_counts=True)
(array([ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]),
array([101, 97, 117, 94, 101, 88, 94, 110, 93, 105]))
Valores distintos de cero:
>>> np.count_nonzero(randomized)
1000
Valores distintos de cero (incluyendo condición):
>>> np.count_nonzero(randomized > 5)
490
Operaciones aritméticas
Una de las grandes ventajas del uso de arrays numéricos en NumPy es la posibilidad de
trabajar con ellos como si fueran objetos «simples» pero sacando partido de la aritmética
vectorial. Esto redunda en una mayor eficiencia y rapidez de cómputo.
Operaciones aritméticas con mismas dimensiones
Cuando operamos entre arrays de las mismas dimensiones, las operaciones aritméticas se
realizan elemento a elemento (ocupando misma posición) y el resultado, obviamente, tiene
las mismas dimensiones:
>>> m1
array([[21, 86, 45],
[31, 36, 78],
[31, 64, 70]])
>>> m2
array([[58, 67, 17],
[99, 53, 9],
[92, 42, 75]])
>>> m1 + m2
array([[ 79, 153, 62],
[130, 89, 87],
[123, 106, 145]])
>>> m1 - m2
(continué en la próxima página)
356 Capítulo 8. Ciencia de datos

-- 360 of 516 --

Aprende Python
(proviene de la página anterior)
array([[-37, 19, 28],
[-68, -17, 69],
[-61, 22, -5]])
>>> m1 * m2
array([[1218, 5762, 765],
[3069, 1908, 702],
[2852, 2688, 5250]])
>>> m1 / m2 # división flotante
array([[0.36206897, 1.28358209, 2.64705882],
[0.31313131, 0.67924528, 8.66666667],
[0.33695652, 1.52380952, 0.93333333]])
>>> m1 // m2 # división entera
array([[0, 1, 2],
[0, 0, 8],
[0, 1, 0]])
Operaciones aritméticas con distintas dimensiones
Cuando operamos entre arrays con dimensiones diferentes, siempre y cuando se cumplan
ciertas restricciones en tamaños de filas y/o columnas, lo que se produce es un «broadcasting»
(o difusión) de los valores.
Suma con array «fila»:
>>> m
array([[9, 8, 1],
[7, 6, 7]])
>>> v
array([[2, 3, 6]])
>>> m + v # broadcasting
array([[11, 11, 7],
[ 9, 9, 13]])
Suma con array «columna»:
>>> m
array([[9, 8, 1],
[7, 6, 7]])
(continué en la próxima página)
8.2. numpy 357

-- 361 of 516 --

Aprende Python
(proviene de la página anterior)
>>> v
array([[1],
[6]])
>>> m + v # broadcasting
array([[10, 9, 2],
[13, 12, 13]])
Advertencia: En el caso de que no coincidan dimensiones de filas y/o columnas, NumPy
no podrá ejecutar la operación y obtendremos un error ValueError: operands could
not be broadcast together with shapes.
Operaciones entre arrays y escalares
Al igual que ocurría en los casos anteriores, si operamos con un array y un escalar, éste
último será difundido para abarcar el tamaño del array:
>>> m
array([[9, 8, 1],
[7, 6, 7]])
>>> m + 5
array([[14, 13, 6],
[12, 11, 12]])
>>> m - 5
array([[ 4, 3, -4],
[ 2, 1, 2]])
>>> m * 5
array([[45, 40, 5],
[35, 30, 35]])
>>> m / 5
array([[1.8, 1.6, 0.2],
[1.4, 1.2, 1.4]])
>>> m // 5
array([[1, 1, 0],
[1, 1, 1]])
>>> m ** 5
(continué en la próxima página)
358 Capítulo 8. Ciencia de datos

-- 362 of 516 --

Aprende Python
(proviene de la página anterior)
array([[59049, 32768, 1],
[16807, 7776, 16807]])
Operaciones unarias
Existen multitud de operaciones sobre un único array. A continuación veremos algunas de
las más utilizas en NumPy.
Funciones universales
Las funciones universales «ufunc» son funciones que operan sobre arrays elemento a
elemento. Existen muchas funciones universales definidas en Numpy, parte de ellas operan
sobre dos arrays y parte sobre un único array.
Un ejemplo de algunas de estas funciones:
>>> values
array([[48.32172375, 24.89651106, 77.49724241],
[77.81874191, 22.54051494, 65.11282444],
[ 5.54960482, 59.06720303, 62.52817198]])
>>> np.sqrt(values)
array([[6.95138287, 4.98964037, 8.80325181],
[8.82149318, 4.74768522, 8.06925179],
[2.35575992, 7.68551905, 7.9074757 ]])
>>> np.sin(values)
array([[-0.93125201, -0.23403917, 0.86370435],
[ 0.66019205, -0.52214693, 0.75824777],
[-0.66953344, 0.58352079, -0.29903488]])
>>> np.ceil(values)
array([[49., 25., 78.],
[78., 23., 66.],
[ 6., 60., 63.]])
>>> np.floor(values)
array([[48., 24., 77.],
[77., 22., 65.],
[ 5., 59., 62.]])
>>> np.log(values)
array([[3.87788123, 3.21472768, 4.35024235],
(continué en la próxima página)
8.2. numpy 359

-- 363 of 516 --

Aprende Python
(proviene de la página anterior)
[4.3543823 , 3.11531435, 4.17612153],
[1.71372672, 4.07867583, 4.13561721]])
Reduciendo el resultado
NumPy nos permite aplicar cualquier función sobre un array reduciendo el resultado por
alguno de sus ejes. Esto abre una amplia gama de posibilidades.
A modo de ilustración, veamos un par de ejemplos con la suma y el producto:
>>> values
array([[8, 2, 7],
[2, 0, 6],
[6, 3, 4]])
>>> np.sum(values, axis=0) # suma por columnas
array([16, 5, 17])
>>> np.sum(values, axis=1) # suma por filas
array([17, 8, 13])
>>> np.prod(values, axis=0) # producto por columnas
array([ 96, 0, 168])
>>> np.prod(values, axis=1) # producto por filas
array([112, 0, 72])
Ejercicio
Compruebe que, para 𝜃 = 2𝜋 (radianes) y 𝑘 = 20 se cumple la siguiente igualdad del producto
infinito de Euler:
cos
(︂

𝜃
2
)︂

· cos
(︂

𝜃
4
)︂

· cos
(︂

𝜃
8
)︂

· · · =
𝑘	∏︁
𝑖=1
cos
(︂

𝜃
2𝑖
)︂

≈ sin(𝜃)
𝜃
360 Capítulo 8. Ciencia de datos

-- 364 of 516 --

Aprende Python
Funciones estadísticas
NumPy proporciona una gran cantidad de funciones estadísticas que pueden ser aplicadas
sobre arrays.
Veamos algunas de ellas:
>>> dist
array([[-6.79006504, -0.01579498, -0.29182173, 0.3298951 , -5.30598975],
[ 3.10720923, -4.09625791, -7.60624152, 2.3454259 , 9.23399023],
[-7.4394269 , -9.68427195, 3.04248586, -5.9843767 , 1.536578 ],
[ 3.33953286, -8.41584411, -9.530274 , -2.42827813, -7.34843663],
[ 7.1508544 , 5.51727548, -3.20216834, -5.00154367, -7.15715252]])
>>> np.mean(dist)
-2.1877878715377777
>>> np.std(dist)
5.393254994089515
>>> np.median(dist)
-3.2021683412383295
Máximos y mínimos
Una de las operaciones más comunes en el manejo de datos es encontrar máximos o
mínimos. Para ello, disponemos de las típicas funciones con las ventajas del uso de arrays
multidimensionales:
>>> values
array([[66, 54, 33, 15, 58],
[55, 46, 39, 16, 38],
[73, 75, 79, 25, 83],
[81, 30, 22, 32, 8],
[92, 25, 82, 10, 90]])
>>> np.min(values)
8
>>> np.min(values, axis=0)
array([55, 25, 22, 10, 8])
>>> np.min(values, axis=1)
array([15, 16, 25, 8, 10])
>>> np.max(values)
(continué en la próxima página)
8.2. numpy 361

-- 365 of 516 --

Aprende Python
(proviene de la página anterior)
92
>>> np.max(values, axis=0)
array([92, 75, 82, 32, 90])
>>> np.max(values, axis=1)
array([66, 55, 83, 81, 92])
Si lo que interesa es obtener los índices de aquellos elementos con valores máximos o
mínimos, podemos hacer uso de las funciones argmax() y argmin() respectivamente.
Veamos un ejemplo donde obtenemos los valores máximos por columnas (mediante sus
índices):
>>> values
array([[66, 54, 33, 15, 58],
[55, 46, 39, 16, 38],
[73, 75, 79, 25, 83],
[81, 30, 22, 32, 8],
[92, 25, 82, 10, 90]])
>>> idx = np.argmax(values, axis=0)
>>> idx
array([4, 2, 4, 3, 4])
>>> values[idx, range(values.shape[1])]
array([92, 75, 82, 32, 90])
Vectorizando funciones
Una de las ventajas de trabajar con arrays numéricos en NumPy es sacar provecho de
la optimización que se produce a nivel de la propia estructura de datos. En el caso de
que queramos implementar una función propia para realizar una determinada acción, sería
deseable seguir aprovechando esa característica.
Veamos un ejemplo en el que queremos realizar el siguiente cálculo entre dos matrices 𝐴 y
𝐵:
𝐴𝑖𝑗 * 𝐵𝑖𝑗 =
⎧
⎪	⎨
⎪	⎩
𝐴𝑖𝑗 + 𝐵𝑖𝑗 , si 𝐴𝑖𝑗 > 𝐵𝑖𝑗
𝐴𝑖𝑗 − 𝐵𝑖𝑗 , si 𝐴𝑖𝑗 < 𝐵𝑖𝑗
0 , e.o.c.
Esta función, definida en Python, quedaría tal que así:
362 Capítulo 8. Ciencia de datos

-- 366 of 516 --

Aprende Python
>>> def customf(a, b):
... if a > b:
... return a + b
... elif a < b:
... return a - b
... else:
... return 0
...
Las dos matrices de partida tienen 9M de valores aleatorios entre -100 y 100:
>>> A = np.random.randint(-100, 100, size=(3000, 3000))
>>> B = np.random.randint(-100, 100, size=(3000, 3000))
Una primera aproximación para aplicar esta función a cada elemento de las matrices de
entrada sería la siguiente:
>>> result = np.zeros_like(A)
>>> %%timeit
... for i in range(A.shape[0]):
... for j in range(A.shape[1]):
... result[i, j] = customf(A[i, j], B[i, j])
...
3 s ± 23.8 ms per loop (mean ± std. dev. of 7 runs, 1 loop each)
Mejorando rendimiento con funciones vectorizadas
Con un pequeño detalle podemos mejorar el rendimiento de la función que hemos diseñado
anteriormente. Se trata de decorarla con np.vectorize con lo que estamos otorgándole un
comportamiento distinto y enfocado al procesamiento de arrays numéricos:
>>> @np.vectorize
... def customf(a, b):
... if a > b:
... return a + b
... elif a < b:
... return a - b
... else:
... return 0
...
Dado que ahora ya se trata de una función vectorizada podemos aplicarla directamente
a las matrices de entrada (aprovechamos para medir su tiempo de ejecución):
8.2. numpy 363

-- 367 of 516 --

Aprende Python
>>> %timeit customf(A, B)
1.29 s ± 7.33 ms per loop (mean ± std. dev. of 7 runs, 1 loop each)
Hemos obtenido una mejora de 2.32x con respecto al uso de funciones simples.
Truco: La mejora de rendimiento se aprecia más claramente a medida que los tamaños de
las matrices (arrays) de entrada son mayores.
Consejo: El uso de funciones lambda puede ser muy útil en vectorización: np.
vectorize(lambda a, b: return a + b).
Ejercicio