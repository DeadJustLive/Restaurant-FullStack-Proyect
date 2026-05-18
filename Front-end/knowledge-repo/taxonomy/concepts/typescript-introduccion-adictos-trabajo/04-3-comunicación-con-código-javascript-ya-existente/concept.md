# 3. Comunicación con código Javascript ya existente

## Fuente
typescript-introduccion-adictos-trabajo (Cap. 4)

## Contenido
# 3. Comunicación con código Javascript ya existente

Otra de las ventajas que otorga Typescript es que permite comunicarse con código Javascript ya creado e
incluso añadirle “tipos” a través de unos fcheros d.ts que indican los tipos que reciben y devuelven las
funciones de una librería por ejemplo.
Hay una estupenda comunidad con defniciones para algunas de las librerías más usadas, como pueden ser
Underscore, jQuery o Backbone.
Con solo descargarse la defnición y añadir una linea de texto en nuestro fchero, nos proporciona tipado para
aquellas librerías que no han sido escritas en Typescript.
/// <reference path="../libs/underscore.d.ts" />

-- 5 of 9 --

Aquí podemos ver como IntelliJ es capaz de decirnos que tipo espera cada función.
En caso de que usáramos una librería interna o que no tenga declaración de tipos podemos hacerla nosotros,
según fuésemos necesitando las distintas funciones.
declare var _: {
each<T, U>(arr: T[], f: (elem: T) => U): U[];
delay(f: Function, wait: number, ...arguments: any[]): number;
template(template: string): (model: any) => string;
bindAll(object: any, ...methodNames: string[]): void;
};
Si por lo que fuera necesitáramos acceder desde Javascript al código generado por Typescript es muy sencillo,
ya que el código generado es fácilmente legible como podremos comprobar a continuación.
