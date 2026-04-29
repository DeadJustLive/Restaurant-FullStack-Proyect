# 🏷️ ms-categorias — Microservicio de Categorías

> **Puerto:** `9005` · **BD:** PostgreSQL `categorias` · **Registro:** Eureka Client  
> **Paquete raíz:** `cl.triskeledu.categorias`

---

## 🎯 Responsabilidad del Servicio

`ms-categorias` gestiona la taxonomía y clasificación de los ítems del menú.
Permite organizar el catálogo en grupos lógicos (ej: "Bebidas", "Postres", "Platos Principales")
para facilitar la navegación en el frontend y la agrupación en reportes.

### Límites del Dominio (Bounded Context)

- ✅ **Responsabilidad:** Mantener el maestro de categorías (nombre, descripción).
- ✅ **Responsabilidad:** Proveer información síncrona (vía Feign) a `ms-menu`.
- ❌ **No responsabilidad:** Gestionar los ítems del menú (eso es `ms-menu`).
- ❌ **No responsabilidad:** Relacionar ítems con categorías (eso se guarda en la tabla `menu_items` de `ms-menu` como una FK lógica a la categoría).

---

## 🗄️ Diccionario de Datos

### Tabla: `categorias`

| Campo           | Tipo SQL        | Tipo Java       | Nullable | Descripción                                                              | Riesgo de modificación                                                    |
|-----------------|-----------------|-----------------|----------|--------------------------------------------------------------------------|---------------------------------------------------------------------------|
| `id`            | `BIGSERIAL`     | `Long`          | NO       | PK autoincremental de la categoría.                                      | **CRÍTICO:** `ms-menu` usa este ID como FK lógica `categoria_id`.         |
| `nombre`        | `VARCHAR(100)`  | `String`        | NO       | Nombre de la categoría (ej: "Entradas"). Único en BD.                    | **BAJO:** Se puede actualizar sin impacto técnico. Usado en UI.           |
| `descripcion`   | `VARCHAR(255)`  | `String`        | SÍ       | Descripción breve para mostrar en el menú digital.                       | **BAJO:** Campo informativo.                                              |
| `activa`        | `BOOLEAN`       | `Boolean`       | NO       | Si la categoría está visible. Si false, se oculta en el menú digital.    | **ALTO:** Si se desactiva, afecta la visibilidad en el frontend.          |
| `creado_en`     | `TIMESTAMP`     | `LocalDateTime` | NO       | Fecha de registro.                                                       | **CRÍTICO:** Inmutable.                                                   |
| `actualizado_en`| `TIMESTAMP`     | `LocalDateTime` | NO       | Fecha de última actualización de datos.                                  | **BAJO:** Gestionado por Hibernate.                                       |

---

## 🔁 Flujo Técnico Interno

```
HTTP Request
        │
        ▼
┌────────────────────────┐
│  CategoriaController   │  Valida @Valid y roles (@PreAuthorize)
│  /api/v1/categorias    │
└─────────┬──────────────┘
          │ CategoriaRequestDTO
          ▼
┌────────────────────────┐
│   CategoriaService     │  Reglas de negocio (unicidad de nombre)
│   CategoriaServiceImpl │
└─────────┬──────────────┘
          │ Categoria (entity)
          ▼
┌────────────────────────┐
│  CategoriaRepository   │  JpaRepository
└─────────┬──────────────┘
          │
          ▼
   PostgreSQL: categorias
          │
          ▼
┌────────────────────────┐
│  CategoriaMapper       │  Entity → CategoriaResponseDTO (MapStruct)
└────────────────────────┘
```

### Consumidores de este Microservicio (Dependencias Feign entrantes)

| Consumidor        | Uso principal                                                                 |
|-------------------|-------------------------------------------------------------------------------|
| `ms-menu`         | Validar que la categoría existe al crear/actualizar un ítem del menú.         |
| `Frontend`        | Listar las categorías para renderizar los tabs del menú digital.              |

---

## 📁 Estructura de Paquetes

```
cl.triskeledu.categorias/
├── controller/
│   └── CategoriaController.java
├── service/
│   ├── CategoriaService.java
│   └── impl/
│       └── CategoriaServiceImpl.java
├── repository/
│   └── CategoriaRepository.java
├── entity/
│   └── Categoria.java
├── dto/
│   ├── request/
│   │   └── CategoriaRequestDTO.java
│   └── response/
│       └── CategoriaResponseDTO.java
├── mapper/
│   └── CategoriaMapper.java
└── exception/
    ├── CategoriaNotFoundException.java
    ├── CategoriaDuplicadaException.java
    └── GlobalExceptionHandler.java
```

---

## 🧪 Endpoints Disponibles

| Método | Path                              | Rol Requerido | Descripción                                             |
|--------|-----------------------------------|---------------|---------------------------------------------------------|
| POST   | `/api/v1/categorias`              | ROLE_SA, AD   | Crear nueva categoría.                                  |
| GET    | `/api/v1/categorias/{id}`         | Todos         | Obtener detalle de una categoría.                       |
| GET    | `/api/v1/categorias`              | Todos         | Listar categorías activas.                              |
| PUT    | `/api/v1/categorias/{id}`         | ROLE_SA, AD   | Actualizar datos (nombre, descripción).                 |
| PATCH  | `/api/v1/categorias/{id}/estado`  | ROLE_SA, AD   | Activar/Desactivar categoría.                           |
