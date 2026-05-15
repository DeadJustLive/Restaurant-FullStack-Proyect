/* ============================================================
   ARCHIVO: 0X-auth.sql
   Microservicio: ms-auth
   Responsabilidad: Gestión de identidades, contraseñas y roles. Emisión de JWT.
   Base de Datos: auth_db
   
   NOTA ARQUITECTÓNICA: 
   Esta es la Bóveda de Seguridad. Solo este microservicio 
   conoce las contraseñas. El ID generado aquí (BIGSERIAL) 
   es el que ms-usuarios guardará como 'credencial_id'.
   ============================================================ */

\c auth;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS user_credentials;

-- 2. TABLA MAESTRA
CREATE TABLE user_credentials (
    -- PK que será el claim 'sub' en el JWT y el credencial_id en ms-usuarios
    id              BIGSERIAL       PRIMARY KEY,
    
    username        VARCHAR(100)    NOT NULL,
    password        VARCHAR(255)    NOT NULL,
    
    -- Restringimos los roles exactamente a los 6 definidos en tu restaurante.
    -- Nota: Al usar @Enumerated(EnumType.STRING) en Java, se guardan en mayúsculas por defecto.
    rol             VARCHAR(20)     NOT NULL CHECK (rol IN ('SUPER_ADMIN', 'ADMIN', 'COCINERO', 'MESERO', 'REPARTIDOR', 'CLIENTE')),
    
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
('roberto.admin@restaurant.cl', '$2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36WQoeG6Lruj3vjPGGa.MeC', 'SUPER_ADMIN', TRUE),

-- ID 2: Admin de Sucursal 1 (Carla Méndez en ms-usuarios)
('carla.mendez@restaurant.cl', '$2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36WQoeG6Lruj3vjPGGa.MeC', 'ADMIN', TRUE),

-- ID 3: Cocinero (Pedro Pinto en ms-usuarios)
('pedro.pinto@restaurant.cl', '$2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36WQoeG6Lruj3vjPGGa.MeC', 'COCINERO', TRUE),

-- ID 4: Mesero (Sofia Soto en ms-usuarios)
('sofia.soto@restaurant.cl', '$2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36WQoeG6Lruj3vjPGGa.MeC', 'MESERO', TRUE),

-- ID 5: Repartidor (Diego Tapia en ms-usuarios)
('diego.tapia@restaurant.cl', '$2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36WQoeG6Lruj3vjPGGa.MeC', 'REPARTIDOR', TRUE),

-- ID 6: Cliente (Valentina Vargas en ms-usuarios)
('valentina.vargas@gmail.com', '$2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36WQoeG6Lruj3vjPGGa.MeC', 'CLIENTE', TRUE);