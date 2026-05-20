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
Las propiedades se pueden declarar con dos clases de tipos de datos: un tipo
simple del lenguaje o el nombre de una clase (será una referencia a un objeto).
Los métodos son funciones que definen la interfaz de una clase, sus capaci-
dades y comportamiento. Éstos se declaran al mismo nivel que las variables
dentro de la definición de clase.

-- 13 of 44 --

CC-BY-NC-ND • PID_00220485 14 Introducción a la programación orientada a objetos
En la declaración de los métodos se define el tipo de valor que devuelven y una
lista de parámetros de entrada separados por comas. En el siguiente ejemplo,
el método devuelve la suma de dos enteros:
int metodoSuma( int paramX, int paramY ) {
return ( paramX + paramY );
}
En el caso de que no se desee devolver ningún valor, se deberá indicar como
tipo la palabra reservada void. Asimismo, si no se desean parámetros, la decla-
ración del método debería incluir un par de paréntesis vacíos:
void metodoVacio( ) { };
Los métodos son llamados indicando una instancia individual de la clase, que
tendrá su propio conjunto único de variables de instancia, por lo que los mé-
todos se pueden referir directamente a ellas. El siguiente método inicia() se
utiliza para establecer los valores de las dos variables de instancia:
void inicia( int paramX, int paramY ) {
x = paramX;
y = paramY;
}
A continuación, vamos a presentar un ejemplo completo en el que se define
una clase con métodos y propiedades. Las principales características de esta
clase son las siguientes:
• La clase modela un punto de espacio, por lo tanto, dispone de dos propie-
dades que definen sus coordenadas.
• La clase dispone de dos métodos. El primero realiza la suma de las dos
coordenadas y devuelve el valor; el segundo calcula la distancia entre el
propio punto y las coordenadas del punto pasado como parámetro.
//Definimos una clase miPunto con:
//un método metodoSuma, que nos retorna la suma de las dos coordenadas que se pasan como parámetros
//un método distancia que calcula la distancia entre el punto pasado como parámetro y el punto
//del objeto
//un método metodoVacio ¡que no hace nada!
class miPunto {
//Definimos dos propiedades x e y, que definen las coordenadas del objeto punto
int x, y;
//Definimos un método que retorna el valor de la suma de los dos valores enteros que se le pasan
//como parámetros

-- 14 of 44 --

CC-BY-NC-ND • PID_00220485 15 Introducción a la programación orientada a objetos
int metodoSuma( int paramX, int paramY ) {
return ( paramX + paramY );
}
//Definimos una función que nos retorna la distancia entre el punto objeto y el que se pasa
//por parámetro
doble distancia( int x, int y ) {
//Asignamos a la variable dx la diferencia entre la coordenada x del objeto
(this.x) y la coordenada x pasada por el parámetro
int dx= this.x - x;
//Asignamos a la variable dy la diferencia entre la coordenada y del objeto (this.y)
//y la coordenada y pasada por el parámetro
int dy = this.y - y;
//Retornamos el resultado de la raíz cuadrada de la suma de dx y dy, por lo
//tanto, la distancia entre dos puntos
return Math.sqrt( dx*dx + dy*dy );
}
//Definimos un método vacío que no hace nada.
void metodoVacio( ) { }
//Definimos un método que inicializa el objeto con el valor que pasamos como parámetro
//de forma que ya tenemos el primer objeto miPunto con las coordenadas definidas
void inicia( int paramX, int paramY ) {
x = paramX;
y = paramY;
}
//Definimos un nuevo método inicializador, pero al no poner la palabra this, no se está
//asignando a la variable de instancia, sino a la misma
//que tenemos en el método, por lo que en este método realmente solo se modifica la variable y
void inicia2( int x, int y ) {
x = x;
this.y = y;
}
//Definimos un método constructor miPunto, donde tenemos dos parámetros que se asignan a las
//propiedades de la instancia x e y
miPunto( int paramX, int paramY ) {
this.x = paramX; // En esta línea this se puede obviar, ya que x corresponde a
//la variable de la función, pero como se trata
// del constructor, es la propia instancia de la clase
y = paramY; // Esta línea es equivalente a la anterior
}
//Definimos un método constructor miPunto, donde como no recibimos ningún parámetro se
inicializa con las coordenadas (-1,-1)
miPunto() {

-- 15 of 44 --

CC-BY-NC-ND • PID_00220485 16 Introducción a la programación orientada a objetos
inicia(-1,-1);
}
}
2.1.2. Objetos
Existen muchas definiciones del concepto objeto. En primer lugar, en el mundo
real un objeto es cualquier cosa que vemos a nuestro alrededor. En este mismo
momento estás delante de unos materiales en formato papel o digital, ambos
son objetos, como lo son el teléfono móvil, la televisión o un vehículo.
Si analizamos un objeto del mundo real como un ordenador portátil, obser-
vamos que éste está formado por los siguientes componentes: la placa base,
el procesador, el disco duro y los módulos de memoria. Es el trabajo coordi-
nado de todos los componentes lo que provoca que el ordenador realice sus
funciones.
Cada uno de estos componentes es sumamente complejo, está fabricado por
diferentes compañías con distintos materiales e incluso con distintos diseños.
Pero no es necesario conocer cómo funcionan internamente cada uno de ellos,
cada uno es una unidad autónoma y todo lo que se necesita saber de su fun-
cionamiento es cómo interactúan entre sí cada uno de los componentes. Un
procesador y un módulo de memoria son compatibles con la placa base si su
interacción es correcta.
La programación orientada a objetos funciona de la misma manera, los pro-
gramas están construidos en función de diferentes componentes, cada uno de
ellos desempeña un papel específico y todos los componentes pueden comu-
nicarse entre ellos de maneras definidas.
Un objeto es una unidad de código formado por propiedades que defi-
nen su estado y métodos que definen su comportamiento.
En el mundo real, todo objeto tiene dos componentes: características y com-
portamiento. En el caso del ejemplo del vehículo, tenemos las siguientes ca-
racterísticas o propiedades: marca, modelo, color, velocidad máxima, etc.; y el
comportamiento se basaría en las siguientes acciones: frenar, acelerar, retroce-
der, llenar combustible, cambiar llantas, etc.
En el mundo de la programación, los objetos también tienen características y
comportamientos; de esta manera, los objetos en la programación almacenan
sus características en variables e implementan su comportamiento mediante
funciones.

