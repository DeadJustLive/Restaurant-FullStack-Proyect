# Capítulo 41:: Enrutamiento de solicitudes ajax

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 79)

## Contenido
# Capítulo 41:: Enrutamiento de solicitudes ajax

con Express.JS
Examples
Una implementación sencilla de AJAX.
Debes tener la plantilla básica de generador express
En app.js, agregue (puede agregarlo en cualquier lugar después de var app = express.app() ):
app.post(function(req, res, next){
next();
});
Ahora en su archivo index.js (o su respectiva coincidencia), agregue:
router.get('/ajax', function(req, res){
res.render('ajax', {title: 'An Ajax Example', quote: "AJAX is great!"});
});
router.post('/ajax', function(req, res){
res.render('ajax', {title: 'An Ajax Example', quote: req.body.quote});
});
Cree un ajax.jade / ajax.pug o ajax.ejs en el directorio /views , agregue:
Para Jade / PugJS:
extends layout
script(src="http://code.jquery.com/jquery-3.1.0.min.js")
script(src="/magic.js")
h1 Quote: !{quote}
form(method="post" id="changeQuote")
input(type='text', placeholder='Set quote of the day', name='quote')
input(type="submit", value="Save")
Para EJS:
<script src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="/magic.js"></script>
<h1>Quote: <%=quote%> </h1>
<form method="post" id="changeQuote">
<input type="text" placeholder="Set quote of the day" name="quote"/>
<input type="submit" value="Save">
</form>
Ahora, crea un archivo en /public llamado magic.js
$(document).ready(function(){
https://riptutorial.com/es/home 147

-- 175 of 423 --

$("form#changeQuote").on('submit', function(e){
e.preventDefault();
var data = $('input[name=quote]').val();
$.ajax({
type: 'post',
url: '/ajax',
data: data,
dataType: 'text'
})
.done(function(data){
$('h1').html(data.quote);
});
});
});
¡Y ahí lo tienes! Al hacer clic en Guardar, la cotización cambiará!
Lea Enrutamiento de solicitudes ajax con Express.JS en línea: https://riptutorial.com/es/node-
js/topic/6738/enrutamiento-de-solicitudes-ajax-con-express-js
https://riptutorial.com/es/home 148

-- 176 of 423 --
