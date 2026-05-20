# parte im: portante de este tiempo está bajo el control del SGBD y hace refe-

## Fuente
Jordi Casas Roma (Cap. 4)

## Contenido
# parte im: portante de este tiempo está bajo el control del SGBD y hace refe-

-- 15 of 22 --

CC-BY-NC-ND • PID_00213710 16 Introducción al diseño de bases de datos
rencia al tiempo de acceso por parte del SGBD a los datos requeridos para
generar la respuesta. Otros aspectos no son controlados por el SGBD, como
por ejemplo la planificación del sistema operativo o los tiempos de acceso
a los medios físicos de almacenamiento de los datos.
• Uso￿del￿espacio. Es la cantidad de espacio de disco utilizado por los fiche-
ros de la base de datos y las estructuras de rutas de acceso al disco, inclu-
yendo índices y otras rutas de acceso.
• Rendimiento. Es la cantidad media de transacciones que se pueden pro-
cesar en un minuto de tiempo. Este factor puede ser crítico para sistemas
transaccionales, como por ejemplo líneas aeronáuticas o entidades banca-
rias.
2.4.2. Transformación del modelo lógico en el modelo físico
En este paso se transforma el modelo lógico de una base de datos en un mode-
lo físico, según el SGBD elegido para implementar el sistema de información,
las características concretas del hardware utilizado y el sistema operativo y el
software básico. Cada SGBD ha desarrollado un lenguaje propio, hecho a me-
dida por el constructor mismo, para implementar el diseño físico de la base
de datos, de acuerdo con las características del entorno, y para obtener el má-
ximo rendimiento del hardware, del sistema operativo y del propio gestor. En
realidad, se podría considerar una ampliación del lenguaje SQL estándar con
las cláusulas propias que cada gestor necesita para definir los componentes del
diseño físico. Sin embargo, existe un gran parecido o equivalencia entre una
