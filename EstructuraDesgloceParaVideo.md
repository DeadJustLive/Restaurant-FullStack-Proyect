Respuesta directa: Debes grabar un video .mp4 individual donde muestres y expliques el código del microservicio que implementaste siguiendo la pauta provista en la "Defensa técnica" — cubre los 18 puntos del guion (desde "Mi microservicio" hasta "GitHub") y demostrar ejecución y pruebas en Postman.

Qué presentar en el video (lista clara, sigue exactamente el guion recomendado)

Introducción breve: di qué microservicio implementaste y su responsabilidad dentro del sistema.

POM padre/hijo: muestra los pom.xml relevantes y explica qué gestiona el padre y qué el hijo.

application.yml: muestra la configuración (puerto, conexión a BD, registro en Eureka) y coméntala.

Modelo de datos: enseña el diagrama (por ejemplo en DBeaver), nombra las tablas usadas y justifica relaciones y normalización.

Clase Application: muestra la clase main y explica qué anotaciones/funcionalidades (Eureka, Feign) habilita.

Manejo de excepciones comunes: muestra las clases de error y explica cómo centralizan respuestas.

JPA / Entity: muestra la entidad principal, relaciones (one-to-many, many-to-many) y propiedades clave.

Repository: enseña la interfaz que extiende JpaRepository y explica consultas personalizadas si las hay.

DTOs: muestra los DTOs que usas para entrada/salida y explica por qué separaste entidad y DTO.

Mapper: enseña cómo conviertes Entity <-> DTO (MapStruct/manual) y muestra un ejemplo.

Service (lógica de negocio): explica los métodos principales (create, delete, update), recorre el código y justifica decisiones.

Client (Feign): muestra la interface cliente usada para consumir otros microservicios y explica su uso declarativo.

Controller: muestra endpoints expuestos y describe al menos un endpoint (por ejemplo create) en detalle.

Kafka (si aplica): muestra producers/consumers o cómo envías/recibes mensajes para actualizar proyecciones.

Logs: enseña ejemplos de logs y explica puntos donde los generas para trazabilidad.

Eureka: abre el dashboard y muestra tu microservicio corriendo en el puerto indicado.

Postman: prueba en vivo al menos un findAll y un delete (o equivalentes) para demostrar funcionamiento.

GitHub: muestra 1 commit tuyo con tu usuario y explica brevemente tu aporte en issues/tareas.

Requisitos formales y evaluaciones importantes

Formato: video .mp4 (no otro).

Debe escucharse tu voz narrando preferentemente las frases sugeridas, y seguir la pauta para no equivocarse.

Entregar también el zip con los 10 microservicios (entrega grupal) en AVA; el video es individual.

La rubrica puntúa estructura CSR, modelado BD, CRUD, reglas de negocio, validaciones, excepciones, logs, comunicaciones entre microservicios, pruebas en vivo, y tu aporte personal (ver porcentajes en la pauta).

Consejos prácticos para el video (2–3 frases)

Graba en pantalla mostrando tu IDE (clase/archivos clave), DBeaver, Eureka y Postman; usa cortes para mantenerlo conciso.

Empieza con la frase sugerida exacta para cada componente cuando corresponda, y prepara ejemplos cortos (30–60 s) para cada punto crítico.



---


Sí: lo mejor es que estructures la explicación como una plantilla fija para que la IA te vaya desglosando cada parte del proyecto de forma ordenada y no improvises al grabar.

Estructura general del video
Para cada componente, usa siempre este esquema:

Qué es
Explica el nombre de la pieza y su función dentro del microservicio.

Para qué sirve en el proyecto
Relaciónalo con el negocio o el problema que resuelve.

Cómo está implementado
Menciona clases, métodos, archivos, anotaciones o librerías.

Qué flujo sigue
Di qué entra, qué procesa y qué sale.

Por qué se hizo así
Justifica la decisión técnica, aunque sea breve.

Prueba o evidencia
Muestra algo real: código, consola, Eureka, Postman, DBeaver, logs o commit.

Estructura por cada parte
1. Microservicio
Debes explicar:

Nombre del microservicio.

Responsabilidad principal.

Qué problema del negocio resuelve.

Qué datos maneja.

Con qué otros microservicios se comunica.

Orden ideal:
“Este microservicio se encarga de…”, “su objetivo es…”, “trabaja con estas entidades…”, “se comunica con…”

2. POM padre e hijo
Debes explicar:

Qué gestiona el padre.

Qué define el hijo.

Qué dependencias usa el microservicio.

Si hay herencia o centralización de versiones.

Orden ideal:
“El pom padre centraliza…”, “el hijo agrega…”, “esto evita duplicar…”

3. application.yml
Debes explicar:

Puerto del servicio.

Nombre de la aplicación.

Configuración de base de datos.

Configuración de Eureka.

Otras propiedades importantes.

Orden ideal:
“Acá se define…”, “esto permite…”, “esta configuración conecta con…”

4. Modelo de datos
Debes explicar:

Tablas o entidades.

Relación entre ellas.

Clave primaria y foráneas.

Normalización o separación lógica.

Por qué ese diseño es correcto.

Orden ideal:
“Esta tabla representa…”, “se relaciona con…”, “esto evita duplicidad…”

5. Clase Application
Debes explicar:

Qué hace esa clase.

Qué anotaciones importantes tiene.

Qué habilita en el sistema.

Si registra el servicio en Eureka.

Si activa Feign.

Orden ideal:
“Esta clase es el punto de entrada…”, “con esta anotación habilito…”

