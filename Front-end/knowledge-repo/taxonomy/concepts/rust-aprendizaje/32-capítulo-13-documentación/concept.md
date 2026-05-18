# Capítulo 13:: Documentación

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 32)

## Contenido
# Capítulo 13:: Documentación

Introducción
El compilador de Rust tiene varias funciones útiles para hacer que documentar su proyecto sea
rápido y fácil. Puede usar lints del compilador para imponer la documentación para cada función y
tener pruebas integradas en sus ejemplos.
Sintaxis
/// Comentario de documentación externa (se aplica al artículo a continuación)	•
//! Comentario interno de la documentación (se aplica al elemento adjunto)	•
documento de carga # Genera documentación para esta caja de la biblioteca.	•
cargo doc --open # Genera documentación para esta caja de biblioteca y navegador abierto.	•
cargo doc -p CRATE # Genera documentación solo para la caja especificada.	•
cargo doc --no-deps # Genera documentación para esta biblioteca y no dependencias.	•
Prueba de carga # Ejecuta pruebas unitarias y pruebas de documentación.	•
Observaciones
Esta sección del 'Libro de óxido' puede contener información útil sobre documentación y pruebas
de documentación.
Los comentarios de documentación se pueden aplicar a:
Módulos	•
Estructuras	•
Enums	•
Métodos	•
Funciones	•
Rasgos y métodos de rasgo	•
Examples
Documentación Lints
Para asegurarse de que todos los elementos posibles estén documentados, puede usar el enlace
missing_docs para recibir advertencias / errores del compilador. Para recibir advertencias en toda
la biblioteca, coloque este atributo en su archivo lib.rs :
https://riptutorial.com/es/home 38

-- 52 of 188 --

#![warn(missing_docs)]
También puede recibir errores por falta de documentación con esta pelusa:
#![deny(missing_docs)]
De forma predeterminada, missing_docs , pero puede permitirlos explícitamente con este atributo:
#![allow(missing_docs)]
Puede ser útil colocarlo en un módulo para permitir la documentación faltante de un módulo, pero
negarlo en todos los demás archivos.
Comentarios de documentación
Rust proporciona dos tipos de comentarios de documentación: comentarios de documentación
interna y comentarios de documentación externa. A continuación se proporcionan ejemplos de
cada uno.
Comentarios internos de la documentación
mod foo {
//! Inner documentation comments go *inside* an item (e.g. a module or a
//! struct). They use the comment syntax //! and must go at the top of the
//! enclosing item.
struct Bar {
pub baz: i64
//! This is invalid. Inner comments must go at the top of the struct,
//! and must not be placed after fields.
}
}
Comentarios de documentación externa
/// Outer documentation comments go *outside* the item that they refer to.
/// They use the syntax /// to distinguish them from inner comments.
pub enum Test {
Success,
Fail(Error)
}
Convenciones
/// In documentation comments, you may use **Markdown**.
/// This includes `backticks` for code, *italics* and **bold**.
/// You can add headers in your documentation, like this:
/// # Notes
/// `Foo` is unsuitable for snafucating. Use `Bar` instead.
struct Foo {
...
}
https://riptutorial.com/es/home 39

-- 53 of 188 --

/// It is considered good practice to have examples in your documentation
/// under an "Examples" header, like this:
/// # Examples
/// Code can be added in "fences" of 3 backticks.
///
/// ```
/// let bar = Bar::new();
/// ```
///
/// Examples also function as tests to ensure the examples actually compile.
/// The compiler will automatically generate a main() function and run the
/// example code as a test when cargo test is run.
struct Bar {
...
}
Pruebas de documentacion
El código en la documentación de los comentarios se ejecutará automáticamente por cargo test .
Estos se conocen como "pruebas de documentación" y ayudan a garantizar que sus ejemplos
funcionen y no engañen a los usuarios de su caja.
Puede importar un pariente desde la raíz de la caja (como si hubiera un extern crate mycrate;
oculto extern crate mycrate; en la parte superior del ejemplo)
/// ```
/// use mycrate::foo::Bar;
/// ```
Si su código no se ejecuta correctamente en una prueba de documentación, puede usar el
atributo no_run , así:
/// ```no_run
/// use mycrate::NetworkClient;
/// NetworkClient::login("foo", "bar");
/// ```
También puede indicar que su código debe entrar en pánico, como este:
/// ```should_panic
/// unreachable!();
/// ```
Lea Documentación en línea: https://riptutorial.com/es/rust/topic/4865/documentacion
https://riptutorial.com/es/home 40

-- 54 of 188 --
