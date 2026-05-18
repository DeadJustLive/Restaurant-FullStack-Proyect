# Chapter 11

Programación Asíncrona
La parte central de una computadora, la parte que lleva a cabo los pasos
individuales que componen nuestros programas, se llama el procesador. Los
programas que hemos visto hasta ahora mantendrán ocupado al procesador
hasta que hayan terminado su trabajo. La velocidad a la cual algo como un
bucle que manipula números puede ser ejecutado depende casi enteramente de
la velocidad del procesador y la memoria de la computadora.
Pero muchos programas interactúan con cosas fuera del procesador. Por
ejemplo, pueden comunicarse a través de una red de computadoras o solicitar
datos desde el disco duro, lo cual es mucho más lento que obtenerlo de la
memoria.
Cuando esto está sucediendo, sería una lástima dejar el procesador inactivo,
ya que podría haber otro trabajo que podría hacer en ese tiempo. En parte,
esto es manejado por tu sistema operativo, el cual cambiará el procesador entre
múltiples programas en ejecución. Pero eso no ayuda cuando queremos que un
único programa pueda avanzar mientras espera una solicitud de red.
Asincronía
En un modelo de programación sincrónico, las cosas suceden una a la vez.
Cuando llamas a una función que realiza una acción de larga duración, solo
devuelve cuando la acción ha terminado y puede devolver el resultado. Esto
detiene tu programa durante el tiempo que tome la acción.
Un modelo asincrónico permite que múltiples cosas sucedan al mismo tiempo.
Cuando inicias una acción, tu programa continúa ejecutándose. Cuando la
acción termina, el programa es informado y obtiene acceso al resultado (por
ejemplo, los datos leídos desde el disco).
Podemos comparar la programación sincrónica y asincrónica usando un pe-
queño ejemplo: un programa que realiza dos solicitudes a través de la red y
luego combina los resultados.
En un entorno sincrónico, donde la función de solicitud devuelve solo después
179

-- 191 of 445 --

de haber hecho su trabajo, la forma más fácil de realizar esta tarea es hacer las
solicitudes una después de la otra. Esto tiene la desventaja de que la segunda
solicitud se iniciará solo cuando la primera haya terminado. El tiempo total
tomado será al menos la suma de los dos tiempos de respuesta.
La solución a este problema, en un sistema sincrónico, es iniciar hebras de
control adicionales. Una hebra es otro programa en ejecución cuya ejecución
puede ser intercalada con otros programas por el sistema operativo, ya que
la mayoría de las computadoras modernas contienen múltiples procesadores,
múltiples hebras incluso podrían ejecutarse al mismo tiempo, en diferentes
procesadores. Una segunda hebra podría iniciar la segunda solicitud, y luego
ambas hebras esperan que sus resultados regresen, después de lo cual se resin-
cronizan para combinar sus resultados.
En el siguiente diagrama, las líneas gruesas representan el tiempo que el
programa pasa funcionando normalmente, y las líneas delgadas representan el
tiempo gastado esperando a la red. En el modelo síncrono, el tiempo tomado
por la red es parte de la línea de tiempo para un hilo de control dado. En el
modelo asíncrono, iniciar una acción en la red permite que el programa continúe
ejecutándose mientras la comunicación en la red sucede junto a él, notificando
al programa cuando haya terminado.
synchronous, single thread of control
synchronous, two threads of control
asynchronous
Otra forma de describir la diferencia es que esperar a que las acciones termi-
nen es implícito en el modelo síncrono, mientras que es explícito, bajo nuestro
control, en el modelo asíncrono.
La asincronía tiene sus pros y sus contras. Facilita la expresión de programas
que no encajan en el modelo de control de línea recta, pero también puede
hacer que expresar programas que siguen una línea recta sea más complicado.
Veremos algunas formas de reducir esta dificultad más adelante en el capítulo.
Tanto las plataformas de programación de JavaScript prominentes —navegadores
como Node.js— hacen operaciones que podrían tardar un tiempo de forma
asíncrona, en lugar de depender de hilos. Dado que programar con hilos es
notoriamente difícil (entender lo que hace un programa es mucho más difícil
cuando está haciendo múltiples cosas a la vez), esto generalmente se considera
180