6. Excepciones
Debes explicar:

Qué errores controlas.

Qué clase centraliza el manejo.

Qué respuesta devuelve.

Qué mejora frente a lanzar errores sueltos.

Orden ideal:
“Estas excepciones sirven para…”, “se capturan aquí…”, “la API responde con…”

7. Entity / modelo JPA
Debes explicar:

Qué representa la entidad.

Qué atributos tiene.

Qué relaciones contiene.

Qué anotaciones usa.

Cómo se conecta con la tabla real.

Orden ideal:
“Esta entidad modela…”, “cada atributo representa…”, “la relación con…”

8. Repository
Debes explicar:

Qué persiste.

Qué extiende.

Qué consultas agrega.

Para qué sirve cada método personalizado.

Orden ideal:
“Este repositorio permite…”, “al extender JpaRepository…”, “este método consulta…”

9. DTO
Debes explicar:

Qué datos recibe.

Qué datos envía.

Por qué no expones directamente la entidad.

Qué mejora aporta.

Orden ideal:
“Uso DTO para separar…”, “este request recibe…”, “este response devuelve…”

10. Mapper
Debes explicar:

Qué convierte.

De dónde a dónde convierte.

Por qué evita duplicar lógica.

Si usa métodos manuales o biblioteca.

Orden ideal:
“Este mapper transforma…”, “convierte de Entity a Response…”, “y de Request a Entity…”

11. Service
Debes explicar:

Qué lógica de negocio vive aquí.

Qué hace create, update, delete, find.

Qué validaciones aplica.

Qué llama al repository o a otros servicios.

Orden ideal:
“Aquí está la lógica principal…”, “cuando se crea…”, “cuando se elimina…”

12. Client Feign
Debes explicar:

Qué microservicio consume.

Qué datos obtiene.

Por qué se usa una interfaz.

Qué endpoints remotos llama.

Cómo impacta en el flujo del negocio.

Orden ideal:
“Con este client consulto…”, “se usa para obtener información remota…”

13. Controller
Debes explicar:

Qué endpoints expone.

Qué hace cada endpoint.

Qué recibe y qué devuelve.

Cómo conecta con el service.

Orden ideal:
“Este controller expone…”, “este endpoint recibe…”, “y responde con…”

14. Kafka
Debes explicar:

Qué evento se publica o consume.

Para qué sirve la asincronía.

Qué tabla o proceso actualiza.

Por qué no se hace de forma síncrona.

Orden ideal:
“Kafka se usa para…”, “esto permite desacoplar…”, “cuando ocurre X, se publica…”

15. Logs
Debes explicar:

Qué eventos registras.

En qué puntos importantes.

Qué ayuda da para depuración.

Qué tipo de información no conviene loguear.

Orden ideal:
“Agregué logs en…”, “esto me permite rastrear…”, “sirve para depurar…”

16. Eureka
Debes explicar:

Que el microservicio está registrado.

Con qué nombre aparece.

En qué puerto corre.

Qué demuestra esa imagen o pantalla.

Orden ideal:
“Aquí vemos el servicio registrado…”, “está corriendo en…”

17. Postman
Debes explicar:

Qué endpoint pruebas.

Qué envías.

Qué respuesta esperas.

Qué valida esa prueba.

Orden ideal:
“Voy a probar…”, “envío este request…”, “la respuesta confirma…”

18. GitHub
Debes explicar:

Qué commit muestras.

Qué parte hiciste tú.

Qué evidencia hay de tu aporte.

Si trabajaste en una tarea concreta.

Orden ideal:
“Aquí se ve mi commit…”, “yo implementé…”, “esto demuestra mi aporte…”

Plantilla corta para que la IA te desglosé el conocimiento
Puedes pedirle a la IA que analice cada parte del proyecto así:

Nombre del componente.

Función dentro del sistema.

Clases/archivos involucrados.

Flujo paso a paso.

Relación con otras capas.

Decisión técnica o justificación.

Ejemplo real desde el código.

Qué debería mostrar en el video.

Orden recomendado del video
Presentación del microservicio.

POM y configuración.

Modelo de datos.

Entity, DTO, mapper, repository.

Service y controller.

Excepciones y logs.

Comunicación con otros microservicios o Kafka.

Eureka y pruebas en Postman.

GitHub y aporte personal.

Ese orden es bueno porque va de lo general a lo específico y termina con evidencia práctica.

Cómo pedirle a la IA que te ayude
Puedes usar prompts como estos:

“Explícame este archivo como si fuera para defensa oral, en orden: qué hace, cómo funciona y por qué se hizo así.”

“Desglosa esta clase en partes: propósito, atributos, métodos, relaciones, errores posibles y cómo lo mostraría en el video.”

“Convierte este código en un guion técnico corto para grabar.”

“Resume esta parte del proyecto en formato: qué es, para qué sirve, cómo fluye y qué evidencia mostrar.”

“Hazme una explicación nivel defensa individual, sin tecnicismos innecesarios pero con suficiente detalle.”

Estructura ideal de cada explicación
Si quieres una fórmula simple para memorizar, usa esta:

Definición → Función → Implementación → Flujo → Justificación → Evidencia

Ejemplo:
“Este repository gestiona la persistencia de la entidad X. Se usa para guardar y consultar datos en la base. Está implementado extendiendo JpaRepository. El flujo es que el service lo llama y luego devuelve resultados al controller. Se eligió así porque simplifica el acceso a datos. Aquí lo muestro funcionando en Postman.”