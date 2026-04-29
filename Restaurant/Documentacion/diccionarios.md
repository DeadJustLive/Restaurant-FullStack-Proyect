# 🗄️ Diccionarios de Datos Centralizados

Este documento consolida las estructuras de las bases de datos de los 12 microservicios del ecosistema `Restaurant`. Cada microservicio posee su propia base de datos física (PostgreSQL) siguiendo el principio "Database per Service".

---

## 1. `ms-auth` (BD: auth_db)

### Tabla: `user_credentials`
| Campo      | Tipo SQL | Tipo Java | Descripción |
|------------|----------|-----------|-------------|
| `id`       | `BIGSERIAL` | `Long` | PK autoincremental de la credencial. |
| `username` | `VARCHAR(150)` | `String` | Correo electrónico o identificador único para login. |
| `password` | `VARCHAR(255)` | `String` | Contraseña hasheada (BCrypt). |
| `rol`      | `VARCHAR(20)` | `RolUsuario` | Enum: ROLE_AD (Admin), ROLE_SA (SuperAdmin), ROLE_CL (Cliente), ROLE_RP (Repartidor), ROLE_CG (Cajero). |
| `activo`   | `BOOLEAN` | `Boolean` | Flag para suspender/reactivar cuentas (soft delete). |

---

## 2. `ms-usuarios` (BD: usuarios_db)

### Tabla: `usuarios`
| Campo          | Tipo SQL | Tipo Java | Descripción |
|----------------|----------|-----------|-------------|
| `id`           | `BIGSERIAL` | `Long` | PK autoincremental del perfil. |
| `credencial_id`| `BIGINT` | `Long` | FK lógica a `ms-auth.user_credentials.id` (Unique). |
| `sucursal_id`  | `BIGINT` | `Long` | FK lógica a `ms-sucursales` (Solo para empleados). |
| `nombre`       | `VARCHAR(100)` | `String` | Nombre de pila. |
| `apellido`     | `VARCHAR(100)` | `String` | Apellido. |
| `telefono`     | `VARCHAR(20)` | `String` | Número de contacto. |
| `direccion`    | `VARCHAR(255)` | `String` | Dirección física principal (útil para clientes). |
| `activo`       | `BOOLEAN` | `Boolean` | Flag para ocultar perfiles eliminados. |

---

## 3. `ms-sucursales` (BD: sucursales_db)

### Tabla: `sucursales`
| Campo      | Tipo SQL | Tipo Java | Descripción |
|------------|----------|-----------|-------------|
| `id`       | `BIGSERIAL` | `Long` | PK autoincremental de la sucursal. |
| `nombre`   | `VARCHAR(150)` | `String` | Nombre comercial del local. |
| `direccion`| `VARCHAR(255)` | `String` | Ubicación física exacta. |
| `telefono` | `VARCHAR(20)` | `String` | Teléfono de contacto del local. |
| `activa`   | `BOOLEAN` | `Boolean` | Flag que indica si la sucursal está operativa (true) o cerrada/eliminada (false). |

---

## 4. `ms-categorias` (BD: categorias_db)

### Tabla: `categorias`
| Campo         | Tipo SQL | Tipo Java | Descripción |
|---------------|----------|-----------|-------------|
| `id`          | `BIGSERIAL` | `Long` | PK autoincremental. |
| `nombre`      | `VARCHAR(100)` | `String` | Nombre único de la categoría (ej. "Pizzas", "Bebidas"). |
| `descripcion` | `VARCHAR(255)` | `String` | Descripción comercial u operativa. |
| `activa`      | `BOOLEAN` | `Boolean` | Flag para mostrar u ocultar la categoría del menú público. |

---

## 5. `ms-menu` (BD: menu)

### Tabla: `menu_items`
| Campo          | Tipo SQL | Tipo Java | Descripción |
|----------------|----------|-----------|-------------|
| `id`           | `BIGSERIAL` | `Long` | PK autoincremental. |
| `sucursal_id`  | `BIGINT` | `Long` | FK lógica a `ms-sucursales`. NULL si el ítem es global a la cadena. |
| `categoria_id` | `BIGINT` | `Long` | FK lógica a `ms-categorias`. |
| `nombre`       | `VARCHAR(150)` | `String` | Nombre del plato o producto. |
| `descripcion`  | `TEXT` | `String` | Detalle, ingredientes o notas. |
| `precio`       | `DECIMAL(10,2)`| `BigDecimal` | Precio de venta al público. |
| `imagen_url`   | `VARCHAR(500)` | `String` | URL de la foto principal. |
| `disponible`   | `BOOLEAN` | `Boolean` | Flag para pausar ventas si no hay insumos (true/false). |
| `activo`       | `BOOLEAN` | `Boolean` | Soft delete del ítem. |

