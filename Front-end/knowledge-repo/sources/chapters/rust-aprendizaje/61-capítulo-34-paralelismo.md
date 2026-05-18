# Capítulo 34:: Paralelismo

Introducción
El paralelismo es bien soportado por la biblioteca estándar de Rust a través de varias clases
como el módulo std::thread , canales y atomics. Esta sección lo guiará a través del uso de estos
tipos.
Examples
Comenzando un nuevo hilo
Para iniciar un nuevo hilo:
use std::thread;
fn main() {
thread::spawn(move || {
// The main thread will not wait for this thread to finish. That
// might mean that the next println isn't even executed before the
// program exits.
println!("Hello from spawned thread");
});
let join_handle = thread::spawn(move || {
println!("Hello from second spawned thread");
// To ensure that the program waits for a thread to finish, we must
// call `join()` on its join handle. It is even possible to send a
// value to a different thread through the join handle, like the
// integer 17 in this case:
17
});
println!("Hello from the main thread");
// The above three printlns can be observed in any order.
// Block until the second spawned thread has finished.
match join_handle.join() {
Ok(x) => println!("Second spawned thread returned {}", x),
Err(_) => println!("Second spawned thread panicked")
}
}
Comunicación entre hilos con canales
Los canales se pueden utilizar para enviar datos de un hilo a otro. A continuación se muestra un
ejemplo de un sistema simple productor-consumidor, donde el hilo principal produce los valores 0,
1, ..., 9 y el hilo generado los imprime:
use std::thread;
https://riptutorial.com/es/home 109

-- 123 of 188 --

use std::sync::mpsc::channel;
fn main() {
// Create a channel with a sending end (tx) and a receiving end (rx).
let (tx, rx) = channel();
// Spawn a new thread, and move the receiving end into the thread.
let join_handle = thread::spawn(move || {
// Keep receiving in a loop, until tx is dropped!
while let Ok(n) = rx.recv() { // Note: `recv()` always blocks
println!("Received {}", n);
}
});
// Note: using `rx` here would be a compile error, as it has been
// moved into the spawned thread.
// Send some values to the spawned thread. `unwrap()` crashes only if the
// receiving end was dropped before it could be buffered.
for i in 0..10 {
tx.send(i).unwrap(); // Note: `send()` never blocks
}
// Drop `tx` so that `rx.recv()` returns an `Err(_)`.
drop(tx);
// Wait for the spawned thread to finish.
join_handle.join().unwrap();
}
Comunicación entre hilos con tipos de sesión
Los tipos de sesión son una forma de informar al compilador sobre el protocolo que desea utilizar
para comunicarse entre subprocesos, no como protocolo en HTTP o FTP, sino el patrón de flujo
de información entre subprocesos. Esto es útil ya que el compilador ahora evitará que rompas
accidentalmente tu protocolo y causes interbloqueos o bloqueos vitales entre los hilos, algunos de
los problemas más notoriamente difíciles de depurar, y una fuente importante de Heisenbugs. Los
tipos de sesión funcionan de manera similar a los canales descritos anteriormente, pero puede
ser más intimidante comenzar a usar. Aquí hay una comunicación simple de dos hilos:
// Session Types aren't part of the standard library, but are part of this crate.
// You'll need to add session_types to your Cargo.toml file.
extern crate session_types;
// For now, it's easiest to just import everything from the library.
use session_types::*;
// First, we describe what our client thread will do. Note that there's no reason
// you have to use a client/server model - it's just convenient for this example.
// This type says that a client will first send a u32, then quit. `Eps` is
// shorthand for "end communication".
// Session Types use two generic parameters to describe the protocol - the first
// for the current communication, and the second for what will happen next.
type Client = Send<u32, Eps>;
// Now, we define what the server will do: it will receive as u32, then quit.
type Server = Recv<u32, Eps>;
https://riptutorial.com/es/home 110

-- 124 of 188 --

