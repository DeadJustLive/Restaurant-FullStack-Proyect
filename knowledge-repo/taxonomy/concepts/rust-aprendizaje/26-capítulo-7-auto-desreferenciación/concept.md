# Capítulo 7:: Auto-desreferenciación

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 26)

## Contenido
# Capítulo 7:: Auto-desreferenciación

Examples
El operador de puntos
El . Operador en Rust viene con mucha magia! Cuando usas . , el compilador insertará tantos * s
(operaciones de desreferenciación) necesarios para encontrar el método en el "árbol" deref.
Como esto sucede en el momento de la compilación, no hay un costo de tiempo de ejecución
para encontrar el método.
let mut name: String = "hello world".to_string();
// no deref happens here because push is defined in String itself
name.push('!');
let name_ref: &String = &name;
// Auto deref happens here to get to the String. See below
let name_len = name_ref.len();
// You can think of this as syntactic sugar for the following line:
let name_len2 = (*name_ref).len();
// Because of how the deref rules work,
// you can have an arbitrary number of references.
// The . operator is clever enough to know what to do.
let name_len3 = (&&&&&&&&&&&&name).len();
assert_eq!(name_len3, name_len);
La desreferenciación automática también funciona para cualquier tipo que implemente el rasgo
std::ops::Deref .
let vec = vec![1, 2, 3];
let iterator = vec.iter();
Aquí, iter no es un método de Vec<T> , sino un método de [T] . Funciona porque Vec<T>
implementa Deref con Target=[T] que le permite a Vec<T> convertirse en [T] cuando el operador *
elimina (que el compilador puede insertar durante a . ).
Deref coerciones
Dados dos tipos T y U , &T forzará (se convertirá implícitamente) a &U si y solo si T implementa
Deref<Target=U>
Esto nos permite hacer cosas como esta:
fn foo(a: &[i32]) {
// code
}
fn bar(s: &str) {
// code
https://riptutorial.com/es/home 19

-- 33 of 188 --

}
let v = vec![1, 2, 3];
foo(&v); // &Vec<i32> coerces into &[i32] because Vec<T> impls Deref<Target=[T]>
let s = "Hello world".to_string();
let rc = Rc::new(s);
// This works because Rc<T> impls Deref<Target=T> ∴ &Rc<String> coerces into
// &String which coerces into &str. This happens as much as needed at compile time.
bar(&rc);
Usando Deref y AsRef para argumentos de función
Para las funciones que necesitan tomar una colección de objetos, los cortes generalmente son
una buena opción:
fn work_on_bytes(slice: &[u8]) {}
Porque Vec<T> y matrices [T; N] implementa Deref<Target=[T]> , se pueden coaccionar fácilmente
a una porción:
let vec = Vec::new();
work_on_bytes(&vec);
let arr = [0; 10];
work_on_bytes(&arr);
let slice = &[1,2,3];
work_on_bytes(slice); // Note lack of &, since it doesn't need coercing
Sin embargo, en lugar de requerir explícitamente una división, se puede hacer que la función
acepte cualquier tipo que pueda usarse como una división:
fn work_on_bytes<T: AsRef<[u8]>>(input: T) {
let slice = input.as_ref();
}
En este ejemplo, la función work_on_bytes tomará cualquier tipo T que implemente as_ref() , lo que
devuelve una referencia a [u8] .
work_on_bytes(vec);
work_on_bytes(arr);
work_on_bytes(slice);
work_on_bytes("strings work too!");
Implementación Deref para Opción y estructura de contenedor
use std::ops::Deref;
use std::fmt::Debug;
#[derive(Debug)]
struct RichOption<T>(Option<T>); // wrapper struct
https://riptutorial.com/es/home 20

-- 34 of 188 --

impl<T> Deref for RichOption<T> {
type Target = Option<T>; // Our wrapper struct will coerce into Option
fn deref(&self) -> &Option<T> {
&self.0 // We just extract the inner element
}
}
impl<T: Debug> RichOption<T> {
fn print_inner(&self) {
println!("{:?}", self.0)
}
}
fn main() {
let x = RichOption(Some(1));
println!("{:?}",x.map(|x| x + 1)); // Now we can use Option's methods...
fn_that_takes_option(&x); // pass it to functions that take Option...
x.print_inner() // and use it's own methods to extend Option
}
fn fn_that_takes_option<T : std::fmt::Debug>(x: &Option<T>) {
println!("{:?}", x)
}
Ejemplo simple de Deref
Deref tiene una regla simple: si tienes un tipo T e implementa Deref<Target=F> , entonces &T obliga
a &F , el compilador repetirá esto tantas veces como sea necesario para obtener F, por ejemplo:
fn f(x: &str) -> &str { x }
fn main() {
// Compiler will coerce &&&&&&&str to &str and then pass it to our function
f(&&&&&&&"It's a string");
}
La coacción Deref es especialmente útil cuando se trabaja con tipos de punteros, como Box o Arc ,
por ejemplo:
fn main() {
let val = Box::new(vec![1,2,3]);
// Now, thanks to Deref, we still
// can use our vector method as if there wasn't any Box
val.iter().fold(0, |acc, &x| acc + x ); // 6
// We pass our Box to the function that takes Vec,
// Box<Vec> coerces to Vec
f(&val)
}
fn f(x: &Vec<i32>) {
println!("{:?}", x) // [1,2,3]
}
Lea Auto-desreferenciación en línea: https://riptutorial.com/es/rust/topic/2574/auto-
desreferenciacion
https://riptutorial.com/es/home 21

-- 35 of 188 --
