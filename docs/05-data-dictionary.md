# 🗄️ Diccionario de Datos y Relaciones Inter-Servicio

## 1. Principio de Identidad
El sistema sigue el principio de **Database per Service**. Las relaciones entre microservicios son lógicas y basadas en IDs.

## 2. Relación Crítica: Auth <-> Usuarios

### Implementación Actual (Realidad en Código)
La vinculación entre el microservicio de autenticación y el de perfiles no es por email ni username, sino por el ID técnico.

- **Vínculo:** `credencialId` (Long)
- **Flujo:**
    1. `ms-auth` crea la credencial y genera un ID autoincremental.
    2. El ID se devuelve o se utiliza para crear el registro en `ms-usuarios`.
    3. `ms-usuarios` almacena este `credencialId` como su llave de referencia externa.

> [!NOTE]
> Esta separación permite cambiar el email o username del usuario sin romper la integridad de sus perfiles, pedidos o historial.

## 3. Relaciones en el Dominio de Ventas

| De (Servicio) | A (Servicio) | Atributo de Vínculo | Estado Implementación |
| :--- | :--- | :--- | :--- |
| `ms-pedidos` | `ms-sucursales`| `sucursalId` (Long) | **Scaffolding** |
| `ms-pedidos` | `ms-menu` | `menuItemId` (Long) | **Scaffolding** |
| `ms-inventario` | `ms-sucursales`| `sucursalId` (Long) | **Implementado** |
| `ms-menu` | `ms-categorias`| `categoriaId` (Long) | **En Transición** |

---

## 4. Arquitectura Objetivo (Datos)
- Implementar **Vistas Materializadas** para reportes que requieran JOINs entre microservicios (vía `ms-reportes`).
- Uso de **Eventos de Dominio** para mantener la consistencia eventual entre `ms-pedidos` y `ms-inventario`.
