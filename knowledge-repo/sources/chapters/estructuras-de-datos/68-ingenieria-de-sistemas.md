# INGENIERIA DE SISTEMAS

If(R!=0) then
Posorden(R.devli()) //llamado recursivo con LI(R)
Posorden(R.devld()) //llamado recursivo con LD(R)
Imprima(R.devDato()) //imprime el dato(R)
End(if)
Fin(Posorden)
Nota: para realizar las pruebas de escritorio a estos algoritmos se debe manejar la estructura pila con las
direcciones de retorno a los llamados respectivos en los métodos que se deben apilar cuando se hace el llamado
y posteriormente se desapilan cuando termina el llamado.
Adicionalmente todos estos algoritmos se pueden escribir en un lenguaje de programación como java para
simular la creación de esta estructura de datos como ya fue ilustrado en videos anteriores en este mismo
capítulo.
2.3.3.5 REPRESENTACIÓN DE UN ÁRBOL GENERAL COMO UN ÁRBOL BINARIO
Cualquier árbol general sin importar su grado, puede ser representado como un árbol binario. La construcción
del árbol binario es como sigue: Para cada registro r que tenga k hijos, su primer hijo se representa como hijo
izquierdo y los otros se insertan como hijos derechos del primero respectivamente. Lo que quiere decir que los
registros que están en una rama derecha del árbol son los hermanos de la raíz que los contiene. Ejemplo:
Para el siguiente árbol General Esta es la Representación como un árbol binario

-- 22 of 64 --

23