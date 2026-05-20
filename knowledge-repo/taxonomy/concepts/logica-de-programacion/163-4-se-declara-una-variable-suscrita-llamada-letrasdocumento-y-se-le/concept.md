# 4. Se declara una variable suscrita llamada letrasDocumento y se le

## Fuente
logica-de-programacion (Cap. 163)

## Contenido
# 4. Se declara una variable suscrita llamada letrasDocumento y se le

da un tama˜no de 50 posiciones para datos de tipo Caracter. (Ver
Figura 6.5).
Caracter letrasDocumento [ ]
letrasDocumento = dimensionar( 50 )
letrasDocumento -> . . .
1 2 3 . . . 49 50
Figura 6.5: Vector letrasDocumento
La funci´on dimensionar() no requiere que se env´ıe una constante
num´erica como argumento, tambi´en se puede usar el contenido de una
variable o constante de tipo Entero. Por ejemplo:
Entero edadEstudiante[ ]
Entero cantidadPersonas
cantidadPersonas = 20
edadEstudiante = dimensionar( cantidadPersonas )
Aclaraci´on:
Aunque se puede declarar una variable en cualquier
