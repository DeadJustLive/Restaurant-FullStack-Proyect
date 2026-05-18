# 6. 	Operaciones con datos cadena

variables apellido, resto: cadena
i: natural
letra: carácter
Comparaciones (por orden alfabético, considerando todos los caracteres según su orden en la tabla del código
ASCII y sus extensiones):
“Costa” = apellido 	apellido ≠ “Po3$” 	apellido < resto
apellido ≤ resto 	apellido > resto 	apellido ≥ resto

-- 260 of 267 --

247
Concatenación:
resto:= resto + apellido 	{resto toma el valor resultante de concatenar su valor
previo con apellido}
apellido:= “de ” + apellido 	{se antepone a la cadena apellido la cadena “de ”}
resto:= “hol” + “a” 	{resto toma el valor “hola”}
Longitud:
i:= long(aux) 	{long devuelve la longitud de la cadena, es decir, su número de
caracteres; la longitud de la cadena vacía, “”, es 0}
Carácter i-ésimo y subcadenas:
letra:= apellido[i] 	{es el i-ésimo carácter de la cadena; 1
≤ i
≤ long(apellido)}
letra:= apellido[1] {primer carácter de la cadena, que debe ser no vacía}
resto:= apellido[2..long(apellido)] {subcadena de apellido desde el carácter 2
hasta el último}
resto:= apellido[i..j] {subcadena desde el carácter i al j; 1
≤ i
≤ j
≤ long(apellido)}