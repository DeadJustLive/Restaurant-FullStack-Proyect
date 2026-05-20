# módulo d: ependa menos del formato de entrada.

El módulo roads contiene los datos crudos de las carreteras (el arreglo roads)
y el enlace roadGraph. Este módulo depende de ./graph.js y exporta el grafo
de carreteras.
La clase VillageState se encuentra en el módulo state. Depende del módulo
./roads porque necesita poder verificar que una carretera dada exista. Tam-
bién necesita randomPick. Dado que es una función de tres líneas, podríamos
simplemente ponerla en el módulo state como una función auxiliar interna.
Pero randomRobot también la necesita. Entonces tendríamos que duplicarla o
ponerla en su propio módulo. Dado que esta función existe en NPM en el
paquete random-item, una solución razonable es hacer que ambos módulos de-
pendan de eso. También podemos agregar la función runRobot a este módulo,
ya que es pequeña y está relacionada con la gestión del estado. El módulo
exporta tanto la clase VillageState como la función runRobot.
Finalmente, los robots, junto con los valores en los que dependen, como
mailRoute, podrían ir en un módulo example-robots, que depende de ./roads
y exporta las funciones del robot. Para que goalOrientedRobot pueda realizar la
búsqueda de rutas, este módulo también depende de dijkstrajs.Al externalizar
cierto trabajo a módulos NPM, el código se volvió un poco más pequeño. Cada