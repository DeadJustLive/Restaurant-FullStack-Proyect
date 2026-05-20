# 8. 	Instrucciones condicionales

si <condición> entonces
<secuencia de acciones>
fsi
si <condición> entonces
<secuencia de acciones>
sino
<secuencia de acciones>
fsi
si <condición> entonces
<secuencia de acciones>
sino_si <condición> entonces
<secuencia de acciones>
sino_si <condición> entonces
<secuencia de acciones>
...
sino
<secuencia de acciones>
fsi

-- 261 of 267 --

248
selección
<condición 1>: <secuencia de instrucciones>;
<condición 2>: <secuencia de instrucciones>;
...
<condición n>: <secuencia de instrucciones>;
[ otrosCasos: <secuencia de instrucciones> ]
fselección
{se requiere que las condiciones sean excluyentes entre sí;
una vez ejecutada la secuencia de instrucciones de la primera
condición verdadera se termina la instrucción de selección}