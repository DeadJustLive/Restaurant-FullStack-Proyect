/* ============================================================
   ARCHIVO: 09-notificaciones.sql
   Microservicio: ms-notificaciones
   Responsabilidad: Registro y encolamiento de envíos de correos y alertas.
   Base de Datos: notificaciones
   ============================================================ */

\c notificaciones;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS notificaciones;

-- 2. TABLA MAESTRA
CREATE TABLE notificaciones (
    id              BIGSERIAL       PRIMARY KEY,
    
    destinatario    VARCHAR(255)    NOT NULL,
    
    -- Ajustado a tu Enum: EMAIL, SMS, PUSH
    tipo            VARCHAR(20)     NOT NULL 
        CHECK (tipo IN ('EMAIL', 'SMS', 'PUSH')),
    
    asunto          VARCHAR(150),
    cuerpo          TEXT            NOT NULL,
    
    -- Ajustado a tu Enum: PENDIENTE, ENVIADO, FALLIDO
    estado          VARCHAR(20)     NOT NULL DEFAULT 'PENDIENTE' 
        CHECK (estado IN ('PENDIENTE', 'ENVIADO', 'FALLIDO')),
    
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 3. ÍNDICES
CREATE INDEX idx_notificaciones_estado ON notificaciones(estado);
CREATE INDEX idx_notificaciones_destinatario ON notificaciones(destinatario);

-- 4. DATOS DE PRUEBA (Data Seeding ajustado a los nuevos estados)
INSERT INTO notificaciones 
(destinatario, tipo, asunto, cuerpo, estado) 
VALUES
-- 1. Un correo exitoso
('valentina.vargas@gmail.com', 'EMAIL', 'Tu pedido #101 está en camino', 'Hola Valentina, tu pizza ha salido...', 'ENVIADO'),

-- 2. Un PUSH pendiente a la app móvil
('device_token_xyz987', 'PUSH', '¡Tu pedido está listo!', 'Acércate al mostrador para retirar tu compra.', 'PENDIENTE'),

-- 3. Un SMS fallido
('+56966667777', 'SMS', NULL, 'TriskeleRest: Tu pedido #102 esta listo.', 'FALLIDO');