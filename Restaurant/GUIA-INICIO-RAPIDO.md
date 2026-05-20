# 🚀 Guía de Inicio Rápido — Restaurant Microservices

> **Comandos listos para copiar y pegar**  
> **Plataformas:** Linux (bash) · Windows (PowerShell / cmd)

---

## 📋 Prerrequisitos

| Herramienta     | Mínimo   | Verificar con               |
|-----------------|----------|-----------------------------|
| Java JDK        | 21       | `java -version`             |
| Maven           | 3.9+     | `mvn -version`              |
| Docker Desktop  | 24+      | `docker --version`          |
| Docker Compose  | v2+      | `docker compose version`    |
| curl            | —        | `curl --version`            |
| Git             | —        | `git --version`             |

---

## 🚦 Scripts Automáticos (Recomendado)

### Linux

```bash
# 1. Ir al directorio del backend
cd Restaurant/

# 2. Dar permisos de ejecución (solo la primera vez)
chmod +x start.sh stop.sh launch.sh pruebas-microservicios/test_endpoints.sh

# 3. INICIAR TODO (Docker + Compilar + Eureka + 10 MS + Frontend)
./start.sh

# 4. Para más control (ver opciones):
./launch.sh --help

# Ejemplos:
./launch.sh                         # Inicia todo
./launch.sh --no-docker             # Si ya tienes Docker corriendo
./launch.sh --only eureka,ms-auth   # Solo Eureka + Auth
./launch.sh --no-frontend           # Sin frontend

# 5. Detener todo
./stop.sh
```

### Windows (cmd)

```cmd
:: 1. Ir al directorio del backend
cd Restaurant\

:: 2. INICIAR TODO (Docker + Compilar + Eureka + 10 MS + Frontend)
launch.bat

:: 3. Para más control:
launch.bat --help

:: Ejemplos:
launch.bat
launch.bat --no-docker
launch.bat --only eureka,ms-auth
launch.bat --no-frontend

:: 4. Detener todo
stop.bat
```

---

## 👣 Paso a Paso Manual

Si prefieres iniciar los servicios uno por uno en terminales separadas:

### 1. Docker — PostgreSQL + Kafka

```bash
cd Restaurant/
docker compose up -d
```

**Verificar:**
```bash
docker ps
# Deberías ver:
#   restaurant-postgres  (puerto 5433)
#   restaurant-kafka     (puerto 9092)

# Esperar a que PostgreSQL esté listo:
docker exec restaurant-postgres pg_isready -U postgres
# → /var/run/postgresql:5432 - aceptando conexiones
```

---

### 2. Compilar (solo la primera vez o tras cambios)

```bash
cd Restaurant/
mvn clean install -DskipTests
```

**Verificar JARs generados:**
```bash
# Deberías ver 11 archivos .jar:
ls -la */target/*.jar | grep -v sources | grep -v javadoc
```

---

### 3. Eureka Server

```bash
# Terminal 1 — Eureka (puerto 8761)
cd Restaurant/
mvn spring-boot:run -pl eureka
```

**Verificar:** Abre http://localhost:8761 — deberías ver el dashboard de Eureka.

---

### 4. Microservicios (cada uno en su terminal)

| Terminal | Servicio       | Puerto | Comando                                      |
|----------|----------------|--------|----------------------------------------------|
| 2        | ms-auth        | 9001   | `mvn spring-boot:run -pl ms-auth`            |
| 3        | ms-sucursales  | 9003   | `mvn spring-boot:run -pl ms-sucursales`      |
| 4        | ms-menu        | 9004   | `mvn spring-boot:run -pl ms-menu`            |
| 5        | ms-carrito     | 9006   | `mvn spring-boot:run -pl ms-carrito`         |
| 6        | ms-pedidos     | 9007   | `mvn spring-boot:run -pl ms-pedidos`         |
| 7        | ms-pagos       | 9008   | `mvn spring-boot:run -pl ms-pagos`           |
| 8        | ms-delivery    | 9009   | `mvn spring-boot:run -pl ms-delivery`        |
| 9        | ms-inventario  | 9010   | `mvn spring-boot:run -pl ms-inventario`      |
| 10       | ms-notificaciones| 9011 | `mvn spring-boot:run -pl ms-notificaciones`  |
| 11       | ms-reportes    | 9012   | `mvn spring-boot:run -pl ms-reportes`        |

