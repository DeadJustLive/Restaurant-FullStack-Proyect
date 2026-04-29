# 🏷️ Microservicio: Categorías (ms-categorias)

## 1. Propósito
Define la taxonomía del catálogo de productos. Permite agrupar los ítems del menú en clasificaciones lógicas para mejorar la experiencia de búsqueda del cliente.

## 2. Responsabilidades Clave
*   Maestro de categorías (ej: "Pizzas", "Bebidas", "Postres").
*   Control de visibilidad de categorías completas.

## 3. Diccionario de Datos (Entidad: Categoria)
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. |
| `nombre` | `String` | Nombre único (ej: "Entradas"). |
| `descripcion` | `String` | Detalle informativo para la App. |
| `activa` | `Boolean` | Flag de visibilidad global. |

## 4. Endpoints Principales
*   `GET /api/v1/categorias`: Listar grupos activos.
*   `POST /api/v1/categorias`: Crear nueva clasificación.
*   `PUT /api/v1/categorias/{id}`: Actualizar metadatos.

## 5. Dependencias
*   `ms-menu`: Utiliza los IDs de este servicio para clasificar sus productos.
