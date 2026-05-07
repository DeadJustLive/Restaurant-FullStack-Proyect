# Plan de Integración de Microservicios (Reducción a 10 servicios)

## Objetivo
Consolidar la arquitectura actual reduciendo de 12 a 10 microservicios, fusionando aquellos con alta cohesión de negocio:
1. **Fase 1:** Integrar `ms-categorias` dentro de `ms-menu`.
2. **Fase 2:** Integrar `ms-usuarios` dentro de `ms-auth`.

---

## Fase 1: Integrar Categorías a Menú (`ms-categorias` -> `ms-menu`)

### 1. Bases de Datos y `application.yml`
Actualmente, `ms-categorias` (Puerto 9005) usa la DB `categorias` y `ms-menu` (Puerto 9004) usa la DB `menu`.
* **Estrategia:** Unificaremos todo en la base de datos `menu`.
* **Acción DB:** En el archivo `init-db/init.sql` se debe eliminar `CREATE DATABASE categorias;`.
* **Acción YAML:** No se modificará el `application.yml` de `ms-menu`. El puerto 9005 dejará de existir.

### 2. Fusión de Dependencias (`pom.xml`)
* **Acción:** Revisar el `pom.xml` de `ms-categorias`. Si existe alguna dependencia exclusiva (por ejemplo, librerías específicas de mapeo o validación), copiarla al `pom.xml` de `ms-menu`.

### 3. Copiado de Código y Refactorización
Se deben copiar los componentes como subpaquetes dentro de la estructura de `ms-menu`:
* **Entidades y Tablas:** Copiar `Categoria.java` al paquete `cl.triskeledu.menu.entity`. Ambas entidades se guardarán en la DB `menu`.
* **Interacción de Entidades (JPA - Punto Crítico):** Actualizar la entidad `MenuItem` para transformar el `categoriaId` (Long) en una relación de base de datos real. Se debe usar `@ManyToOne(fetch = FetchType.LAZY)` hacia la entidad `Categoria` y un `@JoinColumn(name = "categoria_id")`. Esto permitirá recuperar el menú y sus categorías con un solo `JOIN`, integrando las tablas directamente e eliminando la necesidad de llamadas Feign.
* **Repositorios:** Copiar `CategoriaRepository.java` a `cl.triskeledu.menu.repository`.
* **Servicios:** Copiar la lógica a `cl.triskeledu.menu.service`.
* **Controladores:** Copiar `CategoriaController.java` a `cl.triskeledu.menu.controller`.
* **Proyección Kafka (Futuro):** Se creará un paquete `cl.triskeledu.menu.messaging` (o `event`) para manejar la publicación de eventos de dominio (ej. `MenuUpdatedEvent`, `CategoryCreatedEvent`) cuando se integre Kafka, aislando la lógica asíncrona del CRUD principal.

### 4. Actualización del API Gateway / Frontend
* En el API Gateway (o si el Frontend apunta directo a los puertos), las rutas que iban a `http://localhost:9005/api/categorias` ahora deberán apuntar a `http://localhost:9004/api/categorias`.

### 5. Respaldo (Backup)
* Renombrar la carpeta `/ms-categorias` a `/ms-categorias.backup`. No eliminaremos los archivos originales para tener un punto de restauración seguro.

---

## Fase 2: Integrar Usuarios a Auth (`ms-usuarios` -> `ms-auth`)

### 1. Bases de Datos y `application.yml`
Actualmente, `ms-auth` (Puerto 9001) usa la DB `auth` y `ms-usuarios` (Puerto 9002) usa la DB `usuarios`.
* **Estrategia:** Unificaremos el control de identidad completo en la base de datos `auth`.
* **Acción DB:** En el archivo `init-db/init.sql` se debe eliminar `CREATE DATABASE usuarios;`.
* **Acción YAML:** Conservamos el `application.yml` de `ms-auth`. Se descarta el de `ms-usuarios`.

### 2. Fusión de Dependencias (`pom.xml`)
* **Acción:** `ms-auth` ya posee Spring Security y JWT. Moveremos al `pom.xml` de `ms-auth` cualquier dependencia requerida por `ms-usuarios` (ej. `spring-boot-starter-validation`).

