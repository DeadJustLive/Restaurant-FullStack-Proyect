# 2. Conceptos y principales características

## Fuente
introduccion-poo (Cap. 5)

## Contenido
# 2. Conceptos y principales características

La tecnología orientada a objetos ya no se aplica solamente en los lenguajes
de programación, se aplica también en el análisis y diseño de software, al igual
que en las bases de datos. Es uno de los modelos más productivos, que se debe a
sus grandes capacidades y ventajas frente al resto de modelos de programación.
La orientación a objetos se basa en la división del programa en pequeñas uni-
dades lógicas de código; estas unidades es lo que se conoce como objetos. Éstos
son unidades independientes que se comunican entre sí mediante mensajes.
Las principales￿ventajas de un lenguaje orientado a objetos son:
• El fomento de la reutilización y extensión del código.
• La elaboración de sistemas más complejos.
• La relación del sistema con el mundo real.
• La creación de programas visuales.
• La construcción de prototipos.
• La agilización del desarrollo de software.
• La facilitación del trabajo en equipo.
• Un mantenimiento más sencillo del software.
Uno de los aspectos más interesantes de la programación orientada a objetos es
que proporciona conceptos y herramientas con las que se modela y representa
el mundo real tan fielmente como sea posible.
En los siguientes subapartados se mostrarán ejemplos utilizando el lenguaje
de programación Java.
Se ha elegido el lenguaje Java por dos motivos principalmente: en primer lugar
cumple todos los conceptos de la POO que vamos a explicar, y en segundo
lugar su sintaxis es sencilla y por lo tanto, facilita la comprensión.
Los ejemplos no están para reproducirlos, sino para ayudar a comprender los
conceptos que se explican. En el siguiente módulo el estudiante podrá practi-
car parte de estos conceptos con JavaScript, y solo es una parte, ya que este no
cubre todo el paradigma de la programación orientada a objetos.
2.1. El modelo orientado a objetos
El modelo de programación orientada a objetos se basa en los siguientes con-
ceptos fundamentales:
• Clases.

-- 11 of 44 --

CC-BY-NC-ND • PID_00220485 12 Introducción a la programación orientada a objetos
• Objetos.
• Herencia.
• Envío de mensajes.
2.1.1. Clases
La estandarización es una técnica que provoca que existan distintos
objetos de un mismo tipo, que comparten el proceso de fabricación.
En el mundo de la programación orientada a objetos, nuestro teléfono móvil
podría ser una instancia de una clase que se podría llamar "teléfono". Cada
teléfono móvil tiene una serie de características, como la marca, el modelo,
el sistema operativo, el tipo de pantalla y de teclado, etc.; y algunos de sus
comportamientos son: realizar y recibir llamadas, enviar mensajes, transmitir
datos, etc.
En el proceso de fabricación se aprovecha el hecho de que los móviles com-
parten características y se construyen modelos o plantillas comunes, a partir
de las que se crean millares de teléfonos móviles del mismo modelo.
En el mundo de la programación orientada a objetos, la plantilla se conoce
como clase y a los equipos que sacamos a partir de ella los llamamos objetos o
instancia de clase. De esta manera, de una única clase se pueden crear muchos
objetos del mismo tipo.
La clase es un modelo o prototipo, que define las variables y métodos comunes
a todos los objetos, o una plantilla genérica para un conjunto de objetos de
similares características.
La instancia es un objeto de una clase en particular.
La figura siguiente presenta un ejemplo de una clase "posición", en la que se
tienen 4 métodos (iniciar, leerX, leerY y saluda) y dos propiedades X e Y:
Figura 1
Ejemplos
Algunos ejemplos de estanda-
rización podrían ser el teléfono
móvil, el coche, el ordenador,
la televisión, etc.

-- 12 of 44 --

CC-BY-NC-ND • PID_00220485 13 Introducción a la programación orientada a objetos
A partir de esta clase se pueden crear tantos objetos como se necesiten y todos
tendrán los métodos y las propiedades definidos en la clase.
En Java la creación de una clase se realiza utilizando la palabra clave reservada
class seguida del nombre de la clase y finaliza con un bloque de código deli-
mitado por dos llaves que definen el cuerpo de la clase. Por ejemplo:
class miPunto {
}
Aunque la clase miPunto es sintácticamente correcta, se la conoce como una
clase vacía (ya que no dispone de métodos ni propiedades).
Pero una clase debe definir las propiedades y métodos de un objeto. La sintaxis
de una definición de clase es:
class Nombre_De_Clase {
tipo_de_variable nombre_de_propiedad1;
tipo_de_variable nombre_de_propiedad2;
// . . .
tipo_devuelto nombre_de_metodo1( lista_de_parametros ) {
cuerpo_del_metodo1;
}
tipo_devuelto nombre_de_metodo2( lista_de_parametros ) {
cuerpo_del_metodo2;
}
// . . .
}
Los tipos tipo_de_variable y tipo_devuelto deben ser tipos simples Java o nom-
bres de otras clases ya definidas anteriormente.
Las propiedades se definen en el interior de la clase declarando variables. Por
ejemplo, a continuación se añaden a la clase miPunto dos propiedades, x e y:
class miPunto {
int x, y;
}
Las propiedades se 
