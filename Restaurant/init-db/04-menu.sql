/* ============================================================
   ARCHIVO: 04-menu.sql
   Microservicio: ms-menu
   Responsabilidad: Catálogo de productos, precios, categorías y disponibilidad.
   Base de Datos: menu
   
   NOTA ARQUITECTÓNICA: 
   - proyeccion_sucursales: Es una copia local de ms-sucursales (Kafka).
   ============================================================ */

\c menu;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS menu_items;
DROP TABLE IF EXISTS categorias;
DROP TABLE IF EXISTS proyeccion_sucursales;

-- ============================================================
-- 2. PROYECCIONES (Datos de lectura desde otros MS)
-- ============================================================

CREATE TABLE proyeccion_sucursales (
    id_sucursal BIGINT PRIMARY KEY, -- Mismo ID generado en ms-sucursales
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    activa BOOLEAN NOT NULL DEFAULT TRUE
);

-- DATOS DE PRUEBA DE PROYECCIÓN (Simulando lo que llega por Kafka)
INSERT INTO proyeccion_sucursales (id_sucursal, nombre, direccion, activa) 
VALUES
(1, 'Casa Matriz - Providencia', 'Av. Providencia 1234, Santiago', true),
(2, 'Sucursal Las Condes', 'Av. Apoquindo 4500, Las Condes', true),
(3, 'Sucursal Viña del Mar', 'Libertad 600, Viña del Mar', true),
(4, 'Sucursal Ñuñoa (Cerrada)', 'Irarrázaval 3000, Ñuñoa', false);


-- ============================================================
-- 3. TABLAS MAESTRAS (Dueño: ms-menu)
-- ============================================================

CREATE TABLE categorias (
    id              BIGSERIAL       PRIMARY KEY,
    nombre          VARCHAR(100)    NOT NULL,
    descripcion     VARCHAR(255),
    activa          BOOLEAN         NOT NULL DEFAULT TRUE,
    
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en  TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,

    -- Restricción de unicidad 
    CONSTRAINT uk_categoria_nombre UNIQUE (nombre)
);

CREATE TABLE menu_items (
    id              BIGSERIAL       PRIMARY KEY,
    nombre          VARCHAR(100)    NOT NULL,
    descripcion     TEXT,
    
    -- Usamos NUMERIC(10,2) para precisión monetaria
    precio          NUMERIC(10, 2)  NOT NULL CHECK (precio > 0),
    
    imagen_url      VARCHAR(500),
    disponible      BOOLEAN         NOT NULL DEFAULT TRUE,
    
    -- FK Física a la tabla local de categorías
    categoria_id    BIGINT          NOT NULL REFERENCES categorias(id),
    
    -- FK a nuestra tabla de proyección local de sucursales
    -- NULL significa "Disponible en todas las sucursales".
    sucursal_id     BIGINT          REFERENCES proyeccion_sucursales(id_sucursal),
    
    -- Soft Delete
    eliminado       BOOLEAN         NOT NULL DEFAULT FALSE,
    
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en  TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 4. ÍNDICES
CREATE INDEX idx_menu_items_categoria ON menu_items(categoria_id);
CREATE INDEX idx_menu_items_sucursal ON menu_items(sucursal_id);
CREATE INDEX idx_menu_disponibilidad ON menu_items(disponible, eliminado);

-- ============================================================
-- 5. DATOS DE PRUEBA MAESTROS
-- ============================================================

INSERT INTO categorias (nombre, descripcion, activa) VALUES
('Pizzas Tradicionales', 'Nuestra selección clásica de masa artesanal.', true),
('Pizzas Gourmet', 'Ingredientes premium y combinaciones únicas.', true),
('Entradas', 'Palos de ajo, alitas de pollo y más.', true),
('Bebidas', 'Refrescos, jugos naturales y cervezas.', true),
('Postres', 'El toque dulce para terminar la jornada.', true),
('Promociones', 'Combos especiales por tiempo limitado.', false);

INSERT INTO menu_items 
(nombre, descripcion, precio, imagen_url, disponible, categoria_id, sucursal_id) 
VALUES
-- Pizza Global (Todas las sucursales - sucursal_id es NULL)
('Pizza Pepperoni', 'Clásica pizza con doble pepperoni y mozzarella', 12990.00, 'https://cdn.tusistema.com/pepperoni.jpg', true, 1, NULL),

-- Pizza Específica (Solo Sucursal 1 - Providencia)
('Pizza de la Casa (Local 1)', 'Receta secreta del chef local', 15500.00, 'https://cdn.tusistema.com/casa.jpg', true, 2, 1),

-- Bebida (Todas las sucursales)
('Coca-Cola 1.5L', 'Bebida gaseosa original', 2500.00, 'https://cdn.tusistema.com/cola.jpg', true, 4, NULL),

-- Postre (No disponible por ahora)
('Tiramisú', 'Postre italiano con café y mascarpone', 4500.00, 'https://cdn.tusistema.com/tiramisu.jpg', false, 5, NULL);