# 🍔 ms-menu — Microservicio de Menú

> **Puerto:** `9004` · **BD:** PostgreSQL `menu` · **Registro:** Eureka Client  
> **Paquete raíz:** `cl.triskeledu.menu`

---

## 🎯 Responsabilidad del Servicio

El microservicio `ms-menu` administra el **catálogo de productos** disponibles para la venta.
Es consumido por `ms-pedidos` (para obtener precio y nombre al crear pedidos)
y por `ms-inventario` (para asociar stock a cada producto).

### Límites del Dominio (Bounded Context)

- ✅ **Responsabilidad:** CRUD completo de ítems del menú (MenuItem).
- ✅ **Responsabilidad:** Filtrar ítems por categoría, sucursal y disponibilidad.
- ✅ **Responsabilidad:** Exponer endpoint de consulta individual (GET /id) para que ms-pedidos capture el snapshot de precio.
- ❌ **No responsabilidad:** Gestionar stock físico (delegado a `ms-inventario`).
- ❌ **No responsabilidad:** Gestionar categorías (delegado a `ms-categorias`).
- ❌ **No responsabilidad:** Gestionar precios dinámicos o promociones (futuro: ms-promociones).

---

## 🗄️ Diccionario de Datos

### Tabla: `menu_items`

| Campo           | Tipo SQL         | Tipo Java       | Nullable | Descripción                                                              | Riesgo de modificación                                                   |
|-----------------|------------------|-----------------|----------|--------------------------------------------------------------------------|--------------------------------------------------------------------------|
| `id`            | `BIGSERIAL`      | `Long`          | NO       | PK autoincremental. Identificador único del ítem.                        | **CRÍTICO:** Referenciado en `pedido_items.menu_item_id` como FK lógica. Si se reasigna, los snapshots históricos de pedidos quedan inconsistentes. |
| `nombre`        | `VARCHAR(100)`   | `String`        | NO       | Nombre comercial del producto (ej: "Hamburguesa Clásica").               | **ALTO:** Cambiar el nombre NO afecta pedidos históricos (tienen snapshot), pero sí afecta la búsqueda actual en el frontend. |
| `descripcion`   | `TEXT`           | `String`        | SÍ       | Descripción detallada. Ingredientes, alérgenos, preparación.             | **BAJO:** Campo informativo. Cambiar no afecta transacciones. |
| `precio`        | `DECIMAL(10,2)`  | `BigDecimal`    | NO       | Precio de venta actual. Es el valor que ms-pedidos captura como snapshot.| **CRÍTICO:** Cambiar el precio SOLO afecta pedidos futuros. Pedidos pasados conservan su snapshot. No aplicar cambio de precio retroactivo. |
| `imagen_url`    | `VARCHAR(500)`   | `String`        | SÍ       | URL de la imagen del producto. Servida desde almacenamiento externo (CDN).| **BAJO:** Cambiar la URL invalida la imagen en el frontend pero no afecta transacciones. |
| `disponible`    | `BOOLEAN`        | `Boolean`       | NO       | Flag de disponibilidad del ítem para la venta activa.                    | **ALTO:** Si se pone en `false`, el ítem NO debe aparecer en el menú del cliente ni aceptarse en nuevos pedidos. El Service debe validar este campo. |
| `categoria_id`  | `BIGINT`         | `Long`          | NO       | FK lógica a la categoría en `ms-categorias`. Sin FK física en BD.        | **MEDIO:** Si la categoría es eliminada en ms-categorias, el ítem queda sin categoría válida. TODO: Validar al crear/actualizar. |
| `sucursal_id`   | `BIGINT`         | `Long`          | SÍ       | FK lógica a la sucursal en `ms-sucursales`. NULL = ítem global (aplica a todas). | **MEDIO:** Un ítem global (null) es visible en todas las sucursales. Un ítem con sucursal específica solo se muestra en esa. |
| `creado_en`     | `TIMESTAMP`      | `LocalDateTime` | NO       | Marca de creación. Gestionada por `@CreationTimestamp`. Inmutable.       | **CRÍTICO:** No exponer en endpoints de actualización. Auditoría. |
| `actualizado_en`| `TIMESTAMP`      | `LocalDateTime` | NO       | Última modificación. Actualizada automáticamente por `@UpdateTimestamp`. | **BAJO:** Automático. No modificar manualmente. |

---

## 🔁 Flujo Técnico Interno

