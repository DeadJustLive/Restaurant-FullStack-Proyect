# Guion de Defensa Técnica — Microservicios Asignados

> **Servicios a presentar:** ms-auth · ms-sucursales · ms-menu · ms-carrito · ms-pedidos
> **Orden:** Introducción → Arquitectura → 5 servicios → Postman → Eureka → GitHub → Cierre

---

## 1. INTRODUCCIÓN (2 min)

### Qué decir

"Este sistema gestiona la operación completa de un restaurante: desde el registro de usuarios, pasando por la administración de sucursales y el catálogo del menú, hasta la creación del carrito y la transformación a pedidos formales con control de estado."

"Se eligió arquitectura de microservicios porque cada dominio tiene su propio ciclo de vida y reglas de negocio independientes. Esto permite escalar módulos por separado — por ejemplo, pedidos puede necesitar más instancias que sucursales."

"A mí me corresponde explicar cinco microservicios: **auth, sucursales, menú, carrito y pedidos**, que cubren el flujo principal de negocio."

### Qué mostrar en pantalla

- Mapa general del sistema (abrir `guia_arquitectura_academica.md` o dibujar)

---

## 2. ARQUITECTURA GENERAL (2 min) — Mostrar UNA SOLA VEZ

### Puntos clave a decir

| Concepto | Explicación breve |
|---|---|
| **Eureka** | Registro de servicios en `localhost:8761`. Cada microservicio se registra con `spring.application.name`. |
| **Database per Service** | Cada MS tiene su propia BD PostgreSQL (puerto 5433). Se referencian por ID lógico (`Long`), nunca FK entre BDs. |
| **Feign** | Comunicación síncrona. Interfaces `@FeignClient` que Eureka resuelve automáticamente. |
| **Kafka** | Comunicación asíncrona. Patrón CQRS: cada servicio publica eventos y otros los consumen para mantener proyecciones locales. |
| **Estructura CSR** | Controller → Service → Repository en todos los servicios. DTOs separados de entidades vía MapStruct. |

### Evidencia

- Abrir `Eureka dashboard: http://localhost:8761` y señalar los servicios registrados.

---

## 3. DESARROLLO POR MICROSERVICIO

---

### 3.1 ms-auth (Puerto 9001)

#### Frase guía
"Este microservicio se encarga de la autenticación y autorización centralizada del sistema."

#### Qué hace
- Login, registro, refresh token y logout.
- Validación de permisos por módulo y acción para los demás servicios.
- Gestión de usuarios con perfil completo.

#### Problema de negocio que resuelve
- Centraliza la seguridad. Sin auth, cualquier cliente podría ver o modificar datos de otros.

#### Parte técnica a mostrar

| Capa | Archivo | Qué señalar |
|---|---|---|
| **Config** | `application.yml` | Puerto 9001, BD `auth`, JWT secret y expiración (24h access / 7d refresh) |
| **Entity** | `UserCredential.java` | username único, password BCrypt, rol enum |
| **Entity** | `Usuario.java` | FK `credencial_id` OneToOne, datos de perfil, sucursalId lógico |
| **Enum** | `RolUsuario.java` | ROLE_SA, ROLE_AD, ROLE_CO, ROLE_RP, ROLE_ME, ROLE_CL |
| **Security** | `SecurityConfig.java` | `@EnableWebSecurity`, `SecurityFilterChain`, rutas públicas vs protegidas |
| **Security** | `JwtAuthFilter.java` | `OncePerRequestFilter`, extrae userId/username/rol del token |
| **Controller** | `AuthController.java` | `POST /register`, `POST /login`, `POST /refresh`, `GET /validar-acceso` |
| **Controller** | `UsuarioController.java` | CRUD completo + `GET /credencial/{id}` + `GET /sucursal/{id}` |
| **Service** | `AuthServiceImpl.java` | `login()`: busca username, verifica BCrypt, genera JWT + refresh |

#### Interacción importante con otros servicios

