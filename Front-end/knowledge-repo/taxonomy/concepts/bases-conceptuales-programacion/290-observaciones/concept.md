# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 290)

## Contenido
# OBSERVACIONES:

* si no hay d´ıgito, lo agrega
* si se excede, lo vuelve a 0
*/
{
// Agrega un d´ıgito si no lo hab´ıa
if (not hayDigito()) { Poner(Azul) }
// Incrementa dicho d´ıgito
Poner(Negro)
// Si se excede, vuelve a 0
if (leerDigito() == 10) { SacarN(Negro, 10) }
}
B.2.3. Operaciones de zonas espec´ıficas
/*=SECCI´ON 2.3======================================*
* Operaciones de zonas espec´ıficas *
*==================================================*
// procedure IrAlOrigenDeZonaDeProximaPieza()
// procedure IrAlOrigenDeZonaDeSeleccion()
// procedure IrAlOrigenDeZonaDeSemilla()
//
// function leerZonaDeProximaPieza()
// function leerZonaDeSeleccion()
// function leerSemilla()
//
// procedure BorrarZonaDeProximaPieza()
// procedure BorrarZonaDeSeleccion()
//
// procedure AgregarDigitoASeleccion(dig)
// procedure IncrementarZonaDeProximaPieza()
// procedure GrabarSemilla(semilla)
*==================================================*/
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 267 of 312 --

268
//----------------------------------------------------
procedure IrAlOrigenDeZonaDeProximaPieza()
/*
