# Su código debajo de aquí

## Fuente
Aprende Python (Cap. 44)

## Contenido
# Su código debajo de aquí

Ejemplo
• Entrada: 32 56 21 99 12 17
• Salida: 39.50
5.1.9 Listas de listas
Nivel intermedio
Como ya hemos visto en varias ocasiones, las listas son estructuras de datos que pueden
contener elementos heterogéneos. Estos elementos pueden ser a su vez listas.
A continuación planteamos un ejemplo del mundo deportivo. Un equipo de fútbol suele tener
una disposición en el campo organizada en líneas de jugadores. En aquella alineación con la
que España ganó la copa del mundo en 2010 había una disposición 4-3-3 con los siguientes
jugadores:
Veamos una posible representación de este equipo de fútbol usando una lista compuesta de
listas. Primero definimos cada una de las líneas:
>>> goalkeeper = Casillas
>>> defenders = [ Capdevila , Piqué , Puyol , Ramos ]
>>> midfielders = [ Xavi , Busquets , X. Alonso ]
>>> forwards = [ Iniesta , Villa , Pedro ]
Y ahora las juntamos en una única lista:
>>> team = [goalkeeper, defenders, midfielders, forwards]
>>> team
[ Casillas ,
[ Capdevila , Piqué , Puyol , Ramos ],
[ Xavi , Busquets , X. Alonso ],
[ Iniesta , Villa , Pedro ]]
Podemos comprobar el acceso a distintos elementos:
5.1. Listas 163

-- 167 of 516 --

Aprende Python
Figura 5: Lista de listas (como equipo de fútbol)
164 Capítulo 5. Estructuras de datos

-- 168 of 516 --

Aprende Python
>>> team[0] # portero
Casillas
>>> team[1][0] # lateral izquierdo
Capdevila
>>> team[2] # centrocampistas
[ Xavi , Busquets , X. Alonso ]
>>> team[3][1] # delantero centro
Villa
Ejercicio
Escriba un programa que permita multiplicar únicamente matrices de 2 filas por 2 columnas.
Veamos un ejemplo concreto:
A = [[6, 4], [8, 9]]
B = [[3, 2], [1, 7]]
El producto P = 𝐴 × 𝐵 se calcula siguiendo la multiplicación de matrices tal y como se
indica a continuación:
P =
(︂

6[00] 4[01]
8[10] 9[11]
)︂

×
(︂

3[00] 2[01]
1[10] 7[11]
)︂

=
(︂
6 · 3 + 4 · 1 6 · 2 + 4 · 7
8 · 3 + 9 · 1 8 · 2 + 9 · 7
)︂

=
(︂

22 40
33 79
)︂
