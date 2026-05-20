# Capítulo 2:: Aplicaciones GUI

Introducción
Rust no tiene un marco propio para el desarrollo de GUI. Sin embargo, hay muchos enlaces a los
marcos existentes. El enlace de biblioteca más avanzado es rust-gtk . Una 'semi' lista completa de
enlaces se puede encontrar aquí
Examples
Simple Gtk + Ventana con texto
Agregue la dependencia de Gtk a su Cargo.toml :
[dependencies]
gtk = { git = "https://github.com/gtk-rs/gtk.git" }
Crea una ventana simple con lo siguiente:
extern crate gtk;
use gtk::prelude::*; // Import all the basic things
use gtk::{Window, WindowType, Label};
fn main() {
if gtk::init().is_err() { //Initialize Gtk before doing anything with it
panic!("Can't init GTK");
}
let window = Window::new(WindowType::Toplevel);
//Destroy window on exit
window.connect_delete_event(|_,_| {gtk::main_quit(); Inhibit(false) });
window.set_title("Stackoverflow. example");
window.set_default_size(350, 70);
let label = Label::new(Some("Some text"));
window.add(&label);
window.show_all();
gtk::main();
}
Ventana Gtk + con entrada y etiqueta en GtkBox, conexión de señal GtkEntry
extern crate gtk;
use gtk::prelude::*;
use gtk::{Window, WindowType, Label, Entry, Box as GtkBox, Orientation};
fn main() {
if gtk::init().is_err() {
https://riptutorial.com/es/home 8

-- 22 of 188 --

println!("Failed to initialize GTK.");
return;
}
let window = Window::new(WindowType::Toplevel);
window.connect_delete_event(|_,_| {gtk::main_quit(); Inhibit(false) });
window.set_title("Stackoverflow. example");
window.set_default_size(350, 70);
let label = Label::new(Some("Some text"));
// Create a VBox with 10px spacing
let bx = GtkBox::new(Orientation::Vertical, 10);
let entry = Entry::new();
// Connect "activate" signal to anonymous function
// that takes GtkEntry as an argument and prints it's text
entry.connect_activate(|x| println!("{}",x.get_text().unwrap()));
// Add our label and entry to the box
// Do not expand or fill, zero padding
bx.pack_start(&label, false, false, 0);
bx.pack_start(&entry, false, false, 0);
window.add(&bx);
window.show_all();
gtk::main();
}
Lea Aplicaciones GUI en línea: https://riptutorial.com/es/rust/topic/7169/aplicaciones-gui
https://riptutorial.com/es/home 9

-- 23 of 188 --