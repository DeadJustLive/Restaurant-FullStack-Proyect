# 16.4 Aproximaciones Basadas en React

## Fuente
react-aprendiz-maestro (Cap. 141)

## Contenido
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
JavaScript. Las animaciones con CSS no funcionarán, es mejor usar alguna otr
