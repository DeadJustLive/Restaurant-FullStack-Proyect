# Módulo d: e caminos

Escribe un módulo ES, basado en el ejemplo del Capítulo 7, que contenga el
array de caminos y exporte la estructura de datos de gráfico que los representa
como roadGraph. Debería depender de un módulo ./graph.js, que exporta una
función buildGraph que se utiliza para construir el gráfico. Esta función espera
un array de arrays de dos elementos (los puntos de inicio y fin de los caminos).
177

-- 189 of 445 --

Dependencias circulares
Una dependencia circular es una situación en la que el módulo A depende de
B, y B también, directa o indirectamente, depende de A. Muchos sistemas de
módulos simplemente prohíben esto porque, sin importar el orden que elijas
para cargar dichos módulos, no puedes asegurarte de que las dependencias de
cada módulo se hayan cargado antes de que se ejecute.
Los módulos CommonJS permiten una forma limitada de dependencias cícli-
cas. Siempre y cuando los módulos no accedan a la interfaz de cada uno hasta
después de que terminen de cargarse, las dependencias cíclicas están bien.
La función require proporcionada anteriormente en este capítulo admite este
tipo de ciclo de dependencia. ¿Puedes ver cómo maneja los ciclos?
178

-- 190 of 445 --

“¿Quién puede esperar en silencio mientras el barro se asienta?
¿Quién puede permanecer quieto hasta el momento de la acción?”
—Laozi, Tao Te Ching