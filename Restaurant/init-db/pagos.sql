/* ============================================================
   ARCHIVO: 0X-pagos.sql
   Microservicio: ms-pagos
   Responsabilidad: Procesar transacciones financieras e integrarse con pasarelas (ej: Transbank, Stripe).
   Base de Datos: pagos_db
   
   NOTA ARQUITECTÓNICA: 
   - pedido_id: FK Lógica a ms-pedidos. NO es único, porque un pedido
     puede tener múltiples intentos de pago (rechazados antes del aprobado).
   ============================================================ */

\c pagos;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS pagos;

-- 2. TABLA MAESTRA
CREATE TABLE pagos (
    id              BIGSERIAL       PRIMARY KEY,
    
    -- El vínculo con ms-pedidos
    pedido_id       BIGINT          NOT NULL,
    
    -- El dinero siempre se maneja en NUMERIC(10,2) para evitar problemas de redondeo
    monto           NUMERIC(10, 2)  NOT NULL CHECK (monto > 0),
    
    -- Ajustado a tu Enum: EFECTIVO, TARJETA_CREDITO, TARJETA_DEBITO, TRANSFERENCIA
    metodo          VARCHAR(20)     NOT NULL 
        CHECK (metodo IN ('EFECTIVO', 'TARJETA_CREDITO', 'TARJETA_DEBITO', 'TRANSFERENCIA')),
    
    -- Ajustado a tu Enum: PENDIENTE, APROBADO, RECHAZADO, REEMBOLSADO
    estado          VARCHAR(20)     NOT NULL DEFAULT 'PENDIENTE' 
        CHECK (estado IN ('PENDIENTE', 'APROBADO', 'RECHAZADO', 'REEMBOLSADO')),
    
    -- ID de la pasarela de pagos externa (ej: el código de autorización de Transbank)
    transaccion_id  VARCHAR(100),
    
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en  TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 3. ÍNDICES
-- Para cargar rápidamente todos los intentos de pago de un pedido específico
CREATE INDEX idx_pagos_pedido ON pagos(pedido_id);

-- Para que el sistema de conciliación bancaria filtre los aprobados/reembolsados
CREATE INDEX idx_pagos_estado ON pagos(estado);

-- Para buscar un pago específico cuando el cliente llame dando su código de comprobante
CREATE INDEX idx_pagos_transaccion ON pagos(transaccion_id);

-- 4. DATOS DE PRUEBA (Data Seeding)
INSERT INTO pagos 
(pedido_id, monto, metodo, estado, transaccion_id) 
VALUES
-- Intento 1: Un pago aprobado sin problemas a la primera
(101, 15000.00, 'TARJETA_DEBITO', 'APROBADO', 'TX-99887766'),

-- Intento 2 y 3: Un cliente cuya tarjeta de crédito falló (sin fondos), pero luego pagó con transferencia
(102, 25500.00, 'TARJETA_CREDITO', 'RECHAZADO', 'TX-55443322'),
(102, 25500.00, 'TRANSFERENCIA', 'APROBADO', 'TRX-BCO-112233'),

-- Intento 4: Un pedido que se pagará en efectivo cuando llegue el repartidor a la casa
(103, 12000.00, 'EFECTIVO', 'PENDIENTE', NULL),

-- Intento 5: Un pedido que se canceló y se le devolvió el dinero al cliente
(104, 8500.00, 'TARJETA_DEBITO', 'REEMBOLSADO', 'TX-REFUND-111');