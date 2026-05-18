/* ============================================================
   ARCHIVO: 01-auth.sql
   Microservicio: ms-auth
   Responsabilidad: Gestión de identidades, contraseñas y roles. Emisión de JWT.
   Base de Datos: auth
   
   NOTA ARQUITECTÓNICA: 
   Esta es la Bóveda de Seguridad. Solo este microservicio 
   conoce las contraseñas. El ID generado aquí (BIGSERIAL) 
   es el que ms-usuarios guardará como 'credencial_id'.
   ============================================================ */

\c auth;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS user_credentials;
DROP TABLE IF EXISTS usuarios;

-- 2. TABLA MAESTRA
CREATE TABLE user_credentials (
    -- PK que será el claim 'sub' en el JWT y el credencial_id en ms-usuarios
    id              BIGSERIAL       PRIMARY KEY,
    
    username        VARCHAR(100)    NOT NULL,
    password        VARCHAR(255)    NOT NULL,
    
    -- Restringimos los roles exactamente a los 6 definidos en tu restaurante (ROLE_SA, ROLE_AD, ROLE_CO, ROLE_ME, ROLE_RP, ROLE_CL).
    -- Nota: Al usar @Enumerated(EnumType.STRING) en Java, se guardan en mayúsculas por defecto.
    rol             VARCHAR(20)     NOT NULL CHECK (rol IN ('ROLE_SA', 'ROLE_AD', 'ROLE_CO', 'ROLE_ME', 'ROLE_RP', 'ROLE_CL')),
    
    activo          BOOLEAN         NOT NULL DEFAULT TRUE,
    
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en  TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
 
    -- Constraint de unicidad que definiste en el Entity
    CONSTRAINT uk_username UNIQUE (username)
);
 
-- 3. ÍNDICES
-- Creamos un índice para 'username' porque CADA VEZ que alguien haga login,
-- la base de datos tendrá que buscar rápidamente en esta columna.
CREATE INDEX idx_user_credentials_username ON user_credentials(username);
 
-- 4. DATOS DE PRUEBA (Data Seeding sincronizado con ms-usuarios)
-- IMPORTANTE: Todas las contraseñas aquí son '123456', pero están 
-- encriptadas con el algoritmo BCrypt (costo 10), tal como exige tu proyecto.
INSERT INTO user_credentials 
(username, password, rol, activo) 
VALUES
-- ID 1: Super Admin (Roberto Dueñas en ms-usuarios)
('roberto.admin@restaurant.cl', '$2a$10$1sPnz9oX7wNmCKXNJChky.SA6Z9sU0h8gYH17DZdaxr5PN1fqFcSe', 'ROLE_SA', TRUE),
 
-- ID 2: Admin de Sucursal 1 (Carla Méndez en ms-usuarios)
('carla.mendez@restaurant.cl', '$2a$10$1sPnz9oX7wNmCKXNJChky.SA6Z9sU0h8gYH17DZdaxr5PN1fqFcSe', 'ROLE_AD', TRUE),
 
-- ID 3: Cocinero (Pedro Pinto en ms-usuarios)
('pedro.pinto@restaurant.cl', '$2a$10$1sPnz9oX7wNmCKXNJChky.SA6Z9sU0h8gYH17DZdaxr5PN1fqFcSe', 'ROLE_CO', TRUE),
 
-- ID 4: Mesero (Sofia Soto en ms-usuarios)
('sofia.soto@restaurant.cl', '$2a$10$1sPnz9oX7wNmCKXNJChky.SA6Z9sU0h8gYH17DZdaxr5PN1fqFcSe', 'ROLE_ME', TRUE),
 
-- ID 5: Repartidor (Diego Tapia en ms-usuarios)
('diego.tapia@restaurant.cl', '$2a$10$1sPnz9oX7wNmCKXNJChky.SA6Z9sU0h8gYH17DZdaxr5PN1fqFcSe', 'ROLE_RP', TRUE),
 
-- ID 6: Cliente (Valentina Vargas en ms-usuarios)
('valentina.vargas@gmail.com', '$2a$10$1sPnz9oX7wNmCKXNJChky.SA6Z9sU0h8gYH17DZdaxr5PN1fqFcSe', 'ROLE_CL', TRUE);

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