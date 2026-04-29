# 🔔 Microservicio: Notificaciones (ms-notificaciones)

## 1. Propósito
Actúa como el motor de mensajería del ecosistema. Desacopla la lógica de envío de alertas (Emails, SMS, Push) del resto de los microservicios, centralizando el historial y las plantillas.

## 2. Responsabilidades Clave
*   Envío de alertas asíncronas y síncronas.
*   Gestión de historial de notificaciones (Enviado/Fallido).
*   Integración con proveedores de mensajería (Simulados).

## 3. Diccionario de Datos (Entidad: Notificacion)
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. |
| `destinatario` | `String` | Email, teléfono o Token del dispositivo. |
| `tipo` | `Enum` | EMAIL, SMS, PUSH. |
| `asunto` | `String` | Título del mensaje. |
| `cuerpo` | `String` | Contenido detallado. |
| `estado` | `Enum` | PENDIENTE, ENVIADO, FALLIDO. |

## 4. Endpoints Principales
*   `POST /api/v1/notificaciones/enviar`: Solicitar envío de alerta.
*   `GET /api/v1/notificaciones/historial/{destinatario}`: Consultar logs de un usuario.

## 5. Escenarios de Uso
*   **ms-pagos**: Envío de comprobante de pago.
*   **ms-delivery**: Aviso de "Pedido en camino".
*   **ms-inventario**: Alerta de stock crítico a administradores.
