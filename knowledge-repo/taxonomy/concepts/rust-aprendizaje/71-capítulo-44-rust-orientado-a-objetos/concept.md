# Capítulo 44:: Rust orientado a objetos

## Fuente
Capítulo 1: Empezando con Rust 2 (Cap. 71)

## Contenido
# Capítulo 44:: Rust orientado a objetos

Introducción
El óxido está orientado a los objetos porque sus tipos de datos algebraicos pueden tener métodos
asociados, lo que los convierte en objetos en el sentido de datos almacenados junto con el código
que sabe cómo trabajar con ellos.
Sin embargo, el óxido no admite la herencia, favoreciendo la composición con rasgos. Esto
significa que muchos patrones OO no funcionan tal cual y deben modificarse. Algunos son
totalmente irrelevantes.
Examples
Herencia con rasgos
En Rust, no existe el concepto de "heredar" las propiedades de una estructura. En cambio,
cuando diseña la relación entre los objetos, hágalo de manera que la funcionalidad de cada uno
esté definida por una interfaz (un rasgo en Rust). Esto promueve la composición sobre la
herencia , que se considera más útil y más fácil de extender a proyectos más grandes.
Aquí hay un ejemplo usando alguna herencia de ejemplo en Python:
class Animal:
def speak(self):
print("The " + self.animal_type + " said " + self.noise)
class Dog(Animal):
def __init__(self):
self.animal_type = 'dog'
self.noise = 'woof'
Para traducir esto a Rust, necesitamos sacar lo que constituye un animal y poner esa
funcionalidad en rasgos.
trait Speaks {
fn speak(&self);
fn noise(&self) -> &str;
}
trait Animal {
fn animal_type(&self) -> &str;
}
struct Dog {}
impl Animal for Dog {
fn animal_type(&self) -> &str {
"dog"
https://riptutorial.com/es/home 143

-- 157 of 188 --

}
}
impl Speaks for Dog {
fn speak(&self) {
println!("The dog said {}", self.noise());
}
fn noise(&self) -> &str {
"woof"
}
}
fn main() {
let dog = Dog {};
dog.speak();
}
Observe cómo dividimos esa clase padre abstracta en dos componentes separados: la parte que
define la estructura como un animal y la parte que le permite hablar.
Los lectores astutos notarán que esto no es uno a uno, ya que cada implementador debe
reimplementar la lógica para imprimir una cadena con el formato "El {animal} dijo {ruido}". Puede
hacerlo con un ligero rediseño de la interfaz donde implementamos Speak for Animal :
trait Speaks {
fn speak(&self);
}
trait Animal {
fn animal_type(&self) -> &str;
fn noise(&self) -> &str;
}
impl<T> Speaks for T where T: Animal {
fn speak(&self) {
println!("The {} said {}", self.animal_type(), self.noise());
}
}
struct Dog {}
struct Cat {}
impl Animal for Dog {
fn animal_type(&self) -> &str {
"dog"
}
fn noise(&self) -> &str {
"woof"
}
}
impl Animal for Cat {
fn animal_type(&self) -> &str {
"cat"
}
fn noise(&self) -> &str {
https://riptutorial.com/es/home 144

-- 158 of 188 --

"meow"
}
}
fn main() {
let dog = Dog {};
let cat = Cat {};
dog.speak();
cat.speak();
}
Observe que ahora el animal hace un ruido y habla simplemente que ahora tiene una
implementación para cualquier cosa que sea un animal. Esto es mucho más flexible que la forma
anterior y la herencia de Python. Por ejemplo, si desea agregar un ser Human que tenga un sonido
diferente, podemos simplemente tener otra implementación de speak por algo Human :
trait Human {
fn name(&self) -> &str;
fn sentence(&self) -> &str;
}
struct Person {}
impl<T> Speaks for T where T: Human {
fn speak(&self) {
println!("{} said {}", self.name(), self.sentence());
}
}
Patrón de visitante
El ejemplo típico de visitante en Java sería:
interface ShapeVisitor {
void visit(Circle c);
void visit(Rectangle r);
}
interface Shape {
void accept(ShapeVisitor sv);
}
class Circle implements Shape {
private Point center;
private double radius;
public Circle(Point center, double radius) {
this.center = center;
this.radius = radius;
}
public Point getCenter() { return center; }
public double getRadius() { return radius; }
@Override
public void accept(ShapeVisitor sv) {
sv.visit(this);
https://riptutorial.com/es/home 145

-- 159 of 188 --

}
}
class Rectangle implements Shape {
private Point lowerLeftCorner;
private Point upperRightCorner;
public Rectangle(Point lowerLeftCorner, Point upperRightCorner) {
this.lowerLeftCorner = lowerLeftCorner;
this.upperRightCorner = upperRightCorner;
}
public double length() { ... }
public double width() { ... }
@Override
public void accept(ShapeVisitor sv) {
sv.visit(this);
}
}
class AreaCalculator implements ShapeVisitor {
private double area = 0.0;
public double getArea() { return area; }
public void visit(Circle c) {
area = Math.PI * c.radius() * c.radius();
}
public void visit(Rectangle r) {
area = r.length() * r.width();
}
}
double computeArea(Shape s) {
AreaCalculator ac = new AreaCalculator();
s.accept(ac);
return ac.getArea();
}
Esto se puede traducir fácilmente a Rust, de dos maneras.
La primera forma utiliza el polimorfismo en tiempo de ejecución:
trait ShapeVisitor {
fn visit_circle(&mut self, c: &Circle);
fn visit_rectangle(&mut self, r: &Rectangle);
}
trait Shape {
fn accept(&self, sv: &mut ShapeVisitor);
}
struct Circle {
center: Point,
radius: f64,
}
struct Rectangle {
https://riptutorial.com/es/home 146

-- 160 of 188 --

lowerLeftCorner: Point,
upperRightCorner: Point,
}
impl Shape for Circle {

