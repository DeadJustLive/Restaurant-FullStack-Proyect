# 10.2 Implementando un Envoltorio para

## Fuente
react-aprendiz-maestro (Cap. 96)

## Contenido
# 10.2 Implementando un Envoltorio para

localStorage
Para hacer que las cosas sean simples y manejables vamos a implementar un pequeño
envoltorio sobre el almacén que nos permita limitar la complejidad. El API consistirá
en un método get(k) para recuperar elementos del almacenamiento y set(k,v) para
establecerlos. Dado que el API que está por debajo funciona con cadenas de texto,
usaremos JSON.parse y JSON.stringify para la serialización. Tendremos que tener
en cuenta que JSON.parse puede fallar. Considera la siguiente implementación:
app/libs/storage.js
export default storage => ({
get(k) {
try {
return JSON.parse(storage.getItem(k));
}
catch(e) {
return null;
}
},
set(k, v) {
storage.setItem(k, JSON.stringify(v));
}
})
Esta implementación es suficiente para cumplir nuestros propósitos. No funcionará
siempre y fallará si ponemos demasiados datos en el almacén. Para superar estos

-- 118 of 226 --

Implementando Persistencia en localStorage 101
problemas sin tener que arreglarlos por tí mismo es posible utilizar un envoltorio
como localForage3 para ocultar la complejidad.
