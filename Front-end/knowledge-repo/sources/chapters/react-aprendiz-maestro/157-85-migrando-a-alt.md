# 8.5 Migrando a Alt

Alt
En Alt trabajarás con acciones y almacenes. El dispatcher está oculto, pero puedes
acceder a él si lo necesitas. Comparado con otras implementaciones, Alt oculta
mucho código reutilizable. Tiene algunas ceracterísticas especiales que te permitirán
guardar y recuperar el estado de la aplicación, lo cual es útil para implementar tanto
persistencia como renderizado universal.
Hay un par de pasos que debemos seguir para permitir que Alt gestione el estado de
nuestra aplicación: