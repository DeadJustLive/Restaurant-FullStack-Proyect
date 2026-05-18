# 2. Consultas seguras a las bases

## Fuente
2.3.6 Guia Desarrollo Software v2.0 (Cap. 7)

## Contenido
# 2. Consultas seguras a las bases

de datos
Las vulnerabilidades de tipo SQL
injection ocurren cuando datos no
confiables son incorporados de forma
dinámica a una consulta SQL (muchas
veces a través de la concatenación
directa de dos strings). Este tipo de
ataques permite a un adversario extraer,
modificar o eliminar datos desde la base
de datos e, incluso en ocasiones, tomar
total control del sistema comprometido.
Para mitigar o prevenir este tipo de
ataques, se deben implementar
medidas de protección acordes a la
tecnología y plataforma utilizada:
En el caso de estar utilizando un
lenguaje orientado a objetos, se sugiere
el uso de ORM debidamente probados
División de Gobierno Digital | Lineamientos para desarrollo de software 	8

-- 8 of 33 --

por la comunidad e industria . En el caso
de utilizar un ORM, se debe asegurar
que la herramienta escogida no tenga
vulnerabilidades de inyección, e
implementar otros mecanismos de
defensa como codificar y escapar los
datos, como se explica en la próxima
sección de esta guía. Adicionalmente,
se sugiere validar que el ORM escogido
responda adecuadamente ante altas
cantidades de transacciones.
En el caso de no utilizar ORM, se deben
utilizar prepared statements para
prevenir posibles inyecciones de código
SQL.
En el caso de contar con tecnología de
base de datos específica o legacy
(Oracle, SQL Server, etc), en la cual se
utilicen procedimientos almacenados
directamente en el motor, éstos deben
ser securizados de forma correcta, por
ejemplo, utilizando bind variables.
