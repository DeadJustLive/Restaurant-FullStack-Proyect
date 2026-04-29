# 👤 ms-usuarios — Microservicio de Perfiles de Usuario

> **Puerto:** `9002` · **BD:** PostgreSQL `usuarios` · **Registro:** Eureka Client  
> **Paquete raíz:** `cl.triskeledu.usuarios`

---

## 🎯 Responsabilidad del Servicio

`ms-usuarios` gestiona el **perfil público** de cada usuario del sistema.
Almacena la información personal (nombre, teléfono, dirección, foto de perfil)
que no forma parte de las credenciales de acceso (esas pertenecen a `ms-auth`).

### Separación de responsabilidades con ms-auth

```
ms-auth (BD: auth)                ms-usuarios (BD: usuarios)
┌─────────────────────┐          ┌─────────────────────────┐
│ UserCredential      │          │ Usuario                  │
│  id          ←──────┼──────────┼── credencialId           │
│  username           │  (FK     │  nombre                  │
│  password (hash)    │  lógica) │  apellido                │
│  rol                │          │  telefono                │
│  activo             │          │  direccion               │
└─────────────────────┘          │  imagenUrl               │
                                 │  sucursalId              │
                                 └─────────────────────────┘
```

- **ms-auth** sabe QUIÉN eres (identidad, contraseña, rol).
- **ms-usuarios** sabe CÓMO eres (nombre, contacto, preferencias).

### Límites del Dominio (Bounded Context)

- ✅ **Responsabilidad:** CRUD de perfiles de usuario (nombre, teléfono, dirección, foto).
- ✅ **Responsabilidad:** Vincular el `credencialId` (de ms-auth) con el perfil.
- ✅ **Responsabilidad:** Consultar usuarios por sucursal asignada (para empleados).
- ❌ **No responsabilidad:** Gestionar credenciales o contraseñas → `ms-auth`.
- ❌ **No responsabilidad:** Gestionar pedidos del usuario → `ms-pedidos`.
- ❌ **No responsabilidad:** Gestionar sucursales → `ms-sucursales`.

---

## 🗄️ Diccionario de Datos

### Tabla: `usuarios`

| Campo           | Tipo SQL        | Tipo Java       | Nullable | Descripción                                                                 | Riesgo de modificación                                                    |
|-----------------|-----------------|-----------------|----------|-----------------------------------------------------------------------------|---------------------------------------------------------------------------|
| `id`            | `BIGSERIAL`     | `Long`          | NO       | PK autoincremental del perfil de usuario en este MS.                        | **CRÍTICO:** No confundir con `credencial_id`. Son IDs distintos.         |
| `credencial_id` | `BIGINT`        | `Long`          | NO       | FK lógica a `user_credentials.id` en ms-auth. Vínculo único entre sistemas. | **CRÍTICO:** Si se cambia, el perfil queda desvinculado de la credencial. UNIQUE constraint obligatorio. |
| `nombre`        | `VARCHAR(100)`  | `String`        | NO       | Nombre de pila del usuario. Mostrado en UI, notificaciones y tickets.       | **BAJO:** Cambiar no afecta transacciones. Propagado a ms-notificaciones. |
| `apellido`      | `VARCHAR(100)`  | `String`        | NO       | Apellido del usuario.                                                        | **BAJO:** Idem nombre.                                                    |
| `telefono`      | `VARCHAR(20)`   | `String`        | SÍ       | Número de teléfono. Usado para contacto en deliveries.                      | **MEDIO:** Cambiar afecta coordinación de repartidores. Validar formato.  |
| `direccion`     | `VARCHAR(300)`  | `String`        | SÍ       | Dirección principal de entrega. Pre-rellena el campo de delivery en el carrito. | **MEDIO:** Si se cambia a mitad de un pedido, el pedido activo no se ve afectado (la dirección se copia al crear). |
| `imagen_url`    | `VARCHAR(500)`  | `String`        | SÍ       | URL de foto de perfil. CDN externo.                                          | **BAJO:** Cambiar no afecta transacciones. Si URL inválida, mostrar avatar genérico. |
| `sucursal_id`   | `BIGINT`        | `Long`          | SÍ       | FK lógica a la sucursal asignada (solo para empleados: COCINERO, REPARTIDOR, ADMIN). NULL para clientes. | **ALTO:** Cambiar el sucursal_id de un cocinero activo puede dejarlo sin acceso al KDS de su sucursal. |
| `activo`        | `BOOLEAN`       | `Boolean`       | NO       | Flag de perfil activo. Sincronizado con ms-auth: si ms-auth desactiva, ms-usuarios debería reflejar. | **ALTO:** Desactivar aquí no revoca el JWT. Debe coordinarse con ms-auth. |
| `creado_en`     | `TIMESTAMP`     | `LocalDateTime` | NO       | Fecha de creación del perfil. Inmutable. Auditoría.                          | **CRÍTICO:** Inmutable. No incluir en endpoints de actualización.          |
| `actualizado_en`| `TIMESTAMP`     | `LocalDateTime` | NO       | Última actualización del perfil.                                              | **BAJO:** Automático por Hibernate.                                       |

