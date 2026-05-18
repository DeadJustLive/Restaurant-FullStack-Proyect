# 1. Anidar sin usar niños.

(continuado desde arriba)
var CommentList = reactCreateClass({
render: function() {
return (
<div className="commentList">
<ListTitle/>
Hello, world! I am a CommentList.
</div>
);
}
});
Este es el estilo donde A compone B y B compone C.
Pros
Fácil y rápido de separar elementos de la interfaz de usuario	•
Fácil de inyectar accesorios a los niños según el estado del componente principal	•
Contras
Menos visibilidad en la arquitectura de la composición.	•
Menos reusabilidad	•
Bien si
B y C son solo componentes de presentación	•
B debe ser responsable del ciclo de vida de C	•