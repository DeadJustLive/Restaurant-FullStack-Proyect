# 16.4 Aproximaciones Basadas en React

Existen algunas alternativas extra con React. ¿Qué ocurre si todo lo que habiamos
ideado sobre estilos era erróneo?. CSS es poderoso, pero se puede volver un lío
inmantenible sin algo de disciplina. ¿Dónde podemos trazar la separación entre CSS
y JavaScript?
Hay varias aproximaciones para React que nos permiten aplicar estilos a nivel de
componente. Puede parecer un sacrilegio, pero React, rebelde como es, nos puede
llevar allí.
Estilos en Línea al Rescate
Irónicamente, la forma en la que las soluciones que utilizan React resuelven el
problema de los estilos es a través de estilos en línea. Deshacerse de los estilos en línea
fue una de las principales razones para el uso de múltipls archivos CSS separados,
pero ahora han vuelto. Esto significa que, en vez de tener algo como esto:
render(props, context) {
const notes = this.props.notes;
return <ul className='notes'>{notes.map(this.renderNote)}</ul>;
}
y acompañarlo de CSS, tendremos algo como esto:

-- 184 of 226 --

Aplicando Estilo a React 167
render(props, context) {
const notes = this.props.notes;
const style = {
margin: '0.5em',
paddingLeft: 0,
listStyle: 'none'
};
return <ul style={style}>{notes.map(this.renderNote)}</ul>;
}
Como ocurre con los nombres de los atributos en HTML, usaremos la convención
camel case para las propiedades CSS.
Ahora que estamos aplicando estilos a nivel de componente podemos implementar
la lógica que modifica estos estilos fácilmente. Una forma clásica de hacer esto ha
sido alterar los nombres de las clases basándonos en el aspecto que queremos tener.
Ahora podemos ajustar las propiedades que queramos directamente.
Sin embargo, hemos perdido algo por el camino. Ahora nuestros estilos están
fuertemente ligados a nuestro código JavaScript. Va a ser difícil hacer cambios de
mucha envergadura sobre nuestra base del código ya que vamos a tener que modificar
un montón de componentes para ello.
Podemos tratar de hacer algo para ello inyectando algunos estilos mediante props.
Un estilo puede adaptar su propio estilo basado en uno que reciba. Esto se puede
mejorar más adelante mediante convenciones que permitan que ciertas partes de la
configuración de los estilos lleguen a ciertas partes específicas de los componentes.
Es simplemente reinventar los selectores a una pequeña escala.
¿Qué hacemos con cosas como los media queries?. Esta inocente aproximación no
se encarga de ello. Afortunandamente hay gente que ha desarrollado librerías que
solucionan estos problemas por nosotros.
Según Michele Bertoli las características básicas de estas librerías son
• Autoprefixing - p.e., para border, animation, flex.
• Pseudo clases - p.e., :hover, :active.

-- 185 of 226 --

