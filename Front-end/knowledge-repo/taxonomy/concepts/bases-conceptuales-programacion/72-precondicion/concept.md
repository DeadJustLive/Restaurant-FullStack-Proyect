# PRECONDICI´ON:

## Fuente
bases-conceptuales-programacion (Cap. 72)

## Contenido
# PRECONDICI´ON:

* este c´odigo siempre produce la autodestrucci´on
-}
{
color := Negro -- color no puede ser una variable,
-- pues es un par´ametro
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 162 of 312 --

163
cantidad := 1
foreach cantidad in [1..5]
-- cantidad no puede ser un ´ındice,
-- pues es una variable
{
PonerN(cantidad, color)
-- hace referencia a un ´ındice o a una variable?
}
}
Actividad de Programaci ´on 23
Escribir el c ´odigo del ejemplo anterior, y realizar cambios en los nombres de
las variables, par ´ametro o ´ındices, hasta que ejecute correctamente. ¿Cu ´al es
el efecto de este procedimiento? ¿Podr´ıa renombrar los elementos de manera
diferente para producir otro efecto distinto?
Leer con Atenci ´on
GOBSTONES separa de manera clara las nociones de variable, par ´ametro e ´ındi-
ce. Esto es as´ı con el objetivo de que resulte clara la distinci ´on entre las 3 ideas.
Sin embargo, en otros lenguajes se utilizan los nombres de maneras indistintas,
ya sea para denotar par ´ametros, variables o ´ındices, y puede resulta confuso
para quien no tiene las ideas claras.
Utilizando variables hay ciertas operaciones que son m ´as sencillas de expresar, o m ´as
f ´aciles de generalizar. En los pr ´oximos ejemplos revisaremos algunas de las operaciones
vistas en secciones o cap´ıtulos anteriores, para modificarles a trav ´es del uso de variables.
El primero de los ejemplos a revisar es la funci ´on hayEnemigosCercaAlNorte de la
subsecci ´on 3.3.2. En dicho ejemplo, la funci ´on deb´ıa devolver un booleano indicando si
hab´ıa enemigos en alguna de las 3 celdas hacia el norte de la actual. Para realizarlo,
utilizamos el truco de codificar la existencia de enemigos con bolitas azules en la celda
actual y al terminar retornamos si hab´ıa o no bolitas azules en dicha celda. Pero este
ejercicio podr´ıa hacerse sin codificar con bolitas, recordando si hay o no enemigos en una
variable. El c ´odigo ser´ıa:
function hayEnemigosCercaAlNorte()
{-
