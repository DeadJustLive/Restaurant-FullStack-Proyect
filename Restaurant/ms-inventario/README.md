# 📦 ms-inventario — Microservicio de Inventario

> **Puerto:** `9010` · **BD:** PostgreSQL `inventario` · **Registro:** Eureka Client  
> **Paquete raíz:** `cl.triskeledu.inventario`

---

## 🎯 Responsabilidad del Servicio

`ms-inventario` es el corazón del control de stock de la cadena de restaurantes.
Gestiona el inventario de insumos (materias primas) y sus movimientos de entrada (compras) y salida (consumo).

### Límites del Dominio (Bounded Context)

- ✅ **Responsabilidad:** Mantener el stock actualizado por cada sucursal.
- ✅ **Responsabilidad:** Registrar historial inmutable de movimientos (kardex).
- ✅ **Responsabilidad:** Alertar de stock bajo (futuro, mediante `ms-notificaciones`).
- ❌ **No responsabilidad:** Gestionar las ventas o pedidos de clientes.
- ❌ **No responsabilidad:** Calcular precios de venta al público (eso es `ms-menu`).

---

## 🗄️ Diccionario de Datos

### Tabla: `insumos`
| Campo           | Tipo SQL        | Tipo Java       | Descripción                                                              |
|-----------------|-----------------|-----------------|--------------------------------------------------------------------------|
| `id`            | `BIGSERIAL`     | `Long`          | PK autoincremental del insumo.                                           |
| `sucursal_id`   | `BIGINT`        | `Long`          | FK lógica a `ms-sucursales`. El stock es local por sucursal.             |
| `nombre`        | `VARCHAR(100)`  | `String`        | Nombre del insumo (ej. "Harina de trigo").                               |
| `unidad_medida` | `VARCHAR(20)`   | `String`        | Ej. "KG", "LTS", "UNIDAD".                                               |
| `stock_actual`  | `DECIMAL(10,3)` | `BigDecimal`    | Cantidad física disponible.                                              |
| `stock_minimo`  | `DECIMAL(10,3)` | `BigDecimal`    | Umbral para alertas de reabastecimiento.                                 |
| `creado_en`     | `TIMESTAMP`     | `LocalDateTime` | Fecha de registro.                                                       |

### Tabla: `movimientos_inventario`
| Campo           | Tipo SQL        | Tipo Java       | Descripción                                                              |
|-----------------|-----------------|-----------------|--------------------------------------------------------------------------|
| `id`            | `BIGSERIAL`     | `Long`          | PK del movimiento (Kardex).                                              |
| `insumo_id`     | `BIGINT`        | `Long`          | FK a la tabla `insumos`.                                                 |
| `tipo`          | `VARCHAR(20)`   | `TipoMovimiento`| Enum: ENTRADA (compra, ajuste), SALIDA (consumo en pedido, merma).       |
| `cantidad`      | `DECIMAL(10,3)` | `BigDecimal`    | Cantidad afectada en este movimiento.                                    |
| `referencia`    | `VARCHAR(255)`  | `String`        | Motivo o ID relacionado (ej. "Pedido #105", "Merma por vencimiento").    |
| `creado_en`     | `TIMESTAMP`     | `LocalDateTime` | Fecha del movimiento (inmutable).                                        |

---

## 🔁 Flujo Técnico Interno (Scaffolding)

```
HTTP Request o Evento Asíncrono
        │
        ▼
┌────────────────────────┐
│  InventarioController  │  Endpoints para CRUD de insumos y registrar mermas
│  /api/v1/inventario    │
└─────────┬──────────────┘
          │
          ▼
┌────────────────────────┐
│   InventarioService    │  Intención: Crear insumos, registrar movimientos.
│   InventarioServiceImpl│  (Valida sucursales, actualiza stock in-place y registra en Kardex)
└─────────┬──────────────┘
          │
          ▼
┌────────────────────────┐
│  InsumoRepository      │  Modifica stock_actual
│  MovimientoRepository  │  Guarda el histórico (insert-only)
└────────────────────────┘
```

### Consumidores / Dependencias (Feign)

| Relación | Microservicio     | Uso principal                                                                 |
|----------|-------------------|-------------------------------------------------------------------------------|
| Consume  | `ms-sucursales`   | Validar que la sucursal existe al crear un nuevo insumo.                      |
| Consumido| `ms-pedidos`      | Al pasar un pedido a estado `LISTO` o `PREPARACION`, notifica (vía REST o Kafka en un futuro) a `ms-inventario` para descontar insumos (salida por consumo). |
