# Capítulo 26:: Manejo de errores

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 47)

## Contenido
# Capítulo 26:: Manejo de errores

Introducción
El óxido utiliza los valores del Result<T, E> para indicar errores recuperables durante la ejecución.
Los errores irrecuperables causan pánicos, que es un tema propio.
Observaciones
Los detalles del manejo de errores se describen en The Rust Programming Language (también
conocido como The Book)
Examples
Métodos de resultados comunes
use std::io::{Read, Result as IoResult};
use std::fs::File;
struct Config(u8);
fn read_config() -> IoResult<String> {
let mut s = String::new();
let mut file = File::open(&get_local_config_path())
// or_else closure is invoked if Result is Err.
.or_else(|_| File::open(&get_global_config_path()))?;
// Note: In `or_else`, the closure should return a Result with a matching
// Ok type, whereas in `and_then`, the returned Result should have a
// matching Err type.
let _ = file.read_to_string(&mut s)?;
Ok(s)
}
struct ParseError;
fn parse_config(conf_str: String) -> Result<Config, ParseError> {
// Parse the config string...
if conf_str.starts_with("bananas") {
Err(ParseError)
} else {
Ok(Config(42))
}
}
fn run() -> Result<(), String> {
// Note: The error type of this function is String. We use map_err below to
// make the error values into String type
let conf_str = read_config()
.map_err(|e| format!("Failed to read config file: {}", e))?;
// Note: Instead of using `?` above, we can use `and_then` to wrap the let
// expression below.
let conf_val = parse_config(conf_str)
https://riptutorial.com/es/home 82

-- 96 of 188 --

.map(|Config(v)| v / 2) // map can be used to map just the Ok value
.map_err(|_| "Failed to parse the config string!".to_string())?;
// Run...
Ok(())
}
fn main() {
match run() {
Ok(_) => println!("Bye!"),
Err(e) => println!("Error: {}", e),
}
}
fn get_local_config_path() -> String {
let user_config_prefix = "/home/user/.config";
// code to get the user config directory
format!("{}/my_app.rc", user_config_prefix)
}
fn get_global_config_path() -> String {
let global_config_prefix = "/etc";
// code to get the global config directory
format!("{}/my_app.rc", global_config_prefix)
}
Si los archivos de configuración no existen, esto genera:
Error: Failed to read config file: No such file or directory (os error 2)
Si falla el análisis, esto genera:
Error: Failed to parse the config string!
Nota: A medida que el proyecto crezca, será incómodo manejar los errores con estos métodos
básicos ( documentos ) sin perder información sobre el origen y la ruta de propagación de los
errores. Además, definitivamente es una mala práctica convertir errores en cadenas
prematuramente para manejar múltiples tipos de errores como se muestra arriba. Una forma
mucho mejor es usar la error-chain la caja.
Tipos de error personalizados
use std::error::Error;
use std::fmt;
use std::convert::From;
use std::io::Error as IoError;
use std::str::Utf8Error;
#[derive(Debug)] // Allow the use of "{:?}" format specifier
enum CustomError {
Io(IoError),
Utf8(Utf8Error),
Other,
}
https://riptutorial.com/es/home 83

-- 97 of 188 --

// Allow the use of "{}" format specifier
impl fmt::Display for CustomError {
fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
match *self {
CustomError::Io(ref cause) => write!(f, "I/O Error: {}", cause),
CustomError::Utf8(ref cause) => write!(f, "UTF-8 Error: {}", cause),
CustomError::Other => write!(f, "Unknown error!"),
}
}
}
// Allow this type to be treated like an error
impl Error for CustomError {
fn description(&self) -> &str {
match *self {
CustomError::Io(ref cause) => cause.description(),
CustomError::Utf8(ref cause) => cause.description(),
CustomError::Other => "Unknown error!",
}
}
fn cause(&self) -> Option<&Error> {
match *self {
CustomError::Io(ref cause) => Some(cause),
CustomError::Utf8(ref cause) => Some(cause),
CustomError::Other => None,
}
}
}
// Support converting system errors into our custom error.
// This trait is used in `try!`.
impl From<IoError> for CustomError {
fn from(cause: IoError) -> CustomError {
CustomError::Io(cause)
}
}
impl From<Utf8Error> for CustomError {
fn from(cause: Utf8Error) -> CustomError {
CustomError::Utf8(cause)
}
}
Iterando a través de las causas.
A menudo es útil para propósitos de depuración encontrar la causa raíz de un error. Para
examinar un valor de error que implemente std::error::Error :
use std::error::Error;
let orig_error = call_returning_error();
// Use an Option<&Error>. This is the return type of Error.cause().
let mut err = Some(&orig_error as &Error);
// Print each error's cause until the cause is None.
while let Some(e) = err {
println!("{}", e);
https://riptutorial.com/es/home 84

-- 98 of 188 --

err = e.cause();
}
Informes de errores básicos y manejo
Result<T, E> es un tipo de enum que tiene dos variantes: Ok(T) indica una ejecución exitosa con un
resultado significativo de tipo T , y Err(E) indica la ocurrencia de un error inesperado durante la
ejecución, descrito por un valor de tipo E .
enum DateError {
InvalidDay,
InvalidMonth,
}
struct Date {
day: u8,
mont
