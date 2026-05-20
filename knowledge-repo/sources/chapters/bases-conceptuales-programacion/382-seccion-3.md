# /*=SECCI´ON 3=======================================*

* Operaciones para expresar las piezas *
* *
* Las piezas se representan con bolitas verdes *
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 270 of 312 --

271
* (tantas como el c´odigo de pieza) y su *
* pivote se representa con bolitas negras *
* (tantas como el tipo de pieza) y rojas *
* (tantas como la rotaci´on de la pieza). *
* *
* Negras: *
* 1: pieza Z *
* 2: pieza I ZZ I L FF OO SS *
* 3: pieza L XZ X X X XO SX TXT *
* 4: pieza F I LL F T *
* 5: pieza O I *
* 6: pieza T (X marca el pivote *
* 7: pieza S en rotaci´on 1) *
* Rojas: *
* 1: original, pivote marcado con X *
* 2: 1/4 de giro horario *
* 3: 1/2 de giro *
* 4: 1/4 de giro antihorario *
* (puede estar marcada con 7 extras) *
* Cada pieza tiene un ´unico pivote. *
* Las piezas clase A tienen dos partes *
* directamente adyacentes y otra a en *
* diagonal al pivote. Las piezas clase B *
* tienen las 3 partes directamente adyacentes *
* *
*=================================================*
// 3.1. Geometr´ıa de las piezas
// 3.2. Detecci´on de piezas
*=================================================*/
B.3.1. Geometr´ıa de las piezas
/*=SECCI´ON 3.1=====================================*
* Geometr´ıa de las piezas *
*=================================================*
// function rotar(rotacion,sentidoHorario)
//
// function esClaseA(tipoPieza)
// function esClaseB(tipoPieza)
// function diresDePiezaClaseA(tipoPieza,rotPieza)
// function diresDePiezaClaseB(tipoPieza,rotPieza)
// function diresDePiezaZ(rotPieza)
// function diresDePiezaI(rotPieza)
// function diresDePiezaL(rotPieza)
// function diresDePiezaF(rotPieza)
// function diresDePiezaO(rotPieza)
// function diresDePiezaS(rotPieza)
// function diresDePiezaT(rotPieza)
//
// function id(dA,dB,dC1,dC2)
// function ajustarDires(dA,dB,dC1,dC2,rotPieza)
*=================================================*/
//-----------------------------------------------------
//----------------------------------------------------
function rotar(rotacionBase,sentidoHorario)
/*
PROP´OSITO: calcular la rotacion siguiente en
sentido horario o antihorario, seg´un
lo indique el booleano sentidoHorario