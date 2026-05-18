# Ch14 04 installing binaries.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 16)

## Contenido
# Ch14 04 installing binaries.html

# El Lenguaje de Programación Rust

## Instalando Binarios concargo install

El comandocargo installte permite instalar y usar crates binarios localmente.
Esto no está destinado a reemplazar los paquetes del sistema; está destinado a 
ser una forma conveniente para que los desarrolladores de Rust instalen 
herramientas que otros han compartido encrates.io. Tenga en cuenta que solo puede instalar paquetes que tengan 
objetivos binarios. Unobjetivo binarioes el programa ejecutable que se crea 
si el crate tiene un archivosrc/main.rsu otro archivo especificado como un 
binario, en oposición a un objetivo de biblioteca que no se puede ejecutar por 
sí solo, pero que es adecuado para incluirlo en otros programas. Por lo general, 
las crates tienen información en el archivoREADMEsobre si una crate es una 
biblioteca, tiene un objetivo binario, o ambos.

Todos los binarios instalados concargo installse almacenan en la carpeta
raíz de instalación debin. Si instalaste Rust usandorustup.rsy no tienes
configuraciones personalizadas, este directorio será$HOME/.cargo/bin. 
Asegúrese de que el directorio de instalación esté en su$PATHpara poder 
ejecutar los programas que ha instalado concargo install.

Por ejemplo, en el Capítulo 12, mencionamos que hay una implementación de Rust
de la herramientagrepllamadaripgreppara buscar archivos. Para instalarripgrep, podemos ejecutar lo siguiente:

La penúltima línea de la salida muestra la ubicación y el nombre del binario
instalado, que en el caso deripgrepesrg. Mientras el directorio de
instalación esté en su$PATH, como se mencionó anteriormente, puede ejecutarrg --helpy comenzar a usar una herramienta más rápida y oxidada para buscar
archivos!

## Código

```
cargo install
```

```
cargo install
```

```
cargo install
```

```
cargo install
```

```
ripgrep
```

```
ripgrep
```

```
$cargo install ripgrepUpdating crates.io index
  Downloaded ripgrep v14.1.1
  Downloaded 1 crate (213.6 KB) in 0.40s
  Installing ripgrep v14.1.1
--snip--
   Compiling grep v0.3.2
    Finished `release` profile [optimized + debuginfo] target(s) in 6.73s
  Installing ~/.cargo/bin/rg
   Installed package `ripgrep v14.1.1` (executable `rg`)
```

```
$cargo install ripgrepUpdating crates.io index
  Downloaded ripgrep v14.1.1
  Downloaded 1 crate (213.6 KB) in 0.40s
  Installing ripgrep v14.1.1
--snip--
   Compiling grep v0.3.2
    Finished `release` profile [optimized + debuginfo] target(s) in 6.73s
  Installing ~/.cargo/bin/rg
   Installed package `ripgrep v14.1.1` (executable `rg`)
```

```
ripgrep
```

```
rg --help
```

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
- 8.2.Almacenando texto codificado en UTF-8 con Strings
- 8.3.Almacenar Claves con Valores Asociados en HashMaps
- 9.Manejo de Errores
- 9.1.Errores irrecuperables con panic!9.2.Errores recuperables con Result9.3.panic! o no panic!
- 9.1.Errores irrecuperables con panic!
- 9.2.Errores recuperables con Result
- 9.3.panic! o no panic!
- 10.Tipos Genéricos, Traits y Lifetimes
- 10.1.Tipos de Datos Genéricos10