-- 192 of 445 --

algo bueno.
Retrollamadas
Un enfoque para la programación asíncrona es hacer que las funciones que
necesitan esperar por algo tomen un argumento adicional, una función de de-
volución de llamada. La función asíncrona inicia algún proceso, configura las
cosas para que se llame a la función de devolución de llamada cuando el proceso
termine, y luego retorna.
Como ejemplo, la función setTimeout, disponible tanto en Node.js como en
los navegadores, espera un número dado de milisegundos (un segundo equivale
a mil milisegundos) y luego llama a una función.
setTimeout(() => console.log("Tick"), 500);
Esperar no suele ser un tipo de trabajo muy importante, pero puede ser muy
útil cuando necesitas organizar que algo suceda en un momento determinado o
verificar si alguna otra acción está tomando más tiempo del esperado.
Otro ejemplo de una operación asincrónica común es leer un archivo desde el
almacenamiento de un dispositivo. Imagina que tienes una función readTextFile
, la cual lee el contenido de un archivo como una cadena y lo pasa a una función
de devolución de llamada.
readTextFile("lista_de_compras.txt", contenido => {
console.log(`Lista de Compras:\n${contenido}`);
});
// → Lista de Compras:
// → Mantequilla de cacahuate
// → Plátanos
La función readTextFile no es parte del estándar de JavaScript. Veremos cómo
leer archivos en el navegador y en Node.js en capítulos posteriores.
Realizar múltiples acciones asincrónicas en fila usando devoluciones de lla-
mada significa que tienes que seguir pasando nuevas funciones para manejar la
continuación de la computación después de las acciones. Así es como podría
verse una función asincrónica que compara dos archivos y produce un booleano
que indica si su contenido es el mismo.
function compararArchivos(archivoA, archivoB, devolucionLlamada) {
readTextFile(archivoA, contenidoA => {
readTextFile(archivoB, contenidoB => {
devolucionLlamada(contenidoA == contenidoB);
});
181

-- 193 of 445 --

});
}
Este estilo de programación es funcional, pero el nivel de indentación aumenta
con cada acción asincrónica porque terminas en otra función. Hacer cosas
más complicadas, como envolver acciones asincrónicas en un bucle, puede ser
incómodo.
De alguna manera, la asincronía es contagiosa. Cualquier función que llame a
una función que trabaja de forma asincrónica debe ser asincrónica en sí misma,
utilizando una devolución de llamada u otro mecanismo similar para entregar
su resultado. Llamar a una devolución de llamada es algo más complicado
y propenso a errores que simplemente devolver un valor, por lo que necesitar
estructurar grandes partes de tu programa de esa manera no es ideal.
Promesas
Una forma ligeramente diferente de construir un programa asincrónico es hacer
que las funciones asincrónicas devuelvan un objeto que represente su resultado
(futuro) en lugar de pasar devoluciones de llamada por todas partes. De esta
manera, tales funciones realmente devuelven algo significativo, y la estructura
del programa se asemeja más a la de los programas síncronos.
Para esto sirve la clase estándar Promise. Una promesa es un recibo que
representa un valor que aún puede no estar disponible. Proporciona un método
then que te permite registrar una función que debe ser llamada cuando la acción
por la que está esperando finalice. Cuando la promesa se resuelve, es decir, su
valor se vuelve disponible, esas funciones (puede haber varias) son llamadas
con el valor del resultado. Es posible llamar a then en una promesa que ya ha
sido resuelta; tu función seguirá siendo llamada.
La forma más sencilla de crear una promesa es llamando a Promise.resolve.
Esta función se asegura de que el valor que le proporcionas esté envuelto en
una promesa. Si ya es una promesa, simplemente se devuelve; de lo contrario,
obtienes una nueva promesa que se resuelve de inmediato con tu valor como
resultado.
let quince = Promise.resolve(15);
quince.then(valor => console.log(`Obtenido ${valor}`));
// → Obtenido 15
Para crear una promesa que no se resuelva inmediatamente, puedes utilizar
Promise como constructor. Tiene una interfaz un tanto extraña: el constructor
espera una función como argumento, la cual llama inmediatamente, pasándole
182

