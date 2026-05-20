# Capítulo 35:: Pautas inseguras

Introducción
Explique por qué ciertas cosas están marcadas como unsafe en Rust y por qué es posible que
necesitemos usar esta escotilla de escape en ciertas situaciones (raras).
Examples
Carreras de datos
Las carreras de datos ocurren cuando una parte de la memoria es actualizada por una parte,
mientras que otra intenta leerla o actualizarla simultáneamente (sin sincronización entre las dos).
Veamos el ejemplo clásico de una carrera de datos utilizando un contador compartido.
use std::cell::UnsafeCell;
use std::sync::Arc;
use std::thread;
// `UnsafeCell` is a zero-cost wrapper which informs the compiler that "what it
// contains might be shared mutably." This is used only for static analysis, and
// gets optimized away in release builds.
struct RacyUsize(UnsafeCell<usize>);
// Since UnsafeCell is not thread-safe, the compiler will not auto-impl Sync for
// any type containig it. And manually impl-ing Sync is "unsafe".
unsafe impl Sync for RacyUsize {}
impl RacyUsize {
fn new(v: usize) -> RacyUsize {
RacyUsize(UnsafeCell::new(v))
}
fn get(&self) -> usize {
// UnsafeCell::get() returns a raw pointer to the value it contains
// Dereferencing a raw pointer is also "unsafe"
unsafe { *self.0.get() }
}
fn set(&self, v: usize) { // note: `&self` and not `&mut self`
unsafe { *self.0.get() = v }
}
}
fn main() {
let racy_num = Arc::new(RacyUsize::new(0));
let mut handlers = vec![];
for _ in 0..10 {
let racy_num = racy_num.clone();
handlers.push(thread::spawn(move || {
for i in 0..1000 {
if i % 200 == 0 {
https://riptutorial.com/es/home 117

-- 131 of 188 --

// give up the time slice to scheduler
thread::yield_now();
// this is needed to interleave the threads so as to observe
// data race, otherwise the threads will most likely be
// scheduled one after another.
}
// increment by one
racy_num.set(racy_num.get() + 1);
}
}));
}
for th in handlers {
th.join().unwrap();
}
println!("{}", racy_num.get());
}
La salida será casi siempre menor que 10000 (10 subprocesos × 1000) cuando se ejecute en un
procesador de múltiples núcleos.
En este ejemplo, una carrera de datos ha producido un valor lógicamente incorrecto pero aún
significativo. Esto se debe a que solo una palabra estuvo involucrada en la carrera y, por lo tanto,
una actualización no pudo haberla cambiado parcialmente. Pero las carreras de datos en general
pueden producir valores corruptos que no son válidos para un tipo (tipo inseguro) cuando el
objeto que se está compitiendo abarca varias palabras y / o produce valores que apuntan a
ubicaciones de memoria no válidas (memoria insegura) cuando están involucrados punteros.
Sin embargo, el uso cuidadoso de primitivas atómicas puede permitir la construcción de
estructuras de datos muy eficientes que pueden necesitar internamente realizar algunas de estas
operaciones "inseguras" para realizar acciones que no son verificables estáticamente por el
sistema de tipo de Rust, pero que son correctas en general (es decir, para construir una caja
fuerte). abstracción).
Lea Pautas inseguras en línea: https://riptutorial.com/es/rust/topic/6018/pautas-inseguras
https://riptutorial.com/es/home 118

-- 132 of 188 --