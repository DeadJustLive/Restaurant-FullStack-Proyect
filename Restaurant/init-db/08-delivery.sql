/* ============================================================
   ARCHIVO: 08-delivery.sql
   Microservicio: ms-delivery
   Responsabilidad: Gestionar la logística y el estado de entrega de los pedidos.
   Base de Datos: delivery
   
   NOTA ARQUITECTÓNICA: 
   - proyeccion_pedidos: Copia local de ms-pedidos (vía Kafka).
   - proyeccion_usuarios: Copia local de ms-usuarios para validar Repartidores (vía Kafka).
   ============================================================ */

\c delivery;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS deliveries;
DROP TABLE IF EXISTS proyeccion_pedidos;
DROP TABLE IF EXISTS proyeccion_usuarios;

-- ============================================================
-- 2. PROYECCIONES (Datos de lectura provenientes de otros MS)
-- ============================================================

CREATE TABLE proyeccion_usuarios (
    id_usuario      BIGINT PRIMARY KEY, -- ID proveniente de ms-auth
    nombre_completo VARCHAR(150) NOT NULL,
    telefono        VARCHAR(20),
    rol             VARCHAR(20) NOT NULL
);

CREATE TABLE proyeccion_pedidos (
    id_pedido       BIGINT PRIMARY KEY, -- ID proveniente de ms-pedidos
    id_cliente      BIGINT NOT NULL REFERENCES proyeccion_usuarios(id_usuario),
    id_sucursal     BIGINT NOT NULL,
    estado_pedido   VARCHAR(50) NOT NULL
);

-- POBLACIÓN DE DATOS DE PRUEBA EN LAS PROYECCIONES
INSERT INTO proyeccion_usuarios (id_usuario, nombre_completo, telefono, rol) VALUES 
(5, 'Diego Repartidor', '+56988887777', 'REPARTIDOR'),
(6, 'Valentina Silva', '+56911112222', 'CLIENTE'),
(7, 'Carlos Pinto', '+56933334444', 'CLIENTE');

INSERT INTO proyeccion_pedidos (id_pedido, id_cliente, id_sucursal, estado_pedido) VALUES 
(101, 6, 1, 'EN_PREPARACION'),
(102, 7, 1, 'LISTO'),
(103, 6, 2, 'EN_CAMINO'),
(104, 7, 2, 'ENTREGADO');


-- ============================================================
-- 3. TABLAS MAESTRAS (Dueño: ms-delivery)
-- ============================================================

CREATE TABLE deliveries (
    id                  BIGSERIAL       PRIMARY KEY,
    
    -- El vínculo con la proyección del pedido original (FK Física real). 
    -- Es UNIQUE porque 1 pedido = 1 delivery.
    pedido_id           BIGINT          NOT NULL UNIQUE REFERENCES proyeccion_pedidos(id_pedido),
    
    -- El repartidor asignado (FK Física real a la proyección de usuarios).
    -- Puede ser NULL al principio cuando está "BUSCANDO_REPARTIDOR"
    repartidor_id       BIGINT          REFERENCES proyeccion_usuarios(id_usuario),
    
    direccion_entrega   VARCHAR(300)    NOT NULL,
    
    -- AQUÍ ESTÁ LA MAGIA DEL ENUM: Guardamos el texto, pero restringimos las opciones.
    estado              VARCHAR(20)     NOT NULL DEFAULT 'BUSCANDO_REPARTIDOR'
        CHECK (estado IN ('BUSCANDO_REPARTIDOR', 'ASIGNADO', 'EN_CAMINO', 'ENTREGADO', 'CANCELADO')),
    
    -- Usamos TEXT porque las observaciones pueden ser muy largas
    observaciones       TEXT,
    
    creado_en           TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en      TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP
);


-- ============================================================
-- 4. ÍNDICES
-- ============================================================

-- Para que un repartidor pueda ver rápidamente su historial de entregas
CREATE INDEX idx_deliveries_repartidor ON deliveries(repartidor_id);

-- Muy importante para el dashboard del Admin para ver cuáles están "EN_CAMINO" o "BUSCANDO_REPARTIDOR"
CREATE INDEX idx_deliveries_estado ON deliveries(estado);


-- ============================================================
-- 5. DATOS DE PRUEBA MAESTROS
-- ============================================================

INSERT INTO deliveries 
(pedido_id, repartidor_id, direccion_entrega, estado, observaciones) 
VALUES 
-- Delivery 1: Pedido recién salido, buscando quién lo lleve.
(101, NULL, 'Av. Libertador 123, Depto 4B', 'BUSCANDO_REPARTIDOR', 'Llamar al llegar al conserje'),

-- Delivery 2: Repartidor asignado (Diego, ID 5), yendo a buscarlo al local.
(102, 5, 'Calle Los Pinos 456, Casa 2', 'ASIGNADO', 'No funciona el timbre, tocar fuerte'),

-- Delivery 3: Diego ya lo retiró y va en camino hacia la casa del cliente.
(103, 5, 'Av. Providencia 789, Oficina 102', 'EN_CAMINO', 'Dejar en recepción'),

-- Delivery 4: Histórico, ya fue entregado por Diego.
(104, 5, 'Pasaje Los Aromos 321', 'ENTREGADO', NULL);