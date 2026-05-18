# 11. Gestionado Dependencias

de Datos
Hasta ahora hemos desarrollado una aplicación que mantiene las notas en el localS-
torage. Para hacer algo más parecido a Kanban necesitamos modelar el concepto de
Carril. Un Carril es algo que debe ser capaz de almacenar muchas notas y conocer
su orden. Una forma de modelar esto es simplemente crear un Carril que contenga
un array de identificadores de Nota.
Sin embargo, esta relación puede invertirse. Una Nota puede tener referencia a un
Carril utilizando un identificador y almacenando cuál es su posición dentro del
Carril. En nuestro caso vamos a utilizar el primer enfoque ya que permite reordenar
con más facilidad.