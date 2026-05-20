# Ch21 00 final project a web server.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 50)

## Contenido
# El Lenguaje de Programación Rust

# Proyecto final: Construyendo un servidor web multithread

Ha sido un largo viaje, pero hemos llegado al final del libro. En este
capítulo, construiremos un proyecto más para demostrar algunos de los
conceptos que cubrimos en los capítulos finales, así como recapitular algunas
lecciones anteriores.

Para nuestro proyecto final, haremos un servidor web que diga "hola" y se vea
como la Figura 21-1 en un navegador web.

Figure 21-1: Nuestro proyecto final compartido

Aquí está nuestro plan para construir el web server:

Antes de comenzar, debemos mencionar dos detalles:

Primero, el método que usaremos no será la mejor manera de construir un 
servidor web con Rust. Los miembros de la comunidad han publicado una serie decrateslistos para producción disponibles encrates.ioque proporcionan servidores web ythread poolsmás completos que los que 
construiremos. Sin embargo, nuestra intención en este capítulo es ayudarte a 
aprender, no tomar el camino fácil. Debido a que Rust es un lenguaje de 
programación de sistemas, podemos elegir el nivel de abstracción con el que 
queremos trabajar y podemos ir a un nivel más bajo de lo que es posible o 
práctico en otros lenguajes.

En segundo lugar, no utilizaremosasyncniawaitaquí. ¡Construir unthread poolya es un desafío suficientemente grande por sí solo, sin agregar 
la tarea de crear un runtime asincrónico! Sin embargo, mencionaremos cómoasyncyawaitpodrían ser aplicables a algunos de los mismos problemas que 
veremos en este capítulo. En última instancia, como señalamos en el Capítulo 17, 
muchosruntimesasincrónicos utilizanthread poolspara gestionar su 
trabajo.

Por lo tanto, escribiremos el servidor HTTP básico y elthread poolmanualmente para que puedas aprender las ideas y técnicas generales detrás de 
loscratesque podrías usar en el futuro.

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
- 10.1.Tipos de Datos Genéricos10.2.Traits: Definiendo Comportamiento Compartido10.3.Validando Referencias con Lifetimes
- 10.1.Tipos de Datos Genéricos
- 10.2.Traits: Definiendo Comportamiento Compartido
- 10.3.Validando Referencias con Lifetimes
- 11.Escribiendo Tests Automatizados
- 11.1.Cómo Escribir Tests11.2.Controlando Cómo Los Tests Son Ejecutados11.3.Organización De Los Tests
- 11.1.Cómo Escribir Tests
- 11.2.Controlando Cómo Los Tests Son Ejecutados
- 11.3.Organización De Los Tests
- 12.Un proyecto de I/O: Construyendo un programa de línea de comandos
- 12.1.Aceptando argumentos de línea de comandos12.2.Leyendo un archivo12.3.Refactorizando para mejorar la modularidad y el manejo de errores12.4.Desarrollando la funcionalidad de la biblioteca con T.D.D.12.5.Trabajando con Va

> [Contenido truncado — consulta el capítulo completo con knowledge read]
