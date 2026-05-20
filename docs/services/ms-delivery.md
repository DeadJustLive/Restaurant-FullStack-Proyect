# 🚚 Microservicio: Delivery (ms-delivery)

## Propósito
Gestionar la logística de última milla, asignación de repartidores y seguimiento en tiempo real del despacho.

> [!NOTE]
> **Estado de Implementación:** 🟢 **IMPLEMENTADO**
> - CRUD completo de deliveries con persistencia en PostgreSQL.
> - Máquina de estados (`BUSCANDO_REPARTIDOR → ASIGNADO/CANCELADO`, `ASIGNADO → EN_CAMINO/CANCELADO`, `EN_CAMINO → ENTREGADO/CANCELADO`) con validación estricta.
> - Kafka Producer: publica eventos a `delivery-events` en cada cambio de estado.
> - Kafka Consumer: `PedidoEventListener` consume `pedido-events`, almacena proyecciones locales de Pedido, Cliente y Sucursal.
> - Feign: `AuthFeignClient` para validación de permisos (con fallback degradado).
> - Filtro de deliveries activos (no terminales).

## Limitaciones Actuales
- **Sin geolocalización en tiempo real:** No hay integración con Google Maps ni tracking GPS.
- **Asignación manual:** El `repartidorId` se asigna manualmente (no hay algoritmo automático de asignación).
- **Sin app móvil:** No existe cliente para repartidores.

## Dependencias Reales
- `ms-pedidos`: Recibe pedidos listos para despacho.
- `ms-auth`: Validación de JWT y permisos vía Feign.
