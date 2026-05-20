# Capítulo 6:: Componentes

## Fuente
react-stackoverflow-docs (Cap. 41)

## Contenido
# Capítulo 6:: Componentes

Observaciones
React.createClass quedó en desuso en v15.5 y se espera que se elimine en v16 . Hay un paquete
de reemplazo para aquellos que todavía lo requieren. Los ejemplos que lo usan deben ser
actualizados.
Examples
Componente basico
Dado el siguiente archivo HTML:
index.html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>React Tutorial</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.2.1/react.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.2.1/react-dom.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-
core/5.8.34/browser.min.js"></script>
</head>
<body>
<div id="content"></div>
<script type="text/babel" src="scripts/example.js"></script>
</body>
</html>
Puede crear un componente básico utilizando el siguiente código en un archivo separado:
scripts / example.js
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
class FirstComponent extends Component {
render() {
return (
<div className="firstComponent">
Hello, world! I am a FirstComponent.
</div>
);
}
}
ReactDOM.render(
<FirstComponent />, // Note that this is the same as the variable you stored above
document.getElementById('content')
);
https://riptutorial.com/es/home 30

-- 40 of 139 --

Obtendrá el siguiente resultado (tenga en cuenta lo que está dentro del div#content ):
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>React Tutorial</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.2.1/react.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.2.1/react-dom.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-
core/5.8.34/browser.min.js"></script>
</head>
<body>
<div id="content">
<div className="firstComponent">
Hello, world! I am a FirstComponent.
</div>
</div>
<script type="text/babel" src="scripts/example.js"></script>
</body>
</html>
Componentes de anidación
Gran parte del poder de ReactJS es su capacidad para permitir el anidamiento de componentes.
Tome los siguientes dos componentes:
var React = require('react');
var createReactClass = require('create-react-class');
var CommentList = reactCreateClass({
render: function() {
return (
<div className="commentList">
Hello, world! I am a CommentList.
</div>
);
}
});
var CommentForm = reactCreateClass({
render: function() {
return (
<div className="commentForm">
Hello, world! I am a CommentForm.
</div>
);
}
});
Puede anidar y referirse a esos componentes en la definición de un componente diferente:
var React = require('react');
var createReactClass = require('create-react-class');
var CommentBox = reactCreateClass({
render: function() {
https://riptutorial.com/es/home 31

-- 41 of 139 --

return (
<div className="commentBox">
<h1>Comments</h1>
<CommentList /> // Which was defined above and can be reused
<CommentForm /> // Same here
</div>
);
}
});
La anidación adicional se puede hacer de tres maneras, todas ellas tienen sus propios lugares
para ser utilizados.
