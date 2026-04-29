# 👤 Microservicio: Usuarios (ms-usuarios)

## 1. Propósito
Gestiona el perfil público y la información personal de los usuarios. Complementa a `ms-auth` separando la identidad (credenciales) de los atributos de la persona (nombre, contacto, dirección).

## 2. Responsabilidades Clave
*   Gestión de perfiles de usuario (CRUD).
*   Vinculación con `credencialId` de `ms-auth`.
*   Gestión de personal por sucursal (para administradores y empleados).

## 3. Diccionario de Datos (Entidad: Usuario)
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental del perfil. |
| `credencialId` | `Long` | FK Lógica hacia `ms-auth`. Vínculo único. |
| `nombre` | `String` | Nombre de pila. |
| `apellido` | `String` | Apellido del usuario. |
| `telefono` | `String` | Contacto telefónico. |
| `direccion` | `String` | Dirección principal de entrega. |
| `sucursalId` | `Long` | ID de sucursal asignada (solo empleados). |

## 4. Endpoints Principales
*   `GET /api/v1/usuarios/credencial/{credId}`: Obtener perfil por ID de auth.
*   `GET /api/v1/usuarios/sucursal/{sucId}`: Listar empleados de un local.
*   `PUT /api/v1/usuarios/{id}`: Actualizar datos de perfil.

## 5. Dependencias (Feign Clients)
*   `ms-sucursales`: Validar existencia de sucursal al asignar personal.
