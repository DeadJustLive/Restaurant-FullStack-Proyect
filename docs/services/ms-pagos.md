# 💳 Microservicio: Pagos (ms-pagos)

## Propósito
Procesar las transacciones financieras y gestionar los comprobantes de pago (Boletas/Facturas).

> [!NOTE]
> **Estado de Implementación:** 🟢 **IMPLEMENTADO**
> - CRUD completo de pagos con persistencia en PostgreSQL.
> - Máquina de estados (`PENDIENTE → APROBADO/RECHAZADO`, `APROBADO → REEMBOLSADO`) con validación estricta.
> - Kafka Producer: publica eventos a `pago-events` en cada cambio de estado.
> - Kafka Consumer: `PedidoEventListener` consume `pedido-events` y almacena proyección local.
> - Feign: `AuthFeignClient` para validación de permisos (con fallback degradado si ms-auth no responde).
> - Mock "Happy Path": los pagos se marcan como APROBADOS sin pasarela real.

## Limitaciones Actuales
- **Pasarela de pago real pendiente:** No hay integración con Webpay, Stripe ni Transbank.
- **No hay webhook:** No existe endpoint para callbacks de pasarela externa.
- **Sin facturación electrónica:** No genera boletas ni facturas tributarias.

## Dependencias Reales
- `ms-pedidos`: Origen de la obligación de pago.
- `ms-auth`: Validación de JWT y permisos vía Feign.
