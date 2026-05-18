# 9. Implementando NoteStore y

NoteActions
Ahora que hemos movido todo lo relacionado con la gestión de los datos al lugar
correcto podemos centrarnos en implementar las partes que faltan - NoteStore
(Almacén de Notas) y NoteActions (Acciones sobre las Notas). Ambas encapsularán
tanto los datos de la aplicación como la lógica.
No importa qué gestor de estados acabes usando, siempre encontrarás equivalencias
en los demás. En Redux puedes usar acciones que provocarán un cambio de estado
mediante un reductor. En MobX puedes modelar una acción en una clase ES6. La
idea es que manipules los datos dentro de la clase y que ésto provoque que MobX
refresque los componentes cuando sea necesario.
La idea aquí es similar: configuraremos acciones que acabarán invocando métodos
en el estado que modificarán este estado. Cuando el estado cambia las vistas se
actualizan. Para comenzar podemos implementar un NoteStore y definir la lógica
para manipularlo. Una vez hayamos hecho eso, habremos migrado nuestra aplicación
a la arquitectura Flux.