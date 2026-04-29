# 🔐 Microservicio: Autenticación (ms-auth)

## 1. Propósito
Es el guardián de la identidad del sistema. Gestiona credenciales, autenticación y emite los tokens JWT que autorizan el acceso a todos los demás servicios.

## 2. Responsabilidades Clave
*   Registro de credenciales (Username/Password hasheado).
*   Autenticación de usuarios (Login).
*   Emisión y validación de tokens JWT.
*   Gestión de Roles (`ROLE_SA`, `ROLE_AD`, `ROLE_CO`, `ROLE_RP`, `ROLE_CL`).

## 3. Diccionario de Datos (Entidad: UserCredential)
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. Identificador del sujeto (sub). |
| `username` | `String` | Email o nombre de usuario único. |
| `password` | `String` | Hash BCrypt de la contraseña. |
| `rol` | `Enum` | Rol asignado al usuario. |
| `activo` | `Boolean` | Flag para habilitar/deshabilitar acceso. |

## 4. Endpoints Principales
*   `POST /api/v1/auth/register`: Registro de nuevas cuentas.
*   `POST /api/v1/auth/login`: Autenticación y obtención de JWT.
*   `POST /api/v1/auth/refresh`: Renovación de token.

## 5. Seguridad Técnica
*   **Algoritmo:** HS256 (Simétrico) o RS256 (Asimétrico).
*   **Claims:** Incluye `sub` (ID), `username` y `roles`.
*   **Filtro:** `JwtAuthFilter` intercepta cada petición para validar el token en el contexto de Spring Security.