**Verificar que cada uno responde:**
```bash
curl http://localhost:9001/api/v1/auth/health     # → {"status":"UP"}
curl http://localhost:9004/api/v1/menu            # → 200 OK
curl http://localhost:9007/api/v1/pedidos         # → 200 OK
```

**En Eureka Dashboard** (http://localhost:8761), verás los servicios registrados bajo "Instances currently registered with Eureka".

> **Nota:** Cada microservicio tarda ~15-30s en iniciar completamente (Hibernate crea tablas, se registra en Eureka, arrancan los listeners de Kafka). Sé paciente.

---

### 5. Frontend

```bash
cd Front-end/
npm install      # Solo la primera vez
npm run dev      # → http://localhost:3000
```

---

## ✅ Verificación de Todos los Endpoints

Una vez que todos los servicios estén arriba, ejecuta la suite de pruebas automáticas:

### Linux
```bash
cd Restaurant/
./pruebas-microservicios/test_endpoints.sh

# Para desplegar + testear automáticamente:
./pruebas-microservicios/test_endpoints.sh --deploy

# Para detener:
./pruebas-microservicios/test_endpoints.sh --stop
```

### Windows
```cmd
cd Restaurant\
pruebas-microservicios\test_endpoints.bat

:: Para desplegar + testear:
pruebas-microservicios\test_endpoints.bat --deploy

:: Para detener:
pruebas-microservicios\test_endpoints.bat --stop
```

### Lo que prueba el script:

| # | Prueba | Endpoint esperado | Código esperado |
|---|--------|-------------------|-----------------|
| 1 | Health Check Eureka | `GET :8761/actuator/health` | 200 |
| 2 | Health Check Auth | `GET :9001/api/v1/auth/health` | 200 |
| 3 | Listar Sucursales | `GET :9003/api/v1/sucursales` | 200 |
| 4 | Listar Menú | `GET :9004/api/v1/menu` | 200 |
| 5 | Obtener Carrito | `GET :9006/api/v1/carrito/usuario/1` | 200 |
| 6 | Listar Pedidos | `GET :9007/api/v1/pedidos` | 200 |
| 7 | Historial Pagos | `GET :9008/api/v1/pagos` | 200 |
| 8 | Delivery Activos | `GET :9009/api/v1/delivery` | 200 |
| 9 | Stock Inventario | `GET :9010/api/v1/inventario/insumos` | 200 |
| 10 | Notificaciones | `GET :9011/api/v1/notificaciones` | 200 |
| 11 | Reportes | `GET :9012/api/v1/reportes` | 200 |
| 12 | Registrar usuario | `POST :9001/api/v1/auth/register` | 200/201 |
| 13 | Login + JWT | `POST :9001/api/v1/auth/login` | 200 + token |
| 14 | Crear sucursal | `POST :9003/api/v1/sucursales` (con JWT) | 200/201 |

---

## 🧪 Postman Tests

No existe un archivo Postman JSON incluido en el repositorio, pero puedes usar la **colección Postman interactiva** de Flow:

1. Ve a https://www.flow.com/postman-collection-generator
2. Copia y pega la siguiente OpenAPI spec generada desde los controladores, o bien
3. Usa directamente los scripts `test_endpoints.sh` / `test_endpoints.bat` que cubren todos los endpoints.

Para testing manual con curl (Linux):

```bash
# 1. Obtener JWT
JWT=$(curl -s -X POST http://localhost:9001/api/v1/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin@restaurant.com","password":"Admin123!"}' \
  | grep -oP '"token":"\K[^"]+')

# 2. Usar el JWT para llamar cualquier endpoint
curl -H "Authorization: Bearer $JWT" http://localhost:9003/api/v1/sucursales
curl -H "Authorization: Bearer $JWT" http://localhost:9004/api/v1/menu
curl -H "Authorization: Bearer $JWT" http://localhost:9007/api/v1/pedidos
```

---

## 🛑 Detener Todo

### Linux
```bash
cd Restaurant/
./stop.sh

# Alternativa manual:
pkill -f "spring-boot:run"     # Mata todos los MS
docker compose down            # Detiene PostgreSQL + Kafka

# Liberar puertos específicos:
lsof -ti :9001 | xargs kill -9   # Reemplaza :9001 por el puerto
```

### Windows
```cmd
cd Restaurant\
stop.bat

:: Alternativa manual — Cerrar ventanas de terminal una por una
:: Forzar cierre de procesos Java:
taskkill /F /IM java.exe

:: Detener Docker:
docker compose down
```

---

## 🐛 Troubleshooting

### ❌ "Port already in use"

Algún servicio no se detuvo correctamente. Libera el puerto:

```bash
# Linux
lsof -ti :9004 | xargs kill -9

# Windows (cmd como administrador)
netstat -aon | findstr :9004
taskkill /PID <PID> /F
```

### ❌ "Connection refused" al iniciar un MS

```bash
# 1. Verificar que Docker y PostgreSQL estén corriendo
docker ps | grep restaurant-postgres

# 2. Verificar que el puerto 5433 esté accesible
curl telnet://localhost:5433

# 3. Revisar logs del MS
tail -f /tmp/ms-auth.log   # Linux (start.sh)
tail -f logs/ms-auth.log   # Linux (launch.sh)
type logs\ms-auth.log      # Windows
```

### ❌ Eureka no muestra microservicios registrados

```bash
# Esperar ~30s después de iniciar los MS (el registro tiene delay)
# Refrescar http://localhost:8761
# Verificar que cada MS esté vivo:
curl http://localhost:9001/actuator/health
```

### ❌ Error de base de datos "database does not exist"

```bash
# Recrear las bases de datos desde cero:
docker compose down -v      # Elimina los datos
docker compose up -d        # Vuelve a crear (init.sh se ejecuta automáticamente)
```

### ❌ Frontend no conecta con backend

```bash
# 1. Verificar que los MS estén corriendo
# 2. El frontend en desarrollo usa http://localhost:9001-9012
# 3. Busca @MOCK en el código — el frontend funciona con datos mock
#    cuando los MS no están disponibles
```

---

## 📊 Arquitectura — Puertos y Servicios

```
┌──────────────┬──────────┬──────────────────────────────┐
│ Servicio     │ Puerto   │ Dependencias                 │
├──────────────┼──────────┼──────────────────────────────┤
│ Eureka       │ 8761     │ — (Service Registry)         │
│ ms-auth      │ 9001     │ DB: auth · Kafka prod       │
│ ms-sucursales│ 9003     │ DB: sucursales · Kafka prod  │
│ ms-menu      │ 9004     │ DB: menu · Kafka cons+prod   │
│ ms-carrito   │ 9006     │ DB: carrito · Kafka cons     │
│ ms-pedidos   │ 9007     │ DB: pedidos · Kafka cons+prod│
│ ms-pagos     │ 9008     │ DB: pagos · Kafka cons+prod  │
│ ms-delivery  │ 9009     │ DB: delivery · Kafka cons+prod│
│ ms-inventario│ 9010     │ DB: inventario · Kafka cons+prod│
│ ms-notif.    │ 9011     │ DB: notificaciones · Kafka  │
│ ms-reportes  │ 9012     │ DB: reportes · Kafka cons    │
│ PostgreSQL   │ 5433     │ 10 databases (1 por MS)      │
│ Kafka        │ 9092     │ Mensajería asíncrona          │
│ Frontend     │ 3000     │ React + Vite                 │
└──────────────┴──────────┴──────────────────────────────┘
```

---

## 📁 Archivos de este documento

| Archivo | Propósito |
|---------|-----------|
| `GUIA-INICIO-RAPIDO.md` | **Este archivo** — guía compacta con comandos copypaste |
| `docs/03-operations.md` | Guía detallada con antecedentes arquitectónicos |
| `start.sh` / `stop.sh` | Scripts automáticos Linux |
| `launch.sh` / `launch.bat` | Launcher avanzado con opciones (`--only`, `--no-docker`) |
| `compile.bat` | Compilar solo (Windows) |
| `pruebas-microservicios/test_endpoints.sh` | Suite de tests API (Linux) |
| `pruebas-microservicios/test_endpoints.bat` | Suite de tests API (Windows) |
| `docker-compose.yml` | Infraestructura PostgreSQL + Kafka |
| `init-db/init.sh` | Inicialización automática de 10 bases de datos |

---

> **Última actualización:** 20-05-2026  
> **Proyecto:** Restaurant-FullStack-Proyect  
> **Stack:** Java 21 · Spring Boot 3.5.14 · Spring Cloud 2025.0.0 · PostgreSQL · Kafka · Eureka · React
