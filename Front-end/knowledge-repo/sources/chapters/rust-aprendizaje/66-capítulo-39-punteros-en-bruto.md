# Capítulo 39:: Punteros en bruto

Sintaxis
deje que raw_ptr = & pointee como * const type // cree un puntero en bruto constante a
algunos datos
•
let raw_mut_ptr = & mut pointee como * mut type // crea un puntero raw mutable a algunos
datos mutables
•
Deje que deref = * raw_ptr // desreferencia un puntero en bruto (requiere un bloque no
seguro)
•
Observaciones
No se garantiza que los punteros sin procesar apunten a una dirección de memoria válida y,
como tal, el uso descuidado puede dar lugar a errores inesperados (y probablemente
fatales).
•
Cualquier referencia de Rust normal (por ejemplo, &my_object donde el tipo de my_object es
T) my_object a *const T Del mismo modo, las referencias mutables obligan a *mut T
•
Los punteros sin procesar no mueven la propiedad (en contraste con los valores de Cuadro
que)
•
Examples
Creando y utilizando punteros crudos constantes.
// Let's take an arbitrary piece of data, a 4-byte integer in this case
let some_data: u32 = 14;
// Create a constant raw pointer pointing to the data above
let data_ptr: *const u32 = &some_data as *const u32;
// Note: creating a raw pointer is totally safe but dereferencing a raw pointer requires an
// unsafe block
unsafe {
let deref_data: u32 = *data_ptr;
println!("Dereferenced data: {}", deref_data);
}
Se emitirá el código anterior: Dereferenced data: 14
Creando y utilizando punteros en bruto mutables.
// Let's take a mutable piece of data, a 4-byte integer in this case
let mut some_data: u32 = 14;
// Create a mutable raw pointer pointing to the data above
let data_ptr: *mut u32 = &mut some_data as *mut u32;
https://riptutorial.com/es/home 127

-- 141 of 188 --

// Note: creating a raw pointer is totally safe but dereferencing a raw pointer requires an
// unsafe block
unsafe {
*data_ptr = 20;
println!("Dereferenced data: {}", some_data);
}
Se emitirá el código anterior: Dereferenced data: 20
Inicializando un puntero crudo a nulo
A diferencia de las referencias de Rust normales, los punteros sin formato pueden tomar valores
nulos.
use std::ptr;
// Create a const NULL pointer
let null_ptr: *const u16 = ptr::null();
// Create a mutable NULL pointer
let mut_null_ptr: *mut u16 = ptr::null_mut();
Cadena de desreferenciación
Al igual que en C, los punteros en bruto Rust pueden apuntar a otros punteros en bruto (que a su
vez pueden apuntar a otros punteros en bruto).
// Take a regular string slice
let planet: &str = "Earth";
// Create a constant pointer pointing to our string slice
let planet_ptr: *const &str = &planet as *const &str;
// Create a constant pointer pointing to the pointer
let planet_ptr_ptr: *const *const &str = &planet_ptr as *const *const &str;
// This can go on...
let planet_ptr_ptr_ptr = &planet_ptr_ptr as *const *const *const &str;
unsafe {
// Direct usage
println!("The name of our planet is: {}", planet);
// Single dereference
println!("The name of our planet is: {}", *planet_ptr);
// Double dereference
println!("The name of our planet is: {}", **planet_ptr_ptr);
// Triple dereference
println!("The name of our planet is: {}", ***planet_ptr_ptr_ptr);
}
Esto dará como resultado: The name of our planet is: Earth cuatro veces.
Mostrando punteros en bruto
https://riptutorial.com/es/home 128

-- 142 of 188 --

Rust tiene un formateador predeterminado para los tipos de punteros que se pueden usar para
mostrar punteros.
use std::ptr;
// Create some data, a raw pointer pointing to it and a null pointer
let data: u32 = 42;
let raw_ptr = &data as *const u32;
let null_ptr = ptr::null() as *const u32;
// the {:p} mapping shows pointer values as hexadecimal memory addresses
println!("Data address: {:p}", &data);
println!("Raw pointer address: {:p}", raw_ptr);
println!("Null pointer address: {:p}", null_ptr);
Esto producirá algo como esto:
Data address: 0x7fff59f6bcc0
Raw pointer address: 0x7fff59f6bcc0
Null pointer address: 0x0
Lea Punteros en bruto en línea: https://riptutorial.com/es/rust/topic/7270/punteros-en-bruto
https://riptutorial.com/es/home 129

-- 143 of 188 --