- **Expone** `GET /api/v1/auth/validar-acceso` que TODOS los demás servicios consumen vía Feign (`AuthFeignClient`).
- **Produce** a Kafka topic `topico-usuarios` con `AuthEventDTO` → consumido por ms-carrito para su proyección de clientes.

#### Evidencia a mostrar

1. `application.yml` del ms-auth con la config JWT.
2. `JwtAuthFilter.java` — el filtro que valida cada request.
3. Postman: `POST /api/v1/auth/login` → respuesta con token JWT.
4. Postman: `POST /api/v1/auth/register` → 201 con token y refresh.

---

### 3.2 ms-sucursales (Puerto 9003)

#### Frase guía
"Este microservicio administra la información operativa de cada sucursal del restaurante."

#### Qué hace
- CRUD de sucursales: crear, listar, actualizar, cambiar estado (activar/desactivar).
- Soft delete mediante flag `activa` (no borrado físico).

#### Problema de negocio que resuelve
- Referencia central de locales. Menú, carrito y pedidos dependen de saber qué sucursales existen y están activas.

#### Parte técnica a mostrar

| Capa | Archivo | Qué señalar |
|---|---|---|
| **Config** | `application.yml` | Puerto 9003, BD `sucursales` |
| **Entity** | `Sucursal.java` | id, nombre, direccion, telefono, activa (flag soft delete) |
| **Repository** | `SucursalRepository.java` | `findByActivaTrueOrderByNombreAsc()` |
| **Service** | `SucursalServiceImpl.java` | `crear()`: valida permiso via Feign a ms-auth (con fallback degradado), guarda, publica evento Kafka |
| **Controller** | `SucursalController.java` | `POST /`, `GET /{id}`, `GET /` (activas), `GET /todas`, `PUT /{id}`, `PATCH /{id}/estado` |
| **Mapper** | `SucursalMapper.java` | `toResponseDTO()`, `toEntity()`, `updateEntityFromDto()` |
| **Feign** | `AuthFeignClient.java` | `GET /api/v1/auth/validar-acceso` — valida permisos antes de escribir |

#### Interacción importante con otros servicios

- **Consume** ms-auth vía Feign para validar `ESCRITURA` en `SUCURSALES`.
- **Produce** a Kafka topic `sucursal-events` con `SucursalEventDTO` → consumido por ms-menu y ms-pedidos para proyecciones CQRS locales.

#### Evidencia a mostrar

1. `Sucursal.java` — entidad con flag `activa`.
2. `SucursalServiceImpl.java` — método `crear()` mostrando validación + Kafka.
3. Postman: `GET /api/v1/sucursales` → lista de sucursales activas.
4. Postman: `POST /api/v1/sucursales` → crear nueva sucursal, ver 201.

---

### 3.3 ms-menu (Puerto 9004)

#### Frase guía
"Este microservicio administra el catálogo del restaurante y la disponibilidad de los productos."

#### Qué hace
- CRUD de categorías y de ítems del menú.
- Control de disponibilidad por producto (flag `disponible`).
- Soft delete de ítems (flag `eliminado`).
- Asociación opcional de ítems a sucursal (`sucursalId` nulo = global).

#### Problema de negocio que resuelve
- Es el catálogo oficial. Carrito y pedidos dependen de estos datos para mostrar precios y validar disponibilidad.

#### Parte técnica a mostrar

