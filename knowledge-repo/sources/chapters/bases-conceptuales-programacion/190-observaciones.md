# OBSERVACIONES:

* se estructura como un recorrido sobre los d´ıgitos
codificados en la zona de n´umeros
* total guarda el n´umero le´ıdo hasta el momento
* posDig guarda la pr´oxima unidad a leer
*/
{
total := 0
posDig := 1
while(hayDigito() && puedeMoverEnZonaDeNumeroAl(Oeste))
{
// cada digito contribuye seg´un su posici´on
total := leerDigito() * posDig + total
posDig := posDig * 10 // base 10
Mover(Oeste)
}
// si no pudo mover al Oeste y hay d´ıgito, no ley´o el
// ´ultimo d´ıgito
if (hayDigito() && not puedeMoverEnZonaDeNumeroAl(Oeste))
{
// cada digito contribuye seg´un su posici´on
total := leerDigito() * posDig + total
posDig := posDig * 10 // base 10
}
return(total)
}
Es interesante observar que existen dos formas de finalizar: cuando deja de haber d´ıgitos
pero a ´un hay espacio (se encuentra una celda vac´ıa donde no hay d´ıgito), o se encuentra
el borde izquierdo de la zona. En este ´ultimo caso el ´ultimo d´ıgito debe procesarse por se-
parado. La variable posDig almacena si el pr ´oximo d´ıgito a leer es de unidades, decenas,
centenas, etc ´etera. De ah´ı que sea inicializado en uno y que en cada repetici ´on se multi-
plique por 10 (la base de numeraci ´on). Las funciones auxiliares hayDigito y leerDigito
se dejan como ejercicio.
Actividad de Programaci ´on 3
Realice el ejercicio 5.2.3. Recuerde indicar adecuadamente las precondiciones
correspondientes. Luego de realizarlo, verifique con el c ´odigo del anexo B que
realiz ´o el ejercicio correctamente.
Ejercicio 5.2.3. Definir las siguientes funciones auxiliares
1. hayDigito, que indique si en la celda actual hay o no un d´ıgito. Recordar que la
presencia de un d´ıgito se indica con una bolita azul, la cantidad se indica con bolitas
negras, y que el d´ıgito debe estar entre 0 y 9.
2. leerDigito, que, suponiendo que en la celda actual hay un d´ıgito correctamente
codificado, retorna la cantidad representada por ese d´ıgito.
Por otra parte, el procedimiento GrabarNumeroEnZonaDeNumeros se encarga de codificar
el n ´umero dado dentro de la zona de n ´umeros actual. El c ´odigo se estructura como un
recorrido sobre los d´ıgitos del n ´umero, desde las unidades. En cada repetici ´on se divide al
n ´umero por 10 (la base de numeraci ´on), lo cual deja disponible el siguiente d´ıgito para la
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 189 of 312 --

190
siguiente repetici ´on. Adem ´as, al iniciar debe borrarse la zona de n ´umeros actual para evi-
tar que se superpongan las representaciones de m ´as de un n ´umero. El c ´odigo resultante
ser ´a
procedure GrabarNumeroEnZonaDeNumeros(numero)
/*
PROP´OSITO: guardar el n´umero dado en la zona de
n´umeros actual