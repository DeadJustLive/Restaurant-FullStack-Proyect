# INGENIERIA DE SISTEMAS

## Fuente
estructuras-de-datos (Cap. 57)

## Contenido
# INGENIERIA DE SISTEMAS

Fin(muestramatrizentripletas)
El anterior método simplemente recorre el vector de tripletas escribiendo los datos contenidos en cada tripleta.
void insertatripleta(tripleta i) //método para insertar tripletas
Entero i,j,datos //define tres variables enteras
Tripleta t, tx //define objetos de tripleta
tx=retornatripleta(0) //asigna en tx tripleta cero
datos= tx.retornavalor() //retorna valor de tripleta cero
i=1 //inicializa control de ciclo
t=retornatripleta(i) //retorna tripleta 1 en t
While (i<=datos and t.retornafila() <ti.retornafila()) do //
i=i+1
t=retornatripleta(i)
end(while)
datos =datos+1
j=datos-1
while(j>=i) do
v[j+1]=v[j]
j=j-1
end(while)
v[i]=ti
Asignanumerotripletas(datos)
Fin (insertatripleta)
El parámetro de entrada es la tripleta que se desea insertar
Explicación del método insertar:

-- 48 of 64 --

49
