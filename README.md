# 🍽️ Restaurant Platform — Arquitectura de Microservicios

> **Stack:** Java 21 · Spring Boot 3.5 · Spring Cloud 2025 · PostgreSQL · Eureka · OpenFeign  
> **Grupo base:** `cl.triskeledu` · **Puerto Eureka:** `8761`

---

## 📐 Diagrama de Flujo — Los 12 Microservicios

```
                          ┌──────────────────────────┐
                          │      CLIENTE / FRONTEND  │
                          │  (React / Mobile / Admin)│
                          └──────────┬───────────────┘
                                     │  HTTP / REST
                          ┌──────────▼────────────────┐
                          │      API GATEWAY          │  (futuro: puerto 8080)
                          │  Enrutamiento + JWT Filter│
                          └─────┬──────────┬──────────┘
                                │          │
              ┌─────────────────┘          └─────────────────┐
              │                                              │
  ┌───────────▼──────────┐                      ┌────────────▼──────────┐
  │  ms-auth  (:9001)    │                      │  ms-usuarios (:9002)  │
  │  Login / JWT / Roles │◄────────────────────►│  CRUD Usuarios        │
  └──────────────────────┘                      └───────────────────────┘

  ┌──────────────────────┐    ┌──────────────────────┐
  │  ms-sucursales(:9003)│    │  ms-categorias(:9004) │
  │  Sucursales/Locales  │    │  Categorías de Menú   │
  └──────┬───────────────┘    └────────┬─────────────┘
         │                             │
  ┌──────▼──────────────────────────────▼───────────┐
  │              ms-menu (:9005)                    │
  │  Productos del menú · Precio · Stock referencial│
  └──────────────────┬──────────────────────────────┘
                     │
  ┌──────────────────▼─────────────────┐
  │        ms-carrito (:9006)          │
  │  Carrito temporal por usuario/mesa │
  │  Llama a ms-menu para precios      │
  └──────────────────┬─────────────────┘
                     │  (checkout → crea pedido)
  ┌──────────────────▼──────────────────────────────────────┐
  │                ms-pedidos (:9007)  ◄──── NÚCLEO ────    │
  │  Ciclo de vida completo del pedido (PENDIENTE→ENTREGADO)│
  │  Llama: ms-menu, ms-inventario, ms-pagos, ms-delivery   │
  └───────┬────────────────────┬────────────────────────────┘
          │                    │
  ┌───────▼──────────┐  ┌──────▼──────────────────┐
  │  ms-pagos(:9008) │  │  ms-delivery (:9009)    │
  │  Procesamiento   │  │  Asignación repartidor  │
  │  de pagos        │  │  y tracking             │
  └──────────────────┘  └─────────────────────────┘

  ┌──────────────────────────────────────────────────┐
  │           ms-inventario (:9010)                  │
  │  Stock físico por sucursal · Alertas de quiebre  │
  │  Consumido por ms-pedidos y ms-menu              │
  └──────────────────────────────────────────────────┘

  ┌──────────────────────────────────────────────────┐
  │         ms-notificaciones (:9011)                │
  │  Eventos de negocio → Email / Push / SMS         │
  │  Escucha cambios de estado en pedidos/pagos      │
  └──────────────────────────────────────────────────┘

  ┌──────────────────────────────────────────────────┐
  │           ms-reportes (:9012)                    │
  │  Dashboard consolidado · Métricas · KPIs         │
  │  Consulta READ-ONLY a otras BDs (o eventos)      │
  └──────────────────────────────────────────────────┘

  ┌──────────────────────────────────────────────────┐
  │         EUREKA SERVER (:8761)                    │
  │  Registro y descubrimiento de todos los servicios│
  └──────────────────────────────────────────────────┘
```

### Mapa de Puertos

