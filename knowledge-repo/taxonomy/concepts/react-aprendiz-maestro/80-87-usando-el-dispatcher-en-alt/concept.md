# 8.7 Usando el Dispatcher en Alt

## Fuente
react-aprendiz-maestro (Cap. 80)

## Contenido
# 8.7 Usando el Dispatcher en Alt

Aunque hayamos llegado lejos sin utilizar el dispatcher de Flux, puede ser útil que
sepamos algo sobre ello. Alt facilita dos formas de utilizarlo. Si quieres guardar
una traza de todo lo que pase por la instancia de alt puedes utilizar un trozo de
código como alt.dispatcher.register(console.log.bind(console)). También
puedes lanzar this.dispatcher.register(...) en un constructor del almacén.
Estos mecanismos te permitirán generar trazas de forma efectiva.

-- 99 of 226 --

React y Flux 82
Otros gestores de estado ofrecen puntos de enganche similares. Es posible interceptar
el flujo de datos de muchas formas e incluso crear una lógica personalizada encima
de ello.
