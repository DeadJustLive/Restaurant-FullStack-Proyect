/* ============================================================
   ARCHIVO: 0X-reportes.sql
   Microservicio: ms-reportes
   Responsabilidad: Almacenar snapshots precalculados de métricas y estadísticas.
   Base de Datos: reportes_db
   
   NOTA ARQUITECTÓNICA: 
   - Esta tabla es de "Solo Inserción" (Append-Only). No hay actualizaciones.
   - data_json guarda la estructura flexible del reporte.
   ============================================================ */

\c reportes;

-- 1. ELIMINACIÓN EN JERARQUÍA INVERSA
DROP TABLE IF EXISTS reporte_snapshots;

-- 2. TABLA MAESTRA
CREATE TABLE reporte_snapshots (
    id              BIGSERIAL       PRIMARY KEY,
    
    -- FK Lógica a ms-sucursales. NULL significa que es un reporte "Global" del restaurante
    sucursal_id     BIGINT,
    
    -- Ajustado estricto a tu Enum
    tipo            VARCHAR(50)     NOT NULL 
        CHECK (tipo IN ('VENTAS_DIARIAS', 'TOP_PLATOS', 'KARDEX_MENSUAL', 'RENDIMIENTO_REPARTIDORES')),
    
    -- En PostgreSQL puro, lo ideal a futuro es cambiar TEXT por JSONB. 
    -- Por ahora usamos TEXT respetando tu entidad Java.
    data_json       TEXT            NOT NULL,
    
    -- Los reportes son inmutables (fotografías en el tiempo), por eso solo hay creado_en
    creado_en       TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 3. ÍNDICES (Optimizados para dashboards)
-- El dueño casi siempre buscará: "Dame las VENTAS_DIARIAS de la Sucursal Providencia"
CREATE INDEX idx_reportes_sucursal_tipo ON reporte_snapshots(sucursal_id, tipo);

-- Los dashboards siempre filtran por fechas: "Dame los reportes de este mes"
CREATE INDEX idx_reportes_fecha ON reporte_snapshots(creado_en);

-- 4. DATOS DE PRUEBA (Data Seeding con JSON simulado)
INSERT INTO reporte_snapshots 
(sucursal_id, tipo, data_json) 
VALUES
-- 1. Reporte GLOBAL de Ventas Diarias (sucursal_id es NULL)
(NULL, 'VENTAS_DIARIAS', '{
    "fecha": "2026-05-04",
    "total_ventas": 1250000.00,
    "cantidad_pedidos": 85,
    "ticket_promedio": 14705.88,
    "metodos_pago": {"TARJETA_DEBITO": 60, "TARJETA_CREDITO": 20, "EFECTIVO": 5}
}'),

-- 2. Reporte de Platos más vendidos (Específico para la Sucursal 1)
(1, 'TOP_PLATOS', '{
    "mes": "Mayo",
    "anio": 2026,
    "ranking": [
        {"menu_item_id": 1, "nombre": "Pizza Pepperoni", "cantidad_vendida": 400},
        {"menu_item_id": 3, "nombre": "Pizza de la Casa (Local 1)", "cantidad_vendida": 250}
    ]
}'),

-- 3. Reporte de Rendimiento de los Repartidores (Global)
(NULL, 'RENDIMIENTO_REPARTIDORES', '{
    "semana": "18-2026",
    "repartidores": [
        {"repartidor_id": 5, "nombre": "Diego Tapia", "entregas_exitosas": 120, "tiempo_promedio_min": 22.5},
        {"repartidor_id": 8, "nombre": "Luis Silva", "entregas_exitosas": 95, "tiempo_promedio_min": 28.1}
    ]
}'),

-- 4. Reporte Kardex de la Sucursal 1 (Cierre de mes)
(1, 'KARDEX_MENSUAL', '{
    "mes": "Abril",
    "anio": 2026,
    "alertas_stock": [
        {"insumo_id": 2, "nombre": "Queso Mozzarella", "stock_actual": 15.5, "stock_minimo": 5.0}
    ],
    "mermas_totales_clp": 45000.00
}');