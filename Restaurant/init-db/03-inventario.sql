/* ============================================================
   ARCHIVO: 03-inventario.sql
   Microservicio: ms-inventario
   Responsabilidad: Controlar el stock de insumos físicos por sucursal y su Kardex (historial).
   Base de Datos: inventario
   
   NOTA ARQUITECTÓNICA: 
   - sucursal_id: FK Lógica a ms-sucursales.
   ============================================================ */

\c inventario;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS movimientos_inventario;
DROP TABLE IF EXISTS insumos;

-- 2. TABLAS MAESTRAS

-- Tabla Padre: Los insumos físicos de cada local
CREATE TABLE insumos (
    id              BIGSERIAL       PRIMARY KEY,
    sucursal_id     BIGINT          NOT NULL,
    nombre          VARCHAR(100)    NOT NULL,
    unidad_medida   VARCHAR(20)     NOT NULL, -- Ej: 'KG', 'LITROS', 'UNIDADES'
    
    -- NUMERIC(10,3) soporta hasta 9.999.999,999 (Perfecto para gramos/mililitros)
    stock_actual    NUMERIC(10, 3)  NOT NULL DEFAULT 0.000,
    stock_minimo    NUMERIC(10, 3)  NOT NULL DEFAULT 0.000,
    
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en  TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,

    -- Restricción UNIQUE de tu Entity: La Sucursal 1 no puede tener dos insumos llamados "Tomate"
    CONSTRAINT uk_insumo_sucursal_nombre UNIQUE (sucursal_id, nombre)
);

-- Tabla Hija: El Kardex (Historial inmutable de entradas y salidas)
CREATE TABLE movimientos_inventario (
    id              BIGSERIAL       PRIMARY KEY,
    
    -- FK Real a la tabla insumos. Usamos RESTRICT para proteger la auditoría: 
    -- NO puedes borrar un insumo si ya tiene historial de movimientos.
    insumo_id       BIGINT          NOT NULL REFERENCES insumos(id) ON DELETE RESTRICT,
    
    -- Restringimos los textos al Enum de tu código Java
    tipo            VARCHAR(20)     NOT NULL CHECK (tipo IN ('INGRESO', 'EGRESO', 'MERMA', 'AJUSTE')),
    
    -- Validamos que los movimientos no sean de cantidad cero o negativa (Para restar, se usa el tipo EGRESO/MERMA)
    cantidad        NUMERIC(10, 3)  NOT NULL CHECK (cantidad > 0),
    
    -- Para saber por qué se movió: "Compra a proveedor", "Pedido #105", "Se echó a perder"
    referencia      VARCHAR(255),
    
    -- Solo fecha de creación, sin actualización, para mantener la inmutabilidad
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 3. ÍNDICES
-- El Admin siempre va a buscar el stock filtrando por su sucursal
CREATE INDEX idx_insumos_sucursal ON insumos(sucursal_id);
-- Para cargar rápido el historial de un insumo específico
CREATE INDEX idx_movimientos_insumo ON movimientos_inventario(insumo_id);

-- 4. DATOS DE PRUEBA (Data Seeding)
-- Vamos a crear insumos para la Sucursal 1

INSERT INTO insumos (sucursal_id, nombre, unidad_medida, stock_actual, stock_minimo) VALUES
(1, 'Harina de Trigo', 'KG', 50.000, 10.000),
(1, 'Queso Mozzarella', 'KG', 15.500, 5.000),
(1, 'Salsa de Tomate', 'LITROS', 8.000, 3.000),
(1, 'Cajas de Pizza', 'UNIDADES', 150.000, 50.000);

-- Vamos a registrar cómo es que llegaron a tener ese stock (El Kardex)
INSERT INTO movimientos_inventario (insumo_id, tipo, cantidad, referencia) VALUES
-- Insumo 1 (Harina)
(1, 'INGRESO', 55.000, 'Factura Compra Proveedor Molino #9982'),
(1, 'EGRESO', 5.000, 'Uso en cocina para masa turno mañana'), -- Por eso el stock actual es 50

-- Insumo 2 (Queso)
(2, 'INGRESO', 16.000, 'Factura Compra Lácteos Sur #102'),
(2, 'MERMA', 0.500, 'Se cayó al suelo durante la preparación'), -- Por eso el stock actual es 15.5

-- Insumo 4 (Cajas)
(4, 'INGRESO', 200.000, 'Compra Empaques Ltda'),
(4, 'EGRESO', 50.000, 'Pedidos de la semana (100 al 150)');