-- 194 of 445 --

una función que puede utilizar para resolver la promesa.
Así es como podrías crear una interfaz basada en promesas para la función
readTextFile:
function textFile(nombreArchivo) {
return new Promise(resolve => {
readTextFile(nombreArchivo, texto => resolve(texto));
});
}
textFile("planes.txt").then(console.log);
Observa cómo esta función asíncrona devuelve un valor significativo: una promesa
para proporcionarte el contenido del archivo en algún momento futuro.
Una característica útil del método then es que él mismo devuelve otra promesa
que se resuelve al valor retornado por la función de devolución de llamada o,
si esa función devuelve una promesa, al valor al que esa promesa se resuelve.
De esta forma, puedes “encadenar” varias llamadas a then para configurar una
secuencia de acciones asíncronas.
Esta función, la cual lee un archivo lleno de nombres de archivos y devuelve
el contenido de un archivo aleatorio de esa lista, muestra este tipo de cadena
asíncrona de promesas.
function randomFile(archivoLista) {
return textFile(archivoLista)
.then(contenido => contenido.trim().split("\n"))
.then(ls => ls[Math.floor(Math.random() * ls.length)])
.then(nombreArchivo => textFile(nombreArchivo));
}
La función devuelve el resultado de esta cadena de llamadas a then. La promesa
inicial obtiene la lista de archivos como una cadena. La primera llamada a then
transforma esa cadena en un array de líneas, produciendo una nueva promesa.
La segunda llamada a then elige una línea aleatoria de eso, produciendo una
tercera promesa que arroja un único nombre de archivo. La llamada final a
then lee este archivo, de modo que el resultado de la función en su totalidad es
una promesa que devuelve el contenido de un archivo aleatorio.
En este código, las funciones utilizadas en las primeras dos llamadas a then
devuelven un valor regular, que se pasará inmediatamente a la promesa devuelta
por then cuando la función regrese. La última devuelve una promesa (textFile
(nombreArchivo)), convirtiéndola en un paso asincrónico real.
También habría sido posible realizar todos estos pasos dentro de un solo
callback de then, ya que solo el último paso es realmente asíncrono. Pero
183

-- 195 of 445 --

