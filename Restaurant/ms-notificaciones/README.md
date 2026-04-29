# 🔔 ms-notificaciones — Microservicio de Alertas y Mensajería

> **Puerto:** `9011` · **BD:** PostgreSQL `notificaciones` · **Registro:** Eureka Client  
> **Paquete raíz:** `cl.triskeledu.notificaciones`

---

## 🎯 Responsabilidad del Servicio

`ms-notificaciones` es un servicio transversal encargado de enviar alertas
(Email, SMS, Push) a clientes o empleados basados en eventos ocurridos en
otros microservicios.

### Límites del Dominio (Bounded Context)

- ✅ **Responsabilidad:** Registrar el historial de notificaciones enviadas/fallidas.
- ✅ **Responsabilidad:** Integrarse con proveedores externos (ej. SendGrid, Twilio) simulados.
- ✅ **Responsabilidad:** Enviar confirmaciones de pedidos, alertas de stock bajo, etc.
- ❌ **No responsabilidad:** Tomar decisiones sobre cuándo se debe enviar la notificación (eso lo deciden los otros servicios que lo invocan).
- ❌ **No responsabilidad:** Gestionar plantillas dinámicas complejas o lógica de negocio ajena.

---

## 🗄️ Diccionario de Datos

### Tabla: `notificaciones`
| Campo          | Tipo SQL        | Tipo Java            | Descripción                                                              |
|----------------|-----------------|----------------------|--------------------------------------------------------------------------|
| `id`           | `BIGSERIAL`     | `Long`               | PK autoincremental de la notificación.                                   |
| `destinatario` | `VARCHAR(255)`  | `String`             | Email, número de teléfono o token push.                                  |
| `tipo`         | `VARCHAR(20)`   | `TipoNotificacion`   | Enum: EMAIL, SMS, PUSH.                                                  |
| `asunto`       | `VARCHAR(150)`  | `String`             | Título o asunto breve.                                                   |
| `cuerpo`       | `TEXT`          | `String`             | Contenido del mensaje.                                                   |
| `estado`       | `VARCHAR(20)`   | `EstadoNotificacion` | Enum: PENDIENTE, ENVIADO, FALLIDO.                                       |
| `creado_en`    | `TIMESTAMP`     | `LocalDateTime`      | Fecha de creación.                                                       |

---

## 🔁 Flujo Técnico Interno (Scaffolding)

```
HTTP Request o Evento (Kafka/RabbitMQ en futuro)
        │
        ▼
┌────────────────────────┐
│ NotificacionController │  Recibe solicitud de envío desde otro MS
│ /api/v1/notificaciones │
└─────────┬──────────────┘
          │
          ▼
┌────────────────────────┐
│ NotificacionService    │  Intención: Registrar notificación en BD como PENDIENTE.
│ NotificacionServiceImpl│  Intentar envío a través de pasarela externa simulada.
└─────────┬──────────────┘  Actualizar estado a ENVIADO o FALLIDO.
          │
          ▼
┌────────────────────────┐
│ NotificacionRepository │  Guarda historial para auditoría
└────────────────────────┘
```

### Consumidores / Dependencias

| Relación | Microservicio     | Uso principal                                                                 |
|----------|-------------------|-------------------------------------------------------------------------------|
| Consumido| `ms-pagos`        | Para enviar recibo de pago exitoso al cliente.                                |
| Consumido| `ms-delivery`     | Para avisar al cliente que su pedido está en camino.                          |
| Consumido| `ms-inventario`   | Para alertar a administradores sobre stock bajo.                              |
