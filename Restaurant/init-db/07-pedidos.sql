/* ============================================================
   ARCHIVO: 0X-pedidos.sql
   Microservicio: ms-pedidos
   Responsabilidad: Gestión central del ciclo de vida de la compra. Agregado raíz.
   Base de Datos: pedidos_db
   
   NOTA ARQUITECTÓNICA: 
   - usuario_id: FK Lógica a ms-usuarios
   - sucursal_id: FK Lógica a ms-sucursales
   - menu_item_id: FK Lógica a ms-menu
   ============================================================ */

\c pedidos;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS pedido_items;
DROP TABLE IF EXISTS pedidos;

-- 2. TABLAS MAESTRAS

-- Tabla Padre: Pedidos (El Agregado Raíz)
CREATE TABLE pedidos (
    id              BIGSERIAL       PRIMARY KEY,
    
    -- Código de negocio auditable (Ej: PED-20260505-001)
    numero_pedido   VARCHAR(20)     NOT NULL UNIQUE,
    
    usuario_id      BIGINT          NOT NULL,
    sucursal_id     BIGINT          NOT NULL,
    
    -- Ajustado estricto a tu Enum EstadoPedido
    estado          VARCHAR(20)     NOT NULL 
        CHECK (estado IN ('PENDIENTE', 'CONFIRMADO', 'EN_PREPARACION', 'LISTO', 'EN_CAMINO', 'ENTREGADO', 'CANCELADO')),
    
    -- Ajustado estricto a tu Enum TipoPedido
    tipo            VARCHAR(15)     NOT NULL 
        CHECK (tipo IN ('DELIVERY', 'EN_LOCAL')),
    
    total           NUMERIC(10, 2)  NOT NULL CHECK (total >= 0),
    
    notas           TEXT,
    
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en  TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Tabla Hija: Items del Pedido (El Snapshot Histórico)
CREATE TABLE pedido_items (
    id              BIGSERIAL       PRIMARY KEY,
    
    -- Relación Real (@ManyToOne) con borrado en cascada
    pedido_id       BIGINT          NOT NULL REFERENCES pedidos(id) ON DELETE CASCADE,
    
    -- FK Lógica
    menu_item_id    BIGINT          NOT NULL,
    
    -- ==========================================
    -- 🛑 CAMPOS SNAPSHOT (Históricos inmutables)
    -- ==========================================
    nombre_snapshot VARCHAR(100)    NOT NULL,
    precio_unitario NUMERIC(10, 2)  NOT NULL CHECK (precio_unitario >= 0),
    
    cantidad        INT             NOT NULL CHECK (cantidad > 0),
    
    -- subtotal = precio_unitario * cantidad
    subtotal        NUMERIC(10, 2)  NOT NULL CHECK (subtotal >= 0)
);

-- 3. ÍNDICES
-- Para cargar los pedidos históricos de un cliente
CREATE INDEX idx_pedidos_usuario ON pedidos(usuario_id);

-- Para el KDS (Kitchen Display System) del cocinero: "Muéstrame los de MI sucursal que estén CONFIRMADO o EN_PREPARACION"
CREATE INDEX idx_pedidos_sucursal_estado ON pedidos(sucursal_id, estado);

-- Para buscar un pedido por su código (Ej: cuando el cliente llama para quejarse)
CREATE INDEX idx_pedidos_numero ON pedidos(numero_pedido);

-- Para cargar rápido los ítems al abrir el detalle de un pedido
CREATE INDEX idx_pedido_items_pedido ON pedido_items(pedido_id);

-- 4. DATOS DE PRUEBA (Data Seeding)
-- Simulación de la compra de Valentina (ID 6) en la Sucursal Providencia (ID 1)

-- 4.1 Un pedido de Delivery que ya está en camino
INSERT INTO pedidos 
(numero_pedido, usuario_id, sucursal_id, estado, tipo, total, notas) 
VALUES 
('PED-20260505-001', 6, 1, 'EN_CAMINO', 'DELIVERY', 15000.00, 'Dejar en conserjería por favor');
-- Asumimos ID 1

INSERT INTO pedido_items (pedido_id, menu_item_id, nombre_snapshot, precio_unitario, cantidad, subtotal)
VALUES 
(1, 3, 'Pizza de la Casa (Local 1)', 10000.00, 1, 10000.00),
(1, 8, 'Coca-Cola 1.5L', 2500.00, 2, 5000.00);

-- 4.2 Un pedido para comer en el local que recién entró a cocina (Usuario 4)
INSERT INTO pedidos 
(numero_pedido, usuario_id, sucursal_id, estado, tipo, total, notas) 
VALUES 
('PED-20260505-002', 4, 1, 'CONFIRMADO', 'EN_LOCAL', 12990.00, 'Mesa 5, sin orégano');
-- Asumimos ID 2

INSERT INTO pedido_items (pedido_id, menu_item_id, nombre_snapshot, precio_unitario, cantidad, subtotal)
VALUES 
(2, 1, 'Pizza Pepperoni', 12990.00, 1, 12990.00);