los tipos de envolturas then que solo realizan alguna transformación de datos
síncrona son a menudo útiles, por ejemplo, cuando deseas devolver una promesa
que produzca una versión procesada de algún resultado asíncrono.
function jsonFile(nombreArchivo) {
return textFile(nombreArchivo).then(JSON.parse);
}
jsonFile("package.json").then(console.log);
En general, es útil pensar en las promesas como un mecanismo que permite al
código ignorar la pregunta de cuándo va a llegar un valor. Un valor normal
tiene que existir realmente antes de que podamos hacer referencia a él. Un
valor prometido es un valor que puede estar allí o podría aparecer en algún
momento en el futuro. Las operaciones definidas en términos de promesas, al
conectarlas con llamadas then, se ejecutan de forma asíncrona a medida que
sus entradas están disponibles.
Falla
Las computaciones regulares de JavaScript pueden fallar al lanzar una excep-
ción. Las computaciones asíncronas a menudo necesitan algo así. Una solicitud
de red puede fallar, un archivo puede no existir, o algún código que forma parte
de la computación asíncrona puede lanzar una excepción.
Uno de los problemas más apremiantes con el estilo de programación asín-
crona basado en devoluciones de llamada es que hace extremadamente difícil
asegurarse de que las fallas se informen adecuadamente a las devoluciones de
llamada.
Una convención ampliamente utilizada es que el primer argumento de la
devolución de llamada se utiliza para indicar que la acción falló, y el segundo
contiene el valor producido por la acción cuando fue exitosa.
unaFuncionAsincrona((error, valor) => {
if (error) manejarError(error);
else procesarValor(valor);
});
Tales funciones de devolución de llamada siempre deben verificar si recibieron
una excepción y asegurarse de que cualquier problema que causen, incluidas
las excepciones lanzadas por las funciones que llaman, se capturen y se den a
la función correcta.
Las promesas facilitan esto. Pueden ser o bien resueltas (la acción se com-
184

-- 196 of 445 --

pletó con éxito) o rechazadas (falló). Los manejadores de resolución (como se
registran con then) se llaman solo cuando la acción es exitosa, y los rechazos se
propagan a la nueva promesa que es devuelta por then. Cuando un manejador
lanza una excepción, esto causa automáticamente que la promesa producida
por la llamada a su then sea rechazada. Entonces, si algún elemento en una
cadena de acciones asíncronas falla, el resultado de toda la cadena se marca
como rechazado, y no se llaman manejadores de éxito más allá del punto donde
falló.
Al igual que resolver una promesa proporciona un valor, rechazar una tam-
bién lo hace, generalmente llamado el motivo del rechazo. Cuando una excep-
ción en una función manejadora causa el rechazo, el valor de la excepción se usa
como el motivo. De manera similar, cuando una función manejadora devuelve
una promesa que es rechazada, ese rechazo fluye hacia la siguiente promesa. Ex-
iste una función Promise.reject que crea una nueva promesa inmediatamente
rechazada.
Para manejar explícitamente tales rechazos, las promesas tienen un método
catch que registra un manejador para ser llamado cuando la promesa es rec-
hazada, similar a cómo los manejadores de then manejan la resolución normal.
También es muy similar a then en que devuelve una nueva promesa, que se
resuelve con el valor de la promesa original cuando se resuelve normalmente y
con el resultado del manejador catch en caso contrario. Si un manejador de
catch lanza un error, la nueva promesa también se rechaza.
Como un atajo, then también acepta un manejador de rechazo como se-
gundo argumento, para poder instalar ambos tipos de manejadores en una sola
llamada de método.
Una función pasada al constructor Promise recibe un segundo argumento,
junto con la función de resolución, que puede usar para rechazar la nueva
promesa.Cuando nuestra función readTextFile encuentra un problema, pasa el
error a su función de devolución de llamada como segundo argumento. Nuestro
envoltorio textFile debería realmente examinar ese argumento, de manera que
un fallo cause que la promesa que devuelve sea rechazada.
function textFile(filename) {
return new Promise((resolve, reject) => {
readTextFile(filename, (text, error) => {
if (error) reject(error);
else resolve(text);
});
});
}
185

-- 197 of 445 --

Las cadenas de valores de promesa creadas por llamadas a then y catch for-
man así un pipeline a través del cual se mueven los valores asíncronos o fallos.
Dado que dichas cadenas se crean registrando manejadores, cada eslabón tiene
asociado un manejador de éxito o un manejador de rechazo (o ambos). Los
manejadores que no coinciden con el tipo de resultado (éxito o fallo) son ig-
norados. Pero aquellos que coinciden son llamados, y su resultado determina
qué tipo de valor viene a continuación: éxito cuando devuelve un valor que
no es una promesa, rechazo cuando genera una excepción, y el resultado de la
promesa cuando devuelve una promesa.
new Promise((_, reject) => reject(new Error("Fail")))
.then(value => console.log("Manejador 1:", value))
.catch(reason => {
console.log("Error capturado " + reason);
return "nada";
})
.then(value => console.log("Manejador 2:", value));
// → Error capturado Error: Fail
// → Handler 2: nothing
La primera función de manejador regular no es llamada, porque en ese punto
del pipeline la promesa contiene un rechazo. El manejador catch maneja ese
rechazo y devuelve un valor, que se le da a la segunda función de manejador.
Cuando una excepción no controlada es manejada por el entorno, los entornos
de JavaScript pueden detectar cuándo un rechazo de promesa no es manejado
y lo reportarán como un error.
Carla
Es un día soleado en Berlín. La pista del antiguo aeropuerto desmantelado
rebosa de ciclistas y patinadores en línea. En el césped cerca de un contenedor
de basura un grupo de cuervos se agita ruidosamente, intentando convencer a
un grupo de turistas de que les den sus sándwiches.
Uno de los cuervos destaca: una hembra grande andrajosa con algunas
plumas blancas en su ala derecha. Está atrayendo a la gente con habilidad
y confianza que sugieren que ha estado haciendo esto durante mucho tiempo.
Cuando un anciano se distrae con las travesuras de otro cuervo, ella se abalanza
casualmente, arrebata su bollo a medio comer de su mano y se aleja planeando.
A diferencia del resto del grupo, que parece estar feliz de pasar el día hol-
gazaneando aquí, el cuervo grande parece tener un propósito. Llevando su
botín, vuela directamente hacia el techo del edificio del hangar, desapareciendo
186

