# Capítulo 27:: Teclas en reaccionar

## Fuente
react-stackoverflow-docs (Cap. 71)

## Contenido
# Capítulo 27:: Teclas en reaccionar

Introducción
Las claves en reaccionar se utilizan para identificar una lista de elementos DOM de la misma
jerarquía internamente.
Entonces, si está iterando sobre una matriz para mostrar una lista de elementos li, cada uno de
los elementos li necesita un identificador único especificado por la propiedad clave. Por lo
general, este puede ser el ID de su elemento de base de datos o el índice de la matriz.
Observaciones
Por lo general, no se recomienda usar el índice de matriz como clave cuando la matriz va a
cambiar con el tiempo. De los documentos de React:
Como último recurso, puede pasar el índice del elemento en la matriz como una clave.
Esto puede funcionar bien si los artículos nunca se reordenan, pero los pedidos serán
lentos.
Un buen ejemplo de esto: https://medium.com/@robinpokorny/index-as-a-key-is-an-anti-pattern-
e0349aece318
Examples
Usando el id de un elemento
Aquí tenemos una lista de elementos pendientes que se pasan a los accesorios de nuestro
componente.
Cada elemento tiene una propiedad de texto e id. Imagine que la propiedad id proviene de un
almacén de datos de back-end y es un valor numérico único:
todos = [
{
id: 1,
text: 'value 1'
},
{
id: 2,
text: 'value 2'
},
{
id: 3,
text: 'value 3'
},
{
id: 4,
https://riptutorial.com/es/home 116

-- 126 of 139 --

text: 'value 4'
},
];
Establecemos el atributo clave de cada elemento de la lista iterada en todo-${todo.id} para que
reaccione puede identificarlo internamente:
render() {
const { todos } = this.props;
return (
<ul>
{ todos.map((todo) =>
<li key={ `todo-${todo.id}` }>
{ todo.text }
</li>
}
</ul>
);
}
Usando el índice de matriz
Si no tiene identificadores de base de datos únicos a la mano, también podría usar el índice
numérico de su matriz de la siguiente manera:
render() {
const { todos } = this.props;
return (
<ul>
{ todos.map((todo, index) =>
<li key={ `todo-${index}` }>
{ todo.text }
</li>
}
</ul>
);
}
Lea Teclas en reaccionar en línea: https://riptutorial.com/es/reactjs/topic/9805/teclas-en-
reaccionar
https://riptutorial.com/es/home 117

-- 127 of 139 --
