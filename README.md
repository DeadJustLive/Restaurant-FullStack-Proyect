# 🍴 Restaurant Platform - Microservicios & React

Sistema integral de gestión para restaurantes basado en arquitectura de microservicios.

---

## 🚀 Estado Actual de Implementación (Auditado 2026-05-06)

| Microservicio | Puerto | Base de Datos | Clasificación | Estado Real |
| :--- | :--- | :--- | :--- | :--- |
| **ms-auth** | 9001 | `auth` | **Implementado** | Integra Usuarios. JWT, BCrypt, Gestión de Módulos. |
| **ms-sucursales**| 9003 | `sucursales` | **Scaffolding** | Pendiente lógica manual (con AuthFeignClient). |
| **ms-menu** | 9004 | `menu` | **Implementado** | Integra Categorías. CRUD completo, validaciones. |
| **ms-carrito**| 9006 | `carrito` | **Scaffolding** | Pendiente lógica manual (con AuthFeignClient). |
| **ms-pedidos** | 9007 | `pedidos` | **Implementado** | Controlador ok, Service ok, AuthFeignClient integrado. |
| **ms-pagos** | 9008 | `pagos` | **Scaffolding** | Pendiente integración pasarela. |
| **ms-delivery** | 9009 | `delivery` | **Scaffolding** | Pendiente lógica de asignación. |
| **ms-inventario**| 9010 | `inventario` | **Implementado** | Gestión de insumos y movimientos lista. |
| **ms-notificaciones**| 9011 | `notificaciones` | **Scaffolding** | Pendiente lógica de envío. |
| **ms-reportes** | 9012 | `reportes` | **Scaffolding** | Pendiente generación de Jasper/PDFs. |

---

## 🏗️ Arquitectura Objetivo vs Implementado

### Seguridad y Autenticación
- **Objetivo:** Sistema stateless con rotación de Refresh Tokens y MFA.
- **Estado Actual:** Implementada autenticación via Access Token (JWT) con claims de roles. Las contraseñas están hasheadas con **BCrypt** en la base de datos. Se manejan excepciones reales como `UsuarioYaExisteException`.

### Frontend (Dashboard Administrativo)
- **Objetivo:** Panel 100% dinámico con reportes en tiempo real.
- **Estado Actual:**
    - ✅ **Auth Flow:** Login/Logout real conectado al backend.
    - ✅ **Admin:** Gestión real de Usuarios, Roles y Módulos habilitados (`UsersPage`).
    - 🟡 **Vistas Operativas:** Cocina, Mesas y Entregas integradas visualmente pero con **Mocks Temporales** de datos.
    - ✅ **Navegación:** Filtrado dinámico por Rol y Módulos Visibles (Capa UX).

---

## 🛠️ Tecnologías Utilizadas
- **Backend:** Java 21, Spring Boot 3.5, Spring Cloud (Eureka, Feign), PostgreSQL.
- **Frontend:** React 18, TypeScript, Vite, Tailwind CSS, Lucide React.
