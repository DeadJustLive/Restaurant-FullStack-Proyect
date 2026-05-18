# Capítulo 5:: Arreglos, vectores y cortes

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 24)

## Contenido
# Capítulo 5:: Arreglos, vectores y cortes

Examples
Arrays
Una matriz es una lista de objetos de un solo tipo asignados a la pila y de tamaño estático.
Los arreglos generalmente se crean al incluir una lista de elementos de un tipo dado entre
corchetes. El tipo de una matriz se denota con la sintaxis especial: [T; N] donde T es el tipo de
sus elementos y N su conteo, los cuales deben ser conocidos en el momento de la compilación.
Por ejemplo, [4u64, 5, 6] es una matriz de 3 elementos de tipo [u64; 3] . Nota: Se infiere que 5 y
6 son del tipo u64 .
Ejemplo
fn main() {
// Arrays have a fixed size.
// All elements are of the same type.
let array = [1, 2, 3, 4, 5];
// Create an array of 20 elements where all elements are the same.
// The size should be a compile-time constant.
let ones = [1; 20];
// Get the length of an array.
println!("Length of ones: {}", ones.len());
// Access an element of an array.
// Indexing starts at 0.
println!("Second element of array: {}", array[1]);
// Run-time bounds-check.
// This panics with 'index out of bounds: the len is 5 but the index is 5'.
println!("Non existant element of array: {}", array[5]);
}
Limitaciones
La coincidencia de patrones en los arreglos (o segmentos) no se admite en el Rust estable
(consulte # 23121 y patrones de corte ).
Rust no admite la genéricoidad de los números de nivel de tipo (ver RFCs # 1657 ). Por lo tanto,
no es posible implementar simplemente un rasgo para todas las matrices (de todos los tamaños).
Como resultado, los rasgos estándar solo se implementan para arreglos de hasta un número
https://riptutorial.com/es/home 14

-- 28 of 188 --

limitado de elementos (verificados por última vez, hasta 32 incluidos). Las matrices con más
elementos son compatibles, pero no implementan los rasgos estándar (ver documentos ).
Estas restricciones serán levantadas en el futuro.
Vectores
Un vector es esencialmente un puntero a una lista de objetos de un solo tipo asignados
dinámicamente y de tamaño dinámico.
Ejemplo
fn main() {
// Create a mutable empty vector
let mut vector = Vec::new();
vector.push(20);
vector.insert(0, 10); // insert at the beginning
println!("Second element of vector: {}", vector[1]); // 20
// Create a vector using the `vec!` macro
let till_five = vec![1, 2, 3, 4, 5];
// Create a vector of 20 elements where all elements are the same.
let ones = vec![1; 20];
// Get the length of a vector.
println!("Length of ones: {}", ones.len());
// Run-time bounds-check.
// This panics with 'index out of bounds: the len is 5 but the index is 5'.
println!("Non existant element of array: {}", till_five[5]);
}
Rebanadas
Las divisiones son vistas en una lista de objetos y tienen el tipo [T] , que indica una porción de
objetos con el tipo T
Una porción es un tipo sin tamaño y, por lo tanto, solo se puede usar detrás de un puntero. (La
analogía de String World: str , llamada segmento de cadena, también no tiene tamaño.)
Las matrices se convierten en cortes y los vectores se pueden eliminar de referencia en los
cortes. Por lo tanto, los métodos de división se pueden aplicar a ambos. (String world analogy: str
es String , lo que [T] es Vec<T> .)
fn main() {
let vector = vec![1, 2, 3, 4, 5, 6, 7, 8];
let slice = &vector[3..6];
println!("length of slice: {}", slice.len()); // 3
https://riptutorial.com/es/home 15

-- 29 of 188 --

println!("slice: {:?}", slice); // [4, 5, 6]
}
Lea Arreglos, vectores y cortes en línea: https://riptutorial.com/es/rust/topic/5004/arreglos--
vectores-y-cortes
https://riptutorial.com/es/home 16

-- 30 of 188 --
