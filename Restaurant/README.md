# 🚀 Estado de Microservicios (Backend)

Este documento detalla la taxonomía de progreso de cada componente del backend.

| Microservicio | Puerto | DB | Estado | Implementación |
| :--- | :--- | :--- | :--- | :--- |
| **ms-auth** | 9001 | `auth` | **Implementado** | Lógica real, BCrypt, Auth Filter, Integra Usuarios. |
| **ms-sucursales** | 9003 | `sucur` | **Scaffolding** | Base estructurada con AuthFeignClient. |
| **ms-menu** | 9004 | `menu` | **Implementado** | Integra Categorías. CRUD completo. |
| **ms-carrito**| 9006 | `carrito` | **Scaffolding** | Base estructurada con AuthFeignClient. |
| **ms-inventario** | 9010 | `inv` | **Implementado** | Movimientos y stock funcionales. |
| **ms-pedidos** | 9007 | `ped` | **Implementado** | Base estructurada funcional. |
| **ms-pagos** | 9008 | `pagos` | **Scaffolding** | Base estructurada con AuthFeignClient. |
| **ms-delivery** | 9009 | `del` | **Scaffolding** | Base estructurada con AuthFeignClient. |
| **ms-notificaciones**| 9011 | `notif` | **Scaffolding** | Base estructurada con AuthFeignClient. |
| **ms-reportes** | 9012 | `rep` | **Scaffolding** | Base estructurada con AuthFeignClient. |

---

## 🛠️ Definición de Estados

- **Implementado:** Lógica de negocio completa en `Service`, validaciones Jakarta, manejo de excepciones de dominio y persistencia real probada. Sin mocks.
- **Parcialmente implementado:** El código tiene lógica funcional pero faltan integraciones externas (Feign) o flujos secundarios.
- **Scaffolding:** Estructura de carpetas, interfaces y Endpoints (HTTP 200/201) creados. Las excepciones 500 fueron removidas, dejando comentarios `TODO` y validación de seguridad Feign listos para la implementación del desarrollador.
