# Capítulo 46:: The Drop Rasgo - Destructores

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 73)

## Contenido
# Capítulo 46:: The Drop Rasgo - Destructores

en Rust
Observaciones
Usar el Rasgo de caída no significa que se ejecutará cada vez. Si bien se ejecutará cuando salga
de alcance o se desenrolle, puede que no siempre sea así, por ejemplo, cuando se llama a
mem::forget .
Esto se debe a que un pánico mientras se desenrolla hace que el programa se cancele. También
podría haber sido compilado con el Abort on Panic activado.
Para obtener más información, consulte el libro: https://doc.rust-lang.org/book/drop.html
Examples
Implementación de Drop simple
use std::ops::Drop;
struct Foo(usize);
impl Drop for Foo {
fn drop(&mut self) {
println!("I had a {}", self.0);
}
}
Gota para la limpieza
use std::ops::Drop;
#[derive(Debug)]
struct Bar(i32);
impl Bar {
fn get<'a>(&'a mut self) -> Foo<'a> {
let temp = self.0; // Since we will also capture `self` we..
// ..will have to copy the value out first
Foo(self, temp) // Let's take the i32
}
}
struct Foo<'a>(&'a mut Bar, i32); // We specify that we want a mutable borrow..
// ..so we can put it back later on
impl<'a> Drop for Foo<'a> {
fn drop(&mut self) {
if self.1 < 10 { // This is just an example, you could also just put..
// ..it back as is
https://riptutorial.com/es/home 160

-- 174 of 188 --

(self.0).0 = self.1;
}
}
}
fn main() {
let mut b = Bar(0);
println!("{:?}", b);
{
let mut a : Foo = b.get(); // `a` now holds a reference to `b`..
a.1 = 2; // .. and will hold it until end of scope
} // .. here
println!("{:?}", b);
{
let mut a : Foo = b.get();
a.1 = 20;
}
println!("{:?}", b);
}
Drop te permite crear diseños simples y a prueba de fallas.
Drop Logging para la depuración de la gestión de memoria en tiempo de
ejecución
La administración de memoria en tiempo de ejecución con Rc puede ser muy útil, pero también
puede ser difícil envolver la cabeza, especialmente si su código es muy complejo y una sola
instancia es referenciada por decenas o incluso cientos de otros tipos en muchos ámbitos.
Escribiendo un rasgo de Drop que incluye println!("Dropping StructName: {:?}", self); puede ser
inmensamente valioso para la depuración, ya que le permite ver con precisión cuándo se agotan
las referencias sólidas a una instancia de estructura.
Lea The Drop Rasgo - Destructores en Rust en línea: https://riptutorial.com/es/rust/topic/7233/the-
drop-rasgo---destructores-en-rust
https://riptutorial.com/es/home 161

-- 175 of 188 --
