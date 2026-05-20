# 9.2 Entendiendo las Acciones

Las acciones son uno de los conceptos principales de la arquitectura Flux. Para ser
exactos, es una buena idea separar acciones de creadores de acciones. A menudo
estos términos son intercambiables, pero hay una diferencia considerable.
Los creadores de acciones son literalmente funciones que lanzan acciones. El
contenido de la acción será repartido a los almacenes que estén interesados. Puede
ser útil pensar en ellos como mensajes dentro de un envoltorio que son repartidos.
Esta división es útil si quieres hacer acciones asíncronas. Puedes, por ejemplo, querer
recuperar los datos iniciales de tu tablero Kanban. La operación puede ir bien o ir

-- 104 of 226 --

Implementando NoteStore y NoteActions 87
mal, lo cual te dará tres acciones distintas que lanzar. Puedes lanzar acciones cuando
comienzas la consulta y cuando recibes una respuesta.
Todos estos datos son valiosos si te permiten controlar la interfaz del usuario. Puedes
mostrar una barra de progreso mientras la consulta se está realizando y actualizar
el estado de la aplicación una vez llegan los datos del servidor. Si la consulta falla
puedes hacer que el usuario lo sepa.
Este asunto es igual en otros gestores de estados. A menudo modelas una acción como
una función que devuelve una función que lanza acciones individuales como puede
ser el seguimiento del progreso de las consultas. En un ingenuamente síncrono caso
es suficiente con devolver directamente el resultado de la acción.
La documentación oficial de Alt cubre las acciones asíncronas1 con más
detalle.