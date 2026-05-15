/* ============================================================
   ARCHIVO: 0X-menu.sql
   Microservicio: ms-menu
   Responsabilidad: Catálogo de productos, precios y disponibilidad.
   Base de Datos: menu_db
   
   NOTA ARQUITECTÓNICA: 
   - categorias_proyeccion: Es una copia local de ms-categorias (vía Kafka).
   - sucursal_id: Es una FK Lógica (referencia a ms-sucursales).
   ============================================================ */

\c menu;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS menu_items;
DROP TABLE IF EXISTS categorias_proyeccion;

-- 2. TABLAS DE PROYECCIÓN (Copia local de otros microservicios)
CREATE TABLE categorias_proyeccion (
    id          BIGINT          PRIMARY KEY, -- ID viene de ms-categorias
    nombre      VARCHAR(100)    NOT NULL,
    activa      BOOLEAN         NOT NULL DEFAULT TRUE
);

-- 3. TABLA MAESTRA
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

-- 4. ÍNDICES (Para que el menú cargue volando)
CREATE INDEX idx_menu_items_categoria ON menu_items(categoria_id);
CREATE INDEX idx_menu_items_sucursal ON menu_items(sucursal_id);
-- Índice compuesto para filtrar rápido lo que el cliente realmente puede comprar
CREATE INDEX idx_menu_disponibilidad ON menu_items(disponible, eliminado);

-- 5. DATOS DE PRUEBA (Data Seeding)

-- Primero "proyectamos" algunas categorías (Simulando que llegaron por Kafka)
INSERT INTO categorias_proyeccion (id, nombre, activa) VALUES
(1, 'Pizzas Tradicionales', true),
(2, 'Pizzas Premium', true),
(3, 'Bebidas', true),
(4, 'Postres', true);

-- Luego insertamos los productos
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