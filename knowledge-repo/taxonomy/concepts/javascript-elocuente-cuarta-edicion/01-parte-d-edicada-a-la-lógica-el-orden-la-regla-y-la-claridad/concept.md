# parte d: edicada a la lógica, el orden, la regla y la claridad.”

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 1)

## Contenido
# parte d: edicada a la lógica, el orden, la regla y la claridad.”

—Ellen Ullman, Cerca de la máquina: Tecnofilia y sus Descontentos
Introducción
Este es un libro sobre cómo instruir a computadoras. Las computadoras son tan
comunes como los destornilladores hoy en día, pero son bastante más complejas,
y hacer que hagan lo que quieres no siempre es fácil.
Si la tarea que tienes para tu computadora es común, bien entendida, como
mostrarte tu correo electrónico o actuar como una calculadora, puedes abrir
la aplicación correspondiente y ponerte a trabajar. Pero para tareas únicas o
abiertas, a menudo no hay una aplicación adecuada.
Ahí es donde entra en juego la programación. Programar es el acto de con-
struir un programa—un conjunto de instrucciones precisas que le dicen a una
computadora qué hacer. Debido a que las computadoras son bestias tontas y
pedantes, programar es fundamentalmente tedioso y frustrante.
Por suerte, si puedes superar ese hecho—e incluso disfrutar del rigor de
pensar en términos que las máquinas tontas pueden manejar—programar puede
ser gratificante. Te permite hacer cosas en segundos que te tomarían una
eternidad a mano. Es una forma de hacer que tu herramienta informática haga
cosas que antes no podía hacer. Además, se convierte en un maravilloso juego
de resolución de acertijos y pensamiento abstracto.
La mayoría de la programación se realiza con lenguajes de programación. Un
lenguaje de programación es un lenguaje artificialmente construido utilizado
para instruir a las computadoras. Es interesante que la forma más efectiva
que hemos encontrado para comunicarnos con una computadora se base tanto
en la forma en que nos comunicamos entre nosotros. Al igual que los idiomas
humanos, los lenguajes informáticos permiten combinar palabras y frases de
nuevas formas, lo que permite expresar conceptos cada vez más nuevos.
En un momento dado, las interfaces basadas en lenguaje, como los prompts
de BASIC y DOS de los años 1980 y 1990, eran el principal método de in-
teractuar con las computadoras. Para el uso informático rutinario, estas se
han reemplazado en gran medida por interfaces visuales, que son más fáciles de
aprender pero ofrecen menos libertad. Pero si sabes dónde buscar, los lenguajes
todavía están ahí. Uno de ellos, JavaScript, está integrado en cada navegador
web moderno—y por lo tanto está disponible en casi todos los dispositivos.
1

-- 13 of 445 --

Este libro intentará que te familiarices lo suficiente con este lenguaje para
hacer cosas útiles y entretenidas con él.
Sobre la programación
Además de explicar JavaScript, presentaré los principios básicos de la progra-
mación. Resulta que programar es difícil. Las reglas fundamentales son simples
y claras, pero los programas construidos sobre estas reglas tienden a volverse lo
suficientemente complejos como para introducir sus propias reglas y compleji-
dades. Estás construyendo tu propio laberinto, de alguna manera, y fácilmente
puedes perderte en él.
Habrá momentos en los que leer este libro resulte terriblemente frustrante.
Si eres nuevo en la programación, habrá mucho material nuevo que asimilar.
Gran parte de este material luego se combinará de maneras que requieren que
hagas conexiones adicionales.
Depende de ti hacer el esfuerzo necesario. Cuando te cueste seguir el libro,
no saques conclusiones precipitadas sobre tus propias capacidades. Estás bien,
simplemente necesitas seguir adelante. Tómate un descanso, vuelve a leer algo
de material y asegúrate de leer y comprender los programas de ejemplo y los
ejercicios. Aprender es un trabajo duro, pero todo lo que aprendas será tuyo y
facilitará aún más el aprendizaje futuro.
Cuando la acción se vuelve poco rentable, recopila información;
cuando la información se vuelve poco rentable, duerme.
Un programa es muchas cosas. Es un trozo de texto escrito por un progra-
mador, es la fuerza directiva que hace que la computadora haga lo que hace, es
información en la memoria de la computadora, y al mismo tiempo controla las
acciones realizadas en esta memoria. Las analogías que intentan comparar los
programas con objetos familiares tienden a quedarse cortas. Una comparación
vagamente adecuada es comparar un programa con una máquina: suelen estar
implicadas muchas partes separadas y, para hacer que todo funcione, debemos
considerar las formas en que estas partes se interconectan y contribuyen a la
operación del conjunto.
Una computadora es una máquina física que actúa como anfitriona de estas
máquinas inmateriales. Las computadoras mismas solo pueden hacer cosas in-
creíblemente sencillas. La razón por la que son tan útiles es que hacen estas
cosas a una velocidad increíblemente alta. Un programa puede combinar inge-
niosamente un número enorme de estas acciones simples para hacer cosas muy
complicadas.
2

-- 14 of 445 --

Un programa es una construcción del pensamiento. Es gratuito de construir,
es liviano y crece fácilmente bajo nuestras manos al teclear. Pero a medida
que un programa c
