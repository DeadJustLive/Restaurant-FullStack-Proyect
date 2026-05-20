# PROJECT_CONTEXT.md — Estado del Proyecto
> Generado: 2026-05-19T22:13:25.768Z | Framework: openPrompt-Lang

## 1. Identidad

- **Nombre:** restaurant-fullstack-proyect
- **Versión:** 0.1.0

## 2. Stack Tecnológico

- **Lenguaje:** react
- **Stack base:** react, typescript
- **Perfil:** senior

## 3. Plan Paso a Paso (Contexto de Desarrollo)

### Cómo la IA debe obtener contexto rápidamente:

1. **Leer este archivo** (PROJECT_CONTEXT.md) — estado actual del proyecto
2. **Leer AGENTS.md** — reglas, convenciones y stack
3. **Consultar .openprompt/FRAMEWORK.md** — referencia de anotaciones
4. **Usar `learning search`** — conceptos específicos en memoria semántica
5. **Usar `knowledge search`** — consultar libros/playbooks activos
6. **Usar `context`** — regenerar contexto completo si es necesario

### Progreso actual:

- [x] Fase 1: Setup inicial
- [ ] Fase 2: _definir según necesidades_

## 4. Estructura del Proyecto

```text
Restaurant-FullStack-Proyect/
├── 25 plantilla-creador-micro-servicios-v05
│   ├── CGV-TOOLS.md
│   ├── README.md
│   ├── _bak
│   │   ├── compile.bat
│   │   ├── install.bat
│   │   ├── run-all.bat
│   │   ├── run-catalogo.bat
│   │   ├── run-eureka.bat
│   │   ├── run-recursos.bat
│   │   ├── run-test.bat
│   │   └── run-usuarios.bat
│   ├── cgv-tools.py
│   ├── estructura-ms
│   │   ├── controller
│   │   │   └── LibroController.java
│   │   ├── dto
│   │   │   └── LibroRequest.java
│   │   ├── exception
│   │   │   ├── ApiError.java
│   │   │   ├── GlobalExceptionHandler.java
│   │   │   ├── IsbnDuplicadoException.java
│   │   │   └── LibroNotFoundException.java
│   │   ├── mapper
│   │   │   └── LibroMapper.java
│   │   ├── model
│   │   │   └── Libro.java
│   │   ├── repository
│   │   │   └── LibroRepository.java
│   │   ├── service
│   │   │   └── LibroService.java
│   │   └── util
│   │       └── LibroSeeder.java
│   ├── init-multi-db
│   │   ├── 01-init.sql
│   │   ├── 02-create_usuarios.sql
│   │   ├── 03-create_catalogo.sql
│   │   ├── 04-create_recursos.sql
│   │   ├── docker_compile_dbs.bat
│   │   ├── docker_install_biblio.bat
│   │   ├── docker_remove_biblio.bat
│   │   ├── docker_show_info.bat
│   │   ├── docker_start_biblio.bat
│   │   └── docker_stop_biblio.bat
│   ├── join-files.py
│   ├── launch.bat
│   └── lombok.jar
├── AGENTS.md
├── Documentacion
│   ├── Guion_Defensa_Personal.md
│   ├── Guion_Defensa_Tecnica_Microservicios.md
│   ├── Postman-Testing-Plan.md
│   ├── Restaurant-API.postman_collection.json
│   ├── changelog_migracion_v12_a_v10.md
│   ├── guia_arquitectura_academica.md
│   ├── justificacion_arquitectura_feign.md
│   ├── plan_fase4_logica_negocio.md
│   ├── plan_fase5_kafka.md
│   ├── plan_feign_seguridad.md
│   ├── plan_integracion_microservicios.md
│   └── tareas_pendientes_frontend.md
├── EstructuraDesgloceParaVideo.md
├── Front-end
│   ├── README.md
│   ├── docs
│   │   └── architecture.md
│   ├── index.html
│   ├── package-lock.json
│   ├── package.json
│   ├── postcss.config.js
│   ├── src
│   │   ├── App.tsx
│   │   ├── api
│   │   │   ├── axios.ts
│   │   │   └── mockRouter.ts
│   │   ├── components
│   │   │   ├── Modal.tsx
│   │   │   ├── features
│   │   │   ├── navigation
│   │   │   └── ui
│   │   ├── config
│   │   │   └── navigation.ts
│   │   ├── contexts
│   │   │   ├── AuthContext.tsx
│   │   │   └── DevToolsContext.tsx
│   │   ├── docs
│   │   │   └── frontend_architecture.md
│   │   ├── hooks
│   │   │   └── useFetch.ts
│   │   ├── layouts
│   │   │   ├── AppShell.tsx
│   │   │   ├── AuthLayout.tsx
│   │   │   └── PageContainer.tsx
│   │   ├── main.tsx
│   │   ├── mocks
│   │   │   └── data.ts
│   │   ├── pages
│   │   │   ├── CocinaPage.tsx
│   │   │   ├── DashboardPage.tsx
│   │   │   ├── EntregasPage.tsx
│   │   │   ├── LoginPage.tsx
│   │   │   ├── NotificacionesPage.tsx
│   │   │   ├── ProfilePage.tsx
│   │   │   ├── SettingsPage.tsx
│   │   │   ├── WaiterDashboard.tsx
│   │   │   └── admin
│   │   ├── routes
│   │   │   └── AppRouter.tsx
│   │   ├── styles
│   │   │   └── global.css
│   │   ├── utils
│   │   │   └── utils.ts
│   │   └── vite-env.d.ts
│   ├── tailwind.config.js
│   ├── tsconfig.json
│   ├── tsconfig.node.json
│   └── vite.config.ts
├── README.md
├── Restaurant
│   ├── Documentacion
│   │   ├── Presentacion_Arquitectura_Microservicios.md
│   │   ├── diagramas.md
│   │   ├── diccionarios.md
│   │   └── estructuras_carpetas.md
│   ├── ExtractorInformacion.py
│   ├── GUIA-INICIO-SISTEMA.md
│   ├── Pasos-Iniciar-DB-Docker.md
│   ├── README.md
│   ├── compile.bat
│   ├── docker-compose.yml
│   ├── eureka
│   │   ├── application-eureka.yml
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   ├── main
│   │   │   └── test
│   │   ├── target
│   │   │   ├── classes
│   │   │   ├── generated-sources
│   │   │   ├── generated-test-sources
│   │   │   ├── maven-status
│   │   │   └── test-classes
│   │   └── target-local
│   │       ├── cl-triskeledu-eureka-1.0-SNAPSHOT.jar
│   │       ├── cl-triskeledu-eureka-1.0-SNAPSHOT.jar.original
│   │       ├── classes
│   │       ├── generated-sources
│   │       ├── generated-test-sources
│   │       ├── maven-archiver
│   │       ├── maven-status
│   │       └── test-classes
│   ├── init-db
│   │   ├── 00-init.sql
│   │   ├── 01-auth.sql
│   │   ├── 02-sucursales.sql
│   │   ├── 03-inventario.sql
│   │   ├── 04-menu.sql
│   │   ├── 05-carrito.sql
│   │   ├── 06-pagos.sql
│   │   ├── 07-pedidos.sql
│   │   ├── 08-delivery.sql
│   │   ├── 09-notificaciones.sql
│   │   ├── 10-reportes.sql
│   │   ├── README.md
│   │   └── fix-passwords.sql
│   ├── install.bat
│   ├── join-files.py
│   ├── launch.bat
│   ├── launch.sh
│   ├── ms-auth
│   │   ├── README.md
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   ├── main
│   │   │   └── test
│   │   ├── target
│   │   │   ├── classes
│   │   │   ├── generated-sources
│   │   │   ├── generated-test-sources
│   │   │   ├── maven-status
│   │   │   └── test-classes
│   │   └── target-local
│   │       ├── cl-triskeledu-auth-0.0.1-SNAPSHOT.jar
│   │       ├── cl-triskeledu-auth-0.0.1-SNAPSHOT.jar.original
│   │       ├── classes
│   │       ├── generated-sources
│   │       ├── generated-test-sources
│   │       ├── maven-archiver
│   │       ├── maven-status
│   │       └── test-classes
│   ├── ms-carrito
│   │   ├── README.md
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   ├── main
│   │   │   └── test
│   │   ├── target
│   │   │   ├── classes
│   │   │   ├── generated-sources
│   │   │   └── maven-status
│   │   └── target-local
│   │       ├── cl-triskeledu-carrito-0.0.1-SNAPSHOT.jar
│   │       ├── cl-triskeledu-carrito-0.0.1-SNAPSHOT.jar.original
│   │       ├── classes
│   │       ├── generated-sources
│   │       ├── generated-test-sources
│   │       ├── maven-archiver
│   │       ├── maven-status
│   │       └── test-classes
│   ├── ms-categorias.backup
│   │   ├── README.md
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   ├── main
│   │   │   └── test
│   │   ├── target
│   │   │   ├── classes
│   │   │   ├── generated-sources
│   │   │   └── maven-status
│   │   └── target-temp
│   │       └── src
│   ├── ms-delivery
│   │   ├── README.md
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   ├── main
│   │   │   └── test
│   │   ├── target
│   │   │   ├── classes
│   │   │   ├── generated-sources
│   │   │   ├── generated-test-sources
│   │   │   ├── maven-status
│   │   │   └── test-classes
│   │   └── target-local
│   │       ├── cl-triskeledu-delivery-0.0.1-SNAPSHOT.jar
│   │       ├── cl-triskeledu-delivery-0.0.1-SNAPSHOT.jar.original
│   │       ├── classes
│   │       ├── generated-sources
│   │       ├── generated-test-sources
│   │       ├── maven-archiver
│   │       ├── maven-status
│   │       └── test-classes
│   ├── ms-inventario
│   │   ├── README.md
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   ├── main
│   │   │   └── test
│   │   ├── target
│   │   │   ├── classes
│   │   │   ├── generated-sources
│   │   │   ├── generated-test-sources
│   │   │   ├── maven-status
│   │   │   └── test-classes
│   │   └── target-local
│   │       ├── cl-triskeledu-inventario-0.0.1-SNAPSHOT.jar
│   │       ├── cl-triskeledu-inventario-0.0.1-SNAPSHOT.jar.original
│   │       ├── classes
│   │       ├── generated-sources
│   │       ├── generated-test-sources
│   │       ├── maven-archiver
│   │       ├── maven-status
│   │       └── test-classes
│   ├── ms-menu
│   │   ├── README.md
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   ├── main
│   │   │   └── test
│   │   ├── target
│   │   │   ├── classes
│   │   │   ├── generated-sources
│   │   │   ├── generated-test-sources
│   │   │   ├── maven-status
│   │   │   └── test-classes
│   │   └── target-local
│   │       ├── cl-triskeledu-menu-0.0.1-SNAPSHOT.jar
│   │       ├── cl-triskeledu-menu-0.0.1-SNAPSHOT.jar.original
│   │       ├── classes
│   │       ├── generated-sources
│   │       ├── generated-test-sources
│   │       ├── maven-archiver
│   │       ├── maven-status
│   │       └── test-classes
│   ├── ms-notificaciones
│   │   ├── README.md
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   ├── main
│   │   │   └── test
│   │   ├── target
│   │   │   ├── classes
│   │   │   ├── generated-sources
│   │   │   └── maven-status
│   │   └── target-local
│   │       ├── cl-triskeledu-notificaciones-0.0.1-SNAPSHOT.jar
│   │       ├── cl-triskeledu-notificaciones-0.0.1-SNAPSHOT.jar.original
│   │       ├── classes
│   │       ├── generated-sources
│   │       ├── generated-test-sources
│   │       ├── maven-archiver
│   │       ├── maven-status
│   │       └── test-classes
│   ├── ms-pagos
│   │   ├── README.md
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   ├── main
│   │   │   └── test
│   │   ├── target
│   │   │   ├── classes
│   │   │   ├── generated-sources
│   │   │   ├── generated-test-sources
│   │   │   ├── maven-status
│   │   │   └── test-classes
│   │   └── target-local
│   │       ├── cl-triskeledu-pagos-0.0.1-SNAPSHOT.jar
│   │       ├── cl-triskeledu-pagos-0.0.1-SNAPSHOT.jar.original
│   │       ├── classes
│   │       ├── generated-sources
│   │       ├── generated-test-sources
│   │       ├── maven-archiver
│   │       ├── maven-status
│   │       └── test-classes
│   ├── ms-pedidos
│   │   ├── README.md
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   ├── main
│   │   │   └── test
│   │   ├── target
│   │   │   ├── classes
│   │   │   ├── generated-sources
│   │   │   ├── generated-test-sources
│   │   │   ├── maven-status
│   │   │   └── test-classes
│   │   └── target-local
│   │       ├── cl-triskeledu-pedidos-0.0.1-SNAPSHOT.jar
│   │       ├── cl-triskeledu-pedidos-0.0.1-SNAPSHOT.jar.original
│   │       ├── classes
│   │       ├── generated-sources
│   │       ├── generated-test-sources
│   │       ├── maven-archiver
│   │       ├── maven-status
│   │       └── test-classes
│   ├── ms-reportes
│   │   ├── README.md
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   ├── main
│   │   │   └── test
│   │   ├── target
│   │   │   ├── classes
│   │   │   ├── generated-sources
│   │   │   └── maven-status
│   │   └── target-local
│   │       ├── cl-triskeledu-reportes-0.0.1-SNAPSHOT.jar
│   │       ├── cl-triskeledu-reportes-0.0.1-SNAPSHOT.jar.original
│   │       ├── classes
│   │       ├── generated-sources
│   │       ├── generated-test-sources
│   │       ├── maven-archiver
│   │       ├── maven-status
│   │       └── test-classes
│   ├── ms-sucursales
│   │   ├── README.md
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   ├── main
│   │   │   └── test
│   │   ├── target
│   │   │   ├── classes
│   │   │   ├── generated-sources
│   │   │   ├── generated-test-sources
│   │   │   ├── maven-status
│   │   │   └── test-classes
│   │   └── target-local
│   │       ├── cl-triskeledu-sucursales-0.0.1-SNAPSHOT.jar
│   │       ├── cl-triskeledu-sucursales-0.0.1-SNAPSHOT.jar.original
│   │       ├── classes
│   │       ├── generated-sources
│   │       ├── generated-test-sources
│   │       ├── maven-archiver
│   │       ├── maven-status
│   │       └── test-classes
│   ├── ms-usuarios.backup
│   │   ├── README.md
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   ├── src
│   │   │   ├── main
│   │   │   └── test
│   │   └── target
│   │       ├── classes
│   │       ├── generated-sources
│   │       └── maven-status
│   ├── pom.xml
│   ├── pruebas-microservicios
│   │   ├── logs
│   │   │   ├── eureka.log
│   │   │   ├── ms-auth.log
│   │   │   ├── ms-carrito.log
│   │   │   ├── ms-delivery.log
│   │   │   ├── ms-inventario.log
│   │   │   ├── ms-menu.log
│   │   │   ├── ms-notificaciones.log
│   │   │   ├── ms-pagos.log
│   │   │   ├── ms-pedidos.log
│   │   │   ├── ms-reportes.log
│   │   │   └── ms-sucursales.log
│   │   ├── test_endpoints.bat
│   │   └── test_endpoints.sh
│   ├── reemplazar.py
│   └── update-config.py
├── docs
│   ├── 00-intro.md
│   ├── 01-architecture.md
│   ├── 02-security.md
│   ├── 03-operations.md
│   ├── 04-business-flows.md
│   ├── 05-data-dictionary.md
│   ├── 06-backlog.md
│   ├── BACKLOG
│   │   └── tasks.md
│   ├── COMMITS
│   │   └── INDEX.md
│   ├── LOGS
│   │   ├── ACTIVIDAD
│   │   └── ERRORES
│   ├── PHASES
│   │   └── roadmap.md
│   └── services
│       ├── README.md
│       ├── ms-auth.md
│       ├── ms-carrito.md
│       ├── ms-categorias.md
│       ├── ms-delivery.md
│       ├── ms-inventario.md
│       ├── ms-menu.md
│       ├── ms-notificaciones.md
│       ├── ms-pagos.md
│       ├── ms-pedidos.md
│       ├── ms-reportes.md
│       ├── ms-sucursales.md
│       └── ms-usuarios.md
├── package-lock.json
├── package.json
└── prompt-lang.json
```

## 4b. Estadísticas de Anotaciones

- **Archivos totales:** 1469
- **Archivos anotados (@kind):** 3
- **Cobertura:** 0%
- **Archivos sin anotar:** 1466

## 5. Conocimiento Activo

- No hay libros activos. Usa `knowledge sync` para activar.

## 6. Historial de Sesiones

| Fecha | Sesión | Tarea | Resultado |
|-------|--------|-------|-----------|

## 7. Logs y Commits

### Últimos commits
| Fecha | Versión | Descripción |
|-------|---------|-------------|

### Últimos errores
| Fecha | Error | Solución | Lección |
|-------|-------|----------|---------|

### Última actividad
| Fecha | Actividad | Notas |
|-------|-----------|-------|

---
> Última actualización: 2026-05-19T22:13:25.771Z | Generado por openPrompt-Lang
