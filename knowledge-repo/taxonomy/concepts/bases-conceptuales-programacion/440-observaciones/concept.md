# OBSERVACIONES:

## Fuente
bases-conceptuales-programacion (Cap. 440)

## Contenido
# OBSERVACIONES:

* no cambia la celda actual
*/
{
Mover(dir1);Mover(dir2)
TransformarCeldaEnPiso(marca)
Mover(opuesto(dir1));Mover(opuesto(dir2))
}
B.5.4. Operaciones para eliminar filas llenas
/*=SECCI´ON 5.4=====================================*
* Procesamiento del juego (EliminarFilasLlenas) *
*=================================================*
// procedure EliminarFilasLlenas()
// procedure EliminarMientrasSigaLlena()
// function esFilaLlena()
// procedure BajarFilasSobreEsta()
// procedure BajarFilaSuperior()
// procedure VaciarDePisoLaFilaActual()
// procedure QuitarPiso()
*=================================================*/
//----------------------------------------------------
procedure EliminarFilasLlenas()
/*
