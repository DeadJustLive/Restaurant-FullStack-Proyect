# 14. Manejo de secretos

## Fuente
2.3.6 Guia Desarrollo Software v2.0 (Cap. 19)

## Contenido
# 14. Manejo de secretos

Las 	aplicaciones 	habitualmente
contienen múltiples secretos que son
necesarios para su operación. Éstos
pueden incluir certificados digitales,
contraseñas para la base de datos,
credenciales a otros servicios y llaves
criptográficas, entre otros. Toda la
información relacionada a certificados
digitales, 	contraseñas, 	llaves,
credenciales, incluidas las rutas de
almacenamiento u otras referencias a
estos 	objetos, 	deben 	quedar
debidamente parametrizadas en un
archivo de variables de entorno y éste
debe ser excluido de la herramienta de
control de versiones.
