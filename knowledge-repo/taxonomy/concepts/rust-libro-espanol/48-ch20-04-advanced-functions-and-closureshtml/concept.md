# Ch20 04 advanced functions and closures.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 48)

## Contenido
# El Lenguaje de Programación Rust

## Funciones y Closures Avanzados

### Function Pointers

### Retornando Closures

Esta sección cubre algunas características avanzadas relacionadas con
funciones y closures, incluyendo punteros a funciones y retornar closures.

Hemos hablado de cómo pasar closures a funciones; ¡también puedes pasar
funciones regulares a funciones! Esta técnica es útil cuando quieres pasar una
función que ya has definido en lugar de definir un nuevo closure. Las funciones
se coercen al tipofn(con unafminúscula), no confundir con el trait de
cierreFn. El tipofnse llamapuntero a función. Pasar funciones con
punteros a función te permitirá usar funciones como argumentos para otras
funciones.

La sintaxis para especificar que un parámetro es un puntero a función es
similar a la de los closures, como se muestra en el Listado 20-28, donde hemos
definido una funciónadd_oneque suma uno a su parámetro. La funcióndo_twicetoma dos parámetros: un puntero a función a cualquier función que
tome un parámetroi32y devuelva uni32, y un valori32. La funcióndo_twicellama a la funciónfdos veces, pasándole el valorarg, luego
suma los dos resultados de la llamada a la función. La funciónmainllama ado_twicecon los argumentosadd_oney5.

Este código imprimeThe answer is: 12. Especificamos que el parámetrofendo_twicees unfnque toma un parámetro de tipoi32y devuelve uni32.
Luego podemos llamar afen el cuerpo dedo_twice. Enmain, podemos pasar
el nombre de la funciónadd_onecomo el primer argumento ado_twice.

A diferencia de los closures,fnes un tipo en lugar de un trait, por lo que
especificamosfncomo el tipo de parámetro directamente en lugar de declarar
un parámetro de tipo genérico con uno de los traitsFncomo un trait bound.

Los punteros a funciones implementan los tres closure traits (Fn,FnMutyFnOnce), lo que significa que siempre puedes pasar un puntero a función como
un argumento para una función que espera un closure. Es mejor escribir
funciones usando un tipo generic y uno de los closure traits para que tus
funciones puedan aceptar funciones o closures.

Dicho esto, un ejemplo de dónde querrías aceptar solofny no closures es
cuando te comunicas con código externo que no tiene closures: las funciones de
C pueden aceptar funciones como argumentos, pero C no tiene closures.

Como ejemplo de dónde podrías usar un closure definido en línea o una función
nombrada, veamos un uso del métodomapproporcionado por el traitIteratoren la biblioteca estándar. Para usar la funciónmappara convertir un vector
de números en un vector de strings, podríamos usar un closure, como en el 
Listado 20-29:

O podríamos nombrar una función como argumento paramapen lugar del
closure. El Listado 20-30 muestra cómo se vería.

Ten en cuenta que debemos utilizar la sintaxis completamente calificada que
mencionamos anteriormente en la sección“Traits avanzados”

Aquí, estamos usando la funciónto_stringdefinida en el traitToString,
que la biblioteca estándar ha implementado para cualquier tipo que implementeDisplay.

Recuerda la sección“Valores de Enum”del
Capítulo 6, que el nombre de cada variante de enum que definimos también se
convierte en una función inicializadora. Podemos usar estas funciones
inicializadoras como punteros a función que implementan los closure traits,
lo que significa que podemos especificar las funciones inicializadoras como
argumentos para los métodos que toman closures, como puedes ver en el 
Listado 20-31:

Aquí creamos instancias deStatus::Valueusando cada valoru32en el rango
en el que se llama amapusando la función inicializadora deStatus::Value.
A algunas personas les gusta este estilo, y a otras les gusta usar closures.
Compilan al mismo código, así que usa el estilo que sea más claro para ti.

Las closures están representadas por traits, lo que significa que no puedes 
retornar closures directamente. En la mayoría de los casos en los que podrías 
querer devolver un trait, en su lugar puedes usar el tipo concreto que 
implementa el trait como valor de retorno de la función. Sin embargo, no puedes 
hacer eso con closures porque no tienen un tipo concreto que sea retornable; por 
ejemplo, no está permitido usar el puntero a funciónfncomo tipo de retorno.

En su lugar, normalmente usarás la sintaxisimpl Traitque aprendimos en el 
Capítulo 10. Puedes devolver cualquier tipo de función, usandoFn,FnOnceyFnMut. Por ejemplo, el código en el Listado 20-32 funcionará perfectamente.

Sin embargo, como mencionamos en“Inferencia y anotación de tipos en closures”en el Capítulo 13, cada closure también es un tipo distinto por sí mismo. Si 
necesitas trabajar con múltiples funciones que tienen la misma firma pero 
diferentes implementaciones, tendrás que usar un trait object para ellas. 
Considera qué sucede si escribes un código como el que se muestra en el 
Listado 20-33.

Aquí tenemos dos funciones,returns_closureyreturns_initialized_closure, 
que ambas retornanimpl Fn(i32) -> i32. Observa que los closures que devuelven 
son 

> [Contenido truncado — consulta el capítulo completo con knowledge read]
