# 🚀 Guía de Operaciones y Despliegue

## 1. Prerrequisitos
*   **Java 21 JDK**
*   **Maven 3.9+**
*   **PostgreSQL 15+** (corriendo en el puerto 5433 por defecto o según configuración)

## 2. Configuración de Base de Datos
Es necesario crear las siguientes bases de datos antes de iniciar los servicios:
`db_auth`, `db_usuarios`, `db_sucursales`, `db_categorias`, `db_menu`, `db_carrito`, `db_pedidos`, `db_pagos`, `db_delivery`, `db_inventario`, `db_notif`, `db_reportes`.

## 3. Automatización (Scripts)
El proyecto incluye scripts `.bat` para facilitar las tareas comunes:

| Script | Propósito |
| :--- | :--- |
| `install.bat` | Limpia la carpeta `.m2`, elimina `target` y reinstala todas las dependencias. |
| `compile.bat` | Ejecuta `mvn clean install` en todos los microservicios en el orden correcto. |
| `run-all.bat` | Inicia primero el servidor Eureka y luego el resto de microservicios en ventanas separadas. |
| `run-test.bat` | Inicia los servicios utilizando el perfil de `test` (configuración de BD H2/Memoria). |

## 4. Orden de Arranque Recomendado
1.  **Eureka Server** (Esperar 10-15 segundos).
2.  **Microservicios de soporte:** `ms-auth`, `ms-usuarios`.
3.  **Microservicios de negocio:** `ms-menu`, `ms-pedidos`, etc.

## 5. Verificación de Salud
Una vez iniciados, puedes verificar el estado de los servicios en el dashboard de Eureka:
👉 [http://localhost:8761](http://localhost:8761)
