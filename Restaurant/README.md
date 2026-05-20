# Estado de Microservicios (Backend)

## Definición de Estados
- **✅ 100% Funcional:** Implementación completa del CRUD, lógica de negocio, integración Feign, Kafka, excepciones, logs y Eureka.
- **🔶 Scaffolding:** Estructura base creada (Entity, DTO, Controller, Repository, Feign) con lógica de negocio retornando respuestas mock/nulas con comentarios TODO.

| Microservicio | Puerto | Base de Datos | Estado |
|:---|:---:|:---:|:---:|
| Eureka Server | 8761 | — | ✅ |
| ms-auth | 9001 | auth | ✅ 100% |
| ms-sucursales | 9003 | sucursales | 🔶 Scaffolding |
| ms-menu | 9004 | menu | ✅ 100% |
| ms-carrito | 9006 | carrito | 🔶 Scaffolding |
| ms-pedidos | 9007 | pedidos | ✅ 100% |
| ms-pagos | 9008 | pagos | 🔶 Scaffolding |
| ms-delivery | 9009 | delivery | 🔶 Scaffolding |
| ms-inventario | 9010 | inventario | ✅ 100% |
| ms-notificaciones | 9011 | notificaciones | 🔶 Scaffolding |
| ms-reportes | 9012 | reportes | 🔶 Scaffolding |
