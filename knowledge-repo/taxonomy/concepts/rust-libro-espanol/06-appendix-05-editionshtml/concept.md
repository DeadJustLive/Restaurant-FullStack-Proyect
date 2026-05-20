# Appendix 05 editions.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 6)

## Contenido
# El Lenguaje de Programación Rust

## Apéndice E - Ediciones

En el Capítulo 1, viste quecargo newagrega un poco de metadatos a tu archivoCargo.tomlsobre una edición. ¡Este apéndice habla sobre lo que eso significa!

El lenguaje Rust y el compilador tienen un ciclo de lanzamiento de seis semanas,
lo que significa que los usuarios obtienen un flujo constante de nuevas
características. Otros lenguajes de programación lanzan cambios más grandes con
menos frecuencia; Rust lanza actualizaciones más pequeñas con más frecuencia.
Después de un tiempo, todos estos pequeños cambios se suman. Pero de una
versión a otra, puede ser difícil mirar hacia atrás y decir: “Wow, entre Rust
1.10 y Rust 1.31, Rust ha cambiado mucho!”

Cada dos o tres años, el equipo de Rust produce una nuevaediciónde Rust.
Cada edición reúne las características que han aterrizado en un paquete claro
con documentación y herramientas completamente actualizadas. Las nuevas
ediciones se envían como parte del proceso de lanzamiento habitual de seis
semanas.

Las ediciones sirven para diferentes propósitos para diferentes personas:

En el momento de escribir esto, hay cuatro ediciones de Rust disponibles: Rust
2015, Rust 2018, Rust 2021 y Rust 2024. Este libro está escrito utilizando los
modismos de la edición Rust 2024.

La claveeditionenCargo.tomlindica qué edición debe usar el compilador
para su código. Si la clave no existe, Rust usa2015como el valor de la
edición por razones de compatibilidad con versiones anteriores.

Cada proyecto puede optar por una edición que no sea la edición predeterminada
2015. Las ediciones pueden contener cambios incompatibles, como incluir una
nueva palabra clave que entra en conflicto con los identificadores en el código.
Sin embargo, a menos que opte por esos cambios, su código seguirá compilando
incluso cuando actualice la versión del compilador Rust que usa.

Todas las versiones del compilador Rust admiten cualquier edición que existía
antes del lanzamiento de ese compilador, y pueden vincular cajas de cualquier
edición compatible entre sí. Los cambios de edición solo afectan la forma en
que el compilador analiza inicialmente el código. Por lo tanto, si está usando
Rust 2015 y una de sus dependencias usa Rust 2018, su proyecto se compilará y
podrá usar esa dependencia. La situación opuesta, donde su proyecto usa Rust
2018 y una dependencia usa Rust 2015, también funciona.

Para ser claros: la mayoría de las características estarán disponibles en todas
las ediciones. Los desarrolladores que usen cualquier edición de Rust seguirán
viendo mejoras a medida que se realicen nuevos lanzamientos estables. Sin
embargo, en algunos casos, principalmente cuando se agregan nuevas palabras
clave, algunas nuevas características pueden estar disponibles solo en ediciones
posteriores. Deberá cambiar de edición si desea aprovechar dichas
características.

Para más detalles, laGuía de ediciónes un libro completo sobre ediciones que enumera las diferencias entre ediciones
y explica cómo actualizar automáticamente su código a una nueva edición a través
decargo fix.

## Código

```
cargo new
```

```
edition
```

```
cargo fix
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
- 8.1.Almacenando listas de valores con vectores8.2.Almacenando t

> [Contenido truncado — consulta el capítulo completo con knowledge read]
