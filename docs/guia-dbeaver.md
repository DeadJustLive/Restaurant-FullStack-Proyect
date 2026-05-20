# 🗄️ Guía DBeaver — Conexión a las Bases de Datos

## 📋 Datos Generales del Servidor

| Parámetro | Valor |
|-----------|-------|
| **Host** | `localhost` |
| **Puerto** | `5433` (mapea al 5432 interno del contenedor) |
| **Usuario** | `postgres` |
| **Contraseña** | `123` |
| **Driver** | PostgreSQL |
| **Contenedor** | `restaurant-postgres` (Docker, imagen `postgres:15-alpine`) |

> [!IMPORTANT]
> PostgreSQL corre dentro de Docker. Asegúrate de que el contenedor esté corriendo antes de conectarte:
> ```bash
> docker start restaurant-postgres
> ```
> O si usas el script de inicio:
> ```bash
> cd Restaurant && bash start.sh
> ```

---

## 🔌 Conexión Base (postgres)

Esta conexión te da acceso al servidor completo para administrar todas las bases de datos.

### Pasos en DBeaver

1. **Abrir DBeaver** → `Database` → `New Database Connection`
2. **Seleccionar** → `PostgreSQL` → `Next`
3. **Configurar conexión:**

   | Campo | Valor |
   |-------|-------|
   | **Host** | `localhost` |
   | **Port** | `5433` |
   | **Database** | `postgres` (base administrativa por defecto) |
   | **Username** | `postgres` |
   | **Password** | `123` |

4. **Pestaña `Driver properties`** → Verificar:
   - `PGHOST` → `localhost`
   - `PGPORT` → `5433`

5. **Test Connection** → `Finish`

> ✅ Desde esta conexión puedes ver TODAS las bases de datos del sistema.

---

## 🗃️ Las 10 Bases de Datos del Ecosistema

Cada microservicio tiene su propia base de datos PostgreSQL independiente (patrón *Database per Service*).

| # | Base de Datos | Microservicio | Puerto MS | Propósito |
|---|---------------|---------------|-----------|-----------|
| 1 | `auth` | `ms-auth` | `9001` | Credenciales, usuarios y autenticación JWT |
| 2 | `sucursales` | `ms-sucursales` | `9003` | Catálogo de sucursales/locales |
| 3 | `menu` | `ms-menu` | `9004` | Items del menú y categorías |
| 4 | `carrito` | `ms-carrito` | `9006` | Carritos de compra temporales |
| 5 | `pedidos` | `ms-pedidos` | `9007` | Pedidos confirmados y mesas |
| 6 | `pagos` | `ms-pagos` | `9008` | Transacciones y estados de pago |
| 7 | `delivery` | `ms-delivery` | `9009` | Logística de entregas y repartidores |
| 8 | `inventario` | `ms-inventario` | `9010` | Insumos, stock y movimientos (kardex) |
| 9 | `notificaciones` | `ms-notificaciones` | `9011` | Historial de notificaciones enviadas |
| 10 | `reportes` | `ms-reportes` | `9012` | Snapshots de reportes analíticos |

---

## 🔗 Conexiones Individuales (Opcional)

Si prefieres tener conexiones separadas por base de datos (útil para filtrar tablas), crea una conexión por cada una repitiendo los pasos anteriores pero cambiando el campo **Database**:

```
jdbc:postgresql://localhost:5433/auth
jdbc:postgresql://localhost:5433/sucursales
jdbc:postgresql://localhost:5433/menu
jdbc:postgresql://localhost:5433/carrito
jdbc:postgresql://localhost:5433/pedidos
jdbc:postgresql://localhost:5433/pagos
jdbc:postgresql://localhost:5433/delivery
jdbc:postgresql://localhost:5433/inventario
jdbc:postgresql://localhost:5433/notificaciones
jdbc:postgresql://localhost:5433/reportes
```

---

## 📊 Esquemas y Tablas por Base de Datos

### `auth` — Autenticación y Usuarios
| Tabla | Tipo | Descripción |
|-------|------|-------------|
| `user_credentials` | Propia | Login, password hash (BCrypt), rol, activo |
| `usuarios` | Propia | Perfiles: nombre, apellido, teléfono, dirección |

