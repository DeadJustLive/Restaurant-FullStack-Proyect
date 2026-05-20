# módulo i: ndividual hace algo bastante simple y se puede leer por sí solo. Dividir

398

-- 410 of 445 --

el código en módulos a menudo sugiere mejoras adicionales en el diseño del
programa. En este caso, parece un poco extraño que el VillageState y los
robots dependan de un gráfico de caminos específico. Podría ser una mejor
idea hacer que el gráfico sea un argumento del constructor de estado y hacer
que los robots lo lean desde el objeto de estado, esto reduce las dependencias (lo
cual siempre es bueno) y hace posible ejecutar simulaciones en mapas diferentes
(lo cual es aun mejor).
¿Es una buena idea utilizar módulos de NPM para cosas que podríamos
haber escrito nosotros mismos? En principio, sí, para cosas no triviales como
la función de búsqueda de caminos es probable que cometas errores y pierdas
tiempo escribiéndolas tú mismo. Para funciones pequeñas como random-item,
escribirlas por ti mismo es bastante fácil. Pero añadirlas donde las necesitas
tiende a saturar tus módulos.
Sin embargo, tampoco debes subestimar el trabajo involucrado en encontrar
un paquete de NPM apropiado. Y aunque encuentres uno, podría no funcionar
bien o le podrían faltar alguna característica que necesitas. Además, depender
de paquetes de NPM significa que debes asegurarte de que estén instalados,
debes distribuirlos con tu programa y es posible que debas actualizarlos per-
iódicamente.
Así que de nuevo, esto es un compromiso, y puedes decidir de cualquier
manera dependiendo de cuánto te ayude realmente un paquete dado.