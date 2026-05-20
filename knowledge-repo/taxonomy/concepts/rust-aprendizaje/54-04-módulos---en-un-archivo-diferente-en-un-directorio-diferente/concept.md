# 04. Módulos - En un archivo diferente en un directorio diferente

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 54)

## Contenido
# 04. Módulos - En un archivo diferente en un directorio diferente

Cuando mueva algún código a un nuevo archivo en un directorio diferente, el directorio mismo
actúa como un módulo. Y mod.rs en la raíz del módulo es el punto de entrada al módulo de
directorio. Todos los demás archivos en ese directorio, actúan como un submódulo de ese
directorio.
// ↳ main.rs
mod greet;
fn main() {
greet::hello();
}
// ↳ greet/mod.rs
pub fn hello() {
println!("Hello, world!");
}
Cuando tienes varios archivos en la raíz del módulo,
// ↳ main.rs
mod greet;
fn main() {
greet::hello_greet()
}
// ↳ greet/mod.rs
mod hello;
pub fn hello_greet() {
hello::greet()
}
// ↳ greet/hello.rs
pub fn greet() {
println!("Hello, world!");
}
