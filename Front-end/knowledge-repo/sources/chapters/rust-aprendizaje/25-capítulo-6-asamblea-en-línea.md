# Capítulo 6:: Asamblea en línea

Sintaxis
#! [feature (asm)] // ¡Habilita el asm! puerta macro característica	•
asm! (<template>: <output>: <input>: <clobbers>: <options>) // Emitir la plantilla de
ensamblaje proporcionada (por ejemplo, "NOP", "ADD% eax, 4") con las opciones dadas.
•
Examples
El asm! macro
El ensamblaje en línea solo se admitirá en versiones nocturnas de Rust hasta que se estabilice .
Para habilitar el uso del asm! macro, use el siguiente atributo de función en la parte superior del
archivo principal (una puerta de función ):
#![feature(asm)]
Entonces usa el asm! macro en cualquier bloque unsafe :
fn do_nothing() {
unsafe {
asm!("NOP");
}
// asm!("NOP");
// That would be invalid here, because we are no longer in an
// unsafe block.
}
Condicionar compilación en línea de montaje
Use la compilación condicional para asegurarse de que el código solo compile para el conjunto de
instrucciones deseado (como x86 ). De lo contrario, el código podría no ser válido si el programa
se compila para otra arquitectura, como los procesadores ARM.
#![feature(asm)]
// Any valid x86 code is valid for x86_64 as well. Be careful
// not to write x86_64 only code while including x86 in the
// compilation targets!
#[cfg(any(target_arch = "x86", target_arch = "x86_64"))]
fn do_nothing() {
unsafe {
asm!("NOP");
}
}
#[cfg(not(any(target_arch = "x86", target_arch = "x86_64"))]
https://riptutorial.com/es/home 17

-- 31 of 188 --

fn do_nothing() {
// This is an alternative implementation that doesn't use any asm!
// calls. Therefore, it should be safe to use as a fallback.
}
Entradas y salidas
#![feature(asm)]
#[cfg(any(target_arch="x86", target_arch="x86_64"))]
fn subtract(first: i32, second: i32) {
unsafe {
// Output values must either be unassigned (let result;) or mutable.
let result: i32;
// Each value that you pass in will be in a certain register, which
// can be accessed with $0, $1, $2...
//
// The registers are assigned from left to right, so $0 is the
// register containing 'result', $1 is the register containing
// 'first' and $2 is the register containing 'second'.
//
// Rust uses AT&T syntax by default, so the format is:
// SUB source, destination
// which is equivalent to:
// destination -= source;
//
// Because we want to subtract the first from the second,
// we use the 0 constraint on 'first' to use the same
// register as the output.
// Therefore, we're doing:
// SUB second, first
// and getting the value of 'first'
asm!("SUB $2, $0" : "=r"(result) : "0"(first), "r"(second));
println!("{}", result);
}
}
Los códigos de restricción de LLVM se pueden encontrar aquí , pero esto puede variar
dependiendo de la versión de LLVM utilizada por su compilador rustc .
Lea Asamblea en línea en línea: https://riptutorial.com/es/rust/topic/6998/asamblea-en-linea
https://riptutorial.com/es/home 18

-- 32 of 188 --