-- 16 of 44 --

CC-BY-NC-ND • PID_00220485 17 Introducción a la programación orientada a objetos
Ejemplo
Imaginemos estacionado en el garaje un Ford Focus de color azul capaz de llegar a 180
km/h; si se pasa al mundo de la programación, podemos considerar un objeto Automóvil
con las siguientes propiedades:
• Marca = Ford.
• Modelo = Focus.
• Color = Azul.
• Velocidad = 180 km/h.
Cuando a las propiedades del objeto se le asignan valores, el objeto adquiere
un estado; de este modo, las variables almacenan los estados de un objeto en
un determinado momento.
Siguiendo con la clase planteada en el subapartado anterior, a continuación se
puede observar el proceso de creación de un objeto o instanciación de la clase.
Cada vez que se crea una clase, se añade otro tipo de dato que se puede utilizar
igual que uno de los tipos simples de datos, por este motivo, al declarar una
nueva variable se puede utilizar un nombre de clase como indicador de tipo:
miPunto p;
Es una declaración de una variable p, que es una referencia a un objeto de la
clase miPunto, de momento con el valor por defecto null.
Las clases implementan un método especial llamado constructor, este método
inicia el objeto inmediatamente después de su creación y tiene exactamente el
mismo nombre de la clase que lo implementa; es decir, no puede haber ningún
otro método que comparta su nombre con el de su clase. Una vez definido, se
llama automáticamente al constructor cuando se crea un objeto de esa clase
(al utilizar el operador new).
El constructor no devuelve ningún tipo, ni siquiera void. Su misión es iniciar
todo estado interno de un objeto (sus propiedades), haciendo que el objeto sea
utilizable inmediatamente; reservando memoria para sus variables, iniciando
sus valores...
Por ejemplo:
miPunto( ) {
inicia( -1, -1 );
}
Este constructor denominado "constructor por defecto", al no tener paráme-
tros, establece el valor –1 a las variables de instancia x e y de los objetos que
construya.

-- 17 of 44 --

