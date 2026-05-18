/* ============================================================
   ARCHIVO: 05-carrito.sql
   Microservicio: ms-carrito
   Responsabilidad: Gestionar los carritos de compra temporales de los usuarios.
   Base de Datos: carrito
   
   NOTA ARQUITECTÓNICA: 
   - proyeccion_clientes: Copia local de ms-auth/ms-usuarios (vía Kafka).
   - proyeccion_menu_items: Copia local de ms-menu (vía Kafka).
   ============================================================ */

\c carrito;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS carrito_items;
DROP TABLE IF EXISTS carritos;
DROP TABLE IF EXISTS proyeccion_menu_items;
DROP TABLE IF EXISTS proyeccion_clientes;

-- ============================================================
-- 2. PROYECCIONES (Datos de lectura provenientes de otros MS)
-- ============================================================

CREATE TABLE proyeccion_clientes (
    id_cliente      BIGINT PRIMARY KEY, -- Mismo ID generado en ms-auth/ms-usuarios
    nombre          VARCHAR(100) NOT NULL,
    email           VARCHAR(150) NOT NULL
);

CREATE TABLE proyeccion_menu_items (
    id_item         BIGINT PRIMARY KEY, -- Mismo ID generado en ms-menu
    nombre          VARCHAR(100) NOT NULL,
    precio          NUMERIC(10, 2) NOT NULL,
    disponible      BOOLEAN NOT NULL DEFAULT TRUE
);

-- POBLACIÓN DE DATOS DE PRUEBA EN LAS PROYECCIONES (Simulando eventos de Kafka)
INSERT INTO proyeccion_clientes (id_cliente, nombre, email) VALUES
(6, 'Valentina Silva', 'valentina.silva@email.com'),
(7, 'Juan Pérez', 'juan.perez@email.com');

INSERT INTO proyeccion_menu_items (id_item, nombre, precio, disponible) VALUES
(1, 'Pizza Pepperoni', 12990.00, true),
(2, 'Pizza de la Casa (Local 1)', 15500.00, true),
(3, 'Pizza Italiana Familiar', 10000.00, true), -- Usado en tu ejemplo original
(8, 'Coca-Cola 1.5L', 2500.00, true),           -- Usado en tu ejemplo original
(9, 'Tiramisú', 4500.00, false);


-- ============================================================
-- 3. TABLAS MAESTRAS (Dueño: ms-carrito)
-- ============================================================

-- Tabla Padre: Carritos
CREATE TABLE carritos (
    id              BIGSERIAL       PRIMARY KEY,
    
    -- FK Física a nuestra tabla de proyección local de Clientes
    usuario_id      BIGINT          NOT NULL REFERENCES proyeccion_clientes(id_cliente),
    
    -- FK Lógica (Solo el ID) a ms-sucursales.
    sucursal_id     BIGINT          NOT NULL,
    
    total           NUMERIC(10, 2)  NOT NULL DEFAULT 0.00,
    
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en  TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Tabla Hija: Items del Carrito
CREATE TABLE carrito_items (
    id              BIGSERIAL       PRIMARY KEY,
    
    -- Llave foránea REAL que une el ítem con su carrito (Relación ManyToOne de JPA)
    carrito_id      BIGINT          NOT NULL REFERENCES carritos(id) ON DELETE CASCADE,
    
    -- FK Física a nuestra tabla de proyección local de Menu Items
    menu_item_id    BIGINT          NOT NULL REFERENCES proyeccion_menu_items(id_item),
    
    precio_unitario NUMERIC(10, 2)  NOT NULL,
    
    -- Validamos a nivel de BD que un cliente no pueda agregar "0" o cantidades negativas
    cantidad        INT             NOT NULL CHECK (cantidad > 0),
    
    subtotal        NUMERIC(10, 2)  NOT NULL,

    -- Restricción de unicidad: Evita duplicar el mismo item en diferentes filas para un mismo carrito
    CONSTRAINT uk_carrito_menu_item UNIQUE (carrito_id, menu_item_id)
);

-- ============================================================
-- 4. ÍNDICES
-- ============================================================
-- Para encontrar rápidamente si un usuario ya tiene un carrito abierto:
CREATE INDEX idx_carritos_usuario ON carritos(usuario_id);
-- Para cargar rápido los ítems de un carrito específico:
CREATE INDEX idx_carrito_items_carrito_id ON carrito_items(carrito_id);


-- ============================================================
-- 5. DATOS DE PRUEBA EN TABLAS MAESTRAS (Data Seeding)
-- ============================================================
-- Registramos el carrito para la usuaria Valentina (ID 6) en la Sucursal 1.
INSERT INTO carritos (usuario_id, sucursal_id, total) 
VALUES (6, 1, 15000.00); 

-- Agregamos los ítems vinculados de forma íntegra a las proyecciones:
INSERT INTO carrito_items (carrito_id, menu_item_id, precio_unitario, cantidad, subtotal)
VALUES 
-- Valentina pidió 1 Pizza Italiana Familiar (ID 3 de la proyección)
(1, 3, 10000.00, 1, 10000.00),

-- Valentina pidió 2 Bebidas Coca-Cola 1.5L (ID 8 de la proyección)
(1, 8, 2500.00, 2, 5000.00);