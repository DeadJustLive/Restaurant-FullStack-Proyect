# 3. El orden de magnitud es O(p), siendo p el número de tripletas (orden lineal)

## Fuente
estructuras-de-datos (Cap. 62)

## Contenido
# 3. El orden de magnitud es O(p), siendo p el número de tripletas (orden lineal)

A continuación se presenta un método para calcular la transpuesta de una matriz dispersa representada
en tripletas:
La traspuesta es la matriz que resulta de intercambiar las filas con las columnas en una matriz (en otras
palabras la fila i será la columna i y la columna j será la fila j. De otra forma un elemento de la fila i columna
j en la matriz original quedara en la fila j columna i dentro de la matriz transpuesta.
Matrizentripletas transpuesta //método que genera la transpuesta de matriz
Entero i, p ,f , c, v //define cinco variables enteras
Tripleta ti //define objeto ti de clase tripleta
p =retornanumerotripletas() //asigna a p el número de tripletas
ti=new tripleta(retornacolumnas(), retornafilas(),0) //asigna a ti memoria de tripleta
matriz entripletas b=new matrizentriplets(ti) //asigna a b memoria de matrizentripletas
i=1 //inicializa i en 1
while(i<=p) do //ciclo mientras hasta el número de tripletas
ti=retornatrileta(i) //retorna tripleta en ti
f=ti.retornacolumna() //determina la fila de la matriz
c=ti.retornafila() //determina la columna
v=ti.retornavalor() //determina el valor
ti=new tripleta(f,c,v) //asigna memoria de tripleta en ti para c, f
b.insertatripleta(ti) //inseta tripleta en el objeto b (matriz transp)

-- 49 of 64 --

50
