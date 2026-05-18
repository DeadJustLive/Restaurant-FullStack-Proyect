# punto de entrada real

Importante: Si queremos ejecutar este fichero main.py desde línea de comandos,
tendríamos que hacer:
$ python main.py
if __name__ == __main__
Esta condición permite, en el programa principal, diferenciar qué codigo se lanzará cuando
el fichero se ejecuta directamente o cuando el fichero se importa desde otro lugar.
hello.py
1 import blabla
2
3
4 def myfunc():
5 print( Inside myfunc )
6 blabla.hi()
7
(continué en la próxima página)
292 Capítulo 6. Modularidad

-- 296 of 516 --

Aprende Python
Figura 16: Comportamiento de un programa principal al importarlo o ejecutarlo
(proviene de la página anterior)
8
9 if __name__ == __main__ :
10 print( Entry point )
11 myfunc()
import hello El código se ejecuta siempre desde la primera instrucción a la última:
• Línea 1: se importa el módulo blabla.
• Línea 4: se define la función myfunc() y estará disponible para usarse.
• Línea 9: esta condición no se cumple, ya que estamos importando y la variable
especial __name__ no toma ese valor. Con lo cual finaliza la ejecución.
• No hay salida por pantalla.
$ python hello.py El código se ejecuta siempre desde la primera instrucción a la última:
• Línea 1: se importa el módulo blabla.
• Línea 4: se define la función myfunc() y estará disponible para usarse.
• Línea 9: esta condición sí se cumple, ya que estamos ejecutando directamente el
fichero (como programa principal) y la variable especial __name__ toma el valor
__main__.
• Línea 10: salida por pantalla de la cadena de texto Entry point.
• Línea 11: llamada a la función myfunc() que muestra por pantalla Inside
myfunc, además de invocar a la función hi() del módulo blabla.
6.4. Módulos 293

-- 297 of 516 --

Aprende Python