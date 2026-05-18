# Capítulo 25:: Macros

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 46)

## Contenido
# Capítulo 25:: Macros

Observaciones
Puede encontrar un tutorial de macros en The Rust Programming Language (también conocido
como The Book) .
Examples
Tutorial
Las macros nos permiten abstraer patrones sintácticos que se repiten muchas veces. Por
ejemplo:
/// Computes `a + b * c`. If any of the operation overflows, returns `None`.
fn checked_fma(a: u64, b: u64, c: u64) -> Option<u64> {
let product = match b.checked_mul(c) {
Some(p) => p,
None => return None,
};
let sum = match a.checked_add(product) {
Some(s) => s,
None => return None,
};
Some(sum)
}
Notamos que las dos declaraciones de match son muy similares: ambas tienen el mismo patrón
match expression {
Some(x) => x,
None => return None,
}
Imagina que representamos el patrón anterior como try_opt!(expression) , luego podríamos
reescribir la función en solo 3 líneas:
fn checked_fma(a: u64, b: u64, c: u64) -> Option<u64> {
let product = try_opt!(b.checked_mul(c));
let sum = try_opt!(a.checked_add(product));
Some(sum)
}
try_opt! no se puede escribir una función porque una función no admite el retorno anticipado.
Pero podríamos hacerlo con una macro: siempre que tengamos estos patrones sintácticos que no
se pueden representar usando una función, podemos tratar de usar una macro.
Definimos una macro usando las macro_rules! sintaxis:
https://riptutorial.com/es/home 76

-- 90 of 188 --

macro_rules! try_opt {
// ^ note: no `!` after the macro name
($e:expr) => {
// ^~~~~~~ The macro accepts an "expression" argument, which we call `$e`.
// All macro parameters must be named like `$xxxxx`, to distinguish from
// normal tokens.
match $e {
// ^~ The input is used here.
Some(x) => x,
None => return None,
}
}
}
¡Eso es! Hemos creado nuestra primera macro.
(Pruébalo en Rust Playground )
Crear una macro HashSet
// This example creates a macro `set!` that functions similarly to the built-in
// macro vec!
use std::collections::HashSet;
macro_rules! set {
( $( $x:expr ),* ) => { // Match zero or more comma delimited items
{
let mut temp_set = HashSet::new(); // Create a mutable HashSet
$(
temp_set.insert($x); // Insert each item matched into the HashSet
)*
temp_set // Return the populated HashSet
}
};
}
// Usage
let my_set = set![1, 2, 3, 4];
Recursion
Una macro puede llamarse a sí misma, como una función recursiva:
macro_rules! sum {
($base:expr) => { $base };
($a:expr, $($rest:expr),+) => { $a + sum!($($rest),+) };
}
¡Vamos por la expansión de la sum!(1, 2, 3) :
sum!(1, 2, 3)
// ^ ^~~~
// $a $rest
=> 1 + sum!(2, 3)
https://riptutorial.com/es/home 77

-- 91 of 188 --

// ^ ^
// $a $rest
=> 1 + (2 + sum!(3))
// ^
// $base
=> 1 + (2 + (3))
Límite de recursión
Cuando el compilador está expandiendo las macros demasiado profundamente, se rendirá. De
forma predeterminada, el compilador fallará después de expandir las macros a 64 niveles de
profundidad, por lo que, por ejemplo, la siguiente expansión causará un error:
sum!(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,
41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62)
// error: recursion limit reached while expanding the macro `sum`
// --> <anon>:3:46
// 3 |> ($a:expr, $($rest:expr),+) => { $a + sum!($($rest),+) };
// |> ^^^^^^^^^^^^^^^^
Cuando se alcanza un límite de recursión, debería considerar refactorizar su macro, por ejemplo,
¿Tal vez la recursión podría ser reemplazada por la repetición?	•
Tal vez el formato de entrada podría cambiarse a algo menos sofisticado, por lo que no
necesitamos recursión para que coincida.
•
Si hay alguna razón legítima para que 64 niveles no sean suficientes, siempre puede aumentar el
límite de la caja invocando la macro con el atributo:
#![recursion_limit="128"]
// ^~~ set the recursion limit to 128 levels deep.
Patrones multiples
Una macro puede producir diferentes salidas contra diferentes patrones de entrada:
/// The `sum` macro may be invoked in two ways:
///
/// sum!(iterator)
/// sum!(1234, iterator)
///
macro_rules! sum {
($iter:expr) => { // This branch handles the `sum!(iterator)` case
$iter.fold(0, |a, b| a + *b)
};
// ^ use `;` to separate each branch
($start:expr, $iter:expr) => { // This branch handles the `sum!(1234, iter)` case
$iter.fold($start, |a, b| a + *b)
};
}
https://riptutorial.com/es/home 78

-- 92 of 188 --

fn main() {
assert_eq!(10, sum!([1, 2, 3, 4].iter()));
assert_eq!(23, sum!(6, [2, 5, 9, 1].iter()));
}
Especificadores de fragmentos - Tipo de patrones
En $e:expr , el expr se llama el especificador de fragmento . Le dice al analizador qué tipo de
tokens está esperando el parámetro $e . Rust proporciona una variedad de especificadores de
fragmentos para permitir que la entrada sea muy flexible.
Especificador Descripción Ejemplos
ident Identificador x , foo
path Nombre calificado std::collection::HashSet , Vec::new
ty Tipo i32 , &T , Vec<(char, String)>
expr Expresión 2+2 , f(42) , if true { 1 } else { 2 }
pat Modelo _ , c @ 'a' ... 'z' , (true, &x) , Badger { age,
.. }
stmt Decl
