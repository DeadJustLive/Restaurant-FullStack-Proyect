# Capítulo 48:: Tuplas

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 75)

## Contenido
# Capítulo 48:: Tuplas

Introducción
La estructura de datos más trivial, después de un valor singular, es la tupla.
Sintaxis
(A, B, C) // una tupla de tres (una tupla con tres elementos), cuyo primer elemento tiene tipo
A, segundo tipo B y tercero tipo C
•
(A, B) // una tupla doble, cuyos dos elementos tienen tipo A y B respectivamente	•
(A,) // a una tupla (nótese el trailing , ), que tiene sólo un único elemento de tipo A	•
() // la tupla vacía, que es tanto un tipo, como el único elemento de ese tipo	•
Examples
Tipos de tuplas y valores de tuplas
Las tuplas de óxido, como en la mayoría de los otros idiomas, son listas de tamaño fijo cuyos
elementos pueden ser de diferentes tipos.
// Tuples in Rust are comma-separated values or types enclosed in parentheses.
let _ = ("hello", 42, true);
// The type of a tuple value is a type tuple with the same number of elements.
// Each element in the type tuple is the type of the corresponding value element.
let _: (i32, bool) = (42, true);
// Tuples can have any number of elements, including one ..
let _: (bool,) = (true,);
// .. or even zero!
let _: () = ();
// this last type has only one possible value, the empty tuple ()
// this is also the type (and value) of the return value of functions
// that do not return a value ..
let _: () = println!("hello");
// .. or of expressions with no value.
let mut a = 0;
let _: () = if true { a += 1; };
Coincidencia de valores de tupla
Los programas de oxidación utilizan la concordancia de patrones extensivamente para deconstruir
los valores, ya sea utilizando match , if let , o deconstruyendo patrones de let . Las tuplas se
pueden deconstruir como se podría esperar usando el match
fn foo(x: (&str, isize, bool)) {
match x {
(_, 42, _) => println!("it's 42"),
(_, _, false) => println!("it's not true"),
https://riptutorial.com/es/home 163

-- 177 of 188 --

_ => println!("it's something else"),
}
}
o con if let
fn foo(x: (&str, isize, bool)) {
if let (_, 42, _) = x {
println!("it's 42");
} else {
println!("it's something else");
}
}
También puede enlazar dentro de la tupla usando let -deconstruction
fn foo(x: (&str, isize, bool)) {
let (_, n, _) = x;
println!("the number is {}", n);
}
Mirando dentro de las tuplas
Para acceder directamente a los elementos de una tupla, puede usar el formato .n para acceder
al elemento n -ésimo
let x = ("hello", 42, true);
assert_eq!(x.0, "hello");
assert_eq!(x.1, 42);
assert_eq!(x.2, true);
También puedes moverte parcialmente de una tupla
let x = (String::from("hello"), 42);
let (s, _) = x;
let (_, n) = x;
println!("{}, {}", s, n);
// the following would fail however, since x.0 has already been moved
// let foo = x.0;
Lo esencial
Una tupla es simplemente una concatenación de múltiples valores:
de tipos posiblemente diferentes	•
cuyo número y tipos se conocen estáticamente	•
Por ejemplo, (1, "Hello") es una tupla de 2 elementos compuesta por i32 y a &str , y su tipo se
denota como (i32, &'static str) de manera similar a su valor.
Para acceder a un elemento de una tupla, uno simplemente usa su índice:
https://riptutorial.com/es/home 164

-- 178 of 188 --

let tuple = (1, "Hello");
println!("First element: {}, second element: {}", tuple.0, tuple.1);
Debido a que la tupla está incorporada, también es posible utilizar la coincidencia de patrones en
las tuplas:
match (1, "Hello") {
(i, _) if i < 0 => println!("Negative integer: {}", i),
(_, s) => println!("{} World", s),
}
Casos especiales
La tupla del elemento 0: () también se denomina unidad , tipo de unidad o tipo singleton y se usa
para denotar la ausencia de valores significativos. Es el tipo de retorno predeterminado de las
funciones (cuando -> no se especifica). Ver también: ¿Qué tipo es el "tipo ()" en Rust? .
La tupla de 1 elemento: (a,) , con la coma al final, denota una tupla de 1 elemento. La forma sin
una coma (a) se interpreta como una expresión entre paréntesis y se evalúa como solo a .
Y mientras estamos en eso, siempre se aceptan las comas finales: (1, "Hello",) .
Limitaciones
El lenguaje Rust de hoy no admite variadics , además de las tuplas. Por lo tanto, no es posible
implementar simplemente un rasgo para todas las tuplas y, como resultado, los rasgos estándar
solo se implementan para tuplas hasta un número limitado de elementos (hoy, hasta 12 incluidos).
Las tuplas con más elementos son compatibles, pero no implementan los rasgos estándar
(aunque puede implementar sus propios rasgos para ellos).
Esperamos que esta restricción se levante en el futuro.
Desembalaje de tuplas
// It's possible to unpack tuples to assign their inner values to variables
let tup = (0, 1, 2);
// Unpack the tuple into variables a, b, and c
let (a, b, c) = tup;
assert_eq!(a, 0);
assert_eq!(b, 1);
// This works for nested data structures and other complex data types
let complex = ((1, 2), 3, Some(0));
let (a, b, c) = complex;
let (aa, ab) = a;
assert_eq!(aa, 1);
assert_eq!(ab, 2);
https://riptutorial.com/es/home 165

-- 179 of 188 --

Lea Tuplas en línea: https://
