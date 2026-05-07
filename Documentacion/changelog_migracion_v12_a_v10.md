# Registro de Cambios (Changelog): Migración v12 a v10 Microservicios

Este documento sirve como bitácora interna de seguimiento para las modificaciones realizadas durante la consolidación de la arquitectura de microservicios (reducción de 12 a 10 servicios).

## Estado Actual
- **Fase 1 (Categorías a Menú):** `[Completado]`
- **Fase 2 (Usuarios a Auth):** `[Completado]`
- **Fase 3 (Estandarización de Excepciones):** `[Completado]`
- **Fase 4 (Lógica de Negocio Post-Integración):** `[Completado]`

---

## 🛠️ Fase 1: Integración de `ms-categorias` a `ms-menu`

### 1. Base de Datos y Docker
- [x] Modificado `init-db/init.sql` para remover `CREATE DATABASE categorias;`.
- [x] Tablas de categorías (`Category`) preparadas para ser creadas/migradas a la DB `menu`.

### 2. Archivos POM y YAML
- [x] Revisadas dependencias de `ms-categorias` (se unieron al POM de `ms-menu` en caso de haber exclusivas).
- [x] El puerto `9005` y la configuración YAML de `ms-categorias` se marca como obsoleta/eliminada.

### 3. Copiado de Código (Entidades y Relaciones)
- [x] Entidad `Categoria` copiada al paquete `cl.triskeledu.menu.entity`.
- [x] Entidad `MenuItem` actualizada con la relación `@ManyToOne` hacia `Categoria`, reemplazando el `categoriaId` plano.
- [x] Repositorio `CategoriaRepository` copiado a `cl.triskeledu.menu.repository`.
- [x] `CategoriaService` e interfaces relacionadas copiadas a `cl.triskeledu.menu.service`.
- [x] `CategoriaController` copiado a `cl.triskeledu.menu.controller`.
- [x] Eliminadas llamadas Feign (si existían) entre Menú y Categorías.

### 4. Respaldo y Documentación
- [x] Carpeta `/ms-categorias` renombrada a `/ms-categorias.backup`.
- [x] Removido `ms-categorias` de `compile.bat`, `launch.bat` y `pom.xml` padre (si existe).
- [x] Actualizado `diagramas.md` para reflejar la eliminación del nodo `ms-categorias`.
- [x] Actualizado `diccionarios.md` reflejando las tablas integradas en `DB menu`.

---

## 🛠️ Fase 2: Integración de `ms-usuarios` a `ms-auth`

### 1. Base de Datos y Docker
- [x] Modificado `init-db/init.sql` para remover `CREATE DATABASE usuarios;`.
- [x] Tablas de usuarios y roles preparadas para ser creadas/migradas a la DB `auth`.

### 2. Archivos POM y YAML
- [x] Dependencias exclusivas de `ms-usuarios` (como validación) agregadas al POM de `ms-auth`.
- [x] El puerto `9002` y la configuración YAML de `ms-usuarios` se marca como obsoleta/eliminada.

### 3. Copiado de Código (Entidades y Seguridad)
- [x] Entidades `Usuario` y `Role` copiadas al paquete `cl.triskeledu.auth.entity`.
- [x] Repositorios `UsuarioRepository` y `RoleRepository` copiados a `cl.triskeledu.auth.repository`.
- [x] Lógica de negocio (Servicios) copiada a `cl.triskeledu.auth.service`.
- [x] Refactorizada la clase `UserDetailsServiceImpl` (o AuthService) para consumir directamente la base de datos `auth` en lugar de requerir llamadas HTTP a usuarios.
- [x] `UsuarioController` copiado a `cl.triskeledu.auth.controller`.
- [x] Actualizada la seguridad (`SecurityFilterChain`) para proteger el nuevo endpoint `/usuarios/**`.

### 4. Respaldo y Documentación
- [x] Carpeta `/ms-usuarios` renombrada a `/ms-usuarios.backup`.
- [x] Removido `ms-usuarios` de `compile.bat`, `launch.bat` y `pom.xml` padre.
- [x] Actualizado `diagramas.md` para reflejar la consolidación del nodo de identidad.
- [x] Actualizado `diccionarios.md` reflejando las tablas integradas en `DB auth`.

---

## 🛠️ Fase 3: Estandarización de Excepciones (Post-Integración)

### 1. Scaffolding de Excepciones
- [x] Creados los mockups de excepciones (`GlobalExceptionHandler`, `ResourceNotFoundException`) en `ms-menu` y `ms-auth` para revisión.

### 2. Implementación de Manejo de Errores
- [x] Implementado `@RestControllerAdvice` y respuesta estandarizada en `ms-menu`.
- [x] Implementado `@RestControllerAdvice` y respuesta estandarizada en `ms-auth`.
- [x] Controladores y Servicios refactorizados para lanzar excepciones personalizadas.

### 3. Actualización de Documentación Final
- [x] Actualizar `diagramas.md` para incluir el flujo estandarizado de excepciones (respuestas de error HTTP).
- [x] Documentar en `diagramas.md` o crear archivo para la proyección de arquitectura basada en eventos (Kafka).
- [x] Revisión final para garantizar que no existan elementos diferidos entre el código real y la documentación.

---

## 🛠️ Fase 4: Lógica de Negocio Post-Integración (Controllers y Services)

### 1. Implementación de ms-auth (Módulo Usuarios)
- [x] Implementados los métodos CRUD y búsquedas complejas (por credencial y sucursal) en `UsuarioServiceImpl`.
- [x] Actualizado `UsuarioRepository` para utilizar la relación `@OneToOne` de JPA (`credencial.id`).
- [x] Actualizado `UsuarioMapper` para garantizar inmutabilidad de la credencial en métodos PUT.
- [x] `UsuarioController` mapeado 100% al Service, eliminando excepciones de scaffolding.

### 2. Implementación Restante de Microservicios
- [x] Sustituidas las excepciones de scaffolding en los controllers de `ms-carrito`, `ms-notificaciones` y `ms-reportes`.
- [x] Inyectados los servicios correspondientes (`@RequiredArgsConstructor`) devolviendo respuestas HTTP 200/201.
- [x] Preparadas las clases `ServiceImpl` de estos módulos con comentarios guía para la implementación manual del equipo.
