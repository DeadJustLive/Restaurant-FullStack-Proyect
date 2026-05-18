# Capítulo 4:: Argumentos de línea de comando

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 23)

## Contenido
# Capítulo 4:: Argumentos de línea de comando

Introducción
La biblioteca estándar de Rust no contiene un analizador de argumentos adecuado (a diferencia
de argparse en Python), en lugar de eso prefiere dejarlo en argparse de terceros. Estos ejemplos
mostrarán el uso tanto de la biblioteca estándar (para formar un manejador de argumentos en
bruto) como de la biblioteca de clap , que puede analizar los argumentos de la línea de comandos
con mayor eficacia.
Sintaxis
use std :: env; // Importar el módulo env	•
let args = env :: args (); // Almacena un iterador Args en la variable args.	•
Examples
Usando std :: env :: args ()
Puede acceder a los argumentos de línea de comando pasados a su programa usando la función
std::env::args() . Esto devuelve un iterador Args que puede hacer un bucle o recopilarlo en un Vec
.
Iterando a través de argumentos
use std::env;
fn main() {
for argument in env::args() {
if argument == "--help" {
println!("You passed --help as one of the arguments!");
}
}
}
Recogiendo en un Vec
use std::env;
fn main() {
let arguments: Vec<String> = env::args().collect();
println!("{} arguments passed", arguments.len());
}
Podría obtener más argumentos de los que espera si llama a su programa de esta manera:
./example
https://riptutorial.com/es/home 12

-- 26 of 188 --

Aunque parece que no se pasaron argumentos, el primer argumento es ( generalmente ) el
nombre del ejecutable. Sin embargo, esto no es una garantía, por lo que siempre debe validar y
filtrar los argumentos que obtenga.
Utilizando clap
Para programas de línea de comando más grandes, usar std::env::args() es bastante tedioso y
difícil de administrar. Puede usar clap para manejar su interfaz de línea de comandos, que
analizará los argumentos, generará pantallas de ayuda y evitará errores.
Hay varios patrones que puedes usar con clap , y cada uno proporciona una cantidad diferente de
flexibilidad.
Patrón de constructor
Este es el método más detallado (y flexible), por lo que es útil cuando necesita un control preciso
de su CLI.
clap distingue entre subcomandos y argumentos . Los subcomandos actúan como subprogramas
independientes en su programa principal, al igual cargo run y el git push . Pueden tener sus
propias opciones de línea de comandos y entradas. Los argumentos son indicadores simples
como --verbose , y pueden tomar entradas (por ejemplo, --message "Hello, world" )
extern crate clap;
use clap::{Arg, App, SubCommand};
fn main() {
let app = App::new("Foo Server")
.about("Serves foos to the world!")
.version("v0.1.0")
.author("Foo (@Example on GitHub)")
.subcommand(SubCommand::with_name("run")
.about("Runs the Foo Server")
.arg(Arg::with_name("debug")
.short("D")
.about("Sends debug foos instead of normal foos.")))
// This parses the command-line arguments for use.
let matches = app.get_matches();
// We can get the subcommand used with matches.subcommand(), which
// returns a tuple of (&str, Option<ArgMatches>) where the &str
// is the name of the subcommand, and the ArgMatches is an
// ArgMatches struct:
// https://docs.rs/clap/2.13.0/clap/struct.ArgMatches.html
if let ("run", Some(run_matches)) = app.subcommand() {
println!("Run was used!");
}
}
Lea Argumentos de línea de comando en línea:
https://riptutorial.com/es/rust/topic/7015/argumentos-de-linea-de-comando
https://riptutorial.com/es/home 13

-- 27 of 188 --
