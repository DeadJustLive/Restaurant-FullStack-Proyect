# 3. Implementación con estructuras de listas múltiples

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 106)

## Contenido
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

