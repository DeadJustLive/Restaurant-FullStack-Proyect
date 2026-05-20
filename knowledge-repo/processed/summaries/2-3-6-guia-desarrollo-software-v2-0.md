# 2.3.6 Guia Desarrollo Software v2.0

- **ID**: 2-3-6-guia-desarrollo-software-v2-0
- **Método**: native
- **Páginas**: 33
- **Capítulos**: 56
- **Generado**: 2026-05-17T09:15:22.434Z

## Resumen

# I. Introducción

La adopción de buenas prácticas es fundamental para todas las
etapas de desarrollo de un sistema o aplicación informática.
Esta guía técnica entrega los
lineamientos 	generales 	y
r

Secciones:
  # I. Introducción

Conclusión: Uso de estándares comunes entre
instituciones.

## Capítulos

### Cap. 1 — I. Introducción

# I. Introducción

La adopción de buenas prácticas es fundamental para todas las
etapas de desarrollo de un sistema o aplicación informática.
Esta guía técnica entrega los
lineamientos 	generales 	y
r

Secciones:
  # I. Introducción

Conclusión: Uso de estándares comunes entre
instituciones.

### Cap. 2 — II. Consideraciones iniciales para

# II. Consideraciones iniciales para

el desarrollo de aplicaciones
Considerando que el ciclo de desarrollo podría no terminar nunca, se
sugiere utilizar todos o algunos de los siguientes ambientes para
cada proyecto: producción, staging (demo o certificación), test y
development (desarrollo), cada uno de ellos representado en una
rama del proyecto en el repositorio de código.

### Cap. 3 — 1. Metodologías de desarrollo

# 1. Metodologías de desarrollo Para el análisis, desarrollo e implementación se sugiere utilizar metodologías ágiles, incorporando al menos las recomendaciones de la metodología denominada The Twe Secciones: # 1. Metodologías de desarrollo Conclusión: Dado que actualmente las instituciones pueden no contar con un equipo con los conocimientos de metodologías de desarrollo ágil u otras, se recomienda -- 6 of 33 -- iniciar las capacitación para trabajos futuros y, de esta forma, iniciar los nuevos proyectos con estas metodologías y,...

### Cap. 4 — 2. Ambientes de desarrollo

# 2. Ambientes de desarrollo Considerando que el ciclo de desarrollo podría no terminar nunca, se sugiere utilizar todos o algunos de los siguientes ambientes para cada proyecto: producción, staging Secciones: # 2. Ambientes de desarrollo Conclusión: Al contar con los resguardos descritos en esta guía, cada paso de un ambiente a otro debiera propender a contar con procedimientos de calidad de código, para obtener un código revisado y apto para su entrega en el ambiente en el que es...

### Cap. 5 — III. Consideraciones para un

# III. Consideraciones para un

desarrollo seguro
Las librerías y frameworks de terceros confiables que incorporan
mecanismos de seguridad son fundamentales para evitar errores de
implementación en áreas en las que el desarrollador no se encuentre
tan familiarizado.

### Cap. 6 — 1. Uso de librerías y frameworks

# 1. Uso de librerías y frameworks

