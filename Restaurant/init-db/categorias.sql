/* ============================================================
   ARCHIVO: 0X-categorias.sql
   Microservicio: ms-categorias
   Responsabilidad: Gestión de categorías de productos.
   Base de Datos: categorias_db
   ============================================================ */

\c categorias;

-- 1. ELIMINACIÓN DE TABLA (En caso de re-ejecución)
DROP TABLE IF EXISTS categorias;

-- 2. CREACIÓN DE TABLA
CREATE TABLE categorias (
    id              BIGSERIAL       PRIMARY KEY,
    nombre          VARCHAR(100)    NOT NULL,
    descripcion     VARCHAR(255),
    
    -- Flag operativo para Soft Delete
    activa          BOOLEAN         NOT NULL DEFAULT TRUE,
    
    -- Auditoría (Hibernate usará estas columnas)
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en  TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,

    -- Restricción de unicidad (Equivalente al @UniqueConstraint de Java)
    CONSTRAINT uk_categoria_nombre UNIQUE (nombre)
);

-- 3. ÍNDICES (Para optimizar el rendimiento)
-- Ideal para filtrar rápido las categorías que se mostrarán en la App
CREATE INDEX idx_categorias_activa ON categorias(activa);

-- 4. DATOS DE PRUEBA (Seeding inicial)
INSERT INTO categorias (nombre, descripcion, activa) VALUES
('Pizzas Tradicionales', 'Nuestra selección clásica de masa artesanal.', true),
('Pizzas Gourmet', 'Ingredientes premium y combinaciones únicas.', true),
('Entradas', 'Palos de ajo, alitas de pollo y más.', true),
('Bebidas', 'Refrescos, jugos naturales y cervezas.', true),
('Postres', 'El toque dulce para terminar la jornada.', true),
('Promociones', 'Combos especiales por tiempo limitado.', false);