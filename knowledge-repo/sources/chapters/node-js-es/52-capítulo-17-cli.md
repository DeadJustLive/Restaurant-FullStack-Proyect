# Capítulo 17:: CLI

Sintaxis
nodo [opciones] [opciones v8] [script.js | -e "script"] [argumentos]	•
Examples
Opciones de línea de comando
-v, --version
Añadido en: v0.1.3 Imprimir versión del nodo.
-h, --help
Añadido en: v0.1.3 Imprimir opciones de línea de comando del nodo. El resultado de esta opción
es menos detallado que este documento.
-e, --eval "script"
Añadido en: v0.5.2 Evalúe el siguiente argumento como JavaScript. Los módulos que están
predefinidos en el REPL también se pueden usar en el script.
-p, --print "script"
Añadido en: v0.6.4 Idéntico a -e pero imprime el resultado.
-c, --check
Añadido en: v5.0.0 Sintaxis, compruebe el script sin ejecutar.
-i, --interactive
Añadido en: v0.7.7 Abre el REPL incluso si la entrada estándar no parece ser un terminal.
-r, --require module
Añadido en: v1.6.0 Precargue el módulo especificado al inicio.
Los seguimientos requieren las reglas de resolución de módulos de (). módulo puede ser una ruta
a un archivo o un nombre de módulo de nodo.
--no-deprecation
https://riptutorial.com/es/home 89

-- 117 of 423 --

Agregado en: v0.8.0 Advertencias de desaprobación de silencio.
--trace-deprecation
Agregado en: v0.8.0 Imprimir seguimientos de pila para desaprobaciones.
--throw-deprecation
Agregado en: v0.11.14 Tirar errores por desaprobaciones.
--no-warnings
Añadido en: v6.0.0 Silencie todas las advertencias de proceso (incluidas las depreciaciones).
--trace-warnings
Agregado en: v6.0.0 Imprimir seguimientos de la pila para advertencias de proceso (incluidas las
desaprobaciones).
--trace-sync-io
Agregado en: v2.1.0 Imprime un seguimiento de pila cada vez que se detecta una E / S sincrónica
después del primer giro del bucle de eventos.
--zero-fill-buffers
Añadido en: v6.0.0 Rellena automáticamente en cero todas las instancias de Buffer y SlowBuffer
recién asignadas.
--preserve-symlinks
Añadido en: v6.3.0 Indica al cargador de módulos que mantenga los enlaces simbólicos al
resolver y almacenar en caché los módulos.
De forma predeterminada, cuando Node.js carga un módulo desde una ruta que está
simbólicamente vinculada a una ubicación diferente en el disco, Node.js eliminará la referencia al
enlace y usará la "ruta real" real del disco como módulo. y como ruta raíz para ubicar otros
módulos de dependencia. En la mayoría de los casos, este comportamiento predeterminado es
aceptable. Sin embargo, cuando se usan dependencias de iguales vinculadas simbólicamente,
como se ilustra en el siguiente ejemplo, el comportamiento predeterminado hace que se genere
una excepción si el módulo A intenta requerir el módulo B como una dependencia de iguales:
{appDir}
├── app
│ ├── index.js
│ └── node_modules
│ ├── moduleA -> {appDir}/moduleA
│ └── moduleB
https://riptutorial.com/es/home 90

-- 118 of 423 --

│ ├── index.js
│ └── package.json
└── moduleA
├── index.js
└── package.json
El indicador de línea de comando --preserve-symlinks le indica a Node.js que use la ruta del
enlace simbólico para los módulos en lugar de la ruta real, lo que permite que se encuentren
dependencias entre iguales simbólicamente vinculadas.
Tenga en cuenta, sin embargo, que el uso de --preserve-symlinks puede tener otros efectos
secundarios. Específicamente, los módulos nativos vinculados simbólicamente pueden no
cargarse si están vinculados desde más de una ubicación en el árbol de dependencias (Node.js
los vería como dos módulos separados e intentaría cargar el módulo varias veces, lo que
provocaría una excepción) ).
--track-heap-objects
Añadido en: v2.4.0 Rastrear las asignaciones de objetos del montón para las instantáneas del
montón.
--prof-process
Añadido en: v6.0.0 Procesar la salida del generador de perfiles de v8 generada mediante la
opción v8 --prof.
--v8-options
Añadido en: v0.1.3 Imprimir v8 opciones de línea de comando.
Nota: las opciones de v8 permiten que las palabras estén separadas por guiones (-) o guiones
bajos (_).
Por ejemplo, --stack-trace-limit es equivalente a --stack_trace_limit.
--tls-cipher-list=list
Añadido en: v4.0.0 Especifique una lista de cifrado TLS predeterminada alternativa. (Requiere
que Node.js sea creado con soporte criptográfico. (Predeterminado))
--enable-fips
Añadido en: v6.0.0 Habilitar criptografía compatible con FIPS en el inicio. (Requiere que Node.js
sea construido con ./configure --openssl-fips)
--force-fips
Añadido en: v6.0.0 Forzar el cifrado compatible con FIPS en el inicio. (No se puede desactivar
https://riptutorial.com/es/home 91

-- 119 of 423 --

desde el código del script). (Los mismos requisitos que --enable-fips)
--icu-data-dir=file
Añadido en: v0.11.15 Especifique la ruta de carga de datos de ICU. (anula NODE_ICU_DATA)
Environment Variables
NODE_DEBUG=module[,…]
Agregado en: v0.1.32 ',' - lista separada de módulos principales que deberían imprimir información
de depuración.
NODE_PATH=path[:…]
Agregado en: v0.1.32 ':' - lista separada de directorios prefijados a la ruta de búsqueda del
módulo.
Nota: en Windows, esta es una lista separada por ';'.