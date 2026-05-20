# 1.4 React.createElement y JSX

## Fuente
react-aprendiz-maestro (Cap. 26)

## Contenido
# 1.4 React.createElement y JSX

Ya que vamos a trabajar con un DOM Virtual, hay un API de alto nivel13 que nos
permitirá gestionarlo. Este es el aspecto que tiene un componente nativo de React
que utilice el API JavaScript:
const Names = () => {
const names = ['John', 'Jill', 'Jack'];
return React.createElement(
'div',
null,
React.createElement('h2', null, 'Names'),
React.createElement(
'ul',
{ className: 'names' },
names.map(name => {
return React.createElement(
'li',
{ className: 'name' },
name
);
})
10https://github.com/Yomguithereal/react-blessed
11https://projectseptemberinc.gitbooks.io/gl-react/content/
12https://github.com/Flipboard/react-canvas
13https://facebook.github.io/react/docs/top-level-api.html

-- 24 of 226 --

Introducción a React 7
)
);
};
Puesto que es muy largo escribir componentes de esta manera y que son muy difíciles
de leer, la gente por lo general suele preferir utilizar un lenguaje conocido como JSX14
en su lugar. Observa el mismo componente escrito con JSX a continuación:
const Names = () => {
const names = ['John', 'Jill', 'Jack'];
return (
<div>
<h2>Names</h2>
{/* Esto es una lista de nombres */}
<ul className="names">{
names.map(name =>
<li className="name">{name}</li>
)
}</ul>
</div>
);
};
Ahora podemos ver que el componente renderiza un conjunto de nombres dentro
de una lista HTML. Puede que no sea el componente más útil del mundo, pero es
suficiente para ilustrar el concepto básico de qué es JSX. Nos facilita una sintaxis que
parece HTML. También permite escribir JavaScript utilizando las llaves ({}).
Comparado con HTML plano, estamos usando className en lugar de class. Esto se
debe a que el API ha sido inspirado en el nombrado de DOM. Lleva algo de tiempo
acostumbrarse y puede que sufras un shock con JSX15 hasta que comiences a apreciar
esta aproximación. Nos da un nivel extra de validación.
14https://facebook.github.io/jsx/
15https://medium.com/@housecor/react-s-jsx-the-other-side-of-the-coin-2ace7ab62b98

-- 25 of 226 --

Introducción a React 8
HyperScript16 es una alternativa interesante a JSX que brinda un API
JavaScript más cercano al metal. Puedes utilizar la sintaxis con React a
través de hyperscript-helpers17.
Existe una diferencia semántica entre los componentes de React y los
elementos de React. En el ejemplo anterior cada uno de los nodos JSX
puede ser convertido en un elemento. Simplificando, los componentes
pueden tener estado mientras que los elementos son, por naturaleza, más
sencillos. Son objetos puros. Dan Abramov entra en más detalle en en la
siguiente entrada18.
