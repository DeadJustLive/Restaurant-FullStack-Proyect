# 5. Un ejemplo completo: ZILFOST 179

## Fuente
bases-conceptuales-programacion (Cap. 5)

## Contenido
# 5. Un ejemplo completo: ZILFOST 179

5.1. Representaci ´on del ZILFOST . . . . . . . . . . . . . . . . . . . . . 179
5.2. C ´odigo GOBSTONES para las zonas . . . . . . . . . . . . . . . . . 183
5.2.1. Zona de juego . . . . . . . . . . . . . . . . . . . . . . . . . 183
5.2.2. Zonas de n ´umeros . . . . . . . . . . . . . . . . . . . . . . . 187
5.2.3. Zonas de n ´umeros espec´ıficas . . . . . . . . . . . . . . . . 193
5.3. C ´odigo para expresar piezas . . . . . . . . . . . . . . . . . . . . . 195
5.3.1. Geometr´ıa de las piezas . . . . . . . . . . . . . . . . . . . . 195
5.3.2. Detecci ´on de piezas . . . . . . . . . . . . . . . . . . . . . . 199
5.4. C ´odigo para operaciones b ´asicas sobre piezas . . . . . . . . . . . 204
5.4.1. Localizar una pieza . . . . . . . . . . . . . . . . . . . . . . 204
5.4.2. Colocar y quitar una pieza . . . . . . . . . . . . . . . . . . . 204
5.4.3. Movimientos de una pieza . . . . . . . . . . . . . . . . . . . 207
5.5. C ´odigo para la mec ´anica del juego . . . . . . . . . . . . . . . . . . 209
5.5.1. Colocar nueva pieza . . . . . . . . . . . . . . . . . . . . . . 210
5.5.2. Bajar las piezas . . . . . . . . . . . . . . . . . . . . . . . . 210
5.5.3. Extender el piso . . . . . . . . . . . . . . . . . . . . . . . . 214
5.5.4. Eliminar filas llenas . . . . . . . . . . . . . . . . . . . . . . . 218
5.5.5. Generaci ´on del logo de ZILFOST . . . . . . . . . . . . . . . 221
5.6. C ´odigo para las operaciones de interfaz . . . . . . . . . . . . . . . 222
5.6.1. Determinar la pr ´oxima pieza . . . . . . . . . . . . . . . . . 222
5.6.2. Operaciones de interacci ´on . . . . . . . . . . . . . . . . . . 225
5.7. El programa principal . . . . . . . . . . . . . . . . . . . . . . . . . 228
5.7.1. Un programa simple . . . . . . . . . . . . . . . . . . . . . . 228
5.7.2. Programas interactivos . . . . . . . . . . . . . . . . . . . . 228
5.7.3. El juego interactivo . . . . . . . . . . . . . . . . . . . . . . . 229
5.8. Ejercitaci ´on . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 230
5.9. Comentarios Finales . . . . . . . . . . . . . . . . . . . . . . . . . . 233
6. ¿C ´omo continuar aprendiendo a programar? 235
6.1. Estructuras de datos, algor´ıtmica y lenguajes . . . . . . . . . . . . 235
6.1.1. Programaci ´on orientada a objetos . . . . . . . . . . . . . . 236
6.1.2. Programaci ´on funcional . . . . . . . . . . . . . . . . . . . . 237
6.2. Disciplinas asociadas . . . . . . . . . . . . . . . . . . . . . . . . . 237
6.3. Palabras finales . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 238
Las bases conceptuales de la Programaci ´on Mart´ınez L ´opez

-- 14 of 312 --

15
A. La herramienta PYGOBSTONES 241
A.1. Instalaci ´on . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 241
A.1.1. La herramienta . . . . . . . . . . . . . . . . . . . . . . . . . 241
A.1.2. Usuarios de WINDOWS . . . . . . . . . . . . . . . . . . . . 241
A.1.3. Usuarios de GNU/LINUX . . . . . . . . . . . . . . . . . . . . 242
A.2. Primeros pasos en PYGOBSTONES . . . . . . . . . . . . . . . . . . 244
A.2.1. Barra de men ´ues . . . . . . . . . . . . . . . . . . . . . . . . 244
A.2.2. Editor de textos de programa y biblioteca . . . . . . . . . . 245
A.2.3. Ejecutar un programa y ver su resultado . . . . . . . . . . . 245
A.2.4. Visualizar informaci ´on adicional . . . . . . . . . . . . . . . . 247
A.2.5. Chequear un programa . . . . . . . . . . . . . . . . . . . . 247
A.2.6. Opciones de Tablero . . . . . . . . . . . . . . . . . . . . . . 247
A.3. Otras funcionalidades de PYGOBSTONES . . . . . . . . . . . . . . 249
A.3.1. Guardar y cargar tableros . . . . . . . . . . . . . . . . . . . 249
A.3.2. Editor de Tableros . . . . . . . . . . . . . . . . . . . . . . . 250
A.3.3. Vestimentas . . . . . . . . . . . . . . . . . . . . . . . . . . . 250
A.3.4. Interactivo . . . . . . . . . . . . . . . . . . . . . . . . . . . . 252
B. C ´odigo completo del Zilfost 257
B.1. C ´odigo principal . . . . . . . . . . . . . . . . . . . . . . . . . . . . 257
B.2. Operaciones sobre zonas . . . . . . . . . . . . . . . . . . . . . . . 259
B.2.1. Operaciones sobre la zona de juego . . . . . . . . . . . . . 260
B.2.2. Operaciones sobre zonas de n ´umeros . . . . . . . . . . . . 263
B.2.3. Operaciones de zonas espec´ıficas . . . . . . . . . . . . . . 267
B.3. Operaciones sobre piezas . . . . . . . . . . . . . . . . . . . . . . . 270
B.3.1. Geometr´ıa de las piezas . . . . . . . . . . . . . . . . . . . . 271
B.3.2. Detecci ´on de piezas . . . . . . . . . . . . . . . . . . . . . . 276
B.4. Operaciones de procesamiento de piezas . . . . . . . . . . . . . . 280
B.4.1. Operaci ´on de localizaci ´on de una pieza . . . . . . . . . . . 280
B.4.2. Operaciones para colocar una pieza . . . . . . . . . . . . . 280
B.4.3. Operaciones para quitar una pieza . . . . . . . . . . . . . . 283
B.4.4. Operaciones de movimiento de piezas . . . . . . . . . . . . 286
B.5. Operaciones de la mec ´anica del juego . . . . . . . . . . . . . . . . 288
B
