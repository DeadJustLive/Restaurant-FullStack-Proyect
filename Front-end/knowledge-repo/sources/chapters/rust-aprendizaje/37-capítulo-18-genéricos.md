# Capítulo 18:: Genéricos

Examples
Declaración
// Generic types are declared using the <T> annotation
struct GenericType<T> {
pub item: T
}
enum QualityChecked<T> {
Excellent(T),
Good(T),
// enum fields can be generics too
Mediocre { product: T }
}
Instanciación
// explicit type declaration
let some_value: Option<u32> = Some(13);
// implicit type declaration
let some_other_value = Some(66);
Parámetros de tipo múltiple
Los tipos genéricos pueden tener más de un tipo de parámetros, por ejemplo. Result se define
así:
pub enum Result<T, E> {
Ok(T),
Err(E),
}
Tipos genéricos acotados
// Only accept T and U generic types that also implement Debug
fn print_objects<T: Debug, U: Debug>(a: T, b: U) {
println!("A: {:?} B: {:?}", a, b);
}
print_objects(13, 44);
// or annotated explicitly
print_objects::<usize, u16>(13, 44);
Los límites deben cubrir todos los usos del tipo. La adición se realiza mediante el rasgo
https://riptutorial.com/es/home 51

-- 65 of 188 --

std::ops::Add , que tiene parámetros de entrada y salida. where T: std::ops::Add<u32,Output=U>
indica que es posible Add T a u32 , y esta adición debe producir el tipo U
fn try_add_one<T, U>(input_value: T) -> Result<U, String>
where T: std::ops::Add<u32,Output=U>
{
return Ok(input_value + 1);
}
Sized límite de Sized está implícito por defecto. ?Sized límite de ?Sized permite tipos sin tamaño
también.
Funciones genéricas
Las funciones genéricas permiten parametrizar algunos o todos sus argumentos.
fn convert_values<T, U>(input_value: T) -> Result<U, String> {
// Try and convert the value.
// Actual code will require bounds on the types T, U to be able to do something with them.
}
Si el compilador no puede inferir el parámetro de tipo, entonces puede suministrarse
manualmente al llamar:
let result: Result<u32, String> = convert_value::<f64, u32>(13.5);
Lea Genéricos en línea: https://riptutorial.com/es/rust/topic/1801/genericos
https://riptutorial.com/es/home 52

-- 66 of 188 --