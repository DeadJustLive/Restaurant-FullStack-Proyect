# Refactorizando para mejorar la modularidad y el manejo de errores

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 86)

## Contenido
## Refactorizando para mejorar la modularidad y el manejo de errores

### Separacion de preocupaciones para proyectos binarios

#### Extracción del parser de argumentos

#### Agrupación de valores de configuración

### Los intercambios de usarclone

#### Creando un constructor paraConfig

### Arreglando el manejo de errores

#### Mejorando el mensaje de error

#### Devolver unResulten lugar de llamar apanic!

#### Llamando aConfig::buildy manejando errores

### Extrayendo la lógica demain

#### Devolviendo errores desde la funciónrun

#### Manejando errores devueltos porrunenmain

### Dividiendo el código en un crate de biblioteca
