# 2. Anidar usando niños.

https://riptutorial.com/es/home 32

-- 42 of 139 --

(continuado desde arriba)
var CommentBox = reactCreateClass({
render: function() {
return (
<div className="commentBox">
<h1>Comments</h1>
<CommentList>
<ListTitle/> // child
</CommentList>
<CommentForm />
</div>
);
}
});
Este es el estilo en el que A compone B y A le dice a B que componga C. Más poder para los
componentes principales.
Pros
Mejor gestión del ciclo de vida de los componentes.	•
Mejor visibilidad en la arquitectura de la composición.	•
Mejor reusuabilidad	•
Contras
Inyectar accesorios puede ser un poco caro.	•
Menos flexibilidad y potencia en componentes infantiles	•
Bien si
B debería aceptar componer algo diferente de C en el futuro o en otro lugar	•
A debe controlar el ciclo de vida de C	•
B representaría a C usando this.props.children , y no hay una forma estructurada para que B
sepa para qué sirven esos niños. Entonces, B puede enriquecer los componentes secundarios al
dar apoyo adicional, pero si B necesita saber exactamente qué son, el # 3 podría ser una mejor
opción.