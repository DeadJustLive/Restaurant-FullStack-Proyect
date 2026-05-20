# 6. Edición de Notas

## Fuente
react-aprendiz-maestro (Cap. 53)

## Contenido
# 6. Edición de Notas

La edición de notas supone un problema similar al del borrado, ya que el flujo de
datos es exactamente el mismo. Necesitamos definir qué hacer tras invocar a onEdit
y hacer una asociación con bind al identificador de la nota dentro de Notas que está
siendo editado.
Lo que hace que este escenario sea más difícil son los requisitos a nivel de interfaz
de usuario. No es suficiente con tener un botón, necesitamos encontrar la manera de
permitir al usuario introducir un nuevo valor y de persistirlo en el modelo de datos.
Una forma de conseguirlo es mediante la implementación de algo llamado edición
en línea. La idea es que cuando un usuario pulse sobre una nota se muestre una caja
de texto. Cuando el usuario haya terminado la edición, bien pulsando enter o bien
pulsando fuera del campo (lanzando un evento de tipo blur), capturaremos el valor
y lo actualizaremos.
