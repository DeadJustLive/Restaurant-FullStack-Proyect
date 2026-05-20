# Capítulo 110:: Uso de Browserfiy para

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 168)

## Contenido
# Capítulo 110:: Uso de Browserfiy para

resolver el error 'requerido' con los
navegadores
Examples
Ejemplo - archivo.js
En este ejemplo tenemos un archivo llamado file.js.
Supongamos que tiene que analizar una URL utilizando JavaScript y el módulo de cadena de
consulta NodeJS.
Para lograr esto, todo lo que tiene que hacer es insertar la siguiente declaración en su archivo:
const querystring = require('querystring');
var ref = querystring.parse("foo=bar&abc=xyz&abc=123");
¿Qué está haciendo este fragmento?
Bueno, primero, creamos un módulo de cadena de consulta que proporciona utilidades para
analizar y formatear cadenas de consulta de URL. Se puede acceder mediante:
const querystring = require('querystring');
Luego, analizamos una URL usando el método .parse (). Analiza una cadena de consulta de URL
(str) en una colección de pares de clave y valor.
Por ejemplo, la cadena de consulta 'foo=bar&abc=xyz&abc=123' se analiza en:
{ foo: 'bar', abc: ['xyz', '123'] }
Desafortunadamente, los navegadores no tienen el método requerido definido, pero Node.js sí.
Instalar Browserfy
Con Browserify puede escribir el código que los usos requieran de la misma manera que lo usaría
en Node. Entonces, ¿cómo resuelves esto? Es sencillo.
Primero instale el nodo, que se envía con npm. Entonces hazlo:	1.
npm instalar -g browserify
https://riptutorial.com/es/home 380

-- 408 of 423 --

Cambie al directorio en el que se encuentra su archivo.js e instale nuestro módulo de
cadena de consulta con npm:
2.
npm instalar cadena de consulta
Nota: Si no cambia en el directorio específico, el comando fallará porque no puede encontrar el
archivo que contiene el módulo.
Ahora agrupa recursivamente todos los módulos requeridos que comienzan en file.js en un
solo archivo llamado bundle.js (o como quieras llamarlo ) con el comando browserify :
3.
browserify file.js -o bundle.js
Browserify analiza el árbol de sintaxis abstracta para las llamadas require () que recorren todo el
gráfico de dependencia de su
¡Finalmente, coloca una sola etiqueta en tu html y listo!	4.
<script src="bundle.js"></script>
Lo que sucede es que obtienes una combinación de tu antiguo archivo .js ( file.js, es decir) y tu
archivo bundle.js recién creado. Esos dos archivos se fusionan en un solo archivo.
Importante
Tenga en cuenta que si desea realizar algún cambio en su archivo.js y no afectará el
comportamiento de su programa. Sus cambios solo tendrán efecto si edita el
bundle.js recién creado.
Qué significa eso?
Esto significa que si desea editar file.js por cualquier motivo, los cambios no tendrán ningún
efecto. Realmente tienes que editar bundle.js ya que es una combinación de bundle.js y file.js.
Lea Uso de Browserfiy para resolver el error 'requerido' con los navegadores en línea:
https://riptutorial.com/es/node-js/topic/7123/uso-de-browserfiy-para-resolver-el-error--requerido--
con-los-navegadores
https://riptutorial.com/es/home 381

-- 409 of 423 --