---

## 🔁 Flujo Técnico Interno

```
HTTP Request (JWT requerido para endpoints protegidos)
        │
        ▼
┌────────────────────────┐
│   UsuarioController    │  Extrae credencialId del JWT (claim `sub`)
│   /api/v1/usuarios     │  Valida @Valid, delega al Service
└─────────┬──────────────┘
          │ UsuarioRequestDTO
          ▼
┌────────────────────────┐
│   UsuarioService       │  1. Valida reglas de negocio (unicidad credencialId)
│   (interface)          │  2. Valida sucursalId en ms-sucursales (si aplica)
│   UsuarioServiceImpl   │  3. Mapea DTO → Entity con UsuarioMapper
└─────────┬──────────────┘  4. Persiste con Repository
          │ Usuario (entity)
          ▼
┌────────────────────────┐
│  UsuarioRepository     │  JpaRepository + queries por credencialId, sucursal
└─────────┬──────────────┘
          │
          ▼
   PostgreSQL DB: usuarios
          │
          ▼
┌────────────────────────┐
│  UsuarioMapper         │  Entity → UsuarioResponseDTO (MapStruct)
└────────────────────────┘
```

### Dependencias con Otros Microservicios

| Servicio destino  | Cliente Feign         | Propósito                                         | Tipo     |
|-------------------|-----------------------|---------------------------------------------------|----------|
| `ms-sucursales`   | `SucursalClient`      | Validar sucursal activa al asignar empleado       | Síncrono |

### Consumidores de este Microservicio

| Microservicio     | Endpoint consumido              | Propósito                                    |
|-------------------|---------------------------------|----------------------------------------------|
| `ms-pedidos`      | `GET /api/v1/usuarios/{credId}` | Obtener nombre para mostrar en pedido        |
| `ms-notificaciones`| `GET /api/v1/usuarios/{credId}`| Obtener nombre y email para notificaciones   |

---

## 📁 Estructura de Paquetes

```
cl.triskeledu.usuarios/
├── RestaurantUsuariosApplication.java
├── controller/
│   └── UsuarioController.java
├── service/
│   ├── UsuarioService.java           (interface)
│   └── impl/
│       └── UsuarioServiceImpl.java
├── repository/
│   └── UsuarioRepository.java
├── entity/
│   └── Usuario.java
├── dto/
│   ├── request/
│   │   └── UsuarioRequestDTO.java
│   └── response/
│       └── UsuarioResponseDTO.java
├── mapper/
│   └── UsuarioMapper.java
└── exception/
    ├── UsuarioNotFoundException.java
    ├── CredencialYaVinculadaException.java
    └── GlobalExceptionHandler.java
```

---

## 🧪 Endpoints Disponibles

| Método | Path                                  | Rol Requerido           | Descripción                                          |
|--------|---------------------------------------|-------------------------|------------------------------------------------------|
| POST   | `/api/v1/usuarios`                    | Interno (ms-auth)       | Crear perfil al registrar un usuario                 |
| GET    | `/api/v1/usuarios/{id}`               | ROLE_AD, ROLE_SA        | Obtener perfil por ID de perfil                      |
| GET    | `/api/v1/usuarios/credencial/{credId}`| Todos (incluye Feign)   | Obtener perfil por ID de credencial (ms-auth)        |
| GET    | `/api/v1/usuarios/sucursal/{sucId}`   | ROLE_AD, ROLE_SA        | Listar empleados de una sucursal                     |
| PUT    | `/api/v1/usuarios/{id}`               | ROLE_CL (propio), ROLE_AD| Actualizar perfil completo                          |
| PATCH  | `/api/v1/usuarios/{id}/sucursal`      | ROLE_AD, ROLE_SA        | Reasignar empleado a sucursal                        |
| DELETE | `/api/v1/usuarios/{id}`               | ROLE_SA                 | Eliminar perfil (soft delete recomendado)            |