| Capa | Archivo | Qué señalar |
|---|---|---|
| **Config** | `application.yml` | Puerto 9004, BD `menu` |
| **Entity** | `Categoria.java` | id, nombre (unique), descripcion, activa |
| **Entity** | `MenuItem.java` | id, nombre, precio, imagenUrl, disponible, sucursalId (lógico), eliminado (soft delete), `@ManyToOne` Categoria |
| **Repository** | `MenuItemRepository.java` | `findDisponiblesBySucursal()` — JPQL con `OR sucursalId IS NULL` |
| **Service** | `MenuItemServiceImpl.java` | `crear()`: valida duplicado, envía evento Kafka; `eliminar()`: soft delete (eliminado=true, disponible=false) |
| **Controller** | `MenuItemController.java` | `POST /`, `GET /{id}`, `GET /disponibles`, `PUT /{id}`, `PATCH /{id}/disponibilidad`, `DELETE /{id}` |
| **Controller** | `CategoriaController.java` | `POST /`, `GET /`, `GET /todas`, `PUT /{id}`, `PATCH /{id}/estado` |
| **Kafka Consumer** | `SucursalEventListener.java` | Escucha `sucursal-events`, actualiza proyección local `SucursalProyeccion` |
| **Kafka Producer** | `MenuItemServiceImpl.java` | Publica `menu-item-events` en cada create/update/delete |

#### Interacción importante con otros servicios

- **Consume** ms-auth vía Feign para validar permisos.
- **Consume** Kafka `sucursal-events` → mantiene tabla `proyeccion_sucursales` actualizada.
- **Produce** Kafka `menu-item-events` → consumido por ms-carrito y ms-pedidos para sus proyecciones.

#### Evidencia a mostrar

1. `MenuItem.java` — entidad con flags `disponible` y `eliminado`.
2. `MenuItemServiceImpl.java` — método `eliminar()` (soft delete).
3. Postman: `GET /api/v1/menu/disponibles` → lista de productos disponibles.
4. Postman: `POST /api/v1/menu` → crear un plato nuevo.

---

### 3.4 ms-carrito (Puerto 9006)

#### Frase guía
"Este microservicio concentra la selección temporal de productos antes de confirmar el pedido."

#### Qué hace
- Crear carrito por usuario + sucursal.
- Agregar, actualizar cantidad y eliminar ítems.
- Calcular subtotales y total automáticamente.
- Vaciar carrito completo.

#### Problema de negocio que resuelve
- Es la etapa previa al pedido. El cliente arma su selección, ve precios en tiempo real, y cuando confirma se transforma en un pedido formal en ms-pedidos.

#### Parte técnica a mostrar

| Capa | Archivo | Qué señalar |
|---|---|---|
| **Config** | `application.yml` | Puerto 9006, BD `carrito` |
| **Entity** | `Carrito.java` | id, usuarioId (FK lógico), sucursalId (FK lógico), total, `@OneToMany` items con cascade ALL + orphanRemoval |
| **Entity** | `CarritoItem.java` | id, menuItemId (FK lógico), precioUnitario, cantidad, subtotal |
| **Repository** | `CarritoRepository.java` | `findByUsuarioId()` — un usuario tiene un solo carrito activo |
| **Service** | `CarritoServiceImpl.java` | `agregarItem()`: resuelve precio desde proyección local CQRS, si ya existe incrementa cantidad, recalcula total |
| **Controller** | `CarritoController.java` | `GET /usuario/{id}`, `POST /`, `POST /usuario/{id}/items`, `PATCH /usuario/{id}/items/{itemId}`, `DELETE /usuario/{id}/items/{itemId}`, `DELETE /usuario/{id}` |
| **Proyección CQRS** | `MenuItemProyeccion.java` | Tabla `menu_proyeccion`: id, nombre_producto, precio_actual, disponible |
| **Kafka Consumer** | `MenuItemKafkaListener.java` | Escucha `menu-item-events` → actualiza `MenuItemProyeccion` |
| **Kafka Consumer** | `ClienteKafkaListener.java` | Escucha `topico-usuarios` → actualiza `ClienteProyeccion` |

#### Interacción importante con otros servicios

- **NO hace llamadas síncronas** a ms-menu para precios. Usa proyección local (`MenuItemProyeccion`) alimentada por Kafka desde `menu-item-events`. Esto evita latencia y acoplamiento.
- **Consume** `topico-usuarios` de ms-auth para tener datos del cliente localmente.

#### Evidencia a mostrar

