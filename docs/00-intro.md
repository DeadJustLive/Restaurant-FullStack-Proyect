# 🍽️ Restaurant Platform — Proyecto de Microservicios

## 📝 Descripción General
Este es un proyecto semestral diseñado bajo una arquitectura de microservicios utilizando **Java 21** y **Spring Boot 3.5**. El sistema está orientado a la gestión integral de un restaurante, cubriendo desde la administración de sucursales y menús hasta el procesamiento de pedidos, pagos, inventario y reportes consolidados.

## 🛠️ Stack Tecnológico Unificado
El proyecto utiliza herramientas de última generación para asegurar escalabilidad y mantenibilidad:

*   **Lenguaje:** Java 21
*   **Framework Principal:** Spring Boot 3.5.13
*   **Gestión de Dependencias:** Maven
*   **Microservicios:** Spring Cloud 2025 (Eureka, OpenFeign)
*   **Seguridad:** Spring Security + JWT (JSON Web Tokens)
*   **Base de Datos:** PostgreSQL (Database-per-service)
*   **Mapeo de Datos:** MapStruct 1.5.5
*   **Utilidades:** Lombok 1.18.44
*   **Documentación:** Markdown Modular

## 📁 Estructura del Ecosistema de Documentación
Para facilitar la navegación, la documentación se ha dividido en los siguientes módulos:

1.  **[Arquitectura y Diseño](01-architecture.md):** Principios, topología y estándares de código.
2.  **[Seguridad y Accesos](02-security.md):** Roles del sistema y flujo de autenticación.
3.  **[Guía de Operaciones](03-operations.md):** Cómo compilar, ejecutar y mapa de puertos.
4.  **[Referencia de Microservicios](services/):** Detalles técnicos específicos de cada uno de los 12 servicios.
5.  **[Flujos y Reglas de Negocio](04-business-flows.md):** Procesos transversales (Pedidos, Pagos, Inventario).
6.  **[Diccionario de Datos](05-data-dictionary.md):** Entidades y esquemas de base de datos.
7.  **[Backlog y Seguimiento](06-backlog.md):** Estado del proyecto, prioridades y estimaciones.

---
> **Nota Académica:** Este proyecto cumple con los requisitos de desacoplamiento total, donde cada servicio posee su propio ciclo de vida y almacenamiento.
