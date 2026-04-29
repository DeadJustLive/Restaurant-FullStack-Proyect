# 🏢 ms-sucursales — Microservicio de Sucursales

> **Puerto:** `9003` · **BD:** PostgreSQL `sucursales` · **Registro:** Eureka Client  
> **Paquete raíz:** `cl.triskeledu.sucursales`

---

## 🎯 Responsabilidad del Servicio

`ms-sucursales` gestiona la información física y operativa de los locales del restaurante.
Define la disponibilidad de atención y sirve como eje central (hub) organizativo
para repartir carga en otros microservicios (inventario, empleados, pedidos).

### Límites del Dominio (Bounded Context)

- ✅ **Responsabilidad:** Mantener el maestro de sucursales (nombre, dirección, teléfono).
- ✅ **Responsabilidad:** Gestionar estado operativo (activa/inactiva).
- ✅ **Responsabilidad:** Proveer información síncrona (vía Feign) a otros microservicios que dependen de la ubicación.
- ❌ **No responsabilidad:** Gestionar a los empleados de la sucursal → `ms-usuarios`.
- ❌ **No responsabilidad:** Gestionar el menú específico de la sucursal → `ms-menu`.
- ❌ **No responsabilidad:** Gestionar el stock de ingredientes → `ms-inventario`.

---

## 🗄️ Diccionario de Datos

### Tabla: `sucursales`

| Campo           | Tipo SQL        | Tipo Java       | Nullable | Descripción                                                              | Riesgo de modificación                                                    |
|-----------------|-----------------|-----------------|----------|--------------------------------------------------------------------------|---------------------------------------------------------------------------|
| `id`            | `BIGSERIAL`     | `Long`          | NO       | PK autoincremental de la sucursal.                                       | **CRÍTICO:** Múltiples microservicios usan este ID como FK lógica.        |
| `nombre`        | `VARCHAR(100)`  | `String`        | NO       | Nombre comercial de la sucursal (ej: "Sede Centro", "Sucursal Norte").   | **BAJO:** Se puede actualizar sin impacto técnico. Usado en UI.           |
| `direccion`     | `VARCHAR(255)`  | `String`        | NO       | Dirección física de la sucursal. Usado por ms-delivery como punto de partida. | **MEDIO:** Si cambia, afecta el cálculo de distancia de deliveries.       |
| `telefono`      | `VARCHAR(20)`   | `String`        | SÍ       | Teléfono de contacto del local.                                          | **BAJO:** Informativo.                                                    |
| `activa`        | `BOOLEAN`       | `Boolean`       | NO       | Si la sucursal está operando. Si false, no recibe pedidos.               | **ALTO:** Si se desactiva, afecta ms-menu, ms-pedidos y ms-usuarios.      |
| `creado_en`     | `TIMESTAMP`     | `LocalDateTime` | NO       | Fecha de registro de la sucursal en el sistema.                          | **CRÍTICO:** Inmutable.                                                   |
| `actualizado_en`| `TIMESTAMP`     | `LocalDateTime` | NO       | Fecha de última actualización de datos.                                  | **BAJO:** Gestionado por Hibernate.                                       |

---

## 🔁 Flujo Técnico Interno

```
HTTP Request
        │
        ▼
┌────────────────────────┐
│  SucursalController    │  Valida @Valid y roles (@PreAuthorize)
│  /api/v1/sucursales    │
└─────────┬──────────────┘
          │ SucursalRequestDTO
          ▼
┌────────────────────────┐
│   SucursalService      │  Reglas de negocio y estado
│   SucursalServiceImpl  │
└─────────┬──────────────┘
          │ Sucursal (entity)
          ▼
┌────────────────────────┐
│  SucursalRepository    │  JpaRepository (consultas de estado activo)
└─────────┬──────────────┘
          │
          ▼
   PostgreSQL: sucursales
          │
          ▼
┌────────────────────────┐
│  SucursalMapper        │  Entity → SucursalResponseDTO (MapStruct)
└────────────────────────┘
```

### Consumidores de este Microservicio (Dependencias Feign entrantes)

Este microservicio no consume a otros, pero **es consumido** por casi todos:

| Consumidor        | Uso principal                                                                 |
|-------------------|-------------------------------------------------------------------------------|
| `ms-usuarios`     | Validar que la sucursal existe y está activa al asignar un empleado.          |
| `ms-menu`         | Validar existencia al registrar disponibilidad específica de un ítem.         |
| `ms-pedidos`      | Validar sucursal seleccionada por el cliente antes de crear el pedido.        |
| `ms-inventario`   | Consultar sucursales para crear/gestionar lotes de ingredientes (futuro).     |

---

## 📁 Estructura de Paquetes

```
cl.triskeledu.sucursales/
├── controller/
│   └── SucursalController.java
├── service/
│   ├── SucursalService.java
│   └── impl/
│       └── SucursalServiceImpl.java
├── repository/
│   └── SucursalRepository.java
├── entity/
│   └── Sucursal.java
├── dto/
│   ├── request/
│   │   └── SucursalRequestDTO.java
│   └── response/
│       └── SucursalResponseDTO.java
├── mapper/
│   └── SucursalMapper.java
└── exception/
    ├── SucursalNotFoundException.java
    └── GlobalExceptionHandler.java
```

---

## 🧪 Endpoints Disponibles

| Método | Path                            | Rol Requerido | Descripción                                             |
|--------|---------------------------------|---------------|---------------------------------------------------------|
| POST   | `/api/v1/sucursales`            | ROLE_SA       | Crear nueva sucursal.                                   |
| GET    | `/api/v1/sucursales/{id}`       | Todos         | Obtener detalle de una sucursal.                        |
| GET    | `/api/v1/sucursales`            | Todos         | Listar sucursales activas (para clientes y frontend).   |
| GET    | `/api/v1/sucursales/todas`      | ROLE_SA       | Listar TODAS las sucursales (incluye inactivas).        |
| PUT    | `/api/v1/sucursales/{id}`       | ROLE_SA       | Actualizar datos (nombre, dirección, teléfono).         |
| PATCH  | `/api/v1/sucursales/{id}/estado`| ROLE_SA       | Activar/Desactivar sucursal.                            |