CC-BY-NC-ND • PID_00220485 18 Introducción a la programación orientada a objetos
Cuando no encuentre un constructor de la clase, el compilador llamará al
constructor de la superclase que, en caso de no existir, será el de la clase Ob-
ject().
Este otro constructor, sin embargo, recibe dos parámetros:
miPunto( int paraX, int paraY ) {
inicia( paraX, paraY );
}
La lista de parámetros especificada después del nombre de una clase en una
sentencia new se utiliza para pasar parámetros al constructor. Se llama al mé-
todo constructor justo después de crear la instancia y antes de que new de-
vuelva el control al punto de la llamada.
El operador new crea una instancia de una clase (un objeto) y devuelve una
referencia a ese objeto. Por ejemplo:
miPunto p2 = new miPunto(2,3);
Este ejemplo crea una instancia de miPunto() inicializada por los valores (2,3)
y es referenciado por la variable p2.
Las referencias a objetos realmente no contienen los objetos a los que referen-
cian, sino la dirección en la que el objeto es almacenado; de esta manera se
pueden crear múltiples referencias a un mismo objeto, por ejemplo:
miPunto p3 = p2;
Sólo se ha creado un objeto miPunto, pero existen dos variables (p2 y p3) que
lo referencian. Cualquier cambio realizado en el objeto referenciado por p2
afectará al objeto referenciado por p3. La asignación de p2 a p3 no reserva
memoria ni modifica al objeto.
La siguiente asignación al valor null de p2 tiene como efecto que p2 ya no
apuntará al objeto, pero este último aún existe y además p3 aún hace referen-
cia a él:
p2 = null; // p3 todavía apunta al objeto creado con new
Cuando no exista ninguna variable que haga referencia a un objeto, el intér-
prete de Java libera automáticamente la memoria utilizada por el objeto (este
proceso se conoce como Garbage￿collector).

-- 18 of 44 --

CC-BY-NC-ND • PID_00220485 19 Introducción a la programación orientada a objetos
Cuando se realiza una instancia de una clase (mediante new) se reserva en la
memoria un espacio para el conjunto de datos que definen los atributos de
la clase que se indica en la instanciación. A este conjunto de variables se le
denomina variables￿de￿instancia.
La potencia de las variables de instancia se basa en que se crea un conjunto
distinto de ellas para cada uno de los objetos nuevos creados, es decir, cada
objeto tiene su propia copia de las variables de instancia de su clase, por lo
que los cambios sobre las variables de instancia de un objeto no tienen efecto
sobre las variables de instancia de otro objeto.
Acceso￿al￿objeto
El operador punto (.) se utiliza para acceder a las propiedades de la instancia
y a los métodos, mediante su referencia a objeto:
referencia_a_objeto.nombre_de_variable_de_instancia;
referencia_a_objeto.nombre_de_metodo( lista-de-parametros );
En el siguiente ejemplo se puede observar el uso de la sintaxis anterior:
miPunto p3 = new miPunto( 100, 200 );
p3.inicia( 300, 400 );
De esta manera se crea un objeto miPunto con las coordenadas (100,200), pero
a continuación se llama al método inicia que actualiza las anteriores coorde-
nadas a (300,400).
2.1.3. Herencia
La herencia es uno de los conceptos más importantes en la programa-
ción orientada a objetos y consiste en la posibilidad de creación de cla-
ses a partir de otras existentes. Lo que hace tan potente la herencia es
que la nueva clase puede heredar de la primera sus propiedades y sus
métodos (aparecen así los conceptos de clase padre o superclase y clase
hija o subclase).
De esta manera, una subclase puede tener incorporados las propiedades y mé-
todos heredados de la clase padre y, además, puede añadir propiedades y mé-
todos propios a los heredados.
En el proceso de fabricación de modelos de vehículos se utiliza de manera in-
tensiva la herencia; por ejemplo, a partir de una base de chasis un mismo fa-
bricante construye modelos distintos que comparten propiedades y comporta-

-- 19 of 44 --

