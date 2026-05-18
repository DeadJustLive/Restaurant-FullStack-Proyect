# Capítulo 16:: Futuros y Async IO

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 35)

## Contenido
# Capítulo 16:: Futuros y Async IO

Introducción
futures-rs es una biblioteca que implementa futuros y flujos de costo cero en Rust.
Los conceptos centrales de la caja de futuros son Future and Stream .
Examples
Creando un futuro con función oneshot
Hay algunas implementaciones generales de rasgos Future en la caja de futuros . Uno de ellos se
implementa en futures::sync::oneshot module y está disponible a través de futures::oneshot
function:
extern crate futures;
use std::thread;
use futures::Future;
fn expensive_computation() -> u32 {
// ...
200
}
fn main() {
// The oneshot function returns a tuple of a Sender and a Receiver.
let (tx, rx) = futures::oneshot();
thread::spawn(move || {
// The complete method resolves a values.
tx.complete(expensive_computation());
});
// The map method applies a function to a value, when it is resolved.
let rx = rx.map(|x| {
println!("{}", x);
});
// The wait method blocks current thread until the value is resolved.
rx.wait().unwrap();
}
Lea Futuros y Async IO en línea: https://riptutorial.com/es/rust/topic/8595/futuros-y-async-io
https://riptutorial.com/es/home 48

-- 62 of 188 --
