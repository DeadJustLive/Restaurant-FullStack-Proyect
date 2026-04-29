# 🛒 Microservicio: Pedidos (ms-pedidos)

## 1. Propósito
Es el **Núcleo Orquestador** del negocio. Gestiona el ciclo de vida completo de una orden desde que el cliente confirma el carrito hasta que el pedido es entregado.

## 2. Responsabilidades Clave
*   Creación y persistencia de órdenes de compra.
*   Cálculo de totales y validación de reglas de negocio.
*   Orquestación de llamadas a pagos, inventario y delivery.
*   Gestión de estados del pedido (`PENDIENTE`, `PAGADO`, `EN_PREPARACION`, `LISTO`, `EN_CAMINO`, `ENTREGADO`).

## 3. Diccionario de Datos (Entidad: Pedido)
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. |
| `clienteId` | `Long` | ID del usuario que realiza el pedido. |
| `total` | `BigDecimal` | Sumatoria de ítems + impuestos. |
| `estado` | `Enum` | Estado actual del ciclo de vida. |
| `items` | `List<PedidoItem>` | Detalle de productos comprados. |

## 4. Endpoints Principales
*   `POST /api/v1/pedidos/checkout`: Convierte un carrito en pedido.
*   `GET /api/v1/pedidos/mis-pedidos`: Historial para el cliente.
*   `PATCH /api/v1/pedidos/{id}/estado`: Cambio de fase (Cocinero/Repartidor).

## 5. Orquestación (Interacciones)
Al crear un pedido, este servicio interactúa con:
1.  **ms-menu:** Valida precios actuales.
2.  **ms-inventario:** Reserva el stock físico.
3.  **ms-pagos:** Inicia el flujo de cobro.
4.  **ms-notificaciones:** Envía confirmación al cliente.
