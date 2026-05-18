# 3. Implementación con estructuras de listas múltiples

Una implementación estática basada en una matriz o vector bidimensional de este tipo:
Estructuras de datos 	Organización de 	Sistemas
y algoritmos 	computadores 	operativos I
Alberto … 	nota
Belén … 	nota 	nota
Carmen … 	nota
Fernando … 	nota
Ignacio … 	nota 	nota
Marta … 	nota 	nota
sería una mala solución si muchas de las parejas <claveEstudiante,claveAsignatura> no tienen valor (notas)
asignado, es decir, no pertenecen a la tabla, pues se malgastaría mucha memoria.
Una estructura de listas múltiples es una colección de datos dinámicos enlazados mediante punteros en la que cada
dato dinámico tiene más de un campo de tipo puntero y, por tanto, puede pertenecer a más de una lista a la vez (recordar,
por ejemplo, la representación de árboles ordenados en la forma “primogénito-siguiente hermano”, en la que cada nodo
puede pertenecer a una lista de primogénitos y a otra lista de hermanos).
Veamos cómo se puede representar una tabla bidimensional mediante una estructura de listas múltiples, utilizando el
ejemplo de los estudiantes y asignaturas de la EINA.
Cada registro de estudiante contendrá, además de sus datos personales (nombre, apellidos, número de matrícula, etc.,
a partir de los cuales se define la clave de estudiante) un puntero al primer registro de matrícula de ese estudiante en una
asignatura. Este registro de matrícula guardará información sobre las notas de ese estudiante en esa asignatura.
De igual forma, cada registro de asignatura guardará, además de su información general (número de créditos, carácter
optativo u obligatorio, etc.) un puntero al primer registro de matrícula de un estudiante en esa asignatura.
Cada registro de matrícula guarda, además de las notas de un estudiante en una asignatura, sendos punteros al
siguiente registro de matrícula de otro estudiante en la misma asignatura y al siguiente registro de matrícula del
mismo estudiante en otra asignatura.
De esta forma, un registro de matrícula no indica explícitamente el estudiante ni la asignatura que “empareja”. Esa
información está implícita en las dos listas “ortogonales” a las cuales pertenece. Esa limitación puede suponer un incremento
considerable del coste en tiempo de las operaciones especificadas para el diccionario, por lo que es habitual añadir, en
cada registro de matrícula, la información mínima para poder averiguar eficientemente de qué estudiante y de qué
asignatura se trata (un cursor o un puntero al registro correspondiente de estudiante o asignatura, por ejemplo).
Por ejemplo, supónganse los conjuntos de estudiantes y asignaturas, con las matriculaciones señaladas con ‘nota’ que
aparecen en la tabla de más arriba. Una implementación con estructuras de listas múltiples tendría la siguiente forma:

-- 199 of 267 --

186
Por una parte, están sin detallar en la figura las estructuras de datos utilizadas para almacenar los diccionarios o tablas
unidimensionales de estudiantes y de asignaturas. Dependiendo de sus características, se utilizaría alguna de las
soluciones vistas con anterioridad para diccionarios unidimensionales (acceso directo, vector ordenado, lista ordenada, árbol
de búsqueda, tabla dispersa…).
En cuanto a la tabla bidimensional en sí, puede observarse la disposición en una estructura de listas múltiples en la
que, en horizontal (punteros de color azul) se representan listas para obtener la proyección “notas obtenidas por un
estudiante en todas las asignaturas en la que figura”, mientras que en vertical (punteros de color verde) se representan
listas para obtener la proyección “notas de todos los estudiantes inscritos en una asignatura determinada”. Por tanto,
cada registro de esa tabla bidimensional pertenece a una lista horizontal y a otra vertical. Además, cada uno de esos registros
guarda la forma de averiguar eficientemente a qué estudiante y a qué asignatura corresponde la nota que almacena; se ha
optado por un puntero al estudiante (color violeta) y otro puntero a la asignatura (color rojo). Esto presupone que los
datos de los diccionarios unidimensionales de estudiantes y asignaturas están almacenados en memoria dinámica. Si por el
contrario se almacenan en memoria estática (vector), en lugar de punteros a sus elementos se podrían usar cursores
(variables de tipo natural indicando la componente del vector correspondiente).
Una declaración de tipos de datos (parcial, pues falta la decisión sobre los diccionarios de estudiantes y asignaturas)
para esa representación sería la siguiente.
tipos estudiante = ... {información propia de un estudiante}
asignatura = ... {información propia de una asignatura}
nota 	= ... {información propia de cada par <estudiante,asignatura>
(por ejemplo, incluye la nota)}
ptNodoEstudiante = ↑nodoEstudiante;
nodoEstudiante = registro
datoEstudiante:estudiante; {incluye una claveEstudiante}
primeraAsignatura:ptNodoNota
freg;
ptNodoAsignatura = ↑nodoAsignatura;
Alberto
Belén
Carmen
Fernando
Diccionario de
estudiantes
Ignacio
Marta
Estructuras de
datos y algoritmos
Organización de
computadores
Diccionario de asignaturas
Sistemas
operativos I
nota
nota
nota
nota
nota
nota
nota	nota
nota

