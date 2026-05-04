# 🍽️ Guía Completa — Iniciar el Sistema Restaurant SaaS

> **Última actualización:** 03-05-2026  
> **Plataforma:** Linux (compatible con Windows adaptando los comandos)

---

## Requisitos Previos

Antes de iniciar, asegúrate de tener instalado:

| Herramienta    | Versión mínima | Verificar con         |
|----------------|---------------|-----------------------|
| Docker Desktop | 24+           | `docker --version`    |
| Docker Compose | v2+           | `docker compose version` |
| Java JDK       | 21            | `java -version`       |
| Maven          | 3.9+          | `mvn -version`        |
| Node.js        | 18+           | `node -v`             |
| npm            | 9+            | `npm -v`              |

---

## Arquitectura del Sistema

```
┌─────────────────────────────────────────────────────────────────┐
│                    Frontend (React + Vite)                      │
│                      http://localhost:3000                      │
└──────────────────────────┬──────────────────────────────────────┘
                           │ HTTP
┌──────────────────────────▼──────────────────────────────────────┐
│                   Eureka Server (Service Registry)              │
│                      http://localhost:8761                      │
└──────────────────────────┬──────────────────────────────────────┘
                           │ Registro
    ┌──────────┬───────────┼───────────┬──────────┬──────────┐
    ▼          ▼           ▼           ▼          ▼          ▼
 ms-auth   ms-menu   ms-pedidos   ms-pagos  ms-delivery  ...más
 :9001     :9004      :9007       :9008      :9009
    │          │           │           │          │
    └──────────┴───────────┼───────────┴──────────┘
                           ▼
              ┌────────────────────────┐
              │  PostgreSQL (Docker)   │
              │     puerto: 5433       │
              │  12 bases de datos     │
              └────────────────────────┘
```

---

## Paso 1 — Iniciar la Base de Datos (Docker)

### 1.1 Asegurar que Docker esté corriendo

```bash
# Verificar que Docker está activo
docker ps
```

Si no devuelve nada o da error, abre Docker Desktop primero.

### 1.2 Levantar PostgreSQL

```bash
# Desde la raíz del proyecto backend
cd Restaurant/

# Levantar el contenedor en segundo plano
docker-compose up -d
```

**¿Qué sucede?**
- Se descarga la imagen `postgres:15-alpine` (solo la primera vez)
- Se crea el contenedor `restaurant-postgres` en el puerto **5433**
- Se ejecuta automáticamente `init-db/init.sql` que crea **12 bases de datos**:

| Base de datos      | Microservicio       |
|--------------------|---------------------|
| `auth`             | ms-auth             |
| `usuarios`         | ms-usuarios         |
| `sucursales`       | ms-sucursales       |
| `categorias`       | ms-categorias       |
| `menu`             | ms-menu             |
| `carrito`          | ms-carrito          |
| `pedidos`          | ms-pedidos          |
| `pagos`            | ms-pagos            |
| `delivery`         | ms-delivery         |
| `inventario`       | ms-inventario       |
| `notificaciones`   | ms-notificaciones   |
| `reportes`         | ms-reportes         |

### 1.3 Verificar que PostgreSQL está corriendo

```bash
docker ps

# Deberías ver algo como:
# CONTAINER ID   IMAGE               PORTS                    NAMES
# abc123         postgres:15-alpine  0.0.0.0:5433->5432/tcp   restaurant-postgres
```

### 1.4 Verificar la creación de las bases de datos

Para conectarte al contenedor y listar todas las bases de datos creadas por el script de inicialización:

```bash
# 1. Obtener el ID o nombre del contenedor (usualmente 'restaurant-postgres')
docker ps

# 2. Conectarse a postgres dentro del contenedor
docker exec -it restaurant-postgres psql -U postgres

# 3. Dentro de psql, listar las bases de datos (con L minúscula)
\l

# 4. Para salir de psql
\q
```

### 1.5 Credenciales de conexión

| Parámetro | Valor          |
|-----------|----------------|
| Host      | `localhost`    |
| Puerto    | `5433`         |
| Usuario   | `postgres`     |
| Contraseña| `123`          |

