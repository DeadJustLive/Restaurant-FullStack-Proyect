# 🔐 ms-auth — Microservicio de Autenticación y Autorización

> **Puerto:** `9001` · **BD:** PostgreSQL `auth` · **Registro:** Eureka Client  
> **Paquete raíz:** `cl.triskeledu.auth`

---

## 🎯 Responsabilidad del Servicio

El microservicio `ms-auth` es la **puerta de entrada de identidad** del sistema.
Gestiona el registro de credenciales, la autenticación (login) y la emisión de tokens JWT.
Es el **único servicio que emite tokens** — todos los demás microservicios únicamente los validan.

### Límites del Dominio (Bounded Context)

- ✅ **Responsabilidad:** Registrar nuevas credenciales de usuario (`username`, `password` hasheada, `rol`).
- ✅ **Responsabilidad:** Autenticar credenciales (login) y emitir JWT firmado con claims de rol.
- ✅ **Responsabilidad:** Refrescar tokens (`refresh_token`) sin requerir re-login.
- ✅ **Responsabilidad:** Invalidar tokens (logout con blacklist o revocación).
- ❌ **No responsabilidad:** Gestionar datos de perfil (nombre, dirección, teléfono) → `ms-usuarios`.
- ❌ **No responsabilidad:** Validar tokens en cada request de otros servicios → cada MS valida localmente su JWT con la clave pública compartida.

### ⚠️ Dependencias que deben agregarse al pom.xml

```xml
<!-- Spring Security: seguridad HTTP, autenticación y autorización -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- JJWT API: creación y validación de JSON Web Tokens -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.6</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.12.6</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.12.6</version>
    <scope>runtime</scope>
</dependency>
```

---

## 🗄️ Diccionario de Datos

### Tabla: `user_credentials`

| Campo           | Tipo SQL        | Tipo Java       | Nullable | Descripción                                                                | Riesgo de modificación                                                    |
|-----------------|-----------------|-----------------|----------|----------------------------------------------------------------------------|---------------------------------------------------------------------------|
| `id`            | `BIGSERIAL`     | `Long`          | NO       | PK autoincremental. Identificador único de la credencial.                  | **CRÍTICO:** Usado como `sub` (subject) en el JWT. Nunca reasignar.       |
| `username`      | `VARCHAR(100)`  | `String`        | NO       | Email o nombre de usuario. Clave de búsqueda en el login. Único en la BD. | **ALTO:** Si se cambia, el usuario no podrá hacer login con su username anterior. |
| `password`      | `VARCHAR(255)`  | `String`        | NO       | Hash BCrypt de la contraseña. NUNCA almacenar texto plano.                 | **CRÍTICO:** Solo debe modificarse a través del flujo de cambio de contraseña. Nunca exponer en ningún DTO de response. |
| `rol`           | `VARCHAR(20)`   | `RolUsuario`    | NO       | Rol del usuario (enum). Incluido como claim `roles` en el JWT.             | **CRÍTICO:** Cambiar el rol de un usuario invalida sus tokens activos. Requiere re-login. |
| `activo`        | `BOOLEAN`       | `Boolean`       | NO       | Flag de cuenta habilitada. Si es false, el login debe ser rechazado.       | **ALTO:** Desactivar una cuenta no invalida tokens JWT ya emitidos. TODO: implementar blacklist. |
| `creado_en`     | `TIMESTAMP`     | `LocalDateTime` | NO       | Fecha de creación de la credencial. Inmutable. Auditoría.                  | **CRÍTICO:** Inmutable. No incluir en endpoints de actualización.         |
| `actualizado_en`| `TIMESTAMP`     | `LocalDateTime` | NO       | Última modificación. Actualizada automáticamente por Hibernate.            | **BAJO:** Gestionado por @UpdateTimestamp. No modificar manualmente.      |

### Tabla: `refresh_tokens` (futuro)

| Campo           | Tipo SQL        | Tipo Java       | Nullable | Descripción                                                      |
|-----------------|-----------------|-----------------|----------|------------------------------------------------------------------|
| `id`            | `BIGSERIAL`     | `Long`          | NO       | PK.                                                              |
| `token`         | `VARCHAR(500)`  | `String`        | NO       | Valor del refresh token (UUID o string aleatorio). Único.        |
| `user_id`       | `BIGINT`        | `Long`          | NO       | FK lógica a `user_credentials.id`.                               |
| `expira_en`     | `TIMESTAMP`     | `LocalDateTime` | NO       | Fecha de expiración. Si superada, el token es inválido.          |
| `revocado`      | `BOOLEAN`       | `Boolean`       | NO       | Si true, el token fue revocado (logout). No puede reutilizarse.  |

---

## 🔐 Estructura del JWT

