# 3. Uso de HTTP

## Fuente
2.3.6 Guia Desarrollo Software v2.0 (Cap. 40)

## Contenido
# 3. Uso de HTTP

Las operaciones de las interfaces
programables (APIs) deben tender a
utilizar el protocolo HTTP3 , ser
procesadas en tiempo real y entregar
una respuesta según la codificación
establecida en el protocolo HTTP:
● GET: Solicitar un recurso.
● POST: Crear un nuevo recurso
subordinado dentro de una URL
existente.
● DELETE: Eliminar un recurso.
● PUT: Crear un nuevo recurso a una
nueva URL o modificar un recurso
existente en una URL.
3
https://www.w3.org/Protocols/rfc2616/rfc2616-
sec9.html
División de Gobierno Digital | Lineamientos para desarrollo de software 	21

-- 21 of 33 --

● HEAD: Idéntica a GET, excepto que
no se retorna un cuerpo del mensaje
en la respuesta.
● CONNECT: Establece un túnel hacia
el servidor identificado por el
recurso.
● OPTIONS: Utilizado para describir
las opciones de comunicación para
el recurso de destino.
● TRACE: Realiza una prueba de bucle
de retorno de mensaje a lo largo de
la ruta al recurso de destino.
● PATCH: Es utilizado para aplicar
modificaciones parciales a un
recurso.
Es importante identificar que, de los
métodos precedentes, los cuatro
primeros son los más utilizados, en
particular para atender las operaciones
CRUD (create, read, update y delete).
