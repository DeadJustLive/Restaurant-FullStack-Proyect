# módulo d: e flujo proporciona una API base que facilita la creación de objetos que

implementan la interfaz de flujo.
Para manejar el cuerpo de la solicitud de una solicitud POST, use el objeto de request , que es un
flujo legible. Los flujos de datos se emiten como eventos de data en el objeto de request .
request.on('data', chunk => {
buffer += chunk;
});
request.on('end', () => {
// POST request body is now available as `buffer`
});
Simplemente cree una cadena de búfer vacía y agregue los datos del búfer como se recibieron a
través de data eventos de data .