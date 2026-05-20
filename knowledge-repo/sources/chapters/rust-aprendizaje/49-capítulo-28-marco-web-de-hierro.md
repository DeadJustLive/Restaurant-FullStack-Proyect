# Capítulo 28:: Marco web de hierro

Introducción
Iron es un marco web popular para Rust (basado en la biblioteca Hyper de nivel inferior) que
promueve la idea de extensibilidad a través de middleware . Gran parte de la funcionalidad
necesaria para crear un sitio web útil se puede encontrar en el middleware de Iron en lugar de en
la propia biblioteca.
Examples
Sencillo servidor 'Hello'
Este ejemplo envía una respuesta codificada al usuario cuando envía una solicitud de servidor.
extern crate iron;
use iron::prelude::*;
use iron::status;
// You can pass the handler as a function or a closure. In this
// case, we've chosen a function for clarity.
// Since we don't care about the request, we bind it to _.
fn handler(_: &mut Request) -> IronResult<Response> {
Ok(Response::with((status::Ok, "Hello, Stack Overflow")))
}
fn main() {
Iron::new(handler).http("localhost:1337").expect("Server failed!")
}
Al crear un nuevo servidor Iron en este ejemplo, expect detectar cualquier error con un mensaje
de error más descriptivo. En las aplicaciones de producción, maneje el error producido (consulte
la documentación de http() ).
Instalación de hierro
Agregue esta dependencia al archivo Cargo.toml :
[dependencies]
iron = "0.4.0"
Run cargo build y Cargo descargará e instalará la versión especificada de Iron.
Enrutamiento simple con hierro
Este ejemplo proporcionará enrutamiento web básico utilizando Iron.
https://riptutorial.com/es/home 90

-- 104 of 188 --

Para empezar, deberá agregar la dependencia de Iron a su archivo Cargo.toml .
[dependencies]
iron = "0.4.*"
Usaremos la propia librería Router de Iron. Para simplificar, el proyecto Iron proporciona esta
biblioteca como parte de la biblioteca de Iron Core, eliminando cualquier necesidad de agregarla
como una dependencia separada. A continuación, hacemos referencia tanto a la biblioteca Iron
como a la biblioteca Router.
extern crate iron;
extern crate router;
Luego importamos los objetos requeridos para permitirnos administrar el enrutamiento y devolver
una respuesta al usuario.
use iron::{Iron, Request, Response, IronResult};
use iron::status;
use router::{Router};
En este ejemplo, lo mantendremos simple escribiendo la lógica de enrutamiento dentro de nuestra
función main() . Por supuesto, a medida que su aplicación crezca, querrá separar el enrutamiento,
el registro, los problemas de seguridad y otras áreas de su aplicación web. Por ahora, este es un
buen punto de partida.
fn main() {
let mut router = Router::new();
router.get("/", handler, "handler");
router.get("/:query", query_handler, "query_handler");
Repasemos lo que hemos logrado hasta ahora. Actualmente, nuestro programa crea una
instancia de un nuevo objeto de Iron Router y adjunta dos "controladores" a dos tipos de solicitud
de URL: el primero ( "/" ) es la raíz de nuestro dominio, y el segundo ( "/:query" ) es cualquier
ruta debajo de la raiz
Al usar un punto y coma antes de la palabra "consulta", le estamos diciendo a Iron que tome esta