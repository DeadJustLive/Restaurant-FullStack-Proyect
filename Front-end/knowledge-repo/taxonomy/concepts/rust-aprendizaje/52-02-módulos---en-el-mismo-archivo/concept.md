# 02. Módulos - En el mismo archivo

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 52)

## Contenido
# 02. Módulos - En el mismo archivo

fn main() {
greet::hello();
}
mod greet {
// By default, everything inside a module is private
pub fn hello() { // So function has to be public to access from outside
println!("Hello, world!");
}
}