CC-BY-NC-ND • PID_00220485 20 Introducción a la programación orientada a objetos
mientos, con la particularización de que se añaden nuevas propiedades y com-
portamientos que los definen como un nuevo modelo, aunque, en realidad,
gran parte de su estructura interna es común y compartida por otros modelos.
La herencia es un mecanismo utilizado para definir similitud entre clases, sim-
plificando definiciones de clases similares previamente detenidas. Existen dos
tipos￿de￿herencia:
• La herencia￿simple se produce cuando el lenguaje sólo permite que una
clase derive de una clase. En el siguiente ejemplo se observa cómo la clase
punto hereda de la clase posición:
Figura 2
• La herencia￿múltiple se produce cuando una clase puede ser derivada de
más de una clase. El siguiente ejemplo muestra cómo a partir de dos clases
que definen objetos de sonido e imagen se puede crear una nueva clase
que herede de las dos anteriores:
Figura 3
La herencia permite la reutilización de código de forma muy simple
para el programador.

-- 20 of 44 --

CC-BY-NC-ND • PID_00220485 21 Introducción a la programación orientada a objetos
Para indicar que una clase hereda de otra, heredando tanto sus propiedades
como sus métodos, en Java se usa el término extends, como en el siguiente
ejemplo:
public class SubClase extends SuperClase {
// Contenido de la clase
}
Por ejemplo, a continuación se crea una clase miPunto3D, que va a heredar
de la clase miPunto:
class miPunto3D extends miPunto {
int z;
miPunto3D( ) {
x = 0; // Heredado de miPunto
y = 0; // Heredado de miPunto
z = 0; // Nuevo atributo
}
}
La palabra clave extends se utiliza para indicar que se va a crear una subclase de
la clase que es nombrada a continuación; en el ejemplo anterior, miPunto3D
es hija de miPunto.
La clase Object
Es la superclase de todas las clases de Java. Todas las clases derivan, directa o indirecta-
mente de ella. Si al definir una nueva clase no aparece la cláusula extends, Java considera
que dicha clase desciende directamente de Object.
La clase Object aporta una serie de métodos básicos comunes a todas las clases:
• public boolean equals( Object obj ): se utiliza para comparar, en valor, dos objetos.
Devuelve true si el objeto que recibe por parámetro es igual, en valor, que el objeto
desde el que se llama al método. Si se desean comparar dos referencias a objeto se
pueden utilizar los operadores de comparación == y !=.
• public int hashCode(): devuelve un código hash para ese objeto, para poder almace-
narlo en una Hashtable.
• protected Object clone() throws CloneNotSupportedException: devuelve una copia
de ese objeto.
• public final Class getClass(): devuelve el objeto concreto, de tipo Class, que representa
la clase de ese objeto.
• protected void finalize() throws Trowable: realiza acciones durante la recogida de
basura.

-- 21 of 44 --

