# 📜 Microservicio: Menú (ms-menu)

## Propósito
Gestionar el catálogo de platos, precios y disponibilidad de la oferta gastronómica del restaurante.

## Estado Actual de Implementación: [PARCIALMENTE IMPLEMENTADO]
- **Funcional:** Estructura de base de datos para MenuItems.
- **Scaffolding:** El servicio cuenta con la lógica básica de CRUD pero falta la integración de precios dinámicos por sucursal.
- **Puerto Real:** 9004.

## Arquitectura Objetivo
- Validación de disponibilidad en tiempo real basada en el stock de `ms-inventario`.
- Gestión de modificadores (extras, términos de carne, etc.).
- Sincronización con `ms-categorias` para filtrado eficiente.

## Limitaciones Actuales
- No valida si una categoría existe realmente antes de asociarla al plato (falta integración Feign).
- Los precios son globales y no varían por sucursal aún.

## Dependencias Reales
- `ms-categorias`: Para la taxonomía del catálogo.
- `ms-eureka`: Para el registro en el ecosistema.
