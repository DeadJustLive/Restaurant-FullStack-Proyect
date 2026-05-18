# Ch14 01 release profiles.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 13)

## Contenido
# Ch14 01 release profiles.html

# El Lenguaje de Programación Rust

## Personalizando compilaciones con perfiles de lanzamiento

En Rust, losrelease profilesson perfiles predefinidos y personalizables con
diferentes configuraciones que permiten a un programador tener más control sobre
varias opciones para compilar código. Cada perfil se configura de forma
independiente de los demás.

Cargo tiene dos perfiles principales: el perfildevque Cargo usa cuando
ejecutascargo buildy el perfilreleaseque Cargo usa cuando ejecutascargo build --release. El perfildevestá definido con buenos valores
predeterminados para el desarrollo, y el perfilreleasetiene buenos valores
predeterminados para las compilaciones de lanzamiento.

Estos nombres de perfil pueden ser familiares en la salida de tus compilaciones:

El perfildevyreleaseson estos perfiles diferentes utilizados por el
compilador.

Cargo tiene valores predeterminados para cada uno de los perfiles que se
aplican cuando no has agregado explícitamente ninguna sección[profile.*]en
el archivoCargo.tomldel proyecto. Al agregar secciones[profile.*]para
cualquier perfil que desees personalizar, anularás cualquier subconjunto de los
valores predeterminados. Por ejemplo, aquí están los valores predeterminados
para la configuraciónopt-levelpara los perfilesdevyrelease:

El ajusteopt-levelcontrola la cantidad de optimizaciones que Rust aplicará
a tu código, con un rango de 0 a 3. Aplicar más optimizaciones extiende el
tiempo de compilación, por lo que si estás en desarrollo y compilando tu código
con frecuencia, querrás menos optimizaciones para compilar más rápido, incluso
si el código resultante se ejecuta más lento. Elopt-levelpredeterminado paradeves, por lo tanto,0. Cuando estés listo para lanzar tu código, es mejor
dedicar más tiempo a compilar. Solo compilarás en modo de lanzamiento una vez,
pero ejecutarás el programa compilado muchas veces, por lo que el modo de
lanzamiento intercambia un tiempo de compilación más largo por un código que se
ejecuta más rápido. Es por eso que elopt-levelpredeterminado para el perfilreleasees3.

Puedes anular un ajuste predeterminado agregando un valor diferente para él enCargo.toml. Por ejemplo, si queremos usar el nivel de optimización 1 en el
perfil de desarrollo, podemos agregar estas dos líneas al archivoCargo.tomldel proyecto:

Este código anula la configuración predeterminada de0. Ahora, cuando
ejecutemoscargo build, Cargo usará los valores predeterminados para el perfildevmás nuestra personalización deopt-level. Debido a que establecimosopt-levelen1, Cargo aplicará más optimizaciones que el valor 
predeterminado, pero no tantas como en una compilación de lanzamiento.

Para la lista completa de opciones de configuración y valores predeterminados
para cada perfil, consulta ladocumentación de Cargo.

## Código

```
cargo build
```

```
release
```

```
cargo build --release
```

```
release
```

```
$cargo buildFinished `dev` profile [unoptimized + debuginfo] target(s) in 0.00s$cargo build --releaseFinished `release` profile [optimized] target(s) in 0.32s
```

```
$cargo buildFinished `dev` profile [unoptimized + debuginfo] target(s) in 0.00s$cargo build --releaseFinished `release` profile [optimized] target(s) in 0.32s
```

```
release
```

```typescript
[profile.*]
```

```typescript
[profile.*]
```

```
opt-level
```

```
release
```

```typescript
[profile.dev]opt-level=0[profile.release]opt-level=3
```

```typescript
[profile.dev]opt-level=0[profile.release]opt-level=3
```

```
opt-level
```

```
opt-level
```

```
opt-level
```

```
release
```

```typescript
[profile.dev]opt-level=1
```

```typescript
[profile.dev]opt-level=1
```

```
cargo build
```

```
opt-level
```

```
opt-level
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
- 7.
