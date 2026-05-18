# 3.3 Generando los Ids

Habitualmente el problema de generar los ids se resuelve por un backend. Ya que
no tenemos ninguno todavía, en su lugar, vamos a utilizar un estándar conocido
como RFC41222 que nos permitirá generar identificadores únicos. Utilizaremos una
2https://www.ietf.org/rfc/rfc4122.txt

-- 38 of 226 --

Implementando una Aplicación de Notas 21
implementación de Node.js conocida como uuid y su variante uuid.v4 que nos
dará ids tales como 1c8e7a12-0b4c-4f23-938c-00d7161f94fc que, casi con toda
seguridad, serán únicos.
Para utilizar el generador en nuestra aplicación modifícala como sigue:
app/components/Notes.jsx
import React from 'react';
import uuid from 'uuid';
const notes = [
{
id: '4e81fc6e-bfb6-419b-93e5-0242fb6f3f6a',
id: uuid.v4(),
task: 'Learn React'
},
{
id: '11bbffc8-5891-4b45-b9ea-5c99aadf870f',
id: uuid.v4(),
task: 'Do laundry'
}
];
...
Nuestra configuración de desarrollo instalará la dependencia uuid automáticamente.
Una vez que esto haya ocurrido y que la aplicación se haya recargado, todo debería
tener el mismo aspecto. Sin embargo, si pruebas a depurar la aplicación, verás que los
ids cambiarán cada vez que refresques la página. Puedes comprobarlo fácilmente o
bien insertando la línea console.log(notes); o bien usando el comando debugger;3
dentro del componente.
El comando debugger; es especialmente útil ya que le indica al navegador que debe
parar la ejecución. De este modo es posible ver la pila de llamadas y examinar las
3https://developer.mozilla.org/es/docs/Web/JavaScript/Referencia/Sentencias/debugger

-- 39 of 226 --

Implementando una Aplicación de Notas 22
variables que estén disponibles. Es una buena forma de depurar las aplicaciones y
suponer qué está ocurriendo si no estás seguro de cómo funciona algo.
console.log es una alternativa más ligera. Puedes incluso diseñar un sistema de
gestión de logs en torno a él y usar ambas técnicas juntas. Echa un vistazo a MDN4
y a la documentación de Chrome5 para ver el API completo.
Si estás interesado en conocer las matemáticas que se esconden tras la
generación de los id, puedes ver más detalles sobre cómo se hacen estos
cálculos en la Wikipedia6. Verás que la posibilidad de que haya una
colisión es realmente pequeña y que no debemos preocuparnos por ello.