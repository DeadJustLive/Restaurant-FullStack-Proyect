# 4. Sin embargo, algunos sistemas operativos utilizan no solo un carácter de

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 27)

## Contenido
# 4. Sin embargo, algunos sistemas operativos utilizan no solo un carácter de

nueva línea para separar líneas sino un carácter de retorno de carro seguido
de una nueva línea ("\r\n"). Dado que el método split también permite una
expresión regular como argumento, podemos usar una expresión regular como
/\r?\n/ para dividir de una manera que permita tanto "\n" como "\r\n" entre
líneas.
function parseINI(string) {
// Comenzar con un objeto para contener los campos de nivel
superior
160

-- 172 of 445 --

let result = {};
let section = result;
for (let line of string.split(/\r?\n/)) {
let match;
if (match = line.match(/^(\w+)=(.*)$/)) {
section[match[1]] = match[2];
} else if (match = line.match(/^\[(.*)\]$/)) {
section = result[match[1]] = {};
} else if (!/^\s*(;|$)/.test(line)) {
throw new Error("La línea '" + line + "' no es válida.");
}
};
return result;
}
console.log(parseINI(`
name=Vasilis
[address]
city=Tessaloniki`));
// → {name: "Vasilis", address: {city: "Tessaloniki"}}
El código recorre las líneas del archivo y construye un objeto. Las propiedades
en la parte superior se almacenan directamente en ese objeto, mientras que
las propiedades encontradas en secciones se almacenan en un objeto de sección
separado. El enlace section apunta al objeto para la sección actual.
Hay dos tipos de líneas significativas: encabezados de sección o líneas de
propiedades. Cuando una línea es una propiedad regular, se almacena en la
sección actual. Cuando es un encabezado de sección, se crea un nuevo objeto
de sección y section se establece para apuntar a él.
Observa el uso recurrente de ^ y $ para asegurarse de que la expresión co-
incida con toda la línea, no solo parte de ella. Dejarlos fuera resulta en un
código que funciona en su mayor parte pero se comporta de manera extraña
para algunas entradas, lo que puede ser un error difícil de rastrear.
“‘El patrón if (match = string.match(...)) hace uso del hecho de que el
valor de una expresión de asignación (=) es el valor asignado. A menudo no estás
seguro de que tu llamada a match tendrá éxito, por lo que solo puedes acceder
al objeto resultante dentro de una declaración if que comprueba esto. Para no
romper la agradable cadena de formas de else if, asignamos el resultado de
la coincidencia a un enlace y usamos inmediatamente esa asignación como la
prueba para la declaración if.
Si una línea no es un encabezado de sección o una propiedad, la función
verifica si es un comentario o una línea vacía usando la expresión /^\s*(;|$)/
para hacer coincidir líneas que solo contienen espacio o espacio seguido de un
161

-- 173 of 445 --

punto y coma (haciendo que el resto de la línea sea un comentario). Cuando
una línea no coincide con ninguna de las formas esperadas, la función lanza
una excepción.
Unidades de código y caracteres
Otro error de diseño que se ha estandarizado en las expresiones regulares de
JavaScript es que, por defecto, operadores como . o ? trabajan en unidades
de código, como se discute en el Capítulo 5, no en caracteres reales. Esto
significa que los caracteres que están compuestos por dos unidades de código
se comportan de manera extraña.
console.log(/🍎{3}/.test("🍎🍎🍎"));
// → false
console.log(/<.>/.test("<🌹>"));
// → false
console.log(/<.>/u.test("<🌹>"));
// → true
El problema es que el 🍎 en la primera línea se trata como dos unidades de
código, y la parte {3} se aplica solo al segundo. Del mismo modo, el punto
coincidirá con una sola unidad de código, no con las dos que componen la rosa
emoji.
Debes agregar la opción u (Unicode) a tu expresión regular para que trate
correctamente este tipo de caracteres.
console.log(/🍎{3}/u.test("🍎🍎🍎"));
// → true
Resumen
Las expresiones regulares son objetos que representan patrones en cadenas.
Utilizan su propio lenguaje para expresar estos patrones.
162

-- 174 of 445 --

/abc/ Una secuencia de caracteres
/[abc]/ Cualquier carácter de un conjunto de caracteres
/[^abc]/ Cualquier carácter que no esté en un conjunto de caracteres
/[0-9]/ Cualquier carácter en un rango de caracteres
/x+/ Una o más ocurrencias del patrón x
/x+?/ Una o más ocurrencias, perezoso
/x*/ Cero o más ocurrencias
/x?/ Cero o una ocurrencia
/x{2,4}/ Dos a cuatro ocurrencias
/(abc)/ Un grupo
/a|b|c/ Cualquiera de varias combinaciones de patrones
/\d/ Cualquier carácter de dígito
/\w/ Un carácter alfanumérico (“carácter de palabra”)
/\s/ Cualquier carácter de espacio en blanco
/./ Cualquier carácter excepto saltos de línea
/\p{L}/u Cualquier carácter de letra
/^/ Inicio de entrada
/$/ Fin de entrada
/(?=a)/ Una prueba de vistazo hacia adelante
Una expresión regular tiene un método test para comprobar si una cadena
dada coincide con ella. También tiene un método exec que, cuando se encuentra
una coincidencia, devuelve un array que contiene todos los grupos coincidentes.
Dicho array tiene una propiedad index que indica dónde empezó la coinciden-
cia.Las cadenas tienen un método match para compararlas con una expresión
regular y un método searc