// This function is ordinary code to run the client. Notice that it takes
// ownership of a channel, just like other forms of interthread communication -
// but this one about the protocol we just defined.
fn run_client(channel: Chan<(), Client>) {
let channel = channel.send(42);
println!("The client just sent the number 42!");
channel.close();
}
// Now we define some code to run the server. It just accepts a value and prints
// it.
fn run_server(channel: Chan<(), Server>) {
let (channel, data) = channel.recv();
println!("The server received some data: {}", data);
channel.close();
}
fn main() {
// First, create the channels used for the two threads to talk to each other.
let (server_channel, client_channel) = session_channel();
// Start the server on a new thread
let server_thread = std::thread::spawn(move || {
run_server(server_channel);
});
// Run the client on this thread.
run_client(client_channel);
// Wait for the server to finish.
server_thread.join().unwrap();
}
Debe observar que el método principal se ve muy similar al método principal para la comunicación
entre hilos definidos anteriormente, si el servidor se movió a su propia función. Si tuvieras que
ejecutar esto, obtendrías la salida:
The client just sent the number 42!
The server received some data: 42
en ese orden.
¿Por qué pasar por todas las molestias de definir los tipos de cliente y servidor? ¿Y por qué
redefinimos el canal en el cliente y el servidor? Estas preguntas tienen la misma respuesta: ¡el
compilador nos impedirá romper el protocolo! Si el cliente intentara recibir datos en lugar de
enviarlos (lo que resultaría en un interbloqueo en el código ordinario), el programa no se
compilaría, ya que el objeto de canal del cliente no tiene un método de recv . Además, si
intentamos definir el protocolo de una manera que pudiera provocar un interbloqueo (por ejemplo,
si el cliente y el servidor intentaron recibir un valor), la compilación fallaría cuando creamos los
canales. Esto se debe a que Send y Recv son "Tipos duales", lo que significa que si el Servidor
hace uno, el Cliente tiene que hacer el otro, si ambos intentan Recv , estaremos en problemas. Eps
es su propio tipo dual, ya que está bien que tanto el Cliente como el Servidor acuerden cerrar el
canal.
Por supuesto, cuando hacemos alguna operación en el canal, pasamos a un nuevo estado en el
https://riptutorial.com/es/home 111

-- 125 of 188 --

