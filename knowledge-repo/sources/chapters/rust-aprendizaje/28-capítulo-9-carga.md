# Capítulo 9:: Carga

Introducción
Cargo es el administrador de paquetes de Rust, utilizado para administrar cajas (el término de
Rust para bibliotecas / paquetes). En su mayoría, la carga obtiene paquetes de crates.io y puede
administrar árboles de dependencia complejos con requisitos de versión específicos (mediante el
uso de versiones semánticas). La carga también puede ayudar a construir, ejecutar y administrar
proyectos de Rust con cargo build cargo run , cargo run cargo test y cargo test (entre otros
comandos útiles).
Sintaxis
cargo new crate_name [--bin]	•
carga inicial [--bin]	•
construcción de carga [--release]	•
carrera de carga [--release]	•
control de carga	•
prueba de carga	•
banco de carga	•
actualización de carga	•
paquete de carga	•
publicación de carga	•
cargo [un] instalar binary_crate_name	•
búsqueda de carga	•
versión de carga	•
inicio de sesión de api_key	•
Observaciones
En este momento, el subcomando del cargo bench requiere que la versión nocturna del
compilador funcione de manera efectiva.
•
Examples
Crear nuevo proyecto
Biblioteca
cargo new my-library
Esto crea un nuevo directorio llamado my-library contiene el archivo de configuración de carga y
https://riptutorial.com/es/home 27

-- 41 of 188 --

un directorio de origen que contiene un solo archivo de origen de Rust:
my-library/Cargo.toml
my-library/src/lib.rs
Estos dos archivos ya contendrán el esqueleto básico de una biblioteca, por lo que puede hacer
una cargo test (desde el directorio de my-library ) de inmediato para verificar si todo funciona.
Binario
cargo new my-binary --bin
Esto crea un nuevo directorio llamado my-binary con una estructura similar a una biblioteca:
my-binary/Cargo.toml
my-binary/src/main.rs
Esta vez, la cargo habrá configurado un simple binario Hello World que podremos ejecutar de
inmediato con cargo run .
También puede crear el nuevo proyecto en el directorio actual con el subcomando init :
cargo init --bin
Al igual que arriba, elimine la bandera --bin para crear un nuevo proyecto de biblioteca. El
nombre de la carpeta actual se utiliza como nombre del cajón automáticamente.
Construir proyecto
Depurar
cargo build
Lanzamiento
La --release con el indicador --release habilita ciertas optimizaciones del compilador que no se
realizan al construir una compilación de depuración. Esto hace que el código se ejecute más
rápido, pero también alarga un poco más el tiempo de compilación. Para un rendimiento óptimo,
este comando se debe usar una vez que la versión de lanzamiento esté lista.
cargo build --release
https://riptutorial.com/es/home 28

-- 42 of 188 --

Pruebas de carrera
Uso básico
cargo test
Mostrar salida del programa
cargo test -- --nocapture
Ejecutar ejemplo específico
cargo test test_name
Hola programa mundial
Esta es una sesión de shell que muestra cómo crear un programa "Hello world" y ejecutarlo con
Cargo:
$ cargo new hello --bin
$ cd hello
$ cargo run
Compiling hello v0.1.0 (file:///home/rust/hello)
Running `target/debug/hello`
Hello, world!
Después de hacer esto, puede editar el programa abriendo src/main.rs en un editor de texto.
Publicando un cajón
Para publicar una caja en crates.io , debe iniciar sesión con Cargo (consulte ' Conexión de Cargo
a una cuenta de Crates.io ').
Puedes empaquetar y publicar tu caja con los siguientes comandos:
cargo package
cargo publish
Cualquier error en su archivo Cargo.toml se resaltará durante este proceso. Debe asegurarse de
actualizar su versión y de que su archivo .gitignore o Cargo.toml excluye cualquier archivo no
deseado.
Conexión de carga a una cuenta Crates.io
https://riptutorial.com/es/home 29

-- 43 of 188 --

Las cuentas en crates.io se crean al iniciar sesión con GitHub; No puedes registrarte con ningún
otro método.
Para conectar su cuenta de GitHub a crates.io, haga clic en el botón ' Iniciar sesión con GitHub '
en la barra de menú superior y autorice a crates.io para acceder a su cuenta. Esto lo conectará a
crates.io, asumiendo que todo salió bien.
Luego debe encontrar su clave API , que puede encontrar haciendo clic en su avatar, yendo a '
Configuración de la cuenta ' y copiando la línea que se ve así:
cargo login abcdefghijklmnopqrstuvwxyz1234567890rust
Debe pegarse en su terminal / línea de comando y debe autenticarlo con la instalación de cargo
local.
Tenga cuidado con su clave API: debe mantenerse en secreto, como una contraseña, de lo
contrario, sus jaulas podrían ser secuestradas.
Lea Carga en línea: https://riptutorial.com/es/rust/topic/1084/carga
https://riptutorial.com/es/home 30

-- 44 of 188 --