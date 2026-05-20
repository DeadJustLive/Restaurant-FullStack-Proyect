# 📦 Microservicio: Inventario (ms-inventario)

## Propósito
Gestionar el stock de materias primas e insumos de cada sucursal, registrando movimientos de entrada y salida para el control de mermas y reabastecimiento.

## Estado Actual de Implementación: [✅ IMPLEMENTADO]
- **Funcional:** CRUD de Insumos con validación de nombres duplicados por sucursal, registro de movimientos (INGRESO/EGRESO/MERMA/AJUSTE), consulta de Kardex por insumo, control de stock mínimo.
- **Kafka Producer:** Publica `StockEventDTO` a `stock-events` con detección de `stockBajo`.
- **Feign:** `AuthFeignClient` para validación de permisos (con fallback degradado).
- **Persistencia:** Real en PostgreSQL.
- **Validaciones:** Control de stock suficiente para EGRESO/MERMA, unique constraint por sucursal+nombre.

## Arquitectura Objetivo
- Descuento automático de stock al finalizar un pedido en `ms-pedidos`.
- Generación de alertas automáticas de reabastecimiento vía `ms-notificaciones`.
- Integración de escaneo de códigos QR/Barras para movimientos de bodega.

## Limitaciones Actuales
- No existe integración con la venta real (el stock se debe mover manualmente o vía API).
- No maneja múltiples unidades de medida con conversión automática.

## Dependencias Reales
- `ms-sucursales`: Segmentación de stock por local físico.
- `ms-auth`: Protección de endpoints de auditoría de inventario.
