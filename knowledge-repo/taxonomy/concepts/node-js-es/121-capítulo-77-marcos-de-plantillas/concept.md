# Capítulo 77:: Marcos de plantillas

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 121)

## Contenido
# Capítulo 77:: Marcos de plantillas

Examples
Nunjucks
Motor del lado del servidor con herencia de bloque, autoescape, macros, control asíncrono y más.
Muy inspirado en jinja2, muy similar a Twig (php).
Docs - http://mozilla.github.io/nunjucks/
Instalar - npm i nunjucks
Uso básico con Express a continuación.
app.js
var express = require ('express');
var nunjucks = require('nunjucks');
var app = express();
app.use(express.static('/public'));
// Apply nunjucks and add custom filter and function (for example).
var env = nunjucks.configure(['views/'], { // set folders with templates
autoescape: true,
express: app
});
env.addFilter('myFilter', function(obj, arg1, arg2) {
console.log('myFilter', obj, arg1, arg2);
// Do smth with obj
return obj;
});
env.addGlobal('myFunc', function(obj, arg1) {
console.log('myFunc', obj, arg1);
// Do smth with obj
return obj;
});
app.get('/', function(req, res){
res.render('index.html', {title: 'Main page'});
});
app.get('/foo', function(req, res){
res.locals.smthVar = 'This is Sparta!';
res.render('foo.html', {title: 'Foo page'});
});
app.listen(3000, function() {
console.log('Example app listening on port 3000...');
});
/views/index.html
https://riptutorial.com/es/home 252

-- 280 of 423 --

<html>
<head>
<title>Nunjucks example</title>
</head>
<body>
{% block content %}
{{title}}
{% endblock %}
</body>
</html>
/views/foo.html
{% extends "index.html" %}
{# This is comment #}
{% block content %}
<h1>{{title}}</h1>
{# apply custom function and next build-in and custom filters #}
{{ myFunc(smthVar) | lower | myFilter(5, 'abc') }}
{% endblock %}
Lea Marcos de plantillas en línea: https://riptutorial.com/es/node-js/topic/5885/marcos-de-plantillas
https://riptutorial.com/es/home 253

-- 281 of 423 --
