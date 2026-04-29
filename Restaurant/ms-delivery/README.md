# 🛵 ms-delivery — Microservicio de Logística y Despacho

> **Puerto:** `9009` · **BD:** PostgreSQL `delivery` · **Registro:** Eureka Client  
> **Paquete raíz:** `cl.triskeledu.delivery`

---

## 🎯 Responsabilidad del Servicio

`ms-delivery` gestiona la logística de transporte de un pedido desde que está
`LISTO` en la cocina hasta que es `ENTREGADO` al cliente. Asigna a los repartidores
(ROLE_RP) y actualiza los tiempos estimados de entrega.

### Límites del Dominio (Bounded Context)

- ✅ **Responsabilidad:** Asignar pedidos listos a repartidores de una sucursal.
- ✅ **Responsabilidad:** Gestionar el ciclo del viaje (ASIGNADO, EN_CAMINO, ENTREGADO, CANCELADO).
- ✅ **Responsabilidad:** Notificar estado de ubicación (futuro).
- ❌ **No responsabilidad:** Gestionar el menú o el carrito.
- ❌ **No responsabilidad:** Calcular la preparación en cocina (eso es `ms-pedidos`).

---

## 🗄️ Diccionario de Datos

### Tabla: `deliveries`
| Campo               | Tipo SQL        | Tipo Java        | Descripción                                                              |
|---------------------|-----------------|------------------|--------------------------------------------------------------------------|
| `id`                | `BIGSERIAL`     | `Long`           | PK autoincremental de la ruta de entrega.                                |
| `pedido_id`         | `BIGINT`        | `Long`           | FK lógica a `ms-pedidos`. Un delivery pertenece a un pedido.             |
| `repartidor_id`     | `BIGINT`        | `Long`           | FK lógica al perfil en `ms-usuarios` con `ROLE_RP`.                      |
| `direccion_entrega` | `VARCHAR(300)`  | `String`         | Dirección física extraída del pedido/usuario al momento del despacho.    |
| `estado`            | `VARCHAR(20)`   | `EstadoDelivery` | Enum: BUSCANDO_REPARTIDOR, ASIGNADO, EN_CAMINO, ENTREGADO, CANCELADO.    |
| `observaciones`     | `TEXT`          | `String`         | Notas del repartidor (ej. "Nadie abrió la puerta").                      |
| `creado_en`         | `TIMESTAMP`     | `LocalDateTime`  | Fecha en que el pedido entró a la cola de despacho.                      |
| `actualizado_en`    | `TIMESTAMP`     | `LocalDateTime`  | Fecha del último cambio de estado.                                       |

---

## 🔁 Flujo Técnico Interno (Scaffolding)

```
HTTP Request
        │
        ▼
┌────────────────────────┐
│  DeliveryController    │  Recibe actualizaciones del repartidor o panel admin
│  /api/v1/delivery      │
└─────────┬──────────────┘
          │
          ▼
┌────────────────────────┐
│   DeliveryService      │  Intención: Asignar repartidor, cambiar estado.
│   DeliveryServiceImpl  │  (Notificar a ms-pedidos vía Feign que el pedido fue ENTREGADO)
└─────────┬──────────────┘
          │
          ▼
┌────────────────────────┐
│  DeliveryRepository    │  Guarda seguimiento en BD
└────────────────────────┘
```

### Consumidores / Dependencias (Feign)

| Relación | Microservicio     | Uso principal                                                                 |
|----------|-------------------|-------------------------------------------------------------------------------|
| Consume  | `ms-usuarios`     | Validar que el `repartidor_id` existe y realmente tiene el rol adecuado.      |
| Consume  | `ms-pedidos`      | Notificar (PATCH) que el pedido ya llegó al cliente (`ENTREGADO`).            |
| Consumido| `ms-pedidos`      | Al pasar un pedido a estado `LISTO`, `ms-pedidos` invoca a `ms-delivery` para buscar repartidor. |
