# Capítulo 40:: Rasgos

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 67)

## Contenido
# Capítulo 40:: Rasgos

Introducción
Los rasgos son una forma de describir un "contrato" que una struct debe implementar. Los
rasgos generalmente definen las firmas de los métodos, pero también pueden proporcionar
implementaciones basadas en otros métodos del rasgo, siempre que los límites de los rasgos lo
permitan.
Para aquellos familiarizados con la programación orientada a objetos, los rasgos se pueden
considerar como interfaces con algunas diferencias sutiles.
Sintaxis
rasgo Rasgo {método fn (...) -> ReturnType; ...}	•
rasgo Rasgo: Bound {método fn (...) -> ReturnType; ...}	•
impl Trait for Type {fn method (...) -> ReturnType {...} ...}	•
impl <T> Rasgo para T donde T: Límites {método fn (...) -> ReturnType {...} ...}	•
Observaciones
Los rasgos se suelen comparar con las interfaces, pero es importante hacer una distinción
entre los dos. En lenguajes OO como Java, las interfaces son una parte integral de las
clases que las extienden. En Rust, el compilador no sabe nada de los rasgos de una
estructura a menos que se usen esos rasgos.
•
Examples
Lo esencial
Creando un Rasgo
trait Speak {
fn speak(&self) -> String;
}
Implementando un Rasgo
struct Person;
struct Dog;
impl Speak for Person {
fn speak(&self) -> String {
String::from("Hello.")
https://riptutorial.com/es/home 130

-- 144 of 188 --

}
}
impl Speak for Dog {
fn speak(&self) -> String {
String::from("Woof.")
}
}
fn main() {
let person = Person {};
let dog = Dog {};
println!("The person says {}", person.speak());
println!("The dog says {}", dog.speak());
}
Despacho estático y dinámico
Es posible crear una función que acepte objetos que implementen un rasgo específico.
Despacho estático
fn generic_speak<T: Speak>(speaker: &T) {
println!("{0}", speaker.speak());
}
fn main() {
let person = Person {};
let dog = Dog {};
generic_speak(&person);
generic_speak(&dog);
}
Aquí se usa el envío estático, lo que significa que el compilador Rust generará versiones
especializadas de la función generic_speak para los tipos Dog y Person . Esta generación de
versiones especializadas de una función polimórfica (o cualquier entidad polimórfica) durante la
compilación se denomina monomorfización .
Despacho dinámico
fn generic_speak(speaker: &Speak) {
println!("{0}", speaker.speak());
}
fn main() {
let person = Person {};
let dog = Dog {};
generic_speak(&person as &Speak);
generic_speak(&dog); // gets automatically coerced to &Speak
}
https://riptutorial.com/es/home 131

-- 145 of 188 --

Aquí, solo existe una versión única de generic_speak en el binario compilado, y la llamada speak()
se realiza mediante una búsqueda vtable en tiempo de ejecución. Por lo tanto, el uso del envío
dinámico da como resultado una compilación más rápida y un tamaño más pequeño del binario
compilado, mientras que es un poco más lento en el tiempo de ejecución.
Los objetos de tipo &Speak o Box<Speak> se denominan objetos de rasgo .
Tipos asociados
Utilice el tipo asociado cuando exista una relación de uno a uno entre el tipo que
implementa el rasgo y el tipo asociado.
•
A veces también se conoce como el tipo de salida , ya que este es un elemento dado a un
tipo cuando le aplicamos un rasgo.
•
Creación
trait GetItems {
type First;
// ^~~~ defines an associated type.
type Last: ?Sized;
// ^~~~~~~~ associated types may be constrained by traits as well
fn first_item(&self) -> &Self::First;
// ^~~~~~~~~~~ use `Self::` to refer to the associated type
fn last_item(&self) -> &Self::Last;
// ^~~~~~~~~~ associated types can be used as function output...
fn set_first_item(&mut self, item: Self::First);
// ^~~~~~~~~~~ ... input, and anywhere.
}
Implementacion
impl<T, U: ?Sized> GetItems for (T, U) {
type First = T;
type Last = U;
// ^~~ assign the associated types
fn first_item(&self) -> &Self::First { &self.0 }
fn last_item(&self) -> &Self::Last { &self.1 }
fn set_first_item(&mut self, item: Self::First) { self.0 = item; }
}
impl<T> GetItems for [T; 3] {
type First = T;
type Last = T;
fn first_item(&self) -> &T { &self[0] }
// ^ you could refer to the actual type instead of `Self::First`
fn last_item(&self) -> &T { &self[2] }
fn set_first_item(&mut self, item: T) { self[0] = item; }
}
https://riptutorial.com/es/home 132

-- 146 of 188 --

Haciendo referencia a tipos asociados.
Si estamos seguros de que un tipo T implementa GetItems por ejemplo, en genéricos, simplemente
podríamos usar T::First para obtener el tipo asociado.
fn get_first_and_last<T: GetItems>(obj: &T) -> (&T::First, &T::Last) {
// ^~~~~~~~ refer to an associated type
(obj.first_item(), obj.last_item())
}
De lo contrario, debe indicar explícitamente al compilador qué rasgo está implementando el tipo
let array: [u32; 3] = [1, 2, 3];
let first: &<[u32; 3] as GetItems>::First = array.first_item();
// ^~~~~~~~~~~~~~~~~~~~~~~~~~~~~ [u32; 3] may implement multiple traits which many
// of them provide the `First` associated type.
// thus the explicit "cast" is necessary here.
assert_eq!(*first, 1);
Restricción con tipos asociados
fn clone_first_and
