# Capítulo 31:: Utilizando ReactJS con

Typescript
Examples
Componente ReactJS escrito en Typescript
En realidad, puedes usar los componentes de ReactJS en Typescript como en el ejemplo de
facebook. Simplemente reemplaza la extensión del archivo 'jsx' a 'tsx':
//helloMessage.tsx:
var HelloMessage = React.createClass({
render: function() {
return <div>Hello {this.props.name}</div>;
}
});
ReactDOM.render(<HelloMessage name="John" />, mountNode);
Pero para hacer un uso completo de la característica principal de Typescript (verificación de tipos
estática) se debe hacer un par de cosas:
1) convertir el ejemplo de React.createClass a ES6 Class:
//helloMessage.tsx:
class HelloMessage extends React.Component {
render() {
return <div>Hello {this.props.name}</div>;
}
}
ReactDOM.render(<HelloMessage name="John" />, mountNode);
2) a continuación agregue Props y interfaces de estado:
interface IHelloMessageProps {
name:string;
}
interface IHelloMessageState {
//empty in our case
}
class HelloMessage extends React.Component<IHelloMessageProps, IHelloMessageState> {
constructor(){
super();
}
render() {
return <div>Hello {this.props.name}</div>;
}
}
ReactDOM.render(<HelloMessage name="Sebastian" />, mountNode);
https://riptutorial.com/es/home 123

-- 133 of 139 --

Ahora Typescript mostrará un error si el programador se olvida de aprobar las propuestas. O si
añadieron accesorios que no están definidos en la interfaz.
Componentes de Stateless React en Typescript
Los componentes de React que son funciones puras de sus propiedades y no requieren ningún
estado interno se pueden escribir como funciones de JavaScript en lugar de usar la sintaxis de
clase estándar, como:
import React from 'react'
const HelloWorld = (props) => (
<h1>Hello, {props.name}!</h1>
);
Lo mismo se puede lograr en Typescript usando la clase React.SFC :
import * as React from 'react';
class GreeterProps {
name: string
}
const Greeter : React.SFC<GreeterProps> = props =>
<h1>Hello, {props.name}!</h1>;
Tenga en cuenta que, el nombre React.SFC es un alias para React.StatelessComponent Por
React.StatelessComponent tanto, cualquiera de los dos puede usarse.
Instalación y configuración
Para usar mecanografiado con reacción en un proyecto de nodo, primero debe tener un directorio
de proyecto inicializado con npm. Inicializar el directorio con npm init
Instalación vía npm o hilo
Puedes instalar React usando npm haciendo lo siguiente:
npm install --save react react-dom
Facebook lanzó su propio administrador de paquetes llamado Yarn , que también se puede usar
para instalar React. Después de instalar Yarn solo necesitas ejecutar este comando:
yarn add react react-dom
Luego puede usar React en su proyecto exactamente de la misma manera que si hubiera
instalado React a través de npm.
Instalando definiciones de tipo de reacción en Typescript 2.0+
https://riptutorial.com/es/home 124

-- 134 of 139 --

Para compilar su código usando mecanografia, agregue / instale archivos de definición de tipo
usando npm o hilados.
npm install --save-dev @types/react @types/react-dom
o, usando hilo
yarn add --dev @types/react @types/react-dom
Instalar definiciones de tipo de reacción en versiones anteriores de Typescript
Tienes que usar un paquete separado llamado tsd
tsd install react react-dom --save
Agregando o cambiando la configuración de Typescript
Para usar JSX , un lenguaje que mezcla javascript con html / xml, debe cambiar la configuración
del compilador de caracteres. En el archivo de configuración de tsconfig.json del proyecto
(normalmente denominado tsconfig.json ), deberá agregar la opción JSX como:
"compilerOptions": {
"jsx": "react"
},
Esa opción del compilador básicamente le dice al compilador mecanografiado que traduzca las
etiquetas JSX en código a las llamadas de función javascript.
Para evitar que el compilador mecanografiado convierta JSX a llamadas de funciones de
JavaScript simples, use
"compilerOptions": {
"jsx": "preserve"
},
Componentes sin estado y sin propiedad
El componente de reacción más simple sin un estado y sin propiedades se puede escribir como:
import * as React from 'react';
const Greeter = () => <span>Hello, World!</span>
Ese componente, sin embargo, no puede acceder a this.props ya que mecanografiado no puede
saber si es un componente de reacción. Para acceder a sus accesorios, utiliza:
import * as React from 'react';
const Greeter: React.SFC<{}> = props => () => <span>Hello, World!</span>
https://riptutorial.com/es/home 125

-- 135 of 139 --

Incluso si el componente no tiene propiedades explícitamente definidas, ahora puede acceder a
props.children ya que todos los componentes tienen hijos de forma inherente.
Otro buen uso similar de los componentes sin estado y sin propiedades se encuentra en la
plantilla de página simple. El siguiente es un componente simple de la Page ejemplos, asumiendo
que hay componentes hipotéticos de Container , NavTop y NavBottom ya en el proyecto:
import * as React from 'react';
const Page: React.SFC<{}> = props => () =>
<Container>
<NavTop />
{props.children}
<NavBottom />
</Container>
const LoginPage: React.SFC<{}> = props => () =>
<Page>
Login Pass: <input type="password" />
</Page>
En este ejemplo, el componente Page se puede usar posteriormente por cualquier otra página real
como plantilla base.
Lea Utilizando ReactJS con Typescript en línea:
https://riptutorial.com/es/reactjs/topic/1419/utilizando-reactjs-con-typescript
https://riptutorial.com/es/home 126

