# 10.1 Entendiendo localStorage

localStorage es una parte de Web Storage API. La otra mitad, el sessionStorage,
funciona sólo cuando el navegador está en funcionamiento mientras localStorage
persiste incluso más allá. Ambos comparten el mismo API2 que se muestra a
continuación:
• storage.getItem(k) - Devuelve la cadena de texto almacenada en la clave
enviada como parámetro.
• storage.removeItem(k) - Elimina el dato que coincida con la clave.
• storage.setItem(k, v) - Guarda el valor recibido en base a la clave indicada.
• storage.clear() - Borra el contenido del almacén.
Es conveniente operar con el API utilizando las herramientas de desarrollador del
navegador. En Chrome, la pestaña Recursos es útil y te permite tanto inspeccionar
los datos como realizar operaciones directas contra ellas. Puedes utilizar incluso los
1https://developer.mozilla.org/en/docs/Web/API/Window/localStorage
2https://developer.mozilla.org/en-US/docs/Web/API/Web_Storage_API/Using_the_Web_Storage_API

-- 117 of 226 --

Implementando Persistencia en localStorage 100
atajos storage.key y storage.key = 'value' en la consola para hacer pequeñas
pruebas.
localStorage y sessionStorage pueden utilizar hasta un máximo de 10 MB entre
las dos, que aunque es algo que debería estar bien soportado por los navegadores,
puede fallar.