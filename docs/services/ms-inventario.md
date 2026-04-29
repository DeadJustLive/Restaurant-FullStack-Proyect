# 📦 Microservicio: Inventario (ms-inventario)

## 1. Propósito
Controla el stock físico de insumos y productos en cada sucursal. Es vital para prevenir quiebres de stock y registrar el movimiento de mercancía (Kardex).

## 2. Responsabilidades Clave
*   Mantenimiento del stock actual por sucursal.
*   Registro de movimientos (ENTRADA por compra/ajuste, SALIDA por venta/merma).
*   Alertas de stock bajo (Umbrales de reabastecimiento).

## 3. Diccionario de Datos
### Entidad: Insumo
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. |
| `nombre` | `String` | Nombre del insumo (ej: "Harina"). |
| `stockActual` | `BigDecimal` | Cantidad física en bodega. |
| `stockMinimo` | `BigDecimal` | Umbral para alertas. |
| `sucursalId` | `Long` | FK Lógica hacia `ms-sucursales`. |

### Entidad: MovimientoInventario (Kardex)
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. |
| `insumoId` | `Long` | Relación con el insumo. |
| `tipo` | `Enum` | ENTRADA o SALIDA. |
| `cantidad` | `BigDecimal` | Cantidad afectada. |
| `referencia` | `String` | Motivo (ej: "Pedido #102"). |

## 4. Endpoints Principales
*   `GET /api/v1/inventario/sucursal/{sucId}`: Ver stock de un local.
*   `POST /api/v1/inventario/movimiento`: Registrar entrada o salida.
*   `GET /api/v1/inventario/alertas`: Listar productos bajo el stock mínimo.

## 5. Dependencias (Feign Clients)
*   `ms-sucursales`: Validar local antes de operar.
