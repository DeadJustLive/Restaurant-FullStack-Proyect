# Presentación: Arquitectura de Microservicios Restaurant

> **Objetivo:** Guion estructurado para video de defensa técnica (~12-14 minutos)
> **Fórmula:** Definición → Función → Implementación → Flujo → Justificación → Evidencia

---

## 1. Introducción del Proyecto (1 min)

### Problema que resuelve

Un restaurante con múltiples sucursales necesita gestionar: menú, pedidos, pagos, delivery, inventario, notificaciones y reportes. Un sistema monolítico no escala por sucursal, dificulta el despliegue independiente y acopla dominios de negocio que deberían evolucionar por separado.

### Contexto del restaurante

- 4 sucursales (3 activas, 1 cerrada)
- 6 roles de usuario: Super Admin, Admin, Cocinero, Mesero, Repartidor, Cliente
- Operaciones: menú digital, carrito de compras, pedidos (delivery/en local), pagos, tracking de delivery, control de inventario, notificaciones y reportes

### **Guion (lo que dices):**

> "Este proyecto resuelve la gestión integral de un restaurante con múltiples sucursales. En lugar de un monolito, implementé una arquitectura de microservicios donde cada dominio de negocio —autenticación, menú, pedidos, pagos, delivery, inventario, notificaciones y reportes— es un servicio independiente con su propia base de datos. Esto permite escalar por dominio, desplegar sin afectar otros servicios, y usar el patrón de comunicación más adecuado para cada interacción: síncrono con Feign o asíncrono con Kafka."

---

## 2. Arquitectura General (2 min)

### Diagrama de alto nivel

```mermaid
graph TB
    subgraph Frontend["Frontend - React + Vite"]
        FE["React App<br/>Puerto 3001"]
    end

    subgraph Infra["Infraestructura"]
        Eureka["Eureka Server<br/>Puerto 8761<br/>Service Discovery"]
        Kafka["Apache Kafka<br/>Puerto 9092<br/>Mensajería Asíncrona"]
        PG[("PostgreSQL<br/>Puerto 5433<br/>10 Bases de Datos")]
    end

    subgraph Core["Microservicios Core"]
        Auth["ms-auth :9001<br/>Autenticación JWT<br/>Gestión Usuarios"]
        Suc["ms-sucursales :9003<br/>CRUD Sucursales"]
        Menu["ms-menu :9004<br/>Menú y Categorías"]
    end

    subgraph Business["Microservicios de Negocio"]
        Cart["ms-carrito :9006<br/>Carrito Compras"]
        Ped["ms-pedidos :9007<br/>Ciclo de Vida Pedidos"]
        Pag["ms-pagos :9008<br/>Procesamiento Pagos"]
        Del["ms-delivery :9009<br/>Entregas Domicilio"]
    end

    subgraph Support["Microservicios de Soporte"]
        Inv["ms-inventario :9010<br/>Stock y Kardex"]
        Not["ms-notificaciones :9011<br/>Email/SMS/Push"]
        Rep["ms-reportes :9012<br/>Reportes Consolidados"]
    end

    FE --> Auth
    FE --> Suc
    FE --> Menu
    FE --> Cart
    FE --> Ped
    FE --> Pag
    FE --> Del
    FE --> Inv
    FE --> Not
    FE --> Rep

    Auth --> Eureka
    Suc --> Eureka
    Menu --> Eureka
    Cart --> Eureka
    Ped --> Eureka
    Pag --> Eureka
    Del --> Eureka
    Inv --> Eureka
    Not --> Eureka
    Rep --> Eureka

    Auth --> PG
    Suc --> PG
    Menu --> PG
    Cart --> PG
    Ped --> PG
    Pag --> PG
    Del --> PG
    Inv --> PG
    Not --> PG
    Rep --> PG

    Auth --> Kafka
    Suc --> Kafka
    Menu --> Kafka
    Ped --> Kafka
    Pag --> Kafka
    Del --> Kafka
    Inv --> Kafka
    Kafka --> Menu
    Kafka --> Cart
    Kafka --> Ped
    Kafka --> Pag
    Kafka --> Del
    Kafka --> Inv
    Kafka --> Not
    Kafka --> Rep
```

### **Guion:**