| Servicio            | Puerto | Base de Datos            |
|---------------------|--------|--------------------------|
| Eureka              | 8761   | —                        |
| ms-auth             | 9001   | PostgreSQL: `auth`       |
| ms-usuarios         | 9002   | PostgreSQL: `usuarios`   |
| ms-sucursales       | 9003   | PostgreSQL: `sucursales` |
| ms-categorias       | 9004   | PostgreSQL: `categorias` |
| ms-menu             | 9005   | PostgreSQL: `menu`       |
| ms-carrito          | 9006   | PostgreSQL: `carrito`    |
| ms-pedidos          | 9007   | PostgreSQL: `pedidos`    |
| ms-pagos            | 9008   | PostgreSQL: `pagos`      |
| ms-delivery         | 9009   | PostgreSQL: `delivery`   |
| ms-inventario       | 9010   | PostgreSQL: `inventario` |
| ms-notificaciones   | 9011   | PostgreSQL: `notif`      |
| ms-reportes         | 9012   | PostgreSQL: `reportes`   |

---

## 👥 Roles del Sistema y Visibilidad en el Frontend

El sistema define 5 roles. Cada rol recibe un JWT con claim `roles`, que el frontend utiliza para condicionar la renderización de vistas y rutas.

| Rol               | Código    | Descripción                                         | Vistas habilitadas en Frontend                                                                 |
|-------------------|-----------|-----------------------------------------------------|-----------------------------------------------------------------------------------------------|
| **SUPER_ADMIN**   | `ROLE_SA` | Control total del sistema. Configura todos los MS.  | Todo: gestión de sucursales, usuarios, menú, inventario, reportes, pagos, delivery.           |
| **ADMIN**         | `ROLE_AD` | Administra su sucursal asignada.                    | Menú, carrito, pedidos, inventario de su sucursal, reportes básicos.                          |
| **COCINERO**      | `ROLE_CO` | Visualiza y actualiza pedidos en cocina.            | Vista de cola de pedidos (estado: PENDIENTE → EN_PREPARACION → LISTO).                       |
| **REPARTIDOR**    | `ROLE_RP` | Gestiona entregas asignadas.                        | Vista de deliveries asignados, cambio de estado (EN_CAMINO → ENTREGADO).                     |
| **MESERO**        | `ROLE_ME` | Atiende mesas, toma pedidos y cobra la cuenta.      | Vista de mesas, toma de pedidos presenciales, gestión de pagos/cobros.                       |
| **CLIENTE**       | `ROLE_CL` | Usuario final. Realiza pedidos desde app/web.       | Menú (lectura), carrito, historial de pedidos propios, estado de delivery, perfil propio.    |

### Impacto en el Frontend

```
Token JWT → Frontend decodifica claim "roles" → Guarda en contexto/store
     │
     ├── ROLE_SA / ROLE_AD  → Renderiza sidebar con módulos administrativos
     ├── ROLE_CO            → Renderiza pantalla de cocina (KDS — Kitchen Display)
     ├── ROLE_RP            → Renderiza pantalla de delivery
     ├── ROLE_ME            → Renderiza vista de salón (mesas + cobros)
     └── ROLE_CL            → Renderiza vista de cliente (menú + pedidos propios)
```

> **⚠️ Regla crítica:** La visibilidad en frontend es solo UX. La autorización real
> ocurre en el backend mediante `@PreAuthorize("hasRole('ROLE_AD')")` en cada endpoint.
> Nunca confiar únicamente en la lógica del frontend para proteger recursos.

---

## 🗄️ Principio: Database per Service

### ¿Qué es?

Cada microservicio posee su **propia base de datos PostgreSQL**, completamente aislada.
Ningún servicio puede conectarse directamente a la base de datos de otro servicio.

### Estructura en este proyecto

```
┌─────────────────┐   ┌─────────────────┐   ┌─────────────────┐
│   ms-pedidos    │   │    ms-pagos     │   │  ms-inventario  │
│                 │   │                 │   │                 │
│  DB: pedidos    │   │   DB: pagos     │   │  DB: inventario │
│  Puerto: 5433   │   │  Puerto: 5433   │   │  Puerto: 5433   │
│  Schema: public │   │  Schema: public │   │  Schema: public │
└────────┬────────┘   └────────┬────────┘   └────────┬────────┘
         │                     │                     │
         └─────────────────────┴─────────────────────┘
                     Comunicación SOLO vía
                    OpenFeign (HTTP / REST)
```

