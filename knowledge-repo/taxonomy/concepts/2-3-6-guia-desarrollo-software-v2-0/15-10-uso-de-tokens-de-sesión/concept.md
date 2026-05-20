# 10. Uso de tokens de sesión

## Fuente
2.3.6 Guia Desarrollo Software v2.0 (Cap. 15)

## Contenido
# 10. Uso de tokens de sesión

Cuando sea necesario manejar sesiones
stateless, por razones de performance u
otras, se recomienda el uso de JWT
(JSON Web Tokens), puesto que es un
mecanismo seguro e interoperable de
manejo de sesión.
Un JWT2 tiene garantías criptográficas
si es generado de forma segura, para lo
cual se recomienda utilizar los
siguientes parámetros:
● Nunca definir, en la configuración, el
algoritmo para firmar o cifrar como
“none”. Esto deshabilita todas las
consideraciones criptográficas. El
parámetro alg es el que permite
definir el algoritmo que será
utilizado para estas tareas.
● En relación al punto anterior, se
debe seleccionar un algoritmo lo
suficientemente fuerte.
● Se deben generar los secretos (o
secrets) 	de 	forma
criptográficamente segura, con una
correcta entropía por parte del
servidor que los genere.
● Rotar periódicamente, por ejemplo,
cada 3 meses, los secretos
2 https://tools.ietf.org/html/rfc7519
División de Gobierno Digital | Lineamientos para desarrollo de software 	12

-- 12 of 33 --

utilizados para firmar los tokens de
sesión.
