# INGENIERIA DE SISTEMAS

## Fuente
estructuras-de-datos (Cap. 64)

## Contenido
# INGENIERIA DE SISTEMAS

i=i+1 //incrementa el valor de i
end(while)
return b //retorna b con matriz transpuesta en tripletas
fin(transpuesta)
Es un método que se basa en llamar a insertatripleta para crear la transpuesta. El orden de magnitud de este
algoritmo es O(p2), pero en el peor de los casos con el llamado a insertatripleta puede ser O(m2*n2) que sería un
algoritmo catastrófico.
Para evitar el llamado inserta tripleta dentro del algoritmo de la transpuesta en tripletas se propone el siguiente
algoritmo para calcular la transpuesta en tripletas:
Variación del algoritmo de la transpuesta en tripletas para mejorar su rendimiento
Matrizentripletas transpuestaM()
Entero i,j,k,m,n,p,f,c,v
Tripleta tj, tx
m=retornafilas()
n=retornacolumnas()
p=retornanumerotripletas()
tx= new tripleta(n,m,p)
matrizentripletas b=new matriz entripletas(tx)
k=0
for(i=1;i<=n;i++) do
for(j=1;j<=p;j++) do
tj=retornatripleta(j)
f=tj.retornafila()
c=tj.retornacolumna()
v=tj.retornavalor()

-- 50 of 64 --

51