> "Esta es la arquitectura general. Tenemos 10 microservicios Java 21 con Spring Boot 3.5, cada uno con su propia base de datos PostgreSQL — esto es el patrón Database per Service. Todos se registran en Eureka para descubrimiento de servicios. La comunicación entre ellos usa dos patrones: Feign para llamadas síncronas —cuando necesito respuesta inmediata— y Kafka para eventos asíncronos —cuando múltiples servicios deben reaccionar sin bloquear al productor."

---

## 3. ¿Por qué Microservicios? (1 min)

### Ventajas de esta arquitectura

| Ventaja | Evidencia en el proyecto |
|---|---|
| **Escalabilidad independiente** | ms-pedidos puede escalar en hora punta sin tocar ms-menu ni ms-auth |
| **Despliegue autónomo** | Un cambio en ms-inventario no requiere redesplegar todo el sistema |
| **Aislamiento de fallos** | Si ms-notificaciones cae, los pedidos se siguen creando |
| **Tecnología adecuada por dominio** | ms-auth usa Spring Security; ms-pedidos usa Kafka; cada uno solo depende de lo que necesita |
| **Database per Service** | Cada MS tiene su BD aislada — no hay FK entre bases de datos |
| **Equipos autónomos** | Cada microservicio puede ser desarrollado por una persona distinta |

### **Guion:**

> "Elegí microservicios por cinco razones. Primero, escalabilidad: si hay 100 pedidos simultáneos, solo escalo ms-pedidos, no todo el sistema. Segundo, despliegue independiente: puedo actualizar ms-menu sin tumbar los pagos. Tercero, aislamiento de fallos: si las notificaciones fallan, los pedidos se siguen procesando. Cuarto, cada servicio usa solo las dependencias que necesita. Y quinto, cada microservicio tiene su propia base de datos —esto es clave: no hay foreign keys entre bases de datos de distintos servicios."

---

## 4. Comunicación Síncrona: Feign (1.5 min)

### Diagrama de llamadas Feign

```mermaid
graph LR
    subgraph "Llamadas Síncronas (Feign)"
        Suc["ms-sucursales"] -->|"AuthFeignClient<br/>validarAcceso()"| Auth["ms-auth"]
        Menu["ms-menu"] -->|"AuthFeignClient"| Auth
        Cart["ms-carrito"] -->|"AuthFeignClient"| Auth
        Ped["ms-pedidos"] -->|"AuthFeignClient"| Auth
        Ped -->|"MenuItemClient<br/>getById()"| Menu
        Pag["ms-pagos"] -->|"AuthFeignClient"| Auth
        Del["ms-delivery"] -->|"AuthFeignClient"| Auth
        Inv["ms-inventario"] -->|"AuthFeignClient"| Auth
        Not["ms-notificaciones"] -->|"AuthFeignClient"| Auth
        Rep["ms-reportes"] -->|"AuthFeignClient"| Auth
        Rep -->|"PagoClient"| Pag
        Rep -->|"PedidoClient"| Ped
    end

    style Auth fill:#4CAF50,color:#fff
    style Menu fill:#2196F3,color:#fff
    style Ped fill:#FF9800,color:#fff
    style Pag fill:#9C27B0,color:#fff
```

### ¿Cuándo usar Feign?

Feign se usa cuando el servicio **necesita respuesta inmediata** para continuar su operación. Es una llamada bloqueante: el servicio que llama espera la respuesta.

### Tabla de justificación Feign

| Cliente | Origen → Destino | ¿Por qué síncrono? |
|---|---|---|
| `AuthFeignClient` | 9 MS → ms-auth | **Autorización**: No puedo crear un pedido si no sé si el usuario tiene permiso. La respuesta debe ser inmediata. |
| `MenuItemClient` | ms-pedidos → ms-menu | **Precio en tiempo real**: Para calcular el total del pedido necesito el precio actual del ítem del menú ahora, no después. |
| `PagoClient` | ms-reportes → ms-pagos | **Consulta bajo demanda**: El reporte se genera cuando el admin lo pide; necesita datos de pago actualizados en ese momento. |
| `PedidoClient` | ms-reportes → ms-pedidos | **Consulta bajo demanda**: Misma razón — el reporte necesita datos de pedidos actuales al generarse. |

### **Guion:**

