/* ============================================================
   ARCHIVO: 04-menu.sql
   Microservicio: ms-menu
   Responsabilidad: Catálogo de productos, precios y disponibilidad.
   Base de Datos: menu
   
   NOTA ARQUITECTÓNICA: 
   - categorias_proyeccion: Es una copia local de ms-categorias (vía Kafka).
   - sucursal_id: Es una FK Lógica (referencia a ms-sucursales).
   ============================================================ */

\c menu;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS menu_items;
DROP TABLE IF EXISTS categorias;
DROP TABLE IF EXISTS 

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
    
    -- Usamos NUMERIC(10,2) para precisión monetaria (evita errores de redondeo de float)
    precio          NUMERIC(10, 2)  NOT NULL CHECK (precio > 0),
    
    imagen_url      VARCHAR(500),
    disponible      BOOLEAN         NOT NULL DEFAULT TRUE,
    
    -- FK Física a nuestra TABLA DE PROYECCIÓN local
    categoria_id    BIGINT          NOT NULL REFERENCES categorias_proyeccion(id),
    
    -- FK Lógica (Solo el ID) a ms-sucursales. NULL significa "Disponible en todas".
    sucursal_id     BIGINT,
    
    -- Soft Delete
    eliminado       BOOLEAN         NOT NULL DEFAULT FALSE,
    
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en  TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ÍNDICES
CREATE INDEX idx_menu_items_categoria ON menu_items(categoria_id);
CREATE INDEX idx_menu_items_sucursal ON menu_items(sucursal_id);
-- Índice compuesto para filtrar rápido lo que el cliente realmente puede comprar
CREATE INDEX idx_menu_disponibilidad ON menu_items(disponible, eliminado);

-- DATOS DE PRUEBA

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
-- Pizza Global (Todas las sucursales)
('Pizza Pepperoni', 'Clásica pizza con doble pepperoni y mozzarella', 12990.00, 'https://cdn.tusistema.com/pepperoni.jpg', true, 1, NULL),

-- Pizza Específica (Solo Sucursal 1)
('Pizza de la Casa (Local 1)', 'Receta secreta del chef local', 15500.00, 'https://cdn.tusistema.com/casa.jpg', true, 2, 1),

-- Bebida
('Coca-Cola 1.5L', 'Bebida gaseosa original', 2500.00, 'https://cdn.tusistema.com/cola.jpg', true, 3, NULL),

-- Postre (No disponible por ahora)
('Tiramisú', 'Postre italiano con café y mascarpone', 4500.00, 'https://cdn.tusistema.com/tiramisu.jpg', false, 4, NULL);