# 🛒 Microservicio: Carrito (ms-carrito)

## 1. Propósito
Gestiona el estado temporal de la compra. Permite a los usuarios pre-seleccionar productos y calcular subtotales antes de confirmar la orden definitiva.

## 2. Responsabilidades Clave
*   Almacenar persistencia temporal del carrito (por usuario y sucursal).
*   Sincronizar precios reales desde `ms-menu`.
*   Cálculo automático de totales y subtotales.

## 3. Diccionario de Datos
### Entidad: Carrito
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. |
| `usuarioId` | `Long` | ID del dueño del carrito (`ms-usuarios`). |
| `sucursalId` | `Long` | ID del local donde se compra. |
| `total` | `BigDecimal` | Suma de los ítems. |

### Entidad: CarritoItem
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. |
| `menuItemId` | `Long` | Producto referenciado (`ms-menu`). |
| `precioUnitario` | `BigDecimal` | Precio capturado al agregar. |
| `cantidad` | `Integer` | Unidades deseadas. |

## 4. Endpoints Principales
*   `GET /api/v1/carrito/usuario/{userId}`: Ver estado actual.
*   `POST /api/v1/carrito/items`: Agregar o actualizar cantidad.
*   `DELETE /api/v1/carrito/{id}`: Vaciar tras finalizar compra.

## 5. Dependencias (Feign Clients)
*   `ms-menu`: Validar stock y obtener precio vigente.
*   `ms-sucursales`: Verificar que el local esté abierto.
