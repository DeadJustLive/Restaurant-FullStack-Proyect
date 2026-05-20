# INGENIERIA DE SISTEMAS

Ejemplo de un árbol con los tres recorridos definidos:
Inorden: 1 3 4 6 7 8 10 13 14
Preorden: 8 3 1 6 4 7 10 14 13
Posorden: 1 4 7 6 3 13 14 10 8
Algoritmos para los recorridos de árboles binarios: Se definen los algoritmos para una representación
de árboles con listas ligadas, donde la raíz es de tipo nodo Float R y se utiliza dentro de la clase árbol un
método que puede devolver el hijo izquierdo y el hijo derecho o el dato del nodo para determinar el
recorrido recursivo respectivo:
Inorden(nodoFloat R)
If(R!=0) then
Inorden(R.devli()) //llamado recursivo con LI(R)
Imprima(R.devDato()) //imprime el dato(R)
Inorden(R.devld()) //llamado recursivo con LD(R)
End(if)
Fin(Inorden)
Preorden(nodoFloat R)
If(R!=0) then
Imprima(R.devDato()) //imprime el dato(R)
Preorden(R.devli()) //llamado recursivo con LI(R)
Preorden(R.devld()) //llamado recursivo con LD(R)
End(if)
Fin(Preorden)
Posorden(nodoFloat R)

-- 21 of 64 --

22