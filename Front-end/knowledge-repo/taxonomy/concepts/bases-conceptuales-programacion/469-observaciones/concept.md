# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 469)

## Contenido
# OBSERVACIONES:

* la semilla de par´ametro se usa como semilla inicial
* el resultado de cada n´umero seudorand´omico generado
se usa como pr´oxima semilla, y el final se retorna
*/
{
(ubicacion,nuevaSemilla)
:= randomEntre0YConSemilla(anchoDeZonaDeJuego()-1
,semilla)
(tipoPieza,nuevaSemilla)
:= randomEntre0YConSemilla(6
,nuevaSemilla)
return(leerZonaDeProximaPieza(), tipoPieza+1
,ubicacion , nuevaSemilla)
}
B.6.2. Operaciones de interacci ´on
/*=SECCI´ON 6.2======================================*
* Operaciones de interacci´on *
*==================================================*
// procedure OperacionColocarNuevaPieza()
// procedure OperacionMoverPiezaAl(dir)
// procedure OperacionRotarPieza(sentidoHorario)
// procedure OperacionAgregarDigitoASeleccion(dig)
// procedure OperacionBajarPiezas()
*==================================================*/
//----------------------------------------------------
procedure OperacionColocarNuevaPieza()
/*
