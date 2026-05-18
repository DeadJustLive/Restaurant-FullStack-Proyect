# Capítulo 33:: Pánicos y Desenrollamientos

Introducción
Cuando los programas de Rust alcanzan un estado en el que se ha producido un error crítico, el
panic! Se puede llamar a la macro para salir rápidamente (a menudo comparada, pero sutilmente
diferente, a una excepción en otros idiomas). El manejo adecuado de errores debe involucrar
tipos de Result , aunque esta sección solo tratará el panic! y sus conceptos.
Observaciones
Los pánicos no siempre causan pérdidas de memoria u otras pérdidas de recursos. De hecho, los
pánicos generalmente conservan las invariantes de RAII, ejecutando los destructores
(Implementaciones de Drop) de las estructuras a medida que la pila se desenrolla. Sin embargo,
si hay un segundo pánico durante este proceso, el programa simplemente se cancela; en ese
punto, las garantías invariantes de RAII son nulas.
Examples
Trata de no entrar en pánico
En Rust, hay dos métodos principales para indicar que algo salió mal en un programa: una
función que devuelve un Err(E) ( potencialmente definido por el Err(E) , del tipo Result<T, E> y un
panic! .
El pánico no es una alternativa para las excepciones, que se encuentran comúnmente en otros
idiomas. En Rust, un pánico es para indicar que algo salió mal y que no puede continuar. Aquí
hay un ejemplo de la fuente de Vec para push :
pub fn push(&mut self, value: T) {
// This will panic or abort if we would allocate > isize::MAX bytes
// or if the length increment would overflow for zero-sized types.
if self.len == self.buf.cap() {
self.buf.double();
}
...
}
Si nos quedamos sin memoria, no hay mucho más que Rust pueda hacer, por lo que puede entrar
en pánico (el comportamiento predeterminado) o abortar (que debe configurarse con un indicador
de compilación).
El pánico desenrollará la pila, ejecutará los destructores y garantizará que se limpie la memoria.
Abort no hace esto, y confía en el sistema operativo para limpiarlo correctamente.
Trate de ejecutar el siguiente programa normalmente y con
https://riptutorial.com/es/home 107

-- 121 of 188 --

[profile.dev]
panic = "abort"
en su Cargo.toml .
// main.rs
struct Foo(i32);
impl Drop for Foo {
fn drop(&mut self) {
println!("Dropping {:?}!", self.0);
}
}
fn main() {
let foo = Foo(1);
panic!("Aaaaaaahhhhh!");
}
Lea Pánicos y Desenrollamientos en línea: https://riptutorial.com/es/rust/topic/6895/panicos-y-
desenrollamientos
https://riptutorial.com/es/home 108

-- 122 of 188 --