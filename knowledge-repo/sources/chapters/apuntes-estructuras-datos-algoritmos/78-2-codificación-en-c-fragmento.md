# 2. Codificación en C++ (fragmento)

Incluimos la parte inicial de una posible codificación en C++ del TAD pila genérica con representación dinámica
(enlazada con punteros). No utilizaremos clases (orientación a objetos) sino registros de C++. Los detalles de
implementación de las operaciones quedan como ejercicio.
// Interfaz del TAD. Pre-declaraciones:
template <typename Elem> struct Pila;
template <typename Elem> void crearVacia(Pila<Elem>& p);
template <typename Elem> void apilar(Pila<Elem>& p, const Elem& dato);
template <typename Elem> void desapilar(Pila<Elem>& p);
template <typename Elem> void cima(const Pila<Elem>& p, Elem& dato, bool& error);
template <typename Elem> bool esVacia(const Pila<Elem>& p);
template <typename Elem> int altura(const Pila<Elem>& p);
template <typename Elem> void duplicar(const Pila<Elem>& pOrigen, Pila<Elem>& pDestino);
template <typename Elem> bool operator==(const Pila<Elem>& p1, const Pila<Elem>& p2);
template <typename Elem> void liberar(Pila<Elem>& p);
template <typename Elem> void iniciarIterador(Pila<Elem>& p);
template <typename Elem> bool existeSiguiente(const Pila<Elem>& p);
template <typename Elem> bool siguiente(Pila<Elem>& p, Elem& dato);
// Declaración
template <typename Elem> struct Pila{
friend void crearVacia<Elem>(Pila<Elem>& p);
friend void apilar<Elem>(Pila<Elem>& p, const Elem& dato);
friend void desapilar<Elem>(Pila<Elem>& p);
friend void cima<Elem>(const Pila<Elem>& p, Elem& dato, bool& error);
friend bool esVacia<Elem>(const Pila<Elem>& p);
friend int altura<Elem>(const Pila<Elem>& p);
friend void duplicar<Elem>(const Pila<Elem>& pOrigen, Pila<Elem>& pDestino);
friend bool operator==<Elem>(const Pila<Elem>& p1, const Pila<Elem>& p2);
friend void liberar<Elem>(Pila<Elem>& p);

-- 77 of 267 --

70
friend void iniciarIterador<Elem>(Pila<Elem>& p);
friend bool existeSiguiente<Elem>(const Pila<Elem>& p);
friend bool siguiente<Elem>(Pila<Elem>& p, Elem& dato);
// Representación de los valores del TAD
private:
struct Nodo{
Elem valor;
Nodo* sig;
};
Nodo* laCima;
int numDatos;
Nodo* iter;
};
// Implementación de las operaciones
template<typename Elem> void crearVacia(Pila<Elem>& p){
p.numDatos = 0;
p.laCima = nullptr;
}
template <typename Elem> void apilar(Pila<Elem>& p, const Elem& dato){
typename Pila<Elem>::Nodo* aux = new typename Pila<Elem>::Nodo;
aux->valor=dato;
aux->sig=p.laCima;
p.laCima=aux;
p.numDatos++;
}
// etc, etc, implementación de las demás operaciones (ejercicio)