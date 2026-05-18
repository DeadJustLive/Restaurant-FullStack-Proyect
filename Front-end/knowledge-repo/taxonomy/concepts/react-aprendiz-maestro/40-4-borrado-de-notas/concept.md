# 4. Borrado de Notas

## Fuente
react-aprendiz-maestro (Cap. 40)

## Contenido
# 4. Borrado de Notas

Una forma sencilla de permitir el borrado de notas consiste en mostrar un botón con
una “x” en cada Nota. Cuando este botón sea pulsado, simplemente deberemos borrar
la nota en cuestión de la estructura de datos. Tal y como hicimos antes podemos
comenzar añadiendo borradores, éste puede ser un buen lugar en el que separar el
concepto de Nota del componente Notas.
A menudo trabajarás de esta forma con React. Generarás componentes de los que más
adelante te darás cuenta que están compuestos por otros componentes que pueden
ser extraidos. Este proceso de separación es fácil, y a veces puede incluso incrementar
el rendimiento de tu aplicación puesto que la estás optimizando al renderizar partes
más pequeñas.