1. `CarritoServiceImpl.java` — método `agregarItem()` mostrando cálculo de subtotal y uso de proyección local.
2. `MenuItemKafkaListener.java` — cómo se actualiza la proyección desde Kafka.
3. Postman: `POST /api/v1/carrito` → crear carrito.
4. Postman: `POST /api/v1/carrito/usuario/1/items` → agregar ítem, ver respuesta con total calculado.

---

### 3.5 ms-pedidos (Puerto 9007)

#### Frase guía
"Este microservicio transforma la selección del cliente en un pedido formal con control de estado."

#### Qué hace
- Crear pedido a partir de ítems seleccionados.
- Generar `numeroPedido` único (`PED-{timestamp}`).
- Tomar snapshot del nombre y precio al momento de la compra (inmutable).
- Máquina de estados con transiciones controladas.
- Cancelar pedidos (solo en estados PENDIENTE o CONFIRMADO).

#### Problema de negocio que resuelve
- Es el flujo más importante: convierte la intención de compra en un pedido trazable con ciclo de vida completo.

#### Parte técnica a mostrar

| Capa | Archivo | Qué señalar |
|---|---|---|
| **Config** | `application.yml` | Puerto 9007, BD `pedidos` |
| **Entity** | `Pedido.java` | id, numeroPedido (unique), usuarioId, sucursalId, estado (enum), tipo (DELIVERY/EN_LOCAL), total, `@OneToMany` items |
| **Entity** | `PedidoItem.java` | menuItemId, nombreSnapshot, precioUnitario, cantidad, subtotal — snapshot histórico inmutable |
| **Enum** | `EstadoPedido.java` | PENDIENTE → CONFIRMADO → EN_PREPARACION → LISTO → (EN_CAMINO|ENTREGADO) → ENTREGADO / CANCELADO |
| **Repository** | `PedidoRepository.java` | `findByIdWithItems()` JOIN FETCH, `findBySucursalIdAndEstadoNotIn()`, `findByRangoFechas()` |
| **Service** | `PedidoServiceImpl.java` | `crear()`: consulta ms-menu vía Feign por cada ítem (con fallback a proyección local), snapshot de nombre/precio, calcula total; `cambiarEstado()`: mapa `TRANSICIONES_VALIDAS` |
| **Controller** | `PedidoController.java` | `POST /`, `GET /{id}`, `GET /sucursal/{id}/activos`, `GET /cliente/{id}`, `PATCH /{id}/estado`, `PATCH /{id}/cancelar` |
| **Feign** | `MenuItemClient.java` | `GET /api/v1/menu/{id}` → obtiene nombre y precio del menú en tiempo real |
| **Kafka Producer** | `PedidoServiceImpl.java` | Publica `pedido-events` con `PedidoEventDTO` en cada create/state-change/cancel |
| **Kafka Consumer** | `MenuItemEventListener.java` | Escucha `menu-item-events` → actualiza `MenuItemProyeccion` local |
| **Kafka Consumer** | `SucursalEventListener.java` | Escucha `sucursal-events` → actualiza `SucursalProyeccion` local |

#### Interacción importante con otros servicios

- **Consume** ms-menu vía Feign para snapshot de nombre y precio (con fallback a proyección CQRS si Feign falla).
- **Consume** Kafka `menu-item-events` y `sucursal-events` para proyecciones locales.
- **Produce** Kafka `pedido-events` → consumido por ms-pagos, ms-delivery, ms-inventario, ms-notificaciones y ms-reportes.

#### Evidencia a mostrar

1. `EstadoPedido.java` — enum con 7 estados y sus transiciones.
2. `PedidoServiceImpl.java` — método `crear()` con consulta Feign + snapshot.
3. `PedidoServiceImpl.java` — `TRANSICIONES_VALIDAS` y `cambiarEstado()`.
4. Postman: `POST /api/v1/pedidos` → crear pedido con ítems, ver 201 con numeroPedido.
5. Postman: `PATCH /api/v1/pedidos/1/estado` → cambiar a CONFIRMADO, ver transición.

---

## 4. EVIDENCIA FINAL

### 4.1 Postman

Ejecutar en vivo:

