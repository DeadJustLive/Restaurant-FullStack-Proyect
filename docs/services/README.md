# 🛠️ Catálogo de Microservicios

El ecosistema se compone de **10 microservicios de negocio** + **Eureka Server** que colaboran para ofrecer la funcionalidad completa del restaurante. Cada servicio sigue el patrón **CSR** (Controller → Service → Repository) con 6+ capas y posee su propia base de datos PostgreSQL.

> 📌 **Migración v12→v10:** Los servicios `ms-usuarios` y `ms-categorias` fueron fusionados en `ms-auth` y `ms-menu` respectivamente. Ver [changelog de migración](../07-migration-changelog.md).

## Servicios Nucleares (Core)
*   [**ms-auth**](ms-auth.md) (`:9001`): Autenticación JWT, registro/login, gestión de usuarios y roles.
*   [**ms-sucursales**](ms-sucursales.md) (`:9003`): Maestro de locales físicos y estados operativos.

## Gestión Comercial y Menú
*   [**ms-menu**](ms-menu.md) (`:9004`): Catálogo de productos, categorías, precios y disponibilidad.
*   [**ms-carrito**](ms-carrito.md) (`:9006`): Persistencia temporal de la selección del cliente.

## Operaciones y Transacciones
*   [**ms-pedidos**](ms-pedidos.md) (`:9007`): Motor de estados de la orden (Pendiente → Entregado).
*   [**ms-pagos**](ms-pagos.md) (`:9008`): Procesamiento transaccional y registro de pagos.
*   [**ms-delivery**](ms-delivery.md) (`:9009`): Logística de última milla y asignación de repartidores.

## Soporte e Inteligencia
*   [**ms-inventario**](ms-inventario.md) (`:9010`): Control de stock de insumos y movimientos.
*   [**ms-notificaciones**](ms-notificaciones.md) (`:9011`): Motor de alertas (historial de notificaciones).
*   [**ms-reportes**](ms-reportes.md) (`:9012`): Análisis de datos, CQRS y snapshots gerenciales.

---

[⬅️ Volver al Inicio](../00-intro.md)
