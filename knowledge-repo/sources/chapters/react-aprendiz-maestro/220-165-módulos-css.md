# 16.5 Módulos CSS

Como si no hubiera suficientes opciones de estilo para React, hay una más que merece
la pena mencionar. Módulos CSS25 parte de la premisa de que los estilos CSS deben
ser locales por defecto. Los estilos globales deben ser tratadas como un caso especial.
El post The End of Global CSS26 de Mark Dalgleish entra en más detalles sobre esto.
De forma resumida, si se te hace difícil usar estilos globales, tienes que apañártelas
para resolver el mayor problemas de las CSS. Esta aproximación te permite desarro-
llar CSS como hemos estado haciendo hasta ahora, solo que esta vez el ámbito se
reduce a un contexto más seguro y localizado por defecto.
Esto en sí mismo soluciona una gran cantidad de los problemas que las librerias
anteriores trataban de resolver a su propia forma. Si necesitas estilos globales todavía
puedes tenerlos, es probable que queramos tener ciertos estilos que apliquen a alto
nivel, después de todo. Esta vez seremos explícitos en ello.
Para qur te hagas una idea mejor, fíjate en el siguiente ejemplo:
style.css
25https://github.com/css-modules/css-modules
26https://medium.com/seek-ui-engineering/the-end-of-global-css-90d2a4a06284

-- 191 of 226 --

Aplicando Estilo a React 174
.primary {
background: 'green';
}
.warning {
background: 'yellow';
}
.button {
padding: 1em;
}
.primaryButton {
composes: primary button;
}
@media (max-width: 200px) {
.primaryButton {
composes: primary button;
width: 100%;
}
}
button.jsx
import styles from './style.css';
...
<button className=`${styles.primaryButton}`>Confirm</button>
Como puedes ver, esta aproximación trata de encontrar el equilibrio entre aquello que
a la gente le resulta familiar con librerías específicas para React. Es por ello que no

-- 192 of 226 --

Aplicando Estilo a React 175
me sorprende que esta aproximación sea muy popular aunque todavía sea reciente.
Echa un ojo a la demo de CSS Modules de Webpack27 para ver más ejemplos.
Puedes usar procesadores, como Sass, junto con Módulos CSS, en caso de
que busques tener más funcionalidad.
gajus/react-css-modules28 hace que sea más sencillo todavía usar Módulos
CSS con React. Con él, no tendrás que referencia al objeto styles nunca
más, y no estás obligado a poner nombres usando camelCase.
Glen Maddern discute este tema con mucho más detalle en si artículo
llamado CSS Modules - Bienvenidos al Futuro29.