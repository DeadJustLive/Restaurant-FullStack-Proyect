# Capítulo 30:: Opción

Introducción
El tipo Option<T> es el equivalente de Rust de los tipos anulables, sin todos los problemas que lo
acompañan. La mayoría de los lenguajes tipo C permiten que cualquier variable sea null si no
hay datos presentes, pero el tipo de Option está inspirado en lenguajes funcionales que favorecen
a los 'opcionales' (por ejemplo, la mónada de Haskell, Maybe ). El uso de los tipos de Option le
permitirá expresar la idea de que los datos pueden o no estar allí (ya que Rust no tiene tipos
anulables).
Examples
Creando un valor de opción y una coincidencia de patrón
// The Option type can either contain Some value or None.
fn find(value: i32, slice: &[i32]) -> Option<usize> {
for (index, &element) in slice.iter().enumerate() {
if element == value {
// Return a value (wrapped in Some).
return Some(index);
}
}
// Return no value.
None
}
fn main() {
let array = [1, 2, 3, 4, 5];
// Pattern match against the Option value.
if let Some(index) = find(2, &array) {
// Here, there is a value.
println!("The element 2 is at index {}.", index);
}
// Check if the result is None (no value).
if let None = find(12, &array) {
// Here, there is no value.
println!("The element 12 is not in the array.");
}
// You can also use `is_some` and `is_none` helpers
if find(12, &array).is_none() {
println!("The element 12 is not in the array.");
}
}
Destructurando una opción
fn main() {
let maybe_cake = Some("Chocolate cake");
https://riptutorial.com/es/home 100

-- 114 of 188 --

let not_cake = None;
// The unwrap method retrieves the value from the Option
// and panics if the value is None
println!("{}", maybe_cake.unwrap());
// The expect method works much like the unwrap method,
// but panics with a custom, user provided message.
println!("{}", not_cake.expect("The cake is a lie."));
// The unwrap_or method can be used to provide a default value in case
// the value contained within the option is None. This example would
// print "Cheesecake".
println!("{}", not_cake.unwrap_or("Cheesecake"));
// The unwrap_or_else method works like the unwrap_or method,
// but allows us to provide a function which will return the
// fallback value. This example would print "Pumpkin Cake".
println!("{}", not_cake.unwrap_or_else(|| { "Pumpkin Cake" }));
// A match statement can be used to safely handle the possibility of none.
match maybe_cake {
Some(cake) => println!("{} was consumed.", cake),
None => println!("There was no cake.")
}
// The if let statement can also be used to destructure an Option.
if let Some(cake) = maybe_cake {
println!("{} was consumed.", cake);
}
}
Desenvolver una referencia a una opción que posee su contenido
Una referencia a una opción &Option<T> no se puede desempaquetar si el tipo T no se puede
copiar. La solución es cambiar la opción a &Option<&T> usando as_ref() .
La oxidación prohíbe la transferencia de la propiedad de los objetos mientras se prestan los
objetos. Cuando la propia Opción se toma prestada ( &Option<T> ), su contenido también es,
indirectamente, prestado.
#[derive(Debug)]
struct Foo;
fn main() {
let wrapped = Some(Foo);
let wrapped_ref = &wrapped;
println!("{:?}", wrapped_ref.unwrap()); // Error!
}
no puede salir del contenido prestado [--explain E0507]
Sin embargo, es posible crear una referencia al contenido de la Option<T> . El método as_ref()
Option devuelve una opción para &T , que puede ser desenvuelta sin transferencia de propiedad:
https://riptutorial.com/es/home 101

-- 115 of 188 --

println!("{:?}", wrapped_ref.as_ref().unwrap());
Usando la opción con el mapa y and_then
La operación de map es una herramienta útil cuando se trabaja con matrices y vectores, pero
también se puede utilizar para tratar los valores de las Option de una manera funcional.
fn main() {
// We start with an Option value (Option<i32> in this case).
let some_number = Some(9);
// Let's do some consecutive calculations with our number.
// The crucial point here is that we don't have to unwrap
// the content of our Option type - instead, we're just
// transforming its content. The result of the whole operation
// will still be an Option<i32>. If the initial value of
// 'some_number' was 'None' instead of 9, then the result
// would also be 'None'.
let another_number = some_number
.map(|n| n - 1) // => Some(8)
.map(|n| n * n) // => Some(64)
.and_then(|n| divide(n, 4)); // => Some(16)
// In the last line above, we're doing a division using a helper
// function (definition: see bottom).
// 'and_then' is very similar to 'map', but allows us to pass a
// function which returns an Option type itself. To ensure that we
// don't end up with Option<Option<i32>>, 'and_then' flattens the
// result (in other languages, 'and_then' is also known as 'flatmap').
println!("{}", to_message(another_number));
// => "16 is definitely a number!"
// For the sake of completeness, let's check the result when
// dividing by zero.
let final_number = another_number
.and_then(|n| divide(n, 0)); // => None
println!("{}", to_message(final_number));
// => "None!"
}
// Just a helper function for integer division. In case
// the divisor is zero, we'll get 'None' as result.
fn divide(number: i32, divisor: i32) -> Option<i32> {
if divisor != 0 { Some(number/divisor) } else { None }
}
// Creates a message that tells us whether our
// Option<i32> contains a number or not. There are other
// ways to achieve the same result, but let's just use
// map again!
fn to_message(number: Option<i32>) -> String {
number
.map(|n| format!("{} is definitely a number!", n)) // => Some("...")
.unwrap_or("None!".to_string()) // => "..."
}
https://riptutorial.com/es/home 102

-- 116 of 188 --

Lea Opción en línea: https://riptutorial.com/es/rust/topic/1125/opcion
https://riptutorial.com/es/home 103

-- 117 of 188 --