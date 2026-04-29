# 📦 ms-pedidos — Microservicio de Pedidos

> **Puerto:** `9007` · **BD:** PostgreSQL `pedidos` · **Registro:** Eureka Client  
> **Paquete raíz:** `cl.triskeledu.pedidos`

---

## 🎯 Responsabilidad del Servicio

El microservicio `ms-pedidos` es el **núcleo transaccional** de la plataforma.
Gestiona el ciclo de vida completo de un pedido desde su creación (checkout del carrito)
hasta su entrega final, coordinando con otros servicios mediante OpenFeign.

### Límites del Dominio (Bounded Context)

- ✅ **Responsabilidad:** Crear, leer, actualizar estado y cancelar pedidos.
- ✅ **Responsabilidad:** Mantener el detalle de ítems ordenados con precio histórico.
- ❌ **No responsabilidad:** Gestionar stock (delegado a `ms-inventario`).
- ❌ **No responsabilidad:** Procesar el pago (delegado a `ms-pagos`).
- ❌ **No responsabilidad:** Asignar repartidor (delegado a `ms-delivery`).

---

## 🔄 Ciclo de Vida del Pedido (State Machine)

```
PENDIENTE
    │
    ▼ (confirmación de pago desde ms-pagos)
CONFIRMADO
    │
    ▼ (cocinero actualiza estado)
EN_PREPARACION
    │
    ▼ (cocinero marca como listo)
LISTO
    │
    ▼ (delivery recoge el pedido)
EN_CAMINO         ← Solo para tipo DELIVERY
    │
    ▼ (repartidor confirma entrega)
ENTREGADO
    │
    ○ (estado terminal — no modificable)

CANCELADO  ← Accesible desde PENDIENTE o CONFIRMADO únicamente
```

---

## 🗄️ Diccionario de Datos

### Tabla: `pedidos`

| Campo              | Tipo SQL             | Tipo Java          | Nullable | Descripción                                                   | Riesgo de modificación                                           |
|--------------------|----------------------|--------------------|----------|---------------------------------------------------------------|------------------------------------------------------------------|
| `id`               | `BIGSERIAL`          | `Long`             | NO       | PK autoincremental. Identificador único del pedido.           | **CRÍTICO:** Nunca reasignar. Referenciado por pagos y delivery. |
| `numero_pedido`    | `VARCHAR(20)`        | `String`           | NO       | Código legible (ej: `PED-20240425-0001`). Único y auditable.  | **ALTO:** Cambiar formato rompe reportes y notificaciones.       |
| `usuario_id`       | `BIGINT`             | `Long`             | NO       | FK lógica al usuario en `ms-usuarios`. Sin FK física en BD.   | **ALTO:** Modificar sin validar con ms-usuarios rompe integridad.|
| `sucursal_id`      | `BIGINT`             | `Long`             | NO       | FK lógica a la sucursal destino del pedido.                   | **MEDIO:** Cambiar en pedido activo puede confundir a cocina.    |
| `estado`           | `VARCHAR(20)`        | `EstadoPedido`     | NO       | Enum del estado actual (ver State Machine arriba).            | **CRÍTICO:** Solo la máquina de estados puede modificarlo.       |
| `tipo`             | `VARCHAR(15)`        | `TipoPedido`       | NO       | `DELIVERY` o `EN_LOCAL`. Define si aplica ms-delivery.        | **ALTO:** No modificar en pedido ya creado.                      |
| `total`            | `DECIMAL(10,2)`      | `BigDecimal`       | NO       | Suma de subtotales de los ítems. Calculado en el service.     | **CRÍTICO:** Nunca modificar manualmente. Recalcular siempre.    |
| `notas`            | `TEXT`               | `String`           | SÍ       | Instrucciones especiales del cliente (alergias, etc).         | **BAJO:** Campo libre. Validar longitud máxima.                  |
| `creado_en`        | `TIMESTAMP`          | `LocalDateTime`    | NO       | Fecha de creación. Gestionado por `@CreationTimestamp`.       | **CRÍTICO:** Inmutable. No exponer en endpoints de actualización.|
| `actualizado_en`   | `TIMESTAMP`          | `LocalDateTime`    | NO       | Última modificación. Gestionado por `@UpdateTimestamp`.       | **BAJO:** Automático. No modificar manualmente.                  |

### Tabla: `pedido_items`

| Campo              | Tipo SQL             | Tipo Java          | Nullable | Descripción                                                   | Riesgo de modificación                                           |
|--------------------|----------------------|--------------------|----------|---------------------------------------------------------------|------------------------------------------------------------------|
| `id`               | `BIGSERIAL`          | `Long`             | NO       | PK del ítem.                                                  | **CRÍTICO:** No reasignar.                                       |
| `pedido_id`        | `BIGINT`             | `Long`             | NO       | FK a la tabla `pedidos`. Relación `@ManyToOne`.               | **CRÍTICO:** Cambiar asocia el ítem a un pedido incorrecto.      |
| `menu_item_id`     | `BIGINT`             | `Long`             | NO       | ID del producto en `ms-menu`. FK lógica (sin FK física).      | **ALTO:** El ítem existe como snapshot; ms-menu puede cambiar.   |
| `nombre_snapshot`  | `VARCHAR(100)`       | `String`           | NO       | Nombre del producto **al momento de la compra** (snapshot).   | **BAJO:** Registro histórico. No sincronizar con ms-menu.        |
| `precio_unitario`  | `DECIMAL(10,2)`      | `BigDecimal`       | NO       | Precio **al momento de la compra** (snapshot).                | **CRÍTICO:** Precio histórico. Nunca actualizar con precio actual.|
| `cantidad`         | `INT`                | `Integer`          | NO       | Cantidad de unidades ordenadas. Mínimo 1.                     | **ALTO:** Cambiar implica recalcular `subtotal` y `total`.       |
| `subtotal`         | `DECIMAL(10,2)`      | `BigDecimal`       | NO       | `precio_unitario * cantidad`. Calculado por el service.       | **CRÍTICO:** Derivado. Solo se calcula, nunca se recibe del cliente.|

