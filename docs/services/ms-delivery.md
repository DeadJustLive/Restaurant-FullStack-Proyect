# 🛵 Microservicio: Delivery (ms-delivery)

## 1. Propósito
Gestiona la logística de última milla. Se encarga de la asignación de repartidores y el seguimiento del pedido desde que sale del local hasta que llega a manos del cliente.

## 2. Responsabilidades Clave
*   Asignación de repartidores (ROLE_RP) a pedidos en estado "LISTO".
*   Seguimiento del ciclo de vida del despacho (ASIGNADO, EN_CAMINO, ENTREGADO).
*   Registro de incidencias durante la entrega.

## 3. Diccionario de Datos (Entidad: Delivery)
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. |
| `pedidoId` | `Long` | FK Lógica hacia `ms-pedidos`. |
| `repartidorId` | `Long` | FK Lógica hacia `ms-usuarios` (Repartidor asignado). |
| `direccionEntrega` | `String` | Punto de llegada capturado del pedido. |
| `estado` | `Enum` | BUSCANDO, ASIGNADO, EN_CAMINO, ENTREGADO. |
| `observaciones` | `String` | Notas del repartidor o del cliente. |

## 4. Endpoints Principales
*   `GET /api/v1/delivery/pendientes`: Ver pedidos esperando repartidor.
*   `PATCH /api/v1/delivery/{id}/asignar`: Vincular repartidor al pedido.
*   `PATCH /api/v1/delivery/{id}/estado`: Actualizar progreso del viaje.

## 5. Dependencias (Feign Clients)
*   `ms-usuarios`: Verificar identidad y disponibilidad del repartidor.
*   `ms-pedidos`: Informar la entrega final para cerrar el ciclo del pedido.