```
Header:
{
  "alg": "HS256",   // Algoritmo de firma — HS256 (simétrico) o RS256 (asimétrico recomendado)
  "typ": "JWT"
}

Payload (Claims):
{
  "sub":      "42",                    // ID del usuario (user_credentials.id)
  "username": "juan@email.com",        // Nombre de usuario
  "roles":    ["ROLE_CL"],             // Lista de roles (ver tabla de roles en README raíz)
  "iat":      1714000000,              // Issued At — timestamp de emisión
  "exp":      1714003600              // Expiry — timestamp de expiración (iat + 1h)
}

Signature: HMAC-SHA256(base64(header) + "." + base64(payload), secretKey)
```

> **⚠️ SEGURIDAD CRÍTICA:** La `secretKey` debe almacenarse como variable de entorno
> (nunca en `application.yml` en texto plano). En producción usar AWS Secrets Manager, Vault o similar.
> Para RS256 (asimétrico), el private key firma y el public key valida — los demás MS solo necesitan el public key.

---

## 🔁 Flujo Técnico Interno

### Flujo de Login

```
POST /api/v1/auth/login
        │ { username, password }
        ▼
┌─────────────────────┐
│   AuthController    │  Valida @Valid, delega al Service
└─────────┬───────────┘
          │ LoginRequestDTO
          ▼
┌─────────────────────┐
│   AuthService       │  1. Busca UserCredential por username (Repository)
│   (interface)       │  2. Verifica contraseña con BCryptPasswordEncoder
│                     │  3. Verifica activo = true
│   AuthServiceImpl   │  4. Genera JWT con JwtService (sub=id, roles=[rol])
└─────────┬───────────┘  5. Genera refresh_token (opcional)
          │ AuthResponseDTO
          ▼
┌─────────────────────┐
│ UserCredentialRepo  │  findByUsername(username) → Optional<UserCredential>
└─────────────────────┘
          │
          ▼
HTTP 200 { token, refreshToken, expiresIn, rol }
```

### Flujo de Registro

```
POST /api/v1/auth/register
        │ { username, password, rol }
        ▼
AuthController → AuthService:
  1. Verificar que username no existe (unicidad)
  2. Hashear password con BCryptPasswordEncoder.encode()
  3. Persistir UserCredential con activo = true
  4. Emitir JWT inmediatamente (registro automático con sesión)
  5. TODO: Notificar a ms-usuarios para crear el perfil del nuevo usuario
HTTP 201 { token, refreshToken, expiresIn, rol }
```

### Cómo otros microservicios validan el JWT

```
ms-pedidos recibe: Authorization: Bearer <token>
        │
        ▼
JwtFilter (en cada MS) — intercepta la request ANTES del Controller:
  1. Extrae el token del header Authorization
  2. Verifica la firma con la misma secretKey (o public key en RS256)
  3. Verifica que el token no esté expirado
  4. Extrae el claim "roles" y crea un Authentication en SecurityContext
  5. Spring Security permite o deniega el acceso al endpoint según @PreAuthorize
```

---

## 📁 Estructura de Paquetes

```
cl.triskeledu.auth/
├── RestaurantAuthApplication.java
├── controller/
│   └── AuthController.java
├── service/
│   ├── AuthService.java          (interface)
│   ├── impl/
│   │   └── AuthServiceImpl.java
│   └── JwtService.java           (generación y validación de JWT)
├── repository/
│   └── UserCredentialRepository.java
├── entity/
│   ├── UserCredential.java
│   └── enums/
│       └── RolUsuario.java
├── dto/
│   ├── request/
│   │   ├── LoginRequestDTO.java
│   │   └── RegisterRequestDTO.java
│   └── response/
│       └── AuthResponseDTO.java
├── security/
│   ├── SecurityConfig.java        (configuración de Spring Security)
│   └── JwtAuthFilter.java         (filtro JWT para validar tokens en cada request)
└── exception/
    ├── CredencialesInvalidasException.java
    ├── UsuarioYaExisteException.java
    ├── CuentaDesactivadaException.java
    └── GlobalExceptionHandler.java
```

---

## 🧪 Endpoints Disponibles

| Método | Path                          | Acceso       | Descripción                                        |
|--------|-------------------------------|--------------|----------------------------------------------------|
| POST   | `/api/v1/auth/register`       | Público      | Registrar nuevas credenciales y obtener JWT        |
| POST   | `/api/v1/auth/login`          | Público      | Autenticar y obtener JWT + refresh token           |
| POST   | `/api/v1/auth/refresh`        | Público      | Obtener nuevo JWT usando un refresh token válido   |
| POST   | `/api/v1/auth/logout`         | Autenticado  | Revocar el refresh token activo del usuario        |
| GET    | `/api/v1/auth/validate`       | Interno      | Validar un JWT (usado por API Gateway futuro)      |