CC-BY-NC-ND • PID_00220485 22 Introducción a la programación orientada a objetos
2.2. Características de la programación orientada a objetos
2.2.1. Abstracción
La abstracción es un ejercicio mental por el cual, a partir de un objeto com-
plejo, somos capaces de extraer las propiedades y el comportamiento esencial,
dejando de lado aquellos aspectos que no son relevantes.
Gracias a la abstracción se pueden representar las características esenciales de
un objeto sin preocuparse de las características restantes (no esenciales). La
abstracción se centra en la vista externa de un objeto, de modo que sirva para
separar el comportamiento esencial de un objeto de su implementación.
En los lenguajes de programación orientada a objetos, el concepto de Clase es
la representación y el mecanismo por el que se gestionan las abstracciones.
En POO, se puede considerar a una Persona, por ejemplo, como un objeto que
tiene propiedades (como nombre, altura, peso, color de pelo, color de ojos,
etc.) y métodos (como hablar, mirar, andar, correr, parar, etc.).
Con la abstracción, un objeto Tren puede manipular objetos Persona sin tener
en cuenta sus propiedades ni métodos, ya que sólo le interesa, por ejemplo,
calcular la cantidad de personas que están viajando en él en ese momento, sin
tener en cuenta ninguna otra información relacionada con dichas personas,
tales como la altura, el nombre, el color de ojos, etc.
Hay situaciones en las que se necesita definir una clase que represente un con-
cepto abstracto, y por lo tanto no se pueda proporcionar una implementación
completa de algunos de sus métodos.
Cuando creamos una clase, podemos declarar un determinado método como
abstracto. Haciéndolo, forzamos a que cualquier subclase haya de implemen-
tar obligatoriamente este método, o bien declararlo igualmente abstracto.
Cualquier clase que contenga métodos declarados como abstract también se
debe declarar como abstract, y no se podrán crear instancias de dicha clase.
A continuación, se presenta un ejemplo de clases abstractas:
abstract class claseA {
abstract void metodoAbstracto();
void metodoConcreto() {
//El método concreto de claseA;
}
}
class claseB extends claseA {
Ejemplo
Al describir el cuerpo humano,
se refiere a la cabeza, brazo(s),
pierna(s), etc.

-- 22 of 44 --

CC-BY-NC-ND • PID_00220485 23 Introducción a la programación orientada a objetos
void metodoAbstracto(){
//El método abstracto de claseB;
}
}
La clase abstracta claseA ha implementado el método concreto metodoCon-
creto(), pero el método metodoAbstracto() era abstracto y por eso ha tenido
que ser redefinido en la clase hija claseB.
2.2.2. Ocultamiento o encapsulamiento
Es la capacidad de ocultar los detalles internos del comportamiento de
una clase y exponer públicamente únicamente los detalles que son ne-
cesarios para el resto del sistema.
El ocultamiento permite dos características fundamentales:
• Restringir￿el￿uso￿de￿la￿clase: existirá cierto comportamiento privado de
la clase que no podrá ser accedido por otras clases.
• Controlar￿el￿uso￿de￿la￿clase: existirán ciertos mecanismos para modificar
el estado de la clase y es mediante estos mecanismos como se validará que
algunas condiciones se cumplan.
De esta manera, cada objeto está aislado del exterior y cada tipo de objeto ex-
pone una interfaz a otros objetos que especifica cómo se puede interactuar. El
aislamiento protege a las propiedades de un objeto contra su modificación por
quien no tenga derecho a acceder a ellas, solamente son los propios métodos
internos del objeto los que pueden acceder a su estado.
Esto asegura que no se pueda cambiar el estado interno de un objeto de ma-
neras inesperadas, al eliminar efectos secundarios e interacciones inesperadas.
Si se continúa el ejemplo anterior de la clase Persona, donde se tiene una pro-
piedad que se llama DNI, que contiene el número de DNI, se define un méto-
do NIF que te retorna el valor del NIF. Dentro de la clase habrá definido un
método que a partir de un número de DNI retorna la letra del NIF. Ahora bien,
este método no es accesible, no se puede llamar directamente para obtener
solo la letra. Se ha de llamar al método NIF (que además, la operación que lo
llama tampoco conoce si se trata de un método o una propiedad) y obtener
directamente el valor del NIF entero.

-- 23 of 44 --

CC-BY-NC-ND • PID_00220485 24 Introducción a la programación orientada a objetos
En el lenguaje Java, todas las propiedades y métodos de una clase son accesibles
desde el código de la misma clase, el control del acceso desde otras clases y de
la herencia por las subclases; los miembros (atributos y métodos) de las clases
tienen tres￿modificadores posibles que definen el tipo de control de acceso:
• Public: las propiedades o métodos declarados con public son accesibles en
cualquier lugar en el que sea accesible la clase, y son heredados por las
subclases.
• Private: las propiedades o métodos declarados private son accesibles sólo
en la propia clase.
• Protected: las propiedades o métodos declarados protected son sólo acce-
sibles para sus subclases.
En caso de que no se especifique ningún modificador, las propiedades y mé-
todos son accesibles desde cualquier clase de las que esta forma parte.
Package
Un package en el lenguaje Java es un mecanismo que agrupa clases similares en un tipo
de librería. Una característica interesante es que no puede haber dos clases con el mismo
nombre en un mismo package, pero sí que puede ser en el caso de que pertenezcan a
packages distintos.
Por ejemplo:
class Padre { // Hereda de Object
// Atributos
private int numeroFavorito, nacidoHace, dineroDisponible;
// Métodos
public int getApuesta() {
return numeroFavorito;
}
protected int getEdad() {
return nacidoHace;
}
private int getSaldo() {
return dineroDisponible;
}
}
class Hija extends Padre {
// Definición
}
class Visita {
// Definición
}

-- 24 of 44 --

