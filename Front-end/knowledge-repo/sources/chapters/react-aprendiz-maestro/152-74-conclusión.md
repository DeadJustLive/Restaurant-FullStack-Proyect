# 7.4 Conclusión

Esta no es más que una forma de aplicar estilos sobre una aplicación de React. Delegar
en clases como hemos hecho hasta ahora puede acarrear problemas a medida que la
aplicación crezca. Éste es el motivo por el cual hay alternativas con las que poder
aplicar estilos a la vez que se resuelve este problema en particular. El capítulo Dando
estilo a React muestra muchas de esas técnicas.
Puede ser una buena idea probar un par de alternativas con el objetivo de encontrar
alguna con la que te encuentes cómodo. Particularmente creo que los Módulos CSS
prometen ser capaces de resolver el problema fundamental de CSS - el problema
de que el ámbito de todo es global. Esta técnica te permite aplicar estilos para cada
componente de forma local.
Ahora que tenemos una aplicación de Notas sencilla funcionando podemos comenzar
a hacer un Kanban completo. Requerirá de un poco de paciencia ya que necesitaremos

-- 81 of 226 --

Dando Estilo a la Aplicación de Notas 64
mejorar la forma en la que estamos gestionando el estado de la aplicación. También
necesitaremos añadir algo de estructura que nos falta y estar seguros de que
podremos arrastrar y soltar notas por aquí y por allá. Todos ellos son objetivos jugosos
para la siguiente parte del libro.

-- 82 of 226 --

II Implementando Kanban
En este apartado convertiremos nuestra aplicación de notas en una aplicación
Kanban. Durante el proceso aprenderás lo más básico de React. Dado que React
es sólo una librería de vistas debatiremos sobre otras tecnologías relacionadas.
Configuraremos una solución con la que gestionar los estados dentro de nuestra
aplicación y también veremos cómo usar React DnD para incluir la funcionalidad
de arrastrar y soltar en el tablero Kanban.

-- 83 of 226 --