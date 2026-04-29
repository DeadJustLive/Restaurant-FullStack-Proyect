# 📦 Microservicio: Menú (ms-menu)

## 1. Propósito
Responsable de gestionar el catálogo de productos disponibles para la venta, incluyendo nombres, descripciones, precios y asociación con categorías y sucursales.

## 2. Responsabilidades Clave
*   Gestión de ítems del menú (CRUD).
*   Validación de disponibilidad de productos.
*   Fuente de verdad para el precio vigente al momento de la compra.

## 3. Diccionario de Datos (Entidad: MenuItem)
| Campo | Tipo | Requerido | Descripción |
| :--- | :--- | :--- | :--- |
| `id` | `Long` | Sí | PK Autoincremental. |
| `nombre` | `String` | Sí | Nombre comercial del producto. |
| `precio` | `BigDecimal` | Sí | Precio unitario. |
| `disponible` | `Boolean` | Sí | Flag para ocultar/mostrar en el menú. |
| `categoriaId` | `Long` | Sí | FK Lógica hacia `ms-categorias`. |
| `sucursalId` | `Long` | Sí | FK Lógica hacia `ms-sucursales`. |

## 4. Endpoints Principales
*   `GET /api/v1/menu`: Lista todos los productos disponibles.
*   `GET /api/v1/menu/{id}`: Detalle de un producto específico.
*   `POST /api/v1/menu`: Crear nuevo ítem (Solo ADMIN).
*   `PUT /api/v1/menu/{id}`: Actualizar datos o precio.

## 5. Dependencias (Feign Clients)
*   `ms-categorias`: Para validar existencia de la categoría.
*   `ms-sucursales`: Para validar pertenencia a local.
