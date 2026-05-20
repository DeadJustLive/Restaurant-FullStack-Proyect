# 📜 Microservicio: Menú (ms-menu)

> [!IMPORTANT]
> **Estado de Implementación:** ✅ **IMPLEMENTADO** (100% funcional)
> Incluye gestión de `MenuItem` y `Categoria` como entidades JPA internas (relación `@ManyToOne` directa, sin Feign).

## 1. Propósito
Gestionar el catálogo de platos, categorías, precios y disponibilidad de la oferta gastronómica del restaurante.

## 2. Funcionalidad Implementada
*   CRUD completo de **items del menú** (`MenuItem`) con precios, descripción, disponible/eliminado.
*   CRUD completo de **categorías** (`Categoria`) con activa/eliminado.
*   Relación `@ManyToOne` directa entre `MenuItem` → `Categoria` (dentro del mismo microservicio, sin Feign).
*   Proyección local de sucursales via Kafka (`sucursal-events`) para filtrado por sucursal.

## 3. Diccionario de Datos

### MenuItem
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental |
| `nombre` | `String` | Nombre del plato |
| `descripcion` | `String` | Descripción del plato |
| `precio` | `BigDecimal` | Precio actual |
| `categoria` | `Categoria` | `@ManyToOne` — categoría del plato |
| `disponible` | `Boolean` | Disponibilidad actual |
| `eliminado` | `Boolean` | Soft delete |

### Categoria
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental |
| `nombre` | `String` | Nombre de la categoría |
| `descripcion` | `String` | Descripción |
| `activa` | `Boolean` | Soft delete |

## 4. Endpoints
*   `GET /api/v1/menu` — Listar items disponibles
*   `GET /api/v1/menu/{id}` — Obtener item por ID
*   `POST /api/v1/menu` — Crear item (requiere JWT)
*   `PUT /api/v1/menu/{id}` — Actualizar item (requiere JWT)
*   `DELETE /api/v1/menu/{id}` — Soft delete (requiere JWT)
*   `PATCH /api/v1/menu/{id}/disponibilidad` — Cambiar disponibilidad
*   `GET /api/v1/categorias` — Listar categorías activas
*   `GET /api/v1/categorias/{id}` — Obtener categoría por ID
*   `POST /api/v1/categorias` — Crear categoría (requiere JWT)

## 5. Kafka
*   **Consumer:** `sucursal-events` — actualiza proyección local de sucursales
*   **Producer:** `menu-item-events` — notifica cambios a carrito, pedidos, inventario

## 6. Dependencias
*   `ms-sucursales` (Feign): Consulta de sucursales activas
*   `ms-auth` (Feign): Validación de JWT
*   `Eureka`: Registro y descubrimiento
