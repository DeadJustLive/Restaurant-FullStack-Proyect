# 🗄️ Diccionario de Datos y Relaciones Inter-Servicio

## 1. Principio de Identidad
El sistema sigue el principio de **Database per Service**. Las relaciones entre microservicios son lógicas y basadas en **IDs Long**, nunca con relaciones JPA cross-service.

## 2. Relación Crítica: Auth ↔ Usuarios

### Implementación Actual
La vinculación entre autenticación y perfiles de usuario es por **`credencialId`** (FK lógica).

- **Vínculo:** `credencialId` (Long) — almacenado en la entidad `Usuario` dentro de `ms-auth`
- **Flujo:**
    1. `ms-auth` crea la credencial (email + password hasheado) y devuelve el ID.
    2. Se crea el perfil `Usuario` con ese `credencialId` como referencia.
    3. El `AuthFeignClient` de otros servicios recibe `X-Credencial-Id` en los headers.

> [!NOTE]
> Esta separación permite cambiar el email o username del usuario sin romper la integridad de sus perfiles, pedidos o historial.

## 3. Relaciones en el Dominio de Ventas

| De (Servicio) | A (Servicio) | Atributo de Vínculo | Estado |
| :--- | :--- | :--- | :--- |
| `ms-pedidos` | `ms-sucursales` | `sucursalId` (Long) | ✅ Implementado |
| `ms-pedidos` | `ms-menu` | `menuItemId` (Long) | ✅ Implementado |
| `ms-inventario` | `ms-sucursales` | `sucursalId` (Long) | ✅ Implementado |
| `ms-menu` | — (interno) | `categoriaId` (Long) | ✅ `@ManyToOne` dentro de `ms-menu` |
| `ms-carrito` | `ms-menu` | `menuItemId` (Long) | 🔶 Scaffolding |
| `ms-pagos` | `ms-pedidos` | `pedidoId` (Long) | 🔶 Scaffolding |

## 4. Proyecciones Locales (CQRS)
Varios servicios mantienen **proyecciones locales** actualizadas vía eventos Kafka para evitar llamadas Feign innecesarias:

| Servicio | Proyección | Origen del Evento |
| :--- | :--- | :--- |
| `ms-menu` | `proyeccion_sucursales` | `ms-sucursales` (sucursal-events) |
| `ms-carrito` | `proyeccion_menu_items`, `proyeccion_clientes` | `ms-menu` (menu-item-events), `ms-auth` |
| `ms-pedidos` | `proyeccion_menu_items`, `proyeccion_clientes` | `ms-menu`, `ms-auth` |
| `ms-pagos` | `proyeccion_pedidos` | `ms-pedidos` (pedido-events) |
| `ms-delivery` | `proyeccion_pedidos` | `ms-pedidos` (pedido-events) |
| `ms-inventario` | `proyeccion_menu_items` | `ms-menu` (menu-item-events) |
| `ms-reportes` | `proyeccion_pedidos`, `proyeccion_pagos` | `ms-pedidos`, `ms-pagos` |

## 5. Arquitectura Objetivo (Datos)
- Implementar **Vistas Materializadas** para reportes que requieran JOINs entre microservicios (vía `ms-reportes`).
- Transicionar a **Event Sourcing** para trazabilidad completa de cambios de estado en pedidos e inventario.
