# 24 | SCRUM Y XP DESDE LAS TRINCHERAS

## Fuente
scrum-y-xp-desde-las-trincheras (Cap. 42)

## Contenido
# 24 | SCRUM Y XP DESDE LAS TRINCHERAS

• 	Tratar de convencer a la gerencia de que asigne un nuevo Dueño de
Producto.
• 	Posponer el lanzamiento del Sprint hasta que el Dueño de Producto
encuentre 	el 	tiempo 	para 	asistir 	a 	la 	reunión. 	Mientras 	tanto, 	no
comprometerse a ninguna entrega y permitir que el equipo pase el día
haciendo cualquier cosa que les parezca importante hacer.
Por qué la calidad no es negociable
En el triángulo mencionado anteriormente he dejado intencionadamente fuera
una cuarta variable: la calidad. Tiendo a distinguir entre calidad interna y calidad
externa.
• 	Calidad externa: es lo que perciben los usuarios del sistema. Un interfaz
de usuario lento y poco intuitivo es un ejemplo de baja calidad externa.
• 	Calidad interna: se refiere a aquellos aspectos que normalmente no son
visibles 	al 	usuario, 	pero 	que 	tienen 	un 	profundo 	efecto 	en 	la
mantenibilidad del sistema. Cosas como consistencia del diseño del
sistema, cobertura de pruebas, legibilidad del código, refactorización, etc.
Generalizando, un sistema con alta calidad interna puede, aun así, tener una
baja calidad externa. Pero un sistema con baja calidad interna rara vez tendrá
buena calidad externa. Es difícil construir algo sobre unos cimientos podridos.
Yo trato la calidad externa como parte del alcance. En algunos casos puede
tener sentido, desde el punto de vista de negocio, liberar una versión del
producto que tenga un internaza de usuario torpe y lento, y más tarde liberar una
versión mejorada. Dejo esa decisión al Dueño de Producto, ya que él es el
responsable de definir el alcance.
Sin embargo, la calidad interna es algo que no puede ser discutido. Es
responsabilidad 	del 	equipo 	mantener 	la 	calidad 	del 	sistema 	bajo 	toda
circunstancia y simplemente no es negociable. Nunca. (Vale, OK, casi nunca).
¿Y como distinguimos la diferencia entre aspectos de calidad externa y aspectos
de calidad interna? Supongamos que el Dueño de Producto dice “OK tíos,
respeto vuestras estimaciones de esfuerzo de 6 puntos de historia, pero estoy
seguro de que podríamos usar algún apaño rápido para hacerlo en la mitad de
tiempo si le dais una pensada”.
¡Ajá! Está intentando usar la calidad interna como una variable. ¿Cómo lo se?
Porque quiere que reduzcamos la estimación de la historia sin “pagar el precio”
de reducir el alcance. La palabra “apaño” debería disparar una alarma en
vuestras mentes…
¿Y por qué no permitimos esto? Mi experiencia es que sacrificar la calidad
interna es, prácticamente siempre, una idea terrible. El tiempo que se ahorra es
mucho menor que el coste, tanto a corto como a largo plazo. Una vez que
permites que una base de código comience a deteriorarse es muy duro volver a
conseguir su calidad original más adelante.
En lugar de eso intento reconducir la discusión hacia el alcance. “Ya que es
importante para ti que entreguemos esta historia pronto, ¿podemos reducir su
alcance de forma que sea más rápida de implementar? Quizás podríamos

-- 24 of 122 --
