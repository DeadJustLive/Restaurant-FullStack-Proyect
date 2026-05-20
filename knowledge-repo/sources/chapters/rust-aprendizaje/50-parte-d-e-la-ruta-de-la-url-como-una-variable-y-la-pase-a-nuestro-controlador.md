# parte d: e la ruta de la URL como una variable y la pase a nuestro controlador.

La siguiente línea de código es cómo creamos una instancia de Iron, designando nuestro propio
objeto router para administrar nuestras solicitudes de URL. El dominio y el puerto están
codificados en este ejemplo para simplificar.
Iron::new(router).http("localhost:3000").unwrap();
A continuación, declaramos dos funciones en línea que son nuestros manejadores, handler y
query_handler . Ambos se utilizan para demostrar URL fijas y URL variables.
En la segunda función tomamos la variable "query" de la URL que contiene el objeto de solicitud,
y la enviamos de vuelta al usuario como respuesta.
https://riptutorial.com/es/home 91

-- 105 of 188 --

fn handler(_: &mut Request) -> IronResult<Response> {
Ok(Response::with((status::Ok, "OK")))
}
fn query_handler(req: &mut Request) -> IronResult<Response> {
let ref query = req.extensions.get::<Router>()
.unwrap().find("query").unwrap_or("/");
Ok(Response::with((status::Ok, *query)))
}
}
Si ejecutamos este ejemplo, podremos ver el resultado en el navegador web en localhost:3000 .
La raíz del dominio debe responder con "OK" , y cualquier cosa debajo de la raíz debe repetir la
ruta de regreso.
El siguiente paso de este ejemplo podría ser la separación del enrutamiento y el servicio de
páginas estáticas.
Lea Marco web de hierro en línea: https://riptutorial.com/es/rust/topic/8060/marco-web-de-hierro
https://riptutorial.com/es/home 92

-- 106 of 188 --