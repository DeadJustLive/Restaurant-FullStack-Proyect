# AGENTS.md — Contexto para IA

## Stack
- Java 21, Spring Boot 3.5.13, Spring Cloud 2025.0.0
- PostgreSQL (puerto 5433), H2 para testing
- Spring Data JPA, Spring Kafka, Spring Security (ms-auth)
- Eureka Server, OpenFeign, MapStruct 1.5.5, Lombok 1.18.44
- Maven (multi-module), Docker Compose
- Frontend: React

## Convenciones
- Anotaciones PromptLang con @kind, @contract, @limit
- Framework: openPrompt-Lang
- Arquitectura: microservicios con patrón CSR (Controller → Service → Repository)
- DTOs separados de entidades (MapStruct para mapeo)
- Excepciones centralizadas con @RestControllerAdvice
- Comunicación asíncrona vía Kafka (patrón CQRS con proyecciones)
- Comunicación síncrona vía Feign (service discovery con Eureka)

## Perfil del desarrollador
senior

## Reglas críticas
- NO usar any
- NO superar límites de líneas sin refactorizar
- Las anotaciones PromptLang deben declarar @use() al inicio del archivo
- FKs lógicos (Long) entre microservicios, nunca relaciones JPA cross-service
- Soft delete con flags (eliminado, activa) en vez de borrado físico
- Logs con @Slf4j en Service y Controller
- Pool de Conexiones (HikariCP): Límite estricto de máximo 3 conexiones por microservicio en desarrollo local (maximum-pool-size: 3) para prevenir la saturación de conexiones físicas en PostgreSQL. En producción, usar PgBouncer o proxies equivalentes para multiplexación.

## Referencias
- Framework: openPrompt-Lang
- Prompt library: docs/PROMPTS/INDEX.md (si aplica)
- Guion defensa técnica: Documentacion/Guion_Defensa_Tecnica_Microservicios.md