### `sucursales` — Locales
| Tabla | Tipo | Descripción |
|-------|------|-------------|
| `sucursales` | Propia | Nombre, dirección, teléfono, activa |

### `menu` — Menú y Categorías
| Tabla | Tipo | Descripción |
|-------|------|-------------|
| `menu_items` | Propia | Items del menú con precio y stock |
| `categorias` | Propia | Categorías de items |
| `proyeccion_sucursales` | Proyección CQRS | Copia local de sucursales vía Kafka |

### `carrito` — Carritos
| Tabla | Tipo | Descripción |
|-------|------|-------------|
| `carritos` | Propia | Carrito por usuario + sucursal |
| `carrito_items` | Propia | Items con cantidad y precio unitario |
| `proyeccion_clientes` | Proyección CQRS | Clientes sincronizados vía Kafka |
| `proyeccion_menu_items` | Proyección CQRS | Items del menú sincronizados vía Kafka |

### `pedidos` — Pedidos y Mesas
| Tabla | Tipo | Descripción |
|-------|------|-------------|
| `pedidos` | Propia | Pedidos con estado, total, sucursal |
| `pedido_items` | Propia | Items de cada pedido |
| `mesas` | Propia | Mesas con número, capacidad y estado |
| `proyeccion_clientes` | Proyección CQRS | Clientes vía Kafka |
| `proyeccion_sucursales` | Proyección CQRS | Sucursales vía Kafka |
| `proyeccion_menu_items` | Proyección CQRS | Items del menú vía Kafka |

### `pagos` — Transacciones
| Tabla | Tipo | Descripción |
|-------|------|-------------|
| `pagos` | Propia | Pagos con estado, método, monto |
| `proyeccion_pedidos` | Proyección CQRS | Pedidos vía Kafka |

### `delivery` — Entregas
| Tabla | Tipo | Descripción |
|-------|------|-------------|
| `deliveries` | Propia | Deliveries con estado, repartidor |
| `proyeccion_usuarios` | Proyección CQRS | Usuarios vía Kafka |
| `proyeccion_pedidos` | Proyección CQRS | Pedidos vía Kafka |

### `inventario` — Stock
| Tabla | Tipo | Descripción |
|-------|------|-------------|
| `insumos` | Propia | Insumos con stock actual y mínimo |
| `movimientos_inventario` | Propia | Kardex: cada entrada/salida con detalle |

### `notificaciones` — Alertas
| Tabla | Tipo | Descripción |
|-------|------|-------------|
| `notificaciones` | Propia | Notificaciones con tipo, estado, destinatario |
| `proyeccion_clientes` | Proyección CQRS | Clientes vía Kafka |

### `reportes` — Analytics
| Tabla | Tipo | Descripción |
|-------|------|-------------|
| `reporte_snapshots` | Propia | Reportes generados con datos JSON |

---

## 🐳 Comandos Docker Útiles

```bash
# Iniciar PostgreSQL
docker start restaurant-postgres

# Ver logs
docker logs restaurant-postgres -f

# Acceder a la consola de PostgreSQL dentro del contenedor
docker exec -it restaurant-postgres psql -U postgres

# Listar bases de datos (dentro de psql)
\l

# Conectarse a una base específica (dentro de psql)
\c auth

# Ver tablas (dentro de psql)
\dt
```

## ℹ️ Notas Técnicas

- **Pool de conexiones:** Cada microservicio usa HikariCP con `maximum-pool-size: 3` para desarrollo local. DBeaver abre conexiones administrativas que NO compiten con este pool.
- **ddl-auto: update** — Hibernate crea/actualiza las tablas automáticamente al iniciar cada microservicio. Las tablas existen aunque no se hayan ejecutado los scripts SQL de seed.
- **Proyecciones CQRS:** Las tablas con prefijo `proyeccion_*` se llenan automáticamente vía Kafka cuando los microservicios origen emiten eventos. No se modifican manualmente.
- **Soft Delete:** Las tablas usan flags booleanos (`activo`, `activa`) en vez de borrado físico. Las consultas deben filtrar por `WHERE activo = true`.
