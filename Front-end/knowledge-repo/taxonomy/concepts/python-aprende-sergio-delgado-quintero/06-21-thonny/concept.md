# 2.1 Thonny

## Fuente
Aprende Python (Cap. 6)

## Contenido
# 2.1 Thonny

Thonny es un programa muy interesante para empezar a aprender Python, ya que engloba
tres de las herramientas fundamentales para trabajar con el lenguaje: intérprete, editor y
depurador.1
Cuando vamos a trabajar con Python debemos tener instalado, como mínimo, un intérprete
del lenguaje (para otros lenguajes sería un compilador). El intérprete nos permitirá
ejecutar nuestro código para obtener los resultados deseados. La idea del intéprete es lanzar
instrucciones «sueltas» para probar determinados aspectos.
Pero normalmente queremos ir un poco más allá y poder escribir programas algo más largos,
por lo que también necesitaremos un editor. Un editor es un programa que nos permite
crear ficheros de código (en nuestro caso con extensión *.py), que luego son ejecutados por
el intérprete.
Hay otra herramienta interesante dentro del entorno de desarrollo que sería el depurador.
Lo podemos encontrar habitualmente en la bibliografía por su nombre inglés debugger.
Es el módulo que nos permite ejecutar paso a paso nuestro código y visualizar qué está
ocurriendo en cada momento. Se suele usar normalmente para encontrar fallos (bugs) en
nuestros programas y poder solucionarlos (debug/fix).
Cuando nos encontramos con un programa que proporciona estas funciones (e incluso otras
adicionales) para el trabajo de programación, nos referimos a él como un Entorno Integrado de
Desarrollo, conocido popularmente por sus siglas en inglés IDE (por Integrated Development
1 Foto original de portada por freddie marriage en Unsplash.
24 Capítulo 2. Entornos de desarrollo

-- 28 of 516 --

Aprende Python
Environment). Thonny es un IDE gratuito, sencillo y apto para principiantes.
2.1.1 Instalación
Para instalar Thonny debemos acceder a su web y descargar la aplicación para nuestro
sistema operativo. La ventaja es que está disponible tanto para Windows, Mac y Linux.
Una vez descargado el fichero lo ejecutamos y seguimos su instalación paso por paso.
Una vez terminada la instalación ya podemos lanzar la aplicación que se verá parecida a la
siguiente imagen:
Figura 1: Aspecto de Thonny al arrancarlo
Nota: Es posible que el aspecto del programa varíe ligeramente según el sistema operativo,
configuración de escritorio, versión utilizada o idioma (en mi caso está en inglés), pero a
efectos de funcionamiento no hay diferencia.
Podemos observar que la pantalla está dividida en 3 paneles:
• Panel principal que contiene el editor e incluye la etiqueta <untitled> donde
escribiremos nuestro código fuente Python.
• Panel inferior con la etiqueta Shell que contiene el intérprete de Python. En el
momento de la escritura del presente documento, Thonny incluye la versión de Python
3.7.7.
2.1. Thonny 25

-- 29 of 516 --

Aprende Python
• Panel derecho que contiene el depurador. Más concretamente se trata de la ventana
de variables donde podemos inspeccionar el valor de las mismas.
2.1.2 Probando el intérprete
El intérprete de Python (por lo general) se identifica claramente porque posee un prompt2
con tres angulos hacia la derecha >>>. En Thonny lo podemos encontrar en el panel inferior,
pero se debe tener en cuenta que el intérprete de Python es una herramienta autocontenida
y que la podemos ejecutar desde el símbolo del sistema o la terminal:
Lista 1: Invocando el intérprete de Python 3.7 desde una
terminal en MacOS
$ python3.7
Python 3.7.4 (v3.7.4:e09359112e, Jul 8 2019, 14:54:52)
[Clang 6.0 (clang-600.0.57)] on darwin
Type "help", "copyright", "credits" or "license" for more information.
>>>
Para hacer una prueba inicial del intérprete vamos a retomar el primer programa que se
suele hacer. Es el llamado «Hello, World». Para ello escribimos lo siguiente en el intérprete
y pulsamos la tecla ENTER:
>>> print( Hello, World )
Hello, World
Lo que hemos hecho es indicarle a Python que ejecute como entrada la instrucción
print( Hello, World ). La salida es el texto Hello, World que lo vemos en la siguiente
línea (ya sin el prompt >>>).
2.1.3 Probando el editor
Ahora vamos a realizar la misma operación, pero en vez de ejecutar la instrucción
directamente en el intérprete, vamos a crear un fichero y guardarlo con la sentencia que
nos interesa. Para ello escribimos print( Hello, World ) en el panel de edición (superior)
y luego guardamos el archivo con el nombre helloworld.py3:
Importante: Los ficheros que contienen programas hechos en Python siempre deben tener
la extensión .py
2 Término inglés que se refiere al símbolo que precede la línea de comandos.
3 La carpeta donde se guarden los archivos de código no es crítico para su ejecución, pero sí es importante
mantener un orden y una organización para tener localizados nuestros ficheros y proyectos.
26 Capítulo 2. Entornos de desarrollo

-- 30 of 516 --

Aprende Python
Figura 2: Guardando nuestro primer programa en Python
Ahora ya podemos ejecutar nuestro fichero helloworld.py. Para ello pulsamos el botón verde
con triángulo blanco (en la barra de herramientas) o bien damos a la tecla F5. Veremos 
