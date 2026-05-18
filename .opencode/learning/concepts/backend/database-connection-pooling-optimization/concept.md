# database-connection-pooling-optimization

## Resumen
Optimización crítica del pool de conexiones de base de datos (HikariCP) en arquitecturas de microservicios locales para evitar el agotamiento de sockets físicos en el motor (PostgreSQL). Limita de manera estricta las conexiones simultáneas por proceso JVM a un máximo de 3 durante la etapa de desarrollo local.

## Tipo
backend

## Estado
aprobado

## Variantes disponibles
| Variante | Archivo | Descripción breve |
|----------|---------|-------------------|
| local-dev | `local-dev.md` | Configuración óptima del pool HikariCP para desarrollo con múltiples servicios. |

## Relaciones
- Similar a: `singleton` (en el sentido de restringir y centralizar la asignación y reúso de sockets en memoria).
- Contraste con: `monolithic-unbounded-pooling` (pools ilimitados o por defecto de gran tamaño aptos únicamente para monolitos solitarios).
- Compatible con: `database-per-service` (patrón de aislamiento de datos).

## Reglas generales
- **Límite de Pool en Dev:** El pool de conexiones físico de HikariCP en cada microservicio no debe superar un tamaño máximo de 3 (`maximum-pool-size: 3`) y un mínimo inactivo de 1 (`minimum-idle: 1`).
- **Prevención de Exceso:** El número de microservicios activos multiplicado por el tamaño del pool de cada uno nunca debe exceder la capacidad máxima de conexiones físicas del motor local (`max_connections` en PostgreSQL, típicamente 100 por defecto).
- **Desacoplamiento de Entornos:** Las configuraciones de pool deben separarse usando perfiles de Spring Boot (`application-dev.yml` vs `application-prod.yml`).