### ¿Por qué?

| Problema evitado                 | Explicación                                                              |
|----------------------------------|--------------------------------------------------------------------------|
| **Acoplamiento de esquema**      | Un cambio de tabla en `pagos` no afecta a `pedidos`.                     |
| **Escalabilidad independiente**  | Si los pedidos crecen, solo se escala `ms-pedidos` + su BD.             |
| **Fallos aislados**              | Si `ms-pagos` cae, los pedidos pueden seguir creándose en estado previo. |
| **Tecnología heterogénea**       | Futuro: `ms-reportes` podría usar MongoDB sin afectar al resto.          |

### ¿Cómo se comunican?

1. **OpenFeign (síncrono):** llamadas HTTP REST entre servicios. Preferir para datos críticos en tiempo real (ej: validar precio de menú al crear pedido).
2. **Eventos de dominio (asíncrono — futuro):** mensajería con Kafka/RabbitMQ. Preferir para notificaciones, reportes, y efectos secundarios no bloqueantes.

> **⚠️ Anti-patrón prohibido:** Nunca usar `@JoinTable` ni `ForeignKey` que cruce
> los límites de dos microservicios distintos. Las relaciones entre agregados de
> distintos servicios se representan únicamente como **IDs** (`Long menuItemId`).

---

## 🏗️ Estructura de Paquetes por Microservicio

```
cl.triskeledu.<servicio>/
├── controller/       # Capa REST: recibe requests, delega al service
├── service/          # Lógica de negocio: reglas, orquestación
│   └── impl/         # Implementación concreta del servicio
├── repository/       # Acceso a datos: JPA Repository + queries custom
├── entity/           # Entidades JPA: mapeo a tablas de BD
├── dto/              # Objetos de transferencia (request y response)
│   ├── request/      # DTOs de entrada (recibidos del cliente)
│   └── response/     # DTOs de salida (enviados al cliente)
├── mapper/           # MapStruct: conversión Entity ↔ DTO
├── client/           # Clientes Feign: llamadas a otros microservicios
├── exception/        # Excepciones de dominio y handler global
└── config/           # Configuraciones: Feign, Security, Beans
```

---

## 🔍 Estado de Scaffolding por Microservicio

| Microservicio        | README | Entity | DTO | Repository | Service | Controller | Mapper |
|----------------------|--------|--------|-----|------------|---------|------------|--------|
| **ms-auth**          | ✅     | ✅     | ✅  | ✅         | ✅      | ✅         | ✅     |
| **ms-usuarios**      | ✅     | ✅     | ✅  | ✅         | ✅      | ✅         | ✅     |
| **ms-sucursales**    | ✅     | ✅     | ✅  | ✅         | ✅      | ✅         | ✅     |
| **ms-categorias**    | ✅     | ✅     | ✅  | ✅         | ✅      | ✅         | ✅     |
| **ms-menu**          | ✅     | ✅     | ✅  | ✅         | ✅      | ✅         | ✅     |
| **ms-carrito**       | ✅     | ✅     | ✅  | ✅         | ✅      | ✅         | ✅     |
| **ms-pedidos**       | ✅     | ✅     | ✅  | ✅         | ✅      | ✅         | ✅     |
| **ms-pagos**         | ✅     | ✅     | ✅  | ✅         | ✅      | ✅         | ✅     |
| **ms-delivery**      | ✅     | ✅     | ✅  | ✅         | ✅      | ✅         | ✅     |
| **ms-inventario**    | ✅     | ✅     | ✅  | ✅         | ✅      | ✅         | ✅     |
| **ms-notificaciones**| ✅     | ✅     | ✅  | ✅         | ✅      | ✅         | ✅     |
| **ms-reportes**      | ✅     | ✅     | ✅  | ✅         | ✅      | ✅         | ✅     |
