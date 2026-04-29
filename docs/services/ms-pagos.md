# 💳 Microservicio: Pagos (ms-pagos)

## 1. Propósito
Orquesta las transacciones financieras del sistema. Actúa como mediador entre los pedidos y las pasarelas de pago, asegurando la integridad del flujo monetario.

## 2. Responsabilidades Clave
*   Procesamiento de pagos (Simulación de pasarelas).
*   Gestión de estados transaccionales (PENDIENTE, APROBADO, RECHAZADO).
*   Notificación de éxito de pago a `ms-pedidos` para activar la preparación.

## 3. Diccionario de Datos (Entidad: Pago)
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. |
| `pedidoId` | `Long` | FK Lógica hacia `ms-pedidos`. |
| `monto` | `BigDecimal` | Valor total de la transacción. |
| `metodo` | `Enum` | EFECTIVO, TARJETA, etc. |
| `estado` | `Enum` | Estado de la transacción. |
| `transaccionId` | `String` | Código de autorización externo. |

## 4. Endpoints Principales
*   `POST /api/v1/pagos`: Iniciar proceso de pago.
*   `GET /api/v1/pagos/pedido/{pedidoId}`: Consultar historial de intentos.
*   `POST /api/v1/pagos/confirmar`: Webhook para confirmación externa.

## 5. Dependencias (Feign Clients)
*   `ms-pedidos`: Notificar cambio de estado tras el pago exitoso.
