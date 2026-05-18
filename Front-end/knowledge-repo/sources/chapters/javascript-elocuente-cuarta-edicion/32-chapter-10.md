# Chapter 10

Módulos
Idealmente, un programa tiene una estructura clara y directa. La forma en que
funciona es fácil de explicar, y cada parte desempeña un papel bien definido.
En la práctica, los programas crecen de forma orgánica. Se añaden piezas
de funcionalidad a medida que el programador identifica nuevas necesidades.
Mantener un programa de esta manera bien estructurado requiere atención y
trabajo constantes. Este es un trabajo que solo dará sus frutos en el futuro,
la próxima vez que alguien trabaje en el programa. Por lo tanto, es tentador
descuidarlo y permitir que las diversas partes del programa se enreden profun-
damente.
Esto causa dos problemas prácticos. Primero, entender un sistema enredado
es difícil. Si todo puede afectar a todo lo demás, es difícil ver cualquier pieza en
aislamiento. Te ves obligado a construir una comprensión holística de todo el
conjunto. Segundo, si deseas utilizar alguna funcionalidad de dicho programa
en otra situación, puede ser más fácil reescribirla que intentar desenredarla de
su contexto.
La frase “gran bola de barro” se usa a menudo para tales programas grandes
y sin estructura. Todo se une, y al intentar sacar una pieza, todo el conjunto
se desintegra y solo logras hacer un desastre.
Programas modulares
Los módulos son un intento de evitar estos problemas. Un módulo es una parte
de un programa que especifica en qué otras piezas se basa y qué funcionalidad
proporciona para que otros módulos la utilicen (su interfaz).
Las interfaces de los módulos tienen mucho en común con las interfaces de
objetos, como las vimos en el Capítulo 6. Permiten que una parte del módulo
esté disponible para el mundo exterior y mantienen el resto privado.
Pero la interfaz que un módulo proporciona para que otros la utilicen es
solo la mitad de la historia. Un buen sistema de módulos también requiere
que los módulos especifiquen qué código ellos utilizan de otros módulos. Estas
166

-- 178 of 445 --

relaciones se llaman dependencias. Si el módulo A utiliza funcionalidad del
módulo B, se dice que depende de él. Cuando estas dependencias se especifican
claramente en el propio módulo, se pueden utilizar para averiguar qué otros
módulos deben estar presentes para poder utilizar un módulo dado y cargar
las dependencias automáticamente.
Cuando las formas en que los módulos interactúan entre sí son explícitas, un
sistema se vuelve más como LEGO, donde las piezas interactúan a través de
conectores bien definidos, y menos como barro, donde todo se mezcla con todo.
Módulos ES
El lenguaje original JavaScript no tenía ningún concepto de un módulo. Todos
los scripts se ejecutaban en el mismo ámbito, y acceder a una función definida en
otro script se hacía mediante la referencia a las vinculaciones globales creadas
por ese script. Esto fomentaba activamente el enredo accidental y difícil de
detectar del código e invitaba a problemas como scripts no relacionados que
intentaban usar el mismo nombre de vinculación.
Desde ECMAScript 2015, JavaScript admite dos tipos diferentes de pro-
gramas. Los scripts se comportan de la manera antigua: sus vinculaciones
se definen en el ámbito global y no tienen forma de referenciar directamente
otros scripts. Los módulos obtienen su propio ámbito separado y admiten las
palabras clave import y export, que no están disponibles en los scripts, para
declarar sus dependencias e interfaz. Este sistema de módulos se suele llamar
módulos de ES (donde “ES” significa “ECMAScript”).
Un programa modular está compuesto por varios de estos módulos, conecta-
dos a través de sus importaciones y exportaciones.
Este ejemplo de módulo convierte entre nombres de días y números (como los
devueltos por el método getDay de Date). Define una constante que no forma