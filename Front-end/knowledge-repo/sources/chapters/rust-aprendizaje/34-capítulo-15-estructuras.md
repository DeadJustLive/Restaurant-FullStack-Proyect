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
requiere que la instancia sea propiedad del llamante, y hará que la instancia se mueva al llamar al
método. Esto puede ser útil si deseamos consumir, destruir o transformar completamente una
instancia existente. Un ejemplo de tal caso de uso es proporcionar métodos de
"encadenamiento":
impl Foo {
https://riptutorial.com/es/home 44

-- 58 of 188 --

fn double(mut self) -> Self {
self.my_num *= 2;
self
}
}
// ...
foo.my_num = 1;
assert_eq!(foo.double().double().my_num, 4);
Tenga en cuenta que también prefijamos self con mut para que podamos mutar el self antes de
devolverlo de nuevo. El tipo de retorno del método double también garantiza alguna explicación.
Self dentro de un bloque impl refiere al tipo al que se aplica el impl (en este caso, Foo ). En este
caso, es principalmente una abreviatura útil para evitar volver a escribir la firma del tipo, pero en
los rasgos, se puede usar para referirse al tipo subyacente que implementa un rasgo en
particular.
Para declarar un método asociado (comúnmente denominado "método de clase" en otros
idiomas) para una struct simplemente struct el argumento self . Dichos métodos se llaman en el
propio tipo de struct , no en una instancia de él:
impl Foo {
fn new(b: bool, n: isize, s: String) -> Foo {
Foo { my_bool: b, my_num: n, my_string: s }
}
}
// ...
// :: is used to access associated members of the type
let x = Foo::new(false, 0, String::from("nil"));
assert_eq!(x.my_num, 0);
Tenga en cuenta que los métodos de estructura solo se pueden definir para los tipos que se
declararon en el módulo actual. Además, al igual que con los campos, todos los métodos de
estructura son privados por defecto y, por lo tanto, solo pueden llamarse por código en el mismo
módulo. Puede prefijar definiciones con la palabra clave pub para que sean invocables desde otro
lugar.
Estructuras genéricas
Las estructuras se pueden hacer genéricas sobre uno o más parámetros de tipo. Estos tipos se
incluyen entre <> cuando se hace referencia al tipo:
struct Gen<T> {
x: T,
z: isize,
}
// ...
let _: Gen<bool> = Gen{x: true, z: 1};
let _: Gen<isize> = Gen{x: 42, z: 2};
let _: Gen<String> = Gen{x: String::from("hello"), z: 3};
https://riptutorial.com/es/home 45

-- 59 of 188 --

Se pueden dar múltiples tipos usando comas:
struct Gen2<T, U> {
x: T,
y: U,
}
// ...
let _: Gen2<bool, isize> = Gen2{x: true, y: 42};
Los parámetros de tipo son una parte del tipo, por lo que dos variables del mismo tipo de base,
pero con parámetros diferentes, no son intercambiables:
let mut a: Gen<bool> = Gen{x: true, z: 1};
let b: Gen<isize> = Gen{x: 42, z: 2};
a = b; // this will not work, types are not the same
a.x = 42; // this will not work, the type of .x in a is bool
Si desea escribir una función que acepte una struct independientemente de la asignación de
parámetros de tipo, esa función también debería ser genérica:
fn hello<T>(g: Gen<T>) {
println!("{}", g.z); // valid, since g.z is always an isize
}
Pero, ¿y si quisiéramos escribir una función que siempre podría imprimir gx ? Tendríamos que
restringir T para que sea de un tipo que se pueda mostrar. Podemos hacer esto con límites de
tipo:
use std::fmt;
fn hello<T: fmt::Display>(g: Gen<T>) {
println!("{} {}", g.x, g.z);
}
La función de hello ahora solo se define para las instancias Gen cuyo tipo T implementa
fmt::Display . Si intentamos pasar un Gen<(bool, isize)> por ejemplo, el compilador se quejaría de
que hello no está definido para ese tipo.
También podemos usar límites de tipo directamente en los parámetros de tipo de la struct para
indicar que solo puedes construir esa struct para ciertos tipos:
use std::hash::Hash;
struct GenB<T: Hash> {
x: T,
}
Cualquier función que tenga acceso a un GenB ahora sabe que el tipo de x implementa Hash y, por
lo tanto, que pueden llamar a .x.hash() . Se pueden dar múltiples tipos de límites para el mismo
parámetro separándolos con un + .
Igual que para las funciones, los límites de tipo se pueden colocar después de <> usando la
https://riptutorial.com/es/home 46

-- 60 of 188 --

palabra clave where :
struct GenB<T> where T: Hash {
x: T,
}
Esto tiene el mismo significado semántico, pero puede hacer que la firma sea más fácil de leer y
formatear cuando tiene límites complejos.
Los parámetros de tipo también están disponibles para los métodos de instancia y los métodos
asociados de la struct :
// note the <T> parameter for the impl as well
// this is necessary to say that all the following methods only
// exist within the context of those type parameter assignments
impl<T> Gen<T> {
fn inner(self) -> T {
self.x
}
fn new(x: T) -> Gen<T> {
Gen{x: x}
}
}
Si tiene límites de tipo en la T Gen , estos también deberían reflejarse en los límites de tipo de la
impl . También puede hacer que los límites impl más estrictos para decir que un método
determinado solo existe si el tipo satisface una propiedad en particular:
impl<T: Hash + fmt::Display> Gen<T> {
fn show(&self) {
println!("{}", self.x);
}
}
// ...
Gen{x: 42}.show(); // works fine
let a = Gen{x: (42, true)}; // ok, because (isize, bool): Hash
a.show(); // error: (isize, bool) does not implement fmt::Display
Lea Estructuras en línea: https://riptutorial.com/es/rust/topic/4583/estructuras
https://riptutorial.com/es/home 47

-- 61 of 188 --