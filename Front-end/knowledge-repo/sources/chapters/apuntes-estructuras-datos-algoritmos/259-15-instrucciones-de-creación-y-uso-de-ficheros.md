# 15. Instrucciones de creación y uso de ficheros

A continuación se muestra un esquema básico del trabajo con ficheros de texto o binarios, junto con las instrucciones
disponibles en pseudocódigo para trabajar con ellos.
• 	Ficheros de texto
variables
f: fichero de texto
d: carácter
nombre: cadena
...
principio
{Asociar la variable f con el fichero externo de nombre “Leeme.txt”:}
asociar(f, “Leeme.txt”);
{Inicializar el fichero para escritura: el fichero externo es creado vacío}
iniciarEscritura(f);
{Para 	escribir 	en 	un 	fichero 	de 	texto 	se 	considerarán 	también 	disponibles 	las
mismas instrucciones que para escribir en pantalla o salida estándar, con el mismo
significado y la misma sintaxis salvo porque se les añade un primer parámetro que es
la variable fichero. Ejemplo:}
escribir(f,d); {escribe en f el caracter d al final del fichero}
escribir(f,nombre); {escribe en f la cadena nombre al final del fichero}
. . .
{Inicializar para lectura el fichero asociado con f, la posición de lectura para
el fichero f se situa para que el primer dato que se lea sea el primero del fichero:}
iniciarLectura(f);
{Para saber si ya no quedan más datos que leer en el fichero (se ha leído ya el
último 	dato), 	está 	disponible 	la 	función: 	finFichero(f) 	(devuelve 	booleano
indicándolo)}
mientrasQue not finFichero(f) hacer
{Para leer de fichero de texto se considerarán también disponibles las mismas
instrucciones que para leer de teclado o entrada estándar, con el mismo significado
y 	la 	misma 	sintaxis 	salvo 	porque 	se 	les 	añade 	un 	primer 	parámetro 	que 	es 	la
variable fichero. Ejemplo:}
leer(f,d); {lee el siguiente dato del fichero f y lo deja en d (lee carácter),
y deja disponible para ser leído el siguiente dato en el fichero}
. . .
fmq;
{Eliminar la asociación entre f y el fichero externo:}
disociar(f);
...
Fin
• 	Ficheros binarios
Similares a los ficheros de texto, pero en ellos la unidad mínima de información para la lectura o escritura es un
dato del tipo especificado en la creación de la variable fichero (y por supuesto no están estructurados en líneas).
variables
ff: fichero de fecha 	{tipo fichero binario de fechas. En el se leerán o escribirán
datos de tipo fecha}
dia: fecha
...
principio
{asociar la variable ff con el fichero externo de nombre “misDatos.dat”:}
asociar(ff, “misDatos.dat”);

-- 264 of 267 --

251
{Inicializar para escritura: el fichero externo es creado vacío y la posición de
escritura en el fichero se mantendrá siempre al final del mismo}
iniciarEscritura(ff);
escribir(ff,dia); {escribe en ff el dato dia, siempre al final del fichero}
. . .
iniciarLectura(ff); {Inicializar para lectura el contenido del fichero asociado
con ff, la posición de lectura para el fichero ff queda justo por delante del primer
dato del fichero}
{Para saber si ya no quedan más datos que leer en el fichero (se ha leído ya el
último 	dato), 	está 	disponible 	la 	función: 	finFichero(ff) 	(devuelve 	booleano
indicándolo)}
mientrasQue not finFichero(ff) hacer
{Para leer un dato de un fichero binario:}
leer(ff,dia); {lee la siguiente fecha en el fichero ff y la deja en dia, y deja
disponible para ser leído el siguiente dato del fichero}
fmq;
{eliminar la asociación entre ff y el fichero externo:}
disociar(ff);
...
fin

-- 265 of 267 --

252

-- 266 of 267 --

253
Bibliografía
Bibliografía Básica:
Weiss, M.A.: Data Structures and Algorithm Analysis in C++, 4th Edition, Pearson/Addison Wesley, 2014.
Hernández, Z.J. y otros: Fundamentos de Estructuras de Datos. Soluciones en Ada, Java y C++, Thomson, 2005.
Shaffer, Clifford A.: Data Structures and Algorithm Analysis in C++, Third Edition, Dover Publications, 2013.
Ejercicios:
Martí Oliet, N., Ortega Mallén, Y., Verdejo López, J.A.: Estructuras de datos y métodos algorítmicos: 213
ejercicios resueltos. 2ª Edición, Ed. Garceta, 2013.
Joyanes, L., Zahonero, I., Fernández, M. y Sánchez, L.: Estructura de datos. Libro de problemas, McGraw Hill,
1999.
Bibliografía sobre C++:
Stroustrup, B.: The C++ Programming Language, 4th Edition, Addison-Wesley, 2013.
Bibliografía Complementaria:
Franch Gutiérrez, X.: Estructuras de Datos. Especificación, Diseño e Implementación, 3ª edición, Ed. Edicions
UPC, 2001.
Mehta, D.P. y Sahni, S.: Handbook of Data Structures and Applications, Chapman & Hall/CRC, 2005.
Aho, A. V., Hopcroft, J. E. y Ullman, J. D.: Estructuras de Datos y Algoritmos, Addison-Wesley, 1988.
Knuth, D. E.: El arte de programar ordenadores, volumen III: clasificación y búsqueda, Ed. Reverté, 1987.
Wirth, N.: Algoritmos + Estructuras de Datos = Programas, Ediciones del Castillo, S.A., 1986.
Peña, R.: Diseño de Programas. Formalismo y Abstracción, Pearson Educación, 2005.

-- 267 of 267 --