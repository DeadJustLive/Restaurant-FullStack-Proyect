# Capítulo 24:: La coincidencia de patrones

Sintaxis
_ // patrón de comodín, coincide con cualquier cosa¹	•
ident // patrón de unión, coincide con cualquier cosa y lo une a ident	•
ident @ pat // igual que arriba, pero permite que coincida aún más con lo que está enlazado	•
ref ident // patrón de encuadernación, coincide con cualquier cosa y lo enlaza con un ident
de referencia ¹
•
ref mut ident // patrón de unión, coincide con cualquier cosa y lo une a una referencia de
mutable ident ¹
•
& pat // coincide con una referencia ( pat no es, por lo tanto, una referencia, sino el árbitro)	•
& mut pat // igual que el anterior con una referencia mutable¹	•
CONST // coincide con una constante nombrada	•
Struct { field1 , field2 } // coincide y deconstruye un valor de estructura, vea más abajo la
nota sobre campos¹
•
EnumVariant // coincide con una variante de enumeración	•
EnumVariant ( pat1 , pat2 ) // coincide con una variante de enumeración y los parámetros
correspondientes
•
EnumVariant ( pat1 , pat2 , .., patn ) // igual que el anterior, pero omite todos los parámetros
menos el primero, el segundo y el último
•
( pat1 , pat2 ) // coincide con una tupla y los elementos correspondientes¹	•
( pat1 , pat2 , .., patn ) // igual que arriba pero salta todos los elementos menos el primero, el
segundo y el último¹
•
encendido // coincide con una constante literal (char, tipos numéricos, booleano y cadena)	•
pat1 ... pat2 // coincide con un valor en ese rango (inclusive) (tipos de caracteres y
numéricos)
•
Observaciones
Al deconstruir un valor de estructura, el campo debe tener el formato field_name o field_name :
pattern . Si no se especifica ningún patrón, se realiza un enlace implícito:
let Point { x, y } = p;
// equivalent to
let Point { x: x, y: y } = p;
let Point { ref x, ref y } = p;
// equivalent to
let Point { x: ref x, y: ref y } = p;
1: patrón irrefutable
Examples
https://riptutorial.com/es/home 70

-- 84 of 188 --

Patrón de coincidencia con enlaces
Es posible vincular valores a nombres usando @ :
struct Badger {
pub age: u8
}
fn main() {
// Let's create a Badger instances
let badger_john = Badger { age: 8 };
// Now try to find out what John's favourite activity is, based on his age
match badger_john.age {
// we can bind value ranges to variables and use them in the matched branches
baby_age @ 0...1 => println!("John is {} years old, he sleeps a lot", baby_age),
young_age @ 2...4 => println!("John is {} years old, he plays all day", young_age),
adult_age @ 5...10 => println!("John is {} years old, he eats honey most of the time",
adult_age),
old_age => println!("John is {} years old, he mostly reads newspapers", old_age),
}
}
Esto imprimirá:
John is 8 years old, he eats honey most of the time
Coincidencia de patrones básicos
// Create a boolean value
let a = true;
// The following expression will try and find a pattern for our value starting with
// the topmost pattern.
// This is an exhaustive match expression because it checks for every possible value
match a {
true => println!("a is true"),
false => println!("a is false")
}
Si no cubrimos todos los casos, obtendremos un error de compilación:
match a {
true => println!("most important case")
}
// error: non-exhaustive patterns: `false` not covered [E0004]
Podemos usar _ como el caso predeterminado / comodín, coincide con todo:
// Create an 32-bit unsigned integer
let b: u32 = 13;
match b {
https://riptutorial.com/es/home 71

-- 85 of 188 --

0 => println!("b is 0"),
1 => println!("b is 1"),
_ => println!("b is something other than 0 or 1")
}
Este ejemplo imprimirá:
a is true
b is something else than 0 or 1
Coincidencia de patrones múltiples
Es posible tratar múltiples valores distintos de la misma manera, usando | :
enum Colour {
Red,
Green,
Blue,
Cyan,
Magenta,
Yellow,
Black
}
enum ColourModel {
RGB,