de seguridad
Se deben seleccionar librerías y
frameworks de autores confiables, con
mantención y desarrollo activo, y que
sean ampliamente utilizadas (y por
ende, v

Secciones:
  # 1. Uso de librerías y frameworks

Conclusión: Algunas librerías y frameworks
recomendados se encuentran en la
sección Tecnologías de Preferencia.

### Cap. 7 — 2. Consultas seguras a las bases

SQL.

Secciones:
  # 2. Consultas seguras a las bases

Conclusión: En el caso de contar con tecnología de
base de datos específica o legacy
(Oracle, SQL Server, etc), en la cual se
utilicen procedimientos almacenados
directamente en el motor, éstos deben
ser securizados de forma correcta, por
ejemplo, utilizando bind variables.

### Cap. 8 — 3. Codificar y escapar los datos

# 3. Codificar y escapar los datos

Éstas son técnicas defensivas, cuyo
objetivo es detener ataques de
inyección, ya sean SQL, XSS u otros.
Codificar consiste en transformar o
traducir ciertos caracte

Secciones:
  # 3. Codificar y escapar los datos

Conclusión: Se deben considerar también las
validaciones de datos, descritas a
continuación.

### Cap. 9 — 4. Validación de datos

# 4. Validación de datos

Ésta es una técnica para asegurar que
sólo los datos con el formato correcto
podrán ingresar al sistema a desarrollar.
Esta validación debe ser correcta, tanto
sintáctica com

Secciones:
  # 4. Validación de datos

Conclusión: Para la validación de datos, incluyendo
datos 	complejos, 	tales 	datos
serializados, HTML u otros, se deberían
utilizar librerías apropiadas para ello
(HTML Purifier, Bleach, entre otras).

### Cap. 10 — 5. Autenticación 	nivel 	1:

# 5. Autenticación 	nivel 	1:

Contraseñas
Las aplicaciones deben exigir al usuario
el uso de contraseñas de características
y calidad adecuadas, y que no sean
contraseñas previamente filtradas1.
Asim

Secciones:
  # 5. Autenticación 	nivel 	1:

Conclusión: En el caso de que los ataques de fuerza
bruta sean un problema, es
recomendado implementar múltiples
factores de autenticación.

### Cap. 11 — 6. Autenticación 	nivel 	2:

# 6. Autenticación nivel 2: Multifactor Es el uso de múltiples factores de autenticación para verificar al usuario. Habitualmente se usa una combinación de dos o más de los siguientes factores: ● L Secciones: # 6. Autenticación nivel 2: Conclusión: La biometría no se debe considerar un dato secreto, puesto que algunas características biométricas pueden ser fácilmente reproducibles u obtenidas sin conocimiento del usuario, por ejemplo, a través de una foto del rostro o “levantando” huellas digitales de objetos, por...

### Cap. 12 — 7. Autenticación 	nivel 	3:

# 7. Autenticación 	nivel 	3:

Criptográfica
Se logra a través del uso de módulos de
hardware criptográfico seguro, en
conjunto con algún mecanismo de
autenticación adicional (password,
biometría, otros).
División de Gobierno Digital | Lineamientos para desarrollo de software 	11

-- 11 of 33 --

### Cap. 13 — 8. Implementar mecanismos de

# 8. Implementar mecanismos de

manejo de sesión
Para el manejo de las sesiones, se debe
considerar al menos lo siguiente:
● El identificador de sesión debe ser
único, suficientemente largo y
aleatori

Secciones:
  # 8. Implementar mecanismos de

Conclusión: La
duración de este timeout debe ser
inversamente proporcional a la
sensibilidad de los datos a proteger,
vale decir, mientras más sensible,
menor duración.

### Cap. 14 — 9. Uso de cookies para manejo

# 9. Uso de cookies para manejo

de sesión
Para el uso de cookies se debe
considerar lo siguiente:
● Deben ser accesibles por el mínimo
de dominios requeridos para el
correcto 	funcionamiento 	del
sistema.
● Deben caducar al momento en que
expira la sesión, o luego de un corto
período.
● Deben tener el flag “secure”. Esto
fuerza su transferencia a través de
TLS.
● Deben tener el flag “HttpOnly”.
Esto previene su acceso a través de
JavaScript.

### Cap. 15 — 10. Uso de tokens de sesión

# 10. Uso de tokens de sesión

Cuando sea necesario manejar sesiones
stateless, por razones de performance u
otras, se recomienda el uso de JWT
(JSON Web Tokens), puesto que es un
mecanismo seguro e i

Secciones:
  # 10. Uso de tokens de sesión

Conclusión: División de Gobierno Digital | Lineamientos para desarrollo de software 	12

-- 12 of 33 --

utilizados para firmar los tokens de
sesión.

### Cap. 16 — 11. Identificación de datos

# 11. Identificación de datos

Los datos sensibles o críticos deben
estar identificados para 	poder
implementar las protecciones que
requieran de forma correcta. Por
ejemplo, si se manejan datos sensibles
de ciudadanos y se requiere
almacenarlos bajo encriptación.

### Cap. 17 — 12. Datos en tránsito

# 12. Datos en tránsito

Las 	comunicaciones 	de 	los
componentes 	que 	transporten
información de los 	usuarios entre
sistemas, deberán siempre estar
protegidas mediante TLS, idealmente la
versión 	1.3, 	y 	los 	sistemas
correctamente 	configurados 	para
seleccionar el cifrado más fuerte
disponible.

### Cap. 18 — parte d: e la aplicación.

# parte d: e la aplicación.

En caso que no se pueda evitar
almacenar datos sensibles, éstos deben
ser protegidos mediante encriptación,
para prevenir la modificación o acceso
no autorizado.
Considera

Secciones:
  # parte d: e la aplicación.

Conclusión: En caso de manejar datos que deban
considerarse como abiertos, éstos
deberán ser manejados y almacenados
utilizando formatos estándar que
permitan su fácil exportación a las
plataformas correspondientes, por el
portal datos.

### Cap. 19 — 14. Manejo de secretos

# 14. Manejo de secretos

Las 	aplicaciones 	habitualmente
contienen múltiples secretos que son
necesarios para su operación. Éstos
pueden incluir certificados digitales,
contraseñas para la base de d

Secciones:
  # 14. Manejo de secretos

Conclusión: Toda la
información relacionada a certificados
digitales, 	contraseñas, 	llaves,
credenciales, incluidas las rutas de
almacenamiento u otras referencias a
estos 	objetos, 	deben 	quedar
debidamente parametrizadas en un
archivo de variables de entorno y éste
debe ser excluido de la herramienta de
control de versiones.

### Cap. 20 — 15. Desarrollo 	orientado 	a

# 15. Desarrollo orientado a pruebas Para efectos de trabajo con datos o ejercicios, el equipo de desarrollo deberá tener un set de datos no válidos, escogido para trabajar y cargar el sitio para e Secciones: # 15. Desarrollo orientado a Conclusión: Este set División de Gobierno Digital | Lineamientos para desarrollo de software 13 -- 13 of 33 -- no debe contener información que sea real y la cantidad de datos debe ser reducida, pero suficiente para generar pruebas...

### Cap. 21 — 16. Calidad de código

# 16. Calidad de código

El código deberá ser revisado de forma
continua durante su construcción con
herramientas de inspección.
Ejemplos de herramientas son:
● CodeClimate
● SonarQube
● Github Advanc

Secciones:
  # 16. Calidad de código

Conclusión: La configuración de
ambas, o al menos de una de las
aplicaciones, debe ser guardada como
archivo de configuración dentro del
código, para luego ser usado en la
integración continua.

### Cap. 22 — 17. Detección preventiva

# 17. Detección preventiva

Para todo lo relacionado con las
aplicaciones, se debe configurar y usar
algún proyecto OWASP (ejemplo:
OWASP ZAP) para la búsqueda de
vulnerabilidades en la aplicación. Es

Secciones:
  # 17. Detección preventiva

Conclusión: Sin embargo, como se considera un
desarrollo continuo después de una
entrega final, la configuración del
proyecto 	usado 	debe 	quedar
documentado dentro del código, tanto
para uso futuro 	como para ser
integrada dentro del pipeline de
despliegue/integración continua.

### Cap. 23 — 18. Modelo inicial de datos

# 18. Modelo inicial de datos

Las estructuras de base de datos no
deberán contener datos, tan sólo los
esquemas y, de requerir la carga de
datos externos producto de un proceso
de inicialización, estos datos no deben ir
en el código y serán procesados por una
vía interna y privada, en el caso que se
requiera.

### Cap. 24 — 19. Seeding de la base de datos

# 19. Seeding de la base de datos La creación de usuarios administradores iniciales o de cualquier tipo de información sensible, debe quedar fuera del sistema de versionamiento del código. El proc Secciones: # 19. Seeding de la base de datos Conclusión: El proceso de creación de un usuario inicial de administración, así como cualquier otro dato sensible para el funcionamiento de la aplicación cuya filtración involucre una merma de seguridad, debe ser documentado, entregado confidencialmente y nunca ser registrado...

### Cap. 25 — 20. Implementar mecanismos de

# 20. Implementar mecanismos de

registros o logs
Se deben registrar distintos eventos del
sistema para permitir que éstos sean
monitoreados de forma automatizada
para efectos de seguridad:
● Utilizar

Secciones:
  # 20. Implementar mecanismos de

Conclusión: Dentro del stack de herramientas
detallado en Tecnologías de Preferencia,
se encuentran opciones Open Source.

### Cap. 26 — 21. Manejo seguro de errores y

# 21. Manejo seguro de errores y

excepciones
Se debe desarrollar el sistema, de forma
tal, que aplique el principio de “fallar
seguro”, es decir:
● No exponer información sensible o
privada en los me

Secciones:
  # 21. Manejo seguro de errores y

Conclusión: Registrar 	las 	excepciones
adecuadamente en los sistemas
que correspondan.

### Cap. 27 — 22. Compilación limpia

# 22. Compilación limpia

De ser un lenguaje compilado y no
interpretado, no es necesario contar con
ningún tipo de alerta en el momento de
compilación. Para conseguir este
objetivo, lo mejor es dar las opciones al
compilador para tratar las alertas
(warnings) como si fueran errores y, de
esta forma, fallar en caso de existir una
alerta (warning) al momento de la
compilación.
División de Gobierno Digital | Lineamientos para desarrollo de software 	15

-- 15 of 33 --

### Cap. 28 — IV. Aseguramiento y certificación

# IV. Aseguramiento y certificación

de calidad
Para facilitar la ejecución y registro de pruebas se recomienda el uso
de herramientas de integración/despliegue continuo (CI/CD) y de
herramientas de r

Secciones:
  # IV. Aseguramiento y certificación

Conclusión: Al final de este documento se presentan
algunos ejemplos de archivos de
configuración de un pipeline CI/CD en
las herramientas Gitlab y Github.

### Cap. 29 — V. Tecnologías de preferencia

# V. Tecnologías de preferencia

Para facilitar la ejecución y registro de pruebas se recomienda el uso
de herramientas de integración/despliegue continuo (CI/CD) y de
herramientas de revisión del código integradas a este pipeline CI/CD.
Se recomienda el uso de las siguientes
tecnologías 	de desarrollo 	y
arquitectura del software.

### Cap. 30 — 1. Lenguajes de programación

# 1. Lenguajes de programación ● Sistemas de información: ➢ Python 3.6+ ➢ PHP 7.1 ➢ Java 11+ ➢ C# 7.3+ ➢ Ruby 2.4.9+ ➢ Go Language 1.13+ ● Microservicios: ➢ Python 3.6+ ➢ NodeJS 8+ ➢ Go Language 1.13 Secciones: # 1. Lenguajes de programación Conclusión: Los frameworks y bibliotecas para desarrollo recomendados son: ➢ PHP: Laravel, Symfony, CodeIgniter ➢ Python: Django y Flask ➢ Ruby: Ruby on Rails ➢ Go: Revel, Gin, Martini ➢ Java: Spring Boot, Splunk...

### Cap. 31 — VI. Uso de tecnologías

# VI. Uso de tecnologías

Para facilitar la ejecución y registro de pruebas se recomienda el uso
de herramientas de integración/despliegue continuo (CI/CD) y de
herramientas de revisión del código integradas a este pipeline CI/CD.

### Cap. 32 — 1. Lenguaje

Spring Boot, etc.

Secciones:
  # 1. Lenguaje

Conclusión: Algunos ejemplos de frameworks que
soportan este paradigma en diversos
lenguajes son: Laravel, Symfony,
CodeIgniter, Flask, Django, Beego, Revel,
Spring Boot, etc.

### Cap. 33 — 2. Almacenamiento

# 2. Almacenamiento Para la gestión de datos, tanto relacionales como no relacionales, se sugiere instalar las bases de datos en modo cluster. Además, se deben tomar las precauciones necesarias, por Secciones: # 2. Almacenamiento Conclusión: Con respecto al uso de bases de datos no relacionales, se debe tener cuidado en la elección del driver, debiendo ser capaz de conectarse a más de un nodo del cluster a la vez para, de esta forma, mantener el paradigma de un sistema...

### Cap. 34 — 3. Tareas fuera de línea o

Preferencia.

Secciones:
  # 3. Tareas fuera de línea o

Conclusión: El consumo de las colas
debe ser con procesos que no tengan
relación con el sitio y debe ser posible
desarrollarlos e implementarlos como
un servicio separado.

### Cap. 35 — 4. Formateo de código

# 4. Formateo de código

Para una mejor lectura del código por
personas en la organización y para el
futuro, se recomienda de sobremanera
el uso de los formateadores de texto.
Éstas son herramientas q

Secciones:
  # 4. Formateo de código

Conclusión: Para
lenguajes como Python, se sugiere
PEP8, sin embargo, el estilo y formateo
de una organización debe ser elegido
por la misma y se sugieren los
estándares propuestos para cada
lenguaje por sus creadores.

### Cap. 36 — 5. Repositorios de código

# 5. Repositorios de código

Se debe utilizar repositorios para
almacenar el código de las aplicaciones,
ya sea on premise o mediante algún
servicio en la nube. Github, Gitlab y
Bitbucket son algunos ejemplos de
servicios de repositorio de código.
División de Gobierno Digital | Lineamientos para desarrollo de software 	20

-- 20 of 33 --

### Cap. 37 — VII. Desarrollo y consumo de APIs

# VII. Desarrollo y consumo de APIs

La exposición de los servicios API REST debe utilizar mecanismos de
autenticación para su consumo privado, ya sea tokens (JWT u otros),
certificados o llaves criptográficas, u otros como medios de
autenticación entre puntos.

### Cap. 38 — 1. Ley de Transformación Digital

# 1. Ley de Transformación Digital

(21.180)
Actualmente, en el marco de la Ley de
Transformación Digital (21.180) se está
elaborando una Norma Técnica de
Interoperabilidad. Esta Norma Técnica
consignará 	los 	estándares 	de
interoperabilidad que deberán cumplir
las instituciones.
Mientras esta Norma Técnica se elabora
y publica, a continuación, se mencionan
algunas buenas prácticas para aquellas
instituciones que están utilizando
arquitectura REST en sus servicios web.

### Cap. 39 — 2. Desacoplar 	clientes 	y

# 2. Desacoplar 	clientes 	y

servicios web
Las aplicaciones construidas bajo los
lineamientos expuestos hasta acá,
deberán propender a cumplir con dos
características fundamentales:
● Independencia de la plataforma.
● Evolución del servicio.
Para cumplir esto, se deben desacoplar
las implementaciones de clientes y
servicios, y poner a disposición sus
métodos y operaciones.

### Cap. 40 — 3. Uso de HTTP

CRUD (create, read, update y delete).

Secciones:
  # 3. Uso de HTTP

Conclusión: Es importante identificar que, de los
métodos precedentes, los cuatro
primeros son los más utilizados, en
particular para atender las operaciones
CRUD (create, read, update y delete).

### Cap. 41 — 4. Exposición y autenticación de

# 4. Exposición y autenticación de

servicios
La exposición de los servicios API REST
debe 	utilizar 	mecanismos 	de
autenticación para su consumo privado,
ya sea tokens (JWT u otros),
certificados o llaves criptográficas, u
otros como medios de autenticación
entre puntos.

### Cap. 42 — 5. Definición de URI de recursos

# 5. Definición de URI de recursos

La definición de URI de recursos debe
propender a seguir las prácticas
expresadas a continuación como
ejemplo:
● Usar sustantivos para describir los
recursos:
➢ GET

Secciones:
  # 5. Definición de URI de recursos

Conclusión: Para la descripción de servicios se
recomienda utilizar el estándar OpenAPI
Specification (OAS) v3.

### Cap. 43 — 6. Uso del idioma en el código

# 6. Uso del idioma en el código

Se recomienda utilizar de la siguiente
forma el uso de idioma castellano e
inglés a nivel de programación y
definición de esquemas para la
construcción de servicios:

Secciones:
  # 6. Uso del idioma en el código

Conclusión: División de Gobierno Digital | Lineamientos para desarrollo de software 	23

-- 23 of 33 --

● Campos de auditorías en base de
datos, por ejemplo, created_at,
updated_at y deleted_at, etc.

### Cap. 44 — VIII. Uso de contenedores en el

# VIII. Uso de contenedores en el

despliegue
Para el despliegue de las aplicaciones es altamente recomendado el
uso de contenedores, debido a la facilidad de movilidad de los
mismos y replicación de

Secciones:
  # VIII. Uso de contenedores en el

Conclusión: Sin
embargo, se sugiere considerar su uso
en los futuros desarrollos y, de esta
forma, 	ir 	avanzando 	hacia
infraestructuras más flexibles y que
pueden crecer de forma horizontal.

### Cap. 45 — IX. Licencias

# IX. Licencias Todo desarrollo realizado al interior del Estado debe propender a estar licenciado, acorde a las necesidades de uso con que fue creado. Todo desarrollo realizado al interior del Estad Secciones: # IX. Licencias Conclusión: Para el Estado es fundamental la colaboración entre instituciones, por lo que se sugiere la construcción de software cuyo código fuente sea accesible por otras instituciones, así como también para estar frente al escrutinio de los ciudadanos y que éstos puedan realizar los...

### Cap. 46 — 1. GPLv2 y GPLv3

# 1. GPLv2 y GPLv3 Este conjunto de licencias es conocido como copyleft, es decir, requiere que las modificaciones realizadas al software, incluyendo cambios efectuados por terceros, sean puestos a d Secciones: # 1. GPLv2 y GPLv3 Conclusión: Para todos los desarrollos, se recomienda el uso de la licencia GPLv3, pero también se puede utilizar la licencia GPLv2 en caso de que alguna institución requiera modificar software que utilice dicha licencia y no pueda apelar a re-licenciar la misma a...

### Cap. 47 — 3. Apache 2.0

# 3. Apache 2.0

Esta licencia, compatible con GPLv3
(no inferiores), supone muchas ventajas
para mantener el código libre y también
permite trabajos secundarios y uso del
código en otros proyectos. S

Secciones:
  # 3. Apache 2.0

Conclusión: Un
ejemplo de esto último es cuando se
genera un producto complementario
que podría llegar a ser usado por otros
gobiernos e, incluso, por el mundo
privado.

### Cap. 48 — 4. Dominio Público (Creative

# 4. Dominio Público (Creative

Commons 0 y equivalentes)
Estas licencias actúan como el
equivalente a poner en dominio público
el trabajo realizado. Son eficaces para
compartir datos que puedan ser
utilizados por la comunidad científica,
medios audiovisuales y otros datos que
requieran una distribución lo más
amplia posible.
Habitualmente, esta licencia se aplica a
los datos generados por un software y
no al software en sí, salvo algunas
excepciones.

