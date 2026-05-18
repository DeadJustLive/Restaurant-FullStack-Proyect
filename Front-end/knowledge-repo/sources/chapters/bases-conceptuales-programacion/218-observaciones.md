# OBSERVACIONES:

* realiza una selecci´on alternativa en base al
tipo de pieza
*/
{
switch (tipoPieza) to
7 -> { (dirA,dirB,dirC) := diresDePiezaT(rotPieza) }
_ -> { }
return (dirA,dirB,dirC)
}
Hay varios detalles para observar. El primero es que ambas funciones asumen como pre-
condici ´on que tanto el tipo de pieza como la rotaci ´on son v ´alidos; en caso de recibir datos
inv ´alidos, fallar ´an con un error (en este caso, por indefinici ´on de variables). El segundo
es que ambas realizan una selecci ´on alternativa en base al tipo de pieza, e invocan a
una funci ´on espec´ıfica correspondiente a esa pieza; esta funci ´on toma como par ´ametro
el c ´odigo de rotaci ´on de la pieza y devuelve 4 ( ´o 3) direcciones, las cuales se asignan a
variables en forma simult ´anea. El ´ultimo detalle a observar es que la rotaci ´on de la pieza
La asignaci ´on simult ´anea es una
forma extendida de la asignaci ´on
que posee GOBSTONES, y que
permite que una funci ´on retorne
varios resultados al mismo tiem-
po. Puede verse como la opera-
ci ´on opuesta de recibir varios ar-
gumentos. Ver el final de la sub-
secci ´on 4.3.1.
se utiliza como argumento para la funci ´on espec´ıfica invocada.
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 197 of 312 --

198
Las funciones espec´ıficas usadas en diresDePiezaClaseA y diresDePiezaClaseB sir-
ven para expresar la forma de cada pieza utilizando direcciones. Para ello reciben como
par ´ametro la rotaci ´on, y ajustan las direcciones “naturales” (las que tiene la pieza cuando
est ´a en rotaci ´on 1) seg ´un este par ´ametro. Veamos el c ´odigo de una de estas funciones
para la clase A, la de la pieza Z
function diresDePiezaZ(rotPieza)
/*