```
HTTP Request (JSON)
        │
        ▼
┌──────────────────────┐
│  MenuItemController  │  Valida @Valid, extrae path/query params
│  /api/v1/menu        │  Delega al Service con DTO de request
└────────┬─────────────┘
         │ MenuItemRequestDTO
         ▼
┌──────────────────────┐
│  MenuItemService     │  1. Valida reglas de negocio (disponible, precio > 0)
│  (interface)         │  2. Verifica categoría en ms-categorias (CategoriaClient)
│                      │  3. Verifica sucursal en ms-sucursales si sucursalId != null
│  MenuItemServiceImpl │  4. Mapea DTO → Entity con MenuItemMapper
└────────┬─────────────┘  5. Persiste con Repository
         │ MenuItem (entity)
         ▼
┌──────────────────────┐
│  MenuItemRepository  │  JpaRepository<MenuItem, Long>
│  (Spring Data JPA)   │  Queries: por categoría, sucursal, disponibilidad
└────────┬─────────────┘
         │
         ▼
  PostgreSQL DB: menu
         │
         ▼
┌──────────────────────┐
│  MenuItemMapper      │  Entity → MenuItemResponseDTO (MapStruct)
└────────┬─────────────┘
         │ MenuItemResponseDTO
         ▼
HTTP Response (JSON) → Cliente / ms-pedidos (Feign)
```

### Dependencias con Otros Microservicios

| Servicio destino  | Cliente Feign         | Propósito                                              | Tipo     |
|-------------------|-----------------------|--------------------------------------------------------|----------|
| `ms-categorias`   | `CategoriaClient`     | Validar que la categoría existe al crear/actualizar    | Síncrono |
| `ms-sucursales`   | `SucursalClient`      | Validar que la sucursal está activa si `sucursalId != null` | Síncrono |
| `ms-inventario`   | *(consumidor)*        | ms-inventario llama a ms-menu para obtener nombre del producto en alertas | —      |

### Consumidores de este Microservicio

| Microservicio | Endpoint consumido         | Propósito                            |
|---------------|----------------------------|--------------------------------------|
| `ms-pedidos`  | `GET /api/v1/menu/{id}`    | Obtener precio y nombre para snapshot|
| `ms-carrito`  | `GET /api/v1/menu/{id}`    | Validar que el ítem existe y precio  |
| `ms-inventario` | `GET /api/v1/menu`       | Sincronizar lista de productos       |

---

## 📁 Estructura de Paquetes

```
cl.triskeledu.menu/
├── RestaurantMenuApplication.java
├── controller/
│   └── MenuItemController.java
├── service/
│   ├── MenuItemService.java          (interface)
│   └── impl/
│       └── MenuItemServiceImpl.java
├── repository/
│   └── MenuItemRepository.java
├── entity/
│   └── MenuItem.java
├── dto/
│   ├── request/
│   │   └── MenuItemRequestDTO.java
│   └── response/
│       └── MenuItemResponseDTO.java
├── mapper/
│   └── MenuItemMapper.java
├── client/
│   ├── CategoriaClient.java
│   └── SucursalClient.java
└── exception/
    ├── MenuItemNotFoundException.java
    ├── ItemNoDisponibleException.java
    └── GlobalExceptionHandler.java
```

---

## 🧪 Endpoints Disponibles

| Método | Path                               | Rol Requerido              | Descripción                                          |
|--------|------------------------------------|----------------------------|------------------------------------------------------|
| GET    | `/api/v1/menu`                     | ROLE_CL, ROLE_CO, ROLE_AD  | Listar todos los ítems disponibles                   |
| GET    | `/api/v1/menu/{id}`                | Todos (incluye Feign)      | Obtener ítem por ID — usado por ms-pedidos y ms-carrito |
| GET    | `/api/v1/menu/categoria/{catId}`   | ROLE_CL, ROLE_AD           | Listar ítems de una categoría específica             |
| GET    | `/api/v1/menu/sucursal/{sucId}`    | ROLE_CL, ROLE_CO, ROLE_AD  | Listar ítems disponibles en una sucursal             |
| POST   | `/api/v1/menu`                     | ROLE_AD, ROLE_SA           | Crear nuevo ítem del menú                            |
| PUT    | `/api/v1/menu/{id}`                | ROLE_AD, ROLE_SA           | Actualizar ítem (nombre, descripción, precio, imagen)|
| PATCH  | `/api/v1/menu/{id}/disponibilidad` | ROLE_AD, ROLE_SA           | Cambiar flag disponible (true/false)                 |
| DELETE | `/api/v1/menu/{id}`                | ROLE_SA                    | Eliminar ítem (soft delete recomendado)              |