-- 200 of 267 --

187
nodoAsignatura = registro
datoAsignatura:asignatura; {incluye una claveAsignatura}
primerEstudiante:ptNodoNota
freg;
ptNodoNota = ↑nodoNota;
nodoNota = registro
datoNota:nota;
quéEstudiante:ptNodoEstudiante;
quéAsignatura:ptNodoAsignatura;
sigEstudiante,sigAsignatura:ptNodoNota
freg
diccionarioEstudiantes = ... {representación de un diccionario unidimensional
de datos de tipo estudiante}
diccionarioAsignaturas = ... {representación de un diccionario unidimensional
de datos de tipo asignatura}
escuela = registro
losEstudiantes:diccionarioEstudiantes;
lasAsignaturas:diccionarioAsignaturas
freg
Dada la estructura de datos anterior, para responder a una pregunta como “¿qué estudiantes están matriculados en la
asignatura Estructuras de datos y algoritmos?, y escribir sus notas” (es decir, la proyección de notas fijada una asignatura),
hay que hacer lo siguiente:
• 	buscar los datos de esa asignatura, dada su clave (en el campo lasAsignaturas de la variable de tipo escuela
hasta llegar al registro de tipo nodoAsignatura que le corresponde); la implementación de esa búsqueda depende
de cómo se haya representado el diccionario unidimensional de asignaturas (cualquiera de los métodos vistos hasta
el momento sirve: vector de asignaturas, lista enlazada de asignaturas, árbol de búsqueda equilibrado de
asignaturas, tabla dispersa de asignaturas…);
• 	luego, basta con seguir el puntero primerEstudiante para acceder al registro de la nota (de tipo nodoNota) del
primer estudiante en esa asignatura; para saber de qué estudiante se trata, hay que seguir el puntero
quéEstudiante hasta llegar a un registro de tipo nodoEstudiante;
• 	a continuación, pasar al siguiente registro de nota en la asignatura, siguiendo el puntero sigEstudiante, etcétera;
así hasta llegar al final de la lista vertical correspondiente a notas de esa asignatura.
El siguiente algoritmo describe de forma un poco más precisa la solución:
procedimiento escribeEstudiantes(ent EINA:escuela; ent c:claveAsignatura)
{Escribe en pantalla la información (notas) de los estudiantes matriculados en la
asignatura de clave c.}
variables unaAsignatura:ptNodoAsignatura;
unEstudiante:ptNodoNota
principio
buscar(EINA,c,unaAsignatura); {devuelve en unaAsignatura un puntero al registro
de asignatura correspondiente a la asignatura
de clave c; su implementación depende de la
representación del diccionario de asignaturas}
unEstudiante:=unaAsignatura↑.primerEstudiante;
mientrasQue unEstudiante≠nil hacer
{unEstudiante apunta a un registro de nota de un estudiante en la asignatura
de clave c}
escribeEstudiante(unEstudiante↑.quéEstudiante); {escribe los datos personales
del estudiante almacenados en el
registro apuntado por ese campo}
escribeNota(unEstudiante↑.datoNota); {escribe la nota}
unEstudiante:=unEstudiante↑.sigEstudiante
fmq
fin

-- 201 of 267 --

