# Capítulo 1:: Empezando con Rust

Observaciones
Rust es un lenguaje de programación de sistemas diseñado para seguridad, velocidad y
concurrencia. Rust tiene numerosas funciones de tiempo de compilación y controles de seguridad
para evitar las carreras de datos y los errores comunes, todo con una sobrecarga mínima de
tiempo de ejecución cero.
Versiones
Estable
Versión Fecha de lanzamiento
1.17.0 2017-04-27
1.16.0 2017-03-16
1.15.1 2017-02-09
1.15.0 2017-02-02
1.14.0 2016-12-22
1.13.0 2016-11-10
1.12.1 2016-10-20
1.12.0 2016-09-30
1.11.0 2016-08-18
1.10.0 2016-07-07
1.9.0 2016-05-26
1.8.0 2016-04-14
1.7.0 2016-03-03
1.6.0 2016-01-21
1.5.0 2015-12-10
1.4.0 2015-10-29
https://riptutorial.com/es/home 2

-- 16 of 188 --

Versión Fecha de lanzamiento
1.3.0 2015-09-17
1.2.0 2015-08-07
1.1.0 2015-06-25
1.0.0 2015-05-15
Beta
Versión Fecha de lanzamiento prevista
1.18.0 2017-06-08
Examples
Uso avanzado de println!
println! (¡y su hermano, print! ) proporciona un mecanismo conveniente para producir e imprimir
texto que contiene datos dinámicos, similar a la familia de funciones printf encuentran en muchos
otros idiomas. Su primer argumento es una cadena de formato , que dicta cómo los otros
argumentos deben imprimirse como texto. La cadena de formato puede contener marcadores de
posición (incluidos en {} ) para especificar que debe producirse una sustitución:
// No substitution -- the simplest kind of format string
println!("Hello World");
// Output: Hello World
// The first {} is substituted with a textual representation of
// the first argument following the format string. The second {}
// is substituted with the second argument, and so on.
println!("{} {} {}", "Hello", true, 42);
// Output: Hello true 42
En este punto, es posible que se pregunte: ¡Cómo se println! ¿Sabes para imprimir el valor
booleano true como la cadena "verdadero"? {} es realmente una instrucción para el formateador
de que el valor se debe convertir en texto usando el rasgo de Display . Este rasgo se implementa
para la mayoría de los tipos de Rust primitivos (cadenas, números, booleanos, etc.) y está
destinado a "salida orientada al usuario". Por lo tanto, el número 42 se imprimirá en decimal como
42, y no, digamos, en binario, que es cómo se almacena internamente.
¿Cómo imprimimos tipos, entonces, que no implementan Display , siendo los ejemplos Slices (
[i32] ), vectores ( Vec<i32> ) u opciones ( Option<&str> )? No hay una clara representación textual
de éstos (p. Ej., Una que podría insertar de forma trivial en una oración). Para facilitar la impresión
de dichos valores, Rust también tiene el rasgo de Debug y el correspondiente marcador de posición
{:?} . De la documentación: "La Debug debe formatear la salida en un contexto de depuración
https://riptutorial.com/es/home 3

-- 17 of 188 --

orientado hacia el programador". Veamos algunos ejemplos:
println!("{:?}", vec!["a", "b", "c"]);
// Output: ["a", "b", "c"]
println!("{:?}", Some("fantastic"));
// Output: Some("fantastic")
println!("{:?}", "Hello");
// Output: "Hello"
// Notice the quotation marks around "Hello" that indicate
// that a string was printed.
Debug también tiene un mecanismo de impresión bonito incorporado, que puede habilitar usando el
modificador # después de los dos puntos:
println!("{:#?}", vec![Some("Hello"), None, Some("World")]);
// Output: [
// Some(
// "Hello"
// ),
// None,
// Some(
// "World"
// )
// ]
Las cadenas de formato le permiten expresar sustituciones bastante complejas :
// You can specify the position of arguments using numerical indexes.
println!("{1} {0}", "World", "Hello");
// Output: Hello World
// You can use named arguments with format
println!("{greeting} {who}!", greeting="Hello", who="World");
// Output: Hello World
// You can mix Debug and Display prints:
println!("{greeting} {1:?}, {0}", "and welcome", Some(42), greeting="Hello");
// Output: Hello Some(42), and welcome
println! y los amigos también te avisarán si estás tratando de hacer algo que no funcionará, en
lugar de estrellarte en el tiempo de ejecución:
// This does not compile, since we don't use the second argument.
println!("{}", "Hello World", "ignored");
// This does not compile, since we don't give the second argument.
println!("{} {}", "Hello");
// This does not compile, since Option type does not implement Display
println!("{}", Some(42));
En su núcleo, las macros de impresión Rust son simplemente envoltorios alrededor del format!
macro, que permite construir una cadena uniendo representaciones textuales de diferentes
https://riptutorial.com/es/home 4

