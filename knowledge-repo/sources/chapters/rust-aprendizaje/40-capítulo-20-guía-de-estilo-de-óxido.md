# Capítulo 20:: Guía de estilo de óxido

Introducción
Aunque no hay una guía de estilo oficial de Rust, los siguientes ejemplos muestran las
convenciones adoptadas por la mayoría de los proyectos de Rust. Seguir estas convenciones
alineará el estilo de su proyecto con el de la biblioteca estándar, facilitando que las personas vean
la lógica en su código.
Observaciones
Las pautas de estilo Rust oficiales estaban disponibles en el repositorio rust-lang/rust en GitHub,
pero se han eliminado recientemente, en espera de la migración al repositorio rust-lang-
nursery/fmt-rfcs . Hasta que se publiquen nuevas pautas allí, debe intentar seguir las pautas en el
repositorio de rust-lang .
Puede usar rustfmt y clippy para revisar automáticamente su código en busca de problemas de
estilo y formatearlo correctamente. Estas herramientas se pueden instalar usando Cargo, así:
cargo install clippy
cargo install rustfmt
Para ejecutarlos, usas:
cargo clippy
cargo fmt
Examples
Espacio en blanco
Longitud de la línea
// Lines should never exceed 100 characters.
// Instead, just wrap on to the next line.
let bad_example = "So this sort of code should never really happen, because it's really hard
to fit on the screen!";
Sangría
// You should always use 4 spaces for indentation.
// Tabs are discouraged - if you can, set your editor to convert
// a tab into 4 spaces.
let x = vec![1, 3, 5, 6, 7, 9];
for item in x {
if x / 2 == 3 {
https://riptutorial.com/es/home 58

-- 72 of 188 --

println!("{}", x);
}
}
Espacio en blanco que se arrastra
Se deben eliminar los espacios en blanco al final de los archivos o líneas.
Operadores Binarios
// For clarity, always add a space when using binary operators, e.g.
// +, -, =, *
let bad=3+4;
let good = 3 + 4;
Esto también se aplica en los atributos, por ejemplo:
// Good:
#[deprecated = "Don't use my class - use Bar instead!"]
// Bad:
#[deprecated="This is broken"]
Punto y coma
// There is no space between the end of a statement
// and a semicolon.
let bad = Some("don't do this!") ;
let good: Option<&str> = None;
Alineación de los Campos Struct
// Struct fields should **not** be aligned using spaces, like this:
pub struct Wrong {
pub x : i32,
pub foo: i64
}
// Instead, just leave 1 space after the colon and write the type, like this:
pub struct Right {
pub x: i32,
pub foo: i64
}
Firmas de funciones
// Long function signatures should be wrapped and aligned so that
// the starting parameter of each line is aligned
fn foo(example_item: Bar, another_long_example: Baz,
yet_another_parameter: Quux)
-> ReallyLongReturnItem {
// Be careful to indent the inside block correctly!
}
https://riptutorial.com/es/home 59

-- 73 of 188 --

Tirantes
// The starting brace should always be on the same line as its parent.
// The ending brace should be on its own line.
fn bad()
{
println!("This is incorrect.");
}
struct Good {
example: i32
}
struct AlsoBad {
example: i32 }
Creación de cajas
Preludios y reexportaciones
// To reduce the amount of imports that users need, you should
// re-export important structs and traits.
pub use foo::Client;
pub use bar::Server;
A veces, las cajas usan un módulo de prelude para contener estructuras importantes, como
std::io::prelude . Por lo general, estos se importan con use std::io::prelude::*;
Importaciones
Debes ordenar tus importaciones y declaraciones así:
declaraciones de extern crate	•
use importaciones
Las importaciones externas de otras cajas deben ser lo primero	○
•
Reexportaciones ( pub use )	•
Nombrar
Estructuras
// Structs use UpperCamelCase.
pub struct Snafucator {
}
mod snafucators {
// Try to avoid 'stuttering' by repeating
// the module name in the struct name.
// Bad:
pub struct OrderedSnafucator {
https://riptutorial.com/es/home 60

-- 74 of 188 --

}
// Good:
pub struct Ordered {
}
}
Rasgos
// Traits use the same naming principles as
// structs (UpperCamelCase).
trait Read {
fn read_to_snafucator(&self) -> Result<(), Error>;
}
Cajas y módulos
// Modules and crates should both use snake_case.
// Crates should try to use single words if possible.
extern crate foo;
mod bar_baz {
mod quux {
}
}
Variables estáticas y constantes
// Statics and constants use SCREAMING_SNAKE_CASE.
const NAME: &'static str = "SCREAMING_SNAKE_CASE";
Enums
// Enum types and their variants **both** use UpperCamelCase.
pub enum Option<T> {
Some(T),
None
}
Funciones y Métodos
// Functions and methods use snake_case
fn snake_cased_function() {
}
Fijaciones variables
// Regular variables also use snake_case
let foo_bar = "snafu";
Vidas
https://riptutorial.com/es/home 61

-- 75 of 188 --

// Lifetimes should consist of a single lower case letter. By
// convention, you should start at 'a, then 'b, etc.
// Good:
struct Foobar<'a> {
x: &'a str
}
// Bad:
struct Bazquux<'stringlife> {
my_str: &'stringlife str
}
Acrónimos
Los nombres de variables que contienen acrónimos, como TCP deben tener el siguiente estilo:
Para los nombres de UpperCamelCase , la primera letra debe estar en mayúsculas (por
ejemplo, TcpClient )
•
Para los nombres de snake_case , no debe haber mayúsculas (por ejemplo, tcp_client )	•
Para los nombres de SCREAMING_SNAKE_CASE , el acrónimo debe estar completamente en
mayúscula (por ejemplo, TCP_CLIENT )
•
Los tipos
Escriba anotaciones
// There should be one space after the colon of the type
// annotation. This rule applies in variable declarations,
// struct fields, functions and methods.
// GOOD:
let mut buffer: String = String::new();
// BAD:
let mut buffer:String = String::new();
let mut buffer : String = String::new();
Referencias
// The ampersand (&) of a reference should be 'touching'
// the type it refers to.
// GOOD:
let x: &str = "Hello, world.";
// BAD:
fn fooify(x: & str) {
println!("{}", x);
}
// Mutable references should be formatted like so:
fn bar(buf: &mut String) {
}
https://riptutorial.com/es/home 62

-- 76 of 188 --

Lea Guía de estilo de óxido en línea: https://riptutorial.com/es/rust/topic/4620/guia-de-estilo-de-
oxido
https://riptutorial.com/es/home 63

-- 77 of 188 --