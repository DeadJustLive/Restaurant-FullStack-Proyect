# Capítulo 17:: JSX

## Fuente
react-stackoverflow-docs (Cap. 61)

## Contenido
# Capítulo 17:: JSX

Observaciones
JSX es un paso de preprocesador que agrega sintaxis XML a JavaScript. Definitivamente,
puedes usar React sin JSX, pero JSX hace que React sea mucho más elegante.
Al igual que XML, las etiquetas JSX tienen un nombre de etiqueta, atributos e hijos. Si un valor de
atributo se incluye entre comillas, el valor es una cadena. De lo contrario, ajuste el valor entre
llaves y el valor es la expresión de JavaScript incluida.
Fundamentalmente, JSX solo proporciona azúcar sintáctica para la función
React.createElement(component, props, ...children) .
Por lo tanto, el siguiente código JSX:
class HelloMessage extends React.Component {
render() {
return <div>Hello {this.props.name}</div>;
}
}
ReactDOM.render(<HelloMessage name="Kalo" />, mountNode);
Compila hasta el siguiente código de JavaScript:
class HelloMessage extends React.Component {
render() {
return React.createElement(
"div",
null,
"Hello ",
this.props.name
);
}
}
ReactDOM.render(React.createElement(HelloMessage, { name: "Kalo" }), mountNode);
En conclusión, tenga en cuenta que la siguiente línea en JSX no es una cadena ni HTML :
const element = <h1>Hello, world!</h1>;
Se llama JSX y es una extensión de sintaxis para JavaScript . JSX puede recordarle un
lenguaje de plantilla, pero viene con todo el poder de JavaScript.
El equipo de React dice en sus documentos que recomiendan usarlo para describir cómo debería
ser la interfaz de usuario.
https://riptutorial.com/es/home 74

-- 84 of 139 --

Examples
Puntales en JSX
Hay varias formas diferentes de especificar props en JSX.
Expresiones de JavaScript
Puedes pasar cualquier expresión de JavaScript como prop, al rodearla con {} . Por ejemplo,
en este JSX:
<MyComponent count={1 + 2 + 3 + 4} />
Dentro de MyComponent , el valor de props.count será 10 , porque se evalúa la expresión 1 + 2 + 3 +
4 .
Si las declaraciones y los bucles no son expresiones en JavaScript, no se pueden usar
directamente en JSX.
Literales de cuerda
Por supuesto, también puedes pasar cualquier string literal como prop . Estas dos expresiones
JSX son equivalentes:
<MyComponent message="hello world" />
<MyComponent message={'hello world'} />
Cuando se pasa un literal de cadena, su valor no se guarda en HTML. Así que estas dos
expresiones JSX son equivalentes:
<MyComponent message="&lt;3" />
<MyComponent message={'<3'} />
Este comportamiento no suele ser relevante. Sólo se menciona aquí para completar.
Valor predeterminado de accesorios
Si no pasa ningún valor para un objeto, el valor predeterminado es true . Estas dos expresiones
JSX son equivalentes:
https://riptutorial.com/es/home 75

-- 85 of 139 --

<MyTextBox autocomplete />
<MyTextBox autocomplete={true} />
Sin embargo, el equipo de React dice que no se recomienda el uso de este documento en sus
documentos, ya que puede confundirse con la abreviatura del objeto ES6 {foo} que es la
abreviatura de {foo: foo} lugar de {foo: true} . Dicen que este comportamiento está ahí para que
coincida con el comportamiento de HTML.
Atributos de propagación
Si ya tiene objetos como objeto y desea pasarlos a JSX, puede usar ... como operador de
extensión para pasar todo el objeto de objetos. Estos dos componentes son equivalentes:
function Case1() {
return <Greeting firstName="Kaloyab" lastName="Kosev" />;
}
function Case2() {
const person = {firstName: 'Kaloyan', lastName: 'Kosev'};
return <Greeting {...person} />;
}
Niños en JSX
En las expresiones JSX que contienen una etiqueta de apertura y una etiqueta de cierre, el
contenido entre esas etiquetas se pasa como un elemento especial: props.children . Hay varias
maneras diferentes de pasar a los niños:
Literales de cuerda
Puede colocar una cadena entre las etiquetas de apertura y cierre y props.children solo será esa
cadena. Esto es útil para muchos de los elementos HTML integrados. Por ejemplo:
<MyComponent>
<h1>Hello world!</h1>
</MyComponent>
Esto es JSX válido, y props.children en MyComponent simplemente será <h1>Hello world!</h1> .
Tenga en cuenta que el HTML no se puede escapar , por lo que generalmente puede escribir
JSX como lo haría con HTML.
Ten en cuenta que en este caso JSX:
elimina los espacios en blanco al principio y al final de una línea;	•
https://riptutorial.com/es/home 76

-- 86 of 139 --

elimina las líneas en blanco;	•
Se eliminan las nuevas líneas adyacentes a las etiquetas;	•
Las nuevas líneas que se producen en medio de cadenas literales se condensan en un solo
espacio.
•
Niños jsx
Puede proporcionar más elementos JSX como los hijos. Esto es útil para mostrar componentes
anidados:
<MyContainer>
<MyFirstComponent />
<MySecondComponent />
</MyContainer>
Puedes mezclar diferentes tipos de niños, así que puedes usar literales de cuerdas junto
con niños JSX . Esta es otra forma en la que JSX es como HTML, de modo que es tanto JSX
válido como HTML válido:
<div>
<h2>Here is a list</h2>
<ul>
<li>Item 1</li>
<li>Item 2</li>
</ul>
</div>
Tenga en cuenta que un componente React no puede devolver varios elementos Re