---

## Paso 2 — Compilar los Microservicios

> ⚠️ **Solo necesario la primera vez** o después de cambios en el código Java.

```bash
# Desde la carpeta Restaurant/ (raíz del proyecto Maven)
cd Restaurant/

# Compilar todos los módulos
mvn clean compile
```

Si necesitas reconstruir todo desde cero:

```bash
mvn clean install -DskipTests
```

---

## Paso 3 — Iniciar Eureka Server

Eureka debe estar corriendo **antes** de iniciar cualquier microservicio.

```bash
# Desde Restaurant/
mvn -f eureka spring-boot:run
```

**Verificar:** Abrir http://localhost:8761 en el navegador. Deberías ver el dashboard de Eureka.

> 💡 Espera ~10 segundos a que Eureka esté completamente listo antes de continuar.

---

## Paso 4 — Iniciar los Microservicios

Cada microservicio se ejecuta en una terminal separada. Al arrancar:
1. Se conecta a su base de datos PostgreSQL individual
2. Hibernate (`ddl-auto: update`) **crea las tablas automáticamente**
3. Se registra en Eureka Server

### Tabla de microservicios y puertos

| Microservicio       | Puerto | Base de datos    | Comando                                    |
|---------------------|--------|------------------|--------------------------------------------|
| ms-auth             | 9001   | auth             | `mvn -f ms-auth spring-boot:run`           |
| ms-usuarios         | 9002   | usuarios         | `mvn -f ms-usuarios spring-boot:run`       |
| ms-sucursales       | 9003   | sucursales       | `mvn -f ms-sucursales spring-boot:run`     |
| ms-menu             | 9004   | menu             | `mvn -f ms-menu spring-boot:run`           |
| ms-categorias       | 9005   | categorias       | `mvn -f ms-categorias spring-boot:run`     |
| ms-carrito          | 9006   | carrito          | `mvn -f ms-carrito spring-boot:run`        |
| ms-pedidos          | 9007   | pedidos          | `mvn -f ms-pedidos spring-boot:run`        |
| ms-pagos            | 9008   | pagos            | `mvn -f ms-pagos spring-boot:run`          |
| ms-delivery         | 9009   | delivery         | `mvn -f ms-delivery spring-boot:run`       |
| ms-inventario       | 9010   | inventario       | `mvn -f ms-inventario spring-boot:run`     |
| ms-notificaciones   | 9011   | notificaciones   | `mvn -f ms-notificaciones spring-boot:run` |
| ms-reportes         | 9012   | reportes         | `mvn -f ms-reportes spring-boot:run`       |

### Iniciar todos de golpe (Linux)

```bash
# Desde Restaurant/
# Eureka primero
mvn -f eureka spring-boot:run &
sleep 10

# Luego todos los microservicios en background
mvn -f ms-auth spring-boot:run &
mvn -f ms-usuarios spring-boot:run &
mvn -f ms-sucursales spring-boot:run &
mvn -f ms-menu spring-boot:run &
mvn -f ms-categorias spring-boot:run &
mvn -f ms-carrito spring-boot:run &
mvn -f ms-pedidos spring-boot:run &
mvn -f ms-pagos spring-boot:run &
mvn -f ms-delivery spring-boot:run &
mvn -f ms-inventario spring-boot:run &
mvn -f ms-notificaciones spring-boot:run &
mvn -f ms-reportes spring-boot:run &
```

### Iniciar solo los esenciales (desarrollo rápido)

Si solo necesitas probar funcionalidades básicas:

```bash
mvn -f eureka spring-boot:run &
sleep 10
mvn -f ms-auth spring-boot:run &
mvn -f ms-menu spring-boot:run &
mvn -f ms-pedidos spring-boot:run &
mvn -f ms-pagos spring-boot:run &
mvn -f ms-inventario spring-boot:run &
```

---

## Paso 5 — Iniciar el Frontend

