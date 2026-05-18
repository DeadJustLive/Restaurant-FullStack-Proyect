# 3. Anidar utilizando puntales.

## Fuente
react-stackoverflow-docs (Cap. 44)

## Contenido
# 3. Anidar utilizando puntales.

(continuado desde arriba)
var CommentBox = reactCreateClass({
render: function() {
return (
<div className="commentBox">
https://riptutorial.com/es/home 33

-- 43 of 139 --

<h1>Comments</h1>
<CommentList title={ListTitle}/> //prop
<CommentForm />
</div>
);
}
});
Este es el estilo donde A compone B y B proporciona una opción para que A pase algo para
componer para un propósito específico. Composición más estructurada.
Pros
La composición como característica	•
Validación fácil	•
Mejor composibilidad	•
Contras
Inyectar accesorios puede ser un poco caro.	•
Menos flexibilidad y potencia en componentes infantiles	•
Bien si
B tiene características específicas definidas para componer algo.	•
B solo debe saber cómo renderizar no qué renderizar	•
