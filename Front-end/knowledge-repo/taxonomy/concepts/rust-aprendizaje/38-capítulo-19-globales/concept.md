# Capítulo 19:: Globales

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 38)

## Contenido
# Capítulo 19:: Globales

Sintaxis
IDENTIFICADOR const: tipo = constexpr;	•
IDENTIFICADOR estático [mut]: tipo = expr;	•
lazy_static! {IDENTIFICADOR de ref. estático: tipo = expr; }	•
Observaciones
const valores const están siempre en línea y no tienen dirección en la memoria.	•
static valores static nunca están en línea y tienen una instancia con una dirección fija.	•
static mut valores static mut no son seguros para la memoria y, por lo tanto, solo se puede
acceder a ellos en un bloque unsafe .
•
A veces, el uso de variables mutables estáticas globales en código de subprocesos
múltiples puede ser peligroso, así que considere usar std :: sync :: Mutex u otras alternativas
•
lazy_static objetos lazy_static son inmutables, se inicializan solo una vez, se comparten
entre todos los subprocesos y se puede acceder directamente (no hay tipos de envoltorios
involucrados). En contraste, los objetos thread_local están diseñados para ser mutables, se
inicializan una vez para cada hilo y los accesos son indirectos (que involucran el tipo de
envoltorio LocalKey<T> )
•
Examples
Const
La palabra clave const declara un enlace constante global.
const DEADBEEF: u64 = 0xDEADBEEF;
fn main() {
println("{:X}", DEADBEEF);
}
Esto produce
