# 10.5 Conectando la Lógica de Persistencia con

la Aplicación
Todavía nos falta una pieza para hacer que esto funcione. Necesitamos conectar
la lógica con nuestra aplicación. Por suerte hay un sitio indicado para ello, la
configuración. Déjala como sigue:
app/components/Provider/setup.js
import storage from '../../libs/storage';
import persist from '../../libs/persist';
import NoteStore from '../../stores/NoteStore';
export default alt => {
alt.addStore('NoteStore', NoteStore);
persist(alt, storage(localStorage), 'app');
}
Si refrescas el navegador ahora, la aplicación debería mantener su estado. Puesto
que esta solución es genérica, añadir más estados al sistema no debería suponer
un problema. También podemos integrar un backend que facilite estos puntos de
enganche si queremos.
Si tuviésemos un backend real podríamos incluir el resultado en el HTML y
devolverlo al navegador, lo que nos ahorraría un viaje. Si además renderizamos el
HTML inicial de la aplicación acabaremos implementando una aproximación básica
al renderizado universal. El renderizado universal es una técnica muy poderosa que
permite usar React para mejorar el rendimiento de tu aplicación a la vez que sigue
funcionando el SEO.
Nuestra implementación no está falta de fallos. Es fácil llegar a una
situación en la que el localStorage contenga datos inválidos debido a
cambios que hayamos hecho en el modelo de datos. Esto te acerca al
mundo de los esquemas de bases de datos y sus migraciones. Lo que
debes aprender aquí es que cuánto más estado tengas en tu aplicación,
más complicado se volverá manejarlo.

-- 121 of 226 --

Implementando Persistencia en localStorage 104