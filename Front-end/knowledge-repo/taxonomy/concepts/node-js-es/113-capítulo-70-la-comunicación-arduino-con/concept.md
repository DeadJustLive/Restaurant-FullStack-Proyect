# Capítulo 70:: La comunicación arduino con

## Fuente
Capítulo 1: Empezando con Node.js 2 (Cap. 113)

## Contenido
# Capítulo 70:: La comunicación arduino con

nodeJs.
Introducción
Manera de mostrar cómo Node.Js puede comunicarse con Arduino Uno.
Examples
Comunicación del nodo Js con Arduino a través de serialport.
Codigo js del nodo
La muestra para iniciar este tema es el servidor Node.js que se comunica con Arduino a través de
serialport.
npm install express --save
npm install serialport --save
Ejemplo de aplicación.js:
const express = require('express');
const app = express();
var SerialPort = require("serialport");
var port = 3000;
var arduinoCOMPort = "COM3";
var arduinoSerialPort = new SerialPort(arduinoCOMPort, {
baudrate: 9600
});
arduinoSerialPort.on('open',function() {
console.log('Serial Port ' + arduinoCOMPort + ' is opened.');
});
app.get('/', function (req, res) {
return res.send('Working');
})
app.get('/:action', function (req, res) {
var action = req.params.action || req.param('action');
if(action == 'led'){
arduinoSerialPort.write("w");
return res.send('Led light is on!');
https://riptutorial.com/es/home 235

-- 263 of 423 --

}
if(action == 'off') {
arduinoSerialPort.write("t");
return res.send("Led light is off!");
}
return res.send('Action: ' + action);
});
app.listen(port, function () {
console.log('Example app listening on port http://0.0.0.0:' + port + '!');
});
Iniciando el servidor express de muestra:
node app.js
Código arduino
// the setup function runs once when you press reset or power the board
void setup() {
// initialize digital pin LED_BUILTIN as an output.
Serial.begin(9600); // Begen listening on port 9600 for serial
pinMode(LED_BUILTIN, OUTPUT);
digitalWrite(LED_BUILTIN, LOW);
}
// the loop function runs over and over again forever
void loop() {
if(Serial.available() > 0) // Read from serial port
{
char ReaderFromNode; // Store current character
ReaderFromNode = (char) Serial.read();
convertToState(ReaderFromNode); // Convert character to state
}
delay(1000);
}
void convertToState(char chr) {
if(chr=='o'){
digitalWrite(LED_BUILTIN, HIGH);
delay(100);
}
if(chr=='f'){
digitalWrite(LED_BUILTIN, LOW);
delay(100);
}
}
Empezando
https://riptutorial.com/es/home 236

-- 264 of 423 --

Conecta el arduino a tu maquina.	1.
Iniciar el servidor	2.
Controlar la construcción en led vía nodo js servidor expreso.
Para encender el led:
http://0.0.0.0:3000/led
Para apagar el led:
http://0.0.0.0:3000/off
Lea La comunicación arduino con nodeJs. en línea: https://riptutorial.com/es/node-
js/topic/10509/la-comunicacion-arduino-con-nodejs-
https://riptutorial.com/es/home 237

-- 265 of 423 --
