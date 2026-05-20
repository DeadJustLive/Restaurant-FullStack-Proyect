# ✅ Plan de Fase 5: Integración de Apache Kafka (COMPLETADO)

> **Estado:** ✅ **COMPLETADO**
> La integración de Apache Kafka está implementada y en funcionamiento en todo el ecosistema.

## 1. Infraestructura
- [x] Kafka broker (Confluent 7.5.0) en `docker-compose.yml` — puerto `9092`
- [x] Modo KRaft (sin Zookeeper)
- [x] Configurado en todos los `application.yml` de los microservicios

## 2. Topics Implementados

| Topic | Producer | Consumers |
| :--- | :--- | :--- |
| `pedido-events` | `ms-pedidos` | `ms-pagos`, `ms-delivery`, `ms-reportes` |
| `sucursal-events` | `ms-sucursales` | `ms-menu`, `ms-pedidos`, `ms-carrito` |
| `menu-item-events` | `ms-menu` | `ms-carrito`, `ms-pedidos`, `ms-inventario` |
| `topico-usuarios` | `ms-auth` | `ms-pedidos`, `ms-carrito`, `ms-reportes` |
| `pago-procesado` | `ms-pagos` | `ms-pedidos`, `ms-reportes`, `ms-notificaciones` |
| `inventario-actualizado` | `ms-inventario` | `ms-menu`, `ms-notificaciones` |
| `delivery-asignado` | `ms-delivery` | `ms-pedidos`, `ms-notificaciones` |
| `notificacion-enviada` | `ms-notificaciones` | `ms-reportes` |

## 3. Patrón CQRS
Cada microservicio que necesita datos de otro dominio mantiene una **proyección local** (tabla separada) que se actualiza mediante los eventos Kafka. Esto evita llamadas Feign innecesarias y mejora la resiliencia.

## 4. Manejo de Errores
- `@RetryableTopic` para reintentos en consumidores
- Dead Letter Topics (DLT) para mensajes fallidos
- Logs estructurados con `@Slf4j` en cada listener
