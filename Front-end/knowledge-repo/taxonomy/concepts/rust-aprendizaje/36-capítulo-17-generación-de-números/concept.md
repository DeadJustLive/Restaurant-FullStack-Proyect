# Capítulo 17:: Generación de números

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 36)

## Contenido
# Capítulo 17:: Generación de números

aleatorios
Introducción
El óxido tiene una capacidad incorporada para proporcionar la generación de números aleatorios
a través de la caja del rand . Una vez que formó parte de la biblioteca estándar de Rust, la
funcionalidad de la caja de rand se separó para permitir que su desarrollo se estabilice por
separado del resto del proyecto de Rust. Este tema cubrirá cómo simplemente agregar la caja de
rand, luego generar y generar un número aleatorio en Rust.
Observaciones
Existe un soporte integrado para un RNG asociado con cada subproceso almacenado en el
almacenamiento local de subprocesos. Se puede acceder a este RNG a través de thread_rng , o
se puede usar implícitamente a través de random . Este RNG normalmente se siembra
aleatoriamente desde una fuente de aleatoriedad del sistema operativo, por ejemplo, /dev/urandom
en sistemas Unix, y se reiniciará automáticamente desde esta fuente después de generar 32 KiB
de datos aleatorios.
Una aplicación que requiere una fuente de entropía para propósitos criptográficos debe usar OsRng
, que lee la aleatoriedad de la fuente que proporciona el sistema operativo (por ejemplo,
/dev/urandom en Unixes o CryptGenRandom() en Windows). Los otros generadores de números
aleatorios proporcionados por este módulo no son adecuados para tales propósitos.
Examples
Generando dos números aleatorios con rand
En primer lugar, deberá agregar la caja en su archivo Cargo.toml como una dependencia.
[dependencies]
rand = "0.3"
Esto recuperará la caja de rand de crates.io . A continuación, agregue esto a su raíz de caja.
extern crate rand;
Como este ejemplo proporcionará una salida simple a través del terminal, crearemos una función
principal e imprimiremos dos números generados aleatoriamente en la consola. El generador de
números aleatorios locales de hilo se almacenará en caché en este ejemplo. Cuando se generan
valores múltiples, esto a menudo puede resultar más eficiente.
https://riptutorial.com/es/home 49

-- 63 of 188 --

use rand::Rng;
fn main() {
let mut rng = rand::thread_rng();
if rng.gen() { // random bool
println!("i32: {}, u32: {}", rng.gen::<i32>(), rng.gen::<u32>())
}
}
Cuando ejecute este ejemplo, debería ver la siguiente respuesta en la consola.
$ cargo run
Running `target/debug/so`
i32: 1568599182, u32: 2222135793
Generando personajes con rand
Para generar caracteres, puede utilizar la función de generador de números aleatorios de
subprocesos locales, random .
fn main() {
let tuple = rand::random::<(f64, char)>();
println!("{:?}", tuple)
}
Para solicitudes ocasionales o singulares, como la anterior, este es un método razonable y
eficiente. Sin embargo, si pretende generar más de un puñado de números, encontrará que el
generador de caché será más eficiente.
Debería esperar ver el siguiente resultado en este caso.
$ cargo run
Running `target/debug/so`
(0.906881, '\u{9edc}')
Lea Generación de números aleatorios en línea:
https://riptutorial.com/es/rust/topic/8864/generacion-de-numeros-aleatorios
https://riptutorial.com/es/home 50

-- 64 of 188 --