Aplicando Estilo a React 168
• Media queries - p.e., @media (max-width: 200px).
• Estilos como Objetos - Revisa el ejemplo anterior.
• Extracción de estilos CSS - Es útil para poder partir un fichero CSS grande
en ficheros CSS pequeños que ayuden con la primera carga de la página. Esto
evita que veamos la página sin estilos al entrar (FOUC).
Vamos a ver algunas de las librerías disponibles para que te hagas una idea de cómo
funcionan. Echa un vistazo a la list de Michele15 para tener una mejor visión de la
situación.
Radium
Radium16 tiene algunas ideas valiosas que merece la pena destacar. Lo más impor-
tante es que facilita las abstracciones necesarias para poder lidiar con media queries
y pseudo clases (p.e. :hover). Expande la sintaxis básica como sigue:
const styles = {
button: {
padding: '1em',
':hover': {
border: '1px solid black'
},
'@media (max-width: 200px)': {
width: '100%',
':hover': {
background: 'white',
}
}
},
15https://github.com/MicheleBertoli/css-in-js
16http://projects.formidablelabs.com/radium/

-- 186 of 226 --

Aplicando Estilo a React 169
primary: {
background: 'green'
},
warning: {
background: 'yellow'
},
};
...
<button style={[styles.button, styles.primary]}>Confirm</button>
Para que la propiedad style funcione deberás anotar tus clases usando el decorador
@Radium.
React Style
React Style17 utiliza la misma sintaxis que React Native StyleSheet18. Alarga la
definición básica introduciendo algunas claves adicionales para cada fragmento.
import StyleSheet from 'react-style';
const styles = StyleSheet.create({
primary: {
background: 'green'
},
warning: {
background: 'yellow'
},
button: {
padding: '1em'
},
17https://github.com/js-next/react-style
18https://facebook.github.io/react-native/docs/stylesheet.html#content

-- 187 of 226 --

Aplicando Estilo a React 170
// media queries
'@media (max-width: 200px)': {
button: {
width: '100%'
}
}
});
...
<button styles={[styles.button, styles.primary]}>Confirm</button>
Como puedes ver, podemos uasr fragmentos individuales para tener el mismo efecto
que teniamos con Radium. Además, los media queries también están soportados.
React Style espera que manipules los estados del navegador (p.e. hover) mediante
JavaScript. Las animaciones con CSS no funcionarán, es mejor usar alguna otra
solución para ello.
El plugin de React Style para Webpack19 puede extraer las declaraciones
del CSS en un paquete aparte. Ahora estamos más cerca de lo que ha uti-
lizado todo el mundo, pero no tenemos las cascadas, aunque mantenemos
la declaración de los estilos a nivel de componente.
JSS
JSS20 es un compilador de JSON a hoja de estilos. Puede ser una forma útil de
representar estilos usando estructuras JSON ya que tiene un espacio de nombres
sencillo. También es posible realizar tranformaciones en el JSON para obtener más
funcionalidad, como el autoprefixing. JSS tiene una interfaz para plugins con la que
hacer este tipo de cosas.
JSS puede utilizarse con React a través de react-jss21. Puedes usar react-jss de este
modo:
19https://github.com/js-next/react-style-webpack-plugin
20https://github.com/jsstyles/jss
21https://www.npmjs.com/package/react-jss

-- 188 of 226 --

Aplicando Estilo a React 171
...
import classnames from 'classnames';
import useSheet from 'react-jss';
const styles = {
button: {
padding: '1em'
},
'media (max-width: 200px)': {
button: {
width: '100%'
}
},
primary: {
background: 'green'
},
warning: {
background: 'yellow'
}
};
@useSheet(styles)
export default class ConfirmButton extends React.Component {
render() {
const {classes} = this.props.sheet;
return <button
className={classnames(classes.button, classes.primary)}>
Confirm
</button>;
}
}

-- 189 of 226 --

Aplicando Estilo a React 172
Hay un jss-loader22 para Webpack.
React Inline
React Inline23 es un enfoque intereasnte para aplicar estilos. Genera CSS basado en la
prop className de los elementos que lo usen. El ejemplo anterior puede ser adaptado
para React Inline de esta manera:
import cx from 'classnames';
...
class ConfirmButton extends React.Component {
render() {
const {className} = this.props;
const classes = cx(styles.button, styles.primary, className);
return <button className={classes}>Confirm</button>;
}
}
Por desgracia, se basa en su propia herramienta personalizada para generar código
de React y el CSS que necesita para trabajar.
jsxstyle
El jsxstyle24 de Pete Hunt trata de mitigar algunos de los problemas React Style.
Como has podido ver en los ejemplos anteriores, todavía tenemos las definiciones
de los estilos separadas del lenguaje de marcado de los componentes. jsxstyle une
ambos conceptos. Observa el siguiente ejemplo:
22https://www.npmjs.com/package/jss-loader
23https://github.com/martinandert/react-inline
24https://github.com/petehunt/jsxstyle

-- 190 of 226 --

Aplicando Estilo a React 173
// PrimaryButton component
<button
padding='1em'
background='green'
>Confirm</button>
Esta aproximación todavía está en fase inicial. Por ejemplo, no hay soporte para
media queries. En lugar de definir modificadores como antes, acabarás definiendo
más componentes con los que dar cabida a tus casos de uso.
Al igual que con React Style, jsxstyle tieen un cargador de Webpack que
puede extraer CSS en un fichero separado.