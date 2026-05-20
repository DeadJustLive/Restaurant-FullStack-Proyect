# 4. Escribir la instrucci´on MientrasQue y su condici´on.

Con base a lo enunciado, para la validaci´on de un dato num´erico se
procede tal y como se muestra en el segmento de Algoritmo 4.17, el cual
permite ingresar un n´umero que sea mayor o igual a un valor m´ınimo y al
mismo tiempo sea menor o igual a un valor m´aximo, en otro caso9 el ciclo
se hace verdadero y se solicita nuevamente el valor.
Algoritmo 4.17: Validaci´on de un valor num´erico en un rango
1 imprimir( "Ingrese un valor num´erico: " )
2 Haga
3 leer( valor )
4 MientrasQue( valor < m´ınimo O valor > m´aximo )
Para ilustrar este caso se muestra el segmento de Algoritmo 4.18 en el
cual se solicita una edad entre 18 y 90 a˜nos.
9Que le n´umero sea estrictamente menor que un valor m´ınimo O mayor a un valor
m´aximo

-- 254 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 253
Algoritmo 4.18: Ejemplo de validaci´on de un valor num´erico en un rango
1 imprimir( "Ingrese la edad (entre 18 y 90 a˜nos): " )
2 Haga
3 leer( edad )
4 MientrasQue( edad < 18 O edad > 90 )
En este ejemplo (segmento de Algoritmo 4.18) se solicita ingresar una
edad entre 18 y 90 a˜nos, luego se abre el ciclo con la instrucci´on Haga,
seguidamente se lee la variable edad que almacenar´a el valor digitado.
Finalmente se encuentra la condici´on MientrasQue (edad < 18 O
edad > 90), utilizada para validar que la entrada del valor est´e entre 18
y 90. Las validaciones para este tipo de dato se hacen teniendo en cuenta
que solo se van a ingresar n´umeros pertenecientes a un rango de valores.
Suponga que como dato de entrada proporcionan una edad de 15 a˜nos,
entonces la variable edad almacena este valor, al evaluar la condici´on se
tiene que:
edad < 18 O edad > 90
15 < 18 O 15 > 90
Verdadero O Falso
Verdadero
Como el resultado final de la condici´on es verdadero, el ciclo se repite,
solicitando nuevamente el valor de la edad, y as´ı hasta que el usuario ingrese
un valor v´alido (entre 18 y 90).
En los pasos para validar mostrados en el segmento del Algoritmo 4.17,
m´	ınimo y m´	aximo se refieren al rango de valores que aceptar´a el algoritmo
como entrada, pero puede suceder que solamente se requiera solo uno de
los valores, por ejemplo, si el problema establece que se va a trabajar como
dato de entrada un valor positivo (no incluido el cero), sin importar el tope
superior, la validaci´on puede expresarse como se muestra en el segmento
de Algoritmo 4.19.
Algoritmo 4.19: Validaci´on de un valor inferior
1 imprimir( "Ingrese un valor num´erico: " )
2 Haga
3 leer( valor )
4 MientrasQue( valor < 1 )
En cuanto a la validaci´on de los datos de tipo Caracter, se deben tener
en cuenta, por separado, cada uno de los valores (caracteres) que puede
recibir. Para ello se siguen estos pasos:

-- 255 of 450 --

254 Estructuras de repetici ´on
Algoritmo 4.20: Validaci´on de un Caracter
1 imprimir ( "Ingrese una letra: " )
2 Haga
3 leer( letra )
4 MientrasQue( letra != ’letra1’ Y letra != ’letra2’ )
Por ejemplo, suponga que se desea validar que el usuario ingrese la letra
’S’ o ’N’ tanto may´usculas como min´usculas, entonces se puede proceder
como se muestra el segmento de Algoritmo 4.21.
Algoritmo 4.21: Ejemplo de validaci´on de un Caracter
1 imprimir ( "Desea continuar [S] o [N]: " )
2 Haga
3 leer( seguir )
4 MientrasQue( seguir != ’S’ Y seguir != ’s’ Y
5 seguir != ’N’ Y seguir != ’n’ )
La condici´on especificada tiene en cuenta que solo pueda ingresar la letra
’S’ o la letra ’N’ en may´uscula o en min´uscula. La variable seguir debe
estar declarada de tipo Caracter.
Sin embargo, en la mayor´ıa de los lenguajes existe la posibilidad de
convertir las letras que digiten a may´uscula, de esta manera no se requieren
tener en cuenta las letras min´usculas.
Otro de los datos que se deben validar, son los de tipo Cadena, es decir,
aquellos que son un conjunto de caracteres. Generalmente la validaci´on se
enfoca a que no se reciban valores vac´ıos (Ver Algoritmo 4.22)
Algoritmo 4.22: Validaci´on de un Cadena
1 imprimir ( "Ingrese una cadena: " )
2 Haga
3 leer( cadena )
4 MientrasQue( longitud ( cadena ) == 0 )
Por ejemplo, para validar que en la solicitud de un nombre no se omita
el dato, se debe proceder de acuerdo al segmento de Algoritmo 4.23
Algoritmo 4.23: Validaci´on de un nombre
1 imprimir ( "Ingrese su nombre: " )
2 Haga
3 leer( nombre )
4 MientrasQue( longitud ( nombre ) == 0 )

-- 256 of 450 --

Introducci ´on a la L ´ogica de Programaci ´on 255
Para evitar que las variables de este tipo de dato queden en blanco,
una de las formas es trabajar con la funci´on longitud, cuyo prop´osito
es medir la cantidad de caracteres almacenados dentro de una variable
de tipo Cadena. Cuando en este tipo de variables no se ha almacenado
ning´un dato, se dice que su longitud es de 0, por el contrario, si tuviera
almacenado por ejemplo, el nombre "Liliana", su longitud ser´ıa de 7.
La expresi´on relacional MientrasQue(Longitud(nombre )==0),
eval´ua si la longitud del dato que almacene la variable nombre es igual a