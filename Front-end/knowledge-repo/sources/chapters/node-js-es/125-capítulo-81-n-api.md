# Capítulo 81:: N-API

Introducción
El N-API es una nueva y mejor manera de crear un módulo nativo para NodeJS. N-API se
encuentra en una etapa temprana, por lo que puede tener documentación inconsistente.
Examples
Hola a N-API
Este módulo registra la función de saludo en el módulo de saludo. La función hello imprime Hello
world en la consola con printf y devuelve 1373 de la función nativa al llamador javascript.
#include <node_api.h>
#include <stdio.h>
napi_value say_hello(napi_env env, napi_callback_info info)
{
napi_value retval;
printf("Hello world\n");
napi_create_number(env, 1373, &retval);
return retval;
}
void init(napi_env env, napi_value exports, napi_value module, void* priv)
{
napi_status status;
napi_property_descriptor desc = {
/*
* String describing the key for the property, encoded as UTF8.
*/
.utf8name = "hello",
/*
* Set this to make the property descriptor object's value property
* to be a JavaScript function represented by method.
* If this is passed in, set value, getter and setter to NULL (since these members
won't be used).
*/
.method = say_hello,
/*
* A function to call when a get access of the property is performed.
* If this is passed in, set value and method to NULL (since these members won't be
used).
* The given function is called implicitly by the runtime when the property is
accessed
* from JavaScript code (or if a get on the property is performed using a N-API call).
*/
.getter = NULL,
/*
https://riptutorial.com/es/home 262

-- 290 of 423 --

* A function to call when a set access of the property is performed.
* If this is passed in, set value and method to NULL (since these members won't be
used).
* The given function is called implicitly by the runtime when the property is set
* from JavaScript code (or if a set on the property is performed using a N-API call).
*/
.setter = NULL,
/*
* The value that's retrieved by a get access of the property if the property is a
data property.
* If this is passed in, set getter, setter, method and data to NULL (since these
members won't be used).
*/
.value = NULL,
/*
* The attributes associated with the particular property. See
napi_property_attributes.
*/
.attributes = napi_default,
/*
* The callback data passed into method, getter and setter if this function is
invoked.
*/
.data = NULL
};
/*
* This method allows the efficient definition of multiple properties on a given object.
*/
status = napi_define_properties(env, exports, 1, &desc);
if (status != napi_ok)
return;
}
NAPI_MODULE(hello, init)
Lea N-API en línea: https://riptutorial.com/es/node-js/topic/10539/n-api
https://riptutorial.com/es/home 263

-- 291 of 423 --