-- 18 of 188 --

valores de datos. Por lo tanto, para todos los ejemplos anteriores, puede sustituir println! para el
format! para almacenar la cadena formateada en lugar de imprimirla:
let x: String = format!("{} {}", "Hello", 42);
assert_eq!(x, "Hello 42");
Salida de consola sin macros
// use Write trait that contains write() function
use std::io::Write;
fn main() {
std::io::stdout().write(b"Hello, world!\n").unwrap();
}
El rasgo std::io::Write está diseñado para objetos que aceptan flujos de bytes. En este
caso, se adquiere un manejador de salida estándar con std::io::stdout() .
•
Write::write() acepta un segmento de bytes ( &[u8] ), que se crea con un literal de cadena
de bytes ( b"<string>" ). Write::write() devuelve un Result<usize, IoError> , que contiene el
número de bytes escritos (en caso de éxito) o un valor de error (en caso de error).
•
La llamada a Result::unwrap() indica que se espera que la llamada sea exitosa (
Result<usize, IoError> -> usize ), y el valor se descarta.
•
Ejemplo minimo
Para escribir el programa tradicional Hello World en Rust, cree un archivo de texto llamado
hello.rs contenga el siguiente código fuente:
fn main() {
println!("Hello World!");
}
Esto define una nueva función llamada main , que no toma parámetros y no devuelve datos. Aquí
es donde su programa comienza a ejecutarse cuando se ejecuta. En su interior, tienes un
println! , que es una macro que imprime texto en la consola.
Para generar una aplicación binaria, invoque el compilador Rust pasándole el nombre del archivo
fuente:
$ rustc hello.rs
El ejecutable resultante tendrá el mismo nombre que el módulo fuente principal, por lo que para
ejecutar el programa en un sistema Linux o MacOS, ejecute:
$ ./hello
Hello World!
https://riptutorial.com/es/home 5

-- 19 of 188 --

En un sistema Windows, ejecute:
C:\Rust> hello.exe
Hello World!
Empezando
Instalación
Antes de poder hacer algo con el lenguaje de programación Rust, deberá adquirirlo, ya sea para
Windows o para usar su terminal en sistemas similares a Unix, donde $ simboliza la entrada en el
terminal:
$ curl https://sh.rustup.rs -sSf | sh
Esto recuperará los archivos necesarios y configurará la última versión de Rust para usted, sin
importar en qué sistema se encuentre. Para más información, vea la página del proyecto .
Nota: Algunas distribuciones de Linux (p. Ej., Arch Linux ) proporcionan el proceso de rustup
como un paquete, que puede instalarse en su lugar. Y aunque muchos sistemas similares a Unix
proporcionan rustc y cargo como paquetes separados, todavía se recomienda usar rustup ya que
hace que sea mucho más fácil administrar múltiples canales de lanzamiento y realizar
compilación cruzada.
Compilador de óxido
Ahora podemos verificar si Rust se instaló con éxito en nuestras computadoras ejecutando el
siguiente comando en nuestro terminal, si está en UNIX, o en el símbolo del sistema, si está en
Windows:
$ rustc --version
Si este comando es exitoso, la versión del compilador de Rust instalado en nuestras
computadoras se mostrará ante nuestros ojos.
Carga
Con Rust viene Cargo , que es una herramienta de compilación utilizada para administrar sus
paquetes y proyectos de Rust . Para asegurarse de que esto también esté presente en su
computadora, ejecute lo siguiente dentro de la consola: la consola se refiere al terminal o al
símbolo del sistema según el sistema en el que esté:
$ cargo --version
https://riptutorial.com/es/home 6

-- 20 of 188 --

Al igual que el comando equivalente para el compilador Rust , este regresará y mostrará la
versión actual de Cargo .
Para crear su primer proyecto de Cargo, puede dirigirse a Cargo .
Alternativamente, puede compilar programas directamente usando rustc como se muestra en el
ejemplo Mínimo .
Lea Empezando con Rust en línea: https://riptutorial.com/es/rust/topic/362/empezando-con-rust
https://riptutorial.com/es/home 7

-- 21 of 188 --