# Capítulo 16:: Introducción a la representación

## Fuente
react-stackoverflow-docs (Cap. 60)

## Contenido
# Capítulo 16:: Introducción a la representación

del lado del servidor
Examples
Componentes de renderizado
Hay dos opciones para representar componentes en el servidor: renderToString y
renderToStaticMarkup .
renderToString
Esto renderizará los componentes React a HTML en el servidor. Esta función también agregará
propiedades de data-react- a elementos HTML, por lo que React on client no tendrá que volver a
generar elementos.
import { renderToString } from "react-dom/server";
renderToString(<App />);
renderToStaticMarkup
Esto convertirá los componentes de React en HTML, pero sin data-react- propiedades de data-
react- , no se recomienda usar componentes que se representarán en el cliente, ya que los
componentes se redireccionarán.
import { renderToStaticMarkup } from "react-dom/server";
renderToStaticMarkup(<App />);
Lea Introducción a la representación del lado del servidor en línea:
https://riptutorial.com/es/reactjs/topic/7478/introduccion-a-la-representacion-del-lado-del-servidor
https://riptutorial.com/es/home 73

-- 83 of 139 --
