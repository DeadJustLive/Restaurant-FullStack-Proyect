# REST

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 116)

## Contenido
# REST

Introducción
Conectores basados en reposo y cómo tratar con ellos. Todos sabemos que Loopback no
proporciona elegancia a las conexiones basadas en REST.
Examples
Agregar un conector basado en web
// Este ejemplo obtiene la respuesta de iTunes
{
"descanso": {
"nombre": "resto",
"conector": "resto",
"depurar": verdadero,
"opciones": {
"useQuerystring": verdadero,
"tiempo de espera": 10000,
"encabezados": {
"acepta": "aplicación / json",
"tipo de contenido": "aplicación / json"
}
}
"operaciones": [
{
"modelo": {
"método": "OBTENER",
"url": "https://itunes.apple.com/search",
"consulta": {
"term": "{keyword}",
"country": "{country = IN}",
"media": "{itemType = music}",
"límite": "{límite = 10}",
"explícito": "falso"
}
}
"funciones": {
"buscar": [
"palabra clave",
"país",
"tipo de artículo",
"límite"
]
}
}
{
"modelo": {
"método": "OBTENER",
"url": "https://itunes.apple.com/lookup",
"consulta": {
https://riptutorial.com/es/home 241

-- 269 of 423 --

"yo si}"
}
}
"funciones": {
"findById": [
"carné de identidad"
]
}
}
]
}
}
Lea Loopback - Conector basado en REST en línea: https://riptutorial.com/es/node-
js/topic/9234/loopback---conector-basado-en-rest
https://riptutorial.com/es/home 242

-- 270 of 423 --
