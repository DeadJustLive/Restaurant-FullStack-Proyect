# K BACKSPACE; y

el c ´odigo de la tecla de fin de ciclo, K CTRL D.
El caracter de CTRL-D es hist ´oricamente usado en telecomunicaciones como el carac-
ter de fin de transmisi ´on (end-of-transmission, o EOT). En el sistema operativo UNIX se
utiliza para indicarle a una terminal que termin ´o el ingreso de datos. En el GOBSTONES
lo usaremos para indicar que deber terminar el ciclo de interacci ´on con el usuario. Esta
informaci ´on se obtuvo de la Wikipedia.
Recurso Web
https://en.wikipedia.org/wiki/End-of-transmission_character
Cada herramienta (IDE) ser ´a responsable de implementar la manera en que se debe ex-
presar la interacci ´on, proveyendo quiz ´as herramientas adicionales (como podr´ıa ser un
texto inicial previo al inicio de la ejecuci ´on, la capacidad de redibujar celdas para que
aparezcan de otras maneras, etc ´etera).
5.7.3. El juego interactivo
Habiendo presentado la capacidad de GOBSTONES de expresar programas interactivos,
completaremos nuestra presentaci ´on del ZILFOST mostrando un programa principal inter-
activo, donde fueron elegidas teclas espec´ıficas para llevar adelante la interacci ´on. Cada
tecla se asociar ´a con una operaci ´on de interfaz espec´ıfica, como se ve en el siguiente
c ´odigo
interactive program
/*