> "Para comunicación síncrona uso Feign, que es un cliente HTTP declarativo integrado con Eureka. El caso principal es AuthFeignClient: 9 de los 10 microservicios llaman a ms-auth para validar si un usuario tiene permiso para realizar una operación. Esto DEBE ser síncrono: no puedo crear un pedido sin saber si el usuario está autorizado. También ms-pedidos consulta a ms-menu vía Feign para obtener el precio actual de un ítem —necesito ese dato en tiempo real para calcular el total. Y ms-reportes consulta a ms-pagos y ms-pedidos para generar reportes bajo demanda. En todos estos casos, la respuesta es necesaria AHORA, no después."

---

## 5. Comunicación Asíncrona: Kafka (2 min)

### Diagrama de topics y consumidores

```mermaid
graph LR
    subgraph Producers["Productores (Publican)"]
        AuthP["ms-auth"] -->|"topico-usuarios"| K1[" "]
        SucP["ms-sucursales"] -->|"sucursal-events"| K2[" "]
        MenuP["ms-menu"] -->|"menu-item-events"| K3[" "]
        PedP["ms-pedidos"] -->|"pedido-events"| K4[" "]
        PagP["ms-pagos"] -->|"pago-events"| K5[" "]
        DelP["ms-delivery"] -->|"delivery-events"| K6[" "]
        InvP["ms-inventario"] -->|"stock-events"| K7[" "]
    end

    subgraph Kafka["Apache Kafka"]
        K1
        K2
        K3
        K4
        K5
        K6
        K7
    end

    subgraph Consumers["Consumidores (Reaccionan)"]
        K1 --> CartC["ms-carrito<br/>ClienteProyeccion"]
        K2 --> MenuC["ms-menu<br/>SucursalProyeccion"]
        K2 --> PedC["ms-pedidos<br/>SucursalProyeccion"]
        K3 --> PedC2["ms-pedidos<br/>MenuItemProyeccion"]
        K3 --> CartC2["ms-carrito<br/>MenuItemProyeccion"]
        K4 --> PagC["ms-pagos<br/>PedidoProyeccion"]
        K4 --> DelC["ms-delivery<br/>PedidoProyeccion"]
        K4 --> InvC["ms-inventario<br/>Log de eventos"]
        K4 --> NotC["ms-notificaciones<br/>Genera notificación"]
        K4 --> RepC["ms-reportes<br/>ReporteSnapshot"]
        K5 --> RepC2["ms-reportes<br/>ReporteSnapshot"]
        K6 --> NotC2["ms-notificaciones<br/>Genera notificación"]
    end

    style Kafka fill:#FF5722,color:#fff
```

### ¿Cuándo usar Kafka?

Kafka se usa cuando un evento de negocio debe ser **consumido por múltiples servicios sin bloquear al productor**. El productor publica el evento y continúa —no espera respuesta.

### Tabla de justificación Kafka

| Topic | Productor | Consumidores | ¿Por qué asíncrono? |
|---|---|---|---|
| `pedido-events` | ms-pedidos | pagos, delivery, inventario, notificaciones, reportes | **Desacoplamiento**: 5 servicios reaccionan al pedido. Si uno falla, los demás siguen. El pedido se crea aunque ms-pagos esté caído. |
| `menu-item-events` | ms-menu | pedidos, carrito | **CQRS**: En vez de llamar a ms-menu cada vez que se necesita un precio, los datos se replican localmente. Esto elimina latencia de red en lecturas. |
| `sucursal-events` | ms-sucursales | menu, pedidos | **Replicación**: Datos de sucursal disponibles localmente en los MS que los necesitan para filtrar menús y pedidos por sucursal. |
| `pago-events` | ms-pagos | reportes | **Alimentación de reportes**: El resultado de cada pago alimenta el sistema de reportes sin acoplar los servicios. |
| `delivery-events` | ms-delivery | notificaciones | **Notificaciones desacopladas**: Cuando cambia el estado de un delivery, se notifica al cliente sin que delivery sepa cómo enviar notificaciones. |
| `topico-usuarios` | ms-auth | carrito | **Datos de cliente locales**: ms-carrito necesita datos del cliente para mostrar el carrito, pero no debe llamar a ms-auth por cada consulta. |
| `stock-events` | ms-inventario | (futuro dashboard) | **Alertas de stock bajo**: Preparado para que un futuro dashboard de alertas consuma eventos de stock sin acoplamiento. |

### **Guion:**

