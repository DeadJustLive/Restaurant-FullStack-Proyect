# 🛒 ms-carrito — Microservicio de Carrito de Compras

> **Puerto:** `9006` · **BD:** PostgreSQL `carrito` · **Registro:** Eureka Client  
> **Paquete raíz:** `cl.triskeledu.carrito`

---

## 🎯 Responsabilidad del Servicio

`ms-carrito` gestiona el estado temporal de los ítems que un cliente o cajero
desea comprar antes de consolidarlos en un pedido definitivo (`ms-pedidos`).

### Límites del Dominio (Bounded Context)

- ✅ **Responsabilidad:** Almacenar el carrito temporal (sesión/usuario).
- ✅ **Responsabilidad:** Agregar, modificar cantidad o remover ítems.
- ✅ **Responsabilidad:** Calcular subtotales y total temporal (delegando validación de precios a `ms-menu`).
- ❌ **No responsabilidad:** Procesar el pago (eso es `ms-pagos`).
- ❌ **No responsabilidad:** Gestionar el ciclo de vida de preparación en cocina (eso es `ms-pedidos`).

---

## 🗄️ Diccionario de Datos

### Tabla: `carritos`
| Campo           | Tipo SQL        | Tipo Java       | Descripción                                                              |
|-----------------|-----------------|-----------------|--------------------------------------------------------------------------|
| `id`            | `BIGSERIAL`     | `Long`          | PK autoincremental del carrito.                                          |
| `usuario_id`    | `BIGINT`        | `Long`          | FK lógica al ID del perfil en `ms-usuarios` (dueño del carrito).         |
| `sucursal_id`   | `BIGINT`        | `Long`          | FK lógica a `ms-sucursales`. El carrito siempre está atado a una sucursal. |
| `total`         | `DECIMAL(10,2)` | `BigDecimal`    | Suma temporal de los ítems.                                              |
| `creado_en`     | `TIMESTAMP`     | `LocalDateTime` | Fecha de creación.                                                       |
| `actualizado_en`| `TIMESTAMP`     | `LocalDateTime` | Fecha de última modificación (para limpiar carritos abandonados).        |

### Tabla: `carrito_items`
| Campo            | Tipo SQL        | Tipo Java       | Descripción                                                              |
|------------------|-----------------|-----------------|--------------------------------------------------------------------------|
| `id`             | `BIGSERIAL`     | `Long`          | PK del ítem.                                                             |
| `carrito_id`     | `BIGINT`        | `Long`          | FK a la tabla `carritos` (owner).                                        |
| `menu_item_id`   | `BIGINT`        | `Long`          | FK lógica a `ms-menu`.                                                   |
| `precio_unitario`| `DECIMAL(10,2)` | `BigDecimal`    | Snapshot del precio en el momento de agregarlo.                          |
| `cantidad`       | `INTEGER`       | `Integer`       | Cantidad del ítem.                                                       |
| `subtotal`       | `DECIMAL(10,2)` | `BigDecimal`    | `precio_unitario` * `cantidad`.                                          |

---

## 🔁 Flujo Técnico Interno (Scaffolding)

```
HTTP Request
        │
        ▼
┌────────────────────────┐
│  CarritoController     │  Recibe solicitudes (agregar ítem, ver carrito)
│  /api/v1/carrito       │
└─────────┬──────────────┘
          │ (Delega)
          ▼
┌────────────────────────┐
│   CarritoService       │  Intención: Orquestar actualización de precios
│   CarritoServiceImpl   │  (Valida en ms-menu y ms-sucursales vía Feign)
└─────────┬──────────────┘
          │
          ▼
┌────────────────────────┐
│  CarritoRepository     │  Guarda/Actualiza estado temporal en PostgreSQL
└────────────────────────┘
```

### Consumidores / Dependencias (Feign)

| Relación | Microservicio     | Uso principal                                                                 |
|----------|-------------------|-------------------------------------------------------------------------------|
| Consume  | `ms-menu`         | Obtener precio real y disponibilidad del ítem antes de agregarlo al carrito.  |
| Consume  | `ms-sucursales`   | Validar que la sucursal está activa para operar.                              |
| Consumido| `ms-pedidos`      | Al hacer checkout, `ms-pedidos` lee el carrito para convertirlo en un Pedido. |
