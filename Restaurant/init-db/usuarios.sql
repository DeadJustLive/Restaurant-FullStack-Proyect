/* ============================================================
   ARCHIVO: 0X-usuarios.sql
   Microservicio: ms-usuarios
   Responsabilidad: Administrar el perfil público y de contacto de los usuarios.
   Base de Datos: usuarios_db
   
   NOTA ARQUITECTÓNICA: 
   Las credenciales (email/password/rol) NO viven aquí, viven en ms-auth.
   El puente entre ambos es la columna 'credencial_id'.
   ============================================================ */

\c usuarios;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS usuarios;

-- 2. TABLA MAESTRA
CREATE TABLE usuarios (
    -- Usamos BIGSERIAL porque en Java declaraste un Long (64 bits). SERIAL normal es Integer (32 bits).
    id              BIGSERIAL       PRIMARY KEY,
    
    -- El vínculo crucial con ms-auth. Usamos BIGINT para que coincida con el Long.
    credencial_id   BIGINT          NOT NULL,
    
    nombre          VARCHAR(100)    NOT NULL,
    apellido        VARCHAR(100)    NOT NULL,
    telefono        VARCHAR(20),
    direccion       VARCHAR(300),
    imagen_url      VARCHAR(500),
    
    -- FK lógica a ms-sucursales. Es NULL si el usuario es un Cliente.
    sucursal_id     BIGINT,         
    
    activo          BOOLEAN         NOT NULL DEFAULT TRUE,
    
    -- Fechas de auditoría usando el estándar profesional de zonas horarias
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en  TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,

    -- Restricción de unicidad para garantizar la relación 1 a 1 con ms-auth
    CONSTRAINT uk_credencial_id UNIQUE (credencial_id)
);

-- 3. ÍNDICES
-- (PostgreSQL ya crea un índice automático para la Primary Key y para la regla UNIQUE de credencial_id)
-- Creamos un índice para sucursal_id porque el Admin filtrará mucho a sus empleados por sucursal.
CREATE INDEX idx_usuarios_sucursal ON usuarios(sucursal_id);
-- Creamos un índice para activo para listar rápidamente solo al personal trabajando.
CREATE INDEX idx_usuarios_activo ON usuarios(activo);

-- 4. DATOS DE PRUEBA (Data Seeding)
-- Simularemos 6 perfiles asociados a 6 credenciales (que se crearían en el script de ms-auth).
-- Asumimos que la Sucursal 1 es "Sede Central".
INSERT INTO usuarios 
(credencial_id, nombre, apellido, telefono, direccion, sucursal_id, activo) 
VALUES
-- 1. Super Admin (No atado a una sucursal específica, es el dueño)
(1, 'Roberto', 'Dueñas', '+56911112222', 'Oficina Central', NULL, TRUE),

-- 2. Admin (Administrador de la Sucursal 1)
(2, 'Carla', 'Méndez', '+56922223333', 'Las Condes 123', 1, TRUE),

-- 3. Cocinero (Trabaja en la Sucursal 1)
(3, 'Pedro', 'Pinto', '+56933334444', 'Providencia 456', 1, TRUE),

-- 4. Mesero (Trabaja en la Sucursal 1)
(4, 'Sofia', 'Soto', '+56944445555', 'Ñuñoa 789', 1, TRUE),

-- 5. Repartidor (Asignado a la Sucursal 1)
(5, 'Diego', 'Tapia', '+56955556666', 'Macul 321', 1, TRUE),

-- 6. Cliente (No tiene sucursal asignada, pide a domicilio)
(6, 'Valentina', 'Vargas', '+56966667777', 'La Florida 987', NULL, TRUE);