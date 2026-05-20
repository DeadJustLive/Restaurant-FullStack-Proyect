# Capítulo 13:: Formularios y comentarios del

## Fuente
react-stackoverflow-docs (Cap. 56)

## Contenido
# Capítulo 13:: Formularios y comentarios del

usuario
Examples
Componentes controlados
Los componentes de formulario controlados se definen con una propiedad de value . El valor de
las entradas controladas es administrado por React, las entradas del usuario no tendrán ninguna
influencia directa en la entrada renderizada. En cambio, un cambio en la propiedad de value debe
reflejar este cambio.
class Form extends React.Component {
constructor(props) {
super(props);
this.onChange = this.onChange.bind(this);
this.state = {
name: ''
};
}
onChange(e) {
this.setState({
name: e.target.value
});
}
render() {
return (
<div>
<label for='name-input'>Name: </label>
<input
id='name-input'
onChange={this.onChange}
value={this.state.name} />
</div>
)
}
}
El ejemplo anterior demuestra cómo la propiedad de value define el valor actual de la entrada y el
controlador de eventos onChange actualiza el estado del componente con la entrada del usuario.
Las entradas de formularios deben definirse como componentes controlados cuando sea posible.
Esto garantiza que el estado del componente y el valor de entrada estén sincronizados en todo
momento, incluso si el valor es cambiado por un disparador que no sea una entrada del usuario.
Componentes no controlados
https://riptutorial.com/es/home 64

-- 74 of 139 --

Los componentes no controlados son entradas que no tienen una propiedad de value . Al
contrario de los componentes controlados, es responsabilidad de la aplicación mantener el estado
del componente y el valor de entrada sincronizados.
class Form extends React.Component {
constructor(props) {
super(props);
this.onChange = this.onChange.bind(this);
this.state = {
name: 'John'
};
}
onChange(e) {
this.setState({
name: e.target.value
});
}
render() {
return (
<div>
<label for='name-input'>Name: </label>
<input
id='name-input'
onChange={this.onChange}
defaultValue={this.state.name} />
</div>
)
}
}
Aquí, el estado del componente se actualiza a través del controlador de eventos onChange , al igual
que para los componentes controlados. Sin embargo, en lugar de una propiedad de value , se
proporciona una propiedad defaultValue . Esto determina el valor inicial de la entrada durante el
primer renderizado. Cualquier cambio posterior en el estado del componente no se refleja
automáticamente por el valor de entrada; Si es necesario, se debe utilizar un componente
controlado en su lugar.
Lea Formularios y comentarios del usuario en línea:
https://riptutorial.com/es/reactjs/topic/2884/formularios-y-comentarios-del-usuario
https://riptutorial.com/es/home 65

-- 75 of 139 --