### Cap. 49 — 5. Casos de uso de licencia

# 5. Casos de uso de licencia

Al momento de aplicar las licencias se
debe tener especial consideración en
cómo se desea perpetuar el código en el
tiempo, es decir, cuando el código sea
un proyecto re

Secciones:
  # 5. Casos de uso de licencia

Conclusión: No aplica
para lenguajes interpretados.

### Cap. 50 — 6. Buenas 	prácticas 	de

COPYING.TXT.

Secciones:
  # 6. Buenas 	prácticas 	de

Conclusión: If 	not, 	see
<https://www.

### Cap. 51 — X. Actualizaciones a esta guía

# X. Actualizaciones a esta guía Dado que el mundo de la tecnología avanza cada vez a pasos más y más agigantados, esta guía será sometida a revisión una vez al año, en busca de las actualizaciones q Secciones: # X. Actualizaciones a esta guía Conclusión: Sin desmedro de lo anterior, la guía a futuro podrá contener un anexo con fe de erratas apropiadas, que serán incorporadas en la medida que éstas sean detectadas, sin la necesidad de esperar a...

### Cap. 52 — 1. Ejemplo Dockerfile aplicación

# 1. Ejemplo Dockerfile aplicación

PHP
El archivo Dockerfile es el que da el
inicio a la construcción de la imagen
que será cargada en un servicio de
registry de imágenes para su posterior
uso. A continuación se muestra un
Dockerfile de ejemplo de una aplicación
PHP.

