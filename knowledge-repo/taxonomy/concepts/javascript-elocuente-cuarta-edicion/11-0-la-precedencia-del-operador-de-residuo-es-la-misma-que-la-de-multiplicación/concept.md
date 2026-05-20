# 0. La precedencia del operador de residuo es la misma que la de multiplicación

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 11)

## Contenido
# 0. La precedencia del operador de residuo es la misma que la de multiplicación

y división. También verás a menudo a este operador referido como módulo.
Números especiales
Hay tres valores especiales en JavaScript que se consideran números pero no
se comportan como números normales. Los dos primeros son Infinity y -
Infinity, que representan el infinito positivo y negativo. Infinity - 1 sigue
siendo Infinity, y así sucesivamente. Sin embargo, no confíes demasiado en
los cálculos basados en infinito. No es matemáticamente sólido y rápidamente
te llevará al siguiente número especial: NaN.
NaN significa “no es un número”, aunque es un valor del tipo numérico. Ob-
tendrás este resultado cuando, por ejemplo, intentes calcular 0 / 0 (cero divi-
dido por cero), Infinity - Infinity, u cualquier otra operación numérica que
no produzca un resultado significativo.
Cadenas
El siguiente tipo de dato básico es la cadena. Las cadenas se utilizan para
representar texto. Se escriben encerrando su contenido entre comillas.
`En el mar`
"Acostado en el océano"
'Flotando en el océano'
13

-- 25 of 445 --

Puedes usar comillas simples, comillas dobles o acentos graves para marcar
las cadenas, siempre y cuando las comillas al principio y al final de la cadena
coincidan.
Puedes poner casi cualquier cosa entre comillas para que JavaScript genere
un valor de cadena a partir de ello. Pero algunos caracteres son más difíciles.
Puedes imaginar lo complicado que sería poner comillas entre comillas, ya que
parecerían el final de la cadena. Saltos de línea (los caracteres que obtienes al
presionar enter) solo se pueden incluir cuando la cadena está entre acentos
graves (\‘).
Para poder incluir dichos caracteres en una cadena, se utiliza la siguiente
notación: una barra invertida (\) dentro de un texto entre comillas indica que
el carácter posterior tiene un significado especial. Esto se llama escapar el
carácter. Una comilla que va precedida por una barra invertida no finalizará la
cadena, sino que formará parte de ella. Cuando un carácter n aparece después
de una barra invertida, se interpreta como un salto de línea. De manera similar,
un t después de una barra invertida significa un carácter de tabulación. Toma
la siguiente cadena:
"Esta es la primera línea\nY esta es la segunda"
Este es el texto real de esa cadena:
Esta es la primera línea
Y esta es la segunda
Por supuesto, hay situaciones en las que deseas que una barra invertida en
una cadena sea simplemente una barra invertida, no un código especial. Si
dos barras invertidas van seguidas, se colapsarán juntas y solo quedará una en
el valor de cadena resultante. Así es como se puede expresar la cadena “Un
carácter de nueva línea se escribe como "\n".”:
"Un carácter de nueva línea se escribe como \"\\n\"."
Las cadenas también deben ser modeladas como una serie de bits para poder
existir dentro de la computadora. La forma en que JavaScript lo hace se basa
en el estándar Unicode. Este estándar asigna un número a prácticamente cada
carácter que puedas necesitar, incluidos los caracteres griegos, árabes, japone-
ses, armenios, y así sucesivamente. Si tenemos un número para cada carácter,
una cadena puede ser descrita por una secuencia de números. Y eso es lo que
hace JavaScript.
Sin embargo, hay una complicación: la representación de JavaScript utiliza
16 bits por elemento de cadena, lo que puede describir hasta 216 caracteres difer-
14

-- 26 of 445 --

entes. Sin embargo, Unicode define más caracteres que eso —aproximadamente
el doble, en este momento. Por lo tanto, algunos caracteres, como muchos
emoji, ocupan dos “posiciones de caracteres” en las cadenas de JavaScript.
Volveremos a esto en el Capítulo 5.
Las cadenas no se pueden dividir, multiplicar o restar. El operador + se
puede usar en ellas, no para sumar, sino para concatenar —unir dos cadenas.
La siguiente línea producirá la cadena "concatenar":
"con" + "cat" + "e" + "nar"
Los valores de cadena tienen una serie de funciones asociadas (métodos) que
se pueden utilizar para realizar otras operaciones con ellos. Hablaré más sobre
esto en el Capítulo 4.
Las cadenas escritas con comillas simples o dobles se comportan de manera
muy similar, la única diferencia radica en qué tipo de comilla necesitas escapar
dentro de ellas. Las cadenas entre acentos graves, generalmente llamadas tem-
plate literals, pueden hacer algunas cosas más. Aparte de poder abarcar varias
líneas, también pueden incrustar otros valores.
`la mitad de 100 es ${100 / 2}`
Cuando escribes algo dentro de ${} en una plantilla literal, su resultado se
calculará, se convertirá en una cadena y se incluirá en esa posición. Este
ejemplo produce “la mitad de 100 es 50”.
Operadores unarios
No todos los operadores son símbolos. Algunos se escriben como palabras. Un
ejemplo es el operador typeof, que produce un valor de cadena que indica el
tipo del valor que le proporcionas.
console.log(typeof 4.5)
// → number
console.log(typeof "x")
// → string
Utilizaremos console.log en ej
