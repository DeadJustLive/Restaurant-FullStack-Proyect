# 5. Casos de uso de licencia

## Fuente
2.4.2 Guia de Desarrollo Software Servicios Publicos (Cap. 49)

## Contenido
# 5. Casos de uso de licencia

Al momento de aplicar las licencias se
debe tener especial consideración en
cómo se desea perpetuar el código en el
tiempo, es decir, cuando el código sea
un proyecto relevante, éste debe
considerar que al estar público da lugar
a que la comunidad tome el código y
pueda hacer cambios en el mismo, para
uso propio o para vender de vuelta estos
cambios al Estado.
Sin embargo, al usar una licencia GPLv3
esto se puede evitar, ya que fuerza a que
los cambios mayores realizados al
código sean contribuidos al proyecto
principal y, de esta forma, mantener
todo cambio en el código libre en el
tiempo.
Al dejar el código en dominio público,
sin licencia o usando una licencia
clásica Creative Commons, no se está
buscando que los cambios al código
vuelvan a la base sino, más bien,
mantener la autoría del mismo. De esta
forma, toda persona dentro de la
comunidad puede tomar el código y
realizarle cambios, cerrarlo y utilizarlo
para prestar servicios al Estado, usando
el código del Estado. Es por ello que
estas licencias no son recomendadas
para software de carácter crítico o que
su uso pueda masificarse de forma
importante en el tiempo.
Por otro lado, es necesario considerar
que muchas veces el software podría
estar usando módulos con licencias
no compatibles con una GPLv3 o GPLv2.
Por esto, el uso de LGPLv3 es
recomendado, ya que permite incorporar
módulos propietarios. Este caso se da
para aplicaciones que son compiladas y
enlazadas con otros módulos. No aplica
para lenguajes interpretados.
División de Gobierno Digital | Lineamientos para desarrollo de software 	27

-- 27 of 33 --
