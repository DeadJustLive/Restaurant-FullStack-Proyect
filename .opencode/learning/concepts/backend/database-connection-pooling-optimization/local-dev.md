# Variante: local-dev (Configuración de Pool HikariCP para Desarrollo Local)

En una arquitectura de microservicios con patrón **Database per Service**, cada proceso de Spring Boot corre en su propia JVM y mantiene su propio pool de conexiones física a la base de datos (HikariCP).

## 📋 Justificación Técnica
*   **Valor por defecto:** HikariCP por defecto asigna un `maximum-pool-size` de **10 conexiones**.
*   **Problema de Escala:** Con 10 microservicios independientes, el ecosistema intenta abrir `10 * 10 = 100` conexiones simultáneas. Al llegar al límite máximo predeterminado de PostgreSQL (`max_connections = 100`), uno o más microservicios fallan al iniciar con el error `sorry, too many clients already`.
*   **Solución en Desarrollo:** Dado que en desarrollo local la carga es de un único usuario concurrente (el desarrollador), cada microservicio requiere máximo 1 o 2 conexiones activas reales para funcionar de forma óptima. Un pool máximo de 3 proporciona redundancia suficiente para transacciones concurrentes sin agotar la base de datos.

## 🛠️ Configuración en Spring Boot (`application.yml` / `application-dev.yml`)

Para implementar este límite en tus servicios, la configuración de la base de datos debe estructurarse de la siguiente manera:

```yaml
spring:
  datasource:
    hikari:
      maximum-pool-size: 3
      minimum-idle: 1
      idle-timeout: 30000
      max-lifetime: 1800000
      connection-timeout: 20000
```

### 🔍 Parámetros Explicados:
1.  **`maximum-pool-size: 3`:** Restringe de forma estricta a máximo 3 sockets físicos concurrentes activos hacia PostgreSQL por cada proceso JVM.
2.  **`minimum-idle: 1`:** Mantiene un mínimo de 1 conexión abierta y "caliente" para evitar latencia de establecimiento en la primera consulta, liberando las otras 2 si no se utilizan.
3.  **`idle-timeout: 30000`:** Tiempo máximo (30 segundos) que una conexión inactiva puede permanecer en el pool antes de ser liberada.
4.  **`connection-timeout: 20000`:** Si las 3 conexiones están ocupadas, el hilo esperará hasta 20 segundos antes de lanzar una excepción de timeout (evita cuellos de botella infinitos).
