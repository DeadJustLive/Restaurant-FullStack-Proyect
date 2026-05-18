# Capítulo 41:: Rasgos de conversión

Observaciones
AsRef y Borrow son similares pero tienen propósitos distintos. Borrow se utiliza para tratar
métodos de endeudamiento múltiples de manera similar, o para tratar valores prestados
como sus contrapartes de propiedad, mientras que AsRef se utiliza para generar referencias.
•
From<A> for B implica Into<B> for A , pero no al revés.	•
From<A> for A se implementa implícitamente.	•
Examples
Desde
El rasgo From de Rust es un rasgo de propósito general para la conversión entre tipos. Para
cualquiera de los dos tipos TypeA y TypeB ,
impl From<TypeA> for TypeB
indica que se garantiza que una instancia de TypeB se puede construir desde una instancia de
TypeA . Una implementación de From ve así:
struct TypeA {
a: u32,
}
struct TypeB {
b: u32,
}
impl From<TypeA> for TypeB {
fn from(src: TypeA) -> Self {
TypeB {
b: src.a,
}
}
}
AsRef & AsMut
std::convert::AsRef y std::convert::AsMut se utilizan para convertir tipos de referencias a bajo
costo. Para los tipos A y B ,
impl AsRef<B> for A
indica que a &A se puede convertir en a &B y,
https://riptutorial.com/es/home 136

-- 150 of 188 --

impl AsMut<B> for A
indica que un &mut A se puede convertir en un &mut B
Esto es útil para realizar conversiones de tipo sin copiar o mover valores. Un ejemplo en la
biblioteca estándar es std::fs::File.open() :
fn open<P: AsRef<Path>>(path: P) -> Result<File>
Esto permite que File.open() acepte no solo Path , sino también OsStr , OsString , str , String y
PathBuf con conversión implícita porque todos estos tipos implementan AsRef<Path> .
Pedir prestado
Los rasgos std::borrow::Borrow y std::borrow::BorrowMut se utilizan para tratar tipos prestados
como tipos de propiedad. Para los tipos A y B ,
impl Borrow<B> for A
indica que se puede usar una A prestada donde se desea una B Por ejemplo,
std::collections::HashMap.get() usa Borrow para su método get() , lo que permite que un HashMap
con claves de A se indexe con a &B
Por otro lado, std::borrow::ToOwned implementa la relación inversa.
Así, con los tipos A y B mencionados anteriormente se puede implementar:
impl ToOwned for B
Nota: mientras que A puede implementar Borrow<T> para varios tipos distintos T , B solo puede
implementar ToOwned una vez.
Deref & DerefMut
Los rasgos std::ops::Deref y std::ops::DerefMut se utilizan para sobrecargar el operador de
desreferencia, *x . Para los tipos A y B ,
impl Deref<Target=B> for A
indica que la anulación de la referencia de una unión de &A producirá a &B y,
impl DerefMut for A
indica que al anular una unión de &mut A obtendrá un &mut B
Deref (resp. DerefMut ) también proporciona una función de lenguaje útil llamada deref coercion ,
https://riptutorial.com/es/home 137

-- 151 of 188 --

que permite que &A (resp. &mut A ) coaccione automáticamente a a &B (resp. &mut B ). Esto se usa
comúnmente cuando se convierte de String a &str , ya que &String se obliga implícitamente a &str
según sea necesario.
Nota: DerefMut no admite la especificación del tipo resultante, usa el mismo tipo que Deref .
Nota: Debido al uso de un tipo asociado (a diferencia de AsRef ), un tipo dado solo puede
implementar cada uno de Deref y DerefMut una vez.
Lea Rasgos de conversión en línea: https://riptutorial.com/es/rust/topic/2661/rasgos-de-conversion
https://riptutorial.com/es/home 138

-- 152 of 188 --