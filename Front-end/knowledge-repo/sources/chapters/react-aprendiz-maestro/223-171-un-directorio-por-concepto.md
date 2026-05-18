# 17.1 Un Directorio por Concepto

Nuestra aplicación Kanban tiene una estructura plana como la siguiente:
├── actions
│ ├── LaneActions.js
│ └── NoteActions.js
├── components
│ ├── App.jsx
│ ├── Editable.jsx
│ ├── Lane.jsx
│ ├── Lanes.jsx
│ ├── Note.jsx
│ └── Notes.jsx
├── constants
│ └── itemTypes.js
├── index.jsx
├── libs
│ ├── alt.js
│ ├── persist.js
│ └── storage.js

-- 195 of 226 --

Estructurando Proyectos con React 178
├── main.css
└── stores
├── LaneStore.js
└── NoteStore.js
Es suficiente para nuestro propósito, pero hay algunas alternativas interesantes:
• Un fichero por concepto - Perfecto para prototipos pequeño. Puedes dividirlo
a medida que la aplicación se vaya haciendo más seria.
• Un directorio por componente - Es posible dejar componentes en directorios
que pasen a ser de su propiedad. Aunque quizá sea la aproximación más
pesada, tiene algunas ventajas interesantes que veremos pronto.
• Un directorio por vista - Esta aproximación se vuelve relevante una vez quieres
introducir enrutamiento en tu aplicación.
Hay más alternativas pero éstas cubren los casos más comunes. Siempre hay espacio
para hacer ajustes en base a las necesidades de tu aplicación.