---

## 6. `ms-carrito` (BD: carrito)

### Tabla: `carritos`
| Campo          | Tipo SQL | Tipo Java | Descripción |
|----------------|----------|-----------|-------------|
| `id`           | `BIGSERIAL` | `Long` | PK autoincremental. |
| `usuario_id`   | `BIGINT` | `Long` | FK lógica a `ms-usuarios` (cliente dueño del carrito). |
| `sucursal_id`  | `BIGINT` | `Long` | FK lógica a `ms-sucursales`. El carrito ata al cliente a pedir en un local específico. |
| `total`        | `DECIMAL(10,2)`| `BigDecimal` | Suma de subtotales de los ítems en el carrito. |

### Tabla: `carrito_items`
| Campo             | Tipo SQL | Tipo Java | Descripción |
|-------------------|----------|-----------|-------------|
| `id`              | `BIGSERIAL` | `Long` | PK del ítem en carrito. |
| `carrito_id`      | `BIGINT` | `Long` | FK a `carritos`. |
| `menu_item_id`    | `BIGINT` | `Long` | FK lógica a `ms-menu`. |
| `precio_unitario` | `DECIMAL(10,2)`| `BigDecimal` | Snapshot del precio al momento de agregarlo. |
| `cantidad`        | `INTEGER` | `Integer` | Unidades deseadas. |
| `subtotal`        | `DECIMAL(10,2)`| `BigDecimal` | precio * cantidad. |

---

## 7. `ms-pedidos` (BD: pedidos_db)

### Tabla: `pedidos`
| Campo          | Tipo SQL | Tipo Java | Descripción |
|----------------|----------|-----------|-------------|
| `id`           | `BIGSERIAL` | `Long` | PK autoincremental. |
| `numero_pedido`| `VARCHAR(50)` | `String` | Identificador humano (ej. "ORD-10023"). |
| `usuario_id`   | `BIGINT` | `Long` | FK lógica a `ms-usuarios` (cliente que ordenó). |
| `sucursal_id`  | `BIGINT` | `Long` | FK lógica a `ms-sucursales`. |
| `estado`       | `VARCHAR(20)` | `EstadoPedido` | Enum: PENDIENTE, PREPARACION, LISTO, ENTREGADO, CANCELADO. |
| `tipo`         | `VARCHAR(20)` | `TipoPedido` | Enum: LOCAL, RETIRO, DELIVERY. |
| `total`        | `DECIMAL(10,2)`| `BigDecimal` | Total a pagar consolidado. |
| `notas`        | `TEXT` | `String` | Instrucciones especiales del cliente. |

### Tabla: `pedido_items`
| Campo             | Tipo SQL | Tipo Java | Descripción |
|-------------------|----------|-----------|-------------|
| `id`              | `BIGSERIAL` | `Long` | PK del ítem. |
| `pedido_id`       | `BIGINT` | `Long` | FK a `pedidos`. |
| `menu_item_id`    | `BIGINT` | `Long` | FK lógica a `ms-menu`. |
| `nombre_snapshot` | `VARCHAR(150)` | `String` | Nombre del plato copiado estáticamente para el histórico. |
| `precio_unitario` | `DECIMAL(10,2)`| `BigDecimal` | Precio congelado en la venta. |
| `cantidad`        | `INTEGER` | `Integer` | Unidades compradas. |
| `subtotal`        | `DECIMAL(10,2)`| `BigDecimal` | precio * cantidad. |

---

## 8. `ms-pagos` (BD: pagos)

### Tabla: `pagos`
| Campo          | Tipo SQL | Tipo Java | Descripción |
|----------------|----------|-----------|-------------|
| `id`           | `BIGSERIAL` | `Long` | PK del intento de pago. |
| `pedido_id`    | `BIGINT` | `Long` | FK lógica a `ms-pedidos`. |
| `monto`        | `DECIMAL(10,2)`| `BigDecimal` | Monto procesado. |
| `metodo`       | `VARCHAR(20)` | `MetodoPago` | Enum: EFECTIVO, TARJETA_CREDITO, TARJETA_DEBITO, TRANSFERENCIA. |
| `estado`       | `VARCHAR(20)` | `EstadoPago` | Enum: PENDIENTE, APROBADO, RECHAZADO, REEMBOLSADO. |
| `transaccion_id`| `VARCHAR(100)`| `String` | Código emitido por pasarela externa (ej. Webpay). |

