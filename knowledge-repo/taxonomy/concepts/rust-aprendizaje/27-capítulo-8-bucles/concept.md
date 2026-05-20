# Capítulo 8:: Bucles

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 27)

## Contenido
# Capítulo 8:: Bucles

Sintaxis
loop { bloque } // bucle infinito	•
condición { bloque }	•
mientras let patrón = expr { bloque }	•
para el patrón en expr { bloque } // expr debe implementar IntoIterator	•
continuar // saltar al final del cuerpo del bucle, comenzando una nueva iteración si es
necesario
•
romper // detener el bucle	•
' label : loop { block }	•
' label : while condición { bloque }	•
' label : while let pattern = expr { block }	•
' label : para patrón en expr { bloque }	•
continue ' label // salta al final de la etiqueta etiquetada del cuerpo del bucle, iniciando una
nueva iteración si es necesario
•
romper etiqueta // detener la etiqueta etiquetada en bucle	•
Examples
Lo esencial
Hay 4 construcciones en bucle en Rust. Todos los ejemplos a continuación producen el mismo
resultado.
Bucles infinitos
let mut x = 0;
loop {
if x > 3 { break; }
println!("{}", x);
x += 1;
}
https://riptutorial.com/es/home 22

-- 36 of 188 --

Mientras bucles
let mut x = 0;
while x <= 3 {
println!("{}", x);
x += 1;
}
También vea: ¿Cuál es la diferencia entre loop y while true ?
Patrones combinados de patrones
Estos a veces se conocen como while let bucles para la brevedad.
let mut x = Some(0);
while let Some(v) = x {
println!("{}", v);
x = if v < 3 { Some(v + 1) }
else { None };
}
Esto es equivalente a una match dentro de un bloque de loop :
let mut x = Some(0);
loop {
match x {
Some(v) => {
println!("{}", v);
x = if v < 3 { Some(v + 1) }
else { None };
}
_ => break,
}
}
Para loops
En Rust, for loop solo se puede usar con un objeto "iterable" (es decir, debe implementar
IntoIterator ).
for x in 0..4 {
println!("{}", x);
}
Esto es equivalente al siguiente fragmento de código while let :
let mut iter = (0..4).into_iter();
while let Some(v) = iter.next() {
https://riptutorial.com/es/home 23

-- 37 of 188 --

println!("{}", v);
}
Nota: 0..4 devuelve un objeto Range que ya implementa el rasgo Iterator . Por into_iter() tanto,
into_iter() es necesario, pero se mantiene solo para ilustrar for qué sirve. Para una mirada en
profundidad, ver los documentos oficiales for Loops y IntoIterator .
Ver también: iteradores.
Más sobre For Loops
Como se mencionó en Conceptos básicos, podemos usar cualquier cosa que implemente
IntoIterator con el bucle for :
let vector = vec!["foo", "bar", "baz"]; // vectors implement IntoIterator
for val in vector {
println!("{}", val);
}
Rendimiento esperado:
foo
bar
baz
Tenga en cuenta que la iteración sobre el vector de esta manera lo consume (después del bucle
for , el vector no se puede usar de nuevo). Esto se debe a que IntoIterator::into_iter mueve a
self .
IntoIterator también se implementa con &Vec<T> y &mut Vec<T> (obteniendo valores con los tipos &T
y &mut T respectivamente) para que pueda evitar el movimiento del vector simplemente pasándolo
por referencia:
let vector = vec!["foo", "bar", "baz"];
for val in &vector {
println!("{}", val);
}
println!("{:?}", vector);
Tenga en cuenta que val es de tipo &&str , ya que vector es de tipo Vec<&str> .
Control de bucle
Todas las construcciones de bucle permiten el uso de las declaraciones break y continue . Afectan
el bucle inmediato (más interno) que lo rodea.
Control de bucle básico
break termina el bucle:
https://riptutorial.com/es/home 24

-- 38 of 188 --

for x in 0..5 {
if x > 2 { break; }
println!("{}", x);
}
Salida
0
1
2
continue termina la iteración actual temprano.
for x in 0..5 {
if x < 2 { continue; }
println!("{}", x);
}
Salida
2
3
4
Control de bucle avanzado
Ahora, supongamos que tenemos bucles anidados y queremos break hacia el bucle externo.
Luego, podemos usar etiquetas de bucle para especificar a qué bucle se aplica una break o
continue . En el siguiente ejemplo, 'outer es la etiqueta dada al bucle externo.
'outer: for i in 0..4 {
for j in i..i+2 {
println!("{} {}", i, j);
if i > 1 {
continue 'outer;
}
}
println!("--");
}
Salida
0 0
0 1
--
1 1
1 2
--
2 2
3 3
Para i > 1 , el bucle interno se itera sólo una vez y -- no se imprimió.
https://riptutorial.com/es/home 25

-- 39 of 188 --

Nota: No confunda una etiqueta de bucle con una variable de por vida. Las variables de por vida
solo aparecen junto a un & o como un parámetro genérico dentro de <> .
Lea Bucles en línea: https://riptutorial.com/es/rust/topic/955/bucles
https://riptutorial.com/es/home 26

-- 40 of 188 --
