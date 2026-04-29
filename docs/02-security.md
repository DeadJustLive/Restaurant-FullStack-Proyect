# 🔐 Seguridad y Control de Acceso

## 1. Modelo de Autenticación
El sistema utiliza **JWT (JSON Web Tokens)** para la seguridad de los endpoints. El flujo de autenticación es el siguiente:

1.  El cliente envía credenciales a `ms-auth`.
2.  `ms-auth` valida contra `db_usuarios`.
3.  Se genera un JWT que contiene los **Claims de Roles**.
4.  El cliente envía el JWT en el header `Authorization: Bearer <token>` en cada petición.
5.  Los microservicios validan el token localmente mediante una configuración de seguridad compartida.

## 2. Matriz de Roles y Permisos (RBAC)

| Rol | Código | Descripción | Acceso Principal |
| :--- | :--- | :--- | :--- |
| **Super Admin** | `ROLE_SA` | Control total del sistema. | Gestión de usuarios, sucursales y reportes globales. |
| **Admin** | `ROLE_AD` | Administrador de local. | Gestión de menú, inventario y pedidos de su sucursal. |
| **Cocinero** | `ROLE_CO` | Operativo de cocina. | Visualización y cambio de estado de pedidos. |
| **Repartidor** | `ROLE_RP` | Operativo de entregas. | Gestión de deliveries asignados. |
| **Cliente** | `ROLE_CL` | Usuario final. | Lectura de menú, gestión de carrito y pedidos propios. |

## 3. Autorización en el Código
La seguridad se aplica a nivel de método utilizando anotaciones de Spring Security:

```java
@PreAuthorize("hasRole('ROLE_AD')")
@PostMapping("/crear")
public ResponseEntity<ResponseDTO> crearItem(...) { ... }
```

> **⚠️ Regla de Oro:** La validación en el Frontend es solo estética (UX). La seguridad real debe residir siempre en el Microservicio receptor del request.
