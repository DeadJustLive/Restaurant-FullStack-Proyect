# Capítulo 29:: Módulos

Sintaxis
mod modname ; // Buscar el módulo en modname .rs o modname /mod.rs en el mismo
directorio
•
mod modname { bloque }	•
Examples
Árbol de módulos
Archivos:
- example.rs (root of our modules tree, generally named lib.rs or main.rs when using Cargo)
- first.rs
- second/
- mod.rs
- sub.rs
Módulos:
- example -> example
- first -> example::first
- second -> example::second
- sub -> example::second::sub
- third -> example::third
example.rs
pub mod first;
pub mod second;
pub mod third {
...
}
El second módulo que se debe declarar en el archivo example.rs como su padre es example y no,
por ejemplo, first y, por lo tanto, no se puede declarar en el first.rs u otro archivo en el mismo
nivel de directorio
second/mod.rs
pub mod sub;
El atributo # [ruta]
El atributo #[path] Rust se puede usar para especificar la ruta para buscar un módulo en particular
si no está en la ubicación estándar. Sin embargo, esto generalmente no se recomienda , ya que
https://riptutorial.com/es/home 93

-- 107 of 188 --

hace que la jerarquía de módulos sea frágil y facilita la ruptura de la compilación al mover un
archivo en un directorio completamente diferente.
#[path="../path/to/module.rs"]
mod module;
Nombres en código vs nombres en `use`
La sintaxis de dos puntos de los nombres en la declaración de use es similar a los nombres
usados en otras partes del código, pero el significado de estas rutas es diferente.
Los nombres en la declaración de use por defecto se interpretan como absolutos, comenzando en
la raíz de la caja. Los nombres en otras partes del código son relativos al módulo actual.
La declaración:
use std::fs::File;
tiene el mismo significado en el archivo principal de la caja, así como en los módulos. Por otro
lado, un nombre de función como std::fs::File::open() se referirá a la biblioteca estándar de
Rust solo en el archivo principal de la caja, porque los nombres en el código se interpretan en
relación con el módulo actual.
fn main() {
std::fs::File::open("example"); // OK
}
mod my_module {
fn my_fn() {
// Error! It means my_module::std::fs::File::open()
std::fs::File::open("example");
// OK. `::` prefix makes it absolute
::std::fs::File::open("example");
// OK. `super::` reaches out to the parent module, where `std` is present
super::std::fs::File::open("example");
}
}
Para hacer que std::… nombres se comporten en todas partes igual que en la raíz de la caja,
usted podría agregar:
use std;
A la inversa, puede hacer que las rutas de use relativas prefijándolas con palabras clave self o
super :
use self::my_module::my_fn;
https://riptutorial.com/es/home 94

-- 108 of 188 --

Accediendo al Módulo de Padres
A veces, puede ser útil importar funciones y estructuras relativamente sin tener que use algo con
su ruta absoluta en su proyecto. Para lograr esto, puedes usar el módulo super , así:
fn x() -> u8 {
5
}
mod example {
use super::x;
fn foo() {
println!("{}", x());
}
}
Puede usar super varias veces para llegar al "abuelo" de su módulo actual, pero debe tener
cuidado de no introducir problemas de legibilidad si usa super demasiadas veces en una
importación.
Exportaciones y Visibilidad
Estructura de directorios:
yourproject/
Cargo.lock
Cargo.toml
src/
main.rs
writer.rs
main.rs
// This is import from writer.rs
mod writer;
fn main() {
// Call of imported write() function.
writer::write()
// BAD
writer::open_file()
}
escritor.r
// This function WILL be exported.
pub fn write() {}
// This will NOT be exported.
fn open_file() {}
https://riptutorial.com/es/home 95

-- 109 of 188 --

Organización del código básico
Veamos cómo podemos organizar el código, cuando el código base se está haciendo más
grande.