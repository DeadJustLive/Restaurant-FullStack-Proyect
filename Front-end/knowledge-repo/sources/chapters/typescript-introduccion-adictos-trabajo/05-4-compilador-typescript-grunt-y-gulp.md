# 4. Compilador Typescript, Grunt y Gulp.

Para que funcione todo esto hace falta un paso intermedio para convertir el código Typescript en código
Javascript, para ello existen varios métodos.

-- 6 of 9 --

Compilador Typescript
El equipo de Typescript provee una herramienta de linea de comandos para hacer esta compilación, se
encuentra en npm y se puede instalar con el siguiente comando:
<code>npm install -g typescript</code>
Podemos usarlo escribiendo
<code>tsc helloworld.ts</code>
Si queremos compilar varios fcheros, y que los módulos sean con notación AMD, podríamos hacerlo:
<code>tsc foo.ts bar.ts --module amd</code>
Esto no escala, ya que poner todos los fcheros uno a uno en la consola, puede resultar muy incomodo, por ello
podemos usar Typescript con herramientas como Grunt o Gulp, a continuación voy a poner un ejemplo de como
montar la build con Gulp.
Compilando con Gulp
Gulp es un TaskRunner parecido a Grunt (y Maven para los que vengan del mundo Java, sin la parte de
dependencias).
La idea es que se ejecute automáticamente el compilador Typescript cada vez que modifquemos un fchero, y
se recargue el navegador con los fcheros Javascript generados.
(A partir de aquí tenemos en cuenta de que tienes instalado Gulp en tu ordenador, puedes leer cómo aquí)
gulp.task('compile:typescript', function () {
gulp.src('app/src/**/*.ts')
.pipe(ts({
declarationFiles: true,
noExternalResolve: true,
module: 'amd'
}))
.pipe(gulp.dest('dist/scripts'))
});
Esto lo que hará será compilar todos los fcheros con la extension .ts con las opciones que le pasemos en el
objeto json dentro de ts() y los pondrá en dist.
Esta tarea ha de ser invocada manualmente, el siguiente paso será crear una tarea que detecte los cambios en
los fcheros con extension .ts y ejecute automáticamente dicha tarea, para ello usaremos la función watch de
gulp.

-- 7 of 9 --

gulp.task('default', function () {
gulp.watch('app/src/**/*.ts', ['compile:typescript'])
});
Por último vamos a crear una tarea que nos cree un servidor local donde probar nuestra aplicación, y que cada
vez que cambiemos algún fchero se recargue el navegador.
// Watch Files For Changes & Reload
gulp.task('serve', ['compile:typescript'], function () {
browserSync({
notify: false,
server: ['dist', 'app']
});
gulp.watch(['app/**/*.html'], reload);
gulp.watch(['app/src/**/*.ts'], ['compile:typescript', reload])
});
Puedes ver el fchero entero con todos las dependencias aquí.