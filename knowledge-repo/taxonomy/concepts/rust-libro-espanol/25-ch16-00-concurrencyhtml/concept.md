# Ch16 00 concurrency.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 25)

## Contenido
# El Lenguaje de Programación Rust

# Concurrencia sin miedo

Manejar la programación concurrente de forma segura y eficiente es otro de los
principales objetivos de Rust. Laprogramación concurrente, donde diferentes
partes de un programa se ejecutan de forma independiente, y laprogramación
paralela, donde diferentes partes de un programa se ejecutan al mismo tiempo,
son cada vez más importantes a medida que más computadoras aprovechan sus
múltiples procesadores. Históricamente, la programación en estos contextos ha
sido difícil y propensa a errores: ¡Rust espera cambiar eso!

Inicialmente, el equipo de Rust pensó que garantizar la seguridad de la memoria
y prevenir los problemas de concurrencia eran dos desafíos separados que se
resolverían con diferentes métodos. Con el tiempo, el equipo descubrió que los
sistemas de propiedad y tipos son un conjunto de herramientas poderosas para
ayudar a administrar la seguridad de la memoriaylos problemas de
concurrencia. Al aprovechar la propiedad y la comprobación de tipos, muchos
errores de concurrencia son errores de tiempo de compilación en Rust en lugar
de errores de tiempo de ejecución. Por lo tanto, en lugar de hacer que pase
mucho tiempo tratando de reproducir las circunstancias exactas en las que se
produce un error de concurrencia en tiempo de ejecución, el código incorrecto
se negará a compilar y presentará un error que explica el problema. Como
resultado, puede corregir su código mientras lo está trabajando en lugar de
potencialmente después de que se haya enviado a producción. Hemos apodado este
aspecto de Rust comoconcurrencia sin miedo. La concurrencia sin miedo le
permite escribir código que no tiene errores sutiles y es fácil de refactorizar
sin introducir nuevos bugs.

Nota: Para simplificar, nos referiremos a muchos de los problemas comoconcurrentesen lugar de ser más precisos y decirconcurrentes y/o
paralelos. Para este capítulo, por favor sustituye mentalmente concurrentes 
y/o paralelos cada vez que usemos concurrentes. En el próximo capítulo, donde 
la distinción es más importante, seremos más específicos.

Muchos lenguajes son dogmáticos sobre las soluciones que ofrecen para manejar
problemas concurrentes. Por ejemplo, Erlang tiene una funcionalidad elegante
para la concurrencia de paso de mensajes, pero solo tiene formas oscuras de
compartir estado entre hilos. Soportar solo un subconjunto de soluciones
posibles es una estrategia razonable para los lenguajes de más alto nivel,
porque un lenguaje de más alto nivel promete beneficios al renunciar a cierto
control para obtener abstracciones. Sin embargo, se espera que los lenguajes de
nivel inferior proporcionen la solución con el mejor rendimiento en cualquier
situación dada y tengan menos abstracciones sobre el hardware. Por lo tanto,
Rust ofrece una variedad de herramientas para modelar problemas de la manera
que sea apropiada para su situación y requisitos.

Aquí están los temas que cubriremos en este capítulo:

- El Lenguaje de Programación Rust
- Prefacio
- Introducción
- 1.Empezando
- 1.1.Instalación1.2.¡Hola, Mundo!1.3.¡Hola, Cargo!
- 1.1.Instalación
- 1.2.¡Hola, Mundo!
- 1.3.¡Hola, Cargo!
- 2.Programando un juego de adivinanzas
- 3.Conceptos Comunes de Programación
- 3.1.Variables y Mutabilidad3.2.Tipos de Datos3.3.Funciones3.4.Comentarios3.5.Flujo de Control
- 3.1.Variables y Mutabilidad
- 3.2.Tipos de Datos
- 3.3.Funciones
- 3.4.Comentarios
- 3.5.Flujo de Control
- 4.Entendiendo el Ownership
- 4.1.¿Qué es el Ownership?4.2.Referencias y Prestamos4.3.El Tipo Slice
- 4.1.¿Qué es el Ownership?
- 4.2.Referencias y Prestamos
- 4.3.El Tipo Slice
- 5.Usando Structs para Estructurar Datos Relacionados
- 5.1.Definiendo e Instanciando Structs5.2.Un Programa de Ejemplo Usando Structs5.3.Sintaxis de Métodos
- 5.1.Definiendo e Instanciando Structs
- 5.2.Un Programa de Ejemplo Usando Structs
- 5.3.Sintaxis de Métodos
- 6.Enums y Pattern Matching
- 6.1.Definiendo un Enum6.2.El operador de control de flujo match6.3.Flujo de Control Conciso con if let y let else
- 6.1.Definiendo un Enum
- 6.2.El operador de control de flujo match
- 6.3.Flujo de Control Conciso con if let y let else
- 7.Administrando Proyectos en Crecimiento con Paquetes, Crates y Módulos
- 7.1.Paquetes y Crates7.2.Definiendo módulos para controlar el scope y la privacidad7.3.Paths para referirse a un item en el árbol de módulos7.4.Incluyendo rutas al Scope con la palabra clave use7.5.Separando Módulos en Diferentes Archivos
- 7.1.Paquetes y Crates
- 7.2.Definiendo módulos para controlar el scope y la privacidad
- 7.3.Paths para referirse a un item en el árbol de módulos
- 7.4.Incluyendo rutas al Scope con la palabra clave use
- 7.5.Separando Módulos en Diferentes Archivos
- 8.Colecciones comunes
- 8.1.Almacenando listas de valores con vectores8.2.Almacenando texto codificado en UTF-8 con Strings8.3.Almacenar Claves con Valores Asociados en HashMaps
- 8.1.Almacenando listas de valores con vectores
- 8.2.Almacenando texto codificado en UT

> [Contenido truncado — consulta el capítulo completo con knowledge read]