CC-BY-NC-ND • PID_00220485 25 Introducción a la programación orientada a objetos
En el anterior ejemplo, un objeto de la clase Hija hereda los tres atributos (nu-
meroFavorito, nacidoHace y dineroDisponible) y los tres métodos (getApues-
ta(), getEdad() y getSaldo()) de la clase Padre, y podrá invocarlos. Cuando se
llame al método getEdad() de un objeto de la clase Hija, se devolverá el valor
de la variable de instancia nacidoHace de ese objeto, y no de uno de la clase
Padre.
Sin embargo, un objeto de la clase Hija no podrá invocar al método getSaldo()
de un objeto de la clase Padre, con lo que se evita que el Hijo conozca el estado
de la cuenta corriente de un Padre.
La clase Visita sólo podrá acceder al método getApuesta() para averiguar el
número favorito de un Padre, pero de ninguna manera podrá conocer ni su
saldo, ni su edad.
2.2.3. Polimorfismo
La palabra polimorfismo proviene del griego y significa 'que posee formas dife-
rentes'. Éste es uno de los conceptos esenciales de una programación orientada
a objetos. Así como la herencia está relacionada con las clases y su jerarquía,
el polimorfismo se relaciona con los métodos.
El polimorfismo permite modificar el comportamiento de un operador
dependiendo de los operandos.
En general, existen tres￿tipos￿de￿polimorfismo:
1)￿Polimorfismo￿de￿sobrecarga: ocurre cuando funciones con el mismo nom-
bre existen con funcionalidad similar, pero en clases que son completamente
independientes unas de otras (no deben ser clases hijas de la clase objeto).
De esta manera, el polimorfismo de sobrecarga permite definir operadores cu-
yo comportamiento variará de acuerdo con los parámetros que se les apliquen.
Así es posible agregar el operador + y hacer que se comporte de manera distin-
ta, o bien cuando está haciendo referencia a una operación entre dos números
enteros (suma) o bien cuando se encuentra entre dos cadenas de caracteres
(concatenación).
2)￿Polimorfismo￿paramétrico: es la capacidad para definir varias funciones
utilizando el mismo nombre, pero usando parámetros con diferente tipo, di-
ferente número de parámetros o las dos cosas. De esta manera se selecciona
automáticamente el método correcto que aplicar en función del tipo de da-
tos pasados en el parámetro. Por lo tanto, se pueden definir varios métodos
Ejemplo
La clase Punto, la clase Image
y la clase Link pueden todas
tener la función "display". Esto
significa que no es necesario
preocuparse por el tipo de ob-
jeto con el que se está traba-
jando si todo lo que se desea
es visualizarlo en la pantalla.

-- 25 of 44 --

CC-BY-NC-ND • PID_00220485 26 Introducción a la programación orientada a objetos
homónimos de suma() efectuando una suma de valores, de modo que si los
parámetros son numéricos, devuelva el valor de la suma de éstos, y si son ca-
denas de texto, devuelva la concatenación de las cadenas.
3)￿Polimorfismo￿de￿subtipado: se basa en la habilidad de redefinir un método
en clases que se heredan de una clase base. Por lo tanto, se puede llamar a un
método de objeto sin la necesidad de conocer su tipo intrínseco; así se permi-
te no tomar en cuenta detalles de las clases especializadas de una familia de
objetos y enmascararlos con una interfaz común (siendo ésta la clase básica).
Ejemplo
Un ejemplo podría ser un juego de ajedrez con los objetos Rey, Reina, Alfil, Caballo, Torre
y Peón, cada uno heredando del objeto Pieza. El método Movimiento podría, usando
polimorfismo de subtipado, hacer el movimiento correspondiente de acuerdo a la clase
objeto que se llama.
Así pues, se trata de una característica que permite que una clase tenga varios
procedimientos con el mismo nombre, pero con distinto tipo y/o número de
argumentos. Se obtienen de esta manera comportamientos diferentes, asocia-
dos a objetos distintos, pero que comparten el mismo nombre, y al llamarlos
por ese nombre se utiliza el comportamiento correspondiente al objeto que
se esté usando.
Por ejemplo, una compañía paga a sus empleados semanalmente, y éstos se
clasifican en cuatro tipos: empleados asalariados que reciben un salario sema-
nal fijo, sin importar el número de horas trabajadas; empleados por horas,
que reciben un sueldo por hora y pago por tiempo extra, por todas las horas
trabajadas que excedan a 40 horas; empleados por comisión, que reciben un
porcentaje de sus ventas, y empleados asalariados por comisión, que reciben
un salario base más un porcentaje de sus ventas.
Para este período de pago, la compañía ha decidido recompensar a los em-
pleados asalariados por comisión, y agrega un 10% a sus salarios base. En este
ejemplo, se definiría el método Pago utilizando polimorfismo de subtipado.
En el lenguaje de programación Java, el polimorfismo se puede implementar
con las siguientes técnicas:
1)￿Selección￿dinámica￿de￿método
Las dos clases implementadas a continuación tienen una relación subclase/su-
perclase simple con un único método que se sobrescribe en la subclase:
class claseA {
void metodoDinamico() {
// El método dinámico de claseA;
}
}