> "Para comunicación asíncrona uso Apache Kafka con 7 topics. El caso más importante es `pedido-events`: cuando se crea un pedido, ms-pedidos publica un evento y 5 servicios reaccionan de forma independiente —pagos, delivery, inventario, notificaciones y reportes. Esto es clave: si ms-pagos está caído, el pedido se crea igual. Kafka retiene el mensaje y cuando ms-pagos se recupera, lo procesa.
>
> Este patrón se llama CQRS: en vez de llamar a otro servicio por cada consulta, los datos se replican localmente mediante eventos. Por ejemplo, cuando ms-menu crea un ítem, publica `menu-item-events` y tanto ms-pedidos como ms-carrito actualizan su copia local. Así, cuando un cliente ve el menú, ms-carrito no necesita llamar a ms-menu —ya tiene los datos localmente. Esto elimina latencia de red y evita que una caída de ms-menu tumbe el carrito de compras."

---

## 6. ¿Por qué Kafka aquí y Feign allá? — La decisión clave (1 min)

```mermaid
graph TD
    Q["¿El servicio que llama<br/>necesita respuesta<br/>para continuar?"]
    Q -->|"SÍ"| Feign["FEIGN (Síncrono)"]
    Q -->|"NO"| Kafka["KAFKA (Asíncrono)"]

    Feign --> F1["Autorización: ¿tiene permiso?"]
    Feign --> F2["Consulta de precio actual"]
    Feign --> F3["Generación de reporte bajo demanda"]

    Kafka --> K1["Evento dispara reacción<br/>en múltiples servicios"]
    Kafka --> K2["Replicación de datos<br/>para consultas locales (CQRS)"]
    Kafka --> K3["Notificaciones desacopladas"]

    style Feign fill:#2196F3,color:#fff
    style Kafka fill:#FF5722,color:#fff
```

### Regla de decisión

| Si... | Entonces usa... | Porque... |
|---|---|---|
| El resultado determina si la operación continúa o no | **Feign** | No puedes proceder sin saber la respuesta |
| La operación debe completarse aunque el receptor no esté disponible | **Kafka** | El productor no debe bloquearse por un consumidor caído |
| Múltiples servicios necesitan reaccionar al mismo evento | **Kafka** | Un publicador, muchos suscriptores desacoplados |
| Necesitas datos actualizados en el momento exacto de la consulta | **Feign** | Kafka tiene latencia de consumo |
| Quieres evitar llamadas de red en cada lectura (CQRS) | **Kafka** | Los datos se replican proactivamente; las lecturas son locales |

### **Guion:**

> "Esta es probablemente la decisión arquitectónica más importante del proyecto. La regla es simple: si la respuesta determina si puedo continuar o no, uso Feign. Si el evento debe disparar reacciones en otros servicios sin bloquear al productor, uso Kafka.
>
> Ejemplo concreto: cuando un mesero crea un pedido, primero consulto a ms-auth vía Feign: '¿este mesero tiene permiso para crear pedidos?' Si la respuesta es no, el pedido no se crea —necesito esa respuesta ya. Pero una vez creado el pedido, publico un evento a Kafka. Que ms-pagos procese el cobro, que ms-delivery asigne repartidor, que ms-notificaciones avise al cliente —todo eso ocurre después, sin bloquear al mesero. Si las notificaciones fallan, el pedido ya está creado."

---

## 7. Flujos de Negocio (3 min)

### 7.1 Flujo de Autenticación y Autorización

```mermaid
sequenceDiagram
    participant C as Cliente/Postman
    participant Auth as ms-auth :9001
    participant DB as PostgreSQL (auth)
    participant Other as Otro MS (ej: pedidos)

    Note over C,Other: REGISTRO
    C->>Auth: POST /api/v1/auth/register
    Auth->>DB: INSERT user_credentials (BCrypt hash)
    Auth->>DB: INSERT usuarios
    Auth->>Auth: Generar JWT (HS256, 24h) + Refresh Token (7d)
    Auth-->>C: 201 {token, refreshToken, rol, expiresIn}

    Note over C,Other: LOGIN
    C->>Auth: POST /api/v1/auth/login
    Auth->>DB: SELECT + BCrypt.checkpw()
    Auth-->>C: 200 {token, refreshToken, rol}

    Note over C,Other: AUTORIZACIÓN (cada operación)
    C->>Other: POST /api/v1/pedidos (Authorization: Bearer <JWT>)
    Other->>Auth: Feign: GET /validar-acceso?credencialId=X&modulo=pedidos&accion=crear
    Auth-->>Other: {permitido: true, mensaje: "Acceso Concedido"}
    Other-->>C: 201 Pedido creado
```

