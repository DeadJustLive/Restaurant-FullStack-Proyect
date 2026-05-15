/* ============================================================
   ARCHIVO: 0X-delivery.sql
   Microservicio: ms-delivery
   Responsabilidad: Gestionar la logística y el estado de entrega de los pedidos.
   Base de Datos: delivery_db
   
   NOTA ARQUITECTÓNICA: 
   - pedido_id: FK Lógica a ms-pedidos (1 a 1, un pedido tiene un solo delivery)
   - repartidor_id: FK Lógica a ms-usuarios (Rol REPARTIDOR)
   ============================================================ */

\c delivery;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS deliveries;

-- 2. TABLA MAESTRA
CREATE TABLE deliveries (
    id                  BIGSERIAL       PRIMARY KEY,
    
    -- El vínculo con el pedido original. Es UNIQUE porque 1 pedido = 1 delivery.
    pedido_id           BIGINT          NOT NULL UNIQUE,
    
    -- El repartidor asignado. Puede ser NULL al principio cuando está "BUSCANDO_REPARTIDOR"
    repartidor_id       BIGINT,
    
    direccion_entrega   VARCHAR(300)    NOT NULL,
    
    -- AQUÍ ESTÁ LA MAGIA DEL ENUM: Guardamos el texto, pero restringimos las opciones.
    estado              VARCHAR(20)     NOT NULL DEFAULT 'BUSCANDO_REPARTIDOR'
        CHECK (estado IN ('BUSCANDO_REPARTIDOR', 'ASIGNADO', 'EN_CAMINO', 'ENTREGADO', 'CANCELADO')),
    
    -- Usamos TEXT porque las observaciones pueden ser muy largas ("Tocar el timbre 3 veces, casa roja con reja negra...")
    observaciones       TEXT,
    
    creado_en           TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en      TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 3. ÍNDICES
-- Muy importante para que el Repartidor vea rápidamente "Sus" deliveries asignados
CREATE INDEX idx_deliveries_repartidor ON deliveries(repartidor_id);
-- Muy importante para el dashboard del Admin para ver cuáles están "EN_CAMINO"
CREATE INDEX idx_deliveries_estado ON deliveries(estado);

-- 4. DATOS DE PRUEBA (Data Seeding)
INSERT INTO deliveries 
(pedido_id, repartidor_id, direccion_entrega, estado, observaciones) 
VALUES 
-- Delivery 1: Recién salido de la cocina, esperando repartidor (Sin repartidor asignado)
(101, NULL, 'Av. Libertador 123, Depto 4B', 'BUSCANDO_REPARTIDOR', 'Llamar al llegar al conserje'),

-- Delivery 2: Repartidor asignado (Diego, ID 5 de nuestro script de usuarios), yendo a buscarlo
(102, 5, 'Calle Los Pinos 456, Casa 2', 'ASIGNADO', 'No funciona el timbre, tocar fuerte'),

-- Delivery 3: En camino hacia la casa del cliente
(103, 5, 'Av. Providencia 789, Oficina 102', 'EN_CAMINO', 'Dejar en recepción'),

-- Delivery 4: Ya entregado históricamente
(104, 5, 'Pasaje Los Aromos 321', 'ENTREGADO', NULL);