-- 26 of 44 --

CC-BY-NC-ND • PID_00220485 27 Introducción a la programación orientada a objetos
class claseB extends claseA {
void metodoDinamico() {
// El método dinámico de claseB;
}
}
Por lo tanto, si se ejecutan las siguientes sentencias:
claseA referenciaA = new claseB();
referenciaA.metodoDinamico();
se estará ejecutando el metodoDinamico definido en la claseB.
Se declara la variable de tipo claseA, y después se almacena una referencia a
una instancia de la clase claseB en ella. Al llamar al método metodoDinamico()
de claseA, el compilador de Java verifica que claseA tiene un método llamado
metodoDinamico(), pero el intérprete de Java observa que la referencia es real-
mente una instancia de claseB, por lo que llama al método metodoDinamico()
de claseB en vez de al de claseA.
Esta manera de polimorfismo dinámico en tiempo de ejecución es uno de
los mecanismos más poderosos que ofrece el diseño orientado a objetos para
soportar la reutilización del código y su robustez.
2)￿Sobrescritura￿de￿un￿método
Durante una jerarquía de herencia puede interesar volver a escribir el cuerpo de
un método, para realizar una funcionalidad de diferente manera dependiendo
del nivel de abstracción en el que nos encontremos. A esta modificación de
funcionalidad se le llama sobrescritura de un método.
Por ejemplo, en una herencia entre una clase SerVivo y una clase hija Persona,
si la clase SerVivo tuviese un método Alimentarse(), debería volver a escribirse
en el nivel Persona, puesto que una persona no se alimenta ni como un Animal
ni como una Planta.
La mejor manera de observar la diferencia entre sobrescritura y sobrecarga es
mediante un ejemplo. A continuación, se puede observar la implementación
de la sobrecarga de la distancia en 3D y la sobrescritura de la distancia en 2D.
class miPunto3D extends miPunto {
int x,y,z;
double distancia(int pX, int pY) { // Sobrescritura
int retorno=0;
retorno += ((x/z)-pX)*((x/z)-pX);
retorno += ((y/z)-pY)*((y/z)-pY);
return Math.sqrt( retorno );

-- 27 of 44 --

CC-BY-NC-ND • PID_00220485 28 Introducción a la programación orientada a objetos
}
}
Se inician los objetos mediante las sentencias:
miPunto p3 = new miPunto(1,1);
miPunto p4 = new miPunto3D(2,2);
y llamando a los métodos de la siguiente manera:
p3.distancia(3,3); //Método miPunto.distancia(pX,pY)
p4.distancia(4,4); //Método miPunto3D.distancia(pX,pY)
Los métodos se seleccionan en función del tipo de la instancia en tiempo de
ejecución, no de la clase en la que se está ejecutando el método actual. A esto
se le llama selección￿dinámica￿de￿método.
3)￿Sobrecarga￿de￿método
Es posible que se necesite crear más de un método con el mismo nombre, pero
con listas de parámetros distintas. A esto se le llama sobrecarga del método. La
sobrecarga de método se utiliza para proporcionar a Java un comportamiento
polimórfico.
Un ejemplo de uso de la sobrecarga es, por ejemplo, crear constructores alter-
nativos en función de las coordenadas, tal y como se hacía en la clase miPunto:
miPunto( ) { //Constructor por defecto
inicia( -1, -1 );
}
miPunto( int paramX, int paramY ) { // Parametrizado
this.x = paramX;
y = paramY;
}
Se llama al constructor basándose en el número y tipo de parámetros que se
les pase. Al número de parámetros con tipo de una secuencia específica se le
llama signatura￿ de￿ tipo. Java utiliza estas signaturas de tipo para decidir a
qué método llamar. Para distinguir entre dos métodos, no se consideran los
nombres de los parámetros formales sino sus tipos y su número.
miPunto p1 = new miPunto(); // Constructor por defecto
miPunto p2 = new miPunto( 5, 6 ); // Constructor parametrizado

