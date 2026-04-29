# 📊 Microservicio: Reportes (ms-reportes)

## 1. Propósito
Centraliza la inteligencia de negocios del sistema. Consolida datos de múltiples microservicios para generar visibilidad gerencial y dashboards de rendimiento.

## 2. Responsabilidades Clave
*   Generación de snapshots estadísticos (Ventas por local, productos más vendidos).
*   Consolidación de costos vs. ingresos.
*   Auditoría de mermas y rendimiento de inventario.

## 3. Diccionario de Datos (Entidad: ReporteSnapshot)
| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `id` | `Long` | PK autoincremental. |
| `sucursalId` | `Long` | Filtro por local (opcional). |
| `tipo` | `Enum` | VENTAS_DIARIAS, TOP_PLATOS, etc. |
| `dataJson` | `String` | Payload JSON con los resultados calculados. |
| `creadoEn` | `DateTime` | Fecha de generación del reporte. |

## 4. Endpoints Principales
*   `GET /api/v1/reportes/ventas`: Dashboard de ventas consolidado.
*   `GET /api/v1/reportes/top-productos`: Ranking de popularidad.
*   `POST /api/v1/reportes/generar`: Forzar recalculo de snapshots.

## 5. Estrategia de Datos (CQRS)
Este servicio utiliza el patrón **CQRS** (Command Query Responsibility Segregation) en su forma básica:
1.  **Recolección**: Consume datos de `ms-pedidos`, `ms-pagos` y `ms-inventario`.
2.  **Procesamiento**: Transforma datos operativos en información analítica.
3.  **Persistencia**: Guarda el resultado final para que las consultas pesadas no afecten a los servicios transaccionales.
