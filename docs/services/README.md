# 🛠️ Catálogo de Microservicios

El ecosistema se compone de **12 microservicios** independientes que colaboran para ofrecer la funcionalidad completa del restaurante. Cada servicio sigue un patrón de arquitectura de 6 capas y posee su propia base de datos.

## Servicios Nucleares (Core)
*   [**ms-auth**](ms-auth.md): Gestión de tokens JWT y autenticación centralizada.
*   [**ms-usuarios**](ms-usuarios.md): Perfiles de usuarios, roles y asignación a sucursales.
*   [**ms-sucursales**](ms-sucursales.md): Maestro de locales físicos y estados operativos.

## Gestión Comercial y Menú
*   [**ms-menu**](ms-menu.md): Catálogo de productos, precios y disponibilidad.
*   [**ms-categorias**](ms-categorias.md): Taxonomía y clasificación de productos.
*   [**ms-carrito**](ms-carrito.md): Persistencia temporal de la selección del cliente.

## Operaciones y Transacciones
*   [**ms-pedidos**](ms-pedidos.md): Motor de estados de la orden (Desde Pendiente hasta Entregado).
*   [**ms-pagos**](ms-pagos.md): Procesamiento transaccional y pasarelas de pago.
*   [**ms-delivery**](ms-delivery.md): Logística de última milla y asignación de repartidores.

## Soporte e Inteligencia
*   [**ms-inventario**](ms-inventario.md): Control de stock de materias primas y recetas.
*   [**ms-notificaciones**](ms-notificaciones.md): Motor de alertas (Email, SMS, Push).
*   [**ms-reportes**](ms-reportes.md): Análisis de datos, CQRS y Dashboards gerenciales.

---
[⬅️ Volver al Inicio](../00-intro.md)
