# 💳 Microservicio: Pagos (ms-pagos)

## Propósito
Procesar las transacciones financieras y gestionar los comprobantes de pago (Boletas/Facturas).

## Estado Actual de Implementación: [SCAFFOLDING]
- **Estado:** Solo estructura de controladores y entidades.
- **Lógica:** Pendiente integración con pasarela de pagos (Webpay/Stripe).

## Arquitectura Objetivo
- Integración con servicios externos de pago.
- Generación automática de documentos tributarios.

## Limitaciones Actuales
- No procesa pagos reales. Los pedidos se marcan como "Pagados" mediante bypass manual en la demo.

## Dependencias Reales
- `ms-pedidos`: Origen de la obligación de pago.
