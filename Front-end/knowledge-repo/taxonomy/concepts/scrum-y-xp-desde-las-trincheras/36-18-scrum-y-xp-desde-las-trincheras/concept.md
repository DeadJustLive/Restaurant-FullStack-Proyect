# 18 | SCRUM Y XP DESDE LAS TRINCHERAS

## Fuente
scrum-y-xp-desde-las-trincheras (Cap. 36)

## Contenido
# 18 | SCRUM Y XP DESDE LAS TRINCHERAS

• 	Notas – cualquier otra información, clarificación, referencia a otras
fuentes de información, etc. Normalmente muy breve.
Pila de Producto (ejemplo)
ID 	Nombre 	Imp. 	Est. 	Como probarlo 	Notas
1 	Depósito 	30 	5 	Entrar, abrir página
de 	depósito,
depositar 10€, ir a
página de balance y
comprobar 	que 	se
ha incrementado en
10€
Necesita 	un
diagrama 	UML.
No 	preocuparse
por 	encriptación
aun
2 	Ver tu historial de
transacciones
10 	8 	Entrar, 	ver
transacciones.
Realizar un depósito
de 	10€. 	Ir 	a
transacciones 	y
comprobar 	que 	se
ha actualizado con
el nuevo depósito
Utilizar
paginación 	para
no 	hacer
consultas 	muy
grandes 	a 	la
BB.DD. 	Diseño
similar 	a 	la
página 	de
usuario.
Hemos experimentado con muchos otros campos, pero al final estos seis
campos son los únicos que realmente se usaban Sprint tras Sprint.
Mantenemos esta tabla en un documento Excel con “compartir” habilitado (es
decir, muchos usuarios pueden editar simultáneamente la hoja). Oficialmente, el
Dueño de Producto es el propietario del documento, pero no queremos dejar al
resto de usuarios fuera. Muchas veces un desarrollador necesita abrir el
documento para clarificar algo o cambiar una estimación.
Por la misma razón, no colocamos este documento en el repositorio de control de
versiones; en vez de eso, lo almacenamos en una unidad de red compartida.
Esta ha demostrado ser la manera más simple de permitir múltiples editores
diferentes sin causar problemas de bloqueo o fusión de documentos.
Sin embargo, casi todos los demás artefactos se colocan en el repositorio de
control de versiones.
Campos de historia adicionales
A veces usamos campos adicionales en la Pila de Producto, fundamentalmente
como comodidad para el Dueño de Producto a la hora de decidir sus prioridades.
• 	Categoría 	– una categorización básica de la historia, por ejemplo
“backoffice” o “optimización”. Así, el dueño de producto puede filtrar
fácilmente “optimización” y cambiar todas las prioridades de este tipo a
“baja”, etc.
• 	Componentes - usualmente implementado en la forma de “checkboxes”
en el documento Excel, por ejemplo “base de datos, servidor, cliente”.
Aquí, el Dueño de Producto puede identificar qué componentes técnicos
estarán involucrados en la implementación de la historia. Esto es útil

-- 18 of 122 --
