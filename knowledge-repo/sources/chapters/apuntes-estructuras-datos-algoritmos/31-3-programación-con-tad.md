# 3. Programación con TAD

La programación en gran escala exige la partición del código en módulos, o bien en clases (si estamos utilizando
características de Orientación a Objetos). En el resto de estos apuntes utilizaremos módulos y no clases.
Un módulo es una unidad del programa que puede ser desarrollada independientemente del resto.
Para ello, la descomposición en módulos debe cumplir unos requisitos:
• 	Cada módulo debe tener una conexión mínima con el resto: la interfaz (para obtener la relativa independencia en el
desarrollo).
• 	La mayor parte de cambios y mejoras del programa afecten sólo a un número pequeño de módulos.
• 	El tamaño de cada módulo sea adecuado (si es muy grande es difícil hacer cambios, si es muy pequeño resulta
costoso por los trabajos adicionales de especificación, documentación, control de versiones, ...).
La definición e implementación de un TAD puede encapsularse en un módulo:
• 	La interfaz (conexión con el exterior) es reducida: el nombre del tipo y los encabezamientos de las operaciones
(procedimientos y/o funciones). No permite compartir variables entre módulos, ni conocer la estructura interna de
la representación de los valores del tipo en el exterior. Un tipo del que sólo se exporta el nombre se denomina opaco.
• 	Puede cambiarse la implementación independientemente (los cambios afectan en muchos casos a un solo módulo).
• 	El tamaño del módulo suele ser suficientemente grande (implementación de las diferentes operaciones).
A continuación, a título de ejemplo, se desarrolla el módulo conjuntosDeCaracteres, que exporta el tipo conjcar
definido en la sección anterior, utilizando una notación algorítmica en español. Véase el Anexo 6 para conocer la sintaxis
de esa notación o pseudocódigo.