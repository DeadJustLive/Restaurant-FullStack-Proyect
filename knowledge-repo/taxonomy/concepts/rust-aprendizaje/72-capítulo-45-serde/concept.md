# Capítulo 45:: Serde

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 72)

## Contenido
# Capítulo 45:: Serde

Introducción
Serde es un popular ialization ser y marco de serialización de Rust, que se utiliza para convertir
los datos en serie (por ejemplo, JSON y XML) para estructuras de óxido y viceversa. Serde
soporta muchos formatos, incluyendo: JSON, YAML, TOML, BSON, Pickle y XML.
Examples
Struct ↔ JSON
main.rs
extern crate serde;
extern crate serde_json;
// Import this crate to derive the Serialize and Deserialize traits.
#[macro_use] extern crate serde_derive;
#[derive(Serialize, Deserialize, Debug)]
struct Point {
x: i32,
y: i32,
}
fn main() {
let point = Point { x: 1, y: 2 };
// Convert the Point to a packed JSON string. To convert it to
// pretty JSON with indentation, use `to_string_pretty` instead.
let serialized = serde_json::to_string(&point).unwrap();
// Prints serialized = {"x":1,"y":2}
println!("serialized = {}", serialized);
// Convert the JSON string back to a Point.
let deserialized: Point = serde_json::from_str(&serialized).unwrap();
// Prints deserialized = Point { x: 1, y: 2 }
println!("deserialized = {:?}", deserialized);
}
Cargo.toml
[package]
name = "serde-example"
version = "0.1.0"
https://riptutorial.com/es/home 149

-- 163 of 188 --

build = "build.rs"
[dependencies]
serde = "0.9"
serde_json = "0.9"
serde_derive = "0.9"
Serializar enumeración como cadena
extern crate serde;
extern crate serde_json;
macro_rules! enum_str {
($name:ident { $($variant:ident($str:expr), )* }) => {
#[derive(Clone, Copy, Debug, Eq, PartialEq)]
pub enum $name {
$($variant,)*
}
impl ::serde::Serialize for $name {
fn serialize<S>(&self, serializer: S) -> Result<S::Ok, S::Error>
where S: ::serde::Serializer,
{
// Serialize the enum as a string.
serializer.serialize_str(match *self {
$( $name::$variant => $str, )*
})
}
}
impl ::serde::Deserialize for $name {
fn deserialize<D>(deserializer: D) -> Result<Self, D::Error>
where D: ::serde::Deserializer,
{
struct Visitor;
impl ::serde::de::Visitor for Visitor {
type Value = $name;
fn expecting(&self, formatter: &mut ::std::fmt::Formatter) ->
::std::fmt::Result {
write!(formatter, "a string for {}", stringify!($name))
}
fn visit_str<E>(self, value: &str) -> Result<$name, E>
where E: ::serde::de::Error,
{
match value {
$( $str => Ok($name::$variant), )*
_ => Err(E::invalid_value(::serde::de::Unexpected::Other(
&format!("unknown {} variant: {}", stringify!($name), value)
), &self)),
}
}
}
// Deserialize the enum from a string.
deserializer.deserialize_str(Visitor)
}
https://riptutorial.com/es/home 150

-- 164 of 188 --

}
}
}
enum_str!(LanguageCode {
English("en"),
Spanish("es"),
Italian("it"),
Japanese("ja"),
Chinese("zh"),
});
fn main() {
use LanguageCode::*;
let languages = vec![English, Spanish, Italian, Japanese, Chinese];
// Prints ["en","es","it","ja","zh"]
println!("{}", serde_json::to_string(&languages).unwrap());
let input = r#" "ja" "#;
assert_eq!(Japanese, serde_json::from_str(input).unwrap());
}
Serializar campos como camelCase
extern crate serde;
extern crate serde_json;
#[macro_use] extern crate serde_derive;
#[derive(Serialize)]
struct Person {
#[serde(rename="firstName")]
first_name: String,
#[serde(rename="lastName")]
last_name: String,
}
fn main() {
let person = Person {
first_name: "Joel".to_string(),
last_name: "Spolsky".to_string(),
};
let json = serde_json::to_string_pretty(&person).unwrap();
// Prints:
//
// {
// "firstName": "Joel",
// "lastName": "Spolsky"
// }
println!("{}", json);
}
Valor predeterminado para el campo
extern crate serde;
https://riptutorial.com/es/home 151

-- 165 of 188 --

extern crate serde_json;
#[macro_use] extern crate serde_derive;
#[derive(Deserialize, Debug)]
struct Request {
// Use the result of a function as the default if "resource" is
// not included in the input.
#[serde(default="default_resource")]
resource: String,
// Use the type's implementation of std::default::Default if
// "timeout" is not included in the input.
#[serde(default)]
timeout: Timeout,
// Use a method from the type as the default if "priority" is not
// included in the input. This may also be a trait method.
#[serde(default="Priority::lowest")]
priority: Priority,
}
fn default_resource() -> String {
"/".to_string()
}
/// Timeout in seconds.
#[derive(Deserialize, Debug)]
struct Timeout(u32);
impl Default for Timeout {
fn default() -> Self {
Timeout(30)
}
}
#[derive(Deserialize, Debug)]
enum Priority { ExtraHigh, High, Normal, Low, ExtraLow }
impl Priority {
fn lowest() -> Self { Priority::ExtraLow }
}
fn main() {
let json = r#"
[
{
"resource": "/users"
},
{
"timeout": 5,
"priority": "High"
}
]
"#;
let requests: Vec<Request> = serde_json::from_str(json).unwrap();
// The first request has resource="/users", timeout=30, priority=ExtraLow
println!("{:?}", requests[0]);
// The second request has resource="/", timeout=5, priority=High
println!("{:?}", requests[1]);
}
https://riptutorial.com/es/home 152

-- 166 of 188 --

Saltar campo de serialización
extern crate serde;
extern crate serde_json;
#[macro_use] extern crate serde_derive;