### Cap. 53 — 2. Ejemplo Gitlab-ci.yml

# 2. Ejemplo Gitlab-ci.yml

El archivo gitlab-ci.yml es un archivo
YAML que se encuentra en la raíz del
proyecto, 	y 	que 	se 	ejecuta
automáticamente cada vez que se
ejecuta un commit. Este archivo hace
que un runner procese las tareas
especificadas en el mismo archivo.

### Cap. 54 — 3. Ejemplo Github-action.yml

# 3. Ejemplo Github-action.yml

El mismo concepto que el gitlab-ci.yml,
pero para Github actions
División de Gobierno Digital | Lineamientos para desarrollo de software 	30

-- 30 of 33 --

Ejemplo Do

Secciones:
  # 3. Ejemplo Github-action.yml

Conclusión: División de Gobierno Digital | Lineamientos para desarrollo de software 	32

-- 32 of 33 --

Ejemplo github-actions.

### Cap. 55 — - 	CLUSTER_NAME:

T_SHA} .

Secciones:
  # - 	CLUSTER_NAME:

Conclusión: REPOSITORY}:latest
- docker 	push
${AWS_ACCOUNT_ID}.

### Cap. 56 — T_SHA}

# T_SHA}

- 	- name: kubernetes deploy
- 	run: |
- aws eks update-kubeconfig --name ${CLUSTER_NAME} --region us-east-2
- 	kubectl 	set 	image 	deploy/$APP_NAME
$APP_NAME=${AWS_ACCOUNT_ID}.dkr.ecr.us-east-2.amazonaws.com/${REPOSITORY}:${SHORT_SHA
} -n ${NAMESPACE} --record
División de Gobierno Digital | Lineamientos para desarrollo de software 	33

-- 33 of 33 --

