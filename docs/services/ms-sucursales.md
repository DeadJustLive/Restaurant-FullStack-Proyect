# 🏢 Microservicio: Sucursales (ms-sucursales)

## 1. Propósito
Centraliza la información de los locales físicos. Es el punto de referencia para la disponibilidad de productos, asignación de personal y origen de los despachos.

## 2. Responsabilidades Clave
*   Maestro de locales (Nombre, Dirección, Teléfono).
*   Estado operativo (Habilitar/Deshabilitar sucursal).
*   Proveer IDs de sucursal para la segmentación de datos en otros servicios.

## 3. Diccionario de Datos (Entidad: Sucursal)
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. ID central de referencia. |
| `nombre` | `String` | Nombre identificador (ej: "Sede Centro"). |
| `direccion` | `String` | Ubicación física. |
| `telefono` | `String` | Contacto del local. |
| `activa` | `Boolean` | Flag de disponibilidad operativa. |

## 4. Endpoints Principales
*   `GET /api/v1/sucursales`: Listar locales activos para clientes.
*   `POST /api/v1/sucursales`: Crear nuevo local (Solo Admin).
*   `PATCH /api/v1/sucursales/{id}/estado`: Cambiar disponibilidad.

## 5. Relaciones (Servicio Hub)
Este servicio es **consumido** por:
*   `ms-usuarios`: Para asignar empleados a un local.
*   `ms-menu`: Para definir stock por sucursal.
*   `ms-pedidos`: Para validar el punto de venta.
*   `ms-inventario`: Para segmentar el stock de materias primas.
