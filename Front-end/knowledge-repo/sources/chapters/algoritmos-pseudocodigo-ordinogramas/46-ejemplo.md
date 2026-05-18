# EJEMPLO

algoritmo Ejemplo_similar_3
variables
entero b = a * 6, a = 4
inicio
escribir( b )
fin
Tanto Ejemplo_similar_1 como Ejemplo_similar_2 son algoritmos que están
escritos correctamente y, en ambos casos, su salida por pantalla es la misma: 24
Sin embargo, el algoritmo Ejemplo_similar_3 no se puede ejecutar, debido a que,
cuando se intenta evaluar la expresión a * 6, ¿quién es a? Debe definirse con anterioridad
a usarse, como sí se ha hecho en el algoritmo Ejemplo_similar_2.
7.4. Comentarios en un algoritmo
En los algoritmos es conveniente escribir comentarios para explicar el diseño y/o
funcionamiento del mismo. Para delimitar los comentarios se pueden utilizar distintos
caracteres:
 ([) y (])
 ({) y (})
 (/*) y (*/)
 ...
En pseudocódigo, en este libro, los comentarios se van a escribir entre los símbolos reservados
barra-asterisco (/*) y asterisco-barra (*/), que son los mismos que se utilizan en lenguaje C.

-- 75 of 180 --

Libro de Algoritmos de “Abrirllave.com” 76 / 180
EJEMPLO Para comentar las secciones del algoritmo Area_de_una_circunferencia
se puede escribir:
/* Cabecera */
algoritmo Area_de_una_circunferencia
/* Declaraciones */
variables
real radio
/* Cuerpo */
inicio
escribir( "Introduzca radio: " )
leer( radio )
escribir( "El área de la circunferencia es: ",
3.141592 * radio ** 2 )
fin
Cuando un algoritmo se convierta –codifique– en un programa, también se podrán escribir los
comentarios en el código fuente de dicho programa. Dichos comentarios no afectarán nunca a
la ejecución del programa. No obstante, serán muy útiles a la hora de querer saber qué hace
un algoritmo (o programa), y cómo lo hace.
Los comentarios de un algoritmo (o programa) forman parte de la documentación del mismo,
pudiendo:
 Informar sobre algunos datos relevantes del algoritmo (autor, fecha de creación, fecha
de última modificación, proyecto en el que se integra, versión...).
 Explicar la utilidad de uno o más tipos de datos, constantes y/o variables.
 Describir el funcionamiento general del algoritmo (o programa).
 Explicar el cometido de una o más instrucciones.
 Etc.

-- 76 of 180 --

Libro de Algoritmos de “Abrirllave.com” 77 / 180