# 16.2 Metodologías CSS

¿Qué ocurre cuando tu aplicación comienza a crecer y se añaden nuevos conceptos?
Los selectores CSS son globales. El problema se vuelve incluso peor si tienes que lidiar
con el orden el que se cargan. Si hay varios selectores iguales, la última declaración
es la que gana, a menos que haya un !important en algún lugar. Se vuelve complejo
muy rápidamente.

-- 179 of 226 --

Aplicando Estilo a React 162
Podemos luchar contra este problema haciendo que los selectores sean más espe-
cíficos, usando reglas de nombrado, etc. Esto simplemente retrasa lo inevitable. Ya
que han sido muchas las personas que han combatido contra este problema durante
mucho tiempo, algunas metodologías han emergido.
Particularmente, OOCSS1 (Object-Oriented CSS), SMACSS2 (Scalable and Modular
Approach for CSS), y BEM3 (Block Element Modifier) son bien conocidas. Cada una
de ellas soluciona los problemas de CSS a su propia manera.
BEM
El origen de BEM reside en Yandex. La meta de BEM es la de permitir que existan
componentes reutilizables y compartir código. Sitios como Get BEM4 te pueden
ayudar a entender la metodología con más detalle.
El mantener nombres de clases largos tal y como BEM requiere puede ser duro. Es
por ello que han aparecido varias librerías que pueden hacerlo más sencillo. Para
React, algunas de ellas son react-bem-helper5, react-bem-render6, y bem-react7.
Ten en cuenta que postcss-bem-linter8 te permite analizar tu CSS para ver si cumple
con BEM.