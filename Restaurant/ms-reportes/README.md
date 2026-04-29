# 📊 ms-reportes — Microservicio de Análisis y Dashboards

> **Puerto:** `9012` · **BD:** PostgreSQL `reportes` · **Registro:** Eureka Client  
> **Paquete raíz:** `cl.triskeledu.reportes`

---

## 🎯 Responsabilidad del Servicio

`ms-reportes` se encarga de la agregación de datos y la generación de información
estadística o gerencial. Consolida la información de ventas (`ms-pedidos`),
ingresos (`ms-pagos`) e inventario (`ms-inventario`).

### Límites del Dominio (Bounded Context)

- ✅ **Responsabilidad:** Implementar el patrón "API Composition" o leer eventos para generar estadísticas consolidadadas.
- ✅ **Responsabilidad:** Almacenar snapshots precalculados (ej. "Ventas Diarias", "Top Platos") para no sobrecargar los microservicios operativos con consultas pesadas (`CQRS`).
- ❌ **No responsabilidad:** Modificar el estado de pedidos, pagos o inventario. Todo en este servicio es *Read-Only* respecto al resto del ecosistema.

---

## 🗄️ Diccionario de Datos

### Tabla: `reporte_snapshots`
| Campo          | Tipo SQL        | Tipo Java         | Descripción                                                              |
|----------------|-----------------|-------------------|--------------------------------------------------------------------------|
| `id`           | `BIGSERIAL`     | `Long`            | PK autoincremental del reporte generado.                                 |
| `sucursal_id`  | `BIGINT`        | `Long`            | FK lógica a `ms-sucursales`. Puede ser NULL si es un reporte global.     |
| `tipo`         | `VARCHAR(50)`   | `TipoReporte`     | Enum: VENTAS_DIARIAS, TOP_PLATOS, KARDEX_MENSUAL.                        |
| `data_json`    | `JSONB` / `TEXT`| `String`          | Payload con los datos consolidados del reporte.                          |
| `creado_en`    | `TIMESTAMP`     | `LocalDateTime`   | Fecha y hora en la que se tomó la "foto" de los datos.                   |

---

## 🔁 Flujo Técnico Interno (Scaffolding)

```
CronJob o Solicitud HTTP
        │
        ▼
┌────────────────────────┐
│   ReporteController    │  Recibe petición para ver o generar un reporte
│   /api/v1/reportes     │
└─────────┬──────────────┘
          │
          ▼
┌────────────────────────┐
│    ReporteService      │  Intención: Orquestar recolección de datos vía Feign
│  ReporteServiceImpl    │  (ms-pedidos, ms-pagos, ms-inventario), procesar y 
└─────────┬──────────────┘  guardar el resultado final en BD (Snapshot).
          │
          ▼
┌────────────────────────┐
│ReporteSnapshotRepository  Guarda el resultado precalculado para lectura rápida
└────────────────────────┘
```

### Consumidores / Dependencias (Feign)

| Relación | Microservicio     | Uso principal                                                                 |
|----------|-------------------|-------------------------------------------------------------------------------|
| Consume  | `ms-pedidos`      | Traer totales de ventas, tiempos promedios de preparación, etc.               |
| Consume  | `ms-inventario`   | Traer consolidado de mermas o costos de insumos.                              |
| Consume  | `ms-pagos`        | Traer flujos de caja efectivos vs. rechazados.                                |
