/* ============================================================
   ARCHIVO: 05-carrito.sql
   Microservicio: ms-carrito
   Responsabilidad: Gestionar los carritos de compra temporales de los usuarios.
   Base de Datos: carrito
   
   NOTA ARQUITECTÓNICA: 
   - usuario_id: FK Lógica a ms-usuarios
   - sucursal_id: FK Lógica a ms-sucursales
   - menu_item_id: FK Lógica a ms-menu
   Ninguna de estas tiene restricción FOREIGN KEY real en SQL porque 
   viven en bases de datos separadas.
   ============================================================ */

\c carrito;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA

DROP TABLE IF EXISTS carrito_items;
DROP TABLE IF EXISTS carritos;
DROP TABLE IF EXISTS clientes_proyeccion;
-- 2. TABLAS MAESTRAS

-- Tabla Padre: Carritos
CREATE TABLE carritos (
    id              BIGSERIAL       PRIMARY KEY,
    
    -- IDs de otros microservicios (Guardados como BIGINT porque son Long en Java)
    usuario_id      BIGINT          NOT NULL,
    sucursal_id     BIGINT          NOT NULL,
    
    -- NUMERIC(10,2) es el equivalente SQL perfecto para BigDecimal(precision=10, scale=2)
    total           NUMERIC(10, 2)  NOT NULL DEFAULT 0.00,
    
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    actualizado_en  TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Tabla Hija: Items del Carrito
CREATE TABLE carrito_items (
    id              BIGSERIAL       PRIMARY KEY,
    
    -- La llave foránea REAL que une el ítem con su carrito (Relación de JPA @ManyToOne)
    carrito_id      BIGINT          NOT NULL REFERENCES carritos(id) ON DELETE CASCADE,
    
    -- FK Lógica a ms-menu
    menu_item_id    BIGINT          NOT NULL,
    
    precio_unitario NUMERIC(10, 2)  NOT NULL,
    
    -- Validamos a nivel de BD que un cliente no pueda agregar "0" o "-5" hamburguesas
    cantidad        INT             NOT NULL CHECK (cantidad > 0),
    
    subtotal        NUMERIC(10, 2)  NOT NULL,

    -- Regla de negocio inteligente: Un mismo carrito no debería tener el menú_item_id 5 
    -- en dos filas distintas. Si el cliente pide otro, se debe sumar la cantidad a la fila existente.
    CONSTRAINT uk_carrito_menu_item UNIQUE (carrito_id, menu_item_id)
);

-- 3. ÍNDICES
-- Para encontrar rápidamente si un usuario ya tiene un carrito abierto:
CREATE INDEX idx_carritos_usuario ON carritos(usuario_id);
-- Para cargar rápido los ítems de un carrito específico:
CREATE INDEX idx_carrito_items_carrito_id ON carrito_items(carrito_id);

-- 4. DATOS DE PRUEBA (Data Seeding)
-- Simularemos que el Usuario 6 (Valentina, nuestra cliente del script anterior) 
-- tiene un carrito armándose para la Sucursal 1.

INSERT INTO carritos (usuario_id, sucursal_id, total) 
VALUES (6, 1, 15000.00); 
-- Asumimos que el Carrito recibe el ID 1

INSERT INTO carrito_items (carrito_id, menu_item_id, precio_unitario, cantidad, subtotal)
VALUES 
-- Valentina pidió 1 Pizza (Supongamos que en ms-menu la Pizza tiene ID 3 a $10.000)
(1, 3, 10000.00, 1, 10000.00),

-- Valentina pidió 2 Bebidas (Supongamos que la Bebida tiene ID 8 a $2.500 c/u)
(1, 8, 2500.00, 2, 5000.00);

-- El total del carrito (10000 + 5000) coincide con los 15000.00 guardados arriba.