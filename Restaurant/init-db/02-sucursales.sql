/* ============================================================
   ARCHIVO: 0X-sucursales.sql
   Microservicio: ms-sucursales
   Responsabilidad: Gestión de locales físicos y datos de contacto.
   Base de Datos: sucursales_db
   
   NOTA ARQUITECTÓNICA: 
   - Esta es una tabla maestra. 
   - Otras bases de datos guardan el 'sucursal_id' como FK lógica.
   ============================================================ */

\c sucursales;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS sucursales;

-- 2. TABLA MAESTRA
CREATE TABLE sucursales (
    id              BIGSERIAL       PRIMARY KEY,
    nombre          VARCHAR(100)    NOT NULL,
    direccion       VARCHAR(255)    NOT NULL,
    telefono        VARCHAR(20),
    
    -- Flag operativo (Soft Delete)
    -- Si es FALSE, el ms-pedidos debe rechazar transacciones para este ID.
    activa          BOOLEAN         NOT NULL DEFAULT TRUE,
    
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en  TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 3. ÍNDICES
-- El frontend y otros servicios filtrarán constantemente por sucursales abiertas
CREATE INDEX idx_sucursales_activa ON sucursales(activa);

-- Búsqueda por nombre para administradores
CREATE INDEX idx_sucursales_nombre ON sucursales(nombre);

-- 4. DATOS DE PRUEBA (Data Seeding)
INSERT INTO sucursales 
(nombre, direccion, telefono, activa) 
VALUES
('Casa Matriz - Providencia', 'Av. Providencia 1234, Santiago', '+56222223333', true),
('Sucursal Las Condes', 'Av. Apoquindo 4500, Las Condes', '+56222224444', true),
('Sucursal Viña del Mar', 'Libertad 600, Viña del Mar', '+56322225555', true),
('Sucursal Ñuñoa (Cerrada)', 'Irarrázaval 3000, Ñuñoa', '+56222226666', false);