### **Guion flujo auth:**

> "El flujo de autenticación tiene tres fases. Primero, el registro: el usuario envía email y password, que se hashea con BCrypt antes de guardar —nunca almacenamos contraseñas en texto plano. El sistema devuelve un JWT firmado con HMAC-SHA256 que expira en 24 horas, más un refresh token de 7 días.
>
> En el login, se compara el hash BCrypt. Si coincide, se genera un nuevo par de tokens.
>
> Pero lo más interesante es la autorización: cada vez que un microservicio recibe una petición, llama a ms-auth vía Feign con el credencialId, el módulo y la acción. ms-auth verifica el rol del usuario y responde si tiene permiso. Por ejemplo, un cliente no puede crear ítems del menú, pero un admin sí. Esto implementa el patrón zero-trust: ningún microservicio confía en el token por sí solo; siempre valida contra la fuente de autoridad."

### 7.2 Flujo de Crear Pedido (el más importante)

```mermaid
sequenceDiagram
    actor C as Cliente
    participant Ped as ms-pedidos :9007
    participant Auth as ms-auth :9001
    participant Menu as ms-menu :9004
    participant DB as PostgreSQL (pedidos)
    participant K as Apache Kafka

    C->>Ped: POST /api/v1/pedidos<br/>{usuarioId, sucursalId, items[], tipo}

    Note over Ped,Auth: 1. Validar autorización (Feign)
    Ped->>Auth: Feign: validarAcceso(credencialId, "pedidos", "crear")
    Auth-->>Ped: {permitido: true}

    Note over Ped,Menu: 2. Obtener precios actuales (Feign)
    loop Por cada ítem
        Ped->>Menu: Feign: MenuItemClient.getById(menuItemId)
        Menu-->>Ped: {id, nombre, precio}
    end

    Note over Ped,DB: 3. Crear pedido
    Ped->>Ped: Calcular total, generar numeroPedido
    Ped->>DB: INSERT pedido (estado=PENDIENTE) + INSERT pedido_items

    Note over Ped,K: 4. Publicar evento (Kafka)
    Ped->>K: pedido-events: {idPedido, idCliente, total, estado, direccionEntrega}

    par Reacciones asíncronas
        K->>ms-pagos: Proyectar pedido para cobro
        K->>ms-delivery: Proyectar pedido para entrega
        K->>ms-inventario: Registrar evento
        K->>ms-notificaciones: Notificar al cliente
        K->>ms-reportes: Almacenar para reportes
    end

    Ped-->>C: 201 {id, numeroPedido, estado: PENDIENTE, items[], total}
```

### **Guion flujo pedido:**

> "Este es el flujo más importante del sistema. Cuando un cliente crea un pedido, ocurren 4 pasos. Primero, validación de autorización vía Feign: ¿este usuario puede crear pedidos? Segundo, para cada ítem del pedido, consulto a ms-menu vía Feign para obtener el precio actual —necesito el precio real, no una copia vieja. Tercero, creo el pedido en estado PENDIENTE, genero un número de pedido único, y guardo en la base de datos.
>
> Y aquí viene lo clave —el cuarto paso: publico un evento `pedido-events` a Kafka. A partir de este momento, 5 servicios reaccionan de forma independiente y asíncrona: ms-pagos proyecta el pedido para cobrarlo, ms-delivery lo proyecta para asignar repartidor, ms-inventario registra el evento para trazabilidad de stock, ms-notificaciones genera una notificación al cliente, y ms-reportes almacena un snapshot para reportes futuros. Todo esto ocurre sin que ms-pedidos espere ni se bloquee. Si ms-notificaciones está caído, el pedido ya está creado y el evento se procesará cuando se recupere."

### 7.3 Flujo de Pago

