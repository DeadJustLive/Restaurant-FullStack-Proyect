# 2.2 Contexto real

## Fuente
Aprende Python (Cap. 7)

## Contenido
# 2.2 Contexto real

Hemos visto que Thonny es una herramienta especialmente diseñada para el aprendizaje de
Python, integrando diferentes módulos que facilitan su gestión. Si bien lo podemos utilizar
28 Capítulo 2. Entornos de desarrollo

-- 32 of 516 --

Aprende Python
para un desarrollo más «serio», se suele recurrir a un flujo de trabajo algo diferente en
contextos más reales.1
2.2.1 Python
La forma más habitual de instalar Python (junto con sus librerías) es descargarlo e instalarlo
desde su página oficial:
• Versiones de Python para Windows
• Versiones de Python para Mac
• Versiones de Python para Linux
Truco: Tutorial para instalar Python en Windows.
Anaconda
Otra de las alternativas para disponer de Python en nuestro sistema y que además es muy
utilizada, es Anaconda. Se trata de un conjunto de herramientas, orientadas en principio a
la ciencia de datos, pero que podemos utilizarlas para desarrollo general en Python (junto
con otras librerías adicionales).
Existen versiones de pago, pero la distribución Individual Edition es «open-source» y
gratuita. Se puede descargar desde su página web. Anaconda trae por defecto una gran
cantidad de paquetes Python en su distribución.
Ver también:
Miniconda es un instalador mínimo que trae por defecto Python y un pequeño número de
paquetes útiles.
2.2.2 Gestión de paquetes
La instalación limpia2 de Python ya ofrece de por sí muchos paquetes y módulos que vienen
por defecto. Es lo que se llama la librería estándar. Pero una de las características más
destacables de Python es su inmenso «ecosistema» de paquetes disponibles en el Python
Package Index (PyPI).
Para gestionar los paquetes que tenemos en nuestro sistema se utiliza la herramienta pip,
una utilidad que también se incluye en la instalación de Python. Con ella podremos instalar,
1 Foto original de portada por SpaceX en Unsplash.
2 También llamada «vanilla installation» ya que es la que viene por defecto y no se hace ningúna
personalización.
2.2. Contexto real 29

-- 33 of 516 --

Aprende Python
desinstalar y actualizar paquetes, según nuestras necesidades. A continuación se muestran
las instrucciones que usaríamos para cada una de estas operaciones:
Lista 2: Instalación, desinstalación y actualización del
paquete pandas utilizando pip
$ pip install pandas
$ pip uninstall pandas
$ pip install pandas --upgrade
Consejo: Para el caso de Anaconda usaríamos conda install pandas (aunque ya viene
preinstalado).
2.2.3 Entornos virtuales
Nivel intermedio
Cuando trabajamos en distintos proyectos, no todos ellos requieren los mismos paquetes
ni siquiera la misma versión de Python. La gestión de estas situaciones no es sencilla si
únicamente instalamos paquetes y manejamos configuraciones a nivel global (a nivel de
máquina). Es por ello que surge el concepto de entornos virtuales. Como su propio nombre
indica se trata de crear distintos entornos en función de las necesidades de cada proyecto, y
esto nos permite establecer qué versión de Python usaremos y qué paquetes instalaremos.
La manera más sencilla de crear un entorno virtual es la siguiente:
1 $ cd myproject
2 $ python -m venv --prompt myproject .venv
3 $ source .venv/bin/activate
• Línea 1: Entrar en la carpeta de nuestro proyecto.
• Línea 2: Crear una carpeta .venv con los ficheros que constituyen el entorno virtual.
• Línea 3: Activar el entorno virtual. A partir de aquí todo lo que se instale quedará
dentro del entorno virtual.
30 Capítulo 2. Entornos de desarrollo

-- 34 of 516 --

Aprende Python
virtualenv
El paquete de Python que nos proporciona la funcionalidad de crear y gestionar entornos
virtuales se denomina virtualenv. Su instalación es sencilla a través del gestor de paquetes
pip:
$ pip install virtualenv
Si bien con virtualenv tenemos las funcionalidades necesarias para trabajar con entornos
virtuales, destacaría una herramienta llamada virtualenvwrapper que funciona por encima
de virtualenv y que facilita las operaciones sobre entornos virtuales. Su instalación es
equivalente a cualquier otro paquete Python:
$ pip install virtualenvwrapper
Veamos a continuación algunos de los comandos que nos ofrece:
$ ~/project1 > mkvirtualenv env1
Using base prefix /Library/Frameworks/Python.framework/Versions/3.7
New python executable in /Users/sdelquin/.virtualenvs/env1/bin/python3.7
Also creating executable in /Users/sdelquin/.virtualenvs/env1/bin/python
Installing setuptools, pip, wheel...
done.
virtualenvwrapper.user_scripts creating /Users/sdelquin/.virtualenvs/env1/bin/
˓→predeactivate
virtualenvwrapper.user_scripts creating /Users/sdelquin/.virtualenvs/env1/bin/
˓→postdeactivate
virtualenvwrapper.user_scripts creating /Users/sdelquin/.virtualenvs/env1/bin/
˓→preactivate
virtualenvwrapper.user_scripts creating /Users/sdelquin/.virtualenvs/env1/bin/
˓→postactivate
virtualenvwrapper.user_scripts creating /Users/sdelquin/.virtualenvs/env1/bin/get_
˓→env_details
$ (env1) ~/project1 > pip install requests
Collecting requests
Using cached requests-2.24.0-py2.py3
