# Testing

## Fuente
Qwik Framework - Libro en Español (Cap. 17)

## Contenido
# Testing

> Fuente: [https://qwik-book-spanish.netlify.app/17-testing](https://qwik-book-spanish.netlify.app/17-testing)

Aprenderemos a testear nuestros componentes y proyectos de Qwik.

Curso gratuito que ofrece Google para obtener las nociones básicas sobre el Testing que os pueden venir perfectas para esta sección.

Podéis acceder al curso desde elsiguiente enlace

Estos serán los puntos que trataremos en este capítulo, como veís hay bastantes puntos e intentaremos tocar todos los aspectos fundamentales para poder entender bien todo lo relacionado a lo que estamos viendo en el capítulo.

Introducción.

Unit testing en Qwik.

Configurando el entorno de Testing.

Escribiendo nuestras pruebas.

Ejemplos con diferentes casos de uso.

Conclusión.

La importancia de una detección efectiva y rápida de errores recae en la calidad y en la confianza que nos pueda proporcionar el software que estamos desarrollando. Los errores pueden hacer que las experiencias sean negativas para los usuarios, donde podría darse pérdida de datos o incluso vulnerabilidades de seguridad.

Lo que no podemos hacer es simplemente ir recorriendo el sitio web nosotros mismos. Necesitamos comprobar si cada unidad de nuestro código funciona como queremos que lo haga.

Para eso, vamos a necesitar escribir pruebas unitarias, y realmente pueden ser un poco molestas, dándonos bastante pereza ponernos a ello cuando realmente nos ponemos a escribirlas.

Al realizar pruebas exhaustivas durante el desarrollo, los programadores podemos (y deberíamos) identificar y abordar problemas antes de que lleguen a los usuarios finales, lo que nos hará ahorrar tiempo y recursos en correcciones posteriores.

Nuestra responsabilidad, la de los programadores, en este proceso es crucial, ya que somos los que mejor entendemos el funcionamiento interno de nuestras aplicaciones.

Además, cuando realizamos pruebas rigurosas, estamos invirtiendo en la mejora de la calidad de lo que hacemos y con ello, haremos que lo que construimos sea de más calidad y también sea más sencillo su mantenimiento futuro.

Esta responsabilidad no se va a limitar solo al presente, sino que también se extiende al futuro, sea a corto, medio o largo plazo.

El motivo es que teniendo una base sólida de pruebas nos va a facilitar la adaptación y el mantenimiento a medida que el software evoluciona con nuevas funcionalidades y actualizaciones.

En resumen, la detección temprana de errores y la inversión que realicemos en pruebas sólidas van a ser esenciales para garantizar un desarrollo de software exitoso y sostenible.

Como desarrolladores responsables que somos (o deberíamos de ser), es conveniente que agreguemos pruebas unitarias a nuestras aplicaciones de Qwik.

Actualmente hay muy poca información y por ese motivo, intentaré ir ampliando esta información para abrir puertas a los futuros perfiles que trabajen con este framework.

Se realizará el aprendizaje básico para agregar pruebas unitarias a nuestras aplicaciones Qwik y dado que Qwik es relativamente nuevo, descubrí que había poca documentación sobre cómo hacerlo. Además, hasta hace poco, no existían herramientas para configurar y trabajar fácilmente con los componentes de Qwik en pruebas unitarias.

En este capítulo, os voy a ir a mostrando los pasos que hay que dar para empezar a escribir pruebas unitarias en Qwik. Explicaré el proceso a través de varios ejemplos, para ayudaros a comprender mejor los diferentes casos de uso que nos podamos encontrar normalmente en todos los proyectos y luego ya deberéis de ir adaptando lo aprendido a vuestras necesidades personales y profesionales.

Para este capítulo, asumo que ya tenéis un conocimiento básico de Qwik, ya que ya han pasado 16 capítulos del libro y si no es así, entonces os recomendaría que trabajaseis capítulo a capítulo hasta llegar aquí.

Las pruebas implican comprobar si nuestro código funciona (como se supone que debería) al comparar la salida esperada con la salida real.

En general, nuestras pruebas deben cubrir los siguientes aspectos de nuestro código:

Qué no probar

Probar la mayor parte de tu código es importante, pero aquí hay algunas cosas que no necesitas probar:

Esto de primeras puede parecernos un poco complicado de entender, pero lo vamos a llegar a entender mejor a través de ejemplos empezando desde lo más básico.

Cualquier prueba en Qwik (u otras tecnologías como Angular, React,...), sin importar su complejidad, seguirá la siguiente estructura:

Existen varias opciones cuando se trata de elegir un framework / herramienta de pruebas, entre las cuales existe el tan popular y utilizadoJest.

Sin embargo, dado que Qwik utiliza Vite, por simplificar el proceso vamos a hacerlo con la opción más directa y efectiva, que será usarVitest.

Vitestestá diseñado específicamente para ser la herramienta de pruebas preferida y más recomendable en proyectos Vite, lo que lo hace una excelente elección (aunque para gustos los colores, no habría problemas en usarJest, pero podéis 
