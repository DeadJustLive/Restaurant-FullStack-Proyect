# Integraciones: Trabajando con Componentes React

## Fuente
Qwik Framework - Libro en Español (Cap. 20)

## Contenido
# Integraciones: Trabajando con Componentes React

> Fuente: [https://qwik-book-spanish.netlify.app/20-integrations-react](https://qwik-book-spanish.netlify.app/20-integrations-react)

En este capítulo os voy a enseñar a utilizar React dentro de Qwik utilizandoQwik Reactbasándonos en los conocimientos iniciales que hemos adquirido sobre las integraciones que nos proporciona Qwik.

La ventaja principal de utilizarQwik Reactes que vamos a poder utilizar componentes y bibliotecas existentes de React dentro de Qwik, tanto de nuestros proyectos o paquetes NPM que podamos encontrar.

Con esto estaremos dando posibilidad a que podamos migrar a Qwik proyectos React con cierta facilidad.

Obviamente todo depende de la magnitud y complejidad del proyecto aunque con estas claves estaremos más cerca de poder hacerlo.

Esto nos va a permitir aprovechar el gran ecosistema de componentes y bibliotecas de React, como podrían ser entre muchas más opciones:

También podemos aprovecharnos de obtener los beneficios que nos proporciona Qwik sin tener que reescribir completamente nuestra aplicación de React, que esto es un plus por si queremos adaptar un proyecto React a Qwik.

Siguendo todos los pasos que se van a mencionar a continuación conseguiremos aprender las bases para poder usar componentes React de proyectos propios o de librerías de componentes propias o de terceros.

Integrando React en Qwik: Instalación y configuración.

qwikify$— Convierte componentes React en Qwik.

Primer ejemplo Básico — Componente de saludo.

Componente React usando props.

Hidratando un componente React.

Hidratando más de un componente React.

Usar librería React publicada en NPM - I —react-day-picker.

Usar librería React publicada en NPM - II —react-modern-calendar-datepicker.

Al igual que la mayoría de las bibliotecas o frameworks de Frontend de JavaScript, React está utilizando la hidratación, lo que tiene sus desventajas y puede ser más costoso su uso de lo que se podría pensar.

Qwik no necesita hidratación al cargar. Es solo HTML puro. Esto hace que Qwik sea más rápido para cargar las interfaces de usuario, con las cuales los usuarios pueden comenzar a interactuar.

Esto es algo a tener muy en cuenta al considerar incluir componentes de React en tus aplicaciones Qwik.

Qwik Reactes una herramienta que nos va a permitir utilizar componentes de React en Qwik, incluyendo todo el ecosistema de paquetes de componentes como Material UI, Threejs y React Spring entre otras muchas opciones como se ha mencionado al inicio del capítulo.

Antes de comenzar con la integración debemos de tener el proyecto de Qwik creado y listo para iniciarlo con lo básico asignándole el nombre20-integrations-react.

Esto ya lo sabemos hacer y si no, os invito a mirar el primer capítulo mencionado.

Hay dos formas de integrar React en Qwik:

Manual: Completando todos los pasos y configuraciones necasarias que os voy a exponer a continuación.

Automática: Mediante un comando ejecutado y varias selecciones te realiza todas las configuraciones y te añade varios paquetes de componentes como@emotion/react,@emotion/styled,@mui/materialy@mui/x-data-grid.

En este capítulovamos a aprender realizarlo todo de manera manual, para no instalar esas dependencias ni generar los ejemplos que viene por defecto a la hora de hacerlo de manera automática y a su vez podemos entender todo el proceso paso a paso.

Si quisieráis hacerlo de manera automática añadiendo esas dependencias y ejemplos, solo tenéis que ejecutar el siguiente comando y seguir las instrucciones:

Comenzamos con la integración de React en Qwik, lo primero que vamos a realizar es instalar las dependencias necesarias de React y el plugin@builder.io/qwik-reactmediante el siguiente comando (pongo las versiones para trabajar con la versión actual (01/2024) de Qwik, esto en el futuro cambiará, pero lo que es el procedimiento no) :

Se instalarán las dependencias y se registrará esta información en elpackage.json.

Tenéis que tener en cuenta que estoNO ES UNA EMULACIÓN de React, si no que estará usando la librería actual de React.

Ahora vamos al ficherovite.config.tsy pasamos de esto:

A añadir el plugin Vite para integrar React en nuestra app:

Llegados a este punto, ya tenemos la instalación y configuración inicial del pluginQwik-Reactañadido y lo que tenemos que hacer es pasar al siguiente punto donde vamos a crear un componente en React super sencillo, integrándolo en Qwik fácilmente usando la funciónqwikify$después de entender que es y como es su funcionamiento.

Es la función que se usa en el plugin Qwik React para usar componentes existentes de React y envolverlos en esta funciónqwikify$.

Su funcionamiento es bien sencillo.qwikify$creará un componente Qwik que se puede utilizar dentro de Qwik y que convertirá el componente de React en una isla que te permitirá la libertad de ajustar cuando el componente de React debe hidratar.

La funciónqwikify$es exportada de@builder.io/qwik-reacty convierte los componentes de R
