# Capítulo 37:: Propiedad

Introducción
La propiedad es uno de los conceptos más importantes en Rust, y es algo que no está presente
en la mayoría de los otros idiomas. La idea de que un valor puede ser propiedad de una variable
en particular es a menudo bastante difícil de entender, especialmente en los idiomas donde la
copia está implícita, pero esta sección revisará las diferentes ideas que rodean la propiedad.
Sintaxis
let x: & T = ... // x es una referencia inmutable	•
let x: & mut T = ... // x es una referencia exclusiva y mutable	•
vamos a _ = & mut foo; // pedir prestado foo de manera mudable (es decir, exclusivamente)	•
deja _ = & foo; // tomar prestado foo de manera inmutable	•
dejar _ = foo; // mover foo (requiere propiedad)	•
Observaciones
En versiones mucho más antiguas de Rust (antes de 1.0; mayo de 2015), una variable
propiedad tenía un tipo que comenzaba con ~ . Puedes ver esto en ejemplos muy antiguos.
•
Examples
Propiedad y préstamo
Todos los valores en Rust tienen exactamente un propietario. El propietario es responsable de
eliminar ese valor cuando está fuera del alcance, y es el único que puede mover la propiedad del
valor. El propietario de un valor puede regalar referencias al permitir que otras piezas de código
tomen ese valor prestado . En cualquier momento, puede haber cualquier número de referencias
inmutables a un valor:
let owned = String::from("hello");
// since we own the value, we may let other variables borrow it
let immutable_borrow1 = &owned;
// as all current borrows are immutable, we can allow many of them
let immutable_borrow2 = &owned;
// in fact, if we have an immutable reference, we are also free to
// duplicate that reference, since we maintain the invariant that
// there are only immutable references
let immutable_borrow3 = &*immutable_borrow2;
o una sola referencia mutable ( ERROR denota un error en tiempo de compilación):
// for us to borrow a value mutably, it must be mutable
let mut owned = String::from("hello");
https://riptutorial.com/es/home 121

-- 135 of 188 --

// we can borrow owned mutably
let mutable_borrow = &mut owned;
// but note that we cannot borrow owned *again*
let mutable_borrow2 = &mut owned; // ERROR, already borrowed
// nor can we cannot borrow owned immutably
// since a mutable borrow is exclusive.
let immutable_borrow = &owned; // ERROR, already borrowed
Si hay referencias pendientes (mutables o inmutables) a un valor, ese valor no se puede mover
(es decir, su propiedad ha sido regalada). Tendríamos que asegurarnos de que todas las
referencias se eliminaron primero para poder mover un valor:
let foo = owned; // ERROR, outstanding references to owned
let owned = String::from("hello");
{
let borrow = &owned;
// ...
} // the scope ends the borrow
let foo = owned; // OK, owned and not borrowed
Préstamos y vidas
Todos los valores en Rust tienen toda una vida . La vida útil de un valor abarca el segmento de
código desde el valor que se introduce hasta donde se mueve, o el final del ámbito de contenido.
{
let x = String::from("hello"); // +
// ... :
let y = String::from("hello"); // + |
// ... : :
foo(x) // x is moved | = x's lifetime
// ... :
} // = y's lifetime
Cada vez que toma prestado un valor, la referencia resultante tiene una duración que está ligada
a la duración del valor prestado:
{
let x = String::from("hello");
let y = String::from("world");
// when we borrow y here, the lifetime of the reference
// stored in foo is equal to the lifetime of y
// (i.e., between let y = above, to the end of the scope below)
let foo = &y;
// similarly, this reference to x is bound to the lifetime
// of x --- bar cannot, for example, spawn a thread that uses
// the reference beyond where x is moved below.
bar(&x);
}
Propiedad y llamadas a funciones.
La mayoría de las preguntas sobre la propiedad surgen al escribir funciones. Cuando especifique
https://riptutorial.com/es/home 122

-- 136 of 188 --

los tipos de argumentos de una función, puede elegir cómo se pasa ese valor. Si solo necesita
acceso de solo lectura, puede tomar una referencia inmutable:
fn foo(x: &String) {
// foo is only authorized to read x's contents, and to create
// additional immutable references to it if it so desires.
let y = *x; // ERROR, cannot move when not owned
x.push_str("foo"); // ERROR, cannot mutate with immutable reference
println!("{}", x.len()); // reading OK
foo(x); // forwarding reference OK
}
Si foo necesita modificar el argumento, debe tomar una referencia exclusiva y mutable:
fn foo(x: &mut String) {
// foo is still not responsible for dropping x before returning,
// nor is it allowed to. however, foo may modify the String.
let x2 = *x; // ERROR, cannot move when not owned
x.push_str("foo"); // mutating OK
drop(*x); // ERROR, cannot drop value when not owned
println!("{}", x.len()); // reading OK
}
Si no especifica ya sea & o &mut , está diciendo que la función tomará posesión de un argumento.
Esto significa que foo ahora también es responsable de soltar x .
fn foo(x: String) {
// foo may do whatever it wishes with x, since no-one else has
// access to it. once the function terminates, x will be dropped,
// unless it is moved away when calling another function.
let mut x2 = x; // moving OK
x2.push_str("foo"); // mutating OK
let _ = &mut x2; // mutable borrow OK
let _ = &x2; // immutable borrow OK (note that &mut above is dropped)
println!("{}", x2.len()); // reading OK
drop(x2); // dropping OK
}
La propiedad y el rasgo de la copia
Algunos tipos de Rust implementan el rasgo de Copy . Los tipos que son Copy se pueden mover sin
poseer el valor en cuestión. Esto se debe a que el contenido del valor puede simplemente
copiarse byte por byte en la memoria para producir un nuevo valor idéntico. La mayoría de las
primitivas en Rust ( bool , usize , f64 , etc.) son Copy .
let x: isize = 42;
let xr = &x;
let y = *xr; // OK, because isize is Copy
// both x and y are owned here
En particular, Vec y String no son Copy :
let x = Vec::new();
https://riptutorial.com/es/home 123

-- 137 of 188 --

let xr = &x;
let y = *xr; // ERROR, cannot move out of borrowed content
Lea Propiedad en línea: https://riptutorial.com/es/rust/topic/4395/propiedad
https://riptutorial.com/es/home 124

-- 138 of 188 --