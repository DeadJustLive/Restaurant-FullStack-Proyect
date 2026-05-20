# 4.2 Bucles

## Fuente
Aprende Python (Cap. 34)

## Contenido
# 4.2 Bucles

Cuando queremos hacer algo más de una vez, necesitamos recurrir a un bucle. En esta
sección veremos las distintas sentencias en Python que nos permiten repetir un bloque de
código.1
4.2.1 La sentencia while
El primer mecanismo que existe en Python para repetir instrucciones es usar la sentencia
while. La semántica tras esta sentencia es: «Mientras se cumpla la condición haz algo».
Veamos un sencillo bucle que repite una pregunta mientras la respuesta sea negativa:
>>> want_exit = N # importante dar un valor antes de empezar el bucle
>>> while want_exit == N :
... print( Hola qué tal )
... want_exit = input( ¿Quiere salir? [S/N] )
...
... print( Ciao! )
Hola qué tal
¿Quiere salir? [S/N] N
Hola qué tal
(continué en la próxima página)
1 Foto original de portada por Gary Lopater en Unsplash.
4.2. Bucles 119

-- 123 of 516 --

Aprende Python
(proviene de la página anterior)
¿Quiere salir? [S/N] N
Hola qué tal
¿Quiere salir? [S/N] S
Ciao!
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/cNg8dR0
La condición del bucle se comprueba en cada nueva repetición. En este caso chequeamos que
la variable want_exit sea igual a N . Dentro del cuerpo del bucle estamos mostrando un
mensaje y pidiendo la opción al usuario.
Romper un bucle while
Python ofrece la posibilidad de romper o finalizar un bucle antes de que se cumpla la
condición de parada.
Supongamos que en el ejemplo anterior, establecemos un máximo de 4 preguntas:
>>> want_exit = N
>>> num_questions = 0
>>> while want_exit == N :
... print( Hola qué tal )
... want_exit = input( ¿Quiere salir? [S/N] )
... num_questions += 1
... if num_questions == 4:
... print( Máximo número de preguntas alcanzado )
... break
... print( Ciao! )
Hola qué tal
¿Quiere salir? [S/N] N
Hola qué tal
¿Quiere salir? [S/N] N
Hola qué tal
¿Quiere salir? [S/N] N
Hola qué tal
¿Quiere salir? [S/N] N
Máximo número de preguntas alcanzado
Ciao!
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/xNhq3iI
120 Capítulo 4. Control de flujo

-- 124 of 516 --

Aprende Python
Como hemos visto en este ejemplo, break nos permite finalizar el bucle una vez que hemos
llegado al máximo número de preguntas. Pero si no hubiéramos llegado a dicho límite, el
bucle habría seguido hasta que el usuario indicara que quiere salir.
Otra forma de resolver este ejercicio sería incorporar una condición al bucle:
while want_exit == N and num_questions < 4:
...
Comprobar la rotura
Nivel intermedio
Python nos ofrece la posibilidad de detectar si el bucle ha acabado de forma ordinaria,
esto es, ha finalizado por no cumplirse la condición establecida. Para ello podemos hacer uso
de la sentencia else como parte del propio bucle. Si el bucle while finaliza normalmente (sin
llamada a break) el flujo de control pasa a la sentencia opcional else.
Veamos su comportamiento siguiendo con el ejemplo que venimos trabajando:
>>> want_exit = N
>>> num_questions = 0
>>> while want_exit == N :
... print( Hola qué tal )
... want_exit = input( ¿Quiere salir? [S/N] )
... num_questions += 1
... if num_questions == 4:
... print( Máximo número de preguntas alcanzado )
... break
... else:
... print( Usted ha decidido salir )
... print( Ciao )
Hola qué tal
¿Quiere salir? [S/N] S
Usted ha decidido salir
Ciao
Importante: Si hubiéramos agotado el número de preguntas NO se habría ejecutado la
cláusula else del bucle ya que habríamos roto el flujo con un break.
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/xNho3di
4.2. Bucles 121

-- 125 of 516 --

Aprende Python
Continuar un bucle
Nivel intermedio
Hay situaciones en las que, en vez de romper un bucle, nos interesa saltar adelante hacia
la siguiente repetición. Para ello Python nos ofrece la sentencia continue que hace
precisamente eso, descartar el resto del código del bucle y saltar a la siguiente iteración.
Continuamos con el ejemplo anterior y vamos a contar el número de respuestas válidas:
>>> want_exit = N
>>> valid_options = 0
>>> while want_exit == N :
... print( Hola qué tal )
... want_exit = input( ¿Quiere salir? [S/N] )
... if want_exit not in SN :
... want_exit = N
... continue
... valid_options += 1
... print(f {valid_options} respuestas válidas )
... print( Ciao! )
Hola qué tal
¿Quiere salir? [S/N] N
Hola qué tal
¿Quiere salir? [S/N] X
Hola qué tal
¿Quiere salir? [S/N] Z
Hola qué tal
¿Quiere salir? [S/N] S
2 respuestas válidas
Ciao!
Ejecución paso a paso a través de Python Tutor:
https://cutt.ly/BNhkOhP
Bucle infinito
Si no establecemos correctamente la condición de parada o bien el valor de alguna variable
está fuera de control, es posible que lleguemos a una situación de bucle infinito, del que nunca
podamos salir. Veamos un ejemplo de esto:
>>> num = 1
>>> while num != 10:
... num += 2
(continué en la próxima página)
122 Capítulo 4. Control de flujo

-- 126 of 516 --

Aprende Python
(proviene de la página anterior)
...
