# 3. 	Definición de nuevos tipos de datos

## Fuente
apuntes-estructuras-datos-algoritmos (Cap. 172)

## Contenido
# 3. 	Definición de nuevos tipos de datos

tipos
mes = (ene,feb,mar,abr,may,jun,jul,ago,sep,oct,nov,dic) 	{tipo enumerado}
mesVerano = jul..sep 	{tipo subrango de otro tipo discreto}
día = 1..31
fecha = registro 	{tipo registro (o estructura), agregación de campos}
elDía: día;
elMes: mes;
elAño: natural
freg
pluviometría = vector[mes] de real 	{tipo vector (array)}
fiestas = vector[1..maxNum] de fecha
secFechas = fichero de fecha 	{tipo fichero binario de fechas}
entrada 	= 	fichero 	de 	texto 	{tipo 	fichero 	de 	texto, 	i.e., 	secuencia 	de 	líneas
(una línea es una secuencia de caracteres)}