```bash
# Desde la carpeta Front-end/
cd Front-end/

# Instalar dependencias (solo la primera vez)
npm install

# Iniciar servidor de desarrollo
npm run dev
```

**Resultado:** Frontend disponible en http://localhost:3000

---

## Estado Actual de los Microservicios

> ⚠️ **Importante:** Los controllers de todos los microservicios están definidos (rutas HTTP existen),
> pero la lógica de negocio en los ServiceImpl aún contiene `throw UnsupportedOperationException` 
> en la mayoría de métodos. Esto significa que las **tablas se crean correctamente en la DB**, 
> pero los **endpoints devuelven error 500** al ser invocados.

| Microservicio     | Entities/DDL | Controllers | ServiceImpl        |
|-------------------|:------------:|:-----------:|:------------------:|
| ms-auth           | ✅           | ✅          | 🔶 Parcial         |
| ms-usuarios       | ✅           | ✅          | 🔶 Scaffolding     |
| ms-sucursales     | ✅           | ✅          | 🔶 Scaffolding     |
| ms-menu           | ✅           | ✅          | ✅ Implementado    |
| ms-categorias     | ✅           | ✅          | 🔶 Scaffolding     |
| ms-carrito        | ✅           | ✅          | 🔶 Scaffolding     |
| ms-pedidos        | ✅           | ✅          | ✅ Implementado    |
| ms-pagos          | ✅           | ✅          | 🔶 Scaffolding     |
| ms-delivery       | ✅           | ✅          | 🔶 Scaffolding     |
| ms-inventario     | ✅           | ✅          | ✅ Implementado    |
| ms-notificaciones | ✅           | ✅          | 🔶 Scaffolding     |
| ms-reportes       | ✅           | ✅          | 🔶 Scaffolding     |

> El **Frontend** funciona de forma independiente usando datos **mock** cuando los microservicios 
> no están disponibles. Busca `@MOCK` en el código para identificar todos los bloques simulados.

---

## Comandos Útiles

### Docker

```bash
# Ver contenedores corriendo
docker ps

# Detener PostgreSQL
docker-compose down

# Detener y eliminar datos (reset completo)
docker-compose down -v

# Ver logs de PostgreSQL
docker logs restaurant-postgres
```

### Conectarse a una DB específica

```bash
# Conectarse a la DB de pedidos, por ejemplo
docker exec -it restaurant-postgres psql -U postgres -d pedidos

# para listar las tablas de la db 
\l

# para seleccionar un schema, se usa este mismo para seleccionar otras db dentro de la terminal

\c database_name

#para mostrar todas las tablas de un schema 
\dt 
 
# para ver relaciones 
\d
 
# mostrar todos los schema 
\dn 
# para salir de psql 
\q
```



### Detener todos los microservicios (Linux)

```bash
# Matar todos los procesos Maven de spring-boot:run
pkill -f "spring-boot:run"
```

### Frontend

```bash
# Verificar errores TypeScript sin compilar
npx tsc --noEmit

# Build de producción
npm run build
```

---

## Orden de Apagado

Para apagar el sistema de forma limpia, sigue el orden inverso:

1. **Frontend:** `Ctrl+C` en la terminal de `npm run dev`
2. **Microservicios:** `Ctrl+C` en cada terminal (o `pkill -f "spring-boot:run"`)
3. **Eureka:** `Ctrl+C` en su terminal
4. **PostgreSQL:** `docker-compose down` (o dejar corriendo para la próxima sesión)

---

## Troubleshooting

### El microservicio no arranca — "Connection refused"
→ Verifica que Docker y PostgreSQL estén corriendo: `docker ps`

### Eureka no muestra los microservicios
→ Espera ~30 segundos. Los servicios se registran con delay. Refresca http://localhost:8761

### Error "Port already in use"
→ Otro proceso ocupa el puerto. Busca y mata:
```bash
lsof -i :9004   # Ejemplo para ms-menu
kill -9 <PID>
```

### Frontend muestra datos pero los botones dan error
→ Es normal si el backend no está corriendo. El frontend usa datos `@MOCK` y simula las operaciones con `console.warn`.