```mermaid
sequenceDiagram
    actor M as Mesero/Admin
    participant Pag as ms-pagos :9008
    participant Auth as ms-auth :9001
    participant DB as PostgreSQL (pagos)
    participant K as Kafka

    M->>Pag: POST /api/v1/pagos<br/>{pedidoId, monto, metodo}
    Pag->>Auth: Feign: validarAcceso()
    Auth-->>Pag: {permitido: true}
    Pag->>DB: INSERT pago (estado=PENDIENTE)
    Note over Pag: Validar monto == total del pedido
    Pag->>DB: UPDATE pago (estado=APROBADO, transaccionId)
    Pag->>K: pago-events: {pagoId, pedidoId, estado, monto, metodo}
    K->>ms-reportes: Almacenar para reportes financieros
    Pag-->>M: 200 {id, estado: APROBADO, transaccionId}
```

### **Guion flujo pago:**

> "El flujo de pago sigue el mismo patrón: autorización vía Feign, creación del pago, y publicación del evento `pago-events` a Kafka para que ms-reportes lo almacene. La validación de transiciones de estado —por ejemplo, no se puede aprobar un pago ya reembolsado— está implementada con un mapa de transiciones válidas, que es una máquina de estados simple pero efectiva."

### 7.4 Flujo de Delivery

```mermaid
sequenceDiagram
    actor A as Admin/Repartidor
    participant Del as ms-delivery :9009
    participant Auth as ms-auth :9001
    participant DB as PostgreSQL (delivery)
    participant K as Kafka

    Note over A,Del: CREAR DELIVERY
    A->>Del: POST /api/v1/delivery<br/>{pedidoId, direccionEntrega}
    Del->>Auth: Feign: validarAcceso()
    Del->>DB: INSERT delivery (estado=BUSCANDO_REPARTIDOR)
    Del->>K: delivery-events (DELIVERY_CREATED)

    Note over A,Del: ASIGNAR REPARTIDOR
    A->>Del: PATCH /{id}/asignar<br/>{repartidorId}
    Del->>Auth: Feign: validarAcceso()
    Del->>DB: UPDATE delivery (estado=ASIGNADO, repartidorId)
    Del->>K: delivery-events (DELIVERY_REPARTIDOR_ASIGNADO)

    Note over A,Del: ACTUALIZAR ESTADO
    A->>Del: PATCH /{id}/estado?estado=EN_CAMINO
    Del->>Auth: Feign: validarAcceso()
    Del->>DB: UPDATE delivery (estado=EN_CAMINO)
    Del->>K: delivery-events (DELIVERY_EN_CAMINO)
    K->>ms-notificaciones: "Tu pedido está en camino"
```

### **Guion flujo delivery:**

> "El delivery tiene un ciclo de vida con 5 estados: buscando repartidor, asignado, en camino, entregado y cancelado. Cada cambio de estado publica un evento a Kafka en el topic `delivery-events`, y ms-notificaciones consume estos eventos para notificar al cliente —'tu pedido está en camino', 'tu pedido fue entregado'. De nuevo, el desacoplamiento es clave: ms-delivery no sabe cómo enviar notificaciones, solo publica eventos. ms-notificaciones decide si es email, SMS o push."

### 7.5 Patrón CQRS: Proyecciones

```mermaid
sequenceDiagram
    participant Productor as ms-menu (Productor)
    participant K as Kafka
    participant Consumidor as ms-pedidos (Consumidor)
    participant DB as PostgreSQL (pedidos)

    Note over Productor: Crear un ítem de menú
    Productor->>Productor: INSERT INTO menu_items
    Productor->>K: menu-item-events<br/>{id, nombre, precio, disponible}

    Note over Consumidor,DB: Consumir evento y actualizar proyección local
    K->>Consumidor: @KafkaListener("menu-item-events")
    Consumidor->>Consumidor: Deserializar JSON a MenuItemEventDTO
    Consumidor->>DB: INSERT/UPDATE proyeccion_menu_items<br/>(id, nombre, precio, disponible)

    Note over Consumidor,DB: Ahora ms-pedidos tiene una copia local
    Note over Consumidor,DB: Puede consultar precios sin llamar a ms-menu
```

### **Guion CQRS:**

> "Este es el patrón CQRS con proyecciones. En lugar de que ms-pedidos llame a ms-menu cada vez que necesita el precio de un ítem, ms-menu publica un evento cada vez que crea o modifica un ítem. ms-pedidos consume ese evento y actualiza una tabla local llamada `proyeccion_menu_items`. El resultado: cuando ms-pedidos necesita mostrar el menú o calcular un total, lee de su propia base de datos local —cero latencia de red, cero dependencia de que ms-menu esté disponible. Si ms-menu se cae, ms-pedidos sigue funcionando con la última copia de los datos. Esto se replica para sucursales, clientes, y pedidos en todos los microservicios que los necesitan."

