# 07. Módulos - Con use

Cuando desee enlazar la ruta completa a un nuevo nombre,	1.
use greet::hello::greet as greet_hello;
https://riptutorial.com/es/home 98

-- 112 of 188 --

fn main() {
greet_hello();
}
mod greet {
pub mod hello {
pub fn greet() {
println!("Hello, world!");
}
}
}
Cuando quieras usar el contenido del nivel de alcance del cajón	2.
fn main() {
user::hello();
}
mod greet {
pub mod hello {
pub fn greet() {
println!("Hello, world!");
}
}
}
mod user {
use greet::hello::greet as call_hello;
pub fn hello() {
call_hello();
}
}
Lea Módulos en línea: https://riptutorial.com/es/rust/topic/2528/modulos
https://riptutorial.com/es/home 99

-- 113 of 188 --