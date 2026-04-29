# 📈 Diagramas de Flujo y Arquitectura

Este documento contiene diagramas visuales generados con **Mermaid** para comprender la arquitectura, el flujo de operaciones principales y las máquinas de estados del ecosistema de microservicios del restaurante.

---

## 1. Diagrama de Arquitectura (Interacciones Feign)

El siguiente diagrama muestra el principio "Database per Service" y cómo los microservicios se comunican entre sí de forma declarativa (via Feign) para enriquecer datos o delegar procesos.

```mermaid
graph TD
    %% Definición de Nodos (Microservicios)
    Gateway[API Gateway / Frontend] --> Auth(ms-auth\n[9001])
    Gateway --> Pedidos(ms-pedidos\n[9007])
    Gateway --> Menu(ms-menu\n[9004])
    Gateway --> Carrito(ms-carrito\n[9006])
    
    Auth -.->|Registra perfil| Usuarios(ms-usuarios\n[9002])
    
    Pedidos -.->|Verifica dueño| Usuarios
    Pedidos -.->|Verifica lugar| Sucursales(ms-sucursales\n[9003])
    Pedidos -.->|Verifica precio/stock| Menu
    Pedidos -.->|Descuenta stock| Inventario(ms-inventario\n[9010])
    Pedidos -.->|Paga orden| Pagos(ms-pagos\n[9008])
    Pedidos -.->|Si es envío| Delivery(ms-delivery\n[9009])
    
    Menu -.->|Asocia| Categorias(ms-categorias\n[9005])
    Menu -.->|Disponibilidad| Sucursales
    
    Carrito -.->|Revisa precio| Menu
    Carrito -.->|Revisa ubicación| Sucursales
    
    Inventario -.->|Verifica sucursal| Sucursales
    
    %% Alertas
    Pagos -.->|Recibo| Notificaciones(ms-notificaciones\n[9011])
    Delivery -.->|Tracking| Notificaciones
    Inventario -.->|Alerta stock| Notificaciones
    
    %% Agregación
    Reportes(ms-reportes\n[9012]) -.->|Lee Ventas| Pedidos
    Reportes -.->|Lee Gastos| Inventario
    Reportes -.->|Lee Ingresos| Pagos

    %% Bases de Datos
    Auth --- db1[(DB auth)]
    Usuarios --- db2[(DB users)]
    Sucursales --- db3[(DB sucursales)]
    Categorias --- db4[(DB cat)]
    Menu --- db5[(DB menu)]
    Carrito --- db6[(DB carrito)]
    Pedidos --- db7[(DB pedidos)]
    Pagos --- db8[(DB pagos)]
    Delivery --- db9[(DB delivery)]
    Inventario --- db10[(DB inv)]
    Notificaciones --- db11[(DB notif)]
    Reportes --- db12[(DB reports)]
```

---

## 2. Diagrama de Flujo de Uso (Core Business)

El "Camino Feliz" (Happy Path) desde que un cliente entra a la aplicación hasta que la comida llega a su mesa o puerta.

```mermaid
sequenceDiagram
    actor Cliente
    participant M as ms-menu
    participant C as ms-carrito
    participant P as ms-pedidos
    participant $$ as ms-pagos
    participant I as ms-inventario
    participant D as ms-delivery
    participant N as ms-notificaciones

    Cliente->>M: 1. Navega el Catálogo (GET)
    M-->>Cliente: Retorna Platos Activos
    Cliente->>C: 2. Agrega Platos al Carrito (POST)
    C->>M: 3. Valida precios y disponibilidad real
    M-->>C: Ok
    Cliente->>P: 4. Finalizar Compra (POST Checkout)
    P->>C: 5. Lee carrito y lo vacía
    C-->>P: Ítems del Carrito
    P->>$$: 6. Inicia Intención de Pago (PENDIENTE)
    Cliente->>$$: 7. Paga en Pasarela (Ej. Webpay)
    $$-->>P: 8. Confirma Pago (Webhook)
    P->>I: 9. Descuenta Insumos de la Receta (SALIDA)
    P->>N: 10. Envía Email de "Orden Recibida" al Cliente
    
    Note over P: El pedido pasa a PREPARACIÓN
    
    P->>D: 11. Notifica a Logística (Si es a domicilio)
    Note over D: Repartidor viaja (EN_CAMINO)
    D->>P: 12. Repartidor reporta "Entregado"
    P->>N: 13. Notifica "¡Buen Provecho!"
```

---

## 3. Diagramas de Estado

Las máquinas de estados finitos son cruciales en 3 microservicios para evitar inconsistencias lógicas.

### 3.1 Estados del Pedido (`ms-pedidos`)
```mermaid
stateDiagram-v2
    [*] --> PENDIENTE : Creado desde Carrito
    PENDIENTE --> CANCELADO : Cliente cancela / Pago falla
    PENDIENTE --> PREPARACION : Pago Aprobado
    PREPARACION --> LISTO : Cocinero termina
    LISTO --> ENTREGADO : Retiro local o Delivery
    ENTREGADO --> [*]
    CANCELADO --> [*]
```

### 3.2 Estados del Pago (`ms-pagos`)
```mermaid
stateDiagram-v2
    [*] --> PENDIENTE : Intención Creada
    PENDIENTE --> APROBADO : Banco confirma
    PENDIENTE --> RECHAZADO : Fondos insuficientes / Error
    APROBADO --> REEMBOLSADO : Local cancela orden ya pagada
    RECHAZADO --> [*]
    REEMBOLSADO --> [*]
```

### 3.3 Estados de Delivery (`ms-delivery`)
```mermaid
stateDiagram-v2
    [*] --> BUSCANDO_REPARTIDOR : ms-pedidos lo solicita
    BUSCANDO_REPARTIDOR --> CANCELADO : Nadie acepta / Local cierra
    BUSCANDO_REPARTIDOR --> ASIGNADO : Repartidor toma la ruta
    ASIGNADO --> EN_CAMINO : Retira paquete
    EN_CAMINO --> ENTREGADO : Cliente firma/recibe
    EN_CAMINO --> CANCELADO : Accidente / Dirección errónea
    ENTREGADO --> [*]
    CANCELADO --> [*]
```
