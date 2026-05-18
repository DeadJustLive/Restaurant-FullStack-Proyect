# Capítulo 11:: Constantes asociadas

Sintaxis
#! [feature (associated_consts)]	•
const ID: i32;	•
Observaciones
Esta característica está disponible actualmente solo en compilador nocturno. Cuestión de
seguimiento # 29646
Examples
Uso de constantes asociadas
// Must enable the feature to use associated constants
#![feature(associated_consts)]
use std::mem;
// Associated constants can be used to add constant attributes to types
trait Foo {
const ID: i32;
}
// All implementations of Foo must define associated constants
// unless a default value is supplied in the definition.
impl Foo for i32 {
const ID: i32 = 1;
}
struct Bar;
// Associated constants don't have to be bound to a trait to be defined
impl Bar {
const BAZ: u32 = 5;
}
fn main() {
assert_eq!(1, i32::ID);
// The defined constant value is only stored once, so the size of
// instances of the defined types doesn't include the constants.
assert_eq!(4, mem::size_of::<i32>());
assert_eq!(0, mem::size_of::<Bar>());
}
Lea Constantes asociadas en línea: https://riptutorial.com/es/rust/topic/7042/constantes-asociadas
https://riptutorial.com/es/home 33

-- 47 of 188 --