# 9. Ejercicios

Construiréis un reloj de forma modular. En primer lugar, generaremos un pe-
queño núcleo que desencadenará un evento que informe del paso del tiem-
po. A este evento le añadiremos tres componentes diferentes que generarán
visualizaciones de la hora actual:
<html>
<head>
<title>Reloj Javascript</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"> </script>
<script type="text/javascript">
<!--
// Emplead el evento de DOM disponible
$(document).ready(function(){
/*
Cread un primer objeto que os generará
los eventos de tiempos. A él conectaréis los diferentes visores de relojes.
*/
function Rellotge()
{
// generad un primero evento
$(document).trigger('tiempo', [new Date()]);
// haced que cada segundo ejecute un evento de tiempo.
setInterval(function(){
$(document).trigger('tiempo', [new Date()]);
}, 1000);
}
// Generad una "clase" texto visor,
var TextVisor = function() {
// Cread un puntero en el this del objeto para poder
// usarlo en la función que se llama desde el evento, puesto que esta
// tiene el this del evento y no de la clase. Como es una clouser
// t es visible en la función.
var t = this.t = this;
// esta función es a la que se ha de conectar el evento, y
// desde la que ejecutaréis el manipulador
var tick = function(event, extra) {
t.pinta( event, extra );
}
// esta función renderiza el resultado del evento
this.pinta = function(event, extra) {
$( '#rellotge' ).html( t.format_string(extra) );

-- 83 of 86 --

CC-BY-SA • PID_00176160 84 CSS3 y Javascript avanzado
}
// esta función nos ayuda, dado una dato, a pintarla en formato
// correcto 00:00:00
this.format_string = function(dat) {
d = dat;
hora = d.getHours();
minuto =d.getMinutes();
if(minuto<=9)
minuto = "0"+minuto;
segundo = d.getSeconds();
if(segundo<=9)
segundo = "0"+segundo;
return hora + ":" + minuto + ":" + segundo;
}
// conectad el evento del Reloj
$(document).bind('tiempo', tick);
}
// Pintad el div con algunos estilos
$('#rellotge').css({
'font-size': '86px',
'font-family': 'Arial',
'text-align': 'center',
'padding-top': '200px'
});
// Cread una instancia del visor, este
// funcionará con el método por defecto que pinta el reloj
var visor = new TextVisor();
// Una nueva instancia, que utiliza el valor del desplegable,
// os mostrará la fecha en la zona horaria seleccionada.
var vis = new TextVisor();
vis.pinta = function(ev, extra) {
// convertimos la fecha a milisegundos para unificar las conversiones
// y le restamos la diferencia horaria de nuestro país.
temps = extra.getTime()-3600000;
// Recuperamos la diferencia horaria del desplegable
zona = Number( $('#timezone').val() );
// la sumamos a la hora actual
temps += 3600000 * zona;
$('#camp_form').val( this.format_string(new Date(temps)) );
}
// Este tercer visor conecta el reloj con la ventana del navegador.
var vis3 = new TextVisor();
vis3.pinta = function(ev, extra){
$(document).attr('title',
this.format_string(extra) );

-- 84 of 86 --

CC-BY-SA • PID_00176160 85 CSS3 y Javascript avanzado
}
// inicializamos reloj
Rellotge();
});
//-->
</script>
</head>
<body>
<div id="rellotge"></div><br /><br />
<div style="text-align:center">
<select name="DropDownTimezone" id="timezone">
<option value="-12.0">(GMT -12:00) Eniwetok, Kwajalein</option>
<option value="-11.0">(GMT -11:00) Midway Island, Samoa</option>
<option value="-10.0">(GMT -10:00) Hawaii</option>
<option value="-9.0">(GMT -9:00) Alaska</option>
<option value="-8.0">(GMT -8:00) Pacific Time (US &amp; Canada)</option>
<option value="-7.0">(GMT -7:00) Mountain Time (US &amp; Canada)</option>
<option value="-6.0">(GMT -6:00) Central Time (US &amp; Canada), Mexico City</option>
<option value="-5.0">(GMT -5:00) Eastern Time (US &amp; Canada), Bogota, Lima</option>
<option value="-4.0">(GMT -4:00) Atlantic Time (Canada), Caracas, La Paz</option>
<option value="-3.5">(GMT -3:30) Newfoundland</option>
<option value="-3.0">(GMT -3:00) Brazil, Buenos Aires, Georgetown</option>
<option value="-2.0">(GMT -2:00) Mid-Atlantic</option>
<option value="-1.0">(GMT -1:00 hour) Azores, Cape Verde Islands</option>
<option value="0.0">(GMT) Western Europe Time, London, Lisbon, Casablanca</option>
<option value="1.0" selected>(GMT +1:00 hour) Brussels, Copenhagen, Madrid, Paris</option>
<option value="2.0">(GMT +2:00) Kaliningrad, South Africa</option>
<option value="3.0">(GMT +3:00) Baghdad, Riyadh, Moscow, St. Petersburg</option>
<option value="3.5">(GMT +3:30) Tehran</option>
<option value="4.0">(GMT +4:00) Abu Dhabi, Muscat, Baku, Tbilisi</option>
<option value="4.5">(GMT +4:30) Kabul</option>
<option value="5.0">(GMT +5:00) Ekaterinburg, Islamabad, Karachi, Tashkent</option>
<option value="5.5">(GMT +5:30) Bombay, Calcutta, Madras, New Delhi</option>
<option value="5.75">(GMT +5:45) Kathmandu</option>
<option value="6.0">(GMT +6:00) Almaty, Dhaka, Colombo</option>
<option value="7.0">(GMT +7:00) Bangkok, Hanoi, Jakarta</option>
<option value="8.0">(GMT +8:00) Beijing, Perth, Singapore, Hong Kong</option>
<option value="9.0">(GMT +9:00) Tokyo, Seoul, Osaka, Sapporo, Yakutsk</option>
<option value="9.5">(GMT +9:30) Adelaide, Darwin</option>
<option value="10.0">(GMT +10:00) Eastern Australia, Guam, Vladivostok</option>
<option value="11.0">(GMT +11:00) Magadan, Solomon Islands, New Caledonia</option>
<option value="12.0">(GMT +12:00) Auckland, Wellington, Fiji, Kamchatka</option>
</select> <input type="text" name="" value="" id="camp_form">
</div>
</body>
</html>

-- 85 of 86 --

CC-BY-SA • PID_00176160 86 CSS3 y Javascript avanzado
La función Reloj inicializa un temporizador que genera eventos cada segundo,
añadiéndole la hora actual como parámetro. La función anota el evento en
el documento.
A este evento se suscribe la clase TextVisor, que representa un visor en modo
Texto. El visor tiene una función, pinta, que nos escribe la hora actual en un
div, con ID #reloj. Existe una segunda instancia de la clase TextVisor a la que
se le sobrescribe el método pinta, asociándolo al contenido de un desplegable
que os devolverá la diferencia horaria seleccionada.
Finalmente, existe una última instancia a la que también se sobrescribe la fun-
ción pinta, escribiendo el reloj en el título de la ventana del navegador.

-- 86 of 86 --