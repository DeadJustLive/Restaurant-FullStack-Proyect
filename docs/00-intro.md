# 🏪 Restaurant Platform — Proyecto de Microservicios

## 1. Descripción General
Plataforma SaaS para la gestión integral de restaurantes, construida sobre una arquitectura de **10 microservicios** que implementan los patrones **Database per Service**, **CQRS** (vía Kafka) y **Service Discovery** (vía Eureka).

Cada microservicio es un módulo Maven independiente con su propia base de datos PostgreSQL, expone APIs REST documentadas, y se comunica con los demás mediante **OpenFeign** (síncrono) y **Apache Kafka** (asíncrono).

## 2. Stack Tecnológico

| Componente | Versión |
| :--- | :--- |
| Java | 21 |
| Spring Boot | 3.5.14 |
| Spring Cloud | 2025.0.0 |
| Spring Security | 6.x (JWT con jjwt 0.11.5) |
| MapStruct | 1.5.5.Final |
| Lombok | 1.18.44 |
| PostgreSQL | 15 (Docker, puerto 5433) |
| Apache Kafka | Confluent 7.5.0 (Docker, puerto 9092) |
| Eureka Server | (Spring Cloud Netflix) |
| OpenFeign | (Spring Cloud) |
| Frontend | React 19 + TypeScript + Vite 8 |
| Estilos | Tailwind CSS + shadcn/ui |

## 3. Microservicios

| # | Servicio | Puerto | BD | Estado |
|---|----------|--------|----|--------|
| 1 | Eureka Server | 8761 | — | ✅ |
| 2 | ms-auth | 9001 | auth | ✅ 100% |
| 3 | ms-sucursales | 9003 | sucursales | 🔶 Scaffolding |
| 4 | ms-menu | 9004 | menu | ✅ 100% |
| 5 | ms-carrito | 9006 | carrito | 🔶 Scaffolding |
| 6 | ms-pedidos | 9007 | pedidos | ✅ 100% |
| 7 | ms-pagos | 9008 | pagos | 🔶 Scaffolding |
| 8 | ms-delivery | 9009 | delivery | 🔶 Scaffolding |
| 9 | ms-inventario | 9010 | inventario | ✅ 100% |
| 10 | ms-notificaciones | 9011 | notificaciones | 🔶 Scaffolding |
| 11 | ms-reportes | 9012 | reportes | 🔶 Scaffolding |

> **Nota:** Los microservicios `ms-usuarios` y `ms-categorias` fueron fusionados en `ms-auth` y `ms-menu` respectivamente durante la migración v12→v10. Ver [changelog](07-migration-changelog.md).

## 4. Estructura del Ecosistema de Documentación

```
docs/
├── 00-intro.md              ← Este archivo (intro + stack + tabla)
├── 01-architecture.md        ← Topología, principios, mapa de puertos
├── 02-security.md            ← Autenticación JWT + seguridad
├── 03-operations.md          ← Guía de inicio del sistema
├── 04-business-flows.md      ← Flujos de negocio (compra E2E)
├── 05-data-dictionary.md     ← Diccionario de datos + relaciones + CQRS
├── 06-backlog.md             ← Backlog y seguimiento
├── 07-migration-changelog.md ← Migración v12→v10
├── 08-postman-testing.md     ← Plan de pruebas Postman
├── services/                 ← Docs individuales por microservicio
│   ├── README.md
│   ├── ms-auth.md
│   ├── ms-sucursales.md
│   ├── ms-menu.md
│   ├── ms-carrito.md
│   ├── ms-pedidos.md
│   ├── ms-pagos.md
│   ├── ms-delivery.md
│   ├── ms-inventario.md
│   ├── ms-notificaciones.md
│   └── ms-reportes.md
└── PHASES/
    └── kafka-integration.md  ← Fase Kafka (COMPLETADA)
```
