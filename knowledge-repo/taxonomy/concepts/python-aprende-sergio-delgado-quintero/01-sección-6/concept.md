# Sección 6

## Fuente
Aprende Python (Cap. 1)

## Contenido
# Sección 6

### 6.4 Módulos . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 286

7 Procesamiento de texto 295
7.1 string . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 296
8 Ciencia de datos 301
8.1 jupyter . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 302
8.2 numpy . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 326
8.3 pandas . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 369
8.4 matplotlib . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 433
9 Scraping 475
9.1 requests . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 476
9.2 beautifulsoup . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 484
9.3 selenium . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 499
ii

-- 4 of 516 --

Aprende Python
Curso gratuito para aprender el lenguaje de programación Python con un enfoque práctico,
incluyendo ejercicios y cobertura para distintos niveles de conocimiento.1
Licencia: GNU General Public License v3.0: GPLv3.
Consejo: «Programming is not about typing, it’s about thinking.» – Rich Hickey
1 En la foto de portada aparecen los Monty Python. Fuente: noticiascyl
Core 1

-- 5 of 516 --

Aprende Python
2 Core

-- 6 of 516 --

### 1.1 Hablando con la máquina

3

-- 7 of 516 --

Aprende Python
Los ordenadores son dispositivos complejos pero están diseñados para hacer una cosa bien:
ejecutar aquello que se les indica. La cuestión es cómo indicar a un ordenador lo que
queremos que ejecute. Esas indicaciones se llaman técnicamente instrucciones y se expresan
en un lenguaje. Podríamos decir que programar consiste en escribir instrucciones para que
sean ejecutadas por un ordenador. El lenguaje que utilizamos para ello se denomina lenguaje
de programación.1
1.1.1 Código máquina
Pero aún seguimos con el problema de cómo hacer que un ordenador (o máquina) entienda
el lenguaje de programación. A priori podríamos decir que un ordenador sólo entiende un
lenguaje muy «simple» denominado código máquina. En este lenguaje se utilizan únicamente
los símbolos 0 y 1 en representación de los niveles de tensión alto y bajo, que al fin y al
cabo, son los estados que puede manejar un circuito digital. Hablamos de sistema binario. Si
tuviéramos que escribir programas de ordenador en este formato sería una tarea ardua, pero
afortunadamente se han ido creando con el tiempo lenguajes de programación intermedios
que, posteriormente, son convertidos a código máquina.
Si intentamos visualizar un programa en código máquina, únicamente obtendríamos una
secuencia de ceros y unos:
00001000 00000010 01111011 10101100 10010111 11011001 01000000 01100010
00110100 00010111 01101111 10111001 01010110 00110001 00101010 00011111
10000011 11001101 11110101 01001110 01010010 10100001 01101010 00001111
11101010 00100111 11000100 01110101 11011011 00010110 10011111 01010110
1.1.2 Ensamblador
El primer lenguaje de programación que encontramos en esta «escalada» es ensamblador.
Veamos un ejemplo de código en ensamblador del típico programa que se escribe por primera
vez, el «Hello, World»:
SYS_SALIDA equ 1
section .data
msg db "Hello, World",0x0a
len equ $ - msg ;longitud de msg
section .text
global _start ;para el linker
_start: ;marca la entrada
mov eax, 4 ;llamada al sistema (sys_write)
(continué en la próxima página)
1 Foto original por Garett Mizunaka en Unsplash.
4 Capítulo 1. Introducción

-- 8 of 516 --

Aprende Python
(proviene de la página anterior)
mov ebx, 1 ;descripción de archivo (stdout)
mov ecx, msg ;msg a escribir
mov edx, len ;longitud del mensaje
int 0x80 ;llama al sistema de interrupciones
fin: mov eax, SYS_SALIDA ;llamada al sistema (sys_exit)
int 0x80
Aunque resulte difícil de creer, lo «único» que hace este programa es mostrar en la pantalla
de nuestro ordenador la frase «Hello, World», pero además teniendo en cuenta que sólo
funcionará para una arquitectura x86.
1.1.3 C
Aunque el lenguaje ensamblador nos facilita un poco la tarea de desarrollar programas, sigue
siendo bastante complicado ya que las instrucciones son muy específicas y no proporcionan
una semántica entendible. Uno de los lenguajes que vino a suplir – en parte – estos obstáculos
fue C. Considerado para muchas personas como un referente en cuanto a los lenguajes de
programación, permite hacer uso de instrucciones más claras y potentes. El mismo ejemplo
anterior del programa «Hello, World» se escribiría así en lenguaje C :
#include <stdio.h>
int main() {
printf("Hello, World");
return 0;
}
1.1.4 Python
Si seguimos «subiendo» en esta lista de lenguajes de programación, podemos llegar hasta
Python. Se dice que es un lenguaje de más alto nivel en el sentido de que sus instrucciones
son más entendibles por un humano. Veamos cómo se escribiría el programa «Hello, World»
en el lenguaje de programación Python:
print( Hello, World )
¡Pues así de fácil! He