---

## 9. `ms-delivery` (BD: delivery)

### Tabla: `deliveries`
| Campo             | Tipo SQL | Tipo Java | Descripción |
|-------------------|----------|-----------|-------------|
| `id`              | `BIGSERIAL` | `Long` | PK de la ruta de entrega. |
| `pedido_id`       | `BIGINT` | `Long` | FK lógica a `ms-pedidos` (Unique). |
| `repartidor_id`   | `BIGINT` | `Long` | FK lógica a `ms-usuarios` (ROLE_RP). |
| `direccion_entrega`| `VARCHAR(300)`| `String` | Destino final del paquete. |
| `estado`          | `VARCHAR(20)` | `EstadoDelivery` | Enum: BUSCANDO_REPARTIDOR, ASIGNADO, EN_CAMINO, ENTREGADO, CANCELADO. |
| `observaciones`   | `TEXT` | `String` | Notas del motorista. |

---

## 10. `ms-inventario` (BD: inventario)

### Tabla: `insumos`
| Campo          | Tipo SQL | Tipo Java | Descripción |
|----------------|----------|-----------|-------------|
| `id`           | `BIGSERIAL` | `Long` | PK del insumo. |
| `sucursal_id`  | `BIGINT` | `Long` | FK lógica a `ms-sucursales`. |
| `nombre`       | `VARCHAR(100)` | `String` | Ej. "Harina". (Unique por sucursal). |
| `unidad_medida`| `VARCHAR(20)` | `String` | Ej. "KG", "LTS". |
| `stock_actual` | `DECIMAL(10,3)`| `BigDecimal` | Disponibilidad física calculada. |
| `stock_minimo` | `DECIMAL(10,3)`| `BigDecimal` | Umbral para alertas. |

### Tabla: `movimientos_inventario`
| Campo        | Tipo SQL | Tipo Java | Descripción |
|--------------|----------|-----------|-------------|
| `id`         | `BIGSERIAL` | `Long` | PK del movimiento. |
| `insumo_id`  | `BIGINT` | `Long` | FK a `insumos`. |
| `tipo`       | `VARCHAR(20)` | `TipoMovimiento` | Enum: ENTRADA, SALIDA. |
| `cantidad`   | `DECIMAL(10,3)`| `BigDecimal` | Magnitud afectada. |
| `referencia` | `VARCHAR(255)` | `String` | Motivo (ej. "Merma", "Pedido #123"). |

---

## 11. `ms-notificaciones` (BD: notificaciones)

### Tabla: `notificaciones`
| Campo          | Tipo SQL | Tipo Java | Descripción |
|----------------|----------|-----------|-------------|
| `id`           | `BIGSERIAL` | `Long` | PK de la alerta. |
| `destinatario` | `VARCHAR(255)` | `String` | Email o Teléfono. |
| `tipo`         | `VARCHAR(20)` | `TipoNotificacion` | Enum: EMAIL, SMS, PUSH. |
| `asunto`       | `VARCHAR(150)` | `String` | Título corto. |
| `cuerpo`       | `TEXT` | `String` | Contenido del mensaje. |
| `estado`       | `VARCHAR(20)` | `EstadoNotificacion` | Enum: PENDIENTE, ENVIADO, FALLIDO. |

---

## 12. `ms-reportes` (BD: reportes)

### Tabla: `reporte_snapshots`
| Campo         | Tipo SQL | Tipo Java | Descripción |
|---------------|----------|-----------|-------------|
| `id`          | `BIGSERIAL` | `Long` | PK del snapshot. |
| `sucursal_id` | `BIGINT` | `Long` | FK lógica a `ms-sucursales` (opcional). |
| `tipo`        | `VARCHAR(50)` | `TipoReporte` | Enum: VENTAS_DIARIAS, TOP_PLATOS, etc. |
| `data_json`   | `TEXT` | `String` | Resultado final del reporte (Datawarehouse ligero). |
