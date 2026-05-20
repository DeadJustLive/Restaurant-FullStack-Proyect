# parte im: portante de los diferentes gestores.

## Fuente
Jordi Casas Roma (Cap. 5)

## Contenido
# parte im: portante de los diferentes gestores.

El estándar SQL incorpora la definición de todos los componentes del diseño
lógico de la base de datos. En cambio, no contiene ningún elemento del diseño
físico.
Para transformar el diseño lógico de la base de datos en un SGBD concreto,
partimos de las definiciones de tablas (con toda la información relacionada;
es decir, atributos, claves primarias, claves foráneas y claves alternativas). A
continuación se relaciona cada elemento con un espacio adecuado en el nivel
virtual y finalmente se relaciona cada espacio virtual con un fichero físico, que
constituye el nivel físico del sistema de información.
2.5. Fase 5. Implementación y optimización
La última etapa es la implementación y la optimización de la base de datos.

-- 16 of 22 --

CC-BY-NC-ND • PID_00213710 17 Introducción al diseño de bases de datos
La etapa￿ de￿ implementación￿ y￿ optimización consiste en realizar la
carga de los datos y posteriormente ajustar algunos parámetros relacio-
nados con el modelo físico de la base de datos para optimizar el rendi-
miento.
El objetivo principal de esta etapa es optimizar el rendimiento de la base de
datos. En primer lugar, hay que realizar la carga de los datos, puesto que no es
posible optimizar el acceso a los datos sin poder determinar el tamaño de las
tablas, los tipos de accesos y consultas, la frecuencia de éstos, etc.
Finalmente, también habrá que concretar los diferentes roles de usuarios y
aplicaciones para poder determinar los permisos de los diferentes grupos. El
componente de gestión de la seguridad y las vistas permiten limitar los accesos
y de este modo reducir el riesgo de problemas derivados de accesos no auto-
rizados.
2.5.1. Procesamiento y optimización de consultas
El lenguaje SQL empleado por las bases de datos relacionales es un lenguaje
declarativo. Esto implica que se especifica el resultado que se quiere obtener
a partir de una consulta realizada, en lugar de determinar el algoritmo o el
método que hay que usar para obtener el resultado. Por lo tanto, es necesario
entender el conjunto de tareas que realizan los SGBD relacionales para obtener
la respuesta deseada.
Los SGBD relacionales evalúan sistemáticamente las posibles estrategias alter-
nativas que se pueden presentar, con el objetivo de elegir la que se considera
óptima. El procesamiento de consultas recoge todo el conjunto de actividades
realizadas por el SGBD, que tienen como objetivo la extracción de informa-
ción de la base de datos para lograr la estrategia más eficiente y proporcionar
un mejor rendimiento del sistema de información.
El procesamiento de consultas se puede dividir en las cuatro etapas principales
siguientes:
1)￿Descomposición￿de￿la￿consulta. Traducción de la consulta expresada en
lenguaje SQL a una representación interna basada en el álgebra relacional.
2)￿Optimización￿de￿la￿consulta. Proceso de selección del plan de ejecución
de la consulta más eficiente entre las muchas estrategias generalmente dispo-
nibles en el procesamiento de una consulta. La optimización de consultas se
puede realizar sobre tres vertientes:

-- 17 of 22 --

CC-BY-NC-ND • PID_00213710 18 Introducción al diseño de bases de datos
a) Optimización semántica basada en las restricciones especificadas en el es-
quema de la base de datos.
b) Optimización sintáctica, que consiste en transformar heurísticamente la
expresión relacional original en otra equivalente pero que sea mucho más efi-
ciente.
c) Optimización física, con el objetivo de elegir entre los distintos planes de
evaluación –que pueden tener costes diferentes– el que sea más eficiente. Para
determinar el coste más eficiente hay que conocer el coste de cada operación,
que a menudo depende de diferentes parámetros.
3)￿Generación￿de￿código.
4)￿Ejecución￿de￿la￿consulta.
Es el proceso de optimización de consultas, es decir, el tratamiento que da
un SGBD a las consultas hechas por los usuarios mediante SQL. Este punto es
uno de los más importantes que se deben tener en cuenta cuando se diseña
un SGBD relacional, puesto que la opción elegida afecta directamente al ren-
dimiento global del sistema.
La optimización de consultas es un aspecto muy importante que hay que con-
siderar cuando se diseña y se construye un SGBD relacional. Las técnicas que
se utilizan para optimizar consultas condicionan el rendimiento global del
sistema, puesto que determinan el tiempo que necesita el sistema gestor para
resolver las consultas que han hecho los usuarios.
2.5.2. Procesamiento de vistas
Una vista es una tabla lógica que permite acceder a la información de una o
varias tablas mediante una consulta predefinida. No contiene información por
sí misma, sino que se basa en información de otras tablas. Las vistas propor-
cionan mecanismos de seguridad y permiten al diseñador de la base de datos
personalizar la vista que tienen los diferentes usuarios de la base de datos.
Hacer un uso adecuado de las vistas es un aspecto clave para lograr un buen
diseño de una