### 3. Copiado de Código y Refactorización
* **Entidades y Tablas:** Copiar `Usuario.java`, `Role.java`, repositorios y servicios a `cl.triskeledu.auth.*`. Estas tablas se crearán ahora en la DB `auth`.
* **Interacción de Entidades (Punto Crítico):** Previamente, `ms-auth` se comunicaba por red (Feign) con `ms-usuarios` para validar credenciales. Ahora, la entidad `Usuario` y `Role` estarán disponibles localmente en la misma unidad de compilación. El `AuthService` o `UserDetailsServiceImpl` interactuará directamente con `UsuarioRepository` y `RoleRepository` a nivel de base de datos (con llaves foráneas entre usuarios y roles), eliminando la latencia de red e incrementando la integridad y seguridad.
* **Controladores:** Copiar los endpoints de gestión (CRUD de Usuarios) al controlador de `ms-auth`.
* **Proyección Kafka (Futuro):** Se creará un paquete `cl.triskeledu.auth.messaging` para publicar eventos como `UserRegisteredEvent` o `RoleChangedEvent`. Esto permitirá que otros servicios (ej. `ms-notificaciones`) reaccionen sin hacer llamadas síncronas.

### 4. Ajustes de Seguridad (`SecurityFilterChain`)
* Como ahora las rutas de gestión de usuarios viven en el servicio de Auth, debemos asegurarnos que las rutas `/auth/login` y `/auth/register` sean públicas (`permitAll()`), pero que las rutas `/usuarios/**` requieran autenticación (`authenticated()`) y posiblemente validación de roles (`hasRole("ADMIN")`).

### 5. Actualización del API Gateway / Frontend
* Redirigir el tráfico del Gateway para `/api/usuarios` hacia el servicio `ms-auth` (Puerto 9001).

### 6. Respaldo (Backup)
* Renombrar la carpeta `/ms-usuarios` a `/ms-usuarios.backup`. No eliminaremos los archivos originales.

---

## Fase 3: Estandarización de Manejo de Excepciones (Global Exception Handling)

**Objetivo:** Asegurar que los microservicios restantes manejen los errores de manera uniforme (ej. códigos HTTP correctos, respuestas JSON estructuradas) facilitando la lectura de errores en el API Gateway y el Frontend. Esta fase se ejecuta **después** de completar exitosamente las Fases 1 y 2.

### 1. Scaffolding y Estructuración Previa
* Se generarán mockups para la clase `GlobalExceptionHandler` (`@ControllerAdvice`) y excepciones personalizadas (`ResourceNotFoundException`, `BusinessValidationException`) para revisar la estructura antes de implementarla.

### 2. Implementación Definitiva
* Se integrarán las clases de manejo de errores en los paquetes `cl.triskeledu.*.exception`.
* Se refactorizarán los servicios y controladores para lanzar estas excepciones de dominio en lugar de retornar errores genéricos 500.

---

## Consideraciones Generales y Actualización de Documentación Transversal
1. **Documentación Continua:** Al finalizar CADA fase (1, 2 y 3), se debe actualizar de forma obligatoria la documentación. En los diagramas de Mermaid se deben eliminar los nodos obsoletos, corregir flechas, y agregar los nuevos flujos (ej. excepciones y Kafka). Los diccionarios deben reflejar el estado real de la DB para evitar elementos diferidos o desactualizados.
2. **Registro de Cambios (`changelog_migracion_v12_a_v10.md`):** Mantener un archivo log detallando qué clases, entidades y configuraciones se movieron en cada paso para facilitar el seguimiento interno.
3. **`docker-compose.yml` y DB:** Aunque el `docker-compose.yml` principal de Postgres se mantiene similar, tener en cuenta que el script de inicialización (`init-db/init.sql`) y la configuración de contenedores (si despliegas los MS en Docker) se reduce en 2 servicios.
4. **Scripts de Arranque:** Si usas los archivos `.bat` o `.py` de la carpeta raíz (`compile.bat`, `launch.bat`), elimina de las listas a los dos microservicios removidos.
5. **Flujo de Trabajo:** Completa y prueba al 100% la Fase 1 (incluyendo actualización de su documentación) antes de tocar la Fase 2. No hagas ambas al mismo tiempo para aislar posibles errores.