-- 28 of 44 --

CC-BY-NC-ND • PID_00220485 29 Introducción a la programación orientada a objetos
2.2.4. Destrucción de objetos
Un destructor es un método de la clase que realiza la tarea opuesta a su cons-
tructor, libera la memoria que fue asignada al objeto que fue creado por el
constructor. Es deseable que el destructor se invoque implícitamente cuando
el objeto abandone el bloque en el que fue declarado.
El destructor le permite al programador despreocuparse de liberar la memoria
que deja de utilizar y correr el riesgo de que ésta se sature.
En Java, la destrucción se puede realizar de manera automática o de manera
personalizada, en función de las características del objeto.
La￿destrucción￿por￿defecto:￿recogida￿de￿basura
El intérprete de Java posee un sistema de recogida de basura que, por lo general,
permite que el programador no se preocupe de liberar la memoria asignada
explícitamente.
El recolector de basura es el encargado de liberar una zona de memoria diná-
mica que había sido reservada mediante el operador new, cuando el objeto ya
no va a ser utilizado durante el programa (por ejemplo, se sale del ámbito de
utilización, o no es referenciado nuevamente).
El sistema de recogida de basura se ejecuta periódicamente, buscando objetos
que ya no estén referenciados.
La￿destrucción￿personalizada:￿finalize
En ocasiones, una clase mantiene un recurso que no es de Java como un des-
criptor de archivo o un tipo de letra del sistema de ventanas. En este caso, es
recomendable utilizar la finalización explícita, para asegurar que dicho recurso
se libera. Para especificar una destrucción personalizada se añade un método
a la clase con el nombre finalize:
class ClaseFinalizada{
ClaseFinalizada() { // Constructor
// Reserva del recurso no Java o recurso compartido
}
protected void finalize() {
// Liberación del recurso no Java o recurso compartido
}
}
El intérprete de Java llama al método finalize() cuando ha de destruir el objeto.

-- 29 of 44 --

CC-BY-NC-ND • PID_00220485 30 Introducción a la programación orientada a objetos
2.2.5. Análisis y diseño orientado a objetos
Para el desarrollo de software orientado a objetos no basta usar un lenguaje
orientado a objetos, también es necesario realizar un análisis y diseño orien-
tado a objetos.
El modelado visual es la clave para realizar el análisis orientado a objetos, desde
los inicios del desarrollo de software orientado a objetos han existido diferen-
tes metodologías para implementar este modelado, pero, sin lugar a duda, el
Lenguaje de Modelado Unificado (UML) puso fin a la guerra de metodologías.
Según los mismos diseñadores del lenguaje UML, éste tiene como fin modelar
cualquier tipo de sistemas (no solamente de software) usando los conceptos
de la orientación a objetos. Además, este lenguaje debe ser entendible tanto
para los programadores como para las máquinas.
Actualmente, en la industria del desarrollo de software, el UML es un estándar
de facto en el modelado de sistemas. Fue la compañía Rational quien creó estas
definiciones y especificaciones del estándar UML, y posteriormente lo publicó
en el mercado.
La misma empresa creó uno de los programas más populares para este fin: el
Rational Rose; pero también existen otros programas, como Poseidon, que dis-
pone de licencias del tipo community edition que permiten su uso libremente.
El UML consta de todos los elementos y diagramas que permiten modelar los
sistemas desde el paradigma orientado a objetos. Cuando se construyen de
manera correcta, los modelos orientados a objetos son fáciles de comunicar,
cambiar, expandir, validar y verificar.
Este modelado en UML es flexible al cambio y permite crear componentes
plenamente reutilizables.

-- 30 of 44 --

CC-BY-NC-ND • PID_00220485 31 Introducción a la programación orientada a objetos