# CMYK

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 45)

## Contenido
# CMYK

}
// let's take an example colour
let colour = Colour::Red;
let model = match colour {
// check if colour is any of the RGB colours
Colour::Red | Colour::Green | Colour::Blue => ColourModel::RGB,
// otherwise select CMYK
_ => ColourModel::CMYK,
};
Patrón condicional que coincide con los guardias
Los patrones se pueden hacer coincidir en función de los valores independientes del valor que se
hace coincidir utilizando if guardias:
// Let's imagine a simplistic web app with the following pages:
enum Page {
Login,
Logout,
About,
Admin
}
// We are authenticated
let is_authenticated = true;
https://riptutorial.com/es/home 72

-- 86 of 188 --

// But we aren't admins
let is_admin = false;
let accessed_page = Page::Admin;
match accessed_page {
// Login is available for not yet authenticated users
Page::Login if !is_authenticated => println!("Please provide a username and a password"),
// Logout is available for authenticated users
Page::Logout if is_authenticated => println!("Good bye"),
// About is a public page, anyone can access it
Page::About => println!("About us"),
// But the Admin page is restricted to administators
Page::Admin if is_admin => println!("Welcome, dear administrator"),
// For every other request, we display an error message
_ => println!("Not available")
}
Esto mostrará "No disponible" .
si let / while let
if let
Combina una match patrón y una declaración if , y permite que se realicen breves coincidencias
no exhaustivas.
if let Some(x) = option {
do_something(x);
}
Esto es equivalente a:
match option {
Some(x) => do_something(x),
_ => {},
}
Estos bloques también pueden tener else declaraciones.
if let Some(x) = option {
do_something(x);
} else {
panic!("option was None");
}
Este bloque es equivalente a:
https://riptutorial.com/es/home 73

-- 87 of 188 --

match option {
Some(x) => do_something(x),
None => panic!("option was None"),
}
while let
Combina una coincidencia de patrón y un bucle while.
let mut cs = "Hello, world!".chars();
while let Some(x) = cs.next() {
print("{}+", x);
}
println!("");
Esto imprime H+e+l+l+o+,+ +w+o+r+l+d+!+ .
Es equivalente a usar un loop {} y una declaración de match :
let mut cs = "Hello, world!".chars();
loop {
match cs.next() {
Some(x) => print("{}+", x),
_ => break,
}
}
println!("");
Extraer referencias de patrones.
A veces es necesario poder extraer valores de un objeto utilizando solo referencias (es decir, sin
transferir la propiedad).
struct Token {
pub id: u32
}
struct User {
pub token: Option<Token>
}
fn main() {
// Create a user with an arbitrary token
let user = User { token: Some(Token { id: 3 }) };
// Let's borrow user by getting a reference to it
let user_ref = &user;
// This match expression would not compile saying "cannot move out of borrowed
// content" because user_ref is a borrowed value but token expects an owned value.
match user_ref {
&User { token } => println!("User token exists? {}", token.is_some())
}
https://riptutorial.com/es/home 74

-- 88 of 188 --

// By adding 'ref' to our pattern we instruct the compiler to give us a reference
// instead of an owned value.
match user_ref {
&User { ref token } => println!("User token exists? {}", token.is_some())
}
// We can also combine ref with destructuring
match user_ref {
// 'ref' will allow us to access the token inside of the Option by reference
&User { token: Some(ref user_token) } => println!("Token value: {}", user_token.id ),
&User { token: None } => println!("There was no token assigned to the user" )
}
// References can be mutable too, let's create another user to demonstrate this
let mut other_user = User { token: Some(Token { id: 4 }) };
// Take a mutable reference to the user
let other_user_ref_mut = &mut other_user;
match other_user_ref_mut {
// 'ref mut' gets us a mutable reference allowing us to change the contained value
directly.
&mut User { token: Some(ref mut user_token) } => {
user_token.id = 5;
println!("New token value: {}", user_token.id )
},
&mut User { token: None } => println!("There was no token assigned to the user" )
}
}
Se imprimirá esto:
User token exists? true
Token value: 3
New token value: 5
Lea La coincidencia de patrones en línea: https://riptutorial.com/es/rust/topic/1188/la-coincidencia-
de-patrones
https://riptutorial.com/es/home 75

-- 89 of 188 --
