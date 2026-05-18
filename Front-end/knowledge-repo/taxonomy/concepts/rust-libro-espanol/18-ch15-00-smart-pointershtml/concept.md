# Ch15 00 smart pointers.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 18)

## Contenido
# Ch15 00 smart pointers.html

# El Lenguaje de Programación Rust

# Smart Pointers

Unpunteroes un concepto general para una variable que contiene una dirección
en memoria. Esta dirección se refiere, o “apunta a,” algún otro dato. El tipo
más común de puntero en Rust es una referencia, la cual aprendiste en el
Capítulo 4. Las referencias son indicadas por el símbolo&y toman prestado
el valor al que apuntan. No tienen ninguna capacidad especial más allá de
referirse a datos, y no tienen sobrecarga.

LosSmart pointers,por otro lado, son estructuras de datos que actúan como un
puntero, pero también tienen metadatos y capacidades adicionales. El concepto de
smart pointers no es único de Rust: los smart pointers se originaron en C++ y
existen en otros lenguajes también. Rust tiene una variedad de smart pointers
definidos en la biblioteca estándar que proveen funcionalidad más allá de la
proveída por las referencias. Para explorar el concepto general, veremos un
par de ejemplos diferentes de smart pointers, incluyendo un tipo de punteroreference counting. Este puntero te permite permitir que los datos tengan
múltiples propietarios al mantener un registro del número de propietarios y,
cuando no hay propietarios restantes, limpiar los datos.

Rust, con su concepto de propiedad y préstamo, tiene una diferencia adicional
entre referencias y smart pointers: mientras que las referencias solo toman
prestado los datos, en muchos casos, los smart pointersson dueñosde los
datos a los que apuntan.

Aunque no los llamamos así en ese momento, ya hemos encontrado algunos smart
pointers en este libro, incluyendoStringyVec<T>en el Capítulo 8. Ambos
estos tipos cuentan como smart pointers porque poseen algo de memoria y te
permiten manipularla. También tienen metadatos y capacidades o garantías
adicionales.String, por ejemplo, almacena su capacidad como metadato y tiene
la capacidad adicional de asegurar que sus datos siempre serán UTF-8 válidos.

Los smart pointers usualmente son implementados usando structs. A diferencia de
un struct ordinaria, los smart pointers implementan los traitsDerefyDrop. El traitDerefpermite que una instancia de la struct smart pointer se
comporte como una referencia, así que puedes escribir tu código para trabajar
con referencias o smart pointers. El traitDropte permite personalizar el
código que se ejecuta cuando una instancia del smart pointer sale del scope. En
este capítulo, discutiremos ambos traits y demostraremos por qué son
importantes para los smart pointers.

Dado que el patrón de smart pointer es un patrón de diseño general usado
frecuentemente en Rust, este capítulo no cubrirá todos los smart pointers
existentes. Muchas bibliotecas tienen sus propios smart pointers, e incluso
puedes escribir los tuyos. Cubriremos los smart pointers más comunes en la
biblioteca estándar:

Además, cubriremos el patróninterior mutabilitydonde un tipo inmutable
expone una API para mutar un valor interior. También discutiremosreference
cycles: cómo pueden fugar memoria y cómo prevenirlos.

¡Vamos a profundizar en los smart pointers!

## Código

```
String
```

```
Vec<T>
```

```
String
```

```
Box<T>
```

```
Ref<T>
```

```
RefMut<T>
```

```
RefCell<T>
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
- 8.1.Alm
