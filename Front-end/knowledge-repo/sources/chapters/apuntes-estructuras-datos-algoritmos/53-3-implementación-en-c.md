# 3. Implementación en C++

C++ no implementa realmente la genericidad, es decir, no permite obtener código objeto (compilado) que sea genérico.
La técnica habitual en este lenguaje para simular la genericidad son las plantillas (templates).
El compilador hace simplemente una sustitución del texto del parámetro formal por el parámetro actual (es decir, por
el tipo concreto). Por tanto, no se genera código objeto genérico sino que se genera un código objeto distinto para cada
particularización del parámetro formal.
Además, se debe incluir la implementación de las operaciones en el mismo archivo de cabecera.
Así, una posible implementación en C++ del TAD genérico saco visto anteriormente, es la que sigue.
Fichero fruta.h, con la implementación del TAD fruta:
#ifndef _FRUTA_H_
#define _FRUTA_H_
enum Fruta { pera, manzana, limon, pomelo, papaya };
int precio(Fruta f){
switch (f){
case pera:
return 2;
break;
case manzana:
return 1;
break;
case limon:
return 3;
break;
case pomelo:
return 4;
break;
case papaya:

-- 50 of 267 --

43
return 5;
break;
default:
return 0;
}
}
#endif
Fichero moneda.h, con la implementación del TAD moneda:
#ifndef _MONEDA_H_
#define _MONEDA_H_
enum Moneda { c1, c10, c50, e1 };
int precio(Moneda m){
switch (m){
case c1:
return 1;
break;
case c10:
return 10;
break;
case c50:
return 50;
break;
case e1:
return 100;
break;
default:
return 0;
}
}
#endif
Fichero saco.h con la implementación del TAD genérico saco:
#ifndef _SACO_H_
#define _SACO_H_
// Interfaz del TAD. Pre-declaraciones:
const int MAX_NUM_ELEMENTOS = 1000;
template<typename Elemento> struct Saco;
/* El tipo Elemento requerirá tener las funciones:
* int precio(const Elemento& e);
* bool operator==(const Elemento& e1, const Elemento& e2);
*/
template<typename Elemento> void vacio(Saco<Elemento>& s);
template<typename Elemento> bool meter(Saco<Elemento>& s, const Elemento& e);

-- 51 of 267 --

44
template<typename Elemento> void sacar(Saco<Elemento>& s, const Elemento& e);
template<typename Elemento> int cuantos(const Saco<Elemento>& s, const Elemento& e);
template<typename Elemento> int valor(const Saco<Elemento>& s);
// Operaciones NO pertenecientes al Interfaz del TAD (internas)
// por tanto, no deben utilizarse fuera de esta implementación:
template<typename Elemento> int buscar(const Saco<Elemento>& s, const Elemento& e);
// Declaración:
template<typename Elemento> struct Saco {
friend void vacio<Elemento>(Saco<Elemento>& s);
friend bool meter<Elemento>(Saco<Elemento>& s, const Elemento& e);
friend void sacar<Elemento>(Saco<Elemento>& s, const Elemento& e);
friend int cuantos<Elemento>(const Saco<Elemento>& s, const Elemento& e);
friend int valor<Elemento>(const Saco<Elemento>& s);
//operación interna:
friend int buscar<Elemento>(const Saco<Elemento>& s, const Elemento& e);
private:
struct Repeticiones {
Elemento dato;
int numRep;
};
Repeticiones elementos [MAX_NUM_ELEMENTOS];
int total;
};
// Implementación de las operaciones
template<typename Elemento> void vacio(Saco<Elemento>& s) {
s.total = 0;
}
template<typename Elemento> int buscar(const Saco<Elemento>& s, const Elemento& e) {
int pos = 0;
while (pos < s.total && s.elementos[pos].dato != e) {
pos = pos + 1;
}
if (pos == s.total) {
pos = -1;
}
return pos;
}
template<typename Elemento> bool meter(Saco<Elemento>& s, const Elemento& e) {
bool sePuede = true;
int pos = buscar(s,e);
if (pos != -1) {
s.elementos[pos].numRep = s.elementos[pos].numRep + 1;
}
else {
sePuede = s.total < MAX_NUM_ELEMENTOS;
if (sePuede) {

-- 52 of 267 --

45
s.elementos[s.total].dato = e;
s.elementos[s.total].numRep = 1;
s.total = s.total + 1;
}
}
return sePuede;
}
template<typename Elemento> void sacar(Saco<Elemento>& s, const Elemento& e) {
int pos = buscar(s,e);
if (pos != -1) {
if (s.elementos[pos].numRep > 1) {
s.elementos[pos].numRep = s.elementos[pos].numRep - 1;
}
else { // al sacar, quedan 0 unidades de ese elemento
if (s.total == 1) {
s.total = 0;
}
else { // sustituirlo por el ultimo de la tabla
s.total = s.total - 1;
s.elementos[pos].dato = s.elementos[s.total].dato;
s.elementos[pos].numRep = s.elementos[s.total].numRep;
}
}
}
}
template<typename Elemento> int cuantos(const Saco<Elemento>& s, const Elemento& e){
int pos = buscar(s,e);
if (pos != -1) {
return s.elementos[pos].numRep;
}
else {
return 0;
}
}
template<typename Elemento> int valor(const Saco<Elemento>& s) {
int res = 0;
for (int i = 0; i < s.total; i++) {
res = res + s.elementos[i].numRep * precio(s.elementos[i].dato);
}
return res;
}
#endif
Y un ejemplo sencillo de utilización del TAD genérico anterior, en el siguiente fichero main.cpp:
#include <iostream>
#include "fruta.h"
#include "moneda.h"

-- 53 of 267 --

46
#include "saco.h"
using namespace std;
int main() {
bool todoBien = true;
Saco<Fruta> frutero;
vacio(frutero);
todoBien = meter(frutero,pera);
todoBien = meter(frutero,limon);
todoBien = meter(frutero,pomelo);
todoBien = meter(frutero,pera);
todoBien = meter(frutero,pera);
todoBien = meter(frutero,pera);
if (!todoBien) {
cout << "ojo, ha habido un error frutal" << endl;
}
cout << "numero de peras: " << cuantos(frutero,pera) << endl;
cout << "valor total: " << valor(frutero) << endl;
todoBien = true;
Saco<Moneda> monedero;
vacio(monedero);
todoBien = meter(monedero,c1);
todoBien = meter(monedero,c10);
todoBien = meter(monedero,c1);
todoBien = meter(monedero,e1);
if (!todoBien) {
cout << "ojo, ha habido un error monetario" << endl;
}
cout << "numero de monedas de 1 centimo: " << cuantos(monedero,c1) << endl;
cout << "valor total: " << valor(monedero) << endl;
}

-- 54 of 267 --

47
Lección 5
TAD fundamentales
Indice