---

## 🔁 Flujo Técnico Interno

```
HTTP Request (JSON)
        │
        ▼
┌───────────────────┐
│   PedidoController│  Valida @Valid, extrae parámetros de path/query
│   /api/v1/pedidos │  Llama al Service con el DTO de request
└────────┬──────────┘
         │ PedidoRequestDTO
         ▼
┌───────────────────┐
│   PedidoService   │  1. Valida reglas de negocio
│   (interface)     │  2. Llama clientes Feign (ms-menu, ms-inventario)
│                   │  3. Calcula totales
│   PedidoServiceImpl│ 4. Mapea DTO → Entity con PedidoMapper
└────────┬──────────┘  5. Persiste con Repository
         │ Pedido (entity)
         ▼
┌───────────────────┐
│  PedidoRepository │  JpaRepository<Pedido, Long>
│  (Spring Data JPA)│  Queries custom con @Query JPQL
└────────┬──────────┘
         │
         ▼
  PostgreSQL DB: pedidos
         │
         ▼
┌───────────────────┐
│  PedidoMapper     │  Entity → PedidoResponseDTO (MapStruct)
└────────┬──────────┘
         │ PedidoResponseDTO
         ▼
HTTP Response (JSON) → Cliente
```

### Dependencias con Otros Microservicios

| Servicio destino  | Cliente Feign         | Propósito                                           | Tipo       |
|-------------------|-----------------------|-----------------------------------------------------|------------|
| `ms-menu`         | `MenuItemClient`      | Obtener precio y nombre del ítem al crear pedido    | Síncrono   |
| `ms-inventario`   | `InventarioClient`    | Validar y descontar stock al confirmar pedido       | Síncrono   |
| `ms-pagos`        | `PagoClient`          | Notificar monto a cobrar y recibir confirmación     | Síncrono   |
| `ms-delivery`     | `DeliveryClient`      | Solicitar asignación de repartidor (solo DELIVERY)  | Síncrono   |
| `ms-notificaciones`| `NotificacionClient` | Notificar cambios de estado al usuario              | Futuro Async|

---

## 📁 Estructura de Paquetes

```
cl.triskeledu.pedidos/
├── RestaurantPedidosApplication.java
├── controller/
│   └── PedidoController.java
├── service/
│   ├── PedidoService.java          (interface)
│   └── impl/
│       └── PedidoServiceImpl.java
├── repository/
│   ├── PedidoRepository.java
│   └── PedidoItemRepository.java
├── entity/
│   ├── Pedido.java
│   ├── PedidoItem.java
│   └── enums/
│       ├── EstadoPedido.java
│       └── TipoPedido.java
├── dto/
│   ├── request/
│   │   ├── PedidoRequestDTO.java
│   │   └── PedidoItemRequestDTO.java
│   └── response/
│       ├── PedidoResponseDTO.java
│       └── PedidoItemResponseDTO.java
├── mapper/
│   └── PedidoMapper.java
├── client/
│   ├── MenuItemClient.java
│   ├── InventarioClient.java
│   ├── PagoClient.java
│   └── DeliveryClient.java
└── exception/
    ├── PedidoNotFoundException.java
    ├── EstadoInvalidoException.java
    └── GlobalExceptionHandler.java
```

---

## 🧪 Endpoints Disponibles

| Método | Path                              | Rol Requerido          | Descripción                               |
|--------|-----------------------------------|------------------------|-------------------------------------------|
| POST   | `/api/v1/pedidos`                 | ROLE_CL, ROLE_AD       | Crear nuevo pedido desde checkout         |
| GET    | `/api/v1/pedidos/{id}`            | ROLE_CL, ROLE_AD, ROLE_CO | Obtener pedido por ID                  |
| GET    | `/api/v1/pedidos/usuario/{uid}`   | ROLE_CL, ROLE_AD       | Historial de pedidos de un usuario        |
| GET    | `/api/v1/pedidos/sucursal/{sid}`  | ROLE_CO, ROLE_AD       | Cola de pedidos de una sucursal           |
| PATCH  | `/api/v1/pedidos/{id}/estado`     | ROLE_CO, ROLE_AD, ROLE_RP | Cambiar estado (máquina de estados)   |
| DELETE | `/api/v1/pedidos/{id}/cancelar`   | ROLE_CL, ROLE_AD       | Cancelar pedido (solo desde PENDIENTE)    |
