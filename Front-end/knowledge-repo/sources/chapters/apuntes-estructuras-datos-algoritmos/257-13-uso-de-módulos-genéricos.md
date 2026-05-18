# 13. Uso de módulos genéricos

a. 	Para definir otro tipo también genérico:
módulo genérico pilasGenéricas
importa listasGenéricas
. . .
parámetro tipo elemento
exporta
tipo pila
. . .
implementación
tipo pila = listasGenéricas.lista {el tipo exportado en listasGenéricas}
procedimiento crear(sal p:pila)
principio
listasGenéricas.crear(p)
fin
. . .
fin {del módulo}
b. 	Concretar un modulo genérico y utilizarlo:
. . .
importa pilasGenéricas;
modulo pila_naturales = pilasGenéricas(natural); {que ofrece el tipo: pila}
{admitimos también esta otra sintaxis aleternativa:}
modulo pila_naturales concreta pilasGenéricas(natural)
. . .
{para declarar variables o parámetros:}
p: pila; 	{o bien: p:pila_naturales.pila}
{para utilizar sus operaciones:}
crear(p); 	{o bien: pila_naturales.crear(p)}
. . .