---

## 8. Capas Internas de un Microservicio (1 min)

### Patrón CSR (Controller → Service → Repository)

```mermaid
graph LR
    subgraph "Capa Web"
        Ctrl["@RestController<br/>Controller"]
    end
    subgraph "Capa Negocio"
        Svc["@Service<br/>Service"]
        Map["@Mapper<br/>MapStruct"]
        FeignC["@FeignClient<br/>Cliente HTTP"]
        KafkaP["KafkaTemplate<br/>Productor"]
    end
    subgraph "Capa Datos"
        Repo["@Repository<br/>JpaRepository"]
        Entity["@Entity<br/>Entidad JPA"]
        KafkaL["@KafkaListener<br/>Consumidor"]
    end
    subgraph "Infra"
        DB[("PostgreSQL")]
        Eureka["Eureka"]
        Kafka["Kafka"]
    end

    Ctrl -->|"RequestDTO"| Svc
    Svc --> Map
    Svc --> FeignC
    Svc --> KafkaP
    Svc --> Repo
    Repo --> Entity
    Entity --> DB
    FeignC --> Eureka
    KafkaP --> Kafka
    Kafka --> KafkaL
    KafkaL --> Repo

    Map -->|"Entity ↔ DTO"| Ctrl
```

### Estructura de paquetes

```
cl.triskeledu.<microservicio>/
├── client/          → @FeignClient (llamadas a otros MS)
├── config/          → CORS, configuración
├── controller/      → @RestController (endpoints HTTP)
├── dto/
│   ├── request/     → DTOs de entrada (con @Valid)
│   ├── response/    → DTOs de salida
│   └── event/       → DTOs para Kafka
├── entity/          → @Entity JPA
├── exception/       → Excepciones + @RestControllerAdvice
├── listener/        → @KafkaListener (consumidores)
├── mapper/          → MapStruct (Entity ↔ DTO)
├── proyecciones/    → Entidades CQRS (réplicas locales)
├── repository/      → JpaRepository
└── service/impl/    → @Service (lógica de negocio)
```

### **Guion:**

> "Todos los microservicios siguen la misma estructura de paquetes y el patrón CSR: Controller recibe la petición HTTP y delega al Service. El Service contiene la lógica de negocio: valida permisos vía Feign, aplica reglas, usa el Repository para persistir, y opcionalmente publica eventos a Kafka. Los DTOs separan la representación externa de la entidad interna —nunca exponemos la entidad JPA directamente. MapStruct genera el mapeo Entity↔DTO en tiempo de compilación, sin reflexión. Y el GlobalExceptionHandler centraliza todos los errores en un solo lugar, devolviendo siempre el mismo formato JSON."

---

## 9. Errores, Validaciones y Logs (1 min)

### Manejo centralizado de errores

```mermaid
graph LR
    Svc["Service"] -->|"throw new PedidoNotFoundException()"| Exc["Exception"]
    Exc --> GEH["@RestControllerAdvice<br/>GlobalExceptionHandler"]
    GEH -->|"404 JSON"| Cliente["{timestamp, status, error, mensaje}"]
    GEH -->|"FeignException → 503"| Cliente
    GEH -->|"Validation → 400 + errores"| Cliente
```

### **Guion:**

> "Todos los errores se manejan de forma centralizada con `@RestControllerAdvice`. Cada microservicio define sus excepciones de negocio —como PedidoNotFoundException— y el GlobalExceptionHandler las intercepta y devuelve un JSON estructurado con timestamp, status HTTP, tipo de error y mensaje. Esto garantiza que el frontend siempre reciba el mismo formato de error, sin stacks traces.
>
> Un detalle importante: las excepciones de Feign —cuando un microservicio no responde— se manejan como 503 Service Unavailable, no como 500. Y si ms-auth no está disponible, los servicios entran en 'modo degradado': permiten la operación pero registran un warning. Así evitamos que una caída de ms-auth tumbe todo el sistema."

---

## 10. Evidencia Final (2 min)

### Evidencia a mostrar en el video

