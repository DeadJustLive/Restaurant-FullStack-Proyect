# PRECONDICIONES:

## Fuente
bases-conceptuales-programacion (Cap. 344)

## Contenido
# PRECONDICIONES:

* la rotaci´on es v´alida (y puede llevar una
marca de 7 bolitas rojas)
*/
{
switch (rotPieza) to
1,8 -> -- La rotaci´on ‘‘natural’’
{
ndirA := dirA
ndirB := dirB
ndirC1 := dirC1
ndirC2 := dirC2
}
2,9 -> -- 1/4 de giro en sentido horario
{
ndirA := siguiente(dirA)
ndirB := siguiente(dirB)
ndirC1 := siguiente(dirC1)
ndirC2 := siguiente(dirC2)
}
3,10 -> -- 1/2 giro
{
ndirA := opuesto(dirA)
ndirB := opuesto(dirB)
ndirC1 := opuesto(dirC1)
ndirC2 := opuesto(dirC2)
}
4,11 -> -- 1/4 de giro en sentido antihorario
{
ndirA := previo(dirA)
ndirB := previo(dirB)
ndirC1 := previo(dirC1)
ndirC2 := previo(dirC2)
}
_ -> { }
return (ndirA,ndirB,ndirC1,ndirC2)
}
B.3.2. Detecci ´on de piezas
/*=SECCI´ON 3.2=====================================*
* Detecci´on de piezas o su ausencia *
*=================================================*
// function esSeccionDeAlgunaPieza()
// function esSeccionPivoteDeAlgunaPieza()
// function esSeccionPivoteDePieza(codPieza)
// function hayPiezaActual()
//
// function leerCodigoDePiezaActual()
// function leerTipoDePiezaActual()
// function leerRotacionDePiezaActual()
//
// function hayLugarParaPiezaTipo(tipoPieza, rotPieza)
// function hayLgPzClaseAEnDires(dirA,dirB,dirC1,dirC2)
// function hayLgPzClaseBEnDires(dirA,dirB,dirC)
// function esCeldaLibre()
// function hayCeldaLibreAl(dir)
// function hayCeldaLibreAlY(dir1,dir2)
//-----------------------------------------------------
*=================================================*/
//-----------------------------------------------------
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 276 of 312 --

277
//-----------------------------------------------------
function esSeccionDeAlgunaPieza()
/*
PROP´OSITO: determinar si la celda actual es
secci´on pivote de alguna pieza
*/
{ return (hayBolitas(Verde)) }
//----------------------------------------------------
function esSeccionPivoteDeAlgunaPieza()
/*
PROP´OSITO: determinar si la celda actual es la
secci´on pivote de una pieza
*/
{
return (esSeccionDeAlgunaPieza()
&& hayBolitas(Negro)
&& hayBolitas(Rojo))
}
//-----------------------------------------------------
function esSeccionPivoteDePieza(codPieza)
/*
PROP´OSITO: determinar si la celda actual es la
secci´on pivote de la pieza codPieza
*/
{ return (esSeccionPivoteDeAlgunaPieza()
&& nroBolitas(Verde)==codPieza) }
//----------------------------------------------------
function hayPiezaActual()
/*
PROP´OSITO: establecer si la celda actual determina
una pieza seleccionada, lo cual por
convenci´on quiere decir que est´a sobre
la secci´on pivote de una pieza
*/
{ return (esSeccionPivoteDeAlgunaPieza()) }
//----------------------------------------------------
//----------------------------------------------------
function leerCodigoDePiezaActual()
/*
PROP´OSITO: determinar el c´odigo de la pieza actual
