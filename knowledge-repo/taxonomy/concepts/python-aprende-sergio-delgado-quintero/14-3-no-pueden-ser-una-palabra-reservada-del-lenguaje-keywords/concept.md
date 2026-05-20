# 3. No pueden ser una palabra reservada del lenguaje («keywords»).

## Fuente
Aprende Python (Cap. 14)

## Contenido
# 3. No pueden ser una palabra reservada del lenguaje («keywords»).

2 Para ser exactos, sí se pueden utilizar otros caracteres, e incluso emojis en los nombres de variables,
aunque no suele ser una práctica extendida, ya que podría dificultar la legibilidad.
48 Capítulo 3. Tipos de datos

-- 52 of 516 --

Aprende Python
Podemos obtener un listado de las palabras reservadas del lenguaje de la siguiente forma:
>>> help( keywords )
Here is a list of the Python keywords. Enter any keyword to get more help.
False class from or
None continue global pass
True def if raise
and del import return
as elif in try
assert else is while
async except lambda with
await finally nonlocal yield
break for not
Nota: Por lo general se prefiere dar nombres en inglés a las variables que utilicemos, ya que
así hacemos nuestro código más «internacional» y con la posibilidad de que otras personas
puedan leerlo, entenderlo y – llegado el caso – modificarlo. Es sólo una recomendación, nada
impide que se haga en castellano.
Importante: Los nombres de variables son «case-sensitive»3. Por ejemplo, stuff y Stuff
son nombres diferentes.
Ejemplos de nombres de variables
Veamos a continuación una tabla con nombres de variables:
Tabla 2: Ejemplos de nombres de variables
Válido Inválido Razón
a 3 Empieza por un dígito
a3 3a Empieza por un dígito
a_b_c___95 another-name Contiene un carácter no permitido
_abc with Es una palabra reservada del lenguaje
_3a 3_a Empieza por un dígito
3 Sensible a cambios en mayúsculas y minúsculas.
3.1. Datos 49

-- 53 of 516 --

Aprende Python
Convenciones para nombres
Mientras se sigan las reglas que hemos visto para nombrar variables no hay problema en la
forma en la que se escriban, pero sí existe una convención para la nomenclatura de las
variables. Se utiliza el llamado snake_case en el que utilizamos caracteres en minúsculas
(incluyendo dígitos si procede) junto con guiones bajos – cuando sean necesarios para su
legibilidad –.4 Por ejemplo, para nombrar una variable que almacene el número de canciones
en nuestro ordenador, podríamos usar num_songs.
Esta convención, y muchas otras, están definidas en un documento denominado PEP 8. Se
trata de una guía de estilo para escribir código en Python. Los PEPs5 son las propuestas
que se hacen para la mejora del lenguaje.
Aunque hay múltiples herramientas disponibles para la comprobación del estilo de código,
una bastante accesible es http://pep8online.com/ ya que no necesita instalación, simplemente
pegar nuestro código y verificar.
Constantes
Un caso especial y que vale la pena destacar son las constantes. Podríamos decir que es un
tipo de variable pero que su valor no cambia a lo largo de nuestro programa. Por ejemplo
la velocidad de la luz. Sabemos que su valor es constante de 300.000 km/s. En el caso
de las constantes utilizamos mayúsculas (incluyendo guiones bajos si es necesario) para
nombrarlas. Para la velocidad de la luz nuestra constante se podría llamar: LIGHT_SPEED.
Elegir buenos nombres
Se suele decir que una persona programadora (con cierta experiencia), a lo que dedica más
tiempo, es a buscar un buen nombre para sus variables. Quizás pueda resultar algo excesivo
pero da una idea de lo importante que es esta tarea. Es fundamental que los nombres de
variables sean autoexplicativos, pero siempre llegando a un compromiso entre ser concisos
y claros.
Supongamos que queremos buscar un nombre de variable para almacenar el número de
elementos que se deben manejar en un pedido:
1. n
2. num_elements
3. number_of_elements
4. number_of_elements_to_be_handled
4 Más información sobre convenciones de nombres en PEP 8.
5 Del término inglés «Python Enhancement Proposals».
50 Capítulo 3. Tipos de datos

-- 54 of 516 --

Aprende Python
No existe una regla mágica que nos diga cuál es el nombre perfecto, pero podemos aplicar
el sentido común y, a través de la experiencia, ir detectando aquellos nombres que sean más
adecuados. En el ejemplo anterior, quizás podríamos descartar de principio la opción 1 y la
4 (por ser demasiado cortas o demasiado largas); nos quedaríamos con las otras dos. Si nos
fijamos bien, casi no hay mucha información adicional de la opción 3 con respecto a la 2. Así
que podríamos concluir que la opción 2 es válida para nuestras necesidades. En cualquier
caso esto dependerá siempre del contexto del problema que estemos tratando.
Como regla general:
• Usar nombres para variables (ejemplo article).
• Usar verbos para funciones (ejemplo get_article()).
• Usar adjetivos para booleanos (ejemplo available).
3.1.3 Asignación
En Python se usa el símbolo = para asignar un valor a una variable:
Figura 3: Asignación de valor a nombre de variable
Nota: Hay que diferenciar la asignación en Python con la igualación en matemáticas. El
símbolo = lo hemos aprendido desde siempre como una equivalencia entre dos expresiones
algebraicas, sin embargo en Python nos indica una sentencia de asignación, del valor (en la
derecha) al nombre (en la izquierda).
Algunos ejemplos de as
