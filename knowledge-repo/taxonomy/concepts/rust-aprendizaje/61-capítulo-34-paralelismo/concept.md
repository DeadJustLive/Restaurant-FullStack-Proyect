# Capítulo 34:: Paralelismo

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 61)

## Contenido
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
Debe observar que el método principal se ve muy similar al método principal par
