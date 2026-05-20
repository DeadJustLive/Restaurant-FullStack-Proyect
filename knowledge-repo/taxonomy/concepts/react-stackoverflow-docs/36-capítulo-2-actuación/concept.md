# Capítulo 2:: Actuación

## Fuente
react-stackoverflow-docs (Cap. 36)

## Contenido
# Capítulo 2:: Actuación

Examples
Lo básico - HTML DOM vs Virtual DOM
HTML DOM es caro
Cada página web se representa internamente como un árbol de objetos. Esta representación se
llama modelo de objeto de documento . Además, es una interfaz de lenguaje neutral que permite
a los lenguajes de programación (como JavaScript) acceder a los elementos HTML.
En otras palabras
El DOM de HTML es un estándar sobre cómo obtener, cambiar, agregar o eliminar
elementos HTML.
Sin embargo, esas operaciones de DOM son extremadamente caras .
Virtual DOM es una solución
Entonces, el equipo de React tuvo la idea de abstraer el DOM de HTML y crear su propio DOM
virtual para calcular el número mínimo de operaciones que necesitamos aplicar en el DOM de
HTML para replicar el estado actual de nuestra aplicación.
El DOM virtual ahorra tiempo de modificaciones innecesarias del DOM.
¿Cómo exactamente?
En cada momento, React tiene el estado de la aplicación representado como un Virtual DOM .
Cada vez que cambia el estado de la aplicación, estos son los pasos que React realiza para
optimizar el rendimiento.
Genere un nuevo DOM virtual que represente el nuevo estado de nuestra aplicación	1.
Compare el antiguo DOM virtual (que representa el actual DOM de HTML) versus el nuevo
DOM virtual
2.
Basado en 2. encuentre el número mínimo de operaciones para transformar el DOM virtual
antiguo (que representa el DOM HTML actual) en el DOM virtual nuevo.
3.
para aprender más sobre eso - lee el algoritmo de diferencia de React	•
Una vez que se encuentran esas operaciones, se asignan a sus operaciones equivalentes
de HTML DOM
4.
https://riptutorial.com/es/home 13

-- 23 of 139 --

recuerde, el DOM virtual es solo una abstracción del DOM de HTML y existe una relación
isomórfica entre ellos
•
Ahora, el número mínimo de operaciones que se han encontrado y transferido a sus
operaciones equivalentes de HTML DOM ahora se aplican directamente al HTML DOM de
la aplicación, lo que ahorra tiempo de modificar el DOM HTML innecesariamente.
5.
Nota: Las operaciones aplicadas en el DOM virtual son baratas, porque el DOM virtual es un
objeto de JavaScript.
Algoritmo de diferencia de React
La generación del número mínimo de operaciones para transformar un árbol en otro tiene una
complejidad en el orden de O (n ^ 3) donde n es el número de nodos en el árbol. React se basa
en dos suposiciones para resolver este problema en un tiempo lineal: O (n)
Dos componentes de la misma clase generarán árboles similares y dos
componentes de clases diferentes generarán árboles diferentes.
1.
Es posible proporcionar una clave única para elementos que sea estable en
diferentes renders.
2.
Para decidir si dos nodos son diferentes, React diferencia 3 casos
Dos nodos son diferentes, si tienen tipos diferentes.	1.
por ejemplo, <div>...</div> es diferente de <span>...</span>	•
Cada vez que dos nodos tienen claves diferentes	2.
por ejemplo, <div key="1">...</div> es diferente de <div key="2">...</div>	•
Además, lo que sigue es crucial y extremadamente importante para entender si desea
optimizar el rendimiento.
Si los [dos nodos] no son del mismo tipo, React ni siquiera intentará hacer coincidir lo
que representan. Solo eliminará el primero del DOM e insertará el segundo.
Este es el por qué
Es muy poco probable que un elemento genere un DOM que se verá como lo que
generaría. En lugar de gastar tiempo tratando de emparejar esas dos estructuras,
React simplemente reconstruye el árbol desde cero.
consejos y trucos
Cuando dos nodos no son del mismo tipo, React no trata de hacerlos coincidir, simplemente
elimina el primer nodo del DOM e inserta el segundo. Por eso dice el primer consejo.
Si te ves alternando entre dos clases de componentes con resultados muy similares, es	1.
https://riptutorial.com/es/home 14

-- 24 of 139 --

posible que desees que sea la misma clase.
Use shouldComponentUpdate para evitar que el componente se vuelva a enviar, si sabe
que no va a cambiar, por ejemplo
2.
shouldComponentUpdate: function(nextProps, nextState) {
return nextProps.id !== this.props.id;
}
Medición de rendimiento con ReactJS
No puedes mejorar algo que no puedes medir . Para mejorar el rendimiento de los
componentes React, debe poder medirlo. ReactJS proporciona herramientas para medir el
rendimiento de montaje anexo. Importe el módulo react-addons-perf para medir el rendimiento
import Perf from 'react-addons-perf' // ES6
var Perf = require('react-addons-perf') // ES5 with npm
var Perf = React.addons.Perf; // ES5 with react-with-addons.js
Puedes usar los siguientes métodos del módulo Perf importado:
Perf.printInclusive ()	•
Perf.printExclusive ()	•
Perf.printWasted ()	•
Perf.printOperations ()	•
Perf.printDOM ()	•
El más importante que necesitará la mayoría del tiempo es Perf.printWasted() que le brinda la
representación tabular del tiempo perdido de su componente individual.
Puede anotar la columna Tiempo perdido en la tabla y mejorar el rendimiento del Componente
utilizando la sección de Consejos y truc
