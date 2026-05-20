#!/bin/bash
# ============================================================
# start.sh — Arranque completo del ecosistema Restaurant
#
# Orden:
#   1. Docker (PostgreSQL + Kafka)
#   2. Eureka Server
#   3. Microservicios (paralelo, con espera entre grupos)
#   4. Front-end
# ============================================================

set -e

RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
CYAN='\033[0;36m'
NC='\033[0m' # No Color

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$SCRIPT_DIR"

log() { echo -e "${CYAN}[$(date '+%H:%M:%S')]${NC} $1"; }

# ─── 1. Docker ──────────────────────────────────────────────────
log "${YELLOW}[1/4]${NC} Levantando Docker (PostgreSQL + Kafka)..."
docker compose up -d
log "${GREEN}✅ Docker listo${NC}"
echo "   PostgreSQL → localhost:5433"
echo "   Kafka      → localhost:9092"

# Esperar a que PostgreSQL esté listo
log "   Esperando PostgreSQL..."
for i in $(seq 1 30); do
  if docker exec restaurant-postgres pg_isready -U postgres > /dev/null 2>&1; then
    log "${GREEN}   PostgreSQL acepta conexiones${NC}"
    break
  fi
  if [ "$i" -eq 30 ]; then
    log "${RED}❌ PostgreSQL no respondió después de 30s${NC}"
    exit 1
  fi
  sleep 1
done

# ─── 2. Compilar (si no existe el build) ──────────────────────────
if ! ls eureka/target/*.jar >/dev/null 2>&1; then
  log "${YELLOW}   Compilando proyecto...${NC}"
  mvn clean install -DskipTests -q
  log "${GREEN}✅ Compilación completa${NC}"
fi

# ─── 3. Eureka Server ────────────────────────────────────────────
log "${YELLOW}[2/4]${NC} Arrancando Eureka Server..."
mvn spring-boot:run -pl eureka -q > /tmp/eureka.log 2>&1 &
echo $! > /tmp/eureka.pid
log "   PID: $(cat /tmp/eureka.pid) — Log: /tmp/eureka.log"

# Esperar a que Eureka esté listo
for i in $(seq 1 30); do
  if curl -s http://localhost:8761/actuator/health > /dev/null 2>&1; then
    log "${GREEN}✅ Eureka listo en :8761${NC}"
    break
  fi
  if [ "$i" -eq 30 ]; then
    log "${RED}❌ Eureka no respondió después de 30s${NC}"
    log "   Últimas líneas del log:"
    tail -5 /tmp/eureka.log
    exit 1
  fi
  sleep 2
done

# ─── 4. Microservicios (en grupos para no saturar) ──────────────
log "${YELLOW}[3/4]${NC} Arrancando microservicios..."

# Grupo 1: Servicios base (auth, sucursales, menu)
BASE_MS="ms-auth ms-sucursales ms-menu"
for ms in $BASE_MS; do
  log "   Arrancando $ms..."
  mvn spring-boot:run -pl "$ms" -q > "/tmp/$ms.log" 2>&1 &
  echo $! > "/tmp/$ms.pid"
  sleep 3
done

log "   Esperando servicios base..."
sleep 15

# Grupo 2: Servicios de negocio (pedidos, pagos, delivery, carrito)
BUSINESS_MS="ms-pedidos ms-pagos ms-delivery ms-carrito"
for ms in $BUSINESS_MS; do
  log "   Arrancando $ms..."
  mvn spring-boot:run -pl "$ms" -q > "/tmp/$ms.log" 2>&1 &
  echo $! > "/tmp/$ms.pid"
  sleep 2
done

log "   Esperando servicios de negocio..."
sleep 10

# Grupo 3: Servicios de soporte (inventario, notificaciones, reportes)
SUPPORT_MS="ms-inventario ms-notificaciones ms-reportes"
for ms in $SUPPORT_MS; do
  log "   Arrancando $ms..."
  mvn spring-boot:run -pl "$ms" -q > "/tmp/$ms.log" 2>&1 &
  echo $! > "/tmp/$ms.pid"
  sleep 2
done

log "${GREEN}✅ Microservicios arrancados${NC}"
echo ""
echo "   ┌──────────────┬──────────┐"
echo "   │ Servicio      │ Puerto   │"
echo "   ├──────────────┼──────────┤"
echo "   │ Eureka       │ :8761    │"
echo "   │ ms-auth      │ :9001    │"
echo "   │ ms-sucursales│ :9003    │"
echo "   │ ms-menu      │ :9004    │"
echo "   │ ms-carrito   │ :9006    │"
echo "   │ ms-pedidos   │ :9007    │"
echo "   │ ms-pagos     │ :9008    │"
echo "   │ ms-delivery  │ :9009    │"
echo "   │ ms-inventario│ :9010    │"
echo "   │ ms-notifs    │ :9011    │"
echo "   │ ms-reportes  │ :9012    │"
echo "   └──────────────┴──────────┘"

# ─── 5. Front-end ────────────────────────────────────────────────
log "${YELLOW}[4/4]${NC} Arrancando Front-end..."
if [ -d "../Front-end" ]; then
  cd ../Front-end
  npm run dev > /tmp/frontend.log 2>&1 &
  echo $! > /tmp/frontend.pid
  log "${GREEN}✅ Front-end en http://localhost:3000${NC}"
  cd "$SCRIPT_DIR"
else
  log "${RED}❌ Directorio Front-end no encontrado${NC}"
fi

echo ""
echo "═══════════════════════════════════════════════"
log "${GREEN}✅ Ecosistema completo arrancado${NC}"
echo ""
echo "   Front-end : http://localhost:3000"
echo "   Eureka    : http://localhost:8761"
echo ""
echo "   Para ver logs de un servicio:"
echo "     tail -f /tmp/ms-auth.log"
echo ""
echo "   Para detener todo:"
echo "     ./stop.sh"
echo "═══════════════════════════════════════════════"
