# 9. Muestra el valor de la ubicación de memoria 0.

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 10)

## Contenido
# 9. Muestra el valor de la ubicación de memoria 0.

Aunque eso ya es más legible que la sopa de bits, sigue siendo bastante con-
fusa. Usar nombres en lugar de números para las instrucciones y las ubicaciones
de memoria ayuda:
Establecer “total” en 0.
Establecer “count” en 1.
[bucle]
Establecer “compare” en “count”.
Restar 11 de “compare”.
Si “compare” es cero, continuar en [fin].
Sumar “count” a “total”.
Añadir 1 a “count”.
Continuar en [bucle].
[fin]
Mostrar “total”.
¿Puedes ver cómo funciona el programa en este punto? Las dos primeras líneas
asignan los valores iniciales a dos ubicaciones de memoria: total se utilizará
para construir el resultado de la computación, y count llevará la cuenta del
4

-- 16 of 445 --

número que estamos observando en ese momento. Las líneas que utilizan
compare probablemente sean las más confusas. El programa quiere ver si count
es igual a 11 para decidir si puede dejar de ejecutarse. Debido a que nuestra
máquina hipotética es bastante primitiva, solo puede comprobar si un número
es cero y tomar una decisión en función de ese valor. Por lo tanto, utiliza
la ubicación de memoria etiquetada como compare para calcular el valor de
count - 11 y tomar una decisión basada en ese valor. Las siguientes dos líneas
suman el valor de count al resultado e incrementan count en 1 cada vez que
el programa decide que count aún no es 11. Aquí está el mismo programa en
JavaScript:
let total = 0, count = 1;
while (count <= 10) {
total += count;
count += 1;
}
console.log(total);
// → 55
Esta versión nos proporciona algunas mejoras. Lo más importante es que ya
no es necesario especificar la forma en que queremos que el programa salte
hacia adelante y hacia atrás; la construcción while se encarga de eso. Continúa
ejecutando el bloque (entre llaves) debajo de él siempre y cuando se cumpla la
condición que se le ha dado. Esa condición es count <= 10, lo que significa “el
recuento es menor o igual a 10”. Ya no tenemos que crear un valor temporal y
compararlo con cero, lo cual era simplemente un detalle no interesante. Parte
del poder de los lenguajes de programación es que pueden encargarse de los
detalles no interesantes por nosotros.
Al final del programa, después de que la construcción while haya terminado,
se utiliza la operación console.log para escribir el resultado.
Finalmente, así es como podría verse el programa si tuviéramos a nuestra
disposición las operaciones convenientes rango y suma, que respectivamente
crean una colección de números dentro de un rango y calculan la suma de una
colección de números:
console.log(suma(rango(1, 10)));
// → 55
La moraleja de esta historia es que el mismo programa puede expresarse de
formas largas y cortas, ilegibles y legibles. La primera versión del programa
era extremadamente críptica, mientras que esta última es casi en inglés: registra
(log) la suma del rango de números del 1 al 10. (Veremos en capítulos posteriores
5

-- 17 of 445 --

cómo definir operaciones como suma y rango.)
Un buen lenguaje de programación ayuda al programador al permitirle hablar
sobre las acciones que la computadora debe realizar a un nivel más alto. Ayuda
a omitir detalles, proporciona bloques de construcción convenientes (como
while y console.log), te permite definir tus propios bloques de construcción
(como suma y rango), y hace que esos bloques sean fáciles de componer.
¿Qué es JavaScript?
JavaScript fue introducido en 1995 como una forma de agregar programas a
páginas web en el navegador Netscape Navigator. Desde entonces, el lenguaje
ha sido adoptado por todos los demás navegadores web gráficos principales.
Ha hecho posibles aplicaciones web modernas, es decir, aplicaciones con las
que puedes interactuar directamente sin tener que recargar la página para cada
acción. JavaScript también se utiliza en sitios web más tradicionales para
proporcionar distintas formas de interactividad e ingenio.
Es importante tener en cuenta que JavaScript casi no tiene nada que ver con
el lenguaje de programación llamado Java. El nombre similar fue inspirado por
consideraciones de marketing en lugar de un buen juicio. Cuando se estaba
introduciendo JavaScript, el lenguaje Java se estaba comercializando mucho y
ganaba popularidad. Alguien pensó que era una buena idea intentar aprovechar
este éxito. Ahora estamos atrapados con el nombre.
Después de su adopción fuera de Netscape, se escribió un documento estándar
para describir la forma en que debería funcionar el lenguaje JavaScript para
que las diversas piezas de software que afirmaban soportar JavaScript pudieran
asegurarse de que realmente proporcionaban el mismo lenguaje. Esto se llama
el estándar ECMAScript, según la organización Ecma International que llevó a
cabo la estandarización. En la práctica, los términos ECMAScript y JavaScript
se pueden usar indistintamente, son dos nombres para el mismo lenguaje.
Hay quienes dirán cosas terribles sobre JavaScript. Muchas de esas cosas
son ciertas. Cuando me pidieron que escribiera algo en JavaS