```mermaid
graph TB
    subgraph "1. Eureka Dashboard"
        EU["http://localhost:8761<br/>10 servicios registrados"]
    end
    subgraph "2. Postman"
        PM["Colección con +80 requests<br/>Flujos completos probados"]
    end
    subgraph "3. Kafka Logs"
        KL["Consola: eventos publicados<br/>y consumidos en tiempo real"]
    end
    subgraph "4. DBeaver"
        DB["PostgreSQL puerto 5433<br/>Tablas y datos seed"]
    end
    subgraph "5. GitHub"
        GH["Repositorio con commits<br/>y estructura del proyecto"]
    end

    EU --> PM --> KL --> DB --> GH
```

### Checklist de evidencia

| # | Qué mostrar | Dónde | Tiempo |
|---|---|---|---|
| 1 | Eureka Dashboard | `http://localhost:8761` | 20s |
| 2 | Login + obtener JWT | Postman → ms-auth :9001 | 30s |
| 3 | Crear pedido completo | Postman → ms-pedidos :9007 | 60s |
| 4 | Ver evento Kafka en logs | Consola ms-pagos/delivery | 30s |
| 5 | Ver proyección actualizada | DBeaver → BD pagos/delivery | 20s |
| 6 | Probar error (404, 401) | Postman → respuesta JSON | 20s |
| 7 | GitHub: mostrar commits | Navegador → repositorio | 20s |
| 8 | Código: mostrar ServiceImpl | IDE → archivo clave | 30s |

### **Guion cierre:**

> "Para demostrar que todo funciona, vamos a verlo en vivo. Primero, Eureka: todos los microservicios registrados. Luego en Postman, hago login, obtengo el JWT, y creo un pedido completo. Inmediatamente vemos en los logs de ms-pagos y ms-delivery cómo reciben el evento de Kafka y actualizan sus proyecciones. En DBeaver confirmamos que las tablas tienen los datos correctos. Y finalmente en GitHub, mostramos los commits que evidencian el trabajo realizado.
>
> Esta arquitectura de microservicios con comunicación híbrida Feign+Kafka, patrón CQRS con proyecciones, y manejo centralizado de errores, permite que el sistema sea escalable, resiliente y mantenible —cada servicio evoluciona de forma independiente sin afectar al resto."

---

## Orden Recomendado para el Video (12-14 min)

| # | Sección | Tiempo | Acumulado |
|---|---|---|---|
| 1 | Introducción y problema | 1:00 | 1:00 |
| 2 | Arquitectura general (diagrama Mermaid) | 2:00 | 3:00 |
| 3 | ¿Por qué microservicios? | 1:00 | 4:00 |
| 4 | Comunicación: Feign (diagrama) | 1:30 | 5:30 |
| 5 | Comunicación: Kafka (diagrama) | 2:00 | 7:30 |
| 6 | ¿Por qué Kafka vs Feign? (decisión clave) | 1:00 | 8:30 |
| 7 | Flujos de negocio (3 diagramas secuencia) | 2:30 | 11:00 |
| 8 | Capas internas, errores y logs | 1:00 | 12:00 |
| 9 | Evidencia en vivo (Postman, Eureka, logs) | 2:00 | 14:00 |

---

## Resumen de Diagramas Mermaid Incluidos

| # | Diagrama | Tipo | Página |
|---|---|---|---|
| 1 | Arquitectura General | `graph TB` | Sección 2 |
| 2 | Llamadas Feign | `graph LR` | Sección 4 |
| 3 | Topics y Consumidores Kafka | `graph LR` | Sección 5 |
| 4 | Decisión Feign vs Kafka | `graph TD` | Sección 6 |
| 5 | Secuencia: Autenticación | `sequenceDiagram` | Sección 7.1 |
| 6 | Secuencia: Crear Pedido | `sequenceDiagram` | Sección 7.2 |
| 7 | Secuencia: Pago | `sequenceDiagram` | Sección 7.3 |
| 8 | Secuencia: Delivery | `sequenceDiagram` | Sección 7.4 |
| 9 | Secuencia: CQRS Proyecciones | `sequenceDiagram` | Sección 7.5 |
| 10 | Capas Internas CSR | `graph LR` | Sección 8 |
| 11 | Manejo de Errores | `graph LR` | Sección 9 |
| 12 | Evidencia Final | `graph TB` | Sección 10 |
