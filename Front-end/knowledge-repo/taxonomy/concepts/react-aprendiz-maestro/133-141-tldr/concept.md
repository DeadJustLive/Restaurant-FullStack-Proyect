# 14.1 TL;DR

## Fuente
react-aprendiz-maestro (Cap. 133)

## Contenido
# 14.1 TL;DR

• Técnicas básicas de testing, incluido test unitario, test de aceptación, test
basado en propiedades, y test basado en mutaciones.
• Los tests unitarios nos permiten determinar ciertas verdades.
• Los tests de aceptación nos permiten probar aspectos cualitativos de nuestro
sistema.
• Los tests basados en propiedades (echa un vistazo a QuickCheck2) son más
genéricos y nos permiten cubrir un mayor rango de valores con más facilidad.
Esos tests son más difíciles de probar.
• Los tests basados en mutaciones permiten probar los tests. Desafortunadamen-
te, todavía no es una técnica particularmente popular en JavaScript.
• La aplicación3 de Cesar Andreu tiene una buena configuración de test (Mo-
cha/Karma/Istanbul).
• La cobertura del código nos permiten saber qué partes del código no están
siendo probadas. Sin embargo, esto no nos da ninguna medida de la calidad de
nuestros tests.
1https://leanpub.com/survivejs_react
2https://hackage.haskell.org/package/QuickCheck
3https://github.com/cesarandreu/web-app

-- 176 of 226 --

Probando React 159
• React Test Utilities4 nos brinda una buena manera de escribir tests unitarios
para nuestros componentes. Hay APIs más sencillas, como jquense/react-
testutil-query5.
• Alt tiene buenos mecanismos para probar acciones6 y almacenes7.
• El testing te dá confianza, lo cual se convierte en algo particularmente
importante a medida que la base del código crece, ya que se vuelve más difícil
romper cosas sin darte cuenta.
Compra el libro8 para más detalles.
4https://facebook.github.io/react/docs/test-utils.html
5https://github.com/jquense/react-testutil-query
6http://alt.js.org/docs/testing/actions/
7http://alt.js.org/docs/testing/stores/
8https://leanpub.com/survivejs-react

-- 177 of 226 --