-- 198 of 445 --

en una rejilla de ventilación.
Dentro del edificio, se puede escuchar un sonido peculiar: suave, pero persis-
tente. Viene de un espacio estrecho bajo el techo de una escalera sin terminar.
El cuervo está sentado allí, rodeado de sus botines robados, media docena de
teléfonos inteligentes (varios de los cuales están encendidos) y un enredo de
cables. Golpea rápidamente la pantalla de uno de los teléfonos con su pico.
Aparecen palabras en él. Si no supieras mejor, pensarías que estaba escribi-
endo.Este cuervo es conocido por sus pares como “cāāw-krö". Pero dado que
esos sonidos no son adecuados para las cuerdas vocales humanas, la llamaremos
Carla.
Carla es un cuervo algo peculiar. En su juventud, estaba fascinada por el
lenguaje humano, escuchando a la gente hasta que tuvo un buen entendimiento
de lo que decían. Más tarde, su interés se trasladó a la tecnología humana, y
comenzó a robar teléfonos para estudiarlos. Su proyecto actual es aprender a
programar. El texto que está escribiendo en su laboratorio secreto, de hecho,
es un fragmento de código JavaScript.
Infiltración
A Carla le encanta Internet. Fastidiosamente, el teléfono en el que está traba-
jando está a punto de quedarse sin datos prepagos. El edificio tiene una red
inalámbrica, pero se requiere un código para acceder a ella.
Afortunadamente, los enrutadores inalámbricos en el edificio tienen 20 años y
están mal protegidos. Tras investigar un poco, Carla descubre que el mecanismo
de autenticación de la red tiene una falla que puede aprovechar. Al unirse a
la red, un dispositivo debe enviar el código correcto de 6 dígitos. El punto
de acceso responderá con un mensaje de éxito o fracaso dependiendo de si se
proporciona el código correcto. Sin embargo, al enviar solo un código parcial
(digamos, solo 3 dígitos), la respuesta es diferente según si esos dígitos son
el inicio correcto del código o no. Cuando se envía un número incorrecto, se
recibe inmediatamente un mensaje de fracaso. Cuando se envían los correctos,
el punto de acceso espera más dígitos.
Esto hace posible acelerar enormemente la adivinación del número. Carla
puede encontrar el primer dígito probando cada número a su vez, hasta que
encuentre uno que no devuelva inmediatamente un fracaso. Teniendo un dígito,
puede encontrar el segundo de la misma manera, y así sucesivamente, hasta que
conozca todo el código de acceso.
Supongamos que tenemos una función joinWifi. Dado el nombre de la red
y el código de acceso (como una cadena), intenta unirse a la red, devolviendo
187

-- 199 of 445 --

