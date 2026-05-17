/* ============================================================
   ARCHIVO: 07-pedidos.sql
   Microservicio: ms-pedidos
   Responsabilidad: Gestión central del ciclo de vida de la compra. Agregado raíz.
   Base de Datos: pedidos
   
   NOTA ARQUITECTÓNICA: 
   - proyeccion_clientes: Copia local de ms-auth/ms-usuarios (vía Kafka).
   - proyeccion_sucursales: Copia local de ms-sucursales (vía Kafka).
   - proyeccion_menu_items: Copia local de ms-menu (vía Kafka).
   ============================================================ */

\c pedidos;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS pedido_items;
DROP TABLE IF EXISTS pedidos;
DROP TABLE IF EXISTS proyeccion_menu_items;
DROP TABLE IF EXISTS proyeccion_sucursales;
DROP TABLE IF EXISTS proyeccion_clientes;

-- ============================================================
-- 2. PROYECCIONES (Datos de lectura provenientes de otros MS)
-- ============================================================

CREATE TABLE proyeccion_clientes (
    id_cliente      BIGINT PRIMARY KEY, -- Mismo ID generado en ms-auth
    nombre          VARCHAR(100) NOT NULL,
    email           VARCHAR(150) NOT NULL
);

CREATE TABLE proyeccion_sucursales (
    id_sucursal     BIGINT PRIMARY KEY, -- Mismo ID generado en ms-sucursales
    nombre          VARCHAR(100) NOT NULL,
    activa          BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE proyeccion_menu_items (
    id_item         BIGINT PRIMARY KEY, -- Mismo ID generado en ms-menu
    nombre          VARCHAR(100) NOT NULL,
    precio          NUMERIC(10, 2) NOT NULL,
    disponible      BOOLEAN NOT NULL DEFAULT TRUE
);

-- POBLACIÓN DE DATOS DE PRUEBA EN LAS PROYECCIONES (Simulando eventos de Kafka)
INSERT INTO proyeccion_clientes (id_cliente, nombre, email) VALUES
(4, 'Carlos Mendoza', 'carlos.mendoza@email.com'),
(6, 'Valentina Silva', 'valentina.silva@email.com');

INSERT INTO proyeccion_sucursales (id_sucursal, nombre, activa) VALUES
(1, 'Casa Matriz - Providencia', true),
(2, 'Sucursal Las Condes', true);

INSERT INTO proyeccion_menu_items (id_item, nombre, precio, disponible) VALUES
(1, 'Pizza Pepperoni', 12990.00, true),
(3, 'Pizza de la Casa (Local 1)', 10000.00, true),
(8, 'Coca-Cola 1.5L', 2500.00, true);


-- ============================================================
-- 3. TABLAS MAESTRAS (Dueño: ms-pedidos)
-- ============================================================

-- Tabla Padre: Pedidos (El Agregado Raíz)
CREATE TABLE pedidos (
    id              BIGSERIAL       PRIMARY KEY,
    
    -- Código de negocio auditable (Ej: PED-20260505-001)
    numero_pedido   VARCHAR(20)     NOT NULL UNIQUE,
    
    -- FKs Físicas a nuestras tablas de proyecciones locales
    usuario_id      BIGINT          NOT NULL REFERENCES proyeccion_clientes(id_cliente),
    sucursal_id     BIGINT          NOT NULL REFERENCES proyeccion_sucursales(id_sucursal),
    
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
    
    -- FK Física a nuestra tabla de proyección local de Menu Items
    menu_item_id    BIGINT          NOT NULL REFERENCES proyeccion_menu_items(id_item),
    
    -- ==========================================
    -- 🛑 CAMPOS SNAPSHOT (Históricos inmutables)
    -- ==========================================
    nombre_snapshot VARCHAR(100)    NOT NULL,
    precio_unitario NUMERIC(10, 2)  NOT NULL CHECK (precio_unitario >= 0),
    
    cantidad        INT             NOT NULL CHECK (cantidad > 0),
    
    -- subtotal = precio_unitario * cantidad
    subtotal        NUMERIC(10, 2)  NOT NULL CHECK (subtotal >= 0)
);


-- ============================================================
-- 4. ÍNDICES
-- ============================================================
-- Para cargar los pedidos históricos de un cliente
CREATE INDEX idx_pedidos_usuario ON pedidos(usuario_id);

-- Para el KDS (Kitchen Display System) del cocinero
CREATE INDEX idx_pedidos_sucursal_estado ON pedidos(sucursal_id, estado);

-- Para buscar un pedido por su código secuencial
CREATE INDEX idx_pedidos_numero ON pedidos(numero_pedido);

-- Para cargar rápido los ítems al abrir el detalle de un pedido
CREATE INDEX idx_pedido_items_pedido ON pedido_items(pedido_id);


-- ============================================================
-- 5. DATOS DE PRUEBA EN TABLAS MAESTRAS (Data Seeding)
-- ============================================================

-- 5.1 Un pedido de Delivery que ya está en camino (Valentina - ID 6)
INSERT INTO pedidos 
(numero_pedido, usuario_id, sucursal_id, estado, tipo, total, notas) 
VALUES 
('PED-20260505-001', 6, 1, 'EN_CAMINO', 'DELIVERY', 15000.00, 'Dejar en conserjería por favor');

INSERT INTO pedido_items (pedido_id, menu_item_id, nombre_snapshot, precio_unitario, cantidad, subtotal)
VALUES 
(1, 3, 'Pizza de la Casa (Local 1)', 10000.00, 1, 10000.00),
(1, 8, 'Coca-Cola 1.5L', 2500.00, 2, 5000.00);

-- 5.2 Un pedido para comer en el local que recién entró a cocina (Carlos - ID 4)
INSERT INTO pedidos 
(numero_pedido, usuario_id, sucursal_id, estado, tipo, total, notas) 
VALUES 
('PED-20260505-002', 4, 1, 'CONFIRMADO', 'EN_LOCAL', 12990.00, 'Mesa 5, sin orégano');

INSERT INTO pedido_items (pedido_id, menu_item_id, nombre_snapshot, precio_unitario, cantidad, subtotal)
VALUES 
(2, 1, 'Pizza Pepperoni', 12990.00, 1, 12990.00);