protocolo, y las funciones disponibles podrían cambiar, por lo que tenemos que redefinir el enlace
del canal. Por suerte, session_types se encarga de eso y siempre devuelve el nuevo canal
(excepto el close , en cuyo caso no hay un nuevo canal). Esto también significa que todos los
métodos en un canal también se apropian del canal, por lo que si olvida redefinir el canal, el
compilador también le dará un error al respecto. Si suelta un canal sin cerrarlo, también es un
error de tiempo de ejecución (desafortunadamente, es imposible verificarlo en el momento de la
compilación).
Hay muchos más tipos de comunicación que solo Send y Recv ; por ejemplo, Offer le da al otro lado
del canal la posibilidad de elegir entre dos posibles ramas del protocolo, y Rec y Var trabajan juntos
para permitir bucles y recursión en el protocolo. . Muchos más ejemplos de tipos de sesión y otros
tipos están disponibles en el session_types GitHub repositorio . La documentación de la biblioteca
se puede encontrar aquí.
Atómica y ordenación de la memoria
Los tipos atómicos son los bloques de construcción de estructuras de datos sin bloqueo y otros
tipos concurrentes. Se debe especificar un orden de memoria, que representa la resistencia de la
barrera de memoria, al acceder / modificar un tipo atómico. Rust proporciona 5 primitivas de
ordenación de memoria: Relajado (el más débil), Adquirir (para lecturas también conocidas
como cargas), Liberar (para escrituras también conocidas como tiendas), AcqRel (equivalente a
"Adquirir para cargar y Liberar para almacenar"; útil cuando ambos están involucrados en una
sola operación, como comparar y cambiar, y SeqCst (la más fuerte). En el siguiente ejemplo,
demostraremos cómo los pedidos "relajados" difieren de los pedidos "Adquirir" y "Liberar".
use std::cell::UnsafeCell;
use std::sync::atomic::{AtomicUsize, Ordering};
use std::sync::{Arc, Barrier};
use std::thread;
struct UsizePair {
atom: AtomicUsize,
norm: UnsafeCell<usize>,
}
// UnsafeCell is not thread-safe. So manually mark our UsizePair to be Sync.
// (Effectively telling the compiler "I'll take care of it!")
unsafe impl Sync for UsizePair {}
static NTHREADS: usize = 8;
static NITERS: usize = 1000000;
fn main() {
let upair = Arc::new(UsizePair::new(0));
// Barrier is a counter-like synchronization structure (not to be confused
// with a memory barrier). It blocks on a `wait` call until a fixed number
// of `wait` calls are made from various threads (like waiting for all
// players to get to the starting line before firing the starter pistol).
let barrier = Arc::new(Barrier::new(NTHREADS + 1));
let mut children = vec![];
https://riptutorial.com/es/home 112

-- 126 of 188 --

for _ in 0..NTHREADS {
let upair = upair.clone();
let barrier = barrier.clone();
children.push(thread::spawn(move || {
barrier.wait();
let mut v = 0;
while v < NITERS - 1 {
// Read both members `atom` and `norm`, and check whether `atom`
// contains a newer value than `norm`. See `UsizePair` impl for
// details.
let (atom, norm) = upair.get();
if atom > norm {
// If `Acquire`-`Release` ordering is used in `get` and
// `set`, then this statement will never be reached.
println!("Reordered! {} > {}", atom, norm);
}
v = atom;
}
}));
}
barrier.wait();
for v in 1..NITERS {
// Update both members `atom` and `norm` to value `v`. See the impl for
// details.
upair.set(v);
}
for child in children {
let _ = child.join();
}
}
impl UsizePair {
pub fn new(v: usize) -> UsizePair {
UsizePair {
atom: AtomicUsize::new(v),
norm: UnsafeCell::new(v),
}
}
pub fn get(&self) -> (usize, usize) {
let atom = self.atom.load(Ordering::Relaxed); //Ordering::Acquire
// If the above load operation is performed with `Acquire` ordering,
// then all writes before the corresponding `Release` store is
// guaranteed to be visible below.
let norm = unsafe { *self.norm.get() };
(atom, norm)
}
pub fn set(&self, v: usize) {
unsafe { *self.norm.get() = v };
// If the below store operation is performed with `Release` ordering,
// then the write to `norm` above is guaranteed to be visible to all
// threads that "loads `atom` with `Acquire` ordering and sees the same
// value that was stored below". However, no guarantees are provided as
https://riptutorial.com/es/home 113

-- 127 of 188 --

// to when other readers will witness the below store, and consequently
// the above write. On the other hand, there is also no guarantee that
// these two values will be in sync for readers. Even if another thread
// sees the same value that was stored below, it may actually see a
// "later" value in `norm` than what was written above. That is, there
// is no restriction on visibility into the future.
self.atom.store(v, Ordering::Relaxed); //Ordering::Release
}
}
Nota: las arquitecturas x86 tienen un fuerte modelo de memoria. Este post lo explica en detalle.
También eche un vistazo a la página de Wikipedia para la comparación de arquitecturas.
Cerraduras de lectura-escritura
RwLocks permite que un solo productor proporcione datos a cualquier número de lectores
mientras evita que los lectores vean datos no válidos o inconsistentes.
El siguiente ejemplo utiliza RwLock para mostrar cómo un solo subproceso productor puede
aumentar periódicamente un valor mientras dos subprocesos de los consumidores leen el valor.
use std::time::Duration;
use std::thread;
use std::thread::sleep;
use std::sync::{Arc, RwLock };
fn main() {
// Create an u32 with an inital value of 0
let initial_value = 0u32;
// Move the initial value into the read-write lock which is wrapped into an atomic
reference
// counter in order to allow safe sharing.
let rw_lock = Arc::new(RwLock::new(initial_value));
// Create a clone for each thread
let producer_lock = rw_lock.clone();
let consumer_id_lock = rw_lock.clone();
let consumer_square_lock = rw_lock.clone();
let producer_thread = thread::spawn(move || {
loop {
// write() blocks this thread until write-exclusive access can be acquired and
retuns an
// RAII guard upon completion
if let Ok(mut write_guard) = producer_lock.write() {
// the returned write_guard implements `Deref` giving us easy access to the
target value
*write_guard += 1;
println!("Updated value: {}", *write_guard);
}
// ^
// | when the RAII guard goes out of the scope, write access will be dropped,
allowing
https://riptutorial.com/es/home 114

-- 128 of 188 --

// +~ other threads access the lock
sleep(Duration::from_millis(1000));
}
});
// A reader thread that prints the current value to the screen
let consumer_id_thread = thread::spawn(move || {
loop {
// read() will only block when `producer_thread` is holding a write lock
if let Ok(read_guard) = consumer_id_lock.read() {
// the returned read_guard also implements `Deref`
println!("Read value: {}", *read_guard);
}
sleep(Duration::from_millis(500));
}
});
// A second reader thread is printing the squared value to the screen. Note that readers
don't
// block each other so `consumer_square_thread` can run simultaneously with
`consumer_id_lock`.
let consumer_square_thread = thread::spawn(move || {
loop {
if let Ok(lock) = consumer_square_lock.read() {
let value = *lock;
println!("Read value squared: {}", value * value);
}
sleep(Duration::from_millis(750));
}
});
let _ = producer_thread.join();
let _ = consumer_id_thread.join();
let _ = consumer_square_thread.join();
}
Ejemplo de salida:
Updated value: 1
Read value: 1
Read value squared: 1
Read value: 1
Read value squared: 1
Updated value: 2
Read value: 2
Read value: 2
Read value squared: 4
Updated value: 3
Read value: 3
Read value squared: 9
Read value: 3
Updated value: 4
Read value: 4
Read value squared: 16
Read value: 4
Read value squared: 16
Updated value: 5
https://riptutorial.com/es/home 115

-- 129 of 188 --

Read value: 5
Read value: 5
Read value squared: 25
...(Interrupted)...
Lea Paralelismo en línea: https://riptutorial.com/es/rust/topic/1222/paralelismo
https://riptutorial.com/es/home 116

-- 130 of 188 --