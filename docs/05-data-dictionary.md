# 🗄️ Diccionario de Datos Consolidado

## 1. Estrategia de Persistencia
El sistema utiliza **PostgreSQL** con una estrategia de **Aislamiento Total (Database per Service)**. Las entidades están diseñadas siguiendo el patrón de *Agregados de Dominio*.

## 2. Entidades Principales y Relaciones Lógicas

A continuación se detallan las entidades clave y cómo se referencian entre microservicios (sin Foreign Keys físicas).

### A. Dominio de Usuarios y Auth
*   **User (ms-usuarios):** Almacena perfil, email y datos personales.
*   **Credential (ms-auth):** Almacena username, password (hasheado) y roles.
    *   *Vínculo:* Se relacionan mediante el `email` o un `uuid` compartido.

### B. Dominio de Ventas (Catálogo)
*   **MenuItem (ms-menu):** Nombre, precio, stock referencial.
*   **Categoria (ms-categorias):** Agrupación lógica (ej: "Bebidas", "Pizzas").
*   **Sucursal (ms-sucursales):** Ubicación física donde está disponible el producto.

### C. Dominio Transaccional
*   **Pedido (ms-pedidos):** Cabecera de la transacción.
*   **PedidoItem (ms-pedidos):** Detalle de productos comprados.
    *   *Relación Lógica:* Contiene `menuItemId` que referencia a `ms-menu`.
*   **Transaccion (ms-pagos):** Registro de intentos de cobro y estados de pasarela.

## 3. Tipos de Datos Estándar
*   **Precios/Montos:** Siempre `BigDecimal` (Java) y `DECIMAL(19,2)` (SQL) para evitar errores de redondeo.
*   **Fechas:** `LocalDateTime` (Java) y `TIMESTAMP` (SQL).
*   **Identificadores:** `Long` (Java) y `BIGSERIAL` (SQL).
