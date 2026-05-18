# 3. Punteros y datos dinámicos en C++

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 232)

## Contenido
# 3. Punteros y datos dinámicos en C++

A continuación, se presenta, a título de ejemplo, la equivalencia entre nuestra notación algorítmica y el lenguaje C++:
tipo Persona = registro
nombre:cadena;
edad:entero
freg;
punteroPersona = ↑Persona
variable p,q:punteroPersona
nuevoDato(p);
p↑.nombre:=”Pepe”;
p↑.edad:=23;
disponer(p);
q:=nil;
struct Persona {
string nombre;
int edad;
};
Persona* p;
Persona* q;
p = new Persona;
p->nombre = “Pepe”; (*)
p->edad = 23;
delete p;
q = nullptr;
(*) Es lo mismo que:
(*p).nombre = “Pepe”;
En cuanto a la estructura de datos para almacenar cadenas de caracteres (si el lenguaje no dispusiera de ese tipo ya
predefinido), una solución elemental similar a la escrita en la sección anterior en pseudocódigo es:
struct Cadena {
char primero;
Cadena* resto;
}

-- 72 of 267 --

65
Lección 8
Implementación dinámica de pilas
Indice
