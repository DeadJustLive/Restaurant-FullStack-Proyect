# Capítulo 38:: Pruebas

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 65)

## Contenido
# Capítulo 38:: Pruebas

Examples
Probar una función
fn to_test(output: bool) -> bool {
output
}
#[cfg(test)] // The module is only compiled when testing.
mod test {
use super::to_test;
// This function is a test function. It will be executed and
// the test will succeed if the function exits cleanly.
#[test]
fn test_to_test_ok() {
assert_eq!(to_test(true), true);
}
// That test on the other hand will only succeed when the function
// panics.
#[test]
#[should_panic]
fn test_to_test_fail() {
assert_eq!(to_test(true), false);
}
}
( Enlace de juegos )
Ejecutar con cargo test .
Pruebas de integración
lib.rs :
pub fn to_test(output: bool) -> bool {
output
}
Cada archivo en las tests/ carpeta se compila como caja única. tests/integration_test.rs
extern crate test_lib;
use test_lib::to_test;
#[test]
fn test_to_test(){
assert_eq!(to_test(true), true);
}
https://riptutorial.com/es/home 125

-- 139 of 188 --

Pruebas de referencia
Con las pruebas de referencia puede probar y medir la velocidad del código, sin embargo, las
pruebas de referencia siguen siendo inestables. Para habilitar los puntos de referencia en su
proyecto de carga que necesita óxido nocturno, coloque sus pruebas de punto de referencia de
integración en los benches/ carpetas en la raíz de su proyecto de Carga, y ejecute el cargo bench .
Ejemplos de llogiq.github.io
extern crate test;
extern crate rand;
use test::Bencher;
use rand::Rng;
use std::mem::replace;
#[bench]
fn empty(b: &mut Bencher) {
b.iter(|| 1)
}
#[bench]
fn setup_random_hashmap(b: &mut Bencher) {
let mut val : u32 = 0;
let mut rng = rand::IsaacRng::new_unseeded();
let mut map = std::collections::HashMap::new();
b.iter(|| { map.insert(rng.gen::<u8>() as usize, val); val += 1; })
}
#[bench]
fn setup_random_vecmap(b: &mut Bencher) {
let mut val : u32 = 0;
let mut rng = rand::IsaacRng::new_unseeded();
let mut map = std::collections::VecMap::new();
b.iter(|| { map.insert((rng.gen::<u8>()) as usize, val); val += 1; })
}
#[bench]
fn setup_random_vecmap_cap(b: &mut Bencher) {
let mut val : u32 = 0;
let mut rng = rand::IsaacRng::new_unseeded();
let mut map = std::collections::VecMap::with_capacity(256);
b.iter(|| { map.insert((rng.gen::<u8>()) as usize, val); val += 1; })
}
Lea Pruebas en línea: https://riptutorial.com/es/rust/topic/961/pruebas
https://riptutorial.com/es/home 126

-- 140 of 188 --
