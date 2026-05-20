# INGENIERIA DE SISTEMAS

if (c==i) then
k=k+1
tx=new tripleta(c,f,v)
b.asignatripleta(tx,k)
end(if)
end(for)
end(for)
return b
fin(traspuestaM)
El anterior algoritmo de la transpesta elimina el llamado a insertatripleta, pero hacienda un análisis al algoritmo
el orden de magnitude puede llegar a ser O(m*n2) el cual comparado al algoritmo de la traspuesta en cuadriculas
O(m*n) sigue siendo malo.
Una tercera alternativa de algoritmo de la traspuesta en tripletas es:
Matrizentripletas transpuestar()
entero m,n,p,i,j,s[],t[]
tripleta ti, tx
m=retornafilas()
n=retornacolumnas()
p=numerodetripletas()
ti=new tripleta(n,m,p)
matrizentripletas b=new matriz entripletas(ti)
s=new entero[n+1]
t= new entero[n+1]
for(i=1;;i<=n;i++) do
s[i]=0

-- 51 of 64 --

52