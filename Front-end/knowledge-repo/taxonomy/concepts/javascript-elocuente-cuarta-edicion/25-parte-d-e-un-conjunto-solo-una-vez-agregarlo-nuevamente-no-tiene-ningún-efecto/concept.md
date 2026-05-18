# parte d: e un conjunto solo una vez: agregarlo nuevamente no tiene ningún efecto.

## Fuente
javascript-elocuente-cuarta-edicion (Cap. 25)

## Contenido
# parte d: e un conjunto solo una vez: agregarlo nuevamente no tiene ningún efecto.

Escribe una clase llamada Group (ya que Set está siendo utilizado). Al igual
que Set, tiene los métodos add, delete y has. Su constructor crea un grupo
vacío, add agrega un valor al grupo (pero solo si aún no es miembro), delete
elimina su argumento del grupo (si era miembro), y has devuelve un valor
booleano que indica si su argumento es miembro del grupo.
Usa el operador ===, o algo equivalente como indexOf, para determinar si
dos valores son iguales.
Dale a la clase un método estático from que tome un objeto iterable como
argumento y cree un grupo que contenga todos los valores producidos al iterar
sobre él.
Grupos iterables
Haz que la clase Group del ejercicio anterior sea iterable. Refiérete a la sección
sobre la interfaz del iterador anteriormente en el capítulo si no tienes claro la
forma exacta de la interfaz.
Si utilizaste un array para representar los miembros del grupo, no devuelvas
simplemente el iterador creado al llamar al método Symbol.iterator en el array.
114

-- 126 of 445 --

Eso funcionaría, pero va en contra del propósito de este ejercicio.
Está bien si tu iterador se comporta de manera extraña cuando el grupo se
modifica durante la iteración.
115

-- 127 of 445 --

“[...] la pregunta de si las Máquinas Pueden Pensar [...] es tan
relevante como la pregunta de si los Submarinos Pueden Nadar.”
—Edsger Dijkstra, Las amenazas a la ciencia informática
Chapter 7
Proyecto: Un Robot
En los capítulos del “proyecto”, dejaré de golpearte con nueva teoría por un
breve momento, y en su lugar trabajaremos en un programa juntos. La teoría
es necesaria para aprender a programar, pero leer y entender programas reales
es igual de importante.
Nuestro proyecto en este capítulo es construir un autómata, un pequeño
programa que realiza una tarea en un mundo virtual. Nuestro autómata será
un robot de entrega de correo que recoge y deja paquetes.
Meadowfield
El pueblo de Meadowfield no es muy grande. Consiste en 11 lugares con 14
carreteras entre ellos. Se puede describir con este array de carreteras:
const roads = [
"Casa de Alice-Casa de Bob","Casa de Alice-Cabaña",
"Casa de Alice-Oficina de Correos","Casa de Bob-Ayuntamiento",
"Casa de Daria-Casa de Ernie","Casa de Daria-Ayuntamiento",
"Casa de Ernie-Casa de Grete","Casa de Grete-Granja",
"Casa de Grete-Tienda","Plaza de Mercado-Granja",
"Plaza de Mercado-Oficina de Correos","Plaza de Mercado-Tienda",
"Plaza de Mercado-Ayuntamiento","Tienda-Ayuntamiento"
];
116

-- 128 of 445 --

La red de carreteras en el pueblo forma un gráfico. Un gráfico es una colección
de puntos (lugares en el pueblo) con líneas entre ellos (carreteras). Este gráfico
será el mundo por el que se moverá nuestro robot.
El array de cadenas no es muy fácil de trabajar. Lo que nos interesa son los
destinos a los que podemos llegar desde un lugar dado. Vamos a convertir la
lista de carreteras en una estructura de datos que, para cada lugar, nos diga
qué se puede alcanzar desde allí.
function buildGraph(edges) {
let graph = Object.create(null);
function addEdge(from, to) {
if (from in graph) {
graph[from].push(to);
} else {
graph[from] = [to];
}
}
for (let [from, to] of edges.map(r => r.split("-"))) {
addEdge(from, to);
addEdge(to, from);
}
return graph;
}
const roadGraph = buildGraph(roads);
Dado un array de aristas, buildGraph crea un objeto de mapa que, para cada
nodo, almacena un array de nodos conectados.
117

-- 129 of 445 --

Utiliza el método split para pasar de las cadenas de carreteras, que tienen
la forma "Inicio-Fin", a arrays de dos elementos que contienen el inicio y el
fin como cadenas separadas.
La tarea
Nuestro robot se moverá por el pueblo. Hay paquetes en varios lugares, cada
uno dirigido a algún otro lugar. El robot recoge los paquetes cuando llega a
ellos y los entrega cuando llega a sus destinos.
El autómata debe decidir, en cada punto, hacia dónde ir a continuación.
Habrá terminado su tarea cuando todos los paquetes hayan sido entregados.
Para poder simular este proceso, debemos definir un mundo virtual que pueda
describirlo. Este modelo nos dice dónde está el robot y dónde están los paque-
tes. Cuando el robot decide moverse a algún lugar, necesitamos actualizar el
modelo para reflejar la nueva situación.
Si estás pensando en términos de programación orientada a objetos, tu primer
impulso podría ser empezar a definir objetos para los diferentes elementos en el
mundo: una clase para el robot, una para un paquete, tal vez una para lugares.
Estos podrían tener propiedades que describen su estado actual, como la pila
de paquetes en un lugar, que podríamos cambiar al actualizar el mundo.
Esto es incorrecto. Al menos, usualmente lo es. El hecho de que algo suene
como un objeto no significa automáticamente que deba ser un objeto en tu
programa. Escribir reflexivamente clases para cada concepto en tu aplicación
tiende a dejarte con una colección de objetos interconectados que tienen su
propio 