-- 136 of 139 --

Creditos
S.
No Capítulos Contributors
1 Empezando con
React
Adam, Adrián Daraš, Alex, Alex Young, Anuj, Bart Riordan,
Cassidy, Community, Daksh Gupta, Dave Kaye, diabolicfreak,
DMan, Donald, Everettss, Gianluca Esposito, himanshuIIITian,
hyde, Ilya Lyamkin, Inanc Gumus, ivarni, jengeb, jolyonruss,
Jon Chan, JordanHendrix, juandemarco, Kaloyan Kosev,
Konstantin Grushetsky, Maksim, Marty, MaxPRafferty, Md.
Nahiduzzaman Rose, Md.Sifatul Islam, Ming Soon,
MMachinegun, Nick Bartlett, orvi, paqash, Prakash, rossipedia,
Shabin Hashim, Simplans, Sunny R Gupta, TheShadowbyte,
Timo, Tushar Khanna, user2314737
2 Actuación Aditya Singh, lustoykov, thibmaek
3 Apoyos en
reaccionar
Ahmad, Anuj, Danillo Corvalan, Everettss, Faktor 10, Fellow
Stranger, hansn, Ilya Lyamkin, Jack7, Jagadish Upadhyay,
JimmyLv, MaxPRafferty, QoP, Sergii Bishyr, vintproykt, WitVault
, zbynour
4
Cómo configurar un
webpack básico,
reaccionar y babel.
Bart Riordan, Tien Do, Zac Braddy
5 Cómo y por qué usar
llaves en React. Sammy I.
6 Componentes
akashrajkn, Anuj, Bart Riordan, Bond, Brandon Roberts, Denis
Ivanov, Diego V, DMan, Evan Hammer, Everettss, goldbullet,
GordyD, hmnzr, Ilya Lyamkin, ivarni, Jagadish Upadhyay,
jbmartinez, John Ruddell, jolyonruss, Jon Chan,
jonathangoodman, JordanHendrix, justabuzz, k170, Kousha,
Kyle Richardson, m_callens, Maayan Glikser, Michael Peyper,
Paul Graffam, philpee2, QoP, Radu Brehar, Sai Vikas, sjmarshy
, Timo, Vlad Bezden, WooCaSh, Zakaria Ridouh, zurfyx
7 Componentes de
orden superior Dennis Stücken
8
Componentes
funcionales sin
estado
Adam, Mark Lapierre, Mayank Shukla, Valter Júnior
Comunicación Entre	9 David, Kaloyan Kosev
https://riptutorial.com/es/home 127

-- 137 of 139 --

Componentes
10 Comunicar Entre
Componentes Random User
11 Configuración de
React Ambiente ghostffcode, Tien Do
12 Estado en reaccionar Alex Young, Alexander, Brad Colthurst, Everettss, Kousha, Kyle
Richardson, QoP, skav, Timo
13
Formularios y
comentarios del
usuario
Everettss, Henrik Karlsson, ivarni, Timo
14 Instalación Rene R, Ruairi O'Brien
15
Instalación de React,
Webpack y
Typescript.
Aron
16
Introducción a la
representación del
lado del servidor
Adrián Daraš, MauroPorrasP
17 JSX Kaloyan Kosev, Ming Soon
18 Reaccionar con
redux Jim
19 Reaccionar
enrutamiento abhirathore2006, Robeen
20 Reaccionar formas promisified
21 Reaccionar
herramientas brillout
22 Reaccionar llamada
AJAX
adamboro, Fabian Schultz, Jason Bourne, lifeiscontent,
McGrady, Sunny R Gupta
23
React Boilerplate
[React + Babel +
Webpack]
Mihir, parlad neupane, Tien Do
24 React Component
Lifecycle
Alex Young, Alexg2195, Anuj, Ashari, Everettss, F. Kauder,
irrigator, John Ruddell, QoP, Salman Saleem, Saravana,
Siddharth, skav, Timo, ultrasamad, Vivian, WitVault
React.createClass vs Kaloyan Kosev, leonardoborges, Michael Peyper, pwolaq,	25
https://riptutorial.com/es/home 128

-- 138 of 139 --

extiende
React.Component
Qianyue, sqzaman
26 Soluciones de
interfaz de usuario vintproykt
27 Teclas en reaccionar Dennis Stücken, thibmaek
28 Usando React con
Flujo JimmyLv, lifeiscontent, Rifat, Rory O'Kane
29 Usando ReactJS con
jQuery Kousha, Shuvo Habib
30 Usando ReactJS en
forma de flujo vintproykt
31 Utilizando ReactJS
con Typescript Everettss, John Ruddell, kevgathuku, Leone, Rajab Shakirov
https://riptutorial.com/es/home 129

-- 139 of 139 --