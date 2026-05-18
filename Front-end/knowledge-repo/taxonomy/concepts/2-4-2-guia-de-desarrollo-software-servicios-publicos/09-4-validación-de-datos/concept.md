# 4. Validación de datos

## Fuente
2.4.2 Guia de Desarrollo Software Servicios Publicos (Cap. 9)

## Contenido
# 4. Validación de datos

Ésta es una técnica para asegurar que
sólo los datos con el formato correcto
podrán ingresar al sistema a desarrollar.
Esta validación debe ser correcta, tanto
sintáctica como semánticamente. Por
ejemplo, si esperamos que en un campo
se puedan ingresar sólo dígitos, no
debemos aceptar otro tipo de
caracteres (validación sintáctica). La
validación semántica es un poco más
compleja y consiste en validar que los
datos tengan sentido en el contexto de
la aplicación, por ejemplo, una fecha de
inicio no podría estar después de una
fecha de fin.
La validación de datos debe ser, como
mínimo, a través de mecanismos de
lista negra (datos conocidos como
maliciosos). Como una mejor práctica
también se validará a través de lista
blanca (datos conocidos como
correctos, por ejemplo, una lista de
regiones).
La validación de datos, al igual que la
codificación y escape, deben ser
siempre realizados en el servidor y
nunca del lado del cliente (por ejemplo,
no se debe realizar en el navegador del
usuario). No se debe confundir un aviso
al usuario (por ejemplo, para alertar de
un campo mal ingresado) con la
validación de datos.
La validación de datos no convierte
automáticamente a los datos en
seguros, por lo que se debe utilizar en
conjunto con otras defensas, tales
como la parametrización de consultas y
escapado de datos, mencionados
anteriormente.
Para la validación de datos, incluyendo
datos 	complejos, 	tales 	datos
serializados, HTML u otros, se deberían
utilizar librerías apropiadas para ello
(HTML Purifier, Bleach, entre otras).
