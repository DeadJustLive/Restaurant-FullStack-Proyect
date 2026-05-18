# 2. Si la clave ya existe, se añade con el valor del «último» diccionario en la mezcla.6

Python ofrece dos mecanismos para realizar esta combinación. Vamos a partir de los
siguientes diccionarios para ejemplificar su uso:
>>> rae1 = {
... bifronte : De dos frentes o dos caras ,
... enjuiciar : Someter una cuestión a examen, discusión y juicio
... }
>>> rae2 = {
... anarcoide : Que tiende al desorden ,
... montuvio : Campesino de la costa ,
... enjuiciar : Instruir, juzgar o sentenciar una causa
... }
Sin modificar los diccionarios originales: Mediante el operador **:
>>> {**rae1, **rae2}
{ bifronte : De dos frentes o dos caras ,
enjuiciar : Instruir, juzgar o sentenciar una causa ,
anarcoide : Que tiende al desorden ,
montuvio : Campesino de la costa }
A partir de Python 3.9 podemos utilizar el operador | para combinar dos diccionarios:
>>> rae1 | rae2
{ bifronte : De dos frentes o dos caras ,
enjuiciar : Instruir, juzgar o sentenciar una causa ,
anarcoide : Que tiende al desorden ,
montuvio : Campesino de la costa }
Modificando los diccionarios originales: Mediante la función update():
>>> rae1.update(rae2)
>>> rae1
{ bifronte : De dos frentes o dos caras ,
enjuiciar : Instruir, juzgar o sentenciar una causa ,
(continué en la próxima página)
6 En este caso «último» hace referencia al diccionario que se encuentra más a la derecha en la expresión.
5.3. Diccionarios 185

-- 189 of 516 --

Aprende Python
(proviene de la página anterior)
anarcoide : Que tiende al desorden ,
montuvio : Campesino de la costa }
Nota: Tener en cuenta que el orden en el que especificamos los diccionarios a la hora de su
combinación (mezcla) es relevante en el resultado final. En este caso el orden de los factores
sí altera el producto.
Borrar elementos
Python nos ofrece, al menos, tres formas para borrar elementos en un diccionario:
Por su clave: Mediante la sentencia del:
>>> rae = {
... bifronte : De dos frentes o dos caras ,
... anarcoide : Que tiende al desorden ,
... montuvio : Campesino de la costa
... }
>>> del rae[ bifronte ]
>>> rae
{ anarcoide : Que tiende al desorden , montuvio : Campesino de la costa }
Por su clave (con extracción): Mediante la función pop() podemos extraer un elemento
del diccionario por su clave. Vendría a ser una combinación de get() + del:
>>> rae = {
... bifronte : De dos frentes o dos caras ,
... anarcoide : Que tiende al desorden ,
... montuvio : Campesino de la costa
... }
>>> rae.pop( anarcoide )
Que tiende al desorden
>>> rae
{ bifronte : De dos frentes o dos caras , montuvio : Campesino de la costa }
>>> rae.pop( bucle )
Traceback (most recent call last):
File "<stdin>", line 1, in <module>
KeyError: bucle
186 Capítulo 5. Estructuras de datos

-- 190 of 516 --

Aprende Python
Advertencia: Si la clave que pretendemos extraer con pop() no existe,
obtendremos un error.
Borrado completo del diccionario: