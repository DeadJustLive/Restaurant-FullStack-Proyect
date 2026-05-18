# 10.3 Persistiendo la Aplicación usando

## Fuente
react-aprendiz-maestro (Cap. 97)

## Contenido
# 10.3 Persistiendo la Aplicación usando

FinalStore
El que tengamos los medios para poder escribir en el localStorage no es suficiente.
Todavía necesitamos poder conectarlo con nuestra aplicación de alguna manera.
Los gestores de estados tienen puntos de enganche para este propósito y a menudo
encontrarás una forma de interceptarlos de alguna manera. En el caso de Alt, esto
ocurre gracias a un almacén predefinido conocido como FinalStore.
El caso es que ya lo tenemos configurado en nuestra instancia de Alt. Lo que nos
queda es escribir el estado de la aplicación en el localStorage cuando éste cambie.
También necesitaremos cargar el estado cuando arranquemos la aplicación. Estos
procesos en Alt se conocen como snapshotting y bootstrapping.
Una forma alternativa de gestionar el almacenamiento de los datos es
hacer un snapshot sólo cuando se cierre el navegador. Hay una llamada a
nivel de ventana llamado beforeunload que puede ser utilizado para ello.
Sin embargo, esta aproximación es algo frágil. ¿Qué ocurrirá si ocurre algo
inesperado y el evento no se llega a lanzar por algún motivo?, que perderás
datos.
