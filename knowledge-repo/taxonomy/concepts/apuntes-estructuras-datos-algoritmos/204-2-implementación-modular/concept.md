# 2. Implementación modular

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 204)

## Contenido
# 2. Implementación modular

En estos apuntes se va a implementar los TAD con módulos y no con clases (propias de la Programación Orientada a
Objetos), así que presentamos en primer lugar nuestra sintaxis en pseudocódigo para esos módulos y posteriormente una
posible codificación en C++ (otras variantes son posibles en el mismo lenguaje).
2.1. 	Pseudocódigo
Un buen lenguaje de programación con TAD debe facilitar la encapsulación. Para ello, debe separar la interfaz, o parte
pública, que incluya la declaración del TAD, de la implementación, o parte privada, que encapsule los detalles de
representación de los valores del tipo e implementación de las operaciones.
En el caso de tener que utilizar un lenguaje que no garantice la encapsulación, es responsabilidad exclusiva del
programador el cumplir con la encapsulación, cumpliendo las restricciones de acceso a los detalles de implementación que
un buen lenguaje de programación con TAD garantizaría.

-- 33 of 267 --

26
En estos apuntes utilizaremos un pseudocódigo en castellano (ver el Anexo 6) en el que los módulos para implementar
los TAD tendrán la siguiente sintaxis:
módulo <nombre del módulo>
importa <lista de módulos que necesita usar>
exporta
{parte pública: definición de constantes, nombres de tipos, encabezamientos
de procedimientos y funciones}
...
implementación
{parte privada: se incluyen las definiciones de los tipos cuyos nombres aparecen
en la parte pública, otros tipos privados, el código de procedimientos
y funciones...}
...
fin
De esta forma, para implementar un TAD, en primer lugar, hay que definir todo lo que aparecerá en la parte pública
o interfaz del módulo, es decir, lo que el módulo exporta:
• 	los identificadores válidos de constantes (si son necesarias), tipos, y operaciones (procedimientos y/o
funciones);
• 	los perfiles o cabeceras de cada operación (sea procedimiento o función): parámetros de entrada, parámetros
de salida y/o parámetros de entrada y salida; y
• 	la comunicación de las situaciones de error (en estos apuntes utilizaremos para ello más parámetros de salida).
Una vez decidida la parte pública, se pueden realizar independientemente (por parte de distintos programadores incluso)
la implementación del TAD y su utilización en otros módulos o en programas principales.
En segundo lugar, y ya en lo referido a la implementación del módulo, hay que decidir la representación interna del
TAD, es decir, cómo representar los valores del tipo de datos especificado, basándose en: tipos básicos predefinidos,
constructores básicos predefinidos (como vectores y registros), y/u otros TAD definidos previamente.
La representación interna deberá permitir implementar las operaciones definidas para el tipo de forma eficiente, tanto
en relación con su coste en memoria como en tiempo.
Además, la representación interna deberá permanecer oculta, encapsulada. Es decir, el uso del nuevo tipo solo será
posible mediante las operaciones definidas en la interfaz del tipo.
En tercer lugar, también dentro de la parte de implementación del módulo, hay que implementar cada operación de
la interfaz del TAD, de acuerdo a la representación interna definida para los valores del TAD, y las operaciones auxiliares
que resulten de interés o de utilidad (siendo éstas inaccesibles para los programadores usuarios del módulo).
Para la implementación de cada operación, las operaciones 0-arias o constantes se pueden implementar, según
convenga, como constantes predefinidas en algún tipo de dato del lenguaje, como procedimientos o como funciones sin
parámetros. Las demás operaciones se implementan como procedimientos o funciones, según convenga.
Como se ha dicho anteriormente, varias operaciones con el mismo dominio y distinto rango o resultado pueden
combinarse en un solo procedimiento con varios parámetros de salida, correspondiente a los resultados. Esta posibilidad es
especialmente recomendable si esas operaciones van a utilizarse a menudo de forma conjunta y la implementación conjunta
reduce el coste en tiempo de obtener los resultados.
En lo concerniente a las operaciones parciales (es decir, con situaciones de error), cabe la posibilidad de utilizar los
mecanismos de manejo de excepciones del lenguaje de implementación, si los tiene. En estos apuntes, no vamos a entrar
en el uso de esos posibles mecanismos, sino que utilizaremos el método, más rudimentario pero utilizable en cualquier
lenguaje de programación, de añadir parámetros de salida sobre el error ocurrido a los procedimientos.
Como regla general, si una operación sólo tiene que devolver un dato resultado, podrá implementarse tanto con un
procedimiento (incluyendo el correspondiente parámetro de salida, o eventualmente de entrada y salida) como con una
función (que devuelve el resultado asociado a su nombre). Por el contrario, si una operación tiene que devolver 0, 2 o más

-- 34 of 267 --

27
resultados, tendrá que optarse por un procedimiento que incluya tantos parámetros de salida, o eventualmente de ent