| Orden | Endpoint | Mostrar |
|---|---|---|
| 1 | `POST /api/v1/auth/login` | Obtener token JWT |
| 2 | `GET /api/v1/sucursales` | Lista de sucursales activas |
| 3 | `GET /api/v1/menu/disponibles` | Catálogo de productos |
| 4 | `POST /api/v1/carrito` | Crear carrito para usuario |
| 5 | `POST /api/v1/carrito/usuario/1/items` | Agregar producto al carrito |
| 6 | `POST /api/v1/pedidos` | Crear pedido desde el JSON de ítems |
| 7 | `GET /api/v1/pedidos/1` | Ver pedido creado con estado PENDIENTE |
| 8 | `PATCH /api/v1/pedidos/1/estado` | Cambiar estado a CONFIRMADO |

### 4.2 Eureka

- Abrir `http://localhost:8761`.
- Señalar: ms-auth (9001), ms-sucursales (9003), ms-menu (9004), ms-carrito (9006), ms-pedidos (9007) — todos UP.

### 4.3 GitHub

- Mostrar repositorio.
- Mostrar commits personales.

### 4.4 DBeaver (opcional)

- Mostrar base de datos `pedidos`, tabla `pedidos` con el pedido recién creado.
- Mostrar `proyeccion_menu_items` en ms-pedidos alimentada por Kafka.

---

## 5. CIERRE (30 seg)

"Con estos cinco microservicios se cubre la parte principal del flujo del restaurante: autenticación, sucursales, menú, carrito y pedidos, mostrando tanto la lógica de negocio como la comunicación entre servicios y la validación del sistema en ejecución."

---

## RESUMEN RÁPIDO: QUÉ DECIR EN CADA SERVICIO

| # | Servicio | 15 seg: qué es | 15 seg: con quién habla | 30 seg: qué mostrar |
|---|---|---|---|---|
| 1 | **ms-auth** | Autenticación JWT centralizada, gestión de usuarios y permisos. | Expone endpoint de validación consumido por todos los demás. Publica eventos de usuario a Kafka. | `application.yml` con JWT, `JwtAuthFilter`, Postman login. |
| 2 | **ms-sucursales** | CRUD de sucursales con soft delete por flag `activa`. | Valida permisos contra ms-auth vía Feign. Publica `sucursal-events` a Kafka. | Entidad `Sucursal`, Service con validación y Kafka, Postman GET. |
| 3 | **ms-menu** | Catálogo de categorías y productos con control de disponibilidad y soft delete. | Valida auth vía Feign. Consume `sucursal-events`. Publica `menu-item-events`. | `MenuItem` con flags, soft delete, Postman POST/GET. |
| 4 | **ms-carrito** | Carrito temporal del cliente con cálculo automático de totales. | Sin llamadas síncronas al menú. Usa proyección CQRS local alimentada por Kafka. | `agregarItem()` con proyección local, Postman flujo completo. |
| 5 | **ms-pedidos** | Transformación del carrito en pedido formal con máquina de estados y snapshot histórico. | Consulta ms-menu vía Feign (con fallback). Consume y publica eventos Kafka. | `EstadoPedido`, `crear()` con snapshot, Postman cambio de estado. |

---

## ORDEN DE GRABACIÓN RECOMENDADO

1. Introducción (lo que dijiste al inicio de este documento).
2. Arquitectura general (mostrar Eureka una vez, mencionar Kafka/Feign una vez).
3. **ms-auth**: application.yml → JwtAuthFilter → AuthController → Postman login.
4. **ms-sucursales**: Entity → Service → Controller → Postman GET/POST.
5. **ms-menu**: Entity MenuItem → Service soft delete → Controller → Postman.
6. **ms-carrito**: Entity → Service agregarItem con proyección → Controller → Postman.
7. **ms-pedidos**: Enum estados → Service crear + cambiarEstado → Controller → Postman.
8. Postman (colección completa de 8 requests).
9. Eureka dashboard.
10. GitHub + commits.
11. Cierre.
