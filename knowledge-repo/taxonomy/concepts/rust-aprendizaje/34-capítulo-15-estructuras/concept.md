# Capítulo 15:: Estructuras

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 34)

## Contenido
# Capítulo 15:: Estructuras

Sintaxis
struct Foo {field1: Type1, field2: Type2}	•
vamos a foo = Foo {field1: Type1 :: new (), field2: Type2 :: new ()};	•
Barra de estructura (Tipo 1, Tipo 2); // tipo de tupla	•
let _ = Bar (Type1 :: new (), Type2 :: new ());	•
struct baz; // tipo de unidad	•
dejar _ = Baz;	•
vamos a Foo {field1, ..} = foo; // extraer campo1 por coincidencia de patrones	•
vamos a Foo {field1: x, ..} = foo; // extraer campo1 como x	•
vamos foo2 = Foo {field1: Type1 :: new (), .. foo}; // construir desde existente	•
implique Foo {fn fiddle (& self) {}} // declare el método de instancia para Foo	•
implique Foo {fn tweak (& mut self) {}} // declare el método de instancia mutable para Foo	•
implique Foo {fn double (self) {}} // declare que posee el método de instancia para Foo	•
implique Foo {fn new () {}} // declare el método asociado para Foo	•
Examples
Definiendo estructuras
Las estructuras en Rust se definen utilizando la palabra clave struct . La forma más común de
estructura consiste en un conjunto de campos nombrados:
struct Foo {
my_bool: bool,
my_num: isize,
my_string: String,
}
Lo anterior declara una struct con tres campos: my_bool , my_num y my_string , de los tipos bool ,
isize y String respectivamente.
Otra forma de crear struct en Rust es crear una estructura de tupla :
struct Bar (bool, isize, String);
Esto define un nuevo tipo, Bar , que tiene tres campos sin nombre, de tipo bool , isize y String , en
ese orden. Esto se conoce como el patrón newtype , porque introduce efectivamente un nuevo
"nombre" para un tipo particular. Sin embargo, lo hace de una manera más poderosa que los alias
creados usando la palabra clave de type ; Bar es aquí un tipo totalmente funcional, lo que significa
que puede escribir sus propios métodos para él (a continuación).
Finalmente, declare una struct sin campos, llamada estructura tipo unidad :
https://riptutorial.com/es/home 42

-- 56 of 188 --

struct Baz;
Esto puede ser útil para burlarse o probar (cuando se quiere implementar un rasgo trivialmente), o
como un tipo de marcador. En general, sin embargo, es poco probable que se encuentre con
muchas estructuras similares a unidades.
Tenga en cuenta que los campos de struct en Rust son todos privados por defecto, es decir, no
se puede acceder a ellos desde el código que se encuentra fuera del módulo que define el tipo.
Puede prefijar un campo con la palabra clave pub para que el campo sea de acceso público.
Además, el propio tipo de struct es privado. Para que el tipo esté disponible para otros módulos,
la definición de la struct también debe tener el prefijo pub :
pub struct X {
my_field: bool,
pub our_field: bool,
}
Creando y utilizando valores de estructura.
Considere las siguientes definiciones de struct :
struct Foo {
my_bool: bool,
my_num: isize,
my_string: String,
}
struct Bar (bool, isize, String);
struct Baz;
La construcción de nuevos valores de estructura para estos tipos es sencilla:
let foo = Foo { my_bool: true, my_num: 42, my_string: String::from("hello") };
let bar = Bar(true, 42, String::from("hello"));
let baz = Baz;
Acceder a los campos de una estructura usando . :
assert_eq!(foo.my_bool, true);
assert_eq!(bar.0, true); // tuple structs act like tuples
Un enlace mutable a una estructura puede tener sus campos mutados:
let mut foo = foo;
foo.my_bool = false;
let mut bar = bar;
bar.0 = false;
Las capacidades de coincidencia de patrones de Rust también se pueden usar para mirar dentro
de una struct :
https://riptutorial.com/es/home 43

-- 57 of 188 --

// creates bindings mb, mn, ms with values of corresponding fields in foo
let Foo { my_bool: mb, my_num: mn, my_string: ms } = foo;
assert_eq!(mn, 42);
// .. allows you to skip fields you do not care about
let Foo { my_num: mn, .. } = foo;
assert_eq!(mn, 42);
// leave out `: variable` to bind a variable by its field name
let Foo { my_num, .. } = foo;
assert_eq!(my_num, 42);
O haga una estructura usando una segunda estructura como "plantilla" con la sintaxis de
actualización de Rust:
let foo2 = Foo { my_string: String::from("world"), .. foo };
assert_eq!(foo2.my_num, 42);
Métodos de estructura
Para declarar métodos en una estructura (es decir, funciones que pueden llamarse "en" la struct ,
o valores de ese tipo de struct ), cree un bloque impl :
impl Foo {
fn fiddle(&self) {
// "self" refers to the value this method is being called on
println!("fiddling {}", self.my_string);
}
}
// ...
foo.fiddle(); // prints "fiddling hello"
&self aquí indica que es necesaria una referencia inmutable a una instancia de struct Foo para
invocar el método de fiddle . Si quisiéramos modificar la instancia (como cambiar uno de sus
campos), en su lugar, &mut self un &mut self (es decir, una referencia mutable):
impl Foo {
fn tweak(&mut self, n: isize) {
self.my_num = n;
}
}
// ...
foo.tweak(43);
assert_eq!(foo.my_num, 43);
Finalmente, también podríamos usar self (tenga en cuenta la falta de un & ) como receptor. Esto
requiere que la instancia sea propiedad del ll
