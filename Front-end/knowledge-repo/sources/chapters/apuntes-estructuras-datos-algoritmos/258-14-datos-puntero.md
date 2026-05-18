# 14. Datos puntero

tipo pila = ↑unDato {tipo puntero (o referencia) a unDato}
unDato = registro
dato:natural;
siguente:pila
freg
variables p,q: pila
Valor especial (constante) de cualquier tipo puntero: nil (ninguna dirección)
p:=nil
Instrucciones con punteros:
nuevoDato(p);
p↑.dato:=3;

-- 263 of 267 --

250
q:=p;
disponer(p);
si p=q entonces ...