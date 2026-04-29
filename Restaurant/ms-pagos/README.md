# 💳 ms-pagos — Microservicio de Pagos

> **Puerto:** `9008` · **BD:** PostgreSQL `pagos` · **Registro:** Eureka Client  
> **Paquete raíz:** `cl.triskeledu.pagos`

---

## 🎯 Responsabilidad del Servicio

`ms-pagos` es el responsable de gestionar el ciclo de vida transaccional de un pedido.
Actúa como fachada (Facade) para comunicarse con pasarelas de pago externas (simuladas en este proyecto)
como Webpay, MercadoPago o procesar pagos en efectivo en caja.

### Límites del Dominio (Bounded Context)

- ✅ **Responsabilidad:** Registrar intentos de pago asociados a un pedido.
- ✅ **Responsabilidad:** Cambiar estados transaccionales (PENDIENTE, APROBADO, RECHAZADO).
- ✅ **Responsabilidad:** Notificar a `ms-pedidos` cuando un pago ha sido confirmado.
- ❌ **No responsabilidad:** Calcular el total a pagar (eso lo hace y envía `ms-pedidos`).
- ❌ **No responsabilidad:** Modificar el estado de preparación de la comida.

---

## 🗄️ Diccionario de Datos

### Tabla: `pagos`
| Campo            | Tipo SQL        | Tipo Java       | Descripción                                                              |
|------------------|-----------------|-----------------|--------------------------------------------------------------------------|
| `id`             | `BIGSERIAL`     | `Long`          | PK autoincremental del pago.                                             |
| `pedido_id`      | `BIGINT`        | `Long`          | FK lógica a `ms-pedidos`. Un pedido puede tener varios intentos de pago. |
| `monto`          | `DECIMAL(10,2)` | `BigDecimal`    | Monto exacto que se intentó cobrar.                                      |
| `metodo`         | `VARCHAR(20)`   | `MetodoPago`    | Enum: EFECTIVO, TARJETA_CREDITO, TARJETA_DEBITO, TRANSFERENCIA.          |
| `estado`         | `VARCHAR(20)`   | `EstadoPago`    | Enum: PENDIENTE, APROBADO, RECHAZADO, REEMBOLSADO.                       |
| `transaccion_id` | `VARCHAR(100)`  | `String`        | ID devuelto por la pasarela externa (ej. código de autorización).        |
| `creado_en`      | `TIMESTAMP`     | `LocalDateTime` | Fecha del intento de pago.                                               |
| `actualizado_en` | `TIMESTAMP`     | `LocalDateTime` | Fecha de confirmación/rechazo del pago.                                  |

---

## 🔁 Flujo Técnico Interno (Scaffolding)

```
HTTP Request
        │
        ▼
┌────────────────────────┐
│  PagoController        │  Recibe solicitud de pago para un Pedido
│  /api/v1/pagos         │
└─────────┬──────────────┘
          │
          ▼
┌────────────────────────┐
│   PagoService          │  Intención: Registrar intento en estado PENDIENTE.
│   PagoServiceImpl      │  Simular llamada a pasarela externa. Actualizar a APROBADO.
└─────────┬──────────────┘  (Notificar a ms-pedidos vía Feign que el pago fue exitoso)
          │
          ▼
┌────────────────────────┐
│  PagoRepository        │  Guarda historial de intentos y estado final en BD
└────────────────────────┘
```

### Consumidores / Dependencias (Feign)

| Relación | Microservicio     | Uso principal                                                                 |
|----------|-------------------|-------------------------------------------------------------------------------|
| Consume  | `ms-pedidos`      | Notifica asíncronamente o sincrónicamente (vía Feign) que el pedido ha sido pagado, para que pase a estado `PREPARACION`. |
| Consumido| `ms-pedidos`      | Al iniciar el checkout, `ms-pedidos` llama a `ms-pagos` para generar la intención de pago. |
