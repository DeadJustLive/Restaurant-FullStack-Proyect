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

## Workflow MCP Obligatorio (Ahorra Tiempo)

El servidor MCP ahora incluye un sistema de **enforcement de workflow** con 3 niveles:
- **Guide** (default): Muestra sugerencias con tiempo ahorrado estimado, no bloquea
- **Gate** (`strictMode: true` en workflow): Bloquea herramientas si no se cumplen prerrequisitos
- **Learn**: Si la IA omite pasos y encuentra errores, crea auto-tickets de fricción

### Flujo recomendado (MCP tools)
1. `analyze_project` → Conoce el proyecto (30s, ahorra ~15min)
2. `context_unified` → Búsqueda cruzada en 7 fuentes (10s, ahorra ~20min)
3. `knowledge_search` o `recall` → Buscar antes de crear (10s, ahorra ~30min)
4. `work_context_plan` → Planificar antes de implementar (1min, ahorra ~1hr)
5. `work_context_start` → Iniciar sesión con tracking
6. `validate` o `lint_file` → Verificar antes de cerrar (5s, previene bugs)
7. `work_context_close` → Cerrar sesión y registrar métricas

### Tools nuevos de workflow
- `workflow_check` — Verifica qué pasos faltan del flujo
- `domain_status` — Muestra dominio activo y patrones disponibles
- `work_context_status` — Estado actual de la sesión
- `recall` — Búsqueda en memoria del proyecto
- `context_unified` — Búsqueda cruzada en 7 fuentes

### Hook pre-commit
Ejecuta `.husky/pre-commit` que corre `npx openPrompt-Lang validate` antes de cada commit.

## Referencias
- Framework: openPrompt-Lang
- Prompt library: docs/PROMPTS/INDEX.md (si aplica)
- Guion defensa técnica: Documentacion/Guion_Defensa_Tecnica_Microservicios.md


## 🧠 Base de Inteligencia Semántica (knowledge-repo)
La IA dispone de toda la base de conocimiento organizada por dominio en `knowledge-repo/`:
- [x] **2-3-2-guia-tecnica-accesibilidad-web-en-chile** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **2-3-5-gu-a-para-el-desarrollo-de-sitios-web** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **2-3-6-guia-desarrollo-software-v2-0** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **2-3-7-tips-on-designing-for-web-accessibility** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **2-4-2-guia-de-desarrollo-software-servicios-publicos** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **algoritmos-pseudocodigo-ordinogramas** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **apuntes-estructuras-datos-algoritmos** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **bases-conceptuales-programacion** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **bases-datos-diseno-introduccion** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **capacitorjs-docs** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **css3-javascript-avanzado** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **estructuras-de-datos** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **flowbite-react** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **fundamentos-programacion** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **guia-scrum-european** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **introduccion-poo** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **javascript-asincronismo** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **javascript-elocuente-cuarta-edicion** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **javascript-uoc** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **jquery-fundamentos** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **logica-de-programacion** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **node-js-es** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **problemas-y-algoritmos** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **python-aprende-sergio-delgado-quintero** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **qwik-libro-espanol** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **react-aprendiz-maestro** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **react-redux-libro-espanol** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **react-stackoverflow-docs** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **rust-aprendizaje** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **rust-libro-espanol** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **scrum-y-xp-desde-las-trincheras** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **typescript-introduccion-adictos-trabajo** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)
- [x] **flow-api-docs** (Dominio: clasificado en taxonomy/domains.json | Accesible vía MCP tools)

> [!IMPORTANT]
> Herramientas MCP: `knowledge_search`, `knowledge_list`, `knowledge_read`, `knowledge_concept`, `knowledge_domain`, `knowledge_playbook`
> Dominios: payments, mobile-pwa, systems, qa, frontend, backend, accessibility, algorithms, fundamentals
> Consulta `.openprompt/FRAMEWORK.md` para el manual operativo completo.
