# DEADBEEF

Estático
La palabra clave static declara un enlace estático global, que puede ser mutable.
static HELLO_WORLD: &'static str = "Hello, world!";
fn main() {
https://riptutorial.com/es/home 53

-- 67 of 188 --

println("{}", HELLO_WORLD);
}
Esto produce
Hello, world!
lazy_static!
Utilice la caja lazy_static para crear variables globales inmutables que se inicializan en tiempo de
ejecución. Usamos HashMap como una demostración.
En Cargo.toml :
[dependencies]
lazy_static = "0.1.*"
En main.rs :
#[macro_use]
extern crate lazy_static;
lazy_static! {
static ref HASHMAP: HashMap<u32, &'static str> = {
let mut m = HashMap::new();
m.insert(0, "hello");
m.insert(1, ",");
m.insert(2, " ");
m.insert(3, "world");
m
};
static ref COUNT: usize = HASHMAP.len();
}
fn main() {
// We dereference COUNT because it's type is &usize
println!("The map has {} entries.", *COUNT);
// Here we don't dereference with * because of Deref coercions
println!("The entry for `0` is \"{}\".", HASHMAP.get(&0).unwrap());
}
Objetos de hilo local
Un objeto de subproceso local se inicializa en su primer uso en un subproceso. Y como su
nombre lo indica, cada subproceso obtendrá una copia nueva independiente de otros
subprocesos.
use std::cell::RefCell;
use std::thread;
thread_local! {
static FOO: RefCell<f32> = RefCell::new(1.0);
https://riptutorial.com/es/home 54

-- 68 of 188 --

}
// When this macro expands, `FOO` gets type `thread::LocalKey<RefCell<f32>>`.
//
// Side note: One of its private member is a pointer to a function which is
// responsible for returning the thread-local object. Having all its members
// `Sync` [0], `LocalKey` is also implicitly `Sync`.
//
// [0]: As of writing this, `LocalKey` just has 2 function-pointers as members
fn main() {
FOO.with(|foo| {
// `foo` is of type `&RefCell<f64>`
*foo.borrow_mut() = 3.0;
});
thread::spawn(move|| {
// Note that static objects do not move (`FOO` is the same everywhere),
// but the `foo` you get inside the closure will of course be different.
FOO.with(|foo| {
println!("inner: {}", *foo.borrow());
});
}).join().unwrap();
FOO.with(|foo| {
println!("main: {}", *foo.borrow());
});
}
Salidas:
inner: 1
main: 3
Mut estático seguro con mut_static
Los elementos globales mutables (llamados static mut , que resaltan la contradicción inherente
involucrada en su uso) no son seguros porque es difícil para el compilador asegurarse de que se
utilicen adecuadamente.
Sin embargo, la introducción de bloqueos mutuamente exclusivos en torno a los datos permite
globales mutables de memoria segura. ¡Esto NO significa que sean lógicamente seguros, sin
embargo!
#[macro_use]
extern crate lazy_static;
extern crate mut_static;
use mut_static::MutStatic;
pub struct MyStruct { value: usize }
impl MyStruct {
pub fn new(v: usize) -> Self{
MyStruct { value: v }
}
https://riptutorial.com/es/home 55

-- 69 of 188 --

pub fn getvalue(&self) -> usize { self.value }
pub fn setvalue(&mut self, v: usize) { self.value = v }
}
lazy_static! {
static ref MY_GLOBAL_STATE: MutStatic<MyStruct> = MutStatic::new();
}
fn main() {
// Here, I call .set on the MutStatic to put data inside it.
// This can fail.
MY_GLOBAL_STATE.set(MyStruct::new(0)).unwrap();
{
// Using the global state immutably is easy...
println!("Before mut: {}",
MY_GLOBAL_STATE.read().unwrap().getvalue());
}
{
// Using it mutably is too...
let mut mut_handle = MY_GLOBAL_STATE.write().unwrap();
mut_handle.setvalue(3);
println!("Changed value to 3.");
}
{
// As long as there's a scope change we can get the
// immutable version again...
println!("After mut: {}",
MY_GLOBAL_STATE.read().unwrap().getvalue());
}
{
// But beware! Anything can change global state!
foo();
println!("After foo: {}",
MY_GLOBAL_STATE.read().unwrap().getvalue());
}
}
// Note that foo takes no parameters
fn foo() {
let val;
{
val = MY_GLOBAL_STATE.read().unwrap().getvalue();
}
{
let mut mut_handle =
MY_GLOBAL_STATE.write().unwrap();
mut_handle.setvalue(val + 1);
}
}
Este código produce la salida:
Before mut: 0
Changed value to 3.
After mut: 3
After foo: 4
Esto no es algo que debería suceder en Rust normalmente. foo() no tomó una referencia mutable
https://riptutorial.com/es/home 56

-- 70 of 188 --

a nada, por lo que no debería haber mutado nada, y sin embargo lo hizo. Esto puede llevar a
errores de lógica muy difíciles de depurar.
Por otro lado, esto es a veces exactamente lo que quieres. Por ejemplo, muchos motores de
juegos requieren un caché global de imágenes y otros recursos que se cargan perezosamente (o
utilizan alguna otra estrategia de carga compleja). MutStatic es perfecto para ese propósito.
Lea Globales en línea: https://riptutorial.com/es/rust/topic/1244/globales
https://riptutorial.com/es/home 57

-- 71 of 188 --