188
Si en la estructura de datos de las listas múltiples no se incluyen los punteros quéEstudiante y quéAsignatura
que apuntan a los nodos correspondientes de los diccionarios unidimensionales de estudiantes y asignaturas, se ahorra
memoria, pero no es posible saber con coste en O(1) de qué estudiante es esa nota (primera instrucción del bucle en el
algoritmo anterior) o, respectivamente, en qué asignatura, cuando se está implementando la proyección (vertical)
escribeEstudiantes o, respectivamente, la (horizontal) análoga, escribeAsignaturas. Una forma de, al menos,
poder hacerlo (con mayor coste en tiempo), consiste en convertir las listas horizontales y las verticales de la estructura de
listas múltiples en listas circulares (horizontales y verticales), pero incluyendo en ellas los nodos de estudiante o de
asignatura de los diccionarios unidimensionales. Así, si estamos accediendo a un nodo de tipo nodoNota, sería posible
seguir su puntero en horizontal sigAsignatura hasta llegar al inicio de la lista circular, que sería el nodo de tipo
nodoEstudiante del diccionario unidimensional de estudiantes. Evidentemente, esa implementación obliga a que todos
los nodos (registros) utilizados para almacenar estudiantes, asignaturas y notas sean de un mismo tipo. Hay lenguajes que
permiten hacer esto con registros con campos variantes, de forma que se definen tres variantes de registro (clase
estudiante, clase asignatura, clase nota) y en cada una se almacenan exclusivamente los campos necesarios para cada
variante. Si el lenguaje no permite la definición de registros con variantes, entonces todo nodo tiene que tener todos los
campos de las tres variantes.
Si permitimos definir registros con variantes en nuestro pseudocódigo, la estructura de datos utilizada en esa solución
alternativa sería:
tipos estudiante = ... {información propia de un estudiante}
asignatura = ... {información propia de una asignatura}
nota 	= ... {información propia de cada par <estudiante,asignatura>
(por ejemplo, incluye la nota)}
claseNodo = (estudiante,asignatura,nota)
ptNodo = ↑nodo
nodo = registro
clase:claseNodo;
selección
clase=estudiante: (datoEstudiante:estudiante;
primeraAsignatura:ptNodo);
clase=asignatura: (datoAsignatura:asignatura;
primerEstudiante:ptNodo);
clase=nota: 	(datoNota:nota;
sigEstudiante,sigAsignatura:ptNodo)
fselección
freg
diccionarioEstudiantes = ... {representación de un diccionario unidimensional
de datos de tipo estudiante, en el que cada
estudiante se almacena en un registro de tipo nodo
de clase estudiante}
diccionarioAsignaturas = ... {representación de un diccionario unidimensional
de datos de tipo asignatura, en el que cada
asignatura se almacena en un registro de tipo nodo
de clase asignatura}
escuela = registro
losEstudiantes:diccionarioEstudiantes;
lasAsignaturas:diccionarioAsignaturas
freg
Gráficamente, la representación de la estructura de listas múltiples para las definiciones anteriores de tipos resultaría
como en la figura siguiente.

-- 202 of 267 --

189
nota
Estructuras de
datos y algoritmos
Organización de
computadores
Sistemas
operativos I
Alberto
Belén
Carmen
Fernando
Ignacio
Marta
nota
nota
nota
nota
nota 	nota
nota	nota
Con esta estructura de datos alternativa, el algoritmo de proyección vertical para responder a la pregunta: “¿qué
estudiantes están matriculados en la asignatura Estructuras de datos y algoritmos?, y escribir sus notas”, queda de la
siguiente forma:
procedimiento escribeEstudiantes(ent EINA:escuela; ent c:claveAsignatura)
{Escribe en pantalla la información (notas) de los estudiantes matriculados en la
asignatura de clave c.}
variables unaAsignatura,unEstudiante,aux:ptNodo
principio
buscar(EINA,c,unaAsignatura); {devuelve en unaAsignatura un puntero al registro
de asignatura correspondiente a la asignatura
de clave c; su implementación depende de la
representación del diccionario de asignaturas}
unEstudiante:=unaAsignatura↑.primerEstudiante;
mientrasQue unEstudiante↑.clase=nota hacer
{unEstudiante apunta a un registro de nota de un estudiante en la asignatura
de clave c}
aux:=unEstudiante↑.sigAsignatura;
mientrasQue aux↑.clase=nota hacer
{recorrer, en horizontal, el resto de registros de nota de ese estudiante}
aux:=aux↑.sigAsignatura
fmq; {al terminar el bucle, aux apunta a un registro de clase estudiante}
escribeEstudiante(aux); {escribe los datos personales del estudiante almacenados
en el registro apuntado por aux}
escribeNota(unEstudiante↑.datoNota); {escribe la nota}
unEstudiante:=unEstudiante↑.sigEstudiante
fmq
fin
Como puede verse, el coste aumenta con respecto a la solución vista para la representación previa. Para cada nota de
un estudiante en la asignatura dada, es preciso recorrer la lista horizontal de notas de ese estudiante (bucle interno del
algoritmo; en el caso peor, lineal en el número total de asignaturas; en la práctica, lineal en el número de asignaturas en que
está matriculado ese estudiante) hasta llegar al registro de clase estudiante correspondiente.

-- 203 of 267 --

190

-- 204 of 267 --