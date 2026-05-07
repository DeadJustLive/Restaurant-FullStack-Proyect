# 🔐 Microservicio: Autenticación (ms-auth)

> [!NOTE]
> **Estado de Implementación:** 🟢 **IMPLEMENTADO**
> El servicio cuenta con lógica real de persistencia, cifrado de seguridad y emisión de tokens.

## 1. Propósito
Es el guardián de la identidad del sistema. Gestiona credenciales, autenticación y emite los tokens JWT que autorizan el acceso a todos los demás servicios.

## 2. Responsabilidades Clave
*   Registro de credenciales (Username/Password hasheado).
*   Autenticación de usuarios (Login).
*   Emisión y validación de tokens JWT.
*   Gestión de Roles (`ROLE_SA`, `ROLE_AD`, `ROLE_CO`, `ROLE_RP`, `ROLE_ME`, `ROLE_CL`).

## 3. Diccionario de Datos (Entidad: UserCredential)
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. Identificador del sujeto (sub). |
| `username` | `String` | Nombre de usuario único (Email). |
| `password` | `String` | Hash **BCrypt** de la contraseña. |
| `rol` | `Enum` | Rol asignado al usuario (ROLE_...). |
| `activo` | `Boolean` | Flag para habilitar/deshabilitar acceso. |

## 4. Endpoints Principales
*   `POST /api/v1/auth/register`: Registro de nuevas cuentas (BCrypt incluido).
*   `POST /api/v1/auth/login`: Autenticación y obtención de JWT.
*   `POST /api/v1/auth/refresh`: **[PENDIENTE]** Renovación de token (Lanza UnsupportedOperationException).

## 5. Seguridad Técnica
*   **Algoritmo:** HS256 (Simétrico).
*   **Claims Implementados:** `sub` (username), `userId`, `roles`.
*   **Filtro:** `JwtAuthFilter` intercepta cada petición para validar el token.