una promesa que se resuelve si tiene éxito, y se rechaza si la autenticación falla.
Lo primero que necesitamos es una forma de envolver una promesa para que se
rechace automáticamente después de transcurrir demasiado tiempo, de manera
que podamos avanzar rápidamente si el punto de acceso no responde.
function withTimeout(promise, tiempo) {
return new Promise((resolve, reject) => {
promise.then(resolve, reject);
setTimeout(() => reject("Se agotó el tiempo"), tiempo);
});
}
Esto aprovecha el hecho de que una promesa solo puede resolverse o rechazarse
una vez: si la promesa dada como argumento se resuelve o se rechaza primero,
ese será el resultado de la promesa devuelta por withTimeout. Si, por otro lado,
el setTimeout se ejecuta primero, rechazando la promesa, se ignoran cualquier
llamada posterior a resolve o reject.
Para encontrar todo el código de acceso, necesitamos buscar repetidamente el
siguiente dígito probando cada dígito. Si la autenticación tiene éxito, sabremos
que hemos encontrado lo que buscamos. Si falla inmediatamente, sabremos que
ese dígito era incorrecto y debemos probar con el siguiente. Si la solicitud se
agota, hemos encontrado otro dígito correcto y debemos continuar agregando
otro dígito.Debido a que no puedes esperar una promesa dentro de un bucle
for, Carla utiliza una función recursiva para llevar a cabo este proceso. En
cada llamada, obtiene el código tal como lo conocemos hasta ahora, así como
el siguiente dígito a probar. Dependiendo de lo que suceda, puede devolver
un código terminado, o llamar de nuevo a sí misma, ya sea para comenzar a
descifrar la siguiente posición en el código, o para intentarlo de nuevo con otro
dígito.
function crackPasscode(networkID) {
function nextDigit(code, digit) {
let newCode = code + digit;
return withTimeout(joinWifi(networkID, newCode), 50)
.then(() => newCode)
.catch(failure => {
if (failure == "Timed out") {
return nextDigit(newCode, 0);
} else if (digit < 9) {
return nextDigit(code, digit + 1);
} else {
throw failure;
}
188

-- 200 of 445 --

});
}
return nextDigit("", 0);
}
El punto de acceso suele responder a solicitudes de autenticación incorrectas en
aproximadamente 20 milisegundos, por lo que, para estar seguros, esta función
espera 50 milisegundos antes de hacer expirar una solicitud.
crackPasscode("HANGAR 2").then(console.log);
// → 555555
Carla inclina la cabeza y suspira. Esto habría sido más satisfactorio si el código
hubiera sido un poco más difícil de adivinar.
Funciones asíncronas
Incluso con promesas, este tipo de código asíncrono es molesto de escribir. Las
promesas a menudo necesitan ser encadenadas de manera verbosa y arbitraria.
Y nos vimos obligados a introducir una función recursiva solo para crear un
bucle.
Lo que la función de descifrado realmente hace es completamente lineal: siem-
pre espera a que la acción anterior se complete antes de comenzar la siguiente.
En un modelo de programación síncrona, sería más sencillo de expresar.
La buena noticia es que JavaScript te permite escribir código pseudo-sincrónico
para describir la computación asíncrona. Una función async es una función que
implícitamente devuelve una promesa y que puede, en su cuerpo, await otras
promesas de una manera que parece sincrónica.
Podemos reescribir crackPasscode de la siguiente manera:
async function crackPasscode(networkID) {
for (let code = "";;) {
for (let digit = 0;; digit++) {
let newCode = code + digit;
try {
await withTimeout(joinWifi(networkID, newCode), 50);
return newCode;
} catch (failure) {
if (failure == "Timed out") {
code = newCode;
break;
} else if (digit == 9) {
throw failure;
189

-- 201 of 445 --

}
}
}
}
}
Esta versión muestra de manera más clara la estructura de doble bucle de la
función (el bucle interno prueba el dígito 0 al 9, el bucle externo añade dígitos
al código de acceso).
Una función async está marcada con la palabra async antes de la palabra
clave function. Los métodos también pueden ser marcados como async escri-
biendo async antes de su nombre. Cuando se llama a una función o método
de esta manera, devuelve una promesa. Tan pronto como la función devuelve
algo, esa promesa se resuelve. Si el cuerpo genera una excepción, la promesa
es rechazada.
Dentro de una función async, la palabra await puede colocarse delante de
una expresión para esperar a que una promesa se resuelva y luego continuar con
la ejecución de la función. Si la promesa es rechazada, se genera una excepción
en el punto del await.
Una función así ya no se ejecuta, como una función regular de JavaScript, de
principio a fin de una sola vez. En su lugar, puede estar congelada en cualquier
punto que tenga un await, y puede continuar más tarde.
Para la mayoría del código asíncrono, esta notación es más conveniente que
usar directamente promesas. Aún necesitas comprender las promesas, ya que en
muchos casos todavía interactúas con ellas directamente. Pero al encadenarlas,
las funciones async suelen ser más agradables de escribir que encadenar lla-
madas then.
Generadores
Esta capacidad de pausar y luego reanudar funciones no es exclusiva de las
funciones async. JavaScript también tiene una característica llamada generador
functions. Son similares, pero sin las promesas.
Cuando defines una función con function* (colocando un asterisco después
de la palabra function), se convierte en un generador. Al llamar a un gener-
ador, devuelve un iterador, que ya vimos en el Capítulo 6.
function* powers(n) {
for (let current = n;; current *= n) {
yield current;
}
190

-- 202 of 445 --

}
for (let power of powers(3)) {
if (power > 50) break;
console.log(power);
}
// → 3
// → 9
// → 27
Inicialmente, al llamar a powers, la función se congela desde el principio. Cada
vez que llamas a next en el iterador, la función se ejecuta hasta que encuentra
una expresión yield, que la pausa y hace que el valor generado se convierta en
el próximo valor producido por el iterador. Cuando la función retorna (la del
ejemplo nunca lo hace), el iterador ha terminado.
Escribir iteradores a menudo es mucho más fácil cuando usas funciones gen-
eradoras. El iterador para la clase Group (del ejercicio en el Capítulo 6) se
puede escribir con este generador:
Group.prototype[Symbol.iterator] = function*() {
for (let i = 0; i < this.members.length; i++) {
yield this.members[i];
}
};
Ya no es necesario crear un objeto para mantener el estado de la iteración: los
generadores guardan automáticamente su estado local cada vez que hacen un
yield.
Tales expresiones yield solo pueden ocurrir directamente en la función gen-
eradora misma y no en una función interna que definas dentro de ella. El estado
que un generador guarda, al hacer yield, es solo su entorno local y la posición
donde hizo el yield.
Una función async es un tipo especial de generador. Produce una promesa
al llamarla, la cual se resuelve cuando retorna (termina) y se rechaza cuando
arroja una excepción. Cada vez que hace un yield (awaits) una promesa, el
resultado de esa promesa (valor o excepción generada) es el resultado de la
expresión await.
Un Proyecto de Arte de Corvidos
Esta mañana, Carla se despertó con un ruido desconocido en la pista de ater-
rizaje fuera de su hangar. Saltando al borde del techo, ve que los humanos están
191

-- 203 of 445 --

preparando algo. Hay muchos cables eléctricos, un escenario y una especie de
gran pared negra que están construyendo.
Siendo una cuerva curiosa, Carla echa un vistazo más de cerca a la pared.
Parece estar compuesta por varios dispositivos grandes con frente de vidrio
conectados a cables. En la parte trasera, los dispositivos dicen “LedTec SIG-
5030”.
Una rápida búsqueda en Internet saca a relucir un manual de usuario para
estos dispositivos. Parecen ser señales de tráfico, con una matriz programable
de luces LED ambarinas. La intención de los humanos probablemente sea
mostrar algún tipo de información en ellas durante su evento. Curiosamente,
las pantallas pueden ser programadas a través de una red inalámbrica. ¿Podría
ser que estén conectadas a la red local del edificio?
Cada dispositivo en una red recibe una dirección IP, que otros dispositivos
pueden usar para enviarle mensajes. Hablamos más sobre eso en el Capítulo