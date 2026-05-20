# 🛒 Microservicio: Pedidos (ms-pedidos)

> [!IMPORTANT]
> **Estado de Implementación:** ✅ **IMPLEMENTADO** (100% funcional con lógica de negocio completa)
> Incluye gestión de mesas (`Mesa` entity), creación de pedidos con items, cambios de estado, y proyecciones CQRS vía Kafka.

## 1. Propósito
Es el **Núcleo Orquestador** del negocio. Gestiona el ciclo de vida completo de una orden desde que el cliente confirma el carrito hasta que el pedido es entregado.

## 2. Responsabilidades Clave
*   Creación y persistencia de órdenes de compra con items.
*   Cálculo de totales y validación de reglas de negocio.
*   Gestión de estados del pedido (`PENDIENTE`, `PAGADO`, `EN_PREPARACION`, `LISTO`, `EN_CAMINO`, `ENTREGADO`, `CANCELADO`).
*   Gestión de mesas (`Mesa` entity con estados `DISPONIBLE`, `OCUPADA`, `RESERVADA`).
*   Producción de eventos Kafka (`pedido-events`) para consumidores downstream.
*   Consumo de eventos de `menu-item-events` y eventos de auth para proyecciones locales.

## 3. Diccionario de Datos

### Pedido
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. |
| `clienteId` | `Long` | FK lógica al usuario. |
| `sucursalId` | `Long` | FK lógica a ms-sucursales. |
| `total` | `BigDecimal` | Sumatoria de ítems. |
| `estado` | `Enum` | Estado actual del ciclo de vida. |
| `items` | `List<PedidoItem>` | Detalle de productos comprados. |
| `creadoEn` | `LocalDateTime` | Timestamp de creación. |

### Mesa
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. |
| `numeroMesa` | `Integer` | Número identificador de la mesa. |
| `capacidad` | `Integer` | Cantidad de comensales. |
| `estado` | `Enum` | DISPONIBLE, OCUPADA, RESERVADA. |
| `sucursalId` | `Long` | FK lógica a ms-sucursales. |
| `activa` | `Boolean` | Soft delete. |

## 4. Endpoints
*   `GET /api/v1/pedidos` — Listar todos los pedidos
*   `GET /api/v1/pedidos/{id}` — Obtener pedido por ID
*   `POST /api/v1/pedidos` — Crear pedido desde carrito
*   `PATCH /api/v1/pedidos/{id}/estado` — Cambiar estado del pedido
*   `GET /api/v1/pedidos/mesas` — Listar todas las mesas
*   `GET /api/v1/pedidos/mesas/disponibles` — Mesas disponibles

## 5. Kafka
*   **Consumer:** `menu-item-events` (proyección de items), `topico-usuarios` (proyección de clientes)
*   **Producer:** `pedido-events` (cuando cambia el estado de un pedido)

## 6. Dependencias
*   `ms-menu` (Feign): Validación de items del menú
*   `ms-inventario` (Feign): Validación de stock
*   `Eureka`: Registro y descubrimiento
