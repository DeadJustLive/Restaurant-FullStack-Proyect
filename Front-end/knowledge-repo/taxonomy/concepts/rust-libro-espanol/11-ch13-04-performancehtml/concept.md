# Ch13 04 performance.html

## Fuente
El Lenguaje de Programación Rust (Libro Oficial en Español) (Cap. 11)

## Contenido
# Ch13 04 performance.html

# El Lenguaje de Programación Rust

## Comparando Performance: Bucles vs. Iteradores

## Resumen

Para determinar si usar loops o iterators, necesitas saber cuál implementación
es más rápida: la versión de la funciónsearchcon unforloop explícito o
la versión con iterators.

Realizamos un benchmark cargando el contenido completo deThe Adventures of
Sherlock Holmesde Sir Arthur Conan Doyle en unStringy buscando la palabratheen el contenido. Aquí están los resultados del benchmark en la versión desearchusando el ciclofory la versión usando iterators:

La versión del iterator fue ligeramente más rápida! No explicaremos el código
del benchmark aquí, porque el punto no es probar que las dos versiones son
equivalentes, sino obtener una idea general de cómo estas dos implementaciones
se comparan en términos de performance.

Para un benchmark más completo, deberías verificar usando varios textos de
varios tamaños como elcontents, diferentes palabras y palabras de diferentes
longitudes como elquery, y todo tipo de otras variaciones. El punto es este:
los iterators, aunque son una abstracción de alto nivel, se compilan a
aproximadamente el mismo código que si hubieras escrito el código de más bajo
nivel tú mismo. Los iterators son una de lasabstracciones de costo cerode
Rust, por lo que queremos decir que el uso de la abstracción no impone ningún
costo adicional en tiempo de ejecución. Esto es análogo a cómo Bjarne
Stroustrup, el diseñador e implementador original de C++, definecero costoen
“Foundations of C++” (2012):

En general, las implementaciones de C++ obedecen el principio de cero costo:
lo que no usas, no pagas. Y además: lo que usas, no podrías codificarlo a
mano mejor.

Como otro ejemplo, el siguiente código es tomado de un decodificador de audio.
El algoritmo de decodificación usa la operación matemática de predicción lineal
para estimar valores futuros basados en una función lineal de las muestras
anteriores. Este código usa un string de iteradores para hacer algunos cálculos
en tres variables en el scope: un slicebufferde datos, un array de 12coefficients, y una cantidad por la cual desplazar datos enqlp_shift. Hemos
declarado las variables dentro de este ejemplo, pero no les hemos dado ningún
valor; aunque este código no tiene mucho sentido fuera de su contexto, sigue
siendo un ejemplo conciso y del mundo real de cómo Rust traduce ideas de alto
nivel a código de bajo nivel.

Para calcular el valor deprediction, este código itera a través de cada uno
de los 12 valores encoefficientsy usa el métodozippara emparejar los
valores de los coeficientes con los 12 valores anteriores enbuffer. Luego,
para cada par, multiplicamos los valores juntos, sumamos todos los resultados y
desplazamos los bits en la sumaqlp_shiftbits a la derecha.

Calculaciones en aplicaciones como decodificadores de audio a menudo priorizan
el performance. Aquí, estamos creando un iterator, usando dos adaptadores, y
luego consumiendo el valor. ¿Qué código ensamblador compilaría este código Rust?
Bueno, a partir de este escrito, compila al mismo ensamblador que escribirías a
mano. No hay ningún ciclo correspondiente a la iteración sobre los valores encoefficients: Rust sabe que hay 12 iteraciones, por lo que “desenrolla” el
ciclo.Desenrollares una optimización que elimina el overhead del código de
control del ciclo y en su lugar genera código repetitivo para cada iteración del
ciclo.

Todos los coeficientes se almacenan en registros, lo que significa que acceder
a los valores es muy rápido. No hay verificaciones de límites en el acceso al
array en tiempo de ejecución. Todas estas optimizaciones que Rust es capaz de
aplicar hacen que el código resultante sea extremadamente eficiente. Ahora que
sabes esto, ¡puedes usar iterators y closures sin miedo! Hacen que el código
parezca de más alto nivel, pero no imponen una penalización de performance en
tiempo de ejecución por hacerlo.

Los closures e iterators son características de Rust inspiradas en ideas de
lenguajes de programación funcionales. Contribuyen a la capacidad de Rust de
expresar claramente ideas de alto nivel a bajo nivel de performance. Las
implementaciones de closures e iterators son tales que el performance en tiempo
de ejecución no se ve afectado. Esto es parte de la meta de Rust de esforzarse
por proveer abstracciones de costo cero.

Ahora que mejoramos la expresividad de nuestro proyecto I/O, veamos algunas
características más decargoque nos ayudarán a compartir el proyecto con el
mundo.

## Código

```
search
```

```
String
```

```
search
```

```
test bench_search_for  ... bench:  19,620,300 ns/iter (+/- 915,700)
test bench_search_iter ... bench:  19,234,900 ns/iter (+/- 657,200)
```

```
test bench_search_for  ... bench:  19,620,300 ns/iter (+/- 915,700)
test bench_search_iter ... bench:  19,234,900 ns/iter (+/- 657,200)
```

```
contents
```

```
buffer
```

```
coefficients
```

```
qlp_shift
```

```
letbuffer: &mut[i32];letcoefficients: [i
