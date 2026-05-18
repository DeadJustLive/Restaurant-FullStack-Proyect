# INGENIERIA DE SISTEMAS

v=new tripleta[p] // asigna memoria de clase tripleta a “v”
v[0]=t //inicializa el vector de tripletas en el valor de “t”
for (i=1,i<=p,i++) do //ciclo que recorre con variable “i” hasta elementos “p”
v[i]=null //asigna cero a las posiciones de la matriz
end(for)
fin(matrizentripletas)
El constructor recibe como parámetros una tripleta t, la cual tiene las dimensiones de la matriz a representar en
la fila y columna y en el campo de valor tiene asignado un cero (indica matriz vacía). Se define un vector de
tamaño n*m+2, para tener una tripleta adicional que facilita algunos de los algoritmos siguientes. La tripleta de
posición cero almacena las dimensiones de la matriz y el número de elementos diferentes de cero.
Los métodos más importantes asociados a tripleta son:
void asignatripleta(tripleta tx, entero i)
v[i]=tx
fin (asigna tripleta)
El método asigna la tripleta enviada al vector v en la posición i
Void asignanumerode tripletas(entero n)
tripleta t=V[0]
t.asignavalor(n)
v[0]=t
fin (asignanumerodetripletas)
El método actualiza el campo de valor de la tripleta que se halla en la posición 0 del vector v (indica el número
de elementos que se representan)
Entero retornafilas()
Tripleta t=v[0]
Return t.retornafila()

-- 46 of 64 --

47