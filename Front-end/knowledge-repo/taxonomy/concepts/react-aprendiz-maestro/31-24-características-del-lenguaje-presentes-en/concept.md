# 2.4 Características del Lenguaje Presentes en

## Fuente
react-aprendiz-maestro (Cap. 31)

## Contenido
# 2.4 Características del Lenguaje Presentes en

el Esqueleto
Babel
El esqueleto depende de un transpilador llamado Babel12 que nos permite utilizar
características del JavaScript del futuro. Se encarga de transformar tu código en un
formato que los navegadores puedan entender. Puedes incluso desarrollar tus propias
características del lenguaje. Permite el uso de JSX mediante un plugin.
Babel da soporte a algunas características experimentales13 de ES7 que van más allá
de ES6. Algunas de ellas podrían llegar formar parte del lenguaje, mientras que
otras podrían ser eliminadas por completo. Las propuestas del lenguaje han sido
categorizadas en etapas:
• Etapa 0 - Hombre de paja
• Etapa 1 - Propuesta
• Etapa 2 - Borrador
• Etapa 3 - Candidata
• Etapa 4 - Finalizada
11http://survivejs.com/webpack/introduction/
12https://babeljs.io/
13https://babeljs.io/docs/plugins/#stage-x-experimental-presets-

-- 32 of 226 --

Configurando el Proyecto 15
Yo tendría mucho cuidado con las características de la etapa 0. El problema es que
acabará rompiendo código que habrá que reescribir en caso de ésta cambie o sea
borrada. Quizá en pequeños problemas experimentales merezca la pena correr el
riesgo.
Aparte de ES2015 estándar y de JSX, vamos a utilizar algunas características extra en
este proyecto. Las he listado a continuación. Echa un vistazo al apéndice Caracterís-
ticas del Lenguaje para saber más sobre ellas.
• Inicializadores de propiedades14 - Ejemplo: addNote = (e) => {. Esto relacio-
na al método addNote automáticamente a una instancia. Esta característica
tendrá más sentido a medida que la vayamos utilizando.
• Decoradores15 - Ejemplo: @DragDropContext(HTML5Backend). Estas anotacio-
nes nos permitirán incluir funcionalidad a clases y a sus métodos.
• rest/spread de Objetos16 - Ejemplo: const {a, b, ...props} = this.props.
Esta sintáxis nos permite recuperar fácilmente propiedades específicas de un
objeto.
He creado un preset17 para que sea más sencillo configurar estas características.
Contiene los plugins babel-plugin-transform-object-assign18 y babel-plugin-array-
includes19. El primero nos permite usar Object.assign mientras que el último
incluye Array.includes sin que tengamos que preocuparnos de compatibilidades
con entornos antiguos.
Un preset es simplemente un módulo de npm que exporta configuración de Babel.
Mantener presets como éste puede ser útil si quieres mantener el mismo conjunto de
funcionalidades entre varios proyectos.
Puedes probar Babel online20 para ver el tipo de código que genera.
14https://github.com/jeffmo/es-class-static-properties-and-fields
15https://github.com/wycats/javascript-decorators
16https://github.com/sebmarkbage/ecmascript-rest-spread
17https://github.com/survivejs/babel-preset-survivejs-kanban
18https://www.npmjs.com/package/babel-plugin-transform-object-assign
19https://www.npmjs.com/package/babel-plugin-array-includes
20https://babeljs.io/repl/

-- 33 of 226 --

Configurando el Proyecto 16
Si estás interesado en una alternativa más ligera, echa un vistazo a Bublé21.
