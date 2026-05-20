# 16.3 Procesadores CSS

Procesadores CSS
El CSS plano carece de ciertas funcionalidades que podrían hacer que el mante-
nimiento fuese más sencillo. Considera algo básico como variables, anidamientos,
mixins, operaciones matemáticas o funciones relacionadas con colores. Estaría bien
poder olvidar los prefijos específicos para cada navegador. Son pequeñas cosas con
las que te encuentras pronto y que hacen que sea molesto generar CSS plano.
A veces puede que veas términos como preprocesador o postprocesador. Stefan
Baumgartner9 llama a estas herramientas simplemente procesadores de CSS. La
imagen anterior basada en el trabajo de Stefan muestra el asunto. Las herramientas
operan tanto a nivel de autor como de optimización. Con nivel de autor nos referimos
a que hace que sea fácil escribir CSS. Las características de optimización hacen que
9https://medium.com/@ddprrt/deconfusing-pre-and-post-processing-d68e3bd078a3

-- 182 of 226 --

Aplicando Estilo a React 165
el CSS plano generado esté optimizado para los navegadores.
Lo interesante aquí es que puede que quieras utilizar varios procesadores de CSS.
La imagen de Stefan ilustra cómo puedes escribir CSS fácilmente con Sass y aún así
optimizarlo con PostCSS. Por ejemplo, puede hacer autoprefix de tu código CSS para
que no te tengas que preocupar de poner prefijos por navegador nunca más.
Puedes usar procesadores comunes como Less10, Sass11, Stylus12, o PostCSS13 con
React.
cssnext14 es un plugin de PostCSS que te permite experimentar el futuro ahora. Hay
algunas restricciones , pero puede merecer la pena probarlo. La ventaja de PostCSS
y cssnext es que estarás programando literalmente en el futuro, A medida que los
navegadores mejoren y adopten los estándares no tendrás que preocuparte de hacer
migraciones.
Pros y Contras
Comparado con CSS plano, los procesadores dejan muchas cosa encima de la
mesa. Lidian con ciertas molestias (p.e. el autoprefixing) a medida que mejoran
tu productividad. PostCSS es más granular por definición y te permite utilizar
únicamente las características que necesitas. Los procesadores como Less o Sass son
muy útiles. Ambas aproximaciones pueden ser utilizadas juntas, de tal modo que
puedes apoyarte en Sass y aplicar algunos plugins de PostCSS cuando sea necesario.
En nuestro projecto podemos aprovecharnos de cssnext incluso si no hemos hecho
cambios en nuestro CSS. Gracias al autoprefixing, las esquinas redondeadas de los
carriles se verán mejor en navegadores antiguos. Es más, podemos parametrizar estos
estilos gracias al uso de parámetros.
10http://lesscss.org/
11http://sass-lang.com/
12https://learnboost.github.io/stylus/
13http://postcss.org/
14https://cssnext.github.io/

-- 183 of 226 --

Aplicando Estilo a React 166