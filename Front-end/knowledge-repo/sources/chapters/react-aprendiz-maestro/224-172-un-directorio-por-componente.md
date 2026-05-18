# 17.2 Un Directorio por Componente

Si dejamos nuestros componentes en directorios que pasen a ser de su propiedad
podemos acabar teniendo algo como esto:
├── actions
│ ├── LaneActions.js
│ └── NoteActions.js
├── components
│ ├── App
│ │ ├── App.jsx
│ │ ├── app.css
│ │ ├── app_test.jsx
│ │ └── index.js
│ ├── Editable

-- 196 of 226 --

Estructurando Proyectos con React 179
│ │ ├── Editable.jsx
│ │ ├── editable.css
│ │ ├── editable_test.jsx
│ │ └── index.js
...
│ └── index.js
├── constants
│ └── itemTypes.js
├── index.jsx
├── libs
│ ├── alt.js
│ ├── persist.js
│ └── storage.js
├── main.css
└── stores
├── LaneStore.js
└── NoteStore.js
Puede ser más pesada que la solución que tenemos actualmente. Los ficheros index.js
sirven de punto de entrada para los componentes. Introducen ruido pero simplifican
los imports.
Sin embargo, hay algunos beneficios interesantes de esta aproximación:
• Podemos utilizar tecnologías como los Módulos CSS para aplicar estilos en
cada componente de forma independiente.
• Dado que cada componente tiene un pequeño “paquete” de sí mismo, puede
ser más sencillo sacarlo del proyecto. De este modo puedes crear componentes
genéricos en cualquier lugar y utilizarlos en muchas aplicaciones.
• Podemos definir tests unitarios a nivel de componente. Esto te anima a hacer
tests, y todavía podemos hacer tests de alto nivel de la aplicación exactamente
igual que antes.
Puede ser interesante tratar de dejar las acciones y los almacenes también en
components. O pueden seguir un esquema de directorios similar. La ventaja de todo
esto es que te permiten definir tests unitarios de una forma similar.

-- 197 of 226 --

Estructurando Proyectos con React 180
Esta configuración no es suficiente si quieres que la aplicación tenga varias vistas.
Necesitamos algo más que nos ayude.
gajus/create-index1 es capaz de generar los ficheros index.js automática-
mente a medida que vas desarrollando.